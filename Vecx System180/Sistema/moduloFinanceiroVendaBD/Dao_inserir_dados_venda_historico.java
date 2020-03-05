package moduloFinanceiroVendaBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_venda_historico{
    public void Inserir_Dados_Venda_Historico(VendaHistorico InsereDadosVendaHistorico){
    	String sql = "INSERT INTO historicovendatb (codigovenda_hist_ven, cliente_hist_ven, funcionario_hist_ven, precototal_hist_ven,"
    				+ "datavenda_hist_ven, horavenda_hist_ven)"
	                + " VALUES (?,?,?,?,?,?)";
    	try{
    		Connection Conectar =  new  ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conectar.prepareStatement(sql);
    		stmt.setString(1, InsereDadosVendaHistorico.getCodigoVenda());
    		stmt.setString(2, InsereDadosVendaHistorico.getNomeCliente());
    		stmt.setString(3, InsereDadosVendaHistorico.getNomeFuncionario());    
            stmt.setDouble(4, InsereDadosVendaHistorico.getPrecoTotal());
            stmt.setDate(5, InsereDadosVendaHistorico.getDataVenda());
            stmt.setTime(6, InsereDadosVendaHistorico.getHoraVenda());
            stmt.execute();
            stmt.close();
            Conectar.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}