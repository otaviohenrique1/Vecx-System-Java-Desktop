package moduloFinanceiroVendaBD;

import java.sql.Date;
import java.sql.Time;

public class Venda {
	
	private String nomeFuncionario,nomeCliente, tipoPagamento,codigoVenda, metodoPagamento, notaFiscal, codigoFuncionario, cargoFuncionario, cpfCliente, codigoCliente;
	private double precoTotal, precoTotalDesconto, descontoProcentagem, precoTotalParcelado;
	private int quantidadeParcelas;
	private Date dataVenda;
	private  Time horaVenda;
	
	/*Construtor da classe*/
	public Venda() {
		
	}
	
	Venda(String nomeFuncionario, String tipoPagamento, String nomeCliente,String codigoVenda, String metodoPagamento, String notaFiscal, String codigoCliente,
			String codigoFuncionario, String cargoFuncionario, String cpfCliente , double precoTotal, double precoTotalDesconto, double descontoProcentagem,
			double precoTotalParcelado,	int quantidadeParcelas, Date dataVenda, Time horaVenda) {
				this.nomeFuncionario = nomeFuncionario;
				this.nomeCliente = nomeCliente;
				this.tipoPagamento = tipoPagamento;
				this.codigoVenda = codigoVenda;
				this.metodoPagamento = metodoPagamento;
				this.notaFiscal = notaFiscal;
				this.precoTotal = precoTotal;
				this.dataVenda = dataVenda;
				this.horaVenda = horaVenda;
				this.codigoFuncionario = codigoFuncionario;
				this.cargoFuncionario = cargoFuncionario;
				this.cpfCliente = cpfCliente;
				this.codigoCliente = codigoCliente;
				this.precoTotalDesconto = precoTotalDesconto;
				this.descontoProcentagem = descontoProcentagem;
				this.precoTotalParcelado = precoTotalParcelado;
				this.quantidadeParcelas = quantidadeParcelas;
	}
	
	/*Metodos get e set */
	/*get e set Nome do cliente*/
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nNomeCliente) {
		nomeCliente = nNomeCliente;
	}
	
	/*get e set nomeFuncionario*/
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nNomeFuncionario) {
		nomeFuncionario = nNomeFuncionario;
	}
	
	/*get e set codigoVenda*/
	public String getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(String nCodigoVenda) {
		codigoVenda = nCodigoVenda;
	}
	
	/*get e set Tipo de pagamento*/
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String nTipoPagamento) {
		tipoPagamento = nTipoPagamento;
	}
	
	/*get e set Metodo de Pagamento*/
	public String getMetodoPagamento() {
		return metodoPagamento;
	}
	public void setMetodoPagamento(String nMetodoPagamento) {
		metodoPagamento = nMetodoPagamento;
	}
	
	/*get e set Nota fiscal*/
	public String getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	/*get e set Preço total*/
	public double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(double nPrecoTotal) {
		precoTotal = nPrecoTotal;
	}
	
	/*get e set Data de Venda*/
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date nDataVenda) {
		dataVenda = nDataVenda;
	}
	
	/*get e set Hora da Venda*/
	public Time getHoraVenda() {
		return horaVenda;
	}
	public void setHoraVenda(Time horaVenda) {
		this.horaVenda = horaVenda;
	}
	
	/*get e set Codigo do funcionario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}
	
	/*get e set Cargo do funcionario*/
	public String getCargoFuncionario() {
		return cargoFuncionario;
	}
	public void setCargoFuncionario(String nCargoFuncionario) {
		cargoFuncionario = nCargoFuncionario;
	}
	
	/*get e set CPF do cliente*/
	public String getCPFCliente() {
		return cpfCliente;
	}
	public void setCPFCliente(String nCPFCliente) {
		cpfCliente = nCPFCliente;
	}
	
	
	/*get e set Codigo do cliente*/
	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	
	/*get e set Preço total da venda com desconto incluso*/
	public double getPrecoTotalDesconto() {
		return precoTotalDesconto;
	}
	public void setPrecoTotalDesconto(double precoTotalDesconto) {
		this.precoTotalDesconto = precoTotalDesconto;
	}
	
	
	/*get e set Valor da porcentagem do desconto*/
	public double getDescontoPorcentagem() {
		return descontoProcentagem;
	}
	public void setDescontoPorcentagem(double descontoProcentagem) {
		this.descontoProcentagem = descontoProcentagem;
	}
	
	
	/*get e set Preço de cada parcela*/
	public double getPrecoTotalParcelado() {
		return precoTotalParcelado;
	}
	public void setPrecoTotalParcelado(double precoTotalParcelado) {
		this.precoTotalParcelado = precoTotalParcelado;
	}
	
	/*get e set Quantidade de parcelas*/
	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	public void setQuantidadeParcelas(int quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
}