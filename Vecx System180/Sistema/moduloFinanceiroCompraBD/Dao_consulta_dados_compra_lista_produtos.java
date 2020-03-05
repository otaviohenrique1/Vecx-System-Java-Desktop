package moduloFinanceiroCompraBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_compra_lista_produtos{
	//Parte que consulta os dados no banco de dados
    public List<CompraProdutos> Consulta_Dados_Compra_Lista_Produtos(String codigoCompra) {
    	List<CompraProdutos> ConsultaDadosCompraListaProdutos = new ArrayList<CompraProdutos>();
    	String sql = "SELECT * FROM compralistaprodutotb WHERE codigocompra_lis_com = ? ";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoCompra);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				CompraProdutos DadosCompraProdutos = new CompraProdutos();
				DadosCompraProdutos.setCodigoProduto(rs.getString("codigoproduto_lis_com"));
				DadosCompraProdutos.setNomeProduto(rs.getString("produto_lis_com"));
				DadosCompraProdutos.setQuantidade(rs.getDouble("quantidade_lis_com"));
				DadosCompraProdutos.setPrecoCompra(rs.getDouble("precounitario_lis_com"));
				DadosCompraProdutos.setPrecoQuantidade(rs.getDouble("precoquantidade_lis_com"));
				DadosCompraProdutos.setFornecedor(rs.getString("nomefornecedor_lis_com"));
				DadosCompraProdutos.setCodigoBarras(rs.getString("codigodebarras_lis_com"));
				DadosCompraProdutos.setICMS(rs.getDouble("icms_lis_com"));
				DadosCompraProdutos.setCodigoCompra(rs.getString("codigocompra_lis_com"));
				ConsultaDadosCompraListaProdutos.add(DadosCompraProdutos);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosCompraListaProdutos;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}