package moduloTransporteTabelas;

public class TransporteCargaTabela {
	private String codigoTransporte, funcionarioNome, clienteNome, estadoCarga;
	
	/*Construtor da classe*/
	public TransporteCargaTabela(String codigoTransporte, String funcionarioNome, String clienteNome, String estadoCarga) {
									this.codigoTransporte = codigoTransporte;
									this.funcionarioNome = funcionarioNome;
									this.clienteNome = clienteNome;
									this.estadoCarga = estadoCarga;
	}
	
	/*Metodos get e set */
	/*get e set Codigo do transporte*/
	public String getCodigoTransporte() {
		return codigoTransporte;
	}
	public void setCodigoTransporte(String nCodigoTransporte) {
		this.codigoTransporte = nCodigoTransporte;
	}
	
	/*get e set Nome do funcionario*/
	public String getFuncionarioNome() {
		return funcionarioNome;
	}
	public void setFuncionarioNome(String nFuncionarioNome) {
		funcionarioNome = nFuncionarioNome;
	}
	
	/*get e set Nome do cliente*/
	public String getClienteNome() {
		return clienteNome;
	}
	public void setClienteNome(String nClienteNome) {
		clienteNome = nClienteNome;
	}
		
	/*get e set Estado da carga*/
	public String getEstadoCarga() {
		return estadoCarga;
	}
	public void setEstadoCarga(String nEstadoCarga) {
		this.estadoCarga = nEstadoCarga;
	}
}