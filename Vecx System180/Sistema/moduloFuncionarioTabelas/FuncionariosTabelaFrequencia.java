package moduloFuncionarioTabelas;

public class FuncionariosTabelaFrequencia {
	private String codigoFuncionario, nomeFuncionario, cargoFuncionario, maximoFaltas, presencasValor, faltasValor, turnoHorario, cargaHoraria;
	
	/*Construtor da classe*/
	public FuncionariosTabelaFrequencia(String codigoFuncionario, String nomeFuncionario, String cargoFuncionario, String maximoFaltas, String presencasValor, String faltasValor,
										String turnoHorario, String cargaHoraria) {
											this.codigoFuncionario = codigoFuncionario;
											this.nomeFuncionario = nomeFuncionario;
											this.cargoFuncionario = cargoFuncionario;
											this.maximoFaltas = maximoFaltas;
											this.presencasValor = presencasValor;
											this.faltasValor = faltasValor;
											this.cargaHoraria = cargaHoraria;
											this.turnoHorario = turnoHorario;
	}
	
	/*Metodos get e set */
	/*get e set Codigo do funcionario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}
	
	/*get e set Nome do funcionario*/
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nNomeFuncionario) {
		nomeFuncionario = nNomeFuncionario;
	}
	
	/*get e set Cargo do funcionario*/
	public String getCargoFuncionario() {
		return cargoFuncionario;
	}
	public void setCargoFuncionario(String nCargoFuncionario) {
		cargoFuncionario = nCargoFuncionario;
	}
	
	/*get e set Valor maximo de faltas do funcionario*/
	public String getMaximoFaltas() {
		return maximoFaltas;
	}
	public void setMaximoFaltas(String nMaximoFaltas) {
		maximoFaltas = nMaximoFaltas;
	}
	
	/*get e set Valor de presenças*/
	public String getPresencasValor() {
		return presencasValor;
	}
	public void setPresencasValor(String nPresencasValor) {
		presencasValor = nPresencasValor;
	}
	
	/*get e set Valor de faltas*/
	public String getFaltasValor() {
		return faltasValor;
	}
	public void setFaltasValor(String nFaltasValor) {
		faltasValor = nFaltasValor;
	}

	/*get e set Carga horaria*/
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String nCargaHoraria) {
		cargaHoraria = nCargaHoraria;
	}
	
	/*get e set Turno do funcionario*/
	public String getTurnoHorario() {
		return turnoHorario;
	}
	public void setTurnoHorario(String nTurnoHorario) {
		turnoHorario = nTurnoHorario;
	}
}