package moduloFinanceiroNotaFiscalBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_nota_fiscal_ficha{
	//Parte que consulta os dados no banco de dados
    public List<NotaFiscal> Consulta_Dados_Nota_Fiscal_Ficha(String codigoNotaFiscal, String codigoCompra) {
    	List<NotaFiscal> ConsultaDadosDadosNotaFiscal = new ArrayList<NotaFiscal>();
    	String sql = "SELECT * FROM notafiscaltb WHERE codigonota_nota = ? AND codigovenda_nota = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoNotaFiscal);
			stmt.setString(2, codigoCompra);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NotaFiscal DadosNotaFiscal = new NotaFiscal();
				DadosNotaFiscal.setCodigoNotaFiscal(rs.getString("codigonota_nota"));
				DadosNotaFiscal.setCodigoVenda(rs.getString("codigovenda_nota"));
				DadosNotaFiscal.setDataEmissao(rs.getDate("dataemissao_nota"));
				DadosNotaFiscal.setHoraEmissao(rs.getTime("horaemissao_nota"));
				DadosNotaFiscal.setTipoPagamento(rs.getString("tipopagamento_nota"));
				DadosNotaFiscal.setMetodoPagamento(rs.getString("metodopagamento_nota"));
				DadosNotaFiscal.setNotaFiscalPaulista(rs.getString("notafiscalpaulista_nota"));
				DadosNotaFiscal.setClienteNome(rs.getString("nomecliente_nota"));
				DadosNotaFiscal.setCPFCliente(rs.getString("cpfcliente_nota"));
				DadosNotaFiscal.setCodigoCliente(rs.getString("codigocliente_nota"));
				DadosNotaFiscal.setTelefoneCliente(rs.getString("telefonecliente_nota"));
				DadosNotaFiscal.setCelularCliente(rs.getString("celularcliente_nota"));
				DadosNotaFiscal.setEnderecoCliente(rs.getString("enderecocliente_nota"));
				DadosNotaFiscal.setNumeroCliente(rs.getString("numerocliente_nota"));
				DadosNotaFiscal.setBairroCliente(rs.getString("bairrocliente_nota"));
				DadosNotaFiscal.setCEPCliente(rs.getString("cepcliente_nota"));
				DadosNotaFiscal.setEstadoCliente(rs.getString("estadocliente_nota"));
				DadosNotaFiscal.setCidadeCliente(rs.getString("cidadecliente_nota"));
				DadosNotaFiscal.setFuncionarioNome(rs.getString("funcionarionome_nota"));
				DadosNotaFiscal.setCargoFuncionario(rs.getString("codigofuncionario_nota"));
				DadosNotaFiscal.setCodigoFuncionario(rs.getString("cargofuncionario_nota"));
				DadosNotaFiscal.setTipoNotaFiscal(rs.getString("tiponotafiscal_nota"));
				DadosNotaFiscal.setPrecoTotal(rs.getDouble("precototal_nota"));
				DadosNotaFiscal.setPorcentagemDesconto(rs.getDouble("descontoporcentagem_nota"));
				DadosNotaFiscal.setPrecoTotalDesconto(rs.getDouble("valortotaldesconto_nota"));
				DadosNotaFiscal.setQuantidadeParcelas(rs.getInt("quantidadeparcelas_nota"));
				DadosNotaFiscal.setPrecoTotalParcelas(rs.getDouble("valortotalparcelado_nota"));
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