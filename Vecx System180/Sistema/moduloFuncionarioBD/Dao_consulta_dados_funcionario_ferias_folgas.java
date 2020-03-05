package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_funcionario_ferias_folgas{
	//Parte que consulta os dados no banco de dados
	public List<FuncionarioFeriasFolga> Consulta_Dados_Funcionario_Ferias_Folga_Lista(String codigoFuncionario) {
    	List<FuncionarioFeriasFolga> ConsultaDadosFuncionarioSalario = new ArrayList<FuncionarioFeriasFolga>();
    	String sql = "SELECT * FROM controleferiastb WHERE codigofuncionario_ferias = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoFuncionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				FuncionarioFeriasFolga DadosFuncionarioFeriasFolga = new FuncionarioFeriasFolga();
				DadosFuncionarioFeriasFolga.setTipoFeriasFolga(rs.getString("tipoferiasfolga_ferias"));
				DadosFuncionarioFeriasFolga.setDataInicio(rs.getDate("feriasinicio_ferias"));
				DadosFuncionarioFeriasFolga.setDataFinal(rs.getDate("feriasfinal_ferias"));
				DadosFuncionarioFeriasFolga.setDuracaoFerias(rs.getString("feriasduracao_ferias"));
				DadosFuncionarioFeriasFolga.setDataCadastro(rs.getDate("datacadastro_ferias"));
				DadosFuncionarioFeriasFolga.setHoraCadastro(rs.getTime("horacadastro_ferias"));
				DadosFuncionarioFeriasFolga.setTotalFerias(rs.getInt("totalferias_ferias"));
				DadosFuncionarioFeriasFolga.setTotalFolgas(rs.getInt("totalfolgas_ferias"));
				ConsultaDadosFuncionarioSalario.add(DadosFuncionarioFeriasFolga);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFuncionarioSalario;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<FuncionarioFeriasFolga> Consulta_Dados_Funcionario_Total_Ferias(String codigoFuncionario) {
    	List<FuncionarioFeriasFolga> ConsultaDadosFuncionarioSalario = new ArrayList<FuncionarioFeriasFolga>();
    	String sql = "SELECT SUM(totalferias_ferias) AS totalferiasvalor FROM controleferiastb WHERE codigofuncionario_ferias = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoFuncionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				FuncionarioFeriasFolga DadosFuncionarioFeriasFolga = new FuncionarioFeriasFolga();
				DadosFuncionarioFeriasFolga.setTotalFerias(rs.getInt("totalferiasvalor"));
				ConsultaDadosFuncionarioSalario.add(DadosFuncionarioFeriasFolga);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFuncionarioSalario;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<FuncionarioFeriasFolga> Consulta_Dados_Funcionario_Total_Folga(String codigoFuncionario) {
    	List<FuncionarioFeriasFolga> ConsultaDadosFuncionarioSalario = new ArrayList<FuncionarioFeriasFolga>();
    	String sql = "SELECT SUM(totalfolgas_ferias) AS totalfolgavalor FROM controleferiastb WHERE codigofuncionario_ferias = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoFuncionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				FuncionarioFeriasFolga DadosFuncionarioFeriasFolga = new FuncionarioFeriasFolga();
				DadosFuncionarioFeriasFolga.setTotalFolgas(rs.getInt("totalfolgavalor"));
				ConsultaDadosFuncionarioSalario.add(DadosFuncionarioFeriasFolga);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFuncionarioSalario;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}