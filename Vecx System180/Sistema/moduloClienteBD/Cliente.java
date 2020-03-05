package moduloClienteBD;

import java.sql.Date;
import java.sql.Time;

public class Cliente {
	private String nome, sexo, email1, email2, estadoCivil, endereco, estado, cidade, bairro, complemento, referencia;
	private String cpf, rg, telefone1, telefone2, celular1, celular2, cep, funcionarioCadastro, numero;
	private String nacionalidade, paisOrigem, codigoCliente, codigoFuncionario, cargoFuncionario;
	private Date dataNascimento, dataCadastro;
	private Time horaCadastro;
	
	/*Construtor da classe*/
	public Cliente() {
		
	}
	
	Cliente(String nome,String sexo, String email1, String email2, String estadoCivil, String endereco, String estado, String cidade, String bairro,
			String complemento, String referencia, String cpf, String rg, String telefone1, String telefone2, String celular1, String celular2, String cep,
			String funcionarioCadastro, String nacionalidade, String paisOrigem, String codigoCliente, String numero, String codigoFuncionario, String cargoFuncionario,
			Date dataNascimento, Date dataCadastro, Time horaCadastro){
		
			this.nome = nome;
			this.sexo = sexo;
			this.email1 = email1;
			this.email2 = email2;
			this.estadoCivil = estadoCivil;
			this.endereco = endereco;
			this.estado = estado;
			this.cidade = cidade;
			this.bairro = bairro;
			this.complemento = complemento;
			this.referencia = referencia;
			this.cpf = cpf;
			this.rg = rg;
			this.telefone1 = telefone1;
			this.telefone2 = telefone2;
			this.celular1 = celular1;
			this.celular2 = celular2;
			this.cep = cep;
			this.funcionarioCadastro = funcionarioCadastro;
			this.codigoFuncionario = codigoFuncionario;
			this.cargoFuncionario = cargoFuncionario;
			this.nacionalidade = nacionalidade;
			this.paisOrigem = paisOrigem;
			this.codigoCliente = codigoCliente;
			this.numero = numero;
			this.dataNascimento = dataNascimento;
			this.dataCadastro = dataCadastro;
			this.horaCadastro = horaCadastro;
			
	}
	
	/*Metodos get e set */
	/*get e set Nome*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nNome) {
		this.nome = nNome;
	}
	
	/*get e set Sexo*/
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String nSexo) {
		this.sexo = nSexo;
	}
	
	/*get e set Email 1*/
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String nEmail1) {
		this.email1 = nEmail1;
	}
	
	/*get e set Email 2*/
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String nEmail2) {
		this.email2 = nEmail2;
	}
	
	/*get e set EstadoCivil*/
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String nEstadoCivil) {
		this.estadoCivil = nEstadoCivil;
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
	
	/*get e set Referencia*/
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String nReferencia) {
		this.referencia = nReferencia;
	}
	
	/*get e set CPF*/
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String nCPF) {
		this.cpf = nCPF;
	}
	
	/*get e set RG*/
	public String getRG() {
		return rg;
	}
	public void setRG(String nRG) {
		this.rg = nRG;
	}
	
	/*get e set Telefone 1*/
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String nTelefone1) {
		this.telefone1 = nTelefone1;
	}
	
	/*get e set Telefone 2*/
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String nTelefone2) {
		this.telefone2 = nTelefone2;
	}
	
	/*get e set Celular 1*/
	public String getCelular1() {
		return celular1;
	}
	public void setCelular1(String nCelular1) {
		this.celular1 = nCelular1;
	}
	
	/*get e set Celular 2*/
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
	
	/*get e set Funcionario que cadastrou o cliente*/
	public String getFuncionarioCadastro() {
		return funcionarioCadastro;
	}
	public void setFuncionarioCadastro(String nFuncionarioCadastro) {
		this.funcionarioCadastro = nFuncionarioCadastro;
	}
	
	/*get e set Codigo do funcioario*/
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
	
	/*get e set Nacionalidade*/
	public String getNacionalidade() {
		return nacionalidade;
	}
	/*get e set Celular 2*/
	public void setNacionalidade(String nNacionalidade) {
		this.nacionalidade = nNacionalidade;
	}
	
	/*get e set Pais de origem*/
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String nPaisOrigem) {
		this.paisOrigem = nPaisOrigem;
	}
	
	/*get e set Codigo do cliente*/
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	/*get e set Numero*/
	public String getNumero() {
		return numero;
	}
	public void setNumero(String nNumero) {
		this.numero = nNumero;
	}
	
	/*get e set Data de nascimento*/
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date nDataNascimento) {
		this.dataNascimento = nDataNascimento;
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