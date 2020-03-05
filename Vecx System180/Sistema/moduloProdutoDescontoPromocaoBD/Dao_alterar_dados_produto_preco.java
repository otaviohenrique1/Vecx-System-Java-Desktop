package moduloProdutoDescontoPromocaoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;
import moduloProdutoBD.EstoqueProdutos;
import moduloProdutoBD.Produto;

public class Dao_alterar_dados_produto_preco{
	//Parte que altera os dados no banco de dados
	public void Altera_Dados_Produto_Preco(Produto AlteraPrecoProduto){
    	String sql = "UPDATE produtotb SET "
    				+ "precovendaavista = ?"
	    			+ "WHERE codigoproduto_pro = ? AND nome_pro = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setDouble(1, AlteraPrecoProduto.getPrecoaVista());
    		stmt.setString(2, AlteraPrecoProduto.getCodigoProduto());
    		stmt.setString(3, AlteraPrecoProduto.getNome());
            stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Produto_Preco_Estoque(EstoqueProdutos AlteraPrecoEstoqueProduto){
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
}