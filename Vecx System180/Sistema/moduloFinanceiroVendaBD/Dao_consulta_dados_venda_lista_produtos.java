package moduloFinanceiroVendaBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_venda_lista_produtos{
	//Parte que consulta os dados no banco de dados
    public List<VendaProdutos> Consulta_Dados_Venda_Lista_Produtos (String codigoVenda) {
    	List<VendaProdutos> ConsultaDadosVendaListaProdutos = new ArrayList<VendaProdutos>();
    	String sql = "SELECT * FROM vendalistaprodutotb WHERE codigovenda_lis_ven = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoVenda);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				VendaProdutos DadosVendaProdutos = new VendaProdutos();
				DadosVendaProdutos.setCodigoProduto(rs.getString("codigoproduto_lis_ven"));
				DadosVendaProdutos.setNomeProduto(rs.getString("produto_lis_ven"));
				DadosVendaProdutos.setQuantidade(rs.getDouble("quantidade_lis_ven"));
				DadosVendaProdutos.setPrecoUnitario(rs.getDouble("precounitario_lis_ven"));
				DadosVendaProdutos.setPrecoQuantidade(rs.getDouble("precoquantidade_lis_ven"));
				DadosVendaProdutos.setCodigoBarras(rs.getString("quantidade_lis_ven"));
				DadosVendaProdutos.setCodigoVenda(rs.getString("codigovenda_lis_ven"));
				ConsultaDadosVendaListaProdutos.add(DadosVendaProdutos);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosVendaListaProdutos;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}