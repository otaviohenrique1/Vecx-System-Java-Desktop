package moduloFuncionarioBD;

import java.sql.Date;
import java.sql.Time;

public class FuncionarioFeriasFolga {
	private String codigoFuncionario, nomeFuncionario, cargoFuncionario, duracaoFerias;
	private String codigoResponsavel, nomeResponsavel, cargoResponsavel, tipoFeriasFolga;
	private Date dataInicio, dataFinal, dataCadastro;
	private Time horaCadastro;
	private int totalFerias, totalFolgas;
	
	/*Construtor da classe*/
	public FuncionarioFeriasFolga() {
		
	}
	
	FuncionarioFeriasFolga(String codigoFuncionario, String nomeFuncionario, String cargoFuncionario,
							String codigoResponsavel, String nomeResponsavel, String cargoResponsavel,
							String duracaoFerias, String tipoFeriasFolga, Date dataInicio, Date dataFinal,
							Date dataCadastro, Time horaCadastro, int totalFerias, int totalFolgas) {
		
								this.codigoFuncionario = codigoFuncionario;
								this.nomeFuncionario = nomeFuncionario; 
								this.cargoFuncionario = cargoFuncionario;
								this.codigoResponsavel = codigoResponsavel; 
								this.nomeResponsavel = nomeResponsavel; 
								this.cargoResponsavel = cargoResponsavel;
								this.dataCadastro = dataCadastro;
								this.horaCadastro = horaCadastro;
								this.duracaoFerias = duracaoFerias;
								this.dataInicio = dataInicio;
								this.dataFinal = dataFinal;
								this.tipoFeriasFolga = tipoFeriasFolga;
								this.totalFerias = totalFerias;
								this.totalFolgas = totalFolgas;
		
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
	
	/*get e set Data de cadastro*/
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
	
	/*get e set Duração das ferias*/
	public String getDuracaoFerias() {
		return duracaoFerias;
	}
	public void setDuracaoFerias(String nDuracaoFerias) {
		duracaoFerias = nDuracaoFerias;
	}
	
	/*get e set Data de inicio das ferias folga*/
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date nDataInicio) {
		dataInicio = nDataInicio;
	}
	
	/*get e set Data final das ferias folga*/
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date nDataFinal) {
		dataFinal = nDataFinal;
	}
	
	/*get e set Tipo de ferias folga*/
	public String getTipoFeriasFolga() {
		return tipoFeriasFolga;
	}
	public void setTipoFeriasFolga(String nTipoFeriasFolga) {
		tipoFeriasFolga = nTipoFeriasFolga;
	}
	
	/*get e set Quantidade total de ferias*/
	public int getTotalFerias() {
		return totalFerias;
	}
	public void setTotalFerias(int nTotalFerias) {
		totalFerias = nTotalFerias;
	}
	
	/*get e set Quantidade total de folgas*/
	public int getTotalFolgas() {
		return totalFolgas;
	}
	public void setTotalFolgas(int nTotalFolgas) {
		totalFolgas = nTotalFolgas;
	}
}