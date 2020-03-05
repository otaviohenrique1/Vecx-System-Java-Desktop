package moduloFornecedorTelas;

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
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloFornecedorBD.Dao_consulta_dados_fornecedor;
import moduloFornecedorBD.Fornecedor;
import moduloFornecedorTabelas.FornecedoresTabela;
import moduloFornecedorTabelas.TabelaModeloFornecedoes;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Fornecedores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFornecedores;
	private JTable tabelaFornecedores;
	private TabelaModeloFornecedoes TabelaModelo;
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
					Fornecedores frame = new Fornecedores();
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
	public Fornecedores() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(true);
		setSize(1000, 600);
		
		telaFornecedores = new JPanel();
		telaFornecedores.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFornecedores.setLayout(new BorderLayout(10, 10));
		setContentPane(telaFornecedores);
		
		JPanel panelTitulo = new JPanel();
		telaFornecedores.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		panelTitulo.add(panelTitulo2);
		FlowLayout fl_panelTitulo2 = (FlowLayout) panelTitulo2.getLayout();
		fl_panelTitulo2.setAlignment(FlowLayout.LEFT);
		
		icone = new JLabel("");
		icone.setIcon(new ImageIcon(Fornecedores.class.getResource("/cImagens/Fornecedores.png")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo2.add(icone);
		
		JLabel labelFornecedores = new JLabel("Fornecedores");
		labelFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panelTitulo2.add(labelFornecedores);
		
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
		fichaUsuario.setIcon(new ImageIcon(Fornecedores.class.getResource("/cImagens/Funcionario.png")));
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
		
		JPanel panelFornecedores = new JPanel();
		telaFornecedores.add(panelFornecedores, BorderLayout.CENTER);
		panelFornecedores.setLayout(new BorderLayout(0, 5));
		
		/*Busca na tabela de fornecedores*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFornecedores.add(panelBusca, BorderLayout.NORTH);
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
		
		/*Tabela com a lista de fornecedores*/
		TabelaModelo = new TabelaModeloFornecedoes();
		JScrollPane scrollPaneFornecedores = new JScrollPane();
		panelFornecedores.add(scrollPaneFornecedores, BorderLayout.CENTER);
		tabelaFornecedores = new JTable();
		tabelaFornecedores.setModel(TabelaModelo);
		scrollPaneFornecedores.setViewportView(tabelaFornecedores);
		tabelaFornecedores.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaFornecedores.getColumnModel().getColumn(1).setPreferredWidth(300);
		tabelaFornecedores.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloFornecedoes> sorterBuscaFornecedoes = new TableRowSorter<TabelaModeloFornecedoes>(TabelaModelo);
		tabelaFornecedores.setRowSorter(sorterBuscaFornecedoes);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaFornecedoes.setRowFilter(null);
				}
				else {
					sorterBuscaFornecedoes.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaFornecedoes.setRowFilter(null);
					}
					else {
						sorterBuscaFornecedoes.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_fornecedor teste = new Dao_consulta_dados_fornecedor();
    	List<Fornecedor> Consulta = teste.Consulta_Dados_Fornecedor_Lista();
		for (Fornecedor leitura : Consulta) {
			FornecedoresTabela listaFornecedores = new FornecedoresTabela(leitura.getCodigoFornecedor(), leitura.getNome(), leitura.getCNPJ());
    		TabelaModelo.addFornecedor(listaFornecedores);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFornecedores.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		exibir = new JButton("Exibir");
		exibir.setToolTipText("Exibe a ficha com os dados do fornecedor");
		exibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaFornecedores.getSelectedRow() != -1 && tabelaFornecedores.getSelectedRow() < TabelaModelo.getRowCount()) {
					
					sessao.setCodigoFornecedor((String) tabelaFornecedores.getModel().getValueAt(tabelaFornecedores.getSelectedRow(),0));
					sessao.setNomeFornecedor((String) tabelaFornecedores.getModel().getValueAt(tabelaFornecedores.getSelectedRow(), 1));
					sessao.setCNPJFornecedor((String) tabelaFornecedores.getModel().getValueAt(tabelaFornecedores.getSelectedRow(), 2));
					
					Ficha_do_Fornecedor exibeFichaFornecedor = new Ficha_do_Fornecedor();
					exibeFichaFornecedor.setVisible(true);
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
				Fornecedores reabrirTela = new Fornecedores();
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