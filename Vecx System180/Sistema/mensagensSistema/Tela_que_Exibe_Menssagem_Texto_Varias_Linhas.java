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

public class Tela_que_Exibe_Menssagem_Texto_Varias_Linhas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelTitulo = new JPanel();
	private JTextPane textPaneConteudoMessagem;
	private JButton fechar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Tela_que_Exibe_Menssagem_Texto_Varias_Linhas dialog = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas(null , null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Tela_que_Exibe_Menssagem_Texto_Varias_Linhas(String menssagemTitulo, String menssagemConteudo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela_que_Exibe_Menssagem_Texto_Varias_Linhas.class.getResource("/cImagens/Logo Janela.PNG")));
		setModal(true);
		setResizable(false);
		setTitle("Vecx System");
		setBounds(100, 100, 325, 307);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		panelTitulo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new BorderLayout(10, 0));
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Tela_que_Exibe_Menssagem_Texto_Varias_Linhas.class.getResource("/cImagens/Mensagem aviso.png")));
		icone.setPreferredSize(new Dimension(30, 30));
		panelTitulo.add(icone, BorderLayout.WEST);
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel labelTitulo = new JLabel("Titulo da menssagem");
		panelTitulo.add(labelTitulo);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		String menssagemTitulo1 = menssagemTitulo;
		if (menssagemTitulo1 == null) {
			labelTitulo.setText("Titulo da menssagem");
		}
		else {
			labelTitulo.setText(menssagemTitulo1);
		}
		
		JPanel panelConteudo = new JPanel();
		getContentPane().add(panelConteudo, BorderLayout.CENTER);
		panelConteudo.setLayout(new BorderLayout(0, 0));
		
		JPanel panelConteudoMenssagem = new JPanel();
		panelConteudo.add(panelConteudoMenssagem, BorderLayout.CENTER);
		
		JScrollPane scrollPaneConteudoMenssagem = new JScrollPane();
		panelConteudoMenssagem.add(scrollPaneConteudoMenssagem);
		
		textPaneConteudoMessagem = new JTextPane();
		textPaneConteudoMessagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPaneConteudoMessagem.setBackground(new Color(245, 245, 245));
		textPaneConteudoMessagem.setEditable(false);
		textPaneConteudoMessagem.setPreferredSize(new Dimension(300, 180));
		scrollPaneConteudoMenssagem.setViewportView(textPaneConteudoMessagem);
		
		String menssagemConteudo1 = menssagemConteudo;
		if (menssagemConteudo1 == null) {
			textPaneConteudoMessagem.setText("Conteudo da menssagem");
		}
		else {
			textPaneConteudoMessagem.setText(menssagemConteudo1);
		}
		
		JPanel panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		panelBotoes.add(panelBotoes2);
		
		fechar = new JButton("Fechar");
		fechar.setToolTipText("Fecha a janela");
		fechar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panelBotoes2.add(fechar);
	}
}