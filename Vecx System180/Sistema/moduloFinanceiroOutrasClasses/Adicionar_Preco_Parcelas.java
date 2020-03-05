package moduloFinanceiroOutrasClasses;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
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
import aInterfaceSistema.ValidaNumeroDouble;
import aInterfaceSistema.ValidaNumeroInteiro;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;

public class Adicionar_Preco_Parcelas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelParcelamento = new JPanel();
	private JTextField textValorParcela, textValorJuros;
	private JButton confirmar, limpar, cancelar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Adicionar_Preco_Parcelas dialog = new Adicionar_Preco_Parcelas();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Adicionar_Preco_Parcelas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Adicionar_Preco_Parcelas.class.getResource("/cImagens/Logo Janela.PNG")));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Vecx System");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 340, 170);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
		FlowLayout fl_panelTitulo = (FlowLayout) panelTitulo.getLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		
		JLabel Icone = new JLabel("");
		Icone.setIcon(new ImageIcon(Adicionar_Preco_Parcelas.class.getResource("/cImagens/Parcelamento.PNG")));
		Icone.setPreferredSize(new Dimension(30, 30));
		Icone.setHorizontalAlignment(SwingConstants.CENTER);
		Icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.add(Icone);
		
		JLabel labelParcelamento = new JLabel("Parcelamento");
		panelTitulo.add(labelParcelamento);
		labelParcelamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		panelParcelamento.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelParcelamento, BorderLayout.CENTER);
		panelParcelamento.setLayout(new GridLayout(0, 1, 0, 5));
	
		JPanel panelValorJuros = new JPanel();
		panelParcelamento.add(panelValorJuros);
		panelValorJuros.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel labelValorJuros = new JLabel("Valor do juros (%)");
		labelValorJuros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelValorJuros.add(labelValorJuros);
		
		textValorJuros = new JTextField();
		textValorJuros.setHorizontalAlignment(SwingConstants.RIGHT);
		textValorJuros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textValorJuros.setColumns(10);
		panelValorJuros.add(textValorJuros);
		PlainDocument documentValorJuros = (PlainDocument) textValorJuros.getDocument();
		documentValorJuros.setDocumentFilter(new ValidaNumeroDouble());
		
		JPanel panelValorParcela = new JPanel();
		panelParcelamento.add(panelValorParcela);
		panelValorParcela.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel labelValorParcela = new JLabel("Numero de parcelas");
		labelValorParcela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelValorParcela.add(labelValorParcela);
		
		textValorParcela = new JTextField();
		textValorParcela.setHorizontalAlignment(SwingConstants.RIGHT);
		textValorParcela.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelValorParcela.add(textValorParcela);
		textValorParcela.setColumns(10);
		textValorParcela.setDocument(new ValidaNumeroInteiro());
		
		JPanel panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		panelBotoes.add(panelBotoes2);
		
		confirmar = new JButton("Confirmar");
		confirmar.setToolTipText("Confirma os dados do parcelamento");
		confirmar.setPreferredSize(new Dimension(100, 23));
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textValorJuros.getText().isEmpty() || textValorJuros.getText().length() <= 0 ||
					textValorParcela.getText().isEmpty() || textValorParcela.getText().length() <= 0) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					try {
						double jurosValor = Double.parseDouble(textValorJuros.getText());
						setJurosValorVenda(jurosValor);
						
						int parcelasValor = Integer.parseInt(textValorParcela.getText());
						setParcelaVenda(parcelasValor);
						
						setVisible(false);
					}
					catch(NumberFormatException e2){
						String menssagemConteudo = "Campo do valor do juros aceita somente numeros e um ponto(valores quebrados)";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
				}
			}
		});
		panelBotoes2.add(confirmar);

		limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menssagemConteudo = "Deseja limpar os campos ?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo avisoLimparCampos = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemConteudo);
				avisoLimparCampos.setVisible(true);
				String avisoLimparCamposTexto = avisoLimparCampos.getResposta();
				if (avisoLimparCamposTexto != null) {
					if (avisoLimparCamposTexto.equals("Sim")) {
						textValorJuros.setText("");
						textValorParcela.setText("");
					}
				}
			}
		});
		limpar.setToolTipText("Limpa os campos");
		limpar.setPreferredSize(new Dimension(100, 23));
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(limpar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setToolTipText("Fecha a janela");
		cancelar.setPreferredSize(new Dimension(100, 23));
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textValorJuros.getText().length() != 0 || textValorParcela.getText().length() != 0) {
						String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
						aviso.setVisible(true);
						String resposta = aviso.getResposta();
						if (resposta != null) {
							if (resposta.equals("Sim")) {
								double jurosValorTexto = 0;
								setJurosValorVenda(jurosValorTexto);
								
								int parcelasValorTexto = 0;
								setParcelaVenda(parcelasValorTexto);
								
								setVisible(false);
					            dispose();
							}
						}
				}
				else {
					double jurosValorTexto = 0;
					setJurosValorVenda(jurosValorTexto);
					
					int parcelasValorTexto = 0;
					setParcelaVenda(parcelasValorTexto);
					
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
                	if (textValorJuros.getText().length() != 0 || textValorParcela.getText().length() != 0) {
	                		String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
							aviso.setVisible(true);
							String resposta = aviso.getResposta();
							if (resposta != null) {
								if (resposta.equals("Sim")) {
									double jurosValorTexto = 0;
									setJurosValorVenda(jurosValorTexto);
									
									int parcelasValorTexto = 0;
									setParcelaVenda(parcelasValorTexto);
									
									setVisible(false);
						            dispose();
								}
							}
					}
					else {
						double jurosValorTexto = 0;
						setJurosValorVenda(jurosValorTexto);
						
						int parcelasValorTexto = 0;
						setParcelaVenda(parcelasValorTexto);
						
						setVisible(false);
						dispose();
					}
                }
            }
	    );
	}
	
	/*Metodos get e set*/
	private double jurosValorVenda;
	private int parcelaVenda;
	/*get e set Quantidade de parcelas*/
	public int getParcelaVenda() {
		return parcelaVenda;
	}
	public void setParcelaVenda(int parcelaVenda) {
		this.parcelaVenda = parcelaVenda;
	}
	
	/*get e set Valor do porcentagem dos juros*/
	public double getJurosValorVenda() {
		return jurosValorVenda;
	}
	public void setJurosValorVenda(double jurosValorVenda) {
		this.jurosValorVenda = jurosValorVenda;
	}
}