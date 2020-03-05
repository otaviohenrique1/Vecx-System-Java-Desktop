package moduloClienteTelas;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import aInterfaceSistema.Sessao;
import moduloClienteBD.Cliente;
import moduloClienteBD.Dao_consulta_dados_cliente;
import moduloClienteTabela.ClientesTabelaHistorico;
import moduloClienteTabela.TabelaModeloClientesHistorico;
import moduloFinanceiroVendaBD.Dao_consulta_dados_venda_cliente;
import moduloFinanceiroVendaBD.Venda;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Ficha_do_Cliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaCliente;
	private JTable tabelaHistoricoCompras;
	private TabelaModeloClientesHistorico TabelaModeloHistorico;
	private JButton produtoBusca, editar, voltar;
	private JTextField textBusca;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ficha_do_Cliente frame = new Ficha_do_Cliente();
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
	public Ficha_do_Cliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ficha_do_Cliente.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		setSize(1000, 600);
		
		telaFichaCliente = new JPanel();
		telaFichaCliente.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaFichaCliente);
		telaFichaCliente.setLayout(new BorderLayout(0, 5));
		
		JPanel panelTitulo = new JPanel();
		telaFichaCliente.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout fl_panelTitulo2 = (FlowLayout) panelTitulo2.getLayout();
		fl_panelTitulo2.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Ficha_do_Cliente.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFichaCliente = new JLabel("Ficha do cliente");
		panelTitulo2.add(labelFichaCliente);
		labelFichaCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		Sessao sessao = Sessao.getInstance();
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
		fichaUsuario.setIcon(new ImageIcon(Ficha_do_Cliente.class.getResource("/cImagens/Funcionario.png")));
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
		
		JTabbedPane tabbedPaneCliente = new JTabbedPane(JTabbedPane.TOP);
		telaFichaCliente.add(tabbedPaneCliente, BorderLayout.CENTER);
		
		JPanel panelFichaCliente = new JPanel();
		tabbedPaneCliente.addTab("Ficha do cliente", null, panelFichaCliente, null);
		panelFichaCliente.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPaneCadastro = new JScrollPane();
		scrollPaneCadastro.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneCadastro.getHorizontalScrollBar().setUnitIncrement(10);
		panelFichaCliente.add(scrollPaneCadastro);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNome_RG_CPF = new JPanel();
		panelNome_RG_CPF.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelNome_RG_CPF);
		panelNome_RG_CPF.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNome = new JPanel();
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome_RG_CPF.add(panelNome);
		panelNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNome = new JLabel("Nome");
		panelNome.add(labelNome);
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel nome = new JLabel();
		panelNome.add(nome);
		nome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelRG_CPF_CodCliente = new JPanel();
		panelNome_RG_CPF.add(panelRG_CPF_CodCliente);
		panelRG_CPF_CodCliente.setMinimumSize(new Dimension(10, 50));
		panelRG_CPF_CodCliente.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelRG = new JPanel();
		panelRG.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRG_CPF_CodCliente.add(panelRG);
		panelRG.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelRG = new JLabel("RG");
		panelRG.add(labelRG);
		labelRG.setHorizontalAlignment(SwingConstants.LEFT);
		labelRG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel rg = new JLabel();
		panelRG.add(rg);
		rg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCPF = new JPanel();
		panelRG_CPF_CodCliente.add(panelCPF);
		panelCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPF = new JLabel("CPF");
		panelCPF.add(labelCPF);
		labelCPF.setHorizontalAlignment(SwingConstants.LEFT);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cpf = new JLabel();
		panelCPF.add(cpf);
		cpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelData_Sexo_EstadoCivil = new JPanel();
		panelData_Sexo_EstadoCivil.setMinimumSize(new Dimension(10, 50));
		panelCadastro.add(panelData_Sexo_EstadoCivil);
		panelData_Sexo_EstadoCivil.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelCodigoCliente = new JPanel();
		panelData_Sexo_EstadoCivil.add(panelCodigoCliente);
		panelCodigoCliente.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoCliente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoCliente = new JLabel("Codigo do cliente");
		labelCodigoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoCliente.add(labelCodigoCliente);
		
		JLabel codigoCliente = new JLabel();
		codigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoCliente.add(codigoCliente);
		
		JPanel panelData = new JPanel();
		panelData.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelData_Sexo_EstadoCivil.add(panelData);
		panelData.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataNascimento = new JLabel("Data de nascimento");
		panelData.add(labelDataNascimento);
		labelDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDataNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel dataNascimento = new JLabel();
		panelData.add(dataNascimento);
		dataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelSexo = new JPanel();
		panelData_Sexo_EstadoCivil.add(panelSexo);
		panelSexo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelSexo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSexo = new JLabel("Sexo");
		panelSexo.add(labelSexo);
		labelSexo.setHorizontalAlignment(SwingConstants.LEFT);
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel sexo = new JLabel();
		panelSexo.add(sexo);
		sexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEstadoCivil = new JPanel();
		panelData_Sexo_EstadoCivil.add(panelEstadoCivil);
		panelEstadoCivil.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstadoCivil.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstadoCivil = new JLabel("Estado civil");
		panelEstadoCivil.add(labelEstadoCivil);
		labelEstadoCivil.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel estadoCivil = new JLabel();
		panelEstadoCivil.add(estadoCivil);
		estadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTelefone_Celular = new JPanel();
		panelTelefone_Celular.setMinimumSize(new Dimension(10, 50));
		panelCadastro.add(panelTelefone_Celular);
		panelTelefone_Celular.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelTelefone1 = new JPanel();
		panelTelefone1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelTelefone1);
		panelTelefone1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTelefone1 = new JLabel("Telefone 1");
		panelTelefone1.add(labelTelefone1);
		labelTelefone1.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefone1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel telefone1 = new JLabel();
		panelTelefone1.add(telefone1);
		telefone1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTelefone2 = new JPanel();
		panelTelefone2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelTelefone2);
		panelTelefone2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTelefone2 = new JLabel("Telefone 2");
		labelTelefone2.setHorizontalAlignment(SwingConstants.LEFT);
		labelTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTelefone2.add(labelTelefone2);
		
		JLabel telefone2 = new JLabel();
		telefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelTelefone2.add(telefone2);
		
		JPanel panelCelular1 = new JPanel();
		panelCelular1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelCelular1);
		panelCelular1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular1 = new JLabel("Celular 1");
		panelCelular1.add(labelCelular1);
		labelCelular1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel celular1 = new JLabel();
		panelCelular1.add(celular1);
		celular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCelular2 = new JPanel();
		panelCelular2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTelefone_Celular.add(panelCelular2);
		panelCelular2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular2 = new JLabel("Celular 2");
		labelCelular2.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCelular2.add(labelCelular2);
		
		JLabel celular2 = new JLabel();
		celular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCelular2.add(celular2);
		
		JPanel panelEmail_Email2 = new JPanel();
		panelEmail_Email2.setMinimumSize(new Dimension(10, 50));
		panelCadastro.add(panelEmail_Email2);
		panelEmail_Email2.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelEmail = new JPanel();
		panelEmail.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail_Email2.add(panelEmail);
		panelEmail.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail1 = new JLabel("Email 1");
		panelEmail.add(labelEmail1);
		labelEmail1.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel email1 = new JLabel();
		panelEmail.add(email1);
		email1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEmail2 = new JPanel();
		panelEmail_Email2.add(panelEmail2);
		panelEmail2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail2 = new JLabel("Email 2");
		panelEmail2.add(labelEmail2);
		labelEmail2.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel email2 = new JLabel();
		panelEmail2.add(email2);
		email2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelNac_PaisOrigem_DataHora = new JPanel();
		panelNac_PaisOrigem_DataHora.setMinimumSize(new Dimension(10, 50));
		panelCadastro.add(panelNac_PaisOrigem_DataHora);
		panelNac_PaisOrigem_DataHora.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelNacionalidade = new JPanel();
		panelNacionalidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNac_PaisOrigem_DataHora.add(panelNacionalidade);
		panelNacionalidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNacionalidade = new JLabel("Nacionalidade");
		labelNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNacionalidade.add(labelNacionalidade);
		
		JLabel nacionalidade = new JLabel();
		nacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelNacionalidade.add(nacionalidade);
		
		JPanel panelPaisOrigem = new JPanel();
		panelPaisOrigem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNac_PaisOrigem_DataHora.add(panelPaisOrigem);
		panelPaisOrigem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPaisOrigem = new JLabel("Pais de origem");
		labelPaisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		labelPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(labelPaisOrigem);
		
		JLabel paisOrigem = new JLabel();
		paisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(paisOrigem);
		
		JPanel panelDataHoraCadastro = new JPanel();
		panelNac_PaisOrigem_DataHora.add(panelDataHoraCadastro);
		panelDataHoraCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHoraCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelDataHoraCadastro = new JLabel("Data e hora de cadastro");
		labelDataHoraCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelDataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraCadastro.add(labelDataHoraCadastro);
		
		JLabel dataHoraCadastro = new JLabel();
		dataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraCadastro.add(dataHoraCadastro);
		
		JPanel panelComplemento_CEP = new JPanel();
		panelComplemento_CEP.setMinimumSize(new Dimension(10, 50));
		panelCadastro.add(panelComplemento_CEP);
		panelComplemento_CEP.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelEstado = new JPanel();
		panelComplemento_CEP.add(panelEstado);
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstado.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstado = new JLabel("Estado");
		panelEstado.add(labelEstado);
		labelEstado.setHorizontalAlignment(SwingConstants.LEFT);
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel estado = new JLabel();
		panelEstado.add(estado);
		estado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCEP = new JPanel();
		panelComplemento_CEP.add(panelCEP);
		panelCEP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCEP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCEP = new JLabel("CEP");
		panelCEP.add(labelCEP);
		labelCEP.setHorizontalAlignment(SwingConstants.LEFT);
		labelCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cep = new JLabel();
		panelCEP.add(cep);
		cep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCidade = new JPanel();
		panelComplemento_CEP.add(panelCidade);
		panelCidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCidade = new JLabel("Cidade");
		panelCidade.add(labelCidade);
		labelCidade.setHorizontalAlignment(SwingConstants.LEFT);
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cidade = new JLabel();
		panelCidade.add(cidade);
		cidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEndereco = new JPanel();
		panelEndereco.setMinimumSize(new Dimension(10, 50));
		panelCadastro.add(panelEndereco);
		panelEndereco.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEndereco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o");
		panelEndereco.add(labelEndereco);
		labelEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel endereco = new JLabel();
		panelEndereco.add(endereco);
		endereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelBairro_Estado = new JPanel();
		panelBairro_Estado.setMinimumSize(new Dimension(10, 50));
		panelCadastro.add(panelBairro_Estado);
		panelBairro_Estado.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelNumero = new JPanel();
		panelBairro_Estado.add(panelNumero);
		panelNumero.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNumero.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNumero = new JLabel("Numero");
		panelNumero.add(labelNumero);
		labelNumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel numero = new JLabel();
		panelNumero.add(numero);
		numero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelComplemento = new JPanel();
		panelBairro_Estado.add(panelComplemento);
		panelComplemento.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComplemento.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelComplemento = new JLabel("Complemento");
		panelComplemento.add(labelComplemento);
		labelComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		labelComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel complemento = new JLabel();
		panelComplemento.add(complemento);
		complemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelBairro = new JPanel();
		panelBairro_Estado.add(panelBairro);
		panelBairro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelBairro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairro = new JLabel("Bairro");
		panelBairro.add(labelBairro);
		labelBairro.setHorizontalAlignment(SwingConstants.LEFT);
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel bairro = new JLabel();
		panelBairro.add(bairro);
		bairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelReferencia = new JPanel();
		panelReferencia.setMinimumSize(new Dimension(10, 50));
		panelCadastro.add(panelReferencia);
		panelReferencia.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelReferencia.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelReferencia = new JLabel("Referencia");
		panelReferencia.add(labelReferencia);
		labelReferencia.setHorizontalAlignment(SwingConstants.LEFT);
		labelReferencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel referencia = new JLabel();
		panelReferencia.add(referencia);
		referencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelFuncionario = new JPanel();
		panelFuncionario.setMinimumSize(new Dimension(10, 50));
		panelCadastro.add(panelFuncionario);
		panelFuncionario.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelFuncionarioCadastro = new JPanel();
		panelFuncionarioCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelFuncionario.add(panelFuncionarioCadastro);
		panelFuncionarioCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelFuncionarioCadastro = new JLabel("Funcionario que cadastrou");
		labelFuncionarioCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		labelFuncionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFuncionarioCadastro.add(labelFuncionarioCadastro);
		
		JLabel funcionarioCadastro = new JLabel();
		funcionarioCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFuncionarioCadastro.add(funcionarioCadastro);
		
		JPanel panelCargo_Codigo = new JPanel();
		panelFuncionario.add(panelCargo_Codigo);
		panelCargo_Codigo.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelCargoFuncionario = new JPanel();
		panelCargoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCargo_Codigo.add(panelCargoFuncionario);
		panelCargoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCargoFuncionario = new JLabel("Cargo do funcionario");
		labelCargoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelCargoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargoFuncionario.add(labelCargoFuncionario);
		
		JLabel cargoFuncionario = new JLabel();
		cargoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCargoFuncionario.add(cargoFuncionario);
		
		JPanel panelCodigoFuncionario = new JPanel();
		panelCargo_Codigo.add(panelCodigoFuncionario);
		panelCodigoFuncionario.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCodigoFuncionario.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCodigoFuncionario = new JLabel("Codigo do funcionario");
		labelCodigoFuncionario.setHorizontalAlignment(SwingConstants.LEFT);
		labelCodigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFuncionario.add(labelCodigoFuncionario);
		
		JLabel codigoFuncionario = new JLabel();
		codigoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCodigoFuncionario.add(codigoFuncionario);

		/*Parte que consulta os dados no banco de dados*/
		String codigoClienteConsulta = sessao.getCodigoCliente();
		String nomeClienteConsulta = sessao.getNomeCliente();
		String cpfClienteConsulta = sessao.getCPFCliente();
		Dao_consulta_dados_cliente fichaCliente = new Dao_consulta_dados_cliente();
    	List<Cliente> Consulta = fichaCliente.Consulta_Dados_Cliente_Ficha(codigoClienteConsulta, nomeClienteConsulta, cpfClienteConsulta);
    	for (Cliente leitura : Consulta) {
    		String nomeClienteTexto = leitura.getNome();
    		nome.setText(nomeClienteTexto);
    		
    		String codigoClienteTexto = leitura.getCodigoCliente();
    		codigoCliente.setText(codigoClienteTexto);
    		
    		String rgClienteTexto = leitura.getRG();
    		rg.setText(rgClienteTexto);
    		
    		String cpfClienteTexto = leitura.getCPF();
    		cpf.setText(cpfClienteTexto);
    		
    		Date dataNascimentoFuncionario = leitura.getDataNascimento();
    		SimpleDateFormat dataNascimentoFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataNacimentoValor = dataNascimentoFormato.format(dataNascimentoFuncionario);
    		dataNascimento.setText(dataNacimentoValor);
    		
    		String sexoClienteTexto = leitura.getSexo();
    		sexo.setText(sexoClienteTexto);
    		
    		String estadoCivilCliente = leitura.getEstadoCivil();
    		estadoCivil.setText(estadoCivilCliente);
    		
    		String telefone1Cliente = leitura.getTelefone1();
    		telefone1.setText(telefone1Cliente);
    		
    		String telefone2Cliente = leitura.getTelefone2();
    		telefone2.setText(telefone2Cliente);
    		
    		String celular1Cliente = leitura.getCelular1();
    		celular1.setText(celular1Cliente);
    		
    		String celular2Cliente = leitura.getCelular2();
    		celular2.setText(celular2Cliente);
    		
    		String email1Cliente = leitura.getEmail1();
    		email1.setText(email1Cliente);
    		
    		String email2Cliente = leitura.getEmail2();
    		email2.setText(email2Cliente);
    		
    		String nacionalidadeCliente = leitura.getNacionalidade();
    		nacionalidade.setText(nacionalidadeCliente);
    		
    		String paisOrigemCliente = leitura.getPaisOrigem();
    		paisOrigem.setText(paisOrigemCliente);
    		
    		Date dataCadastroCliente =	leitura.getDataCadastro();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroCliente);
    		Time horaCadastroCliente = leitura.getHoraCadastro();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroCliente);
    		dataHoraCadastro.setText(dataCadastroValor + " " + horaCadastroValor);
    		
    		String nomeFuncionarioTexto = leitura.getFuncionarioCadastro();
    		funcionarioCadastro.setText(nomeFuncionarioTexto);
    		
    		String cargoFuncionarioTexto = leitura.getCargoFuncionario();
    		cargoFuncionario.setText(cargoFuncionarioTexto);
    		
    		String codigoFuncionarioTexto = leitura.getCodigoFuncionario();
    		codigoFuncionario.setText(codigoFuncionarioTexto);
    		
    		String estadoCliente = leitura.getEstado();
    		estado.setText(estadoCliente);
    		
    		String cepCliente = leitura.getCEP();
    		cep.setText(cepCliente);
    		
    		String cidadeCliente = leitura.getCidade();
    		cidade.setText(cidadeCliente);
    		
    		String enderecoCliente = leitura.getEndereco();
    		endereco.setText(enderecoCliente);
    		
    		String numeroCliente = leitura.getNumero();
    		numero.setText(numeroCliente);
    		
    		String complementoCliente = leitura.getComplemento();
    		complemento.setText(complementoCliente);
    		
    		String bairroCliente = leitura.getBairro();
    		bairro.setText(bairroCliente);
    		
    		String referenciaCliente = leitura.getReferencia();
    		referencia.setText(referenciaCliente);
		}
    	
		JPanel panelHistoricoCompras = new JPanel();
		tabbedPaneCliente.addTab("Historico de compras", null, panelHistoricoCompras, null);
		panelHistoricoCompras.setLayout(new BorderLayout(0, 5));

		/*Busca na tabela de compras do cliente*/
		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelHistoricoCompras.add(panelBusca, BorderLayout.NORTH);
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
		
		/*Tabela com a lista de compras do cliente*/
		JScrollPane scrollPaneHistoricoCompras = new JScrollPane();
		scrollPaneHistoricoCompras.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneHistoricoCompras.getHorizontalScrollBar().setUnitIncrement(10);
		panelHistoricoCompras.add(scrollPaneHistoricoCompras);
		TabelaModeloHistorico = new TabelaModeloClientesHistorico();
		tabelaHistoricoCompras = new JTable();
		tabelaHistoricoCompras.setModel(TabelaModeloHistorico);
		scrollPaneHistoricoCompras.setViewportView(tabelaHistoricoCompras);
		
		/*Parte da busca na tabela*/
		TableRowSorter<TabelaModeloClientesHistorico> sorterBuscaHistorico = new TableRowSorter<TabelaModeloClientesHistorico>(TabelaModeloHistorico);
		tabelaHistoricoCompras.setRowSorter(sorterBuscaHistorico);
		produtoBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavraBusca = textBusca.getText();
				if (palavraBusca.length() ==0 ) {
					sorterBuscaHistorico.setRowFilter(null);
				}
				else {
					sorterBuscaHistorico.setRowFilter(RowFilter.regexFilter(palavraBusca));
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
						sorterBuscaHistorico.setRowFilter(null);
					}
					else {
						sorterBuscaHistorico.setRowFilter(RowFilter.regexFilter(palavraBusca));
					}
				}
			}
		});
		
		/*Parte que consulta os dados no banco de dados*/
		//String vendaClienteConsulta = sessao.getVendaCliente();
		String vendaClienteNome = nome.getText();
		//sessao.setVendaNome(vendaClienteNome);
		//String vendaClienteConsulta = sessao.getVendaNome();
		Dao_consulta_dados_venda_cliente fichaVenda = new Dao_consulta_dados_venda_cliente();
    	List<Venda> ConsultaVenda = fichaVenda.Consulta_Dados_Venda_Cliente(vendaClienteNome);
    	for (Venda leituraVenda : ConsultaVenda) {
    		
    		String codigoVendaClinte = leituraVenda.getCodigoVenda();
    		
    		Date dataCadastroCliente =	leituraVenda.getDataVenda();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroCliente);
    		
    		Time horaCadastroCliente = leituraVenda.getHoraVenda();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroCliente);
    		
    		String dataHoraCompraValor = dataCadastroValor + " " + horaCadastroValor;
    		
    		double valorPrecoTotal = leituraVenda.getPrecoTotal();
    		String valorTotalTexto = "" + valorPrecoTotal;
    		
    		ClientesTabelaHistorico listaHistoricoCompras = new ClientesTabelaHistorico(codigoVendaClinte , dataHoraCompraValor, valorTotalTexto);
    		TabelaModeloHistorico.addCompraHistorico(listaHistoricoCompras);
    		
		}
		
    	/*Parte que consulta os dados no banco de dados*/
    	String vendaClienteNome1 = nome.getText();
		Dao_consulta_dados_venda_cliente fichaProdutosComprados = new Dao_consulta_dados_venda_cliente();
    	List<Venda> ConsultaProdutosComprados = fichaProdutosComprados.Consulta_Dados_Venda_Cliente(vendaClienteNome1);
    	for (Venda leituraVenda : ConsultaProdutosComprados) {
    		
    		String codigoVendaClinte = leituraVenda.getCodigoVenda();
    		
    		Date dataCadastroCliente =	leituraVenda.getDataVenda();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroCliente);
    		
    		Time horaCadastroCliente = leituraVenda.getHoraVenda();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroCliente);
    		
    		String dataHoraCompraValor = dataCadastroValor + " " + horaCadastroValor;
    		
    		double valorPrecoTotal = leituraVenda.getPrecoTotal();
    		String valorTotalTexto = "" + valorPrecoTotal;
    		
    		ClientesTabelaHistorico listaHistoricoCompras = new ClientesTabelaHistorico(codigoVendaClinte , dataHoraCompraValor, valorTotalTexto);
    		TabelaModeloHistorico.addCompraHistorico(listaHistoricoCompras);
    		
		}
		
		JPanel panelBotoes = new JPanel();
		telaFichaCliente.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		addWindowListener(
                new WindowAdapter() 
                {
                    public void windowClosing(WindowEvent we) {
                    	setVisible(false);
                    }
                }
        );
		
		editar = new JButton("Editar");
		editar.setToolTipText("Editar os dados da ficha");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ficha_do_Cliente_Editar FichaClienteEditar = new Ficha_do_Cliente_Editar();
				FichaClienteEditar.setVisible(true);
				dispose();
			}
		});
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
		
		if (cargoUsuario != null) {
			if (cargoUsuario.equals("Carregador")) {
				editar.setEnabled(false);
			}
		}
	}
}