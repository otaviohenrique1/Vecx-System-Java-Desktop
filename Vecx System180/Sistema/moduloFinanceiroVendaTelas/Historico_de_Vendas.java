package moduloFinanceiroVendaTelas;

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
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloFinanceiroNotaFiscalTelas.Lista_de_Nota_Fiscal;
import moduloFinanceiroVendaBD.Dao_consulta_dados_venda_historico;
import moduloFinanceiroVendaBD.VendaHistorico;
import moduloFinanceiroVendaTabelas.HistoricoVendaTabela;
import moduloFinanceiroVendaTabelas.TabelaModeloHistoricoVenda;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Historico_de_Vendas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaHistoricoVendas;
	private JTable tabelaHistoricoVenda;
	private TabelaModeloHistoricoVenda TabelaModelo;
	private JTextField textBusca;
	private JButton produtoBusca, notaFiscal, dadosCompra, listaProdutos, voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Historico_de_Vendas frame = new Historico_de_Vendas();
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
	public Historico_de_Vendas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Historico_de_Vendas.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(true);
		setSize(1000, 600);
		
		telaHistoricoVendas = new JPanel();
		telaHistoricoVendas.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaHistoricoVendas.setLayout(new BorderLayout(0, 10));
		setContentPane(telaHistoricoVendas);
		
		JPanel panelTitulo = new JPanel();
		telaHistoricoVendas.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		panelTitulo.add(panelTitulo2);
		panelTitulo2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Historico_de_Vendas.class.getResource("/cImagens/Historico vendas.png")));
		icone.setPreferredSize(new Dimension(30, 30));
		panelTitulo2.add(icone);
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelHistoricoVendas = new JLabel("Historico de vendas");
		panelTitulo2.add(labelHistoricoVendas);
		labelHistoricoVendas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Historico_de_Vendas.class.getResource("/cImagens/Funcionario.png")));
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
		
		JPanel panelHistoricoVendas = new JPanel();
		telaHistoricoVendas.add(panelHistoricoVendas, BorderLayout.CENTER);
		panelHistoricoVendas.setLayout(new BorderLayout(0, 5));
		
		/*Busca na tabela de historico de venda*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelHistoricoVendas.add(panelBusca, BorderLayout.NORTH);
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
		
		/*Tabela com a lista de historico de venda*/
		TabelaModelo = new TabelaModeloHistoricoVenda();
		JScrollPane scrollPaneHistoricoVenda = new JScrollPane();
		panelHistoricoVendas.add(scrollPaneHistoricoVenda, BorderLayout.CENTER);
		tabelaHistoricoVenda = new JTable();
		tabelaHistoricoVenda.setModel(TabelaModelo);
		scrollPaneHistoricoVenda.setViewportView(tabelaHistoricoVenda);
		tabelaHistoricoVenda.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaHistoricoVenda.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabelaHistoricoVenda.getColumnModel().getColumn(2).setPreferredWidth(180);
		tabelaHistoricoVenda.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabelaHistoricoVenda.getColumnModel().getColumn(4).setPreferredWidth(40);
		
		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloHistoricoVenda> sorterBuscaHistoricoVenda = new TableRowSorter<TabelaModeloHistoricoVenda>(TabelaModelo);
		tabelaHistoricoVenda.setRowSorter(sorterBuscaHistoricoVenda);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaHistoricoVenda.setRowFilter(null);
				}
				else {
					sorterBuscaHistoricoVenda.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaHistoricoVenda.setRowFilter(null);
					}
					else {
						sorterBuscaHistoricoVenda.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_venda_historico teste = new Dao_consulta_dados_venda_historico();
    	List<VendaHistorico> Consulta = teste.Consulta_Dados_Venda_Historico();
		for (VendaHistorico leitura : Consulta) {
			String codigoProduto = leitura.getCodigoVenda();
			String nomeCliente = leitura.getNomeCliente();
			String nomeFuncionario = leitura.getNomeFuncionario();
			
    		Date dataVenda = leitura.getDataVenda();
    		Time horaVenda = leitura.getHoraVenda();
    		
    		SimpleDateFormat dataVendaFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataVendaValor = dataVendaFormato.format(dataVenda);
    		SimpleDateFormat horaVendaFormato = new SimpleDateFormat("hh:mm");
    		String horaVendaValor = horaVendaFormato.format(horaVenda);
    		
    		String dataHoraVenda = dataVendaValor + " " + horaVendaValor;
    		
			double precoTotalValor = leitura.getPrecoTotal();
			String precoTotalProduto = "" + precoTotalValor;
			
			HistoricoVendaTabela listaProdutos = new HistoricoVendaTabela(codigoProduto, nomeCliente, nomeFuncionario, precoTotalProduto, dataHoraVenda);
    		TabelaModelo.addHistoricoVenda(listaProdutos);
		}
		
		JPanel panelBotoes = new JPanel();
		telaHistoricoVendas.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		notaFiscal = new JButton("Nota Fiscal");
		notaFiscal.setToolTipText("Abre a tela de nota fiscal");
		notaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		notaFiscal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lista_de_Nota_Fiscal abrirListaNota_Fiscal = new Lista_de_Nota_Fiscal();
				abrirListaNota_Fiscal.setVisible(true);
				dispose();
			}
		});
		panelBotoes2.add(notaFiscal);
		
		dadosCompra = new JButton("Dados da venda");
		dadosCompra.setToolTipText("Abre a tela de dados da venda");
		dadosCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(dadosCompra);
		dadosCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaHistoricoVenda.getSelectedRow() != -1 && tabelaHistoricoVenda.getSelectedRow() < TabelaModelo.getRowCount()) {
					
					sessao.setVendaCodigo((String) tabelaHistoricoVenda.getModel().getValueAt(tabelaHistoricoVenda.getSelectedRow(),0));
					sessao.setVendaCliente((String) tabelaHistoricoVenda.getModel().getValueAt(tabelaHistoricoVenda.getSelectedRow(), 1));
					sessao.setVendaFuncionario((String) tabelaHistoricoVenda.getModel().getValueAt(tabelaHistoricoVenda.getSelectedRow(), 2));
					
					Historico_de_Vendas_Ficha exibeFichaVendas = new Historico_de_Vendas_Ficha();
					exibeFichaVendas.setVisible(true);
				}
				else {
					String menssagemConteudo = "Nenhum item selecionado";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
				}
			}
		});
		
		listaProdutos = new JButton("Lista de produtos");
		listaProdutos.setToolTipText("Abre a tela da lista de produtos da venda");
		listaProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaHistoricoVenda.getSelectedRow() != -1 && tabelaHistoricoVenda.getSelectedRow() < TabelaModelo.getRowCount()) {
					
					sessao.setVendaCodigo((String) tabelaHistoricoVenda.getModel().getValueAt(tabelaHistoricoVenda.getSelectedRow(),0));
					
					Lista_de_Produtos_Vendas exibeVendasLista = new Lista_de_Produtos_Vendas();
					exibeVendasLista.setVisible(true);
				}
				else {
					String menssagemConteudo = "Nenhum item selecionado";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
				}
			}
		});
		listaProdutos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(listaProdutos);
		
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