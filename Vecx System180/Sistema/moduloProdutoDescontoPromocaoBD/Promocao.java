package moduloProdutoDescontoPromocaoBD;

import java.sql.Date;
import java.sql.Time;

public class Promocao {
	private String nomePromocao, codigoPromocao, descricaoPromocao, tipoPromocao, nomeResponsavel, codigoResponsavel, cargoResponsavel;
	private String funcionarioCadastro, cargoFuncionario, codigoFuncionario, estadoPromocao;
	private Date dataInicio, dataTermino, dataCadastro;
	private Time horaInicio, horaTermino, horaCadastro;
	
	/*Construtor da classe*/
	public Promocao() {
		
	}
	
	Promocao(String nomePromocao, String codigoPromocao, String descricaoPromocao, String tipoPromocao, String nomeResponsavel, String funcionarioCadastro,
				String cargoFuncionario, String codigoFuncionario, String codigoResponsavel, String cargoResponsavel, Date dataInicio, String estadoPromocao,
				Date dataTermino, Date dataCadastro, Time horaInicio, Time horaTermino, Time horaCadastro) {
				 	this.nomePromocao = nomePromocao;
				 	this.codigoPromocao = codigoPromocao;
				 	this.estadoPromocao = estadoPromocao;
				 	this.descricaoPromocao = descricaoPromocao;
				 	this.tipoPromocao = tipoPromocao;
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
	}
	
	/*Metodos get e set */
	/*get e set Nome da promoção*/
	public String getNomePromocao() {
		return nomePromocao;
	}
	public void setNomePromocao(String nNomePromocao) {
		nomePromocao = nNomePromocao;
	}
	
	/*get e set Estado da promoção*/
	public String getEstadoPromocao() {
		return estadoPromocao;
	}
	public void setEstadoPromocao(String estadoPromocao) {
		this.estadoPromocao = estadoPromocao;
	}
	
	/*get e set Codigo da promoção*/
	public String getCodigoPromocao() {
		return codigoPromocao;
	}
	public void setCodigoPromocao(String nCodigoPromocao) {
		codigoPromocao = nCodigoPromocao;
	}
	
	/*get e set Descrição da promoção*/
	public String getDescricaoPromocao() {
		return descricaoPromocao;
	}
	public void setDescricaoPromocao(String nDescricaoPromocao) {
		descricaoPromocao = nDescricaoPromocao;
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
	
	/*get e set Cargo do reponsavel*/
	public String getCargoResponsavel() {
		return cargoResponsavel;
	}
	public void setCargoResponsavel(String nCargoResponsavel) {
		cargoResponsavel = nCargoResponsavel;
	}
	
	/*get e set Nome do funcionario*/
	public String getFuncionarioCadastro() {
		return funcionarioCadastro;
	}
	public void setFuncionarioCadastro(String nFuncionarioCadastro) {
		funcionarioCadastro = nFuncionarioCadastro;
	}
	
	/*get e set Codigo do funcionario*/
	public String getCargoFuncionario() {
		return cargoFuncionario;
	}
	public void setCargoFuncionario(String nCargoFuncionario) {
		cargoFuncionario = nCargoFuncionario;
	}
	
	/*get e set Cargo do funcionario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}
	
	/*get e set Data de inicio da promoção*/
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date nDataInicio) {
		dataInicio = nDataInicio;
	}
	
	/*get e set Data de termino da promoção*/
	public Date getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Date nDataTermino) {
		dataTermino = nDataTermino;
	}
	
	/*get e set Data de cadastro da promoção*/
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date nDataCadastro) {
		dataCadastro = nDataCadastro;
	}
	
	/*get e set Hora de inicio da promoção*/
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time nHoraInicio) {
		horaInicio = nHoraInicio;
	}
	
	/*get e set Hora de termino da promoção*/
	public Time getHoraTermino() {
		return horaTermino;
	}
	public void setHoraTermino(Time nHoraTermino) {
		horaTermino = nHoraTermino;
	}
	
	/*get e set Hora de cadastro da promoção*/
	public Time getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(Time nHoraCadastro) {
		horaCadastro = nHoraCadastro;
	}
	
	/*get e set Tipo de promoção*/
	public String getTipoPromocao() {
		return tipoPromocao;
	}
	public void setTipoPromocao(String tipoPromocao) {
		this.tipoPromocao = tipoPromocao;
	}
}