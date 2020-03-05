package moduloFinanceiroVendaTelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import moduloAdministrativo.DadosLoja;
import moduloAdministrativo.Dao_consulta_dados_loja;
import moduloClienteBD.Cliente;
import moduloClienteBD.Dao_consulta_dados_cliente;
import moduloClienteTelas.Cadastro_de_Cliente;
import moduloFinanceiroNotaFiscalBD.Dao_inserir_dados_nota_fiscal;
import moduloFinanceiroNotaFiscalBD.NotaFiscal;
import moduloFinanceiroOutrasClasses.Adicionar_Desconto;
import moduloFinanceiroOutrasClasses.Adicionar_Preco_Parcelas;
import moduloFinanceiroOutrasClasses.Calculadora;
import moduloFinanceiroOutrasClasses.Dao_alterar_dados_produto_quantidade;
import moduloFinanceiroVendaBD.Dao_inserir_dados_venda;
import moduloFinanceiroVendaBD.Dao_inserir_dados_venda_historico;
import moduloFinanceiroVendaBD.Dao_inserir_dados_venda_produtos;
import moduloFinanceiroVendaBD.Venda;
import moduloFinanceiroVendaBD.VendaHistorico;
import moduloFinanceiroVendaBD.VendaProdutos;
import moduloFinanceiroVendaTabelas.TabelaModeloVenda;
import moduloFinanceiroVendaTabelas.VendaTabela;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoBD.EstoqueProdutos;
import moduloProdutoBD.Produto;

public class Vendas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaVenda;
	private JComboBox<String> comboBoxTipoPagamento, comboBoxMetodoPagamento;
	private JTextField textNomeCliente, textCodigoCliente;
	private JFormattedTextField textDataVenda, textHoraVenda, textCPF;
	private JCheckBox checkBoxNotaFiscalPaulista;
	private JTable tabelaListaProdutos;
	private TabelaModeloVenda TabelaModelo;
	private JButton dadosNotaFiscal, buscaCliente, calculadora, finalizar, adicionar;
	private JButton cancelar, removerProduto, voltar, limpar;
	private JLabel precoTotal, precoParcelado, precoDesconto, labelPrecoDesconto;
	Vendas_Adicionar_Dados_Nota_Fiscal dadosCadastroNotaFiscal;
	Venda cadastrarVenda;
	VendaHistorico cadastrarVendaHistorico;
	NotaFiscal cadastrarNotaFiscal;
	String dataCompra, horaCompra, notaFiscalVenda;
	SimpleDateFormat dataFormato, horaFormato;
	Date data;
	Time hora;
	Dao_inserir_dados_venda savaDados;
	Dao_inserir_dados_venda_historico savaHistoricoDados;
	Dao_inserir_dados_nota_fiscal savaNotaFiscalDados;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendas frame = new Vendas();
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
	public Vendas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vendas.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(true);
		setSize(1000, 600);
		
		telaVenda = new JPanel();
		telaVenda.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaVenda);
		telaVenda.setLayout(new BoxLayout(telaVenda, BoxLayout.Y_AXIS));
		
		MaskFormatter dataMascara = null;
		try{
			dataMascara = new MaskFormatter("##/##/####");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		MaskFormatter horaMascara = null;
		try{
			horaMascara = new MaskFormatter("##:##");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		MaskFormatter numeroCPFMascara = null;
		try{
			numeroCPFMascara = new MaskFormatter("###.###.###-#");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		JPanel panelTelaVenda = new JPanel();
		telaVenda.add(panelTelaVenda);
		panelTelaVenda.setLayout(new BorderLayout(0, 10));
		
		JPanel panelTitulo = new JPanel();
		panelTelaVenda.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Vendas.class.getResource("/cImagens/Venda.png")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelVendaTitulo = new JLabel("Venda");
		panelTitulo2.add(labelVendaTitulo);
		labelVendaTitulo.setToolTipText("");
		labelVendaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		String nomeUsuario = sessao.getNome();
		String cargoUsuario = sessao.getCargo();
		String codigoUsuario = sessao.getCodigo();
		
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
				sessao.setCodigoFuncionario(codigoUsuario);
				sessao.setNomeFuncionario(nomeUsuario);
				sessao.setCargoFuncionario(cargoUsuario);
				
				Ficha_do_Funcionario_Exibicao FichaFuncionario = new Ficha_do_Funcionario_Exibicao();
				FichaFuncionario.setVisible(true);
			}
		});
		fichaUsuario.setPreferredSize(new Dimension(30, 30));
		fichaUsuario.setIcon(new ImageIcon(Vendas.class.getResource("/cImagens/Funcionario.png")));
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
		
		JScrollPane scrollPaneVendas = new JScrollPane();
		scrollPaneVendas.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneVendas.getHorizontalScrollBar().setUnitIncrement(10);
		panelTelaVenda.add(scrollPaneVendas, BorderLayout.CENTER);
		
		JPanel panelVenda = new JPanel();
		scrollPaneVendas.setViewportView(panelVenda);
		panelVenda.setLayout(new BorderLayout(0, 10));
		
		JPanel panelDados = new JPanel();
		panelVenda.add(panelDados, BorderLayout.NORTH);
		panelDados.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneDados = new JScrollPane();
		scrollPaneDados.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneDados.getHorizontalScrollBar().setUnitIncrement(10);
		panelDados.add(scrollPaneDados, BorderLayout.CENTER);
		
		JPanel panelDados2 = new JPanel();
		scrollPaneDados.setViewportView(panelDados2);
		panelDados2.setLayout(new BoxLayout(panelDados2, BoxLayout.Y_AXIS));
		
		JPanel panelDadosCliente = new JPanel();
		panelDadosCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDados2.add(panelDadosCliente);
		panelDadosCliente.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDadosCliente2 = new JPanel();
		panelDadosCliente.add(panelDadosCliente2);
		panelDadosCliente2.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelNome_CPF = new JPanel();
		panelDadosCliente2.add(panelNome_CPF);
		panelNome_CPF.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNome = new JPanel();
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome_CPF.add(panelNome);
		panelNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeCliente = new JLabel("Nome do cliente");
		panelNome.add(labelNomeCliente);
		labelNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textNomeCliente = new JTextField();
		panelNome.add(textNomeCliente);
		textNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNomeCliente.setColumns(10);
		
		JPanel panelCPF_Busca_NotaFiscal = new JPanel();
		panelNome_CPF.add(panelCPF_Busca_NotaFiscal);
		panelCPF_Busca_NotaFiscal.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCPF = new JPanel();
		panelCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCPF_Busca_NotaFiscal.add(panelCPF);
		panelCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPF = new JLabel("CPF do cliente");
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCPF.add(labelCPF);
		
		textCPF = new JFormattedTextField(numeroCPFMascara);
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCPF.setColumns(10);
		panelCPF.add(textCPF);
		
		JPanel panelClienteBusca = new JPanel();
		panelCPF_Busca_NotaFiscal.add(panelClienteBusca);
		panelClienteBusca.setLayout(new GridLayout(0, 1, 0, 0));
		
		buscaCliente = new JButton("Busca de cliente");
		panelClienteBusca.add(buscaCliente);
		buscaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String consultaCPFCliente = textCPF.getText();
				Dao_consulta_dados_cliente consultaCliente = new Dao_consulta_dados_cliente();
				String consultaTelefone = null, consultaCidade = null, consultaEndereco = null, consultaNumero = null, consultaBairro = null;
				String consultaCelular = null, consultaEstado = null, consultaCEP = null, consultaNome = null, consultaCodigoCliente = null;
				List<Cliente> Consulta = consultaCliente.Consulta_Dados_Cliente_Venda_Dados(consultaCPFCliente);
				for (Cliente leitura : Consulta) {
					consultaNome = leitura.getNome();
					consultaCodigoCliente = leitura.getCodigoCliente();
					consultaTelefone = leitura.getTelefone1();
					consultaCelular = leitura.getCelular1();
					consultaCidade = leitura.getCidade();
					consultaEndereco = leitura.getEndereco();
					consultaNumero = leitura.getNumero();
					consultaBairro = leitura.getBairro();
					consultaEstado = leitura.getEstado();
					consultaCEP = leitura.getCEP();
				}
				if (consultaTelefone == null || consultaCidade == null || consultaEndereco == null || consultaNumero == null || consultaBairro == null ||
					consultaCelular == null || consultaCEP == null || consultaEstado == null || consultaNome == null || consultaCodigoCliente == null) {
						String menssagemTitulo = "Cliente não cadastrado";
						String menssagemConteudo = "Deseja criar um cadastro ?";
						Tela_que_Exibe_Menssagem_Sim_Nao telaVendaCliente = new Tela_que_Exibe_Menssagem_Sim_Nao(menssagemTitulo, menssagemConteudo);
						telaVendaCliente.setVisible(true);
						String respostaTexto = telaVendaCliente.getResposta();
						if (respostaTexto != null) {
							if (respostaTexto.equals("Sim")) {
								Cadastro_de_Cliente cadastroCliente = new Cadastro_de_Cliente();
								cadastroCliente.setVisible(true);
							}
						}
						String encontrou = "Não encontrou";
						setDadosConsultaEncontrados(encontrou);
				}
				else {
					String encontrou = "Encontrou";
					String menssagemConteudo = "Cliente encontrado";
					Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
					menssagemAviso.setVisible(true);
					setNomeCliente(consultaNome);
					textNomeCliente.setText(consultaNome);
					setCodigoCliente(consultaCodigoCliente);
					textCodigoCliente.setText(consultaCodigoCliente);
					setDadosConsultaEncontrados(encontrou);
					setTelefoneCliente(consultaTelefone);
					setCidadeCliente(consultaCidade);
					setEnderecoCliente(consultaEndereco);
					setNumeroCliente(consultaNumero);
					setBairroCliente(consultaBairro);
					setCEPCliente(consultaCEP);
					setCelularCliente(consultaCelular);
					setEstadoCliente(consultaEstado);
				}
			}
		});
		buscaCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		dadosNotaFiscal = new JButton("Dados da nota fiscal");
		dadosNotaFiscal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemTitulo = "Dados na nota fiscal";
				String menssagemConteudo = "Deseja cadastrar os dados na nota fiscal ?";
				Tela_que_Exibe_Menssagem_Sim_Nao telaVendaCliente = new Tela_que_Exibe_Menssagem_Sim_Nao(menssagemTitulo, menssagemConteudo);
				telaVendaCliente.setVisible(true);
				String respostaTexto = telaVendaCliente.getResposta();
				if (respostaTexto != null) {
					if (respostaTexto.equals("Sim")) {
						dadosCadastroNotaFiscal = new Vendas_Adicionar_Dados_Nota_Fiscal();
				    	dadosCadastroNotaFiscal.setVisible(true);
			    		String telefoneNotaFiscal = dadosCadastroNotaFiscal.getTelefoneCliente();
				    	String celularNotaFiscal =  dadosCadastroNotaFiscal.getCelularCliente();
				    	String enderecoNotaFiscal =  dadosCadastroNotaFiscal.getEnderecoCliente();
				    	String numeroNotaFiscal =  dadosCadastroNotaFiscal.getNumeroCliente();
				    	String cepNotaFiscal =  dadosCadastroNotaFiscal.getCEPCliente();
				    	String bairroNotaFiscal =  dadosCadastroNotaFiscal.getBairroCliente();
				    	String estadoNotaFiscal =  dadosCadastroNotaFiscal.getEstadoCliente();
					    String cidadeNotaFiscal =  dadosCadastroNotaFiscal.getCidadeCliente();
			    		
					    String dadosNotaFiscalTexto = "novoCadastro";
					    setNotaFiscalCadastro(dadosNotaFiscalTexto);
					    setTelefoneCliente(telefoneNotaFiscal);
				    	setCelularCliente(celularNotaFiscal);
				    	setEnderecoCliente(enderecoNotaFiscal);
				    	setNumeroCliente(numeroNotaFiscal);
				    	setCEPCliente(cepNotaFiscal);
				    	setBairroCliente(bairroNotaFiscal);
				    	setEstadoCliente(estadoNotaFiscal);
					    setCidadeCliente(cidadeNotaFiscal);
					}
				}
			}
		});
		dadosNotaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelClienteBusca.add(dadosNotaFiscal);
		
		JPanel panelCodigo_Pagamento_Data_Hora = new JPanel();
		panelDadosCliente2.add(panelCodigo_Pagamento_Data_Hora);
		panelCodigo_Pagamento_Data_Hora.setLayout(new GridLayout(0, 6, 5, 0));
		
		JPanel panelCodigoCliente = new JPanel();
		panelCodigoCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigo_Pagamento_Data_Hora.add(panelCodigoCliente);
		panelCodigoCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoCliente = new JLabel("Codigo do cliente");
		labelCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCodigoCliente.add(labelCodigoCliente);
		
		textCodigoCliente = new JTextField();
		textCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCodigoCliente.setColumns(10);
		panelCodigoCliente.add(textCodigoCliente);
		
		JPanel panelTipoPagamento = new JPanel();
		panelTipoPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigo_Pagamento_Data_Hora.add(panelTipoPagamento);
		panelTipoPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoPagamento = new JLabel("Tipo de pagamento");
		panelTipoPagamento.add(labelTipoPagamento);
		labelTipoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		comboBoxTipoPagamento = new JComboBox<String>();
		comboBoxTipoPagamento.addItem("Escolha");
		comboBoxTipoPagamento.addItem("Dinheiro");
		comboBoxTipoPagamento.addItem("Cartão de credito");
		comboBoxTipoPagamento.addItem("Cartão de debito");
		comboBoxTipoPagamento.addItem("Cheque");
		comboBoxTipoPagamento.addItem("Carnê");
		panelTipoPagamento.add(comboBoxTipoPagamento);
		comboBoxTipoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panelMetodoPagamento = new JPanel();
		panelMetodoPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigo_Pagamento_Data_Hora.add(panelMetodoPagamento);
		panelMetodoPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelMetodoPagamento = new JLabel("Metodo de pagamento");
		labelMetodoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelMetodoPagamento.add(labelMetodoPagamento);
		
		comboBoxMetodoPagamento = new JComboBox<String>();
		comboBoxMetodoPagamento.setMaximumRowCount(3);
		comboBoxMetodoPagamento.addItem("Escolha");
		comboBoxMetodoPagamento.addItem("À vista");
		comboBoxMetodoPagamento.addItem("A prazo");
		comboBoxMetodoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelMetodoPagamento.add(comboBoxMetodoPagamento);
		
		JPanel panelDataVenda = new JPanel();
		panelDataVenda.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigo_Pagamento_Data_Hora.add(panelDataVenda);
		panelDataVenda.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataVenda = new JLabel("Data da venda");
		panelDataVenda.add(labelDataVenda);
		labelDataVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textDataVenda = new JFormattedTextField(dataMascara);
		panelDataVenda.add(textDataVenda);
		textDataVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDataVenda.setColumns(10);
		
		JPanel panelHoraVenda = new JPanel();
		panelHoraVenda.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigo_Pagamento_Data_Hora.add(panelHoraVenda);
		panelHoraVenda.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraVenda = new JLabel("Hora da venda");
		labelHoraVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelHoraVenda.add(labelHoraVenda);
		
		textHoraVenda = new JFormattedTextField(horaMascara);
		textHoraVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textHoraVenda.setColumns(10);
		panelHoraVenda.add(textHoraVenda);
		
		JPanel panelNotaFiscalPaulista = new JPanel();
		panelNotaFiscalPaulista.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigo_Pagamento_Data_Hora.add(panelNotaFiscalPaulista);
		panelNotaFiscalPaulista.setLayout(new GridLayout(0, 1, 0, 0));
		
		checkBoxNotaFiscalPaulista = new JCheckBox("Nota fiscal paulista");
		panelNotaFiscalPaulista.add(checkBoxNotaFiscalPaulista);
		checkBoxNotaFiscalPaulista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panelPrecoTotalVenda = new JPanel();
		panelDadosCliente2.add(panelPrecoTotalVenda);
		panelPrecoTotalVenda.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelPrecoTotal = new JPanel();
		panelPrecoTotalVenda.add(panelPrecoTotal);
		panelPrecoTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotal.setLayout(new GridLayout(0, 1, 0, 5));
		
		JLabel labelPrecoTotal = new JLabel("Pre\u00E7o total (R$):");
		labelPrecoTotal.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPrecoTotal.add(labelPrecoTotal);
		
		precoTotal = new JLabel("00.00");
		panelPrecoTotal.add(precoTotal);
		precoTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		precoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panelPrecoParcelado = new JPanel();
		panelPrecoParcelado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotalVenda.add(panelPrecoParcelado);
		panelPrecoParcelado.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoParcelado = new JLabel("Pre\u00E7o parcelado (A prazo) (R$):");
		labelPrecoParcelado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelPrecoParcelado.add(labelPrecoParcelado);
		
		precoParcelado = new JLabel("0 x 00.00");
		precoParcelado.setHorizontalAlignment(SwingConstants.RIGHT);
		precoParcelado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelPrecoParcelado.add(precoParcelado);
		
		JPanel panelPrecoDesconto = new JPanel();
		panelPrecoDesconto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotalVenda.add(panelPrecoDesconto);
		panelPrecoDesconto.setLayout(new GridLayout(0, 1, 0, 0));
		
		labelPrecoDesconto = new JLabel("Pre\u00E7o (R$) com 0% de desconto (\u00C0 vista):");
		panelPrecoDesconto.add(labelPrecoDesconto);
		labelPrecoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		precoDesconto = new JLabel("00.00");
		precoDesconto.setHorizontalAlignment(SwingConstants.RIGHT);
		precoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelPrecoDesconto.add(precoDesconto);
		
		comboBoxMetodoPagamento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent eventoItem) {
				if (eventoItem.getStateChange() == ItemEvent.SELECTED) {
                    if (comboBoxMetodoPagamento.getSelectedItem() == "À vista") {
                    	Adicionar_Desconto vendaDesconto = new Adicionar_Desconto();
                    	vendaDesconto.setVisible(true);
                    	double precoTotalVenda = Double.parseDouble(precoTotal.getText());
                    	double valorDescontoVenda = vendaDesconto.getValorDesconto();
                    	if (valorDescontoVenda == 0) {
                    		labelPrecoDesconto.setText("Preço (R$) com 0% desconto (À vista):");
							precoDesconto.setText("00.00");
						}
                    	else {
							double descontoTotal = ((precoTotalVenda * valorDescontoVenda)/100);
							double precoDescontoTotal = precoTotalVenda - descontoTotal;
							labelPrecoDesconto.setText("Preço (R$) com " + valorDescontoVenda + "% " + "desconto (À vista):");
							precoDesconto.setText("" + precoDescontoTotal);
							precoParcelado.setText("0 x 00.00");
							setPorcentagemDescontoValor(valorDescontoVenda);
							setDescontoPrecoTotal(precoDescontoTotal);
						}
                    	
					}
                    
                    if (comboBoxMetodoPagamento.getSelectedItem() == "A prazo") {
                    	Adicionar_Preco_Parcelas vendaPrecoParcelas = new Adicionar_Preco_Parcelas();
                    	vendaPrecoParcelas.setVisible(true);
                    	double jurosValor = vendaPrecoParcelas.getJurosValorVenda();
                    	int parcelasValor = vendaPrecoParcelas.getParcelaVenda();
                    	double precoTotalValor = Double.parseDouble(precoTotal.getText());
                    	if (jurosValor == 0) {
                    		precoParcelado.setText("0 x 00.00");
						}
                    	else if (parcelasValor == 0) {
                    		precoParcelado.setText("0 x 00.00");
						}
                    	else if (jurosValor == 0 || parcelasValor == 0) {
                    		precoParcelado.setText("0 x 00.00");
						}
                    	else {
                    		double jurosTotal = ((precoTotalValor * jurosValor)/100);
    						double precoParceladoValor = ((precoTotalValor + jurosTotal)/parcelasValor);
                        	precoParcelado.setText(parcelasValor + " x " + precoParceladoValor);
                        	labelPrecoDesconto.setText("Preço (R$) com 0% desconto (À vista)");
							precoDesconto.setText("00.00");
							setQuantidadeParcelasVenda(parcelasValor);
							setPrecoTotalParcelado(precoParceladoValor);
						}
					}
				}
			}
		});
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelVenda.add(panelProdutos);
		panelProdutos.setLayout(new BorderLayout(0, 0));
		
		//Modelo de tabela usada e a criação da tabela
		TabelaModelo = new TabelaModeloVenda();
		JScrollPane scrollPaneTabela = new JScrollPane();
		panelProdutos.add(scrollPaneTabela, BorderLayout.CENTER);
		scrollPaneTabela.getVerticalScrollBar().setUnitIncrement(10);//Velocidade de rolagem do jscrollbar
		scrollPaneTabela.getHorizontalScrollBar().setUnitIncrement(10);
		tabelaListaProdutos = new JTable();
		tabelaListaProdutos.setModel(TabelaModelo);
		scrollPaneTabela.setViewportView(tabelaListaProdutos);
		//Tamanho das colunas da tabela
		tabelaListaProdutos.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaListaProdutos.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaListaProdutos.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabelaListaProdutos.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabelaListaProdutos.getColumnModel().getColumn(4).setPreferredWidth(40);
		
		JPanel panelBotoes = new JPanel();
		panelTelaVenda.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		finalizar = new JButton("Finalizar");
		finalizar.setToolTipText("Finaliza a venda e gera a nota fiscal");
		finalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if (textNomeCliente.getText().isEmpty() || textNomeCliente.getText().length() <= 0 ||
					comboBoxMetodoPagamento.getSelectedItem() == "Escolha" ||
					comboBoxTipoPagamento.getSelectedItem() == "Escolha" ||
					textDataVenda.getText().replaceAll("\\/", "").trim().isEmpty() ||
					textHoraVenda.getText().replace(":","").trim().isEmpty() || TabelaModelo.getRowCount() == 0){
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					/*Envia os dados do cliente para o banco de dados*/
					cadastrarVenda = new Venda();
					cadastrarVendaHistorico = new VendaHistorico();
					cadastrarNotaFiscal = new NotaFiscal();
					
					cadastrarVenda.setNomeCliente(textNomeCliente.getText());
					cadastrarVendaHistorico.setNomeCliente(textNomeCliente.getText());
					cadastrarNotaFiscal.setClienteNome(textNomeCliente.getText());
					
					cadastrarVenda.setCPFCliente(textCPF.getText());
					cadastrarNotaFiscal.setCPFCliente(textCPF.getText());
					
					if (textCodigoCliente.getText().isEmpty() || textCodigoCliente.getText().length() <= 0) {
						String codigoClienteTexto = "Não registrado";
						cadastrarVenda.setCodigoCliente(codigoClienteTexto);
						cadastrarNotaFiscal.setCodigoCliente(codigoClienteTexto);
					}
					else {
						String codigoClienteTexto = textCodigoCliente.getText();
						cadastrarVenda.setCodigoCliente(codigoClienteTexto);
						cadastrarNotaFiscal.setCodigoCliente(codigoClienteTexto);
					}
					
					cadastrarVenda.setTipoPagamento((String)comboBoxTipoPagamento.getSelectedItem());
					cadastrarNotaFiscal.setTipoPagamento((String)comboBoxTipoPagamento.getSelectedItem());
					
					cadastrarVenda.setMetodoPagamento((String)comboBoxMetodoPagamento.getSelectedItem());
					cadastrarNotaFiscal.setMetodoPagamento((String)comboBoxMetodoPagamento.getSelectedItem());
					
					cadastrarVenda.setPrecoTotal(Double.parseDouble(precoTotal.getText()));
					cadastrarVendaHistorico.setPrecoTotal(Double.parseDouble(precoTotal.getText()));
					cadastrarNotaFiscal.setPrecoTotal(Double.parseDouble(precoTotal.getText()));
					
					double porcentagemDescontoValor = getPorcentagemDescontoValor();
					cadastrarVenda.setDescontoPorcentagem(porcentagemDescontoValor);
					cadastrarNotaFiscal.setPorcentagemDesconto(porcentagemDescontoValor);
					
					double precoDescontoValor = getDescontoPrecoTotal();
					cadastrarVenda.setPrecoTotalDesconto(precoDescontoValor);
					cadastrarNotaFiscal.setPrecoTotalDesconto(precoDescontoValor);
					
					int quantidadeParcelasValor = getQuantidadeParcelasVenda();
					cadastrarVenda.setQuantidadeParcelas(quantidadeParcelasValor);
					cadastrarNotaFiscal.setQuantidadeParcelas(quantidadeParcelasValor);
					
					double precoParceladoValor = getPrecoTotalParcelado();
					cadastrarVenda.setPrecoTotalParcelado(precoParceladoValor);
					cadastrarNotaFiscal.setPrecoTotalParcelas(precoParceladoValor);
					
					if (nomeUsuario == null) {
						String nomeFuncionario = "Nome";
						cadastrarVenda.setNomeFuncionario(nomeFuncionario);
						cadastrarVendaHistorico.setNomeFuncionario(nomeFuncionario);
						cadastrarNotaFiscal.setFuncionarioNome(nomeFuncionario);
					}
					else {
						cadastrarVenda.setNomeFuncionario(nomeUsuario);
						cadastrarVendaHistorico.setNomeFuncionario(nomeUsuario);
						cadastrarNotaFiscal.setFuncionarioNome(nomeUsuario);
					}
					
					if (codigoUsuario == null) {
						String codigoFuncionario = "Codigo";
						cadastrarVenda.setCodigoFuncionario(codigoFuncionario);
						cadastrarNotaFiscal.setCodigoFuncionario(codigoFuncionario);
					}
					else {
						cadastrarVenda.setCodigoFuncionario(codigoUsuario);
						cadastrarNotaFiscal.setCodigoFuncionario(codigoUsuario);
					}
					
					if (cargoUsuario == null) {
						String cargoFuncionario = "Cargo";
						cadastrarVenda.setCargoFuncionario(cargoFuncionario);
						cadastrarNotaFiscal.setCargoFuncionario(cargoFuncionario);
					}
					else {
						cadastrarVenda.setCargoFuncionario(cargoUsuario);
						cadastrarNotaFiscal.setCargoFuncionario(cargoUsuario);
					}
					
					dataCompra = textDataVenda.getText();
					try {
						dataFormato = new SimpleDateFormat("dd/MM/yyyy");
						data = new java.sql.Date(dataFormato.parse(dataCompra).getTime());
						cadastrarVenda.setDataVenda(data);
						cadastrarVendaHistorico.setDataVenda(data);
						cadastrarNotaFiscal.setDataEmissao(data);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					horaCompra = textHoraVenda.getText();
					try {
						horaFormato = new SimpleDateFormat("HH:mm");
						hora = new java.sql.Time(horaFormato.parse(horaCompra).getTime());
						cadastrarVenda.setHoraVenda(hora);
						cadastrarVendaHistorico.setHoraVenda(hora);
						cadastrarNotaFiscal.setHoraEmissao(hora);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					Random numeroCodigo = new Random();
					String codigoRegistro;
					int n0 = numeroCodigo.nextInt(10);
					int n1 = numeroCodigo.nextInt(10);
					int n2 = numeroCodigo.nextInt(10);
					int n3 = numeroCodigo.nextInt(10);
					int n4 = numeroCodigo.nextInt(10);
					int n5 = numeroCodigo.nextInt(10);
					int n6 = numeroCodigo.nextInt(10);
					int n7 = numeroCodigo.nextInt(10);
					int n8 = numeroCodigo.nextInt(10);
					int n9 = numeroCodigo.nextInt(10);
					codigoRegistro = ""+n0+n1+n2+n3+n4+n5+n6+n7+n8+n9;
					cadastrarVenda.setCodigoVenda(codigoRegistro);
					cadastrarVendaHistorico.setCodigoVenda(codigoRegistro);
					cadastrarNotaFiscal.setCodigoVenda(codigoRegistro);
					
					if (checkBoxNotaFiscalPaulista.isSelected()) {
						notaFiscalVenda = "Pedido";
						cadastrarVenda.setNotaFiscal(notaFiscalVenda);
						cadastrarNotaFiscal.setNotaFiscalPaulista(notaFiscalVenda);
					}
					else {
						notaFiscalVenda = "Não pedido";
						cadastrarVenda.setNotaFiscal(notaFiscalVenda);
						cadastrarNotaFiscal.setNotaFiscalPaulista(notaFiscalVenda);
					}
					
					savaDados = new Dao_inserir_dados_venda();
					savaDados.Inserir_Dados_Venda(cadastrarVenda);
					
					/*Envia os dados da lista de produtos da tabela para o banco de dados*/
					List<VendaProdutos>listaProdutoscliente = new ArrayList<VendaProdutos>();
					int linhasTabela = tabelaListaProdutos.getRowCount();
					for (int i = 0; i < linhasTabela; i++) {
						VendaProdutos cadastrarListaProdutos = new VendaProdutos();
						cadastrarListaProdutos.setCodigoProduto((String) tabelaListaProdutos.getModel().getValueAt(i, 0));
						cadastrarListaProdutos.setNomeProduto((String) tabelaListaProdutos.getModel().getValueAt(i, 1));
						cadastrarListaProdutos.setQuantidade(Double.parseDouble((String) tabelaListaProdutos.getModel().getValueAt(i, 2)));
						cadastrarListaProdutos.setPrecoUnitario(Double.parseDouble((String) tabelaListaProdutos.getModel().getValueAt(i, 3)));
						cadastrarListaProdutos.setPrecoQuantidade(Double.parseDouble((String) tabelaListaProdutos.getModel().getValueAt(i, 4)));
						cadastrarListaProdutos.setCodigoVenda(codigoRegistro);
						listaProdutoscliente.add(cadastrarListaProdutos);
					}
					
					for (VendaProdutos cadastrarListaProdutos : listaProdutoscliente) {
						Dao_inserir_dados_venda_produtos savaDadosListaProdutos = new Dao_inserir_dados_venda_produtos();
						savaDadosListaProdutos.Inserir_Dados_Venda_Produtos(cadastrarListaProdutos);
					}
					
					savaHistoricoDados = new Dao_inserir_dados_venda_historico();
					savaHistoricoDados.Inserir_Dados_Venda_Historico(cadastrarVendaHistorico);
					
					/*Envia os dados da nota fiscal para o banco de dados*/
					Random numeroCodigoNotaFiscal = new Random();
					String codigoRegistroNotaFiscal;
					int nf0 = numeroCodigoNotaFiscal.nextInt(10);
					int nf1 = numeroCodigoNotaFiscal.nextInt(10);
					int nf2 = numeroCodigoNotaFiscal.nextInt(10);
					int nf3 = numeroCodigoNotaFiscal.nextInt(10);
					int nf4 = numeroCodigoNotaFiscal.nextInt(10);
					int nf5 = numeroCodigoNotaFiscal.nextInt(10);
					int nf6 = numeroCodigoNotaFiscal.nextInt(10);
					int nf7 = numeroCodigoNotaFiscal.nextInt(10);
					int nf8 = numeroCodigoNotaFiscal.nextInt(10);
					int nf9 = numeroCodigoNotaFiscal.nextInt(10);
					codigoRegistroNotaFiscal = ""+nf0+nf1+nf2+nf3+nf4+nf5+nf6+nf7+nf8+nf9;
					cadastrarNotaFiscal.setCodigoNotaFiscal(codigoRegistroNotaFiscal);
					
					String tipoNotaFiscal = "Venda";
					cadastrarNotaFiscal.setTipoNotaFiscal(tipoNotaFiscal);
					
					String nomeLoja = null, cnpjLoja = null, enderecoLoja = null, inscricaoNumero = null;
					String numeroLoja = null, telefoneLoja = null, bairroLoja = null;
					String emailLoja = null, cepLoja = null, estadoLoja = null, cidadeLoja = null;
					
					Dao_consulta_dados_loja consultaDadosLojaRegistro = new Dao_consulta_dados_loja();
			    	List<DadosLoja> ConsultaDadosLoja = consultaDadosLojaRegistro.Consulta_Dados_Fornecedor_Dados_Loja();
			    	for (DadosLoja leitura : ConsultaDadosLoja) {
			    		String estadoDadosLojaConsultaTexto = leitura.getEstadoDadosLoja();
			    		setEstadoDadosLojaConsultaRegistro(estadoDadosLojaConsultaTexto);
					}
			    	
			    	/*Parte que consulta os dados no banco de dados*/
			    	String estadoDadosLojaConsultaTexto = getEstadoDadosLojaConsultaRegistro();
					Dao_consulta_dados_loja consultaDadosLoja = new Dao_consulta_dados_loja();
			    	List<DadosLoja> Consulta = consultaDadosLoja.Consulta_Dados_Fornecedor_Ficha(estadoDadosLojaConsultaTexto);
			    	for (DadosLoja leitura : Consulta) {
			    		nomeLoja = leitura.getNome();
			    		cnpjLoja = leitura.getCNPJ();
			    		inscricaoNumero = leitura.getInscricaoNumero();
			    		telefoneLoja = leitura.getTelefone1();
			    		emailLoja = leitura.getEmail1();
			    		estadoLoja = leitura.getEstado();
			    		cepLoja = leitura.getCEP();
			    		cidadeLoja = leitura.getCidade();
			    		enderecoLoja = leitura.getEndereco();
			    		numeroLoja = leitura.getNumero();
			    		bairroLoja = leitura.getBairro();
					}
			    	
					try {
						String caminhotxt = "C:\\Users\\ROSANGELA\\Desktop\\" + "Nota fiscal " + codigoRegistroNotaFiscal + " Cliente " + textNomeCliente.getText() + ".txt";
						FileWriter arq = new FileWriter(caminhotxt);
			            PrintWriter gravarArq = new PrintWriter(arq);
			            gravarArq.println("---------------------------------------------------");
			            gravarArq.println(nomeLoja);
			            gravarArq.println("CNPJ: " + cnpjLoja);
			            gravarArq.println(enderecoLoja + " " + numeroLoja);
			            gravarArq.println(bairroLoja);
			            gravarArq.println("CEP: " + cepLoja + ", " + estadoLoja + ", " + cidadeLoja);
			            gravarArq.println(numeroLoja + " " + bairroLoja);
			            gravarArq.println("Tel: " + telefoneLoja);
			            gravarArq.println("Email: " + emailLoja);
			            gravarArq.println("IE: " + inscricaoNumero);
			            gravarArq.println("Nota fiscal codigo" + codigoRegistro);
			            gravarArq.println("---------------------------------------------------");
		                gravarArq.println(textNomeCliente.getText());
		                gravarArq.println(textCPF.getText());
		                
				    	String consultaEncontrada = getDadosConsultaEncontrados();
				    	
				    	if (consultaEncontrada == null) {
				    		gravarArq.println("----------------------c-----------------------------");
						}
				    	else if (consultaEncontrada.equals("Não encontrou")) {
				    		gravarArq.println("----------------------d-----------------------------");
						}
				    	else {
				    		String telefoneCliente = getTelefoneCliente();
				            String celularCliente = getCelularCliente();
						    String enderecoCliente = getEnderecoCliente();
						    String numeroCliente = getNumeroCliente();
						    String cepCliente = getCEPCliente();
						    String bairroCliente = getBairroCliente();
						    String estadoCliente = getEstadoCliente();
						    String cidadeCliente = getCidadeCliente();
						    
				    		if (telefoneCliente == null || celularCliente == null || enderecoCliente == null || numeroCliente == null ||
					    		cepCliente == null || bairroCliente == null || estadoCliente == null || cidadeCliente == null) {
					    		gravarArq.println("----------------------b-----------------------------");
							}
					    	else {
					    		if(consultaEncontrada.equals("Encontrou")){
						    		gravarArq.println("Tel: " + telefoneCliente + " " + "Cel: " + celularCliente);
						    		gravarArq.println(enderecoCliente + ", " + numeroCliente);
						            gravarArq.println(bairroCliente);
						            gravarArq.println("CEP: " + cepCliente + ", " + cidadeCliente);
						            gravarArq.println(estadoCliente);
								}
							}
				    	}
				    	
				    	dadosCadastroNotaFiscal = new Vendas_Adicionar_Dados_Nota_Fiscal();
				    	String novoCadastroNotaFiscal = getNotaFiscalCadastro();
				    	
				    	if (novoCadastroNotaFiscal == null) {
				    		gravarArq.println("----------------------e-----------------------------");
						}
				    	else if (novoCadastroNotaFiscal.equals("novoCadastro")) {
				    		String telefoneNotaFiscal = getTelefoneCliente();
					    	String celularNotaFiscal =  getCelularCliente();
					    	String enderecoNotaFiscal =  getEnderecoCliente();
					    	String numeroNotaFiscal =  getNumeroCliente();
					    	String cepNotaFiscal =  getCEPCliente();
					    	String bairroNotaFiscal =  getBairroCliente();
					    	String estadoNotaFiscal =  getEstadoCliente();
						    String cidadeNotaFiscal =  getCidadeCliente();
				    		
				    		if (telefoneNotaFiscal == null || celularNotaFiscal == null || enderecoNotaFiscal == null || numeroNotaFiscal == null ||
				    			cepNotaFiscal == null || bairroNotaFiscal == null || estadoNotaFiscal == null || cidadeNotaFiscal == null) {
					    		gravarArq.println("------------------a---------------------------------");
							}
						    else { 
						    	gravarArq.println("Tel: " + telefoneNotaFiscal + " " + "Cel: " + celularNotaFiscal);
					    		gravarArq.println(enderecoNotaFiscal + ", " + numeroNotaFiscal);
					            gravarArq.println(bairroNotaFiscal);
					            gravarArq.println("CEP: " + cepNotaFiscal + " " + cidadeNotaFiscal);
					            gravarArq.println(estadoNotaFiscal);
							}
						}
			    		
				    	gravarArq.println("---------------------------------------------------");
			            gravarArq.println("|Codigo|Nome do produto|Qtd|Preço|Qtd x Preço");
			            gravarArq.println("---------------------------------------------------");
			            
			            List<StringBuilder> listaProdutosNotaFiscal = new ArrayList<StringBuilder>();
			            StringBuilder produtoListaFiscal;
						int linhasTabelaNotaFiscal = tabelaListaProdutos.getRowCount();
						int colunasTabelaNotaFiscal = tabelaListaProdutos.getColumnCount();
						for (int i = 0; i < linhasTabelaNotaFiscal; i++) {
							produtoListaFiscal = new StringBuilder();
							for (int j = 0; j < colunasTabelaNotaFiscal; j++) {
								produtoListaFiscal.append(tabelaListaProdutos.getValueAt(i, j) + " ");
							}
							listaProdutosNotaFiscal.add(produtoListaFiscal);
						}
						for (StringBuilder gravaProdutoListaFiscal: listaProdutosNotaFiscal) {
							gravarArq.println(gravaProdutoListaFiscal);
						}
			            gravarArq.println("---------------------------------------------------");
			            
			            if (nomeUsuario == null) {
							String nomeFuncionario = "Nome";
							gravarArq.println("Funcionario: " + nomeFuncionario);
						}
						else {
							gravarArq.println("Funcionario: " + nomeUsuario);
						}
						
						if (codigoUsuario == null) {
							String codigoFuncionario = "Codigo";
							gravarArq.println("Codigo do funcionario: " + codigoFuncionario);
						}
						else {
							gravarArq.println("Codigo do funcionario: " + codigoUsuario);
						}
						
						if (cargoUsuario == null) {
							String cargoFuncionario = "Cargo";
							gravarArq.println("Cargo: " + cargoFuncionario);
						}
						else {
							gravarArq.println("Cargo: " + cargoUsuario);
						}
						gravarArq.println("---------------------------------------------------");
			            gravarArq.println("Nota fiscal paulista: " + notaFiscalVenda);
			            gravarArq.println("Metodo de pagamento: " + (String) comboBoxMetodoPagamento.getSelectedItem());
			            gravarArq.println("Tipo de pagamento: " + (String) comboBoxTipoPagamento.getSelectedItem());
			            gravarArq.println("Preço Total(R$): "+ precoTotal.getText());
			            
			            double porcentagemDescontoNota = getPorcentagemDescontoValor();
						double precoDescontoNota = getDescontoPrecoTotal();
						int quantidadeParcelasNota = getQuantidadeParcelasVenda();
						double precoParceladoNota = getPrecoTotalParcelado();
						
			            gravarArq.println("Preço (R$) com "+ porcentagemDescontoNota +"% de desconto (À vista): " + precoDescontoNota);
			            gravarArq.println("Preço parcelado (A prazo) (R$): "+ quantidadeParcelasNota + " x " + precoParceladoNota);
			            gravarArq.println("---------------------------------------------------");
			            gravarArq.println("---------------------------------------------------");
		                arq.close();
					}
					catch (IOException e2) {
						e2.printStackTrace();
					}
					
					String telefoneTexto = getTelefoneCliente();
			    	String celularTexto =  getCelularCliente();
			    	String enderecoTexto =  getEnderecoCliente();
			    	String numeroTexto =  getNumeroCliente();
			    	String cepTexto =  getCEPCliente();
			    	String bairroTexto =  getBairroCliente();
			    	String estadoTexto =  getEstadoCliente();
				    String cidadeTexto =  getCidadeCliente();
					
					if (telefoneTexto == null || celularTexto == null || enderecoTexto == null || numeroTexto == null ||
			    		cepTexto == null || bairroTexto == null || estadoTexto == null || cidadeTexto == null) {
						
						String telefoneTextoValor = "Não registrado";
				    	String celularTextoValor =  "Não registrado";
				    	String enderecoTextoValor =  "Não registrado";
				    	String numeroTextoValor =  "Não registrado";
				    	String cepTextoValor =  "Não registrado";
				    	String bairroTextoValor =  "Não registrado";
				    	String estadoTextoValor =  "Não registrado";
					    String cidadeTextoValor =  "Não registrado";
						
					    cadastrarNotaFiscal.setTelefoneCliente(telefoneTextoValor);
						cadastrarNotaFiscal.setCelularCliente(celularTextoValor);
						cadastrarNotaFiscal.setEnderecoCliente(enderecoTextoValor);
						cadastrarNotaFiscal.setNumeroCliente(numeroTextoValor);
						cadastrarNotaFiscal.setCEPCliente(cepTextoValor);
						cadastrarNotaFiscal.setBairroCliente(bairroTextoValor);
						cadastrarNotaFiscal.setEstadoCliente(estadoTextoValor);
						cadastrarNotaFiscal.setCidadeCliente(cidadeTextoValor);
					    
					}
					else {
						cadastrarNotaFiscal.setTelefoneCliente(telefoneTexto);
						cadastrarNotaFiscal.setCelularCliente(celularTexto);
						cadastrarNotaFiscal.setEnderecoCliente(enderecoTexto);
						cadastrarNotaFiscal.setNumeroCliente(numeroTexto);
						cadastrarNotaFiscal.setCEPCliente(cepTexto);
						cadastrarNotaFiscal.setBairroCliente(bairroTexto);
						cadastrarNotaFiscal.setEstadoCliente(estadoTexto);
						cadastrarNotaFiscal.setCidadeCliente(cidadeTexto);
					}
					
					savaNotaFiscalDados = new Dao_inserir_dados_nota_fiscal();
					savaNotaFiscalDados.Inserir_Dados_Nota_Fiscal(cadastrarNotaFiscal);
					
					//Mensagem de confirmação do cadastro
					String menssagemConteudo = "Dados cadastrados com sucesso";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
					
					//Limpa os campos depois que o cadastro é realizado
					textNomeCliente.setText("");
					comboBoxTipoPagamento.setSelectedItem("Escolha");
					textCPF.setText("");
					textCodigoCliente.setText("");
					textDataVenda.setText("");
					textHoraVenda.setText("");
					comboBoxMetodoPagamento.setSelectedItem("Escolha");
					precoTotal.setText("00.00");
					precoParcelado.setText("0 x 00.00");
					labelPrecoDesconto.setText("Preço (R$) com 0% desconto (À vista):");
					precoDesconto.setText("00.00");
					checkBoxNotaFiscalPaulista.setSelected(false);
					
					//Apaga as linhas da tabela apos a realização da venda
					TabelaModelo.cancelarVenda();
				}
			}
		});
		finalizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(finalizar);
		
		calculadora = new JButton("Calculadora");
		calculadora.setToolTipText("Abre a calculadora");
		calculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calculadora Calculadora = new Calculadora();
				Calculadora.setVisible(true);
			}
		});
		calculadora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(calculadora);
		
		adicionar = new JButton("Adicionar");
		adicionar.setToolTipText("Adiciona um produto da lista de vendas");
		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vendas_Adicionar_Produto telaAdicionarProduto = new Vendas_Adicionar_Produto();
				telaAdicionarProduto.setVisible(true);
				
				String nomeProduto = telaAdicionarProduto.getNomeProduto();
				String codigoProduto = telaAdicionarProduto.getCodigoProduto();
				double quantidadeProduto = telaAdicionarProduto.getQuantidadeProduto();
				double quantidadeEstoqueProduto = telaAdicionarProduto.getQuantidadeEstoqueProduto();
				double precoProduto = telaAdicionarProduto.getPrecoProduto();
				
				String icmsProduto = "10";
				
				if (nomeProduto != null || codigoProduto != null || quantidadeProduto != 0 || quantidadeEstoqueProduto !=0 || precoProduto != 0) {
					Produto alterarCadastroProduto = new Produto();
					EstoqueProdutos alterarCadastroEstoqueProduto = new EstoqueProdutos();
					
					double quantidadeTotal = quantidadeEstoqueProduto - quantidadeProduto;
					
					alterarCadastroProduto.setCodigoProduto(codigoProduto);
					alterarCadastroProduto.setNome(nomeProduto);
					alterarCadastroProduto.setQuantidade(quantidadeTotal);
					
					alterarCadastroEstoqueProduto.setCodigoProduto(codigoProduto);
					alterarCadastroEstoqueProduto.setNome(nomeProduto);
					alterarCadastroEstoqueProduto.setQuantidade(quantidadeTotal);
					
					Dao_alterar_dados_produto_quantidade salvaNovoQuantidadeProduto = new Dao_alterar_dados_produto_quantidade();
					salvaNovoQuantidadeProduto.Altera_Dados_Produto_Quantidade(alterarCadastroProduto);
					salvaNovoQuantidadeProduto.Altera_Dados_Produto_Quantidade_Estoque(alterarCadastroEstoqueProduto);
					
					String quantidadeTexto = "" + quantidadeProduto;
					String precoTexto = "" + precoProduto;
					double precoQuantidadeCompra = quantidadeProduto * precoProduto;
					String precoQuantidadeTexto = "" + precoQuantidadeCompra;
					
					VendaTabela nVenda = new VendaTabela(codigoProduto, nomeProduto, quantidadeTexto, precoTexto, precoQuantidadeTexto, icmsProduto);
				    TabelaModelo.addVenda(nVenda);
					double valorPrecoTotal = 0;
					int linhasTabela = tabelaListaProdutos.getRowCount();
					for (int i = 0; i < linhasTabela; i++) {
						double valorPrecoUnitario = Double.parseDouble((String) tabelaListaProdutos.getValueAt(i, 4));
						valorPrecoTotal += valorPrecoUnitario;
						String valorPrecoVenda = "" + valorPrecoTotal;
						precoTotal.setText(valorPrecoVenda);
					}
				}
			}
		});
		adicionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(adicionar);
		
		removerProduto = new JButton("Remover");
		removerProduto.setToolTipText("Remove um produto da lista de vendas");
		removerProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemTitulo = "Deseja remover o produto?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo aviso = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemTitulo);
				aviso.setVisible(true);
				String resposta = aviso.getResposta();
				if (resposta != null) {
					if (resposta.equals("Sim")) {
						if (tabelaListaProdutos.getSelectedRow() != -1 && tabelaListaProdutos.getSelectedRow() < TabelaModelo.getRowCount()) {
							int linhaSelecionada = tabelaListaProdutos.getSelectedRow();
							TabelaModelo.removerVenda(linhaSelecionada);
							double valorPrecoTotal = 0;
							int linhasTabela = tabelaListaProdutos.getRowCount();
							for (int i = 0; i < linhasTabela; i++) {
								double valorPrecoUnitario = Double.parseDouble((String) tabelaListaProdutos.getValueAt(i, 4));
								valorPrecoTotal -= (-1)*(valorPrecoUnitario);
								String valorPrecoVenda = "" + valorPrecoTotal;
								precoTotal.setText(valorPrecoVenda);
							}
							if (linhasTabela == 0) {
								precoTotal.setText("00.00");
							}
						} 
						else {
							String menssagemConteudo = "Nenhum item selecionado";
							Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
							mensagemConfirmacao.setVisible(true);
						}
					}
				}
			}
		});
		removerProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(removerProduto);
		
		limpar = new JButton("Limpar");
		limpar.setToolTipText("Limpa os campos");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menssagemConteudo = "Deseja limpar os campos ?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo avisoLimparCampos = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemConteudo);
				avisoLimparCampos.setVisible(true);
				String avisoLimparCamposTexto = avisoLimparCampos.getResposta();
				if (avisoLimparCamposTexto != null) {
					if (avisoLimparCamposTexto.equals("Sim")) {
						textNomeCliente.setText("");
						textCPF.setText("");
						textCodigoCliente.setText("");
						comboBoxTipoPagamento.setSelectedItem("Escolha");
						comboBoxMetodoPagamento.setSelectedItem("Escolha");
						textDataVenda.setText("");
						textHoraVenda.setText("");
						checkBoxNotaFiscalPaulista.setSelected(false);
					}
				}
			}
		});
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(limpar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setToolTipText("Cancela a venda");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemTitulo = "Cancelamento da venda";
				String menssagemConteudo = "Deseja cancelar a venda ?";
				Tela_que_Exibe_Menssagem_Sim_Nao telaCancelarVenda = new Tela_que_Exibe_Menssagem_Sim_Nao(menssagemTitulo, menssagemConteudo);
				telaCancelarVenda.setVisible(true);
				String cancelarVendaTexto = telaCancelarVenda.getResposta();
				if (cancelarVendaTexto != null) {
					if (cancelarVendaTexto.equals("Sim")) {
						//Apaga as linhas da tabela e cancela a compra
						TabelaModelo.cancelarVenda();
						
						//Limpa os campos
						textNomeCliente.setText("");
						textCPF.setText("");
						textCodigoCliente.setText("");
						comboBoxTipoPagamento.setSelectedItem("Escolha");
						comboBoxMetodoPagamento.setSelectedItem("Escolha");
						textDataVenda.setText("");
						textHoraVenda.setText("");
						precoTotal.setText("00.00");
						precoParcelado.setText("0 x 00.00");
						labelPrecoDesconto.setText("Preço (R$) com 0% de desconto (À vista):");
						precoDesconto.setText("00.00");
						checkBoxNotaFiscalPaulista.setSelected(false);
					}
				}
			}
		});
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(cancelar);
		
		voltar = new JButton("Voltar");
		voltar.setToolTipText("Fecha a janela");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNomeCliente.getText().length() != 0 || textCodigoCliente.getText().length() != 0 ||
					textCPF.getText().replaceAll("\\.", "").replace("-","").trim().length() != 0  ||
					comboBoxMetodoPagamento.getSelectedItem() != "Escolha" || comboBoxTipoPagamento.getSelectedItem() != "Escolha" ||
					textDataVenda.getText().replaceAll("\\/", "").trim().length() != 0 ||
					textHoraVenda.getText().replace(":","").trim().length() != 0 || TabelaModelo.getRowCount() != 0){
						String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
						aviso.setVisible(true);
						String resposta = aviso.getResposta();
						if (resposta != null) {
							if (resposta.equals("Sim")) {
								setVisible(false); 
					            dispose();
							}
						}
				}
				else {
					setVisible(false); 
		            dispose();
				}
			}
		});
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBotoes2.add(voltar);
		
		/*Ação do botao sair da janela*/
		addWindowListener(
            new WindowAdapter() 
            {
                public void windowClosing(WindowEvent we) {
                	if (textNomeCliente.getText().length() != 0 || textCodigoCliente.getText().length() != 0 ||
    					textCPF.getText().replaceAll("\\.", "").replace("-","").trim().length() != 0  ||
    					comboBoxMetodoPagamento.getSelectedItem() != "Escolha" || comboBoxTipoPagamento.getSelectedItem() != "Escolha" ||
    					textDataVenda.getText().replaceAll("\\/", "").trim().length() != 0 ||
    					textHoraVenda.getText().replace(":","").trim().length() != 0 || TabelaModelo.getRowCount() != 0){
	                		String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
    						aviso.setVisible(true);
    						String resposta = aviso.getResposta();
    						if (resposta != null) {
    							if (resposta.equals("Sim")) {
    								setVisible(false); 
    					            dispose();
    							}
    						}
    				}
    				else {
    					setVisible(false); 
    		            dispose();
    				}
                }
            }
	    );
	}

	/*Metodos get e set*/
	private String telefoneCliente, celularCliente, enderecoCliente, numeroCliente, cidadeCliente, bairroCliente, estadoCliente, cepCliente;
	private String dadosConsultaEncontrados, nomeCliente, codigoCliente, notaFiscalCadastro;
	private double porcentagemDescontoValor, descontoPrecoTotal, precoTotalParcelado;
	private int quantidadeParcelasVenda;
	/*get e set Telefone do cliente*/
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String nTelefoneCliente) {
		this.telefoneCliente = nTelefoneCliente;
	}
	
	/*get e set Endereço do cliente*/
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	
	/*get e set Numero da casa do cliente*/
	public String getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	
	/*get e set Cidade do cliente*/
	public String getCidadeCliente() {
		return cidadeCliente;
	}
	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}
	
	/*get e set Bairro do cliente*/
	public String getBairroCliente() {
		return bairroCliente;
	}
	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}
	
	/*get e set Celular do cliente*/
	public String getCelularCliente() {
		return celularCliente;
	}
	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}
	
	/*get e set Estado do cliente*/
	public String getEstadoCliente() {
		return estadoCliente;
	}
	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
	
	/*get e set CEP do cliente*/
	public String getCEPCliente() {
		return cepCliente;
	}
	public void setCEPCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}
	
	/*get e set Resposta da pesquisa dos dados do cliente no banco de dados*/
	public String getDadosConsultaEncontrados() {
		return dadosConsultaEncontrados;
	}
	public void setDadosConsultaEncontrados(String dadosConsultaEncontrados) {
		this.dadosConsultaEncontrados = dadosConsultaEncontrados;
	}
	
	/*get e set Nome do cliente*/
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	/*get e set Codigo do cliente*/
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	/*get e set Valor da porcentagem desconto*/
	public double getPorcentagemDescontoValor() {
		return porcentagemDescontoValor;
	}
	public void setPorcentagemDescontoValor(double porcentagemDescontoValor) {
		this.porcentagemDescontoValor = porcentagemDescontoValor;
	}
	
	/*get e set Preço com desconto*/
	public double getDescontoPrecoTotal() {
		return descontoPrecoTotal;
	}
	public void setDescontoPrecoTotal(double descontoPrecoTotal) {
		this.descontoPrecoTotal = descontoPrecoTotal;
	}
	
	/*get e set Preço de cada parcela*/
	public double getPrecoTotalParcelado() {
		return precoTotalParcelado;
	}
	public void setPrecoTotalParcelado(double precoTotalParcelado) {
		this.precoTotalParcelado = precoTotalParcelado;
	}
	
	/*get e set Quantidade de parcelas*/
	public int getQuantidadeParcelasVenda() {
		return quantidadeParcelasVenda;
	}
	public void setQuantidadeParcelasVenda(int quantidadeParcelasVenda) {
		this.quantidadeParcelasVenda = quantidadeParcelasVenda;
	}
	
	/*get e set Cadastro da nota fiscal*/
	public String getNotaFiscalCadastro() {
		return notaFiscalCadastro;
	}
	public void setNotaFiscalCadastro(String notaFiscalCadastro) {
		this.notaFiscalCadastro = notaFiscalCadastro;
	}
	
	private String estadoDadosLojaConsultaRegistro;
	
	/*get e set Estado dados loja registro*/
	public String getEstadoDadosLojaConsultaRegistro() {
		return estadoDadosLojaConsultaRegistro;
	}
	public void setEstadoDadosLojaConsultaRegistro(String estadoDadosLojaConsultaRegistro) {
		this.estadoDadosLojaConsultaRegistro = estadoDadosLojaConsultaRegistro;
	}
}