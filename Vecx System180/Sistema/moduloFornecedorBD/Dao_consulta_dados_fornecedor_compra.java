package moduloFornecedorBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import aInterfaceSistema.ConectaBanco;
import moduloFinanceiroCompraBD.CompraProdutos;

public class Dao_consulta_dados_fornecedor_compra{
	//Parte que consulta os dados no banco de dados
    public List<CompraProdutos> Consulta_Dados_Fornecedor_Compra(String nomeFornecedor) {
    	List<CompraProdutos> ConsultaDadosCompraProdutos = new ArrayList<CompraProdutos>();
    	String sql = "SELECT * FROM compralistaprodutotb WHERE nomefornecedor_lis_com = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, nomeFornecedor);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				CompraProdutos DadosCompraProdutos = new CompraProdutos();
				DadosCompraProdutos.setCodigoProduto(rs.getString("codigoproduto_lis_com"));
				DadosCompraProdutos.setNomeProduto(rs.getString("produto_lis_com"));
				DadosCompraProdutos.setPrecoCompra(rs.getDouble("precounitario_lis_com"));
				DadosCompraProdutos.setQuantidade(rs.getDouble("quantidade_lis_com"));
				DadosCompraProdutos.setPrecoQuantidade(rs.getDouble("precoquantidade_lis_com"));
				DadosCompraProdutos.setCodigoCompra(rs.getString("codigocompra_lis_com"));
				DadosCompraProdutos.setDataCompra(rs.getDate("datacompra_lis_com"));
				DadosCompraProdutos.setHoraCompra(rs.getTime("horacompra_lis_com"));
				ConsultaDadosCompraProdutos.add(DadosCompraProdutos);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosCompraProdutos;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}