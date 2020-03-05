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
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.RowFilter;
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
import javax.swing.JTabbedPane;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoBD.EstoqueProdutos;
import moduloProdutoBD.Produto;
import moduloProdutoDescontoPromocaoBD.Dao_alterar_dados_produto_preco;
import moduloProdutoDescontoPromocaoBD.Dao_consulta_dados_desconto;
import moduloProdutoDescontoPromocaoBD.Dao_consulta_dados_promocao;
import moduloProdutoDescontoPromocaoBD.Dao_inserir_dados_desconto;
import moduloProdutoDescontoPromocaoBD.Desconto;
import moduloProdutoDescontoPromocaoBD.Promocao;
import moduloProdutoDescontoPromocaoTabelas.DescontoTabela;
import moduloProdutoDescontoPromocaoTabelas.PromocaoTabela;
import moduloProdutoDescontoPromocaoTabelas.TabelaModeloDesconto;
import moduloProdutoDescontoPromocaoTabelas.TabelaModeloPromocao;

public class Descontos_e_Promocoes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaDescontosPromocoes;
	private JTable tabelaPromocoes, tabelaDescontos;
	private TabelaModeloPromocao TabelaModeloPromocao;
	private TabelaModeloDesconto TabelaModeloDesconto;
	private JButton buscaPromocao, buscaDesconto, acrescentarDesconto, atualizar, voltar, fichaPromocao, adicionarPromocao, fichaDesconto;
	private JTextField textBuscaPromocao, textBuscaDesconto;
	Desconto cadastrarDesconto;
	Dao_inserir_dados_desconto salvaDadosDesconto;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Descontos_e_Promocoes frame = new Descontos_e_Promocoes();
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
	public Descontos_e_Promocoes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Descontos_e_Promocoes.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(true);
		setSize(1000, 600);
		
		telaDescontosPromocoes = new JPanel();
		telaDescontosPromocoes.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaDescontosPromocoes.setLayout(new BorderLayout(0, 5));
		setContentPane(telaDescontosPromocoes);
		
		JPanel panelTitulo = new JPanel();
		telaDescontosPromocoes.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		panelTitulo.add(panelTitulo2);
		panelTitulo2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Descontos_e_Promocoes.class.getResource("/cImagens/Descontos e promo\u00E7\u00F5es.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		panelTitulo2.add(icone);
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelDescontosPromocoesTitulo = new JLabel("Descontos e promo\u00E7\u00F5es");
		panelTitulo2.add(labelDescontosPromocoesTitulo);
		labelDescontosPromocoesTitulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Descontos_e_Promocoes.class.getResource("/cImagens/Funcionario.png")));
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
		
		JTabbedPane tabbedPaneDescontosPromocoes = new JTabbedPane(JTabbedPane.TOP);
		telaDescontosPromocoes.add(tabbedPaneDescontosPromocoes, BorderLayout.CENTER);
		
		/*Parte das promoções*/
		JPanel panelPromocoes = new JPanel();
		tabbedPaneDescontosPromocoes.addTab("Promo\u00E7\u00F5es", null, panelPromocoes, null);
		panelPromocoes.setLayout(new BorderLayout(0, 5));
		
		/*Busca na tabela da lista da promoção*/
		JPanel panelBuscaPromocao = new JPanel();
		panelBuscaPromocao.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPromocoes.add(panelBuscaPromocao, BorderLayout.NORTH);
		panelBuscaPromocao.setLayout(new BorderLayout(5, 0));
		
		JLabel labelBuscaPromocao = new JLabel("Busca:");
		labelBuscaPromocao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBuscaPromocao.add(labelBuscaPromocao, BorderLayout.WEST);
		
		buscaPromocao = new JButton("Busca");
		buscaPromocao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBuscaPromocao.add(buscaPromocao, BorderLayout.EAST);
		
		textBuscaPromocao = new JTextField();
		textBuscaPromocao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBuscaPromocao.add(textBuscaPromocao, BorderLayout.CENTER);
		textBuscaPromocao.setColumns(10);
		
		/*Tabela com a lista da promoção*/
		TabelaModeloPromocao = new TabelaModeloPromocao();
		JScrollPane scrollPanePromocoes = new JScrollPane();
		panelPromocoes.add(scrollPanePromocoes);
		tabelaPromocoes = new JTable();
		tabelaPromocoes.setModel(TabelaModeloPromocao);
		scrollPanePromocoes.setViewportView(tabelaPromocoes);
		tabelaPromocoes.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaPromocoes.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaPromocoes.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabelaPromocoes.getColumnModel().getColumn(3).setPreferredWidth(40);

		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloPromocao> sorterBuscaPromocao = new TableRowSorter<TabelaModeloPromocao>(TabelaModeloPromocao);
		tabelaPromocoes.setRowSorter(sorterBuscaPromocao);
		buscaPromocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBuscaPromocao.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaPromocao.setRowFilter(null);
				}
				else {
					sorterBuscaPromocao.setRowFilter(RowFilter.regexFilter(palavraBusca));
				}
			}
		});
		textBuscaPromocao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evtkey) {
				int botaoteclado = evtkey.getKeyCode();
				if (botaoteclado == KeyEvent.VK_ENTER) {
					String palavraBusca = textBuscaPromocao.getText();
					if (palavraBusca.length() ==0 ) {
						sorterBuscaPromocao.setRowFilter(null);
					}
					else {
						sorterBuscaPromocao.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_promocao ConsultaDadosPromocao = new Dao_consulta_dados_promocao();
    	List<Promocao> ConsultaPromocao = ConsultaDadosPromocao.Consulta_Dados_Promocao_Lista();
		for (Promocao leitura : ConsultaPromocao) {
			String codigoPromocao = leitura.getCodigoPromocao();
			String nomePromocao = leitura.getNomePromocao();
			
    		Date dataPromocaoInicio = leitura.getDataInicio();
    		SimpleDateFormat dataInicioFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataInicioValor = dataInicioFormato.format(dataPromocaoInicio);
    		Time horaPromocaoInicio = leitura.getHoraInicio();
    		SimpleDateFormat horaInicioFormato = new SimpleDateFormat("HH:mm");
    		String horaInicioValor = horaInicioFormato.format(horaPromocaoInicio);
    		String dataHoraInicio = dataInicioValor + " " + horaInicioValor;

    		Date dataPromocaoTermino = leitura.getDataTermino();
    		SimpleDateFormat dataTerminoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataTerminoValor = dataTerminoFormato.format(dataPromocaoTermino);
    		Time horaPromocaoTermino = leitura.getHoraTermino();
    		SimpleDateFormat horaTerminoFormato = new SimpleDateFormat("HH:mm");
    		String horaTerminoValor = horaTerminoFormato.format(horaPromocaoTermino);
    		String dataHoraTermino = dataTerminoValor + " " + horaTerminoValor;
    		
    		String nomeResponsavel = leitura.getNomeResponsavel();
    		
			PromocaoTabela listaPromocao = new PromocaoTabela(codigoPromocao, nomePromocao, dataHoraInicio, dataHoraTermino, nomeResponsavel);
			TabelaModeloPromocao.addPromocao(listaPromocao);
		}
		
		JPanel panelPromocaoBotoes = new JPanel();
		FlowLayout fl_panelPromocaoBotoes = (FlowLayout) panelPromocaoBotoes.getLayout();
		fl_panelPromocaoBotoes.setAlignment(FlowLayout.RIGHT);
		panelPromocoes.add(panelPromocaoBotoes, BorderLayout.SOUTH);
		
		fichaPromocao = new JButton("Ficha");
		fichaPromocao.setToolTipText("Exibe a ficha com os dados da promo\u00E7\u00E3o");
		fichaPromocao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fichaPromocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabelaPromocoes.getSelectedRow() != -1 && tabelaPromocoes.getSelectedRow() < TabelaModeloPromocao.getRowCount()) {
					
					sessao.setCodigoPromocaoFicha((String) tabelaPromocoes.getModel().getValueAt(tabelaPromocoes.getSelectedRow(),0));
					
					Descontos_e_Promocoes_Ficha_Promocoes fichaPromocao = new Descontos_e_Promocoes_Ficha_Promocoes();
					fichaPromocao.setVisible(true);
				}
				else {
					String menssagemConteudo = "Nenhum item selecionado";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
				}
			}
		});
		panelPromocaoBotoes.add(fichaPromocao);
		
		adicionarPromocao = new JButton("Adicionar promo\u00E7\u00E3o");
		adicionarPromocao.setToolTipText("Criar uma promo\u00E7\u00E3o");
		adicionarPromocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Descontos_e_Promocoes_Adicionar_Promocao telaDescontosPromocoesAdicionarPromocao = new Descontos_e_Promocoes_Adicionar_Promocao();
				telaDescontosPromocoesAdicionarPromocao.setVisible(true);
				dispose();
			}
		});
		panelPromocaoBotoes.add(adicionarPromocao);
		adicionarPromocao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		/*Parte dos descontos*/
		JPanel panelDescontos = new JPanel();
		tabbedPaneDescontosPromocoes.addTab("Descontos", null, panelDescontos, null);
		panelDescontos.setLayout(new BorderLayout(0, 5));
		
		/*Busca na tabela da lista do desconto*/
		JPanel panelBuscaDesconto = new JPanel();
		panelBuscaDesconto.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDescontos.add(panelBuscaDesconto, BorderLayout.NORTH);
		panelBuscaDesconto.setLayout(new BorderLayout(5, 0));
		
		JLabel labelBuscaDesconto = new JLabel("Busca:");
		labelBuscaDesconto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBuscaDesconto.add(labelBuscaDesconto, BorderLayout.WEST);
		
		textBuscaDesconto = new JTextField();
		textBuscaDesconto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBuscaDesconto.add(textBuscaDesconto, BorderLayout.CENTER);
		textBuscaDesconto.setColumns(10);

		buscaDesconto = new JButton("Busca");
		buscaDesconto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBuscaDesconto.add(buscaDesconto, BorderLayout.EAST);
		
		/*Tabela com a lista do desconto*/
		JScrollPane scrollPaneDescontos = new JScrollPane();
		panelDescontos.add(scrollPaneDescontos);
		TabelaModeloDesconto = new TabelaModeloDesconto();
		tabelaDescontos = new JTable();
		scrollPaneDescontos.setViewportView(tabelaDescontos);
		tabelaDescontos.setModel(TabelaModeloDesconto);
		tabelaDescontos.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaDescontos.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaDescontos.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabelaDescontos.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabelaDescontos.getColumnModel().getColumn(4).setPreferredWidth(40);
		tabelaDescontos.getColumnModel().getColumn(5).setPreferredWidth(80);

		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloDesconto> sorterBuscaDesconto = new TableRowSorter<TabelaModeloDesconto>(TabelaModeloDesconto);
		tabelaDescontos.setRowSorter(sorterBuscaDesconto);
		buscaDesconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBuscaDesconto.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaDesconto.setRowFilter(null);
				}
				else {
					sorterBuscaDesconto.setRowFilter(RowFilter.regexFilter(palavraBusca));
				}
			}
		});
		textBuscaDesconto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evtkey) {
				int botaoteclado = evtkey.getKeyCode();
				if (botaoteclado == KeyEvent.VK_ENTER) {
					String palavraBusca = textBuscaDesconto.getText();
					if (palavraBusca.length() ==0 ) {
						sorterBuscaDesconto.setRowFilter(null);
					}
					else {
						sorterBuscaDesconto.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		Dao_consulta_dados_desconto ConsultaDadosDesconto = new Dao_consulta_dados_desconto();
    	List<Desconto> ConsultaDesconto = ConsultaDadosDesconto.Consulta_Dados_Desconto_Lista();
		for (Desconto leitura : ConsultaDesconto) {
			String codigoDesconto = leitura.getCodigoDesconto();
			String nomePromocao = leitura.getNomeProduto();
			
			double descontoValor = leitura.getDescontoPorcentagem();
			String descontoProduto = "" + descontoValor;
			
    		Date dataPromocaoInicio = leitura.getDataInicio();
    		SimpleDateFormat dataInicioFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataInicioValor = dataInicioFormato.format(dataPromocaoInicio);
    		Time horaPromocaoInicio = leitura.getHoraInicio();
    		SimpleDateFormat horaInicioFormato = new SimpleDateFormat("HH:mm");
    		String horaInicioValor = horaInicioFormato.format(horaPromocaoInicio);
    		String dataHoraInicio = dataInicioValor + " " + horaInicioValor;

    		Date dataPromocaoTermino = leitura.getDataTermino();
    		SimpleDateFormat dataTerminoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataTerminoValor = dataTerminoFormato.format(dataPromocaoTermino);
    		Time horaPromocaoTermino = leitura.getHoraTermino();
    		SimpleDateFormat horaTerminoFormato = new SimpleDateFormat("HH:mm");
    		String horaTerminoValor = horaTerminoFormato.format(horaPromocaoTermino);
    		String dataHoraTermino = dataTerminoValor + " " + horaTerminoValor;
    		
    		String nomeResponsavel = leitura.getNomeResponsavel();
    		
    		DescontoTabela listaDesconto = new DescontoTabela(codigoDesconto, nomePromocao, descontoProduto, dataHoraInicio, dataHoraTermino, nomeResponsavel);
			TabelaModeloDesconto.addDesconto(listaDesconto);
		}
		
		JPanel panelDescontoBotoes = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelDescontoBotoes.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelDescontos.add(panelDescontoBotoes, BorderLayout.SOUTH);
		
		fichaDesconto = new JButton("Ficha");
		fichaDesconto.setToolTipText("Exibe a ficha com os dados da promo\u00E7\u00E3o");
		fichaDesconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tabelaDescontos.getSelectedRow() != -1 && tabelaDescontos.getSelectedRow() < TabelaModeloDesconto.getRowCount()) {
					
					sessao.setCodigoDescontoFicha((String) tabelaDescontos.getModel().getValueAt(tabelaDescontos.getSelectedRow(),0));
					
					Descontos_e_Promocoes_Ficha_Desconto fichaDesconto = new Descontos_e_Promocoes_Ficha_Desconto();
					fichaDesconto.setVisible(true);
				}
				else {
					String menssagemConteudo = "Nenhum item selecionado";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
				}
			}
		});
		fichaDesconto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelDescontoBotoes.add(fichaDesconto);
		
		acrescentarDesconto = new JButton("Acrescentar desconto");
		acrescentarDesconto.setToolTipText("Acrescenta desconto a um produto");
		panelDescontoBotoes.add(acrescentarDesconto);
		acrescentarDesconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Descontos_e_Promocoes_Desconto_Adicionar_Produto telaAdicionarProdutoDesconto = new Descontos_e_Promocoes_Desconto_Adicionar_Produto();
				telaAdicionarProdutoDesconto.setVisible(true);
				cadastrarDesconto = new Desconto();
				String codigoProduto = telaAdicionarProdutoDesconto.getCodigoProduto();
				String nomeProduto = telaAdicionarProdutoDesconto.getNomeProduto();
				double precoNormal = telaAdicionarProdutoDesconto.getPrecoProduto();
				double porcentagemDesconto = telaAdicionarProdutoDesconto.getDescontoProduto();
				Date dataInicio = telaAdicionarProdutoDesconto.getDataInicio();
				Date dataTermino = telaAdicionarProdutoDesconto.getDataTermino();
				Time horaInicio = telaAdicionarProdutoDesconto.getHoraInicio();
				Time horaTermino = telaAdicionarProdutoDesconto.getHoraTermino();
				String nomeResponsavel = telaAdicionarProdutoDesconto.getNomeResponsavel();
				String cargoResponsavel = telaAdicionarProdutoDesconto.getCargoResponsavel();
				String codigoResponsavel = telaAdicionarProdutoDesconto.getCodigoResponsavel();
				
				if (codigoProduto != null || nomeProduto != null || precoNormal != 0 || porcentagemDesconto != 0 || 
					dataInicio != null || dataTermino != null || horaInicio != null || horaTermino != null || nomeResponsavel != null ||
					cargoResponsavel != null || codigoResponsavel != null) {
					
					String porcentagemDescontoTexto = "" + porcentagemDesconto;
					
					double precoDescontoValor = ((precoNormal * porcentagemDesconto) / 100);
					double precoDescontoTotal = precoNormal - precoDescontoValor;
					
					cadastrarDesconto.setCodigoProduto(codigoProduto);
					cadastrarDesconto.setNomeProduto(nomeProduto);
					cadastrarDesconto.setNomeResponsavel(nomeResponsavel);
					cadastrarDesconto.setCargoResponsavel(cargoResponsavel);
					cadastrarDesconto.setCodigoResponsavel(codigoResponsavel);
					cadastrarDesconto.setPrecoNormal(precoNormal);
					cadastrarDesconto.setDescontoPorcentagem(porcentagemDesconto);
					cadastrarDesconto.setPrecoDesconto(precoDescontoTotal);
					cadastrarDesconto.setDataInicio(dataInicio);
					cadastrarDesconto.setDataTermino(dataTermino);
					cadastrarDesconto.setHoraInicio(horaInicio);
					cadastrarDesconto.setHoraTermino(horaTermino);
					
					
					SimpleDateFormat dataInicioFormato = new SimpleDateFormat("dd/MM/yyyy");
		    		String dataInicioValor = dataInicioFormato.format(dataInicio);
		    		SimpleDateFormat horaInicioFormato = new SimpleDateFormat("HH:mm");
		    		String horaInicioValor = horaInicioFormato.format(horaInicio);
					String dataHoraInicio = dataInicioValor + " " + horaInicioValor;
					
					SimpleDateFormat dataTerminoFormato = new SimpleDateFormat("dd/MM/yyyy");
		    		String dataTerminoValor = dataTerminoFormato.format(dataTermino);
		    		SimpleDateFormat horaTerminoFormato = new SimpleDateFormat("HH:mm");
		    		String horaTerminoValor = horaTerminoFormato.format(horaTermino);
					String dataHoraTermino = dataTerminoValor + " " + horaTerminoValor;
					
					if (nomeUsuario == null) {
						String nomeFuncionario = "Nome";
						cadastrarDesconto.setFuncionarioCadastro(nomeFuncionario);
					}
					else {
						cadastrarDesconto.setFuncionarioCadastro(nomeUsuario);
					}
					
					if (codigoUsuario == null) {
						String codigoFuncionario = "Codigo";
						cadastrarDesconto.setCodigoFuncionario(codigoFuncionario);
					}
					else {
						cadastrarDesconto.setCodigoFuncionario(codigoUsuario);
					}
					
					if (cargoUsuario == null) {
						String cargoFuncionario = "Cargo";
						cadastrarDesconto.setCargoFuncionario(cargoFuncionario);
					}
					else {
						cadastrarDesconto.setCargoFuncionario(cargoUsuario);
					}
					
					try {
						java.util.Date dataRegistro = new java.util.Date();
						SimpleDateFormat dataRegistroFormato = new SimpleDateFormat("dd/MM/yyyy");
						String dataCadastroFuncionario = dataRegistroFormato.format(dataRegistro);
						SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
						Date dataCadastro = new java.sql.Date(dataCadastroFormato.parse(dataCadastroFuncionario).getTime());
						cadastrarDesconto.setDataCadastro(dataCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
					}
					
					try {
						java.util.Date horaRegistro = new java.util.Date();
						SimpleDateFormat horaRegistroFormato = new SimpleDateFormat("HH:mm");
						String horaCadastroFuncionario = horaRegistroFormato.format(horaRegistro);
						SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
						Time horaCadastro = new java.sql.Time(horaCadastroFormato.parse(horaCadastroFuncionario).getTime());
						cadastrarDesconto.setHoraCadastro(horaCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
					}
					
					String estadoDescontoTexto = "Em andamento";
					cadastrarDesconto.setEstadoDesconto(estadoDescontoTexto);
					
					Random numeroCodigo = new Random();
					String codigoDescontoTexto;
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
					codigoDescontoTexto = ""+n0+n1+n2+n3+n4+n5+n6+n7+n8+n9;
					cadastrarDesconto.setCodigoDesconto(codigoDescontoTexto);
					
					Produto alterarCadastroProduto = new Produto();
					EstoqueProdutos alterarCadastroEstoqueProduto = new EstoqueProdutos();
					
					alterarCadastroProduto.setCodigoProduto(codigoProduto);
					alterarCadastroProduto.setNome(nomeProduto);
					alterarCadastroProduto.setPrecoaVista(precoDescontoTotal);
					
					alterarCadastroEstoqueProduto.setCodigoProduto(codigoProduto);
					alterarCadastroEstoqueProduto.setNome(nomeProduto);
					alterarCadastroEstoqueProduto.setPrecoaVista(precoDescontoTotal);
					
					Dao_alterar_dados_produto_preco salvaNovoPrecoProduto = new Dao_alterar_dados_produto_preco();
					salvaNovoPrecoProduto.Altera_Dados_Produto_Preco(alterarCadastroProduto);
					salvaNovoPrecoProduto.Altera_Dados_Produto_Preco_Estoque(alterarCadastroEstoqueProduto);
					
					salvaDadosDesconto = new Dao_inserir_dados_desconto();
					salvaDadosDesconto.Inserir_Dados_Desconto(cadastrarDesconto);
					
					DescontoTabela nLista = new DescontoTabela(codigoDescontoTexto, nomeProduto, porcentagemDescontoTexto, dataHoraInicio, dataHoraTermino , nomeResponsavel);
					TabelaModeloDesconto.addDesconto(nLista);
					
					String menssagemConteudo = "Desconto cadastrado com sucesso";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
				}
			}
		});
		acrescentarDesconto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panelBotoes = new JPanel();
		telaDescontosPromocoes.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		atualizar = new JButton("Atualizar");
		atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Descontos_e_Promocoes rebrirTela = new Descontos_e_Promocoes();
				rebrirTela.setVisible(true);
				dispose();
			}
		});
		atualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(atualizar);
		
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
}