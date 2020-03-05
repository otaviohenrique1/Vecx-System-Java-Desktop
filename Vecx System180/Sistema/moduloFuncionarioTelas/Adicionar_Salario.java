package moduloFuncionarioTelas;

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

public class Adicionar_Salario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelValorSalario = new JPanel();
	private JTextField textValorSalario;
	private JButton confirmar, limpar, cancelar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Adicionar_Salario dialog = new Adicionar_Salario();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Adicionar_Salario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Adicionar_Salario.class.getResource("/cImagens/Logo Janela.PNG")));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Vecx System");
		setResizable(false);
		setBounds(100, 100, 350, 140);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
		FlowLayout fl_panelTitulo = (FlowLayout) panelTitulo.getLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
	
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Adicionar_Salario.class.getResource("/cImagens/Adicionar salario.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.add(icone);
		
		JLabel labelValorSalarioTitulo = new JLabel("Digite o valor");
		panelTitulo.add(labelValorSalarioTitulo);
		labelValorSalarioTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		panelValorSalario.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelValorSalario, BorderLayout.CENTER);
		panelValorSalario.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel labelValorSalario = new JLabel("Valor em R$");
		panelValorSalario.add(labelValorSalario);
		labelValorSalario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textValorSalario = new JTextField();
		textValorSalario.setHorizontalAlignment(SwingConstants.RIGHT);
		panelValorSalario.add(textValorSalario);
		textValorSalario.setColumns(10);
		PlainDocument documentValorSalario = (PlainDocument) textValorSalario.getDocument();
		documentValorSalario.setDocumentFilter(new ValidaNumeroDouble());
		
		JPanel panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		panelBotoes.add(panelBotoes2);
	
		confirmar = new JButton("Confirmar");
		confirmar.setPreferredSize(new Dimension(100, 23));
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textValorSalario.getText().isEmpty() || textValorSalario.getText().length() <= 0) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					try {
						setValorSalario(Double.parseDouble(textValorSalario.getText()));
						setVisible(false);
					}
					catch(NumberFormatException e2){
						String menssagemConteudo = "Campo do valor do salario aceita somente numeros e um ponto(valores quebrados)";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
				}
			}
		});
		panelBotoes2.add(confirmar);

		limpar = new JButton("Limpar");
		limpar.setToolTipText("Limpa os campos");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String menssagemConteudo = "Deseja limpar os campos ?";
				Tela_que_Exibe_Menssagem_Sim_Nao_Titulo avisoLimparCampos = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(menssagemConteudo);
				avisoLimparCampos.setVisible(true);
				String avisoLimparCamposTexto = avisoLimparCampos.getResposta();
				if (avisoLimparCamposTexto != null) {
					if (avisoLimparCamposTexto.equals("Sim")) {
						textValorSalario.setText("");
					}
				}
			}
		});
		limpar.setPreferredSize(new Dimension(100, 23));
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBotoes2.add(limpar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setPreferredSize(new Dimension(100, 23));
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textValorSalario.getText().length() != 0) {
						String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
						aviso.setVisible(true);
						String resposta = aviso.getResposta();
						if (resposta != null) {
							if (resposta.equals("Sim")) {
								double valorSalario1 = 0;
								setValorSalario(valorSalario1);
								setVisible(false);
								dispose();
							}
						}
				}
				else {
					double valorSalario1 = 0;
					setValorSalario(valorSalario1);
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
                	if (textValorSalario.getText().length() != 0) {
	                		String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
	    					aviso.setVisible(true);
	    					String resposta = aviso.getResposta();
	    					if (resposta != null) {
	    						if (resposta.equals("Sim")) {
	    							double valorSalario1 = 0;
	    							setValorSalario(valorSalario1);
	    							setVisible(false);
	    							dispose();
	    						}
	    					}
    				}
    				else {
    					double valorSalario1 = 0;
    					setValorSalario(valorSalario1);
    					setVisible(false);
    					dispose();
    				}
                }
            }
	    );
	}
	
	/*Metodos get e set*/
	private double valorSalario;
	/*get e set Valor do salario*/
	public double getValorSalario() {
		return valorSalario;
	}
	public void setValorSalario(double valorSalario) {
		this.valorSalario = valorSalario;
	}
}