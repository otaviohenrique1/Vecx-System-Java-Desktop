package moduloFinanceiroVendaBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_venda{
    public void Inserir_Dados_Venda(Venda InsereDadosVenda){
    	String sql = "INSERT INTO vendatb (nomefuncionario_ven, cargofuncionario_ven, codigofuncionario_ven, nomecliente_ven,"
    				+ "cpfcliente_ven, codigocliente_ven, codigovenda_ven, metodopagamento_ven, tipopagamento_ven, datavenda_ven,"
    				+ "horavenda_ven, notafiscalpaulista_ven, valortotal_ven, descontoporcentagem_ven, valortotaldesconto_ven,"
    				+ "quantidadeparcelas_ven, valortotalparcelado_ven)"
	                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conectar =  new  ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conectar.prepareStatement(sql);
    		stmt.setString(1, InsereDadosVenda.getNomeFuncionario());
    		stmt.setString(2, InsereDadosVenda.getCargoFuncionario());
    		stmt.setString(3, InsereDadosVenda.getCodigoFuncionario());
    		stmt.setString(4, InsereDadosVenda.getNomeCliente());
    		stmt.setString(5, InsereDadosVenda.getCPFCliente());
    		stmt.setString(6, InsereDadosVenda.getCodigoCliente());
    		stmt.setString(7, InsereDadosVenda.getCodigoVenda());
            stmt.setString(8, InsereDadosVenda.getMetodoPagamento());
            stmt.setString(9, InsereDadosVenda.getTipoPagamento());
            stmt.setDate(10, InsereDadosVenda.getDataVenda());
            stmt.setTime(11, InsereDadosVenda.getHoraVenda());
            stmt.setString(12, InsereDadosVenda.getNotaFiscal());
            stmt.setDouble(13, InsereDadosVenda.getPrecoTotal());
            stmt.setDouble(14, InsereDadosVenda.getDescontoPorcentagem());
            stmt.setDouble(15, InsereDadosVenda.getPrecoTotalDesconto());
            stmt.setInt(16, InsereDadosVenda.getQuantidadeParcelas());
            stmt.setDouble(17, InsereDadosVenda.getPrecoTotalParcelado());
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