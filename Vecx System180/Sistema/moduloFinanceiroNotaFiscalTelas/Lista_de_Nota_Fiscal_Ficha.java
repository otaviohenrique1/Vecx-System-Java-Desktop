package moduloFinanceiroNotaFiscalTelas;

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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import aInterfaceSistema.Sessao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import moduloAdministrativo.DadosLoja;
import moduloAdministrativo.Dao_consulta_dados_loja;
import moduloFinanceiroNotaFiscalBD.Dao_consulta_dados_nota_fiscal_ficha;
import moduloFinanceiroNotaFiscalBD.NotaFiscal;
import moduloFinanceiroVendaBD.Dao_consulta_dados_venda_lista_produtos;
import moduloFinanceiroVendaBD.VendaProdutos;
import moduloFinanceiroVendaTelas.Lista_de_Produtos_Vendas;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Lista_de_Nota_Fiscal_Ficha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaFornecedor;
	private JButton exibirListaProdutos, gerarNotaFiscal, voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista_de_Nota_Fiscal_Ficha frame = new Lista_de_Nota_Fiscal_Ficha();
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
	public Lista_de_Nota_Fiscal_Ficha() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Lista_de_Nota_Fiscal_Ficha.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setSize(800, 600);
		telaFichaFornecedor = new JPanel();
		telaFichaFornecedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaFornecedor.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaFornecedor);
		
		JPanel panelTitulo = new JPanel();
		telaFichaFornecedor.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Lista_de_Nota_Fiscal_Ficha.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFichaAcessoLog = new JLabel("Ficha de nota fiscal");
		panelTitulo2.add(labelFichaAcessoLog);
		labelFichaAcessoLog.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Lista_de_Nota_Fiscal_Ficha.class.getResource("/cImagens/Funcionario.png")));
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
		
		JScrollPane scrollPaneNotaFiscal = new JScrollPane();
		telaFichaFornecedor.add(scrollPaneNotaFiscal, BorderLayout.CENTER);
		
		JPanel panelNotaFiscal = new JPanel();
		scrollPaneNotaFiscal.setViewportView(panelNotaFiscal);
		panelNotaFiscal.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelCodCom_CodNota_DataHora = new JPanel();
		panelNotaFiscal.add(panelCodCom_CodNota_DataHora);
		panelCodCom_CodNota_DataHora.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelCodigoNotaFiscal = new JPanel();
		panelCodigoNotaFiscal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodCom_CodNota_DataHora.add(panelCodigoNotaFiscal);
		panelCodigoNotaFiscal.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoNotaFiscal = new JLabel("Codigo da nota fiscal");
		labelCodigoNotaFiscal.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoNotaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoNotaFiscal.add(labelCodigoNotaFiscal);
		
		JLabel codigoNotaFiscal = new JLabel();
		codigoNotaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoNotaFiscal.add(codigoNotaFiscal);
		
		JPanel panelCodigoVenda = new JPanel();
		panelCodigoVenda.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodCom_CodNota_DataHora.add(panelCodigoVenda);
		panelCodigoVenda.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoVenda = new JLabel("Codigo de venda");
		labelCodigoVenda.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoVenda.add(labelCodigoVenda);
		
		JLabel codigoVenda = new JLabel();
		codigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoVenda.add(codigoVenda);
		
		JPanel panelDataHora = new JPanel();
		panelCodCom_CodNota_DataHora.add(panelDataHora);
		panelDataHora.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHora.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHora = new JLabel("Data e hora de emiss\u00E3o");
		panelDataHora.add(labelDataHora);
		labelDataHora.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel dataHoraEmissaoNotaFiscal = new JLabel();
		panelDataHora.add(dataHoraEmissaoNotaFiscal);
		dataHoraEmissaoNotaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelPagamento_NotaFiscalPaulista = new JPanel();
		panelNotaFiscal.add(panelPagamento_NotaFiscalPaulista);
		panelPagamento_NotaFiscalPaulista.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelTipoPagamento = new JPanel();
		panelTipoPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPagamento_NotaFiscalPaulista.add(panelTipoPagamento);
		panelTipoPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTipoPagamento = new JLabel("Tipo de pagamento");
		labelTipoPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		labelTipoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoPagamento.add(labelTipoPagamento);
		
		JLabel tipoPagamento = new JLabel();
		tipoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTipoPagamento.add(tipoPagamento);
		
		JPanel panelMetodoPagamento = new JPanel();
		panelMetodoPagamento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPagamento_NotaFiscalPaulista.add(panelMetodoPagamento);
		panelMetodoPagamento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelMetodoPagamento = new JLabel("Metodo de pagamento");
		labelMetodoPagamento.setHorizontalAlignment(SwingConstants.LEFT);
		labelMetodoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelMetodoPagamento.add(labelMetodoPagamento);
		
		JLabel metodoPagamento = new JLabel();
		metodoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelMetodoPagamento.add(metodoPagamento);
		
		JPanel panelNotaFiscalPaulista = new JPanel();
		panelNotaFiscalPaulista.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPagamento_NotaFiscalPaulista.add(panelNotaFiscalPaulista);
		panelNotaFiscalPaulista.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNotaFiscalPaulista = new JLabel("Nota fiscal paulista");
		labelNotaFiscalPaulista.setHorizontalAlignment(SwingConstants.LEFT);
		labelNotaFiscalPaulista.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNotaFiscalPaulista.add(labelNotaFiscalPaulista);
		
		JLabel notaFiscalPaulista = new JLabel();
		notaFiscalPaulista.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNotaFiscalPaulista.add(notaFiscalPaulista);
		
		JPanel panelNome_CPF = new JPanel();
		panelNome_CPF.setPreferredSize(new Dimension(10, 50));
		panelNotaFiscal.add(panelNome_CPF);
		panelNome_CPF.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeCliente = new JPanel();
		panelNomeCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome_CPF.add(panelNomeCliente);
		panelNomeCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNomeCliente = new JLabel("Nome do cliente");
		panelNomeCliente.add(labelNomeCliente);
		labelNomeCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel nomeCliente = new JLabel();
		panelNomeCliente.add(nomeCliente);
		nomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCPFCliente = new JPanel();
		panelNome_CPF.add(panelCPFCliente);
		panelCPFCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCPFCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPFCliente = new JLabel("CPF do cliente");
		labelCPFCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelCPFCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCPFCliente.add(labelCPFCliente);
		
		JLabel cpfCliente = new JLabel();
		cpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCPFCliente.add(cpfCliente);
		
		JPanel panelCodCliente_Telefone_Celular = new JPanel();
		panelNotaFiscal.add(panelCodCliente_Telefone_Celular);
		panelCodCliente_Telefone_Celular.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelCodigoCliente = new JPanel();
		panelCodCliente_Telefone_Celular.add(panelCodigoCliente);
		panelCodigoCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoCliente = new JLabel("Codigo do cliente");
		labelCodigoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoCliente.add(labelCodigoCliente);
		
		JLabel codigoCliente = new JLabel();
		codigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoCliente.add(codigoCliente);
		
		JPanel panelTelefoneCliente = new JPanel();
		panelCodCliente_Telefone_Celular.add(panelTelefoneCliente);
		panelTelefoneCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefoneCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTelefoneCliente = new JLabel("Telefone");
		labelTelefoneCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefoneCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTelefoneCliente.add(labelTelefoneCliente);
		
		JLabel telefoneCliente = new JLabel();
		telefoneCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTelefoneCliente.add(telefoneCliente);
		
		JPanel panelCelularCliente = new JPanel();
		panelCelularCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodCliente_Telefone_Celular.add(panelCelularCliente);
		panelCelularCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelularCliente = new JLabel("Celular");
		labelCelularCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelularCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCelularCliente.add(labelCelularCliente);
		
		JLabel celularCliente = new JLabel();
		celularCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCelularCliente.add(celularCliente);
		
		JPanel panelEndereco_Numero_Bairro = new JPanel();
		panelNotaFiscal.add(panelEndereco_Numero_Bairro);
		panelEndereco_Numero_Bairro.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelEndereco = new JPanel();
		panelEndereco.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEndereco_Numero_Bairro.add(panelEndereco);
		panelEndereco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o");
		panelEndereco.add(labelEndereco);
		labelEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel endereco = new JLabel();
		panelEndereco.add(endereco);
		endereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelNumero_Bairro = new JPanel();
		panelEndereco_Numero_Bairro.add(panelNumero_Bairro);
		panelNumero_Bairro.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNumero = new JPanel();
		panelNumero_Bairro.add(panelNumero);
		panelNumero.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNumero.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNumero = new JLabel("Numero");
		panelNumero.add(labelNumero);
		labelNumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel numero = new JLabel();
		panelNumero.add(numero);
		numero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelBairro = new JPanel();
		panelNumero_Bairro.add(panelBairro);
		panelBairro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelBairro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairro = new JLabel("Bairro");
		labelBairro.setHorizontalAlignment(SwingConstants.LEFT);
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBairro.add(labelBairro);
		
		JLabel bairro = new JLabel();
		bairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBairro.add(bairro);
		
		JPanel panelCEP_Cidade_Estado = new JPanel();
		panelNotaFiscal.add(panelCEP_Cidade_Estado);
		panelCEP_Cidade_Estado.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelCEP = new JPanel();
		panelCEP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCEP_Cidade_Estado.add(panelCEP);
		panelCEP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCEP = new JLabel("CEP");
		labelCEP.setHorizontalAlignment(SwingConstants.LEFT);
		labelCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCEP.add(labelCEP);
		
		JLabel cep = new JLabel();
		cep.setPreferredSize(new Dimension(80, 14));
		cep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCEP.add(cep);
		
		JPanel panelCidade = new JPanel();
		panelCEP_Cidade_Estado.add(panelCidade);
		panelCidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCidade = new JLabel("Cidade");
		panelCidade.add(labelCidade);
		labelCidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cidade = new JLabel();
		panelCidade.add(cidade);
		cidade.setPreferredSize(new Dimension(80, 14));
		cidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEstado = new JPanel();
		panelCEP_Cidade_Estado.add(panelEstado);
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstado.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstado = new JLabel("Estado");
		labelEstado.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstado.add(labelEstado);
		
		JLabel estado = new JLabel();
		estado.setPreferredSize(new Dimension(80, 14));
		estado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEstado.add(estado);
		
		JPanel panelNomeFun_Cargo_CodFun = new JPanel();
		panelNotaFiscal.add(panelNomeFun_Cargo_CodFun);
		panelNomeFun_Cargo_CodFun.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNomeFuncionarioResponsavel = new JPanel();
		panelNomeFuncionarioResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNomeFun_Cargo_CodFun.add(panelNomeFuncionarioResponsavel);
		panelNomeFuncionarioResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFuncionarioResponsavel = new JLabel("Funcionario responsavel");
		panelNomeFuncionarioResponsavel.add(labelFuncionarioResponsavel);
		labelFuncionarioResponsavel.setHorizontalAlignment(SwingConstants.LEFT);
		labelFuncionarioResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel nomeFuncionarioResponsavel = new JLabel();
		panelNomeFuncionarioResponsavel.add(nomeFuncionarioResponsavel);
		nomeFuncionarioResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCargo_CodFun = new JPanel();
		panelNomeFun_Cargo_CodFun.add(panelCargo_CodFun);
		panelCargo_CodFun.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargoResponsavel = new JPanel();
		panelCargoResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_CodFun.add(panelCargoResponsavel);
		panelCargoResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargoResponsavel = new JLabel("Cargo");
		labelCargoResponsavel.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargoResponsavel.add(labelCargoResponsavel);
		
		JLabel cargoResponsavel = new JLabel();
		cargoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargoResponsavel.add(cargoResponsavel);
		
		JPanel panelCodigoResponsavel = new JPanel();
		panelCodigoResponsavel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_CodFun.add(panelCodigoResponsavel);
		panelCodigoResponsavel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoResponsavel = new JLabel("Codigo do funcionario");
		labelCodigoResponsavel.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoResponsavel.add(labelCodigoResponsavel);
		
		JLabel codigoResponsavel = new JLabel();
		codigoResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoResponsavel.add(codigoResponsavel);
		
		JPanel panelPrecoTotal_Desconto_Parcelado = new JPanel();
		panelNotaFiscal.add(panelPrecoTotal_Desconto_Parcelado);
		panelPrecoTotal_Desconto_Parcelado.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelPrecoTotal = new JPanel();
		panelPrecoTotal_Desconto_Parcelado.add(panelPrecoTotal);
		panelPrecoTotal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotal.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoTotal = new JLabel("Pre\u00E7o total (R$)");
		labelPrecoTotal.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPrecoTotal.add(labelPrecoTotal);
		
		JLabel precoTotal = new JLabel();
		precoTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPrecoTotal.add(precoTotal);
		
		JPanel panelPrecoDesconto = new JPanel();
		panelPrecoDesconto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotal_Desconto_Parcelado.add(panelPrecoDesconto);
		panelPrecoDesconto.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoDesconto = new JLabel("Pre\u00E7o (R$) com 0% de desconto");
		labelPrecoDesconto.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPrecoDesconto.add(labelPrecoDesconto);
		
		JLabel precoDesconto = new JLabel();
		precoDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPrecoDesconto.add(precoDesconto);
		
		JPanel panelPrecoParcelado = new JPanel();
		panelPrecoParcelado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelPrecoTotal_Desconto_Parcelado.add(panelPrecoParcelado);
		panelPrecoParcelado.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPrecoParcelado = new JLabel("Pre\u00E7o parcelado");
		labelPrecoParcelado.setHorizontalAlignment(SwingConstants.LEFT);
		labelPrecoParcelado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPrecoParcelado.add(labelPrecoParcelado);
		
		JLabel precoParcelado = new JLabel();
		precoParcelado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPrecoParcelado.add(precoParcelado);
		
		/*Parte que consulta os dados no banco de dados*/
		String notaFiscalCodigo = sessao.getCodigoNotaFiscal();
		String compraCodigoNotaFiscal = sessao.getCodigoCompraNotaFiscal();
		Dao_consulta_dados_nota_fiscal_ficha teste = new Dao_consulta_dados_nota_fiscal_ficha();
    	List<NotaFiscal> Consulta = teste.Consulta_Dados_Nota_Fiscal_Ficha(notaFiscalCodigo, compraCodigoNotaFiscal);
    	for (NotaFiscal leitura : Consulta) {
    		String codigoNotaFiscalTexto = leitura.getCodigoNotaFiscal();
    		codigoNotaFiscal.setText(codigoNotaFiscalTexto);
    		
    		String codigoVendaTexto = leitura.getCodigoVenda();
    		codigoVenda.setText(codigoVendaTexto);
    		
    		Date dataEmissao = leitura.getDataEmissao();
    		SimpleDateFormat dataEmissaoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataEmissaoNotaFiscal = dataEmissaoFormato.format(dataEmissao);
    		
    		Time horaEmissao = leitura.getHoraEmissao();
    		SimpleDateFormat horaEmissaoFormato = new SimpleDateFormat("HH:mm");
    		String horaEmissaoNotaFiscal = horaEmissaoFormato.format(horaEmissao);
    		
    		String dataHoraEmissaoTexto = dataEmissaoNotaFiscal + " " + horaEmissaoNotaFiscal;
    		dataHoraEmissaoNotaFiscal.setText(dataHoraEmissaoTexto);
    		
    		String tipoPagamentoTexto = leitura.getTipoPagamento();
    		tipoPagamento.setText(tipoPagamentoTexto);
    		
    		String metodoPagamentoTexto = leitura.getMetodoPagamento();
    		metodoPagamento.setText(metodoPagamentoTexto);
    		
    		String notaFiscalPaulistaTexto = leitura.getNotaFiscalPaulista();
    		notaFiscalPaulista.setText(notaFiscalPaulistaTexto);
    		
    		String nomeClienteTexto = leitura.getClienteNome();
    		nomeCliente.setText(nomeClienteTexto);
    		
    		String cpfClienteTexto = leitura.getCPFCliente();
    		cpfCliente.setText(cpfClienteTexto);
    		
    		String codigoClienteTexto = leitura.getCodigoCliente();
    		codigoCliente.setText(codigoClienteTexto);
    		
    		String telefoneClienteTexto = leitura.getTelefoneCliente();
    		telefoneCliente.setText(telefoneClienteTexto);
    		
    		String celularClienteTexto = leitura.getCelularCliente();
    		celularCliente.setText(celularClienteTexto);
    		
    		String enderecoCliente = leitura.getEnderecoCliente();
    		endereco.setText(enderecoCliente);
    		
    		String numeroCliente = leitura.getNumeroCliente();
    		numero.setText(numeroCliente);
    		
    		String bairroCliente = leitura.getBairroCliente();
    		bairro.setText(bairroCliente);	
    		
    		String cepCliente = leitura.getCEPCliente();
    		cep.setText(cepCliente);
    		
    		String cidadeCliente = leitura.getCidadeCliente();
    		cidade.setText(cidadeCliente);	
    		
    		String estadoCliente = leitura.getEstadoCliente();
    		estado.setText(estadoCliente);
    		
    		String nomeFuncionarioTexto = leitura.getFuncionarioNome();
    		nomeFuncionarioResponsavel.setText(nomeFuncionarioTexto);
    		
    		String cargoFuncionarioTexto = leitura.getCargoFuncionario();
    		cargoResponsavel.setText(cargoFuncionarioTexto);
    		
    		String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
    		codigoResponsavel.setText(codigoFuncionarioTexto);
    		
    		double precoTotalValor = leitura.getPrecoTotal();
    		String precoTotalTexto = "" + precoTotalValor;
    		precoTotal.setText(precoTotalTexto);
    		
    		double porcentagemDescontoValor = leitura.getPorcentagemDesconto();
    		String porcentagemDescontoTexto = "Preço (R$) com " + porcentagemDescontoValor +"% de desconto" ;
    		labelPrecoDesconto.setText(porcentagemDescontoTexto);
    		setPorcentagemDescontoValor(porcentagemDescontoValor);
    		
    		double precoDescontoValor = leitura.getPrecoTotalDesconto();
    		String precoDescontoTexto = "" + precoDescontoValor;
    		precoDesconto.setText(precoDescontoTexto);
    		setDescontoPrecoTotal(precoDescontoValor);
    		
    		int quantidadeParcelasValor = leitura.getQuantidadeParcelas();
    		double precoParcelasValor = leitura.getPrecoTotalParcelas();
    		String precoTotalParcelasTexto = quantidadeParcelasValor + " x " + precoParcelasValor;
    		precoParcelado.setText(precoTotalParcelasTexto);
    		setQuantidadeParcelasVenda(quantidadeParcelasValor);
    		setPrecoTotalParcelado(precoParcelasValor);
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaFornecedor.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorFichadocliente = new JSeparator();
		panelBotoes.add(separatorFichadocliente, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		gerarNotaFiscal = new JButton("Gerar nota fiscal");
		gerarNotaFiscal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String caminhotxt = "C:\\Users\\ROSANGELA\\Desktop\\" + "Nota fiscal " + codigoNotaFiscal.getText() + " Cliente " + nomeCliente.getText() + ".txt";
					FileWriter arq = new FileWriter(caminhotxt);
		            PrintWriter gravarArq = new PrintWriter(arq);
		            gravarArq.println("---------------------------------------------------");
		            

		    		Dao_consulta_dados_loja consultaDadosLojaRegistro = new Dao_consulta_dados_loja();
		        	List<DadosLoja> ConsultaDadosLojaRegistro = consultaDadosLojaRegistro.Consulta_Dados_Fornecedor_Dados_Loja();
		        	for (DadosLoja leitura : ConsultaDadosLojaRegistro) {
		        		String estadoDadosLojaConsultaTexto = leitura.getEstadoDadosLoja();
		        		setEstadoDadosLojaConsultaRegistro(estadoDadosLojaConsultaTexto);
		    		}
		        	
		    		/*Parte que consulta os dados no banco de dados*/
		        	String estadoDadosLojaConsultaTexto = getEstadoDadosLojaConsultaRegistro();
		            Dao_consulta_dados_loja consultaDadosLoja = new Dao_consulta_dados_loja();
			    	List<DadosLoja> ConsultaDadosLoja = consultaDadosLoja.Consulta_Dados_Fornecedor_Ficha(estadoDadosLojaConsultaTexto);
			    	for (DadosLoja leitura : ConsultaDadosLoja) {
			    		String nomeLoja = leitura.getNome();
			    		String cnpjLoja = leitura.getCNPJ();
			    		String inscricaoNumero = leitura.getInscricaoNumero();
			    		String telefoneLoja = leitura.getTelefone1();
			    		String emailLoja = leitura.getEmail1();
			    		String estadoLoja = leitura.getEstado();
			    		String cepLoja = leitura.getCEP();
			    		String cidadeLoja = leitura.getCidade();
			    		String enderecoLoja = leitura.getEndereco();
			    		String numeroLoja = leitura.getNumero();
			    		String bairroLoja = leitura.getBairro();
			    		
			            gravarArq.println(nomeLoja);
			            gravarArq.println("CNPJ: " + cnpjLoja);
			            gravarArq.println(enderecoLoja + " " + numeroLoja);
			            gravarArq.println(bairroLoja);
			            gravarArq.println("CEP: " + cepLoja + ", " + estadoLoja + ", " + cidadeLoja);
			            gravarArq.println(numeroLoja + " " + bairroLoja);
			            gravarArq.println("Tel: " + telefoneLoja);
			            gravarArq.println("Email: " + emailLoja);
			            gravarArq.println("IE: " + inscricaoNumero);
			            gravarArq.println("Nota fiscal codigo" + codigoNotaFiscal.getText());
					}
			    	gravarArq.println("---------------------------------------------------");
			    	gravarArq.println(nomeCliente.getText());
	                gravarArq.println(cpfCliente.getText());
			    	gravarArq.println("Tel: " + telefoneCliente.getText() + " " + "Cel: " + celularCliente.getText());
		    		gravarArq.println(endereco.getText() + ", " + numero.getText());
		            gravarArq.println(bairro.getText());
		            gravarArq.println("CEP: " + cep.getText() + ", " + cidade.getText());
		            gravarArq.println(estado.getText());
			    	gravarArq.println("---------------------------------------------------");
		            gravarArq.println("|Codigo|Nome do produto|Qtd|Preço|Qtd x Preço");
		            gravarArq.println("---------------------------------------------------");
			    	
		            Dao_consulta_dados_venda_lista_produtos teste = new Dao_consulta_dados_venda_lista_produtos();
			    	List<VendaProdutos> Consulta = teste.Consulta_Dados_Venda_Lista_Produtos(compraCodigoNotaFiscal);
					for (VendaProdutos leitura : Consulta) {
						
						String codigoProduto = leitura.getCodigoProduto();
						String nomeProduto = leitura.getNomeProduto();
						
						double quantidadeValor = leitura.getQuantidade();
						String quantidadeProduto = "" + quantidadeValor;
						
						double precoUnitarioValor = leitura.getPrecoUnitario();
						String precoUnitarioProduto = "" + precoUnitarioValor;
						
						double precoQuantidadeValor = leitura.getPrecoQuantidade();
						String precoQuantidadeProduto = "" + precoQuantidadeValor;
						
						gravarArq.println(codigoProduto + " " + nomeProduto + " " + quantidadeProduto + " " + precoUnitarioProduto + " " + precoQuantidadeProduto);
					}
					gravarArq.println("---------------------------------------------------");
					gravarArq.println("Funcionario: " + nomeFuncionarioResponsavel.getText());
					gravarArq.println("Codigo do funcionario: " + codigoResponsavel.getText());
					gravarArq.println("Cargo: " + cargoResponsavel.getText());
					gravarArq.println("---------------------------------------------------");
					gravarArq.println("Nota fiscal paulista: " + notaFiscalPaulista.getText());
		            gravarArq.println("Metodo de pagamento: " + metodoPagamento.getText());
		            gravarArq.println("Tipo de pagamento: " + tipoPagamento.getText());
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
					String menssagemConteudo = "Impossivel carregar configurações";
		        	Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
		        	aviso.setVisible(true);
				}
			}
		});
		gerarNotaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(gerarNotaFiscal);
		
		exibirListaProdutos = new JButton("Exibe lista de produtos");
		exibirListaProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sessao.setVendaCodigo(compraCodigoNotaFiscal);
				Lista_de_Produtos_Vendas exibeVendasLista = new Lista_de_Produtos_Vendas();
				exibeVendasLista.setVisible(true);
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
	private String estadoDadosLojaConsultaRegistro;
	/*get e set Valor da porcentagem do desconto*/
	public double getPorcentagemDescontoValor() {
		return porcentagemDescontoValor;
	}
	public void setPorcentagemDescontoValor(double porcentagemDescontoValor) {
		this.porcentagemDescontoValor = porcentagemDescontoValor;
	}
	
	/*get e set Valor do preço total com desconto*/
	public double getDescontoPrecoTotal() {
		return descontoPrecoTotal;
	}
	public void setDescontoPrecoTotal(double descontoPrecoTotal) {
		this.descontoPrecoTotal = descontoPrecoTotal;
	}
	
	/*get e set Valor do preço total parcelado*/
	public double getPrecoTotalParcelado() {
		return precoTotalParcelado;
	}
	public void setPrecoTotalParcelado(double precoTotalParcelado) {
		this.precoTotalParcelado = precoTotalParcelado;
	}
	
	/*get e set Quantidade parcelas da venda*/
	public int getQuantidadeParcelasVenda() {
		return quantidadeParcelasVenda;
	}
	public void setQuantidadeParcelasVenda(int quantidadeParcelasVenda) {
		this.quantidadeParcelasVenda = quantidadeParcelasVenda;
	}
	
	/*get e set Estado dados loja registro*/
	public String getEstadoDadosLojaConsultaRegistro() {
		return estadoDadosLojaConsultaRegistro;
	}
	public void setEstadoDadosLojaConsultaRegistro(String estadoDadosLojaConsultaRegistro) {
		this.estadoDadosLojaConsultaRegistro = estadoDadosLojaConsultaRegistro;
	}
}