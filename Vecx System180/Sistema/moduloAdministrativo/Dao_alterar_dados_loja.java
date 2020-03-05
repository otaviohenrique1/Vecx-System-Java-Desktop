package moduloAdministrativo;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_alterar_dados_loja{
	//Parte que altera os dados no banco de dados
	public void Altera_Dados_Loja(DadosLoja AlteraDadosFornecedor){
    	String sql = "UPDATE dadoslojatb SET nomeloja_dados = ?, razaosocial_dados = ?, cnpj_dados = ?, cpf_dados = ?, inscricaoestadual_dados = ?, inscricaonumero_dados = ?,"
											+ "telefone1_dados = ?, telefone2_dados = ?, celular1_dados = ?, celular2_dados = ?, email1_dados = ?, email2_dados = ?, "
											+ "nacionalidade_dados = ?, pais_dados = ?, estado_dados = ?, cep_dados = ?, cidade_dados = ?, endereco_dados = ?,"
											+ "numero_dados = ?, complemento_dados = ?, bairro_dados = ?, referencia_dados = ?"
											+ "WHERE estadodadosloja_dados = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, AlteraDadosFornecedor.getNome());
            stmt.setString(2, AlteraDadosFornecedor.getRazaoSocial());
            stmt.setString(3, AlteraDadosFornecedor.getCNPJ());
            stmt.setString(4, AlteraDadosFornecedor.getCPF());
            stmt.setString(5, AlteraDadosFornecedor.getInscricaoEstadual());
            stmt.setString(6, AlteraDadosFornecedor.getInscricaoNumero());;
            stmt.setString(7, AlteraDadosFornecedor.getTelefone1());
            stmt.setString(8, AlteraDadosFornecedor.getTelefone2());
            stmt.setString(9, AlteraDadosFornecedor.getCelular1());
            stmt.setString(10, AlteraDadosFornecedor.getCelular2());
            stmt.setString(11, AlteraDadosFornecedor.getEmail1());
            stmt.setString(12, AlteraDadosFornecedor.getEmail2());
            stmt.setString(13, AlteraDadosFornecedor.getNacionalidade());
            stmt.setString(14, AlteraDadosFornecedor.getPais());
            stmt.setString(15, AlteraDadosFornecedor.getEstado());
            stmt.setString(16, AlteraDadosFornecedor.getCEP());
            stmt.setString(17, AlteraDadosFornecedor.getCidade());
            stmt.setString(18, AlteraDadosFornecedor.getEndereco());
            stmt.setString(19, AlteraDadosFornecedor.getNumero());
            stmt.setString(20, AlteraDadosFornecedor.getComplemento());
            stmt.setString(21, AlteraDadosFornecedor.getBairro());
            stmt.setString(22, AlteraDadosFornecedor.getReferencia());
            stmt.setString(23, AlteraDadosFornecedor.getEstadoDadosLoja());
            stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}