package moduloFuncionarioTelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import aInterfaceSistema.Sessao;
import moduloFuncionarioBD.Dao_alterar_dados_funcionario_historico;
import moduloFuncionarioBD.Dao_consulta_dados_funcionario_historico;
import moduloFuncionarioBD.Dao_inserir_dados_funcionario_historico_faltas;
import moduloFuncionarioBD.FuncionarioFrequencia;
import moduloFuncionarioBD.FuncionarioFrequenciaFaltas;
import moduloFuncionarioTabelas.FuncionariosTabelaFaltas;
import moduloFuncionarioTabelas.TabelaModeloFuncionariosFrequencia;

public class Funcionarios_Controle_de_Faltas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaControleFaltas;
	private JTable tabelaHistoricoFrequencia;
	private TabelaModeloFuncionariosFrequencia TabelaModeloFrequencia;
	private JButton produtoBusca, voltar, frequenciaFuncionario;
	private JTextField textBusca;
	FuncionarioFrequenciaFaltas cadastrarFrequenciaFaltas;
	FuncionarioFrequencia alterarFrequenciaFaltas;
	Dao_inserir_dados_funcionario_historico_faltas salvaDadosFrequenciaFaltas;
	Dao_alterar_dados_funcionario_historico salvaNovosDadosFrequenciaFaltas;
	Sessao sessao = Sessao.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionarios_Controle_de_Faltas frame = new Funcionarios_Controle_de_Faltas();
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
	public Funcionarios_Controle_de_Faltas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Funcionarios_Controle_de_Faltas.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setSize(700, 600);
		
		telaControleFaltas = new JPanel();
		telaControleFaltas.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaControleFaltas.setLayout(new BorderLayout(0, 5));
		setContentPane(telaControleFaltas);
		
		JPanel panelTitulo = new JPanel();
		telaControleFaltas.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Funcionarios_Controle_de_Faltas.class.getResource("/cImagens/Controle de faltas.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelControleFaltas = new JLabel("Controle de faltas");
		panelTitulo2.add(labelControleFaltas);
		labelControleFaltas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Funcionarios_Controle_de_Faltas.class.getResource("/cImagens/Funcionario.png")));
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
		
		/*Parte da ficha dados do historico de frequencia do funcionario*/
		JPanel panelHistoricoFrequencia = new JPanel();
		telaControleFaltas.add(panelHistoricoFrequencia, BorderLayout.CENTER);
		panelHistoricoFrequencia.setLayout(new BorderLayout(0, 5));
		
		JPanel panelHistoricoFrequenciaDados = new JPanel();
		panelHistoricoFrequencia.add(panelHistoricoFrequenciaDados, BorderLayout.NORTH);
		panelHistoricoFrequenciaDados.setLayout(new BorderLayout(0, 5));
		
		JPanel panelDadosFuncionario = new JPanel();
		panelHistoricoFrequenciaDados.add(panelDadosFuncionario, BorderLayout.NORTH);
		panelDadosFuncionario.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelNome_Cod_Cargo_Fun = new JPanel();
		panelDadosFuncionario.add(panelNome_Cod_Cargo_Fun);
		panelNome_Cod_Cargo_Fun.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeFuncionario = new JPanel();
		panelNomeFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome_Cod_Cargo_Fun.add(panelNomeFuncionario);
		panelNomeFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeFuncionario = new JLabel("Nome do funcionario");
		labelNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelNomeFuncionario.add(labelNomeFuncionario);
		
		JLabel nomeFuncionario = new JLabel("xxxxxxxx");
		nomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelNomeFuncionario.add(nomeFuncionario);
		
		JPanel panelCargo_Codigo_Fun = new JPanel();
		panelNome_Cod_Cargo_Fun.add(panelCargo_Codigo_Fun);
		panelCargo_Codigo_Fun.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargoFuncionario = new JPanel();
		panelCargoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_Codigo_Fun.add(panelCargoFuncionario);
		panelCargoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargoFuncionario = new JLabel("Cargo do funcionario");
		labelCargoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCargoFuncionario.add(labelCargoFuncionario);
		
		JLabel cargoFuncionario = new JLabel("xxxxxxxx");
		cargoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCargoFuncionario.add(cargoFuncionario);
		
		JPanel panelCodigoFuncionario = new JPanel();
		panelCodigoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_Codigo_Fun.add(panelCodigoFuncionario);
		panelCodigoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoFuncionario = new JLabel("Codigo do funcionario");
		labelCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCodigoFuncionario.add(labelCodigoFuncionario);
		
		JLabel codigoFuncionario = new JLabel("xxxxxxxx");
		codigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCodigoFuncionario.add(codigoFuncionario);
		
		JPanel panelFrequenciaFuncionario = new JPanel();
		panelDadosFuncionario.add(panelFrequenciaFuncionario);
		panelFrequenciaFuncionario.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelMaximoFaltas = new JPanel();
		panelMaximoFaltas.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFrequenciaFuncionario.add(panelMaximoFaltas);
		panelMaximoFaltas.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelMaximoFaltas = new JLabel("Maximo de faltas");
		labelMaximoFaltas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelMaximoFaltas.add(labelMaximoFaltas);
		
		JLabel maximoFaltas = new JLabel("0");
		maximoFaltas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelMaximoFaltas.add(maximoFaltas);
		
		JPanel panelPresencasTotal = new JPanel();
		panelPresencasTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFrequenciaFuncionario.add(panelPresencasTotal);
		panelPresencasTotal.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPresencasTotal = new JLabel("Presen\u00E7as");
		labelPresencasTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelPresencasTotal.add(labelPresencasTotal);
		
		JLabel presencasTotal = new JLabel("0");
		presencasTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelPresencasTotal.add(presencasTotal);
		
		JPanel panelFaltasTotal = new JPanel();
		panelFaltasTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFrequenciaFuncionario.add(panelFaltasTotal);
		panelFaltasTotal.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFaltasTotal = new JLabel("Faltas");
		labelFaltasTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelFaltasTotal.add(labelFaltasTotal);
		
		JLabel faltasTotal = new JLabel("0");
		faltasTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelFaltasTotal.add(faltasTotal);
		
		JPanel panelTurno_CargaHoraria = new JPanel();
		panelDadosFuncionario.add(panelTurno_CargaHoraria);
		panelTurno_CargaHoraria.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelTurnoHorario = new JPanel();
		panelTurno_CargaHoraria.add(panelTurnoHorario);
		panelTurnoHorario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTurnoHorario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTurnoHorario = new JLabel("Turno");
		labelTurnoHorario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTurnoHorario.add(labelTurnoHorario);
		
		JLabel turnoHorario = new JLabel("xx:xx - xx:xx");
		turnoHorario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTurnoHorario.add(turnoHorario);
		
		JPanel panelCargaHoraria = new JPanel();
		panelTurno_CargaHoraria.add(panelCargaHoraria);
		panelCargaHoraria.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargaHoraria.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargaHoraria = new JLabel("Carga horaria");
		labelCargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCargaHoraria.add(labelCargaHoraria);
		
		JLabel cargaHoraria = new JLabel("xxxxxxxx");
		cargaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCargaHoraria.add(cargaHoraria);
		
		/*Busca na tabela de estoque*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelHistoricoFrequenciaDados.add(panelBusca, BorderLayout.SOUTH);
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
		
		/*Tabela com a lista do controle de faltas*/
		JScrollPane scrollPaneHistoricoFrequencia = new JScrollPane();
		panelHistoricoFrequencia.add(scrollPaneHistoricoFrequencia);
		TabelaModeloFrequencia = new TabelaModeloFuncionariosFrequencia();
		tabelaHistoricoFrequencia = new JTable();
		tabelaHistoricoFrequencia.setModel(TabelaModeloFrequencia);
		scrollPaneHistoricoFrequencia.setViewportView(tabelaHistoricoFrequencia);

		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloFuncionariosFrequencia> sorterBuscaHistoricoFrequencia = new TableRowSorter<TabelaModeloFuncionariosFrequencia>(TabelaModeloFrequencia);
		tabelaHistoricoFrequencia.setRowSorter(sorterBuscaHistoricoFrequencia);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaHistoricoFrequencia.setRowFilter(null);
				}
				else {
					sorterBuscaHistoricoFrequencia.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaHistoricoFrequencia.setRowFilter(null);
					}
					else {
						sorterBuscaHistoricoFrequencia.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que coloca os dados do banco de dados na tabela*/
		String codigoFuncionarioConsulta = sessao.getCodigoFuncionario();
		String nomeFuncionarioConsulta = sessao.getNomeFuncionario();
		String cargoFuncionarioConsulta = sessao.getCargoFuncionario();
		
		Dao_consulta_dados_funcionario_historico ConsultaFuncionarioFrequencia = new Dao_consulta_dados_funcionario_historico();
    	List<FuncionarioFrequenciaFaltas> ConsultaListaFalta = ConsultaFuncionarioFrequencia.Consulta_Dados_Funcionarios_Frequencia_Lista(codigoFuncionarioConsulta, nomeFuncionarioConsulta, cargoFuncionarioConsulta);
		for (FuncionarioFrequenciaFaltas leitura : ConsultaListaFalta) {
			String frequenciaFuncionarioTexto = leitura.getFrequencia();
			
			Date dataTrabalhoFuncionario =	leitura.getDataTrabalho();
    		SimpleDateFormat dataTrabalhoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataTrabalhoTexto = dataTrabalhoFormato.format(dataTrabalhoFuncionario);
			
    		Time horaCadastroFrequencia = leitura.getHoraCadastro();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroFrequencia);
    		
			FuncionariosTabelaFaltas listaFuncionariosFrequencia = new FuncionariosTabelaFaltas(dataTrabalhoTexto, horaCadastroValor, frequenciaFuncionarioTexto);
    		TabelaModeloFrequencia.addFuncionarioFrequencia(listaFuncionariosFrequencia);
		}
		
		List<FuncionarioFrequencia> Consulta = ConsultaFuncionarioFrequencia.Consulta_Dados_Funcionariso_Historico_Lista(codigoFuncionarioConsulta, nomeFuncionarioConsulta, cargoFuncionarioConsulta);
		for (FuncionarioFrequencia leitura : Consulta) {
			String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
			codigoFuncionario.setText(codigoFuncionarioTexto);
			
			String nomeFuncionarioTexto = leitura.getNomeFuncionario();
			nomeFuncionario.setText(nomeFuncionarioTexto);
			
			String cargoFuncionarioTexto = leitura.getCargoFuncionario();
			cargoFuncionario.setText(cargoFuncionarioTexto);
			
			int maximoFaltaValor = leitura.getValorMaximoFalta();
			String maximoFaltaTexto = "" + maximoFaltaValor;
			maximoFaltas.setText(maximoFaltaTexto);
			
			int presencaValor = leitura.getPresencaTotal();
			String presencaTexto = "" + presencaValor;
			presencasTotal.setText(presencaTexto);
			
			int faltaValor = leitura.getFaltaTotal();
			String faltaTexto = "" + faltaValor;
			faltasTotal.setText(faltaTexto);
			
			Time horaInicioFuncionario = leitura.getHoraEntrada();
    		SimpleDateFormat horaInicioFormato = new SimpleDateFormat("HH:mm");
    		String horaInicioValor = horaInicioFormato.format(horaInicioFuncionario);
    		Time horaSaidaFuncionario = leitura.getHoraSaida();
    		SimpleDateFormat horaSaidaFormato = new SimpleDateFormat("HH:mm");
    		String horaSaidaValor = horaSaidaFormato.format(horaSaidaFuncionario);
    		String horaTurnoHorarioTexto = horaInicioValor + " - " + horaSaidaValor;
    		turnoHorario.setText(horaTurnoHorarioTexto);
    		
			String cargaHorariaValor = leitura.getCargaHoraria();
			String cargaHorariaUnidade = leitura.getCargaHorariaUnidade();
			String cargaHorariaTexto = cargaHorariaValor + " " + cargaHorariaUnidade;
			cargaHoraria.setText(cargaHorariaTexto);
		}
		
		JPanel panelBotoes = new JPanel();
		telaControleFaltas.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		frequenciaFuncionario = new JButton("Frequencia");
		frequenciaFuncionario.setToolTipText("Adicionar frequencia");
		frequenciaFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarFrequenciaFaltas = new FuncionarioFrequenciaFaltas();
				alterarFrequenciaFaltas = new FuncionarioFrequencia();
				salvaDadosFrequenciaFaltas = new Dao_inserir_dados_funcionario_historico_faltas();
				salvaNovosDadosFrequenciaFaltas = new Dao_alterar_dados_funcionario_historico();
				
				Adicionar_Faltas_Presencas_Frequencia adicionarFrequencia = new Adicionar_Faltas_Presencas_Frequencia();
				adicionarFrequencia.setVisible(true);
				String respostaFrequencia =  adicionarFrequencia.getFrequenciaFuncionario();
				if (respostaFrequencia != null) {
					if (respostaFrequencia.equals("Presença")) {
						int presencaTotalValor = Integer.parseInt(presencasTotal.getText());
						int presencaNumero = 1;
						presencaTotalValor += presencaNumero;
						presencasTotal.setText("" + presencaTotalValor);
						
						alterarFrequenciaFaltas.setPresencaTotal(Integer.parseInt(presencasTotal.getText()));
						alterarFrequenciaFaltas.setNomeFuncionario(nomeFuncionario.getText());
						alterarFrequenciaFaltas.setCodigoFuncionario(codigoFuncionario.getText());
						
						salvaNovosDadosFrequenciaFaltas.Altera_Dados_Funcionario_Historico_Presenca(alterarFrequenciaFaltas);
					}
					if (respostaFrequencia.equals("Falta")) {
						int faltaTotalValor = Integer.parseInt(faltasTotal.getText());
						int faltaNumero = 1;
						faltaTotalValor += faltaNumero;
						faltasTotal.setText("" + faltaTotalValor);
						
						alterarFrequenciaFaltas.setFaltaTotal(Integer.parseInt(faltasTotal.getText()));
						alterarFrequenciaFaltas.setNomeFuncionario(nomeFuncionario.getText());
						alterarFrequenciaFaltas.setCodigoFuncionario(codigoFuncionario.getText());
						
						cadastrarFrequenciaFaltas.setNomeFuncionario(nomeFuncionario.getText());
						cadastrarFrequenciaFaltas.setCargoFuncionario(cargoFuncionario.getText());
						cadastrarFrequenciaFaltas.setCodigoFuncionario(codigoFuncionario.getText());
						cadastrarFrequenciaFaltas.setFrequencia(respostaFrequencia);
						
						String dataTrabalhoValor = null;
						try {
							java.util.Date dataRegistro = new java.util.Date();
							SimpleDateFormat dataRegistroFormato = new SimpleDateFormat("dd/MM/yyyy");
							String dataCadastroCliente = dataRegistroFormato.format(dataRegistro);
							SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
							Date dataCadastro = new java.sql.Date(dataCadastroFormato.parse(dataCadastroCliente).getTime());
							
							cadastrarFrequenciaFaltas.setDataTrabalho(dataCadastro);
							
							SimpleDateFormat dataTrabalhoFormato = new SimpleDateFormat("dd/MM/yyyy");
				    		dataTrabalhoValor = dataTrabalhoFormato.format(dataCadastro);
							
						} catch (ParseException e9) {
							e9.printStackTrace();
						}
						
						String horaCadastroValor = null;
						try {
							java.util.Date horaRegistro = new java.util.Date();
							SimpleDateFormat horaRegistroFormato = new SimpleDateFormat("HH:mm");
							String horaCadastroFuncionario = horaRegistroFormato.format(horaRegistro);
							SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
							Time horaCadastro = new java.sql.Time(horaCadastroFormato.parse(horaCadastroFuncionario).getTime());
							
							cadastrarFrequenciaFaltas.setHoraCadastro(horaCadastro);
							
							SimpleDateFormat horaCadastroValorFormato = new SimpleDateFormat("HH:mm");
				    		horaCadastroValor = horaCadastroValorFormato.format(horaCadastro);
				    		
						} catch (ParseException e9) {
							e9.printStackTrace();
						}
						
						FuncionariosTabelaFaltas historicoFuncionario = new FuncionariosTabelaFaltas(dataTrabalhoValor, horaCadastroValor, respostaFrequencia);
						TabelaModeloFrequencia.addFuncionarioFrequencia(historicoFuncionario);
						
						salvaDadosFrequenciaFaltas.Inserir_Dados_Funcionario_Historico(cadastrarFrequenciaFaltas);
						salvaNovosDadosFrequenciaFaltas.Altera_Dados_Funcionario_Historico_Falta(alterarFrequenciaFaltas);
					}
				}
			}
		});
		panelBotoes2.add(frequenciaFuncionario);
		frequenciaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
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