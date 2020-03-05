package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_funcionario_historico_faltas{
	public void Inserir_Dados_Funcionario_Historico(FuncionarioFrequenciaFaltas InsereDadosFrequenciaFaltas){
    	String sql = "INSERT INTO  funcionariohistoricolistafaltastb (codigofuncionario_his_lis, funcionario_his_lis, cargofuncionario_his_lis,"
    				+ "datatrabalho_his_lis, frequencia_his_lis, horacadastro_his_lis)" 
	    			+ "VALUES (?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		//Connection Conecta =  new  ConnectionFactory().getConnection();
    		PreparedStatement stmt;
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosFrequenciaFaltas.getCodigoFuncionario());
    		stmt.setString(2, InsereDadosFrequenciaFaltas.getNomeFuncionario());
    		stmt.setString(3, InsereDadosFrequenciaFaltas.getCargoFuncionario());
    		stmt.setDate(4, InsereDadosFrequenciaFaltas.getDataTrabalho());
            stmt.setString(5, InsereDadosFrequenciaFaltas.getFrequencia());
            stmt.setTime(6, InsereDadosFrequenciaFaltas.getHoraCadastro());
            stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}