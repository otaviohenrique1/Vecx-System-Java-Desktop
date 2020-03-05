package moduloProdutoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_produto_estoque{
	public void Inserir_Dados_Produto_Estoque(EstoqueProdutos InsereDadosProdutoEstoque){
    	String sql = "INSERT INTO estoqueprodutotb (codigoproduto_est, produto_est, quantidade_est, quantidadeunidade_est, lote_est, preco_est, estadoproduto_est)"
	    			+ "VALUES (?,?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosProdutoEstoque.getCodigoProduto());
    		stmt.setString(2, InsereDadosProdutoEstoque.getNome());
    		stmt.setDouble(3, InsereDadosProdutoEstoque.getQuantidade());
    		stmt.setString(4, InsereDadosProdutoEstoque.getQuantidadeUnidade());
    		stmt.setString(5, InsereDadosProdutoEstoque.getLote());
    		stmt.setDouble(6, InsereDadosProdutoEstoque.getPrecoaVista());
    		stmt.setString(7, InsereDadosProdutoEstoque.getEstadoProduto());
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