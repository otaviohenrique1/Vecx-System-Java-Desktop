package moduloProdutoDescontoPromocaoBD;

import java.sql.Date;
import java.sql.Time;

public class Desconto {
	private String codigoDesconto, codigoProduto, nomeProduto, nomeResponsavel, codigoResponsavel, cargoResponsavel; 
	private String funcionarioCadastro, cargoFuncionario, codigoFuncionario, estadoDesconto;
	private Date dataInicio, dataTermino, dataCadastro;
	private Time horaInicio, horaTermino, horaCadastro;
	private double descontoPorcentagem, precoNormal, precoDesconto;
	
	/*Construtor da classe*/
	public Desconto() {
		
	}
	
	Desconto(String codigoDesconto, String codigoProduto, String nomeProduto, String nomeResponsavel,  String codigoResponsavel, String cargoResponsavel, 
				String funcionarioCadastro, String cargoFuncionario, String codigoFuncionario, String estadoDesconto, double descontoPorcentagem, double precoNormal,
				double precoDesconto, Date dataInicio, Date dataTermino, Date dataCadastro, Time horaInicio, Time horaTermino, Time horaCadastro) {
					this.nomeProduto = nomeProduto;
				 	this.codigoProduto = codigoProduto;
				 	this.codigoDesconto = codigoDesconto;
				 	this.estadoDesconto = estadoDesconto;
				 	this.nomeResponsavel = nomeResponsavel;
				 	this.codigoResponsavel = codigoResponsavel;
				 	this.cargoResponsavel = cargoResponsavel;
				 	this.funcionarioCadastro = funcionarioCadastro;
				 	this.cargoFuncionario = cargoFuncionario;
				 	this.codigoFuncionario = codigoFuncionario;
				 	this.dataInicio = dataInicio;
				 	this.dataTermino = dataTermino;
				 	this.dataCadastro = dataCadastro;
				 	this.horaInicio = horaInicio;
				 	this.horaTermino = horaTermino;
				 	this.horaCadastro = horaCadastro;
				 	this.descontoPorcentagem = descontoPorcentagem; 
				 	this.precoNormal = precoNormal;
				 	this.precoDesconto = precoDesconto;
	}
	
	/*Metodos get e set */
	/*get e set Codigo do desconto*/
	public String getCodigoDesconto() {
		return codigoDesconto;
	}
	public void setCodigoDesconto(String codigoDesconto) {
		this.codigoDesconto = codigoDesconto;
	}
	
	/*get e set Estado do desconto*/
	public String getEstadoDesconto() {
		return estadoDesconto;
	}
	public void setEstadoDesconto(String nEstadoDesconto) {
		estadoDesconto = nEstadoDesconto;
	}
	
	/*get e set Nome do produto*/
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nNomeProduto) {
		nomeProduto = nNomeProduto;
	}
	
	/*get e set Codigo do produto*/
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String nCodigoProduto) {
		codigoProduto = nCodigoProduto;
	}
	
	/*get e set Nome do responsavel*/
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nNomeResponsavel) {
		nomeResponsavel = nNomeResponsavel;
	}
	
	/*get e set Codigo do responsavel*/
	public String getCodigoResponsavel() {
		return codigoResponsavel;
	}
	public void setCodigoResponsavel(String nCodigoResponsavel) {
		codigoResponsavel = nCodigoResponsavel;
	}
	
	/*get e set Cargo do responsavel*/
	public String getCargoResponsavel() {
		return cargoResponsavel;
	}
	public void setCargoResponsavel(String nCargoResponsavel) {
		cargoResponsavel = nCargoResponsavel;
	}
	
	/*get e set Funcionario que cadastrou*/
	public String getFuncionarioCadastro() {
		return funcionarioCadastro;
	}
	public void setFuncionarioCadastro(String nFuncionarioCadastro) {
		funcionarioCadastro = nFuncionarioCadastro;
	}
	
	/*get e set Cargo do funcionario que cadastrou*/
	public String getCargoFuncionario() {
		return cargoFuncionario;
	}
	public void setCargoFuncionario(String nCargoFuncionario) {
		cargoFuncionario = nCargoFuncionario;
	}
	
	/*get e set Codigo do funcionario que cadastrou*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}
	
	/*get e set Data de inicio do desconto*/
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date nDataInicio) {
		dataInicio = nDataInicio;
	}
	
	/*get e set Data de termino do desconto*/
	public Date getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Date nDataTermino) {
		dataTermino = nDataTermino;
	}
	
	/*get e set Data de cadastro do desconto*/
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date nDataCadastro) {
		dataCadastro = nDataCadastro;
	}
	
	/*get e set Hora de inicio do desconto*/
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time nHoraInicio) {
		horaInicio = nHoraInicio;
	}
	
	/*get e set Hora de termino do desconto*/
	public Time getHoraTermino() {
		return horaTermino;
	}
	public void setHoraTermino(Time nHoraTermino) {
		horaTermino = nHoraTermino;
	}
	
	/*get e set Hora de cadastro do desconto*/
	public Time getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(Time nHoraCadastro) {
		horaCadastro = nHoraCadastro;
	}
	
	/*get e set Valor da porcentagem do desconto*/
	public double getDescontoPorcentagem() {
		return descontoPorcentagem;
	}
	public void setDescontoPorcentagem(double nDescontoPorcentagem) {
		descontoPorcentagem = nDescontoPorcentagem;
	}
	
	/*get e set Preço normal do produto*/
	public double getPrecoNormal() {
		return precoNormal;
	}
	public void setPrecoNormal(double nPrecoNormal) {
		precoNormal = nPrecoNormal;
	}
	
	/*get e set Preço do produto com desconto*/
	public double getPrecoDesconto() {
		return precoDesconto;
	}
	public void setPrecoDesconto(double nPrecoDesconto) {
		precoDesconto = nPrecoDesconto;
	}
}