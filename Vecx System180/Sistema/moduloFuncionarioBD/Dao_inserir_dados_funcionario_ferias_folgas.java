package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_funcionario_ferias_folgas{
	public void Inserir_Dados_Funcionario_Ferias_Folga(FuncionarioFeriasFolga InsereDadosFeriasFolga){
    	String sql = "INSERT INTO controleferiastb (codigofuncionario_ferias, funcionario_ferias, cargo_ferias, tipoferiasfolga_ferias,"
    				+ "feriasduracao_ferias, feriasinicio_ferias, feriasfinal_ferias, totalferias_ferias, totalfolgas_ferias, "
    				+ "datacadastro_ferias, horacadastro_ferias, codigoresponsavel_ferias, responsavelcadastro_ferias, cargoresponsavel_ferias)" 
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosFeriasFolga.getCodigoFuncionario());
    		stmt.setString(2, InsereDadosFeriasFolga.getNomeFuncionario());
    		stmt.setString(3, InsereDadosFeriasFolga.getCargoFuncionario());
    		stmt.setString(4, InsereDadosFeriasFolga.getTipoFeriasFolga());
    		stmt.setString(5, InsereDadosFeriasFolga.getDuracaoFerias());
    		stmt.setDate(6, InsereDadosFeriasFolga.getDataInicio());
    		stmt.setDate(7, InsereDadosFeriasFolga.getDataFinal());
    		stmt.setInt(8, InsereDadosFeriasFolga.getTotalFerias());
    		stmt.setInt(9, InsereDadosFeriasFolga.getTotalFolgas());
    		stmt.setDate(10, InsereDadosFeriasFolga.getDataCadastro());
            stmt.setTime(11, InsereDadosFeriasFolga.getHoraCadastro());
            stmt.setString(12, InsereDadosFeriasFolga.getCodigoFuncionario());
            stmt.setString(13, InsereDadosFeriasFolga.getNomeFuncionario());
    		stmt.setString(14, InsereDadosFeriasFolga.getCargoFuncionario());
            stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException e){
        	throw new RuntimeException(e);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
}