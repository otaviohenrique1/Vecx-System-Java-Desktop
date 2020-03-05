package moduloFinanceiroVendaTabelas;

public class VendaListaTabela {
	private String codigo, nome, quantidade, preco, precoQuantidade;

	/*Construtor da classe*/
	public VendaListaTabela(String codigo, String nome, String quantidade, String preco, String precoQuantidade) {
		this.nome = nome;
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.preco = preco;
		this.precoQuantidade = precoQuantidade;
	}
	
	/*get e set Codigo do produto*/
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String nCodigo) {
		codigo = nCodigo;
	}
	
	/*get e set Nome do produto*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nNome) {
		nome = nNome;
	}
	
	/*get e set Quantidade*/
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String nQuantidade) {
		quantidade = nQuantidade;
	}
	
	/*get e set Preço*/
	public String getPreco() {
		return preco;
	}
	public void setPreco(String nPreco) {
		preco = nPreco;
	}
	
	/*get e set Preço x Quantidade*/
	public String getPrecoQuantidade() {
		return precoQuantidade;
	}
	public void setPrecoQuantidade(String precoQuantidade) {
		this.precoQuantidade = precoQuantidade;
	}
}