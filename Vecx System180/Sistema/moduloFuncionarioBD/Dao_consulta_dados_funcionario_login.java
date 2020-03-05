package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_funcionario_login{
	//Parte que consulta os dados no banco de dados
	public boolean Consulta_Dados_Funcionario_Login (String loginUsuario, String senhaUsuario) {
		boolean autenticado = false;
    	String sql = "SELECT * FROM funcionariotb WHERE login_fun = ? AND senha_fun = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, loginUsuario);
			stmt.setString(2, senhaUsuario);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				autenticado = true;
			}
			return autenticado;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public String Consulta_Dados_Funcionario_Cargo (String loginUsuario2, String senhaUsuario2) {
		String cargoUsuario = null;
		
		String sql = "SELECT cargo_fun FROM funcionariotb WHERE login_fun = ? AND senha_fun = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, loginUsuario2);
			stmt.setString(2, senhaUsuario2);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				cargoUsuario = rs.getString("cargo_fun");
			}
			return cargoUsuario;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public String Consulta_Dados_Funcionario_NomeFuncionario (String loginUsuario2, String senhaUsuario2) {
		String nomeUsuario = null;
		
		String sql = "SELECT nome_fun FROM funcionariotb WHERE login_fun = ? AND senha_fun = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, loginUsuario2);
			stmt.setString(2, senhaUsuario2);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				nomeUsuario = rs.getString("nome_fun");
			}
			return nomeUsuario;
	    }
	    catch(SQLException erro2){
	    	throw new RuntimeException(erro2);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public String Consulta_Dados_Funcionario_CodigoFuncionario (String loginUsuario2, String senhaUsuario2) {
		String codigoUsuario = null;
		
		String sql = "SELECT codigofuncionario_fun FROM funcionariotb WHERE login_fun = ? AND senha_fun = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, loginUsuario2);
			stmt.setString(2, senhaUsuario2);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				codigoUsuario = rs.getString("codigofuncionario_fun");
			}
			return codigoUsuario;
	    }
	    catch(SQLException erro3){
	    	throw new RuntimeException(erro3);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
	}
}