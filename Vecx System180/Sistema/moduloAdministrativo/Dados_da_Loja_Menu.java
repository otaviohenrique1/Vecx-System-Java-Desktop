package moduloAdministrativo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Toolkit;

public class Dados_da_Loja_Menu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton dadosLoja, fichaLoja, voltar;
	private JLabel labelEstadoDadosLoja, estadoDadosLoja;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dados_da_Loja_Menu dialog = new Dados_da_Loja_Menu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dados_da_Loja_Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dados_da_Loja_Menu.class.getResource("/cImagens/Logo Janela.PNG")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Vecx System");
		setResizable(false);
		setBounds(100, 100, 325, 240);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
		FlowLayout fl_panelTitulo = (FlowLayout) panelTitulo.getLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Dados_da_Loja_Menu.class.getResource("/cImagens/Menu dados loja.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.add(icone);
		
		JLabel labelDadosLoja = new JLabel("Configura\u00E7\u00F5es");
		panelTitulo.add(labelDadosLoja);
		labelDadosLoja.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.CENTER);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		panelBotoes.add(panelBotoes2);
		
		JPanel panelMenuDadosLoja = new JPanel();
		panelMenuDadosLoja.setPreferredSize(new Dimension(300, 150));
		panelBotoes2.add(panelMenuDadosLoja);
		panelMenuDadosLoja.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelEstadoMenuDadosLoja = new JPanel();
		panelEstadoMenuDadosLoja.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelMenuDadosLoja.add(panelEstadoMenuDadosLoja);
		panelEstadoMenuDadosLoja.setLayout(new GridLayout(0, 2, 0, 0));
		
		labelEstadoDadosLoja = new JLabel("Dados da loja:");
		panelEstadoMenuDadosLoja.add(labelEstadoDadosLoja);
		labelEstadoDadosLoja.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		estadoDadosLoja = new JLabel();
		estadoDadosLoja.setHorizontalAlignment(SwingConstants.RIGHT);
		panelEstadoMenuDadosLoja.add(estadoDadosLoja);
		estadoDadosLoja.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		/*Consulta se os dados da loja foram cadastrados*/
		String dadosLojaRegistro = "Ativo";
		boolean consultaDadosLoja;
		consultaDadosLoja = new Dao_consulta_dados_loja().Consulta_Dados_Loja_Cadastro(dadosLojaRegistro);
		if (consultaDadosLoja == false) {
			String dadosLojaRegistroTexto1 = "Não registrado";
			estadoDadosLoja.setText(dadosLojaRegistroTexto1);
		}
		else {
			String dadosLojaRegistroTexto = "Registrado";
			estadoDadosLoja.setText(dadosLojaRegistroTexto);
		}
		
		dadosLoja = new JButton("Dados da loja");
		dadosLoja.setToolTipText("Exibe a tela de cadastro dos dados da loja que v\u00E3o estar presentes na nota fiscal");
		panelMenuDadosLoja.add(dadosLoja);
		dadosLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dadosLojaRegistro = "Ativo";
				boolean consultaDadosLoja;
				consultaDadosLoja = new Dao_consulta_dados_loja().Consulta_Dados_Loja_Cadastro(dadosLojaRegistro);
				if (consultaDadosLoja == false) {
					Loja_Cadastro lojaCadastro = new Loja_Cadastro();
					lojaCadastro.setVisible(true);
					dispose();
				}
				else {
					String menssagemConteudo = "Dados da loja ja estão cadastrados";
					Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
					menssagemAviso.setVisible(true);
				}
			}
		});
		dadosLoja.setPreferredSize(new Dimension(100, 23));
		dadosLoja.setMinimumSize(new Dimension(75, 23));
		dadosLoja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		fichaLoja = new JButton("Ficha da Loja");
		fichaLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loja_Ficha lojaFicha = new Loja_Ficha();
				lojaFicha.setVisible(true);
				dispose();
			}
		});
		fichaLoja.setToolTipText("Exibe a ficha com os dados da loja que est\u00E3o presentes na nota fiscal");
		panelMenuDadosLoja.add(fichaLoja);
		fichaLoja.setPreferredSize(new Dimension(100, 23));
		fichaLoja.setMinimumSize(new Dimension(75, 23));
		fichaLoja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		voltar = new JButton("Voltar");
		voltar.setToolTipText("Fecha a janela");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panelMenuDadosLoja.add(voltar);
		voltar.setPreferredSize(new Dimension(100, 23));
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
}