package moduloFuncionarioTabelas;

public class FuncionariosTabelaFeriasFolga {
	private String duracaoFerias, dataInicio, dataFinal, dataHoraCadastro, tipoFeriasFolga;
	
	/*Construtor da classe*/
	public FuncionariosTabelaFeriasFolga(String tipoFeriasFolga, String dataInicio, String dataFinal, String duracaoFerias, String dataHoraCadastro) {
		this.tipoFeriasFolga = tipoFeriasFolga;
		this.dataHoraCadastro = dataHoraCadastro;
		this.duracaoFerias = duracaoFerias;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}
	
	/*Metodos get e set*/
	/*get e set Data e hora de cadastro*/
	public String getDataHoraCadastro() {
		return dataHoraCadastro;
	}
	public void setDataHoraCadastro(String nDataHoraCadastro) {
		dataHoraCadastro = nDataHoraCadastro;
	}
	
	/*get e set Duração ferias*/
	public String getDuracaoFerias() {
		return duracaoFerias;
	}
	public void setDuracaoFerias(String nDuracaoFerias) {
		duracaoFerias = nDuracaoFerias;
	}
	
	/*get e set Data de Inicio das ferias folgas*/
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String nDataInicio) {
		dataInicio = nDataInicio;
	}
	
	/*get e set Data final das ferias folgas*/
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String nDataFinal) {
		dataFinal = nDataFinal;
	}
	
	/*get e set Tipo de ferias folgas*/
	public String getTipoFeriasFolga() {
		return tipoFeriasFolga;
	}
	public void setTipoFeriasFolga(String nTipoFeriasFolga) {
		tipoFeriasFolga = nTipoFeriasFolga;
	}
}