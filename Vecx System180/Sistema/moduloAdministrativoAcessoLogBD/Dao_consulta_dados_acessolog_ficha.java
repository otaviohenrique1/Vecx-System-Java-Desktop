package moduloAdministrativoAcessoLogBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_acessolog_ficha{
	//Parte que consulta os dados no banco de dados
    public List<AcessoLog> Consulta_Dados_AcessoLog(String codigoAcesso, String funcionarioAcesso, String cargoAcesso) {
    	List<AcessoLog> ConsultaDadosAcessoLog = new ArrayList<AcessoLog>();
    	String sql = "SELECT * FROM acessologtb WHERE codigoregistro_log = ? AND nomefuncionario_log = ? AND cargo_log = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoAcesso);
			stmt.setString(2, funcionarioAcesso);
			stmt.setString(3, cargoAcesso);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				AcessoLog DadosAcessoLog = new AcessoLog();
				DadosAcessoLog.setFuncionarioNome(rs.getString("nomefuncionario_log"));
				DadosAcessoLog.setCargo(rs.getString("cargo_log"));
				DadosAcessoLog.setCodigoFuncionario(rs.getString("codigofuncionario_log"));
				DadosAcessoLog.setLogin(rs.getString("login_log"));
				DadosAcessoLog.setSenha(rs.getString("senha_log"));
				DadosAcessoLog.setDataAcesso(rs.getDate("dataacesso_log"));
				DadosAcessoLog.setHoraAcesso(rs.getTime("horaacesso_log"));
				DadosAcessoLog.setCodigoResgistro(rs.getString("codigoregistro_log"));
				ConsultaDadosAcessoLog.add(DadosAcessoLog);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosAcessoLog;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}