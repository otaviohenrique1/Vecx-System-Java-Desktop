package moduloClienteTelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloClienteBD.Cliente;
import moduloClienteBD.Dao_inserir_dados_cliente;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Cadastro_de_Cliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaCadastroCliente;
	private JTextField textNome, textEmail1, textEmail2, textEndereco, textBairro, textNumero, textComplemento;
	private JTextField  textCidade, textReferencia, textNacionalidade, textPaisOrigem;
	private JFormattedTextField textRG, textCPF, textTelefone1, textTelefone2, textCelular1, textCelular2, textCEP;
	private JFormattedTextField textDataNascimento;
	private JComboBox<String> comboBoxEstado;
	private final ButtonGroup buttonGroupSexo = new ButtonGroup();
	private final ButtonGroup buttonGroupEstadoCivil = new ButtonGroup();
	private JRadioButton radioMasculino, radioFeminino, radioSolteiro, radioCasado, radioOutros;
	private JButton salvar, limpar, voltar;
	Cliente cadastrarCliente;
	String dataNascimentoCliente, sexoCliente, estadoCivilCliente, cadastroReferencia;
	String cadastroEmail1, cadastroEmail2, cadastroTelefone1, cadastroTelefone2, cadastroCelular1, cadastroCelular2;
	SimpleDateFormat dataFormato;
	Date data;
	Dao_inserir_dados_cliente salvaDados;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_de_Cliente frame = new Cadastro_de_Cliente();
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
	public Cadastro_de_Cliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro_de_Cliente.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(true);
		setSize(1000, 600);
		
		telaCadastroCliente = new JPanel();
		telaCadastroCliente.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaCadastroCliente.setLayout(new BorderLayout(50, 10));
		setContentPane(telaCadastroCliente);
		
		JPanel panelTitulo = new JPanel();
		telaCadastroCliente.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelTitulo2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel iconeCadastroCliente = new JLabel("");
		panelTitulo2.add(iconeCadastroCliente);
		iconeCadastroCliente.setIcon(new ImageIcon(Cadastro_de_Cliente.class.getResource("/cImagens/Cadastro usuario.png")));
		iconeCadastroCliente.setPreferredSize(new Dimension(30, 30));
		iconeCadastroCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		iconeCadastroCliente.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel tituloCadastroCliente = new JLabel("Cadastro de Cliente");
		panelTitulo2.add(tituloCadastroCliente);
		tituloCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Cadastro_de_Cliente.class.getResource("/cImagens/Funcionario.png")));
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
		telaCadastroCliente.add(scrollPaneCadastro, BorderLayout.CENTER);
		scrollPaneCadastro.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneCadastro.getHorizontalScrollBar().setUnitIncrement(10);
		
		MaskFormatter numeroRGMascara = null;
		MaskFormatter numeroCPFMascara = null;
		MaskFormatter numeroTelefone1Mascara = null;
		MaskFormatter numeroTelefone2Mascara = null;
		MaskFormatter numeroCelular1Mascara = null;
		MaskFormatter numeroCelular2Mascara = null;
		MaskFormatter dataMascara = null;
		MaskFormatter numeroCEPMascara = null;
		try{
			numeroRGMascara = new MaskFormatter("##.###.###-#");
			numeroCPFMascara = new MaskFormatter("###.###.###-#");
			numeroTelefone1Mascara = new MaskFormatter("(##)####-####");
			numeroTelefone2Mascara = new MaskFormatter("(##)####-####");
			numeroCelular1Mascara = new MaskFormatter("(##)#####-####");
			numeroCelular2Mascara = new MaskFormatter("(##)#####-####");
			dataMascara = new MaskFormatter("##/##/####");
			numeroCEPMascara = new MaskFormatter("#####-###");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNome_RG_CPF = new JPanel();
		panelCadastro.add(panelNome_RG_CPF);
		panelNome_RG_CPF.setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panelNome = new JPanel();
		panelNome_RG_CPF.add(panelNome);
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
			public void focusLost(FocusEvent arg0) {
				if (textNome.getText().isEmpty() || textNome.getText().length() <= 0){
					labelNome.setText("Nome*");
					labelNome.setForeground(Color.RED);
				}
				else {
					labelNome.setText("Nome");
					labelNome.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				labelNome.setText("Nome");
				labelNome.setForeground(Color.BLACK);
			}
		});
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNome.setColumns(10);
		
		JPanel panelRG_CPF = new JPanel();
		panelNome_RG_CPF.add(panelRG_CPF);
		panelRG_CPF.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCPF = new JPanel();
		panelRG_CPF.add(panelCPF);
		panelCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelRG = new JLabel("RG");
		panelCPF.add(labelRG);
		labelRG.setHorizontalAlignment(SwingConstants.LEFT);
		labelRG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textRG = new JFormattedTextField(numeroRGMascara);
		panelCPF.add(textRG);
		textRG.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textRG.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty()){
					labelRG.setText("RG*");
					labelRG.setForeground(Color.RED);
				}
				else {
					labelRG.setText("RG");
					labelRG.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelRG.setText("RG");
				labelRG.setForeground(Color.BLACK);
			}
		});
		textRG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textRG.setColumns(10);
		
		JPanel panelRG = new JPanel();
		panelRG_CPF.add(panelRG);
		panelRG.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRG.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPF = new JLabel("CPF");
		panelRG.add(labelCPF);
		labelCPF.setHorizontalAlignment(SwingConstants.LEFT);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textCPF = new JFormattedTextField(numeroCPFMascara);
		panelRG.add(textCPF);
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
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCPF.setColumns(10);
		
		JPanel panelData_Sexo_EstadoCivil = new JPanel();
		panelCadastro.add(panelData_Sexo_EstadoCivil);
		panelData_Sexo_EstadoCivil.setLayout(new GridLayout(0, 3, 5, 5));
		
		JPanel panelDataNascimento = new JPanel();
		panelDataNascimento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_Sexo_EstadoCivil.add(panelDataNascimento);
		panelDataNascimento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataNascimento = new JLabel("Data de nascimento");
		panelDataNascimento.add(labelDataNascimento);
		labelDataNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textDataNascimento = new JFormattedTextField(dataMascara);
		panelDataNascimento.add(textDataNascimento);
		textDataNascimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textDataNascimento.getText().replaceAll("\\/", "").trim().isEmpty()){
					labelDataNascimento.setText("Data de nascimento*");
					labelDataNascimento.setForeground(Color.RED);
				}
				else {
					labelDataNascimento.setText("Data de nascimento");
					labelDataNascimento.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelDataNascimento.setText("Data de nascimento");
				labelDataNascimento.setForeground(Color.BLACK);
			}
		});
		textDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDataNascimento.setColumns(10);
		
		JPanel panelSexo = new JPanel();
		panelSexo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_Sexo_EstadoCivil.add(panelSexo);
		panelSexo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSexo = new JLabel("Sexo");
		panelSexo.add(labelSexo);
		labelSexo.setHorizontalAlignment(SwingConstants.LEFT);
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelSexo2 = new JPanel();
		FlowLayout fl_panelSexo2 = (FlowLayout) panelSexo2.getLayout();
		fl_panelSexo2.setAlignment(FlowLayout.LEFT);
		fl_panelSexo2.setVgap(0);
		fl_panelSexo2.setHgap(0);
		panelSexo.add(panelSexo2);
		
		radioMasculino = new JRadioButton("Masculino");
		buttonGroupSexo.add(radioMasculino);
		radioMasculino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelSexo2.add(radioMasculino);
		
		radioFeminino = new JRadioButton("Feminino");
		buttonGroupSexo.add(radioFeminino);
		radioFeminino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelSexo2.add(radioFeminino);
		
		JPanel panelEstadoCivil = new JPanel();
		panelEstadoCivil.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_Sexo_EstadoCivil.add(panelEstadoCivil);
		panelEstadoCivil.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstadoCivil = new JLabel("Estado civil");
		panelEstadoCivil.add(labelEstadoCivil);
		labelEstadoCivil.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelEstadoCivil2 = new JPanel();
		FlowLayout fl_panelEstadoCivil2 = (FlowLayout) panelEstadoCivil2.getLayout();
		fl_panelEstadoCivil2.setAlignment(FlowLayout.LEFT);
		fl_panelEstadoCivil2.setVgap(0);
		fl_panelEstadoCivil2.setHgap(0);
		panelEstadoCivil.add(panelEstadoCivil2);
		
		radioSolteiro = new JRadioButton("Solteiro");
		buttonGroupEstadoCivil.add(radioSolteiro);
		radioSolteiro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEstadoCivil2.add(radioSolteiro);
		
		radioCasado = new JRadioButton("Casado");
		buttonGroupEstadoCivil.add(radioCasado);
		radioCasado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEstadoCivil2.add(radioCasado);
		
		radioOutros = new JRadioButton("Outros");
		buttonGroupEstadoCivil.add(radioOutros);
		radioOutros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEstadoCivil2.add(radioOutros);
		
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
		
		JLabel labelEmail1 = new JLabel("Email1");
		panelEmail1.add(labelEmail1);
		labelEmail1.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textEmail1 = new JTextField();
		panelEmail1.add(textEmail1);
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
		labelNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNacionalidade.add(labelNacionalidade);
		
		textNacionalidade = new JTextField();
		textNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNacionalidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textNacionalidade.getText().isEmpty() || textNacionalidade.getText().length() <= 0){
					labelNacionalidade.setText("Nacionalidade*");
					labelNacionalidade.setForeground(Color.RED);
				}
				else {
					labelNacionalidade.setText("Nacionalidade");
					labelNacionalidade.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelNacionalidade.setText("Nacionalidade");
				labelNacionalidade.setForeground(Color.BLACK);
			}
		});
		textNacionalidade.setColumns(10);
		panelNacionalidade.add(textNacionalidade);
		
		JPanel panelPaisOrigem = new JPanel();
		panelPaisOrigem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNac_PaisOrigem.add(panelPaisOrigem);
		panelPaisOrigem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPaisOrigem = new JLabel("Pais de origem");
		labelPaisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		labelPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelPaisOrigem.add(labelPaisOrigem);
		
		textPaisOrigem = new JTextField();
		textPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPaisOrigem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textPaisOrigem.getText().isEmpty() || textPaisOrigem.getText().length() <= 0){
					labelPaisOrigem.setText("Pais de origem*");
					labelPaisOrigem.setForeground(Color.RED);
				}
				else {
					labelPaisOrigem.setText("Pais de origem");
					labelPaisOrigem.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelPaisOrigem.setText("Pais de origem");
				labelPaisOrigem.setForeground(Color.BLACK);
			}
		});
		textPaisOrigem.setColumns(10);
		panelPaisOrigem.add(textPaisOrigem);
		
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
		comboBoxEstado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (comboBoxEstado.getSelectedItem() == "Selecione um estado"){
					labelEstado.setText("Estado*");
					labelEstado.setForeground(Color.RED);
				}
				else {
					labelEstado.setText("Estado");
					labelEstado.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelEstado.setText("Estado");
				labelEstado.setForeground(Color.BLACK);
			}
		});
		
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
				else {
					labelCidade.setText("Cidade");
					labelCidade.setForeground(Color.BLACK);
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
		textEndereco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textEndereco.getText().isEmpty() || textEndereco.getText().length() <= 0){
					labelEndereco.setText("Endereço*");
					labelEndereco.setForeground(Color.RED);
				}
				else {
					labelEndereco.setText("Endereço");
					labelEndereco.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelEndereco.setText("Endereço");
				labelEndereco.setForeground(Color.BLACK);
			}
		});
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
		textNumero.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textNumero.getText().isEmpty() || textNumero.getText().length() <= 0){
					labelNumero.setText("Numero*");
					labelNumero.setForeground(Color.RED);
				}
				else {
					labelNumero.setText("Numero");
					labelNumero.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelNumero.setText("Numero");
				labelNumero.setForeground(Color.BLACK);
			}
		});
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNumero.setColumns(10);
		
		JPanel panelComplemento = new JPanel();
		panelNume_Comp_Bairro.add(panelComplemento);
		panelComplemento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComplemento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComplemento = new JLabel("Complemento");
		panelComplemento.add(labelComplemento);
		labelComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComplemento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textComplemento = new JTextField();
		panelComplemento.add(textComplemento);
		textComplemento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textComplemento.getText().isEmpty() || textComplemento.getText().length() <= 0){
					labelComplemento.setText("Complemento*");
					labelComplemento.setForeground(Color.RED);
				}
				else {
					labelComplemento.setText("Complemento");
					labelComplemento.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelComplemento.setText("Complemento");
				labelComplemento.setForeground(Color.BLACK);
			}
		});
		textComplemento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textComplemento.setColumns(10);
		
		JPanel panelBairro = new JPanel();
		panelNume_Comp_Bairro.add(panelBairro);
		panelBairro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelBairro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairro = new JLabel("Bairro");
		panelBairro.add(labelBairro);
		labelBairro.setHorizontalAlignment(SwingConstants.LEFT);
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textBairro = new JTextField();
		panelBairro.add(textBairro);
		textBairro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textBairro.getText().isEmpty() || textBairro.getText().length() <= 0){
					labelBairro.setText("Bairro*");
					labelBairro.setForeground(Color.RED);
				}
				else {
					labelBairro.setText("Bairro");
					labelBairro.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelBairro.setText("Bairro");
				labelBairro.setForeground(Color.BLACK);
			}
		});
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
		telaCadastroCliente.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelLegenda = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelLegenda.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		panelBotoes.add(panelLegenda, BorderLayout.WEST);
		
		JLabel labelLegenda = new JLabel("Legenda: (*) Campo importante que deve ser preenchido");
		panelLegenda.add(labelLegenda);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		salvar = new JButton("Salvar");
		salvar.setToolTipText("Salva o cadastro do cliente");
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textNome.getText().isEmpty() || textNome.getText().length() <= 0 ||
					textRG.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty() ||
					textCPF.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty() ||
					textDataNascimento.getText().replaceAll("\\/", "").trim().isEmpty() ||
					textEndereco.getText().isEmpty() || textEndereco.getText().length() <= 0 ||
					textBairro.getText().isEmpty() || textBairro.getText().length() <= 0 ||
					textNumero.getText().isEmpty() || textNumero.getText().length() <= 0 ||
					textComplemento.getText().isEmpty() || textComplemento.getText().length() <= 0 ||
					textCidade.getText().isEmpty() || textCidade.getText().length() <= 0 ||
					textCEP.getText().replace("-","").trim().isEmpty() ||
					textNacionalidade.getText().isEmpty() || textNacionalidade.getText().length() <= 0 ||
					textPaisOrigem.getText().isEmpty() || textPaisOrigem.getText().length() <= 0 ||
					comboBoxEstado.getSelectedItem() == "Selecione um estado" ||
					buttonGroupSexo.getSelection() == null ||
					buttonGroupEstadoCivil.getSelection() == null) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					//Envia os dados para o banco de dados
					cadastrarCliente = new Cliente();
					cadastrarCliente.setNome(textNome.getText());
					
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
					cadastrarCliente.setCodigoCliente(codigoRegistro);
					
					cadastrarCliente.setRG(textRG.getText());
					cadastrarCliente.setCPF(textCPF.getText());
					cadastrarCliente.setCEP(textCEP.getText());
					cadastrarCliente.setEndereco(textEndereco.getText());
					cadastrarCliente.setBairro(textBairro.getText());
					cadastrarCliente.setNumero(textNumero.getText());
					cadastrarCliente.setComplemento(textComplemento.getText());
					cadastrarCliente.setCidade(textCidade.getText());
					cadastrarCliente.setReferencia(textReferencia.getText());
					cadastrarCliente.setCPF(textCPF.getText());
					cadastrarCliente.setEstado((String)(comboBoxEstado.getSelectedItem()));
					cadastrarCliente.setNacionalidade(textNacionalidade.getText());
					cadastrarCliente.setPaisOrigem(textPaisOrigem.getText());
					
					try {
						java.util.Date dataRegistro = new java.util.Date();
						SimpleDateFormat dataRegistroFormato = new SimpleDateFormat("dd/MM/yyyy");
						String dataCadastroFuncionario = dataRegistroFormato.format(dataRegistro);
						SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
						Date dataCadastro = new java.sql.Date(dataCadastroFormato.parse(dataCadastroFuncionario).getTime());
						cadastrarCliente.setDataCadastro(dataCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
					}
					
					try {
						java.util.Date horaRegistro = new java.util.Date();
						SimpleDateFormat horaRegistroFormato = new SimpleDateFormat("HH:mm");
						String horaCadastroFuncionario = horaRegistroFormato.format(horaRegistro);
						SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
						Time horaCadastro = new java.sql.Time(horaCadastroFormato.parse(horaCadastroFuncionario).getTime());
						cadastrarCliente.setHoraCadastro(horaCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
					}
					
					/*Cadastro do nome do funcionario*/
					if (nomeUsuario == null) {
						String nomeFuncionario = "Nome";
						cadastrarCliente.setFuncionarioCadastro(nomeFuncionario);
					}
					else {
						cadastrarCliente.setFuncionarioCadastro(nomeUsuario);
					}
					
					/*Cadastro do codigo do funcionario*/
					if (codigoUsuario == null) {
						String codigoFuncionario = "Codigo";
						cadastrarCliente.setCodigoFuncionario(codigoFuncionario);
					}
					else {
						cadastrarCliente.setCodigoFuncionario(codigoUsuario);
					}
					
					/*Cadastro do cargo do funcionario*/
					if (cargoUsuario == null) {
						String cargoFuncionario = "Cargo";
						cadastrarCliente.setCargoFuncionario(cargoFuncionario);
					}
					else {
						cadastrarCliente.setCargoFuncionario(cargoUsuario);
					}
					
					
					if (textReferencia.getText().isEmpty() || textReferencia.getText().length() <= 0){
						cadastroReferencia = "Opcional";
						cadastrarCliente.setReferencia(cadastroReferencia);
					}
					else {
						cadastrarCliente.setReferencia(textReferencia.getText());
					}
					
					dataNascimentoCliente = textDataNascimento.getText();
					try {
						dataFormato = new SimpleDateFormat("dd/MM/yyyy");
						data = new java.sql.Date(dataFormato.parse(dataNascimentoCliente).getTime());
						cadastrarCliente.setDataNascimento(data);
					} catch (ParseException e) {
						e.printStackTrace();
					}
										
					if (radioMasculino.isSelected()) {
						sexoCliente = radioMasculino.getText();
						cadastrarCliente.setSexo(sexoCliente);
					}
					if (radioFeminino.isSelected()) {
						sexoCliente = radioFeminino.getText();
						cadastrarCliente.setSexo(sexoCliente);
					}
					if (radioSolteiro.isSelected()) {
						estadoCivilCliente = radioSolteiro.getText();
						cadastrarCliente.setEstadoCivil(estadoCivilCliente);
					}
					if (radioCasado.isSelected()) {
						estadoCivilCliente = radioCasado.getText();
						cadastrarCliente.setEstadoCivil(estadoCivilCliente);
					}
					if (radioOutros.isSelected()) {
						estadoCivilCliente = radioOutros.getText();
						cadastrarCliente.setEstadoCivil(estadoCivilCliente);
					}
					
					if (textEmail1.getText().isEmpty() || textEmail1.getText().length() <= 0){
						cadastroEmail1 = "Opcional";
						cadastrarCliente.setEmail1(cadastroEmail1);
					}
					else {
						cadastrarCliente.setEmail1(textEmail1.getText());
					}
					
					if (textEmail2.getText().isEmpty() || textEmail2.getText().length() <= 0){
						cadastroEmail2 = "Opcional";
						cadastrarCliente.setEmail2(cadastroEmail2);
					}
					else {
						cadastrarCliente.setEmail2(textEmail2.getText());
					}
					
					if (textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone1 = "Opcional";
						cadastrarCliente.setTelefone1(cadastroTelefone1);
					}
					else {
						cadastroTelefone1 = textTelefone1.getText();
						cadastrarCliente.setTelefone1(cadastroTelefone1);
					}
										
					if (textTelefone2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone2 = "Opcional";
						cadastrarCliente.setTelefone2(cadastroTelefone2);
					}
					else {
						cadastroTelefone2 = textTelefone2.getText();
						cadastrarCliente.setTelefone2(cadastroTelefone2);
					}
					
					if (textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone1 = "Opcional";
						cadastrarCliente.setCelular1(cadastroTelefone1);
					}
					else {
						cadastrarCliente.setCelular1(textCelular1.getText());
					}
					
					if (textCelular2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone2 = "Opcional";
						cadastrarCliente.setCelular2(cadastroTelefone2);
					}
					else {
						cadastrarCliente.setCelular2(textCelular2.getText());
					}
					
					/*Envia os dados para a classe que salva os dados no banco*/
					salvaDados = new Dao_inserir_dados_cliente();
					salvaDados.Inserir_Dados_Cliente(cadastrarCliente);
					
					//Mensagem de confirmação do cadastro
					String menssagemConteudo = "Dados cadastrados com sucesso";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
					
					//Limpa os campos depois que o cadastro é realizado
					textNome.setText("");
					textRG.setText("");
					textTelefone1.setText("");
					textTelefone2.setText("");
					textCelular1.setText("");
					textCelular2.setText("");
					textEmail1.setText("");
					textEmail2.setText("");
					textCEP.setText("");
					textEndereco.setText("");
					textBairro.setText("");
					textNumero.setText("");
					textComplemento.setText("");
					textCidade.setText("");
					textReferencia.setText("");
					textCPF.setText("");
					textNacionalidade.setText("");
					textPaisOrigem.setText("");
					textDataNascimento.setText("");
					buttonGroupSexo.clearSelection();
					buttonGroupEstadoCivil.clearSelection();
					comboBoxEstado.setSelectedItem("Selecione um estado");
					labelNome.setText("Nome");
					labelNome.setForeground(Color.BLACK);
					labelCPF.setText("CPF");
					labelCPF.setForeground(Color.BLACK);
					labelDataNascimento.setText("Data de nascimento");
					labelDataNascimento.setForeground(Color.BLACK);
					labelCelular1.setText("Celular 1");
					labelCelular1.setForeground(Color.BLACK);
					labelCelular2.setText("Celular 2");
					labelCelular2.setForeground(Color.BLACK);
					labelRG.setText("RG");
					labelRG.setForeground(Color.BLACK);
					labelCEP.setText("CEP");
					labelCEP.setForeground(Color.BLACK);
					labelTelefone1.setText("Telefone 1");
					labelTelefone1.setForeground(Color.BLACK);
					labelTelefone2.setText("Telefone 2");
					labelTelefone2.setForeground(Color.BLACK);
					labelNacionalidade.setText("Nacionalidade");
					labelNacionalidade.setForeground(Color.BLACK);
					labelPaisOrigem.setText("Pais de origem");
					labelPaisOrigem.setForeground(Color.BLACK);
					labelCidade.setText("Cidade");
					labelCidade.setForeground(Color.BLACK);
					labelBairro.setText("Bairro");
					labelBairro.setForeground(Color.BLACK);
					labelComplemento.setText("Complemento");
					labelComplemento.setForeground(Color.BLACK);
					labelEndereco.setText("Endereço");
					labelEndereco.setForeground(Color.BLACK);
					labelReferencia.setText("Referencia");
					labelReferencia.setForeground(Color.BLACK);
					labelNumero.setText("Numero");
					labelNumero.setForeground(Color.BLACK);
				}
			}
		});
		panelBotoes2.add(salvar);
		
		limpar = new JButton("Limpar");
		limpar.setToolTipText("Limpa os campos do cadastro");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menssagemConteudo = "Deseja limpar os campos?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo avisoLimparCampos = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemConteudo);
				avisoLimparCampos.setVisible(true);
				String avisoLimparCamposTexto = avisoLimparCampos.getResposta();
				if (avisoLimparCamposTexto != null) {
					if (avisoLimparCamposTexto.equals("Sim")) {
						textNome.setText("");
						textRG.setText("");
						textTelefone1.setText("");
						textTelefone2.setText("");
						textCelular1.setText("");
						textCelular2.setText("");
						textEmail1.setText("");
						textEmail2.setText("");
						textCEP.setText("");
						textEndereco.setText("");
						textBairro.setText("");
						textNumero.setText("");
						textComplemento.setText("");
						textCidade.setText("");
						textReferencia.setText("");
						textCPF.setText("");
						textNacionalidade.setText("");
						textPaisOrigem.setText("");
						textDataNascimento.setText("");
						buttonGroupSexo.clearSelection();
						buttonGroupEstadoCivil.clearSelection();
						comboBoxEstado.setSelectedItem("Selecione um estado");
						labelNome.setText("Nome");
						labelNome.setForeground(Color.BLACK);
						labelCPF.setText("CPF");
						labelCPF.setForeground(Color.BLACK);
						labelDataNascimento.setText("Data de nascimento");
						labelDataNascimento.setForeground(Color.BLACK);
						labelCelular1.setText("Celular 1");
						labelCelular1.setForeground(Color.BLACK);
						labelCelular2.setText("Celular 2");
						labelCelular2.setForeground(Color.BLACK);
						labelRG.setText("RG");
						labelRG.setForeground(Color.BLACK);
						labelCEP.setText("CEP");
						labelCEP.setForeground(Color.BLACK);
						labelTelefone1.setText("Telefone 1");
						labelTelefone1.setForeground(Color.BLACK);
						labelTelefone2.setText("Telefone 2");
						labelTelefone2.setForeground(Color.BLACK);
						labelNacionalidade.setText("Nacionalidade");
						labelNacionalidade.setForeground(Color.BLACK);
						labelPaisOrigem.setText("Pais de origem");
						labelPaisOrigem.setForeground(Color.BLACK);
						labelCidade.setText("Cidade");
						labelCidade.setForeground(Color.BLACK);
						labelBairro.setText("Bairro");
						labelBairro.setForeground(Color.BLACK);
						labelComplemento.setText("Complemento");
						labelComplemento.setForeground(Color.BLACK);
						labelEndereco.setText("Endereço");
						labelEndereco.setForeground(Color.BLACK);
						labelReferencia.setText("Referencia");
						labelReferencia.setForeground(Color.BLACK);
						labelNumero.setText("Numero");
						labelNumero.setForeground(Color.BLACK);
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
				if (textNome.getText().length() != 0 || textRG.getText().replaceAll("\\.", "").replace("-","").trim().length() != 0 ||
					textCPF.getText().replaceAll("\\.", "").replace("-","").trim().length() != 0 ||
					textDataNascimento.getText().replaceAll("\\/", "").trim().length() != 0 ||
					textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
					textTelefone2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
					textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
					textCelular2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
					textEmail1.getText().length() != 0 || textEmail2.getText().length() != 0 || textEndereco.getText().length() != 0 ||
					textBairro.getText().length() != 0 || textNumero.getText().length() != 0 || textComplemento.getText().length() != 0 ||
					textCidade.getText().length() != 0 || textCEP.getText().replace("-","").trim().length() != 0 || 
					textNacionalidade.getText().length() != 0 || textPaisOrigem.getText().length() != 0 || 
					comboBoxEstado.getSelectedItem() != "Selecione um estado" || buttonGroupSexo.getSelection() != null ||
					buttonGroupEstadoCivil.getSelection() != null){
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
                	if (textNome.getText().length() != 0 || textRG.getText().replaceAll("\\.", "").replace("-","").trim().length() != 0 ||
    					textCPF.getText().replaceAll("\\.", "").replace("-","").trim().length() != 0 ||
    					textDataNascimento.getText().replaceAll("\\/", "").trim().length() != 0 ||
    					textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
    					textTelefone2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
    					textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
    					textCelular2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
    					textEmail1.getText().length() != 0 || textEmail2.getText().length() != 0 || textEndereco.getText().length() != 0 ||
    					textBairro.getText().length() != 0 || textNumero.getText().length() != 0 || textComplemento.getText().length() != 0 ||
    					textCidade.getText().length() != 0 || textCEP.getText().replace("-","").trim().length() != 0 ||
    					textNacionalidade.getText().length() != 0 || textPaisOrigem.getText().length() != 0 ||
    					comboBoxEstado.getSelectedItem() != "Selecione um estado" || buttonGroupSexo.getSelection() != null ||
    					buttonGroupEstadoCivil.getSelection() != null){
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