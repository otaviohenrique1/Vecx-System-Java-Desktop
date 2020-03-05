package moduloProdutoDescontoPromocaoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_promocao{
	public void Inserir_Dados_Promocao(Promocao InsereDadosPromocao){
    	String sql = "INSERT INTO promocaotb (codigopromocao_promo, nomepromocao_promo, estadopromocao_promo, descricao_promo, tipopromocao_promo, datainicio_promo, horainicio_promo,"
    				+ "datatermino_promo, horatermino_promo, datacadastro_promo, horacadastro_promo, nomeresponsavel_promo, cargoresponsavel_promo, codigoresponsavel_promo,"
    				+ "funcionariocadastro_promo, cargofuncionario_promo, codigofuncionario_promo)"
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosPromocao.getCodigoPromocao());
    		stmt.setString(2, InsereDadosPromocao.getNomePromocao());
    		stmt.setString(3, InsereDadosPromocao.getEstadoPromocao());
    		stmt.setString(4, InsereDadosPromocao.getDescricaoPromocao());
    		stmt.setString(5, InsereDadosPromocao.getTipoPromocao());
    		stmt.setDate(6, InsereDadosPromocao.getDataInicio());
    		stmt.setTime(7, InsereDadosPromocao.getHoraInicio());
    		stmt.setDate(8, InsereDadosPromocao.getDataTermino());
    		stmt.setTime(9, InsereDadosPromocao.getHoraTermino());
    		stmt.setDate(10, InsereDadosPromocao.getDataCadastro());
    		stmt.setTime(11, InsereDadosPromocao.getHoraCadastro());
    		stmt.setString(12, InsereDadosPromocao.getNomeResponsavel());
    		stmt.setString(13, InsereDadosPromocao.getCargoResponsavel());
    		stmt.setString(14, InsereDadosPromocao.getCodigoResponsavel());
    		stmt.setString(15, InsereDadosPromocao.getFuncionarioCadastro());
    		stmt.setString(16, InsereDadosPromocao.getCodigoFuncionario());
    		stmt.setString(17, InsereDadosPromocao.getCargoFuncionario());
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