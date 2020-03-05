package moduloFinanceiroVendaBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_venda_produtos{
	//Parte que insere os dados no banco de dados
	public void Inserir_Dados_Venda_Produtos(VendaProdutos InsereDadosVendaProdutos){
    	String sql = "INSERT INTO vendalistaprodutotb(codigoproduto_lis_ven, produto_lis_ven, quantidade_lis_ven,"
    				+ "precounitario_lis_ven, precoquantidade_lis_ven, codigovenda_lis_ven)" 
	    			+ "VALUES (?,?,?,?,?,?)";
    	try{
    		PreparedStatement stmt;
    		Connection Conecta = new ConectaBanco().Conecta();
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosVendaProdutos.getCodigoProduto());
    		stmt.setString(2, InsereDadosVendaProdutos.getNomeProduto());
    		stmt.setDouble(3, InsereDadosVendaProdutos.getQuantidade());
            stmt.setDouble(4, InsereDadosVendaProdutos.getPrecoUnitario());
            stmt.setDouble(5, InsereDadosVendaProdutos.getPrecoQuantidade());
            stmt.setString(6, InsereDadosVendaProdutos.getCodigoVenda());
            stmt.execute();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
	}
}