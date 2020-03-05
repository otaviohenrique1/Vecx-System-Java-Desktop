package moduloClienteTelas;

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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloClienteBD.Cliente;
import moduloClienteBD.Dao_alterar_dados_clientes;
import moduloClienteBD.Dao_consulta_dados_cliente;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Ficha_do_Cliente_Editar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaCliente;
	private JTextField textNome, textEmail1, textEmail2, textEndereco, textBairro, textNumero, textComplemento;
	private JTextField  textCidade, textReferencia, textNacionalidade, textPaisOrigem;
	private JFormattedTextField textRG, textCPF, textTelefone1, textTelefone2, textCelular1, textCelular2, textCEP;
	private JFormattedTextField textDataNascimento;
	private JComboBox<String> comboBoxEstado;
	private final ButtonGroup buttonGroupSexo = new ButtonGroup();
	private final ButtonGroup buttonGroupEstadoCivil = new ButtonGroup();
	private JRadioButton radioMasculino, radioFeminino, radioSolteiro, radioCasado, radioOutro;
	private JButton salvar, cancelar;
	private JLabel funcionarioCadastro, codigoFuncionario, dataHoraCadastro;
	Cliente alterarCadastroCliente;
	String dataNascimentoCliente, sexoCliente, estadoCivilCliente, cadastroReferencia;
	String cadastroEmail1, cadastroEmail2, cadastroTelefone1, cadastroTelefone2, cadastroCelular1, cadastroCelular2;
	String email1Texto, email2Texto, telefone1Texto, telefone2Texto, celular1Texto, celular2Texto;
	SimpleDateFormat dataFormato;
	java.sql.Date data;
	Dao_alterar_dados_clientes salvaNovosDados;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficha_do_Cliente_Editar frame = new Ficha_do_Cliente_Editar();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
	public Ficha_do_Cliente_Editar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ficha_do_Cliente_Editar.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setSize(1000, 600);
		
		telaFichaCliente = new JPanel();
		telaFichaCliente.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaFichaCliente);
		telaFichaCliente.setLayout(new BorderLayout(0, 5));
		
		JPanel panelTitulo = new JPanel();
		telaFichaCliente.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout fl_panelTitulo2 = (FlowLayout) panelTitulo2.getLayout();
		fl_panelTitulo2.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Ficha_do_Cliente_Editar.class.getResource("/cImagens/Editar.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFichaCliente = new JLabel("Ficha do cliente");
		panelTitulo2.add(labelFichaCliente);
		labelFichaCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Ficha_do_Cliente_Editar.class.getResource("/cImagens/Funcionario.png")));
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
		
		JTabbedPane tabbedPaneCliente = new JTabbedPane(JTabbedPane.TOP);
		telaFichaCliente.add(tabbedPaneCliente, BorderLayout.CENTER);
		JPanel panelFichaCliente = new JPanel();
		tabbedPaneCliente.addTab("Ficha do cliente", null, panelFichaCliente, null);
		panelFichaCliente.setLayout(new GridLayout(1, 0, 0, 0));
		
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
		
		JScrollPane scrollPaneCadastro = new JScrollPane();
		scrollPaneCadastro.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneCadastro.getHorizontalScrollBar().setUnitIncrement(10);
		panelFichaCliente.add(scrollPaneCadastro);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNome_RG_CPF = new JPanel();
		panelCadastro.add(panelNome_RG_CPF);
		panelNome_RG_CPF.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeCliente = new JPanel();
		panelNome_RG_CPF.add(panelNomeCliente);
		panelNomeCliente.setPreferredSize(new Dimension(10, 50));
		panelNomeCliente.setLayout(new GridLayout(0, 1, 5, 0));
		
		JPanel panelNome = new JPanel();
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeCliente.add(panelNome);
		panelNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNome = new JLabel("Nome");
		panelNome.add(labelNome);
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textNome = new JTextField();
		panelNome.add(textNome);
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelRG_CPF_CodCliente = new JPanel();
		panelNome_RG_CPF.add(panelRG_CPF_CodCliente);
		panelRG_CPF_CodCliente.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelRG = new JPanel();
		panelRG.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRG_CPF_CodCliente.add(panelRG);
		panelRG.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelRG = new JLabel("RG");
		panelRG.add(labelRG);
		labelRG.setHorizontalAlignment(SwingConstants.LEFT);
		labelRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textRG = new JFormattedTextField(numeroRGMascara);
		panelRG.add(textRG);
		textRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCPF = new JPanel();
		panelRG_CPF_CodCliente.add(panelCPF);
		panelCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPF = new JLabel("CPF");
		panelCPF.add(labelCPF);
		labelCPF.setHorizontalAlignment(SwingConstants.LEFT);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCPF = new JFormattedTextField(numeroCPFMascara);
		panelCPF.add(textCPF);
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelData_Sexo_EstadoCivil = new JPanel();
		panelCadastro.add(panelData_Sexo_EstadoCivil);
		panelData_Sexo_EstadoCivil.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelCodigoCliente = new JPanel();
		panelData_Sexo_EstadoCivil.add(panelCodigoCliente);
		panelCodigoCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoCliente = new JLabel("Codigo do cliente");
		labelCodigoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoCliente.add(labelCodigoCliente);
		
		JLabel codigoCliente = new JLabel();
		codigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoCliente.add(codigoCliente);
		
		JPanel panelData = new JPanel();
		panelData.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_Sexo_EstadoCivil.add(panelData);
		panelData.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataNascimento = new JLabel("Data de nascimento");
		panelData.add(labelDataNascimento);
		labelDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDataNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		
		textDataNascimento = new JFormattedTextField(dataMascara);
		panelData.add(textDataNascimento);
		textDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelSexo = new JPanel();
		panelData_Sexo_EstadoCivil.add(panelSexo);
		panelSexo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelSexo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSexo = new JLabel("Sexo");
		panelSexo.add(labelSexo);
		labelSexo.setHorizontalAlignment(SwingConstants.LEFT);
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelSexo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelSexo2.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(0);
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
		panelData_Sexo_EstadoCivil.add(panelEstadoCivil);
		panelEstadoCivil.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstadoCivil.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstadoCivil = new JLabel("Estado civil");
		panelEstadoCivil.add(labelEstadoCivil);
		labelEstadoCivil.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEstadoCivil2 = new JPanel();
		FlowLayout fl_panelEstadoCivil2 = (FlowLayout) panelEstadoCivil2.getLayout();
		fl_panelEstadoCivil2.setAlignment(FlowLayout.LEFT);
		fl_panelEstadoCivil2.setVgap(0);
		fl_panelEstadoCivil2.setHgap(0);
		panelEstadoCivil.add(panelEstadoCivil2);
		
		radioSolteiro = new JRadioButton("Solterio");
		buttonGroupEstadoCivil.add(radioSolteiro);
		panelEstadoCivil2.add(radioSolteiro);
		radioSolteiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		radioCasado = new JRadioButton("Casado");
		buttonGroupEstadoCivil.add(radioCasado);
		radioCasado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoCivil2.add(radioCasado);
		
		radioOutro = new JRadioButton("Outro");
		buttonGroupEstadoCivil.add(radioOutro);
		radioOutro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoCivil2.add(radioOutro);
		
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
		
		JLabel labelTelefone2 = new JLabel("Telefone 2");
		labelTelefone2.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTelefone2.add(labelTelefone2);
		
		textTelefone2 = new JFormattedTextField(numeroTelefone2Mascara);
		textTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTelefone2.add(textTelefone2);
		
		JPanel panelCelular1 = new JPanel();
		panelCelular1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelCelular1);
		panelCelular1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular1 = new JLabel("Celular 1");
		panelCelular1.add(labelCelular1);
		labelCelular1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCelular1 = new JFormattedTextField(numeroCelular1Mascara);
		panelCelular1.add(textCelular1);
		textCelular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCelular2 = new JPanel();
		panelCelular2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelCelular2);
		panelCelular2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular2 = new JLabel("Celular 2");
		labelCelular2.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCelular2.add(labelCelular2);
		
		textCelular2 = new JFormattedTextField(numeroCelular2Mascara);
		textCelular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCelular2.add(textCelular2);
		
		JPanel panelEmail_Email2 = new JPanel();
		panelCadastro.add(panelEmail_Email2);
		panelEmail_Email2.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelEmail = new JPanel();
		panelEmail.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail_Email2.add(panelEmail);
		panelEmail.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail1 = new JLabel("Email 1");
		panelEmail.add(labelEmail1);
		labelEmail1.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textEmail1 = new JTextField();
		panelEmail.add(textEmail1);
		textEmail1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEmail2 = new JPanel();
		panelEmail_Email2.add(panelEmail2);
		panelEmail2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail2 = new JLabel("Email 2");
		panelEmail2.add(labelEmail2);
		labelEmail2.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textEmail2 = new JTextField();
		panelEmail2.add(textEmail2);
		textEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelNac_PaisOrigem_DataHora = new JPanel();
		panelCadastro.add(panelNac_PaisOrigem_DataHora);
		panelNac_PaisOrigem_DataHora.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelNacionalidade = new JPanel();
		panelNacionalidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNac_PaisOrigem_DataHora.add(panelNacionalidade);
		panelNacionalidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNacionalidade = new JLabel("Nacionalidade");
		labelNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNacionalidade.add(labelNacionalidade);
		
		textNacionalidade = new JTextField();
		textNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNacionalidade.add(textNacionalidade);
		
		JPanel panelPaisOrigem = new JPanel();
		panelPaisOrigem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNac_PaisOrigem_DataHora.add(panelPaisOrigem);
		panelPaisOrigem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPaisOrigem = new JLabel("Pais de origem");
		labelPaisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		labelPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(labelPaisOrigem);
		
		textPaisOrigem = new JTextField();
		textPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(textPaisOrigem);
		
		JPanel panelDataHoraCadastro = new JPanel();
		panelNac_PaisOrigem_DataHora.add(panelDataHoraCadastro);
		panelDataHoraCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHoraCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraCadastro = new JLabel("Data e hora de cadastro");
		labelDataHoraCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraCadastro.add(labelDataHoraCadastro);
		
		dataHoraCadastro = new JLabel();
		dataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraCadastro.add(dataHoraCadastro);
		
		JPanel panelComplemento_CEP = new JPanel();
		panelCadastro.add(panelComplemento_CEP);
		panelComplemento_CEP.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelEstado = new JPanel();
		panelComplemento_CEP.add(panelEstado);
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
		panelEstado.add(comboBoxEstado);
		comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCEP = new JPanel();
		panelComplemento_CEP.add(panelCEP);
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
		panelComplemento_CEP.add(panelCidade);
		panelCidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCidade = new JLabel("Cidade");
		panelCidade.add(labelCidade);
		labelCidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textCidade = new JTextField();
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
		
		textEndereco = new JTextField();
		panelEndereco.add(textEndereco);
		textEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelBairro_Estado = new JPanel();
		panelCadastro.add(panelBairro_Estado);
		panelBairro_Estado.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelNumero = new JPanel();
		panelBairro_Estado.add(panelNumero);
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
		panelBairro_Estado.add(panelComplemento);
		panelComplemento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComplemento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComplemento = new JLabel("Complemento");
		panelComplemento.add(labelComplemento);
		labelComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textComplemento = new JTextField();
		panelComplemento.add(textComplemento);
		textComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelBairro = new JPanel();
		panelBairro_Estado.add(panelBairro);
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
		
		funcionarioCadastro = new JLabel();
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
		
		codigoFuncionario = new JLabel();
		codigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFuncionario.add(codigoFuncionario);
		
		/*Parte que consulta os dados no banco de dados*/
		String codigoClienteConsulta = sessao.getCodigoCliente();
		String nomeClienteConsulta = sessao.getNomeCliente();
		String cpfClienteConsulta = sessao.getCPFCliente();
		Dao_consulta_dados_cliente teste = new Dao_consulta_dados_cliente();
    	List<Cliente> Consulta = teste.Consulta_Dados_Cliente_Ficha(codigoClienteConsulta, nomeClienteConsulta, cpfClienteConsulta);
    	for (Cliente leitura : Consulta) {
    		String nomeClienteTexto = leitura.getNome();
    		textNome.setText(nomeClienteTexto);
    		
    		String codigoClienteTexto = leitura.getCodigoCliente();
    		codigoCliente.setText(codigoClienteTexto);
    		
    		String rgClienteTexto = leitura.getRG();
    		textRG.setText(rgClienteTexto);
    		
    		String cpfClienteTexto = leitura.getCPF();
    		textCPF.setText(cpfClienteTexto);
    		
    		Date dataNascimentoFuncionario = leitura.getDataNascimento();
    		SimpleDateFormat dataNascimentoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataNacimentoValor = dataNascimentoFormato.format(dataNascimentoFuncionario);
    		textDataNascimento.setText(dataNacimentoValor);

    		String sexoFuncionario = leitura.getSexo();
    		if (sexoFuncionario.equals("Masculino")) {
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
    		
    		String telefone1Cliente = leitura.getTelefone1();
    		if (telefone1Cliente.equals("Opcional")) {
    			telefone1Texto = "";
    			textTelefone1.setText(telefone1Texto);
			}
    		else {
    			telefone1Texto = leitura.getTelefone1();
    			textTelefone1.setText(telefone1Texto);
			}
    		
    		String telefone2Cliente = leitura.getTelefone2();
    		if (telefone2Cliente.equals("Opcional")) {
    			telefone2Texto = "";
    			textTelefone2.setText(telefone2Texto);
			}
    		else {
    			telefone2Texto = leitura.getTelefone2();
				textTelefone2.setText(telefone2Texto);
			}
    		
    		String celular1Cliente = leitura.getCelular1();
    		if (celular1Cliente.equals("Opcional")) {
    			celular1Texto = "";
    			textCelular1.setText(celular1Texto);
			}
    		else {
    			celular1Texto = leitura.getCelular1();
    			textCelular1.setText(celular1Texto);
			}
    		
    		String celular2Cliente = leitura.getCelular2();
    		if (celular2Cliente.equals("Opcional")) {
    			celular2Texto = "";
    			textCelular2.setText(celular2Texto);
			}
    		else {
    			celular2Texto = leitura.getCelular2();
    			textCelular2.setText(celular2Texto);
			}
    		
    		String email1Cliente = leitura.getEmail1();
    		if (email1Cliente.equals("Opcional")) {
    			email1Texto = "";
    			textEmail1.setText(email1Texto);
			}
    		else {
    			email1Texto = leitura.getEmail1();
    			textEmail1.setText(email1Texto);
			}
    		
    		String email2Cliente = leitura.getEmail2();
    		if (email2Cliente.equals("Opcional")) {
    			email2Texto = "";
    			textEmail2.setText(email2Texto);
			}
    		else {
    			email2Texto = leitura.getEmail2();
    			textEmail2.setText(email2Texto);
			}
    		
    		String nacionalidadeCliente = leitura.getNacionalidade();
    		textNacionalidade.setText(nacionalidadeCliente);
    		
    		String paisOrigemCliente = leitura.getPaisOrigem();
    		textPaisOrigem.setText(paisOrigemCliente);
    		
    		Date dataCadastroCliente =	leitura.getDataCadastro();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroCliente);
    		Time horaCadastroCliente = leitura.getHoraCadastro();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroCliente);
    		dataHoraCadastro.setText(dataCadastroValor + " " + horaCadastroValor);
    		
    		String estadoFuncionario = leitura.getEstado();
    		comboBoxEstado.setSelectedItem(estadoFuncionario);
    		
    		String nomeFuncionarioTexto = leitura.getFuncionarioCadastro();
    		funcionarioCadastro.setText(nomeFuncionarioTexto);

    		String cargoFuncionarioTexto = leitura.getCargoFuncionario();
    		cargoFuncionario.setText(cargoFuncionarioTexto);

    		String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
    		codigoFuncionario.setText(codigoFuncionarioTexto);
    		
    		String cepCliente = leitura.getCEP();
    		textCEP.setText(cepCliente);
    		
    		String cidadeCliente = leitura.getCidade();
    		textCidade.setText(cidadeCliente);
    		
    		String enderecoCliente = leitura.getEndereco();
    		textEndereco.setText(enderecoCliente);
    		
    		String numeroCliente = leitura.getNumero();
    		textNumero.setText(numeroCliente);
    		
    		String complementoCliente = leitura.getComplemento();
    		textComplemento.setText(complementoCliente);
    		
    		String bairroCliente = leitura.getBairro();
    		textBairro.setText(bairroCliente);
    		
    		String referenciaCliente = leitura.getReferencia();
    		textReferencia.setText(referenciaCliente);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaCliente.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorFichaCliente = new JSeparator();
		panelBotoes.add(separatorFichaCliente, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		addWindowListener(
                new WindowAdapter() 
                {
                    public void windowClosing(WindowEvent we) {
                    	setVisible(false);
                    }
                }
        );
		
		salvar = new JButton("Salvar");
		salvar.setToolTipText("Salva os dados editados");
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
					alterarCadastroCliente = new Cliente();
					alterarCadastroCliente.setNome(textNome.getText());
					alterarCadastroCliente.setRG(textRG.getText());
					alterarCadastroCliente.setCPF(textCPF.getText());
					alterarCadastroCliente.setCEP(textCEP.getText());
					alterarCadastroCliente.setEndereco(textEndereco.getText());
					alterarCadastroCliente.setBairro(textBairro.getText());
					alterarCadastroCliente.setNumero(textNumero.getText());
					alterarCadastroCliente.setComplemento(textComplemento.getText());
					alterarCadastroCliente.setCidade(textCidade.getText());
					alterarCadastroCliente.setReferencia(textReferencia.getText());
					alterarCadastroCliente.setCPF(textCPF.getText());
					alterarCadastroCliente.setEstado((String)(comboBoxEstado.getSelectedItem()));
					alterarCadastroCliente.setNacionalidade(textNacionalidade.getText());
					alterarCadastroCliente.setPaisOrigem(textPaisOrigem.getText());
										
					if (textReferencia.getText().isEmpty() || textReferencia.getText().length() <= 0){
						cadastroReferencia = "Opcional";
						alterarCadastroCliente.setReferencia(cadastroReferencia);
					}
					else {
						alterarCadastroCliente.setReferencia(textReferencia.getText());
					}
					
					dataNascimentoCliente = textDataNascimento.getText();
					try {
						dataFormato = new SimpleDateFormat("dd/MM/yyyy");
						data = new java.sql.Date(dataFormato.parse(dataNascimentoCliente).getTime());
						alterarCadastroCliente.setDataNascimento(data);
					} catch (ParseException e) {
						e.printStackTrace();
					}
										
					if (radioMasculino.isSelected()) {
						sexoCliente = radioMasculino.getText();
						alterarCadastroCliente.setSexo(sexoCliente);
					}
					if (radioFeminino.isSelected()) {
						sexoCliente = radioFeminino.getText();
						alterarCadastroCliente.setSexo(sexoCliente);
					}
					if (radioSolteiro.isSelected()) {
						estadoCivilCliente = radioSolteiro.getText();
						alterarCadastroCliente.setEstadoCivil(estadoCivilCliente);
					}
					if (radioCasado.isSelected()) {
						estadoCivilCliente = radioCasado.getText();
						alterarCadastroCliente.setEstadoCivil(estadoCivilCliente);
					}
					if (radioOutro.isSelected()) {
						estadoCivilCliente = radioOutro.getText();
						alterarCadastroCliente.setEstadoCivil(estadoCivilCliente);
					}
					
					if (textEmail1.getText().isEmpty() || textEmail1.getText().length() <= 0){
						cadastroEmail1 = "Opcional";
						alterarCadastroCliente.setEmail1(cadastroEmail1);
					}
					else {
						alterarCadastroCliente.setEmail1(textEmail1.getText());
					}
					
					if (textEmail2.getText().isEmpty() || textEmail2.getText().length() <= 0){
						cadastroEmail2 = "Opcional";
						alterarCadastroCliente.setEmail2(cadastroEmail2);
					}
					else {
						alterarCadastroCliente.setEmail2(textEmail2.getText());
					}
					
					if (textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone1 = "Opcional";
						alterarCadastroCliente.setTelefone1(cadastroTelefone1);
					}
					else {
						cadastroTelefone1 = textTelefone1.getText();
						alterarCadastroCliente.setTelefone1(cadastroTelefone1);
					}
										
					if (textTelefone2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone2 = "Opcional";
						alterarCadastroCliente.setTelefone2(cadastroTelefone2);
					}
					else {
						cadastroTelefone2 = textTelefone2.getText();
						alterarCadastroCliente.setTelefone2(cadastroTelefone2);
					}
					
					if (textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone1 = "Opcional";
						alterarCadastroCliente.setCelular1(cadastroTelefone1);
					}
					else {
						alterarCadastroCliente.setCelular1(textCelular1.getText());
					}
					
					if (textCelular2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone2 = "Opcional";
						alterarCadastroCliente.setCelular2(cadastroTelefone2);
					}
					else {
						alterarCadastroCliente.setCelular2(textCelular2.getText());
					}
					
					alterarCadastroCliente.setCodigoCliente(codigoCliente.getText());
					
					/*Envia os dados para a classe que salva os dados no banco*/
					salvaNovosDados = new Dao_alterar_dados_clientes();
					salvaNovosDados.Altera_Dados_Cliente(alterarCadastroCliente);
					
					//Mensagem de confirmação do cadastro
					String menssagemConteudo = "Dados alterados com sucesso";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
					
					Ficha_do_Cliente FichaCliente = new Ficha_do_Cliente();
					FichaCliente.setVisible(true);
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
				Ficha_do_Cliente FichaCliente = new Ficha_do_Cliente();
				FichaCliente.setVisible(true);
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
                	Ficha_do_Cliente FichaCliente = new Ficha_do_Cliente();
    				FichaCliente.setVisible(true);
    				dispose();
                }
            }
	    );
	}
}