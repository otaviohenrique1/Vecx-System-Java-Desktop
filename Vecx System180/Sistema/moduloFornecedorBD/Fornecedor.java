package moduloFornecedorBD;

import java.sql.Date;
import java.sql.Time;

public class Fornecedor {
	private String nome, razaoSocial, inscricaoEstadual, inscricaoNumero, email1, email2, endereco, estado, cidade, bairro, pais, complemento, referencia, tipoComercio;
	private String cnpj, cpf, telefone1, telefone2, celular1, celular2, cep, nacionalidade, tipoFornecedor, funcionarioCadastro, codigoFuncionario;
	private String codigoFornecedor, numero, cargoFuncionario;
	private Date dataCadastro;
	private Time horaCadastro;
	
	/*Construtor da classe*/
	public Fornecedor() {
		
	}
	
	Fornecedor(String nome,String razaoSocial, String inscricaoEstadual, String inscricaoNumero, String email1, String email2, String tipoComercio,
			String endereco, String estado, String cidade, String bairro, String complemento, String referencia, String pais, String nacionalidade,
			String tipoFornecedor, String cpf, String cnpj, String telefone1, String telefone2, String celular1, String celular2, String cep,
			String funcionarioCadastro, String codigoFuncionario, String codigoFornecedor, String numero, String cargoFuncionario, 
			Date dataCadastro, Time horaCadastro){
				this.nome = nome;
				this.razaoSocial = razaoSocial;
				this.email1 = email1;
				this.email2 = email2;
				this.inscricaoEstadual = inscricaoEstadual;
				this.inscricaoNumero = inscricaoNumero;
				this.endereco = endereco;
				this.estado = estado;
				this.cidade = cidade;
				this.bairro = bairro;
				this.pais = pais;
				this.tipoComercio = tipoComercio;
				this.complemento = complemento;
				this.referencia = referencia;
				this.cpf = cpf;
				this.cnpj = cnpj;
				this.telefone1 = telefone1;
				this.telefone2 = telefone2;
				this.celular1 = celular1;
				this.celular2 = celular2;
				this.cep = cep;
				this.nacionalidade = nacionalidade;
				this.tipoFornecedor = tipoFornecedor;
				this.funcionarioCadastro = funcionarioCadastro; 
				this.codigoFuncionario = codigoFuncionario;
				this.cargoFuncionario = cargoFuncionario;
				this.codigoFornecedor = codigoFornecedor;
				this.dataCadastro = dataCadastro;
				this.horaCadastro = horaCadastro;
				this.numero = numero;
	}
	
	/*Metodos get e set */
	/*get e set Nome*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nNome) {
		this.nome = nNome;
	}
	
	/*get e set Razão social*/
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String nRazaoSocial) {
		this.razaoSocial = nRazaoSocial;
	}
	
	/*get e set Email1*/
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String nEmail1) {
		this.email1 = nEmail1;
	}
	
	/*get e set Email2*/
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String nEmail2) {
		this.email2 = nEmail2;
	}
	
	/*get e set Inscrição estadual*/
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String nInscricaoEstadual) {
		this.inscricaoEstadual = nInscricaoEstadual;
	}
	
	/*get e set Inscrição estadual numero*/
	public String getInscricaoNumero() {
		return inscricaoNumero;
	}
	public void setInscricaoNumero(String nInscricaoNumero) {
		this.inscricaoNumero = nInscricaoNumero;
	}
	
	/*get e set Endereco*/
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String nEndereco) {
		this.endereco = nEndereco;
	}
	
	/*get e set Estado*/
	public String getEstado() {
		return estado;
	}
	public void setEstado(String nEstado) {
		this.estado = nEstado;
	}
	
	/*get e set Cidade*/
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String nCidade) {
		this.cidade = nCidade;
	}
	
	/*get e set Bairro*/
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String nBairro) {
		this.bairro = nBairro;
	}
	
	/*get e set Complemento*/
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String nComplemento) {
		this.complemento = nComplemento;
	}
	
	/*get e set Pais*/
	public String getPais() {
		return pais;
	}
	public void setPais(String nPais) {
		this.pais = nPais;
	}
	
	/*get e set Referencia*/
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String nReferencia) {
		this.referencia = nReferencia;
	}
	
	/*get e set TipoComercio*/
	public String getTipoComercio() {
		return tipoComercio;
	}
	public void setTipoComercio(String nTipocomercio) {
		this.tipoComercio = nTipocomercio;
	}
	
	/*get e set CPF*/
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String nCPF) {
		this.cpf = nCPF;
	}
	
	/*get e set CNPJ*/
	public String getCNPJ() {
		return cnpj;
	}
	public void setCNPJ(String nCNPJ) {
		this.cnpj = nCNPJ;
	}
	
	/*get e set Telefone1*/
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String nTelefone1) {
		this.telefone1 = nTelefone1;
	}
	
	/*get e set Telefone2*/
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String nTelefone2) {
		this.telefone2 = nTelefone2;
	}
	
	/*get e set Celular1*/
	public String getCelular1() {
		return celular1;
	}
	public void setCelular1(String nCelular) {
		this.celular1 = nCelular;
	}
	
	/*get e set Celular2*/
	public String getCelular2() {
		return celular2;
	}
	public void setCelular2(String nCelular2) {
		this.celular2 = nCelular2;
	}
	
	/*get e set CEP*/
	public String getCEP() {
		return cep;
	}
	public void setCEP(String nCEP) {
		this.cep = nCEP;
	}
	
	/*get e set Nacionalidade*/
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nNacionalidade) {
		this.nacionalidade = nNacionalidade;
	}
	
	/*get e set Tipo de fornecedor*/
	public String getTipoFornecedor() {
		return tipoFornecedor;
	}
	public void setTipoFornecedor(String nTipoFornecedor) {
		this.tipoFornecedor = nTipoFornecedor;
	}
	
	/*get e set No0me do funcionario*/
	public String getFuncionarioCadastro() {
		return funcionarioCadastro;
	}
	public void setFuncionarioCadastro(String nFuncionarioCadastro) {
		this.funcionarioCadastro = nFuncionarioCadastro;
	}
	
	/*get e set Codigo do funcionario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		this.codigoFuncionario = nCodigoFuncionario;
	}
	
	/*get e set Cargo do funcionario*/
	public String getCargoFuncionario() {
		return cargoFuncionario;
	}
	public void setCargoFuncionario(String cargoFuncionario) {
		this.cargoFuncionario = cargoFuncionario;
	}
	
	/*get e set Codigo do fornecedor*/
	public String getCodigoFornecedor() {
		return codigoFornecedor;
	}
	public void setCodigoFornecedor(String nCodigoFornecedor) {
		this.codigoFornecedor = nCodigoFornecedor;
	}
	
	/*get e set Numero*/
	public String getNumero() {
		return numero;
	}
	public void setNumero(String nNumero) {
		this.numero = nNumero;
	}
	
	/*get e set Data de cadastro*/
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date nDataCadastro) {
		this.dataCadastro = nDataCadastro;
	}
	
	/*get e set Hora de cadastro*/
	public Time getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(Time nHoraCadastro) {
		this.horaCadastro = nHoraCadastro;
	}
}