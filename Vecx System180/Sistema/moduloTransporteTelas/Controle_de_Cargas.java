package moduloTransporteTelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloTransporteBD.Dao_consulta_dados_transportecarga;
import moduloTransporteBD.TransporteCarga;
import moduloTransporteTabelas.TabelaModeloTransporteCarga;
import moduloTransporteTabelas.TransporteCargaTabela;

public class Controle_de_Cargas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaControleCargas;
	private JTable tabelaControleCargas;
	private TabelaModeloTransporteCarga TabelaModelo;
	private JButton produtoBusca, exibir, atualizarTabela, voltar;
	private JTextField textBusca;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controle_de_Cargas frame = new Controle_de_Cargas();
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
	public Controle_de_Cargas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Controle_de_Cargas.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(true);
		setSize(1000, 600);
		
		telaControleCargas = new JPanel();
		telaControleCargas.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaControleCargas.setLayout(new BorderLayout(0, 10));
		setContentPane(telaControleCargas);
		
		JPanel panelTitulo = new JPanel();
		telaControleCargas.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelTitulo3 = new JPanel();
		panelTitulo.add(panelTitulo3);
		FlowLayout fl_panelTitulo3 = (FlowLayout) panelTitulo3.getLayout();
		fl_panelTitulo3.setAlignment(FlowLayout.LEFT);
		
		JLabel Icone = new JLabel("");
		Icone.setIcon(new ImageIcon(Controle_de_Cargas.class.getResource("/cImagens/Cadastro fornecedor.png")));
		Icone.setPreferredSize(new Dimension(30, 30));
		Icone.setHorizontalAlignment(SwingConstants.CENTER);
		Icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo3.add(Icone);
		
		JLabel labelControleCargas = new JLabel("Controle de cargas");
		labelControleCargas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panelTitulo3.add(labelControleCargas);
		
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
		fichaUsuario.setIcon(new ImageIcon(Controle_de_Cargas.class.getResource("/cImagens/Funcionario.png")));
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
		
		JPanel panelControleCargas = new JPanel();
		telaControleCargas.add(panelControleCargas, BorderLayout.CENTER);
		panelControleCargas.setLayout(new BorderLayout(0, 5));
		
		/*Busca na tabela da lista de controle de cargas*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelControleCargas.add(panelBusca, BorderLayout.NORTH);
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
		
		/*Tabela com a lista de controle de cargas*/
		TabelaModelo = new TabelaModeloTransporteCarga();
		JScrollPane scrollPaneControleCargas = new JScrollPane();
		panelControleCargas.add(scrollPaneControleCargas, BorderLayout.CENTER);
		tabelaControleCargas = new JTable();
		tabelaControleCargas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabelaControleCargas.setModel(TabelaModelo);
		scrollPaneControleCargas.setViewportView(tabelaControleCargas);
		tabelaControleCargas.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaControleCargas.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaControleCargas.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabelaControleCargas.getColumnModel().getColumn(3).setPreferredWidth(80);
		
		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloTransporteCarga> sorterBuscaTransporteCarga = new TableRowSorter<TabelaModeloTransporteCarga>(TabelaModelo);
		tabelaControleCargas.setRowSorter(sorterBuscaTransporteCarga);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaTransporteCarga.setRowFilter(null);
				}
				else {
					sorterBuscaTransporteCarga.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaTransporteCarga.setRowFilter(null);
					}
					else {
						sorterBuscaTransporteCarga.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_transportecarga teste = new Dao_consulta_dados_transportecarga();
    	List<TransporteCarga> Consulta = teste.Consulta_Dados_TransporteCarga_Lista();
		for (TransporteCarga leitura : Consulta) {
			TransporteCargaTabela listaFuncionarios = new TransporteCargaTabela(leitura.getCodigoTransporte(), leitura.getFuncionarioResponsavel(), leitura.getClienteNome(), leitura.getEstadoCarga());
    		TabelaModelo.addTransporteCarga(listaFuncionarios);
		}
		
		JPanel panelBotoes = new JPanel();
		telaControleCargas.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		exibir = new JButton("Exibir");
		exibir.setToolTipText("Exibe os dados da ficha do transporte");
		exibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabelaControleCargas.getSelectedRow() != -1 && tabelaControleCargas.getSelectedRow() < TabelaModelo.getRowCount()) {
					
					sessao.setTransporteCargasCodigo((String) tabelaControleCargas.getModel().getValueAt(tabelaControleCargas.getSelectedRow(),0));
					sessao.setTransporteCargasFuncionario((String) tabelaControleCargas.getModel().getValueAt(tabelaControleCargas.getSelectedRow(), 1));
					sessao.setTransporteCargasCliente((String) tabelaControleCargas.getModel().getValueAt(tabelaControleCargas.getSelectedRow(), 2));
					
					Controle_de_Cargas_Ficha exibeFichaCargas = new Controle_de_Cargas_Ficha();
					exibeFichaCargas.setVisible(true);
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
		
		atualizarTabela = new JButton("Atualizar tabela");
		atualizarTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controle_de_Cargas reabrirTela = new Controle_de_Cargas();
				reabrirTela.setVisible(true);
				dispose();
			}
		});
		atualizarTabela.setToolTipText("Atualiza a tabela");
		atualizarTabela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(atualizarTabela);
		
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