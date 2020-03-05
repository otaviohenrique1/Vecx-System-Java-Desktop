package moduloFinanceiroVendaTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloFinanceiroVendaBD.Dao_consulta_dados_venda_lista_produtos;
import moduloFinanceiroVendaBD.VendaProdutos;
import moduloFinanceiroVendaTabelas.TabelaModeloVendaProdutosLista;
import moduloFinanceiroVendaTabelas.VendaListaTabela;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoTelas.Ficha_do_Produto;

public class Lista_de_Produtos_Vendas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaListaProdutosVenda;
	private JTable tabelaProdutos;
	private TabelaModeloVendaProdutosLista TabelaModeloVendaProdutos;
	private JTextField textBusca;
	private JButton produtoBusca, fichaProduto, voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista_de_Produtos_Vendas frame = new Lista_de_Produtos_Vendas();
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
	public Lista_de_Produtos_Vendas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Lista_de_Produtos_Vendas.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setSize(1000, 600);
		
		telaListaProdutosVenda = new JPanel();
		telaListaProdutosVenda.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaListaProdutosVenda.setLayout(new BorderLayout(0, 10));
		setContentPane(telaListaProdutosVenda);
		
		JPanel panelTitulo = new JPanel();
		telaListaProdutosVenda.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Lista_de_Produtos_Vendas.class.getResource("/cImagens/Lista de produtos.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelListaProdutos = new JLabel("Lista de produtos");
		panelTitulo2.add(labelListaProdutos);
		labelListaProdutos.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Lista_de_Produtos_Vendas.class.getResource("/cImagens/Funcionario.png")));
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
		
		JPanel panelProdutos = new JPanel();
		telaListaProdutosVenda.add(panelProdutos, BorderLayout.CENTER);
		panelProdutos.setLayout(new BorderLayout(0, 5));
		
		/*Busca na tabela da lista de produtos da venda*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelProdutos.add(panelBusca, BorderLayout.NORTH);
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
		
		/*Tabela com a lista de produtos da venda*/
		TabelaModeloVendaProdutos = new TabelaModeloVendaProdutosLista();
		JScrollPane scrollPaneProdutos = new JScrollPane();
		panelProdutos.add(scrollPaneProdutos, BorderLayout.CENTER);
		tabelaProdutos = new JTable();
		scrollPaneProdutos.setViewportView(tabelaProdutos);
		tabelaProdutos.setModel(TabelaModeloVendaProdutos);
		tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(60);
		tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(250);
		tabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabelaProdutos.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabelaProdutos.getColumnModel().getColumn(4).setPreferredWidth(40);
		
		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloVendaProdutosLista> sorterBuscaVendaProdutosLista = new TableRowSorter<TabelaModeloVendaProdutosLista>(TabelaModeloVendaProdutos);
		tabelaProdutos.setRowSorter(sorterBuscaVendaProdutosLista);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaVendaProdutosLista.setRowFilter(null);
				}
				else {
					sorterBuscaVendaProdutosLista.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaVendaProdutosLista.setRowFilter(null);
					}
					else {
						sorterBuscaVendaProdutosLista.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		String codigoVendaConsulta = sessao.getVendaCodigo();
		Dao_consulta_dados_venda_lista_produtos teste = new Dao_consulta_dados_venda_lista_produtos();
    	List<VendaProdutos> Consulta = teste.Consulta_Dados_Venda_Lista_Produtos(codigoVendaConsulta);
		for (VendaProdutos leitura : Consulta) {
			String codigoProduto = leitura.getCodigoProduto();
			String nomeProduto = leitura.getNomeProduto();
			
			double quantidadeValor = leitura.getQuantidade();
			String quantidadeProduto = "" + quantidadeValor;
			
			double precoUnitarioValor = leitura.getPrecoUnitario();
			String precoUnitarioProduto = "" + precoUnitarioValor;
			
			double precoQuantidadeValor = leitura.getPrecoQuantidade();
			String precoQuantidadeProduto = "" + precoQuantidadeValor;
			
			VendaListaTabela listaProdutos = new VendaListaTabela(codigoProduto, nomeProduto, quantidadeProduto, precoUnitarioProduto, precoQuantidadeProduto);
			TabelaModeloVendaProdutos.addVendaProdutosLista(listaProdutos);
		}
		
		JPanel panelBotoes = new JPanel();
		telaListaProdutosVenda.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		fichaProduto = new JButton("Exibir");
		fichaProduto.setToolTipText("Exibe ficha do produto");
		fichaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabelaProdutos.getSelectedRow() != -1 && tabelaProdutos.getSelectedRow() < tabelaProdutos.getRowCount()) {
					
					sessao.setCodigoProduto((String) tabelaProdutos.getModel().getValueAt(tabelaProdutos.getSelectedRow(),0));
					sessao.setNomeProduto((String) tabelaProdutos.getModel().getValueAt(tabelaProdutos.getSelectedRow(), 1));
					
					Ficha_do_Produto fichaProduto = new Ficha_do_Produto();
					fichaProduto.setVisible(true);
				}
				else {
					String menssagemConteudo = "Nenhum item selecionado";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
				}
			}
		});
		fichaProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(fichaProduto);
		
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