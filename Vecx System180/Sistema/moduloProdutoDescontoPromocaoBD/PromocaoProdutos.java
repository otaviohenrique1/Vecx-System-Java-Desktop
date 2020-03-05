package moduloProdutoDescontoPromocaoBD;

public class PromocaoProdutos {
	private String nomeProduto, codigoProduto, codigoPromocao;
	private double descontoPorcentagem, precoNormal, precoDesconto;

	/*Construtor da classe*/
	public PromocaoProdutos() {
		
	}
	
	PromocaoProdutos(String nomeProduto, String codigoProduto, String codigoPromocao, double descontoPorcentagem, double precoNormal, double precoDesconto) {
						this.nomeProduto = nomeProduto;
					 	this.codigoProduto = codigoProduto;
					 	this.codigoPromocao = codigoPromocao; 
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
	
	/*get e set Codigo da promoção*/
	public String getCodigoPromocao() {
		return codigoPromocao;
	}
	public void setCodigoPromocao(String nCodigoPromocao) {
		codigoPromocao = nCodigoPromocao;
	}
	
	/*get e set Valor da porcentagem do desconto*/
	public double getDescontoPorcentagem() {
		return descontoPorcentagem;
	}
	public void setDescontoPorcentagem(double nDescontoPorcentagem) {
		descontoPorcentagem = nDescontoPorcentagem;
	}
	
	/*get e set Preço normal do produto*/
	public double getPrecoNormal() {
		return precoNormal;
	}
	public void setPrecoNormal(double nPrecoNormal) {
		precoNormal = nPrecoNormal;
	}
	
	/*get e set Preço do produto com desconto*/
	public double getPrecoDesconto() {
		return precoDesconto;
	}
	public void setPrecoDesconto(double nPrecoDesconto) {
		precoDesconto = nPrecoDesconto;
	}
}