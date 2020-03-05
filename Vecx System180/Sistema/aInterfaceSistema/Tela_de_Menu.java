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
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloAdministrativo.Dados_da_Loja_Menu;
import moduloAdministrativo.Dao_consulta_dados_loja;
import moduloAdministrativoAcessoLogTelas.Controle_de_Acesso;
import moduloAjuda.Ajuda;
import moduloClienteTelas.Cadastro_de_Cliente;
import moduloClienteTelas.Clientes;
import moduloFinanceiroCompraTelas.Compras;
import moduloFinanceiroCompraTelas.Historico_de_Compras;
import moduloFinanceiroVendaTelas.Historico_de_Vendas;
import moduloFinanceiroVendaTelas.Vendas;
import moduloFornecedorTelas.Cadastro_de_Empresa;
import moduloFornecedorTelas.Fornecedores;
import moduloFuncionarioTelas.Cadastro_de_Funcionario;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloFuncionarioTelas.Funcionarios;
import moduloProdutoDescontoPromocaoTelas.Descontos_e_Promocoes;
import moduloProdutoTelas.Cadastro_de_Produto;
import moduloProdutoTelas.Estoque;
import moduloTransporteTelas.Cadastro_de_TransporteCargas;
import moduloTransporteTelas.Controle_de_Cargas;

public class Tela_de_Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaMenu;
	private JButton venda, compra, historicoVendas, historicoCompras, cadastroFuncionario, funcionarios;
	private JButton cadastroFornecedor, fornecedores, cadastroProduto, estoque, descontosPromocoes;
	private JButton cadastroCliente, clientes, cadastroTransporte, controleCargas, configuracoes;
	private JButton controleAcesso, ajuda;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_Menu frame = new Tela_de_Menu();
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
	public Tela_de_Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_de_Menu.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 500);	
		setLocationRelativeTo(null);
		setSize(600, 500);
		
		telaMenu = new JPanel();
		telaMenu.setBorder(new EmptyBorder(10, 10, 10, 10));
		telaMenu.setLayout(new BorderLayout(5, 5));
		setContentPane(telaMenu);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new EmptyBorder(0, 0, 0, 0));
		telaMenu.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelMenuTitulo = new JPanel();
		FlowLayout fl_panelMenuTitulo = (FlowLayout) panelMenuTitulo.getLayout();
		fl_panelMenuTitulo.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelMenuTitulo);
		
		JLabel iconeMenu = new JLabel();
		panelMenuTitulo.add(iconeMenu);
		iconeMenu.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Menu.png")));
		iconeMenu.setPreferredSize(new Dimension(30, 30));
		iconeMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeMenu.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel labelMenu = new JLabel("Menu");
		panelMenuTitulo.add(labelMenu);
		labelMenu.setHorizontalAlignment(SwingConstants.CENTER);
		labelMenu.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		String nomeUsuario = sessao.getNome();
		String cargoUsuario = sessao.getCargo();
		String codigoUsuario = sessao.getCodigo();
		
		JPanel menuBotoesJanela = new JPanel();
		panelTitulo.add(menuBotoesJanela, BorderLayout.CENTER);
		menuBotoesJanela.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JPanel menuBotoesJanela1 = new JPanel();
		menuBotoesJanela1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		menuBotoesJanela.add(menuBotoesJanela1);
		
		JButton menuSairJanela = new JButton("Sair");
		menuSairJanela.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuSairJanela.setToolTipText("Volta para a tela de login");
		menuSairJanela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemTitulo = "Menssagem do sistema";
				String mensagemConteudo = "Deseja voltar a tela de Login?";
				Tela_que_Exibe_Menssagem_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Sim_Nao(menssagemTitulo, mensagemConteudo);
				aviso.setVisible(true);
				String resposta = aviso.getResposta();
				if (resposta != null) {
					if (resposta.equals("Sim")) {
						Tela_de_Login abrirTelaLogin = new Tela_de_Login();
						abrirTelaLogin.setVisible(true); 
			            dispose();
					}
				}
			}
		});
		menuBotoesJanela1.setLayout(new BorderLayout(10, 0));
		menuBotoesJanela1.add(menuSairJanela, BorderLayout.EAST);
		
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
		fichaUsuario.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Funcionario.png")));
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
		
		JPanel panelModulos = new JPanel();
		telaMenu.add(panelModulos, BorderLayout.CENTER);
		panelModulos.setLayout(new BoxLayout(panelModulos, BoxLayout.X_AXIS));
		
		JScrollPane scrollPaneModulos = new JScrollPane();
		panelModulos.add(scrollPaneModulos);
		scrollPaneModulos.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneModulos.getHorizontalScrollBar().setUnitIncrement(10);
		
		JPanel panelBotoes = new JPanel();
		scrollPaneModulos.setViewportView(panelBotoes);
		panelBotoes.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelModuloFinanceiro = new JPanel();
		panelModuloFinanceiro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modulo Financeiro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBotoes.add(panelModuloFinanceiro);
		panelModuloFinanceiro.setLayout(new GridLayout(2, 2, 5, 5));
		
		JPanel panelVenda = new JPanel();
		panelModuloFinanceiro.add(panelVenda);
		panelVenda.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeVenda = new JLabel();
		panelVenda.add(iconeVenda, BorderLayout.WEST);
		iconeVenda.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Venda.png")));
		iconeVenda.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeVenda.setPreferredSize(new Dimension(60, 30));
		iconeVenda.setHorizontalAlignment(SwingConstants.CENTER);
		
		venda = new JButton("Venda");
		panelVenda.add(venda);
		venda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		venda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vendas abrirVendas = new Vendas();
				abrirVendas.setVisible(true);
			}
		});
		venda.setToolTipText("Abre a tela de venda");
		
		JPanel panelCompra = new JPanel();
		panelModuloFinanceiro.add(panelCompra);
		panelCompra.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeCompra = new JLabel();
		panelCompra.add(iconeCompra, BorderLayout.WEST);
		iconeCompra.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Reposi\u00E7\u00E3o estoque.PNG")));
		iconeCompra.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeCompra.setPreferredSize(new Dimension(60, 30));
		iconeCompra.setHorizontalAlignment(SwingConstants.CENTER);
		
		compra = new JButton("Compra");
		panelCompra.add(compra);
		compra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		compra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compras abrirCompras = new Compras();
				abrirCompras.setVisible(true);
			}
		});
		compra.setToolTipText("Abre a tela de reposi\u00E7\u00E3o de estoque");
		
		JPanel panelHistoricoVendas = new JPanel();
		panelModuloFinanceiro.add(panelHistoricoVendas);
		panelHistoricoVendas.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeHistoricoVendas = new JLabel();
		panelHistoricoVendas.add(iconeHistoricoVendas, BorderLayout.WEST);
		iconeHistoricoVendas.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Historico vendas.png")));
		iconeHistoricoVendas.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeHistoricoVendas.setPreferredSize(new Dimension(60, 30));
		iconeHistoricoVendas.setHorizontalAlignment(SwingConstants.CENTER);
		
		historicoVendas = new JButton("Historico de vendas");
		panelHistoricoVendas.add(historicoVendas);
		historicoVendas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		historicoVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historico_de_Vendas abrirHistoricoVendas = new Historico_de_Vendas();
				abrirHistoricoVendas.setVisible(true);
			}
		});
		historicoVendas.setToolTipText("Abre a tela do historico de vendas ");
		
		JPanel panelHistoricoCompras = new JPanel();
		panelModuloFinanceiro.add(panelHistoricoCompras);
		panelHistoricoCompras.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeHistoricoCompras = new JLabel();
		panelHistoricoCompras.add(iconeHistoricoCompras, BorderLayout.WEST);
		iconeHistoricoCompras.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Historico compras.png")));
		iconeHistoricoCompras.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeHistoricoCompras.setPreferredSize(new Dimension(60, 30));
		iconeHistoricoCompras.setHorizontalAlignment(SwingConstants.CENTER);
		
		historicoCompras = new JButton("Historico de compras");
		panelHistoricoCompras.add(historicoCompras);
		historicoCompras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		historicoCompras.setToolTipText("Abre a tela do historico da reposi\u00E7\u00E3o de estoque");
		historicoCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Historico_de_Compras abrirHistoricoCompras = new Historico_de_Compras();
				abrirHistoricoCompras.setVisible(true);
			}
		});
		
		JPanel panelFuncionarios_Fornecedores = new JPanel();
		panelBotoes.add(panelFuncionarios_Fornecedores);
		panelFuncionarios_Fornecedores.setLayout(new GridLayout(1, 2, 5, 0));
		
		JPanel panelModuloFuncionarios = new JPanel();
		panelFuncionarios_Fornecedores.add(panelModuloFuncionarios);
		panelModuloFuncionarios.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modulo Funcionarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelModuloFuncionarios.setLayout(new GridLayout(2, 1, 0, 5));
		
		JPanel panelCadastroFuncionario = new JPanel();
		panelModuloFuncionarios.add(panelCadastroFuncionario);
		panelCadastroFuncionario.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeCadastroFuncionario = new JLabel();
		panelCadastroFuncionario.add(iconeCadastroFuncionario, BorderLayout.WEST);
		iconeCadastroFuncionario.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Cadastro funcionario.png")));
		iconeCadastroFuncionario.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeCadastroFuncionario.setPreferredSize(new Dimension(60, 30));
		iconeCadastroFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		
		cadastroFuncionario = new JButton("Cadastro de funcionario");
		panelCadastroFuncionario.add(cadastroFuncionario);
		cadastroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cadastroFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_de_Funcionario abrirCadastroFuncionario = new Cadastro_de_Funcionario();
				abrirCadastroFuncionario.setVisible(true);
			}
		});
		cadastroFuncionario.setToolTipText("Abre a tela de cadastro de funcionario");
		
		JPanel panelFuncionarios = new JPanel();
		panelModuloFuncionarios.add(panelFuncionarios);
		panelFuncionarios.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeFuncionarios = new JLabel();
		panelFuncionarios.add(iconeFuncionarios, BorderLayout.WEST);
		iconeFuncionarios.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Funcionarios.png")));
		iconeFuncionarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeFuncionarios.setPreferredSize(new Dimension(60, 30));
		iconeFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		
		funcionarios = new JButton("Funcionarios");
		panelFuncionarios.add(funcionarios);
		funcionarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		funcionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionarios abrirFuncionarios = new Funcionarios();
				abrirFuncionarios.setVisible(true);
			}
		});
		funcionarios.setToolTipText("Abre a tela de funcionarios");
		
		JPanel panelModuloFornecedor = new JPanel();
		panelFuncionarios_Fornecedores.add(panelModuloFornecedor);
		panelModuloFornecedor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modulo Fornecedores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelModuloFornecedor.setLayout(new GridLayout(2, 1, 0, 5));
		
		JPanel panelCadastroFornecedor = new JPanel();
		panelModuloFornecedor.add(panelCadastroFornecedor);
		panelCadastroFornecedor.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeCadastroFornecedor = new JLabel();
		panelCadastroFornecedor.add(iconeCadastroFornecedor, BorderLayout.WEST);
		iconeCadastroFornecedor.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Cadastro dos fornecedores.PNG")));
		iconeCadastroFornecedor.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeCadastroFornecedor.setPreferredSize(new Dimension(60, 30));
		iconeCadastroFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
		
		cadastroFornecedor = new JButton("Cadastro de fornecedor");
		panelCadastroFornecedor.add(cadastroFornecedor);
		cadastroFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cadastroFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_de_Empresa abirCadastroEmpresa = new Cadastro_de_Empresa();
				abirCadastroEmpresa.setVisible(true);
			}
		});
		cadastroFornecedor.setToolTipText("Abre a tela de cadastro de fornecedor");
		
		JPanel panelFornecedores = new JPanel();
		panelModuloFornecedor.add(panelFornecedores);
		panelFornecedores.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeFornecedores = new JLabel();
		panelFornecedores.add(iconeFornecedores, BorderLayout.WEST);
		iconeFornecedores.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Fornecedores.png")));
		iconeFornecedores.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeFornecedores.setPreferredSize(new Dimension(60, 30));
		iconeFornecedores.setHorizontalAlignment(SwingConstants.CENTER);
		
		fornecedores = new JButton("Fornecedores");
		panelFornecedores.add(fornecedores);
		fornecedores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedores abrirFornecedores = new Fornecedores();
				abrirFornecedores.setVisible(true);
			}
		});
		fornecedores.setToolTipText("Abre a tela de fornecedores");
		
		JPanel panelModuloProdutos = new JPanel();
		panelModuloProdutos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modulo Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBotoes.add(panelModuloProdutos);
		panelModuloProdutos.setLayout(new GridLayout(2, 2, 5, 5));
		
		JPanel panelCadastroProduto = new JPanel();
		panelModuloProdutos.add(panelCadastroProduto);
		panelCadastroProduto.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeCadastroProduto = new JLabel();
		panelCadastroProduto.add(iconeCadastroProduto, BorderLayout.WEST);
		iconeCadastroProduto.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Cadastro produtos.PNG")));
		iconeCadastroProduto.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeCadastroProduto.setPreferredSize(new Dimension(60, 30));
		iconeCadastroProduto.setHorizontalAlignment(SwingConstants.CENTER);
		
		cadastroProduto = new JButton("Cadastro de produto");
		cadastroProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastro_de_Produto abrirCadastroProduto = new Cadastro_de_Produto();
				abrirCadastroProduto.setVisible(true);
			}
		});
		panelCadastroProduto.add(cadastroProduto);
		cadastroProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cadastroProduto.setToolTipText("Abre a tela de cadastro de produto");
		
		JPanel panelEstoque = new JPanel();
		panelModuloProdutos.add(panelEstoque);
		panelEstoque.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeEstoque = new JLabel();
		panelEstoque.add(iconeEstoque, BorderLayout.WEST);
		iconeEstoque.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Estoque.png")));
		iconeEstoque.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeEstoque.setPreferredSize(new Dimension(60, 30));
		iconeEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		
		estoque = new JButton("Estoque");
		panelEstoque.add(estoque);
		estoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		estoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque abrirEstoque = new Estoque();
				abrirEstoque.setVisible(true);
			}
		});
		estoque.setToolTipText("Abre a tela de estoque");
		
		JPanel panelDescontosPromocoes = new JPanel();
		panelModuloProdutos.add(panelDescontosPromocoes);
		panelDescontosPromocoes.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeDescontosPromocoes = new JLabel();
		iconeDescontosPromocoes.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Descontos e promo\u00E7\u00F5es.PNG")));
		panelDescontosPromocoes.add(iconeDescontosPromocoes, BorderLayout.WEST);
		iconeDescontosPromocoes.setPreferredSize(new Dimension(60, 30));
		iconeDescontosPromocoes.setHorizontalAlignment(SwingConstants.CENTER);
		iconeDescontosPromocoes.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		descontosPromocoes = new JButton("Descontos e Promo\u00E7\u00F5es");
		panelDescontosPromocoes.add(descontosPromocoes);
		descontosPromocoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Descontos_e_Promocoes abrirDescontosPromocoes = new Descontos_e_Promocoes();
				abrirDescontosPromocoes.setVisible(true);
			}
		});
		descontosPromocoes.setToolTipText("Abre a tela de descontos e promo\u00E7\u00F5es");
		descontosPromocoes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelClientes_Transporte = new JPanel();
		panelBotoes.add(panelClientes_Transporte);
		panelClientes_Transporte.setLayout(new GridLayout(1, 2, 5, 0));
		
		JPanel panelModuloCliente = new JPanel();
		panelClientes_Transporte.add(panelModuloCliente);
		panelModuloCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modulo Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelModuloCliente.setLayout(new GridLayout(2, 1, 0, 5));
		
		JPanel panelCadastroCliente = new JPanel();
		panelModuloCliente.add(panelCadastroCliente);
		panelCadastroCliente.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeCadastroCliente = new JLabel();
		panelCadastroCliente.add(iconeCadastroCliente, BorderLayout.WEST);
		iconeCadastroCliente.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Cadastro usuario.png")));
		iconeCadastroCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeCadastroCliente.setPreferredSize(new Dimension(60, 30));
		iconeCadastroCliente.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastroCliente.setBounds(100, 100, 100, 100);
		
		cadastroCliente = new JButton("Cadastro de cliente");
		panelCadastroCliente.add(cadastroCliente);
		cadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_de_Cliente abrirCadastroCliente = new Cadastro_de_Cliente();
				abrirCadastroCliente.setVisible(true);
			}
		});
		cadastroCliente.setToolTipText("Abre a tela de cadastro de cliente");
		
		JPanel panelClientes = new JPanel();
		panelModuloCliente.add(panelClientes);
		panelClientes.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeClientes = new JLabel();
		panelClientes.add(iconeClientes, BorderLayout.WEST);
		iconeClientes.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Clientes.png")));
		iconeClientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeClientes.setPreferredSize(new Dimension(60, 30));
		iconeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		
		clientes = new JButton("Clientes");
		panelClientes.add(clientes);
		clientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes abrirClientes = new Clientes();
				abrirClientes.setVisible(true);
			}
		});
		clientes.setToolTipText("Abre a tela de clientes");
		
		JPanel panelModuloTransporte = new JPanel();
		panelClientes_Transporte.add(panelModuloTransporte);
		panelModuloTransporte.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modulo Transporte", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelModuloTransporte.setLayout(new GridLayout(2, 1, 0, 5));
		
		JPanel panelCadastroTransporte = new JPanel();
		panelModuloTransporte.add(panelCadastroTransporte);
		panelCadastroTransporte.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeCadastroTransporte = new JLabel();
		iconeCadastroTransporte.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Cadastro de  transporte.PNG")));
		panelCadastroTransporte.add(iconeCadastroTransporte, BorderLayout.WEST);
		iconeCadastroTransporte.setPreferredSize(new Dimension(60, 30));
		iconeCadastroTransporte.setHorizontalAlignment(SwingConstants.CENTER);
		iconeCadastroTransporte.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		cadastroTransporte = new JButton("Cadastro de transporte");
		panelCadastroTransporte.add(cadastroTransporte);
		cadastroTransporte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cadastroTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastro_de_TransporteCargas abrirCadastroTransporteCargas = new Cadastro_de_TransporteCargas();
				abrirCadastroTransporteCargas.setVisible(true);
			}
		});
		cadastroTransporte.setToolTipText("Abre a tela de cadastro de transporte");
		
		JPanel panelControleCargas = new JPanel();
		panelModuloTransporte.add(panelControleCargas);
		panelControleCargas.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeControleCargas = new JLabel();
		iconeControleCargas.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Cadastro fornecedor.png")));
		panelControleCargas.add(iconeControleCargas, BorderLayout.WEST);
		iconeControleCargas.setPreferredSize(new Dimension(60, 30));
		iconeControleCargas.setHorizontalAlignment(SwingConstants.CENTER);
		iconeControleCargas.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		controleCargas = new JButton("Controle de cargas");
		panelControleCargas.add(controleCargas);
		controleCargas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		controleCargas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controle_de_Cargas abrirControle_de_Cargas = new Controle_de_Cargas();
				abrirControle_de_Cargas.setVisible(true);
			}
		});
		controleCargas.setToolTipText("Abre a tela do controle de cargas");
		
		JPanel panelAdministrativo_Ajuda = new JPanel();
		panelBotoes.add(panelAdministrativo_Ajuda);
		panelAdministrativo_Ajuda.setLayout(new GridLayout(1, 2, 5, 0));
		
		JPanel panelModuloAdministrativo = new JPanel();
		panelAdministrativo_Ajuda.add(panelModuloAdministrativo);
		panelModuloAdministrativo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modulo Administrativo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelModuloAdministrativo.setLayout(new GridLayout(2, 1, 0, 5));
		
		JPanel panelConfiguracoes = new JPanel();
		panelModuloAdministrativo.add(panelConfiguracoes);
		panelConfiguracoes.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeConfiguracoes = new JLabel();
		panelConfiguracoes.add(iconeConfiguracoes, BorderLayout.WEST);
		iconeConfiguracoes.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Configuracoes.png")));
		iconeConfiguracoes.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeConfiguracoes.setPreferredSize(new Dimension(60, 30));
		iconeConfiguracoes.setHorizontalAlignment(SwingConstants.CENTER);
		
		configuracoes = new JButton("Configura\u00E7\u00F5es");
		panelConfiguracoes.add(configuracoes);
		configuracoes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		configuracoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dados_da_Loja_Menu abrirConfiguracoes = new Dados_da_Loja_Menu();
				abrirConfiguracoes.setVisible(true);
			}
		});
		configuracoes.setToolTipText("Abre a tela de configura\u00E7\u00F5es");
		
		JPanel panelControleAcesso = new JPanel();
		panelModuloAdministrativo.add(panelControleAcesso);
		panelControleAcesso.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeControleAcesso = new JLabel();
		iconeControleAcesso.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Historico de acesso.PNG")));
		panelControleAcesso.add(iconeControleAcesso, BorderLayout.WEST);
		iconeControleAcesso.setPreferredSize(new Dimension(60, 30));
		iconeControleAcesso.setHorizontalAlignment(SwingConstants.CENTER);
		iconeControleAcesso.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		controleAcesso = new JButton("Controle de acesso");
		panelControleAcesso.add(controleAcesso);
		controleAcesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		controleAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controle_de_Acesso abrirControleAcesso = new Controle_de_Acesso();
				abrirControleAcesso.setVisible(true);
			}
		});
		controleAcesso.setToolTipText("Abre a tela de cadastro de fornecedor");
		
		JPanel panelModuloAjuda = new JPanel();
		panelAdministrativo_Ajuda.add(panelModuloAjuda);
		panelModuloAjuda.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modulo Ajuda", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelModuloAjuda.setLayout(new GridLayout(2, 1, 0, 5));
		
		JPanel panelAjuda = new JPanel();
		panelModuloAjuda.add(panelAjuda);
		panelAjuda.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeAjuda = new JLabel();
		panelAjuda.add(iconeAjuda, BorderLayout.WEST);
		iconeAjuda.setIcon(new ImageIcon(Tela_de_Menu.class.getResource("/cImagens/Ajuda.png")));
		iconeAjuda.setBorder(new LineBorder(new Color(0, 0, 0)));
		iconeAjuda.setPreferredSize(new Dimension(60, 30));
		iconeAjuda.setHorizontalAlignment(SwingConstants.CENTER);
		
		ajuda = new JButton("Ajuda");
		panelAjuda.add(ajuda);
		ajuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ajuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajuda abrirAjuda = new Ajuda();
				abrirAjuda.setVisible(true);
			}
		});
		ajuda.setToolTipText("Abre a tela de ajuda");
		
		/*Consulta se os dados da loja foram cadastrados*/
		String dadosLojaRegistro = "Ativo";
		boolean consultaDadosLoja;
		consultaDadosLoja = new Dao_consulta_dados_loja().Consulta_Dados_Loja_Cadastro(dadosLojaRegistro);
		if (consultaDadosLoja == false) {
			String menssagemConteudo = "Deseja cadastrar os dados da loja ?";
			Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
			menssagemAviso.setVisible(true);
		}
		
		/*Parte que controla o nivel de acesso de cada cargo*/
		if (cargoUsuario != null) {
			if (cargoUsuario.equals("Atendente")) {
					iconeCadastroFuncionario.setEnabled(false);
					cadastroFuncionario.setEnabled(false);
					iconeFuncionarios.setEnabled(false);
					funcionarios.setEnabled(false);
					panelModuloFuncionarios.setEnabled(false);
					
					iconeConfiguracoes.setEnabled(false);
					configuracoes.setEnabled(false);
					iconeControleAcesso.setEnabled(false);
					controleAcesso.setEnabled(false);
					panelModuloAdministrativo.setEnabled(false);
			}
			else if (cargoUsuario.equals("Carregador")) {
					iconeVenda.setEnabled(false);
					venda.setEnabled(false);
					iconeCompra.setEnabled(false);
					compra.setEnabled(false);
					iconeHistoricoCompras.setEnabled(false);
					historicoCompras.setEnabled(false);
					iconeHistoricoVendas.setEnabled(false);
					historicoVendas.setEnabled(false);
					panelModuloFinanceiro.setEnabled(false);
	
					iconeDescontosPromocoes.setEnabled(false);
					descontosPromocoes.setEnabled(false);
					
					iconeCadastroCliente.setEnabled(false);
					cadastroCliente.setEnabled(false);
					
					iconeCadastroFornecedor.setEnabled(false);
					cadastroFornecedor.setEnabled(false);
					iconeFornecedores.setEnabled(false);
					fornecedores.setEnabled(false);
					panelModuloFornecedor.setEnabled(false);
					
					iconeCadastroFuncionario.setEnabled(false);
					cadastroFuncionario.setEnabled(false);
					iconeFuncionarios.setEnabled(false);
					funcionarios.setEnabled(false);
					panelModuloFuncionarios.setEnabled(false);
					
					iconeConfiguracoes.setEnabled(false);
					configuracoes.setEnabled(false);
					iconeControleAcesso.setEnabled(false);
					controleAcesso.setEnabled(false);
					panelModuloAdministrativo.setEnabled(false);
			}
		}
		
		/*Ação do botao sair da janela*/
		addWindowListener(
            new WindowAdapter() 
            {
                public void windowClosing(WindowEvent we) {
                	String menssagemTitulo = "Menssagem do sistema";
    				String mensagemConteudo = "Deseja voltar a tela de Login?";
    				Tela_que_Exibe_Menssagem_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Sim_Nao(menssagemTitulo, mensagemConteudo);
    				aviso.setVisible(true);
    				String resposta = aviso.getResposta();
    				if (resposta != null) {
    					if (resposta.equals("Sim")) {
    						Tela_de_Login abrirTelaLogin = new Tela_de_Login();
    						abrirTelaLogin.setVisible(true);
    						dispose();
    					}
    				}
                }
            }
	    );
	}
}