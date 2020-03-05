package moduloFuncionarioBD;

import java.sql.Date;
import java.sql.Time;

public class FuncionarioFrequenciaFaltas {
	
	private String frequencia, nomeFuncionario, cargoFuncionario, codigoFuncionario;
	private  Date dataTrabalho; 
	private Time horaCadastro;
	
	/*Construtor da classe*/
	public FuncionarioFrequenciaFaltas() {
		
	}
	
	FuncionarioFrequenciaFaltas(Date dataTrabalho, String frequencia, String nomeFuncionario, String cargoFuncionario, String codigoFuncionario, Time horaCadastro) {
										this.dataTrabalho = dataTrabalho;
										this.frequencia = frequencia;
										this.nomeFuncionario = nomeFuncionario;
										this.cargoFuncionario = cargoFuncionario;
										this.codigoFuncionario = codigoFuncionario;
										this.horaCadastro = horaCadastro;
	}
	
	/*Metodos get e set */
	/*get e set Data do dia*/
	public Date getDataTrabalho() {
		return dataTrabalho;
	}
	public void setDataTrabalho(Date nDataTrabalho) {
		dataTrabalho = nDataTrabalho;
	}
	
	/*get e set Frequencia*/
	public String getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(String nFrequencia) {
		frequencia = nFrequencia;
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
	
	/*get e set Codigo do funcionario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}
	
	/*get e set Hora de cadastro*/
	public Time getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(Time nHoraCadastro) {
		horaCadastro = nHoraCadastro;
	}	
}