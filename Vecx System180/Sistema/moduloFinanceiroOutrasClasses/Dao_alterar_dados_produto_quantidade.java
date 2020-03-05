package moduloFinanceiroOutrasClasses;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;
import moduloProdutoBD.EstoqueProdutos;
import moduloProdutoBD.Produto;

public class Dao_alterar_dados_produto_quantidade{
	//Parte que altera os dados no banco de dados
	public void Altera_Dados_Produto_Quantidade(Produto AlteraQuantidadeProduto){
    	String sql = "UPDATE produtotb SET "
    				+ "quantidade_pro = ?"
	    			+ "WHERE codigoproduto_pro = ? AND nome_pro = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setDouble(1, AlteraQuantidadeProduto.getQuantidade());
    		stmt.setString(2, AlteraQuantidadeProduto.getCodigoProduto());
    		stmt.setString(3, AlteraQuantidadeProduto.getNome());
            stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Produto_Quantidade_Estoque(EstoqueProdutos AlteraQuantidadeEstoqueProduto){
    	String sql = "UPDATE estoqueprodutotb SET "
    				+ "quantidade_est = ?"
	    			+ "WHERE codigoproduto_est = ? AND produto_est = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setDouble(1, AlteraQuantidadeEstoqueProduto.getQuantidade());
    		stmt.setString(2, AlteraQuantidadeEstoqueProduto.getCodigoProduto());
    		stmt.setString(3, AlteraQuantidadeEstoqueProduto.getNome());
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