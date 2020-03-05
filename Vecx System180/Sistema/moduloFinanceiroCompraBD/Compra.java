package moduloFinanceiroCompraBD;

import java.sql.Date;
import java.sql.Time;

public class Compra {
	
	private String nomeFuncionario, tipoPagamento, metodoPagamento, codigoCompra, notaFiscal, codigoFuncionario, cargoFuncionario;
	private double precoTotal, precoTotalDesconto, descontoPorcentagem, precoTotalParcelado;
	private int quantidadeParcelas;
	private Date dataCompra;
	private Time horaCompra;
	
	/*Construtor da classe*/
	public Compra() {
		
	}
	
	Compra(String nomeFuncionario, String codigoBarras, String tipoPagamento,String notaFiscal,String metodoPagamento, String codigoCompra,
			String codigoFuncionario, String cargoFuncionario, Time horaCompra, double precoTotalDesconto, double descontoPorcentagem,
			double precoTotalParcelado,	int quantidadeParcelas, double precoTotal, Date dataCompra) {
				this.nomeFuncionario = nomeFuncionario;
				this.horaCompra = horaCompra;
				this.tipoPagamento = tipoPagamento;
				this.metodoPagamento = metodoPagamento;
				this.codigoCompra = codigoCompra;
				this.notaFiscal = notaFiscal;
				this.precoTotal = precoTotal;
				this.dataCompra = dataCompra;
				this.codigoFuncionario = codigoFuncionario;
				this.cargoFuncionario = cargoFuncionario;
				this.precoTotalDesconto = precoTotalDesconto;
				this.descontoPorcentagem = descontoPorcentagem;
				this.precoTotalParcelado = precoTotalParcelado;
				this.quantidadeParcelas = quantidadeParcelas;
	}
	
	/*Metodos get e set */	
	/*get e set Nome do funcionario*/
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nNomefuncionario) {
		nomeFuncionario = nNomefuncionario;
	}
	
	/*get e set Nota fiscal*/
	public String getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(String nNotaFiscal) {
		notaFiscal = nNotaFiscal;
	}
	
	/*get e set Codigo da compra*/
	public String getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(String nCodigoCompra) {
		codigoCompra = nCodigoCompra;
	}

	/*get e set tipoPagamento*/
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String nTipoPagamento) {
		tipoPagamento = nTipoPagamento;
	}
	
	/*get e set Metodo de pagamento*/
	public String getMetodoPagamento() {
		return metodoPagamento;
	}
	public void setMetodoPagamento(String nMetodoPagamento) {
		this.metodoPagamento = nMetodoPagamento;
	}
	
	/*get e set Preço total*/
	public double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(double nPrecoTotal) {
		precoTotal = nPrecoTotal;
	}
	
	/*get e set Data de compra*/
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date nDataCompra) {
		dataCompra = nDataCompra;
	}
	
	/*get e set Hora de compra*/
	public Time getHoraCompra() {
		return horaCompra;
	}
	public void setHoraCompra(Time nHoraCompra) {
		horaCompra = nHoraCompra;
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
	
	/*get e set Preço total com desconto*/
	public double getPrecoTotalDesconto() {
		return precoTotalDesconto;
	}
	public void setPrecoTotalDesconto(double nPrecoTotalDesconto) {
		precoTotalDesconto = nPrecoTotalDesconto;
	}
	
	/*get e set Valor da porcentagem do desconto*/
	public double getDescontoPorcentagem() {
		return descontoPorcentagem;
	}
	public void setDescontoPorcentagem(double nDescontoPorcentagem) {
		descontoPorcentagem = nDescontoPorcentagem;
	}
	
	/*get e set Preço de cada parcela*/
	public double getPrecoTotalParcelado() {
		return precoTotalParcelado;
	}
	public void setPrecoTotalParcelado(double nPrecoTotalParcelado) {
		precoTotalParcelado = nPrecoTotalParcelado;
	}
	
	/*get e set Quantidade de parcelas*/
	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	public void setQuantidadeParcelas(int nQuantidadeParcelas) {
		quantidadeParcelas = nQuantidadeParcelas;
	}
}