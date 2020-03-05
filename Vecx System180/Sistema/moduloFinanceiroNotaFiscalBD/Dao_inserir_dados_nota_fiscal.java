package moduloFinanceiroNotaFiscalBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_nota_fiscal{
    public void Inserir_Dados_Nota_Fiscal(NotaFiscal InsereDadosNotaFiscal){
    	String sql = "INSERT INTO notafiscaltb (codigonota_nota, codigovenda_nota, dataemissao_nota, horaemissao_nota, tipopagamento_nota, metodopagamento_nota,"
    				+ "notafiscalpaulista_nota, nomecliente_nota, cpfcliente_nota , codigocliente_nota, telefonecliente_nota, celularcliente_nota , enderecocliente_nota,"
    				+ "numerocliente_nota, bairrocliente_nota, cepcliente_nota, estadocliente_nota, cidadecliente_nota, funcionarionome_nota,"
    				+ "codigofuncionario_nota, cargofuncionario_nota, tiponotafiscal_nota, precototal_nota, descontoporcentagem_nota,"
    				+ "valortotaldesconto_nota, quantidadeparcelas_nota, valortotalparcelado_nota)" 
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		PreparedStatement stmt;
    		Connection Conecta = new ConectaBanco().Conecta();
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosNotaFiscal.getCodigoNotaFiscal());
    		stmt.setString(2, InsereDadosNotaFiscal.getCodigoVenda());
    		stmt.setDate(3, InsereDadosNotaFiscal.getDataEmissao());
            stmt.setTime(4, InsereDadosNotaFiscal.getHoraEmissao());
            stmt.setString(5, InsereDadosNotaFiscal.getTipoPagamento());
            stmt.setString(6, InsereDadosNotaFiscal.getMetodoPagamento());
            stmt.setString(7, InsereDadosNotaFiscal.getNotaFiscalPaulista());
    		stmt.setString(8, InsereDadosNotaFiscal.getClienteNome());
    		stmt.setString(9, InsereDadosNotaFiscal.getCPFCliente());
    		stmt.setString(10, InsereDadosNotaFiscal.getCodigoCliente());
    		stmt.setString(11, InsereDadosNotaFiscal.getTelefoneCliente());
    		stmt.setString(12, InsereDadosNotaFiscal.getCelularCliente());
    		stmt.setString(13, InsereDadosNotaFiscal.getEnderecoCliente());
            stmt.setString(14, InsereDadosNotaFiscal.getNumeroCliente());
            stmt.setString(15, InsereDadosNotaFiscal.getBairroCliente());
    		stmt.setString(16, InsereDadosNotaFiscal.getCEPCliente());
            stmt.setString(17, InsereDadosNotaFiscal.getEstadoCliente());
            stmt.setString(18, InsereDadosNotaFiscal.getCidadeCliente());
            stmt.setString(19, InsereDadosNotaFiscal.getFuncionarioNome());
            stmt.setString(20, InsereDadosNotaFiscal.getCodigoFuncionario());
            stmt.setString(21, InsereDadosNotaFiscal.getCargoFuncionario());
    		stmt.setString(22, InsereDadosNotaFiscal.getTipoNotaFiscal());
    		stmt.setDouble(23, InsereDadosNotaFiscal.getPrecoTotal());
    		stmt.setDouble(24, InsereDadosNotaFiscal.getPorcentagemDesconto());
    		stmt.setDouble(25, InsereDadosNotaFiscal.getPrecoTotalDesconto());
    		stmt.setDouble(26, InsereDadosNotaFiscal.getQuantidadeParcelas());
    		stmt.setDouble(27, InsereDadosNotaFiscal.getPrecoTotalParcelas());
    		stmt.execute();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}