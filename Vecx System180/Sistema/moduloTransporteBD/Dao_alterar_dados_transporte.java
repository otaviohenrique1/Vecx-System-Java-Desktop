package moduloTransporteBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_alterar_dados_transporte{
	//Parte que altera os dados no banco de dados
	public void Altera_Dados_Cliente(TransporteCarga AlteraDadosTransporteCarga){
    	String sql = "UPDATE transportetb SET estadocarga_transp = ? WHERE codigotransporte_transp = ? AND clientenome_transp = ? AND cpfcliente_transp = ?";
    	try{
    		Connection Conectar =  new  ConectaBanco().Conecta();
    		//Connection Conectar =  new  ConnectionFactory().getConnection();
    		PreparedStatement stmt;
    		stmt = Conectar.prepareStatement(sql);
    		stmt.setString(1, AlteraDadosTransporteCarga.getEstadoCarga());
    		stmt.setString(2, AlteraDadosTransporteCarga.getCodigoTransporte());
            stmt.setString(3, AlteraDadosTransporteCarga.getClienteNome());
            stmt.setString(4, AlteraDadosTransporteCarga.getClienteCPF());
            stmt.execute();
            stmt.close();
            Conectar.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}