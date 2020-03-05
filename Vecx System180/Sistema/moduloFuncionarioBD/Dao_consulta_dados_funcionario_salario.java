package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_funcionario_salario{
	//Parte que consulta os dados no banco de dados
	public List<FuncionarioSalario> Consulta_Dados_Funcionario_Salario_Lista(String codigoFuncionario) {
    	List<FuncionarioSalario> ConsultaDadosFuncionarioSalario = new ArrayList<FuncionarioSalario>();
    	String sql = "SELECT * FROM funcionariosalariotb WHERE codigofuncionario_sal = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoFuncionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				FuncionarioSalario DadosFuncionarioSalario = new FuncionarioSalario();
				DadosFuncionarioSalario.setEstadoComissaoBonus(rs.getString("estadocomissaobonus_sal"));
				DadosFuncionarioSalario.setBonusSalario(rs.getDouble("valorbonus_sal"));
				DadosFuncionarioSalario.setComissaoSalario(rs.getDouble("valorcomissao_sal"));
				DadosFuncionarioSalario.setDataCadastro(rs.getDate("datacadastro_sal"));
				DadosFuncionarioSalario.setHoraCadastro(rs.getTime("horacadastro_sal"));
				DadosFuncionarioSalario.setNomeResponsavel(rs.getString("funcionarioresponsavel_sal"));
				ConsultaDadosFuncionarioSalario.add(DadosFuncionarioSalario);
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