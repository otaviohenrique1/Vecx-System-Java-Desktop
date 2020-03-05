package moduloAdministrativo;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_loja{
	//Parte que consulta os dados no banco de dados
	public boolean Consulta_Dados_Loja_Cadastro(String estadoDadosLojaBusca) {
	 	boolean buscaCadastroLoja = false;
    	String sql = "SELECT * FROM dadoslojatb WHERE estadodadosloja_dados = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, estadoDadosLojaBusca);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				buscaCadastroLoja = true;
			}
	        return buscaCadastroLoja;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public List<DadosLoja> Consulta_Dados_Fornecedor_Dados_Loja () {
    	List<DadosLoja> ConsultaDadosLoja = new ArrayList<DadosLoja>();
    	String sql = "SELECT * FROM dadoslojatb";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DadosLoja DadosLoja = new DadosLoja();
				DadosLoja.setEstadoDadosLoja(rs.getString("estadodadosloja_dados"));
				ConsultaDadosLoja.add(DadosLoja);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosLoja;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<DadosLoja> Consulta_Dados_Fornecedor_Ficha (String estadoDadosLojaBusca) {
    	List<DadosLoja> ConsultaDadosLoja = new ArrayList<DadosLoja>();
    	String sql = "SELECT * FROM dadoslojatb  WHERE estadodadosloja_dados = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, estadoDadosLojaBusca);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DadosLoja DadosLoja = new DadosLoja();
				DadosLoja.setNome(rs.getString("nomeloja_dados"));
				DadosLoja.setRazaoSocial(rs.getString("razaosocial_dados"));
				DadosLoja.setCNPJ(rs.getString("cnpj_dados"));
				DadosLoja.setCPF(rs.getString("cpf_dados"));
				DadosLoja.setInscricaoEstadual(rs.getString("inscricaoestadual_dados"));
				DadosLoja.setInscricaoNumero(rs.getString("inscricaonumero_dados"));
				DadosLoja.setTelefone1(rs.getString("telefone1_dados"));
				DadosLoja.setTelefone2(rs.getString("telefone2_dados"));
				DadosLoja.setCelular1(rs.getString("celular1_dados"));
				DadosLoja.setCelular2(rs.getString("celular2_dados"));
				DadosLoja.setEmail1(rs.getString("email1_dados"));
				DadosLoja.setEmail2(rs.getString("email2_dados"));
				DadosLoja.setNacionalidade(rs.getString("nacionalidade_dados"));
				DadosLoja.setPais(rs.getString("pais_dados"));
				DadosLoja.setEstado(rs.getString("estado_dados"));
				DadosLoja.setCEP(rs.getString("cep_dados"));
				DadosLoja.setCidade(rs.getString("cidade_dados"));
				DadosLoja.setEndereco(rs.getString("endereco_dados"));
				DadosLoja.setNumero(rs.getString("numero_dados"));
				DadosLoja.setComplemento(rs.getString("complemento_dados"));
				DadosLoja.setBairro(rs.getString("bairro_dados"));
				DadosLoja.setReferencia(rs.getString("referencia_dados"));
				DadosLoja.setDataCadastro(rs.getDate("datacadastro_dados"));
				DadosLoja.setHoraCadastro(rs.getTime("horacadastro_dados"));
				ConsultaDadosLoja.add(DadosLoja);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosLoja;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}