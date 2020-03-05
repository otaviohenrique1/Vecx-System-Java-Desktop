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
import moduloProdutoDescontoPromocaoBD.Dao_consulta_dados_desconto;
import moduloProdutoDescontoPromocaoBD.Desconto;

public class Descontos_e_Promocoes_Ficha_Desconto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaDesconto;
	private JButton cancelarDesconto, voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Descontos_e_Promocoes_Ficha_Desconto frame = new Descontos_e_Promocoes_Ficha_Desconto();
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
	public Descontos_e_Promocoes_Ficha_Desconto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Descontos_e_Promocoes_Ficha_Desconto.class.getResource("/cImagens/Logo Janela.PNG")));
		setResizable(false);
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		setSize(700, 450);
		telaFichaDesconto = new JPanel();
		telaFichaDesconto.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaDesconto.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaDesconto);
		
		JPanel panelTitulo = new JPanel();
		telaFichaDesconto.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Descontos_e_Promocoes_Ficha_Desconto.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFichaDesconto = new JLabel("Ficha de desconto");
		panelTitulo2.add(labelFichaDesconto);
		labelFichaDesconto.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Descontos_e_Promocoes_Ficha_Desconto.class.getResource("/cImagens/Funcionario.png")));
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
		
		JScrollPane scrollPaneDesconto = new JScrollPane();
		telaFichaDesconto.add(scrollPaneDesconto, BorderLayout.CENTER);
		
		JPanel panelDescontoFicha = new JPanel();
		scrollPaneDesconto.setViewportView(panelDescontoFicha);
		panelDescontoFicha.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNomeProduto = new JPanel();
		panelDescontoFicha.add(panelNomeProduto);
		panelNomeProduto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeProduto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeProduto = new JLabel("Nome do produto");
		labelNomeProduto.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeProduto.add(labelNomeProduto);
		
		JLabel nomeProduto = new JLabel();
		nomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeProduto.add(nomeProduto);
		
		JPanel panelDesconto_Produto = new JPanel();
		panelDescontoFicha.add(panelDesconto_Produto);
		panelDesconto_Produto.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelCodigoProduto = new JPanel();
		panelDesconto_Produto.add(panelCodigoProduto);
		panelCodigoProduto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoProduto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoProduto = new JLabel("Codigo do produto");
		labelCodigoProduto.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoProduto.add(labelCodigoProduto);
		
		JLabel codigoProduto = new JLabel();
		codigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoProduto.add(codigoProduto);
		
		JPanel panelCodigoDesconto = new JPanel();
		panelDesconto_Produto.add(panelCodigoDesconto);
		panelCodigoDesconto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoDesconto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoDesconto = new JLabel("Codigo do desconto");
		labelCodigoDesconto.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoDesconto.add(labelCodigoDesconto);
		
		JLabel codigoDesconto = new JLabel();
		codigoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoDesconto.add(codigoDesconto);
		
		JPanel panelEstadoDesconto = new JPanel();
		panelEstadoDesconto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDesconto_Produto.add(panelEstadoDesconto);
		panelEstadoDesconto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstadoDesconto = new JLabel("Estado do desconto");
		labelEstadoDesconto.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstadoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoDesconto.add(labelEstadoDesconto);
		
		JLabel estadoDesconto = new JLabel();
		estadoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstadoDesconto.add(estadoDesconto);
		
		JPanel panelFuncionarioResponsavel = new JPanel();
		panelDescontoFicha.add(panelFuncionarioResponsavel);
		panelFuncionarioResponsavel.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeResponsavel = new JPanel();
		panelFuncionarioResponsavel.add(panelNomeResponsavel);
		panelNomeResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeResponsavel = new JLabel("Nome do responsavel");
		panelNomeResponsavel.add(labelNomeResponsavel);
		labelNomeResponsavel.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel nomeResponsavel = new JLabel();
		panelNomeResponsavel.add(nomeResponsavel);
		nomeResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		
		JPanel panelPrecoTotal_Desconto_Parcelado = new JPanel();
		panelDescontoFicha.add(panelPrecoTotal_Desconto_Parcelado);
		panelPrecoTotal_Desconto_Parcelado.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelPrecoNormal = new JPanel();
		panelPrecoTotal_Desconto_Parcelado.add(panelPrecoNormal);
		panelPrecoNormal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoNormal.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoNormal = new JLabel("Pre\u00E7o normal (R$)");
		labelPrecoNormal.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoNormal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPrecoNormal.add(labelPrecoNormal);
		
		JLabel precoNormal = new JLabel();
		precoNormal.setHorizontalAlignment(SwingConstants.RIGHT);
		precoNormal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPrecoNormal.add(precoNormal);
		
		JPanel panelDescontoPorcentagem = new JPanel();
		panelDescontoPorcentagem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotal_Desconto_Parcelado.add(panelDescontoPorcentagem);
		panelDescontoPorcentagem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDescontoPorcentagem = new JLabel("Desconto (%)");
		labelDescontoPorcentagem.setHorizontalAlignment(SwingConstants.LEFT);
		labelDescontoPorcentagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDescontoPorcentagem.add(labelDescontoPorcentagem);
		
		JLabel descontoPorcentagem = new JLabel();
		descontoPorcentagem.setHorizontalAlignment(SwingConstants.RIGHT);
		descontoPorcentagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDescontoPorcentagem.add(descontoPorcentagem);
		
		JPanel panelPrecoDesconto = new JPanel();
		panelPrecoDesconto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotal_Desconto_Parcelado.add(panelPrecoDesconto);
		panelPrecoDesconto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoDesconto = new JLabel("Pre\u00E7o com desconto (R$)");
		labelPrecoDesconto.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPrecoDesconto.add(labelPrecoDesconto);
		
		JLabel precoDesconto = new JLabel();
		precoDesconto.setHorizontalAlignment(SwingConstants.RIGHT);
		precoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPrecoDesconto.add(precoDesconto);
		
		JPanel panelDataHora = new JPanel();
		panelDescontoFicha.add(panelDataHora);
		panelDataHora.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelDataHoraInicio = new JPanel();
		panelDataHora.add(panelDataHoraInicio);
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
		panelDataHora.add(panelDataHoraTermino);
		panelDataHoraTermino.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraTermino = new JLabel("Data e hora de termino");
		labelDataHoraTermino.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraTermino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraTermino.add(labelDataHoraTermino);
		
		JLabel dataHoraTermino = new JLabel();
		dataHoraTermino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraTermino.add(dataHoraTermino);
		
		JPanel panelDataHoraCadastro = new JPanel();
		panelDataHoraCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHora.add(panelDataHoraCadastro);
		panelDataHoraCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraCadastro = new JLabel("Data e hora de cadastro");
		labelDataHoraCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraCadastro.add(labelDataHoraCadastro);
		
		JLabel dataHoraCadastro = new JLabel();
		dataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraCadastro.add(dataHoraCadastro);
		
		JPanel panelFuncionarioCadastro = new JPanel();
		panelDescontoFicha.add(panelFuncionarioCadastro);
		panelFuncionarioCadastro.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeFuncionarioCadastro = new JPanel();
		panelNomeFuncionarioCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFuncionarioCadastro.add(panelNomeFuncionarioCadastro);
		panelNomeFuncionarioCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFuncionarioCadastro = new JLabel("Funcionario que cadastrou");
		panelNomeFuncionarioCadastro.add(labelFuncionarioCadastro);
		labelFuncionarioCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel nomeFuncionarioCadastro = new JLabel();
		panelNomeFuncionarioCadastro.add(nomeFuncionarioCadastro);
		nomeFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		
		String compraCodigoDesconto = sessao.getCodigoDescontoFicha();
		
		/*Parte que consulta os dados no banco de dados*/
		Dao_consulta_dados_desconto ConsultaDadosDesconto = new Dao_consulta_dados_desconto();
    	List<Desconto> Consulta = ConsultaDadosDesconto.Consulta_Dados_Desconto_Ficha(compraCodigoDesconto);
    	for (Desconto leitura : Consulta) {
    		nomeProduto.setText(leitura.getNomeProduto());
    		codigoDesconto.setText(leitura.getCodigoDesconto());
    		codigoProduto.setText(leitura.getCodigoProduto());
    		estadoDesconto.setText(leitura.getEstadoDesconto());
    		
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
    		
    		nomeResponsavel.setText(leitura.getNomeResponsavel());
    		cargoResponsavel.setText(leitura.getCargoResponsavel());
    		codigoResponsavel.setText(leitura.getCodigoResponsavel());
    		
    		nomeFuncionarioCadastro.setText(leitura.getFuncionarioCadastro());
    		cargoFuncionarioCadastro.setText(leitura.getCargoFuncionario());
    		codigoFuncionarioCadastro.setText(leitura.getCodigoFuncionario());
    		
    		double precoNormalValor = leitura.getPrecoNormal();
    		String precoNormalTexto = "" + precoNormalValor;
    		precoNormal.setText(precoNormalTexto);
    		
    		double porcentagemDescontoValor = leitura.getDescontoPorcentagem();
    		String porcentagemDescontoTexto = "" + porcentagemDescontoValor;
    		descontoPorcentagem.setText(porcentagemDescontoTexto);
    		
    		double precoDescontoValor = leitura.getPrecoDesconto();
    		String precoDescontoTexto = "" + precoDescontoValor;
    		precoDesconto.setText(precoDescontoTexto);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaDesconto.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		cancelarDesconto = new JButton("Cancelar desconto");
		cancelarDesconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menssagemTitulo = "Cancelamento do desconto";
				String menssagemConteudo = "Deseja cancelar o desconto ?";
				Tela_que_Exibe_Menssagem_Sim_Nao telaCancelarDesconto = new Tela_que_Exibe_Menssagem_Sim_Nao(menssagemTitulo, menssagemConteudo);
				telaCancelarDesconto.setVisible(true);
				String cancelarDescontoTexto = telaCancelarDesconto.getResposta();
				if (cancelarDescontoTexto != null) {
					if (cancelarDescontoTexto.equals("Sim")) {
							Desconto alterarNovosDadosDesconto = new Desconto();
							String estadoDescontoTexto = "Cancelada";
							alterarNovosDadosDesconto.setEstadoDesconto(estadoDescontoTexto);
							alterarNovosDadosDesconto.setPrecoNormal(Double.parseDouble(precoNormal.getText()));
							alterarNovosDadosDesconto.setCodigoDesconto(codigoDesconto.getText());
							Dao_alterar_dados_promocao_desconto salvaNovosDadosDesconto = new Dao_alterar_dados_promocao_desconto();
							salvaNovosDadosDesconto.Altera_Dados_Estado_Desconto(alterarNovosDadosDesconto);
							
							String menssagemConteudoTitulo = "Desconto cancelado";
							Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudoTitulo);
							mensagemConfirmacao.setVisible(true);
							
							setVisible(false);
					}
				}
			}
		});
		cancelarDesconto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(cancelarDesconto);
		
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