package moduloFornecedorBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_fornecedor{
	public void Inserir_Dados_Fornecedor(Fornecedor InsereDadosFornecedor){
    	String sql = "INSERT INTO fornecedortb (nome_for, razaosocial_for, codigofornecedor_for, cnpj_for, cpf_for, inscricaoestadual_for, inscricaonumero_for, tipofornecedor_for,"
    				+ "tipocomercio_for, telefone1_for, telefone2_for, celular1_for, celular2_for, email1_for, email2_for, nacionalidade_for, pais_for, estado_for, cep_for,"
    				+ "cidade_for, endereco_for, numero_for, complemento_for, bairro_for, referencia_for, funcionarionome_for, codigofuncionario_for, cargofuncionario_for,"
    				+ "datacadastro_for, horacadastro_for)"
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosFornecedor.getNome());
            stmt.setString(2, InsereDadosFornecedor.getRazaoSocial());
            stmt.setString(3, InsereDadosFornecedor.getCodigoFornecedor());
            stmt.setString(4, InsereDadosFornecedor.getCNPJ());
            stmt.setString(5, InsereDadosFornecedor.getCPF());
            stmt.setString(6, InsereDadosFornecedor.getInscricaoEstadual());
            stmt.setString(7, InsereDadosFornecedor.getInscricaoNumero());
            stmt.setString(8, InsereDadosFornecedor.getTipoFornecedor());
            stmt.setString(9, InsereDadosFornecedor.getTipoComercio());
            stmt.setString(10, InsereDadosFornecedor.getTelefone1());
            stmt.setString(11, InsereDadosFornecedor.getTelefone2());
            stmt.setString(12, InsereDadosFornecedor.getCelular1());
            stmt.setString(13, InsereDadosFornecedor.getCelular2());
            stmt.setString(14, InsereDadosFornecedor.getEmail1());
            stmt.setString(15, InsereDadosFornecedor.getEmail2());
            stmt.setString(16, InsereDadosFornecedor.getNacionalidade());
            stmt.setString(17, InsereDadosFornecedor.getPais());
            stmt.setString(18, InsereDadosFornecedor.getEstado());
            stmt.setString(19, InsereDadosFornecedor.getCEP());
            stmt.setString(20, InsereDadosFornecedor.getCidade());
            stmt.setString(21, InsereDadosFornecedor.getEndereco());
            stmt.setString(22, InsereDadosFornecedor.getNumero());
            stmt.setString(23, InsereDadosFornecedor.getComplemento());
            stmt.setString(24, InsereDadosFornecedor.getBairro());
            stmt.setString(25, InsereDadosFornecedor.getReferencia());
            stmt.setString(26, InsereDadosFornecedor.getFuncionarioCadastro());
            stmt.setString(27, InsereDadosFornecedor.getCodigoFuncionario());
            stmt.setString(28, InsereDadosFornecedor.getCargoFuncionario());
            stmt.setDate(29, InsereDadosFornecedor.getDataCadastro());
            stmt.setTime(30, InsereDadosFornecedor.getHoraCadastro());
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