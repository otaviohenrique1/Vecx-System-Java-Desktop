package moduloProdutoDescontoPromocaoTelas;

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
import moduloFuncionarioBD.Dao_consulta_dados_funcionario;
import moduloFuncionarioBD.Funcionario;
import moduloProdutoDescontoPromocaoTabelas.DescontoResonsavelTabela;
import moduloProdutoDescontoPromocaoTabelas.TabelaModeloDescontoResponsavel;

public class Descontos_e_Promocoes_Adicionar_Responsavel extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFuncionarioResponsavel;
	private JTable tabelaFuncionarioResponsavel;
	private TabelaModeloDescontoResponsavel TabelaModeloResponsavel;
	private JButton produtoBusca, selecionar, voltar;
	private JTextField textBusca;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Descontos_e_Promocoes_Adicionar_Responsavel frame = new Descontos_e_Promocoes_Adicionar_Responsavel();
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
	public Descontos_e_Promocoes_Adicionar_Responsavel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Descontos_e_Promocoes_Adicionar_Responsavel.class.getResource("/cImagens/Logo Janela.PNG")));
		setModal(true);
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setResizable(false);
		setSize(600, 400);
		
		telaFuncionarioResponsavel = new JPanel();
		telaFuncionarioResponsavel.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFuncionarioResponsavel.setLayout(new BorderLayout(0, 10));
		setContentPane(telaFuncionarioResponsavel);
		
		JPanel panelTitulo = new JPanel();
		telaFuncionarioResponsavel.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel Icone = new JLabel("");
		panelTitulo.add(Icone);
		Icone.setIcon(new ImageIcon(Descontos_e_Promocoes_Adicionar_Responsavel.class.getResource("/cImagens/Adicionar responsavel.PNG")));
		Icone.setPreferredSize(new Dimension(30, 30));
		Icone.setHorizontalAlignment(SwingConstants.CENTER);
		Icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFuncionarioResponsavel = new JLabel("Selecionar responsavel");
		panelTitulo.add(labelFuncionarioResponsavel);
		labelFuncionarioResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JPanel panelFuncionarioResponsavel = new JPanel();
		telaFuncionarioResponsavel.add(panelFuncionarioResponsavel, BorderLayout.CENTER);
		panelFuncionarioResponsavel.setLayout(new BorderLayout(0, 5));

		/*Busca na tabela com a lista de funcionarios responsaveis*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelFuncionarioResponsavel.add(panelBusca, BorderLayout.NORTH);
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
		
		/*Tabela com a lista de funcionarios responsaveis*/
		JScrollPane scrollPaneFuncionarioResponsavel = new JScrollPane();
		panelFuncionarioResponsavel.add(scrollPaneFuncionarioResponsavel);
		TabelaModeloResponsavel = new TabelaModeloDescontoResponsavel();
		tabelaFuncionarioResponsavel = new JTable();
		scrollPaneFuncionarioResponsavel.setViewportView(tabelaFuncionarioResponsavel);
		tabelaFuncionarioResponsavel.setModel(TabelaModeloResponsavel);
		tabelaFuncionarioResponsavel.getColumnModel().getColumn(0).setPreferredWidth(120);
		tabelaFuncionarioResponsavel.getColumnModel().getColumn(1).setPreferredWidth(300);
		tabelaFuncionarioResponsavel.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloDescontoResponsavel> sorterBuscaDescontoResponsavel = new TableRowSorter<TabelaModeloDescontoResponsavel>(TabelaModeloResponsavel);
		tabelaFuncionarioResponsavel.setRowSorter(sorterBuscaDescontoResponsavel);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaDescontoResponsavel.setRowFilter(null);
				}
				else {
					sorterBuscaDescontoResponsavel.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaDescontoResponsavel.setRowFilter(null);
					}
					else {
						sorterBuscaDescontoResponsavel.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_funcionario teste = new Dao_consulta_dados_funcionario();
    	List<Funcionario> Consulta = teste.Consulta_Dados_Funcionario_Lista();
		for (Funcionario leitura : Consulta) {
			String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
			String nomeFuncionarioTexto = leitura.getNome();
			String cargoFuncionarioTexto = leitura.getCargo();
			
			DescontoResonsavelTabela listaDescontoResonsavel = new DescontoResonsavelTabela(codigoFuncionarioTexto, nomeFuncionarioTexto, cargoFuncionarioTexto);
    		TabelaModeloResponsavel.addDescontoResonsavel(listaDescontoResonsavel);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFuncionarioResponsavel.add(panelBotoes, BorderLayout.SOUTH);
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
				if (tabelaFuncionarioResponsavel.getSelectedRow() != -1 && tabelaFuncionarioResponsavel.getSelectedRow() < TabelaModeloResponsavel.getRowCount()) {
					
					setCodigoFuncionario((String) tabelaFuncionarioResponsavel.getModel().getValueAt(tabelaFuncionarioResponsavel.getSelectedRow(),0));
					setNomeFuncionario((String) tabelaFuncionarioResponsavel.getModel().getValueAt(tabelaFuncionarioResponsavel.getSelectedRow(), 1));
					setCargoFuncionario((String) tabelaFuncionarioResponsavel.getModel().getValueAt(tabelaFuncionarioResponsavel.getSelectedRow(), 2));
					
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
	private String nomeFuncionario, codigoFuncionario, cargoFuncionario;
	/*get e set Nome do funcionario*/
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	/*get e set Codigo do funcionario*/
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	
	/*get e set Codigo do funcionario*/
	public String getCargoFuncionario() {
		return cargoFuncionario;
	}
	public void setCargoFuncionario(String cargoFuncionario) {
		this.cargoFuncionario = cargoFuncionario;
	}
}