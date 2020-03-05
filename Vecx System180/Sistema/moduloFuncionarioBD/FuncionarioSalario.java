package moduloFuncionarioBD;

import java.sql.Date;
import java.sql.Time;

public class FuncionarioSalario {
	private String codigoFuncionario, nomeFuncionario, cargoFuncionario, estadoComissaoBonus;
	private String codigoResponsavel, nomeResponsavel, cargoResponsavel;
	private double salarioFuncionario, bonusSalario, comissaoSalario;
	private Date dataCadastro;
	private Time horaCadastro;
	
	/*Construtor da classe*/
	public FuncionarioSalario() {
		
	}
	
	FuncionarioSalario(String codigoFuncionario, String nomeFuncionario, String cargoFuncionario, String estadoComissaoBonus,
						String codigoResponsavel, String nomeResponsavel, String cargoResponsavel,
						double salarioFuncionario, double bonusSalario, double comissaoSalario,
						Date dataCadastro, Time horaCadastro) {
							this.estadoComissaoBonus = estadoComissaoBonus;
							this.codigoFuncionario = codigoFuncionario;
							this.nomeFuncionario = nomeFuncionario; 
							this.cargoFuncionario = cargoFuncionario;
							this.codigoResponsavel = codigoResponsavel; 
							this.nomeResponsavel = nomeResponsavel; 
							this.cargoResponsavel = cargoResponsavel;
							this.salarioFuncionario = salarioFuncionario;
							this.bonusSalario = bonusSalario;
							this.comissaoSalario = comissaoSalario;
							this.dataCadastro = dataCadastro;
							this.horaCadastro = horaCadastro;
		
	}
	
	/*Metodos get e set*/
	/*get e set Estado comissão/bonus*/
	public String getEstadoComissaoBonus() {
		return estadoComissaoBonus;
	}
	public void setEstadoComissaoBonus(String nEstadoComissaoBonus) {
		estadoComissaoBonus = nEstadoComissaoBonus;
	}
	
	/*get e set Codigo do funcionario*/
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}
	public String getCodigoFuncionario() {
		return codigoFuncionario;
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
	
	/*get e set Codigo do responsavel*/
	public String getCodigoResponsavel() {
		return codigoResponsavel;
	}
	public void setCodigoResponsavel(String nCodigoResponsavel) {
		codigoResponsavel = nCodigoResponsavel;
	}
	
	/*get e set Nome do responsavel*/
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nNomeResponsavel) {
		nomeResponsavel = nNomeResponsavel;
	}
	
	/*get e set Cargo do responsavel*/
	public String getCargoResponsavel() {
		return cargoResponsavel;
	}
	public void setCargoResponsavel(String nCargoResponsavel) {
		cargoResponsavel = nCargoResponsavel;
	}
	
	/*get e set Valor do salario do funcionario*/
	public double getSalarioFuncionario() {
		return salarioFuncionario;
	}
	public void setSalarioFuncionario(double nSalarioFuncionario) {
		salarioFuncionario = nSalarioFuncionario;
	}
	
	/*get e set Valor do bonus*/
	public double getBonusSalario() {
		return bonusSalario;
	}
	public void setBonusSalario(double nBonusSalario) {
		bonusSalario = nBonusSalario;
	}
	
	/*get e set Valor da comissão*/
	public double getComissaoSalario() {
		return comissaoSalario;
	}
	public void setComissaoSalario(double nComissaoSalario) {
		comissaoSalario = nComissaoSalario;
	}
	
	/*get e set Data do cadastro*/
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date nDataCadastro) {
		dataCadastro = nDataCadastro;
	}
	
	/*get e set Hora do cadastro*/
	public Time getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(Time nHoraCadastro) {
		horaCadastro = nHoraCadastro;
	}
}