package moduloFornecedorBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import aInterfaceSistema.ConectaBanco;
import moduloProdutoBD.Produto;

public class Dao_consulta_dados_fornecedor_produtos{
	//Parte que consulta os dados no banco de dados
    public List<Produto> Consulta_Dados_Compra_Fornecedor_Produtos(String nomeFornecedor) {
    	List<Produto> ConsultaDadosListaProduto = new ArrayList<Produto>();
    	String sql = "SELECT * FROM produtotb WHERE fornecedor_pro = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, nomeFornecedor);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto DadosProduto = new Produto();
				DadosProduto.setCodigoProduto(rs.getString("codigoproduto_pro"));
				DadosProduto.setNome(rs.getString("nome_pro"));
				DadosProduto.setDataPrimeiraCompra(rs.getDate("dataprimeiracompra_pro"));
				DadosProduto.setPrecoCompra(rs.getDouble("precocompra_pro"));
				ConsultaDadosListaProduto.add(DadosProduto);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosListaProduto;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}