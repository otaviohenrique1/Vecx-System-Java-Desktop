package moduloAdministrativo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Loja_Cadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaCadastroLoja;
	private JTextField textEndereco, textBairro, textNumero, textComplemento, textCidade, textPaisOrigem, textNome, textRazaoSocial, textInscricaoNumero;
	private JTextField textEmail1, textEmail2, textReferencia, textNacionalidade;
	private JFormattedTextField textCNPJ, textCPF, textCEP, textTelefone1, textTelefone2, textCelular1, textCelular2;
	private JCheckBox checkBoxIsento;
	private final ButtonGroup buttonGroupComercio = new ButtonGroup();
	private JComboBox<String> comboBoxEstado;
	private JButton salvar, limpar, voltar;
	String tipoComercio, isentoInscricaoEstadual;
	String cadastroEmail1, cadastroEmail2, cadastroTelefone1, cadastroTelefone2, cadastroCelular1, cadastroCelular2;
	DadosLoja cadastrarLoja, alterarCadastroLoja;
	Dao_inserir_dados_loja salvaDados;
	Dao_alterar_dados_loja salvaNovosDados;
	Dao_consulta_dados_loja consultaDadosLoja;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loja_Cadastro frame = new Loja_Cadastro();
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
	public Loja_Cadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Loja_Cadastro.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(true);
		setSize(1000, 600);
		
		telaCadastroLoja = new JPanel();
		telaCadastroLoja.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaCadastroLoja.setLayout(new BorderLayout(0, 0));
		setContentPane(telaCadastroLoja);
		
		JPanel panelTitulo = new JPanel();
		telaCadastroLoja.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelTitulo2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel iconeCadastroLoja = new JLabel("");
		panelTitulo2.add(iconeCadastroLoja);
		iconeCadastroLoja.setIcon(new ImageIcon(Loja_Cadastro.class.getResource("/cImagens/Cadastro dados loja.PNG")));
		iconeCadastroLoja.setPreferredSize(new Dimension(30, 30));
		iconeCadastroLoja.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastroLoja.setFont(new Font("Tahoma", Font.PLAIN, 13));
		iconeCadastroLoja.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel labelCadastroLoja = new JLabel("Cadastro dos dados da Loja");
		panelTitulo2.add(labelCadastroLoja);
		labelCadastroLoja.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		Sessao sessao = Sessao.getInstance();
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
		fichaUsuario.setIcon(new ImageIcon(Loja_Cadastro.class.getResource("/cImagens/Funcionario.png")));
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
		telaCadastroLoja.add(scrollPaneCadastro, BorderLayout.CENTER);
		scrollPaneCadastro.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneCadastro.getHorizontalScrollBar().setUnitIncrement(10);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNome = new JPanel();
		panelNome.setPreferredSize(new Dimension(10, 50));
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCadastro.add(panelNome);
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
		
		JPanel panelRazaoSocial = new JPanel();
		panelRazaoSocial.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCadastro.add(panelRazaoSocial);
		panelRazaoSocial.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelRazaoSocial = new JLabel("Raz\u00E3o social");
		panelRazaoSocial.add(labelRazaoSocial);
		labelRazaoSocial.setHorizontalAlignment(SwingConstants.LEFT);
		labelRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textRazaoSocial = new JTextField();
		panelRazaoSocial.add(textRazaoSocial);
		textRazaoSocial.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textRazaoSocial.getText().isEmpty() || textRazaoSocial.getText().length() <= 0){
					labelRazaoSocial.setText("Razão social*");
					labelRazaoSocial.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelRazaoSocial.setText("Razão social");
				labelRazaoSocial.setForeground(Color.BLACK);
			}
		});
		textRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textRazaoSocial.setColumns(10);
		
		
		MaskFormatter numeroCNPJMascara = null;
		MaskFormatter numeroCPFMascara = null;
		try{
			numeroCNPJMascara = new MaskFormatter("##.###.###/####-#");
			numeroCPFMascara = new MaskFormatter("###.###.###-#");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
				
		JPanel panelCNPJ_CPF_InscEst = new JPanel();
		panelCadastro.add(panelCNPJ_CPF_InscEst);
		panelCNPJ_CPF_InscEst.setLayout(new GridLayout(0, 3, 5, 5));
		
		JPanel panelCNPJ = new JPanel();
		panelCNPJ.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCNPJ_CPF_InscEst.add(panelCNPJ);
		panelCNPJ.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCNPJ = new JLabel("CNPJ");
		panelCNPJ.add(labelCNPJ);
		labelCNPJ.setHorizontalAlignment(SwingConstants.LEFT);
		labelCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textCNPJ = new JFormattedTextField(numeroCNPJMascara);
		panelCNPJ.add(textCNPJ);
		textCNPJ.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCNPJ.getText().replaceAll("\\.", "").replace("/","").replace("-","").trim().isEmpty()){
					labelCNPJ.setText("CNPJ*");
					labelCNPJ.setForeground(Color.RED);
				}
				else {
					labelCNPJ.setText("CNPJ");
					labelCNPJ.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelCNPJ.setText("CNPJ");
				labelCNPJ.setForeground(Color.BLACK);
			}
		});
		textCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCNPJ.setColumns(10);
		
		JPanel panelCPF = new JPanel();
		panelCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCNPJ_CPF_InscEst.add(panelCPF);
		panelCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPF = new JLabel("CPF");
		panelCPF.add(labelCPF);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCPF.setHorizontalAlignment(SwingConstants.LEFT);
		
		textCPF = new JFormattedTextField(numeroCPFMascara);
		panelCPF.add(textCPF);
		
		JPanel panelInscricaoEstadual = new JPanel();
		panelCNPJ_CPF_InscEst.add(panelInscricaoEstadual);
		panelInscricaoEstadual.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelInscricaoEstadual.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelInscricaoEstadual = new JLabel("Inscri\u00E7\u00E3o estadual");
		panelInscricaoEstadual.add(labelInscricaoEstadual);
		labelInscricaoEstadual.setHorizontalAlignment(SwingConstants.LEFT);
		labelInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelInscricaoEstadual2 = new JPanel();
		panelInscricaoEstadual.add(panelInscricaoEstadual2);
		panelInscricaoEstadual2.setLayout(new BoxLayout(panelInscricaoEstadual2, BoxLayout.X_AXIS));
		
		checkBoxIsento = new JCheckBox("Isento");
		checkBoxIsento.setPreferredSize(new Dimension(80, 23));
		panelInscricaoEstadual2.add(checkBoxIsento);
		checkBoxIsento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textInscricaoNumero = new JTextField();
		panelInscricaoEstadual2.add(textInscricaoNumero);
		textInscricaoNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textInscricaoNumero.setColumns(10);
		textCPF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCPF.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty()){
					labelCPF.setText("CPF*");
					labelCPF.setForeground(Color.RED);
				}
				else {
					labelCPF.setText("CPF");
					labelCPF.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelCPF.setText("CPF");
				labelCPF.setForeground(Color.BLACK);
			}
		});
		
		MaskFormatter numeroTelefone1Mascara = null;
		MaskFormatter numeroTelefone2Mascara = null;
		MaskFormatter numeroCelular1Mascara = null;
		MaskFormatter numeroCelular2Mascara = null;
		try{
			numeroTelefone1Mascara = new MaskFormatter("(##)####-####");
			numeroTelefone2Mascara = new MaskFormatter("(##)####-####");
			numeroCelular1Mascara = new MaskFormatter("(##)#####-####");
			numeroCelular2Mascara = new MaskFormatter("(##)#####-####");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
				
		JPanel panelTelefone_Celular = new JPanel();
		panelCadastro.add(panelTelefone_Celular);
		panelTelefone_Celular.setLayout(new GridLayout(0, 4, 5, 5));
		
		JPanel panelTelefone1 = new JPanel();
		panelTelefone1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelTelefone1);
		panelTelefone1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTelefone1 = new JLabel("Telefone 1");
		panelTelefone1.add(labelTelefone1);
		labelTelefone1.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefone1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textTelefone1 = new JFormattedTextField(numeroTelefone1Mascara);
		panelTelefone1.add(textTelefone1);
		textTelefone1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
					labelTelefone1.setText("Telefone 1*");
					labelTelefone1.setForeground(Color.RED);
				}
				else {
					labelTelefone1.setText("Telefone 1");
					labelTelefone1.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelTelefone1.setText("Telefone 1");
				labelTelefone1.setForeground(Color.BLACK);
			}
		});
		textTelefone1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTelefone1.setColumns(10);
		
		JPanel panelTelefone2 = new JPanel();
		panelTelefone2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelTelefone2);
		panelTelefone2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTelefone2 = new JLabel("Telefone 2");
		panelTelefone2.add(labelTelefone2);
		labelTelefone2.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textTelefone2 = new JFormattedTextField(numeroTelefone2Mascara);
		panelTelefone2.add(textTelefone2);
		textTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTelefone2.setColumns(10);
		
		JPanel panelCelular1 = new JPanel();
		panelCelular1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelCelular1);
		panelCelular1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular1 = new JLabel("Celular 1");
		panelCelular1.add(labelCelular1);
		labelCelular1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textCelular1 = new JFormattedTextField(numeroCelular1Mascara);
		panelCelular1.add(textCelular1);
		textCelular1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
					labelCelular1.setText("Celular 1*");
					labelCelular1.setForeground(Color.RED);
				}
				else {
					labelCelular1.setText("Celular 1");
					labelCelular1.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelCelular1.setText("Celular 1");
				labelCelular1.setForeground(Color.BLACK);
			}
		});
		textCelular1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCelular1.setColumns(10);
		
		JPanel panelCelular2 = new JPanel();
		panelCelular2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelCelular2);
		panelCelular2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular2 = new JLabel("Celular 2");
		panelCelular2.add(labelCelular2);
		labelCelular2.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textCelular2 = new JFormattedTextField(numeroCelular2Mascara);
		panelCelular2.add(textCelular2);
		textCelular2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCelular2.setColumns(10);
		
		JPanel panelEmail = new JPanel();
		panelCadastro.add(panelEmail);
		panelEmail.setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panelEmail1 = new JPanel();
		panelEmail1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail.add(panelEmail1);
		panelEmail1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail1 = new JLabel("Email 1");
		panelEmail1.add(labelEmail1);
		labelEmail1.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textEmail1 = new JTextField();
		panelEmail1.add(textEmail1);
		textEmail1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textEmail1.getText().isEmpty() || textEmail1.getText().length() <= 0){
					labelEmail1.setText("Email 1*");
					labelEmail1.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelEmail1.setText("Email 1");
				labelEmail1.setForeground(Color.BLACK);
			}
		});
		textEmail1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEmail1.setColumns(10);
		
		JPanel panelEmail2 = new JPanel();
		panelEmail2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail.add(panelEmail2);
		panelEmail2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail2 = new JLabel("Email 2");
		panelEmail2.add(labelEmail2);
		labelEmail2.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textEmail2 = new JTextField();
		panelEmail2.add(textEmail2);
		textEmail2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEmail2.setColumns(10);
		
		JPanel panelNac_PaisOrigem = new JPanel();
		panelCadastro.add(panelNac_PaisOrigem);
		panelNac_PaisOrigem.setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panelNacionalidade = new JPanel();
		panelNacionalidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNac_PaisOrigem.add(panelNacionalidade);
		panelNacionalidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNacionalidade = new JLabel("Nacionalidade");
		panelNacionalidade.add(labelNacionalidade);
		labelNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textNacionalidade = new JTextField();
		panelNacionalidade.add(textNacionalidade);
		textNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNacionalidade.setColumns(10);
		
		JPanel panePaisOrigem = new JPanel();
		panePaisOrigem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNac_PaisOrigem.add(panePaisOrigem);
		panePaisOrigem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPaisOrigem = new JLabel("Pais");
		panePaisOrigem.add(labelPaisOrigem);
		labelPaisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		labelPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textPaisOrigem = new JTextField();
		panePaisOrigem.add(textPaisOrigem);
		textPaisOrigem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textPaisOrigem.getText().isEmpty() || textPaisOrigem.getText().length() <= 0){
					labelPaisOrigem.setText("Pais*");
					labelPaisOrigem.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelPaisOrigem.setText("Pais");
				labelPaisOrigem.setForeground(Color.BLACK);
			}
		});
		textPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPaisOrigem.setColumns(10);
		
		JPanel panelEstado_CEP_Cidade = new JPanel();
		panelCadastro.add(panelEstado_CEP_Cidade);
		panelEstado_CEP_Cidade.setLayout(new GridLayout(0, 3, 5, 5));
		
		JPanel panelEstado = new JPanel();
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstado_CEP_Cidade.add(panelEstado);
		panelEstado.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstado = new JLabel("Estado");
		panelEstado.add(labelEstado);
		labelEstado.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
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
		comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		MaskFormatter numeroCEPMascara = null;
		try{
			numeroCEPMascara = new MaskFormatter("#####-###");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		JPanel panelCEP = new JPanel();
		panelCEP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstado_CEP_Cidade.add(panelCEP);
		panelCEP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCEP = new JLabel("CEP");
		panelCEP.add(labelCEP);
		labelCEP.setHorizontalAlignment(SwingConstants.LEFT);
		labelCEP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textCEP = new JFormattedTextField(numeroCEPMascara);
		panelCEP.add(textCEP);
		textCEP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCEP.getText().replace("-","").trim().isEmpty()){
					labelCEP.setText("CEP*");
					labelCEP.setForeground(Color.RED);
				}
				else {
					labelCEP.setText("CEP");
					labelCEP.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelCEP.setText("CEP");
				labelCEP.setForeground(Color.BLACK);
			}
		});
		textCEP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCEP.setColumns(10);
		
		JPanel panelCidade = new JPanel();
		panelCidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstado_CEP_Cidade.add(panelCidade);
		panelCidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCidade = new JLabel("Cidade");
		panelCidade.add(labelCidade);
		labelCidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textCidade = new JTextField();
		panelCidade.add(textCidade);
		textCidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCidade.getText().isEmpty() || textCidade.getText().length() <= 0){
					labelCidade.setText("Cidade*");
					labelCidade.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelCidade.setText("Cidade");
				labelCidade.setForeground(Color.BLACK);
			}
		});
		textCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCidade.setColumns(10);
		
		JPanel panelEndereco = new JPanel();
		panelEndereco.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCadastro.add(panelEndereco);
		panelEndereco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o");
		panelEndereco.add(labelEndereco);
		labelEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textEndereco = new JTextField();
		panelEndereco.add(textEndereco);
		textEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEndereco.setColumns(10);
		
		JPanel panelNume_Comp_Bairro = new JPanel();
		panelCadastro.add(panelNume_Comp_Bairro);
		panelNume_Comp_Bairro.setLayout(new GridLayout(0, 3, 5, 5));
		
		JPanel panelNumero = new JPanel();
		panelNumero.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNume_Comp_Bairro.add(panelNumero);
		panelNumero.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNumero = new JLabel("Numero");
		panelNumero.add(labelNumero);
		labelNumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textNumero = new JTextField();
		panelNumero.add(textNumero);
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNumero.setColumns(10);
		
		JPanel panelComplemento = new JPanel();
		panelComplemento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNume_Comp_Bairro.add(panelComplemento);
		panelComplemento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComplemento = new JLabel("Complemento");
		panelComplemento.add(labelComplemento);
		labelComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComplemento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textComplemento = new JTextField();
		panelComplemento.add(textComplemento);
		textComplemento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textComplemento.setColumns(10);
		
		JPanel panelBairro = new JPanel();
		panelBairro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNume_Comp_Bairro.add(panelBairro);
		panelBairro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairro = new JLabel("Bairro");
		panelBairro.add(labelBairro);
		labelBairro.setHorizontalAlignment(SwingConstants.LEFT);
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textBairro = new JTextField();
		panelBairro.add(textBairro);
		textBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textBairro.setColumns(10);
		
		JPanel panelReferencia = new JPanel();
		panelReferencia.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCadastro.add(panelReferencia);
		panelReferencia.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelReferencia = new JLabel("Refer\u00EAncia");
		panelReferencia.add(labelReferencia);
		labelReferencia.setHorizontalAlignment(SwingConstants.LEFT);
		labelReferencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textReferencia = new JTextField();
		panelReferencia.add(textReferencia);
		textReferencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textReferencia.setColumns(10);
		
		JPanel panelBotoes = new JPanel();
		telaCadastroLoja.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelLegenda = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelLegenda.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		panelBotoes.add(panelLegenda, BorderLayout.WEST);
		
		JLabel labelLegenda = new JLabel("Legenda: (*) Campo importante que deve ser preenchido");
		labelLegenda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelLegenda.add(labelLegenda);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2, BorderLayout.CENTER);
		
		salvar = new JButton("Salvar");
		salvar.setToolTipText("Salva o cadastro do fornecedor");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNome.getText().isEmpty() || textNome.getText().length() <= 0 ||
					textRazaoSocial.getText().isEmpty() || textRazaoSocial.getText().length() <= 0 ||
					textCNPJ.getText().replaceAll("\\.", "").replace("/","").replace("-","").trim().isEmpty() ||
					textCPF.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty() ||
					textEndereco.getText().isEmpty() || textEndereco.getText().length() <= 0 ||
					textBairro.getText().isEmpty() || textBairro.getText().length() <= 0 ||
					textNumero.getText().isEmpty() || textNumero.getText().length() <= 0 ||
					textComplemento.getText().isEmpty() || textComplemento.getText().length() <= 0 ||
					textCidade.getText().isEmpty() || textCidade.getText().length() <= 0 ||
					textReferencia.getText().isEmpty() || textReferencia.getText().length() <= 0 ||
					textCEP.getText().replace("-","").trim().isEmpty() ||
					textPaisOrigem.getText().isEmpty() || textPaisOrigem.getText().length() <= 0) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					cadastrarLoja = new DadosLoja();
					cadastrarLoja.setNome(textNome.getText());
					cadastrarLoja.setRazaoSocial(textRazaoSocial.getText());
					cadastrarLoja.setCNPJ(textCNPJ.getText());
					cadastrarLoja.setCEP(textCEP.getText());
					cadastrarLoja.setEndereco(textEndereco.getText());
					cadastrarLoja.setBairro(textBairro.getText());
					cadastrarLoja.setNumero(textNumero.getText());
					cadastrarLoja.setComplemento(textComplemento.getText());
					cadastrarLoja.setCidade(textCidade.getText());
					cadastrarLoja.setReferencia(textReferencia.getText());
					cadastrarLoja.setCPF(textCPF.getText());
					cadastrarLoja.setPais(textPaisOrigem.getText());
					cadastrarLoja.setNacionalidade(textNacionalidade.getText());
					cadastrarLoja.setEstado((String)(comboBoxEstado.getSelectedItem()));
					
					try {
						java.util.Date dataRegistro = new java.util.Date();
						SimpleDateFormat dataRegistroFormato = new SimpleDateFormat("dd/MM/yyyy");
						String dataCadastroFuncionario = dataRegistroFormato.format(dataRegistro);
						SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
						Date dataCadastro = new java.sql.Date(dataCadastroFormato.parse(dataCadastroFuncionario).getTime());
						cadastrarLoja.setDataCadastro(dataCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
					}
					
					try {
						java.util.Date horaRegistro = new java.util.Date();
						SimpleDateFormat horaRegistroFormato = new SimpleDateFormat("HH:mm");
						String horaCadastroFuncionario = horaRegistroFormato.format(horaRegistro);
						SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
						Time horaCadastro = new java.sql.Time(horaCadastroFormato.parse(horaCadastroFuncionario).getTime());
						cadastrarLoja.setHoraCadastro(horaCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
					}
					
					if (checkBoxIsento.isSelected()) {
						isentoInscricaoEstadual = "Isento";
						cadastrarLoja.setInscricaoEstadual(isentoInscricaoEstadual);
						cadastrarLoja.setInscricaoNumero(textInscricaoNumero.getText());
					}
					else {
						isentoInscricaoEstadual = "Não isento";
						cadastrarLoja.setInscricaoEstadual(isentoInscricaoEstadual);
					}
					
					if (textEmail1.getText().isEmpty() || textEmail1.getText().length() <= 0){
						cadastroEmail1 = "Opcional";
						cadastrarLoja.setEmail1(cadastroEmail1);
					}
					else {
						cadastrarLoja.setEmail1(textEmail1.getText());
					}
					
					if (textEmail2.getText().isEmpty() || textEmail2.getText().length() <= 0){
						cadastroEmail2 = "Opcional";
						cadastrarLoja.setEmail2(cadastroEmail2);
					}
					else {
						cadastrarLoja.setEmail2(textEmail2.getText());
					}
					
					if (textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone1 = "Opcional";
						cadastrarLoja.setTelefone1(cadastroTelefone1);
					}
					else {
						cadastroTelefone1 = textTelefone1.getText();
						cadastrarLoja.setTelefone1(cadastroTelefone1);
					}
										
					if (textTelefone2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone2 = "Opcional";
						cadastrarLoja.setTelefone2(cadastroTelefone2);
					}
					else {
						cadastroTelefone2 = textTelefone2.getText();
						cadastrarLoja.setTelefone2(cadastroTelefone2);
					}
					
					if (textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone1 = "Opcional";
						cadastrarLoja.setCelular1(cadastroTelefone1);
					}
					else {
						cadastrarLoja.setCelular1(textCelular1.getText());
					}
					
					if (textCelular2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone2 = "Opcional";
						cadastrarLoja.setCelular2(cadastroTelefone2);
					}
					else {
						cadastrarLoja.setCelular2(textCelular2.getText());
					}
					
					String estadoDadosLojaTexto = "Ativo";
					cadastrarLoja.setEstadoDadosLoja(estadoDadosLojaTexto);
					
					/*Envia os dados para a classe que salva os dados no banco*/
					salvaDados = new Dao_inserir_dados_loja();
					salvaDados.Inserir_Dados_Loja(cadastrarLoja);
					
					//Mensagem de confirmação do cadastro
					String menssagemConteudo = "Dados cadastrados com sucesso";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
					
					//Limpa os campos depois que o cadastro é realizado
					textCEP.setText("");
					textEndereco.setText("");
					textBairro.setText("");
					textNumero.setText("");
					textComplemento.setText("");
					textCidade.setText("");
					textPaisOrigem.setText("");
					textNome.setText("");
					textRazaoSocial.setText("");
					textCNPJ.setText("");
					textCPF.setText("");
					textInscricaoNumero.setText("");
					textTelefone1.setText("");
					textTelefone2.setText("");
					textCelular1.setText("");
					textCelular2.setText("");
					textEmail1.setText("");
					textEmail2.setText("");
					textNacionalidade.setText("");
					textReferencia.setText("");
					checkBoxIsento.setSelected(false);
					comboBoxEstado.setSelectedItem("Selecione um estado");
					buttonGroupComercio.clearSelection();
					labelNome.setText("Nome");
					labelNome.setForeground(Color.BLACK);
					labelRazaoSocial.setText("Razão social");
					labelRazaoSocial.setForeground(Color.BLACK);
					labelCNPJ.setText("CNPJ");
					labelCNPJ.setForeground(Color.BLACK);
					labelCelular1.setText("Celular 1");
					labelCelular1.setForeground(Color.BLACK);
					labelTelefone1.setText("Telefone 1");
					labelTelefone1.setForeground(Color.BLACK);
					labelEmail1.setText("Email 1");
					labelEmail1.setForeground(Color.BLACK);
					labelCidade.setText("Cidade");
					labelCidade.setForeground(Color.BLACK);
					labelPaisOrigem.setText("Pais");
					labelPaisOrigem.setForeground(Color.BLACK);
				}
			}
		});
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(salvar);
		
		limpar = new JButton("Limpar");
		limpar.setToolTipText("Limpa os campos do cadastro");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menssagemConteudo = "Deseja limpar os campos ?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo avisoLimparCampos = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemConteudo);
				avisoLimparCampos.setVisible(true);
				String avisoLimparCamposTexto = avisoLimparCampos.getResposta();
				if (avisoLimparCamposTexto != null) {
					if (avisoLimparCamposTexto.equals("Sim")) {
						textCEP.setText("");
						textEndereco.setText("");
						textBairro.setText("");
						textNumero.setText("");
						textCPF.setText("");
						textComplemento.setText("");
						textCidade.setText("");
						textPaisOrigem.setText("");
						textNome.setText("");
						textRazaoSocial.setText("");
						textCNPJ.setText("");
						textInscricaoNumero.setText("");
						textTelefone1.setText("");
						textTelefone2.setText("");
						textCelular1.setText("");
						textCelular2.setText("");
						textEmail1.setText("");
						textEmail2.setText("");
						textReferencia.setText("");
						checkBoxIsento.setSelected(false);
						buttonGroupComercio.clearSelection();
						comboBoxEstado.setSelectedItem("Selecione um estado");
						labelNome.setText("Nome");
						labelNome.setForeground(Color.BLACK);
						labelRazaoSocial.setText("Razão social");
						labelRazaoSocial.setForeground(Color.BLACK);
						labelCNPJ.setText("CNPJ");
						labelCNPJ.setForeground(Color.BLACK);
						labelCelular1.setText("Celular 1");
						labelCelular1.setForeground(Color.BLACK);
						labelTelefone1.setText("Telefone 1");
						labelTelefone1.setForeground(Color.BLACK);
						labelEmail1.setText("Email 1");
						labelEmail1.setForeground(Color.BLACK);
						labelCidade.setText("Cidade");
						labelCidade.setForeground(Color.BLACK);
						labelPaisOrigem.setText("Pais");
						labelPaisOrigem.setForeground(Color.BLACK);
					}
				}
			}
		});
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(limpar);
		
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