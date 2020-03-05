package moduloTransporteBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_transportecarga{
	//Parte que consulta os dados no banco de dados
	public List<TransporteCarga> Consulta_Dados_TransporteCarga_Lista () {
    	List<TransporteCarga> ConsultaDadosTransporteCarga = new ArrayList<TransporteCarga>();
    	String sql = "SELECT * FROM transportetb";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TransporteCarga DadosTransporteCarga = new TransporteCarga();
				DadosTransporteCarga.setCodigoTransporte(rs.getString("codigotransporte_transp"));
				DadosTransporteCarga.setFuncionarioResponsavel(rs.getString("nomeresponsavel_transp"));
				DadosTransporteCarga.setClienteNome(rs.getString("clientenome_transp"));
				DadosTransporteCarga.setEstadoCarga(rs.getString("estadocarga_transp"));
				ConsultaDadosTransporteCarga.add(DadosTransporteCarga);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosTransporteCarga;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<TransporteCarga> Consulta_Dados_TransporteCarga_Ficha (String transporteCodigo) {
    	List<TransporteCarga> ConsultaDadosTransporteCarga = new ArrayList<TransporteCarga>();
    	String sql = "SELECT * FROM transportetb WHERE codigotransporte_transp = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, transporteCodigo);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TransporteCarga DadosTransporteCarga = new TransporteCarga();
				DadosTransporteCarga.setCodigoTransporte(rs.getString("codigotransporte_transp"));
				DadosTransporteCarga.setFuncionarioResponsavel(rs.getString("nomeresponsavel_transp"));
				DadosTransporteCarga.setCargoResponsavel(rs.getString("cargoresponsavel_transp"));
				DadosTransporteCarga.setCodigoResponsavel(rs.getString("codigoresponsavel_transp"));
				DadosTransporteCarga.setClienteNome(rs.getString("clientenome_transp"));
				DadosTransporteCarga.setClienteCPF(rs.getString("cpfcliente_transp"));
				DadosTransporteCarga.setClienteRG(rs.getString("rgcliente_transp"));
				DadosTransporteCarga.setEnderecoCliente(rs.getString("enderecocliente_transp"));
				DadosTransporteCarga.setClienteNumero(rs.getString("numerocliente_transp"));
				DadosTransporteCarga.setClienteBairro(rs.getString("bairrocliente_transp"));
				DadosTransporteCarga.setClienteCidade(rs.getString("cidadecliente_transp"));
				DadosTransporteCarga.setTipoTransporte(rs.getString("tipotransporte_transp"));
				DadosTransporteCarga.setEstadoCarga(rs.getString("estadocarga_transp"));
				DadosTransporteCarga.setDataSaida(rs.getDate("datasaida_transp"));
				DadosTransporteCarga.setHoraSaida(rs.getTime("horasaida_transp"));
				DadosTransporteCarga.setDataChegada(rs.getDate("datachegada_transp"));
				DadosTransporteCarga.setHoraChegada(rs.getTime("horachegada_transp"));
				DadosTransporteCarga.setDataCadastro(rs.getDate("datacadastro_transp"));
				DadosTransporteCarga.setHoraCadastro(rs.getTime("horacadastro_transp"));
				DadosTransporteCarga.setFuncionarioCadastro(rs.getString("funcionarionome_transp"));
				DadosTransporteCarga.setCargoFuncionarioCadastro(rs.getString("cargofuncionario_transp"));
				DadosTransporteCarga.setCodigoFuncionarioCadastro(rs.getString("codigofuncionario_transp"));
				ConsultaDadosTransporteCarga.add(DadosTransporteCarga);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosTransporteCarga;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}