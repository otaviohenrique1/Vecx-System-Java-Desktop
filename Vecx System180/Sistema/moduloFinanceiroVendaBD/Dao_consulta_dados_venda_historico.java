package moduloFinanceiroVendaBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_venda_historico{
	//Parte que consulta os dados no banco de dados
    public List<VendaHistorico> Consulta_Dados_Venda_Historico () {
    	List<VendaHistorico> ConsultaDadosVendaHistorico = new ArrayList<VendaHistorico>();
    	String sql = "SELECT * FROM historicovendatb";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				VendaHistorico DadosVendaHistorico = new VendaHistorico();
				DadosVendaHistorico.setCodigoVenda(rs.getString("codigovenda_hist_ven"));
				DadosVendaHistorico.setNomeCliente(rs.getString("cliente_hist_ven"));
				DadosVendaHistorico.setNomeFuncionario(rs.getString("funcionario_hist_ven"));
				DadosVendaHistorico.setDataVenda(rs.getDate("datavenda_hist_ven"));
				DadosVendaHistorico.setHoraVenda(rs.getTime("horavenda_hist_ven"));
				DadosVendaHistorico.setPrecoTotal(rs.getDouble("precototal_hist_ven"));
				ConsultaDadosVendaHistorico.add(DadosVendaHistorico);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosVendaHistorico;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}