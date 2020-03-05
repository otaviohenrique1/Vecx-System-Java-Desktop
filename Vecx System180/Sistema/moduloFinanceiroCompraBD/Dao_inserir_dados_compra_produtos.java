package moduloFinanceiroCompraBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_compra_produtos{
	//Parte que insere os dados no banco de dados
    public void Inserir_Dados_Compra_Produtos(CompraProdutos InsereDadosCompraProdutos){
    	String sql = "INSERT INTO compralistaprodutotb (codigoproduto_lis_com, produto_lis_com, quantidade_lis_com,"
    				+ "precounitario_lis_com, precoquantidade_lis_com, nomefornecedor_lis_com, codigocompra_lis_com,"
    				+ "datacompra_lis_com, horacompra_lis_com)" 
	    			+ "VALUES (?,?,?,?,?,?,?,?,?)";
    	try{
    		PreparedStatement stmt;
    		Connection Conecta = new ConectaBanco().Conecta();
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosCompraProdutos.getCodigoProduto());
    		stmt.setString(2, InsereDadosCompraProdutos.getNomeProduto());
    		stmt.setDouble(3, InsereDadosCompraProdutos.getQuantidade());
            stmt.setDouble(4, InsereDadosCompraProdutos.getPrecoCompra());
            stmt.setDouble(5, InsereDadosCompraProdutos.getPrecoQuantidade());
            stmt.setString(6, InsereDadosCompraProdutos.getFornecedor());
            stmt.setString(7, InsereDadosCompraProdutos.getCodigoCompra());
            stmt.setDate(8, InsereDadosCompraProdutos.getDataCompra());
            stmt.setTime(9, InsereDadosCompraProdutos.getHoraCompra());
            stmt.execute();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}