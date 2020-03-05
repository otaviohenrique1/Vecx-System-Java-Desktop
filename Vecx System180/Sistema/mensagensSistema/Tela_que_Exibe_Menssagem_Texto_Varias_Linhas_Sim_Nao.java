package mensagensSistema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelTitulo = new JPanel();
	private JTextPane textPaneConteudoMessagem;
	private JButton sim, nao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao dialog = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(String menssagemTitulo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao.class.getResource("/cImagens/Logo Janela.PNG")));
		setModal(true);
		setResizable(false);
		setTitle("Vecx System");
		setBounds(100, 100, 325, 140);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		panelTitulo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new BorderLayout(10, 0));
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao.class.getResource("/cImagens/Mensagem aviso.png")));
		icone.setPreferredSize(new Dimension(30, 30));
		panelTitulo.add(icone, BorderLayout.WEST);
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JScrollPane scrollPaneConteudoMenssagem = new JScrollPane();
		panelTitulo.add(scrollPaneConteudoMenssagem, BorderLayout.CENTER);
		
		textPaneConteudoMessagem = new JTextPane();
		textPaneConteudoMessagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPaneConteudoMessagem.setBackground(new Color(245, 245, 245));
		textPaneConteudoMessagem.setEditable(false);
		textPaneConteudoMessagem.setPreferredSize(new Dimension(300, 60));
		scrollPaneConteudoMenssagem.setViewportView(textPaneConteudoMessagem);
		
		String menssagemTitulo1 = menssagemTitulo;
		if (menssagemTitulo1 == null) {
			textPaneConteudoMessagem.setText("Titulo da menssagem");
		}
		else {
			textPaneConteudoMessagem.setText(menssagemTitulo1);
		}
		
		JPanel panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		panelBotoes.add(panelBotoes2);
		
		sim = new JButton("Sim");
		sim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String resposta = "Sim";
				setResposta(resposta);
				setVisible(false);
			}
		});
		sim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBotoes2.add(sim);
		
		nao = new JButton("N\u00E3o");
		nao.setToolTipText("N\u00E3o");
		nao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panelBotoes2.add(nao);
	}
	
	/*Metodos get e set*/
	private String resposta;
	/*get e set Resposta*/
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}