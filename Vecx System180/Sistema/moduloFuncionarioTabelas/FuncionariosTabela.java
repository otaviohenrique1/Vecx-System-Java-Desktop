package moduloFuncionarioTabelas;

public class FuncionariosTabela {
	private String nomeFuncionario, cargo, codigoFuncionario, rgFuncionario, cpfFuncionario;
	
	/*Construtor da classe*/
	public FuncionariosTabela(String codigoFuncionario, String nomeFuncionario, String cargo, String rgFuncionario, String cpfFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
		this.codigoFuncionario = codigoFuncionario;
		this.cargo = cargo;
		this.rgFuncionario = rgFuncionario;
		this.cpfFuncionario = cpfFuncionario;
	}
	
	/*Metodos get e set*/
	/*get e set Nome do funcionario*/
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nNomeFuncionario) {
		nomeFuncionario = nNomeFuncionario;
	}
	
	/*get e set Codigo do funcionario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}
	
	/*get e set Cargo do funcionario*/
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String nCargo) {
		cargo = nCargo;
	}
	
	/*get e set RG do funcionario*/
	public String getRGFuncionario() {
		return rgFuncionario;
	}
	public void setRGFuncionario(String nRGFuncionario) {
		rgFuncionario = nRGFuncionario;
	}
	
	/*get e set CPF do funcionario*/
	public String getCPFFuncionario() {
		return cpfFuncionario;
	}
	public void setCPFFuncionario(String nCPFFuncionario) {
		cpfFuncionario = nCPFFuncionario;
	}	
}