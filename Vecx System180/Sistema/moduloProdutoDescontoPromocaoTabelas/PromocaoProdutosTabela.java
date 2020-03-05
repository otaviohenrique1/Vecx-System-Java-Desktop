package moduloProdutoDescontoPromocaoTabelas;

public class PromocaoProdutosTabela {
	private String nomeProduto, codigoProduto, descontoPorcentagem, precoNormal, precoDesconto;
	
	/*Construtor da classe*/
	public PromocaoProdutosTabela(String codigoProduto, String nomeProduto, String precoNormal, String descontoPorcentagem, String precoDesconto) {
									this.nomeProduto = nomeProduto;
								 	this.codigoProduto = codigoProduto;
								 	this.descontoPorcentagem = descontoPorcentagem; 
								 	this.precoNormal = precoNormal;
								 	this.precoDesconto = precoDesconto;
					 	 
	}

	/*Metodos get e set */
	/*get e set Nome do produto*/
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nNomeProduto) {
		nomeProduto = nNomeProduto;
	}
	
	/*get e set Codigo do produto*/
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String nCodigoProduto) {
		codigoProduto = nCodigoProduto;
	}
	
	/*get e set Valor da porcentagem do desconto*/
	public String getDescontoPorcentagem() {
		return descontoPorcentagem;
	}
	public void setDescontoPorcentagem(String nDescontoPorcentagem) {
		descontoPorcentagem = nDescontoPorcentagem;
	}
	
	/*get e set Preço normal do produto*/
	public String getPrecoNormal() {
		return precoNormal;
	}
	public void setPrecoNormal(String nPrecoNormal) {
		precoNormal = nPrecoNormal;
	}
	
	/*get e set Preço do desconto do produto*/
	public String getPrecoDesconto() {
		return precoDesconto;
	}
	public void setPrecoDesconto(String nPrecoDesconto) {
		precoDesconto = nPrecoDesconto;
	}
}