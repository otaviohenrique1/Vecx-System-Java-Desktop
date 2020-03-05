package moduloProdutoTabelas;

public class EstoqueTabela {
	private String codigoProduto, nome, lote, quantidade, precoaVista;
	
	/*Construtor da classe*/
	public EstoqueTabela(String codigoProduto, String nome, String quantidade, String precoaVista, String lote){
				this.nome = nome;
				this.lote = lote;
				this.precoaVista = precoaVista;
				this.quantidade = quantidade;
				this.codigoProduto = codigoProduto;
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
	public String getPrecoaVista() {
		return precoaVista;
	}
	public void setPrecoaVista(String nPrecoaVista) {
		this.precoaVista = nPrecoaVista;
	}
	
	/*get e set Quantidade*/
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String nQuantidade) {
		this.quantidade = nQuantidade;
	}
	
	/*get e set Codigo do produto*/
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String nCodigoProduto) {
		this.codigoProduto = nCodigoProduto;
	}
}