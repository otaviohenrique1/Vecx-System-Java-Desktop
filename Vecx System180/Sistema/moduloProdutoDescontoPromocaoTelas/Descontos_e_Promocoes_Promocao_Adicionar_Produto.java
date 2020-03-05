package moduloProdutoDescontoPromocaoTelas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.text.PlainDocument;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.util.List;
import aInterfaceSistema.ValidaNumeroDouble;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;
import moduloProdutoBD.Dao_consulta_dados_produto;
import moduloProdutoBD.Produto;
import moduloProdutoTelas.Cadastro_de_Produto;

public class Descontos_e_Promocoes_Promocao_Adicionar_Produto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelProduto = new JPanel();
	private JTextField textNomeProduto, textPorcentagemDesconto, textCodigoBarras, textCodigoProduto;
	private JLabel estoqueQuantidade, precoUnitario, estoqueQuantidadeUnidade;
	private JButton confirmar, limpar, cancelar;
	double quantidadeValor, precoUnitarioValor, precoQuantidadeCompra;
	String precoQuantidadeTexto;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Descontos_e_Promocoes_Promocao_Adicionar_Produto dialog = new Descontos_e_Promocoes_Promocao_Adicionar_Produto();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Descontos_e_Promocoes_Promocao_Adicionar_Produto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Descontos_e_Promocoes_Promocao_Adicionar_Produto.class.getResource("/cImagens/Logo Janela.PNG")));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Vecx System");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
		FlowLayout fl_panelTitulo = (FlowLayout) panelTitulo.getLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		
		JLabel Icone = new JLabel("");
		Icone.setIcon(new ImageIcon(Descontos_e_Promocoes_Promocao_Adicionar_Produto.class.getResource("/cImagens/Acrescentar produto.png")));
		Icone.setPreferredSize(new Dimension(30, 30));
		Icone.setHorizontalAlignment(SwingConstants.CENTER);
		Icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.add(Icone);
		
		JLabel labelAdicionarProduto = new JLabel("Adicionar produto");
		panelTitulo.add(labelAdicionarProduto);
		labelAdicionarProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		panelProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelProduto, BorderLayout.CENTER);
		panelProduto.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelCodigoProduto = new JPanel();
		panelProduto.add(panelCodigoProduto);
		panelCodigoProduto.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel labelCodigoProduto = new JLabel("Codigo do produto");
		labelCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCodigoProduto.add(labelCodigoProduto);
		
		textCodigoProduto = new JTextField();
		textCodigoProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evtkey) {
				int botaoteclado = evtkey.getKeyCode();
				if (botaoteclado == KeyEvent.VK_ENTER) {
					if (textCodigoProduto.getText().isEmpty() || textCodigoProduto.getText().length() <= 0) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
					else {
						Dao_consulta_dados_produto consultaProduto = new Dao_consulta_dados_produto();
						String consultaCodigoProduto = textCodigoProduto.getText();
						String nomeProduto = null;
						String quantidadeProduto = null;
						double quantidadeValor = 0;
						String quantidadeUnidade = null;
						double precoaVistaValor = 0;
						String precoaVistaProduto = null;
						List<Produto> Consulta = consultaProduto.Consulta_Dados_Produto_Pesquisa_Codigo_Produto(consultaCodigoProduto);
						for (Produto leitura : Consulta) {
							nomeProduto = leitura.getNome();
							
							quantidadeValor = leitura.getQuantidade();
							quantidadeProduto = "" + quantidadeValor;
							
							quantidadeUnidade = leitura.getQuantidadeUnidade();
							
							precoaVistaValor = leitura.getPrecoaVista();
							precoaVistaProduto = "" + precoaVistaValor;
						}
						
						if (nomeProduto == null || quantidadeUnidade == null || precoaVistaProduto == null || quantidadeProduto == null) {
								String menssagemTitulo = "Produto não cadastrado";
								String menssagemConteudo = "Deseja criar um cadastro ?";
								Tela_que_Exibe_Menssagem_Sim_Nao telaCadastroFornecedor = new Tela_que_Exibe_Menssagem_Sim_Nao(menssagemTitulo, menssagemConteudo);
								telaCadastroFornecedor.setVisible(true);
								String respostaTexto = telaCadastroFornecedor.getResposta();
								if (respostaTexto != null) {
									if (respostaTexto.equals("Sim")) {
										Cadastro_de_Produto cadastroProduto = new Cadastro_de_Produto();
										cadastroProduto.setVisible(true);
									}
								}
						}
						else {
							textNomeProduto.setText(nomeProduto);
							estoqueQuantidade.setText(quantidadeProduto);
							estoqueQuantidadeUnidade.setText(quantidadeUnidade);
							precoUnitario.setText(precoaVistaProduto);
						}
					}
				}
			}
		});
		textCodigoProduto.setColumns(10);
		panelCodigoProduto.add(textCodigoProduto);
		
		JPanel panelNomeProduto = new JPanel();
		panelProduto.add(panelNomeProduto);
		panelNomeProduto.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel labelNomeProduto = new JLabel("Nome do produto");
		labelNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNomeProduto.add(labelNomeProduto);
		
		textNomeProduto = new JTextField();
		textNomeProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evtkey) {
				int botaoteclado = evtkey.getKeyCode();
				if (botaoteclado == KeyEvent.VK_ENTER) {
					if (textNomeProduto.getText().isEmpty() || textNomeProduto.getText().length() <= 0) {
							String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
							menssagemAvisoCampos.setVisible(true);
					}
					else {
						Dao_consulta_dados_produto consultaProduto = new Dao_consulta_dados_produto();
						String consultaNomeProduto = textNomeProduto.getText();
						String codigoProduto = null;
						String quantidadeProduto = null;
						double quantidadeValor = 0;
						String quantidadeUnidade = null;
						double precoaVistaValor = 0;
						String precoaVistaProduto = null;
						List<Produto> Consulta = consultaProduto.Consulta_Dados_Produto_Pesquisa_Nome_Produto(consultaNomeProduto);
						for (Produto leitura : Consulta) {
							codigoProduto = leitura.getCodigoProduto();
							
							quantidadeValor = leitura.getQuantidade();
							quantidadeProduto = "" + quantidadeValor;
							
							quantidadeUnidade = leitura.getQuantidadeUnidade();
							
							precoaVistaValor = leitura.getPrecoaVista();
							precoaVistaProduto = "" + precoaVistaValor;
						}
						if (codigoProduto == null || quantidadeUnidade == null || precoaVistaProduto == null || quantidadeProduto == null) {
								String menssagemTitulo = "Produto não cadastrado";
								String menssagemConteudo = "Deseja criar um cadastro ?";
								Tela_que_Exibe_Menssagem_Sim_Nao telaCadastroFornecedor = new Tela_que_Exibe_Menssagem_Sim_Nao(menssagemTitulo, menssagemConteudo);
								telaCadastroFornecedor.setVisible(true);
								String respostaTexto = telaCadastroFornecedor.getResposta();
								if (respostaTexto != null) {
									if (respostaTexto.equals("Sim")) {
										Cadastro_de_Produto cadastroProduto = new Cadastro_de_Produto();
										cadastroProduto.setVisible(true);
									}
								}
						}
						else {
							textCodigoProduto.setText(codigoProduto);
							estoqueQuantidade.setText(quantidadeProduto);
							estoqueQuantidadeUnidade.setText(quantidadeUnidade);
							precoUnitario.setText(precoaVistaProduto);
						}
					}
				}
			}
		});
		panelNomeProduto.add(textNomeProduto);
		textNomeProduto.setColumns(10);
		
		JPanel panelCodigoBarras = new JPanel();
		panelProduto.add(panelCodigoBarras);
		panelCodigoBarras.setLayout(new GridLayout(0, 2, 5, 0));
			
		JLabel labelCodigoBarras = new JLabel("Codigo de barras");
		labelCodigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCodigoBarras.add(labelCodigoBarras);
	
	
		textCodigoBarras = new JTextField();
		textCodigoBarras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evtkey) {
				int botaoteclado = evtkey.getKeyCode();
				if (botaoteclado == KeyEvent.VK_ENTER) {
					if (textCodigoBarras.getText().isEmpty() || textCodigoBarras.getText().length() <= 0) {
							String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
							menssagemAvisoCampos.setVisible(true);
					}
					else {
						Dao_consulta_dados_produto consultaProduto = new Dao_consulta_dados_produto();
						String consultaCodigoBarras = textCodigoBarras.getText();
						String codigoProduto = null;
						String nomeProduto = null;
						String quantidadeProduto = null;
						double quantidadeValor = 0;
						String quantidadeUnidade = null;
						double precoaVistaValor = 0;
						String precoaVistaProduto = null;
						List<Produto> Consulta = consultaProduto.Consulta_Dados_Produto_Pesquisa_Codigo_Barras(consultaCodigoBarras);
						for (Produto leitura : Consulta) {
							codigoProduto = leitura.getCodigoProduto();
							
							nomeProduto = leitura.getNome();
							
							quantidadeValor = leitura.getQuantidade();
							
							quantidadeUnidade = leitura.getQuantidadeUnidade();
							quantidadeProduto = "" + quantidadeValor;
							
							precoaVistaValor = leitura.getPrecoaVista();
							precoaVistaProduto = "" + precoaVistaValor;
						}
						if (nomeProduto == null || codigoProduto == null || quantidadeUnidade == null || precoaVistaProduto == null || quantidadeProduto == null) {
								String menssagemTitulo = "Produto não cadastrado";
								String menssagemConteudo = "Deseja criar um cadastro ?";
								Tela_que_Exibe_Menssagem_Sim_Nao telaCadastroFornecedor = new Tela_que_Exibe_Menssagem_Sim_Nao(menssagemTitulo, menssagemConteudo);
								telaCadastroFornecedor.setVisible(true);
								String respostaTexto = telaCadastroFornecedor.getResposta();
								if (respostaTexto != null) {
									if (respostaTexto.equals("Sim")) {
										Cadastro_de_Produto cadastroProduto = new Cadastro_de_Produto();
										cadastroProduto.setVisible(true);
									}
								}
						}
						else {
							textCodigoProduto.setText(codigoProduto);
							textNomeProduto.setText(nomeProduto);
							estoqueQuantidade.setText(quantidadeProduto);
							estoqueQuantidadeUnidade.setText(quantidadeUnidade);
							precoUnitario.setText(precoaVistaProduto);
						}
						
					}
				}
			}
		});
		textCodigoBarras.setColumns(10);
		panelCodigoBarras.add(textCodigoBarras);
		
		JPanel panelPorcentagemDesconto = new JPanel();
		panelProduto.add(panelPorcentagemDesconto);
		panelPorcentagemDesconto.setLayout(new GridLayout(0, 2, 5, 0));
	
		JLabel labelPorcentagemDesconto = new JLabel("Valor do desconto (%)");
		labelPorcentagemDesconto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelPorcentagemDesconto.add(labelPorcentagemDesconto);
		
		textPorcentagemDesconto = new JTextField();
		panelPorcentagemDesconto.add(textPorcentagemDesconto);
		textPorcentagemDesconto.setHorizontalAlignment(SwingConstants.RIGHT);
		textPorcentagemDesconto.setColumns(10);
		PlainDocument documentPorcentagemDesconto = (PlainDocument) textPorcentagemDesconto.getDocument();
		documentPorcentagemDesconto.setDocumentFilter(new ValidaNumeroDouble());
		
		JPanel panelPrecoUnitario = new JPanel();
		panelProduto.add(panelPrecoUnitario);
		panelPrecoUnitario.setLayout(new GridLayout(0, 2, 5, 0));
			
		JLabel labelPrecoUnitario = new JLabel("Pre\u00E7o unitario (R$)");
		labelPrecoUnitario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelPrecoUnitario.add(labelPrecoUnitario);
		
		precoUnitario = new JLabel();
		precoUnitario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		precoUnitario.setText("00.00");
		precoUnitario.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPrecoUnitario.add(precoUnitario);
		
		JPanel panelEstoqueQuantidade = new JPanel();
		panelProduto.add(panelEstoqueQuantidade);
		panelEstoqueQuantidade.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelEstoqueQuantidade = new JLabel("Quantidade no estoque");
		labelEstoqueQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEstoqueQuantidade.add(labelEstoqueQuantidade);
		
		JPanel panelEstoqueQuantidade2 = new JPanel();
		panelEstoqueQuantidade.add(panelEstoqueQuantidade2);
		panelEstoqueQuantidade2.setLayout(new GridLayout(0, 2, 5, 0));
		
		estoqueQuantidade = new JLabel("0");
		panelEstoqueQuantidade2.add(estoqueQuantidade);
		estoqueQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		estoqueQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		estoqueQuantidadeUnidade = new JLabel("");
		estoqueQuantidadeUnidade.setHorizontalAlignment(SwingConstants.LEFT);
		estoqueQuantidadeUnidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelEstoqueQuantidade2.add(estoqueQuantidadeUnidade);
	
		JPanel panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorDesconto = new JSeparator();
		panelBotoes.add(separatorDesconto, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		panelBotoes.add(panelBotoes2);
				
		confirmar = new JButton("Confirmar");
		confirmar.setToolTipText("Confirma os dados do produto e salva a janela");
		confirmar.setPreferredSize(new Dimension(100, 23));
		confirmar.setMinimumSize(new Dimension(75, 23));
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNomeProduto.getText().isEmpty() || textNomeProduto.getText().length() <=0 ||
					textCodigoProduto.getText().isEmpty() || textCodigoProduto.getText().length() <=0 ||
					textPorcentagemDesconto.getText().isEmpty() || textPorcentagemDesconto.getText().length() <=0) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					try {
						setNomeProduto(textNomeProduto.getText());
						setCodigoProduto(textCodigoProduto.getText());
						setPrecoProduto(Double.parseDouble(precoUnitario.getText()));
						setDescontoProduto(Double.parseDouble(textPorcentagemDesconto.getText()));
						setVisible(false);
					}
					catch(NumberFormatException e2){
						String menssagemConteudo = "Campo da porcentagem do desconto aceita somente numeros e um ponto(valores quebrados)";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
				}
			}
		});
		panelBotoes2.add(confirmar);
		
		limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemConteudo = "Deseja limpar os campos ?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo avisoLimparCampos = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemConteudo);
				avisoLimparCampos.setVisible(true);
				String avisoLimparCamposTexto = avisoLimparCampos.getResposta();
				if (avisoLimparCamposTexto != null) {
					if (avisoLimparCamposTexto.equals("Sim")) {
						textNomeProduto.setText("");
						textCodigoProduto.setText("");
						textCodigoBarras.setText("");
						textPorcentagemDesconto.setText("");
						precoUnitario.setText("00.00");
						estoqueQuantidade.setText("0");
						estoqueQuantidadeUnidade.setText("");
					}
				}
			}
		});
		limpar.setPreferredSize(new Dimension(100, 23));
		limpar.setMinimumSize(new Dimension(75, 23));
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(limpar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setToolTipText("Fecha a janela");
		cancelar.setPreferredSize(new Dimension(100, 23));
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNomeProduto.getText().length() !=0 || textCodigoProduto.getText().length() !=0 ||
					textCodigoBarras.getText().length() !=0 || textPorcentagemDesconto.getText().length() !=0) {
						String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
						aviso.setVisible(true);
						String resposta = aviso.getResposta();
						if (resposta != null) {
							if (resposta.equals("Sim")) {
								String nomeProduto1 = null;
								String codigoProduto1 = null;
								double precoProduto1 = 0;
								double porcentagemDesconto1 = 0;
								setNomeProduto(nomeProduto1);
								setCodigoProduto(codigoProduto1);
								setPrecoProduto(precoProduto1);
								setDescontoProduto(porcentagemDesconto1);
								setVisible(false);
							}
						}
				}
				else {
					String nomeProduto1 = null;
					String codigoProduto1 = null;
					double precoProduto1 = 0;
					double porcentagemDesconto1 = 0;
					setNomeProduto(nomeProduto1);
					setCodigoProduto(codigoProduto1);
					setPrecoProduto(precoProduto1);
					setDescontoProduto(porcentagemDesconto1);
					setVisible(false);
				}
			}
		});
		panelBotoes2.add(cancelar);
		
		/*Ação do botao sair da janela*/
		addWindowListener(
            new WindowAdapter() 
            {
                public void windowClosing(WindowEvent we) {
                	if (textNomeProduto.getText().length() !=0 || textCodigoProduto.getText().length() !=0 ||
						textCodigoBarras.getText().length() !=0 || textPorcentagemDesconto.getText().length() !=0) {
	                		String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
							aviso.setVisible(true);
							String resposta = aviso.getResposta();
							if (resposta != null) {
								if (resposta.equals("Sim")) {
									String nomeProduto1 = null;
									String codigoProduto1 = null;
									double precoProduto1 = 0;
									double porcentagemDesconto1 = 0;
									setNomeProduto(nomeProduto1);
									setCodigoProduto(codigoProduto1);
									setPrecoProduto(precoProduto1);
									setDescontoProduto(porcentagemDesconto1);
									setVisible(false);
								}
							}
					}
					else {
						String nomeProduto1 = null;
						String codigoProduto1 = null;
						double precoProduto1 = 0;
						double porcentagemDesconto1 = 0;
						setNomeProduto(nomeProduto1);
						setCodigoProduto(codigoProduto1);
						setPrecoProduto(precoProduto1);
						setDescontoProduto(porcentagemDesconto1);
						setVisible(false);
					}
                }
            }
	    );
	}

	/*Metodos get e set*/
	private String nomeProduto, codigoProduto;
	private double descontoProduto, precoProduto;
	/*get e set Nome do produto*/
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	/*get e set Codigo do produto*/
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	/*get e set Preço do produto*/
	public double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}
	
	/*get e set Valor do desconto do produto*/
	public double getDescontoProduto() {
		return descontoProduto;
	}
	public void setDescontoProduto(double descontoProduto) {
		this.descontoProduto = descontoProduto;
	}
}