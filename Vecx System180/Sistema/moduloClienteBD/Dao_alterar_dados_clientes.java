package moduloClienteBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_alterar_dados_clientes{
	//Parte que altera os dados no banco de dados
	public void Altera_Dados_Cliente(Cliente AlteraDadosCliente){
    	String sql = "UPDATE clientetb SET nome_cli = ?, rg_cli = ?, cpf_cli = ?, datanascimento_cli = ?, sexo_cli = ?, estadocivil_cli = ?,"
					+ "telefone1_cli = ?, telefone2_cli = ?, celular1_cli = ?, celular2_cli = ?, email1_cli = ?, email2_cli = ?, nacionalidade_cli = ?,"
					+ "pais_cli = ?, estado_cli = ?, cep_cli = ?, cidade_cli = ?, endereco_cli = ?, numero_cli = ?, complemento_cli = ?, bairro_cli = ?,"
					+ "referencia_cli = ?"
	    			+ "WHERE codigocliente_cli = ?";
    	try{
    		Connection Conectar =  new  ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conectar.prepareStatement(sql);
    		stmt.setString(1, AlteraDadosCliente.getNome());
    		stmt.setString(2, AlteraDadosCliente.getRG());
    		stmt.setString(3, AlteraDadosCliente.getCPF());
    		stmt.setDate(4, AlteraDadosCliente.getDataNascimento());
    		stmt.setString(5, AlteraDadosCliente.getSexo());
            stmt.setString(6, AlteraDadosCliente.getEstadoCivil());
            stmt.setString(7, AlteraDadosCliente.getTelefone1());
            stmt.setString(8, AlteraDadosCliente.getTelefone2());
            stmt.setString(9, AlteraDadosCliente.getCelular1());
            stmt.setString(10, AlteraDadosCliente.getCelular2());
            stmt.setString(11, AlteraDadosCliente.getEmail1());
            stmt.setString(12, AlteraDadosCliente.getEmail2());
            stmt.setString(13, AlteraDadosCliente.getNacionalidade());
            stmt.setString(14, AlteraDadosCliente.getPaisOrigem());
            stmt.setString(15, AlteraDadosCliente.getEstado());
            stmt.setString(16, AlteraDadosCliente.getCEP());
            stmt.setString(17, AlteraDadosCliente.getCidade());
            stmt.setString(18, AlteraDadosCliente.getEndereco());
            stmt.setString(19, AlteraDadosCliente.getNumero());
            stmt.setString(20, AlteraDadosCliente.getComplemento());
            stmt.setString(21, AlteraDadosCliente.getBairro());
            stmt.setString(22, AlteraDadosCliente.getReferencia());
            stmt.setString(23, AlteraDadosCliente.getCodigoCliente());
            stmt.execute();
            stmt.close();
            Conectar.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}