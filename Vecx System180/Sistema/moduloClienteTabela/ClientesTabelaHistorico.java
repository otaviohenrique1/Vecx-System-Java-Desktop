package moduloClienteTabela;

public class ClientesTabelaHistorico {
	private String codigoCompra, dataHoraCompra, precoTotal;
	
	/*Construtor da classe*/
	public ClientesTabelaHistorico(String codigoCompra, String dataHoraCompra, String precoTotal) {
		this.codigoCompra = codigoCompra;
		this.dataHoraCompra = dataHoraCompra;
		this.precoTotal = precoTotal;
	}
	
	/*Metodos get e set */
	/*get e set Codigo da compra*/
	public String getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(String nCodigoCompra) {
		codigoCompra = nCodigoCompra;
	}
	
	/*get e set Data e hora da venda*/
	public String getDataHoraCompra() {
		return dataHoraCompra;
	}
	public void setDataHoraCompra(String nDataHoraCompra) {
		dataHoraCompra = nDataHoraCompra;
	}
	
	/*get e set Preço total da venda*/
	public String getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(String nPrecoTotal) {
		precoTotal = nPrecoTotal;
	}
}