package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_funcionario_historico{
	public void Inserir_Dados_Funcionario_Historico(FuncionarioFrequencia InsereDadosFrequenciaFuncionario){
    	String sql = "INSERT INTO funcionariohistoricotb (codigofuncionario_his, funcionario_his, cargofuncionario_his,"
    				+ "presencaquantidade_his, faltaquantidade_his, maximofalta_his, entradafuncionario_his,"
    				+ "saidafuncionario_his, cargahoraria_his, cargahorariaunidade_his)" 
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosFrequenciaFuncionario.getCodigoFuncionario());
    		stmt.setString(2, InsereDadosFrequenciaFuncionario.getNomeFuncionario());
    		stmt.setString(3, InsereDadosFrequenciaFuncionario.getCargoFuncionario());
    		stmt.setInt(4, InsereDadosFrequenciaFuncionario.getPresencaTotal());
    		stmt.setInt(5, InsereDadosFrequenciaFuncionario.getFaltaTotal());
            stmt.setInt(6, InsereDadosFrequenciaFuncionario.getValorMaximoFalta());
            stmt.setTime(7, InsereDadosFrequenciaFuncionario.getHoraEntrada());
    		stmt.setTime(8, InsereDadosFrequenciaFuncionario.getHoraSaida());
    		stmt.setString(9, InsereDadosFrequenciaFuncionario.getCargaHoraria());
            stmt.setString(10, InsereDadosFrequenciaFuncionario.getCargaHorariaUnidade());
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