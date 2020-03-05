package moduloFinanceiroCompraBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_compra_ficha{
	//Parte que consulta os dados no banco de dados
    public List<Compra> Consulta_Dados_Compra_Ficha(String codigoCompra, String compraFuncionario) {
    	List<Compra> ConsultaDadosCompra = new ArrayList<Compra>();
    	String sql = "SELECT * FROM compratb WHERE codigocompra_com = ? AND nomefuncionario_com = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoCompra);
			stmt.setString(2, compraFuncionario);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Compra DadosCompra = new Compra();
				DadosCompra.setCodigoCompra(rs.getString("codigocompra_com"));
				DadosCompra.setNomeFuncionario(rs.getString("nomefuncionario_com"));
				DadosCompra.setCargoFuncionario(rs.getString("cargofuncionario_com"));
				DadosCompra.setCodigoFuncionario(rs.getString("codigofuncionario_com"));
				DadosCompra.setTipoPagamento(rs.getString("tipopagamento_com"));
				DadosCompra.setMetodoPagamento(rs.getString("metodopagamento_com"));
				DadosCompra.setDataCompra(rs.getDate("datacompra_com"));
				DadosCompra.setHoraCompra(rs.getTime("horacompra_com"));
				DadosCompra.setNotaFiscal(rs.getString("notafiscal_com"));
				DadosCompra.setPrecoTotal(rs.getDouble("valortotal_com"));
				DadosCompra.setDescontoPorcentagem(rs.getDouble("descontoporcentagem_com"));
				DadosCompra.setPrecoTotalDesconto(rs.getDouble("valortotaldesconto_com"));
				DadosCompra.setQuantidadeParcelas(rs.getInt("quantidadeparcelas_com"));
				DadosCompra.setPrecoTotalParcelado(rs.getDouble("valortotalparcelado_com"));
				ConsultaDadosCompra.add(DadosCompra);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosCompra;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}