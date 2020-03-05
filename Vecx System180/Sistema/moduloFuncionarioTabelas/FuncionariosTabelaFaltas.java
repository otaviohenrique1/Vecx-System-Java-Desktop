package moduloFuncionarioTabelas;

public class FuncionariosTabelaFaltas {
	private String frequencia, data, horaCadastro;
	
	/*Construtor da classe*/
	public FuncionariosTabelaFaltas(String data, String horaCadastro, String frequencia) {
		this.data = data;
		this.frequencia = frequencia;
		this.horaCadastro = horaCadastro;
	}
	
	/*Metodos get e set */
	/*get e set Data do dia*/
	public String getData() {
		return data;
	}
	public void setData(String nData) {
		data = nData;
	}
	
	/*get e set Frequencia*/
	public String getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(String nFrequencia) {
		frequencia = nFrequencia;
	}
	
	/*get e set Hora do cadastro*/
	public String getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(String nHoraCadastro) {
		horaCadastro = nHoraCadastro;
	}	
}