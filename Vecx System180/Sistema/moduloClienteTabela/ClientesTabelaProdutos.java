package moduloClienteTabela;

public class ClientesTabelaProdutos {
	
	private String nomeProduto, codigoProduto; 
	private int quantidadeComprada;
	private double precoUnitario;
	
	/*Construtor da classe*/
	public ClientesTabelaProdutos(String codigoProduto, String nomeProduto, int quantidadeComprada, double precoUnitario) {
		this.nomeProduto = nomeProduto;
		this.codigoProduto = codigoProduto;
		this.quantidadeComprada = quantidadeComprada;
		this.precoUnitario = precoUnitario;
	}
	
	/*Metodos get e set */
	/*get e set Nome do produto*/
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nNomeProduto) {
		nomeProduto = nNomeProduto;
	}
	
	/*get e set Codigo do produto*/
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String nCodigoProduto) {
		codigoProduto = nCodigoProduto;
	}
	
	/*get e set Quantidade*/
	public int getQuantidadeComprada() {
		return quantidadeComprada;
	}
	public void setQuantidadeComprada(int nQuantidadeComprada) {
		quantidadeComprada = nQuantidadeComprada;
	}
	
	/*get e set Preço do produto*/
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double nPrecoUnitario) {
		precoUnitario = nPrecoUnitario;
	}
}