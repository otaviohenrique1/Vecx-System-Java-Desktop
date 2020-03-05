package moduloFinanceiroCompraBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_compra_historico{
    public void Inserir_Dados_Compra_Historico(CompraHistorico InsereDadosCompraHistorico){
    	String sql = "INSERT INTO historicoreposicaoestoquetb (codigocompra_hist_rep, funcionario_hist_rep, datacompra_hist_rep,"
    				+ "horacompra_hist_rep, precototal_hist_rep)" 
	    			+ "VALUES (?,?,?,?,?)";
    	try{
    		PreparedStatement stmt;
    		Connection Conecta = new ConectaBanco().Conecta();
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosCompraHistorico.getCodigoCompra());
    		stmt.setString(2, InsereDadosCompraHistorico.getNomeFuncionario());
            stmt.setDate(3, InsereDadosCompraHistorico.getDataCompra());
            stmt.setTime(4, InsereDadosCompraHistorico.getHoraCompra());
            stmt.setDouble(5, InsereDadosCompraHistorico.getPrecoTotal());
            stmt.execute();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}