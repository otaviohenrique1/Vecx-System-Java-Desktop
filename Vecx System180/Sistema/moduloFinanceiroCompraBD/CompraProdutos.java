package moduloFinanceiroCompraBD;

import java.sql.Date;
import java.sql.Time;

public class CompraProdutos {
	
	private String nomeProduto, codigoBarras, codigoProduto, codigoCompra, fornecedor;
	private double precoCompra, precoQuantidade, icms, quantidade;
	private Date dataCompra;
	private Time horaCompra;
	
	/*Construtor da classe*/
	public CompraProdutos() {
		
	}
	
	CompraProdutos(String codigoProduto, String nomeProduto, String codigoCompra, String fornecedor, double icms, double quantidade, double precoCompra, double precoQuantidade,
					Date dataCompra, Time horaCompra, String codigoBarras) {
						this.codigoCompra = codigoCompra;
						this.nomeProduto = nomeProduto;
						this.codigoBarras = codigoBarras;
						this.codigoProduto = codigoProduto;
						this.quantidade = quantidade;
						this.icms = icms;
						this.precoCompra = precoCompra;
						this.precoQuantidade = precoQuantidade;
						this.fornecedor = fornecedor;
						this.dataCompra = dataCompra;
						this.horaCompra = horaCompra;
	}
	
	/*Metodos get e set */
	/*get e set Codigo da compra*/
	public String getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(String nCodigoCompra) {
		codigoCompra = nCodigoCompra;
	}
	
	/*get e set Nome do produto*/
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nNomeproduto) {
		nomeProduto = nNomeproduto;
	}
	
	/*get e set Codigo de barras*/
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String nCodigoBarras) {
		codigoBarras = nCodigoBarras;
	}
	
	/*get e set Codigo do produto*/
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String nCodigoProduto) {
		codigoProduto = nCodigoProduto;
	}

	/*get e set ICMS*/
	public double getICMS() {
		return icms;
	}
	public void setICMS(double nICMS) {
		icms = nICMS;
	}
	
	/*get e set Quantidade*/
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double nQuantidade) {
		quantidade = nQuantidade;
	}
	
	/*get e set Preco de compra do produto*/
	public double getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(double nPrecoCompra) {
		precoCompra = nPrecoCompra;
	}
	
	/*get e set Fornecedor*/
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String nFornecedor) {
		fornecedor = nFornecedor;
	}
	
	
	/*get e set Preço x Quantidade*/
	public double getPrecoQuantidade() {
		return precoQuantidade;
	}
	public void setPrecoQuantidade(double precoQuantidade) {
		this.precoQuantidade = precoQuantidade;
	}
	
	/*get e set Data da compra*/
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date nDataCompra) {
		dataCompra = nDataCompra;
	}
	
	/*get e set Hora da compra*/
	public Time getHoraCompra() {
		return horaCompra;
	}
	public void setHoraCompra(Time nHoraCompra) {
		horaCompra = nHoraCompra;
	}
}