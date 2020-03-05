package moduloProdutoDescontoPromocaoTabelas;

public class DescontoTabela {
	private String codigoDesconto, nomeProduto, nomeResponsavel, descontoPorcentagem, dataHoraInicio, dataHoraTermino;

	/*Construtor da classe*/
	public DescontoTabela(String codigoDesconto, String nomeProduto, String descontoPorcentagem, String dataHoraInicio, String dataHoraTermino, String nomeResponsavel) {
							this.nomeProduto = nomeProduto;
						 	this.codigoDesconto = codigoDesconto;
						 	this.nomeResponsavel = nomeResponsavel;
						 	this.dataHoraInicio = dataHoraInicio;
						 	this.dataHoraTermino = dataHoraTermino;
						 	this.descontoPorcentagem = descontoPorcentagem;
	}
	
	/*Metodos get e set */
	/*get e set Codigo do desconto*/
	public String getCodigoDesconto() {
		return codigoDesconto;
	}
	public void setCodigoDesconto(String codigoDesconto) {
		this.codigoDesconto = codigoDesconto;
	}
	
	/*get e set Nome do produto*/
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nNomeProduto) {
		nomeProduto = nNomeProduto;
	}
	
	/*get e set Valor da porcentagem do desconto*/
	public String getDescontoPorcentagem() {
		return descontoPorcentagem;
	}
	public void setDescontoPorcentagem(String nDescontoPorcentagem) {
		descontoPorcentagem = nDescontoPorcentagem;
	}
	
	/*get e set Nome do responsavel*/
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nNomeResponsavel) {
		nomeResponsavel = nNomeResponsavel;
	}
	
	/*get e set Data e hora do inicio do desconto*/
	public String getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(String nDataHoraInicio) {
		dataHoraInicio = nDataHoraInicio;
	}
	
	/*get e set Data e hora do termino do desconto*/
	public String getDataHoraTermino() {
		return dataHoraTermino;
	}
	public void setDataHoraTermino(String nDataHoraTermino) {
		dataHoraTermino = nDataHoraTermino;
	}
}