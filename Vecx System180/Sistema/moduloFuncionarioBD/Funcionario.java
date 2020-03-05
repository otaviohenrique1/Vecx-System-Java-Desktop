package moduloFuncionarioBD;
import java.sql.Time;
import java.sql.Date;

public class Funcionario{
	private String nome, sexo, email1, email2, estadoCivil, endereco, estado, cidade, bairro, complemento, referencia;
	private String cargo, login, senha, carteiraTrabalho, nacionalidade, paisOrigem, escolaridade;
	private String nomeBanco, formaPagamento, nomeMae, nomePai, tipoTrabalho, cargaHoraria, cargaHorariaUnidade, cpf, rg;
	private String telefone1, telefone2, celular1, celular2, cep, numero, codigoFuncionario;
	private Date dataNascimento, dataAdmissao, dataDemissao, dataCadastro;
	private Time horaEntrada, horaSaida, horaCadastro;
	private double salario;
	private int limiteFaltas;
	
	/*Construtor da classe*/
	public Funcionario() {
		
	}
	
	Funcionario(String cargo,String senha,String carteiraTrabalho,String estadoCivil, String codigoFuncionario,
				String nome,String sexo,String email1,String email2,String endereco,String estado,String cidade,String bairro,String complemento,String referencia,
				String login, String nacionalidade, String paisOrigem, String escolaridade, String nomeBanco, String formaPagamento, String nomeMae, String nomePai,
				String tipoTrabalho, String cargaHoraria, double salario,String cpf, String rg, String telefone1, String telefone2, String celular1, String celular2, 
				String cep, String numero, String cargaHorariaUnidade, Date dataNascimento, Date dataAdmissao, Date dataDemissao, Date dataCadastro, Time horaEntrada,
				Time horaSaida, Time horaCadastro, int limiteFaltas){
					this.nome = nome;
					this.codigoFuncionario = codigoFuncionario;
					this.dataCadastro = dataCadastro;
					this.horaCadastro = horaCadastro;
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
					this.escolaridade = escolaridade;
					this.cpf = cpf;
					this.rg = rg;
					this.telefone1 = telefone1;
					this.telefone2 = telefone2;
					this.celular1 = celular1;
					this.celular2 = celular2;
					this.cep = cep;
					this.numero = numero;
					this.nacionalidade = nacionalidade;
					this.paisOrigem = paisOrigem;
					this.tipoTrabalho = tipoTrabalho;
					this.dataNascimento = dataNascimento;
					this.dataAdmissao = dataAdmissao;
					this.dataDemissao = dataDemissao;
					this.horaEntrada = horaEntrada;
					this.horaSaida = horaSaida;
					this.cargaHoraria = cargaHoraria;
					this.cargaHorariaUnidade = cargaHorariaUnidade;
					this.cargo = cargo;
					this.login = login;
					this.senha = senha;
					this.carteiraTrabalho = carteiraTrabalho;
					this.salario = salario;
					this.nomeBanco = nomeBanco;
					this.formaPagamento = formaPagamento;
					this.nomeMae = nomeMae;
					this.nomePai = nomePai;
					this.limiteFaltas = limiteFaltas;
	}
	
	/*Metodos get e set */
	/*get e set Nome*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nNome) {
		nome = nNome;
	}
	
	/*get e set Codigo do funcionario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}	
	
	/*get e set Data de cadastro*/
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date nDataCadastro) {
		dataCadastro = nDataCadastro;
	}
	
	/*get e set Sexo*/
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String nSexo) {
		sexo = nSexo;
	}
	
	/*get e set Email 1*/
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String nEmail1) {
		email1 = nEmail1;
	}
	
	/*get e set Email 2*/
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String nEmail2) {
		email2 = nEmail2;
	}
	
	/*get e set EstadoCivil*/
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String nEstadoCivil) {
		estadoCivil = nEstadoCivil;
	}
	
	/*get e set Nacionalidade*/
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nNacionalidade) {
		nacionalidade = nNacionalidade;
	}
	
	/*get e set Pais de origem*/
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String nPaisOrigem) {
		paisOrigem = nPaisOrigem;
	}
	
	/*get e set Escolaridade*/
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String nEscolaridade) {
		escolaridade = nEscolaridade;
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
	
	/*get e set RG*/
	public String getRG() {
		return rg;
	}
	public void setRG(String nRG) {
		rg = nRG;
	}
	
	/*get e set Telefone 1*/
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String nTelefone1) {
		telefone1 = nTelefone1;
	}
	
	/*get e set Telefone 2*/
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String nTelefone2) {
		telefone2 = nTelefone2;
	}
	
	/*get e set Celular 1*/
	public String getCelular1() {
		return celular1;
	}
	public void setCelular1(String nCelular1) {
		celular1 = nCelular1;
	}
	
	/*get e set Celular 2*/
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
	
	/*get e set Numero*/
	public String getNumero() {
		return numero;
	}
	public void setNumero(String nNumero) {
		numero = nNumero;
	}
	/*get e set Noime da Mãe*/	
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nNomeMae) {
		this.nomeMae = nNomeMae;
	}
	
	/*get e set Nome do Pai*/
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nNomePai) {
		this.nomePai = nNomePai;
	}
	
	/*get e set Data de nascimento*/
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date nDataNascimento) {
		dataNascimento = nDataNascimento;
	}
	
	/*get e set Cargo*/
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String nCargo) {
		cargo = nCargo;
	}
	
	/*get e set dataNascimento*/
	public String getTipoTrabalho() {
		return tipoTrabalho;
	}
	public void setTipoTrabalho(String nTipoTrabalho) {
		tipoTrabalho = nTipoTrabalho;
	}
	
	/*get e set Data de admissão*/
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date nDataAdmissao) {
		dataAdmissao = nDataAdmissao;
	}
	
	/*get e set Data a demissão*/
	public Date getDataDemissao() {
		return dataDemissao;
	}
	public void setDataDemissao(Date nDataDemissao) {
		dataDemissao = nDataDemissao;
	}
	
	/*get e set Senha*/
	public String getSenha() {
		return senha;
	}
	public void setSenha(String nSenha) {
		senha = nSenha;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String nLogin) {
		login = nLogin;
	}
	/*get e set Carteira de trabalho*/
	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}
	public void setCarteiraTrabalho(String nCarteiraTrabalho) {
		carteiraTrabalho = nCarteiraTrabalho;
	}
		
	/*get e set Salario*/
	public double getSalario() {
		return salario;
	}
	public void setSalario(double nSalario) {
		salario = nSalario;
	}
	
	/*get e set Nome do banco*/
	public String getNomeBanco() {
		return nomeBanco;
	}
	public void setNomeBanco(String nNomeBanco) {
		nomeBanco = nNomeBanco;
	}
	
	/*get e set Forma de pagamento*/
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String nFormaPagamento) {
		formaPagamento = nFormaPagamento;
	}
	
	/*get e set Carga horaria*/
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String nCargaHoraria) {
		cargaHoraria = nCargaHoraria;
	}
	
	/*get e set CargaHoraria unidade*/
	public String getCargaHorariaUnidade() {
		return cargaHorariaUnidade;
	}
	public void setCargaHorariaUnidade(String nCargaHorariaUnidade) {
		cargaHorariaUnidade = nCargaHorariaUnidade;
	}
	
	/*get e set Hora de entrada*/
	public Time getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(Time nHoraEntrada) {
		horaEntrada = nHoraEntrada;
	}
	
	/*get e set Hora de saida*/
	public Time getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Time nHoraSaida) {
		horaSaida = nHoraSaida;
	}

	/*get e set Hora de cadastro*/
	public Time getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(Time nHoraCadastro) {
		horaCadastro = nHoraCadastro;
	}
	
	/*get e set Limite de faltas do funcionario*/
	public int getLimiteFaltas() {
		return limiteFaltas;
	}
	public void setLimiteFaltas(int nLimiteFaltas) {
		limiteFaltas = nLimiteFaltas;
	}
}