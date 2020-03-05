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
import javax.swing.text.MaskFormatter;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;
import aInterfaceSistema.ValidaNumeroInteiro;
import mensagensSistema.Tela_que_Exibe_Menssagem_Sim_Nao_Titulo;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo;

public class Adicionar_Ferias_e_Folgas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panelFuncionarioFeriasFolgas = new JPanel();
	private JFormattedTextField textFeriasFolgasInicio, textFeriasFolgasFinal;
	private JTextField textDuracaoFeriasFolgas;
	private JComboBox<String> comboBoxFeriasFolgas;
	private final ButtonGroup buttonGroupTipoFeriasFolga = new ButtonGroup();
	private JRadioButton radioFerias, radioFolga;
	private JButton confirmar, limpar, cancelar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Adicionar_Ferias_e_Folgas dialog = new Adicionar_Ferias_e_Folgas();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Adicionar_Ferias_e_Folgas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Adicionar_Ferias_e_Folgas.class.getResource("/cImagens/Logo Janela.PNG")));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Vecx System");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 350, 230);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
		FlowLayout fl_panelTitulo = (FlowLayout) panelTitulo.getLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		
		JLabel Icone = new JLabel("");
		Icone.setIcon(new ImageIcon(Adicionar_Ferias_e_Folgas.class.getResource("/cImagens/Adicionar ferias folgas.PNG")));
		Icone.setPreferredSize(new Dimension(30, 30));
		Icone.setHorizontalAlignment(SwingConstants.CENTER);
		Icone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Icone.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.add(Icone);
		
		JLabel labelFuncionarioFeriasFolgas = new JLabel("Adicionar ferias/folga(s)");
		panelTitulo.add(labelFuncionarioFeriasFolgas);
		labelFuncionarioFeriasFolgas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		MaskFormatter dataInicioMascara = null;
		MaskFormatter dataFinalMascara = null;
		try{
			dataInicioMascara = new MaskFormatter("##/##/####");
			dataFinalMascara = new MaskFormatter("##/##/####");
        }
         catch(Exception e){
        	 String menssagemConteudo = "Impossivel carregar configurações";
        	 Tela_que_Exibe_Menssagem_Texto_Uma_Linha aviso = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
        	 aviso.setVisible(true);
        }
		
		panelFuncionarioFeriasFolgas.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelFuncionarioFeriasFolgas, BorderLayout.CENTER);
		panelFuncionarioFeriasFolgas.setLayout(new GridLayout(0, 1, 5, 5));
	
		JPanel panelTipoFeriasFolga = new JPanel();
		panelFuncionarioFeriasFolgas.add(panelTipoFeriasFolga);
		panelTipoFeriasFolga.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel labelTipoFeriasFolga = new JLabel("Tipo");
		labelTipoFeriasFolga.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTipoFeriasFolga.add(labelTipoFeriasFolga);
		
		JPanel panelTipoFeriasFolga2 = new JPanel();
		panelTipoFeriasFolga.add(panelTipoFeriasFolga2);
		panelTipoFeriasFolga2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

		radioFerias = new JRadioButton("Ferias");
		buttonGroupTipoFeriasFolga.add(radioFerias);
		radioFerias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTipoFeriasFolga2.add(radioFerias);
		
		radioFolga = new JRadioButton("Folga");
		buttonGroupTipoFeriasFolga.add(radioFolga);
		radioFolga.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelTipoFeriasFolga2.add(radioFolga);
		
		JPanel panelFeriasFolgasInicio = new JPanel();
		panelFuncionarioFeriasFolgas.add(panelFeriasFolgasInicio);
		panelFeriasFolgasInicio.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel labelFeriasFolgasInicio = new JLabel("Inicio ferias/folga(s)");
		labelFeriasFolgasInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelFeriasFolgasInicio.add(labelFeriasFolgasInicio);
	
		textFeriasFolgasInicio = new JFormattedTextField(dataInicioMascara);
		panelFeriasFolgasInicio.add(textFeriasFolgasInicio);
		textFeriasFolgasInicio.setColumns(10);

		JPanel panelFeriasFolgasFinal = new JPanel();
		panelFuncionarioFeriasFolgas.add(panelFeriasFolgasFinal);
		panelFeriasFolgasFinal.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel labelFeriasFolgasFinal = new JLabel("Final ferias/folga(s)");
		labelFeriasFolgasFinal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelFeriasFolgasFinal.add(labelFeriasFolgasFinal);
		
		textFeriasFolgasFinal = new JFormattedTextField(dataFinalMascara);
		textFeriasFolgasFinal.setColumns(10);
		panelFeriasFolgasFinal.add(textFeriasFolgasFinal);
		
		JPanel panelDuracaoFeriasFolgas = new JPanel();
		panelFuncionarioFeriasFolgas.add(panelDuracaoFeriasFolgas);
		panelDuracaoFeriasFolgas.setLayout(new GridLayout(0, 2, 5, 0));
		
		JLabel labelDuracaoFeriasFolgas = new JLabel("Dura\u00E7\u00E3o ferias/folga(s)");
		labelDuracaoFeriasFolgas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelDuracaoFeriasFolgas.add(labelDuracaoFeriasFolgas);
		
		JPanel panelDuracaoFeriasFolgas2 = new JPanel();
		panelDuracaoFeriasFolgas.add(panelDuracaoFeriasFolgas2);
		panelDuracaoFeriasFolgas2.setLayout(new BorderLayout(0, 0));

		textDuracaoFeriasFolgas = new JTextField();
		panelDuracaoFeriasFolgas2.add(textDuracaoFeriasFolgas);
		textDuracaoFeriasFolgas.setColumns(10);
		textDuracaoFeriasFolgas.setDocument(new ValidaNumeroInteiro());
		
		comboBoxFeriasFolgas = new JComboBox<String>();
		comboBoxFeriasFolgas.setMaximumRowCount(5);
		comboBoxFeriasFolgas.addItem("Escolha");
		comboBoxFeriasFolgas.addItem("dia(s)");
		comboBoxFeriasFolgas.addItem("semana(s)");
		comboBoxFeriasFolgas.addItem("mes(es)");
		comboBoxFeriasFolgas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelDuracaoFeriasFolgas2.add(comboBoxFeriasFolgas, BorderLayout.EAST);
		
		JPanel panelBotoes = new JPanel();
		getContentPane().add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new BorderLayout(0, 0));
		
		JSeparator separatorBotoes = new JSeparator();
		panelBotoes.add(separatorBotoes, BorderLayout.NORTH);
		
		JPanel panelBotoes2 = new JPanel();
		panelBotoes.add(panelBotoes2);
		
		confirmar = new JButton("Confirmar");
		confirmar.setToolTipText("Confirma os dados das ferias/folga(s)");
		confirmar.setPreferredSize(new Dimension(100, 23));
		confirmar.setMinimumSize(new Dimension(75, 23));
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFeriasFolgasInicio.getText().replaceAll("\\/", "").trim().isEmpty() || textFeriasFolgasFinal.getText().replaceAll("\\/", "").trim().isEmpty() ||
					textDuracaoFeriasFolgas.getText().isEmpty() || textDuracaoFeriasFolgas.getText().length() <= 0 || comboBoxFeriasFolgas.getSelectedItem() == "Escolha" ||
					buttonGroupTipoFeriasFolga.getSelection() == null) {
						String menssagemConteudo = "Campos vazios, preencha os campos para cadastrar";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo menssagemAvisoCampos = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Titulo(menssagemConteudo);
						menssagemAvisoCampos.setVisible(true);
				}
				else {
					
					if (radioFerias.isSelected()) {
						String tipoFeriasTexto = "Ferias";
						setTipoFeriasFolga(tipoFeriasTexto);
					}
					if (radioFolga.isSelected()) {
						String tipoFolgaTexto = "Folga";
						setTipoFeriasFolga(tipoFolgaTexto);
					}
					
					String dataInicioFeriasFolga = textFeriasFolgasInicio.getText();
					try {
						SimpleDateFormat dataInicioFormato = new SimpleDateFormat("dd/MM/yyyy");
						dataInicio = new java.sql.Date(dataInicioFormato.parse(dataInicioFeriasFolga).getTime());
						setDataInicio(dataInicio);
					} catch (ParseException e3) {
						e3.printStackTrace();
					}
					
					String dataFinalFeriasFolga = textFeriasFolgasFinal.getText();
					try {
						SimpleDateFormat dataFinalFormato = new SimpleDateFormat("dd/MM/yyyy");
						dataFinal = new java.sql.Date(dataFinalFormato.parse(dataFinalFeriasFolga).getTime());
						setDataFinal(dataFinal);
					} catch (ParseException e3) {
						e3.printStackTrace();
					}
					
					try {
						java.util.Date dataRegistro = new java.util.Date();
						SimpleDateFormat dataRegistroFormato = new SimpleDateFormat("dd/MM/yyyy");
						String dataCadastroCliente = dataRegistroFormato.format(dataRegistro);
						SimpleDateFormat dataCadastroFormato = new SimpleDateFormat("dd/MM/yyyy");
						Date dataCadastro = new java.sql.Date(dataCadastroFormato.parse(dataCadastroCliente).getTime());
						setDataCadastro(dataCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
					}
					
					try {
						java.util.Date horaRegistro = new java.util.Date();
						SimpleDateFormat horaRegistroFormato = new SimpleDateFormat("HH:mm");
						String horaCadastroFuncionario = horaRegistroFormato.format(horaRegistro);
						SimpleDateFormat horaCadastroFormato = new SimpleDateFormat("HH:mm");
						Time horaCadastro = new java.sql.Time(horaCadastroFormato.parse(horaCadastroFuncionario).getTime());
						setHoraCadastro(horaCadastro);
					} catch (ParseException e9) {
						e9.printStackTrace();
					}
					
					String duracaoFeriasFolgasValor = textDuracaoFeriasFolgas.getText();
					String duracaoFeriasFolgasUnidade = (String) comboBoxFeriasFolgas.getSelectedItem();
					String duracaoFeriasFolgas = duracaoFeriasFolgasValor + " " + duracaoFeriasFolgasUnidade;
					setDuracaoFeriasFolga(duracaoFeriasFolgas);
					
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
						textDuracaoFeriasFolgas.setText("");
						textFeriasFolgasInicio.setText("");
						textFeriasFolgasFinal.setText("");
						comboBoxFeriasFolgas.setSelectedItem("Escolha");
						buttonGroupTipoFeriasFolga.clearSelection();
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
				if (textFeriasFolgasInicio.getText().replaceAll("\\/", "").trim().length() != 0 || textFeriasFolgasFinal.getText().replaceAll("\\/", "").trim().length() != 0 ||
					textDuracaoFeriasFolgas.getText().length() != 0 || comboBoxFeriasFolgas.getSelectedItem() != "Escolha" ||
					buttonGroupTipoFeriasFolga.getSelection() != null) {
						String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
						Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
						aviso.setVisible(true);
						String resposta = aviso.getResposta();
						if (resposta != null) {
							if (resposta.equals("Sim")) {
								Date dataInicio1 = null;
								Date dataFinal1 = null;
								Date dataCadastro1 = null;
								Time horaCadastro1 = null;
								String duracaoCadastro = null;
								setDataInicio(dataInicio1);
								setDataFinal(dataFinal1);
								setDataCadastro(dataCadastro1);
								setHoraCadastro(horaCadastro1);
								setDuracaoFeriasFolga(duracaoCadastro);
								setVisible(false);
					            dispose();
							}
						}
				}
				else {
					Date dataInicio1 = null;
					Date dataFinal1 = null;
					Date dataCadastro1 = null;
					Time horaCadastro1 = null;
					String duracaoCadastro = null;
					setDataInicio(dataInicio1);
					setDataFinal(dataFinal1);
					setDataCadastro(dataCadastro1);
					setHoraCadastro(horaCadastro1);
					setDuracaoFeriasFolga(duracaoCadastro);
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
                	if (textFeriasFolgasInicio.getText().replaceAll("\\/", "").trim().length() != 0 || textFeriasFolgasFinal.getText().replaceAll("\\/", "").trim().length() != 0 ||
    					textDuracaoFeriasFolgas.getText().length() != 0 || comboBoxFeriasFolgas.getSelectedItem() != "Escolha" ||
    					buttonGroupTipoFeriasFolga.getSelection() != null) {
	                		String menssagemConteudo = "Há campos preenchidos, ao sair da tela os dados nos campos serão perdidos. Deseja voltar?";
							Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao aviso = new Tela_que_Exibe_Menssagem_Texto_Varias_Linhas_Sim_Nao(menssagemConteudo);
    						aviso.setVisible(true);
    						String resposta = aviso.getResposta();
    						if (resposta != null) {
    							if (resposta.equals("Sim")) {
    								Date dataInicio1 = null;
    								Date dataFinal1 = null;
    								Date dataCadastro1 = null;
    								Time horaCadastro1 = null;
    								String duracaoCadastro = null;
    								setDataInicio(dataInicio1);
    								setDataFinal(dataFinal1);
    								setDataCadastro(dataCadastro1);
    								setHoraCadastro(horaCadastro1);
    								setDuracaoFeriasFolga(duracaoCadastro);
    								setVisible(false);
    					            dispose();
    							}
    						}
    				}
    				else {
    					Date dataInicio1 = null;
    					Date dataFinal1 = null;
    					Date dataCadastro1 = null;
    					Time horaCadastro1 = null;
    					String duracaoCadastro = null;
    					setDataInicio(dataInicio1);
    					setDataFinal(dataFinal1);
    					setDataCadastro(dataCadastro1);
    					setHoraCadastro(horaCadastro1);
    					setDuracaoFeriasFolga(duracaoCadastro);
    					setVisible(false);
    					dispose();
    				}
                }
            }
	    );
	}
	
	/*Metodos get e set*/
	private String duracaoFeriasFolga, tipoFeriasFolga;
	private Date dataInicio, dataFinal, dataCadastro;
	private Time horaCadastro;
	/*get e set Duração da ferias/folga*/
	public String getDuracaoFeriasFolga() {
		return duracaoFeriasFolga;
	}
	public void setDuracaoFeriasFolga(String duracaoFeriasFolga) {
		this.duracaoFeriasFolga = duracaoFeriasFolga;
	}
	
	/*get e set Data de inicio da ferias/folga*/
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	/*get e set Data final da ferias/folga*/
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	/*get e set Data de cadastro da ferias/folga*/
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	/*get e set Hora de cadastro da ferias/folga*/
	public Time getHoraCadastro() {
		return horaCadastro;
	}
	public void setHoraCadastro(Time horaCadastro) {
		this.horaCadastro = horaCadastro;
	}
	
	/*get e set Tipo de ferias/folga*/
	public String getTipoFeriasFolga() {
		return tipoFeriasFolga;
	}
	public void setTipoFeriasFolga(String tipoFeriasFolga) {
		this.tipoFeriasFolga = tipoFeriasFolga;
	}
}