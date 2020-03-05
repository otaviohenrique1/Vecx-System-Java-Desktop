package moduloProdutoDescontoPromocaoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_promocao_produtos{
	public void Inserir_Dados_Promocao(PromocaoProdutos InsereDadosPromocaoProdutos){
    	String sql = "INSERT INTO promocaolistatb (codigoproduto_promo_lis, nomeproduto_promo_lis, preconormal_promo_lis,"
    				+ "desconto_promo_lis, precodesconto_promo_lis, codigopromocao_promo_lis)"
	    			+ "VALUES (?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, InsereDadosPromocaoProdutos.getCodigoProduto());
    		stmt.setString(2, InsereDadosPromocaoProdutos.getNomeProduto());
    		stmt.setDouble(3, InsereDadosPromocaoProdutos.getPrecoNormal());
    		stmt.setDouble(4, InsereDadosPromocaoProdutos.getDescontoPorcentagem());
    		stmt.setDouble(5, InsereDadosPromocaoProdutos.getPrecoDesconto());
    		stmt.setString(6, InsereDadosPromocaoProdutos.getCodigoPromocao());
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