package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_alterar_dados_funcionario{
	//Parte que altera os dados no banco de dados
	public void Altera_Dados_Funcionario(Funcionario AlteraDadosFuncionario){
    	String sql = "UPDATE funcionariotb SET "
    				+ "nome_fun = ?, rg_fun = ?, cpf_fun = ?, datanascimento_fun = ?, sexo_fun = ?, estadocivil_fun = ?, telefone1_fun = ?, telefone2_fun = ?,"
    				+ "celular1_fun = ?, celular2_fun = ?, email1_fun = ?, email2_fun = ?, nomemae_fun = ?, nomepai_fun = ?, escolaridade_fun = ?, nacionalidade_fun = ?,"
    				+ "pais_fun = ?, login_fun = ?, senha_fun = ?, cargo_fun = ?, carteiratrabalho_fun = ?, salario_fun = ?, formapagamento_fun = ?, nomebanco_fun = ?,"
    				+ "tipotrabalho_fun = ?, dataadmissao_fun = ?, datademissao_fun = ?, horarioentrada_fun = ?,horariosaida_fun = ?, cargahoraria_fun = ?, cargahorariaunidade_fun = ?,"
    				+ "maximofalta_fun = ?, estado_fun = ?, cep_fun = ?, cidade_fun = ?, endereco_fun = ?, numero_fun = ?, complemento_fun = ?, bairro_fun = ?, referencia_fun = ?" 
	    			+ "WHERE codigofuncionario_fun = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, AlteraDadosFuncionario.getNome());
    		stmt.setString(2, AlteraDadosFuncionario.getRG());
    		stmt.setString(3, AlteraDadosFuncionario.getCPF());
            stmt.setDate(4, AlteraDadosFuncionario.getDataNascimento());
    		stmt.setString(5, AlteraDadosFuncionario.getSexo());
    		stmt.setString(6, AlteraDadosFuncionario.getEstadoCivil());
            stmt.setString(7, AlteraDadosFuncionario.getTelefone1());
            stmt.setString(8, AlteraDadosFuncionario.getTelefone2());
            stmt.setString(9, AlteraDadosFuncionario.getCelular1());
            stmt.setString(10, AlteraDadosFuncionario.getCelular2());
            stmt.setString(11, AlteraDadosFuncionario.getEmail1());
            stmt.setString(12, AlteraDadosFuncionario.getEmail2());
            stmt.setString(13, AlteraDadosFuncionario.getNomeMae());
            stmt.setString(14, AlteraDadosFuncionario.getNomePai());
            stmt.setString(15, AlteraDadosFuncionario.getEscolaridade());
            stmt.setString(16, AlteraDadosFuncionario.getNacionalidade());
            stmt.setString(17, AlteraDadosFuncionario.getPaisOrigem());
            stmt.setString(18, AlteraDadosFuncionario.getLogin());
            stmt.setString(19, AlteraDadosFuncionario.getSenha());
            stmt.setString(20, AlteraDadosFuncionario.getCargo());
            stmt.setString(21, AlteraDadosFuncionario.getCarteiraTrabalho());
            stmt.setDouble(22, AlteraDadosFuncionario.getSalario());
            stmt.setString(23, AlteraDadosFuncionario.getFormaPagamento());
            stmt.setString(24, AlteraDadosFuncionario.getNomeBanco());
            stmt.setString(25, AlteraDadosFuncionario.getTipoTrabalho());
            stmt.setDate(26, AlteraDadosFuncionario.getDataAdmissao());
            stmt.setDate(27, AlteraDadosFuncionario.getDataDemissao());
            stmt.setTime(28, AlteraDadosFuncionario.getHoraEntrada());
            stmt.setTime(29, AlteraDadosFuncionario.getHoraSaida());
            stmt.setString(30, AlteraDadosFuncionario.getCargaHoraria());
            stmt.setString(31, AlteraDadosFuncionario.getCargaHorariaUnidade());
            stmt.setInt(32, AlteraDadosFuncionario.getLimiteFaltas());
            stmt.setString(33, AlteraDadosFuncionario.getEstado());
            stmt.setString(34, AlteraDadosFuncionario.getCEP());
            stmt.setString(35, AlteraDadosFuncionario.getCidade());
            stmt.setString(36, AlteraDadosFuncionario.getEndereco());
            stmt.setString(37, AlteraDadosFuncionario.getNumero());
            stmt.setString(38, AlteraDadosFuncionario.getComplemento());
            stmt.setString(39, AlteraDadosFuncionario.getBairro());
            stmt.setString(40, AlteraDadosFuncionario.getReferencia());
            stmt.setString(41, AlteraDadosFuncionario.getCodigoFuncionario());
            stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Funcionario_Historico(FuncionarioFrequencia AlteraDadosFuncionarioHistorico){
    	String sql = "UPDATE funcionariohistoricotb SET funcionario_his = ?, cargofuncionario_his = ?, entradafuncionario_his = ?, saidafuncionario_his = ?,"
    				+ "cargahoraria_his = ?, cargahorariaunidade_his = ?, maximofalta_his = ? WHERE codigofuncionario_his = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, AlteraDadosFuncionarioHistorico.getNomeFuncionario());
    		stmt.setString(2, AlteraDadosFuncionarioHistorico.getCargoFuncionario());
    		stmt.setTime(3, AlteraDadosFuncionarioHistorico.getHoraEntrada());
    		stmt.setTime(4, AlteraDadosFuncionarioHistorico.getHoraSaida());
    		stmt.setString(5, AlteraDadosFuncionarioHistorico.getCargaHoraria());
    		stmt.setString(6, AlteraDadosFuncionarioHistorico.getCargaHorariaUnidade());
    		stmt.setInt(7, AlteraDadosFuncionarioHistorico.getValorMaximoFalta());
    		stmt.setString(8, AlteraDadosFuncionarioHistorico.getCodigoFuncionario());
			stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Funcionario_Salario(Funcionario AlteraDadosFuncionario){
    	String sql = "UPDATE funcionariotb SET "
    				+ "salario_fun = ?" 
	    			+ "WHERE codigofuncionario_fun = ? AND nome_fun = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt = Conecta.prepareStatement(sql);
    		stmt.setDouble(1, AlteraDadosFuncionario.getSalario());
    		stmt.setString(2, AlteraDadosFuncionario.getCodigoFuncionario());
			stmt.setString(3, AlteraDadosFuncionario.getNome());
    		stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Funcionario_Salario_Nome_Cargo(FuncionarioSalario AlteraDadosFuncionarioSalario){
    	String sql = "UPDATE funcionariosalariotb SET funcionario_sal = ?, cargo_sal = ? WHERE codigofuncionario_sal = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, AlteraDadosFuncionarioSalario.getNomeFuncionario());
    		stmt.setString(2, AlteraDadosFuncionarioSalario.getCargoFuncionario());
    		stmt.setString(3, AlteraDadosFuncionarioSalario.getCodigoFuncionario());
    		stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Funcionario_Ferias_Folgas_Nome_Cargo(FuncionarioFeriasFolga AlteraDadosFuncionarioFeriasFolga){
    	String sql = "UPDATE controleferiastb SET funcionario_ferias = ?, cargo_ferias = ? WHERE codigofuncionario_ferias = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, AlteraDadosFuncionarioFeriasFolga.getNomeFuncionario());
    		stmt.setString(2, AlteraDadosFuncionarioFeriasFolga.getCargoFuncionario());
    		stmt.setString(3, AlteraDadosFuncionarioFeriasFolga.getCodigoFuncionario());
    		stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Funcionario_Historico_Faltas_Nome_Cargo(FuncionarioFrequenciaFaltas AlteraDadosFuncionarioFrequenciaFaltas){
    	String sql = "UPDATE funcionariohistoricolistafaltastb SET funcionario_his_lis = ?, cargofuncionario_his_lis = ? WHERE codigofuncionario_his_lis = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, AlteraDadosFuncionarioFrequenciaFaltas.getNomeFuncionario());
    		stmt.setString(2, AlteraDadosFuncionarioFrequenciaFaltas.getCargoFuncionario());
    		stmt.setString(3, AlteraDadosFuncionarioFrequenciaFaltas.getCodigoFuncionario());
    		stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}