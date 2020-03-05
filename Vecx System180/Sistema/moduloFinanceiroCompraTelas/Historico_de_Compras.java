package moduloFinanceiroCompraTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloFinanceiroCompraBD.CompraHistorico;
import moduloFinanceiroCompraBD.Dao_consulta_dados_compra_historico;
import moduloFinanceiroCompraTabelas.HistoricoCompraTabela;
import moduloFinanceiroCompraTabelas.TabelaModeloHistoricoCompra;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Historico_de_Compras extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaHistoricoCompras;
	private JTable tabelaHistoricoCompra;
	private TabelaModeloHistoricoCompra TabelaModeloHistorico;
	private JTextField textBusca;
	private JButton produtoBusca, dadosCompra, listaProdutos, voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Historico_de_Compras frame = new Historico_de_Compras();
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
	public Historico_de_Compras() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Historico_de_Compras.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(true);
		setSize(1000, 600);
		
		telaHistoricoCompras = new JPanel();
		telaHistoricoCompras.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaHistoricoCompras.setLayout(new BorderLayout(0, 10));
		setContentPane(telaHistoricoCompras);
		
		JPanel panelTitulo = new JPanel();
		telaHistoricoCompras.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		panelTitulo.add(panelTitulo2);
		panelTitulo2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Historico_de_Compras.class.getResource("/cImagens/Historico compras.png")));
		icone.setPreferredSize(new Dimension(30, 30));
		panelTitulo2.add(icone);
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelHistoricoCompras = new JLabel("Historico de compras");
		panelTitulo2.add(labelHistoricoCompras);
		labelHistoricoCompras.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		String nome = sessao.getNome();
		String cargo = sessao.getCargo();
		String codigo = sessao.getCodigo();
		
		JPanel MenuBotoesJanela = new JPanel();
		panelTitulo.add(MenuBotoesJanela, BorderLayout.CENTER);
		MenuBotoesJanela.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JPanel MenuBotoesJanela1 = new JPanel();
		MenuBotoesJanela1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		MenuBotoesJanela.add(MenuBotoesJanela1);
		MenuBotoesJanela1.setLayout(new BorderLayout(10, 0));
		
		JButton fichaUsuario = new JButton();
		fichaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sessao.setCodigoFuncionario(codigo);
				sessao.setNomeFuncionario(nome);
				sessao.setCargoFuncionario(cargo);
				
				Ficha_do_Funcionario_Exibicao FichaFuncionario = new Ficha_do_Funcionario_Exibicao();
				FichaFuncionario.setVisible(true);
			}
		});
		fichaUsuario.setPreferredSize(new Dimension(30, 30));
		fichaUsuario.setIcon(new ImageIcon(Historico_de_Compras.class.getResource("/cImagens/Funcionario.png")));
		fichaUsuario.setToolTipText("Ficha do usuario");
		fichaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		MenuBotoesJanela1.add(fichaUsuario, BorderLayout.CENTER);
		
		JPanel panelDadosUsuario = new JPanel();
		MenuBotoesJanela1.add(panelDadosUsuario, BorderLayout.WEST);
		panelDadosUsuario.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel nomeFuncionarioLogin = new JLabel("Nome: Usuario");
		panelDadosUsuario.add(nomeFuncionarioLogin);
		
		JLabel cargoFuncionarioLogin = new JLabel("Cargo: Cargo");
		panelDadosUsuario.add(cargoFuncionarioLogin);
		
		String nomeLogin, cargoLogin;
		if (nome == null) {
			nomeLogin = "Usuario";
			nomeFuncionarioLogin.setText("Nome: " + nomeLogin);
		}
		else {
			nomeFuncionarioLogin.setText("Nome: " + nome);
		}
		
		if (cargo == null) {
			cargoLogin = "Cargo";
			cargoFuncionarioLogin.setText("Cargo: " + cargoLogin);
		}
		else {
			cargoFuncionarioLogin.setText("Cargo: " + cargo);
		}
		
		JPanel panelHistoricoCompras = new JPanel();
		telaHistoricoCompras.add(panelHistoricoCompras, BorderLayout.CENTER);
		panelHistoricoCompras.setLayout(new BorderLayout(0, 5));
		
		/*Busca na tabela de historico de compras*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelHistoricoCompras.add(panelBusca, BorderLayout.NORTH);
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
		
		/*Tabela com a lista de historico de compras*/
		TabelaModeloHistorico = new TabelaModeloHistoricoCompra();
		JScrollPane scrollPaneHistoricoCompra = new JScrollPane();
		panelHistoricoCompras.add(scrollPaneHistoricoCompra, BorderLayout.CENTER);
		tabelaHistoricoCompra = new JTable();
		tabelaHistoricoCompra.setModel(TabelaModeloHistorico);
		scrollPaneHistoricoCompra.setViewportView(tabelaHistoricoCompra);
		tabelaHistoricoCompra.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaHistoricoCompra.getColumnModel().getColumn(1).setPreferredWidth(300);
		tabelaHistoricoCompra.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabelaHistoricoCompra.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_compra_historico teste = new Dao_consulta_dados_compra_historico();
    	List<CompraHistorico> Consulta = teste.Consulta_Dados_Compra_Historico();
		for (CompraHistorico leitura : Consulta) {
			String codigoProduto = leitura.getCodigoCompra();
			String nomeFuncionario = leitura.getNomeFuncionario();
			
    		Date dataVenda = leitura.getDataCompra();
    		SimpleDateFormat dataVendaFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataVendaValor = dataVendaFormato.format(dataVenda);
    		Time horaVenda = leitura.getHoraCompra();
    		SimpleDateFormat horaVendaFormato = new SimpleDateFormat("HH:mm");
    		String horaVendaValor = horaVendaFormato.format(horaVenda);
    		String dataHoraVenda = dataVendaValor + " " + horaVendaValor;
    		
			double precoTotalValor = leitura.getPrecoTotal();
			String precoTotalProduto = "" + precoTotalValor;
			
			HistoricoCompraTabela listaProdutos = new HistoricoCompraTabela(codigoProduto, nomeFuncionario, dataHoraVenda, precoTotalProduto);
			TabelaModeloHistorico.addHistoricoCompra(listaProdutos);
		}
		
		
		JPanel panelBotoes = new JPanel();
		telaHistoricoCompras.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		dadosCompra = new JButton("Dados da compra");
		dadosCompra.setToolTipText("Exibe os dados da ficha da compra");
		dadosCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaHistoricoCompra.getSelectedRow() != -1 && tabelaHistoricoCompra.getSelectedRow() < TabelaModeloHistorico.getRowCount()) {
					
					sessao.setCompraCodigo((String) tabelaHistoricoCompra.getModel().getValueAt(tabelaHistoricoCompra.getSelectedRow(),0));
					sessao.setCompraFuncionario((String) tabelaHistoricoCompra.getModel().getValueAt(tabelaHistoricoCompra.getSelectedRow(), 1));
					
					Historico_de_Compras_Ficha exibeFichaCompras = new Historico_de_Compras_Ficha();
					exibeFichaCompras.setVisible(true);
				}
				else {
					String menssagemConteudo = "Nenhum item selecionado";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
				}
			}
		});
		dadosCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(dadosCompra);
		
		listaProdutos = new JButton("Lista de produtos");
		listaProdutos.setToolTipText("Lista de produtos da compra");
		listaProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaHistoricoCompra.getSelectedRow() != -1 && tabelaHistoricoCompra.getSelectedRow() < TabelaModeloHistorico.getRowCount()) {
					
					sessao.setCompraCodigo((String) tabelaHistoricoCompra.getModel().getValueAt(tabelaHistoricoCompra.getSelectedRow(),0));
					
					Lista_de_Produtos_Compras exibeComprasLista = new Lista_de_Produtos_Compras();
					exibeComprasLista.setVisible(true);
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