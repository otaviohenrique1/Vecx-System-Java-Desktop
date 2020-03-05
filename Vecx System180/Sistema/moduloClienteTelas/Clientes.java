package moduloClienteTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloClienteBD.Cliente;
import moduloClienteBD.Dao_consulta_dados_cliente;
import moduloClienteTabela.ClientesTabela;
import moduloClienteTabela.TabelaModeloClientes;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Clientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaClientes;
	private JTable tabelaClientes;
	private TabelaModeloClientes TabelaModelo;
	private JLabel icone;
	private JTextField textBusca;
	private JButton produtoBusca, exibir, atualizar, voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(true);
		setSize(1000, 600);
		
		telaClientes = new JPanel();
		telaClientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaClientes.setLayout(new BorderLayout(10, 10));
		setContentPane(telaClientes);
		
		JPanel panelTitulo = new JPanel();
		telaClientes.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelTitulo2 = new JPanel();
		panelTitulo.add(panelTitulo2);
		FlowLayout fl_panelTitulo2 = (FlowLayout) panelTitulo2.getLayout();
		fl_panelTitulo2.setAlignment(FlowLayout.LEFT);
		
		icone = new JLabel("");
		icone.setIcon(new ImageIcon(Clientes.class.getResource("/cImagens/Clientes.png")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo2.add(icone);
		
		JLabel labelClientes = new JLabel("Clientes");
		labelClientes.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panelTitulo2.add(labelClientes);
		
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
		fichaUsuario.setIcon(new ImageIcon(Clientes.class.getResource("/cImagens/Funcionario.png")));
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
		
		JPanel panelClientes = new JPanel();
		telaClientes.add(panelClientes, BorderLayout.CENTER);
		panelClientes.setLayout(new BorderLayout(0, 5));
		
		/*Busca na tabela de clientes*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelClientes.add(panelBusca, BorderLayout.NORTH);
		panelBusca.setLayout(new BorderLayout(10, 0));
		
		JLabel labelBusca = new JLabel("Busca:");
		labelBusca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBusca.add(labelBusca, BorderLayout.WEST);
		
		textBusca = new JTextField();
		textBusca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBusca.add(textBusca);
		textBusca.setColumns(10);
		
		produtoBusca = new JButton("Busca");
		produtoBusca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBusca.add(produtoBusca, BorderLayout.EAST);
		
		/*Tabela com a lista de clientes*/
		TabelaModelo = new TabelaModeloClientes();
		JScrollPane scrollPaneClientes = new JScrollPane();
		panelClientes.add(scrollPaneClientes, BorderLayout.CENTER);
		tabelaClientes = new JTable();
		tabelaClientes.setModel(TabelaModelo);
		scrollPaneClientes.setViewportView(tabelaClientes);
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(300);
		tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloClientes> sorterBuscaClientes = new TableRowSorter<TabelaModeloClientes>(TabelaModelo);
		tabelaClientes.setRowSorter(sorterBuscaClientes);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaClientes.setRowFilter(null);
				}
				else {
					sorterBuscaClientes.setRowFilter(RowFilter.regexFilter(palavraBusca));
				}
			}
		});
		textBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evtkey) {
				int botaoteclado = evtkey.getKeyCode();
				if (botaoteclado == KeyEvent.VK_ENTER) {
					String palavraBusca = textBusca.getText();
					if (palavraBusca.length() ==0 ) {
						sorterBuscaClientes.setRowFilter(null);
					}
					else {
						sorterBuscaClientes.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_cliente teste = new Dao_consulta_dados_cliente();
    	List<Cliente> Consulta = teste.Consulta_Dados_Cliente_Lista();
		for (Cliente leitura : Consulta) {
			String codigoClienteTexto = leitura.getCodigoCliente();
			String nomeClienteTexto = leitura.getNome();
			String rgClienteTexto = leitura.getRG();
			String cpfClienteTexto = leitura.getCPF();
			
			ClientesTabela listaFuncionarios = new ClientesTabela(codigoClienteTexto, nomeClienteTexto, rgClienteTexto, cpfClienteTexto);
    		TabelaModelo.addClientes(listaFuncionarios);
		}
		
		JPanel panelBotoes = new JPanel();
		telaClientes.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
				
		exibir = new JButton("Exibir");
		exibir.setToolTipText("Exibe a ficha com os dados do cliente");
		exibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaClientes.getSelectedRow() != -1 && tabelaClientes.getSelectedRow() < TabelaModelo.getRowCount()) {
					
					sessao.setCodigoCliente((String) tabelaClientes.getModel().getValueAt(tabelaClientes.getSelectedRow(),0));
					sessao.setNomeCliente((String) tabelaClientes.getModel().getValueAt(tabelaClientes.getSelectedRow(), 1));
					sessao.setCPFCliente((String) tabelaClientes.getModel().getValueAt(tabelaClientes.getSelectedRow(), 3));
					
					Ficha_do_Cliente exibeFichaCliente = new Ficha_do_Cliente();
					exibeFichaCliente.setVisible(true);
				}
				else {
					String menssagemConteudo = "Nenhum item selecionado";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
				}
			}
		});
		
		exibir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(exibir);
		
		atualizar = new JButton("Atualizar tabela");
		atualizar.setToolTipText("Atualiza a tabela");
		atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes reabrirTela = new Clientes();
				reabrirTela.setVisible(true);
				dispose();
			}
		});
		atualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(atualizar);
		
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