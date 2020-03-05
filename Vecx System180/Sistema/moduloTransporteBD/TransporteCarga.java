package moduloTransporteBD;

import java.sql.Time;
import java.sql.Date;

public class TransporteCarga {
	private String codigoTransporte, enderecoCliente, funcionarioCadastro, cargoFuncionarioCadastro, codigoFuncionarioCadastro;
	private String clienteNome, clienteCPF, clienteRG, estadoCarga, tipoTransporte, codigoVenda;
	private String clienteNumero, clienteBairro, clienteCidade;
	private String funcionarioResponsavel, cargoResponsavel, codigoResponsavel;
	private Date dataCadastro, dataSaida, dataChegada;
	private Time horaCadastro, horaSaida, horaChegada;

	/*Construtor da classe*/
	public TransporteCarga() {
		
	}
	
	TransporteCarga(String codigoTransporte, String enderecoCliente ,String funcionarioResponsavel, String cargoResponsavel, String codigoResponsavel,
					String clienteNome, String clienteCPF, String clienteRG, String estadoCarga, String tipoTransporte,	String funcionarioCadastro, 
					String cargoFuncionarioCadastro, String codigoFuncionarioCadastro, String clienteNumero, String clienteBairro, String codigoVenda,
					String clienteCidade, Date dataCadastro, Date dataSaida, Date dataChegada,Time horaCadastro, Time horaSaida, Time horaChegada) {
						this.codigoTransporte = codigoTransporte;
						this.funcionarioResponsavel = funcionarioResponsavel;
						this.cargoResponsavel = cargoResponsavel;
						this.codigoResponsavel = codigoResponsavel;
						this.clienteNome = clienteNome;
						this.clienteCPF = clienteCPF;
						this.clienteRG = clienteRG;
						this.enderecoCliente = enderecoCliente;
						this.clienteBairro = clienteBairro;
						this.clienteNumero = clienteNumero;
						this.clienteCidade = clienteCidade;
						this.dataCadastro = dataCadastro;
						this.horaCadastro = horaCadastro;
						this.dataSaida = dataSaida;
						this.dataChegada = dataChegada;
						this.horaSaida = horaSaida;
						this.horaChegada = horaChegada;
						this.codigoVenda = codigoVenda;
						this.estadoCarga = estadoCarga;
						this.tipoTransporte = tipoTransporte;
						this.funcionarioCadastro = funcionarioCadastro;
						this.cargoFuncionarioCadastro = cargoFuncionarioCadastro;
						this.codigoFuncionarioCadastro = codigoFuncionarioCadastro;						
	}
	
	/*Metodos get e set */
	/*get e set Codigo do transporte*/
	public String getCodigoTransporte() {
		return codigoTransporte;
	}
	public void setCodigoTransporte(String nCodigoTransporte) {
		codigoTransporte = nCodigoTransporte;
	}
	
	/*get e set Nome do funcionario responsavel pelo transporte*/
	public String getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}
	public void setFuncionarioResponsavel(String nFuncionarioResponsavel) {
		funcionarioResponsavel = nFuncionarioResponsavel;
	}
	
	/*get e set Cargo do funcionario responsavel pelo transporte*/
	public String getCargoResponsavel() {
		return cargoResponsavel;
	}
	public void setCargoResponsavel(String nCargoResponsavel) {
		cargoResponsavel = nCargoResponsavel;
	}
	
	/*get e set Codigo do funcionario responsavel pelo transporte*/
	public String getCodigoResponsavel() {
		return codigoResponsavel;
	}
	public void setCodigoResponsavel(String nCodigoResponsavel) {
		codigoResponsavel = nCodigoResponsavel;
	}
	
	/*get e set Nome do cliente*/
	public String getClienteNome() {
		return clienteNome;
	}
	public void setClienteNome(String nClienteNome) {
		clienteNome = nClienteNome;
	}
	
	/*get e set CPF do cliente*/
	public String getClienteCPF() {
		return clienteCPF;
	}
	public void setClienteCPF(String nClienteCPF) {
		clienteCPF = nClienteCPF;
	}
	
	/*get e set RG do cliente*/
	public String getClienteRG() {
		return clienteRG;
	}
	public void setClienteRG(String nClienteRG) {
		clienteRG = nClienteRG;
	}
	
	/*get e set Numero da casa do cliente*/
	public String getClienteNumero() {
		return clienteNumero;
	}
	public void setClienteNumero(String clienteNumero) {
		this.clienteNumero = clienteNumero;
	}
	
	/*get e set Bairro do cliente*/
	public String getClienteBairro() {
		return clienteBairro;
	}
	public void setClienteBairro(String clienteBairro) {
		this.clienteBairro = clienteBairro;
	}

	/*get e set RG do cliente*/
	public String getClienteCidade() {
		return clienteCidade;
	}
	public void setClienteCidade(String clienteCidade) {
		this.clienteCidade = clienteCidade;
	}

	/*get e set Data de cadastro*/
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date nDataCadastro) {
		dataCadastro = nDataCadastro;
	}
	
	/*get e set Data de saida*/
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date nDataSaida) {
		dataSaida = nDataSaida;
	}
	
	/*get e set Data de chegada*/
	public Date getDataChegada() {
		return dataChegada;
	}
	public void setDataChegada(Date nDataChegada) {
		dataChegada = nDataChegada;
	}
	
	/*get e set Hora de saida*/
	public Time getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Time nHoraSaida) {
		horaSaida = nHoraSaida;
	}
	
	/*get e set Hora de chegada*/
	public Time getHoraChegada() {
		return horaChegada;
	}
	public void setHoraChegada(Time nHoraChegada) {
		horaChegada = nHoraChegada;
	}
	
	/*get e set Hora do cadastro*/
	public Time getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(Time nHoraCadastro) {
		horaCadastro = nHoraCadastro;
	}
	
	/*get e set Codigo da venda*/
	public String getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(String nCodigoVenda) {
		codigoVenda = nCodigoVenda;
	}

	/*get e set Estado da carga*/
	public String getEstadoCarga() {
		return estadoCarga;
	}
	public void setEstadoCarga(String nEstadoCarga) {
		estadoCarga = nEstadoCarga;
	}
	
	/*get e set Tipo de transporte*/
	public String getTipoTransporte() {
		return tipoTransporte;
	}
	public void setTipoTransporte(String nTipoTransporte) {
		tipoTransporte = nTipoTransporte;
	}
	
	/*get e set Endereço do transporte*/
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String nEnderecoCliente) {
		enderecoCliente = nEnderecoCliente;
	}
	
	/*get e set Nome do funcionario que cadastrou*/
	public String getFuncionarioCadastro() {
		return funcionarioCadastro;
	}
	public void setFuncionarioCadastro(String nFuncionarioCadastro) {
		funcionarioCadastro = nFuncionarioCadastro;
	}
	
	/*get e set Cargo do funcionario que cadastrou*/
	public String getCargoFuncionarioCadastro() {
		return cargoFuncionarioCadastro;
	}
	public void setCargoFuncionarioCadastro(String nCargoFuncionarioCadastro) {
		cargoFuncionarioCadastro = nCargoFuncionarioCadastro;
	}
	
	/*get e set Codigo do funcionario que cadastrou*/
	public String getCodigoFuncionarioCadastro() {
		return codigoFuncionarioCadastro;
	}
	public void setCodigoFuncionarioCadastro(String nCodigoFuncionarioCadastro) {
		codigoFuncionarioCadastro = nCodigoFuncionarioCadastro;
	}
}