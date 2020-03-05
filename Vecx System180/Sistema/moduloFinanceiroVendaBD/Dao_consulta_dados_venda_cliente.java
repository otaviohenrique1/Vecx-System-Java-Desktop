package moduloFinanceiroVendaBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_venda_cliente{
	//Parte que consulta os dados no banco de dados
    public List<Venda> Consulta_Dados_Venda_Cliente(String clienteVenda) {
    	List<Venda> ConsultaDadosVenda = new ArrayList<Venda>();
    	String sql = "SELECT * FROM historicovendatb WHERE cliente_hist_ven = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, clienteVenda);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Venda DadosVenda = new Venda();
				DadosVenda.setCodigoVenda(rs.getString("codigovenda_hist_ven"));
				DadosVenda.setDataVenda(rs.getDate("datavenda_hist_ven"));
				DadosVenda.setHoraVenda(rs.getTime("horavenda_hist_ven"));
				DadosVenda.setPrecoTotal(rs.getDouble("precototal_hist_ven"));
				ConsultaDadosVenda.add(DadosVenda);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosVenda;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}