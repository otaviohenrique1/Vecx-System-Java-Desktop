package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_funcionario{
	//Parte que consulta os dados no banco de dados
	public List<Funcionario> Consulta_Dados_Funcionario_Lista() {
    	List<Funcionario> ConsultaDadosFuncionario = new ArrayList<Funcionario>();
    	String sql = "SELECT * FROM funcionariotb";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Funcionario DadosFuncionario = new Funcionario();
				DadosFuncionario.setNome(rs.getString("nome_fun"));
				DadosFuncionario.setCodigoFuncionario(rs.getString("codigofuncionario_fun"));
				DadosFuncionario.setCargo(rs.getString("cargo_fun"));
				DadosFuncionario.setRG(rs.getString("rg_fun"));
				DadosFuncionario.setCPF(rs.getString("cpf_fun"));
				ConsultaDadosFuncionario.add(DadosFuncionario);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFuncionario;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<Funcionario> Consulta_Dados_Funcionario_Ficha(String codigoFuncionario, String nomeFuncionario, String cargoFuncionario) {
    	List<Funcionario> ConsultaDadosFuncionario = new ArrayList<Funcionario>();
    	String sql = "SELECT * FROM funcionariotb WHERE codigofuncionario_fun = ? AND nome_fun = ? AND cargo_fun = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoFuncionario);
			stmt.setString(2, nomeFuncionario);
			stmt.setString(3, cargoFuncionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Funcionario DadosFuncionario = new Funcionario();
				DadosFuncionario.setNome(rs.getString("nome_fun"));
				DadosFuncionario.setCodigoFuncionario(rs.getString("codigofuncionario_fun"));
				DadosFuncionario.setRG(rs.getString("rg_fun"));
				DadosFuncionario.setCPF(rs.getString("cpf_fun"));
				DadosFuncionario.setDataNascimento(rs.getDate("datanascimento_fun"));
				DadosFuncionario.setSexo(rs.getString("sexo_fun"));
				DadosFuncionario.setEstadoCivil(rs.getString("estadocivil_fun"));
				DadosFuncionario.setTelefone1(rs.getString("telefone1_fun"));
				DadosFuncionario.setTelefone2(rs.getString("telefone2_fun"));
				DadosFuncionario.setCelular1(rs.getString("celular1_fun"));
				DadosFuncionario.setCelular2(rs.getString("celular2_fun"));
				DadosFuncionario.setEmail1(rs.getString("email1_fun"));
				DadosFuncionario.setEmail2(rs.getString("email2_fun"));
				DadosFuncionario.setEscolaridade(rs.getString("escolaridade_fun"));
				DadosFuncionario.setNacionalidade(rs.getString("nacionalidade_fun"));
				DadosFuncionario.setPaisOrigem(rs.getString("pais_fun"));
				DadosFuncionario.setNacionalidade(rs.getString("nacionalidade_fun"));
				DadosFuncionario.setNomeMae(rs.getString("nomemae_fun"));
				DadosFuncionario.setNomePai(rs.getString("nomepai_fun"));
				DadosFuncionario.setLogin(rs.getString("login_fun"));
				DadosFuncionario.setSenha(rs.getString("senha_fun"));
				DadosFuncionario.setCargo(rs.getString("cargo_fun"));
				DadosFuncionario.setCarteiraTrabalho(rs.getString("carteiratrabalho_fun"));
				DadosFuncionario.setSalario(rs.getDouble("salario_fun"));
				DadosFuncionario.setFormaPagamento(rs.getString("formapagamento_fun"));
				DadosFuncionario.setNomeBanco(rs.getString("nomebanco_fun"));
				DadosFuncionario.setTipoTrabalho(rs.getString("tipotrabalho_fun"));
				DadosFuncionario.setDataAdmissao(rs.getDate("dataadmissao_fun"));
				DadosFuncionario.setDataDemissao(rs.getDate("datademissao_fun"));
				DadosFuncionario.setHoraEntrada(rs.getTime("horarioentrada_fun"));
				DadosFuncionario.setHoraSaida(rs.getTime("horariosaida_fun"));
				DadosFuncionario.setCargaHoraria(rs.getString("cargahoraria_fun"));
				DadosFuncionario.setCargaHorariaUnidade(rs.getString("cargahorariaunidade_fun"));
				DadosFuncionario.setLimiteFaltas(rs.getInt("maximofalta_fun"));
				DadosFuncionario.setEstado(rs.getString("estado_fun"));
				DadosFuncionario.setCEP(rs.getString("cep_fun"));
				DadosFuncionario.setCidade(rs.getString("cidade_fun"));
				DadosFuncionario.setEndereco(rs.getString("endereco_fun"));
				DadosFuncionario.setNumero(rs.getString("numero_fun"));
				DadosFuncionario.setComplemento(rs.getString("complemento_fun"));
				DadosFuncionario.setBairro(rs.getString("bairro_fun"));
				DadosFuncionario.setReferencia(rs.getString("referencia_fun"));
				DadosFuncionario.setDataCadastro(rs.getDate("datacadastro_fun"));
				DadosFuncionario.setHoraCadastro(rs.getTime("horacadastro_fun"));
				ConsultaDadosFuncionario.add(DadosFuncionario);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFuncionario;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}