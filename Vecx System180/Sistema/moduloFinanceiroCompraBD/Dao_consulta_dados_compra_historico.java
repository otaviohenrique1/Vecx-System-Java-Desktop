package moduloFinanceiroCompraBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_compra_historico{
	//Parte que consulta os dados no banco de dados
    public List<CompraHistorico> Consulta_Dados_Compra_Historico () {
    	List<CompraHistorico> ConsultaDadosCompra = new ArrayList<CompraHistorico>();
    	String sql = "SELECT * FROM historicoreposicaoestoquetb";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				CompraHistorico DadosCompra = new CompraHistorico();
				DadosCompra.setCodigoCompra(rs.getString("codigocompra_hist_rep"));
				DadosCompra.setNomeFuncionario(rs.getString("funcionario_hist_rep"));
				DadosCompra.setDataCompra(rs.getDate("datacompra_hist_rep"));
				DadosCompra.setHoraCompra(rs.getTime("horacompra_hist_rep"));
				DadosCompra.setPrecoTotal(rs.getDouble("precototal_hist_rep"));
				ConsultaDadosCompra.add(DadosCompra);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosCompra;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}