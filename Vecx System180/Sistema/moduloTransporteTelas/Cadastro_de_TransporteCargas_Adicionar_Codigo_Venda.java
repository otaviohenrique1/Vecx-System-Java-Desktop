package moduloTransporteTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
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
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloFinanceiroVendaBD.Dao_consulta_dados_venda_historico;
import moduloFinanceiroVendaBD.VendaHistorico;
import moduloTransporteTabelas.AdicionarCodigoVendaTabela;
import moduloTransporteTabelas.TabelaModeloAdicionarCodigoVenda;

public class Cadastro_de_TransporteCargas_Adicionar_Codigo_Venda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaCodigoVenda;
	private JTable tabelaCodigoVenda;
	private TabelaModeloAdicionarCodigoVenda TabelaModeloCodigoVenda;
	private JButton produtoBusca, selecionar, voltar;
	private JTextField textBusca;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_de_TransporteCargas_Adicionar_Codigo_Venda frame = new Cadastro_de_TransporteCargas_Adicionar_Codigo_Venda();
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
	public Cadastro_de_TransporteCargas_Adicionar_Codigo_Venda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro_de_TransporteCargas_Adicionar_Codigo_Venda.class.getResource("/cImagens/Logo Janela.PNG")));
		setModal(true);
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		setResizable(false);
		setSize(600, 420);
		
		telaCodigoVenda = new JPanel();
		telaCodigoVenda.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaCodigoVenda.setLayout(new BorderLayout(0, 10));
		setContentPane(telaCodigoVenda);
		
		JPanel panelTitulo = new JPanel();
		telaCodigoVenda.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel icone = new JLabel("");
		panelTitulo.add(icone);
		icone.setIcon(new ImageIcon(Cadastro_de_TransporteCargas_Adicionar_Codigo_Venda.class.getResource("/cImagens/Adicionar codigo da venda.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelCodigoVenda = new JLabel("Codigo de venda");
		panelTitulo.add(labelCodigoVenda);
		labelCodigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JPanel panelCodigoVenda = new JPanel();
		telaCodigoVenda.add(panelCodigoVenda, BorderLayout.CENTER);
		panelCodigoVenda.setLayout(new BorderLayout(0, 5));

		/*Busca na tabela com a lista de codigo de venda*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCodigoVenda.add(panelBusca, BorderLayout.NORTH);
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
		
		/*Tabela com a lista de codigo de venda*/
		JScrollPane scrollPaneHistoricoVenda = new JScrollPane();
		panelCodigoVenda.add(scrollPaneHistoricoVenda, BorderLayout.CENTER);
		TabelaModeloCodigoVenda = new TabelaModeloAdicionarCodigoVenda();
		tabelaCodigoVenda = new JTable();
		tabelaCodigoVenda.setModel(TabelaModeloCodigoVenda);
		scrollPaneHistoricoVenda.setViewportView(tabelaCodigoVenda);
		tabelaCodigoVenda.getColumnModel().getColumn(0).setPreferredWidth(90);
		tabelaCodigoVenda.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabelaCodigoVenda.getColumnModel().getColumn(2).setPreferredWidth(90);
		tabelaCodigoVenda.getColumnModel().getColumn(3).setPreferredWidth(90);

		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloAdicionarCodigoVenda> sorterBuscaCodigoVenda = new TableRowSorter<TabelaModeloAdicionarCodigoVenda>(TabelaModeloCodigoVenda);
		tabelaCodigoVenda.setRowSorter(sorterBuscaCodigoVenda);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaCodigoVenda.setRowFilter(null);
				}
				else {
					sorterBuscaCodigoVenda.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaCodigoVenda.setRowFilter(null);
					}
					else {
						sorterBuscaCodigoVenda.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
			
    		Date dataVenda = leitura.getDataVenda();
    		Time horaVenda = leitura.getHoraVenda();
    		
    		SimpleDateFormat dataVendaFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataVendaValor = dataVendaFormato.format(dataVenda);
    		SimpleDateFormat horaVendaFormato = new SimpleDateFormat("hh:mm");
    		String horaVendaValor = horaVendaFormato.format(horaVenda);
    		
    		String dataHoraVenda = dataVendaValor + " " + horaVendaValor;
    		
			double precoTotalValor = leitura.getPrecoTotal();
			String precoTotalProduto = "" + precoTotalValor;
			
			AdicionarCodigoVendaTabela listaProdutos = new AdicionarCodigoVendaTabela(codigoProduto, nomeCliente, precoTotalProduto, dataHoraVenda);
			TabelaModeloCodigoVenda.addAdicionarCodigoVenda(listaProdutos);
		}
		
		JPanel panelBotoes = new JPanel();
		telaCodigoVenda.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		selecionar = new JButton("Selecionar");
		selecionar.setToolTipText("Selecionar o codigo da  venda");
		selecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaCodigoVenda.getSelectedRow() != -1 && tabelaCodigoVenda.getSelectedRow() < TabelaModeloCodigoVenda.getRowCount()) {
						String codigoVenda = (String)tabelaCodigoVenda.getModel().getValueAt(tabelaCodigoVenda.getSelectedRow(),0);
						setCodigoVenda(codigoVenda);
						setVisible(false);
				}
				else {
					String menssagemConteudo = "Nenhum item selecionado";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
				}
			}
		});
		selecionar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(selecionar);
		
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
	
	/*Metodos get e set*/
	private String codigoVenda;
	/*get e set Nome do cliente*/
	public String getCodigoVenda() {
		return codigoVenda;
	}
	public void setCodigoVenda(String codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
}