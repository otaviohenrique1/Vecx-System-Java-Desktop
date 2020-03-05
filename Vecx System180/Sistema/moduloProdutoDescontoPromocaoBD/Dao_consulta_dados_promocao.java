package moduloProdutoDescontoPromocaoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_promocao{
	//Parte que consulta os dados no banco de dados
	public List<Promocao> Consulta_Dados_Promocao_Lista() {
    	List<Promocao> ConsultaDadosPromocao = new ArrayList<Promocao>();
    	String sql = "SELECT * FROM promocaotb";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Promocao DadosPromocao = new Promocao();
				DadosPromocao.setCodigoPromocao(rs.getString("codigopromocao_promo"));
				DadosPromocao.setNomePromocao(rs.getString("nomepromocao_promo"));
				DadosPromocao.setDataInicio(rs.getDate("datainicio_promo"));
				DadosPromocao.setHoraInicio(rs.getTime("horainicio_promo"));
				DadosPromocao.setDataTermino(rs.getDate("datatermino_promo"));
				DadosPromocao.setHoraTermino(rs.getTime("horatermino_promo"));
				DadosPromocao.setNomeResponsavel(rs.getString("nomeresponsavel_promo"));
				ConsultaDadosPromocao.add(DadosPromocao);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosPromocao;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<Promocao> Consulta_Dados_Promocao_Ficha(String codigoPromocao) {
    	List<Promocao> ConsultaDadosPromocao = new ArrayList<Promocao>();
    	String sql = "SELECT * FROM promocaotb WHERE codigopromocao_promo = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoPromocao);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Promocao DadosPromocao = new Promocao();
				DadosPromocao.setCodigoPromocao(rs.getString("codigopromocao_promo"));
				DadosPromocao.setNomePromocao(rs.getString("nomepromocao_promo"));
				DadosPromocao.setDescricaoPromocao(rs.getString("descricao_promo"));
				DadosPromocao.setTipoPromocao(rs.getString("tipopromocao_promo"));
				DadosPromocao.setEstadoPromocao(rs.getString("estadopromocao_promo"));
				DadosPromocao.setDataInicio(rs.getDate("datainicio_promo"));
				DadosPromocao.setHoraInicio(rs.getTime("horainicio_promo"));
				DadosPromocao.setDataTermino(rs.getDate("datatermino_promo"));
				DadosPromocao.setHoraTermino(rs.getTime("horatermino_promo"));
				DadosPromocao.setDataCadastro(rs.getDate("datacadastro_promo"));
				DadosPromocao.setHoraCadastro(rs.getTime("horatermino_promo"));
				DadosPromocao.setNomeResponsavel(rs.getString("nomeresponsavel_promo"));
				DadosPromocao.setCargoResponsavel(rs.getString("cargoresponsavel_promo"));
				DadosPromocao.setCodigoResponsavel(rs.getString("codigoresponsavel_promo"));
				DadosPromocao.setFuncionarioCadastro(rs.getString("funcionariocadastro_promo"));
				DadosPromocao.setCodigoFuncionario(rs.getString("codigofuncionario_promo"));
				DadosPromocao.setCargoFuncionario(rs.getString("cargofuncionario_promo"));
				ConsultaDadosPromocao.add(DadosPromocao);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosPromocao;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}