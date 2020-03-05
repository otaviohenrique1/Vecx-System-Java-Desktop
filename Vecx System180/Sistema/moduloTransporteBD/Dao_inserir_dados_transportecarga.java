package moduloTransporteBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_transportecarga{
	public void Inserir_Dados_Transporte_Carga(TransporteCarga InsereDadosTransporte){
    	String sql = "INSERT INTO transportetb (codigotransporte_transp, nomeresponsavel_transp, cargoresponsavel_transp, codigoresponsavel_transp,"
    				+ "clientenome_transp, cpfcliente_transp, rgcliente_transp, enderecocliente_transp, numerocliente_transp, bairrocliente_transp,"
    				+ "cidadecliente_transp, codigovenda_transp, estadocarga_transp, tipotransporte_transp, datacadastro_transp, horacadastro_transp, datasaida_transp,"
    				+ "horasaida_transp, datachegada_transp, horachegada_transp, funcionarionome_transp, cargofuncionario_transp , codigofuncionario_transp)" 
    				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosTransporte.getCodigoTransporte());
    		stmt.setString(2, InsereDadosTransporte.getFuncionarioResponsavel());
            stmt.setString(3, InsereDadosTransporte.getCargoResponsavel());
            stmt.setString(4, InsereDadosTransporte.getCodigoResponsavel());
    		stmt.setString(5, InsereDadosTransporte.getClienteNome());
    		stmt.setString(6, InsereDadosTransporte.getClienteCPF());
    		stmt.setString(7, InsereDadosTransporte.getClienteRG());
    		stmt.setString(8, InsereDadosTransporte.getEnderecoCliente());
    		stmt.setString(9, InsereDadosTransporte.getClienteNumero());
    		stmt.setString(10, InsereDadosTransporte.getClienteBairro());
    		stmt.setString(11, InsereDadosTransporte.getClienteCidade());
    		stmt.setString(12, InsereDadosTransporte.getCodigoVenda());
    		stmt.setString(13, InsereDadosTransporte.getEstadoCarga());
    		stmt.setString(14, InsereDadosTransporte.getTipoTransporte());
            stmt.setDate(15, InsereDadosTransporte.getDataCadastro());
            stmt.setTime(16, InsereDadosTransporte.getHoraCadastro());
            stmt.setDate(17, InsereDadosTransporte.getDataSaida());
            stmt.setTime(18, InsereDadosTransporte.getHoraSaida());
            stmt.setDate(19, InsereDadosTransporte.getDataChegada());
            stmt.setTime(20, InsereDadosTransporte.getHoraChegada());
            stmt.setString(21, InsereDadosTransporte.getFuncionarioCadastro());
    		stmt.setString(22, InsereDadosTransporte.getCargoFuncionarioCadastro());
    		stmt.setString(23, InsereDadosTransporte.getCodigoFuncionarioCadastro());
            stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}