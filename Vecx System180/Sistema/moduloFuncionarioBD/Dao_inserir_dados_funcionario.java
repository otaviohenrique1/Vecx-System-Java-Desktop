package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_funcionario{
	public void Inserir_Dados_Funcionario(Funcionario InsereDadosFuncionario){
    	String sql = "INSERT INTO funcionariotb (nome_fun, codigofuncionario_fun, rg_fun, cpf_fun, datanascimento_fun, sexo_fun, estadocivil_fun,"
    				+ "telefone1_fun, telefone2_fun,celular1_fun, celular2_fun, email1_fun, email2_fun, nomemae_fun, nomepai_fun, escolaridade_fun,"
    				+ "nacionalidade_fun, pais_fun, login_fun, senha_fun, cargo_fun, carteiratrabalho_fun, salario_fun, formapagamento_fun,"
    				+ "nomebanco_fun, tipotrabalho_fun, dataadmissao_fun, datademissao_fun, horarioentrada_fun, horariosaida_fun, cargahoraria_fun,"
    				+ "cargahorariaunidade_fun, maximofalta_fun, estado_fun, cep_fun, cidade_fun, endereco_fun, numero_fun, complemento_fun, bairro_fun,"
    				+ "referencia_fun, datacadastro_fun, horacadastro_fun)" 
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosFuncionario.getNome());
    		stmt.setString(2, InsereDadosFuncionario.getCodigoFuncionario());
    		stmt.setString(3, InsereDadosFuncionario.getRG());
    		stmt.setString(4, InsereDadosFuncionario.getCPF());
            stmt.setDate(5, InsereDadosFuncionario.getDataNascimento());
    		stmt.setString(6, InsereDadosFuncionario.getSexo());
    		stmt.setString(7, InsereDadosFuncionario.getEstadoCivil());
            stmt.setString(8, InsereDadosFuncionario.getTelefone1());
            stmt.setString(9, InsereDadosFuncionario.getTelefone2());
            stmt.setString(10, InsereDadosFuncionario.getCelular1());
            stmt.setString(11, InsereDadosFuncionario.getCelular2());
            stmt.setString(12, InsereDadosFuncionario.getEmail1());
            stmt.setString(13, InsereDadosFuncionario.getEmail2());
            stmt.setString(14, InsereDadosFuncionario.getNomeMae());
            stmt.setString(15, InsereDadosFuncionario.getNomePai());
            stmt.setString(16, InsereDadosFuncionario.getEscolaridade());
            stmt.setString(17, InsereDadosFuncionario.getNacionalidade());
            stmt.setString(18, InsereDadosFuncionario.getPaisOrigem());
            stmt.setString(19, InsereDadosFuncionario.getLogin());
            stmt.setString(20, InsereDadosFuncionario.getSenha());
            stmt.setString(21, InsereDadosFuncionario.getCargo());
            stmt.setString(22, InsereDadosFuncionario.getCarteiraTrabalho());
            stmt.setDouble(23, InsereDadosFuncionario.getSalario());
            stmt.setString(24, InsereDadosFuncionario.getFormaPagamento());
            stmt.setString(25, InsereDadosFuncionario.getNomeBanco());
            stmt.setString(26, InsereDadosFuncionario.getTipoTrabalho());
            stmt.setDate(27, InsereDadosFuncionario.getDataAdmissao());
            stmt.setDate(28, InsereDadosFuncionario.getDataDemissao());
            stmt.setTime(29, InsereDadosFuncionario.getHoraEntrada());
            stmt.setTime(30, InsereDadosFuncionario.getHoraSaida());
            stmt.setString(31, InsereDadosFuncionario.getCargaHoraria());
            stmt.setString(32, InsereDadosFuncionario.getCargaHorariaUnidade());
            stmt.setInt(33, InsereDadosFuncionario.getLimiteFaltas());
            stmt.setString(34, InsereDadosFuncionario.getEstado());
            stmt.setString(35, InsereDadosFuncionario.getCEP());
            stmt.setString(36, InsereDadosFuncionario.getCidade());
            stmt.setString(37, InsereDadosFuncionario.getEndereco());
            stmt.setString(38, InsereDadosFuncionario.getNumero());
            stmt.setString(39, InsereDadosFuncionario.getComplemento());
            stmt.setString(40, InsereDadosFuncionario.getBairro());
            stmt.setString(41, InsereDadosFuncionario.getReferencia());
            stmt.setDate(42, InsereDadosFuncionario.getDataCadastro());
            stmt.setTime(43, InsereDadosFuncionario.getHoraCadastro());
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