package moduloClienteBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_cliente{
	//Parte que insere os dados no banco de dados
    public void Inserir_Dados_Cliente(Cliente InsereDadosCliente){
    	String sql = "INSERT INTO clientetb (nome_cli, codigocliente_cli, rg_cli, cpf_cli, datanascimento_cli, sexo_cli, estadocivil_cli,"
					+ "telefone1_cli, telefone2_cli, celular1_cli, celular2_cli, email1_cli, email2_cli, nacionalidade_cli, pais_cli,"
					+ "estado_cli, cep_cli, cidade_cli, endereco_cli, numero_cli , complemento_cli, bairro_cli, referencia_cli, "
					+ "funcionarionome_cli, codigofuncionario_cli, cargofuncionario_cli, datacadastro_cli, horacadastro_cli)"
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conectar =  new  ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conectar.prepareStatement(sql);
    		stmt.setString(1, InsereDadosCliente.getNome());
    		stmt.setString(2, InsereDadosCliente.getCodigoCliente());
    		stmt.setString(3, InsereDadosCliente.getRG());
    		stmt.setString(4, InsereDadosCliente.getCPF());
    		stmt.setDate(5, InsereDadosCliente.getDataNascimento());
    		stmt.setString(6, InsereDadosCliente.getSexo());
            stmt.setString(7, InsereDadosCliente.getEstadoCivil());
            stmt.setString(8, InsereDadosCliente.getTelefone1());
            stmt.setString(9, InsereDadosCliente.getTelefone2());
            stmt.setString(10, InsereDadosCliente.getCelular1());
            stmt.setString(11, InsereDadosCliente.getCelular2());
            stmt.setString(12, InsereDadosCliente.getEmail1());
            stmt.setString(13, InsereDadosCliente.getEmail2());
            stmt.setString(14, InsereDadosCliente.getNacionalidade());
            stmt.setString(15, InsereDadosCliente.getPaisOrigem());
            stmt.setString(16, InsereDadosCliente.getEstado());
            stmt.setString(17, InsereDadosCliente.getCEP());
            stmt.setString(18, InsereDadosCliente.getCidade());
            stmt.setString(19, InsereDadosCliente.getEndereco());
            stmt.setString(20, InsereDadosCliente.getNumero());
            stmt.setString(21, InsereDadosCliente.getComplemento());
            stmt.setString(22, InsereDadosCliente.getBairro());
            stmt.setString(23, InsereDadosCliente.getReferencia());
            stmt.setString(24, InsereDadosCliente.getFuncionarioCadastro());
            stmt.setString(25, InsereDadosCliente.getCodigoFuncionario());
            stmt.setString(26, InsereDadosCliente.getCargoFuncionario());
            stmt.setDate(27, InsereDadosCliente.getDataCadastro());
            stmt.setTime(28, InsereDadosCliente.getHoraCadastro());
            stmt.execute();
            stmt.close();
            Conectar.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema vai tomar no seu cu",JOptionPane.ERROR_MESSAGE);
        }
    }
}