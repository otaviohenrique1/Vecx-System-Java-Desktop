package moduloProdutoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_alterar_dados_produto{
	//Parte que altera os dados no banco de dados
	public void Altera_Dados_Produto(Produto AlteraDadosProduto){
    	String sql = "UPDATE produtotb SET nome_pro = ?, marca_pro = ?, lote_pro = ?, codigobarras_pro = ?, dataprimeiracompra_pro = ?, datafabricacao_pro = ?, datavalidade_pro = ?, "
    				+ "vidautil_pro = ?, vidautilunidade_pro = ?, precocompra_pro = ?, precovendaavista = ?, origemproduto_pro = ?, garantia_pro = ?,"
    				+ "garantiaunidade_pro = ?, fornecedor_pro = ?, fornecedorcnpj_pro = ?, tipoproduto_pro = ?, quantcomponetes_pro = ?, aplicacao_pro = ?, embalagem_pro = ?,"
    				+ "embalagemtipo_pro = ?, estampa_pro = ?, estampatipo_pro = ?, cor_pro = ?, modelo_pro = ?, montagem_pro = ?, acessorios_pro = ?, peso_pro = ?, pesounidade_pro = ?, "
    				+ "altura_pro = ?, alturaunidade_pro = ?, comprimento_pro = ?, comprimentounidade_pro = ?, largura_pro = ?, larguraunidade_pro = ?, profundidade_pro = ?,"
    				+ "profundidadeunidade_pro = ?, espessura_pro = ?, espessuraunidade_pro = ?, quantidade_pro = ?, quantidadeunidade_pro = ?, descricao_pro = ?"
	    			+ "WHERE codigoproduto_pro = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
            stmt.setString(1, AlteraDadosProduto.getNome());
    		stmt.setString(2, AlteraDadosProduto.getMarca());
            stmt.setString(3, AlteraDadosProduto.getLote());    
            stmt.setString(4, AlteraDadosProduto.getCodigoBarras());
            stmt.setDate(5, AlteraDadosProduto.getDataPrimeiraCompra());
    		stmt.setDate(6, AlteraDadosProduto.getDataFabricacao());
    		stmt.setDate(7, AlteraDadosProduto.getDataValidade());
    		stmt.setString(8, AlteraDadosProduto.getVidaUtil());
    		stmt.setString(9, AlteraDadosProduto.getVidaUtilUnidade());
            stmt.setDouble(10, AlteraDadosProduto.getPrecoCompra());
            stmt.setDouble(11, AlteraDadosProduto.getPrecoaVista());
            stmt.setString(12, AlteraDadosProduto.getOrigemProduto());
            stmt.setString(13, AlteraDadosProduto.getGarantia());
            stmt.setString(14, AlteraDadosProduto.getGarantiaUnidade());
            stmt.setString(15, AlteraDadosProduto.getFornecedor());
            stmt.setString(16, AlteraDadosProduto.getFornecedorCNPJ());
            stmt.setString(17, AlteraDadosProduto.getTipoProduto());
            stmt.setInt(18, AlteraDadosProduto.getQuantidadeComponentes());
            stmt.setString(19, AlteraDadosProduto.getAplicacao());
            stmt.setString(20, AlteraDadosProduto.getEmbalagem());
            stmt.setString(21, AlteraDadosProduto.getTipoEmbalagem());
            stmt.setString(22, AlteraDadosProduto.getEstampa());
            stmt.setString(23, AlteraDadosProduto.getTipoEstampa());
            stmt.setString(24, AlteraDadosProduto.getCor());
            stmt.setString(25, AlteraDadosProduto.getModelo());
            stmt.setString(26, AlteraDadosProduto.getMontagem());
            stmt.setString(27, AlteraDadosProduto.getAcessorios());
            stmt.setString(28, AlteraDadosProduto.getPeso());
            stmt.setString(29, AlteraDadosProduto.getPesoUnidade());
            stmt.setString(30, AlteraDadosProduto.getAltura());
            stmt.setString(31, AlteraDadosProduto.getAlturaUnidade());
            stmt.setString(32, AlteraDadosProduto.getComprimento());
            stmt.setString(33, AlteraDadosProduto.getComprimentoUnidade());
            stmt.setString(34, AlteraDadosProduto.getLargura());
            stmt.setString(35, AlteraDadosProduto.getLarguraUnidade());
            stmt.setString(36, AlteraDadosProduto.getProfundidade());
            stmt.setString(37, AlteraDadosProduto.getProfundidadeUnidade());
            stmt.setString(38, AlteraDadosProduto.getEspessura());
            stmt.setString(39, AlteraDadosProduto.getEspessuraUnidade());
            stmt.setDouble(40, AlteraDadosProduto.getQuantidade());
            stmt.setString(41, AlteraDadosProduto.getQuantidadeUnidade());
            stmt.setString(42, AlteraDadosProduto.getDescricao());
            stmt.setString(43, AlteraDadosProduto.getCodigoProduto());
            stmt.execute();
            stmt.close();
            Conecta.close();
        }
        catch(SQLException erro){
        	throw new RuntimeException(erro);
        	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void Altera_Dados_Produto_Produto_Estoque(EstoqueProdutos AlteraEstoqueProduto){
    	String sql = "UPDATE estoqueprodutotb SET "
    				+ "produto_est = ?, quantidade_est = ?, quantidadeunidade_est = ?, lote_est = ?, preco_est = ?"
	    			+ "WHERE codigoproduto_est = ?";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
    		stmt.setString(1, AlteraEstoqueProduto.getNome());
            stmt.setDouble(2, AlteraEstoqueProduto.getQuantidade());
            stmt.setString(3, AlteraEstoqueProduto.getQuantidadeUnidade());
            stmt.setString(4, AlteraEstoqueProduto.getLote());
            stmt.setDouble(5, AlteraEstoqueProduto.getPrecoaVista());
            stmt.setString(6, AlteraEstoqueProduto.getCodigoProduto());
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