package moduloAdministrativo;

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
import java.util.List;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import aInterfaceSistema.Sessao;
import moduloFuncionarioTelas.Ficha_do_Funcionario_Exibicao;

public class Loja_Ficha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel telaFichaLoja;
	private JButton editar, voltar;
	Sessao sessao = Sessao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loja_Ficha frame = new Loja_Ficha();
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
	public Loja_Ficha() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Loja_Ficha.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		setSize(1000, 600);
		
		telaFichaLoja = new JPanel();
		telaFichaLoja.setBorder(new EmptyBorder(5, 5, 5, 5));
		telaFichaLoja.setLayout(new BorderLayout(0, 5));
		setContentPane(telaFichaLoja);
		
		JPanel panelTitulo = new JPanel();
		telaFichaLoja.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		JLabel icone = new JLabel("");
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Loja_Ficha.class.getResource("/cImagens/Ficha.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelFichaLoja = new JLabel("Ficha de dados da loja");
		panelTitulo2.add(labelFichaLoja);
		labelFichaLoja.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
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
		fichaUsuario.setIcon(new ImageIcon(Loja_Ficha.class.getResource("/cImagens/Funcionario.png")));
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
		
		JPanel panelFichaFornecedor = new JPanel();
		telaFichaLoja.add(panelFichaFornecedor, BorderLayout.CENTER);
		panelFichaFornecedor.setLayout(new GridLayout(0, 1, 5, 5));
		
		JScrollPane scrollPaneCadastro = new JScrollPane();
		scrollPaneCadastro.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneCadastro.getHorizontalScrollBar().setUnitIncrement(10);
		panelFichaFornecedor.add(scrollPaneCadastro);
		
		JPanel panelCadastro = new JPanel();
		scrollPaneCadastro.setViewportView(panelCadastro);
		panelCadastro.setLayout(new GridLayout(0, 1, 5, 5));
		
		JPanel panelNome = new JPanel();
		panelNome.setPreferredSize(new Dimension(10, 50));
		panelCadastro.add(panelNome);
		panelNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNome.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNome = new JLabel("Nome");
		panelNome.add(labelNome);
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel nome = new JLabel();
		panelNome.add(nome);
		nome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelRazaoSocial = new JPanel();
		panelRazaoSocial.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCadastro.add(panelRazaoSocial);
		panelRazaoSocial.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelRazaoSocial = new JLabel("Raz\u00E3o social");
		labelRazaoSocial.setHorizontalAlignment(SwingConstants.LEFT);
		labelRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelRazaoSocial.add(labelRazaoSocial);
		
		JLabel razaoSocial = new JLabel();
		razaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelRazaoSocial.add(razaoSocial);
		
		JPanel panelCNPJ_CPF_InscEst_DataHora = new JPanel();
		panelCadastro.add(panelCNPJ_CPF_InscEst_DataHora);
		panelCNPJ_CPF_InscEst_DataHora.setLayout(new GridLayout(0, 4, 5, 0));
		
		JPanel panelCNPJ = new JPanel();
		panelCNPJ.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCNPJ_CPF_InscEst_DataHora.add(panelCNPJ);
		panelCNPJ.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCNPJ = new JLabel("CNPJ");
		panelCNPJ.add(labelCNPJ);
		labelCNPJ.setHorizontalAlignment(SwingConstants.LEFT);
		labelCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cnpj = new JLabel();
		panelCNPJ.add(cnpj);
		cnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCPF = new JPanel();
		panelCPF.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCNPJ_CPF_InscEst_DataHora.add(panelCPF);
		panelCPF.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCPF = new JLabel("CPF");
		panelCPF.add(labelCPF);
		labelCPF.setHorizontalAlignment(SwingConstants.LEFT);
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cpf = new JLabel();
		panelCPF.add(cpf);
		cpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelDataHoraCadastro = new JPanel();
		panelCNPJ_CPF_InscEst_DataHora.add(panelDataHoraCadastro);
		panelDataHoraCadastro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDataHoraCadastro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCadastroDataHora = new JLabel("Data e hora do cadastro");
		labelCadastroDataHora.setHorizontalAlignment(SwingConstants.LEFT);
		labelCadastroDataHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDataHoraCadastro.add(labelCadastroDataHora);
		
		JLabel dataHoraCadastro = new JLabel();
		panelDataHoraCadastro.add(dataHoraCadastro);
		dataHoraCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelInscricaoEstadual = new JPanel();
		panelCNPJ_CPF_InscEst_DataHora.add(panelInscricaoEstadual);
		panelInscricaoEstadual.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelInscricaoEstadual.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelInscricaoEstadual = new JLabel("Inscri\u00E7\u00E3o estadual");
		panelInscricaoEstadual.add(labelInscricaoEstadual);
		labelInscricaoEstadual.setHorizontalAlignment(SwingConstants.LEFT);
		labelInscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelInscricaoEstadual2 = new JPanel();
		panelInscricaoEstadual.add(panelInscricaoEstadual2);
		panelInscricaoEstadual2.setLayout(new BorderLayout(5, 0));
		
		JLabel inscricaoEstadual = new JLabel();
		inscricaoEstadual.setPreferredSize(new Dimension(80, 14));
		panelInscricaoEstadual2.add(inscricaoEstadual, BorderLayout.WEST);
		inscricaoEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel inscricaoNumero = new JLabel();
		panelInscricaoEstadual2.add(inscricaoNumero);
		inscricaoNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelTelefone_Celular = new JPanel();
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
		
		JLabel tabelTelefone2 = new JLabel("Telefone 2");
		panelTelefone2.add(tabelTelefone2);
		tabelTelefone2.setHorizontalAlignment(SwingConstants.LEFT);
		tabelTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel telefone2 = new JLabel();
		panelTelefone2.add(telefone2);
		telefone2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCelular1 = new JPanel();
		panelTelefone_Celular.add(panelCelular1);
		panelCelular1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCelular1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular1 = new JLabel("Celular 1");
		panelCelular1.add(labelCelular1);
		labelCelular1.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel celular1 = new JLabel();
		panelCelular1.add(celular1);
		celular1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCelular2 = new JPanel();
		panelTelefone_Celular.add(panelCelular2);
		panelCelular2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelCelular2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular2 = new JLabel("Celular 2");
		panelCelular2.add(labelCelular2);
		labelCelular2.setHorizontalAlignment(SwingConstants.LEFT);
		labelCelular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel celular2 = new JLabel();
		panelCelular2.add(celular2);
		celular2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEmail = new JPanel();
		panelCadastro.add(panelEmail);
		panelEmail.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelEmail1 = new JPanel();
		panelEmail1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail.add(panelEmail1);
		panelEmail1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail1 = new JLabel("Email");
		panelEmail1.add(labelEmail1);
		labelEmail1.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel email1 = new JLabel();
		panelEmail1.add(email1);
		email1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelEmail2 = new JPanel();
		panelEmail2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEmail.add(panelEmail2);
		panelEmail2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEmail2 = new JLabel("Email 2");
		panelEmail2.add(labelEmail2);
		labelEmail2.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel email2 = new JLabel();
		panelEmail2.add(email2);
		email2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelNac_PaisOrigem = new JPanel();
		panelCadastro.add(panelNac_PaisOrigem);
		panelNac_PaisOrigem.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelNacionalidade = new JPanel();
		panelNacionalidade.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNac_PaisOrigem.add(panelNacionalidade);
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
		panelNac_PaisOrigem.add(panelPaisOrigem);
		panelPaisOrigem.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelPaisOrigem = new JLabel("Pais de origem");
		labelPaisOrigem.setHorizontalAlignment(SwingConstants.LEFT);
		labelPaisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(labelPaisOrigem);
		
		JLabel paisOrigem = new JLabel();
		paisOrigem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPaisOrigem.add(paisOrigem);
		
		JPanel panelEstado_CEP_Cidade = new JPanel();
		panelCadastro.add(panelEstado_CEP_Cidade);
		panelEstado_CEP_Cidade.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelEstado = new JPanel();
		panelEstado_CEP_Cidade.add(panelEstado);
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
		panelCEP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelEstado_CEP_Cidade.add(panelCEP);
		panelCEP.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCEP = new JLabel("CEP");
		panelCEP.add(labelCEP);
		labelCEP.setHorizontalAlignment(SwingConstants.LEFT);
		labelCEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel cep = new JLabel();
		panelCEP.add(cep);
		cep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelCidade = new JPanel();
		panelEstado_CEP_Cidade.add(panelCidade);
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
		
		JPanel panelNume_Comp_Bairro = new JPanel();
		panelCadastro.add(panelNume_Comp_Bairro);
		panelNume_Comp_Bairro.setLayout(new GridLayout(0, 3, 5, 0));
		
		JPanel panelNumero = new JPanel();
		panelNumero.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNume_Comp_Bairro.add(panelNumero);
		panelNumero.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelNumero = new JLabel("Numero");
		panelNumero.add(labelNumero);
		labelNumero.setHorizontalAlignment(SwingConstants.LEFT);
		labelNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel numero = new JLabel();
		panelNumero.add(numero);
		numero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelComplemento = new JPanel();
		panelNume_Comp_Bairro.add(panelComplemento);
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
		panelBairro.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNume_Comp_Bairro.add(panelBairro);
		panelBairro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairro = new JLabel("Bairro");
		panelBairro.add(labelBairro);
		labelBairro.setHorizontalAlignment(SwingConstants.LEFT);
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel bairro = new JLabel();
		panelBairro.add(bairro);
		bairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelReferencia = new JPanel();
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
		
		/*Parte que consulta no banco de dados o estado dos dados da loja*/
		/*se os mesmos estao registrados ou não registrados*/
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
    		String nomeLoja = leitura.getNome();
    		nome.setText(nomeLoja);
    		
    		String razaoSocialLoja = leitura.getRazaoSocial();
    		razaoSocial.setText(razaoSocialLoja);
    		
    		String cnpjLoja = leitura.getCNPJ();
    		cnpj.setText(cnpjLoja);
    		
    		String cpfLoja = leitura.getCPF();
    		cpf.setText(cpfLoja);
    		
    		Date dataCadastroCliente =	leitura.getDataCadastro();
    		SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
    		String dataCadastroValor = dataCadastroFormato.format(dataCadastroCliente);
    		Time horaCadastroCliente = leitura.getHoraCadastro();
    		SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
    		String horaCadastroValor = horaCadastroFormato.format(horaCadastroCliente);
    		dataHoraCadastro.setText(dataCadastroValor + " " + horaCadastroValor);
    		
    		String inscricaoEstadualLoja = leitura.getInscricaoEstadual();
    		inscricaoEstadual.setText(inscricaoEstadualLoja);
    		
    		String inscricaoNumeroLoja = leitura.getInscricaoNumero();
    		inscricaoNumero.setText(inscricaoNumeroLoja);
    		
    		String telefone1Loja = leitura.getTelefone1();
    		if (telefone1Loja.equals("Opcional")) {
    			String telefone1LojaTexto = "Opcional";
    			telefone1.setText(telefone1LojaTexto);
			}
    		else {
				telefone1.setText(telefone1Loja);
			}
    		
    		String telefone2Loja = leitura.getTelefone2();
    		if (telefone2Loja.equals("Opcional")) {
    			String telefone2LojaTexto = "Opcional";
    			telefone2.setText(telefone2LojaTexto);
			}
    		else {
    			telefone2.setText(telefone2Loja);
			}
    		
    		String celular1Loja = leitura.getCelular1();
    		if (celular1Loja.equals("Opcional")) {
    			String celular1LojaTexto = "Opcional";
    			celular1.setText(celular1LojaTexto);
			}
    		else {
    			celular1.setText(celular1Loja);
			}
    		
    		String celular2Loja = leitura.getCelular2();
    		if (celular2Loja.equals("Opcional")) {
    			String celular2LojaTexto = "Opcional";
    			celular2.setText(celular2LojaTexto);
			}
    		else {
    			celular2.setText(celular2Loja);
			}
    		
    		String email1Loja = leitura.getEmail1();
    		if (email1Loja.equals("Opcional")) {
    			String email1LojaTexto = "Opcional";
    			email1.setText(email1LojaTexto);
			}
    		else {
    			email1.setText(email1Loja);
			}
    		
    		String email2Loja = leitura.getEmail2();
    		if (email2Loja.equals("Opcional")) {
    			String email2LojaTexto = "Opcional";
    			email2.setText(email2LojaTexto);
			}
    		else {
    			email2.setText(email2Loja);
			}
    		
    		String nacionalidadeLoja = leitura.getNacionalidade();
    		nacionalidade.setText(nacionalidadeLoja);
    		
    		String paisLoja = leitura.getPais();
    		paisOrigem.setText(paisLoja);
    		
    		String estadoLoja = leitura.getEstado();
    		estado.setText(estadoLoja);
    		
    		String cepLoja = leitura.getCEP();
    		cep.setText(cepLoja);
    		
    		String cidadeLoja = leitura.getCidade();
    		cidade.setText(cidadeLoja);
    		
    		String enderecoLoja = leitura.getEndereco();
    		endereco.setText(enderecoLoja);
    		
    		String numeroLoja = leitura.getNumero();
    		numero.setText(numeroLoja);
    		
    		String complementoLoja = leitura.getComplemento();
    		complemento.setText(complementoLoja);
    		
    		String bairroLoja = leitura.getBairro();
    		bairro.setText(bairroLoja);
    		
    		String referenciaLoja = leitura.getReferencia();
    		referencia.setText(referenciaLoja);
		}
				
		JPanel panelBotoes = new JPanel();
		telaFichaLoja.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		FlowLayout fl_panelBotoes2 = (FlowLayout) panelBotoes2.getLayout();
		fl_panelBotoes2.setAlignment(FlowLayout.RIGHT);
		panelBotoes.add(panelBotoes2);
		
		editar = new JButton("Editar");
		editar.setToolTipText("Editar os dados da ficha");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loja_Ficha_Editar abrirFichaLoja = new Loja_Ficha_Editar();
				abrirFichaLoja.setVisible(true);
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
	}
	
	/*Metodos get e set */
	private String estadoDadosLojaConsultaRegistro;
	/*get e set Estado dados loja registro*/
	public String getEstadoDadosLojaConsultaRegistro() {
		return estadoDadosLojaConsultaRegistro;
	}
	public void setEstadoDadosLojaConsultaRegistro(String estadoDadosLojaConsultaRegistro) {
		this.estadoDadosLojaConsultaRegistro = estadoDadosLojaConsultaRegistro;
	}
}