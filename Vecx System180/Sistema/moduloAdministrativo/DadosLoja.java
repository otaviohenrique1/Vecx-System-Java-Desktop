package moduloAdministrativo;

import java.sql.Time;
import java.sql.Date;

public class DadosLoja {
	private String nome, razaoSocial, inscricaoEstadual, inscricaoNumero, email1, email2, endereco, estado, cidade, bairro, pais, complemento, referencia;
	private String cnpj, cpf, telefone1, telefone2, celular1, celular2, cep, nacionalidade, numero, estadoDadosLoja;
	private Date dataCadastro;
	private Time horaCadastro;
	
	/*Construtor da classe*/
	public DadosLoja() {
		
	}
	
	DadosLoja(String nome,String razaoSocial, String inscricaoEstadual, String inscricaoNumero, String email1, String email2, String endereco, 
				String estado, String cidade, String bairro, String complemento, String referencia, String pais, String nacionalidade,
				String cpf, String cnpj, String telefone1, String telefone2, String celular1, String celular2, String cep, String estadoDadosLoja,
				String numero, Date dataCadastro, Time horaCadastro){
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
					this.numero = numero;
					this.dataCadastro = dataCadastro;
					this.horaCadastro = horaCadastro;
					this.estadoDadosLoja = estadoDadosLoja;
	}
	
	/*Metodos get e set */
	/*get e set Nome*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nNome) {
		nome = nNome;
	}
	
	/*get e set Razão social*/
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String nRazaoSocial) {
		razaoSocial = nRazaoSocial;
	}
	
	/*get e set Email1*/
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String nEmail1) {
		email1 = nEmail1;
	}
	
	/*get e set Email2*/
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String nEmail2) {
		email2 = nEmail2;
	}
	
	/*get e set Inscrição estadual*/
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String nInscricaoEstadual) {
		inscricaoEstadual = nInscricaoEstadual;
	}
	
	/*get e set Inscrição estadual numero*/
	public String getInscricaoNumero() {
		return inscricaoNumero;
	}
	public void setInscricaoNumero(String nInscricaoNumero) {
		inscricaoNumero = nInscricaoNumero;
	}
	
	/*get e set Endereco*/
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String nEndereco) {
		endereco = nEndereco;
	}
	
	/*get e set Estado*/
	public String getEstado() {
		return estado;
	}
	public void setEstado(String nEstado) {
		estado = nEstado;
	}
	
	/*get e set Cidade*/
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String nCidade) {
		cidade = nCidade;
	}
	
	/*get e set Bairro*/
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String nBairro) {
		bairro = nBairro;
	}
	
	/*get e set Complemento*/
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String nComplemento) {
		complemento = nComplemento;
	}
	
	/*get e set Pais*/
	public String getPais() {
		return pais;
	}
	public void setPais(String nPais) {
		pais = nPais;
	}
	
	/*get e set Referencia*/
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String nReferencia) {
		referencia = nReferencia;
	}
	
	/*get e set CPF*/
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String nCPF) {
		cpf = nCPF;
	}
	
	/*get e set CNPJ*/
	public String getCNPJ() {
		return cnpj;
	}
	public void setCNPJ(String nCNPJ) {
		cnpj = nCNPJ;
	}
	
	/*get e set Telefone1*/
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String nTelefone1) {
		telefone1 = nTelefone1;
	}
	
	/*get e set Telefone2*/
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String nTelefone2) {
		telefone2 = nTelefone2;
	}
	
	/*get e set Celular1*/
	public String getCelular1() {
		return celular1;
	}
	public void setCelular1(String nCelular) {
		celular1 = nCelular;
	}
	
	/*get e set Celular2*/
	public String getCelular2() {
		return celular2;
	}
	public void setCelular2(String nCelular2) {
		celular2 = nCelular2;
	}
	
	/*get e set CEP*/
	public String getCEP() {
		return cep;
	}
	public void setCEP(String nCEP) {
		cep = nCEP;
	}
	
	/*get e set Nacionalidade*/
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nNacionalidade) {
		nacionalidade = nNacionalidade;
	}
	
	/*get e set Numero*/
	public String getNumero() {
		return numero;
	}
	public void setNumero(String nNumero) {
		numero = nNumero;
	}
	
	/*get e set Data de cadastro*/
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date nDataCadastro) {
		dataCadastro = nDataCadastro;
	}
	
	/*get e set Hora de cadastro*/
	public Time getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(Time nHoraCadastro) {
		horaCadastro = nHoraCadastro;
	}
	
	/*get e set Estado dados loja*/
	public String getEstadoDadosLoja() {
		return estadoDadosLoja;
	}
	public void setEstadoDadosLoja(String nEstadoDadosLoja) {
		estadoDadosLoja = nEstadoDadosLoja;
	}
}