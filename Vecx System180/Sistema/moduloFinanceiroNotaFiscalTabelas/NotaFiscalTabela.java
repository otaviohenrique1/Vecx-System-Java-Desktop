package moduloFinanceiroNotaFiscalTabelas;

public class NotaFiscalTabela {
	private String clienteNome, codigoNotaFiscal, codigoCompra,  dataHoraEmissao, precoTotal;
	
	/*Construtor da classe*/
	public NotaFiscalTabela(String codigoNotaFiscal, String codigoCompra, String clienteNome, String precoTotal, String dataHoraEmissao) {
		this.clienteNome = clienteNome;
		this.dataHoraEmissao = dataHoraEmissao;
		this.codigoNotaFiscal= codigoNotaFiscal;
		this.precoTotal= precoTotal;
		this.codigoCompra = codigoCompra;
	}
	
	/*Metodos get e set */
	/*get e set Nome do cliente*/
	public String getClienteNome() {
		return clienteNome;
	}
	public void setClienteNome(String nClienteNome) {
		clienteNome = nClienteNome;
	}
	
	/*get e set Data e hora de Emissao*/
	public String getDataHoraEmissao() {
		return dataHoraEmissao;
	}
	public void setDataHoraEmissao(String nDataHoraEmissao) {
		dataHoraEmissao = nDataHoraEmissao;
	}
	
	/*get e set Codigo da nota fiscal*/
	public String getCodigoNotaFiscal() {
		return codigoNotaFiscal;
	}
	public void setCodigoNotaFiscal(String nCodigoNotaFiscal) {
		codigoNotaFiscal = nCodigoNotaFiscal;
	}
	
	/*get e set Preço total da venda*/
	public String getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(String nPrecoTotal) {
		precoTotal = nPrecoTotal;
	}
	
	/*get e set Cdigo da compra*/
	public String getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(String codigoCompra) {
		this.codigoCompra = codigoCompra;
	}
}