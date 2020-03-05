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
import moduloFuncionarioBD.Dao_consulta_dados_funcionario;
import moduloFuncionarioBD.Funcionario;

public class Ficha_do_Funcionario_Exibicao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaFuncionario;
	private JButton voltar;
	Sessao sessao = Sessao.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficha_do_Funcionario_Exibicao frame = new Ficha_do_Funcionario_Exibicao();
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
	public Ficha_do_Funcionario_Exibicao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ficha_do_Funcionario_Exibicao.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		setSize(1000, 600);
		telaFichaFuncionario = new JPanel();
		telaFichaFuncionario.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaFuncionario.setLayout(new BorderLayout(0, 10));
		setContentPane(telaFichaFuncionario);
		
		JPanel panelTitulo = new JPanel();
		telaFichaFuncionario.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Ficha_do_Funcionario_Exibicao.class.getResource("/cImagens/Editar.PNG")));
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
		fichaUsuario.setIcon(new ImageIcon(Ficha_do_Funcionario_Exibicao.class.getResource("/cImagens/Funcionario.png")));
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
		JPanel panelDadosPessoais = new JPanel();
		telaFichaFuncionario.add(panelDadosPessoais, BorderLayout.CENTER);
		panelDadosPessoais.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneDadosPessoais = new JScrollPane();
		scrollPaneDadosPessoais.getVerticalScrollBar().setUnitIncrement(10);
		panelDadosPessoais.add(scrollPaneDadosPessoais);
		
		JPanel panelFichaDadosPessoais = new JPanel();
		scrollPaneDadosPessoais.setViewportView(panelFichaDadosPessoais);
		panelFichaDadosPessoais.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelFichaParteA1 = new JPanel();
		panelFichaParteA1.setPreferredSize(new Dimension(150, 150));
		panelFichaDadosPessoais.add(panelFichaParteA1);
		panelFichaParteA1.setLayout(new GridLayout(3, 1, 0, 5));
		
		JPanel panelNome_CodFun = new JPanel();
		panelFichaParteA1.add(panelNome_CodFun);
		panelNome_CodFun.setLayout(new BorderLayout(5, 0));
		
		JPanel panelNome = new JPanel();
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome_CodFun.add(panelNome);
		panelNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNome = new JLabel("Nome");
		panelNome.add(labelNome);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel nome = new JLabel();
		panelNome.add(nome);
		nome.setHorizontalAlignment(SwingConstants.LEFT);
		nome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCodigoFuncionario = new JPanel();
		panelCodigoFuncionario.setPreferredSize(new Dimension(200, 10));
		panelNome_CodFun.add(panelCodigoFuncionario, BorderLayout.EAST);
		panelCodigoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoFuncionario = new JLabel("Codigo do funcionario");
		labelCodigoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFuncionario.add(labelCodigoFuncionario);
		
		JLabel codigoFuncionario = new JLabel();
		codigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFuncionario.add(codigoFuncionario);
		
		JPanel panelData_RG_CPF = new JPanel();
		panelFichaParteA1.add(panelData_RG_CPF);
		panelData_RG_CPF.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelDataHoraFuncionario = new JPanel();
		panelDataHoraFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_RG_CPF.add(panelDataHoraFuncionario);
		panelDataHoraFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraFuncionario = new JLabel("Data e hora do cadastro");
		labelDataHoraFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraFuncionario.add(labelDataHoraFuncionario);
		
		JLabel dataHoraFuncionario = new JLabel();
		panelDataHoraFuncionario.add(dataHoraFuncionario);
		dataHoraFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelRG = new JPanel();
		panelData_RG_CPF.add(panelRG);
		panelRG.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRG.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelRG = new JLabel("RG");
		panelRG.add(labelRG);
		labelRG.setHorizontalAlignment(SwingConstants.LEFT);
		labelRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel rg = new JLabel();
		panelRG.add(rg);
		rg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCPF = new JPanel();
		panelCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_RG_CPF.add(panelCPF);
		panelCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPF = new JLabel("CPF");
		panelCPF.add(labelCPF);
		labelCPF.setHorizontalAlignment(SwingConstants.LEFT);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cpf = new JLabel();
		panelCPF.add(cpf);
		cpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		
		JLabel dataNascimento = new JLabel();
		panelDataNascimento.add(dataNascimento);
		dataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelSexo = new JPanel();
		panelSexo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDaNasc_Sexo_EstCivil.add(panelSexo);
		panelSexo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSexo = new JLabel("Sexo");
		panelSexo.add(labelSexo);
		labelSexo.setHorizontalAlignment(SwingConstants.LEFT);
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel sexo = new JLabel();
		panelSexo.add(sexo);
		sexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEstadoCivil = new JPanel();
		panelDaNasc_Sexo_EstCivil.add(panelEstadoCivil);
		panelEstadoCivil.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstadoCivil.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstadoCivil = new JLabel("Estado civil");
		labelEstadoCivil.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoCivil.add(labelEstadoCivil);
		
		JLabel estadoCivil = new JLabel();
		estadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoCivil.add(estadoCivil);
		
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
		
		JLabel telefone1 = new JLabel();
		panelTelefone1.add(telefone1);
		telefone1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTelefone2 = new JPanel();
		panelTelefone_Celular.add(panelTelefone2);
		panelTelefone2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTelefone2 = new JLabel("Telefone 2");
		labelTelefone2.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTelefone2.add(labelTelefone2);
		
		JLabel telefone2 = new JLabel();
		telefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTelefone2.add(telefone2);
		
		JPanel panelCelular1 = new JPanel();
		panelTelefone_Celular.add(panelCelular1);
		panelCelular1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCelular1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular1 = new JLabel("Celular 1");
		panelCelular1.add(labelCelular1);
		labelCelular1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel celular1 = new JLabel();
		panelCelular1.add(celular1);
		celular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCelular2 = new JPanel();
		panelTelefone_Celular.add(panelCelular2);
		panelCelular2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCelular2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular2 = new JLabel("Celular 2");
		labelCelular2.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCelular2.add(labelCelular2);
		
		JLabel celular2 = new JLabel();
		celular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCelular2.add(celular2);
		
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
		
		JLabel email1 = new JLabel();
		panelEmail1.add(email1);
		email1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEmail2 = new JPanel();
		panelEmail.add(panelEmail2);
		panelEmail2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail2 = new JLabel("Email 2");
		panelEmail2.add(labelEmail2);
		labelEmail2.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel email2 = new JLabel();
		panelEmail2.add(email2);
		email2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		
		JLabel escolaridade = new JLabel();
		escolaridade.setHorizontalAlignment(SwingConstants.LEFT);
		escolaridade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEscolaridade.add(escolaridade);
		
		JPanel panelNacionalidade = new JPanel();
		panelEs_Na_Pa.add(panelNacionalidade);
		panelNacionalidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNacionalidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNacionalidade = new JLabel("Nacionalidade");
		labelNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNacionalidade.add(labelNacionalidade);
		
		JLabel nacionalidade = new JLabel();
		nacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		nacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNacionalidade.add(nacionalidade);
		
		JPanel panelPaisOrigem = new JPanel();
		panelEs_Na_Pa.add(panelPaisOrigem);
		panelPaisOrigem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPaisOrigem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPaisOrigem = new JLabel("Pais de origem");
		labelPaisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		labelPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(labelPaisOrigem);
		
		JLabel paisOrigem = new JLabel();
		paisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		paisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(paisOrigem);
		
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
		
		JLabel nomeMae = new JLabel();
		nomeMae.setHorizontalAlignment(SwingConstants.LEFT);
		nomeMae.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeMae.add(nomeMae);
		
		JPanel panelNomePai = new JPanel();
		panelNomeMae_NomePai.add(panelNomePai);
		panelNomePai.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomePai.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomePai = new JLabel("Nome do Pai");
		labelNomePai.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomePai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomePai.add(labelNomePai);
		
		JLabel nomePai = new JLabel();
		nomePai.setHorizontalAlignment(SwingConstants.LEFT);
		nomePai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomePai.add(nomePai);
		
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
		
		JLabel login = new JLabel();
		login.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelLogin.add(login);
		
		JPanel panelSenha = new JPanel();
		panelLogin_Senha_Cargo.add(panelSenha);
		panelSenha.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelSenha.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSenha = new JLabel("Senha");
		panelSenha.add(labelSenha);
		labelSenha.setHorizontalAlignment(SwingConstants.LEFT);
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel senha = new JLabel();
		panelSenha.add(senha);
		senha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCargo = new JPanel();
		panelLogin_Senha_Cargo.add(panelCargo);
		panelCargo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargo = new JLabel("Cargo");
		panelCargo.add(labelCargo);
		labelCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cargo = new JLabel();
		panelCargo.add(cargo);
		cargo.setHorizontalAlignment(SwingConstants.LEFT);
		cargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		
		JLabel carteiraTrabalho = new JLabel();
		panelCarteiraTrabalho.add(carteiraTrabalho);
		carteiraTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelSalario = new JPanel();
		panelCartTrab_Sal_ForPag_NomeBanco.add(panelSalario);
		panelSalario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelSalario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSalario = new JLabel("Salario (R$)");
		panelSalario.add(labelSalario);
		labelSalario.setHorizontalAlignment(SwingConstants.LEFT);
		labelSalario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel salario = new JLabel();
		panelSalario.add(salario);
		salario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelFormaPagamento = new JPanel();
		panelCartTrab_Sal_ForPag_NomeBanco.add(panelFormaPagamento);
		panelFormaPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFormaPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFormaPagamento = new JLabel("Forma de pagamento");
		labelFormaPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		labelFormaPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFormaPagamento.add(labelFormaPagamento);
		
		JLabel formaPagamento = new JLabel();
		formaPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		formaPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFormaPagamento.add(formaPagamento);
		
		JPanel panelNomeBanco = new JPanel();
		panelCartTrab_Sal_ForPag_NomeBanco.add(panelNomeBanco);
		panelNomeBanco.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeBanco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeBanco = new JLabel("Nome do banco");
		labelNomeBanco.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeBanco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeBanco.add(labelNomeBanco);
		
		JLabel nomeBanco = new JLabel();
		nomeBanco.setHorizontalAlignment(SwingConstants.LEFT);
		nomeBanco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeBanco.add(nomeBanco);
		
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
		
		JLabel tipoTrabalho = new JLabel();
		tipoTrabalho.setHorizontalAlignment(SwingConstants.LEFT);
		tipoTrabalho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoTrabalho.add(tipoTrabalho);
		
		JPanel panelDataAdmissao = new JPanel();
		panelTipoTrabalho_Data.add(panelDataAdmissao);
		panelDataAdmissao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataAdmissao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataAdmissao = new JLabel("Data de admiss\u00E3o");
		labelDataAdmissao.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataAdmissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataAdmissao.add(labelDataAdmissao);
		
		JLabel dataAdmissao = new JLabel();
		dataAdmissao.setHorizontalAlignment(SwingConstants.LEFT);
		dataAdmissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataAdmissao.add(dataAdmissao);
		
		JPanel panelDataDemissao = new JPanel();
		panelTipoTrabalho_Data.add(panelDataDemissao);
		panelDataDemissao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataDemissao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataDemissao = new JLabel("Data de demiss\u00E3o");
		labelDataDemissao.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataDemissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataDemissao.add(labelDataDemissao);
		
		JLabel dataDemissao = new JLabel();
		dataDemissao.setHorizontalAlignment(SwingConstants.LEFT);
		dataDemissao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataDemissao.add(dataDemissao);
		
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
		
		JLabel horaInicio = new JLabel();
		horaInicio.setHorizontalAlignment(SwingConstants.LEFT);
		horaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelHoraEntrada.add(horaInicio);
		
		JPanel panelHoraSaida = new JPanel();
		panelHorarioLimiteFaltas.add(panelHoraSaida);
		panelHoraSaida.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHoraSaida.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraSaida = new JLabel("Hora de saida");
		labelHoraSaida.setHorizontalAlignment(SwingConstants.LEFT);
		labelHoraSaida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelHoraSaida.add(labelHoraSaida);
		
		JLabel horaSaida = new JLabel();
		horaSaida.setHorizontalAlignment(SwingConstants.LEFT);
		horaSaida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelHoraSaida.add(horaSaida);
		
		JPanel PanelCargaHoraria = new JPanel();
		panelHorarioLimiteFaltas.add(PanelCargaHoraria);
		PanelCargaHoraria.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		PanelCargaHoraria.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargaHoraria = new JLabel("Carga horaria por dia");
		labelCargaHoraria.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PanelCargaHoraria.add(labelCargaHoraria);
		
		JLabel cargaHoraria = new JLabel();
		cargaHoraria.setHorizontalAlignment(SwingConstants.LEFT);
		cargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PanelCargaHoraria.add(cargaHoraria);
		
		JPanel panelLimiteFaltas = new JPanel();
		panelLimiteFaltas.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHorarioLimiteFaltas.add(panelLimiteFaltas);
		panelLimiteFaltas.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelLimiteFaltas = new JLabel("Limite de faltas");
		labelLimiteFaltas.setHorizontalAlignment(SwingConstants.LEFT);
		labelLimiteFaltas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelLimiteFaltas.add(labelLimiteFaltas);
		
		JLabel limiteFaltas = new JLabel();
		limiteFaltas.setHorizontalAlignment(SwingConstants.LEFT);
		limiteFaltas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelLimiteFaltas.add(limiteFaltas);
		
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
		
		JLabel estado = new JLabel();
		panelEstado.add(estado);
		estado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCEP = new JPanel();
		panelEstado_CEP_Cidade.add(panelCEP);
		panelCEP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCEP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCEP = new JLabel("CEP");
		panelCEP.add(labelCEP);
		labelCEP.setHorizontalAlignment(SwingConstants.LEFT);
		labelCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cep = new JLabel();
		panelCEP.add(cep);
		cep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCidade = new JPanel();
		panelEstado_CEP_Cidade.add(panelCidade);
		panelCidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCidade = new JLabel("Cidade");
		panelCidade.add(labelCidade);
		labelCidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cidade = new JLabel();
		panelCidade.add(cidade);
		cidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		
		JLabel endereco = new JLabel();
		endereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEndereco.add(endereco);
		
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
		
		JLabel numero = new JLabel();
		panelNumero.add(numero);
		numero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelComplemento = new JPanel();
		panelNume_Comp_Bairro.add(panelComplemento);
		panelComplemento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComplemento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComplemento = new JLabel("Complemento");
		labelComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelComplemento.add(labelComplemento);
		
		JLabel complemento = new JLabel();
		complemento.setHorizontalAlignment(SwingConstants.LEFT);
		complemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelComplemento.add(complemento);
		
		JPanel panelBairro = new JPanel();
		panelNume_Comp_Bairro.add(panelBairro);
		panelBairro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelBairro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairro = new JLabel("Bairro");
		panelBairro.add(labelBairro);
		labelBairro.setHorizontalAlignment(SwingConstants.LEFT);
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel bairro = new JLabel();
		panelBairro.add(bairro);
		bairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelReferencia = new JPanel();
		panelFichaParteA5.add(panelReferencia);
		panelReferencia.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelReferencia.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelReferencia = new JLabel("Referencia");
		labelReferencia.setHorizontalAlignment(SwingConstants.LEFT);
		labelReferencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelReferencia.add(labelReferencia);
		
		JLabel referencia = new JLabel();
		referencia.setHorizontalAlignment(SwingConstants.LEFT);
		referencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelReferencia.add(referencia);
		
		/*Parte que consulta os dados no banco de dados*/
		String codigoFuncionarioConsulta = sessao.getCodigoFuncionario();
		String nomeFuncionarioConsulta = sessao.getNomeFuncionario();
		String cargoFuncionarioConsulta = sessao.getCargoFuncionario();
		Dao_consulta_dados_funcionario teste = new Dao_consulta_dados_funcionario();
    	List<Funcionario> Consulta = teste.Consulta_Dados_Funcionario_Ficha(codigoFuncionarioConsulta, nomeFuncionarioConsulta, cargoFuncionarioConsulta);
    	for (Funcionario leitura : Consulta) {
    		String nomeFuncionarioTexto = leitura.getNome();
    		nome.setText(nomeFuncionarioTexto);
    		
    		String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
    		codigoFuncionario.setText(codigoFuncionarioTexto);
    		
    		String cargoFuncionarioTexto = leitura.getCargo();
    		cargo.setText(cargoFuncionarioTexto);
    		
    		String rgFuncionarioTexto = leitura.getRG();
    		rg.setText(rgFuncionarioTexto);
    		
    		String cpfFuncionarioTexto = leitura.getCPF();
    		cpf.setText(cpfFuncionarioTexto);
    		
    		Date dataNascimentoFuncionario = leitura.getDataNascimento();
    		SimpleDateFormat dataNascimentoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataNacimentoValor = dataNascimentoFormato.format(dataNascimentoFuncionario);
    		dataNascimento.setText(dataNacimentoValor);
    		
    		String sexoFuncionarioTexto = leitura.getSexo();
    		sexo.setText(sexoFuncionarioTexto);
    		
    		String estadoCivilFuncionario = leitura.getEstadoCivil();
    		estadoCivil.setText(estadoCivilFuncionario);
    		
    		String telefone1Funcionario = leitura.getTelefone1();
    		telefone1.setText(telefone1Funcionario);
    		
    		String telefone2Funcionario = leitura.getTelefone2();
    		telefone2.setText(telefone2Funcionario);
    		
    		String celular1Funcionario = leitura.getCelular1();
    		celular1.setText(celular1Funcionario);
    		
    		String celular2Funcionario = leitura.getCelular2();
    		celular2.setText(celular2Funcionario);
    		
    		String email1Funcionario = leitura.getEmail1();
    		email1.setText(email1Funcionario);
    		
    		String email2Funcionario = leitura.getEmail2();
    		email2.setText(email2Funcionario);
    		
    		String escolaridadeFuncionario = leitura.getEscolaridade();
    		escolaridade.setText(escolaridadeFuncionario);
    		
    		String nacionalidadeFuncionario = leitura.getNacionalidade();
    		nacionalidade.setText(nacionalidadeFuncionario);
    		
    		String paisOrigemFuncionario = leitura.getPaisOrigem();
    		paisOrigem.setText(paisOrigemFuncionario);
    		
    		String nomeMaeFuncionario = leitura.getNomeMae();
    		nomeMae.setText(nomeMaeFuncionario);
    		
    		String nomePaiFuncionario = leitura.getNomePai();
    		nomePai.setText(nomePaiFuncionario);
    		
    		String loginFuncionario = leitura.getLogin();
    		login.setText(loginFuncionario);
    		
    		String senhaFuncionario = leitura.getSenha();
    		senha.setText(senhaFuncionario);
    		
    		String carteiraTrabalhoFuncionario = leitura.getCarteiraTrabalho();
    		carteiraTrabalho.setText(carteiraTrabalhoFuncionario);
    		
    		String salarioFuncionario = "" + leitura.getSalario();
    		salario.setText(salarioFuncionario);
    		
    		String formaPagamentoFuncionario = leitura.getFormaPagamento();
    		formaPagamento.setText(formaPagamentoFuncionario);
    		
    		String nomeBancoFuncionario = leitura.getNomeBanco();
    		nomeBanco.setText(nomeBancoFuncionario);
    		
    		String tipoTrabalhoFuncionario = leitura.getTipoTrabalho();
    		tipoTrabalho.setText(tipoTrabalhoFuncionario);
    		
    		Date dataAdmissaoFuncionario =	leitura.getDataAdmissao();
    		SimpleDateFormat dataAdmissaoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataAdmissaoValor = dataAdmissaoFormato.format(dataAdmissaoFuncionario);
    		dataAdmissao.setText(dataAdmissaoValor);
    		
    		Date dataDemissaoFuncionario =	leitura.getDataDemissao();
    		if (dataDemissaoFuncionario == null) {
    			String dataDemissaoValorTexto = "Sem registro";
    			dataDemissao.setText(dataDemissaoValorTexto);
			}
    		else {
				SimpleDateFormat dataDemissaoFormato = new SimpleDateFormat("dd/MM/yyyy");
	    		String dataDemissaoValor = dataDemissaoFormato.format(dataDemissaoFuncionario);
	    		dataDemissao.setText(dataDemissaoValor);
			}
    		
    		Time horaInicioFuncionario = leitura.getHoraEntrada();
    		SimpleDateFormat horaInicioFormato = new SimpleDateFormat("HH:mm");
    		String horaInicioValor = horaInicioFormato.format(horaInicioFuncionario);
    		horaInicio.setText(horaInicioValor);
    		
    		Time horaSaidaFuncionario = leitura.getHoraSaida();
    		SimpleDateFormat horaSaidaFormato = new SimpleDateFormat("HH:mm");
    		String horaSaidaValor = horaSaidaFormato.format(horaSaidaFuncionario);
    		horaSaida.setText(horaSaidaValor);
    		
    		Date dataCadastroCliente =	leitura.getDataCadastro();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroCliente);
    		Time horaCadastroCliente = leitura.getHoraCadastro();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroCliente);
    		String DataHoraCadastroiTexto = dataCadastroValor + " " + horaCadastroValor;
    		dataHoraFuncionario.setText(DataHoraCadastroiTexto);
    		
    		String cargaHorariaValor = leitura.getCargaHoraria();
    		String cargaHorariaUnidade = leitura.getCargaHorariaUnidade();
    		String cargaHorariaTexto = cargaHorariaValor + " " + cargaHorariaUnidade;
    		cargaHoraria.setText(cargaHorariaTexto);
    		
    		int limiteFaltasValor  = leitura.getLimiteFaltas();
    		String limiteFaltasTexto = "" + limiteFaltasValor;
    		limiteFaltas.setText(limiteFaltasTexto);
    		
    		String estadoFuncionario = leitura.getEstado();
    		estado.setText(estadoFuncionario);
    		
    		String cepFuncionario = leitura.getCEP();
    		cep.setText(cepFuncionario);
    		
    		String cidadeFuncionario = leitura.getCidade();
    		cidade.setText(cidadeFuncionario);
    		
    		String enderecoFuncionario = leitura.getEndereco();
    		endereco.setText(enderecoFuncionario);
    		
    		String numeroFuncionario = leitura.getNumero();
    		numero.setText(numeroFuncionario);
    		
    		String complementoFuncionario = leitura.getComplemento();
    		complemento.setText(complementoFuncionario);
    		
    		String bairroFuncionario = leitura.getBairro();
    		bairro.setText(bairroFuncionario);
    		
    		String referenciaFuncionario = leitura.getReferencia();
    		referencia.setText(referenciaFuncionario);
		}
		
		/*Parte dos botoes*/
		JPanel panelBotoes = new JPanel();
		telaFichaFuncionario.add(panelBotoes, BorderLayout.SOUTH);
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