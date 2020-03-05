package moduloProdutoDescontoPromocaoTabelas;

public class DescontoResonsavelTabela {
	private String nomeFuncionario, cargo, codigoFuncionario;
	
	/*Construtor da classe*/
	public DescontoResonsavelTabela(String codigoFuncionario, String nomeFuncionario, String cargo) {
		this.nomeFuncionario = nomeFuncionario;
		this.codigoFuncionario = codigoFuncionario;
		this.cargo = cargo;
	}
	
	/*Metodos get e set */
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
}