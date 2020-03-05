package moduloFuncionarioBD;

import java.sql.Time;

public class FuncionarioFrequencia {
	
	private String nomeFuncionario, cargoFuncionario, codigoFuncionario, cargaHoraria, cargaHorariaUnidade;
	private int presencaTotal, faltaTotal, valorMaximoFalta;
	private Time horaEntrada, horaSaida;
	
	/*Construtor da classe*/
	public FuncionarioFrequencia() {
		
	}
	
	FuncionarioFrequencia(String nomeFuncionario, String cargoFuncionario, String codigoFuncionario, int presencaTotal, int faltaTotal, int valorMaximoFalta,
							String cargaHoraria, String cargaHorariaUnidade, Time horaEntrada, Time horaSaida) {
										this.nomeFuncionario = nomeFuncionario;
										this.cargoFuncionario = cargoFuncionario;
										this.codigoFuncionario = codigoFuncionario;
										this.presencaTotal = presencaTotal;
										this.faltaTotal = faltaTotal;
										this.valorMaximoFalta = valorMaximoFalta;
										this.cargaHoraria = cargaHoraria;
										this.cargaHorariaUnidade = cargaHorariaUnidade;
										this.horaEntrada = horaEntrada;
										this.horaSaida = horaSaida;
	}
	
	/*Metodos get e set */
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
	
	/*get e set Codigo do funcionario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}
	
	/*get e set Valor maximo de faltas*/
	public int getValorMaximoFalta() {
		return valorMaximoFalta;
	}
	public void setValorMaximoFalta(int nValorMaximoFalta) {
		valorMaximoFalta = nValorMaximoFalta;
	}
	
	/*get e set Data do dia*/
	public int getPresencaTotal() {
		return presencaTotal;
	}
	public void setPresencaTotal(int nPresencaTotal) {
		presencaTotal = nPresencaTotal;
	}
	
	/*get e set Numero total de faltas*/
	public int getFaltaTotal() {
		return faltaTotal;
	}
	public void setFaltaTotal(int nFaltaTotal) {
		faltaTotal = nFaltaTotal;
	}
	
	/*get e set Carga horaria*/
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String nCargaHoraria) {
		cargaHoraria = nCargaHoraria;
	}
	
	/*get e set Carga horaria unidade*/
	public String getCargaHorariaUnidade() {
		return cargaHorariaUnidade;
	}
	public void setCargaHorariaUnidade(String nCargaHorariaUnidade) {
		cargaHorariaUnidade = nCargaHorariaUnidade;
	}
	
	/*get e set Hora de entrada*/
	public Time getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(Time nHoraEntrada) {
		horaEntrada = nHoraEntrada;
	}
	
	/*get e set Hora de saida*/
	public Time getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Time nHoraSaida) {
		horaSaida = nHoraSaida;
	}
}