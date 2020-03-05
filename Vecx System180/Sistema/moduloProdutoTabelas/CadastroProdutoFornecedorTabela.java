package moduloProdutoTabelas;

public class CadastroProdutoFornecedorTabela {
	private String fornecedorNome, fornecedorCNPJ;

	/*Construtor da classe*/
	public CadastroProdutoFornecedorTabela(String fornecedorNome, String fornecedorCNPJ) {
		this.fornecedorNome = fornecedorNome;
		this.fornecedorCNPJ = fornecedorCNPJ;
	}
	
	/*Metodos get e set*/
	/*get e set Nome do fornecedor*/
	public String getFornecedorNome() {
		return fornecedorNome;
	}
	public void setFornecedorNome(String nFornecedorNome) {
		fornecedorNome = nFornecedorNome;
	}
	
	/*get e set CNPJ do fornecedor*/
	public String getFornecedorCNPJ() {
		return fornecedorCNPJ;
	}
	public void setFornecedorCNPJ(String nFornecedorCNPJ) {
		fornecedorCNPJ = nFornecedorCNPJ;
	}	
}