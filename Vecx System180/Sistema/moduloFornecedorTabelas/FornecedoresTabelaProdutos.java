package moduloFornecedorTabelas;

public class FornecedoresTabelaProdutos {
	private String nomeProduto, codigoProduto, precoCompra, dataPrimeiraCompra;
	
	/*Construtor da classe*/
	public FornecedoresTabelaProdutos(String codigoProduto, String nomeProduto, String precoCompra, String dataPrimeiraCompra) {
		this.nomeProduto = nomeProduto;
		this.codigoProduto = codigoProduto;
		this.precoCompra = precoCompra;
		this.dataPrimeiraCompra = dataPrimeiraCompra;
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
	
	/*get e set Data da primeira da compra*/
	public String getDataPrimeiraCompra() {
		return dataPrimeiraCompra;
	}
	public void setDataPrimeiraCompra(String nDataPrimeiraCompra) {
		dataPrimeiraCompra = nDataPrimeiraCompra;
	}
	
	/*get e set Preço de compra*/
	public String getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(String precoCompra) {
		this.precoCompra = precoCompra;
	}
}