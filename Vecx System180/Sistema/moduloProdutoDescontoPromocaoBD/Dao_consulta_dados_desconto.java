package moduloProdutoDescontoPromocaoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_desconto{
	//Parte que consulta os dados no banco de dados
	public List<Desconto> Consulta_Dados_Desconto_Lista() {
    	List<Desconto> ConsultaDadosDesconto = new ArrayList<Desconto>();
    	String sql = "SELECT * FROM descontotb";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Desconto DadosDesconto = new Desconto();
				DadosDesconto.setCodigoDesconto(rs.getString("codigodesconto_des"));
				DadosDesconto.setNomeProduto(rs.getString("nomeproduto_des"));
				DadosDesconto.setDescontoPorcentagem(rs.getDouble("desconto_des"));
				DadosDesconto.setDataInicio(rs.getDate("datainicio_des"));
				DadosDesconto.setHoraInicio(rs.getTime("horainicio_des"));
				DadosDesconto.setDataTermino(rs.getDate("datatermino_des"));
				DadosDesconto.setHoraTermino(rs.getTime("horatermino_des"));
				DadosDesconto.setNomeResponsavel(rs.getString("nomeresponsavel_des"));
				ConsultaDadosDesconto.add(DadosDesconto);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosDesconto;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<Desconto> Consulta_Dados_Desconto_Ficha(String codigoDesconto) {
    	List<Desconto> ConsultaDadosDesconto = new ArrayList<Desconto>();
    	String sql = "SELECT * FROM descontotb WHERE codigodesconto_des = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoDesconto);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Desconto DadosDesconto = new Desconto();
				DadosDesconto.setCodigoDesconto(rs.getString("codigodesconto_des"));
				DadosDesconto.setEstadoDesconto(rs.getString("estadodesconto_des"));
				DadosDesconto.setCodigoProduto(rs.getString("codigoproduto_des"));
				DadosDesconto.setNomeProduto(rs.getString("nomeproduto_des"));
				DadosDesconto.setPrecoNormal(rs.getDouble("preconormal_des"));
				DadosDesconto.setDescontoPorcentagem(rs.getDouble("desconto_des"));
				DadosDesconto.setPrecoDesconto(rs.getDouble("precodesconto_des"));
				DadosDesconto.setDataInicio(rs.getDate("datainicio_des"));
				DadosDesconto.setHoraInicio(rs.getTime("horainicio_des"));
				DadosDesconto.setDataTermino(rs.getDate("datatermino_des"));
				DadosDesconto.setHoraTermino(rs.getTime("horatermino_des"));
				DadosDesconto.setDataCadastro(rs.getDate("datacadastro_des"));
				DadosDesconto.setHoraCadastro(rs.getTime("horacadastro_des"));
				DadosDesconto.setNomeResponsavel(rs.getString("nomeresponsavel_des"));
				DadosDesconto.setCargoResponsavel(rs.getString("cargoresponsavel_des"));
				DadosDesconto.setCodigoResponsavel(rs.getString("codigoresponsavel_des"));
				DadosDesconto.setFuncionarioCadastro(rs.getString("funcionariocadastro_des"));
				DadosDesconto.setCodigoFuncionario(rs.getString("codigofuncionario_des"));
				DadosDesconto.setCargoFuncionario(rs.getString("cargofuncionario_des"));
				ConsultaDadosDesconto.add(DadosDesconto);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosDesconto;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}