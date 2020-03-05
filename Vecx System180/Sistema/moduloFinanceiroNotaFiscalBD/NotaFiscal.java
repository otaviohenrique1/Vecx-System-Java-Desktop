package moduloFinanceiroNotaFiscalBD;

import java.sql.Time;
import java.sql.Date;

public class NotaFiscal {
	private String funcionarioNome, clienteNome, enderecoCliente, codigoNotaFiscal, codigoFuncionario;
	private String codigoCliente, cargoFuncionario, telefoneCliente, codigoVenda, tipoNotaFiscal;
	private String numeroCliente, bairroCliente, cepCliente, estadoCliente, cidadeCliente, cpfCliente, celularCliente;
	private String tipoPagamento, metodoPagamento, notaFiscalPaulista;
	private Date dataEmissao;
	private Time horaEmissao;
	private double precoTotal, porcentagemDesconto, precoTotalDesconto, precoTotalParcelas;
	private int quantidadeParcelas;

	/*Construtor da classe*/
	public NotaFiscal() {
		
	}
	
	NotaFiscal(String funcionarioNome, String clienteNome, String enderecoCliente, Date dataEmissao, Time horaEmissao,
				String codigoNotaFiscal, String codigoFuncionario, String codigoCliente, String cargoFuncionario, String cpfCliente,
				String telefoneCliente, String codigoVenda, String tipoNotaFiscal, double precoTotal, double porcentagemDesconto, 
				double precoTotalDesconto, int quantidadeParcelas, double precoTotalParcelas, String numeroCliente, String bairroCliente,
				String cepCliente, String estadoCliente, String cidadeCliente, String celularCliente, String tipoPagamento,
				String metodoPagamento, String notaFiscalPaulista) {
					this.funcionarioNome = funcionarioNome;
					this.clienteNome = clienteNome;
					this.dataEmissao = dataEmissao;
					this.horaEmissao = horaEmissao;
					this.tipoPagamento = tipoPagamento;
					this.metodoPagamento = metodoPagamento;
					this.notaFiscalPaulista = notaFiscalPaulista;
					this.enderecoCliente = enderecoCliente;
					this.codigoNotaFiscal= codigoNotaFiscal;
					this.codigoFuncionario = codigoFuncionario;
					this.codigoCliente = codigoCliente;
					this.cargoFuncionario = cargoFuncionario;
					this.telefoneCliente = telefoneCliente;
					this.precoTotal= precoTotal;
					this.codigoVenda = codigoVenda;
					this.tipoNotaFiscal = tipoNotaFiscal;
					this.numeroCliente = numeroCliente;
					this.bairroCliente = bairroCliente;
					this.cepCliente = cepCliente;
					this.estadoCliente = estadoCliente;
					this.cidadeCliente = cidadeCliente;
					this.cpfCliente = cpfCliente;
					this.celularCliente = celularCliente;
					this.porcentagemDesconto = porcentagemDesconto;
					this.precoTotalDesconto = precoTotalDesconto;
					this.precoTotalParcelas = precoTotalParcelas;
					this.quantidadeParcelas = quantidadeParcelas;
	}
	
	/*Metodos get e set */
	/*get e set Nome do funcionario*/
	public String getFuncionarioNome() {
		return funcionarioNome;
	}
	public void setFuncionarioNome(String nFuncionarioNome) {
		funcionarioNome = nFuncionarioNome;
	}
	
	/*get e set Nome do cliente*/
	public String getClienteNome() {
		return clienteNome;
	}
	public void setClienteNome(String nClienteNome) {
		clienteNome = nClienteNome;
	}
	
	/*get e set Data de Emissao*/
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date nDataEmissao) {
		dataEmissao = nDataEmissao;
	}
	
	/*get e set Hora de Emissao*/
	public Time getHoraEmissao() {
		return horaEmissao;
	}
	public void setHoraEmissao(Time nHoraEmissao) {
		horaEmissao = nHoraEmissao;
	}
	
	/*get e set Endereço do cliente*/
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String nEnderecoCliente) {
		enderecoCliente = nEnderecoCliente;
	}
	
	/*get e set Codigo da nota fiscal*/
	public String getCodigoNotaFiscal() {
		return codigoNotaFiscal;
	}
	public void setCodigoNotaFiscal(String nCodigoNotaFiscal) {
		codigoNotaFiscal = nCodigoNotaFiscal;
	}
	
	/*get e set Codigo do funcionario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String nCodigoFuncionario) {
		codigoFuncionario = nCodigoFuncionario;
	}
	
	/*get e set Codigo do cliente*/
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String nCodigoCliente) {
		codigoCliente = nCodigoCliente;
	}
	
	/*get e set Cargo do funcionario*/
	public String getCargoFuncionario() {
		return cargoFuncionario;
	}
	public void setCargoFuncionario(String nCargoFuncionario) {
		cargoFuncionario = nCargoFuncionario;
	}
	
	/*get e set Telefone do cliente*/
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String nTelefoneCliente) {
		telefoneCliente = nTelefoneCliente;
	}
	
	/*get e set Preço total da venda*/
	public double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(double nPrecoTotal) {
		precoTotal = nPrecoTotal;
	}
	
	/*get e set Codigo da venda*/
	public String getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(String nCodigoVenda) {
		codigoVenda = nCodigoVenda;
	}
	
	/*get e set Tipo de nota fiscal*/
	public String getTipoNotaFiscal() {
		return tipoNotaFiscal;
	}
	public void setTipoNotaFiscal(String nTipoNotaFiscal) {
		tipoNotaFiscal = nTipoNotaFiscal;
	}
	
	/*get e set Numero*/
	public String getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(String nNumeroCliente) {
		numeroCliente = nNumeroCliente;
	}
	
	/*get e set Bairro*/
	public String getBairroCliente() {
		return bairroCliente;
	}
	public void setBairroCliente(String nBairroCliente) {
		bairroCliente = nBairroCliente;
	}
	
	/*get e set CEP*/
	public String getCEPCliente() {
		return cepCliente;
	}
	public void setCEPCliente(String nCepCliente) {
		cepCliente = nCepCliente;
	}
	
	/*get e set Estado*/
	public String getEstadoCliente() {
		return estadoCliente;
	}
	public void setEstadoCliente(String nEstadoCliente) {
		estadoCliente = nEstadoCliente;
	}
	
	/*get e set Cidade*/
	public String getCidadeCliente() {
		return cidadeCliente;
	}
	public void setCidadeCliente(String nCidadeCliente) {
		cidadeCliente = nCidadeCliente;
	}
	
	/*get e set CPF do cliente*/
	public String getCPFCliente() {
		return cpfCliente;
	}
	public void setCPFCliente(String nCPFCliente) {
		cpfCliente = nCPFCliente;
	}
	
	/*get e set Valor da porcentagem do desconto*/
	public double getPorcentagemDesconto() {
		return porcentagemDesconto;
	}
	public void setPorcentagemDesconto(double nPorcentagemDesconto) {
		porcentagemDesconto = nPorcentagemDesconto;
	}
	
	/*get e set Preço total com desconto*/
	public double getPrecoTotalDesconto() {
		return precoTotalDesconto;
	}
	public void setPrecoTotalDesconto(double nPrecoTotalDesconto) {
		precoTotalDesconto = nPrecoTotalDesconto;
	}
	
	/*get e set Preço de cada parcela*/
	public double getPrecoTotalParcelas() {
		return precoTotalParcelas;
	}
	public void setPrecoTotalParcelas(double nPrecoTotalParcelas) {
		precoTotalParcelas = nPrecoTotalParcelas;
	}
	
	/*get e set Quantidade de parcelas*/
	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	public void setQuantidadeParcelas(int nQuantidadeParcelas) {
		quantidadeParcelas = nQuantidadeParcelas;
	}
	
	/*get e set Celular do cliente*/
	public String getCelularCliente() {
		return celularCliente;
	}
	public void setCelularCliente(String nCelularCliente) {
		celularCliente = nCelularCliente;
	}
	
	/*get e set Tipo de pagamento*/
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String nTipoPagamento) {
		tipoPagamento = nTipoPagamento;
	}
	
	/*get e set Metodo de pagamento*/
	public String getMetodoPagamento() {
		return metodoPagamento;
	}
	public void setMetodoPagamento(String nMetodoPagamento) {
		metodoPagamento = nMetodoPagamento;
	}
	
	/*get e set Nota fiscal paulista*/
	public String getNotaFiscalPaulista() {
		return notaFiscalPaulista;
	}
	public void setNotaFiscalPaulista(String nNotaFiscalPaulista) {
		notaFiscalPaulista = nNotaFiscalPaulista;
	}
}