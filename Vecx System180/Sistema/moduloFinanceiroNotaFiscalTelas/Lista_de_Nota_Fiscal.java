package moduloFinanceiroNotaFiscalTelas;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import moduloFinanceiroNotaFiscalBD.Dao_consulta_dados_nota_fiscal_lista;
import moduloFinanceiroNotaFiscalBD.NotaFiscal;
import moduloFinanceiroNotaFiscalTabelas.NotaFiscalTabela;
import moduloFinanceiroNotaFiscalTabelas.TabelaModeloNotaFiscal;
import moduloFinanceiroVendaTelas.Historico_de_Vendas;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Lista_de_Nota_Fiscal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaNotaFiscal;
	private JTable tabelaNotaFiscal;
	private TabelaModeloNotaFiscal TabelaModelo;
	private JButton produtoBusca, exibir, voltar;
	private JTextField textBusca;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista_de_Nota_Fiscal frame = new Lista_de_Nota_Fiscal();
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
	public Lista_de_Nota_Fiscal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Lista_de_Nota_Fiscal.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(true);
		setSize(1000, 600);
		
		telaNotaFiscal = new JPanel();
		telaNotaFiscal.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaNotaFiscal.setLayout(new BorderLayout(5, 5));
		setContentPane(telaNotaFiscal);
		
		JPanel panelTitulo = new JPanel();
		telaNotaFiscal.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo3 = new JPanel();
		panelTitulo.add(panelTitulo3);
		FlowLayout fl_panelTitulo3 = (FlowLayout) panelTitulo3.getLayout();
		fl_panelTitulo3.setAlignment(FlowLayout.LEFT);
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Lista_de_Nota_Fiscal.class.getResource("/cImagens/Lista de nota fiscal.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo3.add(icone);
		
		JLabel labelNotaFiscal = new JLabel("Nota fiscal");
		labelNotaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panelTitulo3.add(labelNotaFiscal);
		
		String nome = sessao.getNome();
		String cargo = sessao.getCargo();
		String codigo = sessao.getCodigo();
		
		JPanel menuBotoesJanela = new JPanel();
		panelTitulo.add(menuBotoesJanela);
		menuBotoesJanela.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JPanel menuBotoesJanela1 = new JPanel();
		menuBotoesJanela1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		menuBotoesJanela.add(menuBotoesJanela1);
		menuBotoesJanela1.setLayout(new BorderLayout(10, 0));
		
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
		fichaUsuario.setIcon(new ImageIcon(Lista_de_Nota_Fiscal.class.getResource("/cImagens/Funcionario.png")));
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
		
		/*Parte da lista de nota de fiscal*/
		JPanel panelNotaFiscal = new JPanel();
		telaNotaFiscal.add(panelNotaFiscal, BorderLayout.CENTER);
		panelNotaFiscal.setLayout(new BorderLayout(0, 5));
		
		/*Busca na tabela da lista de nota de fiscal*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNotaFiscal.add(panelBusca, BorderLayout.NORTH);
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
		
		/*Tabela com a lista de nota de fiscal*/
		TabelaModelo = new TabelaModeloNotaFiscal();
		JScrollPane scrollPaneNotaFiscal = new JScrollPane();
		panelNotaFiscal.add(scrollPaneNotaFiscal, BorderLayout.CENTER);
		tabelaNotaFiscal = new JTable();
		tabelaNotaFiscal.setModel(TabelaModelo);
		scrollPaneNotaFiscal.setViewportView(tabelaNotaFiscal);
		tabelaNotaFiscal.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaNotaFiscal.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabelaNotaFiscal.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabelaNotaFiscal.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabelaNotaFiscal.getColumnModel().getColumn(4).setPreferredWidth(40);
		
		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloNotaFiscal> sorterBuscaNotaFiscal = new TableRowSorter<TabelaModeloNotaFiscal>(TabelaModelo);
		tabelaNotaFiscal.setRowSorter(sorterBuscaNotaFiscal);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaNotaFiscal.setRowFilter(null);
				}
				else {
					sorterBuscaNotaFiscal.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaNotaFiscal.setRowFilter(null);
					}
					else {
						sorterBuscaNotaFiscal.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_nota_fiscal_lista teste = new Dao_consulta_dados_nota_fiscal_lista();
    	List<NotaFiscal> Consulta = teste.Consulta_Dados_Nota_Fiscal_Lista();
		for (NotaFiscal leitura : Consulta) {
			
			String codigoNotaFiscal = leitura.getCodigoNotaFiscal();
			String codigoCompra = leitura.getCodigoVenda();
			String nomeCliente = leitura.getClienteNome();
			
    		Date dataVenda = leitura.getDataEmissao();
    		SimpleDateFormat dataVendaFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataVendaValor = dataVendaFormato.format(dataVenda);
    		Time horaVenda = leitura.getHoraEmissao();
    		SimpleDateFormat horaVendaFormato = new SimpleDateFormat("HH:mm");
    		
    		String horaVendaValor = horaVendaFormato.format(horaVenda);
    		String dataHoraVenda = dataVendaValor + " " + horaVendaValor;
    		
			double precoTotalValor = leitura.getPrecoTotal();
			String precoTotalProduto = "" + precoTotalValor;
			
			NotaFiscalTabela listaNotaFiscal = new NotaFiscalTabela(codigoNotaFiscal, codigoCompra, nomeCliente, precoTotalProduto, dataHoraVenda);
    		TabelaModelo.addNotaFiscal(listaNotaFiscal);
		}
		
		JPanel panelBotoes = new JPanel();
		telaNotaFiscal.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		
		panelBotoes.add(panelBotoes2);
		
		exibir = new JButton("Exibir");
		exibir.setToolTipText("Abre a tela que exibe os dados da nota fiscal");
		exibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaNotaFiscal.getSelectedRow() != -1 && tabelaNotaFiscal.getSelectedRow() < TabelaModelo.getRowCount()) {
					
					sessao.setCodigoNotaFiscal((String) tabelaNotaFiscal.getModel().getValueAt(tabelaNotaFiscal.getSelectedRow(),0));
					sessao.setCodigoCompraNotaFiscal((String) tabelaNotaFiscal.getModel().getValueAt(tabelaNotaFiscal.getSelectedRow(), 1));
					
					Lista_de_Nota_Fiscal_Ficha exibeFichaNotaFiscal = new Lista_de_Nota_Fiscal_Ficha();
					exibeFichaNotaFiscal.setVisible(true);
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
		
		voltar = new JButton("Voltar");
		voltar.setToolTipText("Fecha a janela");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historico_de_Vendas abrirHistoricoVendas = new Historico_de_Vendas();
				abrirHistoricoVendas.setVisible(true); 
	            dispose();
			}
		});
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(voltar);
		
		/*Ação do botao sair da janela*/
		addWindowListener(
            new WindowAdapter() 
            {
                public void windowClosing(WindowEvent we) {
                	Historico_de_Vendas abrirHistoricoVendas = new Historico_de_Vendas();
					abrirHistoricoVendas.setVisible(true); 
		            dispose();
                }
            }
	    );
	}	
}