package aInterfaceSistema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloAdministrativoAcessoLogBD.AcessoLog;
import moduloAdministrativoAcessoLogBD.Dao_inserir_dados_acessolog;
import moduloFuncionarioBD.Dao_consulta_dados_funcionario_login;

public class Tela_de_Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaLogin;
	private JTextField textLogin;
	private JPasswordField textSenha;
	private JButton entrar, sair;
	AcessoLog cadastroLogAcesso;
	Dao_inserir_dados_acessolog salvaDados;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_Login frame = new Tela_de_Login();
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
	public Tela_de_Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_de_Login.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 304, 404);
		setResizable(false);
		setSize(300, 400);
		
		telaLogin = new JPanel();
		telaLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaLogin.setLayout(new BorderLayout(10, 10));
		setContentPane(telaLogin);
		
		JPanel panelTitulo = new JPanel();
		telaLogin.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Tela_de_Login.class.getResource("/cImagens/Logo Vecx System.PNG")));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setPreferredSize(new Dimension(50, 50));
		icone.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		icone.setBorder(new LineBorder(Color.BLACK, 2));
		panelTitulo.add(icone);
		
		JLabel tituloLogin = new JLabel("Vecx System");
		tituloLogin.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		panelTitulo.add(tituloLogin);
		
		JPanel panelLogin = new JPanel();
		telaLogin.add(panelLogin, BorderLayout.CENTER);
		panelLogin.setBounds(0, 0, 250, 300);
		panelLogin.setLayout(new GridLayout(3, 1, 0, 10));
		
		JPanel panelUsuarioLogin = new JPanel();
		panelLogin.add(panelUsuarioLogin);
		panelUsuarioLogin.setPreferredSize(new Dimension(10, 60));
		panelUsuarioLogin.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLogin = new JLabel("Login");
		panelUsuarioLogin.add(labelLogin);
		labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textLogin = new JTextField();
		panelUsuarioLogin.add(textLogin);
		textLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textLogin.setColumns(10);
		
		JPanel panelUsuarioSenha = new JPanel();
		panelLogin.add(panelUsuarioSenha);
		panelUsuarioSenha.setPreferredSize(new Dimension(10, 60));
		panelUsuarioSenha.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSenha = new JLabel("Senha");
		panelUsuarioSenha.add(labelSenha);
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textSenha = new JPasswordField();
		panelUsuarioSenha.add(textSenha);
		textSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textSenha.setColumns(10);
		
		JPanel panelBotao = new JPanel();
		telaLogin.add(panelBotao, BorderLayout.SOUTH);
		panelBotao.setLayout(new BorderLayout(0, 5));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotao.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotao2 = new JPanel();
		panelBotao.add(panelBotao2, BorderLayout.SOUTH);
		
		entrar = new JButton("Entrar");
		entrar.setToolTipText("Entrar no menu");
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String loginTextoADM = "adm";
				String senhaTextoADM = "adm";
				
				String loginTextoGerente = "gerente";
				String senhaTextoGerente = "gerente";
				
				String loginTextoAtendente = "atendente";
				String senhaTextoAtendente = "atendente";
				
				String loginTextoCarregador = "carregador";
				String senhaTextoCarregador = "carregador";
				
				String loginTextoCompara = textLogin.getText();
				String senhaTextoCompara = new String(textSenha.getPassword());
				
				if (textLogin.getText().length() <= 0 || textLogin.getText().isEmpty() ||
					textSenha.getPassword().length <= 0) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else if (textLogin.getText().length() <= 0 ||textLogin.getText().isEmpty() ||
						textSenha.getPassword().length <= 0 || loginTextoCompara.equals(loginTextoADM) ||
						senhaTextoCompara.equals(senhaTextoADM)) {
							String nomeUsuarioA = "adm";
							String cargoUsuarioA = "adm";
							String codigoUsuarioA = "adm1";
							sessao.setNome(nomeUsuarioA);
							sessao.setCargo(cargoUsuarioA);
							sessao.setCodigo(codigoUsuarioA);
							Tela_de_Menu telaMenu = new Tela_de_Menu();
							telaMenu.setVisible(true); 
				            dispose();
				}
				else if (textLogin.getText().length() <= 0 ||textLogin.getText().isEmpty() ||
						textSenha.getPassword().length <= 0 || loginTextoCompara.equals(loginTextoGerente) ||
						senhaTextoCompara.equals(senhaTextoGerente)) {
							String nomeUsuarioB = "Gerente";
							String cargoUsuarioB = "Gerente";
							String codigoUsuarioB = "Gerente1";
							sessao.setNome(nomeUsuarioB);
							sessao.setCargo(cargoUsuarioB);
							sessao.setCodigo(codigoUsuarioB);
							Tela_de_Menu telaMenu = new Tela_de_Menu();
							telaMenu.setVisible(true); 
				            dispose();
				}
				else if (textLogin.getText().length() <= 0 ||textLogin.getText().isEmpty() ||
						textSenha.getPassword().length <= 0 || loginTextoCompara.equals(loginTextoAtendente) ||
						senhaTextoCompara.equals(senhaTextoAtendente)) {
							String nomeUsuarioC = "Atendente";
							String cargoUsuarioC = "Atendente";
							String codigoUsuarioC = "Atendente1";
							sessao.setNome(nomeUsuarioC);
							sessao.setCargo(cargoUsuarioC);
							sessao.setCodigo(codigoUsuarioC);
							Tela_de_Menu telaMenu = new Tela_de_Menu();
							telaMenu.setVisible(true); 
				            dispose();
				}
				else if (textLogin.getText().length() <= 0 ||textLogin.getText().isEmpty() ||
						textSenha.getPassword().length <= 0 || loginTextoCompara.equals(loginTextoCarregador) ||
						senhaTextoCompara.equals(senhaTextoCarregador)) {
							String nomeUsuarioD = "Carregador";
							String cargoUsuarioD = "Carregador";
							String codigoUsuarioD = "Carregador1";
							sessao.setNome(nomeUsuarioD);
							sessao.setCargo(cargoUsuarioD);
							sessao.setCodigo(codigoUsuarioD);
							Tela_de_Menu telaMenu = new Tela_de_Menu();
							telaMenu.setVisible(true); 
				            dispose();
				}
				else {
					/*Parte que consulta os dados no banco de dados*/
					String loginTexto = textLogin.getText();
					String senhaTexto = new String(textSenha.getPassword());
		    		
		    		boolean consultaLoginSenha;
		    		consultaLoginSenha = new Dao_consulta_dados_funcionario_login().Consulta_Dados_Funcionario_Login(loginTexto, senhaTexto);
		    		
		    		if (consultaLoginSenha == false) {
						String menssagemConteudo = "Login e Senha incorretos ou não registrados";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						mensagemConfirmacao.setVisible(true);
					}
		    		else {
						cadastroLogAcesso = new AcessoLog();
						
						cadastroLogAcesso.setLogin(textLogin.getText());
						
						String senhaCadastro  = new String(textSenha.getPassword());
						cadastroLogAcesso.setSenha(senhaCadastro);
						
						String consultaFuncionarioNome;
						consultaFuncionarioNome = new Dao_consulta_dados_funcionario_login().Consulta_Dados_Funcionario_NomeFuncionario(loginTexto, senhaTexto);
						cadastroLogAcesso.setFuncionarioNome(consultaFuncionarioNome);
						
						String consultaCodigoFuncionario;
						consultaCodigoFuncionario = new Dao_consulta_dados_funcionario_login().Consulta_Dados_Funcionario_CodigoFuncionario(loginTexto, senhaTexto);
						cadastroLogAcesso.setCodigoFuncionario(consultaCodigoFuncionario);
						
						String consultaCargo;
						consultaCargo = new Dao_consulta_dados_funcionario_login().Consulta_Dados_Funcionario_Cargo(loginTexto, senhaTexto);
						cadastroLogAcesso.setCargo(consultaCargo);
						
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
						cadastroLogAcesso.setCodigoResgistro(codigoRegistro);
						
						try {
							java.util.Date dataRegistro = new java.util.Date();
							SimpleDateFormat dataRegistroFormato = new SimpleDateFormat("dd/MM/yyyy");
							String dataAcessoUsuario = dataRegistroFormato.format(dataRegistro);
							SimpleDateFormat dataAcessoFormato = new SimpleDateFormat("dd/MM/yyyy");
							Date dataAcesso = new java.sql.Date(dataAcessoFormato.parse(dataAcessoUsuario).getTime());
							cadastroLogAcesso.setDataAcesso(dataAcesso);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						try {
							java.util.Date horaRegistro = new java.util.Date();
							SimpleDateFormat horaRegistroFormato = new SimpleDateFormat("HH:mm");
							String horaAcessoUsuario = horaRegistroFormato.format(horaRegistro);
							SimpleDateFormat horaAcessoFormato = new SimpleDateFormat("HH:mm");
							Time horaAcesso = new java.sql.Time(horaAcessoFormato.parse(horaAcessoUsuario).getTime());
							cadastroLogAcesso.setHoraAcesso(horaAcesso);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						salvaDados = new Dao_inserir_dados_acessolog();
						salvaDados.Inserir_Dados_AcessoLog(cadastroLogAcesso);
						
						sessao.setLogin(textLogin.getText());
						sessao.setSenha(new String(textSenha.getPassword()));
						sessao.setCodigo(consultaCodigoFuncionario);
						sessao.setNome(consultaFuncionarioNome);
						sessao.setCargo(consultaCargo);
						
						textLogin.setText("");
						textSenha.setText("");
						
						Tela_de_Menu telaMenu = new Tela_de_Menu();
						telaMenu.setVisible(true); 
			            dispose();
					}
				}
			}
		});
		panelBotao2.setLayout(new GridLayout(0, 2, 5, 0));
		entrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		entrar.setPreferredSize(new Dimension(100, 30));
		panelBotao2.add(entrar);
		
		sair = new JButton("Sair");
		sair.setToolTipText("Fecha a janela");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menssagemTitulo = "Deseja sair do programa?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo aviso = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemTitulo);
				aviso.setVisible(true);
				
				String resposta = aviso.getResposta();
				if (resposta != null) {
					if (resposta.equals("Sim")) {
						System.exit(0);
					}
				}
			}
		});
		sair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sair.setPreferredSize(new Dimension(100, 30));
		panelBotao2.add(sair);
		
		addWindowListener(
            new WindowAdapter() 
            {
                public void windowClosing(WindowEvent we) {
                	String menssagemTitulo = "Deseja sair do programa?";
    				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo aviso = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemTitulo);
    				aviso.setVisible(true);
    				
    				String resposta = aviso.getResposta();
    				if (resposta != null) {
    					if (resposta.equals("Sim")) {
    						System.exit(0);
    					}
    				}
                }
            }
        );
	}
	
}