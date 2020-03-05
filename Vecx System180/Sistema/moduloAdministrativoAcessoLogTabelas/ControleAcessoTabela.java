package moduloAdministrativoAcessoLogTabelas;

public class ControleAcessoTabela {
	
	private String funcionarioNome, Cargo, dataHoraAcesso, codigoRegistro;
	
	/*Construtor da classe*/
	public ControleAcessoTabela(String codigoRegistro, String funcionarioNome,String Cargo, String dataHoraAcesso) {
									this.codigoRegistro = codigoRegistro;
									this.funcionarioNome = funcionarioNome;
									this.Cargo = Cargo;
									this.dataHoraAcesso = dataHoraAcesso;
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
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	
	/*get e set Data e hora do acesso*/
	public String getDataHoraAcesso() {
		return dataHoraAcesso;
	}
	public void setDataHoraAcesso(String nDataHoraAcesso) {
		dataHoraAcesso = nDataHoraAcesso;
	}
	
	/*get e set Codigo de registro*/
	public String getCodigoRegistro() {
		return codigoRegistro;
	}
	public void setCodigoRegistro(String nCodigoRegistro) {
		codigoRegistro = nCodigoRegistro;
	}	
}