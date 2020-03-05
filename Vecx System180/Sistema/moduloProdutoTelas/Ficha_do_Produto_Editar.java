package moduloProdutoTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import aInterfaceSistema.Sessao;
import aInterfaceSistema.ValidaNumeroDouble;
import aInterfaceSistema.ValidaNumeroInteiro;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoBD.Dao_alterar_dados_produto;
import moduloProdutoBD.Dao_consulta_dados_produto;
import moduloProdutoBD.EstoqueProdutos;
import moduloProdutoBD.Produto;

public class Ficha_do_Produto_Editar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaProdutoEditar;
	private JTextField textNome, textMarca, textPrecoCompra, textCodigoBarras, textTipoProduto, textGarantia, textPrecoVenda, textPeso, textLote;
	private JTextField textAplicacao, textQuantComponentes, textModelo, textCor, textTipoEmbalagem, textTipoEstampa, textAltura;
	private JTextField textComprimento, textLargura, textProfundidade, textEspessura, textVidaUtil, textQuantidade;
	private JTextField textFornecedorNome;
	private JFormattedTextField textDataPrimeiraCompra, textDataFabricacao, textDataValidade;
	private JFormattedTextField textFornecedorCNPJ;
	private JComboBox<String> comboBoxVidaUtil, comboBoxGarantia, comboBoxPeso, comboBoxAltura, comboBoxComprimento;
	private JComboBox<String> comboBoxLargura, comboBoxProfundidade, comboBoxEspessura, comboBoxQuantidade;	
	private final ButtonGroup buttonGroupProduto = new ButtonGroup();
	private final ButtonGroup buttonGroupEmbalagem = new ButtonGroup();
	private final ButtonGroup buttonGroupEstampa = new ButtonGroup();
	private final ButtonGroup buttonGroupMontagem = new ButtonGroup();
	private JRadioButton radioNacional, radioImportado, radioEmbalagemSim, radioEmbalagemNao, radioEstampaSim, radioEstampaNao;
	private JRadioButton radioMontagemSim, radioMontagemNao; 
	private JTextArea textAreaAcessorios, textAreaDescricao;
	private JButton fornecedor, salvar, cancelar;
	ImageIcon fotoProduto1;
	String origemProduto, montagemProduto, embalagemProduto, estampaProduto, acessoriosProdutoTexto, descricaoProdutoTexto; 
	String dataPrimeiraCompraProduto, dataFabricacaoProduto, dataValidadeProduto, garantia, garantiaValor, garantiaUnidade;
	String alturaValor, alturaUnidade, larguraValor, larguraUnidade, comprimentoValor, comprimentoUnidade;
	String alturaTexto, alturaUnidadeTexto, larguraTexto, larguraUnidadeTexto, comprimentoTexto, comprimentoUnidadeTexto;
	String pesoValor, pesoUnidade, espessuraValor, espessuraUnidade, profundidadeValor, profundidadeUnidade;
	String pesoTexto, pesoUnidadeTexto, espessuraTexto, espessuraUnidadeTexto, profundidadeTexto, profundidadeUnidadeTexto;
	String vidaUtil, vidaUtilValor, vidaUtilUnidade, tipoProdutoTexto, aplicacaoProdutoTexto, corProdutoTexto, modeloProdutoTexto;
	String tipoEstampaTexto, tipoEmbalagemTexto, quantidadeCompoenentesTexto, quantidadeValor, quantidadeUnidade;
	String vidaUtilTexto, vidaUtilUnidadeTexto, garantiaTexto, garantiaUnidadeTexto;
	SimpleDateFormat dataCompraFormato, dataFabricacaoFormato, dataValidadeFormato;
	Date dataCompra, dataFabricacao, dataValidade;
	Produto alterarCadastroProduto;
	EstoqueProdutos alterarCadastroEstoqueProduto;
	Dao_alterar_dados_produto salvaNovosDados, salvaNovosDadosEstoque;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficha_do_Produto_Editar frame = new Ficha_do_Produto_Editar();
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
	public Ficha_do_Produto_Editar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ficha_do_Produto_Editar.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setSize(1000, 600);
		
		telaFichaProdutoEditar = new JPanel();
		telaFichaProdutoEditar.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaProdutoEditar.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaProdutoEditar);
		
		JPanel panelTitulo = new JPanel();
		telaFichaProdutoEditar.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelTitulo2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Ficha_do_Produto_Editar.class.getResource("/cImagens/Editar.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFichaProdutoTitulo = new JLabel("Ficha do produto");
		panelTitulo2.add(labelFichaProdutoTitulo);
		labelFichaProdutoTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Ficha_do_Produto_Editar.class.getResource("/cImagens/Funcionario.png")));
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
		
		JTabbedPane tabbedPaneFichaProduto = new JTabbedPane(JTabbedPane.TOP);
		telaFichaProdutoEditar.add(tabbedPaneFichaProduto, BorderLayout.CENTER);

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
		
		JPanel panelFichaTecnica = new JPanel();
		tabbedPaneFichaProduto.addTab("Ficha Tecnica", null, panelFichaTecnica, null);
		panelFichaTecnica.setLayout(new GridLayout(0, 1, 0, 5));
		
		JScrollPane scrollPaneFichaProduto = new JScrollPane();
		scrollPaneFichaProduto.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneFichaProduto.getHorizontalScrollBar().setUnitIncrement(10);
		panelFichaTecnica.add(scrollPaneFichaProduto);
		
		JPanel panelFichaProduto = new JPanel();
		panelFichaProduto.setMinimumSize(new Dimension(800, 600));
		scrollPaneFichaProduto.setViewportView(panelFichaProduto);
		panelFichaProduto.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNome_CodPro_DataHora = new JPanel();
		panelFichaProduto.add(panelNome_CodPro_DataHora);
		panelNome_CodPro_DataHora.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNome = new JPanel();
		panelNome_CodPro_DataHora.add(panelNome);
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel labelNome = new JLabel("Nome do produto");
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNome.add(labelNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNome.add(textNome);
		
		JPanel panelCodPro_DataHora = new JPanel();
		panelNome_CodPro_DataHora.add(panelCodPro_DataHora);
		panelCodPro_DataHora.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCodigoProduto = new JPanel();
		panelCodPro_DataHora.add(panelCodigoProduto);
		panelCodigoProduto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoProduto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoProduto = new JLabel("Codigo do produto");
		panelCodigoProduto.add(labelCodigoProduto);
		labelCodigoProduto.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel codigoProduto = new JLabel();
		panelCodigoProduto.add(codigoProduto);
		codigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelDataCadastro = new JPanel();
		panelCodPro_DataHora.add(panelDataCadastro);
		panelDataCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraCadastro = new JLabel("Data e hora de cadastro");
		labelDataHoraCadastro.setPreferredSize(new Dimension(200, 14));
		labelDataHoraCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataCadastro.add(labelDataHoraCadastro);
		
		JLabel dataCadastro = new JLabel();
		dataCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataCadastro.add(dataCadastro);
		
		JPanel panelMarca_CodBarras_Lote = new JPanel();
		panelFichaProduto.add(panelMarca_CodBarras_Lote);
		panelMarca_CodBarras_Lote.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelMarca = new JPanel();
		panelMarca_CodBarras_Lote.add(panelMarca);
		panelMarca.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelMarca.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel LabelMarca = new JLabel("Marca");
		LabelMarca.setHorizontalAlignment(SwingConstants.LEFT);
		LabelMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelMarca.add(LabelMarca);
		
		textMarca = new JTextField("");
		textMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelMarca.add(textMarca);
		
		JPanel panelCodBarras_Lote = new JPanel();
		panelMarca_CodBarras_Lote.add(panelCodBarras_Lote);
		panelCodBarras_Lote.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCodigoBarras = new JPanel();
		panelCodBarras_Lote.add(panelCodigoBarras);
		panelCodigoBarras.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoBarras.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel labelCodigoBarras = new JLabel("Codigo de barras");
		panelCodigoBarras.add(labelCodigoBarras);
		labelCodigoBarras.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCodigoBarras = new JTextField();
		panelCodigoBarras.add(textCodigoBarras);
		textCodigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelLote = new JPanel();
		panelCodBarras_Lote.add(panelLote);
		panelLote.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelLote.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLote = new JLabel("Lote");
		panelLote.add(labelLote);
		labelLote.setHorizontalAlignment(SwingConstants.LEFT);
		labelLote.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textLote = new JTextField("");
		panelLote.add(textLote);
		textLote.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelData_VidaUtil = new JPanel();
		panelFichaProduto.add(panelData_VidaUtil);
		panelData_VidaUtil.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelDataPrimeiraCompra = new JPanel();
		panelData_VidaUtil.add(panelDataPrimeiraCompra);
		panelDataPrimeiraCompra.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataPrimeiraCompra.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataPrimeiraCompra = new JLabel("Data da primeira compra");
		panelDataPrimeiraCompra.add(labelDataPrimeiraCompra);
		labelDataPrimeiraCompra.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataPrimeiraCompra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textDataPrimeiraCompra = new JFormattedTextField(dataCompraMascara);
		panelDataPrimeiraCompra.add(textDataPrimeiraCompra);
		textDataPrimeiraCompra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelDataFabricacao = new JPanel();
		panelData_VidaUtil.add(panelDataFabricacao);
		panelDataFabricacao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataFabricacao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataFabricacao = new JLabel("Data de fabrica\u00E7\u00E3o");
		panelDataFabricacao.add(labelDataFabricacao);
		labelDataFabricacao.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataFabricacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textDataFabricacao = new JFormattedTextField(dataValidadeMascara);
		panelDataFabricacao.add(textDataFabricacao);
		textDataFabricacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelDataValidade = new JPanel();
		panelData_VidaUtil.add(panelDataValidade);
		panelDataValidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataValidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataValidade = new JLabel("Data de validade");
		panelDataValidade.add(labelDataValidade);
		labelDataValidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataValidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textDataValidade = new JFormattedTextField(dataFabricacaoMascara);
		panelDataValidade.add(textDataValidade);
		textDataValidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelVidaUtil = new JPanel();
		panelData_VidaUtil.add(panelVidaUtil);
		panelVidaUtil.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelVidaUtil.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelVidaUtil = new JLabel("Vida Util do produto");
		labelVidaUtil.setHorizontalAlignment(SwingConstants.LEFT);
		labelVidaUtil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelVidaUtil.add(labelVidaUtil);
		
		JPanel panelVidaUtil2 = new JPanel();
		panelVidaUtil.add(panelVidaUtil2);
		panelVidaUtil2.setLayout(new BorderLayout(0, 0));
		
		textVidaUtil = new JTextField();
		panelVidaUtil2.add(textVidaUtil);
		textVidaUtil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textVidaUtil.setDocument(new ValidaNumeroInteiro());
		
		comboBoxVidaUtil = new JComboBox<String>();
		comboBoxVidaUtil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxVidaUtil.setMaximumRowCount(5);
		comboBoxVidaUtil.addItem("Escolha");
		comboBoxVidaUtil.addItem("minuto(s)");
		comboBoxVidaUtil.addItem("hora(s)");
		comboBoxVidaUtil.addItem("dia(s)");
		comboBoxVidaUtil.addItem("semana(s)");
		comboBoxVidaUtil.addItem("mese(s)");
		comboBoxVidaUtil.addItem("ano(s)");
		panelVidaUtil2.add(comboBoxVidaUtil, BorderLayout.EAST);
		
		JPanel panelPreco_OriPro = new JPanel();
		panelFichaProduto.add(panelPreco_OriPro);
		panelPreco_OriPro.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelPrecoCompra = new JPanel();
		panelPreco_OriPro.add(panelPrecoCompra);
		panelPrecoCompra.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoCompra.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoCompra = new JLabel("Pre\u00E7o de compra (R$)");
		panelPrecoCompra.add(labelPrecoCompra);
		labelPrecoCompra.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoCompra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textPrecoCompra = new JTextField();
		panelPrecoCompra.add(textPrecoCompra);
		textPrecoCompra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PlainDocument documentPrecoCompra = (PlainDocument) textPrecoCompra.getDocument();
		documentPrecoCompra.setDocumentFilter(new ValidaNumeroDouble());
		
		JPanel panelPrecoVenda = new JPanel();
		panelPreco_OriPro.add(panelPrecoVenda);
		panelPrecoVenda.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoVenda.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoVenda = new JLabel("Pre\u00E7o de Venda (R$)");
		panelPrecoVenda.add(labelPrecoVenda);
		labelPrecoVenda.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textPrecoVenda = new JTextField();
		panelPrecoVenda.add(textPrecoVenda);
		textPrecoVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PlainDocument documentPrecoVenda = (PlainDocument) textPrecoVenda.getDocument();
		documentPrecoVenda.setDocumentFilter(new ValidaNumeroDouble());
		
		JPanel panelOrigemProduto = new JPanel();
		panelPreco_OriPro.add(panelOrigemProduto);
		panelOrigemProduto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelOrigemProduto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelOrigemProduto = new JLabel("Origem do produto");
		labelOrigemProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelOrigemProduto.add(labelOrigemProduto);
		
		JPanel panelOrigemProduto2 = new JPanel();
		FlowLayout fl_panelOrigemProduto2 = (FlowLayout) panelOrigemProduto2.getLayout();
		fl_panelOrigemProduto2.setAlignment(FlowLayout.LEFT);
		fl_panelOrigemProduto2.setVgap(0);
		fl_panelOrigemProduto2.setHgap(0);
		panelOrigemProduto.add(panelOrigemProduto2);
		
		radioNacional = new JRadioButton("Nacional");
		buttonGroupProduto.add(radioNacional);
		panelOrigemProduto2.add(radioNacional);
		radioNacional.setHorizontalAlignment(SwingConstants.LEFT);
		radioNacional.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		radioImportado = new JRadioButton("Importado");
		buttonGroupProduto.add(radioImportado);
		radioImportado.setHorizontalAlignment(SwingConstants.LEFT);
		radioImportado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelOrigemProduto2.add(radioImportado);
		
		JPanel panelQuant_Garan_For_CNPJ = new JPanel();
		panelFichaProduto.add(panelQuant_Garan_For_CNPJ);
		panelQuant_Garan_For_CNPJ.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelQuantidade = new JPanel();
		panelQuant_Garan_For_CNPJ.add(panelQuantidade);
		panelQuantidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelQuantidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelQuantidade = new JLabel("Quantidade");
		labelQuantidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQuantidade.add(labelQuantidade);
		
		JPanel panelQuantidade2 = new JPanel();
		panelQuantidade.add(panelQuantidade2);
		panelQuantidade2.setLayout(new BorderLayout(0, 0));
		
		textQuantidade = new JTextField();
		panelQuantidade2.add(textQuantidade);
		textQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PlainDocument documentQuantidade = (PlainDocument) textQuantidade.getDocument();
		documentQuantidade.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxQuantidade = new JComboBox<String>();
		comboBoxQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		panelQuant_Garan_For_CNPJ.add(panelGarantia);
		panelGarantia.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelGarantia.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelGarantia = new JLabel("Garantia");
		panelGarantia.add(labelGarantia);
		labelGarantia.setHorizontalAlignment(SwingConstants.LEFT);
		labelGarantia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelGarantia2 = new JPanel();
		panelGarantia.add(panelGarantia2);
		panelGarantia2.setLayout(new BorderLayout(0, 0));
		
		textGarantia = new JTextField();
		panelGarantia2.add(textGarantia);
		textGarantia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textGarantia.setDocument(new ValidaNumeroInteiro());
		
		comboBoxGarantia = new JComboBox<String>();
		comboBoxGarantia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxGarantia.setMaximumRowCount(4);
		comboBoxGarantia.addItem("Escolha");
		comboBoxGarantia.addItem("semana(s)");
		comboBoxGarantia.addItem("mes(es)");
		comboBoxGarantia.addItem("ano(s)");
		panelGarantia2.add(comboBoxGarantia, BorderLayout.EAST);
		
		JPanel panelFornecedorNome = new JPanel();
		panelQuant_Garan_For_CNPJ.add(panelFornecedorNome);
		panelFornecedorNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFornecedorNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFornecedorNome = new JLabel("Fornecedor");
		panelFornecedorNome.add(labelFornecedorNome);
		labelFornecedorNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textFornecedorNome = new JTextField();
		panelFornecedorNome.add(textFornecedorNome);
		panelFornecedorNome.add(textFornecedorNome);
		textFornecedorNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelFornecedorCNPJ = new JPanel();
		panelFornecedorCNPJ.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelQuant_Garan_For_CNPJ.add(panelFornecedorCNPJ);
		panelFornecedorCNPJ.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFornecedorCNPJ = new JLabel("CNPJ do fornecedor");
		labelFornecedorCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFornecedorCNPJ.add(labelFornecedorCNPJ);
		
		textFornecedorCNPJ = new JFormattedTextField(numeroCNPJMascara);
		textFornecedorCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFornecedorCNPJ.add(textFornecedorCNPJ);
		
		JPanel panelTipoPro_Quant_Apli = new JPanel();
		panelFichaProduto.add(panelTipoPro_Quant_Apli);
		panelTipoPro_Quant_Apli.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelTipoProduto = new JPanel();
		panelTipoPro_Quant_Apli.add(panelTipoProduto);
		panelTipoProduto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoProduto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoProduto = new JLabel("Tipo de produto");
		labelTipoProduto.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoProduto.add(labelTipoProduto);
		
		textTipoProduto = new JTextField();
		textTipoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoProduto.add(textTipoProduto);
		
		JPanel panelQuantComponentes = new JPanel();
		panelTipoPro_Quant_Apli.add(panelQuantComponentes);
		panelQuantComponentes.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelQuantComponentes.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelQuantComponentes = new JLabel("Quantidade de componentes");
		labelQuantComponentes.setHorizontalAlignment(SwingConstants.LEFT);
		labelQuantComponentes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQuantComponentes.add(labelQuantComponentes);
		
		textQuantComponentes = new JTextField();
		textQuantComponentes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQuantComponentes.add(textQuantComponentes);
		textQuantComponentes.setDocument(new ValidaNumeroInteiro());
		
		JPanel panelAplicacao = new JPanel();
		panelTipoPro_Quant_Apli.add(panelAplicacao);
		panelAplicacao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelAplicacao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelAplicacao = new JLabel("Aplica\u00E7\u00E3o");
		labelAplicacao.setHorizontalAlignment(SwingConstants.LEFT);
		labelAplicacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAplicacao.add(labelAplicacao);
		
		textAplicacao = new JTextField();
		textAplicacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAplicacao.add(textAplicacao);
		
		JPanel panelEmbalagem_TipoEmbalagem = new JPanel();
		panelFichaProduto.add(panelEmbalagem_TipoEmbalagem);
		panelEmbalagem_TipoEmbalagem.setLayout(new BorderLayout(5, 0));
		
		JPanel panelEmbalagem = new JPanel();
		panelEmbalagem_TipoEmbalagem.add(panelEmbalagem, BorderLayout.WEST);
		panelEmbalagem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmbalagem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmbalagem = new JLabel("O produto tem embalagem(s) ?");
		labelEmbalagem.setPreferredSize(new Dimension(200, 14));
		labelEmbalagem.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmbalagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEmbalagem.add(labelEmbalagem);
		
		JPanel panelEmbalagem2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelEmbalagem2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panelEmbalagem.add(panelEmbalagem2);
		
		radioEmbalagemSim = new JRadioButton("Sim");
		buttonGroupEmbalagem.add(radioEmbalagemSim);
		panelEmbalagem2.add(radioEmbalagemSim);
		radioEmbalagemSim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		radioEmbalagemNao = new JRadioButton("N\u00E3o");
		buttonGroupEmbalagem.add(radioEmbalagemNao);
		radioEmbalagemNao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEmbalagem2.add(radioEmbalagemNao);
		
		JPanel panelTipoEmbalagem = new JPanel();
		panelEmbalagem_TipoEmbalagem.add(panelTipoEmbalagem);
		panelTipoEmbalagem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoEmbalagem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoEmbalagem = new JLabel("Tipo de embalagem");
		labelTipoEmbalagem.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoEmbalagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoEmbalagem.add(labelTipoEmbalagem);
		
		textTipoEmbalagem = new JTextField();
		textTipoEmbalagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoEmbalagem.add(textTipoEmbalagem);
		
		JPanel panelEstampa_TipoEstampa = new JPanel();
		panelFichaProduto.add(panelEstampa_TipoEstampa);
		panelEstampa_TipoEstampa.setLayout(new BorderLayout(5, 0));
		
		JPanel panelEstampa = new JPanel();
		panelEstampa_TipoEstampa.add(panelEstampa, BorderLayout.WEST);
		panelEstampa.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstampa.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstampa = new JLabel("O produto tem estampa(s) ?");
		labelEstampa.setPreferredSize(new Dimension(200, 14));
		labelEstampa.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstampa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstampa.add(labelEstampa);
		
		JPanel panelEstampa2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelEstampa2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		panelEstampa.add(panelEstampa2);
		
		radioEstampaSim = new JRadioButton("Sim");
		buttonGroupEstampa.add(radioEstampaSim);
		radioEstampaSim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstampa2.add(radioEstampaSim);
		
		radioEstampaNao = new JRadioButton("N\u00E3o");
		buttonGroupEstampa.add(radioEstampaNao);
		radioEstampaNao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstampa2.add(radioEstampaNao);
		
		JPanel panelTipoEstampa = new JPanel();
		panelEstampa_TipoEstampa.add(panelTipoEstampa);
		panelTipoEstampa.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoEstampa.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoEstampa = new JLabel("Tipo de estampa");
		labelTipoEstampa.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoEstampa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoEstampa.add(labelTipoEstampa);
		
		textTipoEstampa = new JTextField();
		textTipoEstampa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoEstampa.add(textTipoEstampa);
		
		JPanel panelCor_Modelo_Montagem = new JPanel();
		panelFichaProduto.add(panelCor_Modelo_Montagem);
		panelCor_Modelo_Montagem.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelCor = new JPanel();
		panelCor_Modelo_Montagem.add(panelCor);
		panelCor.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCor.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCor = new JLabel("Cor");
		labelCor.setHorizontalAlignment(SwingConstants.LEFT);
		labelCor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCor.add(labelCor);
		
		textCor = new JTextField();
		textCor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCor.add(textCor);
		
		JPanel panelModelo = new JPanel();
		panelCor_Modelo_Montagem.add(panelModelo);
		panelModelo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelModelo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelModelo = new JLabel("Modelo");
		labelModelo.setHorizontalAlignment(SwingConstants.LEFT);
		labelModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelModelo.add(labelModelo);
		
		textModelo = new JTextField();
		textModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelModelo.add(textModelo);
		
		JPanel panelMontagem = new JPanel();
		panelCor_Modelo_Montagem.add(panelMontagem);
		panelMontagem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelMontagem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelMontagem = new JLabel("Necessita de montagem ?");
		labelMontagem.setHorizontalAlignment(SwingConstants.LEFT);
		labelMontagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelMontagem.add(labelMontagem);
		
		JPanel panelMontagem2 = new JPanel();
		FlowLayout fl_panelMontagem2 = (FlowLayout) panelMontagem2.getLayout();
		fl_panelMontagem2.setAlignment(FlowLayout.LEFT);
		fl_panelMontagem2.setVgap(0);
		fl_panelMontagem2.setHgap(0);
		panelMontagem.add(panelMontagem2);
		
		radioMontagemSim = new JRadioButton("Sim");
		buttonGroupMontagem.add(radioMontagemSim);
		radioMontagemSim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelMontagem2.add(radioMontagemSim);
		
		radioMontagemNao = new JRadioButton("N\u00E3o");
		buttonGroupMontagem.add(radioMontagemNao);
		radioMontagemNao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelMontagem2.add(radioMontagemNao);
		
		JPanel panelPeso_Altura_Comprimento = new JPanel();
		panelFichaProduto.add(panelPeso_Altura_Comprimento);
		panelPeso_Altura_Comprimento.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelPeso = new JPanel();
		panelPeso_Altura_Comprimento.add(panelPeso);
		panelPeso.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPeso.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPeso = new JLabel("Peso");
		panelPeso.add(labelPeso);
		labelPeso.setHorizontalAlignment(SwingConstants.LEFT);
		labelPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelPeso2 = new JPanel();
		panelPeso.add(panelPeso2);
		panelPeso2.setLayout(new BorderLayout(0, 0));
		
		textPeso = new JTextField();
		panelPeso2.add(textPeso, BorderLayout.CENTER);
		textPeso.setColumns(10);
		PlainDocument documentPeso = (PlainDocument) textPeso.getDocument();
		documentPeso.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxPeso = new JComboBox<String>();
		comboBoxPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		labelAltura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAltura.add(labelAltura);
		
		JPanel panelAltura2 = new JPanel();
		panelAltura.add(panelAltura2);
		panelAltura2.setLayout(new BorderLayout(0, 0));
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		panelAltura2.add(textAltura, BorderLayout.CENTER);
		PlainDocument documentAltura = (PlainDocument) textAltura.getDocument();
		documentAltura.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxAltura = new JComboBox<String>();
		comboBoxAltura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAltura2.add(comboBoxAltura, BorderLayout.EAST);
		comboBoxAltura.setMaximumRowCount(5);
		comboBoxAltura.addItem("Escolha");
		comboBoxAltura.addItem("polegada(s)");
		comboBoxAltura.addItem("mm");
		comboBoxAltura.addItem("cm");
		comboBoxAltura.addItem("m");
		comboBoxAltura.addItem("km");
		panelAltura2.add(comboBoxAltura, BorderLayout.EAST);
		
		JPanel panelComprimento = new JPanel();
		panelPeso_Altura_Comprimento.add(panelComprimento);
		panelComprimento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComprimento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComprimento = new JLabel("Comprimento");
		labelComprimento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComprimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelComprimento.add(labelComprimento);
		
		JPanel panelComprimento2 = new JPanel();
		panelComprimento.add(panelComprimento2);
		panelComprimento2.setLayout(new BorderLayout(0, 0));
		
		textComprimento = new JTextField();
		textComprimento.setColumns(10);
		panelComprimento2.add(textComprimento, BorderLayout.CENTER);
		PlainDocument documentComprimento = (PlainDocument) textComprimento.getDocument();
		documentComprimento.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxComprimento = new JComboBox<String>();
		comboBoxComprimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxComprimento.setMaximumRowCount(5);
		comboBoxComprimento.addItem("Escolha");
		comboBoxComprimento.addItem("polegada(s)");
		comboBoxComprimento.addItem("mm");
		comboBoxComprimento.addItem("cm");
		comboBoxComprimento.addItem("m");
		comboBoxComprimento.addItem("km");
		panelComprimento2.add(comboBoxComprimento, BorderLayout.EAST);
		
		JPanel panelLargura_Espessura_Profundidade = new JPanel();
		panelFichaProduto.add(panelLargura_Espessura_Profundidade);
		panelLargura_Espessura_Profundidade.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelLargura = new JPanel();
		panelLargura_Espessura_Profundidade.add(panelLargura);
		panelLargura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelLargura.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLargura = new JLabel("Largura");
		labelLargura.setHorizontalAlignment(SwingConstants.LEFT);
		labelLargura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelLargura.add(labelLargura);
		
		JPanel panelLargura2 = new JPanel();
		panelLargura.add(panelLargura2);
		panelLargura2.setLayout(new BorderLayout(0, 0));
		
		textLargura = new JTextField();
		textLargura.setColumns(10);
		panelLargura2.add(textLargura, BorderLayout.CENTER);
		PlainDocument documentLargura = (PlainDocument) textLargura.getDocument();
		documentLargura.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxLargura = new JComboBox<String>();
		comboBoxLargura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxLargura.setMaximumRowCount(5);
		comboBoxLargura.addItem("Escolha");
		comboBoxLargura.addItem("polegada(s)");
		comboBoxLargura.addItem("mm");
		comboBoxLargura.addItem("cm");
		comboBoxLargura.addItem("m");
		comboBoxLargura.addItem("km");
		panelLargura2.add(comboBoxLargura, BorderLayout.EAST);
		
		JPanel panelProfundidade = new JPanel();
		panelLargura_Espessura_Profundidade.add(panelProfundidade);
		panelProfundidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelProfundidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelProfundidade = new JLabel("Profundidade");
		labelProfundidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelProfundidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelProfundidade.add(labelProfundidade);
		
		JPanel panelProfundidade2 = new JPanel();
		panelProfundidade.add(panelProfundidade2);
		panelProfundidade2.setLayout(new BorderLayout(0, 0));
		
		textProfundidade = new JTextField();
		textProfundidade.setColumns(10);
		panelProfundidade2.add(textProfundidade, BorderLayout.CENTER);
		PlainDocument documentProfundidade = (PlainDocument) textProfundidade.getDocument();
		documentProfundidade.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxProfundidade = new JComboBox<String>();
		comboBoxProfundidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxProfundidade.setMaximumRowCount(5);
		comboBoxProfundidade.addItem("Escolha");
		comboBoxProfundidade.addItem("polegada(s)");
		comboBoxProfundidade.addItem("mm");
		comboBoxProfundidade.addItem("cm");
		comboBoxProfundidade.addItem("m");
		panelProfundidade2.add(comboBoxProfundidade, BorderLayout.EAST);
		
		JPanel panelEspessura = new JPanel();
		panelLargura_Espessura_Profundidade.add(panelEspessura);
		panelEspessura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEspessura.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEspessura = new JLabel("Espessura");
		labelEspessura.setHorizontalAlignment(SwingConstants.LEFT);
		labelEspessura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEspessura.add(labelEspessura);
		
		JPanel panelEspessura2 = new JPanel();
		panelEspessura.add(panelEspessura2);
		panelEspessura2.setLayout(new BorderLayout(0, 0));
		
		textEspessura = new JTextField();
		textEspessura.setColumns(10);
		panelEspessura2.add(textEspessura, BorderLayout.CENTER);
		PlainDocument documentEspessura = (PlainDocument) textEspessura.getDocument();
		documentEspessura.setDocumentFilter(new ValidaNumeroDouble());
		
		comboBoxEspessura = new JComboBox<String>();
		comboBoxEspessura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxEspessura.setMaximumRowCount(5);
		comboBoxEspessura.addItem("Escolha");
		comboBoxEspessura.addItem("polegada(s)");
		comboBoxEspessura.addItem("mm");
		comboBoxEspessura.addItem("cm");
		comboBoxEspessura.addItem("m");
		panelEspessura2.add(comboBoxEspessura, BorderLayout.EAST);
		
		JPanel panelFuncionario = new JPanel();
		panelFichaProduto.add(panelFuncionario);
		panelFuncionario.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelFuncionarioCadadastro = new JPanel();
		panelFuncionario.add(panelFuncionarioCadadastro);
		panelFuncionarioCadadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFuncionarioCadadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFuncionarioCadadastro = new JLabel("Funcionario que cadastrou");
		labelFuncionarioCadadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelFuncionarioCadadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFuncionarioCadadastro.add(labelFuncionarioCadadastro);
		
		JLabel funcionarioCadadastro = new JLabel();
		funcionarioCadadastro.setHorizontalAlignment(SwingConstants.LEFT);
		funcionarioCadadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFuncionarioCadadastro.add(funcionarioCadadastro);
		
		JPanel panelCargo_Codigo = new JPanel();
		panelFuncionario.add(panelCargo_Codigo);
		panelCargo_Codigo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargoFuncionario = new JPanel();
		panelCargo_Codigo.add(panelCargoFuncionario);
		panelCargoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargoFuncionario = new JLabel("Cargo do funcionario");
		labelCargoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargoFuncionario.add(labelCargoFuncionario);
		
		JLabel cargoFuncionario = new JLabel();
		cargoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		cargoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargoFuncionario.add(cargoFuncionario);
		
		JPanel panelCodigoFuncionario = new JPanel();
		panelCargo_Codigo.add(panelCodigoFuncionario);
		panelCodigoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoFuncionario = new JLabel("Codigo do funcionario");
		labelCodigoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFuncionario.add(labelCodigoFuncionario);
		
		JLabel codigoFuncionario = new JLabel();
		codigoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		codigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFuncionario.add(codigoFuncionario);
		
		JPanel panelAcessorios = new JPanel();
		tabbedPaneFichaProduto.addTab("Acessorios", null, panelAcessorios, null);
		panelAcessorios.setLayout(new BorderLayout(0, 5));
		
		JLabel labelAcessorios = new JLabel("Acessorios");
		panelAcessorios.add(labelAcessorios, BorderLayout.NORTH);
		labelAcessorios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panelAcessorios2 = new JPanel();
		panelAcessorios.add(panelAcessorios2, BorderLayout.CENTER);
		panelAcessorios2.setLayout(new BoxLayout(panelAcessorios2, BoxLayout.X_AXIS));
		
		JScrollPane scrollPaneAcessorios = new JScrollPane();
		scrollPaneAcessorios.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneAcessorios.getHorizontalScrollBar().setUnitIncrement(10);
		panelAcessorios2.add(scrollPaneAcessorios);
		
		textAreaAcessorios = new JTextArea();
		scrollPaneAcessorios.setViewportView(textAreaAcessorios);
		textAreaAcessorios.setLineWrap(true);
		textAreaAcessorios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAreaAcessorios.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel panelDescricao = new JPanel();
		tabbedPaneFichaProduto.addTab("Descri\u00E7\u00E3o", null, panelDescricao, null);
		panelDescricao.setLayout(new BorderLayout(0, 5));
		
		JLabel labelDescricao = new JLabel("Descri\u00E7\u00E3o");
		panelDescricao.add(labelDescricao, BorderLayout.NORTH);
		labelDescricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panelDescricao2 = new JPanel();
		panelDescricao.add(panelDescricao2, BorderLayout.CENTER);
		panelDescricao2.setLayout(new BoxLayout(panelDescricao2, BoxLayout.X_AXIS));
		
		JScrollPane scrollPaneDescricao = new JScrollPane();
		panelDescricao2.add(scrollPaneDescricao);
		
		textAreaDescricao = new JTextArea();
		textAreaDescricao.setLineWrap(true);
		scrollPaneDescricao.setViewportView(textAreaDescricao);
		scrollPaneDescricao.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneDescricao.getHorizontalScrollBar().setUnitIncrement(10);
		textAreaDescricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAreaDescricao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		/*Parte que consulta os dados no banco de dados*/
		String codigoProdutoConsulta = sessao.getCodigoProduto();
		String nomeProdutoConsulta = sessao.getNomeProduto();
		Dao_consulta_dados_produto teste = new Dao_consulta_dados_produto();
		List<Produto> Consulta = teste.Consulta_Dados_Produto_Ficha(codigoProdutoConsulta, nomeProdutoConsulta);
    	for (Produto leitura : Consulta) {
    		/*Nome do produto*/
    		String nomeProdutoTexto = leitura.getNome();
    		textNome.setText(nomeProdutoTexto);
    		
    		/*Codigo do produto*/
    		String codigoProdutoTexto = leitura.getCodigoProduto();
    		codigoProduto.setText(codigoProdutoTexto);
    		
    		/*Data e hora de cadastro*/
    		Date dataCadastroProduto =	leitura.getDataCadastro();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroProduto);
    		Time horaCadastroProduto = leitura.getHoraCadastro();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroProduto);
    		String dataHoraCadastro = dataCadastroValor + " " + horaCadastroValor;
    		dataCadastro.setText(dataHoraCadastro);
    		
    		/*Marca do produto*/
    		String marcaProdutoTexto = leitura.getMarca();
    		textMarca.setText(marcaProdutoTexto);
    		
    		/*Codigo de barras do produto*/
    		String codigoBarrasTexto = leitura.getCodigoBarras();
    		textCodigoBarras.setText(codigoBarrasTexto);
    		
    		/*Lote do produto*/
    		String loteProdutoTexto = leitura.getLote();
    		textLote.setText(loteProdutoTexto);
    		
    		/*Cadastro da data da primeira compra do produto*/
    		Date dataCompraProduto = leitura.getDataPrimeiraCompra();
    		if (dataCompraProduto == null) {
    			String dataCompraProdutoTexto = "";
    			textDataPrimeiraCompra.setText(dataCompraProdutoTexto);
			}
    		else {
    			SimpleDateFormat dataCompraFormato = new SimpleDateFormat("dd/MM/yyyy");
        		String dataCompraValor = dataCompraFormato.format(dataCompraProduto);
        		textDataPrimeiraCompra.setText(dataCompraValor);
			}
    		
    		/*Cadastro da data de fabricação do produto*/
    		Date dataFabricacaoProduto = leitura.getDataFabricacao();
    		if (dataFabricacaoProduto == null) {
    			String dataFabricacaoProdutoTexto = "";
    			textDataFabricacao.setText(dataFabricacaoProdutoTexto);
			}
    		else {
    			SimpleDateFormat dataFabricacaoFormato = new SimpleDateFormat("dd/MM/yyyy");
        		String dataFabricacaoValor = dataFabricacaoFormato.format(dataFabricacaoProduto);
        		textDataFabricacao.setText(dataFabricacaoValor);
			}
    		
    		/*Cadastro da data de validade do produto*/
    		Date dataValidadeProduto = leitura.getDataValidade();
    		if (dataValidadeProduto == null) {
    			String dataValidadeProdutoTexto = "";
    			textDataValidade.setText(dataValidadeProdutoTexto);
			}
    		else {
    			SimpleDateFormat dataValidadeFormato = new SimpleDateFormat("dd/MM/yyyy");
        		String dataValidadeValor = dataValidadeFormato.format(dataValidadeProduto);
        		textDataValidade.setText(dataValidadeValor);
			}
    		
    		/*Vida util do produto*/
    		String vidaUtilValor = leitura.getVidaUtil();
    		String vidaUtilUnidade = leitura.getVidaUtilUnidade();
    		textVidaUtil.setText(vidaUtilValor);
    		comboBoxVidaUtil.setSelectedItem(vidaUtilUnidade);
    		
    		/*Quantidade do produto*/
    		double quantidadeValor = leitura.getQuantidade();
    		String quantidadeProduto = "" + quantidadeValor;
    		String quantidadeUnidade = leitura.getQuantidadeUnidade();
    		textQuantidade.setText(quantidadeProduto);
    		comboBoxQuantidade.setSelectedItem(quantidadeUnidade);
    		
    		/*Preço de compra do produto*/
    		double precoCompraValor = leitura.getPrecoCompra();
    		String precoCompraProduto = "" + precoCompraValor;
    		textPrecoCompra.setText(precoCompraProduto);
    		
    		/*Preço de venda produto*/
    		double precoaVistaValor = leitura.getPrecoaVista();
    		String precoaVistaProduto = "" + precoaVistaValor;
    		textPrecoVenda.setText(precoaVistaProduto);
    		
    		/*Origem do produto*/
    		String origemProduto = leitura.getOrigemProduto();
    		if (origemProduto.equals("Nacional")) {
				radioNacional.setSelected(true);
			}
    		if (origemProduto.equals("Importado")) {
    			radioImportado.setSelected(true);
			}
    		
    		/*Garantia do produto*/
    		String garantiaValor = leitura.getGarantia();
    		textGarantia.setText(garantiaValor);
    		
    		String garantiaUnidade = leitura.getGarantiaUnidade();
    		comboBoxGarantia.setSelectedItem(garantiaUnidade);
    		
    		/*Nome do fornecedor do produto*/
    		String fornecedorProduto = leitura.getFornecedor();
    		textFornecedorNome.setText(fornecedorProduto);
    		
    		/*CNPJ do fornecedor do produto*/
    		String fornecedorCNPJ = leitura.getFornecedorCNPJ();
    		textFornecedorCNPJ.setText(fornecedorCNPJ);
    		
    		/*Tipo de produto*/
    		String tipoProdutoTexto = leitura.getTipoProduto();
    		textTipoProduto.setText(tipoProdutoTexto);
    		
    		/*Quantidade de componentes que vem com o produto*/
    		int quantCompValor = leitura.getQuantidadeComponentes();
    		String quantCompProduto = "" + quantCompValor;
    		textQuantComponentes.setText(quantCompProduto);
    		
    		/*Aplicacao do produto*/
    		String aplicacaoProdutoTexto = leitura.getAplicacao();
    		textAplicacao.setText(aplicacaoProdutoTexto);
    		
    		/*Se o produto vem com embalagem*/
    		String embalagemProduto = leitura.getEmbalagem();
    		if (embalagemProduto.equals("Sim")) {
				radioEmbalagemSim.setSelected(true);
			}
    		if (embalagemProduto.equals("Não")) {
    			radioEmbalagemNao.setSelected(true);
			}
    		
    		/*Tipo de embalagem que vem com o produto*/
    		String tipoEmbalagemTexto = leitura.getTipoEmbalagem();
    		textTipoEmbalagem.setText(tipoEmbalagemTexto);
    		
    		/*Se o produto vem com estampa*/
    		String estampaProduto = leitura.getEstampa();
    		if (estampaProduto.equals("Sim")) {
				radioEstampaSim.setSelected(true);
			}
    		if (estampaProduto.equals("Não")) {
    			radioEstampaNao.setSelected(true);
			}
    		
    		/*Tipo de estampa que vem no produto*/
    		String tipoEstampaTexto = leitura.getTipoEstampa();
    		textTipoEstampa.setText(tipoEstampaTexto);
    		
    		/*Cor do produto*/
    		String corProdutoTexto = leitura.getCor();
    		textCor.setText(corProdutoTexto);
    		
    		/*Modelo do produto*/
    		String modeloProdutoTexto = leitura.getModelo();
    		textModelo.setText(modeloProdutoTexto);
    		
    		/*Se o produto precisa de montagem*/
    		String montagemProduto = leitura.getMontagem();
    		if (montagemProduto.equals("Sim")) {
				radioMontagemSim.setSelected(true);
			}
    		if (montagemProduto.equals("Não")) {
    			radioMontagemNao.setSelected(true);
			}
    		
    		/*Peso do produto*/
    		String pesoValor = leitura.getPeso();
    		textPeso.setText(pesoValor);
    		String pesoUnidade = leitura.getPesoUnidade();
    		comboBoxPeso.setSelectedItem(pesoUnidade);
    		
    		/*Altura do produto*/
    		String alturaValor = leitura.getAltura();
    		textAltura.setText(alturaValor);
    		String alturaUnidade = leitura.getAlturaUnidade();
    		comboBoxAltura.setSelectedItem(alturaUnidade);
    		
    		/*Comprimento do produto*/
    		String comprimentoValor = leitura.getComprimento();
    		textComprimento.setText(comprimentoValor);
    		String comprimentoUnidade = leitura.getComprimentoUnidade();
    		comboBoxComprimento.setSelectedItem(comprimentoUnidade);
    		
    		/*Largura do produto*/
    		String larguraValor = leitura.getLargura();
    		textLargura.setText(larguraValor);
    		String larguraUnidade = leitura.getLarguraUnidade();
    		comboBoxLargura.setSelectedItem(larguraUnidade);
    		
    		/*Profundidade do produto*/
    		String profundidadeValor = leitura.getProfundidade();
    		textProfundidade.setText(profundidadeValor);
    		String profundidadeUnidade = leitura.getProfundidadeUnidade();
    		comboBoxProfundidade.setSelectedItem(profundidadeUnidade);
    		
    		/*Espessura do produto*/
    		String espessuraValor = leitura.getEspessura();
    		textEspessura.setText(espessuraValor);
    		String espessuraUnidade = leitura.getEspessuraUnidade();
    		comboBoxEspessura.setSelectedItem(espessuraUnidade);
    		
    		/*Funcionario que cadastrou o produto*/
    		String funcionarioProdutoTexto = leitura.getFuncionarioCadastro();
    		funcionarioCadadastro.setText(funcionarioProdutoTexto);
    		
    		/*Codigo do Funcionario que cadastrou o produto*/
    		String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
    		codigoFuncionario.setText(codigoFuncionarioTexto);
    		
    		/*Cargo do funcionario que cadastrou o produto*/
    		String cargoFuncionarioTexto = leitura.getCargoFuncionario();
    		cargoFuncionario.setText(cargoFuncionarioTexto);
    		
    		/*Acessorios que vem junto do produto*/
    		String acessoriosProdutoTexto = leitura.getAcessorios();
    		textAreaAcessorios.setText(acessoriosProdutoTexto);
    		
    		/*Descricao do produto*/
    		String descricaoProdutoTexto = leitura.getDescricao();
    		textAreaDescricao.setText(descricaoProdutoTexto);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaProdutoEditar.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		salvar = new JButton("Salvar");
		salvar.setToolTipText("Salva os dados editados");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
							alterarCadastroProduto = new Produto();
							alterarCadastroEstoqueProduto = new EstoqueProdutos();
							
							alterarCadastroProduto.setNome(textNome.getText());
							alterarCadastroEstoqueProduto.setNome(textNome.getText());
							
							alterarCadastroProduto.setMarca(textMarca.getText());
							alterarCadastroProduto.setModelo(textModelo.getText());
							alterarCadastroProduto.setCodigoBarras(textCodigoBarras.getText());
							alterarCadastroProduto.setPrecoCompra(Double.parseDouble(textPrecoCompra.getText()));
							
							alterarCadastroProduto.setPrecoaVista(Double.parseDouble(textPrecoVenda.getText()));
							alterarCadastroEstoqueProduto.setPrecoaVista(Double.parseDouble(textPrecoVenda.getText()));
							
							alterarCadastroProduto.setLote(textLote.getText());
							alterarCadastroEstoqueProduto.setLote(textLote.getText());
							
							alterarCadastroProduto.setCor(textCor.getText());
							alterarCadastroProduto.setAplicacao(textAplicacao.getText());
							alterarCadastroProduto.setQuantidadeComponentes(Integer.parseInt(textQuantComponentes.getText()));
							
							alterarCadastroProduto.setFornecedor(textFornecedorNome.getText());
							alterarCadastroProduto.setFornecedorCNPJ(textFornecedorCNPJ.getText());
							
							/*Cadastro do tipo do produto*/
							if (textTipoProduto.getText().isEmpty() || textTipoProduto.getText().length() <= 0) {
								tipoProdutoTexto = "Produto sem informações";
								alterarCadastroProduto.setTipoProduto(tipoProdutoTexto);
							} else {
								alterarCadastroProduto.setTipoProduto(textTipoProduto.getText());
							}
							
							/*Cadastro da aplicação do produto*/
							if (textAplicacao.getText().isEmpty() || textAplicacao.getText().length() <= 0) {
								aplicacaoProdutoTexto = "Produto sem informações";
								alterarCadastroProduto.setAplicacao(aplicacaoProdutoTexto);
							} else {
								alterarCadastroProduto.setAplicacao(textAplicacao.getText());
							}
							
							/*Cadastro da cor do produto*/
							if (textCor.getText().isEmpty() || textCor.getText().length() <= 0) {
								corProdutoTexto = "Produto sem informações";
								alterarCadastroProduto.setCor(corProdutoTexto);
							} else {
								alterarCadastroProduto.setCor(textTipoProduto.getText());
							}
							
							/*Cadastro do modelo do produto*/
							if (textModelo.getText().isEmpty() || textModelo.getText().length() <= 0) {
								modeloProdutoTexto = "Produto sem informações";
								alterarCadastroProduto.setModelo(modeloProdutoTexto);
							} else {
								alterarCadastroProduto.setModelo(textTipoProduto.getText());
							}
							
							/*Cadastro da quantidade de componentes*/
							if (textQuantComponentes.getText().isEmpty() || textQuantComponentes.getText().length() <= 0) {
								quantidadeCompoenentesTexto = "1";
								alterarCadastroProduto.setQuantidadeComponentes(Integer.parseInt(quantidadeCompoenentesTexto));
							} else {
								alterarCadastroProduto.setQuantidadeComponentes(Integer.parseInt(textQuantComponentes.getText()));
							}
							
							/*Cadastro do tipo de embalagem do produto*/
							if (textTipoEmbalagem.getText().isEmpty() || textTipoEmbalagem.getText().length() <= 0) {
								tipoEmbalagemTexto = "Produto sem informações";
								alterarCadastroProduto.setTipoEmbalagem(tipoEmbalagemTexto);
							} else {
								alterarCadastroProduto.setTipoEmbalagem(textTipoEmbalagem.getText());
							}
							
							/*Cadastro do tipo de estampa do produto*/
							if (textTipoEstampa.getText().isEmpty() || textTipoEstampa.getText().length() <= 0) {
								tipoEstampaTexto = "Produto sem informações";
								alterarCadastroProduto.setTipoEstampa(tipoEstampaTexto);
							} else {
								alterarCadastroProduto.setTipoEstampa(textTipoEstampa.getText());
							}
							
							/*Cadastro dos acessorios do produto*/
							if (textAreaAcessorios.getText().isEmpty() || textAreaAcessorios.getText().length() <= 0) {
								descricaoProdutoTexto = "Produto sem descrição";
								alterarCadastroProduto.setAcessorios(descricaoProdutoTexto);
							} else {
								alterarCadastroProduto.setAcessorios(textAreaDescricao.getText());
							}
							
							/*Cadastro da descrição do produto*/
							if (textAreaDescricao.getText().isEmpty() || textAreaDescricao.getText().length() <= 0) {
								acessoriosProdutoTexto = "Produto sem acessorio";
								alterarCadastroProduto.setDescricao(acessoriosProdutoTexto);
							} else {
								alterarCadastroProduto.setDescricao(textAreaDescricao.getText());
							}
							
							/*Cadastro da quantidade do produto*/
							quantidadeValor = textQuantidade.getText();
							quantidadeUnidade = (String) comboBoxQuantidade.getSelectedItem();
							alterarCadastroProduto.setQuantidade(Double.parseDouble(quantidadeValor));
							alterarCadastroProduto.setQuantidadeUnidade(quantidadeUnidade);
							alterarCadastroEstoqueProduto.setQuantidade(Double.parseDouble(quantidadeValor));
							alterarCadastroEstoqueProduto.setQuantidadeUnidade(quantidadeUnidade);
														
							/*Cadastro da vida util do produto*/
							if (textVidaUtil.getText().isEmpty() || textVidaUtil.getText().length() <= 0 || comboBoxVidaUtil.getSelectedItem() == "Escolha") {
								vidaUtilTexto =  "0";
								vidaUtilUnidadeTexto = "Não determinada";
								alterarCadastroProduto.setVidaUtil(vidaUtilTexto);
								alterarCadastroProduto.setVidaUtilUnidade(vidaUtilUnidadeTexto);
							}
							else{
								vidaUtilValor = textVidaUtil.getText();
								vidaUtilUnidade = (String) comboBoxVidaUtil.getSelectedItem();
								alterarCadastroProduto.setVidaUtil(vidaUtilValor);
								alterarCadastroProduto.setVidaUtilUnidade(vidaUtilUnidade);
							}
							
							/*Cadastro da garantia*/
							if (textGarantia.getText().isEmpty() || textGarantia.getText().length() <= 0 || comboBoxGarantia.getSelectedItem() == "Escolha") {
								garantiaTexto =  "0";
								garantiaUnidadeTexto = "Não determinada";
								alterarCadastroProduto.setGarantia(garantiaTexto);
								alterarCadastroProduto.setGarantiaUnidade(garantiaUnidadeTexto);
							} 
							else {
								garantiaValor = textGarantia.getText();
								garantiaUnidade = (String) comboBoxGarantia.getSelectedItem();
								alterarCadastroProduto.setGarantia(garantiaValor);
								alterarCadastroProduto.setGarantiaUnidade(garantiaUnidade);
							}
							
							/*Cadastro da altura*/
							if (textAltura.getText().isEmpty() || textAltura.getText().length() <= 0 || comboBoxAltura.getSelectedItem() == "Escolha") {
								alturaTexto = "0";
								alturaUnidadeTexto = "Não determinado";
								alterarCadastroProduto.setAltura(alturaTexto);
								alterarCadastroProduto.setAlturaUnidade(alturaUnidadeTexto);
							} 
							else {
								alturaValor = textAltura.getText();
								alturaUnidade = (String) comboBoxAltura.getSelectedItem();
								alterarCadastroProduto.setAltura(alturaValor);
								alterarCadastroProduto.setAlturaUnidade(alturaUnidade);
							}
							
							/*Cadastro do peso*/
							if (textPeso.getText().isEmpty() || textPeso.getText().length() <= 0 || comboBoxPeso.getSelectedItem() == "Escolha") {
								pesoTexto = "0";
								pesoUnidadeTexto = "Não determinado";
								alterarCadastroProduto.setPeso(pesoTexto);
								alterarCadastroProduto.setPesoUnidade(pesoUnidadeTexto);
							} 
							else {
								pesoValor = textPeso.getText();
								pesoUnidade = (String) comboBoxPeso.getSelectedItem();
								alterarCadastroProduto.setPeso(pesoValor);
								alterarCadastroProduto.setPesoUnidade(pesoUnidade);
							}
							
							/*Cadastro do comprimento*/
							if (textComprimento.getText().isEmpty() || textComprimento.getText().length() <= 0 || comboBoxComprimento.getSelectedItem() == "Escolha") {
								comprimentoTexto = "0";
								comprimentoUnidadeTexto = "Não determinado";
								alterarCadastroProduto.setComprimento(comprimentoTexto);
								alterarCadastroProduto.setComprimentoUnidade(comprimentoUnidadeTexto);
							} 
							else {
								comprimentoValor = textComprimento.getText();
								comprimentoUnidade = (String) comboBoxComprimento.getSelectedItem();
								alterarCadastroProduto.setComprimento(comprimentoValor);
								alterarCadastroProduto.setComprimentoUnidade(comprimentoUnidade);
							}
							
							/*Cadastro da largura*/
							if (textLargura.getText().isEmpty() || textLargura.getText().length() <= 0 || comboBoxLargura.getSelectedItem() == "Escolha") {
								larguraTexto = "0";
								larguraUnidadeTexto = "Não determinado";
								alterarCadastroProduto.setLargura(larguraTexto);
								alterarCadastroProduto.setLarguraUnidade(larguraUnidadeTexto);
							} 
							else {
								larguraValor = textLargura.getText();
								larguraUnidade = (String) comboBoxLargura.getSelectedItem();
								alterarCadastroProduto.setLargura(larguraValor);
								alterarCadastroProduto.setLarguraUnidade(larguraUnidade);
							}
							
							/*Cadastro da espessura*/
							if (textEspessura.getText().isEmpty() || textEspessura.getText().length() <= 0 || comboBoxEspessura.getSelectedItem() == "Escolha") {
								espessuraTexto = "0";
								espessuraUnidadeTexto = "Não determinado";
								alterarCadastroProduto.setEspessura(espessuraTexto);
								alterarCadastroProduto.setEspessuraUnidade(espessuraUnidadeTexto);
							} 
							else {
								espessuraValor = textEspessura.getText();
								espessuraUnidade = (String) comboBoxPeso.getSelectedItem();
								alterarCadastroProduto.setEspessura(espessuraValor);
								alterarCadastroProduto.setEspessuraUnidade(espessuraUnidade);
							}
							
							/*Cadastro da profundidade*/
							if (textProfundidade.getText().isEmpty() || textProfundidade.getText().length() <= 0 || comboBoxProfundidade.getSelectedItem() == "Escolha") {
								profundidadeTexto = "0";
								profundidadeUnidadeTexto = "Não determinado";
								alterarCadastroProduto.setProfundidade(profundidadeTexto);
								alterarCadastroProduto.setProfundidadeUnidade(profundidadeUnidadeTexto);
							} 
							else {
								profundidadeValor = textProfundidade.getText();
								profundidadeUnidade = (String) comboBoxProfundidade.getSelectedItem();
								alterarCadastroProduto.setProfundidade(profundidadeValor);
								alterarCadastroProduto.setProfundidadeUnidade(profundidadeUnidade);
							}
							
							/*Cadastro da data da primeira compra do produto*/
							if (textDataPrimeiraCompra.getText().replaceAll("\\/", "").trim().isEmpty()) {
								Date dataPrimeiraCompraValor = null;
								alterarCadastroProduto.setDataPrimeiraCompra(dataPrimeiraCompraValor);
							}
							else {
								dataPrimeiraCompraProduto = textDataPrimeiraCompra.getText();
								try {
									dataCompraFormato = new SimpleDateFormat("dd/MM/yyyy");
									dataCompra = new java.sql.Date(dataCompraFormato.parse(dataPrimeiraCompraProduto).getTime());
									alterarCadastroProduto.setDataPrimeiraCompra(dataCompra);
								} catch (ParseException e1) {
									e1.printStackTrace();
								}
							}
							
							/*Cadastro da data de fabricação do produto*/
							if (textDataFabricacao.getText().replaceAll("\\/", "").trim().isEmpty()) {
								Date dataFabricacaoValor = null;
								alterarCadastroProduto.setDataFabricacao(dataFabricacaoValor);
							}
							else {
								dataFabricacaoProduto = textDataFabricacao.getText();
								try {
									dataFabricacaoFormato = new SimpleDateFormat("dd/MM/yyyy");
									dataFabricacao = new java.sql.Date(dataFabricacaoFormato.parse(dataFabricacaoProduto).getTime());
									alterarCadastroProduto.setDataFabricacao(dataFabricacao);
								} catch (ParseException e1) {
									e1.printStackTrace();
								}
							}
							
							/*Cadastro da data de validade do produto*/
							if (textDataValidade.getText().replaceAll("\\/", "").trim().isEmpty()) {
								Date dataValidadeValor = null;
								alterarCadastroProduto.setDataValidade(dataValidadeValor);
							}
							else {
								dataValidadeProduto = textDataValidade.getText();					
								try {
									dataValidadeFormato = new SimpleDateFormat("dd/MM/yyyy");
									dataValidade = new java.sql.Date(dataValidadeFormato.parse(dataValidadeProduto).getTime());
									alterarCadastroProduto.setDataValidade(dataValidade);
								} catch (ParseException e1) {
									e1.printStackTrace();
								}
							}
							
							/*Cadastro da origem do produto*/
							if (radioImportado.isSelected()) {
								origemProduto = radioImportado.getText();
								alterarCadastroProduto.setOrigemProduto(origemProduto);
							}
							if (radioNacional.isSelected()) {
								origemProduto = radioNacional.getText();
								alterarCadastroProduto.setOrigemProduto(origemProduto);
							}
							
							/*Cadastro da montagem do produto*/
							if (radioMontagemSim.isSelected()) {
								montagemProduto = radioMontagemSim.getText();
								alterarCadastroProduto.setMontagem(montagemProduto);
							}
							if (radioMontagemNao.isSelected()) {
								montagemProduto = radioMontagemNao.getText();
								alterarCadastroProduto.setMontagem(montagemProduto);
							}
							
							/*Cadastro da embalagem*/
							if (radioEmbalagemSim.isSelected()) {
								embalagemProduto = radioEmbalagemSim.getText();
								alterarCadastroProduto.setEmbalagem(embalagemProduto);
							}
							if (radioEmbalagemNao.isSelected()) {
								embalagemProduto = radioEmbalagemNao.getText();
								alterarCadastroProduto.setEmbalagem(embalagemProduto);
							}
							alterarCadastroProduto.setTipoEmbalagem(textTipoEmbalagem.getText());
							
							/*Cadastro da estampa*/
							if (radioEstampaSim.isSelected()) {
								estampaProduto = radioEstampaSim.getText();
								alterarCadastroProduto.setEstampa(estampaProduto);
							}
							if (radioEstampaNao.isSelected()) {
								estampaProduto = radioEstampaNao.getText();
								alterarCadastroProduto.setEstampa(estampaProduto);
							}
							alterarCadastroProduto.setTipoEstampa(textTipoEstampa.getText());
							
							alterarCadastroProduto.setCodigoProduto(codigoProduto.getText());
							alterarCadastroEstoqueProduto.setCodigoProduto(codigoProduto.getText());
							
							salvaNovosDados = new Dao_alterar_dados_produto();
							salvaNovosDados.Altera_Dados_Produto(alterarCadastroProduto);
							
							salvaNovosDadosEstoque = new Dao_alterar_dados_produto();
							salvaNovosDadosEstoque.Altera_Dados_Produto_Produto_Estoque(alterarCadastroEstoqueProduto);
							
							/*Mensagem de confirmação do cadastro*/
							String menssagemConteudo = "Dados alterados com sucesso";
							Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
							mensagemConfirmacao.setVisible(true);
							
							/*Volta para a ficha do produto*/
							Ficha_do_Produto FichaProduto = new Ficha_do_Produto();
							FichaProduto.setVisible(true);
							dispose();
						}
						catch(NumberFormatException e2){
							String menssagemConteudo = "Campos numericos aceitam somente numeros(valores inteiros) ou numeros e pontos(valores quebrados)";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
							menssagemAvisoCampos.setVisible(true);
						}
					}
			}
		});
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(salvar);
		
		fornecedor = new JButton("Fornecedor");
		fornecedor.setToolTipText("Selecionar um fornecedor");
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
		fornecedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(fornecedor);
		
		cancelar = new JButton("Cancelar");
		cancelar.setToolTipText("Fecha a janela");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ficha_do_Produto FichaProduto = new Ficha_do_Produto();
				FichaProduto.setVisible(true);
				dispose();
			}
		});
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(cancelar);
		
		/*Ação do botao sair da janela*/
		addWindowListener(
            new WindowAdapter() 
            {
                public void windowClosing(WindowEvent we) {
                	Ficha_do_Produto FichaProduto = new Ficha_do_Produto();
    				FichaProduto.setVisible(true);
    				dispose();
                }
            }
	    );
	}
}