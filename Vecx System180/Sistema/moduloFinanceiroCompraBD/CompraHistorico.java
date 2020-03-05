package moduloFinanceiroCompraBD;

import java.sql.Date;
import java.sql.Time;

public class CompraHistorico {
	
	private String nomeFuncionario,codigoCompra;
	private double precoTotal;
	private Date dataCompra;
	private Time horaCompra;
	
	/*Construtor da classe*/
	public CompraHistorico() {
		
	}
	
	CompraHistorico(String nomeFuncionario, String codigoCompra, double precoTotal, Time horaCompra, Date dataCompra) {
		this.nomeFuncionario = nomeFuncionario;
		this.horaCompra = horaCompra;
		this.codigoCompra = codigoCompra;
		this.precoTotal = precoTotal;
		this.dataCompra = dataCompra;
	}
	
	/*Metodos get e set */	
	/*get e set Nome do funcionario*/
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nNomefuncionario) {
		this.nomeFuncionario = nNomefuncionario;
	}
	
	/*get e set Codigo da compra*/
	public String getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(String nCodigoCompra) {
		this.codigoCompra = nCodigoCompra;
	}
	
	/*get e set Preço total*/
	public double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(double nPrecoTotal) {
		this.precoTotal = nPrecoTotal;
	}
	
	/*get e set Data de compra*/
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date nDataCompra) {
		this.dataCompra = nDataCompra;
	}
	
	/*get e set Hora de compra*/
	public Time getHoraCompra() {
		return horaCompra;
	}
	public void setHoraCompra(Time horaCompra) {
		this.horaCompra = horaCompra;
	}
}