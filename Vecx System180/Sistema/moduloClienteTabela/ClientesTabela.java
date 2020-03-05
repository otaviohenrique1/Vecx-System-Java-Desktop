package moduloClienteTabela;

public class ClientesTabela {
	
	private String nomeCliente, codigoCliente, rg, cpf;
	
	/*Construtor da classe*/
	public ClientesTabela(String codigoCliente, String nomeCliente, String rg, String cpf) {
		this.nomeCliente = nomeCliente;
		this.codigoCliente = codigoCliente;
		this.rg = rg;
		this.cpf = cpf;
	}
	
	/*Metodos get e set */
	/*get e set Codigo do cliente*/
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String nCodigocliente) {
		codigoCliente = nCodigocliente;
	}
	
	/*get e set Nome*/
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nNomecliente) {
		nomeCliente = nNomecliente;
	}
	
	/*get e set CPF*/
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String nCPF) {
		cpf = nCPF;
	}
	
	/*get e set RG*/
	public String getRG() {
		return rg;
	}
	public void setRG(String nRG) {
		rg = nRG;
	}
}