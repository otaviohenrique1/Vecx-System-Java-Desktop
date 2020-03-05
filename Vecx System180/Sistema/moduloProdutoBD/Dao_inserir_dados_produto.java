package moduloProdutoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import aInterfaceSistema.ConectaBanco;

public class Dao_inserir_dados_produto{
	public void Inserir_Dados_Produto(Produto InsereDadosProduto){
    	String sql = "INSERT INTO produtotb (nome_pro, marca_pro, lote_pro, codigobarras_pro, dataprimeiracompra_pro, datafabricacao_pro, datavalidade_pro,"
	    			+ "vidautil_pro, vidautilunidade_pro, codigoproduto_pro, quantidade_pro, quantidadeunidade_pro, precocompra_pro, precovendaavista,"
	    			+ " origemproduto_pro, garantia_pro, garantiaunidade_pro, fornecedor_pro, fornecedorcnpj_pro, tipoproduto_pro,"
	    			+ "quantcomponetes_pro, aplicacao_pro, embalagem_pro, embalagemtipo_pro, estampa_pro, estampatipo_pro, cor_pro, modelo_pro, montagem_pro,"
	    			+ "acessorios_pro, peso_pro, pesounidade_pro, altura_pro, alturaunidade_pro, comprimento_pro, comprimentounidade_pro, largura_pro,"
	    			+ "larguraunidade_pro, profundidade_pro, profundidadeunidade_pro, espessura_pro, espessuraunidade_pro, descricao_pro,"
	    			+ "funcionarionome_pro, codigofuncionario_pro, cargofuncionario_pro, datacadastro_pro, horacadastro_pro)"
    				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try{
    		Connection Conecta = new ConectaBanco().Conecta();
    		PreparedStatement stmt;    		
    		stmt = Conecta.prepareStatement(sql);
            stmt.setString(1, InsereDadosProduto.getNome());
    		stmt.setString(2, InsereDadosProduto.getMarca());
            stmt.setString(3, InsereDadosProduto.getLote());    
            stmt.setString(4, InsereDadosProduto.getCodigoBarras());
            stmt.setDate(5, InsereDadosProduto.getDataPrimeiraCompra());
    		stmt.setDate(6, InsereDadosProduto.getDataFabricacao());
    		stmt.setDate(7, InsereDadosProduto.getDataValidade());
    		stmt.setString(8, InsereDadosProduto.getVidaUtil());
    		stmt.setString(9, InsereDadosProduto.getVidaUtilUnidade());
    		stmt.setString(10, InsereDadosProduto.getCodigoProduto());
    		stmt.setDouble(11, InsereDadosProduto.getQuantidade());
    		stmt.setString(12, InsereDadosProduto.getQuantidadeUnidade());
            stmt.setDouble(13, InsereDadosProduto.getPrecoCompra());
            stmt.setDouble(14, InsereDadosProduto.getPrecoaVista());
            stmt.setString(15, InsereDadosProduto.getOrigemProduto());
            stmt.setString(16, InsereDadosProduto.getGarantia());
            stmt.setString(17, InsereDadosProduto.getGarantiaUnidade());
            stmt.setString(18, InsereDadosProduto.getFornecedor());
            stmt.setString(19, InsereDadosProduto.getFornecedorCNPJ());
            stmt.setString(20, InsereDadosProduto.getTipoProduto());
            stmt.setInt(21, InsereDadosProduto.getQuantidadeComponentes());
            stmt.setString(22, InsereDadosProduto.getAplicacao());
            stmt.setString(23, InsereDadosProduto.getEmbalagem());
            stmt.setString(24, InsereDadosProduto.getTipoEmbalagem());
            stmt.setString(25, InsereDadosProduto.getEstampa());
            stmt.setString(26, InsereDadosProduto.getTipoEstampa());
            stmt.setString(27, InsereDadosProduto.getCor());
            stmt.setString(28, InsereDadosProduto.getModelo());
            stmt.setString(29, InsereDadosProduto.getMontagem());
            stmt.setString(30, InsereDadosProduto.getAcessorios());
            stmt.setString(31, InsereDadosProduto.getPeso());
            stmt.setString(32, InsereDadosProduto.getPesoUnidade());
            stmt.setString(33, InsereDadosProduto.getAltura());
            stmt.setString(34, InsereDadosProduto.getAlturaUnidade());
            stmt.setString(35, InsereDadosProduto.getComprimento());
            stmt.setString(36, InsereDadosProduto.getComprimentoUnidade());
            stmt.setString(37, InsereDadosProduto.getLargura());
            stmt.setString(38, InsereDadosProduto.getLarguraUnidade());
            stmt.setString(39, InsereDadosProduto.getProfundidade());
            stmt.setString(40, InsereDadosProduto.getProfundidadeUnidade());
            stmt.setString(41, InsereDadosProduto.getEspessura());
            stmt.setString(42, InsereDadosProduto.getEspessuraUnidade());
            stmt.setString(43, InsereDadosProduto.getDescricao());
            stmt.setString(44, InsereDadosProduto.getFuncionarioCadastro());
            stmt.setString(45, InsereDadosProduto.getCodigoFuncionario());
            stmt.setString(46, InsereDadosProduto.getCargoFuncionario());
            stmt.setDate(47, InsereDadosProduto.getDataCadastro());
            stmt.setTime(48, InsereDadosProduto.getHoraCadastro());
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