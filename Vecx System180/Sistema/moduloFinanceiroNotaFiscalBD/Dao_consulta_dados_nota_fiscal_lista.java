package moduloFinanceiroNotaFiscalBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_nota_fiscal_lista{
	//Parte que consulta os dados no banco de dados
	 public List<NotaFiscal> Consulta_Dados_Nota_Fiscal_Lista() {
    	List<NotaFiscal> ConsultaDadosDadosNotaFiscal = new ArrayList<NotaFiscal>();
    	String sql = "SELECT * FROM notafiscaltb";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NotaFiscal DadosNotaFiscal = new NotaFiscal();
				DadosNotaFiscal.setCodigoNotaFiscal(rs.getString("codigonota_nota"));
				DadosNotaFiscal.setCodigoVenda(rs.getString("codigovenda_nota"));
				DadosNotaFiscal.setClienteNome(rs.getString("nomecliente_nota"));
				DadosNotaFiscal.setPrecoTotal(rs.getDouble("precototal_nota"));
				DadosNotaFiscal.setDataEmissao(rs.getDate("dataemissao_nota"));
				DadosNotaFiscal.setHoraEmissao(rs.getTime("horaemissao_nota"));
				ConsultaDadosDadosNotaFiscal.add(DadosNotaFiscal);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosDadosNotaFiscal;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}