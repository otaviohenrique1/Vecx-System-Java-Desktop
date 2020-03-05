package moduloTransporteTabelas;

public class TransporteCargasClienteTabela {
	private String nomeCliente, clienteCPF, clienteRG;
	
	/*Construtor da classe*/
	public TransporteCargasClienteTabela(String nomeCliente, String clienteCPF, String clienteRG) {
											this.nomeCliente = nomeCliente;
											this.clienteCPF = clienteCPF;
											this.clienteRG = clienteRG;
	}
	
	/*Metodos get e set */
	/*get e set Nome do cliente*/
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	/*get e set CPF do cliente*/
	public String getClienteCPF() {
		return clienteCPF;
	}
	public void setClienteCPF(String clienteCPF) {
		this.clienteCPF = clienteCPF;
	}
	
	/*get e set RG do cliente*/
	public String getClienteRG() {
		return clienteRG;
	}
	public void setClienteRG(String clienteRG) {
		this.clienteRG = clienteRG;
	}
}