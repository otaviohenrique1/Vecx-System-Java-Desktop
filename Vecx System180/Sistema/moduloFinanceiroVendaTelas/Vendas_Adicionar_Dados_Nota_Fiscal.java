package moduloFinanceiroVendaTelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;

public class Vendas_Adicionar_Dados_Nota_Fiscal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton salvar, limpar, cancelar;
	private JTextField textCidade, textBairro, textEndereco, textNumero;
	private JFormattedTextField textTelefone, textCelular, textCEP;
	private JComboBox<String> comboBoxEstado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Vendas_Adicionar_Dados_Nota_Fiscal dialog = new Vendas_Adicionar_Dados_Nota_Fiscal();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Vendas_Adicionar_Dados_Nota_Fiscal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vendas_Adicionar_Dados_Nota_Fiscal.class.getResource("/cImagens/Logo Janela.PNG")));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Vecx System");
		setBounds(100, 100, 450, 418);
		setResizable(false);
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setVgap(5);
		borderLayout.setHgap(5);
		getContentPane().setLayout(borderLayout);
		
		JPanel panelTitulo = new JPanel();
		FlowLayout fl_panelTitulo = (FlowLayout) panelTitulo.getLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Vendas_Adicionar_Dados_Nota_Fiscal.class.getResource("/cImagens/Adicionar cliente.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelTitulo.add(icone);
		
		JLabel labelDadosCliente = new JLabel("Dados do cliente");
		labelDadosCliente.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panelTitulo.add(labelDadosCliente);
		
		MaskFormatter numeroTelefoneMascara = null;
		MaskFormatter numeroCelularMascara = null;
		MaskFormatter numeroCEPMascara = null;
		try{
			numeroTelefoneMascara = new MaskFormatter("(##)####-####");
			numeroCelularMascara = new MaskFormatter("(##)#####-####");
			numeroCEPMascara = new MaskFormatter("#####-###");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		JPanel panelDadosCliente = new JPanel();
		getContentPane().add(panelDadosCliente, BorderLayout.CENTER);
		
		JPanel panelDadosCliente2 = new JPanel();
		panelDadosCliente2.setPreferredSize(new Dimension(430, 290));
		panelDadosCliente.add(panelDadosCliente2);
		panelDadosCliente2.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelTelefone_Celular = new JPanel();
		panelDadosCliente2.add(panelTelefone_Celular);
		panelTelefone_Celular.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelTelefone = new JPanel();
		panelTelefone_Celular.add(panelTelefone);
		panelTelefone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTelefone.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTelefone = new JLabel("Telefone");
		labelTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelTelefone.add(labelTelefone);
		
		textTelefone = new JFormattedTextField(numeroTelefoneMascara);
		textTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelTelefone.add(textTelefone);
		
		JPanel panelCelular = new JPanel();
		panelCelular.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTelefone_Celular.add(panelCelular);
		panelCelular.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCelular = new JLabel("Celular");
		labelCelular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCelular.add(labelCelular);
		
		textCelular = new JFormattedTextField(numeroCelularMascara);
		textCelular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCelular.add(textCelular);
		
		JPanel panelEstado_CEP = new JPanel();
		panelDadosCliente2.add(panelEstado_CEP);
		panelEstado_CEP.setLayout(new GridLayout(0, 2, 5, 0));
		
		JPanel panelEstado = new JPanel();
		panelEstado_CEP.add(panelEstado);
		panelEstado.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEstado.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEstado = new JLabel("Estado");
		labelEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelEstado.add(labelEstado);
		
		comboBoxEstado = new JComboBox<String>();
		comboBoxEstado.setMaximumRowCount(29);
		comboBoxEstado.addItem("Selecione um estado");
		comboBoxEstado.addItem("Acre (AC)");
		comboBoxEstado.addItem("Alagoas (AL)");
		comboBoxEstado.addItem("Amapá (AP)");
		comboBoxEstado.addItem("Amazonas (AM)");
		comboBoxEstado.addItem("Bahia (BA)");
		comboBoxEstado.addItem("Ceará (CE)");
		comboBoxEstado.addItem("Distrito Federal (DF)");
		comboBoxEstado.addItem("Espírito Santo (ES)");
		comboBoxEstado.addItem("Goiás (GO)");
		comboBoxEstado.addItem("Maranhão (MA)");
		comboBoxEstado.addItem("Mato Grosso (MT)");
		comboBoxEstado.addItem("Mato Grosso do Sul (MS)");
		comboBoxEstado.addItem("Minas Gerais (MG)");
		comboBoxEstado.addItem("Pará (PA)");
		comboBoxEstado.addItem("Paraíba (PB)");
		comboBoxEstado.addItem("Paraná (PR)");
		comboBoxEstado.addItem("Pernambuco (PE)");
		comboBoxEstado.addItem("Piauí (PI)");
		comboBoxEstado.addItem("Rio de Janeiro (RJ)");
		comboBoxEstado.addItem("Rio Grande do Norte (RN)");
		comboBoxEstado.addItem("Rio Grande do Sul (RS)");
		comboBoxEstado.addItem("Rondônia (RO)");
		comboBoxEstado.addItem("Roraima (RR)");
		comboBoxEstado.addItem("Santa Catarina (SC)");
		comboBoxEstado.addItem("São Paulo (SP)");
		comboBoxEstado.addItem("Sergipe (SE)");
		comboBoxEstado.addItem("Tocantins (TO)");
		comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEstado.add(comboBoxEstado);
		
		JPanel panelCEP = new JPanel();
		panelEstado_CEP.add(panelCEP);
		panelCEP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCEP.setLayout(new GridLayout(0, 1, 0, 0));
	
		JLabel labelCEP = new JLabel("CEP");
		labelCEP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCEP.add(labelCEP);
		
		textCEP = new JFormattedTextField(numeroCEPMascara);
		textCEP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCEP.add(textCEP);
		
		JPanel panelCidade = new JPanel();
		panelDadosCliente2.add(panelCidade);
		panelCidade.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCidade.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelCidade = new JLabel("Cidade");
		labelCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCidade.add(labelCidade);
		
		textCidade = new JTextField();
		textCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCidade.add(textCidade);
		
		JPanel panelEndereco = new JPanel();
		panelDadosCliente2.add(panelEndereco);
		panelEndereco.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEndereco.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelEndereco = new JLabel("Endere\u00E7o");
		labelEndereco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelEndereco.add(labelEndereco);
		
		textEndereco = new JTextField();
		textEndereco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelEndereco.add(textEndereco);
		
		JPanel panelNumero_Bairro = new JPanel();
		panelDadosCliente2.add(panelNumero_Bairro);
		panelNumero_Bairro.setLayout(new BorderLayout(5, 0));
		
		JPanel panelNumero = new JPanel();
		panelNumero.setPreferredSize(new Dimension(100, 10));
		panelNumero_Bairro.add(panelNumero, BorderLayout.WEST);
		panelNumero.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNumero.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelTaxaTransporte = new JLabel("Numero");
		labelTaxaTransporte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelNumero.add(labelTaxaTransporte);
		
		textNumero = new JTextField();
		panelNumero.add(textNumero);
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
		JPanel panelBairro = new JPanel();
		panelNumero_Bairro.add(panelBairro);
		panelBairro.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBairro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelBairro = new JLabel("Bairro");
		labelBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBairro.add(labelBairro);
		
		textBairro = new JTextField();
		textBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBairro.add(textBairro);
		
		JPanel panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separator = new JSeparator();
		panelBotoes.add(separator, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		panelBotoes.add(panelBotoes2, BorderLayout.CENTER);
		
		salvar = new JButton("Salvar");
		salvar.setToolTipText("Salva os dados do cliente");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textCEP.getText().replace("-","").trim().isEmpty() ||
					textCidade.getText().isEmpty() || textCidade.getText().length() <= 0 ||
					textEndereco.getText().isEmpty() || textEndereco.getText().length() <= 0 ||
					textBairro.getText().isEmpty() || textBairro.getText().length() <= 0 ||
					textNumero.getText().isEmpty() || textNumero.getText().length() <= 0) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					String telefoneValor = textTelefone.getText();
					if (telefoneValor == null) {
						String telefoneValor1 = null;
						setTelefoneCliente(telefoneValor1);
					}
					else {
						setTelefoneCliente(telefoneValor);
					}
					
					String celularValor = textCelular.getText();
					if (celularValor == null) {
						String celularValor1 = null;
						setCelularCliente(celularValor1);
					}
					else {
						setCelularCliente(celularValor);
					}
					
					setBairroCliente(textBairro.getText());
					setNumeroCliente(textNumero.getText());
					setEnderecoCliente(textEndereco.getText());
					setCidadeCliente(textCidade.getText());
					setCEPCliente(textCEP.getText());
					setEstadoCliente((String)comboBoxEstado.getSelectedItem());
					setVisible(false);
				}
			}
		});
		salvar.setPreferredSize(new Dimension(100, 23));
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(salvar);
		
		limpar = new JButton("Limpar");
		limpar.setToolTipText("LImpa os campos");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemConteudo = "Deseja limpar os campos ?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo avisoLimparCampos = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemConteudo);
				avisoLimparCampos.setVisible(true);
				String avisoLimparCamposTexto = avisoLimparCampos.getResposta();
				if (avisoLimparCamposTexto != null) {
					if (avisoLimparCamposTexto.equals("Sim")) {
						textTelefone.setText("");
						textCelular.setText("");
						comboBoxEstado.setSelectedItem("Selecione um estado");
						textCEP.setText("");
						textCidade.setText("");
						textBairro.setText("");
						textNumero.setText("");
						textEndereco.setText("");
					}
				}
			}
		});
		limpar.setPreferredSize(new Dimension(100, 23));
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(limpar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setToolTipText("Fecha a janela");
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cancelar.setPreferredSize(new Dimension(100, 23));
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textTelefone.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
					textCelular.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
					comboBoxEstado.getSelectedItem() != "Selecione um estado" ||
					textCEP.getText().replace("-","").trim().length() != 0 || textCidade.getText().length() != 0 ||
					textEndereco.getText().length() != 0 || textBairro.getText().length() != 0 || textNumero.getText().length() != 0) {
						String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
						aviso.setVisible(true);
						String resposta = aviso.getResposta();
						if (resposta != null) {
							if (resposta.equals("Sim")) {
								String telefoneTexto = null;
								String celularTexto = null;
								String bairroTexto = null;
								String numeroTexto = null;
								String enderecoTexto = null;
								String cidadeTexto = null;
								String cepTexto = null;
								String estadoTexto = null;
								
								setTelefoneCliente(telefoneTexto);
								setCelularCliente(celularTexto);
								setBairroCliente(bairroTexto);
								setNumeroCliente(numeroTexto);
								setEnderecoCliente(enderecoTexto);
								setCidadeCliente(cidadeTexto);
								setCEPCliente(cepTexto);
								setEstadoCliente(estadoTexto);
								
								setVisible(false);
								dispose();
							}
						}
				}
				else {
					String telefoneTexto = null;
					String celularTexto = null;
					String bairroTexto = null;
					String numeroTexto = null;
					String enderecoTexto = null;
					String cidadeTexto = null;
					String cepTexto = null;
					String estadoTexto = null;
					
					setTelefoneCliente(telefoneTexto);
					setCelularCliente(celularTexto);
					setBairroCliente(bairroTexto);
					setNumeroCliente(numeroTexto);
					setEnderecoCliente(enderecoTexto);
					setCidadeCliente(cidadeTexto);
					setCEPCliente(cepTexto);
					setEstadoCliente(estadoTexto);
					
					setVisible(false);
					dispose();
				}
			}
		});
		panelBotoes2.add(cancelar);
		
		/*Ação do botao sair da janela*/
		addWindowListener(
            new WindowAdapter() 
            {
                public void windowClosing(WindowEvent we) {
                	if (textTelefone.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
						textCelular.getText().replaceAll("\\(", "").replaceAll("\\)","").replace("-","").trim().length() != 0 ||
						comboBoxEstado.getSelectedItem() != "Selecione um estado" ||
						textCEP.getText().replace("-","").trim().length() != 0 || textCidade.getText().length() != 0 ||
						textEndereco.getText().length() != 0 || textBairro.getText().length() != 0 || textNumero.getText().length() != 0) {
	                		String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
							aviso.setVisible(true);
							String resposta = aviso.getResposta();
							if (resposta != null) {
								if (resposta.equals("Sim")) {
									String telefoneTexto = null;
									String celularTexto = null;
									String bairroTexto = null;
									String numeroTexto = null;
									String enderecoTexto = null;
									String cidadeTexto = null;
									String cepTexto = null;
									String estadoTexto = null;
									
									setTelefoneCliente(telefoneTexto);
									setCelularCliente(celularTexto);
									setBairroCliente(bairroTexto);
									setNumeroCliente(numeroTexto);
									setEnderecoCliente(enderecoTexto);
									setCidadeCliente(cidadeTexto);
									setCEPCliente(cepTexto);
									setEstadoCliente(estadoTexto);
									
									setVisible(false);
									dispose();
								}
							}
					}
					else {
						String telefoneTexto = null;
						String celularTexto = null;
						String bairroTexto = null;
						String numeroTexto = null;
						String enderecoTexto = null;
						String cidadeTexto = null;
						String cepTexto = null;
						String estadoTexto = null;
						
						setTelefoneCliente(telefoneTexto);
						setCelularCliente(celularTexto);
						setBairroCliente(bairroTexto);
						setNumeroCliente(numeroTexto);
						setEnderecoCliente(enderecoTexto);
						setCidadeCliente(cidadeTexto);
						setCEPCliente(cepTexto);
						setEstadoCliente(estadoTexto);
						
						setVisible(false);
						dispose();
					}
                }
            }
	    );
	}
	
	/*Metodos get e set*/
	private String telefoneCliente, celularCliente, estadoCliente, cepCliente, cidadeCliente, enderecoCliente, numeroCliente, bairroCliente;
	/*get e set Telefone do cliente*/
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
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
	
	/*get e set Cidade do cliente*/
	public String getCidadeCliente() {
		return cidadeCliente;
	}
	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}
	
	/*get e set Endereço da casa do cliente*/
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
	
	/*get e set Bairro da casa cliente*/
	public String getBairroCliente() {
		return bairroCliente;
	}
	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}
}