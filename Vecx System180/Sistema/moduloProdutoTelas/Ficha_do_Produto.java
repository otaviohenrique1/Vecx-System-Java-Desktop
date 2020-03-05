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
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.util.List;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import aInterfaceSistema.Sessao;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoBD.Dao_consulta_dados_produto;
import moduloProdutoBD.Produto;

public class Ficha_do_Produto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaProduto;
	private JButton editar, voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficha_do_Produto frame = new Ficha_do_Produto();
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
	public Ficha_do_Produto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ficha_do_Produto.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		setSize(1000, 600);
		
		telaFichaProduto = new JPanel();
		telaFichaProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaProduto.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaProduto);
		
		JPanel panelTitulo = new JPanel();
		telaFichaProduto.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Ficha_do_Produto.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFichaProduto = new JLabel("Ficha do produto");
		panelTitulo2.add(labelFichaProduto);
		labelFichaProduto.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Ficha_do_Produto.class.getResource("/cImagens/Funcionario.png")));
		fichaUsuario.setToolTipText("Fecha o programa");
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
		telaFichaProduto.add(tabbedPaneFichaProduto, BorderLayout.CENTER);
		
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
		panelNome_CodPro_DataHora.setPreferredSize(new Dimension(10, 50));
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
		
		JLabel nome = new JLabel();
		nome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNome.add(nome);
		
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
		
		JLabel labelDataCadastro = new JLabel("Data de cadastro");
		labelDataCadastro.setPreferredSize(new Dimension(200, 14));
		labelDataCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataCadastro.add(labelDataCadastro);
		
		JLabel dataCadastro = new JLabel();
		dataCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataCadastro.add(dataCadastro);
		
		JPanel panelMarca_CodBarras_Lote = new JPanel();
		panelMarca_CodBarras_Lote.setPreferredSize(new Dimension(10, 50));
		panelFichaProduto.add(panelMarca_CodBarras_Lote);
		panelMarca_CodBarras_Lote.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelMarca = new JPanel();
		panelMarca_CodBarras_Lote.add(panelMarca);
		panelMarca.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelMarca.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelMarca = new JLabel("Marca");
		labelMarca.setHorizontalAlignment(SwingConstants.LEFT);
		labelMarca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelMarca.add(labelMarca);
		
		JLabel marca = new JLabel();
		marca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelMarca.add(marca);
		
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
		
		JLabel codigoBarras = new JLabel();
		panelCodigoBarras.add(codigoBarras);
		codigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelLote = new JPanel();
		panelCodBarras_Lote.add(panelLote);
		panelLote.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelLote.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLote = new JLabel("Lote");
		panelLote.add(labelLote);
		labelLote.setHorizontalAlignment(SwingConstants.LEFT);
		labelLote.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lote = new JLabel();
		panelLote.add(lote);
		lote.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelData_VidaUtil = new JPanel();
		panelData_VidaUtil.setPreferredSize(new Dimension(10, 50));
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
		
		JLabel dataPrimeiraCompra = new JLabel();
		panelDataPrimeiraCompra.add(dataPrimeiraCompra);
		dataPrimeiraCompra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelDataFabricacao = new JPanel();
		panelData_VidaUtil.add(panelDataFabricacao);
		panelDataFabricacao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataFabricacao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataFabricacao = new JLabel("Data de fabrica\u00E7\u00E3o");
		panelDataFabricacao.add(labelDataFabricacao);
		labelDataFabricacao.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataFabricacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel dataFabricacao = new JLabel();
		panelDataFabricacao.add(dataFabricacao);
		dataFabricacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelDataValidade = new JPanel();
		panelData_VidaUtil.add(panelDataValidade);
		panelDataValidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataValidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataValidade = new JLabel("Data de validade");
		panelDataValidade.add(labelDataValidade);
		labelDataValidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataValidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel dataValidade = new JLabel();
		panelDataValidade.add(dataValidade);
		dataValidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelVidaUtil = new JPanel();
		panelData_VidaUtil.add(panelVidaUtil);
		panelVidaUtil.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelVidaUtil.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelVidaUtil = new JLabel("Vida Util do produto");
		labelVidaUtil.setHorizontalAlignment(SwingConstants.LEFT);
		labelVidaUtil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelVidaUtil.add(labelVidaUtil);
		
		JLabel vidaUtil = new JLabel();
		vidaUtil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelVidaUtil.add(vidaUtil);
		
		JPanel panelPreco_OriPro = new JPanel();
		panelPreco_OriPro.setPreferredSize(new Dimension(10, 50));
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
		
		JLabel precoCompra = new JLabel();
		panelPrecoCompra.add(precoCompra);
		precoCompra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelPrecoVenda = new JPanel();
		panelPreco_OriPro.add(panelPrecoVenda);
		panelPrecoVenda.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoVenda.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoVenda = new JLabel("Pre\u00E7o de Venda(R$)");
		panelPrecoVenda.add(labelPrecoVenda);
		labelPrecoVenda.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel precoVenda = new JLabel();
		panelPrecoVenda.add(precoVenda);
		precoVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelOrigemProduto = new JPanel();
		panelPreco_OriPro.add(panelOrigemProduto);
		panelOrigemProduto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelOrigemProduto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelOrigemProduto = new JLabel("Origem do produto");
		labelOrigemProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelOrigemProduto.add(labelOrigemProduto);
		
		JLabel origemProduto = new JLabel();
		origemProduto.setHorizontalAlignment(SwingConstants.LEFT);
		origemProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelOrigemProduto.add(origemProduto);
		
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
		
		JLabel quantidade = new JLabel();
		quantidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQuantidade.add(quantidade);
		
		JPanel panelGarantia = new JPanel();
		panelQuant_Garan_For_CNPJ.add(panelGarantia);
		panelGarantia.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelGarantia.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelGarantia = new JLabel("Garantia");
		panelGarantia.add(labelGarantia);
		labelGarantia.setHorizontalAlignment(SwingConstants.LEFT);
		labelGarantia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel garantia = new JLabel();
		panelGarantia.add(garantia);
		garantia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelFornecedorNome = new JPanel();
		panelQuant_Garan_For_CNPJ.add(panelFornecedorNome);
		panelFornecedorNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFornecedorNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFornecedorNome = new JLabel("Fornecedor");
		panelFornecedorNome.add(labelFornecedorNome);
		labelFornecedorNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel fornecedorNome = new JLabel();
		panelFornecedorNome.add(fornecedorNome);
		fornecedorNome.setHorizontalAlignment(SwingConstants.LEFT);
		fornecedorNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelFornecedorCNPJ = new JPanel();
		panelFornecedorCNPJ.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelQuant_Garan_For_CNPJ.add(panelFornecedorCNPJ);
		panelFornecedorCNPJ.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFornecedorCNPJ = new JLabel("CNPJ do fornecedor");
		labelFornecedorCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFornecedorCNPJ.add(labelFornecedorCNPJ);
		
		JLabel fornecedorCNPJ = new JLabel();
		fornecedorCNPJ.setHorizontalAlignment(SwingConstants.LEFT);
		fornecedorCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFornecedorCNPJ.add(fornecedorCNPJ);
		
		JPanel panelTipoPro_Quant_Apli = new JPanel();
		panelTipoPro_Quant_Apli.setPreferredSize(new Dimension(10, 50));
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
		
		JLabel tipoProduto = new JLabel();
		tipoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoProduto.add(tipoProduto);
		
		JPanel panelQuantComp = new JPanel();
		panelTipoPro_Quant_Apli.add(panelQuantComp);
		panelQuantComp.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelQuantComp.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelQuantComp = new JLabel("Quantidade de componentes");
		labelQuantComp.setHorizontalAlignment(SwingConstants.LEFT);
		labelQuantComp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQuantComp.add(labelQuantComp);
		
		JLabel quantComp = new JLabel();
		quantComp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelQuantComp.add(quantComp);
		
		JPanel panelAplicacao = new JPanel();
		panelTipoPro_Quant_Apli.add(panelAplicacao);
		panelAplicacao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelAplicacao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelAplicacao = new JLabel("Aplica\u00E7\u00E3o");
		labelAplicacao.setHorizontalAlignment(SwingConstants.LEFT);
		labelAplicacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAplicacao.add(labelAplicacao);
		
		JLabel aplicacao = new JLabel();
		aplicacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAplicacao.add(aplicacao);
		
		JPanel panelEmbalagem_TipoEmbalagem = new JPanel();
		panelEmbalagem_TipoEmbalagem.setPreferredSize(new Dimension(10, 50));
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
		
		JLabel embalagem = new JLabel();
		embalagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEmbalagem.add(embalagem);
		
		JPanel panelTipoEmbalagem = new JPanel();
		panelEmbalagem_TipoEmbalagem.add(panelTipoEmbalagem);
		panelTipoEmbalagem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoEmbalagem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoEmbalagem = new JLabel("Tipo de embalagem");
		labelTipoEmbalagem.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoEmbalagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoEmbalagem.add(labelTipoEmbalagem);
		
		JLabel tipoEmbalagem = new JLabel();
		tipoEmbalagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoEmbalagem.add(tipoEmbalagem);
		
		JPanel panelEstampa_TipoEstampa = new JPanel();
		panelEstampa_TipoEstampa.setPreferredSize(new Dimension(10, 50));
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
		
		JLabel estampa = new JLabel();
		estampa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstampa.add(estampa);
		
		JPanel panelTipoEstampa = new JPanel();
		panelEstampa_TipoEstampa.add(panelTipoEstampa);
		panelTipoEstampa.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoEstampa.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoEstampa = new JLabel("Tipo de estampa");
		labelTipoEstampa.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoEstampa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoEstampa.add(labelTipoEstampa);
		
		JLabel tipoEstampa = new JLabel();
		tipoEstampa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoEstampa.add(tipoEstampa);
		
		JPanel panelCor_Modelo_Montagem = new JPanel();
		panelCor_Modelo_Montagem.setPreferredSize(new Dimension(10, 50));
		panelFichaProduto.add(panelCor_Modelo_Montagem);
		panelCor_Modelo_Montagem.setLayout(new GridLayout(0, 3, 5, 5));
		
		JPanel panelCor = new JPanel();
		panelCor_Modelo_Montagem.add(panelCor);
		panelCor.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCor.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCor = new JLabel("Cor");
		labelCor.setHorizontalAlignment(SwingConstants.LEFT);
		labelCor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCor.add(labelCor);
		
		JLabel cor = new JLabel();
		cor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCor.add(cor);
		
		JPanel panelModelo = new JPanel();
		panelCor_Modelo_Montagem.add(panelModelo);
		panelModelo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelModelo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelModelo = new JLabel("Modelo");
		labelModelo.setHorizontalAlignment(SwingConstants.LEFT);
		labelModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelModelo.add(labelModelo);
		
		JLabel modelo = new JLabel();
		modelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelModelo.add(modelo);
		
		JPanel panelMontagem = new JPanel();
		panelCor_Modelo_Montagem.add(panelMontagem);
		panelMontagem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelMontagem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelMontagem = new JLabel("Necessita de montagem ?");
		labelMontagem.setHorizontalAlignment(SwingConstants.LEFT);
		labelMontagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelMontagem.add(labelMontagem);
		
		JLabel montagem = new JLabel();
		montagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelMontagem.add(montagem);
		
		JPanel panelPeso_Altura_Comprimento = new JPanel();
		panelPeso_Altura_Comprimento.setPreferredSize(new Dimension(10, 50));
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
		
		JLabel peso = new JLabel();
		panelPeso.add(peso);
		peso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelAltura = new JPanel();
		panelPeso_Altura_Comprimento.add(panelAltura);
		panelAltura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelAltura.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelAltura = new JLabel("Altura");
		labelAltura.setHorizontalAlignment(SwingConstants.LEFT);
		labelAltura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAltura.add(labelAltura);
		
		JLabel altura = new JLabel();
		altura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAltura.add(altura);
		
		JPanel panelComprimento = new JPanel();
		panelPeso_Altura_Comprimento.add(panelComprimento);
		panelComprimento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComprimento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComprimento = new JLabel("Comprimento");
		labelComprimento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComprimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelComprimento.add(labelComprimento);
		
		JLabel comprimento = new JLabel();
		comprimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelComprimento.add(comprimento);
		
		JPanel panelLargura_Espessura_Profundidade = new JPanel();
		panelLargura_Espessura_Profundidade.setPreferredSize(new Dimension(10, 50));
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
		
		JLabel largura = new JLabel();
		largura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelLargura.add(largura);
		
		JPanel panelEspessura = new JPanel();
		panelLargura_Espessura_Profundidade.add(panelEspessura);
		panelEspessura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEspessura.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEspessura = new JLabel("Espessura");
		labelEspessura.setHorizontalAlignment(SwingConstants.LEFT);
		labelEspessura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEspessura.add(labelEspessura);
		
		JLabel espessura = new JLabel();
		espessura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEspessura.add(espessura);
		
		JPanel panelProfundidade = new JPanel();
		panelLargura_Espessura_Profundidade.add(panelProfundidade);
		panelProfundidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelProfundidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelProfundidade = new JLabel("Profundidade");
		labelProfundidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelProfundidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelProfundidade.add(labelProfundidade);
		
		JLabel profundidade = new JLabel();
		profundidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelProfundidade.add(profundidade);
		
		JPanel panelFuncionario = new JPanel();
		panelFuncionario.setPreferredSize(new Dimension(10, 50));
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
		funcionarioCadadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFuncionarioCadadastro.add(funcionarioCadadastro);
		
		JPanel panelCargo_Codigo = new JPanel();
		panelFuncionario.add(panelCargo_Codigo);
		panelCargo_Codigo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargoFuncionario = new JPanel();
		panelCargoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_Codigo.add(panelCargoFuncionario);
		panelCargoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargoFuncionario = new JLabel("Cargo do funcionario");
		labelCargoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargoFuncionario.add(labelCargoFuncionario);
		
		JLabel cargoFuncionario = new JLabel();
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
		
		JTextPane textPaneAcessorios = new JTextPane();
		scrollPaneAcessorios.setViewportView(textPaneAcessorios);
		textPaneAcessorios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPaneAcessorios.setEditable(false);
		textPaneAcessorios.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
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
		
		JTextPane textPaneDescricao = new JTextPane();
		scrollPaneDescricao.setViewportView(textPaneDescricao);
		scrollPaneDescricao.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneDescricao.getHorizontalScrollBar().setUnitIncrement(10);
		textPaneDescricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPaneDescricao.setEditable(false);
		textPaneDescricao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		/*Parte que consulta os dados no banco de dados*/
		String codigoProdutoConsulta = sessao.getCodigoProduto();
		String nomeProdutoConsulta = sessao.getNomeProduto();
		Dao_consulta_dados_produto teste = new Dao_consulta_dados_produto();
    	List<Produto> Consulta = teste.Consulta_Dados_Produto_Ficha(codigoProdutoConsulta, nomeProdutoConsulta);
    	for (Produto leitura : Consulta) {
    		/*Nome do produto*/
    		String nomeProdutoTexto = leitura.getNome();
    		nome.setText(nomeProdutoTexto);
    		
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
    		marca.setText(marcaProdutoTexto);
    		
    		/*Codigo de barras do produto*/
    		String codigoBarrasTexto = leitura.getCodigoBarras();
    		codigoBarras.setText(codigoBarrasTexto);
    		
    		/*Lote do produto*/
    		String loteProdutoTexto = leitura.getLote();
    		lote.setText(loteProdutoTexto);
    		
    		/*Data da primeira compra do produto*/
    		Date dataCompraProduto = leitura.getDataPrimeiraCompra();
    		if (dataCompraProduto == null) {
    			String dataPrimeiraCompraValorTexto = "Sem registro";
    			dataPrimeiraCompra.setText(dataPrimeiraCompraValorTexto);
			}
    		else {
    			SimpleDateFormat dataCompraFormato = new SimpleDateFormat("dd/MM/yyyy");
        		String dataCompraValor = dataCompraFormato.format(dataCompraProduto);
        		dataPrimeiraCompra.setText(dataCompraValor);
			}
    		
    		/*Data de fabricação do produto*/
    		Date dataFabricacaoProduto = leitura.getDataFabricacao();
    		if (dataFabricacaoProduto == null) {
    			String dataFabricacaoProdutoTexto = "Sem registro";
    			dataFabricacao.setText(dataFabricacaoProdutoTexto);
			}
    		else {
    			SimpleDateFormat dataFabricacaoFormato = new SimpleDateFormat("dd/MM/yyyy");
        		String dataFabricacaoValor = dataFabricacaoFormato.format(dataFabricacaoProduto);
        		dataFabricacao.setText(dataFabricacaoValor);
			}
    		
    		/*Data de validade do produto*/
    		Date dataValidadeProduto = leitura.getDataValidade();
    		if (dataValidadeProduto == null) {
    			String dataValidadeProdutoTexto = "Sem registro";
    			dataValidade.setText(dataValidadeProdutoTexto);
			}
    		else {
    			SimpleDateFormat dataValidadeFormato = new SimpleDateFormat("dd/MM/yyyy");
        		String dataValidadeValor = dataValidadeFormato.format(dataValidadeProduto);
        		dataValidade.setText(dataValidadeValor);
			}
    		
    		/*Vida util do produto*/
    		String vidaUtilValor = leitura.getVidaUtil();
    		String vidaUtilUnidade = leitura.getVidaUtilUnidade();
    		String vidaUtilTexto = vidaUtilValor + " " + vidaUtilUnidade;
    		vidaUtil.setText(vidaUtilTexto);
    		
    		/*Quantidade do produto*/
    		double quantidadeValor = leitura.getQuantidade();
    		String quantidadeUnidade = leitura.getQuantidadeUnidade();
    		String quantidadeTexto = quantidadeValor + " " + quantidadeUnidade;
    		quantidade.setText(quantidadeTexto);
    		
    		/*Preço de compra do produto*/
    		double precoCompraValor = leitura.getPrecoCompra();
    		String precoCompraProduto = "" + precoCompraValor;
    		precoCompra.setText(precoCompraProduto);
    		
    		/*Preço de venda produto*/
    		double precoaVistaValor = leitura.getPrecoaVista();
    		String precoaVistaProduto = "" + precoaVistaValor;
    		precoVenda.setText(precoaVistaProduto);
    		
    		/*Garantia do produto*/
    		String garantiaValor = leitura.getGarantia();
    		String garantiaUnidade = leitura.getGarantiaUnidade();
    		String garantiaTexto = garantiaValor + " " + garantiaUnidade;
    		garantia.setText(garantiaTexto);
    		
    		/*Origem do produto*/
    		String origemProdutoTexto = leitura.getOrigemProduto();
    		origemProduto.setText(origemProdutoTexto);
    		
    		/*Nome do fornecedor do produto*/
    		String fornecedorNomeTexto = leitura.getFornecedor();
    		fornecedorNome.setText(fornecedorNomeTexto);
    		
    		/*CNPJ do fornecedor do produto*/
    		String fornecedorCNPJTexto = leitura.getFornecedorCNPJ();
    		fornecedorCNPJ.setText(fornecedorCNPJTexto);
    		
    		/*Tipo de produto*/
    		String tipoProdutoTexto = leitura.getTipoProduto();
    		tipoProduto.setText(tipoProdutoTexto);
    		
    		/*Quantidade de componentes que vem com o produto*/
    		int quantCompValor = leitura.getQuantidadeComponentes();
    		String quantCompProduto = "" + quantCompValor;
    		quantComp.setText(quantCompProduto);
    		
    		/*Aplicacao do produto*/
    		String aplicacaoProdutoTexto = leitura.getAplicacao();
    		aplicacao.setText(aplicacaoProdutoTexto);
    		
    		/*Se o produto vem com embalagem*/
    		String embalagemProdutoTexto = leitura.getEmbalagem();
    		embalagem.setText(embalagemProdutoTexto);
    		
    		/*Tipo de embalagem que vem com o produto*/
    		String tipoEmbalagemTexto = leitura.getTipoEmbalagem();
    		tipoEmbalagem.setText(tipoEmbalagemTexto);
    		
    		/*Se o produto vem com estampa*/
    		String estampaProdutoTexto = leitura.getEstampa();
    		estampa.setText(estampaProdutoTexto);
    		
    		/*Tipo de estampa que vem no produto*/
    		String tipoEstampaTexto = leitura.getTipoEstampa();
    		tipoEstampa.setText(tipoEstampaTexto);
    		
    		/*Cor do produto*/
    		String corProdutoTexto = leitura.getCor();
    		cor.setText(corProdutoTexto);
    		
    		/*Modelo do produto*/
    		String modeloProdutoTexto = leitura.getModelo();
    		modelo.setText(modeloProdutoTexto);
    		
    		/*Se o produto precisa de montagem*/
    		String montagemProdutoTexto = leitura.getMontagem();
    		montagem.setText(montagemProdutoTexto);
    		
    		/*Peso do produto*/
    		String pesoValor = leitura.getPeso();
    		String pesoUnidade = leitura.getPesoUnidade();
    		String pesoTexto = pesoValor + " " + pesoUnidade;
    		peso.setText(pesoTexto);
    		
    		/*Altura do produto*/
    		String alturaValor = leitura.getAltura();
    		String alturaUnidade = leitura.getAlturaUnidade();
    		String alturaTexto = alturaValor + " " + alturaUnidade;
    		altura.setText(alturaTexto);
    		
    		/*Comprimento do produto*/
    		String comprimentoValor = leitura.getComprimento();
    		String comprimentoUnidade = leitura.getComprimentoUnidade();
    		String comprimentoTexto = comprimentoValor + " " + comprimentoUnidade;
    		comprimento.setText(comprimentoTexto);
    		
    		/*Largura do produto*/
    		String larguraValor = leitura.getLargura();
    		String larguraUnidade = leitura.getLarguraUnidade();
    		String larguraTexto = larguraValor + " " + larguraUnidade;
    		largura.setText(larguraTexto);
    		
    		/*Profundidade do produto*/
    		String profundidadeValor = leitura.getProfundidade();
    		String profundidadeUnidade = leitura.getProfundidadeUnidade();
    		String profundidadeTexto = profundidadeValor + " " + profundidadeUnidade;
    		profundidade.setText(profundidadeTexto);
    		
    		/*Espessura do produto*/
    		String espessuraValor = leitura.getEspessura();
    		String espessuraUnidade = leitura.getEspessuraUnidade();
    		String espessuraTexto = espessuraValor + " " + espessuraUnidade;
    		espessura.setText(espessuraTexto);
    		
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
    		textPaneAcessorios.setText(acessoriosProdutoTexto);
    		
    		/*Descricao do produto*/
    		String descricaoProdutoTexto = leitura.getDescricao();
    		textPaneDescricao.setText(descricaoProdutoTexto);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaProduto.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		editar = new JButton("Editar");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ficha_do_Produto_Editar FichaProdutoEditar = new Ficha_do_Produto_Editar();
				FichaProdutoEditar.setVisible(true);
				dispose();
			}
		});
		editar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(editar);
		
		voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(voltar);
		
		
		if (cargoUsuario != null) {
			if (cargoUsuario.equals("Carregador")) {
				editar.setEnabled(false);
			}
		}
	}
}