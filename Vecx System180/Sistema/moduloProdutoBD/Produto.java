package moduloProdutoBD;

import java.sql.Date;
import java.sql.Time;

public class Produto {
	private String nome, marca, garantia, garantiaUnidade, descricao, fornecedor, fornecedorCNPJ,tipoProduto, lote, origemProduto;
	private String peso, altura, comprimento, largura, espessura, profundidade, cor, montagem;
	private String pesoUnidade, alturaUnidade, comprimentoUnidade, larguraUnidade, espessuraUnidade, profundidadeUnidade;
	private String embalagem, tipoEmbalagem, estampa, tipoEstampa, acessorios, codigoFuncionario, quantidadeUnidade;
	private String aplicacao, modelo, vidaUtil, vidaUtilUnidade, codigoProduto, funcionarioCadastro, codigoBarras, cargoFuncionario;
	private double precoCompra,precoaVista, quantidade;
	private int quantidadeComponentes;
	private Date dataPrimeiraCompra, dataFabricacao, dataValidade, dataCadastro;
	private Time horaCadastro;
	
	/*Construtor da classe*/
	public Produto() {
		
	}
	
	Produto(String nome, String marca, String garantia, String descricao, String fornecedor, String fornecedorCNPJ, String tipoProduto, String lote, 
			String origemProduto, String garantiaUnidade, String peso, String altura, String comprimento, String largura,
			String espessura, String profundidade, String cor, String montagem, String aplicacao, String modelo, String quantidadeUnidade,
			String codigoProduto, String vidaUtil, String embalagem, String tipoEmbalagem, String estampa, String tipoEstampa, String vidaUtilUnidade,
			String acessorios, String funcionarioCadastro, String codigoFuncionario, String codigoBarras, String cargoFuncionario,
			String pesoUnidade, String alturaUnidade, String comprimentoUnidade, String larguraUnidade, String espessuraUnidade, String profundidadeUnidade,
			double precoCompra, double precoaVista, double quantidade, int quantidadeComponentes, Date dataPrimeiraCompra,
			Date dataFabricacao, Date dataValidade, Date dataCadastro, Time horaCadastro){
				this.nome = nome;
				this.marca = marca;
				this.garantia = garantia;
				this.garantiaUnidade = garantiaUnidade;
				this.descricao = descricao;
				this.fornecedor = fornecedor;
				this.fornecedorCNPJ = fornecedorCNPJ;
				this.tipoProduto = tipoProduto;
				this.lote = lote;
				this.origemProduto = origemProduto;
				this.precoCompra = precoCompra;
				this.precoaVista = precoaVista;
				this.peso = peso;
				this.altura = altura;
				this.comprimento = comprimento;
				this.largura = largura; 
				this.espessura = espessura; 
				this.profundidade = profundidade;
				this.pesoUnidade = pesoUnidade;
				this.alturaUnidade = alturaUnidade;
				this.comprimentoUnidade = comprimentoUnidade;
				this.larguraUnidade = larguraUnidade;
				this.espessuraUnidade = espessuraUnidade;
				this.profundidadeUnidade = profundidadeUnidade;
				this.montagem = montagem;
				this.embalagem = embalagem;
				this.tipoEmbalagem = tipoEmbalagem;
				this.estampa = estampa;
				this.tipoEstampa = tipoEstampa; 
				this.acessorios = acessorios;
				this.aplicacao = aplicacao;
				this.modelo = modelo;
				this.vidaUtil = vidaUtil;
				this.vidaUtilUnidade = vidaUtilUnidade;
				this.quantidadeComponentes = quantidadeComponentes;
				this.quantidade = quantidade;
				this.quantidadeUnidade = quantidadeUnidade;
				this.codigoProduto = codigoProduto;
				this.codigoFuncionario = codigoFuncionario;
				this.codigoBarras = codigoBarras;
				this.funcionarioCadastro = funcionarioCadastro;
				this.cargoFuncionario = cargoFuncionario;
				this.dataPrimeiraCompra = dataPrimeiraCompra;
				this.dataFabricacao = dataFabricacao;
				this.dataValidade = dataValidade;
				this.dataCadastro = dataCadastro;
				this.horaCadastro = horaCadastro;
	}
	
	/*Metodos get e set */
	/*get e set Nome*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nNome) {
		nome = nNome;
	}
	
	/*get e set Marca*/
	public String getMarca() {
		return marca;
	}
	public void setMarca(String nMarca) {
		marca = nMarca;
	}
	
	/*get e set Garantia*/
	public String getGarantia() {
		return garantia;
	}
	public void setGarantia(String nGarantia) {
		garantia = nGarantia;
	}
	
	/*get e set Descricao*/
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String nDescricao) {
		descricao = nDescricao;
	}
	
	/*get e set Fornecedor*/
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String nFornecedor) {
		fornecedor = nFornecedor;
	}
	
	/*get e set CNPJ do fornecedor*/
	public String getFornecedorCNPJ() {
		return fornecedorCNPJ;
	}
	public void setFornecedorCNPJ(String nFornecedorCNPJ) {
		fornecedorCNPJ = nFornecedorCNPJ;
	}
	
	/*get e set Tipo de produto*/
	public String getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(String nTipoProduto) {
		tipoProduto = nTipoProduto;
	}
	
	/*get e set Lote*/
	public String getLote() {
		return lote;
	}
	public void setLote(String nLote) {
		lote = nLote;
	}
		
	/*get e set Origem do produto*/
	public String getOrigemProduto() {
		return origemProduto;
	}
	public void setOrigemProduto(String nOrigemProduto) {
		origemProduto = nOrigemProduto;
	}
	
	/*get e set Preco de compra*/
	public double getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(double nPrecoCompra) {
		precoCompra = nPrecoCompra;
	}
	
	/*get e set Peso*/
	public String getPeso() {
		return peso;
	}
	public void setPeso(String nPeso) {
		peso = nPeso;
	}
	
	/*get e set Altura*/
	public String getAltura() {
		return altura;
	}
	public void setAltura(String nAltura) {
		altura = nAltura;
	}
	
	/*get e set Comprimento*/
	public String getComprimento() {
		return comprimento;
	}
	public void setComprimento(String nComprimento) {
		comprimento = nComprimento;
	}
	
	/*get e set Largura*/
	public String getLargura() {
		return largura;
	}
	public void setLargura(String nLargura) {
		largura = nLargura;
	}
	
	/*get e set Espessura*/
	public String getEspessura() {
		return espessura;
	}
	public void setEspessura(String nEspessura) {
		espessura = nEspessura;
	}
	
	/*get e set Profundidade*/
	public String getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(String nProfundidade) {
		profundidade = nProfundidade;
	}
	
	/*get e set Pre�o a vista*/
	public double getPrecoaVista() {
		return precoaVista;
	}
	public void setPrecoaVista(double nPrecoaVista) {
		precoaVista = nPrecoaVista;
	}
	
	/*get e set Quantidade*/
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double nQuantidade) {
		quantidade = nQuantidade;
	}
	
	/*get e set Quantidade unidade*/
	public String getQuantidadeUnidade() {
		return quantidadeUnidade;
	}
	public void setQuantidadeUnidade(String nQuantidadeUnidade) {
		quantidadeUnidade = nQuantidadeUnidade;
	}
	
	/*get e set Cor*/
	public String getCor() {
		return cor;
	}
	public void setCor(String nCor) {
		cor = nCor;
	}
	
	/*get e set Montagem*/
	public String getMontagem() {
		return montagem;
	}
	public void setMontagem(String nMontagem) {
		montagem = nMontagem;
	}
	
	/*get e set Embalagem*/
	public String getEmbalagem() {
		return embalagem;
	}
	public void setEmbalagem(String nEmbalagem) {
		embalagem = nEmbalagem;
	}
	
	/*get e set Tipo de embalagem*/
	public String getTipoEmbalagem() {
		return tipoEmbalagem;
	}
	public void setTipoEmbalagem(String nTipoEmbalagem) {
		tipoEmbalagem = nTipoEmbalagem;
	}
	
	/*get e set Estampa*/
	public String getEstampa() {
		return estampa;
	}
	public void setEstampa(String nEstampa) {
		estampa = nEstampa;
	}
	
	/*get e set Tipo de estampa*/
	public String getTipoEstampa() {
		return tipoEstampa;
	}
	public void setTipoEstampa(String nTipoEstampa) {
		tipoEstampa = nTipoEstampa;
	}
	
	/*get e set Acessorios*/
	public String getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(String nAcessorios) {
		acessorios = nAcessorios;
	}
	
	/*get e set Quantidade de componentes*/
	public int getQuantidadeComponentes() {
		return quantidadeComponentes;
	}
	public void setQuantidadeComponentes(int nQuantidadeComponentes) {
		quantidadeComponentes = nQuantidadeComponentes;
	}
	
	/*get e set Aplica��o*/
	public String getAplicacao() {
		return aplicacao;
	}
	public void setAplicacao(String nAplicacao) {
		aplicacao = nAplicacao;
	}
	
	/*get e set Modelo*/
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String nModelo) {
		modelo = nModelo;
	}
	
	/*get e set Vida util*/
	public String getVidaUtil() {
		return vidaUtil;
	}
	public void setVidaUtil(String nVidaUtil) {
		vidaUtil = nVidaUtil;
	}
	
	/*get e set Codigo do produto*/
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String nCodigoProduto) {
		codigoProduto = nCodigoProduto;
	}	
	
	/*get e set Nome do funcionario*/
	public String getFuncionarioCadastro() {
		return funcionarioCadastro;
	}
	public void setFuncionarioCadastro(String nFuncionarioCadastro) {
		funcionarioCadastro = nFuncionarioCadastro;
	}
	
	/*get e set Codigo do funcioario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}
	
	/*get e set Cargo do funcionario*/
	public String getCargoFuncionario() {
		return cargoFuncionario;
	}
	public void setCargoFuncionario(String nCargoFuncionario) {
		cargoFuncionario = nCargoFuncionario;
	}
	
	/*get e set Codigo de barras*/
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String nCodigoBarras) {
		codigoBarras = nCodigoBarras;
	}
	
	/*get e set Data da primeira compra*/
	public Date getDataPrimeiraCompra() {
		return dataPrimeiraCompra;
	}
	public void setDataPrimeiraCompra(Date nDataPrimeiraCompra) {
		dataPrimeiraCompra = nDataPrimeiraCompra;
	}

	/*get e set Data de fabricacao*/
	public Date getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(Date nDataFabricacao) {
		dataFabricacao = nDataFabricacao;
	}

	/*get e set Data de validade*/
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date nDataValidade) {
		dataValidade = nDataValidade;
	}
	
	/*get e set Data de cadastro*/
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date nDataCadastro) {
		dataCadastro = nDataCadastro;
	}
	
	/*get e set Hora de cadastro*/
	public Time getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(Time nHoraCadastro) {
		horaCadastro = nHoraCadastro;
	}
	
	/*get e set Espessura unidade*/
	public String getEspessuraUnidade() {
		return espessuraUnidade;
	}
	public void setEspessuraUnidade(String nEspessuraUnidade) {
		espessuraUnidade = nEspessuraUnidade;
	}
	
	/*get e set Largura unidade*/
	public String getLarguraUnidade() {
		return larguraUnidade;
	}
	public void setLarguraUnidade(String nLarguraUnidade) {
		larguraUnidade = nLarguraUnidade;
	}
	
	/*get e set Comprimento unidade*/
	public String getComprimentoUnidade() {
		return comprimentoUnidade;
	}
	public void setComprimentoUnidade(String nComprimentoUnidade) {
		comprimentoUnidade = nComprimentoUnidade;
	}
	
	/*get e set Altura unidade*/
	public String getAlturaUnidade() {
		return alturaUnidade;
	}
	public void setAlturaUnidade(String nAlturaUnidade) {
		alturaUnidade = nAlturaUnidade;
	}
	
	/*get e set Peso unidade*/
	public String getPesoUnidade() {
		return pesoUnidade;
	}
	public void setPesoUnidade(String nPesoUnidade) {
		pesoUnidade = nPesoUnidade;
	}
	
	/*get e set Profundidade unidade*/
	public String getProfundidadeUnidade() {
		return profundidadeUnidade;
	}
	public void setProfundidadeUnidade(String nProfundidadeUnidade) {
		profundidadeUnidade = nProfundidadeUnidade;
	}
	
	/*get e set Vida util unidade*/
	public String getVidaUtilUnidade() {
		return vidaUtilUnidade;
	}
	public void setVidaUtilUnidade(String nVidaUtilUnidade) {
		vidaUtilUnidade = nVidaUtilUnidade;
	}
	
	/*get e set Garantia unidade*/
	public String getGarantiaUnidade() {
		return garantiaUnidade;
	}
	public void setGarantiaUnidade(String nGarantiaUnidade) {
		garantiaUnidade = nGarantiaUnidade;
	}
}