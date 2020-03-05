package moduloProdutoBD;

public class EstoqueProdutos {
	private String codigoProduto, nome, lote, estadoProduto, quantidadeUnidade;
	private double quantidade, precoaVista;
	
	/*Construtor da classe*/
	public EstoqueProdutos() {
		
	}
	
	EstoqueProdutos(String nome, String marca, String lote,  String codigoProduto, String estadoProduto, double precoaVista, int quantidade, String quantidadeUnidade){
				
				this.nome = nome;
				this.lote = lote;
				this.precoaVista = precoaVista;
				this.quantidade = quantidade;
				this.quantidadeUnidade = quantidadeUnidade;
				this.codigoProduto = codigoProduto;
				this.estadoProduto = estadoProduto;
	}
	
	/*Metodos get e set */
	/*get e set Nome*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nNome) {
		this.nome = nNome;
	}
	
	/*get e set Lote*/
	public String getLote() {
		return lote;
	}
	public void setLote(String nLote) {
		this.lote = nLote;
	}
	
	/*get e set Preço a vista*/
	public double getPrecoaVista() {
		return precoaVista;
	}
	public void setPrecoaVista(double nPrecoaVista) {
		this.precoaVista = nPrecoaVista;
	}
	
	/*get e set Quantidade*/
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double nQuantidade) {
		this.quantidade = nQuantidade;
	}
	
	/*get e set Quantidade unidade*/
	public String getQuantidadeUnidade() {
		return quantidadeUnidade;
	}
	public void setQuantidadeUnidade(String nQuantidadeUnidade) {
		quantidadeUnidade = nQuantidadeUnidade;
	}
	
	/*get e set Codigo do Produto*/
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String nCodigoProduto) {
		this.codigoProduto = nCodigoProduto;
	}
	
	/*get e set Estado do produto*/
	public String getEstadoProduto() {
		return estadoProduto;
	}
	public void setEstadoProduto(String nEstadoProduto) {
		this.estadoProduto = nEstadoProduto;
	}
}