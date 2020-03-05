package moduloFornecedorBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_fornecedor{
	//Parte que consulta os dados no banco de dados
	 public List<Fornecedor> Consulta_Dados_Fornecedor_Lista() {
    	List<Fornecedor> ConsultaDadosFornecedor = new ArrayList<Fornecedor>();
    	String sql = "SELECT * FROM fornecedortb";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor DadosFornecedor = new Fornecedor();
				DadosFornecedor.setNome(rs.getString("nome_for"));
				DadosFornecedor.setCodigoFornecedor(rs.getString("codigofornecedor_for"));
				DadosFornecedor.setCNPJ(rs.getString("cnpj_for"));
				ConsultaDadosFornecedor.add(DadosFornecedor);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFornecedor;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
	} 
	
	public List<Fornecedor> Consulta_Dados_Fornecedor_Ficha (String codigoFornecedor, String nomeFornecedor, String cnpjFornecedor) {
    	List<Fornecedor> ConsultaDadosFornecedor = new ArrayList<Fornecedor>();
    	String sql = "SELECT * FROM fornecedortb WHERE codigofornecedor_for = ? AND nome_for = ? AND cnpj_for = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoFornecedor);
			stmt.setString(2, nomeFornecedor);
			stmt.setString(3, cnpjFornecedor);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor DadosFornecedor = new Fornecedor();
				DadosFornecedor.setNome(rs.getString("nome_for"));
				DadosFornecedor.setRazaoSocial(rs.getString("razaosocial_for"));
				DadosFornecedor.setCodigoFornecedor(rs.getString("codigofornecedor_for"));
				DadosFornecedor.setCNPJ(rs.getString("cnpj_for"));
				DadosFornecedor.setCPF(rs.getString("cpf_for"));
				DadosFornecedor.setInscricaoEstadual(rs.getString("inscricaoestadual_for"));
				DadosFornecedor.setInscricaoNumero(rs.getString("inscricaonumero_for"));
				DadosFornecedor.setTipoFornecedor(rs.getString("tipofornecedor_for"));
				DadosFornecedor.setTipoComercio(rs.getString("tipocomercio_for"));
				DadosFornecedor.setTelefone1(rs.getString("telefone1_for"));
				DadosFornecedor.setTelefone2(rs.getString("telefone2_for"));
				DadosFornecedor.setCelular1(rs.getString("celular1_for"));
				DadosFornecedor.setCelular2(rs.getString("celular2_for"));
				DadosFornecedor.setEmail1(rs.getString("email1_for"));
				DadosFornecedor.setEmail2(rs.getString("email2_for"));
				DadosFornecedor.setNacionalidade(rs.getString("nacionalidade_for"));
				DadosFornecedor.setPais(rs.getString("pais_for"));
				DadosFornecedor.setEstado(rs.getString("estado_for"));
				DadosFornecedor.setCEP(rs.getString("cep_for"));
				DadosFornecedor.setCidade(rs.getString("cidade_for"));
				DadosFornecedor.setEndereco(rs.getString("endereco_for"));
				DadosFornecedor.setNumero(rs.getString("numero_for"));
				DadosFornecedor.setComplemento(rs.getString("complemento_for"));
				DadosFornecedor.setBairro(rs.getString("bairro_for"));
				DadosFornecedor.setReferencia(rs.getString("referencia_for"));
				DadosFornecedor.setFuncionarioCadastro(rs.getString("funcionarionome_for"));
				DadosFornecedor.setCargoFuncionario(rs.getString("cargofuncionario_for"));
				DadosFornecedor.setCodigoFuncionario(rs.getString("codigofuncionario_for"));
				DadosFornecedor.setDataCadastro(rs.getDate("datacadastro_for"));
				DadosFornecedor.setHoraCadastro(rs.getTime("horacadastro_for"));
				ConsultaDadosFornecedor.add(DadosFornecedor);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFornecedor;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	public List<Fornecedor> Consulta_Dados_Fornecedor_Nome (String nomeFornecedor) {
    	List<Fornecedor> ConsultaDadosFornecedor = new ArrayList<Fornecedor>();
    	String sql = "SELECT * FROM fornecedortb WHERE nome_for = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, nomeFornecedor);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor DadosFornecedor = new Fornecedor();
				DadosFornecedor.setCodigoFornecedor(rs.getString("codigofornecedor_for"));
				DadosFornecedor.setCNPJ(rs.getString("cnpj_for"));
				ConsultaDadosFornecedor.add(DadosFornecedor);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFornecedor;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	public List<Fornecedor> Consulta_Dados_Fornecedor_Codigo (String codigoFornecedor) {
    	List<Fornecedor> ConsultaDadosFornecedor = new ArrayList<Fornecedor>();
    	String sql = "SELECT * FROM fornecedortb WHERE codigofornecedor_for = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoFornecedor);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor DadosFornecedor = new Fornecedor();
				DadosFornecedor.setNome(rs.getString("nome_for"));
				DadosFornecedor.setCNPJ(rs.getString("cnpj_for"));
				ConsultaDadosFornecedor.add(DadosFornecedor);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFornecedor;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<Fornecedor> Consulta_Dados_Fornecedor_CNPJ (String cnpjFornecedor) {
    	List<Fornecedor> ConsultaDadosFornecedor = new ArrayList<Fornecedor>();
    	String sql = "SELECT * FROM fornecedortb WHERE cnpj_for = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, cnpjFornecedor);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Fornecedor DadosFornecedor = new Fornecedor();
				DadosFornecedor.setNome(rs.getString("nome_for"));
				DadosFornecedor.setCodigoFornecedor(rs.getString("codigofornecedor_for"));
				ConsultaDadosFornecedor.add(DadosFornecedor);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosFornecedor;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}