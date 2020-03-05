package moduloFinanceiroVendaBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_consulta_dados_venda_ficha{
	//Parte que consulta os dados no banco de dados
    public List<Venda> Consulta_Dados_Venda_Ficha(String codigoVenda, String clienteVenda, String funcionarioVenda) {
    	List<Venda> ConsultaDadosVenda = new ArrayList<Venda>();
    	String sql = "SELECT * FROM vendatb WHERE codigovenda_ven = ? AND nomecliente_ven = ? AND nomefuncionario_ven = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoVenda);
			stmt.setString(2, clienteVenda);
			stmt.setString(3, funcionarioVenda);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Venda DadosVenda = new Venda();
				DadosVenda.setCodigoVenda(rs.getString("codigovenda_ven"));
				DadosVenda.setNomeFuncionario(rs.getString("nomefuncionario_ven"));
				DadosVenda.setCargoFuncionario(rs.getString("cargofuncionario_ven"));
				DadosVenda.setCodigoFuncionario(rs.getString("codigofuncionario_ven"));
				DadosVenda.setNomeCliente(rs.getString("nomecliente_ven"));
				DadosVenda.setCPFCliente(rs.getString("cpfcliente_ven"));
				DadosVenda.setCodigoCliente(rs.getString("codigocliente_ven"));
				DadosVenda.setTipoPagamento(rs.getString("tipopagamento_ven"));
				DadosVenda.setMetodoPagamento(rs.getString("metodopagamento_ven"));
				DadosVenda.setDataVenda(rs.getDate("datavenda_ven"));
				DadosVenda.setHoraVenda(rs.getTime("horavenda_ven"));
				DadosVenda.setNotaFiscal(rs.getString("notafiscalpaulista_ven"));
				DadosVenda.setPrecoTotal(rs.getDouble("valortotal_ven"));
				DadosVenda.setDescontoPorcentagem(rs.getDouble("descontoporcentagem_ven"));
				DadosVenda.setPrecoTotalDesconto(rs.getDouble("valortotaldesconto_ven"));
				DadosVenda.setQuantidadeParcelas(rs.getInt("quantidadeparcelas_ven"));
				DadosVenda.setPrecoTotalParcelado(rs.getDouble("valortotalparcelado_ven"));
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