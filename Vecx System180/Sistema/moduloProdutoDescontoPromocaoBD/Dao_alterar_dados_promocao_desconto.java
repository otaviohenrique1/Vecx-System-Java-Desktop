package moduloProdutoDescontoPromocaoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;
import moduloProdutoBD.EstoqueProdutos;

public class Dao_alterar_dados_promocao_desconto{
	//Parte que altera os dados no banco de dados
	public void Altera_Dados_Estado_Desconto(Desconto AlteraEstadoDesconto){
    	String sql = "UPDATE descontotb SET "
    				+ "estadodesconto_des = ?, preconormal_des = ?"
	    			+ "WHERE codigodesconto_des = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, AlteraEstadoDesconto.getEstadoDesconto());
    		stmt.setDouble(2, AlteraEstadoDesconto.getPrecoNormal());
    		stmt.setString(3, AlteraEstadoDesconto.getCodigoDesconto());
            stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Desconto_Preco_Estoque(EstoqueProdutos AlteraPrecoEstoqueProduto){
		String sql = "UPDATE estoqueprodutotb SET "
				+ "preco_est = ?"
    			+ "WHERE codigoproduto_est = ? AND produto_est = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt;    		
			stmt = Conecta.prepareStatement(sql);
			stmt.setDouble(1, AlteraPrecoEstoqueProduto.getPrecoaVista());
			stmt.setString(2, AlteraPrecoEstoqueProduto.getCodigoProduto());
			stmt.setString(3, AlteraPrecoEstoqueProduto.getNome());
	        stmt.execute();
	        stmt.close();
	        Conecta.close();
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public void Altera_Dados_Estado_Promocao(Promocao AlteraEstadoPromocao){
    	String sql = "UPDATE promocaotb SET "
    				+ "estadopromocao_promo = ?"
	    			+ "WHERE codigopromocao_promo = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, AlteraEstadoPromocao.getEstadoPromocao());
    		stmt.setString(2, AlteraEstadoPromocao.getCodigoPromocao());
            stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}