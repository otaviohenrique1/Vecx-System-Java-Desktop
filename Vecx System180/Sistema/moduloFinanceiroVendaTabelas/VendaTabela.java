package moduloFinanceiroVendaTabelas;

public class VendaTabela {
	private String codigoProduto, nomeProduto, quantidade, preco, precoQuantidade, icms;
	
	/*Construtor da classe*/
	public VendaTabela(String codigoProduto, String nomeProduto,String quantidade, String preco, String precoQuantidade, String icms) {
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.precoQuantidade = precoQuantidade;
		this.icms = icms;
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
	public void setquantidade(String nQuantidade) {
		quantidade = nQuantidade;
	}
	
	/*get e set Preço*/
	public String getPreco() {
		return preco;
	}
	public void setPreco(String nPreco) {
		preco = nPreco;
	}
	
	/*get e set ICMS*/
	public String getICMS() {
		return icms;
	}
	public void setICMS(String nICMS) {
		icms = nICMS;
	}
	
	/*get e set Preco x Quantidade*/
	public String getPrecoQuantidade() {
		return precoQuantidade;
	}
	public void setPrecoQuantidade(String nPrecoQuantidade) {
		precoQuantidade = nPrecoQuantidade;
	}
}