package moduloClienteBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_cliente{
    //Parte que consulta os dados no banco de dados
    public List<Cliente> Consulta_Dados_Cliente_Lista() {
    	List<Cliente> ConsultaDadosCliente = new ArrayList<Cliente>();
    	String sql = "SELECT * FROM clientetb";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente DadosCliente = new Cliente();
				DadosCliente.setNome(rs.getString("nome_cli"));
				DadosCliente.setCodigoCliente(rs.getString("codigocliente_cli"));
				DadosCliente.setRG(rs.getString("rg_cli"));
				DadosCliente.setCPF(rs.getString("cpf_cli"));
				ConsultaDadosCliente.add(DadosCliente);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosCliente;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
    
    //Parte que consulta os dados no banco de dados
    public List<Cliente> Consulta_Dados_Cliente_Ficha(String codigoCliente1, String nomeCliente1, String cpfCliente1) {
    	List<Cliente> ConsultaDadosCliente = new ArrayList<Cliente>();
    	String sql = "SELECT * FROM clientetb WHERE codigocliente_cli = ? AND nome_cli = ? AND cpf_cli = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoCliente1);
			stmt.setString(2, nomeCliente1);
			stmt.setString(3, cpfCliente1);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente DadosCliente = new Cliente();
				DadosCliente.setNome(rs.getString("nome_cli"));
				DadosCliente.setCodigoCliente(rs.getString("codigocliente_cli"));
				DadosCliente.setRG(rs.getString("rg_cli"));
				DadosCliente.setCPF(rs.getString("cpf_cli"));
				DadosCliente.setDataNascimento(rs.getDate("datanascimento_cli"));
				DadosCliente.setSexo(rs.getString("sexo_cli"));
				DadosCliente.setEstadoCivil(rs.getString("estadocivil_cli"));
				DadosCliente.setTelefone1(rs.getString("telefone1_cli"));
				DadosCliente.setTelefone2(rs.getString("telefone2_cli"));
				DadosCliente.setCelular1(rs.getString("celular1_cli"));
				DadosCliente.setCelular2(rs.getString("celular2_cli"));
				DadosCliente.setEmail1(rs.getString("email1_cli"));
				DadosCliente.setEmail2(rs.getString("email2_cli"));
				DadosCliente.setNacionalidade(rs.getString("nacionalidade_cli"));
				DadosCliente.setPaisOrigem(rs.getString("pais_cli"));
				DadosCliente.setEstado(rs.getString("estado_cli"));
				DadosCliente.setCEP(rs.getString("cep_cli"));
				DadosCliente.setCidade(rs.getString("cidade_cli"));
				DadosCliente.setEndereco(rs.getString("endereco_cli"));
				DadosCliente.setNumero(rs.getString("numero_cli"));
				DadosCliente.setComplemento(rs.getString("complemento_cli"));
				DadosCliente.setBairro(rs.getString("bairro_cli"));
				DadosCliente.setReferencia(rs.getString("referencia_cli"));
				DadosCliente.setFuncionarioCadastro(rs.getString("funcionarionome_cli"));
				DadosCliente.setCodigoFuncionario(rs.getString("codigofuncionario_cli"));
				DadosCliente.setCargoFuncionario(rs.getString("cargofuncionario_cli"));
				DadosCliente.setDataCadastro(rs.getDate("datacadastro_cli"));
				DadosCliente.setHoraCadastro(rs.getTime("horacadastro_cli"));
				ConsultaDadosCliente.add(DadosCliente);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosCliente;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
    
    public List<Cliente> Consulta_Dados_Cliente_Transporte(String nomeCliente1, String cpfCliente1) {
    	List<Cliente> ConsultaDadosCliente = new ArrayList<Cliente>();
    	String sql = "SELECT * FROM clientetb WHERE nome_cli = ? AND cpf_cli = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, nomeCliente1);
			stmt.setString(2, cpfCliente1);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente DadosCliente = new Cliente();
				DadosCliente.setCidade(rs.getString("cidade_cli"));
				DadosCliente.setEndereco(rs.getString("endereco_cli"));
				DadosCliente.setNumero(rs.getString("numero_cli"));
				DadosCliente.setBairro(rs.getString("bairro_cli"));
				ConsultaDadosCliente.add(DadosCliente);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosCliente;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
    
    public boolean Consulta_Dados_Cliente_Venda_CPF(String cpfCliente) {
    	boolean consultaCPF = false;
    	String sql = "SELECT * FROM clientetb WHERE cpf_cli = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, cpfCliente);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				consultaCPF = true;
			}
			stmt.close();
	        Conecta.close();
	        return consultaCPF;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
    
    public List<Cliente> Consulta_Dados_Cliente_Venda_Dados(String cpfCliente) {
    	List<Cliente> ConsultaDadosCliente = new ArrayList<Cliente>();
    	String sql = "SELECT * FROM clientetb WHERE cpf_cli = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, cpfCliente);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente DadosCliente = new Cliente();
				DadosCliente.setNome(rs.getString("nome_cli"));
				DadosCliente.setCodigoCliente(rs.getString("codigocliente_cli"));
				DadosCliente.setTelefone1(rs.getString("telefone1_cli"));
				DadosCliente.setCelular1(rs.getString("celular1_cli"));
				DadosCliente.setEstado(rs.getString("estado_cli"));
				DadosCliente.setCEP(rs.getString("cep_cli"));
				DadosCliente.setCidade(rs.getString("cidade_cli"));
				DadosCliente.setEndereco(rs.getString("endereco_cli"));
				DadosCliente.setNumero(rs.getString("numero_cli"));
				DadosCliente.setBairro(rs.getString("bairro_cli"));
				ConsultaDadosCliente.add(DadosCliente);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosCliente;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}