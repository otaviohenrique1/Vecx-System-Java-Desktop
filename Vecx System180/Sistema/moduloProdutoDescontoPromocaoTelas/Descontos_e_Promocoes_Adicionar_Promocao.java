package moduloProdutoDescontoPromocaoTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.text.MaskFormatter;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoBD.EstoqueProdutos;
import moduloProdutoBD.Produto;
import moduloProdutoDescontoPromocaoBD.Dao_alterar_dados_produto_preco;
import moduloProdutoDescontoPromocaoBD.Dao_inserir_dados_promocao;
import moduloProdutoDescontoPromocaoBD.Dao_inserir_dados_promocao_produtos;
import moduloProdutoDescontoPromocaoBD.Promocao;
import moduloProdutoDescontoPromocaoBD.PromocaoProdutos;
import moduloProdutoDescontoPromocaoTabelas.PromocaoProdutosTabela;
import moduloProdutoDescontoPromocaoTabelas.TabelaModeloPromocaoProdutos;

public class Descontos_e_Promocoes_Adicionar_Promocao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaAdicionarPromocoes;
	private JTextField textNomePromocao;
	private JFormattedTextField textDataInicio, textDataTermino, textHoraInicio, textHoraTermino;
	private JButton cancelar, salvar, removerProduto, adicionarProduto, adicionarResponsavel, limparCampos;
	private JTable tabelaProdutos;
	private TabelaModeloPromocaoProdutos TabelaModeloPromocaoProdutos;
	Promocao cadastrarPromocao;
	PromocaoProdutos cadastrarPromocaoProdutos;
	Dao_inserir_dados_promocao salvarDadosPromocao;
	Dao_inserir_dados_promocao_produtos salvarDadosPromocaoProdutos;
	private JTextField textCargoResponsavel;
	private JTextField textCodigoResponsavel;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Descontos_e_Promocoes_Adicionar_Promocao frame = new Descontos_e_Promocoes_Adicionar_Promocao();
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
	public Descontos_e_Promocoes_Adicionar_Promocao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Descontos_e_Promocoes_Adicionar_Promocao.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(830, 600);
		
		telaAdicionarPromocoes = new JPanel();
		telaAdicionarPromocoes.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaAdicionarPromocoes.setLayout(new BorderLayout(0, 5));
		setContentPane(telaAdicionarPromocoes);
		
		MaskFormatter dataInicioMascara = null;
		MaskFormatter horaInicioMascara = null;
		MaskFormatter dataTerminoMascara = null;
		MaskFormatter horaTerminoMascara = null;
		try{
			dataInicioMascara = new MaskFormatter("##/##/####");
			horaInicioMascara = new MaskFormatter("##:##");
			dataTerminoMascara = new MaskFormatter("##/##/####");
			horaTerminoMascara = new MaskFormatter("##:##");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		JPanel panelTitulo = new JPanel();
		telaAdicionarPromocoes.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelTitulo2 = new JPanel();
		panelTitulo.add(panelTitulo2);
		panelTitulo2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel Icone = new JLabel("");
		Icone.setIcon(new ImageIcon(Descontos_e_Promocoes_Adicionar_Promocao.class.getResource("/cImagens/Adicionar promo\u00E7\u00E3o.PNG")));
		Icone.setPreferredSize(new Dimension(30, 30));
		panelTitulo2.add(Icone);
		Icone.setHorizontalAlignment(SwingConstants.CENTER);
		Icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelAdicionarPromocao = new JLabel("Adicionar promo\u00E7\u00E3o");
		panelTitulo2.add(labelAdicionarPromocao);
		labelAdicionarPromocao.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Descontos_e_Promocoes_Adicionar_Promocao.class.getResource("/cImagens/Funcionario.png")));
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		telaAdicionarPromocoes.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelAdicionarPromocao = new JPanel();
		tabbedPane.addTab("Promo\u00E7\u00E3o", null, panelAdicionarPromocao, null);
		panelAdicionarPromocao.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneAdicionarPromocao = new JScrollPane();
		panelAdicionarPromocao.add(scrollPaneAdicionarPromocao);
		
		JPanel panelDadosPromocao = new JPanel();
		scrollPaneAdicionarPromocao.setViewportView(panelDadosPromocao);
		panelDadosPromocao.setLayout(new BorderLayout(0, 5));
		
		JPanel panelDados = new JPanel();
		panelDadosPromocao.add(panelDados, BorderLayout.NORTH);
		panelDados.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelNomePromocao = new JPanel();
		panelNomePromocao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDados.add(panelNomePromocao);
		panelNomePromocao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomePromocao = new JLabel("Nome da promo\u00E7\u00E3o");
		labelNomePromocao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelNomePromocao.add(labelNomePromocao);
		
		textNomePromocao = new JTextField();
		textNomePromocao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelNomePromocao.add(textNomePromocao);
		textNomePromocao.setColumns(10);
		
		JPanel panelNome_Cod_Cargo_Resp = new JPanel();
		panelDados.add(panelNome_Cod_Cargo_Resp);
		panelNome_Cod_Cargo_Resp.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeResponsavel = new JPanel();
		panelNome_Cod_Cargo_Resp.add(panelNomeResponsavel);
		panelNomeResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeResponsavel = new JLabel("Nome do responsavel");
		labelNomeResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelNomeResponsavel.add(labelNomeResponsavel);
		
		JTextField textNomeResponsavel = new JTextField();
		textNomeResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNomeResponsavel.setColumns(10);
		panelNomeResponsavel.add(textNomeResponsavel);
		
		JPanel panelCodiogo_Cargo = new JPanel();
		panelNome_Cod_Cargo_Resp.add(panelCodiogo_Cargo);
		panelCodiogo_Cargo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCodigoResponsavel = new JPanel();
		panelCodiogo_Cargo.add(panelCodigoResponsavel);
		panelCodigoResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoResponsavel = new JLabel("Codigo do responsavel");
		labelCodigoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelCodigoResponsavel.add(labelCodigoResponsavel);
		
		textCodigoResponsavel = new JTextField();
		textCodigoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textCodigoResponsavel.setColumns(10);
		panelCodigoResponsavel.add(textCodigoResponsavel);
		
		JPanel panelCargoResponsavel = new JPanel();
		panelCodiogo_Cargo.add(panelCargoResponsavel);
		panelCargoResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargoResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargoResponsavel = new JLabel("Cargo do responsavel");
		labelCargoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelCargoResponsavel.add(labelCargoResponsavel);
		
		textCargoResponsavel = new JTextField();
		textCargoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textCargoResponsavel.setColumns(10);
		panelCargoResponsavel.add(textCargoResponsavel);
		
		JPanel panelTipoPromocao = new JPanel();
		panelDados.add(panelTipoPromocao);
		panelTipoPromocao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoPromocao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoPromocao = new JLabel("Tipo de promo\u00E7\u00E3o");
		labelTipoPromocao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelTipoPromocao.add(labelTipoPromocao);
		
		JTextField textTipoPromocao = new JTextField();
		textTipoPromocao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTipoPromocao.setColumns(10);
		panelTipoPromocao.add(textTipoPromocao);
		
		JPanel panelPromocaoDataHora = new JPanel();
		panelDados.add(panelPromocaoDataHora);
		panelPromocaoDataHora.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelDataInicio = new JPanel();
		panelDataInicio.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPromocaoDataHora.add(panelDataInicio);
		panelDataInicio.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataInicio = new JLabel("Data de inicio");
		labelDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelDataInicio.add(labelDataInicio);
		
		textDataInicio = new JFormattedTextField(dataInicioMascara);
		textDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDataInicio.setColumns(10);
		panelDataInicio.add(textDataInicio);
		
		JPanel panelHoraInicio = new JPanel();
		panelPromocaoDataHora.add(panelHoraInicio);
		panelHoraInicio.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHoraInicio.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraInicio = new JLabel("Hora de inicio");
		labelHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelHoraInicio.add(labelHoraInicio);
		
		textHoraInicio = new JFormattedTextField(horaInicioMascara);
		textHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textHoraInicio.setColumns(10);
		panelHoraInicio.add(textHoraInicio);
		
		JPanel panelDataTermino = new JPanel();
		panelDataTermino.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPromocaoDataHora.add(panelDataTermino);
		panelDataTermino.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataTermino = new JLabel("Data de termino");
		labelDataTermino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelDataTermino.add(labelDataTermino);
		
		textDataTermino = new JFormattedTextField(dataTerminoMascara);
		textDataTermino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDataTermino.setColumns(10);
		panelDataTermino.add(textDataTermino);
		
		JPanel panelHoraTermino = new JPanel();
		panelPromocaoDataHora.add(panelHoraTermino);
		panelHoraTermino.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelHoraTermino.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelHoraTermino = new JLabel("Hora de termino");
		labelHoraTermino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelHoraTermino.add(labelHoraTermino);
		
		textHoraTermino = new JFormattedTextField(horaTerminoMascara);
		textHoraTermino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textHoraTermino.setColumns(10);
		panelHoraTermino.add(textHoraTermino);
		
		JScrollPane scrollPaneProdutos = new JScrollPane();
		panelDadosPromocao.add(scrollPaneProdutos, BorderLayout.CENTER);
		
		TabelaModeloPromocaoProdutos = new TabelaModeloPromocaoProdutos();
		tabelaProdutos = new JTable();
		scrollPaneProdutos.setViewportView(tabelaProdutos);
		tabelaProdutos.setModel(TabelaModeloPromocaoProdutos);
		tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(80);
		tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaProdutos.getColumnModel().getColumn(2).setPreferredWidth(40);
		tabelaProdutos.getColumnModel().getColumn(3).setPreferredWidth(40);
		tabelaProdutos.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		
		JPanel panelDescricao = new JPanel();
		tabbedPane.addTab("Descri\u00E7\u00E3o da promo\u00E7\u00E3o", null, panelDescricao, null);
		panelDescricao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDescricao.setLayout(new BorderLayout(0, 0));
		
		JLabel labelDescricao = new JLabel("Descri\u00E7\u00E3o da promo\u00E7\u00E3o");
		labelDescricao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelDescricao.add(labelDescricao, BorderLayout.NORTH);
		
		JScrollPane scrollPaneDescricao = new JScrollPane();
		panelDescricao.add(scrollPaneDescricao);
		
		JTextArea textAreaDescricao = new JTextArea();
		textAreaDescricao.setLineWrap(true);
		scrollPaneDescricao.setViewportView(textAreaDescricao);
		textAreaDescricao.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelBotoes = new JPanel();
		telaAdicionarPromocoes.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		salvar = new JButton("Salvar");
		salvar.setToolTipText("Salva os dados do cadastro da promo\u00E7\u00E3o");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNomePromocao.getText().isEmpty() || textNomePromocao.getText().length() <= 0 ||
					textNomeResponsavel.getText().isEmpty() || textNomeResponsavel.getText().length() <= 0 ||
					textCodigoResponsavel.getText().isEmpty() || textCodigoResponsavel.getText().length() <= 0 ||
					textCargoResponsavel.getText().isEmpty() || textCargoResponsavel.getText().length() <= 0 ||
					textTipoPromocao.getText().isEmpty() || textTipoPromocao.getText().length() <= 0 ||
					textDataInicio.getText().replaceAll("\\/", "").trim().isEmpty() || textDataTermino.getText().replaceAll("\\/", "").trim().isEmpty() ||
					textHoraInicio.getText().replace(":","").trim().isEmpty() || textHoraTermino.getText().replace(":","").trim().isEmpty() ||
					textAreaDescricao.getText().isEmpty() || textAreaDescricao.getText().length() <= 0 || TabelaModeloPromocaoProdutos.getRowCount() <= 0) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					cadastrarPromocao = new Promocao();
					cadastrarPromocao.setNomePromocao(textNomePromocao.getText());
					cadastrarPromocao.setNomeResponsavel(textNomeResponsavel.getText());
					cadastrarPromocao.setCodigoResponsavel(textCodigoResponsavel.getText());
					cadastrarPromocao.setCargoResponsavel(textCargoResponsavel.getText());
					cadastrarPromocao.setTipoPromocao(textTipoPromocao.getText());
					cadastrarPromocao.setDescricaoPromocao(textAreaDescricao.getText());
					
					String estadoPromocaoTexto = "Em andamento";
					cadastrarPromocao.setEstadoPromocao(estadoPromocaoTexto);
					
					if (nomeUsuario == null) {
						String nomeFuncionario = "Nome";
						cadastrarPromocao.setFuncionarioCadastro(nomeFuncionario);
					}
					else {
						cadastrarPromocao.setFuncionarioCadastro(nomeUsuario);
					}
					
					if (codigoUsuario == null) {
						String codigoFuncionario = "Codigo";
						cadastrarPromocao.setCodigoFuncionario(codigoFuncionario);
					}
					else {
						cadastrarPromocao.setCodigoFuncionario(codigoUsuario);
					}
					
					if (cargoUsuario == null) {
						String cargoFuncionario = "Cargo";
						cadastrarPromocao.setCargoFuncionario(cargoFuncionario);
					}
					else {
						cadastrarPromocao.setCargoFuncionario(cargoUsuario);
					}
					
					String dataInicioTexto = textDataInicio.getText();
					try {
						SimpleDateFormat dataInicioFormato = new SimpleDateFormat("dd/MM/yyyy");
						Date dataInicio = new java.sql.Date(dataInicioFormato.parse(dataInicioTexto).getTime());
						cadastrarPromocao.setDataInicio(dataInicio);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					String horaInicioTexto = textHoraInicio.getText();
					try {
						SimpleDateFormat horaInicioFormato = new SimpleDateFormat("HH:mm");
						Time horaInicio = new java.sql.Time(horaInicioFormato.parse(horaInicioTexto).getTime());
						cadastrarPromocao.setHoraInicio(horaInicio);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					String dataTerminoTexto = textDataTermino.getText();
					try {
						SimpleDateFormat dataTerminoFormato = new SimpleDateFormat("dd/MM/yyyy");
						Date dataTermino = new java.sql.Date(dataTerminoFormato.parse(dataTerminoTexto).getTime());
						cadastrarPromocao.setDataTermino(dataTermino);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					String horaTerminoTexto = textHoraTermino.getText();
					try {
						SimpleDateFormat horaTerminoFormato = new SimpleDateFormat("HH:mm");
						Time horaTermino = new java.sql.Time(horaTerminoFormato.parse(horaTerminoTexto).getTime());
						cadastrarPromocao.setHoraTermino(horaTermino);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					try {
						java.util.Date dataRegistro = new java.util.Date();
						SimpleDateFormat dataRegistroFormato = new SimpleDateFormat("dd/MM/yyyy");
						String dataCadastroFuncionario = dataRegistroFormato.format(dataRegistro);
						SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
						Date dataCadastro = new java.sql.Date(dataCadastroFormato.parse(dataCadastroFuncionario).getTime());
						cadastrarPromocao.setDataCadastro(dataCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
					}
					
					try {
						java.util.Date horaRegistro = new java.util.Date();
						SimpleDateFormat horaRegistroFormato = new SimpleDateFormat("HH:mm");
						String horaCadastroFuncionario = horaRegistroFormato.format(horaRegistro);
						SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
						Time horaCadastro = new java.sql.Time(horaCadastroFormato.parse(horaCadastroFuncionario).getTime());
						cadastrarPromocao.setHoraCadastro(horaCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
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
					cadastrarPromocao.setCodigoPromocao(codigoRegistro);
					
					salvarDadosPromocao = new Dao_inserir_dados_promocao();
					salvarDadosPromocao.Inserir_Dados_Promocao(cadastrarPromocao);
					
					/*Envia os dados da lista de produtos da tabela para o banco de dados*/
					cadastrarPromocaoProdutos = new PromocaoProdutos();
					List<PromocaoProdutos> listaPromocaoProdutos = new ArrayList<PromocaoProdutos>();
					int linhasTabela = tabelaProdutos.getRowCount();
					for (int i = 0; i < linhasTabela; i++) {
						cadastrarPromocaoProdutos.setCodigoProduto((String) tabelaProdutos.getModel().getValueAt(i, 0));
						cadastrarPromocaoProdutos.setNomeProduto((String) tabelaProdutos.getModel().getValueAt(i, 1));
						cadastrarPromocaoProdutos.setPrecoNormal(Double.parseDouble((String) tabelaProdutos.getModel().getValueAt(i, 2)));
						cadastrarPromocaoProdutos.setDescontoPorcentagem(Double.parseDouble((String) tabelaProdutos.getModel().getValueAt(i, 3)));
						cadastrarPromocaoProdutos.setPrecoDesconto(Double.parseDouble((String) tabelaProdutos.getModel().getValueAt(i, 4)));
						cadastrarPromocaoProdutos.setCodigoPromocao(codigoRegistro);
						listaPromocaoProdutos.add(cadastrarPromocaoProdutos);
					}
					
					for (PromocaoProdutos cadastrarListaProdutos : listaPromocaoProdutos) {
						salvarDadosPromocaoProdutos = new Dao_inserir_dados_promocao_produtos();
						salvarDadosPromocaoProdutos.Inserir_Dados_Promocao(cadastrarListaProdutos);
					}
					
					String menssagemConteudo = "Promoção cadastrada com sucesso";
					Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
					mensagemConfirmacao.setVisible(true);
					
					Descontos_e_Promocoes telaDescontosPromocoes = new Descontos_e_Promocoes();
					telaDescontosPromocoes.setVisible(true); 
		            dispose();
				}
			}
		});
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(salvar);
		
		adicionarResponsavel = new JButton("Responsavel");
		adicionarResponsavel.setToolTipText("Adicionar o responsavel da promo\u00E7\u00E3o");
		adicionarResponsavel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Descontos_e_Promocoes_Adicionar_Responsavel DescontosPromocoesAdicionarResponsavel = new Descontos_e_Promocoes_Adicionar_Responsavel();
				DescontosPromocoesAdicionarResponsavel.setVisible(true);
				
				String resultadoNomeFuncionario = DescontosPromocoesAdicionarResponsavel.getNomeFuncionario();
				String resultadoCodigoFuncionario = DescontosPromocoesAdicionarResponsavel.getCodigoFuncionario();
				String resultadoCargoFuncionario = DescontosPromocoesAdicionarResponsavel.getCargoFuncionario();
				
				if (resultadoNomeFuncionario != null || resultadoCodigoFuncionario != null || resultadoCargoFuncionario != null) {
					textNomeResponsavel.setText(resultadoNomeFuncionario);
					textCodigoResponsavel.setText(resultadoCodigoFuncionario);
					textCargoResponsavel.setText(resultadoCargoFuncionario);
				}
			}
		});
		adicionarResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(adicionarResponsavel);
		
		adicionarProduto = new JButton("Adicionar");
		adicionarProduto.setToolTipText("Adicionar um produto a lista de produtos da promo\u00E7\u00E3o");
		adicionarProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		adicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Descontos_e_Promocoes_Promocao_Adicionar_Produto telaAdicionarProdutoPromocao = new Descontos_e_Promocoes_Promocao_Adicionar_Produto();
				telaAdicionarProdutoPromocao.setVisible(true);
				
				String codigoProduto = telaAdicionarProdutoPromocao.getCodigoProduto();
				String nomeProduto = telaAdicionarProdutoPromocao.getNomeProduto();
				double precoNormal = telaAdicionarProdutoPromocao.getPrecoProduto();
				double porcentagemDesconto = telaAdicionarProdutoPromocao.getDescontoProduto();
				
				if (codigoProduto != null || nomeProduto != null || precoNormal != 0 || porcentagemDesconto != 0) {
					
					String precoNormalTexto = "" + precoNormal;
					String porcentagemDescontoTexto = "" + porcentagemDesconto;
					
					double precoDescontoValor = ((precoNormal * porcentagemDesconto) / 100);
					double precoDescontoTotal = precoNormal - precoDescontoValor;
					String precoDescontoTotalTexto = "" + precoDescontoTotal;
					
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
					
					PromocaoProdutosTabela nLista = new PromocaoProdutosTabela(codigoProduto, nomeProduto, precoNormalTexto, porcentagemDescontoTexto, precoDescontoTotalTexto);
					TabelaModeloPromocaoProdutos.addPromocaoProdutos(nLista);
				}
			}
		});
		panelBotoes2.add(adicionarProduto);
		
		removerProduto = new JButton("Remover");
		removerProduto.setToolTipText("Remover um produto da lista da de produtos da promo\u00E7\u00E3o");
		removerProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menssagemTexto = "Deseja Remover o produto?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo avisoLimparCampos = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemTexto);
				avisoLimparCampos.setVisible(true);
				String avisoLimparCamposTexto = avisoLimparCampos.getResposta();
				if (avisoLimparCamposTexto != null) {
					if (avisoLimparCamposTexto.equals("Sim")) {

						if (tabelaProdutos.getSelectedRow() != -1 && tabelaProdutos.getSelectedRow() < TabelaModeloPromocaoProdutos.getRowCount()) {
							int linhaSelecionada = tabelaProdutos.getSelectedRow();
							TabelaModeloPromocaoProdutos.removerPromocaoProdutos(linhaSelecionada);
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
		removerProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(removerProduto);
		
		limparCampos = new JButton("Limpar");
		limparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemConteudo = "Deseja limpar os campos ?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo avisoLimparCampos = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemConteudo);
				avisoLimparCampos.setVisible(true);
				String avisoLimparCamposTexto = avisoLimparCampos.getResposta();
				if (avisoLimparCamposTexto != null) {
					if (avisoLimparCamposTexto.equals("Sim")) {
						textNomePromocao.setText("");
						textNomeResponsavel.setText("");
						textCodigoResponsavel.setText("");
						textCargoResponsavel.setText("");
						textTipoPromocao.setText("");
						textDataInicio.setText("");
						textDataTermino.setText("");
						textHoraInicio.setText("");
						textHoraTermino.setText("");
						textAreaDescricao.setText("");
					}
				}
			}
		});
		limparCampos.setToolTipText("Limpa os campos");
		limparCampos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(limparCampos);
		
		cancelar = new JButton("Cancelar");
		cancelar.setToolTipText("Fecha a janela");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNomePromocao.getText().length() != 0 || textNomeResponsavel.getText().length() != 0 || textCodigoResponsavel.getText().length() != 0 ||
					textCargoResponsavel.getText().length() != 0 || textTipoPromocao.getText().length() != 0 ||
					textDataInicio.getText().replaceAll("\\/", "").trim().length() != 0 || textDataTermino.getText().replaceAll("\\/", "").trim().length() != 0 ||
					textHoraInicio.getText().replace(":","").trim().length() != 0 || textHoraTermino.getText().replace(":","").trim().length() != 0 ||
					textAreaDescricao.getText().length() != 0 || TabelaModeloPromocaoProdutos.getRowCount() != 0) {
						String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
						aviso.setVisible(true);
						String resposta = aviso.getResposta();
						if (resposta != null) {
							if (resposta.equals("Sim")) {
								Descontos_e_Promocoes telaDescontosPromocoes = new Descontos_e_Promocoes();
								telaDescontosPromocoes.setVisible(true); 
					            dispose();
							}
						}
				}
				else {
					Descontos_e_Promocoes telaDescontosPromocoes = new Descontos_e_Promocoes();
					telaDescontosPromocoes.setVisible(true); 
		            dispose();
				}
			}
		});
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(cancelar);
		
		/*Ação do botao sair da janela*/
		addWindowListener(
            new WindowAdapter() 
            {
                public void windowClosing(WindowEvent we) {
                	if (textNomePromocao.getText().length() != 0 || textNomeResponsavel.getText().length() != 0 || textCodigoResponsavel.getText().length() != 0 ||
    					textCargoResponsavel.getText().length() != 0 || textTipoPromocao.getText().length() != 0 ||
    					textDataInicio.getText().replaceAll("\\/", "").trim().length() != 0 || textDataTermino.getText().replaceAll("\\/", "").trim().length() != 0 ||
    					textHoraInicio.getText().replace(":","").trim().length() != 0 || textHoraTermino.getText().replace(":","").trim().length() != 0 ||
    					textAreaDescricao.getText().length() != 0 || TabelaModeloPromocaoProdutos.getRowCount() != 0) {
	                		String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
    						aviso.setVisible(true);
    						String resposta = aviso.getResposta();
    						if (resposta != null) {
    							if (resposta.equals("Sim")) {
    								Descontos_e_Promocoes telaDescontosPromocoes = new Descontos_e_Promocoes();
    								telaDescontosPromocoes.setVisible(true); 
    					            dispose();
    							}
    						}
    				}
    				else {
    					Descontos_e_Promocoes telaDescontosPromocoes = new Descontos_e_Promocoes();
    					telaDescontosPromocoes.setVisible(true); 
    		            dispose();
    				}
                }
            }
	    );
	}
}