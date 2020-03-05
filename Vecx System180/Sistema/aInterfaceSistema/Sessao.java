package aInterfaceSistema;

public class Sessao {
	private static Sessao instance;
	public Sessao() {
		
	}
	public static Sessao getInstance() {
		if(instance == null){
			instance = new Sessao();
		}
		return instance;
	}
	//Maneira de acessar a classe
	//Aqui popula os atributos da sessão que você irá utilizar
	//Como usar a classe: Sessao sessao = Sessao.getInstance();
	
	/*Dados do login*/
	private String codigo, nome, login, senha, cargo;	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	/*Dados do cliente*/
	private String nomeCliente, codigoCliente , cpfCliente;
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getCPFCliente() {
		return cpfCliente;
	}
	public void setCPFCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	/*Dados do funcionario*/
	private String nomeFuncionario, codigoFuncionario , cargoFuncionario;
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	
	public String getCargoFuncionario() {
		return cargoFuncionario;
	}
	public void setCargoFuncionario(String cargoFuncionario) {
		this.cargoFuncionario = cargoFuncionario;
	}
	
	
	/*Dados do fornecedor*/
	private String nomeFornecedor, codigoFornecedor , cnpjFornecedor;
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public String getCodigoFornecedor() {
		return codigoFornecedor;
	}
	public void setCodigoFornecedor(String codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}
	public String getCNPJFornecedor() {
		return cnpjFornecedor;
	}
	public void setCNPJFornecedor(String cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
	}
	
	/*Dados do produto*/
	private String nomeProduto, codigoProduto , precoProduto, quantidadeProduto, loteProduto;
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(String precoProduto) {
		this.precoProduto = precoProduto;
	}
	public String getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(String quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	public String getLoteProduto() {
		return loteProduto;
	}
	public void setLoteProduto(String loteProduto) {
		this.loteProduto = loteProduto;
	}
	
	/*Dados do Estoque*/
	private String buscaProduto;
	public String getBuscaProduto() {
		return buscaProduto;
	}
	public void setBuscaProduto(String buscaProduto) {
		this.buscaProduto = buscaProduto;
	}
	
	
	/*Dados do Historico de compras*/
	private String compraCodigo, compraFuncionario;
	public String getCompraCodigo() {
		return compraCodigo;
	}
	public void setCompraCodigo(String compraCodigo) {
		this.compraCodigo = compraCodigo;
	}
	public String getCompraFuncionario() {
		return compraFuncionario;
	}
	public void setCompraFuncionario(String compraFuncionario) {
		this.compraFuncionario = compraFuncionario;
	}
	
	/*Dados do Historico de vendas*/
	private String vendaCodigo, vendaCliente, vendaFuncionario, VendaNome;
	public String getVendaCodigo() {
		return vendaCodigo;
	}
	public void setVendaCodigo(String vendaCodigo) {
		this.vendaCodigo = vendaCodigo;
	}
	public String getVendaCliente() {
		return vendaCliente;
	}
	public void setVendaCliente(String vendaCliente) {
		this.vendaCliente = vendaCliente;
	}
	public String getVendaFuncionario() {
		return vendaFuncionario;
	}
	public void setVendaFuncionario(String vendaFuncionario) {
		this.vendaFuncionario = vendaFuncionario;
	}
	public String getVendaNome() {
		return VendaNome;
	}
	public void setVendaNome(String VendaNome) {
		this.VendaNome = VendaNome;
	}
	
	/*Dados do Transporte de cargas*/
	private String transporteCargasCodigo, transporteCargasFuncionario, transporteCargasCliente;
	public String getTransporteCargasCodigo() {
		return transporteCargasCodigo;
	}
	public void setTransporteCargasCodigo(String transporteCargasCodigo) {
		this.transporteCargasCodigo = transporteCargasCodigo;
	}
	public String getTransporteCargasFuncionario() {
		return transporteCargasFuncionario;
	}
	public void setTransporteCargasFuncionario(String transporteCargasFuncionario) {
		this.transporteCargasFuncionario = transporteCargasFuncionario;
	}
	public String getTransporteCargasCliente() {
		return transporteCargasCliente;
	}
	public void setTransporteCargasCliente(String transporteCargasCliente) {
		this.transporteCargasCliente = transporteCargasCliente;
	}
	
	
	/*Dados do AcessoLog*/
	private String acessoCodigo, acessoFuncionario, acessoCargo;
	public String getAcessoCodigo() {
		return acessoCodigo;
	}
	public void setAcessoCodigo(String acessoCodigo) {
		this.acessoCodigo = acessoCodigo;
	}
	public String getAcessoFuncionario() {
		return acessoFuncionario;
	}
	public void setAcessoFuncionario(String acessoFuncionario) {
		this.acessoFuncionario = acessoFuncionario;
	}
	public String getAcessoCargo() {
		return acessoCargo;
	}
	public void setAcessoCargo(String acessoCargo) {
		this.acessoCargo = acessoCargo;
	}
	
	/*Dados do Nota Fiscal*/
	private String codigoNotaFiscal, codigoCompraNotaFiscal;
	public String getCodigoNotaFiscal() {
		return codigoNotaFiscal;
	}
	public void setCodigoNotaFiscal(String codigoNotaFiscal) {
		this.codigoNotaFiscal = codigoNotaFiscal;
	}
	public String getCodigoCompraNotaFiscal() {
		return codigoCompraNotaFiscal;
	}
	public void setCodigoCompraNotaFiscal(String codigoCompraNotaFiscal) {
		this.codigoCompraNotaFiscal = codigoCompraNotaFiscal;
	}
	
	/*Dados do Salario*/
	private String codigoFuncionarioSalario, nomeFuncionarioSalario, cargoFuncionarioSalario;
	public String getCodigoFuncionarioSalario() {
		return codigoFuncionarioSalario;
	}
	public void setCodigoFuncionarioSalario(String codigoFuncionarioSalario) {
		this.codigoFuncionarioSalario = codigoFuncionarioSalario;
	}
	public String getNomeFuncionarioSalario() {
		return nomeFuncionarioSalario;
	}
	public void setNomeFuncionarioSalario(String nomeFuncionarioSalario) {
		this.nomeFuncionarioSalario = nomeFuncionarioSalario;
	}
	public String getCargoFuncionarioSalario() {
		return cargoFuncionarioSalario;
	}
	public void setCargoFuncionarioSalario(String cargoFuncionarioSalario) {
		this.cargoFuncionarioSalario = cargoFuncionarioSalario;
	}
	
	/*Dados do Cadastro Cliente Venda*/
	private String cadastrarClienteVenda;
	public String getCadastrarClienteVenda() {
		return cadastrarClienteVenda;
	}
	public void setCadastrarClienteVenda(String cadastrarClienteVenda) {
		this.cadastrarClienteVenda = cadastrarClienteVenda;
	}
	
	/*Dados da Codigo da promoção*/
	private String codigoPromocaoFicha;
	public String getCodigoPromocaoFicha() {
		return codigoPromocaoFicha;
	}
	public void setCodigoPromocaoFicha(String codigoPromocaoFicha) {
		this.codigoPromocaoFicha = codigoPromocaoFicha;
	}
	
	/*Dados da Lista de produtos da promoção*/
	private String codigoPromocaoProdutos;
	public String getCodigoPromocaoProdutos() {
		return codigoPromocaoProdutos;
	}
	public void setCodigoPromocaoProdutos(String codigoPromocaoProdutos) {
		this.codigoPromocaoProdutos = codigoPromocaoProdutos;
	}
	
	/*Dados da Codigo do desconto*/
	private String codigoDescontoFicha;
	public String getCodigoDescontoFicha() {
		return codigoDescontoFicha;
	}
	public void setCodigoDescontoFicha(String codigoDescontoFicha) {
		this.codigoDescontoFicha = codigoDescontoFicha;
	}
	
	/*Dados da Data de trabalho e frequencia do funcionario*/
	private String dataTrabalhoFrequencia, frequenciaFuncionario;
	public String getDataTrabalhoFrequencia() {
		return dataTrabalhoFrequencia;
	}
	public void setDataTrabalhoFrequencia(String dataTrabalhoFrequencia) {
		this.dataTrabalhoFrequencia = dataTrabalhoFrequencia;
	}
	public String getFrequenciaFuncionario() {
		return frequenciaFuncionario;
	}
	public void setFrequenciaFuncionario(String frequenciaFuncionario) {
		this.frequenciaFuncionario = frequenciaFuncionario;
	}
}