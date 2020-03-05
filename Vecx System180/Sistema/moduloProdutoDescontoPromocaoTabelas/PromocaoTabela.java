package moduloProdutoDescontoPromocaoTabelas;

public class PromocaoTabela {
	private String nomePromocao, codigoPromocao, nomeResponsavel, dataHoraInicio, dataHoraTermino;

	/*Construtor da classe*/
	public PromocaoTabela(String codigoPromocao, String nomePromocao,  String dataHoraInicio, String dataHoraTermino, String nomeResponsavel) {
							 	this.nomePromocao = nomePromocao;
							 	this.codigoPromocao = codigoPromocao;
							 	this.nomeResponsavel = nomeResponsavel;
							 	this.dataHoraInicio = dataHoraInicio;
							 	this.dataHoraTermino = dataHoraTermino;
	}
	
	/*Metodos get e set */
	/*get e set Nome da promoção*/
	public String getNomePromocao() {
		return nomePromocao;
	}
	public void setNomePromocao(String nNomePromocao) {
		nomePromocao = nNomePromocao;
	}
	
	/*get e set Codigo da promoção*/
	public String getCodigoPromocao() {
		return codigoPromocao;
	}
	public void setCodigoPromocao(String nCodigoPromocao) {
		codigoPromocao = nCodigoPromocao;
	}
	
	/*get e set Nome do responsavel*/
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nNomeResponsavel) {
		nomeResponsavel = nNomeResponsavel;
	}
	
	/*get e set Data e hora de inicio da promoção*/
	public String getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(String nDataHoraInicio) {
		dataHoraInicio = nDataHoraInicio;
	}
	
	/*get e set Data e hora de termino da promoção*/
	public String getDataHoraTermino() {
		return dataHoraTermino;
	}
	public void setDataHoraTermino(String nDataHoraTermino) {
		dataHoraTermino = nDataHoraTermino;
	}
}