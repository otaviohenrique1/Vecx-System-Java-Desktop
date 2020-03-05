package moduloFuncionarioBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_funcionario_salario{
	public void Inserir_Dados_Funcionario_Salario(FuncionarioSalario InsereDadosSalarioFuncionario){
    	String sql = "INSERT INTO funcionariosalariotb (codigofuncionario_sal, funcionario_sal, cargo_sal,"
    				+ "estadocomissaobonus_sal, salariofuncionario_sal, valorbonus_sal, valorcomissao_sal, datacadastro_sal, horacadastro_sal,"
    				+ "codigoresponsavel_sal, funcionarioresponsavel_sal, cargoresponsavel_sal)" 
	    			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosSalarioFuncionario.getCodigoFuncionario());
    		stmt.setString(2, InsereDadosSalarioFuncionario.getNomeFuncionario());
    		stmt.setString(3, InsereDadosSalarioFuncionario.getCargoFuncionario());
    		stmt.setString(4, InsereDadosSalarioFuncionario.getEstadoComissaoBonus());
    		stmt.setDouble(5, InsereDadosSalarioFuncionario.getSalarioFuncionario());
            stmt.setDouble(6, InsereDadosSalarioFuncionario.getBonusSalario());
            stmt.setDouble(7, InsereDadosSalarioFuncionario.getComissaoSalario());
            stmt.setDate(8, InsereDadosSalarioFuncionario.getDataCadastro());
            stmt.setTime(9, InsereDadosSalarioFuncionario.getHoraCadastro());
            stmt.setString(10, InsereDadosSalarioFuncionario.getCodigoResponsavel());
            stmt.setString(11, InsereDadosSalarioFuncionario.getNomeResponsavel());
    		stmt.setString(12, InsereDadosSalarioFuncionario.getCargoResponsavel());
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