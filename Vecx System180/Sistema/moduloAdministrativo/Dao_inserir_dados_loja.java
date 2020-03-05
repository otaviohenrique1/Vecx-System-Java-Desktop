package moduloAdministrativo;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_loja{
	public void Inserir_Dados_Loja(DadosLoja InsereDadosLoja){
    	String sql = "INSERT INTO dadoslojatb (nomeloja_dados, razaosocial_dados, cnpj_dados, cpf_dados, inscricaoestadual_dados,"
    				+ "inscricaonumero_dados, telefone1_dados, telefone2_dados, celular1_dados, celular2_dados, email1_dados, email2_dados,"
    				+ "nacionalidade_dados, pais_dados, estado_dados, cep_dados, cidade_dados, endereco_dados, numero_dados, complemento_dados,"
    				+ "bairro_dados, referencia_dados, datacadastro_dados, horacadastro_dados, estadodadosloja_dados)"
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosLoja.getNome());
            stmt.setString(2, InsereDadosLoja.getRazaoSocial());
            stmt.setString(3, InsereDadosLoja.getCNPJ());
            stmt.setString(4, InsereDadosLoja.getCPF());
            stmt.setString(5, InsereDadosLoja.getInscricaoEstadual());
            stmt.setString(6, InsereDadosLoja.getInscricaoNumero());;
            stmt.setString(7, InsereDadosLoja.getTelefone1());
            stmt.setString(8, InsereDadosLoja.getTelefone2());
            stmt.setString(9, InsereDadosLoja.getCelular1());
            stmt.setString(10, InsereDadosLoja.getCelular2());
            stmt.setString(11, InsereDadosLoja.getEmail1());
            stmt.setString(12, InsereDadosLoja.getEmail2());
            stmt.setString(13, InsereDadosLoja.getNacionalidade());
            stmt.setString(14, InsereDadosLoja.getPais());
            stmt.setString(15, InsereDadosLoja.getEstado());
            stmt.setString(16, InsereDadosLoja.getCEP());
            stmt.setString(17, InsereDadosLoja.getCidade());
            stmt.setString(18, InsereDadosLoja.getEndereco());
            stmt.setString(19, InsereDadosLoja.getNumero());
            stmt.setString(20, InsereDadosLoja.getComplemento());
            stmt.setString(21, InsereDadosLoja.getBairro());
            stmt.setString(22, InsereDadosLoja.getReferencia());
            stmt.setDate(23, InsereDadosLoja.getDataCadastro());
            stmt.setTime(24, InsereDadosLoja.getHoraCadastro());
            stmt.setString(25, InsereDadosLoja.getEstadoDadosLoja());
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