package moduloFuncionarioTelas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class Adicionar_Comissoes_e_Bonus extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelComissoesBonus = new JPanel();
	private JTextField textComissoes, textBonus;
	private JButton confirmar, limpar, cancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Adicionar_Comissoes_e_Bonus dialog = new Adicionar_Comissoes_e_Bonus();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Adicionar_Comissoes_e_Bonus() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Adicionar_Comissoes_e_Bonus.class.getResource("/cImagens/Logo Janela.PNG")));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setTitle("Vecx System");
		setResizable(false);
		setBounds(100, 100, 340, 170);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
		FlowLayout fl_panelTitulo = (FlowLayout) panelTitulo.getLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon(Adicionar_Comissoes_e_Bonus.class.getResource("/cImagens/Adicionar bonus comissoes.PNG")));
		icone.setPreferredSize(new Dimension(30, 30));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.add(icone);
		
		JLabel labelValorSalario = new JLabel("Digite o valor");
		panelTitulo.add(labelValorSalario);
		labelValorSalario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		panelComissoesBonus.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelComissoesBonus, BorderLayout.CENTER);
		panelComissoesBonus.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelComissoes = new JPanel();
		panelComissoesBonus.add(panelComissoes);
		panelComissoes.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel labelComissoes = new JLabel("Valor da comiss\u00E3o");
		panelComissoes.add(labelComissoes);
		labelComissoes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textComissoes = new JTextField();
		textComissoes.setHorizontalAlignment(SwingConstants.RIGHT);
		panelComissoes.add(textComissoes);
		textComissoes.setColumns(10);
		PlainDocument documentComissoes = (PlainDocument) textComissoes.getDocument();
		documentComissoes.setDocumentFilter(new ValidaNumeroDouble());
		
		JPanel panelBonus = new JPanel();
		panelComissoesBonus.add(panelBonus);
		panelBonus.setLayout(new GridLayout(0, 2, 5, 0));
	
		JLabel labelBonus = new JLabel("Valor do bonus");
		panelBonus.add(labelBonus);
		labelBonus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textBonus = new JTextField();
		textBonus.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBonus.add(textBonus);
		textBonus.setColumns(10);
		PlainDocument documentBonus = (PlainDocument) textBonus.getDocument();
		documentBonus.setDocumentFilter(new ValidaNumeroDouble());
		
		JPanel panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
	
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		panelBotoes.add(panelBotoes2);
		
		confirmar = new JButton("Confirmar");
		confirmar.setToolTipText("Confirma os dados");
		confirmar.setPreferredSize(new Dimension(100, 23));
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.util.Date dataRegistro = new java.util.Date();
					SimpleDateFormat dataRegistroFormato = new SimpleDateFormat("dd/MM/yyyy");
					String dataCadastroFuncionario = dataRegistroFormato.format(dataRegistro);
					SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
					Date dataCadastro = new java.sql.Date(dataCadastroFormato.parse(dataCadastroFuncionario).getTime());
					setRespostaDataCadastro(dataCadastro);
				} catch (ParseException e9) {
					e9.printStackTrace();
				}
				
				try {
					java.util.Date horaRegistro = new java.util.Date();
					SimpleDateFormat horaRegistroFormato = new SimpleDateFormat("HH:mm");
					String horaCadastroFuncionario = horaRegistroFormato.format(horaRegistro);
					SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
					Time horaCadastro = new java.sql.Time(horaCadastroFormato.parse(horaCadastroFuncionario).getTime());
					setRespostaHoraCadastro(horaCadastro);
				} catch (ParseException e9) {
					e9.printStackTrace();
				}
				
				double comissaoValor;
				double bonusValor;
				if (textComissoes.getText().isEmpty() || textComissoes.getText().length() <= 0) {
					try {
						textComissoes.setText("0");
						comissaoValor = Double.parseDouble(textComissoes.getText());
						setValorComissao(comissaoValor);
						
						Date dataCadastroValor = getRespostaDataCadastro();
						setDataCadastro(dataCadastroValor);
						
						Time horaCadastroValor = getRespostaHoraCadastro();
						setHoraCadastro(horaCadastroValor);
					}
					catch(NumberFormatException e2){
						String menssagemConteudo = "Campos numericos aceitam somente numeros e pontos(valores quebrados)";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
				}
				else {
					try {
						setValorComissao(Double.parseDouble(textComissoes.getText()));
						
						Date dataCadastroValor = getRespostaDataCadastro();
						setDataCadastro(dataCadastroValor);
						
						Time horaCadastroValor = getRespostaHoraCadastro();
						setHoraCadastro(horaCadastroValor);
					}
					catch(NumberFormatException e2){
						String menssagemConteudo = "Campos numericos aceitam somente numeros e pontos(valores quebrados)";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
				}
				
				if (textBonus.getText().isEmpty() || textBonus.getText().length() <= 0) {
					try {
						textBonus.setText("0");
						bonusValor = Double.parseDouble(textBonus.getText());
						setValorBonus(bonusValor);

						Date dataCadastroValor = getRespostaDataCadastro();
						setDataCadastro(dataCadastroValor);
						
						Time horaCadastroValor = getRespostaHoraCadastro();
						setHoraCadastro(horaCadastroValor);
					}
					catch(NumberFormatException e2){
						String menssagemConteudo = "Campos numericos aceitam somente numeros e pontos(valores quebrados)";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
				}
				else {
					try {
						setValorBonus(Double.parseDouble(textBonus.getText()));

						Date dataCadastroValor = getRespostaDataCadastro();
						setDataCadastro(dataCadastroValor);
						
						Time horaCadastroValor = getRespostaHoraCadastro();
						setHoraCadastro(horaCadastroValor);
					}
					catch(NumberFormatException e2){
						String menssagemConteudo = "Campos numericos aceitam somente numeros e pontos(valores quebrados)";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
					}
				}
				
				setVisible(false);
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
						textBonus.setText("");
						textComissoes.setText("");
					}
				}
			}
		});
		limpar.setToolTipText("Limpa os campos");
		limpar.setPreferredSize(new Dimension(100, 23));
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBotoes2.add(limpar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setToolTipText("Fecha a janela");
		cancelar.setPreferredSize(new Dimension(100, 23));
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textComissoes.getText().length() != 0 || textBonus.getText().length() != 0) {
						String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
						aviso.setVisible(true);
						String resposta = aviso.getResposta();
						if (resposta != null) {
							if (resposta.equals("Sim")) {
								double comissaoValor1 = 0;
								double bonusValor1 = 0;
								Date dataCadastro1 = null;
								Time horaCadastro = null;
								setValorComissao(comissaoValor1);
								setValorBonus(bonusValor1);
								setDataCadastro(dataCadastro1);
								setHoraCadastro(horaCadastro);
								setVisible(false);
								dispose();
							}
						}
				}
				else {
					double comissaoValor1 = 0;
					double bonusValor1 = 0;
					Date dataCadastro1 = null;
					Time horaCadastro = null;
					setValorComissao(comissaoValor1);
					setValorBonus(bonusValor1);
					setDataCadastro(dataCadastro1);
					setHoraCadastro(horaCadastro);
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
                	if (textComissoes.getText().length() != 0 || textBonus.getText().length() != 0) {
	                		String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
	    					aviso.setVisible(true);
	    					String resposta = aviso.getResposta();
	    					if (resposta != null) {
	    						if (resposta.equals("Sim")) {
	    							double comissaoValor1 = 0;
	    							double bonusValor1 = 0;
	    							Date dataCadastro1 = null;
	    							Time horaCadastro = null;
	    							setValorComissao(comissaoValor1);
	    							setValorBonus(bonusValor1);
	    							setDataCadastro(dataCadastro1);
	    							setHoraCadastro(horaCadastro);
	    							setVisible(false);
	    							dispose();
	    						}
	    					}
    				}
    				else {
    					double comissaoValor1 = 0;
    					double bonusValor1 = 0;
    					Date dataCadastro1 = null;
    					Time horaCadastro = null;
    					setValorComissao(comissaoValor1);
    					setValorBonus(bonusValor1);
    					setDataCadastro(dataCadastro1);
    					setHoraCadastro(horaCadastro);
    					setVisible(false);
    					dispose();
    				}
                }
            }
	    );
	}
	
	/*Metodos get e set*/
	private double valorComissao, valorBonus;
	private Date dataCadastro, respostaDataCadastro;
	private Time horaCadastro, respostaHoraCadastro;
	/*get e set Valor da comissão*/
	public double getValorComissao() {
		return valorComissao;
	}
	public void setValorComissao(double valorComissao) {
		this.valorComissao = valorComissao;
	}
	
	/*get e set Valor do bonus*/
	public double getValorBonus() {
		return valorBonus;
	}
	public void setValorBonus(double valorBonus) {
		this.valorBonus = valorBonus;
	}
	
	/*get e set Data de cadastro*/
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	/*get e set Hora de cadastro*/
	public Time getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(Time horaCadastro) {
		this.horaCadastro = horaCadastro;
	}
	
	/*get e set Resposta Data de cadastro*/
	public Date getRespostaDataCadastro() {
		return respostaDataCadastro;
	}
	public void setRespostaDataCadastro(Date respostaDataCadastro) {
		this.respostaDataCadastro = respostaDataCadastro;
	}
	
	/*get e set Resposta Hora de cadastro*/
	public Time getRespostaHoraCadastro() {
		return respostaHoraCadastro;
	}
	public void setRespostaHoraCadastro(Time respostaHoraCadastro) {
		this.respostaHoraCadastro = respostaHoraCadastro;
	}
}