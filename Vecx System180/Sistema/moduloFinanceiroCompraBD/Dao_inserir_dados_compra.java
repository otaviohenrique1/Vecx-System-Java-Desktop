package moduloFinanceiroCompraBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_compra{
    public void Inserir_Dados_Compra(Compra InsereDadosCompra){
    	String sql = "INSERT INTO compratb(codigocompra_com, nomefuncionario_com, cargofuncionario_com,  codigofuncionario_com ,"
    				+ "tipopagamento_com, metodopagamento_com, notafiscal_com, datacompra_com, horacompra_com, valortotal_com,"
    				+ "descontoporcentagem_com, valortotaldesconto_com, quantidadeparcelas_com, valortotalparcelado_com)" 
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		PreparedStatement stmt;
    		Connection Conecta = new ConectaBanco().Conecta();
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosCompra.getCodigoCompra());
    		stmt.setString(2, InsereDadosCompra.getNomeFuncionario());
    		stmt.setString(3, InsereDadosCompra.getCargoFuncionario());
    		stmt.setString(4, InsereDadosCompra.getCodigoFuncionario());
    		stmt.setString(5, InsereDadosCompra.getTipoPagamento());
            stmt.setString(6, InsereDadosCompra.getMetodoPagamento());
            stmt.setString(7, InsereDadosCompra.getNotaFiscal());
            stmt.setDate(8, InsereDadosCompra.getDataCompra());
            stmt.setTime(9, InsereDadosCompra.getHoraCompra());
            stmt.setDouble(10, InsereDadosCompra.getPrecoTotal());
            stmt.setDouble(11, InsereDadosCompra.getDescontoPorcentagem());
            stmt.setDouble(12, InsereDadosCompra.getPrecoTotalDesconto());
            stmt.setInt(13, InsereDadosCompra.getQuantidadeParcelas());
            stmt.setDouble(14, InsereDadosCompra.getPrecoTotalParcelado());
            stmt.execute();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}