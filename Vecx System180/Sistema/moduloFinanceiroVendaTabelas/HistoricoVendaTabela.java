package moduloFinanceiroVendaTabelas;

public class HistoricoVendaTabela {
	private String codigoVenda, nomeCliente, nomeFuncionario, dataHoraVenda, precoTotal;
	
	/*Construtor da classe*/
	public HistoricoVendaTabela(String codigoVenda, String nomeCliente, String nomeFuncionario, String precoTotal, String dataHoraVenda) {
		this.codigoVenda = codigoVenda;
		this.nomeCliente = nomeCliente;
		this.nomeFuncionario = nomeFuncionario;
		this.dataHoraVenda = dataHoraVenda;
		this.precoTotal = precoTotal;
	}
	
	/*Metodos get e set */
	/*get e set Codigo da Venda*/
	public String getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(String nCodigoVenda) {
		codigoVenda = nCodigoVenda;
	}
	
	/*get e set Nome do cliente*/
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nNomeCliente) {
		nomeCliente = nNomeCliente;
	}
	
	/*get e set Nome do funcionario*/
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nNomeFuncionario) {
		nomeFuncionario = nNomeFuncionario;
	}
	
	/*get e set Data e Hora da Venda*/
	public String getDataHoraVenda() {
		return dataHoraVenda;
	}
	public void setDataHoraVenda(String nDataHoraVenda) {
		dataHoraVenda = nDataHoraVenda;
	}
	
	/*get e set Preço total da Venda*/
	public String getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(String nPrecoTotal) {
		precoTotal = nPrecoTotal;
	}
}