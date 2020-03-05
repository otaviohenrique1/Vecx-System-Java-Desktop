package moduloProdutoBD;

//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import aInterfaceSistema.ConectaBanco;
//import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas;

import java.sql.PreparedStatement;

public class Dao_consulta_dados_produto{
	//Parte que consulta os dados no banco de dados
	public List<EstoqueProdutos> Consulta_Dados_Produto_Estoque() {
    	List<EstoqueProdutos> ConsultaDadosProdutoEstoque = new ArrayList<EstoqueProdutos>();
    	String sql = "SELECT * FROM estoqueprodutotb";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EstoqueProdutos DadosEstoqueProdutos = new EstoqueProdutos();
				DadosEstoqueProdutos.setCodigoProduto(rs.getString("codigoproduto_est"));
				DadosEstoqueProdutos.setNome(rs.getString("produto_est"));
				DadosEstoqueProdutos.setQuantidade(rs.getDouble("quantidade_est"));
				DadosEstoqueProdutos.setQuantidadeUnidade(rs.getString("quantidadeunidade_est"));
				DadosEstoqueProdutos.setLote(rs.getString("lote_est"));
				DadosEstoqueProdutos.setPrecoaVista(rs.getDouble("preco_est"));
				DadosEstoqueProdutos.setEstadoProduto(rs.getString("estadoproduto_est"));
				ConsultaDadosProdutoEstoque.add(DadosEstoqueProdutos);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosProdutoEstoque;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	/*
	    	StringBuilder StringBuilderMenssagem = new StringBuilder(erro.toString());
	    	for (StackTraceElement ste : erro.getStackTrace()) {
	    		StringBuilderMenssagem.append("\n\tat ");
	    		StringBuilderMenssagem.append(ste);
			}
	    	String menssagemConteudo = StringBuilderMenssagem.toString();
	    	String menssagemTitulo = "Erro no SQL";
	    	Tela_que_Exibe_Menssagem_Texto_Varias_Linhas aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas(menssagemTitulo, menssagemConteudo);
	    	aviso.setVisible(true);
	    	*/
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
		//return ConsultaDadosProdutoEstoque;
    }	
	
	public List<Produto> Consulta_Dados_Produto_Ficha(String codigoProduto, String nomeProduto) {
    	List<Produto> ConsultaDadosProduto = new ArrayList<Produto>();
    	String sql = "SELECT * FROM produtotb WHERE codigoproduto_pro = ? AND nome_pro = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoProduto);
			stmt.setString(2, nomeProduto);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto DadosProduto = new Produto();
				DadosProduto.setNome(rs.getString("nome_pro"));
				DadosProduto.setMarca(rs.getString("marca_pro"));
				DadosProduto.setLote(rs.getString("lote_pro"));
				DadosProduto.setCodigoBarras(rs.getString("codigobarras_pro"));
				DadosProduto.setDataPrimeiraCompra(rs.getDate("dataprimeiracompra_pro"));
				DadosProduto.setDataFabricacao(rs.getDate("datafabricacao_pro"));
				DadosProduto.setDataValidade(rs.getDate("datavalidade_pro"));
				DadosProduto.setVidaUtil(rs.getString("vidautil_pro"));
				DadosProduto.setVidaUtilUnidade(rs.getString("vidautilunidade_pro"));
				DadosProduto.setCodigoProduto(rs.getString("codigoproduto_pro"));
				DadosProduto.setQuantidade(rs.getDouble("quantidade_pro"));
				DadosProduto.setQuantidadeUnidade(rs.getString("quantidadeunidade_pro"));
				DadosProduto.setPrecoCompra(rs.getDouble("precocompra_pro"));
				DadosProduto.setPrecoaVista(rs.getDouble("precovendaavista"));
				DadosProduto.setOrigemProduto(rs.getString("origemproduto_pro"));
				DadosProduto.setGarantia(rs.getString("garantia_pro"));
				DadosProduto.setGarantiaUnidade(rs.getString("garantiaunidade_pro"));
				DadosProduto.setFornecedor(rs.getString("fornecedor_pro"));
				DadosProduto.setFornecedorCNPJ(rs.getString("fornecedorcnpj_pro"));
				DadosProduto.setTipoProduto(rs.getString("tipoproduto_pro"));
				DadosProduto.setQuantidadeComponentes(rs.getInt("quantcomponetes_pro"));
				DadosProduto.setAplicacao(rs.getString("aplicacao_pro"));
				DadosProduto.setEmbalagem(rs.getString("embalagem_pro"));
				DadosProduto.setTipoEmbalagem(rs.getString("embalagemtipo_pro"));
				DadosProduto.setEstampa(rs.getString("estampa_pro"));
				DadosProduto.setTipoEstampa(rs.getString("estampatipo_pro"));
				DadosProduto.setCor(rs.getString("cor_pro"));
				DadosProduto.setModelo(rs.getString("modelo_pro"));
				DadosProduto.setMontagem(rs.getString("montagem_pro"));
				DadosProduto.setAcessorios(rs.getString("acessorios_pro"));
				DadosProduto.setPeso(rs.getString("peso_pro"));
				DadosProduto.setPesoUnidade(rs.getString("pesounidade_pro"));
				DadosProduto.setAltura(rs.getString("altura_pro"));
				DadosProduto.setAlturaUnidade(rs.getString("alturaunidade_pro"));
				DadosProduto.setComprimento(rs.getString("comprimento_pro"));
				DadosProduto.setComprimentoUnidade(rs.getString("comprimentounidade_pro"));
				DadosProduto.setLargura(rs.getString("largura_pro"));
				DadosProduto.setLarguraUnidade(rs.getString("larguraunidade_pro"));
				DadosProduto.setProfundidade(rs.getString("profundidade_pro"));
				DadosProduto.setProfundidadeUnidade(rs.getString("profundidadeunidade_pro"));
				DadosProduto.setEspessura(rs.getString("espessura_pro"));
				DadosProduto.setEspessuraUnidade(rs.getString("espessuraunidade_pro"));
				DadosProduto.setDescricao(rs.getString("descricao_pro"));
				DadosProduto.setFuncionarioCadastro(rs.getString("funcionarionome_pro"));
				DadosProduto.setCodigoFuncionario(rs.getString("codigofuncionario_pro"));
				DadosProduto.setCargoFuncionario(rs.getString("cargofuncionario_pro"));
				DadosProduto.setDataCadastro(rs.getDate("datacadastro_pro"));
				DadosProduto.setHoraCadastro(rs.getTime("horacadastro_pro"));
				ConsultaDadosProduto.add(DadosProduto);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosProduto;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<Produto> Consulta_Dados_Produto_Fornecedor(String fornecedorProduto) {
    	List<Produto> ConsultaDadosProduto = new ArrayList<Produto>();
    	String sql = "SELECT * FROM produtotb WHERE fornecedor_pro = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, fornecedorProduto);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto DadosProduto = new Produto();
				DadosProduto.setNome(rs.getString("nome_pro"));
				DadosProduto.setDataPrimeiraCompra(rs.getDate("dataprimeiracompra_pro"));
				DadosProduto.setCodigoProduto(rs.getString("codigoproduto_pro"));
				ConsultaDadosProduto.add(DadosProduto);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosProduto;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<Produto> Consulta_Dados_Produto_Pesquisa_Codigo_Barras(String codigoBarras) {
    	List<Produto> ConsultaDadosProduto = new ArrayList<Produto>();
    	String sql = "SELECT * FROM produtotb WHERE codigobarras_pro = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoBarras);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto DadosProduto = new Produto();
				DadosProduto.setNome(rs.getString("nome_pro"));
				DadosProduto.setPrecoaVista(rs.getDouble("precovendaavista"));
				DadosProduto.setCodigoProduto(rs.getString("codigoproduto_pro"));
				DadosProduto.setQuantidade(rs.getDouble("quantidade_pro"));
				DadosProduto.setQuantidadeUnidade(rs.getString("quantidadeunidade_pro"));
				ConsultaDadosProduto.add(DadosProduto);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosProduto;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<Produto> Consulta_Dados_Produto_Pesquisa_Codigo_Produto(String codigoProduto) {
    	List<Produto> ConsultaDadosProduto = new ArrayList<Produto>();
    	String sql = "SELECT * FROM produtotb WHERE codigoproduto_pro = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, codigoProduto);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto DadosProduto = new Produto();
				DadosProduto.setNome(rs.getString("nome_pro"));
				DadosProduto.setPrecoaVista(rs.getDouble("precovendaavista"));
				DadosProduto.setQuantidade(rs.getDouble("quantidade_pro"));
				DadosProduto.setQuantidadeUnidade(rs.getString("quantidadeunidade_pro"));
				ConsultaDadosProduto.add(DadosProduto);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosProduto;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	public List<Produto> Consulta_Dados_Produto_Pesquisa_Nome_Produto(String nomeProduto) {
    	List<Produto> ConsultaDadosProduto = new ArrayList<Produto>();
    	String sql = "SELECT * FROM produtotb WHERE nome_pro = ?";
		try{
			Connection Conecta = new ConectaBanco().Conecta();
			PreparedStatement stmt = Conecta.prepareStatement(sql);
			stmt.setString(1, nomeProduto);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto DadosProduto = new Produto();
				DadosProduto.setPrecoaVista(rs.getDouble("precovendaavista"));
				DadosProduto.setCodigoProduto(rs.getString("codigoproduto_pro"));
				DadosProduto.setQuantidade(rs.getDouble("quantidade_pro"));
				DadosProduto.setQuantidadeUnidade(rs.getString("quantidadeunidade_pro"));
				ConsultaDadosProduto.add(DadosProduto);
			}
			stmt.close();
	        Conecta.close();
	        return ConsultaDadosProduto;
	    }
	    catch(SQLException erro){
	    	throw new RuntimeException(erro);
	    	//JOptionPane.showMessageDialog(null,"Erro no comando SQL","Mensagem do Sistema",JOptionPane.ERROR_MESSAGE);
	    }
    }
}