package moduloProdutoDescontoPromocaoTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoDescontoPromocaoBD.Dao_alterar_dados_promocao_desconto;
import moduloProdutoDescontoPromocaoBD.Dao_consulta_dados_promocao;
import moduloProdutoDescontoPromocaoBD.Promocao;

public class Descontos_e_Promocoes_Ficha_Promocoes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaPromocao;
	private JButton exibirListaProdutos, cancelarPromocao, voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Descontos_e_Promocoes_Ficha_Promocoes frame = new Descontos_e_Promocoes_Ficha_Promocoes();
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
	public Descontos_e_Promocoes_Ficha_Promocoes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Descontos_e_Promocoes_Ficha_Promocoes.class.getResource("/cImagens/Logo Janela.PNG")));
		setResizable(false);
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		setSize(800, 450);
		
		telaFichaPromocao = new JPanel();
		telaFichaPromocao.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaPromocao.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaPromocao);
		
		JPanel panelTitulo = new JPanel();
		telaFichaPromocao.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Descontos_e_Promocoes_Ficha_Promocoes.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFichaPromocao = new JLabel("Ficha de promo\u00E7\u00E3o");
		panelTitulo2.add(labelFichaPromocao);
		labelFichaPromocao.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Descontos_e_Promocoes_Ficha_Promocoes.class.getResource("/cImagens/Funcionario.png")));
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
		
		JTabbedPane tabbedPanePromocao = new JTabbedPane(JTabbedPane.TOP);
		telaFichaPromocao.add(tabbedPanePromocao, BorderLayout.CENTER);
		
		JPanel panelPromocaoFicha = new JPanel();
		tabbedPanePromocao.addTab("Dados gerais", null, panelPromocaoFicha, null);
		panelPromocaoFicha.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPanePromocao = new JScrollPane();
		panelPromocaoFicha.add(scrollPanePromocao);
		
		JPanel panelPromocao = new JPanel();
		scrollPanePromocao.setViewportView(panelPromocao);
		panelPromocao.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNomePromocao = new JPanel();
		panelPromocao.add(panelNomePromocao);
		panelNomePromocao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomePromocao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomePromocao = new JLabel("Nome da promo\u00E7\u00E3o");
		labelNomePromocao.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomePromocao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomePromocao.add(labelNomePromocao);
		
		JLabel nomePromocao = new JLabel();
		nomePromocao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomePromocao.add(nomePromocao);
		
		JPanel panelTipoPromocao = new JPanel();
		panelPromocao.add(panelTipoPromocao);
		panelTipoPromocao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTipoPromocao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoPromocao = new JLabel("Tipo de promo\u00E7\u00E3o");
		panelTipoPromocao.add(labelTipoPromocao);
		labelTipoPromocao.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoPromocao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel tipoPromocao = new JLabel();
		panelTipoPromocao.add(tipoPromocao);
		tipoPromocao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelPromocao_DataHora = new JPanel();
		panelPromocao_DataHora.setPreferredSize(new Dimension(10, 50));
		panelPromocao.add(panelPromocao_DataHora);
		panelPromocao_DataHora.setLayout(new GridLayout(0, 5, 5, 0));
		
		JPanel panelEstadoPromocao = new JPanel();
		panelEstadoPromocao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPromocao_DataHora.add(panelEstadoPromocao);
		panelEstadoPromocao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstadoPromocao = new JLabel("Estado da promo\u00E7\u00E3o");
		labelEstadoPromocao.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstadoPromocao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoPromocao.add(labelEstadoPromocao);
		
		JLabel estadoPromocao = new JLabel();
		estadoPromocao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoPromocao.add(estadoPromocao);
		
		JPanel panelCodigoPromocao = new JPanel();
		panelPromocao_DataHora.add(panelCodigoPromocao);
		panelCodigoPromocao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoPromocao.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoPromocao = new JLabel("Codigo da promocao");
		labelCodigoPromocao.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoPromocao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoPromocao.add(labelCodigoPromocao);
		
		JLabel codigoPromocao = new JLabel();
		codigoPromocao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoPromocao.add(codigoPromocao);
		
		JPanel panelDataHoraInicio = new JPanel();
		panelPromocao_DataHora.add(panelDataHoraInicio);
		panelDataHoraInicio.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHoraInicio.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraInicio = new JLabel("Data e hora de inicio");
		panelDataHoraInicio.add(labelDataHoraInicio);
		labelDataHoraInicio.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel dataHoraInicio = new JLabel();
		panelDataHoraInicio.add(dataHoraInicio);
		dataHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelDataHoraTermino = new JPanel();
		panelDataHoraTermino.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPromocao_DataHora.add(panelDataHoraTermino);
		panelDataHoraTermino.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraTermino = new JLabel("Data e hora de termino");
		labelDataHoraTermino.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraTermino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraTermino.add(labelDataHoraTermino);
		
		JLabel dataHoraTermino = new JLabel();
		dataHoraTermino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraTermino.add(dataHoraTermino);
		
		JPanel panelDataHoraCadastro = new JPanel();
		panelPromocao_DataHora.add(panelDataHoraCadastro);
		panelDataHoraCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHoraCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraCadastro = new JLabel("Data e hora de cadastro");
		labelDataHoraCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraCadastro.add(labelDataHoraCadastro);
		
		JLabel dataHoraCadastro = new JLabel();
		dataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraCadastro.add(dataHoraCadastro);
		
		JPanel panelFuncionarioResponsavel = new JPanel();
		panelPromocao.add(panelFuncionarioResponsavel);
		panelFuncionarioResponsavel.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeResponsavel = new JPanel();
		panelNomeResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFuncionarioResponsavel.add(panelNomeResponsavel);
		panelNomeResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeResponsavel = new JLabel("Nome do responsavel");
		labelNomeResponsavel.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeResponsavel.add(labelNomeResponsavel);
		
		JLabel nomeResponsavel = new JLabel();
		nomeResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeResponsavel.add(nomeResponsavel);
		
		JPanel panelCargo_Codigo_Responsavel = new JPanel();
		panelFuncionarioResponsavel.add(panelCargo_Codigo_Responsavel);
		panelCargo_Codigo_Responsavel.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargoResponsavel = new JPanel();
		panelCargo_Codigo_Responsavel.add(panelCargoResponsavel);
		panelCargoResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargoResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargoResponsavel = new JLabel("Cargo do responsavel");
		labelCargoResponsavel.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargoResponsavel.add(labelCargoResponsavel);
		
		JLabel cargoResponsavel = new JLabel();
		cargoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargoResponsavel.add(cargoResponsavel);
		
		JPanel panelCodigoResponsavel = new JPanel();
		panelCargo_Codigo_Responsavel.add(panelCodigoResponsavel);
		panelCodigoResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoResponsavel = new JLabel("Codigo do responsavel");
		labelCodigoResponsavel.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoResponsavel.add(labelCodigoResponsavel);
		
		JLabel codigoResponsavel = new JLabel();
		codigoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoResponsavel.add(codigoResponsavel);
		
		JPanel panelFuncionarioCadastro = new JPanel();
		panelPromocao.add(panelFuncionarioCadastro);
		panelFuncionarioCadastro.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeFuncionarioCadastro = new JPanel();
		panelNomeFuncionarioCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFuncionarioCadastro.add(panelNomeFuncionarioCadastro);
		panelNomeFuncionarioCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFuncionarioResponsavel = new JLabel("Funcionario que cadastrou");
		panelNomeFuncionarioCadastro.add(labelFuncionarioResponsavel);
		labelFuncionarioResponsavel.setHorizontalAlignment(SwingConstants.LEFT);
		labelFuncionarioResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel nomeFuncionarioResponsavel = new JLabel();
		panelNomeFuncionarioCadastro.add(nomeFuncionarioResponsavel);
		nomeFuncionarioResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCargo_Codigo_Funcionario = new JPanel();
		panelFuncionarioCadastro.add(panelCargo_Codigo_Funcionario);
		panelCargo_Codigo_Funcionario.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargoFuncionarioCadastro = new JPanel();
		panelCargoFuncionarioCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_Codigo_Funcionario.add(panelCargoFuncionarioCadastro);
		panelCargoFuncionarioCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargoFuncionarioCadastro = new JLabel("Cargo do funcionario");
		labelCargoFuncionarioCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargoFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargoFuncionarioCadastro.add(labelCargoFuncionarioCadastro);
		
		JLabel cargoFuncionarioCadastro = new JLabel();
		cargoFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargoFuncionarioCadastro.add(cargoFuncionarioCadastro);
		
		JPanel panelCodigoFuncionarioCadastro = new JPanel();
		panelCodigoFuncionarioCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_Codigo_Funcionario.add(panelCodigoFuncionarioCadastro);
		panelCodigoFuncionarioCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoFuncionarioCadastro = new JLabel("Codigo do funcionario");
		labelCodigoFuncionarioCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFuncionarioCadastro.add(labelCodigoFuncionarioCadastro);
		
		JLabel codigoFuncionarioCadastro = new JLabel();
		codigoFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFuncionarioCadastro.add(codigoFuncionarioCadastro);
		
		JPanel panelDescricao = new JPanel();
		tabbedPanePromocao.addTab("Descri\u00E7\u00E3o da promo\u00E7\u00E3o", null, panelDescricao, null);
		panelDescricao.setLayout(new BorderLayout(0, 10));
		
		JLabel labelDescricao = new JLabel("Descri\u00E7\u00E3o da promo\u00E7\u00E3o");
		labelDescricao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelDescricao.add(labelDescricao, BorderLayout.NORTH);
		
		JScrollPane scrollPaneDescricao = new JScrollPane();
		scrollPaneDescricao.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneDescricao.getHorizontalScrollBar().setUnitIncrement(10);
		panelDescricao.add(scrollPaneDescricao);
		
		JTextPane textPaneDescricao = new JTextPane();
		textPaneDescricao.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textPaneDescricao.setEditable(false);
		scrollPaneDescricao.setViewportView(textPaneDescricao);
		
		String codigoPromocaoFicha = sessao.getCodigoPromocaoFicha();
		
		/*Parte que consulta os dados no banco de dados*/
		Dao_consulta_dados_promocao consultaDadosPromocaoFicha = new Dao_consulta_dados_promocao();
    	List<Promocao> consultaPromocaoFicha = consultaDadosPromocaoFicha.Consulta_Dados_Promocao_Ficha(codigoPromocaoFicha);
    	for (Promocao leitura : consultaPromocaoFicha) {
    		nomePromocao.setText(leitura.getNomePromocao());
    		codigoPromocao.setText(leitura.getCodigoPromocao());
    		estadoPromocao.setText(leitura.getEstadoPromocao());
    		
    		nomeResponsavel.setText(leitura.getNomeResponsavel());
    		cargoResponsavel.setText(leitura.getCargoResponsavel());
    		codigoResponsavel.setText(leitura.getCodigoResponsavel());
    		
    		tipoPromocao.setText(leitura.getTipoPromocao());
    		
    		Date dataInicio = leitura.getDataInicio();
    		SimpleDateFormat dataInicioFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataInicioTexto = dataInicioFormato.format(dataInicio);
    		Time horaInicio = leitura.getHoraInicio();
    		SimpleDateFormat horaInicioFormato = new SimpleDateFormat("HH:mm");
    		String horaInicioTexto = horaInicioFormato.format(horaInicio);
    		String dataHoraInicioTexto = dataInicioTexto + " " + horaInicioTexto;
    		dataHoraInicio.setText(dataHoraInicioTexto);
    		
    		Date dataTermino = leitura.getDataTermino();
    		SimpleDateFormat dataTerminoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataTerminoTexto = dataTerminoFormato.format(dataTermino);
    		Time horaTermino = leitura.getHoraTermino();
    		SimpleDateFormat horaTerminoFormato = new SimpleDateFormat("HH:mm");
    		String horaTerminoTexto = horaTerminoFormato.format(horaTermino);
    		String dataHoraTerminoTexto = dataTerminoTexto + " " + horaTerminoTexto;
    		dataHoraTermino.setText(dataHoraTerminoTexto);
    		
    		Date dataCadastro = leitura.getDataCadastro();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroTexto = dataCadastroFormato.format(dataCadastro);
    		Time horaCadastro = leitura.getHoraCadastro();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroTexto = horaCadastroFormato.format(horaCadastro);
    		String dataHoraCadastroTexto = dataCadastroTexto + " " + horaCadastroTexto;
    		dataHoraCadastro.setText(dataHoraCadastroTexto);
    		
    		String descricaoPromocaoTexto = leitura.getDescricaoPromocao();
    		textPaneDescricao.setText(descricaoPromocaoTexto);
    		
    		nomeFuncionarioResponsavel.setText(leitura.getFuncionarioCadastro());
    		cargoFuncionarioCadastro.setText(leitura.getCargoFuncionario());
    		codigoFuncionarioCadastro.setText(leitura.getCodigoFuncionario());
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaPromocao.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		cancelarPromocao = new JButton("Cancelar promo\u00E7\u00E3o");
		cancelarPromocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemTitulo = "Cancelamento da promoção";
				String menssagemConteudo = "Deseja cancelar o promoção ?";
				Tela_que_Exibe_Menssagem_Sim_Nao telaCancelarPromocao = new Tela_que_Exibe_Menssagem_Sim_Nao(menssagemTitulo, menssagemConteudo);
				telaCancelarPromocao.setVisible(true);
				String cancelarPromocaoTexto = telaCancelarPromocao.getResposta();
				if (cancelarPromocaoTexto != null) {
					if (cancelarPromocaoTexto.equals("Sim")) {
							Promocao alterarNovosDadosPromocao = new Promocao();
							String estadoPromocaoTexto = "Cancelada";
							alterarNovosDadosPromocao.setEstadoPromocao(estadoPromocaoTexto);
							alterarNovosDadosPromocao.setCodigoPromocao(codigoPromocao.getText());
							Dao_alterar_dados_promocao_desconto salvaNovosDadosPromocao = new Dao_alterar_dados_promocao_desconto();
							salvaNovosDadosPromocao.Altera_Dados_Estado_Promocao(alterarNovosDadosPromocao);
							
							String menssagemConteudoTitulo = "Promoção cancelada";
							Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudoTitulo);
							mensagemConfirmacao.setVisible(true);
							
							setVisible(false);
					}
				}
			}
		});
		cancelarPromocao.setToolTipText("Cancelar promo\u00E7\u00E3o");
		cancelarPromocao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(cancelarPromocao);
		
		exibirListaProdutos = new JButton("Exibir lista de produtos");
		exibirListaProdutos.setToolTipText("Exibir lista de produtos da promo\u00E7\u00E3o");
		exibirListaProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sessao.setCodigoPromocaoFicha(codigoPromocaoFicha);
				Descontos_e_Promocoes_Lista_de_Produtos exibeListaProdutos = new Descontos_e_Promocoes_Lista_de_Produtos();
				exibeListaProdutos.setVisible(true);
			}
		});
		exibirListaProdutos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(exibirListaProdutos);
		
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
	private double porcentagemDescontoValor, descontoPrecoTotal, precoTotalParcelado;
	private int quantidadeParcelasVenda;
	/*get e set Valor de porcentagem do desconto*/
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
	
	/*get e set Preco de cada parcela*/
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
}