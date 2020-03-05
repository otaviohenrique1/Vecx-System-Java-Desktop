package moduloTransporteTelas;

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
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;
import moduloProdutoTelas.Cadastro_de_Produto;
import moduloTransporteBD.Dao_consulta_dados_transportecarga;
import moduloTransporteBD.TransporteCarga;

public class Controle_de_Cargas_Ficha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaTransporteCarga;
	private JButton editar, voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controle_de_Cargas_Ficha frame = new Controle_de_Cargas_Ficha();
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
	public Controle_de_Cargas_Ficha() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Controle_de_Cargas_Ficha.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		setSize(800, 550);
		
		telaFichaTransporteCarga = new JPanel();
		telaFichaTransporteCarga.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaTransporteCarga.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaTransporteCarga);
		
		JPanel panelTitulo = new JPanel();
		telaFichaTransporteCarga.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Controle_de_Cargas_Ficha.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFichaTransporteCarga = new JLabel("Ficha de transporte");
		panelTitulo2.add(labelFichaTransporteCarga);
		labelFichaTransporteCarga.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Cadastro_de_Produto.class.getResource("/cImagens/Funcionario.png")));
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
		
		JScrollPane scrollPaneCadastro = new JScrollPane();
		telaFichaTransporteCarga.add(scrollPaneCadastro, BorderLayout.CENTER);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panel = new JPanel();
		panelCadastro.add(panel);
		panel.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeResponsavel = new JPanel();
		panel.add(panelNomeResponsavel);
		panelNomeResponsavel.setPreferredSize(new Dimension(10, 50));
		panelNomeResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFuncionarioResponsavel = new JLabel("Nome do funcionario responsavel");
		panelNomeResponsavel.add(labelFuncionarioResponsavel);
		labelFuncionarioResponsavel.setHorizontalAlignment(SwingConstants.LEFT);
		labelFuncionarioResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel funcionarioResponsavel = new JLabel();
		panelNomeResponsavel.add(funcionarioResponsavel);
		funcionarioResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCargo_Codigo_Responsavel = new JPanel();
		panel.add(panelCargo_Codigo_Responsavel);
		panelCargo_Codigo_Responsavel.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargoResponsavel = new JPanel();
		panelCargo_Codigo_Responsavel.add(panelCargoResponsavel);
		panelCargoResponsavel.setPreferredSize(new Dimension(10, 50));
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
		panelCodigoResponsavel.setPreferredSize(new Dimension(10, 50));
		panelCodigoResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoResponsavel = new JLabel("Codigo do responsavel");
		labelCodigoResponsavel.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoResponsavel.add(labelCodigoResponsavel);
		
		JLabel codigoResponsavel = new JLabel();
		codigoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoResponsavel.add(codigoResponsavel);
		
		JPanel panelCliente_Nome_CPF_RG = new JPanel();
		panelCadastro.add(panelCliente_Nome_CPF_RG);
		panelCliente_Nome_CPF_RG.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeCliente = new JPanel();
		panelCliente_Nome_CPF_RG.add(panelNomeCliente);
		panelNomeCliente.setPreferredSize(new Dimension(10, 50));
		panelNomeCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeCliente = new JLabel("Nome do cliente");
		labelNomeCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeCliente.add(labelNomeCliente);
		
		JLabel nomeCliente = new JLabel();
		nomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNomeCliente.add(nomeCliente);
		
		JPanel panelCliente_CPF_RG = new JPanel();
		panelCliente_Nome_CPF_RG.add(panelCliente_CPF_RG);
		panelCliente_CPF_RG.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelClienteCPF = new JPanel();
		panelCliente_CPF_RG.add(panelClienteCPF);
		panelClienteCPF.setPreferredSize(new Dimension(10, 50));
		panelClienteCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelClienteCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelClienteCPF = new JLabel("CPF do cliente");
		labelClienteCPF.setHorizontalAlignment(SwingConstants.LEFT);
		labelClienteCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelClienteCPF.add(labelClienteCPF);
		
		JLabel clienteCPF = new JLabel();
		clienteCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelClienteCPF.add(clienteCPF);
		
		JPanel panelClienteRG = new JPanel();
		panelCliente_CPF_RG.add(panelClienteRG);
		panelClienteRG.setPreferredSize(new Dimension(10, 50));
		panelClienteRG.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelClienteRG.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelClienteRG = new JLabel("RG do cliente");
		labelClienteRG.setHorizontalAlignment(SwingConstants.LEFT);
		labelClienteRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelClienteRG.add(labelClienteRG);
		
		JLabel clienteRG = new JLabel();
		clienteRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelClienteRG.add(clienteRG);
		
		JPanel panelEnderecoCliente = new JPanel();
		panelEnderecoCliente.setPreferredSize(new Dimension(10, 50));
		panelEnderecoCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCadastro.add(panelEnderecoCliente);
		panelEnderecoCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEnderecoCliente = new JLabel("Endere\u00E7o");
		labelEnderecoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelEnderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEnderecoCliente.add(labelEnderecoCliente);
		
		JLabel enderecoCliente = new JLabel();
		enderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEnderecoCliente.add(enderecoCliente);
		
		JPanel panelNumeroBairroCidadeCliente = new JPanel();
		panelCadastro.add(panelNumeroBairroCidadeCliente);
		panelNumeroBairroCidadeCliente.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelNumeroCliente = new JPanel();
		panelNumeroCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNumeroBairroCidadeCliente.add(panelNumeroCliente);
		panelNumeroCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNumeroCliente = new JLabel("Numero da casa do cliente");
		labelNumeroCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumeroCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNumeroCliente.add(labelNumeroCliente);
		
		JLabel numeroCliente = new JLabel();
		numeroCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNumeroCliente.add(numeroCliente);
		
		JPanel panelBairroCliente = new JPanel();
		panelBairroCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNumeroBairroCidadeCliente.add(panelBairroCliente);
		panelBairroCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairroCliente = new JLabel("Bairro do cliente");
		labelBairroCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelBairroCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBairroCliente.add(labelBairroCliente);
		
		JLabel bairroCliente = new JLabel();
		bairroCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBairroCliente.add(bairroCliente);
		
		JPanel panelCidadeCliente = new JPanel();
		panelCidadeCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNumeroBairroCidadeCliente.add(panelCidadeCliente);
		panelCidadeCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCidadeCliente = new JLabel("Cidade do cliente");
		labelCidadeCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelCidadeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCidadeCliente.add(labelCidadeCliente);
		
		JLabel cidadeCliente = new JLabel();
		cidadeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCidadeCliente.add(cidadeCliente);
		
		JPanel panelCod_TipoTrans_EstCar = new JPanel();
		panelCadastro.add(panelCod_TipoTrans_EstCar);
		panelCod_TipoTrans_EstCar.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelCodigoTransporte = new JPanel();
		panelCodigoTransporte.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCod_TipoTrans_EstCar.add(panelCodigoTransporte);
		panelCodigoTransporte.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoTransporte = new JLabel("Codigo do transporte");
		panelCodigoTransporte.add(labelCodigoTransporte);
		labelCodigoTransporte.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoTransporte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel codigoTransporte = new JLabel();
		panelCodigoTransporte.add(codigoTransporte);
		codigoTransporte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTipoTransporte = new JPanel();
		panelTipoTransporte.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCod_TipoTrans_EstCar.add(panelTipoTransporte);
		panelTipoTransporte.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoTransporte = new JLabel("Tipo de transporte");
		labelTipoTransporte.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoTransporte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoTransporte.add(labelTipoTransporte);
		
		JLabel tipoTransporte = new JLabel();
		tipoTransporte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoTransporte.add(tipoTransporte);
		
		JPanel panelEstadoCarga = new JPanel();
		panelEstadoCarga.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCod_TipoTrans_EstCar.add(panelEstadoCarga);
		panelEstadoCarga.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstadoCarga = new JLabel("Estado da carga");
		panelEstadoCarga.add(labelEstadoCarga);
		labelEstadoCarga.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstadoCarga.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel estadoCarga = new JLabel();
		panelEstadoCarga.add(estadoCarga);
		estadoCarga.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelDataHora = new JPanel();
		panelCadastro.add(panelDataHora);
		panelDataHora.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelDataHoraCadastro = new JPanel();
		panelDataHora.add(panelDataHoraCadastro);
		panelDataHoraCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHoraCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraCadastro = new JLabel("Data e hora de cadastro");
		labelDataHoraCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraCadastro.add(labelDataHoraCadastro);
		
		JLabel dataHoraCadastro = new JLabel();
		dataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraCadastro.add(dataHoraCadastro);
		
		JPanel panelDataHoraSaida = new JPanel();
		panelDataHoraSaida.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHora.add(panelDataHoraSaida);
		panelDataHoraSaida.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraSaida = new JLabel("Data e hora de saida");
		panelDataHoraSaida.add(labelDataHoraSaida);
		labelDataHoraSaida.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraSaida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel dataHoraSaida = new JLabel();
		panelDataHoraSaida.add(dataHoraSaida);
		dataHoraSaida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelDataHoraChegada = new JPanel();
		panelDataHoraChegada.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHora.add(panelDataHoraChegada);
		panelDataHoraChegada.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraChegada = new JLabel("Data e hora de chegada");
		panelDataHoraChegada.add(labelDataHoraChegada);
		labelDataHoraChegada.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraChegada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel dataHoraChegada = new JLabel();
		panelDataHoraChegada.add(dataHoraChegada);
		dataHoraChegada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelFuncionarioCadastro = new JPanel();
		panelCadastro.add(panelFuncionarioCadastro);
		panelFuncionarioCadastro.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeFuncionario = new JPanel();
		panelFuncionarioCadastro.add(panelNomeFuncionario);
		panelNomeFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeFuncionario = new JLabel("Funcionario que cadastrou");
		panelNomeFuncionario.add(labelNomeFuncionario);
		labelNomeFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel nomeFuncionario = new JLabel();
		panelNomeFuncionario.add(nomeFuncionario);
		nomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCargo_Codigo_Cadastro = new JPanel();
		panelFuncionarioCadastro.add(panelCargo_Codigo_Cadastro);
		panelCargo_Codigo_Cadastro.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargoFuncionario = new JPanel();
		panelCargoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_Codigo_Cadastro.add(panelCargoFuncionario);
		panelCargoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargoFuncionario = new JLabel("Cargo do funcionario");
		panelCargoFuncionario.add(labelCargoFuncionario);
		labelCargoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cargoFuncionario = new JLabel();
		panelCargoFuncionario.add(cargoFuncionario);
		cargoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCodigoFuncionario = new JPanel();
		panelCodigoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_Codigo_Cadastro.add(panelCodigoFuncionario);
		panelCodigoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoFuncionario = new JLabel("Codigo do funcionario");
		panelCodigoFuncionario.add(labelCodigoFuncionario);
		labelCodigoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel codigoFuncionario = new JLabel();
		panelCodigoFuncionario.add(codigoFuncionario);
		codigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		/*Parte que consulta os dados no banco de dados*/
		String transporteCodigoConsulta = sessao.getTransporteCargasCodigo();
		Dao_consulta_dados_transportecarga fichaCliente = new Dao_consulta_dados_transportecarga();
    	List<TransporteCarga> Consulta = fichaCliente.Consulta_Dados_TransporteCarga_Ficha(transporteCodigoConsulta);
    	for (TransporteCarga leitura : Consulta) {
    		String codigoTransporteTexto = leitura.getCodigoTransporte();
    		codigoTransporte.setText(codigoTransporteTexto);
    		
    		String funcionarioResponsavelTexto = leitura.getFuncionarioResponsavel();
    		funcionarioResponsavel.setText(funcionarioResponsavelTexto);
    		
    		String cargoResponsavelTexto = leitura.getCargoResponsavel();
    		cargoResponsavel.setText(cargoResponsavelTexto);
    		
    		String codigoResponsavelTexto = leitura.getCodigoResponsavel();
    		codigoResponsavel.setText(codigoResponsavelTexto);
    		
    		String nomeClienteTexto = leitura.getClienteNome();
    		nomeCliente.setText(nomeClienteTexto);
    		
    		String clienteCPF_Texto = leitura.getClienteCPF();
    		clienteCPF.setText(clienteCPF_Texto);
    		
    		String clienteRG_Texto = leitura.getClienteRG();
    		clienteRG.setText(clienteRG_Texto);
    		
    		String enderecoClienteTexto = leitura.getEnderecoCliente();
    		enderecoCliente.setText(enderecoClienteTexto);
    		
    		String clienteNumero_Texto = leitura.getClienteNumero();
    		numeroCliente.setText(clienteNumero_Texto);
    		
    		String clienteBairro_Texto = leitura.getClienteBairro();
    		bairroCliente.setText(clienteBairro_Texto);
    		
    		String enderecoCidadeTexto = leitura.getClienteCidade();
    		cidadeCliente.setText(enderecoCidadeTexto);
    		
    		String tipoTransporteTexto = leitura.getTipoTransporte();
    		tipoTransporte.setText(tipoTransporteTexto);
    		
    		String estadoCargaTexto = leitura.getEstadoCarga();
    		estadoCarga.setText(estadoCargaTexto);
    		
    		Date dataCadastroTransporte =	leitura.getDataCadastro();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroTransporte);
    		
    		Time horaCadastroTransporte = leitura.getHoraCadastro();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroTransporte);
    		
    		String dataHoraCadastroTexto = dataCadastroValor + " " + horaCadastroValor;
    		dataHoraCadastro.setText(dataHoraCadastroTexto);
    		
    		Date dataSaidaTransporte =	leitura.getDataCadastro();
    		SimpleDateFormat dataSaidaFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataSaidaValor = dataSaidaFormato.format(dataSaidaTransporte);
    		
    		Time horaSaidaTransporte = leitura.getHoraCadastro();
    		SimpleDateFormat horaSaidaFormato = new SimpleDateFormat("HH:mm");
    		String horaSaidaValor = horaSaidaFormato.format(horaSaidaTransporte);
    		
    		String dataHoraSaidaTransporte = dataSaidaValor + " " + horaSaidaValor;
    		dataHoraSaida.setText(dataHoraSaidaTransporte);
    		
    		Date dataChegadaTransporte =	leitura.getDataCadastro();
    		SimpleDateFormat dataChegadaFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataChegadaValor = dataChegadaFormato.format(dataChegadaTransporte);
    		
    		Time horaChegadaTransporte = leitura.getHoraCadastro();
    		SimpleDateFormat horaChegadaFormato = new SimpleDateFormat("HH:mm");
    		String horaChegadaValor = horaChegadaFormato.format(horaChegadaTransporte);
    		
    		String dataHoraChegadaTransporte = dataChegadaValor + " " + horaChegadaValor;
    		dataHoraChegada.setText(dataHoraChegadaTransporte);
    		
    		String nomeFuncionarioTexto = leitura.getFuncionarioCadastro();
    		nomeFuncionario.setText(nomeFuncionarioTexto);
    		
    		String cargoFuncionarioTexto = leitura.getCargoFuncionarioCadastro();
    		cargoFuncionario.setText(cargoFuncionarioTexto);
    		
    		String codigoFuncionarioTexto = leitura.getCodigoFuncionarioCadastro();
    		codigoFuncionario.setText(codigoFuncionarioTexto);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaTransporteCarga.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		editar = new JButton("Editar");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controle_de_Cargas_Ficha_Editar abrirTelaControleCargasFichaEditar = new Controle_de_Cargas_Ficha_Editar();
				abrirTelaControleCargasFichaEditar.setVisible(true);
				dispose();
			}
		});
		editar.setToolTipText("Editar os dados da ficha de transporte");
		editar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(editar);
		
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