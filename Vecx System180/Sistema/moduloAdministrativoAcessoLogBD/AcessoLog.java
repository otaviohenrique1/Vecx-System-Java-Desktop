package moduloAdministrativoAcessoLogBD;

import java.sql.Date;
import java.sql.Time;

public class AcessoLog {
	private String funcionarioNome, cargo, codigoFuncionario, login, senha, codigoResgistro;
	private Date dataAcesso;
	private Time horaAcesso;
	
	/*Construtor da classe*/
	public AcessoLog() {
		
	}
	
	AcessoLog(String funcionarioNome,String cargo,String codigoFuncionario, String login, String senha, String codigoResgistro,
				Date dataAcesso, Time horaAcesso) {
					this.funcionarioNome = funcionarioNome;
					this.cargo = cargo;
					this.codigoFuncionario = codigoFuncionario;
					this.login = login;
					this.senha = senha;
					this.codigoResgistro = codigoResgistro;
					this.dataAcesso = dataAcesso;
					this.horaAcesso = horaAcesso;
	}
	
	/*Metodos get e set */
	/*get e set Nome do funcionario*/
	public String getFuncionarioNome() {
		return funcionarioNome;
	}
	public void setFuncionarioNome(String nFuncionarioNome) {
		funcionarioNome = nFuncionarioNome;
	}
	
	/*get e set Cargo*/
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String nCargo) {
		cargo = nCargo;
	}
	
	/*get e set Codigo do funcionario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}
	
	/*get e set Login*/
	public String getLogin() {
		return login;
	}

	public void setLogin(String nLogin) {
		login = nLogin;
	}
	
	/*get e set Senha*/
	public String getSenha() {
		return senha;
	}
	public void setSenha(String nSenha) {
		senha = nSenha;
	}
	
	/*get e set Codigo de resgistro*/
	public String getCodigoResgistro() {
		return codigoResgistro;
	}
	public void setCodigoResgistro(String nCodigoResgistro) {
		codigoResgistro = nCodigoResgistro;
	}

	/*get e set Data de acesso*/
	public Date getDataAcesso() {
		return dataAcesso;
	}
	public void setDataAcesso(Date nDataAcesso) {
		dataAcesso = nDataAcesso;
	}
	
	/*get e set Hora de acesso*/
	public Time getHoraAcesso() {
		return horaAcesso;
	}
	public void setHoraAcesso(Time nHoraAcesso) {
		horaAcesso = nHoraAcesso;
	}
}