package moduloProdutoDescontoPromocaoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_desconto{
	public void Inserir_Dados_Desconto(Desconto InsereDadosDesconto){
    	String sql = "INSERT INTO descontotb (codigodesconto_des, estadodesconto_des, codigoproduto_des, nomeproduto_des, preconormal_des, desconto_des, precodesconto_des,"
    				+ "datainicio_des, horainicio_des, datatermino_des, horatermino_des, datacadastro_des, horacadastro_des, nomeresponsavel_des,"
    				+ "cargoresponsavel_des, codigoresponsavel_des, funcionariocadastro_des, codigofuncionario_des, cargofuncionario_des)"
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosDesconto.getCodigoDesconto());
    		stmt.setString(2, InsereDadosDesconto.getEstadoDesconto());
    		stmt.setString(3, InsereDadosDesconto.getCodigoProduto());
    		stmt.setString(4, InsereDadosDesconto.getNomeProduto());
    		stmt.setDouble(5, InsereDadosDesconto.getPrecoNormal());
    		stmt.setDouble(6, InsereDadosDesconto.getDescontoPorcentagem());
    		stmt.setDouble(7, InsereDadosDesconto.getPrecoDesconto());
    		stmt.setDate(8, InsereDadosDesconto.getDataInicio());
    		stmt.setTime(9, InsereDadosDesconto.getHoraInicio());
    		stmt.setDate(10, InsereDadosDesconto.getDataTermino());
    		stmt.setTime(11, InsereDadosDesconto.getHoraTermino());
    		stmt.setDate(12, InsereDadosDesconto.getDataCadastro());
    		stmt.setTime(13, InsereDadosDesconto.getHoraCadastro());
    		stmt.setString(14, InsereDadosDesconto.getNomeResponsavel());
    		stmt.setString(15, InsereDadosDesconto.getCargoResponsavel());
    		stmt.setString(16, InsereDadosDesconto.getCodigoResponsavel());
    		stmt.setString(17, InsereDadosDesconto.getFuncionarioCadastro());
    		stmt.setString(18, InsereDadosDesconto.getCodigoFuncionario());
    		stmt.setString(19, InsereDadosDesconto.getCargoFuncionario());
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