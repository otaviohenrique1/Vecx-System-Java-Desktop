package mensagensSistema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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

public class Tela_que_Exibe_Menssagem_Sim_Nao_Titulo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelTituloMenssagem = new JPanel();
	private JButton sim, nao;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Tela_que_Exibe_Menssagem_Sim_Nao_Titulo dialog = new Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Tela_que_Exibe_Menssagem_Sim_Nao_Titulo(String menssagemTitulo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_que_Exibe_Menssagem_Sim_Nao_Titulo.class.getResource("/cImagens/Logo Janela.PNG")));
		setModal(true);
		setResizable(false);
		setTitle("Vecx System");
		setBounds(100, 100, 350, 120);
		getContentPane().setLayout(new BorderLayout(0, 0));
		panelTituloMenssagem.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelTituloMenssagem, BorderLayout.CENTER);
		panelTituloMenssagem.setLayout(new BorderLayout(10, 0));
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Tela_que_Exibe_Menssagem_Sim_Nao_Titulo.class.getResource("/cImagens/Mensagem aviso.png")));
		icone.setPreferredSize(new Dimension(30, 30));
		panelTituloMenssagem.add(icone, BorderLayout.WEST);
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelMensagemTitulo = new JLabel("Titulo da menssagem");
		panelTituloMenssagem.add(labelMensagemTitulo);
		labelMensagemTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		String menssagemTitulo1 = menssagemTitulo;
		if (menssagemTitulo1 == null) {
			labelMensagemTitulo.setText("Titulo da menssagem");
		}
		else {
			labelMensagemTitulo.setText(menssagemTitulo1);
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
		sim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotoes2.add(sim);
		
		nao = new JButton("N\u00E3o");
		nao.setFont(new Font("Tahoma", Font.PLAIN, 13));
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