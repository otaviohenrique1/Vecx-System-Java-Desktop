package moduloProdutoTelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.sql.Date;
import java.sql.Time;
import aInterfaceSistema.ValidaNumeroDouble;
import aInterfaceSistema.ValidaNumeroInteiro;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoBD.Dao_inserir_dados_produto;
import moduloProdutoBD.Dao_inserir_dados_produto_estoque;
import moduloProdutoBD.EstoqueProdutos;
import moduloProdutoBD.Produto;

public class Cadastro_de_Produto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaCadastroProduto;
	private JTextField textNome, textMarca, textPrecoCompra, textCodigoBarras, textTipoProduto, textGarantia, textPrecoVenda, textPeso, textLote;
	private JTextField textAplicacao, textModelo, textCor, textTipoEmbalagem, textTipoEstampa, textAltura;
	private JTextField textComprimento, textLargura, textProfundidade, textEspessura, textVidaUtil, textQuantidade, textFornecedorNome;
	private JTextField textQuantComponentes;
	private JFormattedTextField textDataPrimeiraCompra, textDataFabricacao, textDataValidade, textFornecedorCNPJ;
	private JComboBox<String> comboBoxVidaUtil, comboBoxGarantia, comboBoxPeso, comboBoxAltura, comboBoxComprimento;
	private JComboBox<String> comboBoxLargura, comboBoxProfundidade, comboBoxEspessura, comboBoxQuantidade;	
	private final ButtonGroup buttonGroupProduto = new ButtonGroup();
	private final ButtonGroup buttonGroupEmbalagem = new ButtonGroup();
	private final ButtonGroup buttonGroupEstampa = new ButtonGroup();
	private final ButtonGroup buttonGroupMontagem = new ButtonGroup();
	private JRadioButton radioNacional, radioImportado, radioEmbalagemSim, radioEmbalagemNao, radioEstampaSim, radioEstampaNao;
	private JRadioButton radioMontagemSim, radioMontagemNao; 
	private JTextArea textAreaAcessorios, textAreaDescricao;
	private JButton fornecedor, salvar, limpar, voltar;
	ImageIcon fotoProduto1;
	String origemProduto, montagemProduto, embalagemProduto, estampaProduto, acessoriosProdutoTexto, descricaoProdutoTexto; 
	String dataPrimeiraCompraProduto, dataFabricacaoProduto, dataValidadeProduto, garantia, garantiaValor, garantiaUnidade, quantidade;
	String altura, alturaValor, alturaUnidade, largura, larguraValor, larguraUnidade, comprimento, comprimentoValor, comprimentoUnidade;
	String peso, pesoValor, pesoUnidade, espessura, espessuraValor, espessuraUnidade, profundidade, profundidadeValor, profundidadeUnidade;
	String vidaUtil, vidaUtilValor, vidaUtilUnidade, tipoProdutoTexto, aplicacaoProdutoTexto, corProdutoTexto, modeloProdutoTexto;
	String tipoEstampaTexto, tipoEmbalagemTexto, quantidadeCompoenentesTexto, quantidadeValor, quantidadeUnidade;
	String alturaTexto, alturaUnidadeTexto, larguraTexto, larguraUnidadeTexto, comprimentoTexto, comprimentoUnidadeTexto, garantiaTexto, garantiaUnidadeTexto;
	String pesoTexto, pesoUnidadeTexto, espessuraTexto, espessuraUnidadeTexto, profundidadeTexto, profundidadeUnidadeTexto, vidaUtilTexto, vidaUtilUnidadeTexto;
	SimpleDateFormat dataCompraFormato, dataFabricacaoFormato, dataValidadeFormato;
	Date dataCompra, dataFabricacao, dataValidade;
	Produto cadastrarProduto;
	EstoqueProdutos cadastrarProdutoEstoque;
	Dao_inserir_dados_produto salvaDados;
	Dao_inserir_dados_produto_estoque salvaDadosEstoque;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_de_Produto frame = new Cadastro_de_Produto();
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
	public Cadastro_de_Produto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro_de_Produto.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(true);
		setSize(1100, 600);
		
		telaCadastroProduto = new JPanel();
		telaCadastroProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaCadastroProduto);
		telaCadastroProduto.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		telaCadastroProduto.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout fl_panelTitulo2 = (FlowLayout) panelTitulo2.getLayout();
		fl_panelTitulo2.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel iconeCadastrodeproduto = new JLabel("");
		panelTitulo2.add(iconeCadastrodeproduto);
		iconeCadastrodeproduto.setIcon(new ImageIcon(Cadastro_de_Produto.class.getResource("/cImagens/Cadastro produtos.PNG")));
		iconeCadastrodeproduto.setPreferredSize(new Dimension(30, 30));
		iconeCadastrodeproduto.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastrodeproduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		iconeCadastrodeproduto.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel cadastrodeproduto = new JLabel("Cadastro de Produto");
		panelTitulo2.add(cadastrodeproduto);
		cadastrodeproduto.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Cadastro_de_Produto.class.getResource("/cImagens/Funcionario.png")));
		fichaUsuario.setToolTipText("Ficha do usuario");
		fichaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBotoesJanela1.add(fichaUsuario, BorderLayout.CENTER);
		
		JPanel panelDadosUsuario = new JPanel();
		menuBotoesJanela1.add(panelDadosUsuario, BorderLayout.WEST);
		panelDadosUsuario.setLayout(new GridLayout(2, 1, 0, 0));

		MaskFormatter dataCompraMascara = null;
		MaskFormatter dataValidadeMascara = null;
		MaskFormatter dataFabricacaoMascara = null;
		MaskFormatter numeroCNPJMascara = null;
		try{
			dataCompraMascara = new MaskFormatter("##/##/####");
			dataValidadeMascara = new MaskFormatter("##/##/####");
			dataFabricacaoMascara = new MaskFormatter("##/##/####");
			numeroCNPJMascara = new MaskFormatter("##.###.###/####-#");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
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
		
		JTabbedPane tabbedPaneCadastroProduto = new JTabbedPane(JTabbedPane.TOP);
		telaCadastroProduto.add(tabbedPaneCadastroProduto);
		
		JPanel panelCadastroProduto = new JPanel();
		tabbedPaneCadastroProduto.addTab("Cadastro do produto", null, panelCadastroProduto, null);
		panelCadastroProduto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPaneCadastro = new JScrollPane();
		scrollPaneCadastro.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneCadastro.getHorizontalScrollBar().setUnitIncrement(10);
		panelCadastroProduto.add(scrollPaneCadastro);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNome = new JPanel();
		panelCadastro.add(panelNome);
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNome = new JLabel("Nome");
		panelNome.add(labelNome);
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textNome = new JTextField();
		panelNome.add(textNome);
		textNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textNome.getText().isEmpty() || textNome.getText().length() <= 0){
					labelNome.setText("Nome*");
					labelNome.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelNome.setText("Nome");
				labelNome.setForeground(Color.BLACK);
			}
		});
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNome.setColumns(10);
		
		JPanel panelMarca_Lote_CodBar = new JPanel();
		panelCadastro.add(panelMarca_Lote_CodBar);
		panelMarca_Lote_CodBar.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelMarca = new JPanel();
		panelMarca_Lote_CodBar.add(panelMarca);
		panelMarca.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelMarca.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelMarca = new JLabel("Marca");
		panelMarca.add(labelMarca);
		labelMarca.setHorizontalAlignment(SwingConstants.LEFT);
		labelMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textMarca = new JTextField();
		panelMarca.add(textMarca);
		textMarca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textMarca.getText().isEmpty() || textMarca.getText().length() <= 0){
					labelMarca.setText("Marca*");
					labelMarca.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelMarca.setText("Marca");
				labelMarca.setForeground(Color.BLACK);
			}
		});
		textMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textMarca.setColumns(10);
		
		JPanel panelLote_CodBar = new JPanel();
		panelMarca_Lote_CodBar.add(panelLote_CodBar);
		panelLote_CodBar.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelLote = new JPanel();
		panelLote_CodBar.add(panelLote);
		panelLote.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelLote.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLote = new JLabel("Lote");
		panelLote.add(labelLote);
		labelLote.setHorizontalAlignment(SwingConstants.LEFT);
		labelLote.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textLote = new JTextField();
		panelLote.add(textLote);
		textLote.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textLote.getText().isEmpty() || textLote.getText().length() <= 0){
					labelLote.setText("Lote*");
					labelLote.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelLote.setText("Lote");
				labelLote.setForeground(Color.BLACK);
			}
		});
		textLote.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textLote.setColumns(10);
		
		JPanel panelCodigoBarras = new JPanel();
		panelLote_CodBar.add(panelCodigoBarras);
		panelCodigoBarras.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoBarras.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoBarras = new JLabel("Codigo de barras");
		panelCodigoBarras.add(labelCodigoBarras);
		labelCodigoBarras.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textCodigoBarras = new JTextField();
		panelCodigoBarras.add(textCodigoBarras);
		textCodigoBarras.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCodigoBarras.getText().isEmpty() || textCodigoBarras.getText().length() <= 0){
					labelCodigoBarras.setText("Codigo de barras*");
					labelCodigoBarras.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelCodigoBarras.setText("Codigo de barras");
				labelCodigoBarras.setForeground(Color.BLACK);
			}
		});
		textCodigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCodigoBarras.setColumns(10);
		
		JPanel panelData_VidaUtil = new JPanel();
		panelCadastro.add(panelData_VidaUtil);
		panelData_VidaUtil.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelDataPrimeiraCompra = new JPanel();
		panelDataPrimeiraCompra.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_VidaUtil.add(panelDataPrimeiraCompra);
		panelDataPrimeiraCompra.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataPrimeiraCompra = new JLabel("Data da primeira compra");
		panelDataPrimeiraCompra.add(labelDataPrimeiraCompra);
		labelDataPrimeiraCompra.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataPrimeiraCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textDataPrimeiraCompra = new JFormattedTextField(dataCompraMascara);
		panelDataPrimeiraCompra.add(textDataPrimeiraCompra);
		textDataPrimeiraCompra.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textDataPrimeiraCompra.getText().replaceAll("\\/", "").trim().isEmpty()){
					labelDataPrimeiraCompra.setText("Data da primeira compra*");
					labelDataPrimeiraCompra.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelDataPrimeiraCompra.setText("Data da primeira compra");
				labelDataPrimeiraCompra.setForeground(Color.BLACK);
			}
		});
		textDataPrimeiraCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDataPrimeiraCompra.setColumns(10);
		
		JPanel panelDataFabricacao = new JPanel();
		panelDataFabricacao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_VidaUtil.add(panelDataFabricacao);
		panelDataFabricacao.setLayout(new GridLayout(0, 1, 5, 0));
		
		JLabel labelDataFabricacao = new JLabel("Data de fabrica\u00E7\u00E3o");
		panelDataFabricacao.add(labelDataFabricacao);
		labelDataFabricacao.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataFabricacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textDataFabricacao = new JFormattedTextField(dataFabricacaoMascara);
		panelDataFabricacao.add(textDataFabricacao);
		textDataFabricacao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textDataFabricacao.getText().replaceAll("\\/", "").trim().isEmpty()){
					labelDataFabricacao.setText("Data de fabricação*");
					labelDataFabricacao.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelDataFabricacao.setText("Data de fabricação");
				labelDataFabricacao.setForeground(Color.BLACK);
			}
		});
		textDataFabricacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDataFabricacao.setColumns(10);
		
		JPanel panelDataValidade = new JPanel();
		panelDataValidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_VidaUtil.add(panelDataValidade);
		panelDataValidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataValidade = new JLabel("Data de validade");
		panelDataValidade.add(labelDataValidade);
		labelDataValidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataValidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textDataValidade = new JFormattedTextField(dataValidadeMascara);
		panelDataValidade.add(textDataValidade);
		textDataValidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textDataValidade.getText().replaceAll("\\/", "").trim().isEmpty()){
					labelDataValidade.setText("Data de validade*");
					labelDataValidade.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelDataValidade.setText("Data de validade");
				labelDataValidade.setForeground(Color.BLACK);
			}
		});
		textDataValidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDataValidade.setColumns(10);
		
		JPanel panelVidaUtil = new JPanel();
		panelVidaUtil.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_VidaUtil.add(panelVidaUtil);
		panelVidaUtil.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelVidaUtil = new JLabel("Vida util do produto");
		labelVidaUtil.setHorizontalAlignment(SwingConstants.LEFT);
		labelVidaUtil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelVidaUtil.add(labelVidaUtil);
		
		JPanel panelVidaUtil2 = new JPanel();
		panelVidaUtil.add(panelVidaUtil2);
		panelVidaUtil2.setLayout(new BorderLayout(0, 0));
		
		textVidaUtil = new JTextField();
		panelVidaUtil2.add(textVidaUtil);
		textVidaUtil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textVidaUtil.setColumns(10);
		textVidaUtil.setDocument(new ValidaNumeroInteiro());
		
		comboBoxVidaUtil = new JComboBox<String>();
		comboBoxVidaUtil.setMaximumRowCount(5);
		comboBoxVidaUtil.addItem("Escolha");
		comboBoxVidaUtil.addItem("minuto(s)");
		comboBoxVidaUtil.addItem("hora(s)");
		comboBoxVidaUtil.addItem("dia(s)");
		comboBoxVidaUtil.addItem("semana(s)");
		comboBoxVidaUtil.addItem("mese(s)");
		comboBoxVidaUtil.addItem("ano(s)");
		comboBoxVidaUtil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelVidaUtil2.add(comboBoxVidaUtil, BorderLayout.EAST);
		
		JPanel panelPreco_OriPro = new JPanel();
		panelCadastro.add(panelPreco_OriPro);
		panelPreco_OriPro.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelPrecoCompra = new JPanel();
		panelPrecoCompra.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPreco_OriPro.add(panelPrecoCompra);
		panelPrecoCompra.setLayout(new GridLayout(0, 1, 5, 0));
		
		JLabel labelPrecoCompra = new JLabel("Pre\u00E7o de compra (R$)");
		panelPrecoCompra.add(labelPrecoCompra);
		labelPrecoCompra.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textPrecoCompra = new JTextField();
		panelPrecoCompra.add(textPrecoCompra);
		textPrecoCompra.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textPrecoCompra.getText().isEmpty() || textPrecoCompra.getText().length() <= 0){
					labelPrecoCompra.setText("Preço de compra (R$)*");
					labelPrecoCompra.setForeground(Color.RED);
				}
				else {
					labelPrecoCompra.setText("Preço de compra (R$)");
					labelPrecoCompra.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelPrecoCompra.setText("Preço de compra (R$)");
				labelPrecoCompra.setForeground(Color.BLACK);
			}
		});
		textPrecoCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPrecoCompra.setColumns(10);
		PlainDocument documentPrecoCompra = (PlainDocument) textPrecoCompra.getDocument();
		documentPrecoCompra.setDocumentFilter(new ValidaNumeroDouble());
	    
		JPanel panelPrecoVenda = new JPanel();
		panelPrecoVenda.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPreco_OriPro.add(panelPrecoVenda);
		panelPrecoVenda.setLayout(new GridLayout(0, 1, 5, 0));
		
		JLabel labelPrecoVenda = new JLabel("Pre\u00E7o de Venda (R$)");
		panelPrecoVenda.add(labelPrecoVenda);
		labelPrecoVenda.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoVenda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textPrecoVenda = new JTextField();
		panelPrecoVenda.add(textPrecoVenda);
		textPrecoVenda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPrecoVenda.setColumns(10);
		PlainDocument documentPrecoaVista = (PlainDocument) textPrecoVenda.getDocument();
		documentPrecoaVista.setDocumentFilter(new ValidaNumeroDouble());
	    
		JPanel panelOrigemProduto = new JPanel();
		panelPreco_OriPro.add(panelOrigemProduto);
		panelOrigemProduto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelOrigemProduto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelOrigemProduto = new JLabel("Origem do produto");
		panelOrigemProduto.add(labelOrigemProduto);
		labelOrigemProduto.setHorizontalAlignment(SwingConstants.LEFT);
		labelOrigemProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelOrigemProduto2 = new JPanel();
		FlowLayout fl_panelOrigemProduto2 = (FlowLayout) panelOrigemProduto2.getLayout();
		fl_panelOrigemProduto2.setAlignment(FlowLayout.LEFT);
		fl_panelOrigemProduto2.setVgap(0);
		fl_panelOrigemProduto2.setHgap(0);
		panelOrigemProduto.add(panelOrigemProduto2);
		
		radioNacional = new JRadioButton("Nacional");
		panelOrigemProduto2.add(radioNacional);
		buttonGroupProduto.add(radioNacional);
		radioNacional.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		radioImportado = new JRadioButton("Importado");
		panelOrigemProduto2.add(radioImportado);
		buttonGroupProduto.add(radioImportado);
		radioImportado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelQuant_Garan_For_CNPJ = new JPanel();
		panelCadastro.add(panelQuant_Garan_For_CNPJ);
		panelQuant_Garan_For_CNPJ.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelQuantidade = new JPanel();
		panelQuantidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelQuant_Garan_For_CNPJ.add(panelQuantidade);
		panelQuantidade.setLayout(new GridLayout(0, 1, 5, 0));
		
		JLabel labelQuantidade = new JLabel("Quantidade");
		labelQuantidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelQuantidade.add(labelQuantidade);
		
		JPanel panelQuantidade2 = new JPanel();
		panelQuantidade.add(panelQuantidade2);
		panelQuantidade2.setLayout(new BorderLayout(0, 0));
		
		textQuantidade = new JTextField();
		panelQuantidade2.add(textQuantidade);
		textQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textQuantidade.setColumns(10);
		PlainDocument documentQuantidade = (PlainDocument) textQuantidade.getDocument();
		documentQuantidade.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxQuantidade = new JComboBox<String>();
		comboBoxQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxQuantidade.setMaximumRowCount(4);
		comboBoxQuantidade.addItem("Escolha");
		comboBoxQuantidade.addItem("unidade(s)");
		comboBoxQuantidade.addItem("polegada(s)");
		comboBoxQuantidade.addItem("mm");
		comboBoxQuantidade.addItem("cm");
		comboBoxQuantidade.addItem("m");
		comboBoxQuantidade.addItem("km");
		comboBoxQuantidade.addItem("mg");
		comboBoxQuantidade.addItem("g");
		comboBoxQuantidade.addItem("kg");
		comboBoxQuantidade.addItem("tonelada(s)");
		panelQuantidade2.add(comboBoxQuantidade, BorderLayout.EAST);
		
		JPanel panelGarantia = new JPanel();
		panelGarantia.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelQuant_Garan_For_CNPJ.add(panelGarantia);
		panelGarantia.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelGarantia = new JLabel("Garantia");
		panelGarantia.add(labelGarantia);
		labelGarantia.setHorizontalAlignment(SwingConstants.LEFT);
		labelGarantia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelGarantia2 = new JPanel();
		panelGarantia.add(panelGarantia2);
		panelGarantia2.setLayout(new BorderLayout(0, 0));
		
		textGarantia = new JTextField();
		panelGarantia2.add(textGarantia);
		textGarantia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textGarantia.setDocument(new ValidaNumeroInteiro());
		textGarantia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textGarantia.getText().isEmpty() || textGarantia.getText().length() <= 0 || comboBoxGarantia.getSelectedItem() == "Escolha"){
					labelGarantia.setText("Garantia*");
					labelGarantia.setForeground(Color.RED);
				}
				else {
					labelGarantia.setText("Garantia");
					labelGarantia.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelGarantia.setText("Garantia");
				labelGarantia.setForeground(Color.BLACK);
			}
		});
		textGarantia.setColumns(10);
		
		comboBoxGarantia = new JComboBox<String>();
		comboBoxGarantia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxGarantia.setMaximumRowCount(4);
		comboBoxGarantia.addItem("Escolha");
		comboBoxGarantia.addItem("semana(s)");
		comboBoxGarantia.addItem("mes(es)");
		comboBoxGarantia.addItem("ano(s)");
		panelGarantia2.add(comboBoxGarantia, BorderLayout.EAST);
		
		JPanel panelFornecedorNome = new JPanel();
		panelFornecedorNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelQuant_Garan_For_CNPJ.add(panelFornecedorNome);
		panelFornecedorNome.setLayout(new GridLayout(0, 1, 5, 0));
		
		JLabel labelFornecedorNome = new JLabel("Nome do fornecedor");
		panelFornecedorNome.add(labelFornecedorNome);
		labelFornecedorNome.setHorizontalAlignment(SwingConstants.LEFT);
		labelFornecedorNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textFornecedorNome = new JTextField();
		panelFornecedorNome.add(textFornecedorNome);
		textFornecedorNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFornecedorNome.getText().isEmpty() || textFornecedorNome.getText().length() <= 0){
					labelFornecedorNome.setText("Nome do fornecedor*");
					labelFornecedorNome.setForeground(Color.RED);
				}
				else {
					labelFornecedorNome.setText("Nome do fornecedor");
					labelFornecedorNome.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelFornecedorNome.setText("Nome do fornecedor");
				labelFornecedorNome.setForeground(Color.BLACK);
			}
		});
		textFornecedorNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelFornecedorCNPJ = new JPanel();
		panelFornecedorCNPJ.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelQuant_Garan_For_CNPJ.add(panelFornecedorCNPJ);
		panelFornecedorCNPJ.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFornecedorCNPJ = new JLabel("CNPJ do fornecedor");
		labelFornecedorCNPJ.setHorizontalAlignment(SwingConstants.LEFT);
		labelFornecedorCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelFornecedorCNPJ.add(labelFornecedorCNPJ);
		
		textFornecedorCNPJ = new JFormattedTextField(numeroCNPJMascara);
		textFornecedorCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFornecedorCNPJ.setColumns(10);
		textFornecedorCNPJ.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFornecedorCNPJ.getText().replaceAll("\\.", "").replace("/","").replace("-","").trim().isEmpty()){
					labelFornecedorCNPJ.setText("CNPJ do fornecedor*");
					labelFornecedorCNPJ.setForeground(Color.RED);
				}
				else {
					labelFornecedorCNPJ.setText("CNPJ do fornecedor");
					labelFornecedorCNPJ.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelFornecedorCNPJ.setText("CNPJ do fornecedor");
				labelFornecedorCNPJ.setForeground(Color.BLACK);
			}
		});
		panelFornecedorCNPJ.add(textFornecedorCNPJ);
		
		JPanel panelTipoPro_Quant_Apli = new JPanel();
		panelCadastro.add(panelTipoPro_Quant_Apli);
		panelTipoPro_Quant_Apli.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelTipoProduto = new JPanel();
		panelTipoPro_Quant_Apli.add(panelTipoProduto);
		panelTipoProduto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoProduto.setLayout(new GridLayout(0, 1, 5, 0));
		
		JLabel labelTipoProduto = new JLabel("Tipo de produto");
		panelTipoProduto.add(labelTipoProduto);
		labelTipoProduto.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textTipoProduto = new JTextField();
		panelTipoProduto.add(textTipoProduto);
		textTipoProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTipoProduto.setColumns(10);
		
		JPanel panelQuantComponentes = new JPanel();
		panelQuantComponentes.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoPro_Quant_Apli.add(panelQuantComponentes);
		panelQuantComponentes.setLayout(new GridLayout(0, 1, 5, 0));
		
		JLabel labelQuantComponentes = new JLabel("Quantidade de componentes");
		labelQuantComponentes.setHorizontalAlignment(SwingConstants.LEFT);
		labelQuantComponentes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelQuantComponentes.add(labelQuantComponentes);
		
		textQuantComponentes = new JTextField();
		textQuantComponentes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textQuantComponentes.setColumns(10);
		textQuantComponentes.setDocument(new ValidaNumeroInteiro());
		panelQuantComponentes.add(textQuantComponentes);
		
		JPanel panelAplicacao = new JPanel();
		panelAplicacao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoPro_Quant_Apli.add(panelAplicacao);
		panelAplicacao.setLayout(new GridLayout(0, 1, 5, 0));
		
		JLabel labelAplicacao = new JLabel("Aplica\u00E7\u00E3o");
		labelAplicacao.setHorizontalAlignment(SwingConstants.LEFT);
		labelAplicacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelAplicacao.add(labelAplicacao);
		
		textAplicacao = new JTextField();
		textAplicacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAplicacao.setColumns(10);
		panelAplicacao.add(textAplicacao);
		
		JPanel panelEmbalagem_TipoEmbalagem = new JPanel();
		panelCadastro.add(panelEmbalagem_TipoEmbalagem);
		panelEmbalagem_TipoEmbalagem.setLayout(new BorderLayout(5, 0));
		
		JPanel panelEmbalagem = new JPanel();
		panelEmbalagem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmbalagem_TipoEmbalagem.add(panelEmbalagem, BorderLayout.WEST);
		panelEmbalagem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmbalagem = new JLabel("O produto tem embalagem(s) ?");
		labelEmbalagem.setPreferredSize(new Dimension(200, 14));
		labelEmbalagem.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmbalagem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEmbalagem.add(labelEmbalagem);
		
		JPanel panelEmbalagem2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelEmbalagem2.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelEmbalagem.add(panelEmbalagem2);
		
		radioEmbalagemSim = new JRadioButton();
		buttonGroupEmbalagem.add(radioEmbalagemSim);
		radioEmbalagemSim.setText("Sim");
		panelEmbalagem2.add(radioEmbalagemSim);
		radioEmbalagemSim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		radioEmbalagemNao = new JRadioButton();
		buttonGroupEmbalagem.add(radioEmbalagemNao);
		radioEmbalagemNao.setText("N\u00E3o");
		radioEmbalagemNao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEmbalagem2.add(radioEmbalagemNao);
		
		JPanel panelTipoEmbalagem = new JPanel();
		panelTipoEmbalagem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmbalagem_TipoEmbalagem.add(panelTipoEmbalagem);
		panelTipoEmbalagem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoEmbalagem = new JLabel("Tipo de embalagem");
		labelTipoEmbalagem.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoEmbalagem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTipoEmbalagem.add(labelTipoEmbalagem);
		
		textTipoEmbalagem = new JTextField();
		textTipoEmbalagem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTipoEmbalagem.setColumns(10);
		panelTipoEmbalagem.add(textTipoEmbalagem);
		
		JPanel panelEstampa_TipoEstampa = new JPanel();
		panelCadastro.add(panelEstampa_TipoEstampa);
		panelEstampa_TipoEstampa.setLayout(new BorderLayout(5, 0));
		
		JPanel panelEstampa = new JPanel();
		panelEstampa_TipoEstampa.add(panelEstampa, BorderLayout.WEST);
		panelEstampa.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstampa.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstampa = new JLabel("O produto tem estampa(s) ?");
		labelEstampa.setPreferredSize(new Dimension(200, 14));
		labelEstampa.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstampa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEstampa.add(labelEstampa);
		
		JPanel panelEstampa2 = new JPanel();
		FlowLayout fl_panelEstampa2 = (FlowLayout) panelEstampa2.getLayout();
		fl_panelEstampa2.setAlignment(FlowLayout.LEFT);
		fl_panelEstampa2.setVgap(0);
		fl_panelEstampa2.setHgap(0);
		panelEstampa.add(panelEstampa2);
		
		radioEstampaSim = new JRadioButton();
		buttonGroupEstampa.add(radioEstampaSim);
		radioEstampaSim.setText("Sim");
		panelEstampa2.add(radioEstampaSim);
		radioEstampaSim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		radioEstampaNao = new JRadioButton();
		buttonGroupEstampa.add(radioEstampaNao);
		radioEstampaNao.setText("N\u00E3o");
		radioEstampaNao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEstampa2.add(radioEstampaNao);
		
		JPanel panelTipoEstampa = new JPanel();
		panelEstampa_TipoEstampa.add(panelTipoEstampa);
		panelTipoEstampa.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoEstampa.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoEstampa = new JLabel("Tipo de estampa");
		labelTipoEstampa.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoEstampa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTipoEstampa.add(labelTipoEstampa);
		
		textTipoEstampa = new JTextField();
		textTipoEstampa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTipoEstampa.setColumns(10);
		panelTipoEstampa.add(textTipoEstampa);
		
		JPanel panelCor_Mode_Mon = new JPanel();
		panelCadastro.add(panelCor_Mode_Mon);
		panelCor_Mode_Mon.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelCor = new JPanel();
		panelCor.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCor_Mode_Mon.add(panelCor);
		panelCor.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCor = new JLabel("Cor");
		labelCor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCor.add(labelCor);
		
		textCor = new JTextField();
		textCor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCor.setColumns(10);
		panelCor.add(textCor);
		
		JPanel panelModelo = new JPanel();
		panelModelo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCor_Mode_Mon.add(panelModelo);
		panelModelo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelModelo = new JLabel("Modelo");
		labelModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelModelo.add(labelModelo);
		
		textModelo = new JTextField();
		textModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelModelo.add(textModelo);
		textModelo.setColumns(10);
		
		JPanel panelMontagem = new JPanel();
		panelMontagem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCor_Mode_Mon.add(panelMontagem);
		panelMontagem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelMontagem = new JLabel("O produto necessita de montagem ?");
		labelMontagem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelMontagem.add(labelMontagem);
		
		JPanel panelMontagem2 = new JPanel();
		FlowLayout fl_panelMontagem2 = (FlowLayout) panelMontagem2.getLayout();
		fl_panelMontagem2.setAlignment(FlowLayout.LEFT);
		fl_panelMontagem2.setVgap(0);
		fl_panelMontagem2.setHgap(0);
		panelMontagem.add(panelMontagem2);
		
		radioMontagemSim = new JRadioButton();
		buttonGroupMontagem.add(radioMontagemSim);
		radioMontagemSim.setText("Sim");
		panelMontagem2.add(radioMontagemSim);
		radioMontagemSim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		radioMontagemNao = new JRadioButton();
		buttonGroupMontagem.add(radioMontagemNao);
		radioMontagemNao.setText("N\u00E3o");
		radioMontagemNao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelMontagem2.add(radioMontagemNao);
		
		JPanel panelPeso_Altura_Comprimento = new JPanel();
		panelCadastro.add(panelPeso_Altura_Comprimento);
		panelPeso_Altura_Comprimento.setLayout(new GridLayout(0, 3, 5, 5));
		
		JPanel panelPeso = new JPanel();
		panelPeso_Altura_Comprimento.add(panelPeso);
		panelPeso.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPeso.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPeso = new JLabel("Peso");
		panelPeso.add(labelPeso);
		labelPeso.setHorizontalAlignment(SwingConstants.LEFT);
		labelPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelPeso2 = new JPanel();
		panelPeso.add(panelPeso2);
		panelPeso2.setLayout(new BorderLayout(0, 0));
		
		textPeso = new JTextField();
		panelPeso2.add(textPeso, BorderLayout.CENTER);
		textPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPeso.setColumns(10);
		PlainDocument documentPeso = (PlainDocument) textPeso.getDocument();
		documentPeso.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxPeso = new JComboBox<String>();
		comboBoxPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxPeso.setMaximumRowCount(5);
		comboBoxPeso.addItem("Escolha");
		comboBoxPeso.addItem("mg");
		comboBoxPeso.addItem("g");
		comboBoxPeso.addItem("kg");
		comboBoxPeso.addItem("tonelada(s)");
		panelPeso2.add(comboBoxPeso, BorderLayout.EAST);
		
		JPanel panelAltura = new JPanel();
		panelPeso_Altura_Comprimento.add(panelAltura);
		panelAltura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelAltura.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelAltura = new JLabel("Altura");
		labelAltura.setHorizontalAlignment(SwingConstants.LEFT);
		labelAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelAltura.add(labelAltura);
		
		JPanel panelAltura2 = new JPanel();
		panelAltura.add(panelAltura2);
		panelAltura2.setLayout(new BorderLayout(0, 0));
		
		textAltura = new JTextField();
		panelAltura2.add(textAltura, BorderLayout.CENTER);
		textAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAltura.setColumns(10);
		PlainDocument documentAltura = (PlainDocument) textAltura.getDocument();
		documentAltura.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxAltura = new JComboBox<String>();
		panelAltura2.add(comboBoxAltura, BorderLayout.EAST);
		comboBoxAltura.setMaximumRowCount(5);
		comboBoxAltura.addItem("Escolha");
		comboBoxAltura.addItem("polegada(s)");
		comboBoxAltura.addItem("mm");
		comboBoxAltura.addItem("cm");
		comboBoxAltura.addItem("m");
		comboBoxAltura.addItem("km");
		comboBoxAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelComprimento = new JPanel();
		panelPeso_Altura_Comprimento.add(panelComprimento);
		panelComprimento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComprimento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComprimento = new JLabel("Comprimento");
		labelComprimento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComprimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelComprimento.add(labelComprimento);
		
		JPanel panelComprimento2 = new JPanel();
		panelComprimento.add(panelComprimento2);
		panelComprimento2.setLayout(new BorderLayout(0, 0));
		
		textComprimento = new JTextField();
		textComprimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textComprimento.setColumns(10);
		panelComprimento2.add(textComprimento, BorderLayout.CENTER);
		PlainDocument documentComprimento = (PlainDocument) textComprimento.getDocument();
		documentComprimento.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxComprimento = new JComboBox<String>();
		comboBoxComprimento.setMaximumRowCount(5);
		comboBoxComprimento.addItem("Escolha");
		comboBoxComprimento.addItem("polegada(s)");
		comboBoxComprimento.addItem("mm");
		comboBoxComprimento.addItem("cm");
		comboBoxComprimento.addItem("m");
		comboBoxComprimento.addItem("km");
		comboBoxComprimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelComprimento2.add(comboBoxComprimento, BorderLayout.EAST);
		
		JPanel panelLargura_Profundidade_Espessura = new JPanel();
		panelCadastro.add(panelLargura_Profundidade_Espessura);
		panelLargura_Profundidade_Espessura.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelLargura = new JPanel();
		panelLargura_Profundidade_Espessura.add(panelLargura);
		panelLargura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelLargura.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLargura = new JLabel("Largura");
		labelLargura.setHorizontalAlignment(SwingConstants.LEFT);
		labelLargura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelLargura.add(labelLargura);
		
		JPanel panelLargura2 = new JPanel();
		panelLargura.add(panelLargura2);
		panelLargura2.setLayout(new BorderLayout(0, 0));
		
		textLargura = new JTextField();
		textLargura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textLargura.setColumns(10);
		panelLargura2.add(textLargura, BorderLayout.CENTER);
		PlainDocument documentLargura = (PlainDocument) textLargura.getDocument();
		documentLargura.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxLargura = new JComboBox<String>();
		comboBoxLargura.setMaximumRowCount(5);
		comboBoxLargura.addItem("Escolha");
		comboBoxLargura.addItem("polegada(s)");
		comboBoxLargura.addItem("mm");
		comboBoxLargura.addItem("cm");
		comboBoxLargura.addItem("m");
		comboBoxLargura.addItem("km");
		comboBoxLargura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelLargura2.add(comboBoxLargura, BorderLayout.EAST);
		
		JPanel panelProfundidade = new JPanel();
		panelLargura_Profundidade_Espessura.add(panelProfundidade);
		panelProfundidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelProfundidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelProfundidade = new JLabel("Profundidade");
		labelProfundidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelProfundidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelProfundidade.add(labelProfundidade);
		
		JPanel panelProfundidade2 = new JPanel();
		panelProfundidade.add(panelProfundidade2);
		panelProfundidade2.setLayout(new BorderLayout(0, 0));
		
		textProfundidade = new JTextField();
		textProfundidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textProfundidade.setColumns(10);
		panelProfundidade2.add(textProfundidade, BorderLayout.CENTER);
		PlainDocument documentProfundidade = (PlainDocument) textProfundidade.getDocument();
		documentProfundidade.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxProfundidade = new JComboBox<String>();
		comboBoxProfundidade.setMaximumRowCount(5);
		comboBoxProfundidade.addItem("Escolha");
		comboBoxProfundidade.addItem("polegada(s)");
		comboBoxProfundidade.addItem("mm");
		comboBoxProfundidade.addItem("cm");
		comboBoxProfundidade.addItem("m");
		comboBoxProfundidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelProfundidade2.add(comboBoxProfundidade, BorderLayout.EAST);
		
		JPanel panelEspessura = new JPanel();
		panelLargura_Profundidade_Espessura.add(panelEspessura);
		panelEspessura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEspessura.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEspessura = new JLabel("Espessura");
		labelEspessura.setHorizontalAlignment(SwingConstants.LEFT);
		labelEspessura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEspessura.add(labelEspessura);
		
		JPanel panelEspessura2 = new JPanel();
		panelEspessura.add(panelEspessura2);
		panelEspessura2.setLayout(new BorderLayout(0, 0));
		
		textEspessura = new JTextField();
		textEspessura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEspessura.setColumns(10);
		panelEspessura2.add(textEspessura, BorderLayout.CENTER);
		PlainDocument documentEspessura = (PlainDocument) textEspessura.getDocument();
		documentEspessura.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxEspessura = new JComboBox<String>();
		comboBoxEspessura.setMaximumRowCount(5);
		comboBoxEspessura.addItem("Escolha");
		comboBoxEspessura.addItem("polegada(s)");
		comboBoxEspessura.addItem("mm");
		comboBoxEspessura.addItem("cm");
		comboBoxEspessura.addItem("m");
		comboBoxEspessura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEspessura2.add(comboBoxEspessura, BorderLayout.EAST);
		
		JPanel panelDescricaoProduto = new JPanel();
		tabbedPaneCadastroProduto.addTab("Descri\u00E7\u00E3o produto", null, panelDescricaoProduto, null);
		panelDescricaoProduto.setLayout(new BorderLayout(0, 5));
		
		JPanel panelDescricao2 = new JPanel();
		panelDescricaoProduto.add(panelDescricao2, BorderLayout.NORTH);
		panelDescricao2.setLayout(new BorderLayout(0, 0));
		
		JLabel descricaoProduto = new JLabel("Descri\u00E7\u00E3o do produto");
		descricaoProduto.setHorizontalAlignment(SwingConstants.LEFT);
		panelDescricao2.add(descricaoProduto, BorderLayout.CENTER);
		descricaoProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPaneDescricao = new JScrollPane();
		panelDescricaoProduto.add(scrollPaneDescricao, BorderLayout.CENTER);
		scrollPaneDescricao.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneDescricao.getHorizontalScrollBar().setUnitIncrement(10);
		
		textAreaDescricao = new JTextArea();
		scrollPaneDescricao.setViewportView(textAreaDescricao);
		textAreaDescricao.setAutoscrolls(false);
		textAreaDescricao.setLineWrap(true);
		textAreaDescricao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaDescricao.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelAcessorios = new JPanel();
		tabbedPaneCadastroProduto.addTab("Acessorios", null, panelAcessorios, null);
		panelAcessorios.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelAcessorios.setLayout(new BorderLayout(5, 0));
		
		JPanel panelAcessorios2 = new JPanel();
		panelAcessorios.add(panelAcessorios2, BorderLayout.NORTH);
		panelAcessorios2.setLayout(new BorderLayout(0, 0));
		
		JLabel labelAcessorios = new JLabel("Acessorios");
		labelAcessorios.setHorizontalAlignment(SwingConstants.LEFT);
		labelAcessorios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelAcessorios2.add(labelAcessorios, BorderLayout.CENTER);
		
		JScrollPane scrollPaneAcessorios = new JScrollPane();
		scrollPaneAcessorios.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneAcessorios.getHorizontalScrollBar().setUnitIncrement(10);
		panelAcessorios.add(scrollPaneAcessorios, BorderLayout.CENTER);
		
		textAreaAcessorios = new JTextArea();
		scrollPaneAcessorios.setViewportView(textAreaAcessorios);
		textAreaAcessorios.setLineWrap(true);
		textAreaAcessorios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaAcessorios.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaAcessorios.setAutoscrolls(false);
	    
		JPanel panelBotoes = new JPanel();
		telaCadastroProduto.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorCadastrodeproduto = new JSeparator();
		panelBotoes.add(separatorCadastrodeproduto, BorderLayout.NORTH);
		
		JPanel panelLegenda = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelLegenda.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(10);
		panelBotoes.add(panelLegenda, BorderLayout.WEST);
		
		JLabel LabelLegenda = new JLabel("Legenda: (*) Campo importante que deve ser preenchido");
		LabelLegenda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelLegenda.add(LabelLegenda);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2, BorderLayout.CENTER);

		JButton dados = new JButton("Dados");
		dados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNome.setText("Nome");
				textMarca.setText("Marca");
				textLote.setText("Lote123");
				textCodigoBarras.setText("12521");
				textDataPrimeiraCompra.setText("12/06/2016");
				textDataFabricacao.setText("10/01/2016");
				textDataValidade.setText("12/06/2018");
				textQuantidade.setText("100");
				comboBoxQuantidade.setSelectedItem("unidade(s)");
				textPrecoCompra.setText("10.00");
				textPrecoVenda.setText("20.00");
				textTipoProduto.setText("Tipo de produto");
				textAplicacao.setText("Aplicacao");
				textModelo.setText("Modelo");
				textCor.setText("Cor");
				textVidaUtil.setText("2");
				comboBoxVidaUtil.setSelectedItem("ano(s)");
				textQuantComponentes.setText("1");
				textTipoEmbalagem.setText("Tipo de embalagem");
				textTipoEstampa.setText("Tipo de estampa");
				textGarantia.setText("10");
				comboBoxGarantia.setSelectedItem("ano(s)");
				textPeso.setText("10");
				comboBoxPeso.setSelectedItem("kg");
				textAltura.setText("10");
				comboBoxAltura.setSelectedItem("m");
				textComprimento.setText("10");
				comboBoxComprimento.setSelectedItem("m");
				textLargura.setText("10");
				comboBoxLargura.setSelectedItem("m");
				textEspessura.setText("10");
				comboBoxEspessura.setSelectedItem("m");
				textProfundidade.setText("10");
				comboBoxProfundidade.setSelectedItem("m");
				textAreaAcessorios.setText("Acessorios");
				textAreaDescricao.setText("Descricao");
				radioEmbalagemSim.setSelected(true);
				radioEstampaSim.setSelected(true);
				radioMontagemSim.setSelected(true);
				radioNacional.setSelected(true);
				textFornecedorNome.setText("Nome do fornecedor");
				textFornecedorCNPJ.setText("12.312.321/3213-2");
			}
		});
		dados.setToolTipText("Dados");
		dados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(dados);
		
		fornecedor = new JButton("Fornecedor");
		fornecedor.setToolTipText("Selecionar um fornecedor");
		fornecedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastro_de_Produto_Adicionar_Fornecedor CadastroProdutoFornecedor = new Cadastro_de_Produto_Adicionar_Fornecedor();
				CadastroProdutoFornecedor.setVisible(true);
				String fornecedorNomeTexto = CadastroProdutoFornecedor.getFornecedorNome();
				String fornecedorCNPJTexto = CadastroProdutoFornecedor.getFornecedorCNPJ();
				if (fornecedorNomeTexto != null || fornecedorCNPJTexto != null) {
					textFornecedorNome.setText(fornecedorNomeTexto);
					textFornecedorCNPJ.setText(fornecedorCNPJTexto);
				}
			}
		});
		panelBotoes2.add(fornecedor);
		
		salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textNome.getText().isEmpty() || textNome.getText().length() <= 0 ||
					textMarca.getText().isEmpty() || textMarca.getText().length() <= 0 ||
					textLote.getText().isEmpty() || textLote.getText().length() <= 0 ||
					textCodigoBarras.getText().isEmpty() || textCodigoBarras.getText().length() <= 0 ||
					textPrecoCompra.getText().isEmpty() || textPrecoCompra.getText().length() <= 0 ||
					textGarantia.getText().isEmpty() || textGarantia.getText().length() <= 0 ||
					textFornecedorNome.getText().isEmpty() || textFornecedorNome.getText().length() <= 0 ||
					textFornecedorCNPJ.getText().replaceAll("\\.", "").replace("/","").replace("-","").trim().isEmpty() ||
					comboBoxGarantia.getSelectedItem() == "Escolha" ||
					buttonGroupProduto.getSelection() == null) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					try{
						/*Envia os dados para o banco de dados*/
						cadastrarProduto = new Produto();
						cadastrarProdutoEstoque = new EstoqueProdutos();
						
						/*Cadastro do nome do produto*/
						cadastrarProduto.setNome(textNome.getText());
						cadastrarProdutoEstoque.setNome(textNome.getText());
						
						/*Cadastro da marca do produto*/
						cadastrarProduto.setMarca(textMarca.getText());
						
						/*Cadastro da lote do produto*/
						cadastrarProduto.setLote(textLote.getText());
						cadastrarProdutoEstoque.setLote(textLote.getText());
						
						/*Cadastro do codigo de barras do produto*/
						cadastrarProduto.setCodigoBarras(textCodigoBarras.getText());
						
						/*Cadastro do preço de compra do produto*/
						cadastrarProduto.setPrecoCompra(Double.parseDouble(textPrecoCompra.getText()));
						
						/*Cadastro do preço de compra a vista do produto*/
						cadastrarProduto.setPrecoaVista(Double.parseDouble(textPrecoVenda.getText()));
						cadastrarProdutoEstoque.setPrecoaVista(Double.parseDouble(textPrecoVenda.getText()));
						
						/*Cadastro do fornecedor do produto*/
						cadastrarProduto.setFornecedor(textFornecedorNome.getText());
						
						/*Cadastro do fornecedor do produto*/
						cadastrarProduto.setFornecedorCNPJ(textFornecedorCNPJ.getText());
						
						/*Cadastro do codigo do produto*/
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
						cadastrarProduto.setCodigoProduto(codigoRegistro);
						cadastrarProdutoEstoque.setCodigoProduto(codigoRegistro);
						
						/*Cadastro da quantidade do produto*/
						cadastrarProduto.setQuantidade(Double.parseDouble(textQuantidade.getText()));
						cadastrarProdutoEstoque.setQuantidade(Double.parseDouble(textQuantidade.getText()));
						
						cadastrarProduto.setQuantidadeUnidade((String)comboBoxQuantidade.getSelectedItem());
						cadastrarProdutoEstoque.setQuantidadeUnidade((String)comboBoxQuantidade.getSelectedItem());
						
						/*Cadastro do estado do produto*/
						String estadoProduto = "Em estoque";
						cadastrarProdutoEstoque.setEstadoProduto(estadoProduto);
						
						/*Cadastro da data do cadastro*/
						try {
							java.util.Date dataRegistro = new java.util.Date();
							SimpleDateFormat dataRegistroFormato = new SimpleDateFormat("dd/MM/yyyy");
							String dataCadastroCliente = dataRegistroFormato.format(dataRegistro);
							SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
							Date dataCadastro = new java.sql.Date(dataCadastroFormato.parse(dataCadastroCliente).getTime());
							cadastrarProduto.setDataCadastro(dataCadastro);
						} catch (ParseException e9) {
							e9.printStackTrace();
						}
						
						/*Cadastro da hora do cadastro*/
						try {
							java.util.Date horaRegistro = new java.util.Date();
							SimpleDateFormat horaRegistroFormato = new SimpleDateFormat("HH:mm");
							String horaCadastroCliente = horaRegistroFormato.format(horaRegistro);
							SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("hh:mm");
							Time horaCadastro = new java.sql.Time(horaCadastroFormato.parse(horaCadastroCliente).getTime());
							cadastrarProduto.setHoraCadastro(horaCadastro);
						} catch (ParseException e9) {
							e9.printStackTrace();
						}
						
						/*Cadastro do nome do funcionario*/
						if (nomeUsuario == null) {
							String nomeFuncionario = "Nome";
							cadastrarProduto.setFuncionarioCadastro(nomeFuncionario);
						}
						else {
							cadastrarProduto.setFuncionarioCadastro(nomeUsuario);
						}
						
						if (codigoUsuario == null) {
							String codigoFuncionario = "Codigo";
							cadastrarProduto.setCodigoFuncionario(codigoFuncionario);
						}
						else {
							cadastrarProduto.setCodigoFuncionario(codigoUsuario);
						}
						
						/*Cadastro do cargo do funcionario*/
						if (cargoUsuario == null) {
							String cargoFuncionario = "Cargo";
							cadastrarProduto.setCargoFuncionario(cargoFuncionario);
						}
						else {
							cadastrarProduto.setCargoFuncionario(cargoUsuario);
						}
						
						/*Cadastro do tipo do produto*/
						if (textTipoProduto.getText().isEmpty() || textTipoProduto.getText().length() <= 0) {
							tipoProdutoTexto = "Produto sem informações";
							cadastrarProduto.setTipoProduto(tipoProdutoTexto);
						} else {
							cadastrarProduto.setTipoProduto(textTipoProduto.getText());
						}
						
						/*Cadastro da aplicação do produto*/
						if (textAplicacao.getText().isEmpty() || textAplicacao.getText().length() <= 0) {
							aplicacaoProdutoTexto = "Produto sem informações";
							cadastrarProduto.setAplicacao(aplicacaoProdutoTexto);
						} else {
							cadastrarProduto.setAplicacao(textAplicacao.getText());
						}
						
						/*Cadastro da cor do produto*/
						if (textCor.getText().isEmpty() || textCor.getText().length() <= 0) {
							corProdutoTexto = "Produto sem informações";
							cadastrarProduto.setCor(corProdutoTexto);
						} else {
							cadastrarProduto.setCor(textCor.getText());
						}
						
						/*Cadastro do modelo do produto*/
						if (textModelo.getText().isEmpty() || textModelo.getText().length() <= 0) {
							modeloProdutoTexto = "Produto sem informações";
							cadastrarProduto.setModelo(modeloProdutoTexto);
						} else {
							cadastrarProduto.setModelo(textModelo.getText());
						}
						
						/*Cadastro da quantidade de componentes*/
						if (textQuantComponentes.getText().isEmpty() || textQuantComponentes.getText().length() <= 0) {
							quantidadeCompoenentesTexto = "1";
							cadastrarProduto.setQuantidadeComponentes(Integer.parseInt(quantidadeCompoenentesTexto));
						} else {
							cadastrarProduto.setQuantidadeComponentes(Integer.parseInt(textQuantComponentes.getText()));
						}
						
						/*Cadastro do tipo de embalagem do produto*/
						if (textTipoEmbalagem.getText().isEmpty() || textTipoEmbalagem.getText().length() <= 0) {
							tipoEmbalagemTexto = "Produto sem informações";
							cadastrarProduto.setTipoEmbalagem(tipoEmbalagemTexto);
						} else {
							cadastrarProduto.setTipoEmbalagem(textTipoEmbalagem.getText());
						}
						
						/*Cadastro do tipo de estampa do produto*/
						if (textTipoEstampa.getText().isEmpty() || textTipoEstampa.getText().length() <= 0) {
							tipoEstampaTexto = "Produto sem informações";
							cadastrarProduto.setTipoEstampa(tipoEstampaTexto);
						} else {
							cadastrarProduto.setTipoEstampa(textTipoEstampa.getText());
						}
						
						/*Cadastro dos acessorios do produto*/
						if (textAreaAcessorios.getText().isEmpty() || textAreaAcessorios.getText().length() <= 0) {
							descricaoProdutoTexto = "Produto sem descrição";
							cadastrarProduto.setAcessorios(descricaoProdutoTexto);
						} else {
							cadastrarProduto.setAcessorios(textAreaAcessorios.getText());
						}
						
						/*Cadastro da descrição do produto*/
						if (textAreaDescricao.getText().isEmpty() || textAreaDescricao.getText().length() <= 0) {
							acessoriosProdutoTexto = "Produto sem acessorio";
							cadastrarProduto.setDescricao(acessoriosProdutoTexto);
						} else {
							cadastrarProduto.setDescricao(textAreaDescricao.getText());
						}
						
						/*Cadastro da quantidade do produto*/
						if (textQuantidade.getText().isEmpty() || textQuantidade.getText().length() <= 0 || comboBoxQuantidade.getSelectedItem() == "Escolha") {
							quantidade = "0";
							quantidadeUnidade = "Não determinada";
							cadastrarProduto.setQuantidade(Double.parseDouble(quantidade));
							cadastrarProduto.setQuantidadeUnidade(quantidadeUnidade);
						}
						else{
							quantidadeValor = textQuantidade.getText();
							quantidadeUnidade = (String) comboBoxQuantidade.getSelectedItem();
							cadastrarProduto.setQuantidade(Double.parseDouble(quantidadeValor));
							cadastrarProduto.setQuantidadeUnidade(quantidadeUnidade);
						}
						
						/*Cadastro da vida util do produto*/
						if (textVidaUtil.getText().isEmpty() || textVidaUtil.getText().length() <= 0 || comboBoxVidaUtil.getSelectedItem() == "Escolha") {
							vidaUtilTexto =  "0";
							vidaUtilUnidadeTexto = "Não determinada";
							cadastrarProduto.setVidaUtil(vidaUtilTexto);
							cadastrarProduto.setVidaUtilUnidade(vidaUtilUnidadeTexto);
						}
						else{
							vidaUtilValor = textVidaUtil.getText();
							vidaUtilUnidade = (String) comboBoxVidaUtil.getSelectedItem();
							cadastrarProduto.setVidaUtil(vidaUtilValor);
							cadastrarProduto.setVidaUtilUnidade(vidaUtilUnidade);
						}
						
						/*Cadastro da garantia*/
						if (textGarantia.getText().isEmpty() || textGarantia.getText().length() <= 0 || comboBoxGarantia.getSelectedItem() == "Escolha") {
							garantiaTexto =  "0";
							garantiaUnidadeTexto = "Não determinada";
							cadastrarProduto.setGarantia(garantiaTexto);
							cadastrarProduto.setGarantiaUnidade(garantiaUnidadeTexto);
						} 
						else {
							garantiaValor = textGarantia.getText();
							garantiaUnidade = (String) comboBoxGarantia.getSelectedItem();
							cadastrarProduto.setGarantia(garantiaValor);
							cadastrarProduto.setGarantiaUnidade(garantiaUnidade);
						}
						
						/*Cadastro da altura*/
						if (textAltura.getText().isEmpty() || textAltura.getText().length() <= 0 || comboBoxAltura.getSelectedItem() == "Escolha") {
							alturaTexto =  "0";
							alturaUnidadeTexto = "Não determinada";
							cadastrarProduto.setAltura(alturaTexto);
							cadastrarProduto.setAlturaUnidade(alturaUnidadeTexto);
						} 
						else {
							alturaValor = textAltura.getText();
							alturaUnidade = (String) comboBoxAltura.getSelectedItem();
							cadastrarProduto.setAltura(alturaValor);
							cadastrarProduto.setAlturaUnidade(alturaUnidade);
						}
						
						/*Cadastro do peso*/
						if (textPeso.getText().isEmpty() || textPeso.getText().length() <= 0 || comboBoxPeso.getSelectedItem() == "Escolha") {
							pesoTexto =  "0";
							pesoUnidadeTexto = "Não determinada";
							cadastrarProduto.setPeso(pesoTexto);
							cadastrarProduto.setPesoUnidade(pesoUnidadeTexto);
						} 
						else {
							pesoValor = textPeso.getText();
							pesoUnidade = (String) comboBoxPeso.getSelectedItem();
							cadastrarProduto.setPeso(pesoValor);
							cadastrarProduto.setPesoUnidade(pesoUnidade);
						}
						
						/*Cadastro do comprimento*/
						if (textComprimento.getText().isEmpty() || textComprimento.getText().length() <= 0 || comboBoxComprimento.getSelectedItem() == "Escolha") {
							comprimentoTexto =  "0";
							comprimentoUnidadeTexto = "Não determinada";
							cadastrarProduto.setComprimento(comprimentoTexto);
							cadastrarProduto.setComprimentoUnidade(comprimentoUnidadeTexto);
						} 
						else {
							comprimentoValor = textComprimento.getText();
							comprimentoUnidade = (String) comboBoxComprimento.getSelectedItem();
							cadastrarProduto.setComprimento(comprimentoValor);
							cadastrarProduto.setComprimentoUnidade(comprimentoUnidade);
						}
						
						/*Cadastro da largura*/
						if (textLargura.getText().isEmpty() || textLargura.getText().length() <= 0 || comboBoxLargura.getSelectedItem() == "Escolha") {
							larguraTexto =  "0";
							larguraUnidadeTexto = "Não determinada";
							cadastrarProduto.setLargura(larguraTexto);
							cadastrarProduto.setLarguraUnidade(larguraUnidadeTexto);
						} 
						else {
							larguraValor = textLargura.getText();
							larguraUnidade = (String) comboBoxLargura.getSelectedItem();
							cadastrarProduto.setLargura(larguraValor);
							cadastrarProduto.setLarguraUnidade(larguraUnidade);
						}
						
						/*Cadastro da espessura*/
						if (textEspessura.getText().isEmpty() || textEspessura.getText().length() <= 0 || comboBoxEspessura.getSelectedItem() == "Escolha") {
							espessuraTexto =  "0";
							espessuraUnidadeTexto = "Não determinada";
							cadastrarProduto.setEspessura(espessuraTexto);
							cadastrarProduto.setEspessuraUnidade(espessuraUnidadeTexto);
						} 
						else {
							espessuraValor = textEspessura.getText();
							espessuraUnidade = (String) comboBoxEspessura.getSelectedItem();
							cadastrarProduto.setEspessura(espessuraValor);
							cadastrarProduto.setEspessuraUnidade(espessuraUnidade);
						}
						
						/*Cadastro da profundidade*/
						if (textProfundidade.getText().isEmpty() || textProfundidade.getText().length() <= 0 || comboBoxProfundidade.getSelectedItem() == "Escolha") {
							profundidadeTexto =  "0";
							profundidadeUnidadeTexto = "Não determinada";
							cadastrarProduto.setProfundidade(profundidadeTexto);
							cadastrarProduto.setProfundidadeUnidade(profundidadeUnidadeTexto);
						} 
						else {
							profundidadeValor = textProfundidade.getText();
							profundidadeUnidade = (String) comboBoxProfundidade.getSelectedItem();
							cadastrarProduto.setProfundidade(profundidadeValor);
							cadastrarProduto.setProfundidadeUnidade(profundidadeUnidade);
						}
						
						/*Cadastro da data da primeira compra do produto*/
						if (textDataPrimeiraCompra.getText().replaceAll("\\/", "").trim().isEmpty()) {
							Date dataPrimeiraCompraValor = null;
							cadastrarProduto.setDataPrimeiraCompra(dataPrimeiraCompraValor);
						}
						else {
							dataPrimeiraCompraProduto = textDataPrimeiraCompra.getText();
							try {
								dataCompraFormato = new SimpleDateFormat("dd/MM/yyyy");
								dataCompra = new java.sql.Date(dataCompraFormato.parse(dataPrimeiraCompraProduto).getTime());
								cadastrarProduto.setDataPrimeiraCompra(dataCompra);
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
						}
						
						/*Cadastro da data de fabricação do produto*/
						if (textDataFabricacao.getText().replaceAll("\\/", "").trim().isEmpty()) {
							Date dataFabricacaoValor = null;
							cadastrarProduto.setDataFabricacao(dataFabricacaoValor);
						}
						else {
							dataFabricacaoProduto = textDataFabricacao.getText();
							try {
								dataFabricacaoFormato = new SimpleDateFormat("dd/MM/yyyy");
								dataFabricacao = new java.sql.Date(dataFabricacaoFormato.parse(dataFabricacaoProduto).getTime());
								cadastrarProduto.setDataFabricacao(dataFabricacao);
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
						}
						
						/*Cadastro da data de validade do produto*/
						if (textDataValidade.getText().replaceAll("\\/", "").trim().isEmpty()) {
							Date dataValidadeValor = null;
							cadastrarProduto.setDataValidade(dataValidadeValor);
						}
						else {
							dataValidadeProduto = textDataValidade.getText();					
							try {
								dataValidadeFormato = new SimpleDateFormat("dd/MM/yyyy");
								dataValidade = new java.sql.Date(dataValidadeFormato.parse(dataValidadeProduto).getTime());
								cadastrarProduto.setDataValidade(dataValidade);
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
						}
						
						/*Cadastro da origem do produto*/
						if (radioImportado.isSelected()) {
							origemProduto = radioImportado.getText();
							cadastrarProduto.setOrigemProduto(origemProduto);
						}
						if (radioNacional.isSelected()) {
							origemProduto = radioNacional.getText();
							cadastrarProduto.setOrigemProduto(origemProduto);
						}
						
						/*Cadastro da montagem do produto*/
						if (radioMontagemSim.isSelected()) {
							montagemProduto = radioMontagemSim.getText();
							cadastrarProduto.setMontagem(montagemProduto);
						}
						if (radioMontagemNao.isSelected()) {
							montagemProduto = radioMontagemNao.getText();
							cadastrarProduto.setMontagem(montagemProduto);
						}
						
						/*Cadastro da embalagem*/
						if (radioEmbalagemSim.isSelected()) {
							embalagemProduto = radioEmbalagemSim.getText();
							cadastrarProduto.setEmbalagem(embalagemProduto);
						}
						if (radioEmbalagemNao.isSelected()) {
							embalagemProduto = radioEmbalagemNao.getText();
							cadastrarProduto.setEmbalagem(embalagemProduto);
						}
						cadastrarProduto.setTipoEmbalagem(textTipoEmbalagem.getText());
						
						/*Cadastro da estampa*/
						if (radioEstampaSim.isSelected()) {
							estampaProduto = radioEstampaSim.getText();
							cadastrarProduto.setEstampa(estampaProduto);
						}
						if (radioEstampaNao.isSelected()) {
							estampaProduto = radioEstampaNao.getText();
							cadastrarProduto.setEstampa(estampaProduto);
						}
						cadastrarProduto.setTipoEstampa(textTipoEstampa.getText());
						
						
						/*Envia os dados para a classe que salva os dados no banco*/
						salvaDados = new Dao_inserir_dados_produto();
						salvaDados.Inserir_Dados_Produto(cadastrarProduto);
						
						salvaDadosEstoque = new Dao_inserir_dados_produto_estoque();
						salvaDadosEstoque.Inserir_Dados_Produto_Estoque(cadastrarProdutoEstoque);
						
						/*Mensagem de confirmação do cadastro*/
						String menssagemConteudo = "Dados cadastrados com sucesso";
						Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
						mensagemConfirmacao.setVisible(true);
						
						/*Limpa os campos depois que o cadastro é realizado*/
						textNome.setText("");
						textMarca.setText("");
						textLote.setText("");
						textCodigoBarras.setText("");
						textDataPrimeiraCompra.setText("");
						textDataFabricacao.setText("");
						textDataValidade.setText("");
						textPrecoCompra.setText("");
						textPrecoVenda.setText("");
						textQuantidade.setText("");
						textTipoProduto.setText("");
						textAplicacao.setText("");
						textModelo.setText("");
						textCor.setText("");
						textVidaUtil.setText("");
						textQuantComponentes.setText("");
						textTipoEmbalagem.setText("");
						textTipoEstampa.setText("");
						textGarantia.setText("");
						textPeso.setText("");
						textAltura.setText("");
						textComprimento.setText("");
						textLargura.setText("");
						textEspessura.setText("");
						textProfundidade.setText("");
						textAreaAcessorios.setText("");
						textAreaDescricao.setText("");
						textFornecedorNome.setText("");
						textFornecedorCNPJ.setText("");
						buttonGroupProduto.clearSelection();
						buttonGroupMontagem.clearSelection();
						buttonGroupEstampa.clearSelection();
						buttonGroupEmbalagem.clearSelection();
						comboBoxPeso.setSelectedItem("Escolha");
						comboBoxAltura.setSelectedItem("Escolha");
						comboBoxComprimento.setSelectedItem("Escolha");
						comboBoxEspessura.setSelectedItem("Escolha");
						comboBoxLargura.setSelectedItem("Escolha");
						comboBoxProfundidade.setSelectedItem("Escolha");
						comboBoxVidaUtil.setSelectedItem("Escolha");
						comboBoxGarantia.setSelectedItem("Escolha");
						labelNome.setText("Nome");
						labelNome.setForeground(Color.BLACK);
						labelMarca.setText("Marca");
						labelMarca.setForeground(Color.BLACK);
						labelLote.setText("Lote");
						labelLote.setForeground(Color.BLACK);
						labelFornecedorNome.setText("Nome do fornecedor");
						labelFornecedorNome.setForeground(Color.BLACK);
						labelFornecedorCNPJ.setText("CNPJ do fornecedor");
						labelFornecedorCNPJ.setForeground(Color.BLACK);
						labelCodigoBarras.setText("Codigo de barras");
						labelCodigoBarras.setForeground(Color.BLACK);
						labelDataPrimeiraCompra.setText("Data da primeira compra");
						labelDataPrimeiraCompra.setForeground(Color.BLACK);
						labelDataFabricacao.setText("Data de fabricação");
						labelDataFabricacao.setForeground(Color.BLACK);
						labelDataValidade.setText("Data de validade");
						labelDataValidade.setForeground(Color.BLACK);
						labelPrecoCompra.setText("Preço de compra (R$)");
						labelPrecoCompra.setForeground(Color.BLACK);
						labelTipoProduto.setText("Tipo de produto");
						labelTipoProduto.setForeground(Color.BLACK);
						labelGarantia.setText("Garantia");
						labelGarantia.setForeground(Color.BLACK);
					}
					catch(NumberFormatException e2){
						String menssagemConteudo = "Campos numericos aceitam somente numeros(valores inteiros) ou numeros e pontos(valores quebrados)(ponto no lugar de virgula)";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
				}
			}
		});
		salvar.setToolTipText("Salva os dados do cadastro do produto");
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(salvar);
		
		limpar = new JButton("Limpar");
		limpar.setToolTipText("Limpa os campos do cadastro");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemConteudo = "Deseja limpar os campos ?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo avisoLimparCampos = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemConteudo);
				avisoLimparCampos.setVisible(true);
				String avisoLimparCamposTexto = avisoLimparCampos.getResposta();
				if (avisoLimparCamposTexto != null) {
					if (avisoLimparCamposTexto.equals("Sim")) {
						textNome.setText("");
						textMarca.setText("");
						textLote.setText("");
						textCodigoBarras.setText("");
						textDataPrimeiraCompra.setText("");
						textDataFabricacao.setText("");
						textDataValidade.setText("");
						textQuantidade.setText("");
						textPrecoCompra.setText("");
						textPrecoVenda.setText("");
						textTipoProduto.setText("");
						textAplicacao.setText("");
						textModelo.setText("");
						textCor.setText("");
						textVidaUtil.setText("");
						textQuantComponentes.setText("");
						textTipoEmbalagem.setText("");
						textTipoEstampa.setText("");
						textGarantia.setText("");
						textPeso.setText("");
						textAltura.setText("");
						textComprimento.setText("");
						textLargura.setText("");
						textEspessura.setText("");
						textProfundidade.setText("");
						textAreaAcessorios.setText("");
						textAreaDescricao.setText("");
						buttonGroupProduto.clearSelection();
						buttonGroupMontagem.clearSelection();
						buttonGroupEstampa.clearSelection();
						buttonGroupEmbalagem.clearSelection();
						comboBoxPeso.setSelectedItem("Escolha");
						comboBoxAltura.setSelectedItem("Escolha");
						comboBoxComprimento.setSelectedItem("Escolha");
						comboBoxEspessura.setSelectedItem("Escolha");
						comboBoxLargura.setSelectedItem("Escolha");
						comboBoxProfundidade.setSelectedItem("Escolha");
						comboBoxVidaUtil.setSelectedItem("Escolha");
						comboBoxGarantia.setSelectedItem("Escolha");
						textFornecedorNome.setText("");
						textFornecedorCNPJ.setText("");
						comboBoxQuantidade.setSelectedItem("Escolha");
						labelNome.setText("Nome");
						labelNome.setForeground(Color.BLACK);
						labelMarca.setText("Marca");
						labelMarca.setForeground(Color.BLACK);
						labelLote.setText("Lote");
						labelLote.setForeground(Color.BLACK);
						labelFornecedorNome.setText("Nome do fornecedor");
						labelFornecedorNome.setForeground(Color.BLACK);
						labelFornecedorCNPJ.setText("CNPJ do fornecedor");
						labelFornecedorCNPJ.setForeground(Color.BLACK);
						labelCodigoBarras.setText("Codigo de barras");
						labelCodigoBarras.setForeground(Color.BLACK);
						labelDataPrimeiraCompra.setText("Data da primeira compra");
						labelDataPrimeiraCompra.setForeground(Color.BLACK);
						labelDataFabricacao.setText("Data de fabricação");
						labelDataFabricacao.setForeground(Color.BLACK);
						labelDataValidade.setText("Data de validade");
						labelDataValidade.setForeground(Color.BLACK);
						labelPrecoCompra.setText("Preço de compra (R$)");
						labelPrecoCompra.setForeground(Color.BLACK);
						labelTipoProduto.setText("Tipo de produto");
						labelTipoProduto.setForeground(Color.BLACK);
						labelGarantia.setText("Garantia");
						labelGarantia.setForeground(Color.BLACK);
					}
				}
			}
		});
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(limpar);
		
		voltar = new JButton("Voltar");
		voltar.setToolTipText("Volta para o menu");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNome.getText().length() != 0 ||	textMarca.getText().length() != 0 || textLote.getText().length() != 0 || textCodigoBarras.getText().length() != 0 ||
					textDataPrimeiraCompra.getText().replaceAll("\\/", "").trim().length() != 0 || textDataFabricacao.getText().replaceAll("\\/", "").trim().length() != 0 ||
					textDataValidade.getText().replaceAll("\\/", "").trim().length() != 0 || textVidaUtil.getText().length() != 0 ||
					textPrecoCompra.getText().length() != 0 || textPrecoVenda.getText().length() != 0 || buttonGroupProduto.getSelection() != null||
					textGarantia.getText().length() != 0 || textFornecedorNome.getText().length() != 0 || 
					textFornecedorCNPJ.getText().replaceAll("\\.", "").replace("/","").replace("-","").trim().length() != 0 || textTipoProduto.getText().length() != 0 ||
					textQuantComponentes.getText().length() != 0 || textAplicacao.getText().length() != 0 || buttonGroupEmbalagem.getSelection() != null || 
					textTipoEmbalagem.getText().length() != 0 || buttonGroupEstampa.getSelection() != null || textTipoEstampa.getText().length() != 0 ||
					textCor.getText().length() != 0 || textModelo.getText().length() != 0 || buttonGroupMontagem.getSelection() != null || textAreaAcessorios.getText().length() != 0 ||
					textPeso.getText().length() != 0 || comboBoxPeso.getSelectedItem() != "Escolha" || textAltura.getText().length() != 0 ||
					comboBoxAltura.getSelectedItem() != "Escolha" || textComprimento.getText().length() != 0 || comboBoxComprimento.getSelectedItem() != "Escolha" ||
					textLargura.getText().length() != 0 || comboBoxLargura.getSelectedItem() != "Escolha" || textProfundidade.getText().length() != 0 ||
					comboBoxProfundidade.getSelectedItem() != "Escolha" || textEspessura.getText().length() != 0 || comboBoxEspessura.getSelectedItem() != "Escolha" ||
					textAreaDescricao.getText().length() != 0) {
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
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(voltar);
		
		/*Ação do botao sair da janela*/
		addWindowListener(
            new WindowAdapter() 
            {
                public void windowClosing(WindowEvent we) {
                	if (textNome.getText().length() != 0 ||	textMarca.getText().length() != 0 || textLote.getText().length() != 0 || textCodigoBarras.getText().length() != 0 ||
    					textDataPrimeiraCompra.getText().replaceAll("\\/", "").trim().length() != 0 || textDataFabricacao.getText().replaceAll("\\/", "").trim().length() != 0 ||
    					textDataValidade.getText().replaceAll("\\/", "").trim().length() != 0 || textVidaUtil.getText().length() != 0 ||
    					textPrecoCompra.getText().length() != 0 || textPrecoVenda.getText().length() != 0 || buttonGroupProduto.getSelection() != null||
    					textGarantia.getText().length() != 0 || textFornecedorNome.getText().length() != 0 || 
    					textFornecedorCNPJ.getText().replaceAll("\\.", "").replace("/","").replace("-","").trim().length() != 0 || textTipoProduto.getText().length() != 0 ||
    					textQuantComponentes.getText().length() != 0 || textAplicacao.getText().length() != 0 || buttonGroupEmbalagem.getSelection() != null || 
    					textTipoEmbalagem.getText().length() != 0 || buttonGroupEstampa.getSelection() != null || textTipoEstampa.getText().length() != 0 ||
    					textCor.getText().length() != 0 || textModelo.getText().length() != 0 || buttonGroupMontagem.getSelection() != null || textAreaAcessorios.getText().length() != 0 ||
    					textPeso.getText().length() != 0 || comboBoxPeso.getSelectedItem() != "Escolha" || textAltura.getText().length() != 0 ||
    					comboBoxAltura.getSelectedItem() != "Escolha" || textComprimento.getText().length() != 0 || comboBoxComprimento.getSelectedItem() != "Escolha" ||
    					textLargura.getText().length() != 0 || comboBoxLargura.getSelectedItem() != "Escolha" || textProfundidade.getText().length() != 0 ||
    					comboBoxProfundidade.getSelectedItem() != "Escolha" || textEspessura.getText().length() != 0 || comboBoxEspessura.getSelectedItem() != "Escolha" ||
    					textAreaDescricao.getText().length() != 0) {
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
}