package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_funcionario_historico{
	//Parte que consulta os dados no banco de dados
	public List<FuncionarioFrequencia> Consulta_Dados_Funcionariso_Historico_Lista(String codigoFuncionario, String nomeFuncionario, String cargoFuncionario) {
    	List<FuncionarioFrequencia> ConsultaDadosFuncionarioFrequencia = new ArrayList<FuncionarioFrequencia>();
    	String sql = "SELECT * FROM funcionariohistoricotb WHERE codigofuncionario_his = ? AND funcionario_his = ? AND cargofuncionario_his = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoFuncionario);
			stmt.setString(2, nomeFuncionario);
			stmt.setString(3, cargoFuncionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				FuncionarioFrequencia DadosFuncionarioFrequencia = new FuncionarioFrequencia();
				DadosFuncionarioFrequencia.setCodigoFuncionario(rs.getString("codigofuncionario_his"));
				DadosFuncionarioFrequencia.setNomeFuncionario(rs.getString("funcionario_his"));
				DadosFuncionarioFrequencia.setCargoFuncionario(rs.getString("cargofuncionario_his"));
				DadosFuncionarioFrequencia.setHoraEntrada(rs.getTime("entradafuncionario_his"));
				DadosFuncionarioFrequencia.setHoraSaida(rs.getTime("saidafuncionario_his"));
				DadosFuncionarioFrequencia.setPresencaTotal(rs.getInt("presencaquantidade_his"));
				DadosFuncionarioFrequencia.setFaltaTotal(rs.getInt("faltaquantidade_his"));
				DadosFuncionarioFrequencia.setValorMaximoFalta(rs.getInt("maximofalta_his"));
				DadosFuncionarioFrequencia.setCargaHoraria(rs.getString("cargahoraria_his"));
				DadosFuncionarioFrequencia.setCargaHorariaUnidade(rs.getString("cargahorariaunidade_his"));
				ConsultaDadosFuncionarioFrequencia.add(DadosFuncionarioFrequencia);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFuncionarioFrequencia;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<FuncionarioFrequenciaFaltas> Consulta_Dados_Funcionarios_Frequencia_Lista(String codigoFuncionario, String nomeFuncionario, String cargoFuncionario) {
    	List<FuncionarioFrequenciaFaltas> ConsultaDadosFuncionarioFrequencia = new ArrayList<FuncionarioFrequenciaFaltas>();
    	String sql = "SELECT * FROM  funcionariohistoricolistafaltastb WHERE codigofuncionario_his_lis = ? AND funcionario_his_lis  = ? AND cargofuncionario_his_lis = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoFuncionario);
			stmt.setString(2, nomeFuncionario);
			stmt.setString(3, cargoFuncionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				FuncionarioFrequenciaFaltas DadosFuncionarioFrequencia = new FuncionarioFrequenciaFaltas();
				DadosFuncionarioFrequencia.setDataTrabalho(rs.getDate("datatrabalho_his_lis"));
				DadosFuncionarioFrequencia.setFrequencia(rs.getString("frequencia_his_lis"));
				DadosFuncionarioFrequencia.setHoraCadastro(rs.getTime("horacadastro_his_lis"));
				ConsultaDadosFuncionarioFrequencia.add(DadosFuncionarioFrequencia);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFuncionarioFrequencia;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}