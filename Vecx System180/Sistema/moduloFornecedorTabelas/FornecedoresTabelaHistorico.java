package moduloFornecedorTabelas;

public class FornecedoresTabelaHistorico {
	private String codigoCompra, dataHoraCompra, precoUnitario, quantidadeProduto, precoQuantidade, codigoProduto, nomeProduto;
	
	/*Construtor da classe*/
	public FornecedoresTabelaHistorico(String codigoProduto, String nomeProduto, String codigoCompra, String dataHoraCompra, String precoUnitario, String quantidadeProduto, String precoQuantidade) {
		this.codigoCompra = codigoCompra;
		this.dataHoraCompra = dataHoraCompra;
		this.precoUnitario = precoUnitario;
		this.quantidadeProduto = quantidadeProduto;
		this.precoQuantidade = precoQuantidade;
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
	}
	
	/*Metodos get e set */
	/*get e set Codigo da compra*/
	public String getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(String nCodigoCompra) {
		codigoCompra = nCodigoCompra;
	}
	
	/*get e set Data e hora da compra*/
	public String getDataHoraCompra() {
		return dataHoraCompra;
	}
	public void setDataHoraCompra(String nDataHoraCompra) {
		dataHoraCompra = nDataHoraCompra;
	}
	
	/*get e set Preço Unitario da venda*/
	public String getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(String nPrecoUnitario) {
		precoUnitario = nPrecoUnitario;
	}
	
	/*get e set Quantidade*/
	public String getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(String nQuantidadeProduto) {
		quantidadeProduto = nQuantidadeProduto;
	}
	
	/*get e set Preço x Quantidade*/
	public String getPrecoQuantidade() {
		return precoQuantidade;
	}
	public void setPrecoQuantidade(String nPrecoQuantidade) {
		precoQuantidade = nPrecoQuantidade;
	}
	
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
}