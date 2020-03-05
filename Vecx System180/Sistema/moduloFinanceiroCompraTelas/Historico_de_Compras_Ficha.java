package moduloFinanceiroCompraTelas;

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
import moduloFinanceiroCompraBD.Compra;
import moduloFinanceiroCompraBD.Dao_consulta_dados_compra_ficha;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Historico_de_Compras_Ficha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaCompra;
	private JButton voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Historico_de_Compras_Ficha frame = new Historico_de_Compras_Ficha();
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
	public Historico_de_Compras_Ficha() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Historico_de_Compras_Ficha.class.getResource("/cImagens/Logo Janela.PNG")));
		setResizable(false);
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 380);
		setSize(800, 380);
		
		telaFichaCompra = new JPanel();
		telaFichaCompra.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaCompra.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaCompra);
		
		JPanel panelTitulo = new JPanel();
		telaFichaCompra.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Historico_de_Compras_Ficha.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelDadosCompra = new JLabel("Dados da compra");
		panelTitulo2.add(labelDadosCompra);
		labelDadosCompra.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Historico_de_Compras_Ficha.class.getResource("/cImagens/Funcionario.png")));
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
		telaFichaCompra.add(scrollPaneCadastro, BorderLayout.CENTER);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNome_CodFun_Cargo = new JPanel();
		panelNome_CodFun_Cargo.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelNome_CodFun_Cargo);
		panelNome_CodFun_Cargo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNome = new JPanel();
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome_CodFun_Cargo.add(panelNome);
		panelNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNome = new JLabel("Funcionario responsavel pela compra");
		panelNome.add(labelNome);
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel nome = new JLabel();
		panelNome.add(nome);
		nome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
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
		
		JPanel panelCodCom_ValorTotal = new JPanel();
		panelCadastro.add(panelCodCom_ValorTotal);
		panelCodCom_ValorTotal.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelCodigoCompra = new JPanel();
		panelCodigoCompra.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodCom_ValorTotal.add(panelCodigoCompra);
		panelCodigoCompra.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoCompra = new JLabel("Codigo da compra");
		panelCodigoCompra.add(labelCodigoCompra);
		labelCodigoCompra.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel codigoCompra = new JLabel();
		panelCodigoCompra.add(codigoCompra);
		codigoCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelDataHoraCompra = new JPanel();
		panelCodCom_ValorTotal.add(panelDataHoraCompra);
		panelDataHoraCompra.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHoraCompra.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraCompra = new JLabel("Data e hora da compra");
		panelDataHoraCompra.add(labelDataHoraCompra);
		labelDataHoraCompra.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel dataHoraCompra = new JLabel();
		panelDataHoraCompra.add(dataHoraCompra);
		dataHoraCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelNotaFiscal = new JPanel();
		panelCodCom_ValorTotal.add(panelNotaFiscal);
		panelNotaFiscal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNotaFiscal.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNotaFiscal = new JLabel("Nota fiscal");
		panelNotaFiscal.add(labelNotaFiscal);
		labelNotaFiscal.setHorizontalAlignment(SwingConstants.LEFT);
		labelNotaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel notaFiscal = new JLabel();
		panelNotaFiscal.add(notaFiscal);
		notaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelNF_TipoPag_MetodoPag = new JPanel();
		panelCadastro.add(panelNF_TipoPag_MetodoPag);
		panelNF_TipoPag_MetodoPag.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelTipoPagamento = new JPanel();
		panelTipoPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNF_TipoPag_MetodoPag.add(panelTipoPagamento);
		panelTipoPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoPagamento = new JLabel("Tipo de pagamento");
		labelTipoPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTipoPagamento.add(labelTipoPagamento);
		
		JLabel tipoPagamento = new JLabel();
		tipoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTipoPagamento.add(tipoPagamento);
		
		JPanel panelMetodoPagamento = new JPanel();
		panelMetodoPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNF_TipoPag_MetodoPag.add(panelMetodoPagamento);
		panelMetodoPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelMetodoPagamento = new JLabel("Metodo de pagamento");
		panelMetodoPagamento.add(labelMetodoPagamento);
		labelMetodoPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		labelMetodoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel metodoPagamento = new JLabel();
		panelMetodoPagamento.add(metodoPagamento);
		metodoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelPrecoTotal = new JPanel();
		panelNF_TipoPag_MetodoPag.add(panelPrecoTotal);
		panelPrecoTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotal.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoTotal = new JLabel("Pre\u00E7o total (R$):");
		panelPrecoTotal.add(labelPrecoTotal);
		labelPrecoTotal.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel precoTotal = new JLabel();
		precoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPrecoTotal.add(precoTotal);
		precoTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
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
		String codigoCompraConsulta = sessao.getCompraCodigo();
		String compraFuncionarioConsulta = sessao.getCompraFuncionario();
		Dao_consulta_dados_compra_ficha fichaCompra = new Dao_consulta_dados_compra_ficha();
    	List<Compra> Consulta = fichaCompra.Consulta_Dados_Compra_Ficha(codigoCompraConsulta, compraFuncionarioConsulta);
    	for (Compra leitura : Consulta) {
    		String nomeFuncionarioTexto = leitura.getNomeFuncionario();
    		nome.setText(nomeFuncionarioTexto);
    		
    		String cargoFuncionarioTexto = leitura.getCargoFuncionario();
    		cargo.setText(cargoFuncionarioTexto);
    		
    		String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
    		codigoFuncionario.setText(codigoFuncionarioTexto);
    		
    		String codigoCompraTexto = leitura.getCodigoCompra();
    		codigoCompra.setText(codigoCompraTexto);
    		
    		String metodoPagamentoTexto = leitura.getMetodoPagamento();
    		metodoPagamento.setText(metodoPagamentoTexto);
    		
    		String tipoPagamentoTexto = leitura.getTipoPagamento();
    		tipoPagamento.setText(tipoPagamentoTexto);
    		
    		Date dataCadastroCliente =	leitura.getDataCompra();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroCliente);
    		Time horaCadastroCliente = leitura.getHoraCompra();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroCliente);
    		String dataHoraCompraValor = dataCadastroValor + " " + horaCadastroValor;
    		dataHoraCompra.setText(dataHoraCompraValor);
    		
    		String notaFiscalTexto = leitura.getNotaFiscal();
    		notaFiscal.setText(notaFiscalTexto);
    		
    		double valorPrecoTotal = leitura.getPrecoTotal();
    		String valorTotalTexto = "" + valorPrecoTotal;
    		precoTotal.setText("R$: " + valorTotalTexto);
    		
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
		telaFichaCompra.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorFichadocliente = new JSeparator();
		panelBotoes.add(separatorFichadocliente, BorderLayout.NORTH);
		
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