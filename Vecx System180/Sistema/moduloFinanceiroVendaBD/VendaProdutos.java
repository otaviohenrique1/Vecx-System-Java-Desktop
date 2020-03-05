package moduloFinanceiroVendaBD;

public class VendaProdutos {
	
	private String nomeProduto,codigoBarras,codigoProduto, codigoVenda;
	private double quantidade, precoUnitario, precoQuantidade;
	
	/*Construtor da classe*/
	public VendaProdutos() {
		
	}
	
	VendaProdutos(String nomeProduto,String codigoBarras,String codigoProduto, String codigoVenda, double quantidade, double precoUnitario , double precoQuantidade) {
						this.codigoVenda = codigoVenda;
						this.nomeProduto = nomeProduto;
						this.codigoBarras = codigoBarras;
						this.codigoProduto = codigoProduto;
						this.precoUnitario = precoUnitario;
						this.precoQuantidade = precoQuantidade;
	}
	
	/*Metodos get e set */
	/*get e set Codigo da venda*/
	public String getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(String nCodigoVenda) {
		codigoVenda = nCodigoVenda;
	}
	
	/*get e set Nome do produto*/
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nNomeproduto) {
		nomeProduto = nNomeproduto;
	}
	
	/*get e set Codigo de barras*/
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String nCodigoBarras) {
		codigoBarras = nCodigoBarras;
	}
	
	/*get e set Codigo do produto*/
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String nCodigoProduto) {
		codigoProduto = nCodigoProduto;
	}
	
	/*get e set Quantidade*/
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double nQuantidade) {
		quantidade = nQuantidade;
	}
	
	/*get e set Preco unitario do produto*/
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double nPrecounitario) {
		precoUnitario = nPrecounitario;
	}
	
	/*get e set Preço com a quantidade*/
	public double getPrecoQuantidade() {
		return precoQuantidade;
	}
	public void setPrecoQuantidade(double nPrecoQuantidade) {
		precoQuantidade = nPrecoQuantidade;
	}
}