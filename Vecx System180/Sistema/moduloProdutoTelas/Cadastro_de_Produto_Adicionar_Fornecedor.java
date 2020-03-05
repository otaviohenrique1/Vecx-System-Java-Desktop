package moduloProdutoTelas;

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
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;
import java.util.List;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloFornecedorBD.Dao_consulta_dados_fornecedor;
import moduloFornecedorBD.Fornecedor;
import moduloProdutoTabelas.CadastroProdutoFornecedorTabela;
import moduloProdutoTabelas.TabelaModeloCadastroProdutoFornecedor;

public class Cadastro_de_Produto_Adicionar_Fornecedor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFornecedorProduto;
	private JTable tabelaFornecedorProduto;
	private TabelaModeloCadastroProdutoFornecedor TabelaModeloProdutoFornecedor;
	private JButton produtoBusca, selecionar, voltar;
	private JTextField textBusca;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_de_Produto_Adicionar_Fornecedor frame = new Cadastro_de_Produto_Adicionar_Fornecedor();
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
	public Cadastro_de_Produto_Adicionar_Fornecedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro_de_Produto_Adicionar_Fornecedor.class.getResource("/cImagens/Logo Janela.PNG")));
		setModal(true);
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setResizable(false);
		setSize(600, 400);
		
		telaFornecedorProduto = new JPanel();
		telaFornecedorProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFornecedorProduto.setLayout(new BorderLayout(0, 10));
		setContentPane(telaFornecedorProduto);
		
		JPanel panelTitulo = new JPanel();
		telaFornecedorProduto.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel Icone = new JLabel("");
		panelTitulo.add(Icone);
		Icone.setIcon(new ImageIcon(Cadastro_de_Produto_Adicionar_Fornecedor.class.getResource("/cImagens/Adicionar fornecedor.PNG")));
		Icone.setPreferredSize(new Dimension(30, 30));
		Icone.setHorizontalAlignment(SwingConstants.CENTER);
		Icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFornecedorProduto = new JLabel("Selecionar fornecedor");
		panelTitulo.add(labelFornecedorProduto);
		labelFornecedorProduto.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JPanel panelFornecedorProduto = new JPanel();
		telaFornecedorProduto.add(panelFornecedorProduto, BorderLayout.CENTER);
		panelFornecedorProduto.setLayout(new BorderLayout(0, 5));

		/*Busca na tabela com a lista de fornecedores*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFornecedorProduto.add(panelBusca, BorderLayout.NORTH);
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
		JScrollPane scrollPaneFornecedorProduto = new JScrollPane();
		panelFornecedorProduto.add(scrollPaneFornecedorProduto);
		TabelaModeloProdutoFornecedor = new TabelaModeloCadastroProdutoFornecedor();
		tabelaFornecedorProduto = new JTable();
		scrollPaneFornecedorProduto.setViewportView(tabelaFornecedorProduto);
		tabelaFornecedorProduto.setModel(TabelaModeloProdutoFornecedor);
		tabelaFornecedorProduto.getColumnModel().getColumn(0).setPreferredWidth(300);
		tabelaFornecedorProduto.getColumnModel().getColumn(1).setPreferredWidth(80);

		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloCadastroProdutoFornecedor> sorterBuscaFornecedor = new TableRowSorter<TabelaModeloCadastroProdutoFornecedor>(TabelaModeloProdutoFornecedor);
		tabelaFornecedorProduto.setRowSorter(sorterBuscaFornecedor);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaFornecedor.setRowFilter(null);
				}
				else {
					sorterBuscaFornecedor.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaFornecedor.setRowFilter(null);
					}
					else {
						sorterBuscaFornecedor.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_fornecedor teste = new Dao_consulta_dados_fornecedor();
    	List<Fornecedor> Consulta = teste.Consulta_Dados_Fornecedor_Lista();
		for (Fornecedor leitura : Consulta) {
			String fornecedorNomeTexto = leitura.getNome();
			String fornecedoeCNPJTexto = leitura.getCNPJ();
			
			CadastroProdutoFornecedorTabela listaProdutoFornecedor = new CadastroProdutoFornecedorTabela(fornecedorNomeTexto, fornecedoeCNPJTexto);
    		TabelaModeloProdutoFornecedor.addCadastroProdutoFornecedor(listaProdutoFornecedor);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFornecedorProduto.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		selecionar = new JButton("Selecionar");
		selecionar.setToolTipText("Seleciona o responsavel");
		selecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaFornecedorProduto.getSelectedRow() != -1 && tabelaFornecedorProduto.getSelectedRow() < TabelaModeloProdutoFornecedor.getRowCount()) {
					
					setFornecedorNome((String) tabelaFornecedorProduto.getModel().getValueAt(tabelaFornecedorProduto.getSelectedRow(),0));
					setFornecedorCNPJ((String) tabelaFornecedorProduto.getModel().getValueAt(tabelaFornecedorProduto.getSelectedRow(), 1));
					
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
			}
		});
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(voltar);
	}

	/*Metodos get e set*/
	private String fornecedorNome, fornecedorCNPJ;
	/*get e set Nome do fornecedor*/
	public String getFornecedorNome() {
		return fornecedorNome;
	}
	public void setFornecedorNome(String fornecedorNome) {
		this.fornecedorNome = fornecedorNome;
	}
	
	/*get e set CNPJ do fornecedor*/
	public String getFornecedorCNPJ() {
		return fornecedorCNPJ;
	}
	public void setFornecedorCNPJ(String fornecedorCNPJ) {
		this.fornecedorCNPJ = fornecedorCNPJ;
	}
}