package moduloFuncionarioTelas;

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
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
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
import moduloFuncionarioBD.Dao_alterar_dados_funcionario;
import moduloFuncionarioBD.Dao_consulta_dados_funcionario;
import moduloFuncionarioBD.Funcionario;
import moduloFuncionarioBD.FuncionarioFeriasFolga;
import moduloFuncionarioBD.FuncionarioFrequencia;
import moduloFuncionarioBD.FuncionarioFrequenciaFaltas;
import moduloFuncionarioBD.FuncionarioSalario;

public class Ficha_do_Funcionario_Editar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaFuncionarioEditar;
	private JTextField textEndereco, textBairro, textNumero, textComplemento, textCidade, textNome, textReferencia;
	private JTextField textEmail1, textEmail2, textLogin, textCarteiraTrabalho, textSalario, textLimiteFaltas;
	private JTextField textNacionalidade, textPaisOrigem, textNomePai, textNomeMae, textNomeBanco, textCargaHoraria;
	private JPasswordField textSenha;
	private JFormattedTextField textCEP, textCPF, textRG, textTelefone1, textTelefone2, textCelular1,textCelular2;
	private JFormattedTextField textDataNascimento, textDataAdmissao, textDataDemissao,textHoraSaida, textHoraEntrada;
	private final ButtonGroup buttonGroupSexo = new ButtonGroup();
	private final ButtonGroup buttonGroupCargo = new ButtonGroup();
	private final ButtonGroup buttonGroupEstadoCivil = new ButtonGroup();
	private JRadioButton radioMasculino, radioFeminino, radioSolteiro, radioCasado,radioOutro, radioAtendente, radioGerente, radioCarregador;
	private JComboBox<String> comboBoxEstado, comboBoxEscolaridade, comboBoxFormaPagamento, comboBoxCargaHoraria, comboBoxTipoTrabalho;
	private JLabel codigoFuncionario;
	private JButton salvar, cancelar;
	SimpleDateFormat dataNascimentoFormato, dataAdmissaoFormato, dataDemissaoFormato;
	SimpleDateFormat horaEntradaFormato, horaSaidaFormato;
	Date data, dataInicio, dataTermino;
	Time horaInicio, horaTermino;
	String dataNascimentoFun, dataAdmissaoFun, dataDemissaoFun, horaEntradaFun, horaSaidaFun, cadastroReferencia;
	String sexoFun, estadoCivilFun, cargoFun, cadastroEmail1, cadastroEmail2, cadastroTelefone1, cadastroTelefone2;
	String cadastroCelular1, cadastroCelular2, cadastroCEP, cargaHoraria, cargaHorariaValor, cargaHorariaUnidade, maximoFaltasValor;
	Funcionario alterarCadastroFuncionario;
	FuncionarioFrequencia alterarCadastroFuncionarioFrequencia;
	FuncionarioFrequenciaFaltas AlteraDadosFuncionarioFrequenciaFaltas;
	FuncionarioSalario AlteraDadosFuncionarioSalario;
	FuncionarioFeriasFolga AlteraDadosFuncionarioFeriasFolga;
	Dao_alterar_dados_funcionario salvaNovosDados, salvaNovosDadosHistorico, salvaNovosDadosNomeCargoFaltas, salvaNovosDadosSalarioNomeCargo, salvaNovosDadosFeriasFolgasNomeCargo;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficha_do_Funcionario_Editar frame = new Ficha_do_Funcionario_Editar();
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
	public Ficha_do_Funcionario_Editar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ficha_do_Funcionario_Editar.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setSize(1000, 600);
		
		telaFichaFuncionarioEditar = new JPanel();
		telaFichaFuncionarioEditar.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaFuncionarioEditar.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaFuncionarioEditar);
		
		JPanel panelTitulo = new JPanel();
		telaFichaFuncionarioEditar.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Ficha_do_Funcionario_Editar.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFichaFuncionario = new JLabel("Ficha do funcionario");
		panelTitulo2.add(labelFichaFuncionario);
		labelFichaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Ficha_do_Funcionario_Editar.class.getResource("/cImagens/Funcionario.png")));
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
		
		/*Parte da ficha dados pessoais do funcionario*/
		JTabbedPane fichaFuncionario = new JTabbedPane(JTabbedPane.TOP);
		telaFichaFuncionarioEditar.add(fichaFuncionario, BorderLayout.CENTER);
		JPanel panelDadosPessoais = new JPanel();
		fichaFuncionario.addTab("Dados pessoais", null, panelDadosPessoais, null);
		panelDadosPessoais.setLayout(new BorderLayout(0, 0));
		
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
		
		JScrollPane scrollPaneDadosPessoais = new JScrollPane();
		scrollPaneDadosPessoais.getVerticalScrollBar().setUnitIncrement(10);
		panelDadosPessoais.add(scrollPaneDadosPessoais);
		
		JPanel panelFichaDadosPessoais = new JPanel();
		scrollPaneDadosPessoais.setViewportView(panelFichaDadosPessoais);
		panelFichaDadosPessoais.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelFichaParteA1 = new JPanel();
		panelFichaDadosPessoais.add(panelFichaParteA1);
		panelFichaParteA1.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelNome_CodFun = new JPanel();
		panelFichaParteA1.add(panelNome_CodFun);
		panelNome_CodFun.setLayout(new BorderLayout(5, 0));
		
		JPanel panelNome = new JPanel();
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome_CodFun.add(panelNome);
		panelNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeFuncionario = new JLabel("Nome");
		panelNome.add(labelNomeFuncionario);
		labelNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textNome = new JTextField();
		panelNome.add(textNome);
		textNome.setHorizontalAlignment(SwingConstants.LEFT);
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCodigoFuncionario = new JPanel();
		panelCodigoFuncionario.setPreferredSize(new Dimension(200, 10));
		panelNome_CodFun.add(panelCodigoFuncionario, BorderLayout.EAST);
		panelCodigoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoFuncionario = new JLabel("Codigo do funcionario");
		labelCodigoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFuncionario.add(labelCodigoFuncionario);
		
		codigoFuncionario = new JLabel();
		codigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFuncionario.add(codigoFuncionario);
		
		JPanel panelData_RG_CPF = new JPanel();
		panelFichaParteA1.add(panelData_RG_CPF);
		panelData_RG_CPF.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelCadastroDataHora = new JPanel();
		panelCadastroDataHora.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_RG_CPF.add(panelCadastroDataHora);
		panelCadastroDataHora.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCadastroDataHora = new JLabel("Data e hora do cadastro");
		labelCadastroDataHora.setHorizontalAlignment(SwingConstants.LEFT);
		labelCadastroDataHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCadastroDataHora.add(labelCadastroDataHora);
		
		JLabel dataHoraCadastro = new JLabel();
		panelCadastroDataHora.add(dataHoraCadastro);
		dataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelRG = new JPanel();
		panelData_RG_CPF.add(panelRG);
		panelRG.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRG.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelRG = new JLabel("RG");
		panelRG.add(labelRG);
		labelRG.setHorizontalAlignment(SwingConstants.LEFT);
		labelRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textRG = new JFormattedTextField(numeroRGMascara);
		panelRG.add(textRG);
		textRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCPF = new JPanel();
		panelCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_RG_CPF.add(panelCPF);
		panelCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPF = new JLabel("CPF");
		panelCPF.add(labelCPF);
		labelCPF.setHorizontalAlignment(SwingConstants.LEFT);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCPF = new JFormattedTextField(numeroCPFMascara);
		panelCPF.add(textCPF);
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelDaNasc_Sexo_EstCivil = new JPanel();
		panelFichaParteA1.add(panelDaNasc_Sexo_EstCivil);
		panelDaNasc_Sexo_EstCivil.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelDataNascimento = new JPanel();
		panelDataNascimento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDaNasc_Sexo_EstCivil.add(panelDataNascimento);
		panelDataNascimento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataDeNascimento = new JLabel("Data de nascimento");
		panelDataNascimento.add(labelDataDeNascimento);
		labelDataDeNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textDataNascimento = new JFormattedTextField(dataNascimentoMascara);
		panelDataNascimento.add(textDataNascimento);
		textDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelSexo = new JPanel();
		panelSexo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDaNasc_Sexo_EstCivil.add(panelSexo);
		panelSexo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSexo = new JLabel("Sexo");
		panelSexo.add(labelSexo);
		labelSexo.setHorizontalAlignment(SwingConstants.LEFT);
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelSexo2 = new JPanel();
		FlowLayout fl_panelSexo2 = (FlowLayout) panelSexo2.getLayout();
		fl_panelSexo2.setVgap(0);
		fl_panelSexo2.setHgap(0);
		fl_panelSexo2.setAlignment(FlowLayout.LEFT);
		panelSexo.add(panelSexo2);
		
		radioMasculino = new JRadioButton("Masculino");
		buttonGroupSexo.add(radioMasculino);
		panelSexo2.add(radioMasculino);
		radioMasculino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		radioFeminino = new JRadioButton("Feminino");
		buttonGroupSexo.add(radioFeminino);
		radioFeminino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelSexo2.add(radioFeminino);
		
		JPanel panelEstadoCivil = new JPanel();
		panelDaNasc_Sexo_EstCivil.add(panelEstadoCivil);
		panelEstadoCivil.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstadoCivil.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstadoCivil = new JLabel("Estado civil");
		labelEstadoCivil.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoCivil.add(labelEstadoCivil);
		
		JPanel panelEstadoCivil2 = new JPanel();
		FlowLayout fl_panelEstadoCivil2 = (FlowLayout) panelEstadoCivil2.getLayout();
		fl_panelEstadoCivil2.setVgap(0);
		fl_panelEstadoCivil2.setHgap(0);
		fl_panelEstadoCivil2.setAlignment(FlowLayout.LEFT);
		panelEstadoCivil.add(panelEstadoCivil2);
		
		radioSolteiro = new JRadioButton("Solteiro");
		buttonGroupEstadoCivil.add(radioSolteiro);
		radioSolteiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoCivil2.add(radioSolteiro);
		
		radioCasado = new JRadioButton("Casado");
		buttonGroupEstadoCivil.add(radioCasado);
		radioCasado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoCivil2.add(radioCasado);
		
		radioOutro = new JRadioButton("Outro");
		buttonGroupEstadoCivil.add(radioOutro);
		radioOutro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoCivil2.add(radioOutro);
		
		JPanel panelFichaParteA2 = new JPanel();
		panelFichaDadosPessoais.add(panelFichaParteA2);
		panelFichaParteA2.setLayout(new GridLayout(3, 1, 5, 5));
		
		JPanel panelTelefone_Celular = new JPanel();
		panelFichaParteA2.add(panelTelefone_Celular);
		panelTelefone_Celular.setLayout(new GridLayout(0, 4, 5, 0));
		
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
		textTelefone1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTelefone2 = new JPanel();
		panelTelefone_Celular.add(panelTelefone2);
		panelTelefone2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTelefone2 = new JLabel("Telefone 2");
		labelTelefone2.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTelefone2.add(labelTelefone2);
		
		textTelefone2 = new JFormattedTextField(numeroTelefone2Mascara);
		textTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTelefone2.add(textTelefone2);
		
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
		labelCelular2.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCelular2.add(labelCelular2);
		
		textCelular2 = new JFormattedTextField(numeroCelular2Mascara);
		textCelular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCelular2.add(textCelular2);
		
		JPanel panelEmail = new JPanel();
		panelFichaParteA2.add(panelEmail);
		panelEmail.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelEmail1 = new JPanel();
		panelEmail.add(panelEmail1);
		panelEmail1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail1.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel labelEmail1 = new JLabel("Email 1");
		panelEmail1.add(labelEmail1);
		labelEmail1.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textEmail1 = new JTextField();
		panelEmail1.add(textEmail1);
		textEmail1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEmail2 = new JPanel();
		panelEmail.add(panelEmail2);
		panelEmail2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail2 = new JLabel("Email 2");
		panelEmail2.add(labelEmail2);
		labelEmail2.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textEmail2 = new JTextField("");
		panelEmail2.add(textEmail2);
		textEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEs_Na_Pa = new JPanel();
		panelFichaParteA2.add(panelEs_Na_Pa);
		panelEs_Na_Pa.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelEscolaridade = new JPanel();
		panelEs_Na_Pa.add(panelEscolaridade);
		panelEscolaridade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEscolaridade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEscolaridade = new JLabel("Escolaridade");
		labelEscolaridade.setHorizontalAlignment(SwingConstants.LEFT);
		labelEscolaridade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEscolaridade.add(labelEscolaridade);
		
		comboBoxEscolaridade = new JComboBox<String>();
		comboBoxEscolaridade.setMaximumRowCount(5);
		comboBoxEscolaridade.addItem("Selecione");
		comboBoxEscolaridade.addItem("Primario");
		comboBoxEscolaridade.addItem("Primeiro grau");
		comboBoxEscolaridade.addItem("Segundo grau");
		comboBoxEscolaridade.addItem("Superior");
		comboBoxEscolaridade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEscolaridade.add(comboBoxEscolaridade);
		
		JPanel panelNacionalidade = new JPanel();
		panelEs_Na_Pa.add(panelNacionalidade);
		panelNacionalidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNacionalidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNacionalidade = new JLabel("Nacionalidade");
		labelNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNacionalidade.add(labelNacionalidade);
		
		textNacionalidade = new JTextField();
		textNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		textNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNacionalidade.add(textNacionalidade);
		
		JPanel panelPaisOrigem = new JPanel();
		panelEs_Na_Pa.add(panelPaisOrigem);
		panelPaisOrigem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPaisOrigem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPaisOrigem = new JLabel("Pais de origem");
		labelPaisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		labelPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(labelPaisOrigem);
		
		textPaisOrigem = new JTextField();
		textPaisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		textPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(textPaisOrigem);
		
		JPanel panelFichaParteA3 = new JPanel();
		panelFichaDadosPessoais.add(panelFichaParteA3);
		panelFichaParteA3.setLayout(new GridLayout(3, 1, 5, 5));
		
		JPanel panelNomeMae_NomePai = new JPanel();
		panelFichaParteA3.add(panelNomeMae_NomePai);
		panelNomeMae_NomePai.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeMae = new JPanel();
		panelNomeMae_NomePai.add(panelNomeMae);
		panelNomeMae.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeMae.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeMae = new JLabel("Nome da M\u00E3e");
		labelNomeMae.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeMae.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeMae.add(labelNomeMae);
		
		textNomeMae = new JTextField();
		textNomeMae.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeMae.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeMae.add(textNomeMae);
		
		JPanel panelNomePai = new JPanel();
		panelNomeMae_NomePai.add(panelNomePai);
		panelNomePai.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomePai.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomePai = new JLabel("Nome do Pai");
		labelNomePai.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomePai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomePai.add(labelNomePai);
		
		textNomePai = new JTextField("");
		textNomePai.setHorizontalAlignment(SwingConstants.LEFT);
		textNomePai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomePai.add(textNomePai);
		
		JPanel panelLogin_Senha_Cargo = new JPanel();
		panelFichaParteA3.add(panelLogin_Senha_Cargo);
		panelLogin_Senha_Cargo.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelLogin = new JPanel();
		panelLogin_Senha_Cargo.add(panelLogin);
		panelLogin.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelLogin.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setHorizontalAlignment(SwingConstants.LEFT);
		labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelLogin.add(labelLogin);
		
		textLogin = new JTextField("");
		textLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelLogin.add(textLogin);
		
		JPanel panelSenha = new JPanel();
		panelLogin_Senha_Cargo.add(panelSenha);
		panelSenha.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelSenha.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSenha = new JLabel("Senha");
		panelSenha.add(labelSenha);
		labelSenha.setHorizontalAlignment(SwingConstants.LEFT);
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textSenha = new JPasswordField("");
		panelSenha.add(textSenha);
		textSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCargo = new JPanel();
		panelLogin_Senha_Cargo.add(panelCargo);
		panelCargo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargo = new JLabel("Cargo");
		panelCargo.add(labelCargo);
		labelCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCargo2 = new JPanel();
		FlowLayout fl_panelCargo2 = (FlowLayout) panelCargo2.getLayout();
		fl_panelCargo2.setVgap(0);
		fl_panelCargo2.setAlignment(FlowLayout.LEFT);
		fl_panelCargo2.setHgap(0);
		panelCargo.add(panelCargo2);
		
		radioAtendente = new JRadioButton("Atendente");
		buttonGroupCargo.add(radioAtendente);
		panelCargo2.add(radioAtendente);
		radioAtendente.setHorizontalAlignment(SwingConstants.LEFT);
		radioAtendente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		radioGerente = new JRadioButton("Gerente");
		buttonGroupCargo.add(radioGerente);
		radioGerente.setHorizontalAlignment(SwingConstants.LEFT);
		radioGerente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargo2.add(radioGerente);
		
		radioCarregador = new JRadioButton("Carregador");
		buttonGroupCargo.add(radioCarregador);
		radioCarregador.setHorizontalAlignment(SwingConstants.LEFT);
		radioCarregador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargo2.add(radioCarregador);
		
		JPanel panelCartTrab_Sal_ForPag_NomeBanco = new JPanel();
		panelFichaParteA3.add(panelCartTrab_Sal_ForPag_NomeBanco);
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
		textCarteiraTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelSalario = new JPanel();
		panelCartTrab_Sal_ForPag_NomeBanco.add(panelSalario);
		panelSalario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelSalario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSalario = new JLabel("Salario (R$)");
		panelSalario.add(labelSalario);
		labelSalario.setHorizontalAlignment(SwingConstants.LEFT);
		labelSalario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textSalario = new JTextField();
		panelSalario.add(textSalario);
		textSalario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PlainDocument documentSalario = (PlainDocument) textSalario.getDocument();
		documentSalario.setDocumentFilter(new ValidaNumeroDouble());
		
		JPanel panelFormaPagamento = new JPanel();
		panelCartTrab_Sal_ForPag_NomeBanco.add(panelFormaPagamento);
		panelFormaPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFormaPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFormaPagamento = new JLabel("Forma de pagamento");
		labelFormaPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		labelFormaPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFormaPagamento.add(labelFormaPagamento);
		
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
		panelFormaPagamento.add(comboBoxFormaPagamento);
		
		JPanel panelNomeBanco = new JPanel();
		panelCartTrab_Sal_ForPag_NomeBanco.add(panelNomeBanco);
		panelNomeBanco.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeBanco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeBanco = new JLabel("Nome do banco");
		labelNomeBanco.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeBanco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeBanco.add(labelNomeBanco);
		
		textNomeBanco = new JTextField();
		textNomeBanco.setHorizontalAlignment(SwingConstants.LEFT);
		textNomeBanco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeBanco.add(textNomeBanco);
		
		JPanel panelFichaParteA4 = new JPanel();
		panelFichaDadosPessoais.add(panelFichaParteA4);
		panelFichaParteA4.setLayout(new GridLayout(3, 1, 5, 5));
		
		JPanel panelTipoTrabalho_Data = new JPanel();
		panelFichaParteA4.add(panelTipoTrabalho_Data);
		panelTipoTrabalho_Data.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelTipoTrabalho = new JPanel();
		panelTipoTrabalho_Data.add(panelTipoTrabalho);
		panelTipoTrabalho.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoTrabalho.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoTrabalho = new JLabel("Tipo de trabalho");
		labelTipoTrabalho.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoTrabalho.add(labelTipoTrabalho);
		
		comboBoxTipoTrabalho = new JComboBox<String>();
		comboBoxTipoTrabalho.setMaximumRowCount(4);
		comboBoxTipoTrabalho.addItem("Selecione");
		comboBoxTipoTrabalho.addItem("Fixo");
		comboBoxTipoTrabalho.addItem("Temporário");
		comboBoxTipoTrabalho.addItem("Estagio");
		comboBoxTipoTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoTrabalho.add(comboBoxTipoTrabalho);
		
		JPanel panelDataAdmissao = new JPanel();
		panelTipoTrabalho_Data.add(panelDataAdmissao);
		panelDataAdmissao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataAdmissao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataAdmissao = new JLabel("Data de admiss\u00E3o");
		labelDataAdmissao.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataAdmissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataAdmissao.add(labelDataAdmissao);
		
		textDataAdmissao = new JFormattedTextField(dataAdmissaoMascara);
		textDataAdmissao.setHorizontalAlignment(SwingConstants.LEFT);
		textDataAdmissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataAdmissao.add(textDataAdmissao);
		
		JPanel panelDataDemissao = new JPanel();
		panelTipoTrabalho_Data.add(panelDataDemissao);
		panelDataDemissao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataDemissao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataDemissao = new JLabel("Data de demiss\u00E3o");
		labelDataDemissao.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataDemissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataDemissao.add(labelDataDemissao);
		
		textDataDemissao = new JFormattedTextField(dataDemissaotoMascara);
		textDataDemissao.setHorizontalAlignment(SwingConstants.LEFT);
		textDataDemissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataDemissao.add(textDataDemissao);
		
		JPanel panelHorarioLimiteFaltas = new JPanel();
		panelFichaParteA4.add(panelHorarioLimiteFaltas);
		panelHorarioLimiteFaltas.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelHoraEntrada = new JPanel();
		panelHorarioLimiteFaltas.add(panelHoraEntrada);
		panelHoraEntrada.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHoraEntrada.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraInicio = new JLabel("Hora de entrada");
		labelHoraInicio.setHorizontalAlignment(SwingConstants.LEFT);
		labelHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelHoraEntrada.add(labelHoraInicio);
		
		textHoraEntrada = new JFormattedTextField(horaEntradaMascara);
		textHoraEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		textHoraEntrada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelHoraEntrada.add(textHoraEntrada);
		
		JPanel panelHoraSaida = new JPanel();
		panelHorarioLimiteFaltas.add(panelHoraSaida);
		panelHoraSaida.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHoraSaida.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraSaida = new JLabel("Hora de saida");
		labelHoraSaida.setHorizontalAlignment(SwingConstants.LEFT);
		labelHoraSaida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelHoraSaida.add(labelHoraSaida);
		
		textHoraSaida = new JFormattedTextField(horaSaidaMascara);
		textHoraSaida.setHorizontalAlignment(SwingConstants.LEFT);
		textHoraSaida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelHoraSaida.add(textHoraSaida);
		
		JPanel panelCargaHoraria = new JPanel();
		panelHorarioLimiteFaltas.add(panelCargaHoraria);
		panelCargaHoraria.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargaHoraria.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargaHoraria = new JLabel("Carga horaria por dia");
		labelCargaHoraria.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargaHoraria.add(labelCargaHoraria);
		
		JPanel panelCargaHoraria2 = new JPanel();
		panelCargaHoraria.add(panelCargaHoraria2);
		panelCargaHoraria2.setLayout(new BorderLayout(0, 0));
		
		textCargaHoraria = new JTextField();
		panelCargaHoraria2.add(textCargaHoraria);
		textCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCargaHoraria.setColumns(10);
		textCargaHoraria.setDocument(new ValidaNumeroInteiro());
		
		comboBoxCargaHoraria = new JComboBox<String>();
		panelCargaHoraria2.add(comboBoxCargaHoraria, BorderLayout.EAST);
		comboBoxCargaHoraria.addItem("Selecione");
		comboBoxCargaHoraria.addItem("hora(s)");
		comboBoxCargaHoraria.addItem("minuto(s)");
		comboBoxCargaHoraria.setMaximumRowCount(5);
		comboBoxCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelLimiteFaltas = new JPanel();
		panelLimiteFaltas.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHorarioLimiteFaltas.add(panelLimiteFaltas);
		panelLimiteFaltas.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLimiteFaltas = new JLabel("Limite de faltas");
		labelLimiteFaltas.setHorizontalAlignment(SwingConstants.LEFT);
		labelLimiteFaltas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelLimiteFaltas.add(labelLimiteFaltas);
		
		textLimiteFaltas = new JTextField();
		panelLimiteFaltas.add(textLimiteFaltas);
		textLimiteFaltas.setColumns(10);
		textLimiteFaltas.setDocument(new ValidaNumeroInteiro());
		
		JPanel panelEstado_CEP_Cidade = new JPanel();
		panelFichaParteA4.add(panelEstado_CEP_Cidade);
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
		panelEstado.add(comboBoxEstado);
		comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCEP = new JPanel();
		panelEstado_CEP_Cidade.add(panelCEP);
		panelCEP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
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
		
		JPanel panelFichaParteA5 = new JPanel();
		panelFichaDadosPessoais.add(panelFichaParteA5);
		panelFichaParteA5.setLayout(new GridLayout(3, 1, 5, 5));
		
		JPanel panelEndereco = new JPanel();
		panelFichaParteA5.add(panelEndereco);
		panelEndereco.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEndereco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o");
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEndereco.add(labelEndereco);
		
		textEndereco = new JTextField();
		textEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEndereco.add(textEndereco);
		
		JPanel panelNume_Comp_Bairro = new JPanel();
		panelFichaParteA5.add(panelNume_Comp_Bairro);
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
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelComplemento = new JPanel();
		panelNume_Comp_Bairro.add(panelComplemento);
		panelComplemento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComplemento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComplemento = new JLabel("Complemento");
		labelComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelComplemento.add(labelComplemento);
		
		textComplemento = new JTextField();
		textComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		textComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelComplemento.add(textComplemento);
		
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
		textBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelReferencia = new JPanel();
		panelFichaParteA5.add(panelReferencia);
		panelReferencia.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelReferencia.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelReferencia = new JLabel("Referencia");
		labelReferencia.setHorizontalAlignment(SwingConstants.LEFT);
		labelReferencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelReferencia.add(labelReferencia);
		
		textReferencia = new JTextField();
		textReferencia.setHorizontalAlignment(SwingConstants.LEFT);
		textReferencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelReferencia.add(textReferencia);
		
		/*Parte que consulta os dados no banco de dados*/
		String codigoFuncionarioConsulta = sessao.getCodigoFuncionario();
		String nomeFuncionarioConsulta = sessao.getNomeFuncionario();
		String cargoFuncionarioConsulta = sessao.getCargoFuncionario();
		Dao_consulta_dados_funcionario teste = new Dao_consulta_dados_funcionario();
    	List<Funcionario> Consulta = teste.Consulta_Dados_Funcionario_Ficha(codigoFuncionarioConsulta, nomeFuncionarioConsulta, cargoFuncionarioConsulta);
    	for (Funcionario leitura : Consulta) {
    		String nomeFuncionarioTexto = leitura.getNome();
    		textNome.setText(nomeFuncionarioTexto);
    		
    		String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
    		codigoFuncionario.setText(codigoFuncionarioTexto);
    		
    		String rgFuncionarioTexto = leitura.getRG();
    		textRG.setText(rgFuncionarioTexto);
    		
    		String cpfFuncionarioTexto = leitura.getCPF();
    		textCPF.setText(cpfFuncionarioTexto);
    		
    		Date dataNascimentoFuncionario = leitura.getDataNascimento();
    		SimpleDateFormat dataNascimentoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataNacimentoValor = dataNascimentoFormato.format(dataNascimentoFuncionario);
    		textDataNascimento.setText(dataNacimentoValor);
    		
    		String sexoFuncionario = leitura.getSexo();
    		if (sexoFuncionario.equals("Masculino") ) {
    			radioMasculino.setSelected(true);
			}
    		if (sexoFuncionario.equals("Feminino")) {
    			radioFeminino.setSelected(true);
			}
    		
    		String estadoCivilFuncionario = leitura.getEstadoCivil();
    		if (estadoCivilFuncionario.equals("Solteiro")) {
    			radioSolteiro.setSelected(true);
			}
    		if (estadoCivilFuncionario.equals("Casado")) {
    			radioCasado.setSelected(true);
			}
    		if (estadoCivilFuncionario.equals("Outro")) {
    			radioOutro.setSelected(true);
			}
    		
    		String telefone1Funcionario = leitura.getTelefone1();
    		textTelefone1.setText(telefone1Funcionario);
    		
    		String telefone2Funcionario = leitura.getTelefone2();
    		textTelefone2.setText(telefone2Funcionario);
    		
    		String celular1Funcionario = leitura.getCelular1();
    		textCelular1.setText(celular1Funcionario);
    		
    		String celular2Funcionario = leitura.getCelular2();
    		textCelular2.setText(celular2Funcionario);
    		
    		String email1Funcionario = leitura.getEmail1();
    		textEmail1.setText(email1Funcionario);
    		
    		String email2Funcionario = leitura.getEmail2();
    		textEmail2.setText(email2Funcionario);

    		String escolaridadeFuncionario = leitura.getEscolaridade();
    		comboBoxEscolaridade.setSelectedItem(escolaridadeFuncionario);
    		
    		String nacionalidadeFuncionario = leitura.getNacionalidade();
    		textNacionalidade.setText(nacionalidadeFuncionario);
    		
    		String paisOrigemFuncionario = leitura.getPaisOrigem();
    		textPaisOrigem.setText(paisOrigemFuncionario);
    		
    		String nomeMaeFuncionario = leitura.getNomeMae();
    		textNomeMae.setText(nomeMaeFuncionario);
    		
    		String nomePaiFuncionario = leitura.getNomePai();
    		textNomePai.setText(nomePaiFuncionario);
    		
    		String loginFuncionario = leitura.getLogin();
    		textLogin.setText(loginFuncionario);
    		
    		String senhaFuncionario = leitura.getSenha();
    		textSenha.setText(senhaFuncionario);
    		
    		String cargoFuncionario = leitura.getCargo();
    		if (cargoFuncionario.equals("Atendente")) {
    			radioAtendente.setSelected(true);
			}
    		else if (cargoFuncionario.equals("Gerente")) {
    			radioGerente.setSelected(true);
			}
    		else if (cargoFuncionario.equals("Carregador")) {
    			radioCarregador.setSelected(true);
			}
    		
    		String carteiraTrabalhoFuncionario = leitura.getCarteiraTrabalho();
    		textCarteiraTrabalho.setText(carteiraTrabalhoFuncionario);
    		
    		String salarioFuncionario = "" + leitura.getSalario();
    		textSalario.setText(salarioFuncionario);
    		
    		String formaPagamentoFuncionario = leitura.getFormaPagamento();
    		comboBoxFormaPagamento.setSelectedItem(formaPagamentoFuncionario);
    		
    		String nomeBancoFuncionario = leitura.getNomeBanco();
    		textNomeBanco.setText(nomeBancoFuncionario);
    		
    		String tipoTrabalhoFuncionario = leitura.getTipoTrabalho();
    		comboBoxTipoTrabalho.setSelectedItem(tipoTrabalhoFuncionario);
    		
    		Date dataAdmissaoFuncionario =	leitura.getDataAdmissao();
    		SimpleDateFormat dataAdmissaoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataAdmissaoValor = dataAdmissaoFormato.format(dataAdmissaoFuncionario);
    		textDataAdmissao.setText(dataAdmissaoValor);
    		
    		Date dataDemissaoFuncionario =	leitura.getDataDemissao();
    		if (dataDemissaoFuncionario == null) {
    			String dataDemissaoValorTexto = "";
    			textDataDemissao.setText(dataDemissaoValorTexto);
			}
    		else {
				SimpleDateFormat dataDemissaoFormato = new SimpleDateFormat("dd/MM/yyyy");
	    		String dataDemissaoValor = dataDemissaoFormato.format(dataDemissaoFuncionario);
	    		textDataDemissao.setText(dataDemissaoValor);
			}
    		
    		Time horaInicioFuncionario = leitura.getHoraEntrada();
    		SimpleDateFormat horaInicioFormato = new SimpleDateFormat("HH:mm");
    		String horaInicioValor = horaInicioFormato.format(horaInicioFuncionario);
    		textHoraEntrada.setText(horaInicioValor);
    		
    		Time horaSaidaFuncionario = leitura.getHoraSaida();
    		SimpleDateFormat horaSaidaFormato = new SimpleDateFormat("HH:mm");
    		String horaSaidaValor = horaSaidaFormato.format(horaSaidaFuncionario);
    		textHoraSaida.setText(horaSaidaValor);
    		
    		String cargaHorariaValor = leitura.getCargaHoraria();
    		String cargaHorariaUnidade = leitura.getCargaHorariaUnidade();
    		textCargaHoraria.setText(cargaHorariaValor);
    		comboBoxCargaHoraria.setSelectedItem(cargaHorariaUnidade);
    		
    		int limiteFaltasValor  = leitura.getLimiteFaltas();
    		String limiteFaltasTexto = "" + limiteFaltasValor;
    		textLimiteFaltas.setText(limiteFaltasTexto);
    		
    		Date dataCadastroCliente =	leitura.getDataCadastro();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroCliente);
    		Time horaCadastroCliente = leitura.getHoraCadastro();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroCliente);
    		String DataHoraCadastroiTexto = dataCadastroValor + " " + horaCadastroValor;
    		dataHoraCadastro.setText(DataHoraCadastroiTexto);
    		
    		String estadoFuncionario = leitura.getEstado();
    		comboBoxEstado.setSelectedItem(estadoFuncionario);
    		
    		String cepFuncionario = leitura.getCEP();
    		textCEP.setText(cepFuncionario);
    		
    		String cidadeFuncionario = leitura.getCidade();
    		textCidade.setText(cidadeFuncionario);
    		
    		String enderecoFuncionario = leitura.getEndereco();
    		textEndereco.setText(enderecoFuncionario);
    		
    		String numeroFuncionario = leitura.getNumero();
    		textNumero.setText(numeroFuncionario);
    		
    		String complementoFuncionario = leitura.getComplemento();
    		textComplemento.setText(complementoFuncionario);
    		
    		String bairroFuncionario = leitura.getBairro();
    		textBairro.setText(bairroFuncionario);
    		
    		String referenciaFuncionario = leitura.getReferencia();
    		textReferencia.setText(referenciaFuncionario);
		}
		
		/*Parte dos botoes*/
		JPanel panelBotoes = new JPanel();
		telaFichaFuncionarioEditar.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorFichadocliente = new JSeparator();
		panelBotoes.add(separatorFichadocliente, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		salvar = new JButton("Salvar");
		salvar.setToolTipText("Salva o cadastro do funcionario");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
						alterarCadastroFuncionario = new Funcionario();
						alterarCadastroFuncionarioFrequencia = new FuncionarioFrequencia();
						AlteraDadosFuncionarioFrequenciaFaltas = new FuncionarioFrequenciaFaltas();/*<--*/
						AlteraDadosFuncionarioSalario = new FuncionarioSalario();
						AlteraDadosFuncionarioFeriasFolga = new FuncionarioFeriasFolga();
						
						alterarCadastroFuncionario.setNome(textNome.getText());
						alterarCadastroFuncionarioFrequencia.setNomeFuncionario(textNome.getText());/*<--*/
						AlteraDadosFuncionarioFrequenciaFaltas.setNomeFuncionario(textNome.getText());
						AlteraDadosFuncionarioSalario.setNomeFuncionario(textNome.getText());
						AlteraDadosFuncionarioFeriasFolga.setNomeFuncionario(textNome.getText());
						
						alterarCadastroFuncionario.setRG(textRG.getText());
						alterarCadastroFuncionario.setEndereco(textEndereco.getText());
						alterarCadastroFuncionario.setBairro(textBairro.getText());
						alterarCadastroFuncionario.setNumero(textNumero.getText());
						alterarCadastroFuncionario.setComplemento(textComplemento.getText());
						alterarCadastroFuncionario.setCidade(textCidade.getText());
						alterarCadastroFuncionario.setCEP(textCEP.getText());
						alterarCadastroFuncionario.setCPF(textCPF.getText());
						alterarCadastroFuncionario.setEstadoCivil(textCPF.getText());
						alterarCadastroFuncionario.setEstado((String)(comboBoxEstado.getSelectedItem()));
						alterarCadastroFuncionario.setEscolaridade((String)(comboBoxEscolaridade.getSelectedItem()));
						alterarCadastroFuncionario.setFormaPagamento((String)(comboBoxFormaPagamento.getSelectedItem()));
						alterarCadastroFuncionario.setTipoTrabalho((String)(comboBoxTipoTrabalho.getSelectedItem()));
						alterarCadastroFuncionario.setCarteiraTrabalho(textCarteiraTrabalho.getText());
						alterarCadastroFuncionario.setSalario(Double.parseDouble(textSalario.getText()));
						alterarCadastroFuncionario.setNomeBanco(textNomeBanco.getText());
						alterarCadastroFuncionario.setNomeMae(textNomeMae.getText());
						alterarCadastroFuncionario.setNomePai(textNomePai.getText());
						alterarCadastroFuncionario.setNacionalidade(textNacionalidade.getText());
						alterarCadastroFuncionario.setPaisOrigem(textPaisOrigem.getText());
						alterarCadastroFuncionario.setLogin(textLogin.getText());
						alterarCadastroFuncionario.setSenha(new String(textSenha.getPassword()));
						
						/*Cadastro da referencia*/
						if (textReferencia.getText().isEmpty() || textReferencia.getText().length() <= 0){
							cadastroReferencia = "Opcional";
							alterarCadastroFuncionario.setReferencia(cadastroReferencia);
						}
						else {
							alterarCadastroFuncionario.setReferencia(textReferencia.getText());
						}
						
						/*Cadastro das datas*/
						dataNascimentoFun = textDataNascimento.getText();
						try {
							dataNascimentoFormato = new SimpleDateFormat("dd/MM/yyyy");
							data = new java.sql.Date(dataNascimentoFormato.parse(dataNascimentoFun).getTime());
							alterarCadastroFuncionario.setDataNascimento(data);
						} catch (ParseException e2) {
							e2.printStackTrace();
						}
						
						dataAdmissaoFun = textDataAdmissao.getText();
						try {
							dataAdmissaoFormato = new SimpleDateFormat("dd/MM/yyyy");
							dataInicio = new java.sql.Date(dataAdmissaoFormato.parse(dataAdmissaoFun).getTime());
							alterarCadastroFuncionario.setDataAdmissao(dataInicio);
						} catch (ParseException e3) {
							e3.printStackTrace();
						}
						
						if (textDataDemissao.getText().replaceAll("\\/", "").trim().isEmpty()) {
							dataTermino = null;
							alterarCadastroFuncionario.setDataDemissao(dataTermino);
						}
						else {
							dataDemissaoFun = textDataDemissao.getText();
							try {
								dataDemissaoFormato = new SimpleDateFormat("dd/MM/yyyy");
								dataTermino = new java.sql.Date(dataDemissaoFormato.parse(dataDemissaoFun).getTime());
								alterarCadastroFuncionario.setDataDemissao(dataTermino);
							} catch (ParseException e4) {
								e4.printStackTrace();
							}
						}
						
						/*Cadastro da hora*/
						horaEntradaFun = textHoraEntrada.getText();
						try {
							horaEntradaFormato = new SimpleDateFormat("HH:mm");
							horaInicio = new java.sql.Time(horaEntradaFormato.parse(horaEntradaFun).getTime());
							alterarCadastroFuncionario.setHoraEntrada(horaInicio);
							alterarCadastroFuncionarioFrequencia.setHoraEntrada(horaInicio);/*<--*/
						} catch (ParseException e4) {
							e4.printStackTrace();
						}
						
						horaSaidaFun = textHoraSaida.getText();
						try {
							horaSaidaFormato = new SimpleDateFormat("HH:mm");
							horaTermino = new java.sql.Time(horaSaidaFormato.parse(horaSaidaFun).getTime());
							alterarCadastroFuncionario.setHoraSaida(horaTermino);
							alterarCadastroFuncionarioFrequencia.setHoraSaida(horaTermino);/*<--*/
						} catch (ParseException e5) {
							e5.printStackTrace();
						}
						
						/*Cadastro do sexo*/
						if (radioMasculino.isSelected()) {
							sexoFun = radioMasculino.getText();
							alterarCadastroFuncionario.setSexo(sexoFun);
						}
						if (radioFeminino.isSelected()) {
							sexoFun = radioFeminino.getText();
							alterarCadastroFuncionario.setSexo(sexoFun);
						}
						
						/*Cadastro da carga horaria*/
						cargaHorariaValor = textCargaHoraria.getText();
						alterarCadastroFuncionario.setCargaHoraria(cargaHorariaValor);
						alterarCadastroFuncionarioFrequencia.setCargaHoraria(cargaHorariaValor);/*<--*/
						
						cargaHorariaUnidade = (String) comboBoxCargaHoraria.getSelectedItem();
						alterarCadastroFuncionario.setCargaHorariaUnidade(cargaHorariaUnidade);
						alterarCadastroFuncionarioFrequencia.setCargaHorariaUnidade(cargaHorariaUnidade);/*<--*/
						
						/*Cadastro Limite de faltas*/
						maximoFaltasValor = textLimiteFaltas.getText();
						alterarCadastroFuncionario.setLimiteFaltas(Integer.parseInt(maximoFaltasValor));
						alterarCadastroFuncionarioFrequencia.setValorMaximoFalta(Integer.parseInt(maximoFaltasValor));/*<--*/
						
						/*Cadastro do estado civil*/
						if (radioSolteiro.isSelected()) {
							estadoCivilFun = radioSolteiro.getText();
							alterarCadastroFuncionario.setEstadoCivil(estadoCivilFun);
						}
						if (radioCasado.isSelected()) {
							estadoCivilFun = radioCasado.getText();
							alterarCadastroFuncionario.setEstadoCivil(estadoCivilFun);
						}
						if (radioOutro.isSelected()) {
							estadoCivilFun = radioOutro.getText();
							alterarCadastroFuncionario.setEstadoCivil(estadoCivilFun);
						}
						
						/*Cadastro de cargo*/
						if (radioAtendente.isSelected()) {
							cargoFun = radioAtendente.getText();
							alterarCadastroFuncionario.setCargo(cargoFun);
							alterarCadastroFuncionarioFrequencia.setCargoFuncionario(cargoFun);/*<--*/
							AlteraDadosFuncionarioFrequenciaFaltas.setCargoFuncionario(cargoFun);
							AlteraDadosFuncionarioSalario.setCargoFuncionario(cargoFun);
							AlteraDadosFuncionarioFeriasFolga.setCargoFuncionario(cargoFun);
						}
						if (radioGerente.isSelected()) {
							cargoFun = radioGerente.getText();
							alterarCadastroFuncionario.setCargo(cargoFun);
							alterarCadastroFuncionarioFrequencia.setCargoFuncionario(cargoFun);/*<--*/
							AlteraDadosFuncionarioFrequenciaFaltas.setCargoFuncionario(cargoFun);
							AlteraDadosFuncionarioSalario.setCargoFuncionario(cargoFun);
							AlteraDadosFuncionarioFeriasFolga.setCargoFuncionario(cargoFun);
						}
						if (radioCarregador.isSelected()) {
							cargoFun = radioCarregador.getText();
							alterarCadastroFuncionario.setCargo(cargoFun);
							alterarCadastroFuncionarioFrequencia.setCargoFuncionario(cargoFun);/*<--*/
							AlteraDadosFuncionarioFrequenciaFaltas.setCargoFuncionario(cargoFun);
							AlteraDadosFuncionarioSalario.setCargoFuncionario(cargoFun);
							AlteraDadosFuncionarioFeriasFolga.setCargoFuncionario(cargoFun);
						}
						
						/*Cadastro de email*/
						if (textEmail1.getText().isEmpty() || textEmail1.getText().length() <= 0){
							cadastroEmail1 = "";
							alterarCadastroFuncionario.setEmail1(cadastroEmail1);
						}
						else {
							alterarCadastroFuncionario.setEmail1(textEmail1.getText());
						}
						
						if (textEmail2.getText().isEmpty() || textEmail2.getText().length() <= 0){
							cadastroEmail2 = "";
							alterarCadastroFuncionario.setEmail2(cadastroEmail2);
						}
						else {
							alterarCadastroFuncionario.setEmail2(textEmail2.getText());
						}
						
						/*Cadastro de telefone*/
						if (textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroTelefone1 = "";
							alterarCadastroFuncionario.setTelefone1(cadastroTelefone1);
						}
						else {
							cadastroTelefone1 = textTelefone1.getText();
							alterarCadastroFuncionario.setTelefone1(cadastroTelefone1);
						}
											
						if (textTelefone2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroTelefone2 = "";
							alterarCadastroFuncionario.setTelefone2(cadastroTelefone2);
						}
						else {
							cadastroTelefone2 = textTelefone2.getText();
							alterarCadastroFuncionario.setTelefone2(cadastroTelefone2);
						}
						
						/*Cadastro de celular*/
						if (textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroCelular1 = "";
							alterarCadastroFuncionario.setCelular1(cadastroCelular1);
						}
						else {
							alterarCadastroFuncionario.setCelular1(textCelular1.getText());
						}
						
						if (textCelular2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
							cadastroCelular2 = "";
							alterarCadastroFuncionario.setCelular2(cadastroCelular2);
						}
						else {
							alterarCadastroFuncionario.setCelular2(textCelular2.getText());
						}
						
						alterarCadastroFuncionario.setCodigoFuncionario(codigoFuncionario.getText());
						alterarCadastroFuncionarioFrequencia.setCodigoFuncionario(codigoFuncionario.getText());/*<--*/
						AlteraDadosFuncionarioFrequenciaFaltas.setCodigoFuncionario(codigoFuncionario.getText());
						AlteraDadosFuncionarioSalario.setCodigoFuncionario(codigoFuncionario.getText());
						AlteraDadosFuncionarioFeriasFolga.setCodigoFuncionario(codigoFuncionario.getText());
						
						/*Envia os dados para a classe que salva os dados no banco*/
						salvaNovosDados = new Dao_alterar_dados_funcionario();
						salvaNovosDados.Altera_Dados_Funcionario(alterarCadastroFuncionario);
						
						salvaNovosDadosHistorico  = new Dao_alterar_dados_funcionario();
						salvaNovosDadosHistorico.Altera_Dados_Funcionario_Historico(alterarCadastroFuncionarioFrequencia);
						
						salvaNovosDadosNomeCargoFaltas = new Dao_alterar_dados_funcionario();
						salvaNovosDadosNomeCargoFaltas.Altera_Dados_Funcionario_Historico_Faltas_Nome_Cargo(AlteraDadosFuncionarioFrequenciaFaltas);
						
						salvaNovosDadosSalarioNomeCargo = new Dao_alterar_dados_funcionario();
						salvaNovosDadosSalarioNomeCargo.Altera_Dados_Funcionario_Salario_Nome_Cargo(AlteraDadosFuncionarioSalario);
						
						salvaNovosDadosFeriasFolgasNomeCargo = new Dao_alterar_dados_funcionario();
						salvaNovosDadosFeriasFolgasNomeCargo.Altera_Dados_Funcionario_Ferias_Folgas_Nome_Cargo(AlteraDadosFuncionarioFeriasFolga);
						
						String menssagemConteudo = "Dados alterados com sucesso";
						Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
						mensagemConfirmacao.setVisible(true);
						
						Ficha_do_Funcionario FichaFuncionario = new Ficha_do_Funcionario();
						FichaFuncionario.setVisible(true);
						dispose();
					}
					catch(NumberFormatException e2){
						String menssagemConteudo = "Campo salario aceita somente numeros e um ponto(valores quebrados)";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
				}
			}
		});
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(salvar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setToolTipText("Fecha a janela");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ficha_do_Funcionario FichaFuncionario = new Ficha_do_Funcionario();
				FichaFuncionario.setVisible(true);
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
                	Ficha_do_Funcionario FichaFuncionario = new Ficha_do_Funcionario();
    				FichaFuncionario.setVisible(true);
    				dispose();
                }
            }
	    );
	}
}