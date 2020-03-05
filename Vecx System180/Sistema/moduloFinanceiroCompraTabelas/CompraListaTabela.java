package moduloFinanceiroCompraTabelas;

public class CompraListaTabela {
	private String codigo, nome, quantidade, preco, precoQuantidade, fornecedor;
	
	/*Construtor da classe*/
	public CompraListaTabela() {
		
	}
	
	public CompraListaTabela(String codigo, String nome, String quantidade, String preco, String precoQuantidade, String fornecedor) {
		this.nome = nome;
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.preco = preco;
		this.precoQuantidade = precoQuantidade;
		this.fornecedor = fornecedor;
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
	
	/*get e set Fornecedor do produto*/
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String nFornecedor) {
		this.fornecedor = nFornecedor;
	}
	
	
	/*get e set Preço x Quantidade*/
	public String getPrecoQuantidade() {
		return precoQuantidade;
	}
	public void setPrecoQuantidade(String precoQuantidade) {
		this.precoQuantidade = precoQuantidade;
	}
}