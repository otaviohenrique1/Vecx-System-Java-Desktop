package moduloFuncionarioTabelas;

public class FuncionariosTabelaSalario {
	private String estadoComissaoBonus, nomeResponsavel, bonusSalario, comissaoSalario, dataHoraCadastro;
	
	/*Construtor da classe*/
	public FuncionariosTabelaSalario(String estadoComissaoBonus, String bonusSalario, String comissaoSalario, String dataHoraCadastro, String nomeResponsavel) {
											this.estadoComissaoBonus = estadoComissaoBonus;
											this.bonusSalario = bonusSalario;
											this.comissaoSalario = comissaoSalario;
											this.dataHoraCadastro = dataHoraCadastro;
											this.nomeResponsavel = nomeResponsavel; 
	}
	
	/*Metodos get e set*/
	/*get e set Estado comissão/bonus*/
	public String getEstadoComissaoBonus() {
		return estadoComissaoBonus;
	}
	public void setEstadoComissaoBonus(String nEstadoComissaoBonus) {
		estadoComissaoBonus = nEstadoComissaoBonus;
	}
	
	/*get e set Valor do bonus*/
	public String getBonusSalario() {
		return bonusSalario;
	}
	public void setBonusSalario(String nBonusSalario) {
		bonusSalario = nBonusSalario;
	}
	
	/*get e set Valor da comissão*/
	public String getComissaoSalario() {
		return comissaoSalario;
	}
	public void setComissaoSalario(String nComissaoSalario) {
		comissaoSalario = nComissaoSalario;
	}
	
	/*get e set Data e Hora do cadastro*/
	public String getDataHoraCadastro() {
		return dataHoraCadastro;
	}
	public void setDataHoraCadastro(String nDataHoraCadastro) {
		dataHoraCadastro = nDataHoraCadastro;
	}
	
	/*get e set Nome do responsavel*/
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nNomeResponsavel) {
		nomeResponsavel = nNomeResponsavel;
	}
}