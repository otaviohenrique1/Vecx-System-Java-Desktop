package moduloAdministrativoAcessoLogTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import aInterfaceSistema.Sessao;
import moduloAdministrativoAcessoLogBD.AcessoLog;
import moduloAdministrativoAcessoLogBD.Dao_consulta_dados_acessolog_ficha;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Controle_de_Acesso_Ficha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaAcesso;
	private JButton voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controle_de_Acesso_Ficha frame = new Controle_de_Acesso_Ficha();
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
	public Controle_de_Acesso_Ficha() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Controle_de_Acesso_Ficha.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		setSize(700, 400);
		
		telaFichaAcesso = new JPanel();
		telaFichaAcesso.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaAcesso.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaAcesso);
		
		JPanel panelTitulo = new JPanel();
		telaFichaAcesso.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Controle_de_Acesso_Ficha.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFichaAcessoLog = new JLabel("Ficha de acesso ");
		panelTitulo2.add(labelFichaAcessoLog);
		labelFichaAcessoLog.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Controle_de_Acesso.class.getResource("/cImagens/Funcionario.png")));
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
		telaFichaAcesso.add(scrollPaneCadastro, BorderLayout.CENTER);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNomeFuncionario = new JPanel();
		panelNomeFuncionario.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelNomeFuncionario);
		panelNomeFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeFuncionario = new JLabel("Nome");
		panelNomeFuncionario.add(labelNomeFuncionario);
		labelNomeFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel nomeFuncionario = new JLabel();
		panelNomeFuncionario.add(nomeFuncionario);
		nomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCargo_CodFun = new JPanel();
		panelCadastro.add(panelCargo_CodFun);
		panelCargo_CodFun.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargo = new JPanel();
		panelCargo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_CodFun.add(panelCargo);
		panelCargo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargo = new JLabel("Cargo");
		panelCargo.add(labelCargo);
		labelCargo.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cargo = new JLabel();
		panelCargo.add(cargo);
		cargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCodigoFuncionario = new JPanel();
		panelCodigoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_CodFun.add(panelCodigoFuncionario);
		panelCodigoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoFuncionario = new JLabel("Codigo do funcionario");
		panelCodigoFuncionario.add(labelCodigoFuncionario);
		labelCodigoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel codigoFuncionario = new JLabel();
		panelCodigoFuncionario.add(codigoFuncionario);
		codigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelLogin_CodigoRegistro = new JPanel();
		panelCadastro.add(panelLogin_CodigoRegistro);
		panelLogin_CodigoRegistro.setLayout(new GridLayout(0, 1, 5, 0));
		
		JPanel panelLogin = new JPanel();
		panelLogin_CodigoRegistro.add(panelLogin);
		panelLogin.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelLogin.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLogin = new JLabel("Login");
		panelLogin.add(labelLogin);
		labelLogin.setHorizontalAlignment(SwingConstants.LEFT);
		labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel login = new JLabel();
		panelLogin.add(login);
		login.setPreferredSize(new Dimension(80, 14));
		login.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCodigoRegistro_DataHora = new JPanel();
		panelCadastro.add(panelCodigoRegistro_DataHora);
		panelCodigoRegistro_DataHora.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCodigoRegistro = new JPanel();
		panelCodigoRegistro_DataHora.add(panelCodigoRegistro);
		panelCodigoRegistro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoRegistro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoRegistro = new JLabel("Codigo de registro");
		labelCodigoRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoRegistro.add(labelCodigoRegistro);
		
		JLabel codigoRegistro = new JLabel();
		codigoRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoRegistro.add(codigoRegistro);
		
		JPanel panelDataHora = new JPanel();
		panelDataHora.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoRegistro_DataHora.add(panelDataHora);
		panelDataHora.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHora = new JLabel("Data e hora de cadastro");
		panelDataHora.add(labelDataHora);
		labelDataHora.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel dataHoraAcessoLog = new JLabel();
		panelDataHora.add(dataHoraAcessoLog);
		dataHoraAcessoLog.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		/*Parte que consulta os dados no banco de dados*/
		String codigoAcessoConsulta = sessao.getAcessoCodigo();
		String funcionarioAcessoConsulta = sessao.getAcessoFuncionario();
		String cargoAcessoConsulta = sessao.getAcessoCargo();
		Dao_consulta_dados_acessolog_ficha teste = new Dao_consulta_dados_acessolog_ficha();
    	List<AcessoLog> Consulta = teste.Consulta_Dados_AcessoLog(codigoAcessoConsulta, funcionarioAcessoConsulta, cargoAcessoConsulta);
    	for (AcessoLog leitura : Consulta) {
    		/*Nome do funcionario*/
    		String nomeFuncionarioTexto = leitura.getFuncionarioNome();
    		nomeFuncionario.setText(nomeFuncionarioTexto);
    		
    		/*Codigo do funcionario*/
    		String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
    		codigoFuncionario.setText(codigoFuncionarioTexto);
    		
    		/*Cargo do funcionario*/
    		String cargoFuncionarioTexto = leitura.getCargo();
    		cargo.setText(cargoFuncionarioTexto);

    		/*Codigo de registro*/
    		String codigoRegistroTexto = leitura.getCodigoResgistro();
    		codigoRegistro.setText(codigoRegistroTexto);
    		
    		/*Data e hora de acesso log*/
    		Date dataAcesso = leitura.getDataAcesso();
    		SimpleDateFormat dataAcessoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataAcessoUsuario = dataAcessoFormato.format(dataAcesso);
    		Time horaAcesso = leitura.getHoraAcesso();
    		SimpleDateFormat horaAcessoFormato = new SimpleDateFormat("HH:mm");
    		String horaAcessoUsuario = horaAcessoFormato.format(horaAcesso);
    		String dataHoraAcesso = dataAcessoUsuario + " " + horaAcessoUsuario;
    		dataHoraAcessoLog.setText(dataHoraAcesso);
    		
    		/*Login do funcionario*/
    		String loginFuncionarioTexto = leitura.getLogin();
    		login.setText(loginFuncionarioTexto);	
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaAcesso.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
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