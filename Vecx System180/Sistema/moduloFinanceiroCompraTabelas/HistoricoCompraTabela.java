package moduloFinanceiroCompraTabelas;

public class HistoricoCompraTabela {
	private String nomeFuncionario, codigoCompra, precoTotal, dataHoraCompra;
	
	/*Construtor da classe*/
	public HistoricoCompraTabela(String codigoCompra, String nomeFuncionario, String dataHoraCompra, String precoTotal) {
		this.nomeFuncionario = nomeFuncionario;
		this.codigoCompra = codigoCompra;
		this.precoTotal = precoTotal;
		this.dataHoraCompra = dataHoraCompra;
	}
	
	/*Metodos get e set */
	/*get e set Nome do funcionario*/
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nNomeFuncionario) {
		nomeFuncionario = nNomeFuncionario;
	}
	
	/*get e set Codigo da compra*/
	public String getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(String nCodigoCompra) {
		codigoCompra = nCodigoCompra;
	}
	
	/*get e set Preço total da compra*/
	public String getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(String nPrecoTotal) {
		precoTotal = nPrecoTotal;
	}
	
	/*get e set Data e hora da compra*/
	public String getDataHoraCompra() {
		return dataHoraCompra;
	}
	public void setDataHoraCompra(String nDataHoraCompra) {
		dataHoraCompra = nDataHoraCompra;
	}
	
}
