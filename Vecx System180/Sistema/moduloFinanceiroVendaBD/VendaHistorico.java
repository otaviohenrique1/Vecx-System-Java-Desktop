package moduloFinanceiroVendaBD;

import java.sql.Date;
import java.sql.Time;

public class VendaHistorico {
	
	private String nomeFuncionario,nomeCliente, codigoVenda;
	private double precoTotal;
	private Date dataVenda;
	private Time horaVenda;
	
	/*Construtor da classe*/
	public VendaHistorico(){
		
	}
	
	VendaHistorico(String codigoVenda, String nomeCliente, String nomeFuncionario, double precoTotal, Date dataVenda, Time horaVenda) {
		this.nomeFuncionario = nomeFuncionario;
		this.nomeCliente = nomeCliente;
		this.codigoVenda = codigoVenda;
		this.precoTotal = precoTotal;
		this.dataVenda = dataVenda;
		this.horaVenda = horaVenda;
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
}