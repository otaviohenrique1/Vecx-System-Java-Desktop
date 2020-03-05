package moduloFornecedorTabelas;

public class FornecedoresTabela {
	private String nomeFornecedor, codigoFornecedor, cnpj;
	
	/*Construtor da classe*/
	public FornecedoresTabela(String codigoFornecedor, String nomeFornecedor, String cnpj) {
		this.nomeFornecedor = nomeFornecedor;
		this.codigoFornecedor = codigoFornecedor;
		this.cnpj = cnpj;
	}
	
	/*Metodos set e get*/
	/*set e get Nome do fornecedor*/
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nNomeFornecedor) {
		nomeFornecedor = nNomeFornecedor;
	}
	
	/*set e get Codigo do fornecedor*/
	public String getCodigoFornecedor() {
		return codigoFornecedor;
	}
	public void setCodigoFornecedor(String nCodigoFornecedor) {
		codigoFornecedor = nCodigoFornecedor;
	}
	
	/*set e get CNPJ do fornecedor*/
	public String getCNPJ() {
		return cnpj;
	}
	public void CNPJ(String nCNPJ) {
		cnpj = nCNPJ;
	}
}