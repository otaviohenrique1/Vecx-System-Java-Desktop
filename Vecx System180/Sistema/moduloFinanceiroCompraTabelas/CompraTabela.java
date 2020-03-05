package moduloFinanceiroCompraTabelas;

public class CompraTabela {
	
	private String nomeProduto, codigoProduto, quantidade, precoCompra , precoQuantidade, fornecedor;
	
	/*Construtor da classe*/
	public CompraTabela(String codigoProduto, String nomeProduto, String quantidade, String precoCompra, String precoQuantidade, String fornecedor) {
		this.nomeProduto = nomeProduto;
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
		this.precoCompra = precoCompra;
		this.precoQuantidade = precoQuantidade;
		this.fornecedor = fornecedor;
	}
	
	/*Metodos get e set */	
	/*get e set Codigo do produto*/
	public String getCodigoProduto() {
		return codigoProduto;
	}
	
	public void setCodigoProduto(String nCodigoProduto) {
		codigoProduto = nCodigoProduto;
	}
	
	/*get e set Nome do produto*/
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nNomeProduto) {
		nomeProduto = nNomeProduto;
	}
	
	/*get e set Quantidade*/
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String nQuantidade) {
		quantidade = nQuantidade;
	}
	
	/*get e set Preço*/
	public String getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(String nPrecoCompra) {
		precoCompra = nPrecoCompra;
	}
	
	/*get e set Fornecedor*/
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String nFornecedor) {
		fornecedor = nFornecedor;
	}
	
	/*get e set Preço x Quantidade*/
	public String getPrecoQuantidade() {
		return precoQuantidade;
	}
	public void setPrecoQuantidade(String precoQuantidade) {
		this.precoQuantidade = precoQuantidade;
	}
}