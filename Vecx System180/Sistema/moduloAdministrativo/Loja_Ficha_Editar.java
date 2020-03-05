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
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Loja_Ficha_Editar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaCadastroFornecedor;
	private JTextField textEndereco, textBairro, textNumero, textComplemento, textCidade, textPaisOrigem, textNome, textRazaoSocial, textInscricaoNumero;
	private JTextField textEmail1, textEmail2, textReferencia, textNacionalidade;
	private JFormattedTextField textCNPJ, textCPF, textCEP, textTelefone1, textTelefone2, textCelular1, textCelular2;
	private JCheckBox checkBoxIsento;
	private JComboBox<String> comboBoxEstado;
	private JButton salvar, voltar;
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
					Loja_Ficha_Editar frame = new Loja_Ficha_Editar();
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
	public Loja_Ficha_Editar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Loja_Ficha_Editar.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(true);
		setSize(1000, 600);
		
		telaCadastroFornecedor = new JPanel();
		telaCadastroFornecedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaCadastroFornecedor.setLayout(new BorderLayout(0, 0));
		setContentPane(telaCadastroFornecedor);
		
		JPanel panelTitulo = new JPanel();
		telaCadastroFornecedor.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelTitulo2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Loja_Ficha_Editar.class.getResource("/cImagens/Editar.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel labelFichaLoja = new JLabel("Ficha de dados da loja");
		panelTitulo2.add(labelFichaLoja);
		labelFichaLoja.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		Sessao sessao = Sessao.getInstance();
		String nome = sessao.getNome();
		String cargo = sessao.getCargo();
		String codigo = sessao.getCodigo();
		
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
				sessao.setCodigoFuncionario(codigo);
				sessao.setNomeFuncionario(nome);
				sessao.setCargoFuncionario(cargo);
				
				Ficha_do_Funcionario_Exibicao FichaFuncionario = new Ficha_do_Funcionario_Exibicao();
				FichaFuncionario.setVisible(true);
			}
		});
		fichaUsuario.setPreferredSize(new Dimension(30, 30));
		fichaUsuario.setIcon(new ImageIcon(Loja_Ficha_Editar.class.getResource("/cImagens/Funcionario.png")));
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
		if (nome == null) {
			nomeLogin = "Usuario";
			nomeFuncionarioLogin.setText("Nome: " + nomeLogin);
		}
		else {
			nomeFuncionarioLogin.setText("Nome: " + nome);
		}
		
		if (cargo == null) {
			cargoLogin = "Cargo";
			cargoFuncionarioLogin.setText("Cargo: " + cargoLogin);
		}
		else {
			cargoFuncionarioLogin.setText("Cargo: " + cargo);
		}
		
		JScrollPane scrollPaneCadastro = new JScrollPane();
		telaCadastroFornecedor.add(scrollPaneCadastro, BorderLayout.CENTER);
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
		panelCNPJ_CPF_InscEst.setLayout(new GridLayout(0, 4, 5, 5));
		
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
		
		JPanel panelDataHoraCadastro = new JPanel();
		panelDataHoraCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCNPJ_CPF_InscEst.add(panelDataHoraCadastro);
		panelDataHoraCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCadastroDataHora = new JLabel("Data e hora do cadastro");
		labelCadastroDataHora.setHorizontalAlignment(SwingConstants.LEFT);
		labelCadastroDataHora.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelDataHoraCadastro.add(labelCadastroDataHora);
		
		JLabel dataHoraCadastro = new JLabel();
		dataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelDataHoraCadastro.add(dataHoraCadastro);
		
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
		
		/*Parte que consulta no banco de dados o estado dos dados da loja*/
		/*se os mesmos estao registrados ou não registrados*/
		Dao_consulta_dados_loja consultaDadosLojaRegistro = new Dao_consulta_dados_loja();
    	List<DadosLoja> ConsultaDadosLoja = consultaDadosLojaRegistro.Consulta_Dados_Fornecedor_Dados_Loja();
    	for (DadosLoja leituraDadosLoja : ConsultaDadosLoja) {
    		String estadoDadosLojaConsultaTexto = leituraDadosLoja.getEstadoDadosLoja();
    		setEstadoDadosLojaConsultaRegistro(estadoDadosLojaConsultaTexto);
		}
    	
		/*Parte que consulta os dados no banco de dados*/
    	String estadoDadosLojaConsultaTexto = getEstadoDadosLojaConsultaRegistro();
    	Dao_consulta_dados_loja consultaDadosLoja = new Dao_consulta_dados_loja();
    	List<DadosLoja> Consulta = consultaDadosLoja.Consulta_Dados_Fornecedor_Ficha(estadoDadosLojaConsultaTexto);
    	for (DadosLoja leitura : Consulta) {
    		String nomeLoja = leitura.getNome();
    		textNome.setText(nomeLoja);
    		
    		String razaoSocialLoja = leitura.getRazaoSocial();
    		textRazaoSocial.setText(razaoSocialLoja);
    		
    		String cnpjLoja = leitura.getCNPJ();
    		textCNPJ.setText(cnpjLoja);
    		
    		String cpfLoja = leitura.getCPF();
    		textCPF.setText(cpfLoja);
    		
    		Date dataCadastroCliente =	leitura.getDataCadastro();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroCliente);
    		Time horaCadastroCliente = leitura.getHoraCadastro();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroCliente);
    		dataHoraCadastro.setText(dataCadastroValor + " " + horaCadastroValor);
    		
    		String inscricaoEstadual = leitura.getInscricaoEstadual();
    		if (inscricaoEstadual.equals("Isento")) {
    			checkBoxIsento.setSelected(true);
			}
    		
    		String inscricaoNumeroLoja = leitura.getInscricaoNumero();
    		textInscricaoNumero.setText(inscricaoNumeroLoja);

    		String telefone1Loja = leitura.getTelefone1();
    		if (telefone1Loja.equals("Opcional")) {
    			textTelefone1.setText("");
			}
    		else {
    			textTelefone1.setText(telefone1Loja);
			}
    		
    		String telefone2Loja = leitura.getTelefone2();
    		if (telefone2Loja.equals("Opcional")) {
    			textTelefone2.setText("");
			}
    		else {
    			textTelefone2.setText(telefone2Loja);
			}
    		
    		String celular1Loja = leitura.getCelular1();
    		if (celular1Loja.equals("Opcional")) {
    			textCelular1.setText("");
			}
    		else {
    			textCelular1.setText(celular1Loja);
			}
    		
    		String celular2Loja = leitura.getCelular2();
    		if (celular2Loja.equals("Opcional")) {
    			textCelular2.setText("");
			}
    		else {
    			textCelular2.setText(celular2Loja);
			}
    		
    		String email1Loja = leitura.getEmail1();
    		if (email1Loja.equals("Opcional")) {
    			textEmail1.setText("");
			}
    		else {
    			textEmail1.setText(email1Loja);
			}
    		
    		String email2Loja = leitura.getEmail2();
    		if (email2Loja.equals("Opcional")) {
    			textEmail2.setText("");
			}
    		else {
    			textEmail2.setText(email2Loja);
			}
    		
    		String nacionalidadeLoja = leitura.getNacionalidade();
    		textNacionalidade.setText(nacionalidadeLoja);
    		
    		String paisLoja = leitura.getPais();
    		textPaisOrigem.setText(paisLoja);
    		
    		String estadoLoja = leitura.getEstado();
    		comboBoxEstado.setSelectedItem(estadoLoja);
    		
    		String cepLoja = leitura.getCEP();
    		textCEP.setText(cepLoja);
    		
    		String cidadeLoja = leitura.getCidade();
    		textCidade.setText(cidadeLoja);
    		
    		String enderecoLoja = leitura.getEndereco();
    		textEndereco.setText(enderecoLoja);
    		
    		String numeroLoja = leitura.getNumero();
    		textNumero.setText(numeroLoja);
    		
    		String complementoLoja = leitura.getComplemento();
    		textComplemento.setText(complementoLoja);
    		
    		String bairroLoja = leitura.getBairro();
    		textBairro.setText(bairroLoja);
    		
    		String referenciaLoja = leitura.getReferencia();
    		textReferencia.setText(referenciaLoja);
		}
		
		JPanel panelBotoes = new JPanel();
		telaCadastroFornecedor.add(panelBotoes, BorderLayout.SOUTH);
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
					alterarCadastroLoja = new DadosLoja();
					alterarCadastroLoja.setNome(textNome.getText());
					alterarCadastroLoja.setRazaoSocial(textRazaoSocial.getText());
					alterarCadastroLoja.setCNPJ(textCNPJ.getText());
					alterarCadastroLoja.setCEP(textCEP.getText());
					alterarCadastroLoja.setEndereco(textEndereco.getText());
					alterarCadastroLoja.setBairro(textBairro.getText());
					alterarCadastroLoja.setNumero(textNumero.getText());
					alterarCadastroLoja.setComplemento(textComplemento.getText());
					alterarCadastroLoja.setCidade(textCidade.getText());
					alterarCadastroLoja.setReferencia(textReferencia.getText());
					alterarCadastroLoja.setCPF(textCPF.getText());
					alterarCadastroLoja.setPais(textPaisOrigem.getText());
					alterarCadastroLoja.setNacionalidade(textNacionalidade.getText());
					alterarCadastroLoja.setEstado((String)(comboBoxEstado.getSelectedItem()));
					
					if (checkBoxIsento.isSelected()) {
						isentoInscricaoEstadual = "Isento";
						alterarCadastroLoja.setInscricaoEstadual(isentoInscricaoEstadual);
						alterarCadastroLoja.setInscricaoNumero(textInscricaoNumero.getText());
					}
					else {
						isentoInscricaoEstadual = "Não isento";
						alterarCadastroLoja.setInscricaoEstadual(isentoInscricaoEstadual);
					}
					
					if (textEmail1.getText().isEmpty() || textEmail1.getText().length() <= 0){
						cadastroEmail1 = "Opcional";
						alterarCadastroLoja.setEmail1(cadastroEmail1);
					}
					else {
						alterarCadastroLoja.setEmail1(textEmail1.getText());
					}
					
					if (textEmail2.getText().isEmpty() || textEmail2.getText().length() <= 0){
						cadastroEmail2 = "Opcional";
						alterarCadastroLoja.setEmail2(cadastroEmail2);
					}
					else {
						alterarCadastroLoja.setEmail2(textEmail2.getText());
					}
					
					if (textTelefone1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone1 = "Opcional";
						alterarCadastroLoja.setTelefone1(cadastroTelefone1);
					}
					else {
						cadastroTelefone1 = textTelefone1.getText();
						alterarCadastroLoja.setTelefone1(cadastroTelefone1);
					}
										
					if (textTelefone2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone2 = "Opcional";
						alterarCadastroLoja.setTelefone2(cadastroTelefone2);
					}
					else {
						cadastroTelefone2 = textTelefone2.getText();
						alterarCadastroLoja.setTelefone2(cadastroTelefone2);
					}
					
					if (textCelular1.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone1 = "Opcional";
						alterarCadastroLoja.setCelular1(cadastroTelefone1);
					}
					else {
						alterarCadastroLoja.setCelular1(textCelular1.getText());
					}
					
					if (textCelular2.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().isEmpty()){
						cadastroTelefone2 = "Opcional";
						alterarCadastroLoja.setCelular2(cadastroTelefone2);
					}
					else {
						alterarCadastroLoja.setCelular2(textCelular2.getText());
					}
					
					Dao_consulta_dados_loja consultaDadosLoja = new Dao_consulta_dados_loja();
			    	List<DadosLoja> Consulta = consultaDadosLoja.Consulta_Dados_Fornecedor_Dados_Loja();
			    	for (DadosLoja leitura : Consulta) {
			    		String estadoDadosLojaConsulta = leitura.getEstadoDadosLoja();
			    		setEstadoDadosLojaTexto(estadoDadosLojaConsulta);
					}
			    	String estadoDadosLojaRegistro = getEstadoDadosLojaTexto();
					alterarCadastroLoja.setEstadoDadosLoja(estadoDadosLojaRegistro);
			    	
					/*Envia os dados para a classe que salva os dados no banco*/
					salvaNovosDados = new Dao_alterar_dados_loja();
					salvaNovosDados.Altera_Dados_Loja(alterarCadastroLoja);
							
					//Mensagem de confirmação do cadastro
					String menssagemConteudo = "Dados cadastrados com sucesso";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
					
					Loja_Ficha abrirFichaLoja = new Loja_Ficha();
					abrirFichaLoja.setVisible(true);
					dispose();
				}
			}
		});
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(salvar);
		
		voltar = new JButton("Voltar");
		voltar.setToolTipText("Fecha a janela");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loja_Ficha abrirFichaLoja = new Loja_Ficha();
				abrirFichaLoja.setVisible(true);
				dispose();
			}
		});
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(voltar);
	}
	
	private String estadoDadosLojaTexto, estadoDadosLojaConsultaRegistro;
	
	/*Metodos get e set */
	/*get e set Estado dados loja*/
	public String getEstadoDadosLojaTexto() {
		return estadoDadosLojaTexto;
	}
	public void setEstadoDadosLojaTexto(String estadoDadosLojaTexto) {
		this.estadoDadosLojaTexto = estadoDadosLojaTexto;
	}
	
	/*get e set Estado dados loja registro*/
	public String getEstadoDadosLojaConsultaRegistro() {
		return estadoDadosLojaConsultaRegistro;
	}
	public void setEstadoDadosLojaConsultaRegistro(String estadoDadosLojaConsultaRegistro) {
		this.estadoDadosLojaConsultaRegistro = estadoDadosLojaConsultaRegistro;
	}
}