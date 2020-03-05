package moduloFornecedorTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import java.util.List;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloFinanceiroCompraBD.CompraProdutos;
import moduloFornecedorBD.Dao_consulta_dados_fornecedor;
import moduloFornecedorBD.Dao_consulta_dados_fornecedor_compra;
import moduloFornecedorBD.Dao_consulta_dados_fornecedor_produtos;
import moduloFornecedorBD.Fornecedor;
import moduloFornecedorTabelas.FornecedoresTabelaHistorico;
import moduloFornecedorTabelas.FornecedoresTabelaProdutos;
import moduloFornecedorTabelas.TabelaModeloFornecedoesHistorico;
import moduloFornecedorTabelas.TabelaModeloFornecedoesProdutos;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoBD.Produto;
import moduloProdutoTelas.Ficha_do_Produto;

public class Ficha_do_Fornecedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaFornecedor;
	private JTable tabelaListaProdutos, tabelaProdutosComprados;
	private TabelaModeloFornecedoesHistorico TabelaModeloHistorico;
	private TabelaModeloFornecedoesProdutos TabelaModeloProdutos;
	private JButton produtoFornecedorComprasBusca, produtoFornecedorProdutoBusca, exibirFichaProduto, editar, voltar;
	private JTextField textFornecedorProdutoBusca, textFornecedorComprasBusca;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficha_do_Fornecedor frame = new Ficha_do_Fornecedor();
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
	public Ficha_do_Fornecedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ficha_do_Fornecedor.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setSize(1000, 600);
		
		telaFichaFornecedor = new JPanel();
		telaFichaFornecedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaFornecedor.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaFornecedor);
		
		JPanel panelTitulo = new JPanel();
		telaFichaFornecedor.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Ficha_do_Fornecedor.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel fichaFornecedor_1 = new JLabel("Ficha do fornecedor");
		panelTitulo2.add(fichaFornecedor_1);
		fichaFornecedor_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Ficha_do_Fornecedor.class.getResource("/cImagens/Funcionario.png")));
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
		
		/*Parte da ficha dados do fornecedor*/
		JTabbedPane tabbedPaneFornecedor = new JTabbedPane(JTabbedPane.TOP);
		telaFichaFornecedor.add(tabbedPaneFornecedor, BorderLayout.CENTER);
		JPanel panelFichaFornecedor = new JPanel();
		tabbedPaneFornecedor.addTab("Ficha do fornecedor", null, panelFichaFornecedor, null);
		panelFichaFornecedor.setLayout(new GridLayout(0, 1, 5, 5));
		
		JScrollPane scrollPaneCadastro = new JScrollPane();
		scrollPaneCadastro.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneCadastro.getHorizontalScrollBar().setUnitIncrement(10);
		panelFichaFornecedor.add(scrollPaneCadastro);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNome_CodFornecedor = new JPanel();
		panelNome_CodFornecedor.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelNome_CodFornecedor);
		panelNome_CodFornecedor.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNome = new JPanel();
		panelNome_CodFornecedor.add(panelNome);
		panelNome.setPreferredSize(new Dimension(10, 50));
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNome = new JLabel("Nome");
		panelNome.add(labelNome);
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel nome = new JLabel();
		panelNome.add(nome);
		nome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCodigo_DataHora = new JPanel();
		panelNome_CodFornecedor.add(panelCodigo_DataHora);
		panelCodigo_DataHora.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCodigoFornecedor = new JPanel();
		panelCodigo_DataHora.add(panelCodigoFornecedor);
		panelCodigoFornecedor.setPreferredSize(new Dimension(200, 10));
		panelCodigoFornecedor.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoFornecedor.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoFornecedor = new JLabel("Codigo do fornecedor");
		labelCodigoFornecedor.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFornecedor.add(labelCodigoFornecedor);
		
		JLabel codigoFornecedor = new JLabel();
		codigoFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFornecedor.add(codigoFornecedor);
		
		JPanel panelCadastroDataHora = new JPanel();
		panelCodigo_DataHora.add(panelCadastroDataHora);
		panelCadastroDataHora.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCadastroDataHora.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCadastroDataHora = new JLabel("Data e hora do cadastro");
		labelCadastroDataHora.setHorizontalAlignment(SwingConstants.LEFT);
		labelCadastroDataHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCadastroDataHora.add(labelCadastroDataHora);
		
		JLabel dataHoraCadastro = new JLabel();
		panelCadastroDataHora.add(dataHoraCadastro);
		dataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		String nomeFornecedor = nome.getText();
		
		JPanel panelRazaoSocial_CNPJ_CPF = new JPanel();
		panelRazaoSocial_CNPJ_CPF.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelRazaoSocial_CNPJ_CPF);
		panelRazaoSocial_CNPJ_CPF.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelRazaoSocial = new JPanel();
		panelRazaoSocial_CNPJ_CPF.add(panelRazaoSocial);
		panelRazaoSocial.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRazaoSocial.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelRazaoSocial = new JLabel("Raz\u00E3o social");
		labelRazaoSocial.setHorizontalAlignment(SwingConstants.LEFT);
		labelRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelRazaoSocial.add(labelRazaoSocial);
		
		JLabel razaoSocial = new JLabel();
		razaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelRazaoSocial.add(razaoSocial);
		
		JPanel panelCodFor_CNPJ_CPF = new JPanel();
		panelRazaoSocial_CNPJ_CPF.add(panelCodFor_CNPJ_CPF);
		panelCodFor_CNPJ_CPF.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCNPJ = new JPanel();
		panelCNPJ.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodFor_CNPJ_CPF.add(panelCNPJ);
		panelCNPJ.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCNPJ = new JLabel("CNPJ");
		panelCNPJ.add(labelCNPJ);
		labelCNPJ.setHorizontalAlignment(SwingConstants.LEFT);
		labelCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cnpj = new JLabel();
		panelCNPJ.add(cnpj);
		cnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCPF = new JPanel();
		panelCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodFor_CNPJ_CPF.add(panelCPF);
		panelCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPF = new JLabel("CPF");
		panelCPF.add(labelCPF);
		labelCPF.setHorizontalAlignment(SwingConstants.LEFT);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cpf = new JLabel();
		panelCPF.add(cpf);
		cpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCom_For_InscEst = new JPanel();
		panelCom_For_InscEst.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelCom_For_InscEst);
		panelCom_For_InscEst.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelInscricaoEstadual = new JPanel();
		panelCom_For_InscEst.add(panelInscricaoEstadual);
		panelInscricaoEstadual.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelInscricaoEstadual.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelInscricaoEstadual = new JLabel("Inscri\u00E7\u00E3o estadual");
		panelInscricaoEstadual.add(labelInscricaoEstadual);
		labelInscricaoEstadual.setHorizontalAlignment(SwingConstants.LEFT);
		labelInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelInscricaoEstadual2 = new JPanel();
		panelInscricaoEstadual.add(panelInscricaoEstadual2);
		panelInscricaoEstadual2.setLayout(new BorderLayout(10, 0));
		
		JLabel inscricaoEstadual = new JLabel();
		inscricaoEstadual.setPreferredSize(new Dimension(80, 14));
		panelInscricaoEstadual2.add(inscricaoEstadual, BorderLayout.WEST);
		inscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel inscricaoEstadualNumero = new JLabel();
		panelInscricaoEstadual2.add(inscricaoEstadualNumero);
		inscricaoEstadualNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTipoFornecedor = new JPanel();
		panelTipoFornecedor.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCom_For_InscEst.add(panelTipoFornecedor);
		panelTipoFornecedor.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoFornecedor = new JLabel("Tipo de fornecedor");
		labelTipoFornecedor.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoFornecedor.add(labelTipoFornecedor);
		
		JLabel tipoFornecedor = new JLabel();
		tipoFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoFornecedor.add(tipoFornecedor);
		
		JPanel panelTipoComercio = new JPanel();
		panelTipoComercio.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCom_For_InscEst.add(panelTipoComercio);
		panelTipoComercio.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoComercio = new JLabel("Tipo de comercio");
		panelTipoComercio.add(labelTipoComercio);
		labelTipoComercio.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoComercio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel tipoComercio = new JLabel();
		panelTipoComercio.add(tipoComercio);
		tipoComercio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTelefone_Celular = new JPanel();
		panelTelefone_Celular.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelTelefone_Celular);
		panelTelefone_Celular.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelTelefone1 = new JPanel();
		panelTelefone1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelTelefone1);
		panelTelefone1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTelefone1 = new JLabel("Telefone 1");
		panelTelefone1.add(labelTelefone1);
		labelTelefone1.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefone1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel telefone1 = new JLabel();
		panelTelefone1.add(telefone1);
		telefone1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTelefone2 = new JPanel();
		panelTelefone2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelTelefone2);
		panelTelefone2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel tabelTelefone2 = new JLabel("Telefone 2");
		panelTelefone2.add(tabelTelefone2);
		tabelTelefone2.setHorizontalAlignment(SwingConstants.LEFT);
		tabelTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel telefone2 = new JLabel();
		panelTelefone2.add(telefone2);
		telefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCelular1 = new JPanel();
		panelTelefone_Celular.add(panelCelular1);
		panelCelular1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCelular1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular1 = new JLabel("Celular 1");
		panelCelular1.add(labelCelular1);
		labelCelular1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel celular1 = new JLabel();
		panelCelular1.add(celular1);
		celular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCelular2 = new JPanel();
		panelTelefone_Celular.add(panelCelular2);
		panelCelular2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCelular2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular2 = new JLabel("Celular 2");
		panelCelular2.add(labelCelular2);
		labelCelular2.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel celular2 = new JLabel();
		panelCelular2.add(celular2);
		celular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEmail = new JPanel();
		panelEmail.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelEmail);
		panelEmail.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelEmail1 = new JPanel();
		panelEmail1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail.add(panelEmail1);
		panelEmail1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail1 = new JLabel("Email");
		panelEmail1.add(labelEmail1);
		labelEmail1.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel email1 = new JLabel();
		panelEmail1.add(email1);
		email1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEmail2 = new JPanel();
		panelEmail2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail.add(panelEmail2);
		panelEmail2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail2 = new JLabel("Email 2");
		panelEmail2.add(labelEmail2);
		labelEmail2.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel email2 = new JLabel();
		panelEmail2.add(email2);
		email2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelNac_PaisOrigem = new JPanel();
		panelNac_PaisOrigem.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelNac_PaisOrigem);
		panelNac_PaisOrigem.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNacionalidade = new JPanel();
		panelNacionalidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNac_PaisOrigem.add(panelNacionalidade);
		panelNacionalidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNacionalidade = new JLabel("Nacionalidade");
		labelNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNacionalidade.add(labelNacionalidade);
		
		JLabel nacionalidade = new JLabel();
		nacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNacionalidade.add(nacionalidade);
		
		JPanel panelPaisOrigem = new JPanel();
		panelPaisOrigem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNac_PaisOrigem.add(panelPaisOrigem);
		panelPaisOrigem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPaisOrigem = new JLabel("Pais de origem");
		labelPaisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		labelPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(labelPaisOrigem);
		
		JLabel paisOrigem = new JLabel();
		paisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(paisOrigem);
		
		JPanel panelEstado_CEP_Cidade = new JPanel();
		panelEstado_CEP_Cidade.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelEstado_CEP_Cidade);
		panelEstado_CEP_Cidade.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelEstado = new JPanel();
		panelEstado_CEP_Cidade.add(panelEstado);
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstado.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstado = new JLabel("Estado");
		panelEstado.add(labelEstado);
		labelEstado.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel estado = new JLabel();
		panelEstado.add(estado);
		estado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCEP = new JPanel();
		panelCEP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstado_CEP_Cidade.add(panelCEP);
		panelCEP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCEP = new JLabel("CEP");
		panelCEP.add(labelCEP);
		labelCEP.setHorizontalAlignment(SwingConstants.LEFT);
		labelCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cep = new JLabel();
		panelCEP.add(cep);
		cep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCidade = new JPanel();
		panelEstado_CEP_Cidade.add(panelCidade);
		panelCidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCidade = new JLabel("Cidade");
		panelCidade.add(labelCidade);
		labelCidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cidade = new JLabel();
		panelCidade.add(cidade);
		cidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEndereco = new JPanel();
		panelEndereco.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelEndereco);
		panelEndereco.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEndereco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o");
		panelEndereco.add(labelEndereco);
		labelEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel endereco = new JLabel();
		panelEndereco.add(endereco);
		endereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelNume_Comp_Bairro = new JPanel();
		panelNume_Comp_Bairro.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelNume_Comp_Bairro);
		panelNume_Comp_Bairro.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelNumero = new JPanel();
		panelNumero.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNume_Comp_Bairro.add(panelNumero);
		panelNumero.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNumero = new JLabel("Numero");
		panelNumero.add(labelNumero);
		labelNumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel numero = new JLabel();
		panelNumero.add(numero);
		numero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelComplemento = new JPanel();
		panelNume_Comp_Bairro.add(panelComplemento);
		panelComplemento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComplemento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComplemento = new JLabel("Complemento");
		panelComplemento.add(labelComplemento);
		labelComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel complemento = new JLabel();
		panelComplemento.add(complemento);
		complemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelBairro = new JPanel();
		panelBairro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNume_Comp_Bairro.add(panelBairro);
		panelBairro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairro = new JLabel("Bairro");
		panelBairro.add(labelBairro);
		labelBairro.setHorizontalAlignment(SwingConstants.LEFT);
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel bairro = new JLabel();
		panelBairro.add(bairro);
		bairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelReferencia = new JPanel();
		panelReferencia.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelReferencia);
		panelReferencia.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelReferencia.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelReferencia = new JLabel("Referencia");
		panelReferencia.add(labelReferencia);
		labelReferencia.setHorizontalAlignment(SwingConstants.LEFT);
		labelReferencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel referencia = new JLabel();
		panelReferencia.add(referencia);
		referencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelFuncionario = new JPanel();
		panelFuncionario.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelFuncionario);
		panelFuncionario.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelFuncionarioCadastro = new JPanel();
		panelFuncionarioCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFuncionario.add(panelFuncionarioCadastro);
		panelFuncionarioCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFuncionarioCadastro = new JLabel("Funcionario que cadastrou");
		labelFuncionarioCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFuncionarioCadastro.add(labelFuncionarioCadastro);
		
		JLabel funcionarioCadastro = new JLabel();
		funcionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFuncionarioCadastro.add(funcionarioCadastro);
		
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
		
		/*Parte que consulta os dados no banco de dados*/
		String codigoFornecedorConsulta = sessao.getCodigoFornecedor();
		String nomeFornecedorConsulta = sessao.getNomeFornecedor();
		String cnpjFornecedoreConsulta = sessao.getCNPJFornecedor();
		Dao_consulta_dados_fornecedor ConsultaFornecedorFicha = new Dao_consulta_dados_fornecedor();
    	List<Fornecedor> ConsultaFornecedorDados = ConsultaFornecedorFicha.Consulta_Dados_Fornecedor_Ficha(codigoFornecedorConsulta, nomeFornecedorConsulta, cnpjFornecedoreConsulta);
    	for (Fornecedor leitura : ConsultaFornecedorDados) {
    		String nomeFornecedorTexto = leitura.getNome();
    		nome.setText(nomeFornecedorTexto);
    		
    		String codigoFornecedorTexto = leitura.getCodigoFornecedor();
    		codigoFornecedor.setText(codigoFornecedorTexto);

    		Date dataCadastroFornecedor =	leitura.getDataCadastro();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroFornecedor);
    		Time horaCadastroFornecedor = leitura.getHoraCadastro();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroFornecedor);
    		dataHoraCadastro.setText(dataCadastroValor + " " + horaCadastroValor);
    		
    		String razaoSocialTexto = leitura.getRazaoSocial();
    		razaoSocial.setText(razaoSocialTexto);
    		
    		String cnpjFornecedor = leitura.getCNPJ();
    		cnpj.setText(cnpjFornecedor);
    		
    		String cpfFornecedor = leitura.getCPF();
    		cpf.setText(cpfFornecedor);
    		
    		String inscricaoEstadualTexto = leitura.getInscricaoEstadual();
    		inscricaoEstadual.setText(inscricaoEstadualTexto);
    		
    		String inscricaoEstadualNumeroTexto = leitura.getInscricaoNumero();
    		inscricaoEstadualNumero.setText(inscricaoEstadualNumeroTexto);
    		
    		String telefone1Fornecedor = leitura.getTelefone1();
    		telefone1.setText(telefone1Fornecedor);
    		
    		String telefone2Fornecedor = leitura.getTelefone2();
    		telefone2.setText(telefone2Fornecedor);
    		
    		String celular1Fornecedor = leitura.getCelular1();
    		celular1.setText(celular1Fornecedor);
    		
    		String celular2Fornecedor = leitura.getCelular2();
    		celular2.setText(celular2Fornecedor);
    		
    		String email1Fornecedor = leitura.getEmail1();
    		email1.setText(email1Fornecedor);
    		
    		String email2Fornecedor = leitura.getEmail2();
    		email2.setText(email2Fornecedor);
    		
    		String nacionalidadeFornecedor = leitura.getNacionalidade();
    		nacionalidade.setText(nacionalidadeFornecedor);
    		
    		String paisOrigemFornecedor = leitura.getPais();
    		paisOrigem.setText(paisOrigemFornecedor);
    		
    		String tipoFornecedorFornecedor = leitura.getTipoFornecedor();
    		tipoFornecedor.setText(tipoFornecedorFornecedor);
    		
    		String tipoComercioFornecedor = leitura.getTipoComercio();
    		tipoComercio.setText(tipoComercioFornecedor);
    		
    		String estadoFornecedor = leitura.getEstado();
    		estado.setText(estadoFornecedor);
    		
    		String cepFornecedor = leitura.getCEP();
    		cep.setText(cepFornecedor);
    		
    		String cidadeFornecedor = leitura.getCidade();
    		cidade.setText(cidadeFornecedor);
    		
    		String enderecoFornecedor = leitura.getEndereco();
    		endereco.setText(enderecoFornecedor);
    		
    		String numeroFornecedor = leitura.getNumero();
    		numero.setText(numeroFornecedor);
    		
    		String complementoFornecedor = leitura.getComplemento();
    		complemento.setText(complementoFornecedor);
    		
    		String bairroFornecedor = leitura.getBairro();
    		bairro.setText(bairroFornecedor);
    		
    		String referenciaFornecedor = leitura.getReferencia();
    		referencia.setText(referenciaFornecedor);
    		
    		String nomeFuncionarioTexto = leitura.getFuncionarioCadastro();
    		funcionarioCadastro.setText(nomeFuncionarioTexto);
    		
    		String cargoFuncionarioTexto = leitura.getCargoFuncionario();
    		cargoFuncionario.setText(cargoFuncionarioTexto);
    		
    		String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
    		codigoFuncionario.setText(codigoFuncionarioTexto);
		}
    	
    	/*Parte da ficha dos produtos de produtos do fornecedor*/
		JPanel panelFornecedorProduto = new JPanel();
		tabbedPaneFornecedor.addTab("Produtos relacionados", null, panelFornecedorProduto, null);
		panelFornecedorProduto.setLayout(new BorderLayout(0, 5));

		/*Busca na tabela de produtos do fornecedor*/
		JPanel panelFornecedorProdutoBusca = new JPanel();
		panelFornecedorProdutoBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFornecedorProduto.add(panelFornecedorProdutoBusca, BorderLayout.NORTH);
		panelFornecedorProdutoBusca.setLayout(new BorderLayout(10, 0));
		
		JLabel labelFornecedorProdutoBusca = new JLabel("Busca:");
		labelFornecedorProdutoBusca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelFornecedorProdutoBusca.add(labelFornecedorProdutoBusca, BorderLayout.WEST);
		
		textFornecedorProdutoBusca = new JTextField();
		textFornecedorProdutoBusca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelFornecedorProdutoBusca.add(textFornecedorProdutoBusca);
		textFornecedorProdutoBusca.setColumns(10);
		
		produtoFornecedorProdutoBusca = new JButton("Busca");
		produtoFornecedorProdutoBusca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelFornecedorProdutoBusca.add(produtoFornecedorProdutoBusca, BorderLayout.EAST);
		
		/*Tabela com a lista de produtos do fornecedor*/
		JScrollPane scrollPaneListaProdutos = new JScrollPane();
		scrollPaneListaProdutos.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneListaProdutos.getHorizontalScrollBar().setUnitIncrement(10);
		panelFornecedorProduto.add(scrollPaneListaProdutos);
		TabelaModeloProdutos = new TabelaModeloFornecedoesProdutos();
		tabelaListaProdutos = new JTable();
		tabelaListaProdutos.setModel(TabelaModeloProdutos);
		scrollPaneListaProdutos.setViewportView(tabelaListaProdutos);
		
		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloFornecedoesProdutos> sorterBuscaFornecedorProduto = new TableRowSorter<TabelaModeloFornecedoesProdutos>(TabelaModeloProdutos);
		tabelaListaProdutos.setRowSorter(sorterBuscaFornecedorProduto);
		produtoFornecedorProdutoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textFornecedorProdutoBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaFornecedorProduto.setRowFilter(null);
				}
				else {
					sorterBuscaFornecedorProduto.setRowFilter(RowFilter.regexFilter(palavraBusca));
				}
			}
		});
		textFornecedorProdutoBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evtkey) {
				int botaoteclado = evtkey.getKeyCode();
				if (botaoteclado == KeyEvent.VK_ENTER) {
					String palavraBusca = textFornecedorProdutoBusca.getText();
					if (palavraBusca.length() ==0 ) {
						sorterBuscaFornecedorProduto.setRowFilter(null);
					}
					else {
						sorterBuscaFornecedorProduto.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		JPanel panelExibirFichaProduto = new JPanel();
		FlowLayout fl_panelExibirFichaProduto = (FlowLayout) panelExibirFichaProduto.getLayout();
		fl_panelExibirFichaProduto.setAlignment(FlowLayout.RIGHT);
		panelFornecedorProduto.add(panelExibirFichaProduto, BorderLayout.SOUTH);
		
		exibirFichaProduto = new JButton("Exibir ficha");
		exibirFichaProduto.setToolTipText("Exibe a ficha com os dados do produto");
		exibirFichaProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		exibirFichaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabelaListaProdutos.getSelectedRow() != -1 && tabelaListaProdutos.getSelectedRow() < TabelaModeloProdutos.getRowCount()) {
					sessao.setCodigoProduto((String) tabelaListaProdutos.getModel().getValueAt(tabelaListaProdutos.getSelectedRow(),0));
					sessao.setNomeProduto((String) tabelaListaProdutos.getModel().getValueAt(tabelaListaProdutos.getSelectedRow(), 1));
					
					Ficha_do_Produto exibeFichaProduto = new Ficha_do_Produto();
					exibeFichaProduto.setVisible(true);
				}
				else {
					String menssagemConteudo = "Nenhum item selecionado";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
				}
			}
		});
		panelExibirFichaProduto.add(exibirFichaProduto);
		tabelaListaProdutos.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaListaProdutos.getColumnModel().getColumn(1).setPreferredWidth(300);
		tabelaListaProdutos.getColumnModel().getColumn(2).setPreferredWidth(80);
		
		/*Parte que consulta os dados no banco de dados*/
		Dao_consulta_dados_fornecedor_produtos ConsultaFornecedorProdutos = new Dao_consulta_dados_fornecedor_produtos();
    	List<Produto> ConsultaListaProdutos = ConsultaFornecedorProdutos.Consulta_Dados_Compra_Fornecedor_Produtos(nomeFornecedor);
    	for (Produto leitura : ConsultaListaProdutos) {
    		String nomeProduto = leitura.getNome();
    		String codigoproduto = leitura.getCodigoProduto();
    		
    		double precoProdutoValor = leitura.getPrecoCompra();
    		String precoProdutoTexto = "" + precoProdutoValor;
    		
    		Date dataPrimeiraCompraProduto =	leitura.getDataPrimeiraCompra();
    		SimpleDateFormat dataPrimeiraCompraFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataPrimeiraCompraValor = dataPrimeiraCompraFormato.format(dataPrimeiraCompraProduto);
    		
    		FornecedoresTabelaProdutos nListaProdutos = new FornecedoresTabelaProdutos(codigoproduto, nomeProduto, precoProdutoTexto, dataPrimeiraCompraValor);
    		TabelaModeloProdutos.addFornecedorProdutos(nListaProdutos);
		}
		
		/*Parte da ficha das compras com o fornecedor*/
		JPanel panelFornecedorCompras = new JPanel();
		tabbedPaneFornecedor.addTab("Historico de compras com este fornecedor", null, panelFornecedorCompras, null);
		panelFornecedorCompras.setLayout(new BorderLayout(0, 5));

		/*Busca na tabela de compras com o fornecedor*/
		JPanel panelFornecedorComprasBusca = new JPanel();
		panelFornecedorComprasBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFornecedorCompras.add(panelFornecedorComprasBusca, BorderLayout.NORTH);
		panelFornecedorComprasBusca.setLayout(new BorderLayout(10, 0));
		
		JLabel labelFornecedorComprasBusca = new JLabel("Busca:");
		labelFornecedorComprasBusca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelFornecedorComprasBusca.add(labelFornecedorComprasBusca, BorderLayout.WEST);
		
		textFornecedorComprasBusca = new JTextField();
		textFornecedorComprasBusca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelFornecedorComprasBusca.add(textFornecedorComprasBusca);
		textFornecedorComprasBusca.setColumns(10);
		
		produtoFornecedorComprasBusca = new JButton("Busca");
		produtoFornecedorComprasBusca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelFornecedorComprasBusca.add(produtoFornecedorComprasBusca, BorderLayout.EAST);
		
		/*Tabela com a lista de compras com o fornecedor*/
		JScrollPane scrollPaneProdutosComprados = new JScrollPane();
		scrollPaneProdutosComprados.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneProdutosComprados.getHorizontalScrollBar().setUnitIncrement(10);
		panelFornecedorCompras.add(scrollPaneProdutosComprados);
		TabelaModeloHistorico = new TabelaModeloFornecedoesHistorico();
		tabelaProdutosComprados = new JTable();
		tabelaProdutosComprados.setModel(TabelaModeloHistorico);
		scrollPaneProdutosComprados.setViewportView(tabelaProdutosComprados);
		tabelaProdutosComprados.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaProdutosComprados.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaProdutosComprados.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabelaProdutosComprados.getColumnModel().getColumn(3).setPreferredWidth(90);
		tabelaProdutosComprados.getColumnModel().getColumn(4).setPreferredWidth(80);
		tabelaProdutosComprados.getColumnModel().getColumn(5).setPreferredWidth(80);
		tabelaProdutosComprados.getColumnModel().getColumn(6).setPreferredWidth(80);
		
		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloFornecedoesHistorico> sorterBuscaFornecedoes = new TableRowSorter<TabelaModeloFornecedoesHistorico>(TabelaModeloHistorico);
		tabelaProdutosComprados.setRowSorter(sorterBuscaFornecedoes);
		produtoFornecedorComprasBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textFornecedorComprasBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaFornecedoes.setRowFilter(null);
				}
				else {
					sorterBuscaFornecedoes.setRowFilter(RowFilter.regexFilter(palavraBusca));
				}
			}
		});
		textFornecedorComprasBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evtkey) {
				int botaoteclado = evtkey.getKeyCode();
				if (botaoteclado == KeyEvent.VK_ENTER) {
					String palavraBusca = textFornecedorComprasBusca.getText();
					if (palavraBusca.length() ==0 ) {
						sorterBuscaFornecedoes.setRowFilter(null);
					}
					else {
						sorterBuscaFornecedoes.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que consulta os dados no banco de dados*/
		Dao_consulta_dados_fornecedor_compra ConsultaFornecedorCompras = new Dao_consulta_dados_fornecedor_compra();
    	List<CompraProdutos> ConsultaListaCompras = ConsultaFornecedorCompras.Consulta_Dados_Fornecedor_Compra(nomeFornecedorConsulta);
    	for (CompraProdutos leitura : ConsultaListaCompras) {
    		String codigoProdutoLista = leitura.getCodigoProduto();
    		String nomeProdutoLista = leitura.getNomeProduto();
    		String codigoCompraLista = leitura.getCodigoCompra();
    		
    		Date dataCompraFornecedor =	leitura.getDataCompra();
    		SimpleDateFormat dataCompraFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCompraValor = dataCompraFormato.format(dataCompraFornecedor);
    		Time horaCompraFornecedor = leitura.getHoraCompra();
    		SimpleDateFormat horaCompraFormato = new SimpleDateFormat("HH:mm");
    		String horaCompraValor = horaCompraFormato.format(horaCompraFornecedor);
    		String dataHoraCompraLista = dataCompraValor + " " + horaCompraValor;
			
    		double precoUnitarioValor = leitura.getPrecoCompra();
    		String precoUnitarioLista = "" + precoUnitarioValor;
    		
    		double quantidadeProdutoValor = leitura.getQuantidade();
    		String quantidadeProdutoLista = "" + quantidadeProdutoValor;
    		
    		double precoQuantidadeValor = leitura.getPrecoQuantidade();
    		String precoQuantidadeLista = "" + precoQuantidadeValor;
    		
    		FornecedoresTabelaHistorico nListaCompra = new FornecedoresTabelaHistorico(codigoProdutoLista, nomeProdutoLista, codigoCompraLista, dataHoraCompraLista, precoUnitarioLista, quantidadeProdutoLista, precoQuantidadeLista);
    		TabelaModeloHistorico.addFornecedorHistorico(nListaCompra);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaFornecedor.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		editar = new JButton("Editar");
		editar.setToolTipText("Editar os dados da ficha");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ficha_do_Fornecedor_Editar fichaFornecedor = new Ficha_do_Fornecedor_Editar();
				fichaFornecedor.setVisible(true);
				dispose();
			}
		});
		editar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(editar);
		
		voltar = new JButton("Voltar");
		voltar.setToolTipText("Fecha a janela");
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