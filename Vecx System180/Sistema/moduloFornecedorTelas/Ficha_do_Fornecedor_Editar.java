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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
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
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloFornecedorBD.Dao_alterar_dados_fornecedor;
import moduloFornecedorBD.Dao_consulta_dados_fornecedor;
import moduloFornecedorBD.Fornecedor;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Ficha_do_Fornecedor_Editar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaFornecedorEditar;
	private JTextField textEndereco, textBairro, textNumero, textComplemento, textCidade, textPaisOrigem, textNome, textRazaoSocial, textInscricaoNumero;
	private JTextField textEmail1, textEmail2, textReferencia, textNacionalidade;
	private JFormattedTextField textCNPJ, textCPF, textCEP, textTelefone1, textTelefone2, textCelular1, textCelular2;
	private JCheckBox checkBoxIsento;
	private final ButtonGroup buttonGroupComercio = new ButtonGroup();
	private JRadioButton radioVarejo, radioAtacado, radioOutro;
	private JComboBox<String> comboBoxTipoFornecedor, comboBoxEstado;
	private JButton salvar, cancelar;
	private JLabel codigoFornecedor;
	Fornecedor alterarCadastroFornecedor;
	String tipoComercio, isentoInscricaoEstadual;
	String cadastroEmail1, cadastroEmail2, cadastroTelefone1, cadastroTelefone2, cadastroCelular1, cadastroCelular2;
	String celular1Texto, celular2Texto, email1Texto, email2Texto, telefone1Texto, telefone2Texto;
	Dao_alterar_dados_fornecedor salvaNovosDados;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficha_do_Fornecedor_Editar frame = new Ficha_do_Fornecedor_Editar();
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
	public Ficha_do_Fornecedor_Editar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ficha_do_Fornecedor_Editar.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setSize(1000, 600);
		
		telaFichaFornecedorEditar = new JPanel();
		telaFichaFornecedorEditar.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaFornecedorEditar.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaFornecedorEditar);
		
		JPanel panelTitulo = new JPanel();
		telaFichaFornecedorEditar.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout fl_panelTitulo2 = (FlowLayout) panelTitulo2.getLayout();
		fl_panelTitulo2.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Ficha_do_Fornecedor_Editar.class.getResource("/cImagens/Editar.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel fichaFornecedor = new JLabel("Ficha do fornecedor");
		panelTitulo2.add(fichaFornecedor);
		fichaFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Ficha_do_Fornecedor_Editar.class.getResource("/cImagens/Funcionario.png")));
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
		telaFichaFornecedorEditar.add(tabbedPaneFornecedor, BorderLayout.CENTER);
		JPanel panelFichaFornecedor = new JPanel();
		tabbedPaneFornecedor.addTab("Dados gerais", null, panelFichaFornecedor, null);
		panelFichaFornecedor.setLayout(new GridLayout(0, 1, 5, 5));
		
		JScrollPane scrollPaneCadastro = new JScrollPane();
		scrollPaneCadastro.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneCadastro.getHorizontalScrollBar().setUnitIncrement(10);
		panelFichaFornecedor.add(scrollPaneCadastro);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		MaskFormatter numeroCNPJMascara = null;
		MaskFormatter numeroCPFMascara = null;
		MaskFormatter numeroTelefone1Mascara = null;
		MaskFormatter numeroTelefone2Mascara = null;
		MaskFormatter numeroCelular1Mascara = null;
		MaskFormatter numeroCelular2Mascara = null;
		MaskFormatter numeroCEPMascara = null;
		try{
			numeroCNPJMascara = new MaskFormatter("##.###.###/####-#");
			numeroCPFMascara = new MaskFormatter("###.###.###-#");
			numeroTelefone1Mascara = new MaskFormatter("(##)####-####");
			numeroTelefone2Mascara = new MaskFormatter("(##)####-####");
			numeroCelular1Mascara = new MaskFormatter("(##)#####-####");
			numeroCelular2Mascara = new MaskFormatter("(##)#####-####");
			numeroCEPMascara = new MaskFormatter("#####-###");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		JPanel panelNome_CodFornecedor = new JPanel();
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
		
		textNome = new JTextField("");
		panelNome.add(textNome);
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		
		codigoFornecedor = new JLabel();
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
		
		JPanel panelRazaoSocial_CNPJ_CPF = new JPanel();
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
		
		textRazaoSocial = new JTextField("");
		textRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelRazaoSocial.add(textRazaoSocial);
		
		JPanel panelCNPJ_CPF_CodFor = new JPanel();
		panelRazaoSocial_CNPJ_CPF.add(panelCNPJ_CPF_CodFor);
		panelCNPJ_CPF_CodFor.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCNPJ = new JPanel();
		panelCNPJ.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCNPJ_CPF_CodFor.add(panelCNPJ);
		panelCNPJ.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCNPJ = new JLabel("CNPJ");
		panelCNPJ.add(labelCNPJ);
		labelCNPJ.setHorizontalAlignment(SwingConstants.LEFT);
		labelCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCNPJ = new JFormattedTextField(numeroCNPJMascara);
		panelCNPJ.add(textCNPJ);
		textCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCPF = new JPanel();
		panelCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCNPJ_CPF_CodFor.add(panelCPF);
		panelCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPF = new JLabel("CPF");
		panelCPF.add(labelCPF);
		labelCPF.setHorizontalAlignment(SwingConstants.LEFT);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCPF = new JFormattedTextField(numeroCPFMascara);
		panelCPF.add(textCPF);
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCom_For_InscEst = new JPanel();
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
		panelInscricaoEstadual2.setLayout(new BorderLayout(5, 0));
		
		checkBoxIsento = new JCheckBox("Isento");
		checkBoxIsento.setPreferredSize(new Dimension(80, 14));
		panelInscricaoEstadual2.add(checkBoxIsento, BorderLayout.WEST);
		checkBoxIsento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textInscricaoNumero = new JTextField("");
		panelInscricaoEstadual2.add(textInscricaoNumero);
		textInscricaoNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTipoFornecedor = new JPanel();
		panelTipoFornecedor.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCom_For_InscEst.add(panelTipoFornecedor);
		panelTipoFornecedor.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoFornecedor = new JLabel("Tipo de fornecedor");
		labelTipoFornecedor.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoFornecedor.add(labelTipoFornecedor);
		
		comboBoxTipoFornecedor = new JComboBox<String>();
		comboBoxTipoFornecedor.setMaximumRowCount(5);
		comboBoxTipoFornecedor.addItem("Selecione");
		comboBoxTipoFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoFornecedor.add(comboBoxTipoFornecedor);
		
		JPanel panelTipoComercio = new JPanel();
		panelTipoComercio.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCom_For_InscEst.add(panelTipoComercio);
		panelTipoComercio.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoComercio = new JLabel("Tipo de comercio");
		panelTipoComercio.add(labelTipoComercio);
		labelTipoComercio.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoComercio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTipoComercio2 = new JPanel();
		FlowLayout fl_panelTipoComercio2 = (FlowLayout) panelTipoComercio2.getLayout();
		fl_panelTipoComercio2.setAlignment(FlowLayout.LEFT);
		fl_panelTipoComercio2.setVgap(0);
		fl_panelTipoComercio2.setHgap(0);
		panelTipoComercio.add(panelTipoComercio2);
		
		radioVarejo = new JRadioButton("Varejo");
		buttonGroupComercio.add(radioVarejo);
		panelTipoComercio2.add(radioVarejo);
		radioVarejo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		radioAtacado = new JRadioButton("Atacado");
		buttonGroupComercio.add(radioAtacado);
		radioAtacado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoComercio2.add(radioAtacado);
		
		radioOutro = new JRadioButton("Outro");
		buttonGroupComercio.add(radioOutro);
		radioOutro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoComercio2.add(radioOutro);
		
		JPanel panelTelefone_Celular = new JPanel();
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
		
		textTelefone1 = new JFormattedTextField(numeroTelefone1Mascara);
		panelTelefone1.add(textTelefone1);
		textTelefone1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTelefone2 = new JPanel();
		panelTelefone2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelTelefone2);
		panelTelefone2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel tabelTelefone2 = new JLabel("Telefone 2");
		panelTelefone2.add(tabelTelefone2);
		tabelTelefone2.setHorizontalAlignment(SwingConstants.LEFT);
		tabelTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textTelefone2 = new JFormattedTextField(numeroTelefone2Mascara);
		panelTelefone2.add(textTelefone2);
		textTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCelular1 = new JPanel();
		panelTelefone_Celular.add(panelCelular1);
		panelCelular1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCelular1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular1 = new JLabel("Celular 1");
		panelCelular1.add(labelCelular1);
		labelCelular1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCelular1 = new JFormattedTextField(numeroCelular1Mascara);
		panelCelular1.add(textCelular1);
		textCelular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCelular2 = new JPanel();
		panelTelefone_Celular.add(panelCelular2);
		panelCelular2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCelular2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular2 = new JLabel("Celular 2");
		panelCelular2.add(labelCelular2);
		labelCelular2.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCelular2 = new JFormattedTextField(numeroCelular2Mascara);
		panelCelular2.add(textCelular2);
		textCelular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEmail = new JPanel();
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
		
		textEmail1 = new JTextField("");
		panelEmail1.add(textEmail1);
		textEmail1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEmail2 = new JPanel();
		panelEmail2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail.add(panelEmail2);
		panelEmail2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail2 = new JLabel("Email 2");
		panelEmail2.add(labelEmail2);
		labelEmail2.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textEmail2 = new JTextField("");
		panelEmail2.add(textEmail2);
		textEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelNac_PaisOrigem = new JPanel();
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
		
		textNacionalidade = new JTextField("");
		textNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNacionalidade.add(textNacionalidade);
		
		JPanel panelPaisOrigem = new JPanel();
		panelPaisOrigem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNac_PaisOrigem.add(panelPaisOrigem);
		panelPaisOrigem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPaisOrigem = new JLabel("Pais de origem");
		labelPaisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		labelPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(labelPaisOrigem);
		
		textPaisOrigem = new JTextField("");
		textPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(textPaisOrigem);
		
		JPanel panelEstado_CEP_Cidade = new JPanel();
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
		
		comboBoxEstado = new JComboBox<String>();
		panelEstado.add(comboBoxEstado);
		comboBoxEstado.setMaximumRowCount(29);
		comboBoxEstado.addItem("Selecione um estado");
		comboBoxEstado.addItem("Acre (AC)");
		comboBoxEstado.addItem("Alagoas (AL)");
		comboBoxEstado.addItem("Amapá (AP)");
		comboBoxEstado.addItem("Amazonas (AM)");
		comboBoxEstado.addItem("Bahia (BA)");
		comboBoxEstado.addItem("Ceará (CE)");
		comboBoxEstado.addItem("Distrito Federal (DF)");
		comboBoxEstado.addItem("Espírito Santo (ES)");
		comboBoxEstado.addItem("Goiás (GO)");
		comboBoxEstado.addItem("Maranhão (MA)");
		comboBoxEstado.addItem("Mato Grosso (MT)");
		comboBoxEstado.addItem("Mato Grosso do Sul (MS)");
		comboBoxEstado.addItem("Minas Gerais (MG)");
		comboBoxEstado.addItem("Pará (PA)");
		comboBoxEstado.addItem("Paraíba (PB)");
		comboBoxEstado.addItem("Paraná (PR)");
		comboBoxEstado.addItem("Pernambuco (PE)");
		comboBoxEstado.addItem("Piauí (PI)");
		comboBoxEstado.addItem("Rio de Janeiro (RJ)");
		comboBoxEstado.addItem("Rio Grande do Norte (RN)");
		comboBoxEstado.addItem("Rio Grande do Sul (RS)");
		comboBoxEstado.addItem("Rondônia (RO)");
		comboBoxEstado.addItem("Roraima (RR)");
		comboBoxEstado.addItem("Santa Catarina (SC)");
		comboBoxEstado.addItem("São Paulo (SP)");
		comboBoxEstado.addItem("Sergipe (SE)");
		comboBoxEstado.addItem("Tocantins (TO)");
		comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCEP = new JPanel();
		panelCEP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstado_CEP_Cidade.add(panelCEP);
		panelCEP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCEP = new JLabel("CEP");
		panelCEP.add(labelCEP);
		labelCEP.setHorizontalAlignment(SwingConstants.LEFT);
		labelCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCEP = new JFormattedTextField(numeroCEPMascara);
		panelCEP.add(textCEP);
		textCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCidade = new JPanel();
		panelEstado_CEP_Cidade.add(panelCidade);
		panelCidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCidade = new JLabel("Cidade");
		panelCidade.add(labelCidade);
		labelCidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCidade = new JTextField("");
		panelCidade.add(textCidade);
		textCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEndereco = new JPanel();
		panelCadastro.add(panelEndereco);
		panelEndereco.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEndereco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o");
		panelEndereco.add(labelEndereco);
		labelEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textEndereco = new JTextField("");
		panelEndereco.add(textEndereco);
		textEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelNume_Comp_Bairro = new JPanel();
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
		
		textNumero = new JTextField("");
		panelNumero.add(textNumero);
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelComplemento = new JPanel();
		panelNume_Comp_Bairro.add(panelComplemento);
		panelComplemento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComplemento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComplemento = new JLabel("Complemento");
		panelComplemento.add(labelComplemento);
		labelComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textComplemento = new JTextField("");
		panelComplemento.add(textComplemento);
		textComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelBairro = new JPanel();
		panelBairro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNume_Comp_Bairro.add(panelBairro);
		panelBairro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairro = new JLabel("Bairro");
		panelBairro.add(labelBairro);
		labelBairro.setHorizontalAlignment(SwingConstants.LEFT);
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textBairro = new JTextField("");
		panelBairro.add(textBairro);
		textBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelReferencia = new JPanel();
		panelCadastro.add(panelReferencia);
		panelReferencia.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelReferencia.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelReferencia = new JLabel("Referencia");
		panelReferencia.add(labelReferencia);
		labelReferencia.setHorizontalAlignment(SwingConstants.LEFT);
		labelReferencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textReferencia = new JTextField("");
		panelReferencia.add(textReferencia);
		textReferencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelFuncionario = new JPanel();
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
		Dao_consulta_dados_fornecedor teste = new Dao_consulta_dados_fornecedor();
		List<Fornecedor> Consulta = teste.Consulta_Dados_Fornecedor_Ficha(codigoFornecedorConsulta, nomeFornecedorConsulta, cnpjFornecedoreConsulta);
    	for (Fornecedor leitura : Consulta) {
    		String nomeFornecedorTexto = leitura.getNome();
    		textNome.setText(nomeFornecedorTexto);
    		
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
    		textRazaoSocial.setText(razaoSocialTexto);
    		
    		String cnpjFornecedor = leitura.getCNPJ();
    		textCNPJ.setText(cnpjFornecedor);
    		
    		String cpfFornecedor = leitura.getCPF();
    		textCPF.setText(cpfFornecedor);
    		
    		String inscricaoEstadual = leitura.getInscricaoEstadual();
    		if (inscricaoEstadual.equals("Isento")) {
    			checkBoxIsento.setSelected(true);
			}
    		
    		String inscricaoEstadualNumeroTexto = leitura.getInscricaoNumero();
    		textInscricaoNumero.setText(inscricaoEstadualNumeroTexto);
    		
    		String telefone1Fornecedor = leitura.getTelefone1();
    		if (telefone1Fornecedor.equals("Opcional")) {
    			telefone1Texto = "";
    			textTelefone1.setText(telefone1Texto);
			}
    		else {
    			telefone1Texto = leitura.getTelefone1();
    			textTelefone1.setText(telefone1Texto);
			}
    		
    		String telefone2Fornecedor = leitura.getTelefone2();
    		if (telefone2Fornecedor.equals("Opcional")) {
    			telefone2Texto = "";
    			textTelefone2.setText(telefone2Texto);
			}
    		else {
    			telefone2Texto = leitura.getTelefone2();
				textTelefone2.setText(telefone2Texto);
			}
    		
    		String celular1Fornecedor = leitura.getCelular1();
    		if (celular1Fornecedor.equals("Opcional")) {
    			celular1Texto = "";
    			textCelular1.setText(celular1Texto);
			}
    		else {
    			celular1Texto = leitura.getCelular1();
    			textCelular1.setText(celular1Texto);
			}
    		
    		String celular2Fornecedor = leitura.getCelular2();
    		if (celular2Fornecedor.equals("Opcional")) {
    			celular2Texto = "";
    			textCelular2.setText(celular2Texto);
			}
    		else {
    			celular2Texto = leitura.getCelular2();
    			textCelular2.setText(celular2Texto);
			}
    		
    		String email1Fornecedor = leitura.getEmail1();
    		if (email1Fornecedor.equals("Opcional")) {
    			email1Texto = "";
    			textEmail1.setText(email1Texto);
			}
    		else {
    			email1Texto = leitura.getEmail1();
    			textEmail1.setText(email1Texto);
			}
    		
    		String email2Fornecedor = leitura.getEmail2();
    		if (email2Fornecedor.equals("Opcional")) {
    			email2Texto = "";
    			textEmail2.setText(email2Texto);
			}
    		else {
    			email2Texto = leitura.getEmail2();
    			textEmail2.setText(email2Texto);
			}
    		
    		String nacionalidadeFornecedor = leitura.getNacionalidade();
    		if (nacionalidadeFornecedor.equals("Sem informações")) {
    			String nacionalidadeFornecedorTexto = "";
    			textNacionalidade.setText(nacionalidadeFornecedorTexto);	
			}
    		else {
    			textNacionalidade.setText(nacionalidadeFornecedor);
			}
    		
    		String paisOrigemFornecedor = leitura.getPais();
    		if (paisOrigemFornecedor.equals("Sem informações")) {
    			String paisOrigemFornecedorTexto = "";
    			textPaisOrigem.setText(paisOrigemFornecedorTexto);
			}
    		else {
    			textPaisOrigem.setText(paisOrigemFornecedor);
			}
    		
    		String tipoFornecedor = leitura.getTipoFornecedor();
    		if (tipoFornecedor.equals("Sem informações")) {
    			String tipoFornecedorTexto = "Selecione";
    			comboBoxTipoFornecedor.setSelectedItem(tipoFornecedorTexto);	
			}
    		else {
				comboBoxTipoFornecedor.setSelectedItem(tipoFornecedor);
			}
    		
    		String tipoComercio = leitura.getTipoComercio();
    		if (tipoComercio.equals("Varejo")) {
    			radioVarejo.setSelected(true);
			}
    		if (tipoComercio.equals("Atacado")) {
    			radioAtacado.setSelected(true);
			}
    		if (tipoComercio.equals("Outro")) {
    			radioOutro.setSelected(true);
			}
    		
    		String estadoFornecedor = leitura.getEstado();
    		if (estadoFornecedor.equals("Sem informações")) {
    			String estadoFornecedorTexto = "Selecione um estado";
    			comboBoxEstado.setSelectedItem(estadoFornecedorTexto);	
			}
    		else {
    			comboBoxEstado.setSelectedItem(estadoFornecedor);
			}
    		
    		String cepFornecedor = leitura.getCEP();
    		if (cepFornecedor.equals("Sem informações")) {
    			String cepFornecedorTexto = "";
    			textCEP.setText(cepFornecedorTexto);
			}
    		else {
    			textCEP.setText(cepFornecedor);
			}
    		
    		String cidadeFornecedor = leitura.getCidade();
    		if (cidadeFornecedor.equals("Sem informações")) {
    			String cidadeFornecedorTexto = "";
    			textCidade.setText(cidadeFornecedorTexto);
			}
    		else {
    			textCidade.setText(cidadeFornecedor);
			}
    		
    		String enderecoFornecedor = leitura.getEndereco();
    		if (enderecoFornecedor.equals("Sem informações")) {
    			String enderecoFornecedorTexto = "";
    			textEndereco.setText(enderecoFornecedorTexto);
			}
    		else {
				textEndereco.setText(enderecoFornecedor);
			}
    		
    		String numeroFornecedor = leitura.getNumero();
    		if (numeroFornecedor.equals("Sem informações")) {
    			String numeroFornecedorTexto = "";
    			textNumero.setText(numeroFornecedorTexto);
			}
    		else {
    			textNumero.setText(numeroFornecedor);
			}
    		
    		String complementoFornecedor = leitura.getComplemento();
    		if (complementoFornecedor.equals("Sem informações")) {
    			String complementoFornecedorTexto = "";
    			textComplemento.setText(complementoFornecedorTexto);	
			}
    		else {
    			textComplemento.setText(complementoFornecedor);
			}
    		
    		String bairroFornecedor = leitura.getBairro();
    		if (bairroFornecedor.equals("Sem informações")) {
				String bairroFornecedorTexto = "";
				textBairro.setText(bairroFornecedorTexto);
			}
    		else {
    			textBairro.setText(bairroFornecedor);
			}
    		
    		String referenciaFornecedor = leitura.getReferencia();
    		if (referenciaFornecedor.equals("Sem informações")) {
    			String referenciaFornecedorTexto = "";
    			textReferencia.setText(referenciaFornecedorTexto);	
			}
    		else {
    			textReferencia.setText(referenciaFornecedor);
			}
    		
    		String nomeFuncionarioTexto = leitura.getFuncionarioCadastro();
    		funcionarioCadastro.setText(nomeFuncionarioTexto);
    		
    		String cargoFuncionarioTexto = leitura.getCargoFuncionario();
    		cargoFuncionario.setText(cargoFuncionarioTexto);
    		
    		String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
    		codigoFuncionario.setText(codigoFuncionarioTexto);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaFornecedorEditar.add(panelBotoes, BorderLayout.SOUTH);
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
					textRazaoSocial.getText().isEmpty() || textRazaoSocial.getText().length() <= 0 ||
					textCNPJ.getText().replaceAll("\\.", "").replace("/","").replace("-","").trim().isEmpty() ||
					textCPF.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty() ||
					buttonGroupComercio.getSelection() == null) {	
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
					else {
						//Envia os dados para o banco de dados
						alterarCadastroFornecedor = new Fornecedor();
						alterarCadastroFornecedor.setNome(textNome.getText());
						alterarCadastroFornecedor.setRazaoSocial(textRazaoSocial.getText());
						alterarCadastroFornecedor.setCNPJ(textCNPJ.getText());
						alterarCadastroFornecedor.setCPF(textCPF.getText());
						
						if (textCEP.getText().replace("-","").trim().isEmpty()) {
							String cepTexto = "Sem informações";
							alterarCadastroFornecedor.setCEP(cepTexto);	
						}
						else {
							alterarCadastroFornecedor.setCEP(textCEP.getText());
						}
						
						if (textEndereco.getText().isEmpty() || textEndereco.getText().length() <= 0) {
							String enderecoTexto = "Sem informações";
							alterarCadastroFornecedor.setEndereco(enderecoTexto);
						}
						else {
							alterarCadastroFornecedor.setEndereco(textEndereco.getText());
						}
						
						if (textBairro.getText().isEmpty() || textBairro.getText().length() <= 0) {
							String bairroTexto = "Sem informações";
							alterarCadastroFornecedor.setBairro(bairroTexto);
						}
						else {
							alterarCadastroFornecedor.setBairro(textBairro.getText());
						}
						
						if (textNumero.getText().isEmpty() || textNumero.getText().length() <= 0) {
							String numeroTexto = "Sem informações";
							alterarCadastroFornecedor.setNumero(numeroTexto);
						}
						else {
							alterarCadastroFornecedor.setNumero(textNumero.getText());
						}
						
						if (textComplemento.getText().isEmpty() || textComplemento.getText().length() <= 0) {
							String fornecedorTexto = "Sem informações";
							alterarCadastroFornecedor.setComplemento(fornecedorTexto);
						}
						else {
							alterarCadastroFornecedor.setComplemento(textComplemento.getText());
						}
						
						
						if (textCidade.getText().isEmpty() || textCidade.getText().length() <= 0) {
							String cidadeTexto = "Sem informações";
							alterarCadastroFornecedor.setCidade(cidadeTexto);	
						}
						else {
							alterarCadastroFornecedor.setCidade(textCidade.getText());
						}
						
						if (textReferencia.getText().isEmpty() || textReferencia.getText().length() <= 0) {
							String referenciaTexto = "Sem informações";
							alterarCadastroFornecedor.setReferencia(referenciaTexto);
						}
						else {
							alterarCadastroFornecedor.setReferencia(textReferencia.getText());
						}
						
						if (textPaisOrigem.getText().isEmpty() || textPaisOrigem.getText().length() <= 0) {
							String paisOrigemTexto = "Sem informações";
							alterarCadastroFornecedor.setPais(paisOrigemTexto);
						}
						else {
							alterarCadastroFornecedor.setPais(textPaisOrigem.getText());
						}
						
						if (textNacionalidade.getText().isEmpty() || textNacionalidade.getText().length() <= 0) {
							String nacionalidadeTexto = "Sem informações";
							alterarCadastroFornecedor.setNacionalidade(nacionalidadeTexto);
						}
						else {
							alterarCadastroFornecedor.setNacionalidade(textNacionalidade.getText());
						}
						
						if (comboBoxEstado.getSelectedItem() == "Selecione um estado") {
							String estadoTexto = "Sem informações";
							alterarCadastroFornecedor.setEstado(estadoTexto);
						}
						else {
							alterarCadastroFornecedor.setEstado((String)(comboBoxEstado.getSelectedItem()));
						}
						
						if (comboBoxTipoFornecedor.getSelectedItem() == "Selecione") {
							String tipoFornecedorTexto = "Sem informações";
							alterarCadastroFornecedor.setTipoFornecedor(tipoFornecedorTexto);
						}
						else {
							alterarCadastroFornecedor.setTipoFornecedor((String)(comboBoxTipoFornecedor.getSelectedItem()));
						}
						
						if (checkBoxIsento.isSelected()) {
							isentoInscricaoEstadual = "Isento";
							alterarCadastroFornecedor.setInscricaoEstadual(isentoInscricaoEstadual);
							alterarCadastroFornecedor.setInscricaoNumero(textInscricaoNumero.getText());
						}
						else {
							isentoInscricaoEstadual = "Não isento";
							alterarCadastroFornecedor.setInscricaoEstadual(isentoInscricaoEstadual);
							alterarCadastroFornecedor.setInscricaoNumero(isentoInscricaoEstadual);
						}
						
						if (radioAtacado.isSelected()) {
							tipoComercio = radioAtacado.getText();
							alterarCadastroFornecedor.setTipoComercio(tipoComercio);
						}
						if (radioVarejo.isSelected()) {
							tipoComercio = radioVarejo.getText();
							alterarCadastroFornecedor.setTipoComercio(tipoComercio);
						}
						if (radioOutro.isSelected()) {
							tipoComercio = radioOutro.getText();
							alterarCadastroFornecedor.setTipoComercio(tipoComercio);
						}
						
						if (textEmail1.getText().isEmpty() || textEmail1.getText().length() <= 0){
							cadastroEmail1 = "Opcional";
							alterarCadastroFornecedor.setEmail1(cadastroEmail1);
						}
						else {
							alterarCadastroFornecedor.setEmail1(textEmail1.getText());
						}
						
						if (textEmail2.getText().isEmpty() || textEmail2.getText().length() <= 0){
							cadastroEmail2 = "Opcional";
							alterarCadastroFornecedor.setEmail2(cadastroEmail2);
						}
						else {
							alterarCadastroFornecedor.setEmail2(textEmail2.getText());
						}
						
						if (textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroTelefone1 = "Opcional";
							alterarCadastroFornecedor.setTelefone1(cadastroTelefone1);
						}
						else {
							cadastroTelefone1 = textTelefone1.getText();
							alterarCadastroFornecedor.setTelefone1(cadastroTelefone1);
						}
											
						if (textTelefone2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroTelefone2 = "Opcional";
							alterarCadastroFornecedor.setTelefone2(cadastroTelefone2);
						}
						else {
							cadastroTelefone2 = textTelefone2.getText();
							alterarCadastroFornecedor.setTelefone2(cadastroTelefone2);
						}
						
						if (textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroTelefone1 = "Opcional";
							alterarCadastroFornecedor.setCelular1(cadastroTelefone1);
						}
						else {
							alterarCadastroFornecedor.setCelular1(textCelular1.getText());
						}
						
						if (textCelular2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroTelefone2 = "Opcional";
							alterarCadastroFornecedor.setCelular2(cadastroTelefone2);
						}
						else {
							alterarCadastroFornecedor.setCelular2(textCelular2.getText());
						}
						
						/*Envia os dados para a classe que salva os dados no banco*/
						salvaNovosDados = new Dao_alterar_dados_fornecedor();
						salvaNovosDados.Altera_Dados_Fornecedor(alterarCadastroFornecedor);
												
						//Mensagem de confirmação do cadastro
						String menssagemConteudo = "Dados alterados com sucesso";
						Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
						mensagemConfirmacao.setVisible(true);
						
						Ficha_do_Fornecedor fichaFornecedor = new Ficha_do_Fornecedor();
						fichaFornecedor.setVisible(true);
						dispose();
					}
				
			}
		});
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(salvar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setToolTipText("Fecha a janela");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ficha_do_Fornecedor fichaFornecedor = new Ficha_do_Fornecedor();
				fichaFornecedor.setVisible(true);
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
                	Ficha_do_Fornecedor fichaFornecedor = new Ficha_do_Fornecedor();
    				fichaFornecedor.setVisible(true);
    				dispose();
                }
            }
	    );
	}
}