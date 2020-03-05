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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.sql.Date;
import java.sql.Time;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import moduloFinanceiroCompraBD.Compra;
import moduloFinanceiroCompraBD.CompraHistorico;
import moduloFinanceiroCompraBD.CompraProdutos;
import moduloFinanceiroCompraBD.Dao_inserir_dados_compra;
import moduloFinanceiroCompraBD.Dao_inserir_dados_compra_historico;
import moduloFinanceiroCompraBD.Dao_inserir_dados_compra_produtos;
import moduloFinanceiroCompraTabelas.CompraTabela;
import moduloFinanceiroCompraTabelas.TabelaModeloCompra;
import moduloFinanceiroOutrasClasses.Adicionar_Desconto;
import moduloFinanceiroOutrasClasses.Adicionar_Preco_Parcelas;
import moduloFinanceiroOutrasClasses.Calculadora;
import moduloFinanceiroOutrasClasses.Dao_alterar_dados_produto_quantidade;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoBD.EstoqueProdutos;
import moduloProdutoBD.Produto;

public class Compras extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel TelaCompra;
	private JPanel panelTitulo;
	private JComboBox<String> comboBoxMetodoPagamento, comboBoxTipoPagamento;
	private JFormattedTextField textDataCompra;
	private JTable tabelaListaProdutos;
	private TabelaModeloCompra TabelaModelo;
	private JLabel precoTotal, precoParcelado, labelPrecoDesconto, precoDesconto;
	private JButton adicionar, calculadora, finalizar;
	private JButton cancelarCompra, voltar, remover, limpar;
	Compra cadastrarCompra;
	CompraHistorico cadastrarCompraHistorico;
	String dataCompra, horaCompra, notaFiscalVenda;
	SimpleDateFormat dataFormato, horaFormato;
	Date data;
	Time hora;
	Dao_inserir_dados_compra savaDados;
	Dao_inserir_dados_compra_historico savaDadosHistorico;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compras frame = new Compras();
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
	public Compras() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Compras.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(true);
		setSize(1000, 600);
		
		TelaCompra = new JPanel();
		TelaCompra.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(TelaCompra);
		TelaCompra.setLayout(new BoxLayout(TelaCompra, BoxLayout.Y_AXIS));
		
		MaskFormatter dataMascara = null;
		try{
			dataMascara = new MaskFormatter("##/##/####");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		MaskFormatter horaMascara = null;
		try{
			horaMascara = new MaskFormatter("##:##");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		JPanel panelTelaCompra = new JPanel();
		TelaCompra.add(panelTelaCompra);
		panelTelaCompra.setLayout(new BorderLayout(0, 10));
		
		JPanel panelCompraTitulo = new JPanel();
		panelTelaCompra.add(panelCompraTitulo, BorderLayout.NORTH);
		panelCompraTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		panelTitulo = new JPanel();
		FlowLayout fl_panelTitulo = (FlowLayout) panelTitulo.getLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		panelCompraTitulo.add(panelTitulo);
		
		JLabel icone = new JLabel("");
		panelTitulo.add(icone);
		icone.setIcon(new ImageIcon(Compras.class.getResource("/cImagens/Reposi\u00E7\u00E3o estoque.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelTituloCompra = new JLabel("Compra");
		panelTitulo.add(labelTituloCompra);
		labelTituloCompra.setToolTipText("");
		labelTituloCompra.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		String nomeUsuario = sessao.getNome();
		String cargoUsuario = sessao.getCargo();
		String codigoUsuario = sessao.getCodigo();
		
		JPanel menuBotoesJanela = new JPanel();
		panelCompraTitulo.add(menuBotoesJanela, BorderLayout.CENTER);
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
		fichaUsuario.setIcon(new ImageIcon(Compras.class.getResource("/cImagens/Funcionario.png")));
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
		
		//Modelo de tabela usada e a criação da tabela		
		TabelaModelo = new TabelaModeloCompra();
		
		JScrollPane scrollPaneCompra = new JScrollPane();
		panelTelaCompra.add(scrollPaneCompra, BorderLayout.CENTER);
		
		JPanel panelCompra = new JPanel();
		scrollPaneCompra.setViewportView(panelCompra);
		panelCompra.setLayout(new BorderLayout(0, 10));
		
		JPanel panelDados1 = new JPanel();
		panelCompra.add(panelDados1, BorderLayout.NORTH);
		panelDados1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneDados = new JScrollPane();
		panelDados1.add(scrollPaneDados);
		
		JPanel panelDados = new JPanel();
		scrollPaneDados.setViewportView(panelDados);
		panelDados.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDados.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelDataHora_NotaFiscalPaulista = new JPanel();
		panelDados.add(panelDataHora_NotaFiscalPaulista);
		panelDataHora_NotaFiscalPaulista.setLayout(new GridLayout(0, 5, 5, 0));
		
		JPanel panelMetodoPagamento = new JPanel();
		panelDataHora_NotaFiscalPaulista.add(panelMetodoPagamento);
		panelMetodoPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelMetodoPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelMetodoPagamento = new JLabel("Metodo de pagamento");
		labelMetodoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelMetodoPagamento.add(labelMetodoPagamento);
		
		comboBoxMetodoPagamento = new JComboBox<String>();
		comboBoxMetodoPagamento.setMaximumRowCount(3);
		comboBoxMetodoPagamento.addItem("Escolha");
		comboBoxMetodoPagamento.addItem("À vista");
		comboBoxMetodoPagamento.addItem("A prazo");
		comboBoxMetodoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelMetodoPagamento.add(comboBoxMetodoPagamento);
		
		
		JPanel panelTipoPagamento = new JPanel();
		panelDataHora_NotaFiscalPaulista.add(panelTipoPagamento);
		panelTipoPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoPagamento = new JLabel("Tipo de pagamento");
		labelTipoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelTipoPagamento.add(labelTipoPagamento);
		
		comboBoxTipoPagamento = new JComboBox<String>();
		comboBoxTipoPagamento.addItem("Escolha");
		comboBoxTipoPagamento.addItem("Dinheiro");
		comboBoxTipoPagamento.addItem("Cartão de credito");
		comboBoxTipoPagamento.addItem("Cartão de debito");
		comboBoxTipoPagamento.addItem("Cheque");
		comboBoxTipoPagamento.addItem("Carnê");
		comboBoxTipoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelTipoPagamento.add(comboBoxTipoPagamento);
		
		JPanel panelDataCompra = new JPanel();
		panelDataCompra.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHora_NotaFiscalPaulista.add(panelDataCompra);
		panelDataCompra.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataCompra = new JLabel("Data da compra");
		panelDataCompra.add(labelDataCompra);
		labelDataCompra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textDataCompra = new JFormattedTextField(dataMascara);
		panelDataCompra.add(textDataCompra);
		textDataCompra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDataCompra.setColumns(10);
		
		JPanel panelHoraCompra = new JPanel();
		panelHoraCompra.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHora_NotaFiscalPaulista.add(panelHoraCompra);
		panelHoraCompra.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraCompra = new JLabel("Hora da compra");
		labelHoraCompra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelHoraCompra.add(labelHoraCompra);
		
		JFormattedTextField textHoraCompra = new JFormattedTextField(horaMascara);
		textHoraCompra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textHoraCompra.setColumns(10);
		panelHoraCompra.add(textHoraCompra);
		
		JPanel panelNotaFiscal = new JPanel();
		panelNotaFiscal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHora_NotaFiscalPaulista.add(panelNotaFiscal);
		panelNotaFiscal.setLayout(new GridLayout(0, 1, 0, 0));
		
		JCheckBox checkBoxNotaFiscal = new JCheckBox("Nota fiscal paulista");
		checkBoxNotaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelNotaFiscal.add(checkBoxNotaFiscal);
		
		JPanel panelPrecoTotalVenda = new JPanel();
		panelDados.add(panelPrecoTotalVenda);
		panelPrecoTotalVenda.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelPrecoTotal = new JPanel();
		panelPrecoTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotalVenda.add(panelPrecoTotal);
		panelPrecoTotal.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoTotal = new JLabel("Pre\u00E7o total (R$):");
		labelPrecoTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrecoTotal.add(labelPrecoTotal);
		
		precoTotal = new JLabel("00.00");
		precoTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		precoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPrecoTotal.add(precoTotal);
		

		JPanel panelPrecoParcelado = new JPanel();
		panelPrecoParcelado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotalVenda.add(panelPrecoParcelado);
		panelPrecoParcelado.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoParcelado = new JLabel("Pre\u00E7o parcelado (A prazo) (R$):");
		labelPrecoParcelado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrecoParcelado.add(labelPrecoParcelado);
		
		precoParcelado = new JLabel("0 x 00.00");
		precoParcelado.setHorizontalAlignment(SwingConstants.RIGHT);
		precoParcelado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrecoParcelado.add(precoParcelado);
		
		JPanel panelPrecoDesconto = new JPanel();
		panelPrecoDesconto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotalVenda.add(panelPrecoDesconto);
		panelPrecoDesconto.setLayout(new GridLayout(0, 1, 0, 0));
		
		labelPrecoDesconto = new JLabel("Pre\u00E7o (R$) com 0% de desconto (\u00C0 vista):");
		panelPrecoDesconto.add(labelPrecoDesconto);
		labelPrecoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		precoDesconto = new JLabel("00.00");
		precoDesconto.setHorizontalAlignment(SwingConstants.RIGHT);
		precoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrecoDesconto.add(precoDesconto);
		
		comboBoxMetodoPagamento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent eventoItem) {
				if (eventoItem.getStateChange() == ItemEvent.SELECTED) {
                    if (comboBoxMetodoPagamento.getSelectedItem() == "À vista") {
                    	Adicionar_Desconto vendaDesconto = new Adicionar_Desconto();
                    	vendaDesconto.setVisible(true);
                    	double precoTotalVenda = Double.parseDouble(precoTotal.getText());
                    	double valorDescontoVenda = vendaDesconto.getValorDesconto();
                    	if (valorDescontoVenda == 0) {
                    		labelPrecoDesconto.setText("Preço (R$) com 0% desconto (À vista):");
							precoDesconto.setText("00.00");
						}
                    	else {
							double descontoTotal = ((precoTotalVenda * valorDescontoVenda)/100);
							double precoDescontoTotal = precoTotalVenda - descontoTotal;
							labelPrecoDesconto.setText("Preço (R$) com " + valorDescontoVenda + "% " + "desconto (À vista):");
							precoDesconto.setText("" + precoDescontoTotal);
							precoParcelado.setText("0 x 00.00");
							setPorcentagemDescontoValor(valorDescontoVenda);
							setDescontoPrecoTotal(precoDescontoTotal);
						}
                    	
					}
                    
                    if (comboBoxMetodoPagamento.getSelectedItem() == "A prazo") {
                    	Adicionar_Preco_Parcelas vendaPrecoParcelas = new Adicionar_Preco_Parcelas();
                    	vendaPrecoParcelas.setVisible(true);
                    	double jurosValor = vendaPrecoParcelas.getJurosValorVenda();
                    	int parcelasValor = vendaPrecoParcelas.getParcelaVenda();
                    	double precoTotalValor = Double.parseDouble(precoTotal.getText());
                    	if (jurosValor == 0) {
                    		precoParcelado.setText("0 x 00.00");
						}
                    	else if (parcelasValor == 0) {
                    		precoParcelado.setText("0 x 00.00");
						}
                    	else if (jurosValor == 0 || parcelasValor == 0) {
                    		precoParcelado.setText("0 x 00.00");
						}
                    	else {
                    		double jurosTotal = ((precoTotalValor * jurosValor)/100);
    						double precoParceladoValor = ((precoTotalValor + jurosTotal)/parcelasValor);
                        	precoParcelado.setText(parcelasValor + " x " + precoParceladoValor);
                        	labelPrecoDesconto.setText("Preço (R$) com 0% desconto (À vista)");
							precoDesconto.setText("00.00");
							setQuantidadeParcelasVenda(parcelasValor);
							setPrecoTotalParcelado(precoParceladoValor);
						}
					}
				}
			}
		});
		
		JPanel panelTabela = new JPanel();
		panelCompra.add(panelTabela, BorderLayout.CENTER);
		panelTabela.setLayout(new BoxLayout(panelTabela, BoxLayout.X_AXIS));
		
		//JScrollPane panel do scroll bar da tabela		
		JScrollPane scrollPaneTabela = new JScrollPane();
		panelTabela.add(scrollPaneTabela);
		scrollPaneTabela.getVerticalScrollBar().setUnitIncrement(10);//Velocidade de rolagem do jscrollbar
		scrollPaneTabela.getHorizontalScrollBar().setUnitIncrement(10);
		tabelaListaProdutos = new JTable();
		tabelaListaProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabelaListaProdutos.setModel(TabelaModelo);
		scrollPaneTabela.setViewportView(tabelaListaProdutos);
		tabelaListaProdutos.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaListaProdutos.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaListaProdutos.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabelaListaProdutos.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabelaListaProdutos.getColumnModel().getColumn(4).setPreferredWidth(40);
		tabelaListaProdutos.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		JPanel panelBotoes = new JPanel();
		panelTelaCompra.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		finalizar = new JButton("Finalizar");
		finalizar.setToolTipText("Finaliza a compra e gera a nota fiscal");
		finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMetodoPagamento.getSelectedItem() == "Escolha" ||
					comboBoxTipoPagamento.getSelectedItem() == "Escolha" ||
					textDataCompra.getText().replaceAll("\\/", "").trim().isEmpty() ||
					textHoraCompra.getText().replaceAll("\\:", "").trim().isEmpty() || TabelaModelo.getRowCount() == 0) {
							
					String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
					Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
					menssagemAvisoCampos.setVisible(true);
				}
				else {
					cadastrarCompra = new Compra();
					cadastrarCompraHistorico = new CompraHistorico();
					
					Random numeroCodigo = new Random();
					String codigoRegistro;
					int n0 = numeroCodigo.nextInt(10);
					int n1 = numeroCodigo.nextInt(10);
					int n2 = numeroCodigo.nextInt(10);
					int n3 = numeroCodigo.nextInt(10);
					int n4 = numeroCodigo.nextInt(10);
					int n5 = numeroCodigo.nextInt(10);
					int n6 = numeroCodigo.nextInt(10);
					int n7 = numeroCodigo.nextInt(10);
					int n8 = numeroCodigo.nextInt(10);
					int n9 = numeroCodigo.nextInt(10);
					codigoRegistro = ""+n0+n1+n2+n3+n4+n5+n6+n7+n8+n9;
					cadastrarCompra.setCodigoCompra(codigoRegistro);
					cadastrarCompraHistorico.setCodigoCompra(codigoRegistro);
					
					if (nomeUsuario == null) {
						String nomeFuncionario = "Nome";
						cadastrarCompra.setNomeFuncionario(nomeFuncionario);
						cadastrarCompraHistorico.setNomeFuncionario(nomeFuncionario);
					}
					else {
						cadastrarCompra.setNomeFuncionario(nomeUsuario);
						cadastrarCompraHistorico.setNomeFuncionario(nomeUsuario);
					}
					if (codigoUsuario == null) {
						String codigoFuncionario = "Codigo";
						cadastrarCompra.setCodigoFuncionario(codigoFuncionario);
					}
					else {
						cadastrarCompra.setCodigoFuncionario(codigoUsuario);
					}
					
					if (cargoUsuario == null) {
						String cargoFuncionario = "Cargo";
						cadastrarCompra.setCargoFuncionario(cargoFuncionario);
					}
					else {
						cadastrarCompra.setCargoFuncionario(cargoUsuario);
					}
					
					dataCompra = textDataCompra.getText();
					try {
						dataFormato = new SimpleDateFormat("dd/MM/yyyy");
						data = new java.sql.Date(dataFormato.parse(dataCompra).getTime());
						cadastrarCompra.setDataCompra(data);
						cadastrarCompraHistorico.setDataCompra(data);
						setDataCompraLista(data);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					horaCompra = textHoraCompra.getText();
					try {
						horaFormato = new SimpleDateFormat("HH:mm");
						hora = new java.sql.Time(horaFormato.parse(horaCompra).getTime());
						cadastrarCompra.setHoraCompra(hora);
						cadastrarCompraHistorico.setHoraCompra(hora);
						setHoraCompraLista(hora);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					cadastrarCompra.setMetodoPagamento((String)comboBoxMetodoPagamento.getSelectedItem());
					cadastrarCompra.setTipoPagamento((String)comboBoxTipoPagamento.getSelectedItem());
					
					cadastrarCompra.setPrecoTotal(Double.parseDouble(precoTotal.getText()));
					cadastrarCompraHistorico.setPrecoTotal(Double.parseDouble(precoTotal.getText()));
					
					double porcentagemDescontoValor = getPorcentagemDescontoValor();
					cadastrarCompra.setDescontoPorcentagem(porcentagemDescontoValor);
					
					double precoDescontoValor = getDescontoPrecoTotal();
					cadastrarCompra.setPrecoTotalDesconto(precoDescontoValor);
					
					int quantidadeParcelasValor = getQuantidadeParcelasVenda();
					cadastrarCompra.setQuantidadeParcelas(quantidadeParcelasValor);
					
					double precoParceladoValor = getPrecoTotalParcelado();
					cadastrarCompra.setPrecoTotalParcelado(precoParceladoValor);
					
					if (checkBoxNotaFiscal.isSelected()) {
						notaFiscalVenda = "Pedido";
						cadastrarCompra.setNotaFiscal(notaFiscalVenda);
					}
					else {
						notaFiscalVenda = "Não pedido";
						cadastrarCompra.setNotaFiscal(notaFiscalVenda);
					}
					
					/*Envia os dados da lista de produtos da tabela para o banco de dados*/
					savaDados = new Dao_inserir_dados_compra();
					savaDados.Inserir_Dados_Compra(cadastrarCompra);
					
					/*Envia os dados da lista de produtos da tabela para o banco de dados*/
					List<CompraProdutos>listaProdutoscliente = new ArrayList<CompraProdutos>();
					int linhasTabela = tabelaListaProdutos.getRowCount();
					for (int i = 0; i < linhasTabela; i++) {
						CompraProdutos cadastrarListaProdutos = new CompraProdutos();
						cadastrarListaProdutos.setCodigoProduto((String) tabelaListaProdutos.getModel().getValueAt(i, 0));
						cadastrarListaProdutos.setNomeProduto((String) tabelaListaProdutos.getModel().getValueAt(i, 1));
						cadastrarListaProdutos.setQuantidade(Double.parseDouble((String) tabelaListaProdutos.getModel().getValueAt(i, 2)));
						cadastrarListaProdutos.setPrecoCompra(Double.parseDouble((String) tabelaListaProdutos.getModel().getValueAt(i, 3)));
						cadastrarListaProdutos.setPrecoQuantidade(Double.parseDouble((String) tabelaListaProdutos.getModel().getValueAt(i, 4)));
						cadastrarListaProdutos.setFornecedor((String) tabelaListaProdutos.getModel().getValueAt(i, 5));
						cadastrarListaProdutos.setCodigoCompra(codigoRegistro);
						
						Date dataCompraProdutoLista = getDataCompraLista();
						cadastrarListaProdutos.setDataCompra(dataCompraProdutoLista);
						
						Time horaCompraProdutoLista = getHoraCompraLista();
						cadastrarListaProdutos.setHoraCompra(horaCompraProdutoLista);
						
						listaProdutoscliente.add(cadastrarListaProdutos);
					}
					
					for (CompraProdutos cadastrarListaProdutos : listaProdutoscliente) {
						Dao_inserir_dados_compra_produtos savaDadosListaProdutos = new Dao_inserir_dados_compra_produtos();
						savaDadosListaProdutos.Inserir_Dados_Compra_Produtos(cadastrarListaProdutos);
					}
					
					savaDadosHistorico = new Dao_inserir_dados_compra_historico();
					savaDadosHistorico.Inserir_Dados_Compra_Historico(cadastrarCompraHistorico);
					
					//Mensagem de confirmação do cadastro
					String menssagemConteudo = "Dados cadastrados com sucesso";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
					
					//Limpa os campos depois que o cadastro é realizado
					comboBoxMetodoPagamento.setSelectedItem("Escolha");
					comboBoxTipoPagamento.setSelectedItem("Escolha");
					textDataCompra.setText("");
					textHoraCompra.setText("");
					checkBoxNotaFiscal.setSelected(false);
					precoTotal.setText("00.00");
					precoParcelado.setText("0 x 00.00");
					labelPrecoDesconto.setText("Preço (R$) com 0% de desconto (À vista):");
					precoDesconto.setText("00.00");
					
					//Apaga as linhas da tabela  apos a realização da compra
					TabelaModelo.cancelarCompra();
				}
			}
		});
		finalizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(finalizar);
		
		calculadora = new JButton("Calculadora");
		calculadora.setToolTipText("Abre a calculadora");
		calculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculadora abrirCalculadora = new Calculadora();
				abrirCalculadora.setVisible(true);
			}
		});
		calculadora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(calculadora);
		
		adicionar = new JButton("Adicionar");
		adicionar.setToolTipText("Adicionar um produto a lista de compras");
		panelBotoes2.add(adicionar);
		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compra_Adicionar_Produto telaAdicionarProdutoCompra = new Compra_Adicionar_Produto();
				telaAdicionarProdutoCompra.setVisible(true);
				
				String nomeProduto = telaAdicionarProdutoCompra.getNomeProduto();
				String codigoProduto = telaAdicionarProdutoCompra.getCodigoProduto();
				double quantidadeEstoqueProduto = telaAdicionarProdutoCompra.getQuantidadeEstoqueProduto();
				double quantidadeProduto = telaAdicionarProdutoCompra.getQuantidadeProduto();
				double precoProduto = telaAdicionarProdutoCompra.getPrecoProduto();
				String nomeFornecedor = telaAdicionarProdutoCompra.getNomeForcedor();
				
				if (nomeProduto != null || codigoProduto != null || quantidadeProduto != 0 || quantidadeEstoqueProduto !=0 || precoProduto != 0 || nomeFornecedor != null) {
					Produto alterarCadastroProduto = new Produto();
					EstoqueProdutos alterarCadastroEstoqueProduto = new EstoqueProdutos();
					
					double quantidadeTotal = quantidadeEstoqueProduto + quantidadeProduto;
					
					alterarCadastroProduto.setCodigoProduto(codigoProduto);
					alterarCadastroProduto.setNome(nomeProduto);
					alterarCadastroProduto.setQuantidade(quantidadeTotal);
					
					alterarCadastroEstoqueProduto.setCodigoProduto(codigoProduto);
					alterarCadastroEstoqueProduto.setNome(nomeProduto);
					alterarCadastroEstoqueProduto.setQuantidade(quantidadeTotal);
					
					Dao_alterar_dados_produto_quantidade salvaNovoQuantidadeProduto = new Dao_alterar_dados_produto_quantidade();
					salvaNovoQuantidadeProduto.Altera_Dados_Produto_Quantidade(alterarCadastroProduto);
					salvaNovoQuantidadeProduto.Altera_Dados_Produto_Quantidade_Estoque(alterarCadastroEstoqueProduto);
					
					String quantidadeTexto = "" + quantidadeProduto;
					String precoTexto = "" + precoProduto;
					double precoQuantidadeCompra = quantidadeProduto * precoProduto;
					String precoQuantidadeTexto = "" + precoQuantidadeCompra;
					
					CompraTabela nCompra = new CompraTabela(codigoProduto, nomeProduto, quantidadeTexto, precoTexto, precoQuantidadeTexto, nomeFornecedor);
				    TabelaModelo.addCompra(nCompra);
				    
					double valorPrecoTotal = 0;
					int linhasTabela = tabelaListaProdutos.getRowCount();
					for (int i = 0; i < linhasTabela; i++) {
						double valorPrecoUnitario = Double.parseDouble((String) tabelaListaProdutos.getValueAt(i, 4));
						valorPrecoTotal += valorPrecoUnitario;
						String valorPrecoVenda = "" + valorPrecoTotal;
						precoTotal.setText(valorPrecoVenda);
					}
				}
			}
		});
		adicionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		remover = new JButton("Remover");
		remover.setToolTipText("Remove um produto da lista de compras");
		remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemTitulo = "Deseja remover o produto?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo aviso = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemTitulo);
				aviso.setVisible(true);
				String resposta = aviso.getResposta();
				if (resposta != null) {
					if (resposta.equals("Sim")) {
						if (tabelaListaProdutos.getSelectedRow() != -1 && tabelaListaProdutos.getSelectedRow() < TabelaModelo.getRowCount()) {
							int linhaSelecionada = tabelaListaProdutos.getSelectedRow();
					        TabelaModelo.removerCompra(linhaSelecionada);
					        double valorPrecoTotal = 0;
							int linhasTabela = tabelaListaProdutos.getRowCount();
							for (int i = 0; i < linhasTabela; i++) {
								double valorPrecoUnitario = Double.parseDouble((String) tabelaListaProdutos.getValueAt(i, 3));
								valorPrecoTotal -= (-1)*(valorPrecoUnitario);
								String valorPrecoVenda = "" + valorPrecoTotal;
								precoTotal.setText(valorPrecoVenda);	
							}
							if (linhasTabela == 0) {
								precoTotal.setText("00.00");
							}
						} 
						else {
							String menssagemConteudo = "Nenhum item selecionado";
							Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
							mensagemConfirmacao.setVisible(true);
						}
					}
				}
			}
		});
		remover.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(remover);
		
		limpar = new JButton("Limpar");
		limpar.setToolTipText("Limpa os campos");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menssagemConteudo = "Deseja limpar os campos ?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo avisoLimparCampos = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemConteudo);
				avisoLimparCampos.setVisible(true);
				String avisoLimparCamposTexto = avisoLimparCampos.getResposta();
				if (avisoLimparCamposTexto != null) {
					if (avisoLimparCamposTexto.equals("Sim")) {
						comboBoxMetodoPagamento.setSelectedItem("Escolha");
						comboBoxTipoPagamento.setSelectedItem("Escolha");
						textDataCompra.setText("");
						textHoraCompra.setText("");
						checkBoxNotaFiscal.setSelected(false);
						precoTotal.setText("00.00");
						precoParcelado.setText("0 x 00.00");
						labelPrecoDesconto.setText("Preço (R$) com 0% de desconto (À vista):");
						precoDesconto.setText("00.00");
					}
				}
			}
		});
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(limpar);
		
		cancelarCompra = new JButton("Cancelar");
		cancelarCompra.setToolTipText("Cancelar a compra");
		cancelarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemTitulo = "Cancelamento da compra";
				String menssagemConteudo = "Deseja cancelar a compra ?";
				Tela_que_Exibe_Menssagem_Sim_Nao telaCancelarCompra = new Tela_que_Exibe_Menssagem_Sim_Nao(menssagemTitulo, menssagemConteudo);
				telaCancelarCompra.setVisible(true);
				String cancelarCompraTexto = telaCancelarCompra.getResposta();
				if (cancelarCompraTexto != null) {
					if (cancelarCompraTexto.equals("Sim")) {
						//Apaga as linhas da tabela e cancela a venda
						TabelaModelo.cancelarCompra();
						
						//Limpa os campos
						comboBoxMetodoPagamento.setSelectedItem("Escolha");
						comboBoxTipoPagamento.setSelectedItem("Escolha");
						checkBoxNotaFiscal.setSelected(false);
						textDataCompra.setText("");
						textHoraCompra.setText("");
						precoTotal.setText("00.00");
						precoParcelado.setText("0 x 00.00");
						labelPrecoDesconto.setText("Preço (R$) com 0% de desconto (À vista):");
						precoDesconto.setText("00.00");
					}
				}
			}
		});
		cancelarCompra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(cancelarCompra);
		
		voltar = new JButton("Voltar");
		voltar.setToolTipText("Fecha a janela");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMetodoPagamento.getSelectedItem() != "Escolha" || comboBoxTipoPagamento.getSelectedItem() != "Escolha" ||
					checkBoxNotaFiscal.isSelected() == true || textDataCompra.getText().replaceAll("\\/", "").trim().length() != 0 ||
					textHoraCompra.getText().replaceAll("\\:", "").trim().length() != 0 || TabelaModelo.getRowCount() != 0) {
						String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
						aviso.setVisible(true);
						String resposta = aviso.getResposta();
						if (resposta != null) {
							if (resposta.equals("Sim")) {
								setVisible(false); 
					            dispose();
							}
						}
				}
				else {
					setVisible(false); 
		            dispose();
				}
			}
		});
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(voltar);
		
		/*Ação do botao sair da janela*/
		addWindowListener(
            new WindowAdapter() 
            {
                public void windowClosing(WindowEvent we) {
                	if (comboBoxMetodoPagamento.getSelectedItem() != "Escolha" || comboBoxTipoPagamento.getSelectedItem() != "Escolha" ||
    					checkBoxNotaFiscal.isSelected() == true || textDataCompra.getText().replaceAll("\\/", "").trim().length() != 0 ||
    					textHoraCompra.getText().replaceAll("\\:", "").trim().length() != 0 || TabelaModelo.getRowCount() != 0) {
	                		String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
    						aviso.setVisible(true);
    						String resposta = aviso.getResposta();
    						if (resposta != null) {
    							if (resposta.equals("Sim")) {
    								setVisible(false); 
    					            dispose();
    							}
    						}
    				}
    				else {
    					setVisible(false); 
    		            dispose();
    				}
                }
            }
	    );
	}
	
	/*Metodos get e set*/
	private double porcentagemDescontoValor, descontoPrecoTotal, precoTotalParcelado;
	private int quantidadeParcelasVenda;
	private Date dataCompraLista;
	private Time horaCompraLista;
	/*get e set Valor da porcentagem*/
	public double getPorcentagemDescontoValor() {
		return porcentagemDescontoValor;
	}
	public void setPorcentagemDescontoValor(double porcentagemDescontoValor) {
		this.porcentagemDescontoValor = porcentagemDescontoValor;
	}
	
	/*get e set Preço com desconto*/
	public double getDescontoPrecoTotal() {
		return descontoPrecoTotal;
	}
	public void setDescontoPrecoTotal(double descontoPrecoTotal) {
		this.descontoPrecoTotal = descontoPrecoTotal;
	}
	
	/*get e set Valor de cada parcela*/
	public double getPrecoTotalParcelado() {
		return precoTotalParcelado;
	}
	public void setPrecoTotalParcelado(double precoTotalParcelado) {
		this.precoTotalParcelado = precoTotalParcelado;
	}
	
	/*get e set Quantidade de parcelas*/
	public int getQuantidadeParcelasVenda() {
		return quantidadeParcelasVenda;
	}
	public void setQuantidadeParcelasVenda(int quantidadeParcelasVenda) {
		this.quantidadeParcelasVenda = quantidadeParcelasVenda;
	}
	
	/*get e set Data da compra*/
	public Date getDataCompraLista() {
		return dataCompraLista;
	}
	public void setDataCompraLista(Date dataCompraLista) {
		this.dataCompraLista = dataCompraLista;
	}
	
	/*get e set Hora da compra*/
	public Time getHoraCompraLista() {
		return horaCompraLista;
	}
	public void setHoraCompraLista(Time horaCompraLista) {
		this.horaCompraLista = horaCompraLista;
	}
}