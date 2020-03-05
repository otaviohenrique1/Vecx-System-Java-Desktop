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
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;

public class Adicionar_Desconto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelDesconto = new JPanel();
	private JTextField textValorDesconto;
	private JButton confirmar, limpar, cancelar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Adicionar_Desconto dialog = new Adicionar_Desconto();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Adicionar_Desconto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Adicionar_Desconto.class.getResource("/cImagens/Logo Janela.PNG")));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Vecx System");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 340, 140);
		getContentPane().setLayout(new BorderLayout());
	
		JPanel panelTitulo = new JPanel();
		FlowLayout fl_panelTitulo = (FlowLayout) panelTitulo.getLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		
		JLabel Icone = new JLabel("");
		Icone.setIcon(new ImageIcon(Adicionar_Desconto.class.getResource("/cImagens/Adicionar desconto.PNG")));
		Icone.setPreferredSize(new Dimension(30, 30));
		Icone.setHorizontalAlignment(SwingConstants.CENTER);
		Icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.add(Icone);
		
		JLabel labelParcelas = new JLabel("Desconto");
		panelTitulo.add(labelParcelas);
		labelParcelas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		panelDesconto.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelDesconto, BorderLayout.CENTER);
		panelDesconto.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelValorDesconto = new JPanel();
		panelDesconto.add(panelValorDesconto);
		panelValorDesconto.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel labelValorDesconto = new JLabel("Valor do desconto (%)");
		labelValorDesconto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelValorDesconto.add(labelValorDesconto);
		
		textValorDesconto = new JTextField();
		textValorDesconto.setHorizontalAlignment(SwingConstants.RIGHT);
		textValorDesconto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelValorDesconto.add(textValorDesconto);
		textValorDesconto.setColumns(10);
		PlainDocument documentValorDesconto = (PlainDocument) textValorDesconto.getDocument();
		documentValorDesconto.setDocumentFilter(new ValidaNumeroDouble());
		
		JPanel panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
	
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		panelBotoes.add(panelBotoes2);
		
		confirmar = new JButton("Confirmar");
		confirmar.setToolTipText("Confirma os dados do desconto");
		confirmar.setPreferredSize(new Dimension(100, 23));
		confirmar.setMinimumSize(new Dimension(75, 23));
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textValorDesconto.getText().isEmpty() || textValorDesconto.getText().length() <= 0) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					try {
						double descontoValor = Double.parseDouble(textValorDesconto.getText());
						setValorDesconto(descontoValor);
						
						setVisible(false);
					}
					catch(NumberFormatException e2){
						String menssagemConteudo = "Campos numericos aceitam somente numeros e pontos(valores quebrados)";
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
						textValorDesconto.setText("");
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
				if (textValorDesconto.getText().length() != 0) {
						String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
						aviso.setVisible(true);
						String resposta = aviso.getResposta();
						if (resposta != null) {
							if (resposta.equals("Sim")) {
								double descontoValorTexto = 0;
								setValorDesconto(descontoValorTexto);
								setVisible(false); 
					            dispose();
							}
						}
				}
				else {
					double descontoValorTexto = 0;
					setValorDesconto(descontoValorTexto);
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
                	if (textValorDesconto.getText().length() != 0) {
	                		String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
							aviso.setVisible(true);
							String resposta = aviso.getResposta();
							if (resposta != null) {
								if (resposta.equals("Sim")) {
									double descontoValorTexto = 0;
									setValorDesconto(descontoValorTexto);
									setVisible(false); 
						            dispose();
								}
							}
					}
					else {
						double descontoValorTexto = 0;
						setValorDesconto(descontoValorTexto);
						setVisible(false);
						dispose();
					}
                }
            }
	    );
	}
	
	/*Metodos get e set*/
	private double valorDesconto;
	/*get e set Valor do porcentagem do desconto*/
	public double getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
}