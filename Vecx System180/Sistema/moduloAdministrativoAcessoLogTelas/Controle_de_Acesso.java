package moduloAdministrativoAcessoLogTelas;

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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloAdministrativoAcessoLogBD.AcessoLog;
import moduloAdministrativoAcessoLogBD.Dao_consulta_dados_acessolog_lista;
import moduloAdministrativoAcessoLogTabelas.ControleAcessoTabela;
import moduloAdministrativoAcessoLogTabelas.TabelaModeloControleAcesso;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Controle_de_Acesso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaControleAcesso;
	private JTable tabelaControleAcesso;
	private TabelaModeloControleAcesso TabelaModelo;
	private JButton produtoBusca, voltar, exibir;
	private JTextField textBusca;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controle_de_Acesso frame = new Controle_de_Acesso();
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
	public Controle_de_Acesso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Controle_de_Acesso.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(true);
		setSize(1000, 600);
		
		telaControleAcesso = new JPanel();
		telaControleAcesso.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaControleAcesso.setLayout(new BorderLayout(0, 10));
		setContentPane(telaControleAcesso);
		
		JPanel panelTitulo = new JPanel();
		telaControleAcesso.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelTitulo2 = new JPanel();
		panelTitulo.add(panelTitulo2);
		FlowLayout fl_panelTitulo2 = (FlowLayout) panelTitulo2.getLayout();
		fl_panelTitulo2.setAlignment(FlowLayout.LEFT);
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Controle_de_Acesso.class.getResource("/cImagens/Historico de acesso.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo2.add(icone);
		
		JLabel labelControleAcesso = new JLabel("Controle de acesso ao sistema");
		labelControleAcesso.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panelTitulo2.add(labelControleAcesso);
		
		Sessao sessao = Sessao.getInstance();
		String nome = sessao.getNome();
		String cargo = sessao.getCargo();
		String codigo = sessao.getCodigo();
		
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
				sessao.setCodigoFuncionario(codigo);
				sessao.setNomeFuncionario(nome);
				sessao.setCargoFuncionario(cargo);
				
				Ficha_do_Funcionario_Exibicao FichaFuncionario = new Ficha_do_Funcionario_Exibicao();
				FichaFuncionario.setVisible(true);
			}
		});
		fichaUsuario.setPreferredSize(new Dimension(30, 30));
		fichaUsuario.setIcon(new ImageIcon(Controle_de_Acesso.class.getResource("/cImagens/Funcionario.png")));
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
		
		/*Parte da lista de controle de acesso*/
		JPanel panelControleAcesso = new JPanel();
		telaControleAcesso.add(panelControleAcesso, BorderLayout.CENTER);
		panelControleAcesso.setLayout(new BorderLayout(0, 5));
		
		/*Busca na tabela da lista de controle de acesso*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelControleAcesso.add(panelBusca, BorderLayout.NORTH);
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
		
		/*Tabela com a lista de controle de acesso*/
		TabelaModelo = new TabelaModeloControleAcesso();
		JScrollPane scrollPaneListaControleAcesso = new JScrollPane();
		panelControleAcesso.add(scrollPaneListaControleAcesso, BorderLayout.CENTER);
		tabelaControleAcesso = new JTable();
		tabelaControleAcesso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabelaControleAcesso.setModel(TabelaModelo);
		scrollPaneListaControleAcesso.setViewportView(tabelaControleAcesso);
		tabelaControleAcesso.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaControleAcesso.getColumnModel().getColumn(1).setPreferredWidth(250);
		tabelaControleAcesso.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabelaControleAcesso.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloControleAcesso> sorterBuscaControleAcesso = new TableRowSorter<TabelaModeloControleAcesso>(TabelaModelo);
		tabelaControleAcesso.setRowSorter(sorterBuscaControleAcesso);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaControleAcesso.setRowFilter(null);
				}
				else {
					sorterBuscaControleAcesso.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaControleAcesso.setRowFilter(null);
					}
					else {
						sorterBuscaControleAcesso.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_acessolog_lista teste = new Dao_consulta_dados_acessolog_lista();
    	List<AcessoLog> Consulta = teste.Consulta_Dados_AcessoLog_Lista();
		for (AcessoLog leitura : Consulta) {
			/*Codigo de registro*/
			String codigoRegistro = leitura.getCodigoResgistro();
			
			/*Nome do funcionario*/
			String nomeFuncionario = leitura.getFuncionarioNome();
			
			/*Cargo do funcionario*/
			String cargoFuncionario = leitura.getCargo();
			
			/*Data e hora de acesso log*/
			Date dataAcesso = leitura.getDataAcesso();
    		SimpleDateFormat dataAcessoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataAcessoUsuario = dataAcessoFormato.format(dataAcesso);
    		Time horaAcesso = leitura.getHoraAcesso();
    		SimpleDateFormat horaAcessoFormato = new SimpleDateFormat("HH:mm");
    		String horaAcessoUsuario = horaAcessoFormato.format(horaAcesso);
    		String dataHoraAcesso = dataAcessoUsuario + " " + horaAcessoUsuario;
    		
    		/*Codigo de tabela do acesso log*/
			ControleAcessoTabela listaAcessoLog = new ControleAcessoTabela(codigoRegistro, nomeFuncionario, cargoFuncionario, dataHoraAcesso);
    		TabelaModelo.addControleAcesso(listaAcessoLog);
		}
		
		JPanel panelBotoes = new JPanel();
		telaControleAcesso.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		exibir = new JButton("Exibir");
		exibir.setToolTipText("Exibe a ficha com os dados do acesso ao sistema");
		exibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaControleAcesso.getSelectedRow() != -1 && tabelaControleAcesso.getSelectedRow() < TabelaModelo.getRowCount()) {
					
					sessao.setAcessoCodigo((String) tabelaControleAcesso.getModel().getValueAt(tabelaControleAcesso.getSelectedRow(),0));
					sessao.setAcessoFuncionario((String) tabelaControleAcesso.getModel().getValueAt(tabelaControleAcesso.getSelectedRow(), 1));
					sessao.setAcessoCargo((String) tabelaControleAcesso.getModel().getValueAt(tabelaControleAcesso.getSelectedRow(), 2));
					
					Controle_de_Acesso_Ficha exibeFichaAcesso = new Controle_de_Acesso_Ficha();
					exibeFichaAcesso.setVisible(true);
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
				setVisible(false); 
	            dispose();
			}
		});
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(voltar);
	}
}