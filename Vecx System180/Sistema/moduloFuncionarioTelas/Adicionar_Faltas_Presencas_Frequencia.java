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
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;

public class Adicionar_Faltas_Presencas_Frequencia extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelFuncionarioFrequencia = new JPanel();
	private JRadioButton radioPresenca, radioFalta;
	private final ButtonGroup buttonGroupFuncionarioHistorico = new ButtonGroup();
	private JButton confirmar, limpar, cancelar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Adicionar_Faltas_Presencas_Frequencia dialog = new Adicionar_Faltas_Presencas_Frequencia();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Adicionar_Faltas_Presencas_Frequencia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Adicionar_Faltas_Presencas_Frequencia.class.getResource("/cImagens/Logo Janela.PNG")));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Vecx System");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 340, 160);
		getContentPane().setLayout(new BorderLayout());
	
		JPanel panelTitulo = new JPanel();
		FlowLayout fl_panelTitulo = (FlowLayout) panelTitulo.getLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		
		JLabel Icone = new JLabel("");
		Icone.setIcon(new ImageIcon(Adicionar_Faltas_Presencas_Frequencia.class.getResource("/cImagens/Adicionar frequencia faltas.PNG")));
		Icone.setPreferredSize(new Dimension(30, 30));
		Icone.setHorizontalAlignment(SwingConstants.CENTER);
		Icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.add(Icone);
		
		JLabel labelFuncionarioHistorico = new JLabel("Funcionario frequencia");
		panelTitulo.add(labelFuncionarioHistorico);
		labelFuncionarioHistorico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		panelFuncionarioFrequencia.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelFuncionarioFrequencia, BorderLayout.CENTER);
		panelFuncionarioFrequencia.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelFuncionarioHistorico = new JPanel();
		panelFuncionarioFrequencia.add(panelFuncionarioHistorico);
		panelFuncionarioHistorico.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel labelFrequencia = new JLabel("Frequencia");
		labelFrequencia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelFuncionarioHistorico.add(labelFrequencia);
		
		radioPresenca = new JRadioButton("Presen\u00E7a");
		panelFuncionarioHistorico.add(radioPresenca);
		buttonGroupFuncionarioHistorico.add(radioPresenca);
		radioPresenca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		radioFalta = new JRadioButton("Falta");
		panelFuncionarioHistorico.add(radioFalta);
		buttonGroupFuncionarioHistorico.add(radioFalta);
		radioFalta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorDesconto = new JSeparator();
		panelBotoes.add(separatorDesconto, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		panelBotoes.add(panelBotoes2);
			
		confirmar = new JButton("Confirmar");
		confirmar.setToolTipText("Confirma os dados da frequencia");
		confirmar.setPreferredSize(new Dimension(100, 23));
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buttonGroupFuncionarioHistorico.getSelection() == null) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					if (radioPresenca.isSelected()) {
						String presencaTexto = "Presença";
						setFrequenciaFuncionario(presencaTexto);
					}
					if (radioFalta.isSelected()) {
						String faltaTexto = "Falta";
						setFrequenciaFuncionario(faltaTexto);
					}
					setVisible(false);
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
						buttonGroupFuncionarioHistorico.clearSelection();
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
				if (buttonGroupFuncionarioHistorico.getSelection() != null) {
						String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
						aviso.setVisible(true);
						String resposta = aviso.getResposta();
						if (resposta != null) {
							if (resposta.equals("Sim")) {
								String funcionarioFrequencia1 = null;
								setFrequenciaFuncionario(funcionarioFrequencia1);
								setVisible(false);
					            dispose();
							}
						}
				}
				else {
					String funcionarioFrequencia1 = null;
					setFrequenciaFuncionario(funcionarioFrequencia1);
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
                	if (buttonGroupFuncionarioHistorico.getSelection() != null) {
	                		String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
							aviso.setVisible(true);
							String resposta = aviso.getResposta();
							if (resposta != null) {
								if (resposta.equals("Sim")) {
									String funcionarioFrequencia1 = null;
									setFrequenciaFuncionario(funcionarioFrequencia1);
									setVisible(false);
						            dispose();
								}
							}
					}
					else {
						String funcionarioFrequencia1 = null;
						setFrequenciaFuncionario(funcionarioFrequencia1);
						setVisible(false);
			            dispose();
					}
                }
            }
	    );
	}
	
	/*Metodos get e set*/
	private String frequenciaFuncionario;
	/*get e set Frequencia do funcionario*/
	public String getFrequenciaFuncionario() {
		return frequenciaFuncionario;
	}
	public void setFrequenciaFuncionario(String frequenciaFuncionario) {
		this.frequenciaFuncionario = frequenciaFuncionario;
	}
}