package moduloProdutoDescontoPromocaoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_promocao_produtos{
	//Parte que consulta os dados no banco de dados
	public List<PromocaoProdutos> Consulta_Dados_Promocao_Produtos(String codigoPromocao) {
    	List<PromocaoProdutos> ConsultaDadosPromocaoProdutos = new ArrayList<PromocaoProdutos>();
    	String sql = "SELECT * FROM promocaolistatb WHERE codigopromocao_promo_lis = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoPromocao);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PromocaoProdutos DadosPromocao = new PromocaoProdutos();
				DadosPromocao.setCodigoProduto(rs.getString("codigoproduto_promo_lis"));
				DadosPromocao.setNomeProduto(rs.getString("nomeproduto_promo_lis"));
				DadosPromocao.setPrecoNormal(rs.getDouble("preconormal_promo_lis"));
				DadosPromocao.setDescontoPorcentagem(rs.getDouble("desconto_promo_lis"));
				DadosPromocao.setPrecoDesconto(rs.getDouble("precodesconto_promo_lis"));
				DadosPromocao.setCodigoPromocao(rs.getString("codigopromocao_promo_lis"));
				ConsultaDadosPromocaoProdutos.add(DadosPromocao);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosPromocaoProdutos;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}