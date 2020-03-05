package moduloAjuda;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import aInterfaceSistema.Sessao;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Ajuda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel TelaAjuda;
	private JButton voltar;
	Sessao sessao = Sessao.getInstance();
	AjudaTexto exibeAjudaTexto = new AjudaTexto();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajuda frame = new Ajuda();
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
	public Ajuda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ajuda.class.getResource("/cImagens/Logo Janela.PNG")));
		/*Criação da javela*/
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(true);
		setSize(1000, 600);
		
		TelaAjuda = new JPanel();
		TelaAjuda.setBorder(new EmptyBorder(5, 5, 5, 5));
		TelaAjuda.setLayout(new BorderLayout(5, 5));
		setContentPane(TelaAjuda);
		
		/*Panel do titulo*/
		JPanel panelTitulo = new JPanel();
		TelaAjuda.add(panelTitulo, BorderLayout.NORTH);
		
		/*Icone da janela*/
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Ajuda.class.getResource("/cImagens/Ajuda.png")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		/*Titulo da janela*/
		JLabel labelTituloAjuda = new JLabel("Ajuda");
		panelTitulo2.add(labelTituloAjuda);
		labelTituloAjuda.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Ajuda.class.getResource("/cImagens/Funcionario.png")));
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
		
		JPanel panelAjuda = new JPanel();
		TelaAjuda.add(panelAjuda, BorderLayout.CENTER);
		panelAjuda.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAjudaConteudo = new JPanel();
		panelAjuda.add(panelAjudaConteudo, BorderLayout.CENTER);
		panelAjudaConteudo.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPaneAjuda = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPaneAjuda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPaneAjuda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAjudaConteudo.add(tabbedPaneAjuda);
		
		/*Aba Como navegar no software*/
		JPanel panelNavegarSoftware = new JPanel();
		tabbedPaneAjuda.addTab("Como navegar no software", null, panelNavegarSoftware, null);
		panelNavegarSoftware.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneNavegarSoftware = new JScrollPane();
		panelNavegarSoftware.add(scrollPaneNavegarSoftware);
		
		JTextPane textoNavegarSoftware = new JTextPane();
		textoNavegarSoftware.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoNavegarSoftware.setBackground(new Color(245, 245, 245));
		String navegarSoftwareTexto = exibeAjudaTexto.getTextoNavegarAplicacao();
		textoNavegarSoftware.setText(navegarSoftwareTexto);
		scrollPaneNavegarSoftware.setViewportView(textoNavegarSoftware);
		textoNavegarSoftware.setEditable(false);
		
		/*Aba Modulo Administrativo*/
		JPanel panelModuloAdministrativo = new JPanel();
		tabbedPaneAjuda.addTab("Modulo Administrativo", null, panelModuloAdministrativo, null);
		panelModuloAdministrativo.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneModuloAdministrativo = new JScrollPane();
		panelModuloAdministrativo.add(scrollPaneModuloAdministrativo);
		
		JTextPane textoModuloAdministrativo = new JTextPane();
		textoModuloAdministrativo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoModuloAdministrativo.setBackground(new Color(245, 245, 245));
		String moduloAdministrativoTexto = exibeAjudaTexto.getTextoModuloAdministrativo();
		textoModuloAdministrativo.setText(moduloAdministrativoTexto);
		scrollPaneModuloAdministrativo.setViewportView(textoModuloAdministrativo);
		textoModuloAdministrativo.setEditable(false);
		
		/*Aba Modulo Finaceiro*/
		JPanel panelModuloFinaceiro = new JPanel();
		tabbedPaneAjuda.addTab("Modulo Finaceiro", null, panelModuloFinaceiro, null);
		panelModuloFinaceiro.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneModuloFinaceiro = new JScrollPane();
		panelModuloFinaceiro.add(scrollPaneModuloFinaceiro);
		
		JTextPane textoModuloFinaceiro = new JTextPane();
		textoModuloFinaceiro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoModuloFinaceiro.setBackground(new Color(245, 245, 245));
		String moduloFinaceiroTexto = exibeAjudaTexto.getTextoModuloFinanceiro();
		textoModuloFinaceiro.setText(moduloFinaceiroTexto);
		scrollPaneModuloFinaceiro.setViewportView(textoModuloFinaceiro);
		textoModuloFinaceiro.setEditable(false);
		
		/*Aba Modulo Funcionario*/
		JPanel panelModuloFuncionario = new JPanel();
		tabbedPaneAjuda.addTab("Modulo Funcionario", null, panelModuloFuncionario, null);
		panelModuloFuncionario.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneModuloFuncionario = new JScrollPane();
		panelModuloFuncionario.add(scrollPaneModuloFuncionario);
		
		JTextPane textoModuloFuncionario = new JTextPane();
		textoModuloFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoModuloFuncionario.setBackground(new Color(245, 245, 245));
		String moduloFuncionarioTexto = exibeAjudaTexto.getTextoModuloFuncionario();
		textoModuloFuncionario.setText(moduloFuncionarioTexto);
		scrollPaneModuloFuncionario.setViewportView(textoModuloFuncionario);
		textoModuloFuncionario.setEditable(false);
		
		/*Aba Modulo Fornecedor*/
		JPanel panelModuloFornecedor = new JPanel();
		tabbedPaneAjuda.addTab("Modulo Fornecedor", null, panelModuloFornecedor, null);
		panelModuloFornecedor.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneModuloFornecedor = new JScrollPane();
		panelModuloFornecedor.add(scrollPaneModuloFornecedor);
		
		JTextPane textoModuloFornecedor = new JTextPane();
		scrollPaneModuloFornecedor.setViewportView(textoModuloFornecedor);
		String moduloFornecedorTexto = exibeAjudaTexto.getTextoModuloFornecedor();
		textoModuloFornecedor.setText(moduloFornecedorTexto);
		textoModuloFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoModuloFornecedor.setEditable(false);
		textoModuloFornecedor.setBackground(new Color(245, 245, 245));
		
		/*Aba Modulo Cliente*/
		JPanel panelModuloCliente = new JPanel();
		tabbedPaneAjuda.addTab("Modulo Cliente", null, panelModuloCliente, null);
		panelModuloCliente.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneModuloCliente = new JScrollPane();
		panelModuloCliente.add(scrollPaneModuloCliente);
		
		JTextPane textoModuloCliente = new JTextPane();
		textoModuloCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoModuloCliente.setBackground(new Color(245, 245, 245));
		String moduloClienteTexto = exibeAjudaTexto.getTextoModuloCliente();
		textoModuloCliente.setText(moduloClienteTexto);
		scrollPaneModuloCliente.setViewportView(textoModuloCliente);
		textoModuloCliente.setEditable(false);
		
		/*Aba Modulo Produtos*/
		JPanel panelModuloProdutos = new JPanel();
		tabbedPaneAjuda.addTab("Modulo Produtos", null, panelModuloProdutos, null);
		panelModuloProdutos.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneModuloProdutos = new JScrollPane();
		panelModuloProdutos.add(scrollPaneModuloProdutos);
		
		JTextPane textoModuloProdutos = new JTextPane();
		textoModuloProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoModuloProdutos.setBackground(new Color(245, 245, 245));
		String moduloProdutosTexto = exibeAjudaTexto.getTextoModuloProduto();
		textoModuloProdutos.setText(moduloProdutosTexto);
		scrollPaneModuloProdutos.setViewportView(textoModuloProdutos);
		textoModuloProdutos.setEditable(false);
		
		/*Aba Modulo Transporte*/
		JPanel panelModuloTransporte = new JPanel();
		tabbedPaneAjuda.addTab("Modulo Transporte", null, panelModuloTransporte, null);
		panelModuloTransporte.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneModuloTransporte = new JScrollPane();
		panelModuloTransporte.add(scrollPaneModuloTransporte);
		
		JTextPane textoModuloTransporte = new JTextPane();
		scrollPaneModuloTransporte.setViewportView(textoModuloTransporte);
		textoModuloTransporte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		String moduloTransporteTexto = exibeAjudaTexto.getTextoModuloTransporte();
		textoModuloTransporte.setText(moduloTransporteTexto);
		textoModuloTransporte.setEditable(false);
		textoModuloTransporte.setBackground(new Color(245, 245, 245));
		
		/*Aba Sobre o software*/
		JPanel panelSobreSoftware = new JPanel();
		tabbedPaneAjuda.addTab("Sobre o software", null, panelSobreSoftware, null);
		panelSobreSoftware.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneSobreSoftware = new JScrollPane();
		panelSobreSoftware.add(scrollPaneSobreSoftware);
		
		JTextPane textoSobreSoftware = new JTextPane();
		textoSobreSoftware.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoSobreSoftware.setBackground(new Color(245, 245, 245));
		String sobreSoftwareTexto = exibeAjudaTexto.getTextoSobreAplicacao();
		textoSobreSoftware.setText(sobreSoftwareTexto);
		scrollPaneSobreSoftware.setViewportView(textoSobreSoftware);
		textoSobreSoftware.setEditable(false);
		
		/*Parte dos botoes*/
		JPanel panelBotoes = new JPanel();
		TelaAjuda.add(panelBotoes, BorderLayout.SOUTH);
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
	            dispose();
			}
		});
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(voltar);
	}
}