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
import moduloClienteBD.Cliente;
import moduloClienteBD.Dao_consulta_dados_cliente;
import moduloTransporteTabelas.TabelaModeloTransporteCargasCliente;
import moduloTransporteTabelas.TransporteCargasClienteTabela;

public class Cadastro_de_TransporteCargas_Adicionar_Cliente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFuncionarioCliente;
	private JTable tabelaCliente;
	private TabelaModeloTransporteCargasCliente TabelaModeloCliente;
	private JButton produtoBusca, selecionar, voltar;
	private JTextField textBusca;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_de_TransporteCargas_Adicionar_Cliente frame = new Cadastro_de_TransporteCargas_Adicionar_Cliente();
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
	public Cadastro_de_TransporteCargas_Adicionar_Cliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro_de_TransporteCargas_Adicionar_Cliente.class.getResource("/cImagens/Logo Janela.PNG")));
		setModal(true);
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setResizable(false);
		setSize(600, 400);
		
		telaFuncionarioCliente = new JPanel();
		telaFuncionarioCliente.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFuncionarioCliente.setLayout(new BorderLayout(0, 10));
		setContentPane(telaFuncionarioCliente);
		
		JPanel panelTitulo = new JPanel();
		telaFuncionarioCliente.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel Icone = new JLabel("");
		panelTitulo.add(Icone);
		Icone.setIcon(new ImageIcon(Cadastro_de_TransporteCargas_Adicionar_Cliente.class.getResource("/cImagens/Adicionar cliente.PNG")));
		Icone.setPreferredSize(new Dimension(30, 30));
		Icone.setHorizontalAlignment(SwingConstants.CENTER);
		Icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFuncionarioCliente = new JLabel("Selecionar cliente");
		panelTitulo.add(labelFuncionarioCliente);
		labelFuncionarioCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JPanel panelFuncionarioResponsavel = new JPanel();
		telaFuncionarioCliente.add(panelFuncionarioResponsavel, BorderLayout.CENTER);
		panelFuncionarioResponsavel.setLayout(new BorderLayout(0, 5));

		/*Busca na tabela com a lista de clientes*/
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
		
		/*Tabela com a lista de clientes*/
		JScrollPane scrollPaneTabelaCliente = new JScrollPane();
		panelFuncionarioResponsavel.add(scrollPaneTabelaCliente);
		TabelaModeloCliente = new TabelaModeloTransporteCargasCliente();
		tabelaCliente = new JTable();
		scrollPaneTabelaCliente.setViewportView(tabelaCliente);
		tabelaCliente.setModel(TabelaModeloCliente);
		tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(300);
		tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(80);

		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloTransporteCargasCliente> sorterBuscaEstoque = new TableRowSorter<TabelaModeloTransporteCargasCliente>(TabelaModeloCliente);
		tabelaCliente.setRowSorter(sorterBuscaEstoque);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaEstoque.setRowFilter(null);
				}
				else {
					sorterBuscaEstoque.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaEstoque.setRowFilter(null);
					}
					else {
						sorterBuscaEstoque.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_cliente teste = new Dao_consulta_dados_cliente();
    	List<Cliente> Consulta = teste.Consulta_Dados_Cliente_Lista();
		for (Cliente leitura : Consulta) {
			String clienteNomeTexto = leitura.getNome();
			String clienteCPFTexto = leitura.getCPF();
			String clienteRGTexto = leitura.getRG();
			
			TransporteCargasClienteTabela listaTransporteCargasCliente = new TransporteCargasClienteTabela(clienteNomeTexto, clienteCPFTexto, clienteRGTexto);
			TabelaModeloCliente.addTransporteCargasCliente(listaTransporteCargasCliente);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFuncionarioCliente.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		selecionar = new JButton("Selecionar");
		selecionar.setToolTipText("Seleciona o cliente");
		selecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaCliente.getSelectedRow() != -1 && tabelaCliente.getSelectedRow() < TabelaModeloCliente.getRowCount()) {
					
					String clienteNome = (String) tabelaCliente.getModel().getValueAt(tabelaCliente.getSelectedRow(),0);
					String clienteCPF = (String) tabelaCliente.getModel().getValueAt(tabelaCliente.getSelectedRow(), 1);
					
					Dao_consulta_dados_cliente ConsultaClienteTransporte = new Dao_consulta_dados_cliente();
			    	List<Cliente> Consulta = ConsultaClienteTransporte.Consulta_Dados_Cliente_Transporte(clienteNome, clienteCPF);
					for (Cliente leitura : Consulta) {
						String bairroCliente = leitura.getBairro();
						setClienteBairro(bairroCliente);
						
						String enderecoCliente = leitura.getEndereco();
						setClienteEndereco(enderecoCliente);
						
						String numeroCliente = leitura.getNumero();
						setClienteNumero(numeroCliente);
						
						String cidadeCliente = leitura.getCidade();
						setClienteCidade(cidadeCliente);
					}
					
					setNomeCliente((String) tabelaCliente.getModel().getValueAt(tabelaCliente.getSelectedRow(),0));
					setClienteCPF((String) tabelaCliente.getModel().getValueAt(tabelaCliente.getSelectedRow(), 1));
					setClienteRG((String) tabelaCliente.getModel().getValueAt(tabelaCliente.getSelectedRow(), 2));
					
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
	private String nomeCliente, clienteCPF, clienteRG, clienteCidade, clienteBairro, clienteNumero, clienteEndereco;
	/*get e set Nome do cliente*/
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	/*get e set CPF do cliente*/
	public String getClienteCPF() {
		return clienteCPF;
	}
	public void setClienteCPF(String clienteCPF) {
		this.clienteCPF = clienteCPF;
	}
	
	/*get e set RG do cliente*/
	public String getClienteRG() {
		return clienteRG;
	}
	public void setClienteRG(String clienteRG) {
		this.clienteRG = clienteRG;
	}
	
	/*get e set Cidade do cliente*/
	public String getClienteCidade() {
		return clienteCidade;
	}
	public void setClienteCidade(String clienteCidade) {
		this.clienteCidade = clienteCidade;
	}
	
	/*get e set Bairro do cliente*/
	public String getClienteBairro() {
		return clienteBairro;
	}
	public void setClienteBairro(String clienteBairro) {
		this.clienteBairro = clienteBairro;
	}
	
	/*get e set Numero da casa do cliente*/
	public String getClienteNumero() {
		return clienteNumero;
	}
	public void setClienteNumero(String clienteNumero) {
		this.clienteNumero = clienteNumero;
	}
	
	/*get e set Endereço do cliente*/
	public String getClienteEndereco() {
		return clienteEndereco;
	}
	public void setClienteEndereco(String clienteEndereco) {
		this.clienteEndereco = clienteEndereco;
	}
}