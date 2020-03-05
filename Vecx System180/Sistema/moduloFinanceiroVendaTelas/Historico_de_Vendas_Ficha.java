package moduloFinanceiroVendaTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import aInterfaceSistema.Sessao;
import moduloFinanceiroVendaBD.Dao_consulta_dados_venda_ficha;
import moduloFinanceiroVendaBD.Venda;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Historico_de_Vendas_Ficha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaVenda;
	private JButton voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Historico_de_Vendas_Ficha frame = new Historico_de_Vendas_Ficha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Historico_de_Vendas_Ficha() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Historico_de_Vendas_Ficha.class.getResource("/cImagens/Logo Janela.PNG")));
		setResizable(false);
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 420);
		setSize(800, 420);
		
		telaFichaVenda = new JPanel();
		telaFichaVenda.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaVenda.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaVenda);
		
		JPanel panelTitulo = new JPanel();
		telaFichaVenda.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Historico_de_Vendas_Ficha.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelDadosVenda = new JLabel("Dados da venda");
		panelTitulo2.add(labelDadosVenda);
		labelDadosVenda.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		String nomeUsuario = sessao.getNome();
		String cargoUsuario = sessao.getCargo();
		String codigoUsuario = sessao.getCodigo();
		
		JPanel menuBotoesJanela = new JPanel();
		panelTitulo.add(menuBotoesJanela, BorderLayout.CENTER);
		menuBotoesJanela.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JPanel menuBotoesJanela1 = new JPanel();
		menuBotoesJanela1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		menuBotoesJanela.add(menuBotoesJanela1);
		menuBotoesJanela1.setLayout(new BorderLayout(10, 0));
		
		JButton fichaUsuario = new JButton();
		fichaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sessao.setCodigoFuncionario(codigoUsuario);
				sessao.setNomeFuncionario(nomeUsuario);
				sessao.setCargoFuncionario(cargoUsuario);
				
				Ficha_do_Funcionario_Exibicao FichaFuncionario = new Ficha_do_Funcionario_Exibicao();
				FichaFuncionario.setVisible(true);
			}
		});
		fichaUsuario.setPreferredSize(new Dimension(30, 30));
		fichaUsuario.setIcon(new ImageIcon(Historico_de_Vendas_Ficha.class.getResource("/cImagens/Funcionario.png")));
		fichaUsuario.setToolTipText("Ficha do usuario");
		fichaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBotoesJanela1.add(fichaUsuario, BorderLayout.CENTER);
		
		JPanel panelDadosUsuario = new JPanel();
		menuBotoesJanela1.add(panelDadosUsuario, BorderLayout.WEST);
		panelDadosUsuario.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel nomeFuncionarioLogin = new JLabel("Nome: Usuario");
		panelDadosUsuario.add(nomeFuncionarioLogin);
		
		JLabel cargoFuncionarioLogin = new JLabel("Cargo: Cargo");
		panelDadosUsuario.add(cargoFuncionarioLogin);
		
		String nomeLogin, cargoLogin;
		if (nomeUsuario == null) {
			nomeLogin = "Usuario";
			nomeFuncionarioLogin.setText("Nome: " + nomeLogin);
		}
		else {
			nomeFuncionarioLogin.setText("Nome: " + nomeUsuario);
		}
		
		if (cargoUsuario == null) {
			cargoLogin = "Cargo";
			cargoFuncionarioLogin.setText("Cargo: " + cargoLogin);
		}
		else {
			cargoFuncionarioLogin.setText("Cargo: " + cargoUsuario);
		}
		
		JScrollPane scrollPaneCadastro = new JScrollPane();
		telaFichaVenda.add(scrollPaneCadastro, BorderLayout.CENTER);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNome_CPF_CodCliente = new JPanel();
		panelCadastro.add(panelNome_CPF_CodCliente);
		panelNome_CPF_CodCliente.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeCliente = new JPanel();
		panelNome_CPF_CodCliente.add(panelNomeCliente);
		panelNomeCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeCliente = new JLabel("Nome do cliente");
		labelNomeCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNomeCliente.add(labelNomeCliente);
		
		JLabel nomeCliente = new JLabel();
		nomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNomeCliente.add(nomeCliente);
		
		JPanel panelCPF_CodCliente = new JPanel();
		panelNome_CPF_CodCliente.add(panelCPF_CodCliente);
		panelCPF_CodCliente.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCPFCliente = new JPanel();
		panelCPFCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCPF_CodCliente.add(panelCPFCliente);
		panelCPFCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPFCliente = new JLabel("CPF");
		labelCPFCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCPFCliente.add(labelCPFCliente);
		
		JLabel cpfCliente = new JLabel();
		cpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCPFCliente.add(cpfCliente);
		
		JPanel panelCodigoCliente = new JPanel();
		panelCodigoCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCPF_CodCliente.add(panelCodigoCliente);
		panelCodigoCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoCliente = new JLabel("Codigo do cliente");
		labelCodigoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCodigoCliente.add(labelCodigoCliente);
		
		JLabel codigoCliente = new JLabel();
		codigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCodigoCliente.add(codigoCliente);
		
		JPanel panelNome_CodFun_Cargo = new JPanel();
		panelNome_CodFun_Cargo.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelNome_CodFun_Cargo);
		panelNome_CodFun_Cargo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeFuncionario = new JPanel();
		panelNomeFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome_CodFun_Cargo.add(panelNomeFuncionario);
		panelNomeFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeFuncionario = new JLabel("Funcionario responsavel pela venda");
		panelNomeFuncionario.add(labelNomeFuncionario);
		labelNomeFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel nomeFuncionario = new JLabel();
		panelNomeFuncionario.add(nomeFuncionario);
		nomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelCodFun_Cargo = new JPanel();
		panelNome_CodFun_Cargo.add(panelCodFun_Cargo);
		panelCodFun_Cargo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargo = new JPanel();
		panelCodFun_Cargo.add(panelCargo);
		panelCargo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargo = new JLabel("Cargo");
		panelCargo.add(labelCargo);
		labelCargo.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel cargo = new JLabel();
		panelCargo.add(cargo);
		cargo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelCodigoFuncionario = new JPanel();
		panelCodigoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodFun_Cargo.add(panelCodigoFuncionario);
		panelCodigoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoFuncionario = new JLabel("Codigo do funcionario");
		labelCodigoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCodigoFuncionario.add(labelCodigoFuncionario);
		
		JLabel codigoFuncionario = new JLabel();
		codigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCodigoFuncionario.add(codigoFuncionario);
		
		JPanel panelCodCom_DataHora_Pagamento = new JPanel();
		panelCadastro.add(panelCodCom_DataHora_Pagamento);
		panelCodCom_DataHora_Pagamento.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelCodigoVenda = new JPanel();
		panelCodigoVenda.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodCom_DataHora_Pagamento.add(panelCodigoVenda);
		panelCodigoVenda.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoVenda = new JLabel("Codigo da venda");
		panelCodigoVenda.add(labelCodigoVenda);
		labelCodigoVenda.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel codigoVenda = new JLabel();
		panelCodigoVenda.add(codigoVenda);
		codigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelDataHoraCompra = new JPanel();
		panelCodCom_DataHora_Pagamento.add(panelDataHoraCompra);
		panelDataHoraCompra.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHoraCompra.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraVenda = new JLabel("Data e hora da compra");
		panelDataHoraCompra.add(labelDataHoraVenda);
		labelDataHoraVenda.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraVenda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel dataHoraCompra = new JLabel();
		panelDataHoraCompra.add(dataHoraCompra);
		dataHoraCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelNotaFiscalPaulista = new JPanel();
		panelCodCom_DataHora_Pagamento.add(panelNotaFiscalPaulista);
		panelNotaFiscalPaulista.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNotaFiscalPaulista.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNotaFiscalPaulista = new JLabel("Nota fiscal paulista");
		panelNotaFiscalPaulista.add(labelNotaFiscalPaulista);
		labelNotaFiscalPaulista.setHorizontalAlignment(SwingConstants.LEFT);
		labelNotaFiscalPaulista.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel notaFiscalPaulista = new JLabel();
		panelNotaFiscalPaulista.add(notaFiscalPaulista);
		notaFiscalPaulista.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelNotaFiscalPaulista_ValorTotal = new JPanel();
		panelCadastro.add(panelNotaFiscalPaulista_ValorTotal);
		panelNotaFiscalPaulista_ValorTotal.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelTipoPagamento = new JPanel();
		panelNotaFiscalPaulista_ValorTotal.add(panelTipoPagamento);
		panelTipoPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoPagamento = new JLabel("Tipo de pagamento");
		labelTipoPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTipoPagamento.add(labelTipoPagamento);
		
		JLabel tipoPagamento = new JLabel();
		tipoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTipoPagamento.add(tipoPagamento);
		
		JPanel panelMetodoPagamento = new JPanel();
		panelNotaFiscalPaulista_ValorTotal.add(panelMetodoPagamento);
		panelMetodoPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelMetodoPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelMetodoPagamento = new JLabel("Metodo de pagamento");
		panelMetodoPagamento.add(labelMetodoPagamento);
		labelMetodoPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		labelMetodoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel metodoPagamento = new JLabel();
		panelMetodoPagamento.add(metodoPagamento);
		metodoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelPrecoTotal = new JPanel();
		panelPrecoTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNotaFiscalPaulista_ValorTotal.add(panelPrecoTotal);
		panelPrecoTotal.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoTotal = new JLabel("Pre\u00E7o total (R$):");
		labelPrecoTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelPrecoTotal.add(labelPrecoTotal);
		
		JLabel precoTotal = new JLabel();
		precoTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		precoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPrecoTotal.add(precoTotal);
		
		JPanel panelPrecoParcelado_Desconto = new JPanel();
		panelCadastro.add(panelPrecoParcelado_Desconto);
		panelPrecoParcelado_Desconto.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelPrecoParcelado = new JPanel();
		panelPrecoParcelado_Desconto.add(panelPrecoParcelado);
		panelPrecoParcelado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoParcelado.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoParcelado = new JLabel("Pre\u00E7o parcelado (A prazo) (R$):");
		labelPrecoParcelado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelPrecoParcelado.add(labelPrecoParcelado);
		
		JLabel precoParcelado = new JLabel();
		precoParcelado.setHorizontalAlignment(SwingConstants.RIGHT);
		precoParcelado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelPrecoParcelado.add(precoParcelado);
		
		JPanel panelPrecoDesconto = new JPanel();
		panelPrecoParcelado_Desconto.add(panelPrecoDesconto);
		panelPrecoDesconto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoDesconto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoDesconto = new JLabel("Pre\u00E7o (R$) com 0% de desconto (\u00C0 vista):");
		panelPrecoDesconto.add(labelPrecoDesconto);
		labelPrecoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel precoDesconto = new JLabel();
		precoDesconto.setHorizontalAlignment(SwingConstants.RIGHT);
		precoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelPrecoDesconto.add(precoDesconto);
		
		/*Parte que consulta os dados no banco de dados*/
		String codigoVendaConsulta = sessao.getVendaCodigo();
		String vendaClienteConsulta = sessao.getVendaCliente();
		String vendaFuncionarioConsulta = sessao.getVendaFuncionario();
		Dao_consulta_dados_venda_ficha fichaVenda = new Dao_consulta_dados_venda_ficha();
    	List<Venda> Consulta = fichaVenda.Consulta_Dados_Venda_Ficha(codigoVendaConsulta, vendaClienteConsulta, vendaFuncionarioConsulta);
    	for (Venda leitura : Consulta) {
    		String nomeClienteTexto = leitura.getNomeCliente();
    		nomeCliente.setText(nomeClienteTexto);
    		
    		String cpfClienteTexto = leitura.getCPFCliente();
    		cpfCliente.setText(cpfClienteTexto);
    		
    		String codigoClienteTexto = leitura.getCodigoCliente();
    		codigoCliente.setText(codigoClienteTexto);
    		
    		String nomeFuncionarioTexto = leitura.getNomeFuncionario();
    		nomeFuncionario.setText(nomeFuncionarioTexto);
    		
    		String cargoFuncionarioTexto = leitura.getCargoFuncionario();
    		cargo.setText(cargoFuncionarioTexto);
    		
    		String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
    		codigoFuncionario.setText(codigoFuncionarioTexto);
    		
    		String codigoVendaTexto = leitura.getCodigoVenda();
    		codigoVenda.setText(codigoVendaTexto);
    		
    		String metodoPagamentoTexto = leitura.getMetodoPagamento();
    		metodoPagamento.setText(metodoPagamentoTexto);
    		
    		String tipoPagamentoTexto = leitura.getTipoPagamento();
    		tipoPagamento.setText(tipoPagamentoTexto);
    		
    		String notaFiscalTexto = leitura.getNotaFiscal();
    		notaFiscalPaulista.setText(notaFiscalTexto);
    		
    		Date dataCadastroCliente =	leitura.getDataVenda();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroCliente);
    		
    		Time horaCadastroCliente = leitura.getHoraVenda();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroCliente);
    		
    		String dataHoraCompraValor = dataCadastroValor + " " + horaCadastroValor;
    		dataHoraCompra.setText(dataHoraCompraValor);
    		
    		double valorPrecoTotal = leitura.getPrecoTotal();
    		String valorTotalTexto = "" + valorPrecoTotal;
    		precoTotal.setText(valorTotalTexto);
    		
    		double valorPorcentagemDesconto = leitura.getDescontoPorcentagem();
    		double valorPrecoDesconto = leitura.getPrecoTotalDesconto();
    		String valorPrecoDescontoTexto = "" + valorPrecoDesconto;
    		labelPrecoDesconto.setText("Preço (R$) com " + valorPorcentagemDesconto +  "% de desconto (À vista):");
    		precoDesconto.setText(valorPrecoDescontoTexto);
    		
    		int valorQuantidadeParcelas = leitura.getQuantidadeParcelas();
    		double valorPrecoPorcentagem = leitura.getPrecoTotalParcelado();
    		String valorPrecoParceladoTexto = valorQuantidadeParcelas + " x " + valorPrecoPorcentagem;
    		precoParcelado.setText(valorPrecoParceladoTexto);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaVenda.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		voltar = new JButton("Voltar");
		voltar.setToolTipText("Fecha a janela");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(voltar);
	}
}