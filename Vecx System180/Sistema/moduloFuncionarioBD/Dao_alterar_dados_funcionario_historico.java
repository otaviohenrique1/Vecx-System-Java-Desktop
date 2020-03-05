package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_alterar_dados_funcionario_historico{
	//Parte que altera os dados no banco de dados
	public void Altera_Dados_Funcionario_Historico_Maximo_Falta(FuncionarioFrequencia AlteraDadosFuncionarioHistorico){
    	String sql = "UPDATE funcionariohistoricotb SET "
    				+ "maximofalta_his = ?"
	    			+ "WHERE codigofuncionario_his = ? AND funcionario_his = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt = Conecta.prepareStatement(sql);
    		stmt.setDouble(1, AlteraDadosFuncionarioHistorico.getValorMaximoFalta());
    		stmt.setString(2, AlteraDadosFuncionarioHistorico.getCodigoFuncionario());
			stmt.setString(3, AlteraDadosFuncionarioHistorico.getNomeFuncionario());
    		stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Funcionario_Maximo_Falta(Funcionario AlteraDadosFuncionario){
    	String sql = "UPDATE funcionariotb SET "
    				+ "maximofalta_fun = ?" 
	    			+ "WHERE codigofuncionario_fun = ? AND nome_fun = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt = Conecta.prepareStatement(sql);
    		stmt.setInt(1, AlteraDadosFuncionario.getLimiteFaltas());
    		stmt.setString(2, AlteraDadosFuncionario.getCodigoFuncionario());
			stmt.setString(3, AlteraDadosFuncionario.getNome());
    		stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Funcionario_Historico_Falta(FuncionarioFrequencia AlteraDadosFuncionarioHistorico){
    	String sql = "UPDATE funcionariohistoricotb SET "
    				+ "faltaquantidade_his = ?"
	    			+ "WHERE codigofuncionario_his = ? AND funcionario_his = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt = Conecta.prepareStatement(sql);
    		stmt.setDouble(1, AlteraDadosFuncionarioHistorico.getFaltaTotal());
    		stmt.setString(2, AlteraDadosFuncionarioHistorico.getCodigoFuncionario());
			stmt.setString(3, AlteraDadosFuncionarioHistorico.getNomeFuncionario());
    		stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Funcionario_Historico_Presenca(FuncionarioFrequencia AlteraDadosFuncionarioHistorico){
    	String sql = "UPDATE funcionariohistoricotb SET "
    				+ "presencaquantidade_his = ?"
	    			+ "WHERE codigofuncionario_his = ? AND funcionario_his = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt = Conecta.prepareStatement(sql);
    		stmt.setDouble(1, AlteraDadosFuncionarioHistorico.getPresencaTotal());
    		stmt.setString(2, AlteraDadosFuncionarioHistorico.getCodigoFuncionario());
			stmt.setString(3, AlteraDadosFuncionarioHistorico.getNomeFuncionario());
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