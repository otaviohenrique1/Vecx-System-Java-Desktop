package moduloTransporteTelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoDescontoPromocaoTelas.Descontos_e_Promocoes_Adicionar_Responsavel;
import moduloTransporteBD.Dao_inserir_dados_transportecarga;
import moduloTransporteBD.TransporteCarga;

public class Cadastro_de_TransporteCargas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeFuncionario, textNomeCliente, textTipoTransporte, textEnderecoCliente, textCodigoFuncionario, textCargoFuncionario;
	private JTextField textNumeroCliente, textCidadeCliente, textBairroCliente, textCodigoVenda;
	private JFormattedTextField textDataSaida, textHoraSaida, textDataChegada, textHoraChegada, textClienteRG, textClienteCPF;
	private JButton venda, limpar, salvar, cliente, responsavel, voltar;
	private JComboBox<String> comboBoxEstadoCarga;
	TransporteCarga cadastrarTransporteCarga;
	SimpleDateFormat dataSaidaFormato, dataChegadaFormato, dataCadastroFormato;
	SimpleDateFormat horaSaidaFormato, horaChegadaFormato, horaCadastroFormato;
	Date dataSaida, dataChegada, dataCadastro;
	Time horaSaida, horaChegada, horaCadastro;
	String estadoCargaTransporte, dataSaidaTansporte, dataChegadaTransporte, dataCadastroTransporte;
	String horaSaidaTansporte, horaChegadaTransporte, horaCadastroTransporte;
	Dao_inserir_dados_transportecarga salvaDados;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_de_TransporteCargas frame = new Cadastro_de_TransporteCargas();
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
	public Cadastro_de_TransporteCargas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro_de_TransporteCargas.class.getResource("/cImagens/Logo Janela.PNG")));
		setResizable(false);
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900,450);
		setSize(900,450);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5, 5));
		
		JPanel panelTitulo = new JPanel();
		contentPane.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panelTitulo2.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel label = new JLabel("");
		panelTitulo2.add(label);
		label.setIcon(new ImageIcon(Cadastro_de_TransporteCargas.class.getResource("/cImagens/Cadastro de  transporte.PNG")));
		label.setPreferredSize(new Dimension(30, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelCadastroTransporteCargas = new JLabel("Cadastro de transporte");
		panelTitulo2.add(labelCadastroTransporteCargas);
		labelCadastroTransporteCargas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Cadastro_de_TransporteCargas.class.getResource("/cImagens/Funcionario.png")));
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
		contentPane.add(scrollPaneCadastro, BorderLayout.CENTER);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelCadastroParteA1 = new JPanel();
		panelCadastroParteA1.setPreferredSize(new Dimension(10, 180));
		panelCadastro.add(panelCadastroParteA1);
		panelCadastroParteA1.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelFuncionarioResponsavel = new JPanel();
		panelCadastroParteA1.add(panelFuncionarioResponsavel);
		panelFuncionarioResponsavel.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeFuncionario = new JPanel();
		panelFuncionarioResponsavel.add(panelNomeFuncionario);
		panelNomeFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeFuncionario = new JLabel("Nome do funcionario responsavel");
		labelNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNomeFuncionario.add(labelNomeFuncionario);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNomeFuncionario.add(textNomeFuncionario);
		textNomeFuncionario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textNomeFuncionario.getText().isEmpty() || textNomeFuncionario.getText().length() <= 0){
					labelNomeFuncionario.setText("Nome do funcionario responsavel*");
					labelNomeFuncionario.setForeground(Color.RED);
				}
				else {
					labelNomeFuncionario.setText("Nome do funcionario responsavel");
					labelNomeFuncionario.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelNomeFuncionario.setText("Nome do funcionario responsavel");
				labelNomeFuncionario.setForeground(Color.BLACK);
			}
		});
		textNomeFuncionario.setColumns(10);
		
		JPanel panelCodigo_Cargo_Funcionario = new JPanel();
		panelFuncionarioResponsavel.add(panelCodigo_Cargo_Funcionario);
		panelCodigo_Cargo_Funcionario.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargoFuncionario = new JPanel();
		panelCodigo_Cargo_Funcionario.add(panelCargoFuncionario);
		panelCargoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargoFuncionario = new JLabel("Cargo do funcionario");
		labelCargoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCargoFuncionario.add(labelCargoFuncionario);
		
		textCargoFuncionario = new JTextField();
		textCargoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCargoFuncionario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCargoFuncionario.getText().isEmpty() || textCargoFuncionario.getText().length() <= 0){
					labelCargoFuncionario.setText("Cargo do funcionario*");
					labelCargoFuncionario.setForeground(Color.RED);
				}
				else {
					labelCargoFuncionario.setText("Cargo do funcionario");
					labelCargoFuncionario.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelCargoFuncionario.setText("Cargo do funcionario");
				labelCargoFuncionario.setForeground(Color.BLACK);
			}
		});
		textCargoFuncionario.setColumns(10);
		panelCargoFuncionario.add(textCargoFuncionario);
		
		JPanel panelCodigoFuncionario = new JPanel();
		panelCodigo_Cargo_Funcionario.add(panelCodigoFuncionario);
		panelCodigoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoFuncionario = new JLabel("Codigo do funcionario");
		labelCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCodigoFuncionario.add(labelCodigoFuncionario);
		
		textCodigoFuncionario = new JTextField();
		textCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCodigoFuncionario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCodigoFuncionario.getText().isEmpty() || textCodigoFuncionario.getText().length() <= 0){
					labelCodigoFuncionario.setText("Codigo do funcionario*");
					labelCodigoFuncionario.setForeground(Color.RED);
				}
				else {
					labelCodigoFuncionario.setText("Codigo do funcionario");
					labelCodigoFuncionario.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelCodigoFuncionario.setText("Codigo do funcionario");
				labelCodigoFuncionario.setForeground(Color.BLACK);
			}
		});
		textCodigoFuncionario.setColumns(10);
		panelCodigoFuncionario.add(textCodigoFuncionario);
		
		JPanel panelCliente = new JPanel();
		panelCadastroParteA1.add(panelCliente);
		panelCliente.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeCliente = new JPanel();
		panelCliente.add(panelNomeCliente);
		panelNomeCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeCliente = new JLabel("Nome do cliente");
		labelNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNomeCliente.add(labelNomeCliente);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNomeCliente.setColumns(10);
		textNomeCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textNomeCliente.getText().isEmpty() || textNomeCliente.getText().length() <= 0){
					labelNomeCliente.setText("Nome do cliente*");
					labelNomeCliente.setForeground(Color.RED);
				}
				else {
					labelNomeCliente.setText("Nome do cliente");
					labelNomeCliente.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelNomeCliente.setText("Nome do cliente");
				labelNomeCliente.setForeground(Color.BLACK);
			}
		});
		panelNomeCliente.add(textNomeCliente);
		
		MaskFormatter numeroRGMascara = null;
		MaskFormatter numeroCPFMascara = null;
		try{
			numeroRGMascara = new MaskFormatter("##.###.###-#");
			numeroCPFMascara = new MaskFormatter("###.###.###-#");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		JPanel panelCliente_CPF_RG = new JPanel();
		panelCliente.add(panelCliente_CPF_RG);
		panelCliente_CPF_RG.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelClienteCPF = new JPanel();
		panelCliente_CPF_RG.add(panelClienteCPF);
		panelClienteCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelClienteCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelClienteCPF = new JLabel("CPF do cliente");
		labelClienteCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelClienteCPF.add(labelClienteCPF);
		
		textClienteCPF = new JFormattedTextField(numeroCPFMascara);
		textClienteCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textClienteCPF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textClienteCPF.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty()){
					labelClienteCPF.setText("CPF do cliente*");
					labelClienteCPF.setForeground(Color.RED);
				}
				else {
					labelClienteCPF.setText("CPF do cliente");
					labelClienteCPF.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelClienteCPF.setText("CPF do cliente");
				labelClienteCPF.setForeground(Color.BLACK);
			}
		});
		textClienteCPF.setColumns(10);
		panelClienteCPF.add(textClienteCPF);
		
		JPanel panelClienteRG = new JPanel();
		panelCliente_CPF_RG.add(panelClienteRG);
		panelClienteRG.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelClienteRG.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelClienteRG = new JLabel("RG do cliente");
		labelClienteRG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelClienteRG.add(labelClienteRG);
		
		textClienteRG = new JFormattedTextField(numeroRGMascara);
		textClienteRG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textClienteRG.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textClienteRG.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty()){
					labelClienteRG.setText("RG do cliente*");
					labelClienteRG.setForeground(Color.RED);
				}
				else {
					labelClienteRG.setText("RG do cliente");
					labelClienteRG.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelClienteRG.setText("RG do cliente");
				labelClienteRG.setForeground(Color.BLACK);
			}
		});
		textClienteRG.setColumns(10);
		panelClienteRG.add(textClienteRG);
		
		JPanel panelEnderecoCliente = new JPanel();
		panelEnderecoCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCadastroParteA1.add(panelEnderecoCliente);
		panelEnderecoCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEnderecoCliente = new JLabel("Endere\u00E7o do cliente");
		labelEnderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEnderecoCliente.add(labelEnderecoCliente);
		
		textEnderecoCliente = new JTextField();
		textEnderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEnderecoCliente.setColumns(10);
		textEnderecoCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textEnderecoCliente.getText().isEmpty() || textEnderecoCliente.getText().length() <= 0){
					labelEnderecoCliente.setText("Endereço do cliente*");
					labelEnderecoCliente.setForeground(Color.RED);
				}
				else {
					labelEnderecoCliente.setText("Endereço do cliente");
					labelEnderecoCliente.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelEnderecoCliente.setText("Endereço do cliente");
				labelEnderecoCliente.setForeground(Color.BLACK);
			}
		});
		panelEnderecoCliente.add(textEnderecoCliente);
		
		JPanel panelNumeroBairroCidadeCliente = new JPanel();
		panelCadastroParteA1.add(panelNumeroBairroCidadeCliente);
		panelNumeroBairroCidadeCliente.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelNumeroCliente = new JPanel();
		panelNumeroBairroCidadeCliente.add(panelNumeroCliente);
		panelNumeroCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNumeroCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNumeroCliente = new JLabel("Numero da casa do cliente");
		labelNumeroCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNumeroCliente.add(labelNumeroCliente);
		
		textNumeroCliente = new JTextField();
		textNumeroCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNumeroCliente.setColumns(10);
		textNumeroCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textNumeroCliente.getText().length() <= 0 || textNumeroCliente.getText().isEmpty()){
					labelNumeroCliente.setText("Numero da casa do cliente*");
					labelNumeroCliente.setForeground(Color.RED);
				}
				else {
					labelNumeroCliente.setText("Numero da casa do cliente");
					labelNumeroCliente.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelNumeroCliente.setText("Numero da casa do cliente");
				labelNumeroCliente.setForeground(Color.BLACK);
			}
		});
		panelNumeroCliente.add(textNumeroCliente);
		
		JPanel panelBairroCliente = new JPanel();
		panelBairroCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNumeroBairroCidadeCliente.add(panelBairroCliente);
		panelBairroCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairroCliente = new JLabel("Bairro do cliente");
		labelBairroCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBairroCliente.add(labelBairroCliente);
		
		textBairroCliente = new JTextField();
		textBairroCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textBairroCliente.setColumns(10);
		textBairroCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textBairroCliente.getText().length() <= 0 || textBairroCliente.getText().isEmpty()){
					labelBairroCliente.setText("Bairro do cliente*");
					labelBairroCliente.setForeground(Color.RED);
				}
				else {
					labelBairroCliente.setText("Bairro do cliente");
					labelBairroCliente.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelBairroCliente.setText("Bairro do cliente");
				labelBairroCliente.setForeground(Color.BLACK);
			}
		});
		panelBairroCliente.add(textBairroCliente);
		
		JPanel panelCidadeCliente = new JPanel();
		panelCidadeCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNumeroBairroCidadeCliente.add(panelCidadeCliente);
		panelCidadeCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCidadeCliente = new JLabel("Cidade do cliente");
		labelCidadeCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCidadeCliente.add(labelCidadeCliente);
		
		textCidadeCliente = new JTextField();
		textCidadeCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCidadeCliente.setColumns(10);
		textCidadeCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textCidadeCliente.getText().length() <= 0 || textCidadeCliente.getText().isEmpty()){
					labelCidadeCliente.setText("Cidade do cliente*");
					labelCidadeCliente.setForeground(Color.RED);
				}
				else {
					labelCidadeCliente.setText("Cidade do cliente");
					labelCidadeCliente.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelCidadeCliente.setText("Cidade do cliente");
				labelCidadeCliente.setForeground(Color.BLACK);
			}
		});
		panelCidadeCliente.add(textCidadeCliente);
		
		JPanel panelTipoTransporte_EstadoCarga = new JPanel();
		panelCadastroParteA1.add(panelTipoTransporte_EstadoCarga);
		panelTipoTransporte_EstadoCarga.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelCodigoVenda = new JPanel();
		panelCodigoVenda.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoTransporte_EstadoCarga.add(panelCodigoVenda);
		panelCodigoVenda.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoVenda = new JLabel("Codigo da venda");
		labelCodigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCodigoVenda.add(labelCodigoVenda);
		
		textCodigoVenda = new JTextField();
		textCodigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCodigoVenda.setColumns(10);
		panelCodigoVenda.add(textCodigoVenda);
		
		JPanel panelTipoTransporte = new JPanel();
		panelTipoTransporte.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoTransporte_EstadoCarga.add(panelTipoTransporte);
		panelTipoTransporte.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoTransporte = new JLabel("Tipo de transporte");
		panelTipoTransporte.add(labelTipoTransporte);
		labelTipoTransporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textTipoTransporte = new JTextField();
		textTipoTransporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTipoTransporte.add(textTipoTransporte);
		textTipoTransporte.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textTipoTransporte.getText().isEmpty() || textTipoTransporte.getText().length() <= 0){
					labelTipoTransporte.setText("Tipo de transporte*");
					labelTipoTransporte.setForeground(Color.RED);
				}
				else {
					labelTipoTransporte.setText("Tipo de transporte");
					labelTipoTransporte.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelTipoTransporte.setText("Tipo de transporte");
				labelTipoTransporte.setForeground(Color.BLACK);
			}
		});
		
		JPanel panelEstadoCarga = new JPanel();
		panelTipoTransporte_EstadoCarga.add(panelEstadoCarga);
		panelEstadoCarga.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstadoCarga.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstadoCarga = new JLabel("Estado da carga");
		labelEstadoCarga.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEstadoCarga.add(labelEstadoCarga);
		
		comboBoxEstadoCarga = new JComboBox<String>();
		comboBoxEstadoCarga.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEstadoCarga.add(comboBoxEstadoCarga);
		comboBoxEstadoCarga.setMaximumRowCount(4);
		comboBoxEstadoCarga.addItem("Selecione");
		comboBoxEstadoCarga.addItem("Na loja");
		comboBoxEstadoCarga.addItem("Em transito");
		comboBoxEstadoCarga.addItem("Entregue");
		comboBoxEstadoCarga.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (comboBoxEstadoCarga.getSelectedItem() == "Selecione"){
					labelEstadoCarga.setText("Estado da carga*");
					labelEstadoCarga.setForeground(Color.RED);
				}
				else {
					labelEstadoCarga.setText("Estado da carga");
					labelEstadoCarga.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelEstadoCarga.setText("Estado da carga");
				labelEstadoCarga.setForeground(Color.BLACK);
			}
		});
		
		MaskFormatter dataSaidaMascara = null;
		MaskFormatter dataChegadaMascara = null;
		try{
			dataSaidaMascara = new MaskFormatter("##/##/####");
			dataChegadaMascara = new MaskFormatter("##/##/####");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		MaskFormatter horaSaidaMascara = null;
		MaskFormatter horaChegadaMascara = null;
		try{
			horaSaidaMascara = new MaskFormatter("##:##");
			horaChegadaMascara = new MaskFormatter("##:##");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		JPanel panelData_Hora = new JPanel();
		panelCadastroParteA1.add(panelData_Hora);
		panelData_Hora.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelDataSaida = new JPanel();
		panelDataSaida.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_Hora.add(panelDataSaida);
		panelDataSaida.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataSaida = new JLabel("Data de saida");
		labelDataSaida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelDataSaida.add(labelDataSaida);
		
		textDataSaida = new JFormattedTextField(dataSaidaMascara);
		textDataSaida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDataSaida.setColumns(10);
		textDataSaida.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textDataSaida.getText().replaceAll("\\/", "").trim().isEmpty()){
					labelDataSaida.setText("Data de saida*");
					labelDataSaida.setForeground(Color.RED);
				}
				else {
					labelDataSaida.setText("Data de saida");
					labelDataSaida.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelDataSaida.setText("Data de saida");
				labelDataSaida.setForeground(Color.BLACK);
			}
		});
		panelDataSaida.add(textDataSaida);
		textTipoTransporte.setColumns(10);
		
		JPanel panelHoraSaida = new JPanel();
		panelHoraSaida.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_Hora.add(panelHoraSaida);
		panelHoraSaida.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraSaida = new JLabel("Hora de saida");
		labelHoraSaida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelHoraSaida.add(labelHoraSaida);
		
		textHoraSaida = new JFormattedTextField(horaSaidaMascara);
		textHoraSaida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textHoraSaida.setColumns(10);
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
		panelHoraSaida.add(textHoraSaida);
		
		JPanel panelDataChegada = new JPanel();
		panelData_Hora.add(panelDataChegada);
		panelDataChegada.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataChegada.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataChegada = new JLabel("Data de chegada");
		labelDataChegada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelDataChegada.add(labelDataChegada);
		
		textDataChegada = new JFormattedTextField(dataChegadaMascara);
		textDataChegada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDataChegada.setColumns(10);
		textDataChegada.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textDataChegada.getText().replaceAll("\\/", "").trim().isEmpty()){
					labelDataChegada.setText("Data de chegada*");
					labelDataChegada.setForeground(Color.RED);
				}
				else {
					labelDataChegada.setText("Data de chegada");
					labelDataChegada.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelDataChegada.setText("Data de chegada");
				labelDataChegada.setForeground(Color.BLACK);
			}
		});
		panelDataChegada.add(textDataChegada);
		
		JPanel panelHoraChegada = new JPanel();
		panelData_Hora.add(panelHoraChegada);
		panelHoraChegada.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHoraChegada.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraChegada = new JLabel("Hora de chegada");
		labelHoraChegada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelHoraChegada.add(labelHoraChegada);
		
		textHoraChegada = new JFormattedTextField(horaChegadaMascara);
		textHoraChegada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textHoraChegada.setColumns(10);
		textHoraChegada.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textHoraChegada.getText().replace(":","").trim().isEmpty()){
					labelHoraChegada.setText("Hora de chegada*");
					labelHoraChegada.setForeground(Color.RED);
				}
				else {
					labelHoraChegada.setText("Hora de chegada");
					labelHoraChegada.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				labelHoraChegada.setText("Hora de chegada");
				labelHoraChegada.setForeground(Color.BLACK);
			}
		});
		panelHoraChegada.add(textHoraChegada);
				
		JPanel panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separator = new JSeparator();
		panelBotoes.add(separator, BorderLayout.NORTH);
		
		JPanel panelLegenda = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelLegenda.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(10);
		panelBotoes.add(panelLegenda, BorderLayout.WEST);
		
		JLabel labelLegenda = new JLabel("Legenda: (*) Campo importante que deve ser preenchido");
		panelLegenda.add(labelLegenda);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBotoes2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2, BorderLayout.CENTER);
		
		venda = new JButton("Venda");
		venda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastro_de_TransporteCargas_Adicionar_Codigo_Venda adicionar_Codigo_Venda = new Cadastro_de_TransporteCargas_Adicionar_Codigo_Venda();
				adicionar_Codigo_Venda.setVisible(true);
				String codigoVenda = adicionar_Codigo_Venda.getCodigoVenda();
				if (codigoVenda != null) {
					textCodigoVenda.setText(codigoVenda);
				}
			}
		});
		venda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(venda);
		
		cliente = new JButton("Cliente");
		cliente.setToolTipText("Seleciona um cliente");
		cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_de_TransporteCargas_Adicionar_Cliente AdicionarCliente = new Cadastro_de_TransporteCargas_Adicionar_Cliente();
				AdicionarCliente.setVisible(true);
				
				String resultadoNomeCliente= AdicionarCliente.getNomeCliente();
				String resultadoClienteCPF = AdicionarCliente.getClienteCPF();
				String resultadoClienteRG = AdicionarCliente.getClienteRG();
				String resultadoClienteCidade = AdicionarCliente.getClienteCidade();
				String resultadoClienteBairro = AdicionarCliente.getClienteBairro();
				String resultadoClienteNumero = AdicionarCliente.getClienteNumero();
				String resultadoClienteEndereco = AdicionarCliente.getClienteEndereco();
				
				if (resultadoNomeCliente != null || resultadoClienteCPF != null || resultadoClienteRG != null || resultadoClienteCidade != null ||
					resultadoClienteBairro != null || resultadoClienteNumero != null || resultadoClienteEndereco != null) {
						textNomeCliente.setText(resultadoNomeCliente);
						textClienteCPF.setText(resultadoClienteCPF);
						textClienteRG.setText(resultadoClienteRG);
						textCidadeCliente.setText(resultadoClienteCidade);
						textBairroCliente.setText(resultadoClienteBairro);
						textNumeroCliente.setText(resultadoClienteNumero);
						textEnderecoCliente.setText(resultadoClienteEndereco);
				}
			}
		});
		cliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(cliente);
		
		responsavel = new JButton("Responsavel");
		responsavel.setToolTipText("Seleciona um responsavel");
		responsavel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Descontos_e_Promocoes_Adicionar_Responsavel AdicionarResponsavel = new Descontos_e_Promocoes_Adicionar_Responsavel();
				AdicionarResponsavel.setVisible(true);
				
				String resultadoNomeFuncionario = AdicionarResponsavel.getNomeFuncionario();
				String resultadoCodigoFuncionario = AdicionarResponsavel.getCodigoFuncionario();
				String resultadoCargoFuncionario = AdicionarResponsavel.getCargoFuncionario();
				
				if (resultadoNomeFuncionario != null || resultadoCodigoFuncionario != null || resultadoCargoFuncionario != null) {
					textNomeFuncionario.setText(resultadoNomeFuncionario);
					textCodigoFuncionario.setText(resultadoCodigoFuncionario);
					textCargoFuncionario.setText(resultadoCargoFuncionario);
				}
			}
		});
		responsavel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(responsavel);
		
		salvar = new JButton("Salvar");
		salvar.setToolTipText("Salva os dados do cadastro");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textNomeFuncionario.getText().length() <= 0 || textNomeFuncionario.getText().isEmpty() ||
					textCargoFuncionario.getText().length() <= 0 || textCargoFuncionario.getText().isEmpty() ||
					textCodigoFuncionario.getText().length() <= 0 || textCodigoFuncionario.getText().isEmpty() ||
					textCodigoVenda.getText().length() <= 0 || textCodigoVenda.getText().isEmpty() ||
					textNomeCliente.getText().length() <= 0 || textNomeCliente.getText().isEmpty() ||
					textClienteCPF.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty() ||
					textClienteRG.getText().replaceAll("\\.", "").replace("-","").trim().isEmpty() ||
					textTipoTransporte.getText().length() <= 0 || textTipoTransporte.getText().isEmpty() ||
					textNumeroCliente.getText().length() <= 0 || textNumeroCliente.getText().isEmpty() ||
					textBairroCliente.getText().length() <= 0 || textBairroCliente.getText().isEmpty() ||
					textCidadeCliente.getText().length() <= 0 || textCidadeCliente.getText().isEmpty() ||
					textEnderecoCliente.getText().length() <= 0 || textEnderecoCliente.getText().isEmpty() ||
					comboBoxEstadoCarga.getSelectedItem() == "Selecione" ||
					textDataSaida.getText().replaceAll("\\/", "").trim().isEmpty() ||
					textDataChegada.getText().replaceAll("\\/", "").trim().isEmpty() ||
					textHoraSaida.getText().replace(":", "").trim().isEmpty() ||
					textHoraChegada.getText().replace(":", "").trim().isEmpty()) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					cadastrarTransporteCarga = new TransporteCarga();
					
					cadastrarTransporteCarga.setFuncionarioResponsavel(textNomeFuncionario.getText());
					cadastrarTransporteCarga.setCargoResponsavel(textCargoFuncionario.getText());
					cadastrarTransporteCarga.setCodigoResponsavel(textCodigoFuncionario.getText());
					
					cadastrarTransporteCarga.setClienteNome(textNomeCliente.getText());
					cadastrarTransporteCarga.setClienteCPF(textClienteCPF.getText());
					cadastrarTransporteCarga.setClienteRG(textClienteRG.getText());
					
					cadastrarTransporteCarga.setEnderecoCliente(textEnderecoCliente.getText());
					cadastrarTransporteCarga.setClienteNumero(textNumeroCliente.getText());
					cadastrarTransporteCarga.setClienteBairro(textBairroCliente.getText());
					cadastrarTransporteCarga.setClienteCidade(textCidadeCliente.getText());
					cadastrarTransporteCarga.setTipoTransporte(textTipoTransporte.getText());
					
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
					cadastrarTransporteCarga.setCodigoTransporte(codigoRegistro);
					
					cadastrarTransporteCarga.setEstadoCarga((String)comboBoxEstadoCarga.getSelectedItem());
					
					cadastrarTransporteCarga.setCodigoVenda(textCodigoVenda.getText());
					
					dataSaidaTansporte = textDataSaida.getText();
					try {
						dataSaidaFormato = new SimpleDateFormat("dd/MM/yyyy");
						dataSaida = new java.sql.Date(dataSaidaFormato.parse(dataSaidaTansporte).getTime());
						cadastrarTransporteCarga.setDataSaida(dataSaida);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					dataChegadaTransporte = textDataChegada.getText();
					try {
						dataChegadaFormato = new SimpleDateFormat("dd/MM/yyyy");
						dataChegada = new java.sql.Date(dataChegadaFormato.parse(dataChegadaTransporte).getTime());
						cadastrarTransporteCarga.setDataChegada(dataChegada);
					} catch (ParseException e2) {
						e2.printStackTrace();
					}
					
					try {
						java.util.Date dataRegistro = new java.util.Date();
						SimpleDateFormat dataRegistroFormato = new SimpleDateFormat("dd/MM/yyyy");
						String dataCadastroFuncionario = dataRegistroFormato.format(dataRegistro);
						SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
						Date dataCadastro = new java.sql.Date(dataCadastroFormato.parse(dataCadastroFuncionario).getTime());
						cadastrarTransporteCarga.setDataCadastro(dataCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
					}
					
					horaSaidaTansporte = textHoraSaida.getText();
					try {
						horaSaidaFormato = new SimpleDateFormat("HH:mm");
						horaSaida = new java.sql.Time(horaSaidaFormato.parse(horaSaidaTansporte).getTime());
						cadastrarTransporteCarga.setHoraSaida(horaSaida);
					} catch (ParseException e4) {
						e4.printStackTrace();
					}
					
					horaChegadaTransporte = textHoraChegada.getText();
					try {
						horaChegadaFormato = new SimpleDateFormat("HH:mm");
						horaChegada = new java.sql.Time(horaChegadaFormato.parse(horaChegadaTransporte).getTime());
						cadastrarTransporteCarga.setHoraChegada(horaChegada);
					} catch (ParseException e5) {
						e5.printStackTrace();
					}

					try {
						java.util.Date horaRegistro = new java.util.Date();
						SimpleDateFormat horaRegistroFormato = new SimpleDateFormat("HH:mm");
						String horaCadastroFuncionario = horaRegistroFormato.format(horaRegistro);
						SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
						Time horaCadastro = new java.sql.Time(horaCadastroFormato.parse(horaCadastroFuncionario).getTime());
						cadastrarTransporteCarga.setHoraCadastro(horaCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
					}
					
					/*Cadastro do nome do funcionario*/
					if (nomeUsuario == null) {
						String nomeFuncionario = "Nome";
						cadastrarTransporteCarga.setFuncionarioCadastro(nomeFuncionario);
					}
					else {
						cadastrarTransporteCarga.setFuncionarioCadastro(nomeUsuario);
					}
					
					/*Cadastro do codigo do funcionario*/
					if (codigoUsuario == null) {
						String codigoFuncionario = "Codigo";
						cadastrarTransporteCarga.setCodigoFuncionarioCadastro(codigoFuncionario);
					}
					else {
						cadastrarTransporteCarga.setCodigoFuncionarioCadastro(codigoUsuario);
					}
					
					if (cargoUsuario == null) {
						String cargoFuncionario = "Cargo";
						cadastrarTransporteCarga.setCargoFuncionarioCadastro(cargoFuncionario);
					}
					else {
						cadastrarTransporteCarga.setCargoFuncionarioCadastro(cargoUsuario);
					}
					
					/*Envia os dados para a classe que salva os dados no banco*/
					salvaDados = new Dao_inserir_dados_transportecarga();
					salvaDados.Inserir_Dados_Transporte_Carga(cadastrarTransporteCarga);
					
					
					//Mensagem de confirmação do cadastro
					String menssagemConteudo = "Dados cadastrados com sucesso";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
					
					textNomeFuncionario.setText("");
					textCargoFuncionario.setText("");
					textCodigoFuncionario.setText("");
					textNomeCliente.setText("");
					textClienteCPF.setText("");
					textClienteRG.setText("");
					textEnderecoCliente.setText("");
					textNumeroCliente.setText("");
					textBairroCliente.setText("");
					textCidadeCliente.setText("");
					textTipoTransporte.setText("");
					textDataSaida.setText("");
					textHoraSaida.setText("");
					textDataChegada.setText("");
					textHoraChegada.setText("");
					textCodigoVenda.setText("");
					comboBoxEstadoCarga.setSelectedItem("Selecione");
					labelNomeFuncionario.setText("Nome do funcionario responsavel");
					labelNomeFuncionario.setForeground(Color.BLACK);
					labelNomeCliente.setText("Nome do cliente");
					labelNomeCliente.setForeground(Color.BLACK);
					labelClienteCPF.setText("CPF do cliente");
					labelClienteCPF.setForeground(Color.BLACK);
					labelClienteRG.setText("RG do cliente");
					labelClienteRG.setForeground(Color.BLACK);
					labelCodigoVenda.setText("Codigo da venda");
					labelCodigoVenda.setForeground(Color.BLACK);
					labelEnderecoCliente.setText("Endereço do cliente");
					labelEnderecoCliente.setForeground(Color.BLACK);
					labelNumeroCliente.setText("Numero do cliente");
					labelNumeroCliente.setForeground(Color.BLACK);
					labelBairroCliente.setText("Bairro do cliente");
					labelBairroCliente.setForeground(Color.BLACK);
					labelCidadeCliente.setText("Cidade do cliente");
					labelCidadeCliente.setForeground(Color.BLACK);
					labelTipoTransporte.setText("Tipo de transporte");
					labelTipoTransporte.setForeground(Color.BLACK);
					labelEstadoCarga.setText("Estado da carga");
					labelEstadoCarga.setForeground(Color.BLACK);
					labelDataSaida.setText("Data de saida");
					labelDataSaida.setForeground(Color.BLACK);
					labelHoraSaida.setText("Hora de saida");
					labelHoraSaida.setForeground(Color.BLACK);
					labelDataChegada.setText("Data de chegada");
					labelDataChegada.setForeground(Color.BLACK);
					labelHoraChegada.setText("Hora de chegada");
					labelHoraChegada.setForeground(Color.BLACK);
				}
			}
		});
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(salvar);
		
		limpar = new JButton("Limpar");
		limpar.setToolTipText("Limpa os campos");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNomeFuncionario.setText("");
				textCargoFuncionario.setText("");
				textCodigoFuncionario.setText("");
				textNomeCliente.setText("");
				textClienteCPF.setText("");
				textClienteRG.setText("");
				textEnderecoCliente.setText("");
				textNumeroCliente.setText("");
				textBairroCliente.setText("");
				textCidadeCliente.setText("");
				textTipoTransporte.setText("");
				textDataSaida.setText("");
				textHoraSaida.setText("");
				textDataChegada.setText("");
				textHoraChegada.setText("");
				textCodigoVenda.setText("");
				comboBoxEstadoCarga.setSelectedItem("Selecione");
				labelNomeFuncionario.setText("Nome do funcionario responsavel");
				labelNomeFuncionario.setForeground(Color.BLACK);
				labelNomeCliente.setText("Nome do cliente");
				labelNomeCliente.setForeground(Color.BLACK);
				labelClienteCPF.setText("CPF do cliente");
				labelClienteCPF.setForeground(Color.BLACK);
				labelClienteRG.setText("RG do cliente");
				labelClienteRG.setForeground(Color.BLACK);
				labelCodigoVenda.setText("Codigo da venda");
				labelCodigoVenda.setForeground(Color.BLACK);
				labelEnderecoCliente.setText("Endereço do cliente");
				labelEnderecoCliente.setForeground(Color.BLACK);
				labelNumeroCliente.setText("Numero do cliente");
				labelNumeroCliente.setForeground(Color.BLACK);
				labelBairroCliente.setText("Bairro do cliente");
				labelBairroCliente.setForeground(Color.BLACK);
				labelCidadeCliente.setText("Cidade do cliente");
				labelCidadeCliente.setForeground(Color.BLACK);
				labelTipoTransporte.setText("Tipo de transporte");
				labelTipoTransporte.setForeground(Color.BLACK);
				labelEstadoCarga.setText("Estado da carga");
				labelEstadoCarga.setForeground(Color.BLACK);
				labelDataSaida.setText("Data de saida");
				labelDataSaida.setForeground(Color.BLACK);
				labelHoraSaida.setText("Hora de saida");
				labelHoraSaida.setForeground(Color.BLACK);
				labelDataChegada.setText("Data de chegada");
				labelDataChegada.setForeground(Color.BLACK);
				labelHoraChegada.setText("Hora de chegada");
				labelHoraChegada.setForeground(Color.BLACK);
			}
		});
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(limpar);
		
		voltar = new JButton("Voltar");
		voltar.setToolTipText("Fecha a janela");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textNomeFuncionario.getText().length() != 0 || textCargoFuncionario.getText().length() != 0 || textCodigoFuncionario.getText().length() != 0 ||
					textCodigoVenda.getText().length() != 0 || textClienteCPF.getText().replaceAll("\\.", "").replace("-","").trim().length() != 0 ||
					textClienteRG.getText().replaceAll("\\.", "").replace("-","").trim().length() != 0 || textNomeCliente.getText().length() != 0 ||
					textTipoTransporte.getText().length() != 0 || textEnderecoCliente.getText().length() != 0 || textNumeroCliente.getText().length() != 0 ||
					textBairroCliente.getText().length() != 0 || textCidadeCliente.getText().length() != 0 || comboBoxEstadoCarga.getSelectedItem() != "Selecione" ||
					textDataSaida.getText().replaceAll("\\/", "").trim().length() != 0 || textDataChegada.getText().replaceAll("\\/", "").trim().length() != 0 ||
					textHoraSaida.getText().replace(":", "").trim().length() != 0 || textHoraChegada.getText().replace(":", "").trim().length() != 0) {
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
                	if (textNomeFuncionario.getText().length() != 0 || textCargoFuncionario.getText().length() != 0 || textCodigoFuncionario.getText().length() != 0 ||
                		textCodigoVenda.getText().length() != 0 || textClienteCPF.getText().replaceAll("\\.", "").replace("-","").trim().length() != 0 ||
    					textClienteRG.getText().replaceAll("\\.", "").replace("-","").trim().length() != 0 || textNomeCliente.getText().length() != 0 ||
    					textTipoTransporte.getText().length() != 0 || textEnderecoCliente.getText().length() != 0 || textNumeroCliente.getText().length() != 0 ||
    					textBairroCliente.getText().length() != 0 || textCidadeCliente.getText().length() != 0 || comboBoxEstadoCarga.getSelectedItem() != "Selecione" ||
    					textDataSaida.getText().replaceAll("\\/", "").trim().length() != 0 || textDataChegada.getText().replaceAll("\\/", "").trim().length() != 0 ||
    					textHoraSaida.getText().replace(":", "").trim().length() != 0 || textHoraChegada.getText().replace(":", "").trim().length() != 0) {
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