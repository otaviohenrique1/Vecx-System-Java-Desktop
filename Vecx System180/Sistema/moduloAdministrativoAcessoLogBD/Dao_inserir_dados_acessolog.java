package moduloAdministrativoAcessoLogBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_acessolog{
	Connection Conectar =  new  ConectaBanco().Conecta();
	PreparedStatement stmt;
    //Parte que insere os dados no banco de dados
    public void Inserir_Dados_AcessoLog(AcessoLog InsereDadosAcessoLog){
    	String sql = "INSERT INTO acessologtb (nomefuncionario_log, cargo_log, codigofuncionario_log, login_log, senha_log,"
    				+ "dataacesso_log, horaacesso_log, codigoregistro_log)" 
    				+ "VALUES (?,?,?,?,?,?,?,?)";
    	try{
    		stmt = Conectar.prepareStatement(sql);
    		stmt.setString(1, InsereDadosAcessoLog.getFuncionarioNome());
    		stmt.setString(2, InsereDadosAcessoLog.getCargo());
    		stmt.setString(3, InsereDadosAcessoLog.getCodigoFuncionario());
    		stmt.setString(4, InsereDadosAcessoLog.getLogin());
    		stmt.setString(5, InsereDadosAcessoLog.getSenha());
            stmt.setDate(6, InsereDadosAcessoLog.getDataAcesso());
            stmt.setTime(7, InsereDadosAcessoLog.getHoraAcesso());
            stmt.setString(8, InsereDadosAcessoLog.getCodigoResgistro());
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