package moduloFornecedorBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_alterar_dados_fornecedor{
	//Parte que altera os dados no banco de dados
	public void Altera_Dados_Fornecedor(Fornecedor AlteraDadosFornecedor){
    	String sql = "UPDATE fornecedortb SET nome_for = ?, razaosocial_for = ?, cnpj_for = ?, cpf_for = ?, inscricaoestadual_for = ?, "
    				+ "inscricaonumero_for = ?,  tipofornecedor_for = ?, tipocomercio_for = ?, telefone1_for = ?, telefone2_for = ?, celular1_for = ?, celular2_for = ?,"
    				+ "email1_for = ?, email2_for = ?, nacionalidade_for = ?, pais_for = ?, estado_for = ?, cep_for = ?, cidade_for = ?, endereco_for = ?, numero_for = ?,"
    				+ "complemento_for = ?, bairro_for = ?, referencia_for = ?"
	    			+ "WHERE codigofornecedor_for = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, AlteraDadosFornecedor.getNome());
            stmt.setString(2, AlteraDadosFornecedor.getRazaoSocial());
            stmt.setString(3, AlteraDadosFornecedor.getCNPJ());
            stmt.setString(4, AlteraDadosFornecedor.getCPF());
            stmt.setString(5, AlteraDadosFornecedor.getInscricaoEstadual());
            stmt.setString(6, AlteraDadosFornecedor.getInscricaoNumero());
            stmt.setString(7, AlteraDadosFornecedor.getTipoFornecedor());
            stmt.setString(8, AlteraDadosFornecedor.getTipoComercio());
            stmt.setString(9, AlteraDadosFornecedor.getTelefone1());
            stmt.setString(10, AlteraDadosFornecedor.getTelefone2());
            stmt.setString(11, AlteraDadosFornecedor.getCelular1());
            stmt.setString(12, AlteraDadosFornecedor.getCelular2());
            stmt.setString(13, AlteraDadosFornecedor.getEmail1());
            stmt.setString(14, AlteraDadosFornecedor.getEmail2());
            stmt.setString(15, AlteraDadosFornecedor.getNacionalidade());
            stmt.setString(16, AlteraDadosFornecedor.getPais());
            stmt.setString(17, AlteraDadosFornecedor.getEstado());
            stmt.setString(18, AlteraDadosFornecedor.getCEP());
            stmt.setString(19, AlteraDadosFornecedor.getCidade());
            stmt.setString(20, AlteraDadosFornecedor.getEndereco());
            stmt.setString(21, AlteraDadosFornecedor.getNumero());
            stmt.setString(22, AlteraDadosFornecedor.getComplemento());
            stmt.setString(23, AlteraDadosFornecedor.getBairro());
            stmt.setString(24, AlteraDadosFornecedor.getReferencia());
            stmt.setString(25, AlteraDadosFornecedor.getCodigoFornecedor());
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