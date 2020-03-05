package moduloFuncionarioTelas;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.sql.Date;
import java.sql.Time;
import aInterfaceSistema.Sessao;
import aInterfaceSistema.ValidaNumeroDouble;
import aInterfaceSistema.ValidaNumeroInteiro;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloFuncionarioBD.Dao_inserir_dados_funcionario;
import moduloFuncionarioBD.Dao_inserir_dados_funcionario_historico;
import moduloFuncionarioBD.Funcionario;
import moduloFuncionarioBD.FuncionarioFrequencia;

public class Cadastro_de_Funcionario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaCadastroFuncionario;
	private JTextField textEndereco, textBairro, textNumero, textComplemento, textCidade, textNome, textReferencia;
	private JTextField textEmail1, textEmail2, textLogin, textCarteiraTrabalho, textSalario;
	private JTextField textNacionalidade, textPaisOrigem, textNomePai, textNomeMae, textNomeBanco, textCargaHoraria, textLimiteFaltas;
	private JPasswordField textSenha;
	private JFormattedTextField textCEP, textCPF, textRG, textTelefone1, textTelefone2, textCelular1,textCelular2;
	private JFormattedTextField textDataNascimento, textDataAdmissao, textDataDemissao,textHoraSaida, textHoraEntrada;
	private final ButtonGroup buttonGroupSexo = new ButtonGroup();
	private final ButtonGroup buttonGroupCargo = new ButtonGroup();
	private final ButtonGroup buttonGroupEstadoCivil = new ButtonGroup();
	private JRadioButton radioMasculino, radioFeminino, radioSolteiro, radioCasado,radioOutro, radioAtendente, radioGerente, radioCarregador;
	private JComboBox<String> comboBoxEstado, comboBoxEscolaridade, comboBoxFormaPagamento, comboBoxCargaHoraria, comboBoxTipoTrabalho;
	private JButton salvar, limpar, voltar;
	Funcionario cadastrarFuncionario;
	FuncionarioFrequencia cadastrarFuncionarioFrequencia;
	SimpleDateFormat dataNascimentoFormato, dataAdmissaoFormato, dataDemissaoFormato;
	SimpleDateFormat horaEntradaFormato, horaSaidaFormato;
	Date data, dataInicio, dataTermino;
	Time horaInicio, horaTermino;
	String dataNascimentoFun, dataAdmissaoFun, dataDemissaoFun, horaEntradaFun, horaSaidaFun, cadastroReferencia;
	String sexoFun, estadoCivilFun, cargoFun, cadastroEmail1, cadastroEmail2, cadastroTelefone1, cadastroTelefone2;
	String cadastroCelular1, cadastroCelular2, cadastroCEP, cargaHoraria, cargaHorariaValor, cargaHorariaUnidade;
	Dao_inserir_dados_funcionario salvaDados;
	Dao_inserir_dados_funcionario_historico salvaHistoricoDados;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_de_Funcionario frame = new Cadastro_de_Funcionario();
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
	public Cadastro_de_Funcionario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro_de_Funcionario.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(true);
		setSize(1000, 600);
		
		telaCadastroFuncionario = new JPanel();
		telaCadastroFuncionario.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaCadastroFuncionario.setLayout(new BorderLayout(10, 10));
		setContentPane(telaCadastroFuncionario);
		
		JPanel panelTitulo = new JPanel();
		telaCadastroFuncionario.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelTitulo2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel iconeCadastroFunc = new JLabel("");
		panelTitulo2.add(iconeCadastroFunc);
		iconeCadastroFunc.setIcon(new ImageIcon(Cadastro_de_Funcionario.class.getResource("/cImagens/Cadastro funcionario.png")));
		iconeCadastroFunc.setPreferredSize(new Dimension(30, 30));
		iconeCadastroFunc.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastroFunc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		iconeCadastroFunc.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel cadastroFun = new JLabel("Cadastro de Funcionario");
		panelTitulo2.add(cadastroFun);
		cadastroFun.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		ImageIcon FotoFuncionario1 = new ImageIcon(Cadastro_de_Funcionario.class.getResource("/cImagens/Usuario.png"));
		FotoFuncionario1.setImage(FotoFuncionario1.getImage().getScaledInstance(90,90, 100));
		
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
		fichaUsuario.setIcon(new ImageIcon(Cadastro_de_Funcionario.class.getResource("/cImagens/Funcionario.png")));
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
		scrollPaneCadastro.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneCadastro.getHorizontalScrollBar().setUnitIncrement(10);
		telaCadastroFuncionario.add(scrollPaneCadastro, BorderLayout.CENTER);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		MaskFormatter numeroRGMascara = null;
		MaskFormatter numeroCPFMascara = null;
		MaskFormatter dataNascimentoMascara = null;
		MaskFormatter dataAdmissaoMascara = null;
		MaskFormatter dataDemissaotoMascara = null;
		MaskFormatter numeroTelefone1Mascara = null;
		MaskFormatter numeroTelefone2Mascara = null;
		MaskFormatter numeroCelular1Mascara = null;
		MaskFormatter numeroCelular2Mascara = null;
		MaskFormatter horaEntradaMascara = null;
		MaskFormatter horaSaidaMascara = null;
		MaskFormatter numeroCEPMascara = null;
		try{
			numeroRGMascara = new MaskFormatter("##.###.###-#");
			numeroCPFMascara = new MaskFormatter("###.###.###-#");
			numeroTelefone1Mascara = new MaskFormatter("(##)####-####");
			numeroTelefone2Mascara = new MaskFormatter("(##)####-####");
			numeroCelular1Mascara = new MaskFormatter("(##)#####-####");
			numeroCelular2Mascara = new MaskFormatter("(##)#####-####");
			dataNascimentoMascara = new MaskFormatter("##/##/####");
			dataAdmissaoMascara = new MaskFormatter("##/##/####");
			dataDemissaotoMascara = new MaskFormatter("##/##/####");
			horaEntradaMascara = new MaskFormatter("##:##");
			horaSaidaMascara = new MaskFormatter("##:##");
			numeroCEPMascara = new MaskFormatter("#####-###");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		JPanel panelNome_RG_CPF = new JPanel();
		panelCadastro.add(panelNome_RG_CPF);
		panelNome_RG_CPF.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNome = new JPanel();
		panelNome_RG_CPF.add(panelNome);
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNome = new JLabel("Nome");
		panelNome.add(labelNome);
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNome.setColumns(10);
		
		JPanel panelRG_CPF = new JPanel();
		panelNome_RG_CPF.add(panelRG_CPF);
		panelRG_CPF.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelRG = new JPanel();
		panelRG.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRG_CPF.add(panelRG);
		panelRG.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelRG = new JLabel("RG");
		panelRG.add(labelRG);
		labelRG.setHorizontalAlignment(SwingConstants.LEFT);
		labelRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textRG = new JFormattedTextField(numeroRGMascara);
		panelRG.add(textRG);
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
		textRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textRG.setColumns(10);
		
		JPanel panelCPF = new JPanel();
		panelCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRG_CPF.add(panelCPF);
		panelCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPF = new JLabel("CPF");
		panelCPF.add(labelCPF);
		labelCPF.setHorizontalAlignment(SwingConstants.LEFT);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCPF = new JFormattedTextField(numeroCPFMascara);
		panelCPF.add(textCPF);
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
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCPF.setColumns(10);
		
		JPanel panelDaNasc_Sexo_EstCivil = new JPanel();
		panelCadastro.add(panelDaNasc_Sexo_EstCivil);
		panelDaNasc_Sexo_EstCivil.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelDataNascimento = new JPanel();
		panelDataNascimento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDaNasc_Sexo_EstCivil.add(panelDataNascimento);
		panelDataNascimento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataNascimento = new JLabel("Data de nascimento");
		panelDataNascimento.add(labelDataNascimento);
		labelDataNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textDataNascimento = new JFormattedTextField(dataNascimentoMascara);
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
		textDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDataNascimento.setColumns(10);
		
		JPanel panelSexo = new JPanel();
		panelSexo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDaNasc_Sexo_EstCivil.add(panelSexo);
		panelSexo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSexo = new JLabel("Sexo");
		panelSexo.add(labelSexo);
		labelSexo.setHorizontalAlignment(SwingConstants.LEFT);
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelSexo2 = new JPanel();
		panelSexo.add(panelSexo2);
		panelSexo2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		radioMasculino = new JRadioButton("Masculino");
		buttonGroupSexo.add(radioMasculino);
		radioMasculino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelSexo2.add(radioMasculino);
		
		radioFeminino = new JRadioButton("Feminino");
		buttonGroupSexo.add(radioFeminino);
		radioFeminino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelSexo2.add(radioFeminino);
		
		JPanel panelEstadocivil = new JPanel();
		panelDaNasc_Sexo_EstCivil.add(panelEstadocivil);
		panelEstadocivil.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstadocivil.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstadocivil = new JLabel("Estado civil");
		panelEstadocivil.add(labelEstadocivil);
		labelEstadocivil.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstadocivil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEstadoCivil = new JPanel();
		panelEstadocivil.add(panelEstadoCivil);
		panelEstadoCivil.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		radioSolteiro = new JRadioButton("Solteiro");
		buttonGroupEstadoCivil.add(radioSolteiro);
		radioSolteiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoCivil.add(radioSolteiro);
		
		radioCasado = new JRadioButton("Casado");
		buttonGroupEstadoCivil.add(radioCasado);
		radioCasado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoCivil.add(radioCasado);
		
		radioOutro = new JRadioButton("Outro");
		buttonGroupEstadoCivil.add(radioOutro);
		radioOutro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoCivil.add(radioOutro);
		
		JPanel panelTelefone_Celular = new JPanel();
		panelCadastro.add(panelTelefone_Celular);
		panelTelefone_Celular.setLayout(new GridLayout(0, 4, 5, 5));
		
		JPanel panelTelefone1 = new JPanel();
		panelTelefone_Celular.add(panelTelefone1);
		panelTelefone1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTelefone1 = new JLabel("Telefone 1");
		panelTelefone1.add(labelTelefone1);
		labelTelefone1.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefone1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		textTelefone1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTelefone1.setColumns(10);
		
		JPanel panelTelefone2 = new JPanel();
		panelTelefone_Celular.add(panelTelefone2);
		panelTelefone2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTelefone2 = new JLabel("Telefone 2");
		panelTelefone2.add(labelTelefone2);
		labelTelefone2.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textTelefone2 = new JFormattedTextField(numeroTelefone2Mascara);
		panelTelefone2.add(textTelefone2);
		textTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTelefone2.setColumns(10);
		
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
		textCelular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCelular1.setColumns(10);
		
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
		textCelular2.setColumns(10);
		
		JPanel panelEmail = new JPanel();
		panelCadastro.add(panelEmail);
		panelEmail.setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panelEmail1 = new JPanel();
		panelEmail.add(panelEmail1);
		panelEmail1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail1 = new JLabel("Email 1");
		panelEmail1.add(labelEmail1);
		labelEmail1.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		textEmail1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEmail1.setColumns(10);
		
		JPanel panelEmail2 = new JPanel();
		panelEmail.add(panelEmail2);
		panelEmail2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail2 = new JLabel("Email 2");
		panelEmail2.add(labelEmail2);
		labelEmail2.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textEmail2 = new JTextField();
		panelEmail2.add(textEmail2);
		textEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEmail2.setColumns(10);
		
		JPanel panelEs_Na_Pa = new JPanel();
		panelCadastro.add(panelEs_Na_Pa);
		panelEs_Na_Pa.setLayout(new GridLayout(0, 3, 5, 5));
		
		JPanel panelEscolaridade = new JPanel();
		panelEs_Na_Pa.add(panelEscolaridade);
		panelEscolaridade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEscolaridade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEscolaridade = new JLabel("Escolaridade");
		panelEscolaridade.add(labelEscolaridade);
		labelEscolaridade.setHorizontalAlignment(SwingConstants.LEFT);
		labelEscolaridade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		comboBoxEscolaridade = new JComboBox<String>();
		comboBoxEscolaridade.setMaximumRowCount(5);
		comboBoxEscolaridade.addItem("Selecione");
		comboBoxEscolaridade.addItem("Primario");
		comboBoxEscolaridade.addItem("Primeiro grau");
		comboBoxEscolaridade.addItem("Segundo grau");
		comboBoxEscolaridade.addItem("Superior");
		comboBoxEscolaridade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxEscolaridade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (comboBoxEscolaridade.getSelectedItem() == "Selecione") {
					labelEscolaridade.setText("Escolaridade*");
					labelEscolaridade.setForeground(Color.RED);
				}
				else {
					labelEscolaridade.setText("Escolaridade");
					labelEscolaridade.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelEscolaridade.setText("Escolaridade");
				labelEscolaridade.setForeground(Color.BLACK);
			}
		});
		panelEscolaridade.add(comboBoxEscolaridade);
		
		JPanel panelNacionalidade = new JPanel();
		panelEs_Na_Pa.add(panelNacionalidade);
		panelNacionalidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNacionalidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNacionalidade = new JLabel("Nacionalidade");
		panelNacionalidade.add(labelNacionalidade);
		labelNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textNacionalidade = new JTextField();
		panelNacionalidade.add(textNacionalidade);
		textNacionalidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textNacionalidade.getText().isEmpty() || textNacionalidade.getText().length() <= 0){
					labelNacionalidade.setText("Nacionalidade*");
					labelNacionalidade.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelNacionalidade.setText("Nacionalidade");
				labelNacionalidade.setForeground(Color.BLACK);
			}
		});
		textNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNacionalidade.setColumns(10);
		
		JPanel panelPaisOrigem = new JPanel();
		panelEs_Na_Pa.add(panelPaisOrigem);
		panelPaisOrigem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPaisOrigem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPaisOrigem = new JLabel("Pais de origem");
		panelPaisOrigem.add(labelPaisOrigem);
		labelPaisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		labelPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textPaisOrigem = new JTextField();
		panelPaisOrigem.add(textPaisOrigem);
		textPaisOrigem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textPaisOrigem.getText().isEmpty() || textPaisOrigem.getText().length() <= 0){
					labelPaisOrigem.setText("Pais de origem*");
					labelPaisOrigem.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelPaisOrigem.setText("Pais de origem");
				labelPaisOrigem.setForeground(Color.BLACK);
			}
		});
		textPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPaisOrigem.setColumns(10);
		
		JPanel panelNomeMae_NomePai = new JPanel();
		panelCadastro.add(panelNomeMae_NomePai);
		panelNomeMae_NomePai.setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panelNomeMae = new JPanel();
		panelNomeMae_NomePai.add(panelNomeMae);
		panelNomeMae.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeMae.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeMae = new JLabel("Nome da M\u00E3e");
		panelNomeMae.add(labelNomeMae);
		labelNomeMae.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeMae.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textNomeMae = new JTextField();
		panelNomeMae.add(textNomeMae);
		textNomeMae.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNomeMae.setColumns(10);
		
		JPanel panelNomePai = new JPanel();
		panelNomeMae_NomePai.add(panelNomePai);
		panelNomePai.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomePai.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomePai = new JLabel("Nome do Pai");
		panelNomePai.add(labelNomePai);
		labelNomePai.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomePai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textNomePai = new JTextField();
		panelNomePai.add(textNomePai);
		textNomePai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNomePai.setColumns(10);
		
		JPanel panelLogin_Senha_Cargo = new JPanel();
		panelCadastro.add(panelLogin_Senha_Cargo);
		panelLogin_Senha_Cargo.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelLogin = new JPanel();
		panelLogin_Senha_Cargo.add(panelLogin);
		panelLogin.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelLogin.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLogin = new JLabel("Login");
		panelLogin.add(labelLogin);
		labelLogin.setHorizontalAlignment(SwingConstants.LEFT);
		labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textLogin = new JTextField();
		panelLogin.add(textLogin);
		textLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textLogin.getText().isEmpty() || textLogin.getText().length() <= 0){
					labelLogin.setText("Login*");
					labelLogin.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelLogin.setText("Login");
				labelLogin.setForeground(Color.BLACK);
			}
		});
		textLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textLogin.setColumns(10);
		
		JPanel panelSenha = new JPanel();
		panelLogin_Senha_Cargo.add(panelSenha);
		panelSenha.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelSenha.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSenha = new JLabel("Senha");
		panelSenha.add(labelSenha);
		labelSenha.setHorizontalAlignment(SwingConstants.LEFT);
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textSenha = new JPasswordField();
		panelSenha.add(textSenha);
		textSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textSenha.setColumns(10);
		
		JPanel panelCargo = new JPanel();
		panelCargo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelLogin_Senha_Cargo.add(panelCargo);
		panelCargo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargo = new JLabel("Cargo");
		panelCargo.add(labelCargo);
		labelCargo.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCargo2 = new JPanel();
		panelCargo.add(panelCargo2);
		panelCargo2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		radioAtendente = new JRadioButton("Atendente");
		buttonGroupCargo.add(radioAtendente);
		radioAtendente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargo2.add(radioAtendente);
		
		radioGerente = new JRadioButton("Gerente");
		buttonGroupCargo.add(radioGerente);
		radioGerente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargo2.add(radioGerente);
		
		radioCarregador = new JRadioButton("Carregador");
		buttonGroupCargo.add(radioCarregador);
		radioCarregador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargo2.add(radioCarregador);
		
		JPanel panelCartTrab_Sal_ForPag_NomeBanco = new JPanel();
		panelCadastro.add(panelCartTrab_Sal_ForPag_NomeBanco);
		panelCartTrab_Sal_ForPag_NomeBanco.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelCarteiraTrabalho = new JPanel();
		panelCartTrab_Sal_ForPag_NomeBanco.add(panelCarteiraTrabalho);
		panelCarteiraTrabalho.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCarteiraTrabalho.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCarteiraTrabalho = new JLabel("Carteira de trabalho");
		panelCarteiraTrabalho.add(labelCarteiraTrabalho);
		labelCarteiraTrabalho.setHorizontalAlignment(SwingConstants.LEFT);
		labelCarteiraTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCarteiraTrabalho = new JTextField();
		panelCarteiraTrabalho.add(textCarteiraTrabalho);
		textCarteiraTrabalho.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCarteiraTrabalho.getText().isEmpty() || textCarteiraTrabalho.getText().length() <= 0){
					labelCarteiraTrabalho.setText("Carteira de trabalho*");
					labelCarteiraTrabalho.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelCarteiraTrabalho.setText("Carteira de trabalho");
				labelCarteiraTrabalho.setForeground(Color.BLACK);
			}
		});
		textCarteiraTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCarteiraTrabalho.setColumns(10);
		
		JPanel panelSalario = new JPanel();
		panelCartTrab_Sal_ForPag_NomeBanco.add(panelSalario);
		panelSalario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelSalario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSalario = new JLabel("Salario");
		panelSalario.add(labelSalario);
		labelSalario.setHorizontalAlignment(SwingConstants.LEFT);
		labelSalario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textSalario = new JTextField();
		panelSalario.add(textSalario);
		textSalario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textSalario.getText().isEmpty() || textSalario.getText().length() <= 0){
					labelSalario.setText("Salario*");
					labelSalario.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelSalario.setText("Salario");
				labelSalario.setForeground(Color.BLACK);
			}
		});
		textSalario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PlainDocument documentSalario = (PlainDocument) textSalario.getDocument();
		textSalario.setColumns(10);
		
		JPanel panelFormaPagamento = new JPanel();
		panelCartTrab_Sal_ForPag_NomeBanco.add(panelFormaPagamento);
		panelFormaPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFormaPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFormaPagamento = new JLabel("Forma de pagamento");
		panelFormaPagamento.add(labelFormaPagamento);
		labelFormaPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		labelFormaPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		comboBoxFormaPagamento = new JComboBox<String>();
		comboBoxFormaPagamento.setMaximumRowCount(5);
		comboBoxFormaPagamento.addItem("Selecione");
		comboBoxFormaPagamento.addItem("Por hora");
		comboBoxFormaPagamento.addItem("Diaria");
		comboBoxFormaPagamento.addItem("Semanal");
		comboBoxFormaPagamento.addItem("Quinzenal");
		comboBoxFormaPagamento.addItem("Mensal");
		comboBoxFormaPagamento.addItem("Anual");
		comboBoxFormaPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxFormaPagamento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (comboBoxFormaPagamento.getSelectedItem() == "Selecione") {
					labelFormaPagamento.setText("Forma de pagamento*");
					labelFormaPagamento.setForeground(Color.RED);
				}
				else {
					labelFormaPagamento.setText("Forma de pagamento");
					labelFormaPagamento.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelFormaPagamento.setText("Forma de pagamento");
				labelFormaPagamento.setForeground(Color.BLACK);
			}
		});
		panelFormaPagamento.add(comboBoxFormaPagamento);
		
		JPanel panelNomeBanco = new JPanel();
		panelCartTrab_Sal_ForPag_NomeBanco.add(panelNomeBanco);
		panelNomeBanco.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeBanco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeBanco = new JLabel("Nome do banco");
		panelNomeBanco.add(labelNomeBanco);
		labelNomeBanco.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeBanco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textNomeBanco = new JTextField();
		panelNomeBanco.add(textNomeBanco);
		textNomeBanco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNomeBanco.setColumns(10);
		textNomeBanco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textNomeBanco.getText().isEmpty() || textNomeBanco.getText().length() <= 0){
					labelNomeBanco.setText("Nome do banco*");
					labelNomeBanco.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelNomeBanco.setText("Nome do banco");
				labelNomeBanco.setForeground(Color.BLACK);
			}
		});
		
		JPanel panelTipoTrabalho_Data = new JPanel();
		panelCadastro.add(panelTipoTrabalho_Data);
		panelTipoTrabalho_Data.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelTipoTrabalho = new JPanel();
		panelTipoTrabalho_Data.add(panelTipoTrabalho);
		panelTipoTrabalho.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoTrabalho.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoTrabalho = new JLabel("Tipo de trabalho");
		panelTipoTrabalho.add(labelTipoTrabalho);
		labelTipoTrabalho.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		comboBoxTipoTrabalho = new JComboBox<String>();
		comboBoxTipoTrabalho.setMaximumRowCount(4);
		comboBoxTipoTrabalho.addItem("Selecione");
		comboBoxTipoTrabalho.addItem("Fixo");
		comboBoxTipoTrabalho.addItem("Temporário");
		comboBoxTipoTrabalho.addItem("Estagio");
		comboBoxTipoTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxTipoTrabalho.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (comboBoxTipoTrabalho.getSelectedItem() == "Selecione") {
					labelTipoTrabalho.setText("Tipo de trabalho*");
					labelTipoTrabalho.setForeground(Color.RED);
				}
				else {
					labelTipoTrabalho.setText("Tipo de trabalho");
					labelTipoTrabalho.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelTipoTrabalho.setText("Tipo de trabalho");
				labelTipoTrabalho.setForeground(Color.BLACK);
			}
		});
		panelTipoTrabalho.add(comboBoxTipoTrabalho);
		
		JPanel panelDataAdmissao = new JPanel();
		panelTipoTrabalho_Data.add(panelDataAdmissao);
		panelDataAdmissao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataAdmissao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataAdmissao = new JLabel("Data de admiss\u00E3o");
		panelDataAdmissao.add(labelDataAdmissao);
		labelDataAdmissao.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataAdmissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textDataAdmissao = new JFormattedTextField(dataAdmissaoMascara);
		panelDataAdmissao.add(textDataAdmissao);
		textDataAdmissao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textDataAdmissao.getText().replaceAll("\\/", "").trim().isEmpty()){
					labelDataAdmissao.setText("Data de admissão*");
					labelDataAdmissao.setForeground(Color.RED);
				}
				else {
					labelDataAdmissao.setText("Data de admissão");
					labelDataAdmissao.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelDataAdmissao.setText("Data de admissão");
				labelDataAdmissao.setForeground(Color.BLACK);
			}
		});
		textDataAdmissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDataAdmissao.setColumns(10);
		
		JPanel panelDataDemissao = new JPanel();
		panelTipoTrabalho_Data.add(panelDataDemissao);
		panelDataDemissao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataDemissao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataDemissao = new JLabel("Data de demiss\u00E3o");
		panelDataDemissao.add(labelDataDemissao);
		labelDataDemissao.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataDemissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textDataDemissao = new JFormattedTextField(dataDemissaotoMascara);
		panelDataDemissao.add(textDataDemissao);
		textDataDemissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDataDemissao.setColumns(10);
		
		JPanel panelHorario_LimiteFaltas = new JPanel();
		panelCadastro.add(panelHorario_LimiteFaltas);
		panelHorario_LimiteFaltas.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelHoraEntrada = new JPanel();
		panelHorario_LimiteFaltas.add(panelHoraEntrada);
		panelHoraEntrada.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHoraEntrada.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraEntrada = new JLabel("Hora de entrada");
		panelHoraEntrada.add(labelHoraEntrada);
		labelHoraEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		labelHoraEntrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textHoraEntrada = new JFormattedTextField(horaEntradaMascara);
		panelHoraEntrada.add(textHoraEntrada);
		textHoraEntrada.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textHoraEntrada.getText().replace(":","").trim().isEmpty()){
					labelHoraEntrada.setText("Hora de entrada*");
					labelHoraEntrada.setForeground(Color.RED);
				}
				else {
					labelHoraEntrada.setText("Hora de entrada");
					labelHoraEntrada.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelHoraEntrada.setText("Hora de entrada");
				labelHoraEntrada.setForeground(Color.BLACK);
			}
		});
		textHoraEntrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textHoraEntrada.setColumns(10);
		
		JPanel panelHoraSaida = new JPanel();
		panelHorario_LimiteFaltas.add(panelHoraSaida);
		panelHoraSaida.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHoraSaida.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraSaida = new JLabel("Hora de saida");
		panelHoraSaida.add(labelHoraSaida);
		labelHoraSaida.setHorizontalAlignment(SwingConstants.LEFT);
		labelHoraSaida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textHoraSaida = new JFormattedTextField(horaSaidaMascara);
		panelHoraSaida.add(textHoraSaida);
		textHoraSaida.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textHoraSaida.getText().replace(":","").trim().isEmpty()){
					labelHoraSaida.setText("Hora de saida*");
					labelHoraSaida.setForeground(Color.RED);
				}
				else {
					labelHoraSaida.setText("Hora de saida");
					labelHoraSaida.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelHoraSaida.setText("Hora de saida");
				labelHoraSaida.setForeground(Color.BLACK);
			}
		});
		textHoraSaida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textHoraSaida.setColumns(10);
		
		JPanel panelCargaHoraria = new JPanel();
		panelHorario_LimiteFaltas.add(panelCargaHoraria);
		panelCargaHoraria.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargaHoraria.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargaHoraria = new JLabel("Carga horaria diaria");
		panelCargaHoraria.add(labelCargaHoraria);
		labelCargaHoraria.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCargaHoraria2 = new JPanel();
		panelCargaHoraria.add(panelCargaHoraria2);
		panelCargaHoraria2.setLayout(new BorderLayout(0, 0));
		
		textCargaHoraria = new JTextField();
		panelCargaHoraria2.add(textCargaHoraria);
		textCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCargaHoraria.setDocument(new ValidaNumeroInteiro());
		textCargaHoraria.setColumns(10);
		
		comboBoxCargaHoraria = new JComboBox<String>();
		panelCargaHoraria2.add(comboBoxCargaHoraria, BorderLayout.EAST);
		comboBoxCargaHoraria.addItem("Selecione");
		comboBoxCargaHoraria.addItem("hora(s)");
		comboBoxCargaHoraria.addItem("minuto(s)");
		comboBoxCargaHoraria.setMaximumRowCount(5);
		comboBoxCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCargaHoraria.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCargaHoraria.getText().isEmpty() || textCargaHoraria.getText().length() <= 0 || comboBoxCargaHoraria.getSelectedItem() == "Selecione"){
					labelCargaHoraria.setText("Carga horaria diaria*");
					labelCargaHoraria.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelCargaHoraria.setText("Carga horaria diaria");
				labelCargaHoraria.setForeground(Color.BLACK);
			}
		});
		
		JPanel panelLimiteFaltas = new JPanel();
		panelLimiteFaltas.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHorario_LimiteFaltas.add(panelLimiteFaltas);
		panelLimiteFaltas.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLimiteFaltas = new JLabel("Limite de faltas");
		labelLimiteFaltas.setHorizontalAlignment(SwingConstants.LEFT);
		labelLimiteFaltas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelLimiteFaltas.add(labelLimiteFaltas);
		
		textLimiteFaltas = new JTextField();
		panelLimiteFaltas.add(textLimiteFaltas);
		textLimiteFaltas.setColumns(10);
		textLimiteFaltas.setDocument(new ValidaNumeroInteiro());
		textLimiteFaltas.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textLimiteFaltas.getText().isEmpty() || textLimiteFaltas.getText().length() <= 0){
					labelLimiteFaltas.setText("Limite de faltas*");
					labelLimiteFaltas.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelLimiteFaltas.setText("Limite de faltas");
				labelLimiteFaltas.setForeground(Color.BLACK);
			}
		});
		
		
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
		comboBoxEstado.addItem("Selecione");
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
		comboBoxEstado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (comboBoxEstado.getSelectedItem() == "Selecione") {
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
		panelEstado_CEP_Cidade.add(panelCEP);
		panelCEP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCEP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCEP = new JLabel("CEP");
		panelCEP.add(labelCEP);
		labelCEP.setHorizontalAlignment(SwingConstants.LEFT);
		labelCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCEP = new JFormattedTextField(numeroCEPMascara);
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
		panelCEP.add(textCEP);
		textCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCEP.setColumns(10);
		
		JPanel panelCidade = new JPanel();
		panelEstado_CEP_Cidade.add(panelCidade);
		panelCidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCidade = new JLabel("Cidade");
		panelCidade.add(labelCidade);
		labelCidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		textCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCidade.setColumns(10);
		
		JPanel panelEndereco = new JPanel();
		panelCadastro.add(panelEndereco);
		panelEndereco.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEndereco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o");
		panelEndereco.add(labelEndereco);
		labelEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textEndereco = new JTextField();
		panelEndereco.add(textEndereco);
		textEndereco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textEndereco.getText().isEmpty() || textEndereco.getText().length() <= 0){
					labelEndereco.setText("Endereco*");
					labelEndereco.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelEndereco.setText("Endereco");
				labelEndereco.setForeground(Color.BLACK);
			}
		});
		textEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEndereco.setColumns(10);
		
		JPanel panelNume_Comp_Bairro = new JPanel();
		panelCadastro.add(panelNume_Comp_Bairro);
		panelNume_Comp_Bairro.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelNumero = new JPanel();
		panelNume_Comp_Bairro.add(panelNumero);
		panelNumero.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNumero.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNumero = new JLabel("Numero");
		panelNumero.add(labelNumero);
		labelNumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textNumero = new JTextField();
		panelNumero.add(textNumero);
		textNumero.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textNumero.getText().isEmpty() || textNumero.getText().length() <= 0){
					labelNumero.setText("Numero*");
					labelNumero.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelNumero.setText("Numero");
				labelNumero.setForeground(Color.BLACK);
			}
		});
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNumero.setColumns(10);
		
		JPanel panelComplemento = new JPanel();
		panelNume_Comp_Bairro.add(panelComplemento);
		panelComplemento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComplemento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComplemento = new JLabel("Complemento");
		panelComplemento.add(labelComplemento);
		labelComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textComplemento = new JTextField();
		panelComplemento.add(textComplemento);
		textComplemento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textComplemento.getText().isEmpty() || textComplemento.getText().length() <= 0){
					labelComplemento.setText("Complemento*");
					labelComplemento.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelComplemento.setText("Complemento");
				labelComplemento.setForeground(Color.BLACK);
			}
		});
		textComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textComplemento.setColumns(10);
		
		JPanel panelBairro = new JPanel();
		panelNume_Comp_Bairro.add(panelBairro);
		panelBairro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelBairro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairro = new JLabel("Bairro");
		panelBairro.add(labelBairro);
		labelBairro.setHorizontalAlignment(SwingConstants.LEFT);
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textBairro = new JTextField();
		panelBairro.add(textBairro);
		textBairro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textBairro.getText().isEmpty() || textBairro.getText().length() <= 0){
					labelBairro.setText("Bairro*");
					labelBairro.setForeground(Color.RED);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelBairro.setText("Bairro");
				labelBairro.setForeground(Color.BLACK);
			}
		});
		textBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textBairro.setColumns(10);
		
		JPanel panelReferencia = new JPanel();
		panelCadastro.add(panelReferencia);
		panelReferencia.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelReferencia.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelReferencia = new JLabel("Referencia");
		panelReferencia.add(labelReferencia);
		labelReferencia.setHorizontalAlignment(SwingConstants.LEFT);
		labelReferencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textReferencia = new JTextField();
		panelReferencia.add(textReferencia);
		textReferencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textReferencia.setColumns(10);
		documentSalario.setDocumentFilter(new ValidaNumeroDouble());
		
		JPanel panelBotoes = new JPanel();
		telaCadastroFuncionario.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelLegenda = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelLegenda.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		panelBotoes.add(panelLegenda, BorderLayout.WEST);
		
		JLabel labelLegenda = new JLabel("Legenda: (*) Campo importante que deve ser preenchido");
		labelLegenda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelLegenda.add(labelLegenda);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2, BorderLayout.CENTER);
		
		salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNome.getText().isEmpty() || textNome.getText().length() <= 0 || textRG.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty() ||
					textCPF.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty() || textLogin.getText().isEmpty() || textLogin.getText().length() <= 0 ||
					textSenha.getPassword().length <= 0 || textEndereco.getText().isEmpty() || textEndereco.getText().length() <= 0 ||
					textBairro.getText().isEmpty() || textBairro.getText().length() <= 0 || textNumero.getText().isEmpty() || textNumero.getText().length() <= 0 ||
					textComplemento.getText().isEmpty() || textComplemento.getText().length() <= 0 || textCidade.getText().isEmpty() || textCidade.getText().length() <= 0 ||
					textCEP.getText().replace("-","").trim().isEmpty() || textReferencia.getText().isEmpty() || textReferencia.getText().length() <= 0 ||
					textSalario.getText().isEmpty() || textSalario.getText().length() <= 0 || textCargaHoraria.getText().isEmpty() || textCargaHoraria.getText().length() <= 0 ||
					textLimiteFaltas.getText().isEmpty() || textLimiteFaltas.getText().length() <= 0 || textNacionalidade.getText().isEmpty() || textNacionalidade.getText().length() <= 0 ||
					textPaisOrigem.getText().isEmpty() || textPaisOrigem.getText().length() <= 0 || textNomeBanco.getText().isEmpty() || textNomeBanco.getText().length() <= 0 ||
					textDataNascimento.getText().replaceAll("\\/", "").trim().isEmpty() || textDataAdmissao.getText().replaceAll("\\/", "").trim().isEmpty() ||
					textHoraEntrada.getText().replace(":","").trim().isEmpty() || textHoraSaida.getText().replace(":","").trim().isEmpty() ||
					comboBoxEstado.getSelectedItem() == "Selecione" || comboBoxEscolaridade.getSelectedItem() == "Selecione" || comboBoxFormaPagamento.getSelectedItem() == "Selecione" ||
					comboBoxTipoTrabalho.getSelectedItem() == "Selecione" || comboBoxCargaHoraria.getSelectedItem() == "Selecione" || buttonGroupSexo.getSelection() == null ||
					buttonGroupEstadoCivil.getSelection() == null|| buttonGroupCargo.getSelection() == null) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					try{
						//Envia os dados para o banco de dados
						cadastrarFuncionario = new Funcionario();
						cadastrarFuncionarioFrequencia = new FuncionarioFrequencia();
						
						cadastrarFuncionario.setNome(textNome.getText());
						cadastrarFuncionarioFrequencia.setNomeFuncionario(textNome.getText());
						
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
						cadastrarFuncionario.setCodigoFuncionario(codigoRegistro);
						cadastrarFuncionarioFrequencia.setCodigoFuncionario(codigoRegistro);
						
						cadastrarFuncionario.setRG(textRG.getText());
						cadastrarFuncionario.setEndereco(textEndereco.getText());
						cadastrarFuncionario.setBairro(textBairro.getText());
						cadastrarFuncionario.setNumero(textNumero.getText());
						cadastrarFuncionario.setComplemento(textComplemento.getText());
						cadastrarFuncionario.setCidade(textCidade.getText());
						cadastrarFuncionario.setCEP(textCEP.getText());
						cadastrarFuncionario.setCPF(textCPF.getText());
						cadastrarFuncionario.setEstadoCivil(textCPF.getText());
						cadastrarFuncionario.setEstado((String)(comboBoxEstado.getSelectedItem()));
						cadastrarFuncionario.setEscolaridade((String)(comboBoxEscolaridade.getSelectedItem()));
						cadastrarFuncionario.setFormaPagamento((String)(comboBoxFormaPagamento.getSelectedItem()));
						cadastrarFuncionario.setTipoTrabalho((String)(comboBoxTipoTrabalho.getSelectedItem()));
						cadastrarFuncionario.setCarteiraTrabalho(textCarteiraTrabalho.getText());
						cadastrarFuncionario.setSalario(Double.parseDouble(textSalario.getText()));
						cadastrarFuncionario.setNomeBanco(textNomeBanco.getText());
						cadastrarFuncionario.setNomeMae(textNomeMae.getText());
						cadastrarFuncionario.setNomePai(textNomePai.getText());
						cadastrarFuncionario.setNacionalidade(textNacionalidade.getText());
						cadastrarFuncionario.setPaisOrigem(textPaisOrigem.getText());
						cadastrarFuncionario.setLogin(textLogin.getText());
						
						String senhaFuncionario = new String(textSenha.getPassword());
						cadastrarFuncionario.setSenha(senhaFuncionario);
						
						try {
							java.util.Date dataRegistro = new java.util.Date();
							SimpleDateFormat dataRegistroFormato = new SimpleDateFormat("dd/MM/yyyy");
							String dataCadastroFuncionario = dataRegistroFormato.format(dataRegistro);
							SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
							Date dataCadastro = new java.sql.Date(dataCadastroFormato.parse(dataCadastroFuncionario).getTime());
							cadastrarFuncionario.setDataCadastro(dataCadastro);
						} catch (ParseException e9) {
							e9.printStackTrace();
						}
						
						try {
							java.util.Date horaRegistro = new java.util.Date();
							SimpleDateFormat horaRegistroFormato = new SimpleDateFormat("HH:mm");
							String horaCadastroFuncionario = horaRegistroFormato.format(horaRegistro);
							SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
							Time horaCadastro = new java.sql.Time(horaCadastroFormato.parse(horaCadastroFuncionario).getTime());
							cadastrarFuncionario.setHoraCadastro(horaCadastro);
						} catch (ParseException e9) {
							e9.printStackTrace();
						}
						
						/*Cadastro da referencia*/
						if (textReferencia.getText().isEmpty() || textReferencia.getText().length() <= 0){
							cadastroReferencia = "Opcional";
							cadastrarFuncionario.setReferencia(cadastroReferencia);
						}
						else {
							cadastrarFuncionario.setReferencia(textReferencia.getText());
						}
						
						/*Cadastro das datas*/
						dataNascimentoFun = textDataNascimento.getText();
						try {
							dataNascimentoFormato = new SimpleDateFormat("dd/MM/yyyy");
							data = new java.sql.Date(dataNascimentoFormato.parse(dataNascimentoFun).getTime());
							cadastrarFuncionario.setDataNascimento(data);
						} catch (ParseException e2) {
							e2.printStackTrace();
						}
						
						dataAdmissaoFun = textDataAdmissao.getText();
						try {
							dataAdmissaoFormato = new SimpleDateFormat("dd/MM/yyyy");
							dataInicio = new java.sql.Date(dataAdmissaoFormato.parse(dataAdmissaoFun).getTime());
							cadastrarFuncionario.setDataAdmissao(dataInicio);
						} catch (ParseException e3) {
							e3.printStackTrace();
						}
						
						if (textDataDemissao.getText().replaceAll("\\/", "").trim().isEmpty()) {
							Date dataTermino2 = null;
							cadastrarFuncionario.setDataDemissao(dataTermino2);
						} else {
							dataDemissaoFun = textDataDemissao.getText();
							try {
								dataDemissaoFormato = new SimpleDateFormat("dd/MM/yyyy");
								dataTermino = new java.sql.Date(dataDemissaoFormato.parse(dataDemissaoFun).getTime());
								cadastrarFuncionario.setDataDemissao(dataTermino);
							} catch (ParseException e4) {
								e4.printStackTrace();
							}
						}
						
						/*Cadastro da hora*/
						horaEntradaFun = textHoraEntrada.getText();
						try {
							horaEntradaFormato = new SimpleDateFormat("HH:mm");
							horaInicio = new java.sql.Time(horaEntradaFormato.parse(horaEntradaFun).getTime());
							cadastrarFuncionario.setHoraEntrada(horaInicio);
							cadastrarFuncionarioFrequencia.setHoraEntrada(horaInicio);
						} catch (ParseException e4) {
							e4.printStackTrace();
						}
						
						horaSaidaFun = textHoraSaida.getText();
						try {
							horaSaidaFormato = new SimpleDateFormat("HH:mm");
							horaTermino = new java.sql.Time(horaSaidaFormato.parse(horaSaidaFun).getTime());
							cadastrarFuncionario.setHoraSaida(horaTermino);
							cadastrarFuncionarioFrequencia.setHoraSaida(horaTermino);
						} catch (ParseException e5) {
							e5.printStackTrace();
						}
						
						/*Cadastro do sexo*/
						if (radioMasculino.isSelected()) {
							sexoFun = radioMasculino.getText();
							cadastrarFuncionario.setSexo(sexoFun);
						}
						if (radioFeminino.isSelected()) {
							sexoFun = radioFeminino.getText();
							cadastrarFuncionario.setSexo(sexoFun);
						}
						
						/*Cadastro da carga horaria*/
						cargaHorariaValor = textCargaHoraria.getText();
						cadastrarFuncionario.setCargaHoraria(cargaHorariaValor);
						cadastrarFuncionarioFrequencia.setCargaHoraria(cargaHorariaValor);
						
						cargaHorariaUnidade = (String) comboBoxCargaHoraria.getSelectedItem();;
						cadastrarFuncionario.setCargaHorariaUnidade(cargaHorariaUnidade);
						cadastrarFuncionarioFrequencia.setCargaHorariaUnidade(cargaHorariaUnidade);
						
						/*Cadastro do limite de faltas*/
						cadastrarFuncionario.setLimiteFaltas(Integer.parseInt(textLimiteFaltas.getText()));
						cadastrarFuncionarioFrequencia.setValorMaximoFalta(Integer.parseInt(textLimiteFaltas.getText()));
						
						/*Cadastro da quantidade inicial de presenças*/
						int presencaValor = 0;
						cadastrarFuncionarioFrequencia.setPresencaTotal(presencaValor);
						
						/*Cadastro da quantidade inicial de faltas*/
						int faltaValor = 0;
						cadastrarFuncionarioFrequencia.setFaltaTotal(faltaValor);
						
						/*Cadastro do estado civil*/
						if (radioSolteiro.isSelected()) {
							estadoCivilFun = radioSolteiro.getText();
							cadastrarFuncionario.setEstadoCivil(estadoCivilFun);
						}
						if (radioCasado.isSelected()) {
							estadoCivilFun = radioCasado.getText();
							cadastrarFuncionario.setEstadoCivil(estadoCivilFun);
						}
						if (radioOutro.isSelected()) {
							estadoCivilFun = radioOutro.getText();
							cadastrarFuncionario.setEstadoCivil(estadoCivilFun);
						}
						
						/*Cadastro de cargo*/
						if (radioAtendente.isSelected()) {
							cargoFun = radioAtendente.getText();
							cadastrarFuncionario.setCargo(cargoFun);
							cadastrarFuncionarioFrequencia.setCargoFuncionario(cargoFun);
						}
						if (radioGerente.isSelected()) {
							cargoFun = radioGerente.getText();
							cadastrarFuncionario.setCargo(cargoFun);
							cadastrarFuncionarioFrequencia.setCargoFuncionario(cargoFun);
						}
						if (radioCarregador.isSelected()) {
							cargoFun = radioCarregador.getText();
							cadastrarFuncionario.setCargo(cargoFun);
							cadastrarFuncionarioFrequencia.setCargoFuncionario(cargoFun);
						}
						
						/*Cadastro de email*/
						if (textEmail1.getText().isEmpty() || textEmail1.getText().length() <= 0){
							cadastroEmail1 = "Opcional";
							cadastrarFuncionario.setEmail1(cadastroEmail1);
						}
						else {
							cadastrarFuncionario.setEmail1(textEmail1.getText());
						}
						
						if (textEmail2.getText().isEmpty() || textEmail2.getText().length() <= 0){
							cadastroEmail2 = "Opcional";
							cadastrarFuncionario.setEmail2(cadastroEmail2);
						}
						else {
							cadastrarFuncionario.setEmail2(textEmail2.getText());
						}
						
						/*Cadastro de telefone*/
						if (textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroTelefone1 = "Opcional";
							cadastrarFuncionario.setTelefone1(cadastroTelefone1);
						}
						else {
							cadastroTelefone1 = textTelefone1.getText();
							cadastrarFuncionario.setTelefone1(cadastroTelefone1);
						}
											
						if (textTelefone2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroTelefone2 = "Opcional";
							cadastrarFuncionario.setTelefone2(cadastroTelefone2);
						}
						else {
							cadastroTelefone2 = textTelefone2.getText();
							cadastrarFuncionario.setTelefone2(cadastroTelefone2);
						}
						
						/*Cadastro de celular*/
						if (textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroCelular1 = "Opcional";
							cadastrarFuncionario.setCelular1(cadastroCelular1);
						}
						else {
							cadastrarFuncionario.setCelular1(textCelular1.getText());
						}
						
						if (textCelular2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroCelular2 = "Opcional";
							cadastrarFuncionario.setCelular2(cadastroCelular2);
						}
						else {
							cadastrarFuncionario.setCelular2(textCelular2.getText());
						}
						
						/*Envia os dados para a classe que salva os dados no banco*/
						salvaDados = new Dao_inserir_dados_funcionario();
						salvaDados.Inserir_Dados_Funcionario(cadastrarFuncionario);
						
						salvaHistoricoDados = new Dao_inserir_dados_funcionario_historico();
						salvaHistoricoDados.Inserir_Dados_Funcionario_Historico(cadastrarFuncionarioFrequencia);
						
						//Mensagem de confirmação do cadastro
						String menssagemConteudo = "Dados cadastrados com sucesso";
						Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
						mensagemConfirmacao.setVisible(true);
						
						//Limpa os campos depois que o cadastro é realizado
						textNome.setText("");
						textDataNascimento.setText("");
						textCPF.setText("");
						textRG.setText("");
						textTelefone1.setText("");
						textTelefone2.setText("");
						textCelular1.setText("");
						textCelular2.setText("");
						textEmail1.setText("");
						textEmail2.setText("");
						textLogin.setText("");
						textSenha.setText("");
						textNacionalidade.setText("");
						textPaisOrigem.setText("");
						textNomePai.setText("");
						textNomeMae.setText("");
						textNomeBanco.setText("");
						textHoraSaida.setText("");
						textHoraEntrada.setText("");
						textDataAdmissao.setText("");
						textDataDemissao.setText("");
						textCargaHoraria.setText("");
						textLimiteFaltas.setText("");
						textCarteiraTrabalho.setText("");
						textSalario.setText("");
						textCEP.setText("");
						textEndereco.setText("");
						textNumero.setText("");
						textComplemento.setText("");
						textBairro.setText("");
						textCidade.setText("");
						textReferencia.setText("");
						buttonGroupSexo.clearSelection();
						buttonGroupEstadoCivil.clearSelection();
						buttonGroupCargo.clearSelection();
						comboBoxEstado.setSelectedItem("Selecione");
						comboBoxEscolaridade.setSelectedItem("Selecione");
						comboBoxFormaPagamento.setSelectedItem("Selecione");
						comboBoxTipoTrabalho.setSelectedItem("Selecione");
						comboBoxCargaHoraria.setSelectedItem("Selecione");
						labelNome.setText("Nome");
						labelNome.setForeground(Color.BLACK);
						labelDataNascimento.setText("Data de nascimento");
						labelDataNascimento.setForeground(Color.BLACK);
						labelCPF.setText("CPF");
						labelCPF.setForeground(Color.BLACK);
						labelRG.setText("RG");
						labelRG.setForeground(Color.BLACK);
						labelTelefone1.setText("Telefone 1");
						labelTelefone1.setForeground(Color.BLACK);
						labelCelular1.setText("Celular 1");
						labelCelular1.setForeground(Color.BLACK);
						labelEmail1.setText("Email 1");
						labelEmail1.setForeground(Color.BLACK);
						labelEscolaridade.setText("Escolaridade");
						labelEscolaridade.setForeground(Color.BLACK);
						labelLogin.setText("Login");
						labelLogin.setForeground(Color.BLACK);
						labelSenha.setText("Senha");
						labelSenha.setForeground(Color.BLACK);
						labelCarteiraTrabalho.setText("Carteira de trabalho");
						labelCarteiraTrabalho.setForeground(Color.BLACK);
						labelSalario.setText("Salario");
						labelSalario.setForeground(Color.BLACK);
						labelFormaPagamento.setText("Forma de pagamento");
						labelFormaPagamento.setForeground(Color.BLACK);
						labelNomeBanco.setText("Nome do banco");
						labelNomeBanco.setForeground(Color.BLACK);
						labelTipoTrabalho.setText("Tipo de trabalho");
						labelTipoTrabalho.setForeground(Color.BLACK);
						labelDataAdmissao.setText("Data de admissão");
						labelDataAdmissao.setForeground(Color.BLACK);
						labelHoraEntrada.setText("Hora de entrada");
						labelHoraEntrada.setForeground(Color.BLACK);
						labelHoraSaida.setText("Hora de saida");
						labelHoraSaida.setForeground(Color.BLACK);
						labelCargaHoraria.setText("Carga horaria diaria");
						labelCargaHoraria.setForeground(Color.BLACK);
						labelLimiteFaltas.setText("Limite de faltas");
						labelLimiteFaltas.setForeground(Color.BLACK);
						labelNacionalidade.setText("Nacionalidade");
						labelNacionalidade.setForeground(Color.BLACK);
						labelPaisOrigem.setText("Pais de origem");
						labelPaisOrigem.setForeground(Color.BLACK);
						labelCEP.setText("CEP");
						labelCEP.setForeground(Color.BLACK);
						labelEndereco.setText("Endereço");
						labelEndereco.setForeground(Color.BLACK);
						labelNumero.setText("Numero");
						labelNumero.setForeground(Color.BLACK);
						labelComplemento.setText("Complemento");
						labelComplemento.setForeground(Color.BLACK);
						labelBairro.setText("Bairro");
						labelBairro.setForeground(Color.BLACK);
						labelCidade.setText("Cidade");
						labelCidade.setForeground(Color.BLACK);
						labelEstado.setText("Estado");
						labelEstado.setForeground(Color.BLACK);
					}
					catch(NumberFormatException e2){
						String menssagemConteudo = "Campos numericos aceitam somente numeros e um ponto(valores quebrados)";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
				}
			}
		});
		salvar.setToolTipText("Salva o cadastro do funcionario");
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
						textNome.setText("");
						textDataNascimento.setText("");
						textCPF.setText("");
						textRG.setText("");
						textTelefone1.setText("");
						textTelefone2.setText("");
						textCelular1.setText("");
						textCelular2.setText("");
						textEmail1.setText("");
						textEmail2.setText("");
						textLogin.setText("");
						textSenha.setText("");
						textNacionalidade.setText("");
						textPaisOrigem.setText("");
						textNomePai.setText("");
						textNomeMae.setText("");
						textNomeBanco.setText("");
						textHoraSaida.setText("");
						textHoraEntrada.setText("");
						textDataAdmissao.setText("");
						textDataDemissao.setText("");
						textCargaHoraria.setText("");
						textLimiteFaltas.setText("");
						textCarteiraTrabalho.setText("");
						textSalario.setText("");
						textCEP.setText("");
						textEndereco.setText("");
						textNumero.setText("");
						textComplemento.setText("");
						textBairro.setText("");
						textCidade.setText("");
						textReferencia.setText("");
						buttonGroupSexo.clearSelection();
						buttonGroupEstadoCivil.clearSelection();
						buttonGroupCargo.clearSelection();
						comboBoxEstado.setSelectedItem("Selecione");
						comboBoxEscolaridade.setSelectedItem("Selecione");
						comboBoxFormaPagamento.setSelectedItem("Selecione");
						comboBoxTipoTrabalho.setSelectedItem("Selecione");
						comboBoxCargaHoraria.setSelectedItem("Selecione");
						labelNome.setText("Nome");
						labelNome.setForeground(Color.BLACK);
						labelDataNascimento.setText("Data de nascimento");
						labelDataNascimento.setForeground(Color.BLACK);
						labelCPF.setText("CPF");
						labelCPF.setForeground(Color.BLACK);
						labelRG.setText("RG");
						labelRG.setForeground(Color.BLACK);
						labelTelefone1.setText("Telefone 1");
						labelTelefone1.setForeground(Color.BLACK);
						labelCelular1.setText("Celular 1");
						labelCelular1.setForeground(Color.BLACK);
						labelEmail1.setText("Email 1");
						labelEmail1.setForeground(Color.BLACK);
						labelEscolaridade.setText("Escolaridade");
						labelEscolaridade.setForeground(Color.BLACK);
						labelLogin.setText("Login");
						labelLogin.setForeground(Color.BLACK);
						labelSenha.setText("Senha");
						labelSenha.setForeground(Color.BLACK);
						labelCarteiraTrabalho.setText("Carteira de trabalho");
						labelCarteiraTrabalho.setForeground(Color.BLACK);
						labelSalario.setText("Salario");
						labelSalario.setForeground(Color.BLACK);
						labelFormaPagamento.setText("Forma de pagamento");
						labelFormaPagamento.setForeground(Color.BLACK);
						labelNomeBanco.setText("Nome do banco");
						labelNomeBanco.setForeground(Color.BLACK);
						labelTipoTrabalho.setText("Tipo de trabalho");
						labelTipoTrabalho.setForeground(Color.BLACK);
						labelDataAdmissao.setText("Data de admissão");
						labelDataAdmissao.setForeground(Color.BLACK);
						labelHoraEntrada.setText("Hora de entrada");
						labelHoraEntrada.setForeground(Color.BLACK);
						labelHoraSaida.setText("Hora de saida");
						labelHoraSaida.setForeground(Color.BLACK);
						labelCargaHoraria.setText("Carga horaria diaria");
						labelCargaHoraria.setForeground(Color.BLACK);
						labelLimiteFaltas.setText("Limite de faltas");
						labelLimiteFaltas.setForeground(Color.BLACK);
						labelNacionalidade.setText("Nacionalidade");
						labelNacionalidade.setForeground(Color.BLACK);
						labelPaisOrigem.setText("Pais de origem");
						labelPaisOrigem.setForeground(Color.BLACK);
						labelCEP.setText("CEP");
						labelCEP.setForeground(Color.BLACK);
						labelEndereco.setText("Endereço");
						labelEndereco.setForeground(Color.BLACK);
						labelNumero.setText("Numero");
						labelNumero.setForeground(Color.BLACK);
						labelComplemento.setText("Complemento");
						labelComplemento.setForeground(Color.BLACK);
						labelBairro.setText("Bairro");
						labelBairro.setForeground(Color.BLACK);
						labelCidade.setText("Cidade");
						labelEstado.setText("Estado");
						labelEstado.setForeground(Color.BLACK);
						labelCidade.setForeground(Color.BLACK);
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
					buttonGroupSexo.getSelection() != null || buttonGroupEstadoCivil.getSelection() != null ||
					textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
					textTelefone2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
					textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
					textCelular2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
					textEmail1.getText().length() != 0 || textEmail2.getText().length() != 0 ||
					comboBoxEscolaridade.getSelectedItem() != "Selecione" || textNacionalidade.getText().length() != 0 ||
					textPaisOrigem.getText().length() != 0 || textNomeMae.getText().length() != 0 ||
					textNomePai.getText().length() != 0 || textLogin.getText().length() != 0 ||
					textSenha.getPassword().length != 0 || buttonGroupCargo.getSelection() != null || 
					textCarteiraTrabalho.getText().length() != 0 || textSalario.getText().length() != 0 ||
					comboBoxFormaPagamento.getSelectedItem() != "Selecione" || textNomeBanco.getText().length() != 0 ||
					comboBoxTipoTrabalho.getSelectedItem() != "Selecione" || 
					textDataAdmissao.getText().replaceAll("\\/", "").trim().length() != 0 ||
					textDataDemissao.getText().replaceAll("\\/", "").trim().length() != 0 ||
					textHoraEntrada.getText().replace(":","").trim().length() != 0 || 
					textHoraSaida.getText().replace(":","").trim().length() != 0 ||
					textCargaHoraria.getText().length() != 0 || comboBoxCargaHoraria.getSelectedItem() != "Selecione" ||
					textLimiteFaltas.getText().length() != 0 || comboBoxEstado.getSelectedItem() != "Selecione" ||
					textCEP.getText().replace("-","").trim().length() != 0 || textCidade.getText().length() != 0 ||
					textEndereco.getText().length() != 0 ||	textNumero.getText().length() != 0 ||
					textComplemento.getText().length() != 0 || textReferencia.getText().length() != 0) {
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
    					buttonGroupSexo.getSelection() != null || buttonGroupEstadoCivil.getSelection() != null ||
    					textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
    					textTelefone2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
    					textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
    					textCelular2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
    					textEmail1.getText().length() != 0 || textEmail2.getText().length() != 0 ||
    					comboBoxEscolaridade.getSelectedItem() != "Selecione" || textNacionalidade.getText().length() != 0 ||
    					textPaisOrigem.getText().length() != 0 || textNomeMae.getText().length() != 0 ||
    					textNomePai.getText().length() != 0 || textLogin.getText().length() != 0 ||
    					textSenha.getPassword().length != 0 || buttonGroupCargo.getSelection() != null || 
    					textCarteiraTrabalho.getText().length() != 0 || textSalario.getText().length() != 0 ||
    					comboBoxFormaPagamento.getSelectedItem() != "Selecione" || textNomeBanco.getText().length() != 0 ||
    					comboBoxTipoTrabalho.getSelectedItem() != "Selecione" || 
    					textDataAdmissao.getText().replaceAll("\\/", "").trim().length() != 0 ||
    					textDataDemissao.getText().replaceAll("\\/", "").trim().length() != 0 ||
    					textHoraEntrada.getText().replace(":","").trim().length() != 0 || 
    					textHoraSaida.getText().replace(":","").trim().length() != 0 ||
    					textCargaHoraria.getText().length() != 0 || comboBoxCargaHoraria.getSelectedItem() != "Selecione" ||
    					textLimiteFaltas.getText().length() != 0 || comboBoxEstado.getSelectedItem() != "Selecione" ||
    					textCEP.getText().replace("-","").trim().length() != 0 || textCidade.getText().length() != 0 ||
    					textEndereco.getText().length() != 0 ||	textNumero.getText().length() != 0 ||
    					textComplemento.getText().length() != 0 || textReferencia.getText().length() != 0) {
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