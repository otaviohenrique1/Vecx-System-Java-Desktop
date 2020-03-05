package moduloFinanceiroOutrasClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.math.BigDecimal;
import mensagensSistema.Tela_que_Exibe_Menssagem;

public class Calculadora extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel panelVisor,panelTeclado;
	private JLabel Visor,Titulo;
	private JButton N1,N2,N3,N4,N5,N6,N7,N8,N9,N0,Sair,Potencia3,Apagar,CE, Divisao,Multiplicacao,Subtracao,Virgula,Adicao, NumeroSinal,Porcentagem,Raiz,Potencia2,Igual;	
	private JTabbedPane tabbedPaneCalculadora;
    private JPanel panelCalculadora, panelAjudaBotoes, panelMedidaValores, panelBotoes2, panelMedidaValorEntrada2, panelMedidaValorResultado2;
    private JPanel panelCalculadoraMedidas, panelCalculadoraAjuda, panelMedidaVisor, panelMedidaBotoes, panelMedidaValorResultado, panelMedidaValorEntrada;
    private JPanel panelBotoes1, panelBotoes3, panelTipoMedida;
    private JLabel labelMedidaValorResultado, valorResultado, labelMedidaValorEntrada, valorEntrada, labelMedidaTipo;
    private JButton medidaCalcular, medidaSair, medidaApagar, medidaCE, medidaN7, medidaN8, medidaN9, medidaN4, medidaN5, medidaN6, medidaN3, medidaN2;
    private JButton medidaN1, medidaN0, ajudaSair, medidaPonto;
    private JRadioButton radioTamanho, radioPeso;
    private final ButtonGroup buttonGroupMedidaTipo = new ButtonGroup();
    private JComboBox<String> comboBoxValorEntrada,  comboBoxValorResultado;
	String xx = "0", yy = "0", yz = "0", unidadeEntrada, unidadeResultado, yk;
    double xa=0,xb=0,xr=0, ya=0,yb=0,yr=0;
    BigDecimal yt;
    char op='n', medidaop='n';
    int Achou, zerar, num, AchouMedida, zerarMedida;
    FuncoesCalculadora EventoCalculadora = new FuncoesCalculadora();
    FuncoesCalculadoraMedidas EventoCalculadoraMedidas = new FuncoesCalculadoraMedidas();
    RadioButtonEstado EventoRadioButton = new RadioButtonEstado();
    private JTextPane textPaneAjuda;
    private JScrollPane scrollPaneAjuda;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Calculadora dialog = new Calculadora();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Calculadora() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Calculadora.class.getResource("/cImagens/Logo Janela.PNG")));
		setTitle("Vecx System");
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(new BorderLayout(0, 10));
		
		panelTitulo = new JPanel();
		contentPane.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		panelTitulo2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelTitulo.add(panelTitulo2);
		
		icone = new JLabel();
		panelTitulo2.add(icone);
		icone.setIcon(new ImageIcon(Calculadora.class.getResource("/cImagens/Calculadora.PNG")));
		icone.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		icone.setPreferredSize(new Dimension(30, 30));
		
		Titulo = new JLabel("Calculadora");
		panelTitulo2.add(Titulo);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		separator = new JSeparator();
		panelTitulo.add(separator, BorderLayout.SOUTH);
		
		tabbedPaneCalculadora = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneCalculadora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(tabbedPaneCalculadora);
		
		/*Calculadora*/
		panelCalculadora = new JPanel();
		tabbedPaneCalculadora.addTab("Calculadora", null, panelCalculadora, null);
		panelCalculadora.setLayout(new BorderLayout(20, 20));
		
		panelVisor = new JPanel();
		panelVisor.setPreferredSize(new Dimension(10, 60));
		panelCalculadora.add(panelVisor, BorderLayout.NORTH);
		panelVisor.setBackground(new Color(192, 192, 192));
		panelVisor.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelVisor.setLayout(new BorderLayout(10, 10));
		
		Visor = new JLabel("0.0");
		Visor.setVerticalAlignment(SwingConstants.BOTTOM);
		Visor.setHorizontalAlignment(SwingConstants.RIGHT);
		Visor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Visor.setSize(300, 300);		
		panelVisor.add(Visor);
		
		panelTeclado = new JPanel();
		panelCalculadora.add(panelTeclado, BorderLayout.CENTER);
		panelTeclado.setLayout(new GridLayout(0, 4, 5, 5));
		
		Sair = new JButton("Sair");
		Sair.setToolTipText("Fecha a janela");
		Sair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Sair.setBackground(new Color(135, 206, 235));
		Sair.addActionListener(EventoCalculadora);
		panelTeclado.add(Sair);
		
		Apagar = new JButton("Apagar");
		Apagar.setToolTipText("Apaga o(s) valore(s) da tela da calculadora");
		Apagar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Apagar.setBackground(new Color(135, 206, 235));
		Apagar.addActionListener(EventoCalculadora);
		panelTeclado.add(Apagar);
		
		CE = new JButton("CE");
		CE.setToolTipText("Zera o valor da tela da calculadora");
		CE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CE.setBackground(new Color(135, 206, 235));
		CE.addActionListener(EventoCalculadora);
		panelTeclado.add(CE);
		
		N7 = new JButton("7");
		N7.setToolTipText("7");
		N7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N7.setBackground(new Color(32, 178, 170));
		N7.addActionListener(EventoCalculadora);
		
		NumeroSinal = new JButton("+/-");
		NumeroSinal.setToolTipText("Troca o sinal no numero");
		NumeroSinal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NumeroSinal.setBackground(new Color(143, 188, 143));
		NumeroSinal.addActionListener(EventoCalculadora);
		panelTeclado.add(NumeroSinal);
		panelTeclado.add(N7);
		
		N9 = new JButton("9");
		N9.setToolTipText("9");
		N9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N9.setBackground(new Color(32, 178, 170));
		N9.addActionListener(EventoCalculadora);
		
		N8 = new JButton("8");
		N8.setToolTipText("8");
		N8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N8.setBackground(new Color(32, 178, 170));
		N8.addActionListener(EventoCalculadora);
		panelTeclado.add(N8);
		panelTeclado.add(N9);
		
		Divisao = new JButton("/");
		Divisao.setToolTipText("Divis\u00E3o");
		Divisao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Divisao.setBackground(new Color(143, 188, 143));
		Divisao.addActionListener(EventoCalculadora);
		panelTeclado.add(Divisao);
		
		N4 = new JButton("4");
		N4.setToolTipText("4");
		N4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N4.setBackground(new Color(32, 178, 170));
		N4.addActionListener(EventoCalculadora);
		panelTeclado.add(N4);
		
		
		N5 = new JButton("5");
		N5.setToolTipText("5");
		N5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N5.setBackground(new Color(32, 178, 170));
		N5.addActionListener(EventoCalculadora);
		panelTeclado.add(N5);
		
		Multiplicacao = new JButton("x");
		Multiplicacao.setToolTipText("Multiplica\u00E7\u00E3o");
		Multiplicacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Multiplicacao.setBackground(new Color(143, 188, 143));
		Multiplicacao.addActionListener(EventoCalculadora);
		
		N6 = new JButton("6");
		N6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N6.setBackground(new Color(32, 178, 170));
		N6.addActionListener(EventoCalculadora);
		panelTeclado.add(N6);
		panelTeclado.add(Multiplicacao);
		
		N3 = new JButton("3");
		N3.setToolTipText("3");
		N3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N3.setBackground(new Color(32, 178, 170));
		N3.addActionListener(EventoCalculadora);
		panelTeclado.add(N3);
		
		N1 = new JButton("1");
		N1.setToolTipText("1");
		N1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N1.setBackground(new Color(32, 178, 170));
		N1.addActionListener(EventoCalculadora);
		
		N2 = new JButton("2");
		N2.setToolTipText("2");
		N2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N2.setBackground(new Color(32, 178, 170));
		N2.addActionListener(EventoCalculadora);
		panelTeclado.add(N2);
		panelTeclado.add(N1);
		
		Subtracao = new JButton("-");
		Subtracao.setToolTipText("Subtra\u00E7\u00E3o");
		Subtracao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Subtracao.setBackground(new Color(143, 188, 143));
		Subtracao.addActionListener(EventoCalculadora);
		panelTeclado.add(Subtracao);
		
		N0 = new JButton("0");
		N0.setToolTipText("0");
		N0.setFont(new Font("Tahoma", Font.PLAIN, 15));
		N0.setBackground(new Color(32, 178, 170));
		N0.addActionListener(EventoCalculadora);
		panelTeclado.add(N0);
				
		Virgula = new JButton(".");
		Virgula.setToolTipText("Ponto");
		Virgula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Virgula.setBackground(new Color(32, 178, 170));
		Virgula.addActionListener(EventoCalculadora);
		panelTeclado.add(Virgula);
		
		Adicao = new JButton("+");
		Adicao.setToolTipText("Adi\u00E7\u00E3o");
		Adicao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Adicao.setBackground(new Color(143, 188, 143));
		Adicao.addActionListener(EventoCalculadora);
		
		Porcentagem = new JButton("%");
		Porcentagem.setToolTipText("Porcentagem");
		Porcentagem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Porcentagem.setBackground(new Color(32, 178, 170));
		Porcentagem.addActionListener(EventoCalculadora);
		panelTeclado.add(Porcentagem);
		panelTeclado.add(Adicao);
		
		Raiz = new JButton("Raiz");
		Raiz.setToolTipText("Raiz quadrada");
		Raiz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Raiz.setBackground(new Color(32, 178, 170));
		Raiz.addActionListener(EventoCalculadora);
		panelTeclado.add(Raiz);
		
		Potencia2 = new JButton("N^2");
		Potencia2.setToolTipText("Potencia de 2");
		Potencia2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Potencia2.setBackground(new Color(32, 178, 170));
		Potencia2.addActionListener(EventoCalculadora);
		panelTeclado.add(Potencia2);
		
		Potencia3 = new JButton("N^3");
		Potencia3.setToolTipText("Potencia de 3");
		Potencia3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Potencia3.setBackground(new Color(32, 178, 170));
		Potencia3.addActionListener(EventoCalculadora);
		panelTeclado.add(Potencia3);
		
		Igual = new JButton("=");
		Igual.setToolTipText("Igual");
		Igual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Igual.setBackground(new Color(143, 188, 143));
		Igual.addActionListener(EventoCalculadora);
		panelTeclado.add(Igual);
		
		/*Calculadora de medidas*/
		panelCalculadoraMedidas = new JPanel();
		tabbedPaneCalculadora.addTab("Calculadora de medidas", null, panelCalculadoraMedidas, null);
		panelCalculadoraMedidas.setLayout(new BorderLayout(0, 0));
		
		panelMedidaVisor = new JPanel();
		panelCalculadoraMedidas.add(panelMedidaVisor, BorderLayout.CENTER);
		panelMedidaVisor.setLayout(new GridLayout(2, 1, 0, 10));
		
		panelMedidaValores = new JPanel();
		panelMedidaVisor.add(panelMedidaValores);
		panelMedidaValores.setLayout(new GridLayout(0, 1, 0, 5));
		
		panelMedidaValorEntrada = new JPanel();
		panelMedidaValorEntrada.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelMedidaValores.add(panelMedidaValorEntrada);
		panelMedidaValorEntrada.setLayout(new GridLayout(0, 1, 0, 0));
		
		labelMedidaValorEntrada = new JLabel("Valor de entrada");
		labelMedidaValorEntrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelMedidaValorEntrada.add(labelMedidaValorEntrada);
		
		panelMedidaValorEntrada2 = new JPanel();
		panelMedidaValorEntrada.add(panelMedidaValorEntrada2);
		panelMedidaValorEntrada2.setLayout(new BorderLayout(10, 0));
		
		valorEntrada = new JLabel("0");
		panelMedidaValorEntrada2.add(valorEntrada);
		valorEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		valorEntrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		comboBoxValorEntrada = new JComboBox<String>();
		comboBoxValorEntrada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxValorEntrada.addItem("Selecione");
		panelMedidaValorEntrada2.add(comboBoxValorEntrada, BorderLayout.EAST);
		
		panelMedidaValorResultado = new JPanel();
		panelMedidaValorResultado.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelMedidaValores.add(panelMedidaValorResultado);
		panelMedidaValorResultado.setLayout(new GridLayout(0, 1, 0, 0));
		
		labelMedidaValorResultado = new JLabel("Resultado");
		panelMedidaValorResultado.add(labelMedidaValorResultado);
		labelMedidaValorResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panelMedidaValorResultado2 = new JPanel();
		panelMedidaValorResultado.add(panelMedidaValorResultado2);
		panelMedidaValorResultado2.setLayout(new BorderLayout(10, 0));
		
		valorResultado = new JLabel("0");
		panelMedidaValorResultado2.add(valorResultado);
		valorResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		valorResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		comboBoxValorResultado = new JComboBox<String>();
		comboBoxValorResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxValorResultado.addItem("Selecione");
		panelMedidaValorResultado2.add(comboBoxValorResultado, BorderLayout.EAST);
		
		panelMedidaBotoes = new JPanel();
		panelMedidaVisor.add(panelMedidaBotoes);
		panelMedidaBotoes.setLayout(new GridLayout(0, 1, 0, 5));
		
		panelTipoMedida = new JPanel();
		panelMedidaBotoes.add(panelTipoMedida);
		panelTipoMedida.setLayout(new GridLayout(0, 3, 0, 0));
		
		labelMedidaTipo = new JLabel("Tipo de medida");
		labelMedidaTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelTipoMedida.add(labelMedidaTipo);
		
		radioTamanho = new JRadioButton("Tamanho");
		radioTamanho.addItemListener(EventoRadioButton);
		buttonGroupMedidaTipo.add(radioTamanho);
		radioTamanho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelTipoMedida.add(radioTamanho);
		
		radioPeso = new JRadioButton("Peso");
		radioPeso.addItemListener(EventoRadioButton);
		buttonGroupMedidaTipo.add(radioPeso);
		radioPeso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelTipoMedida.add(radioPeso);
		
		panelBotoes1 = new JPanel();
		panelMedidaBotoes.add(panelBotoes1);
		panelBotoes1.setLayout(new GridLayout(0, 4, 5, 0));
		
		medidaSair = new JButton("Sair");
		medidaSair.setToolTipText("Fecha a janela");
		medidaSair.setBackground(new Color(135, 206, 235));
		medidaSair.addActionListener(EventoCalculadoraMedidas);
		panelBotoes1.add(medidaSair);
		medidaSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		medidaCalcular = new JButton("Calcular");
		medidaCalcular.setToolTipText("Calcula o numero");
		medidaCalcular.setBackground(new Color(135, 206, 235));
		medidaCalcular.addActionListener(EventoCalculadoraMedidas);
		panelBotoes1.add(medidaCalcular);
		medidaCalcular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		medidaApagar = new JButton("Apagar");
		medidaApagar.setToolTipText("Apaga o(s) valore(s) da tela da calculadora");
		medidaApagar.addActionListener(EventoCalculadoraMedidas);
		panelBotoes1.add(medidaApagar);
		medidaApagar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaApagar.setBackground(new Color(135, 206, 235));
		
		medidaCE = new JButton("CE");
		medidaCE.setToolTipText("Zera o valor da tela da calculadora");
		medidaCE.addActionListener(EventoCalculadoraMedidas);
		panelBotoes1.add(medidaCE);
		medidaCE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaCE.setBackground(new Color(135, 206, 235));
		
		panelBotoes2 = new JPanel();
		panelMedidaBotoes.add(panelBotoes2);
		panelBotoes2.setLayout(new GridLayout(0, 5, 5, 0));
		
		medidaN9 = new JButton("9");
		medidaN9.setToolTipText("9");
		medidaN9.addActionListener(EventoCalculadoraMedidas);
		
		medidaN5 = new JButton("5");
		medidaN5.setToolTipText("5");
		medidaN5.addActionListener(EventoCalculadoraMedidas);
		medidaN5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaN5.setBackground(new Color(32, 178, 170));
		panelBotoes2.add(medidaN5);
		
		medidaN6 = new JButton("6");
		medidaN6.setToolTipText("6");
		medidaN6.addActionListener(EventoCalculadoraMedidas);
		medidaN6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaN6.setBackground(new Color(32, 178, 170));
		panelBotoes2.add(medidaN6);
		
		medidaN7 = new JButton("7");
		medidaN7.setToolTipText("7");
		medidaN7.addActionListener(EventoCalculadoraMedidas);
		medidaN7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaN7.setBackground(new Color(32, 178, 170));
		panelBotoes2.add(medidaN7);
		
		medidaN8 = new JButton("8");
		medidaN8.setToolTipText("8");
		medidaN8.addActionListener(EventoCalculadoraMedidas);
		medidaN8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaN8.setBackground(new Color(32, 178, 170));
		panelBotoes2.add(medidaN8);
		
		medidaN9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaN9.setBackground(new Color(32, 178, 170));
		panelBotoes2.add(medidaN9);
		
		panelBotoes3 = new JPanel();
		panelMedidaBotoes.add(panelBotoes3);
		panelBotoes3.setLayout(new GridLayout(0, 6, 5, 0));
		
		medidaN4 = new JButton("4");
		medidaN4.setToolTipText("4");
		medidaN4.addActionListener(EventoCalculadoraMedidas);
		
		medidaN0 = new JButton("0");
		medidaN0.setToolTipText("0");
		medidaN0.addActionListener(EventoCalculadoraMedidas);
		
		medidaPonto = new JButton(".");
		medidaPonto.setToolTipText("Ponto");
		medidaPonto.addActionListener(EventoCalculadoraMedidas);
		medidaPonto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaPonto.setBackground(new Color(32, 178, 170));
		panelBotoes3.add(medidaPonto);
		
		panelBotoes3.add(medidaN0);
		medidaN0.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaN0.setBackground(new Color(32, 178, 170));
		
		medidaN1 = new JButton("1");
		medidaN1.setToolTipText("1");
		medidaN1.addActionListener(EventoCalculadoraMedidas);
		panelBotoes3.add(medidaN1);
		medidaN1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaN1.setBackground(new Color(32, 178, 170));
		
		medidaN2 = new JButton("2");
		medidaN2.setToolTipText("2");
		medidaN2.addActionListener(EventoCalculadoraMedidas);
		panelBotoes3.add(medidaN2);
		medidaN2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaN2.setBackground(new Color(32, 178, 170));
		
		medidaN3 = new JButton("3");
		medidaN3.setToolTipText("3");
		medidaN3.addActionListener(EventoCalculadoraMedidas);
		panelBotoes3.add(medidaN3);
		medidaN3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaN3.setBackground(new Color(32, 178, 170));
		
		panelBotoes3.add(medidaN4);
		medidaN4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		medidaN4.setBackground(new Color(32, 178, 170));
		
		/*Ajuda da calculadora*/
		panelCalculadoraAjuda = new JPanel();
		tabbedPaneCalculadora.addTab("Ajuda", null, panelCalculadoraAjuda, null);
		panelCalculadoraAjuda.setLayout(new BorderLayout(0, 0));
		
		scrollPaneAjuda = new JScrollPane();
		scrollPaneAjuda.getVerticalScrollBar().setUnitIncrement(10);
		scrollPaneAjuda.getHorizontalScrollBar().setUnitIncrement(10);
		panelCalculadoraAjuda.add(scrollPaneAjuda, BorderLayout.CENTER);
		
		textPaneAjuda = new JTextPane();
		textPaneAjuda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPaneAjuda.setBackground(new Color(245, 245, 245));
		textPaneAjuda.setEditable(false);
		scrollPaneAjuda.setViewportView(textPaneAjuda);
		
		String ajudaCalculadorTexto = ExibeAjudaCalculadoraTexto();
		textPaneAjuda.setText(ajudaCalculadorTexto);
		
		panelAjudaBotoes = new JPanel();
		FlowLayout fl_panelAjudaBotoes = (FlowLayout) panelAjudaBotoes.getLayout();
		fl_panelAjudaBotoes.setAlignment(FlowLayout.RIGHT);
		panelCalculadoraAjuda.add(panelAjudaBotoes, BorderLayout.SOUTH);
		
		ajudaSair = new JButton("Sair");
		ajudaSair.setToolTipText("Fecha a janela");
		ajudaSair.setBackground(new Color(135, 206, 235));
		ajudaSair.addActionListener(EventoCalculadoraMedidas);
		ajudaSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelAjudaBotoes.add(ajudaSair);
	}
	
	/*Funções da calculadora*/
	public class FuncoesCalculadora implements ActionListener{
		public void actionPerformed(ActionEvent Evento) {
			
			if(Evento.getSource() == N1){
            	if(zerar == 1)
            		xx = "";
            	if(xx.equals("0"))
            		xx = "";
            	xx = xx + "1";
            	zerar = 0;
            }
            
            else if(Evento.getSource() == N2){
            	if(zerar == 1)
            		xx = "";
            	
            	if(xx.equals("0"))
            		xx = "";
            	
            	xx = xx +"2";
            	zerar = 0;
            }
            
            else if(Evento.getSource() == N3){
            	if(zerar == 1)
            		xx = "";
            	
            	if(xx.equals("0"))xx = "";
            	xx = xx +"3";zerar = 0;
            }
            
            else if(Evento.getSource() == N4){
            	if(zerar == 1)
            		xx = "";
            	if(xx.equals("0"))
            		xx = "";
            	xx = xx +"4";
            	zerar = 0;
            }
            
            else if(Evento.getSource() == N5){
            	if(zerar == 1)
            		xx = "";
            	if(xx.equals("0"))
            		xx = "";
            	xx = xx +"5";
            	zerar = 0;
            }
            
            else if(Evento.getSource() == N6){
            	if(zerar == 1)
            		xx = "";
            	if(xx.equals("0"))
            		xx = "";
            	xx = xx +"6";
            	zerar = 0;
            }
            
            else if(Evento.getSource() == N7){
            	if(zerar == 1)
            		xx = "";
            	if(xx.equals("0"))
            		xx = "";
            	xx = xx +"7";
            	zerar = 0;
            }
            
            else if(Evento.getSource() == N8){
            	if(zerar == 1)
            		xx = "";
            	if(xx.equals("0"))
            		xx = "";
            	xx = xx +"8";
            	zerar = 0;
            }
            
            else if(Evento.getSource() == N9){
            	if(zerar == 1)
            		xx = "";
            	if(xx.equals("0"))
            		xx = "";
            	xx = xx +"9";
            	zerar = 0;
            }
            
            else if(Evento.getSource() == N0){
            	if(zerar == 1)
            		xx = "";
            	if(xx.equals("0"))
            		xx = "";
            	xx = xx +"0";
            	zerar = 0;
            }
            
            else if(Evento.getSource() == Virgula){
            	Achou = 0;
            	if(zerar == 1)
            		xx = "";
            	for (int i=0; i<xx.length(); ++i)
            		if (xx.charAt(i) == '.') 
            			Achou=1;
                    if (xx.equals("")) 
                    	xx = xx + "0.";
                else if (Achou == 0) 
                    xx = xx + ".";
                zerar = 0;
            }
			
            else if(Evento.getSource() == Adicao){
            	xa = Double.parseDouble(Visor.getText());
            	op = '+';
            	zerar = 1;
            }
            
            else if(Evento.getSource() == Subtracao){
            	xa = Double.parseDouble(Visor.getText());
            	op = '-';
            	zerar = 1;
            }
            
            else if(Evento.getSource() == Divisao){
            	xa = Double.parseDouble(Visor.getText());
            	op = '/';
            	zerar = 1;
            }
            
            else if(Evento.getSource() == Multiplicacao){
            	xa = Double.parseDouble(Visor.getText());
            	op = '*';
            	zerar = 1;
            }
            
            else if(Evento.getSource() == Igual){
            	xb = Double.parseDouble(Visor.getText());
                switch(op){
                    case 'n':
                        xr = xb;
                        break;
                    
                    case '+':
                        xr = xa + xb;
                        break;
                    	
                    case '-': 
                        xr = xa - xb;
                        break;
                    
                    case '*':
                        xr = xa * xb;
                        break;
                    
                    case '/':
                    	if(xb == 0){
                    		JOptionPane.showMessageDialog(null,"Impossivel dividir por 0");
                        }
                        else{
                        	xr = xa / xb;
                        }
                        break;
                    
                    case '^':
                    	xr = Math.pow(xa, xb);
                    	break;
                    
                    case 'r':
                    	xr = Math.pow (xa, 1.0 / xb);
                        break;
                    
                    case '!':
                    	num=(int)xb; 
                        long txx = 1;
                        for (int i = 2; i <= num; i++){
                        	txx = txx * i;
                        }
                        xr = txx;
                        break;
                    
                    case 'e':
                    	xr =(xa * (Math.pow(10, xb)));
                        break;
                    
                    case 'i':
                    	xr = (Math.abs (xa % xb));
                        break;
                    
                    case 'j':
                    	xr =(Math.sqrt((Math.pow(xa, 2))+(Math.pow(xb, 2))));
                        break;
                 }    
                 xx = String.valueOf(xr);zerar = 1;
            }
			
            else if(Evento.getSource() == NumeroSinal){
            	xx=String.valueOf((Double.parseDouble(xx))*(-1));
            }
			
            else if(Evento.getSource() ==Porcentagem){
            	xx=String.valueOf((Double.parseDouble(xx))/100);
            }
			
            else if(Evento.getSource() == Potencia2){
            	xx = String.valueOf(Math.pow(Double.parseDouble(xx) , 2));
            	zerar = 1;
            }
			
            else if(Evento.getSource() == Potencia3){
            	xx = String.valueOf(Math.pow(Double.parseDouble(xx) , 3));
            	zerar = 1;
            }
			
            else if(Evento.getSource() == Raiz){
            	xx = String.valueOf(Math.sqrt(Double.parseDouble(xx)));
            	zerar = 1;
            }
			
            else if(Evento.getSource() == CE){
            	xx="0.0";
            	zerar = 1;
            }
            
            else if(Evento.getSource() == Apagar){
            	if (xx.length()  > 1) 
            		xx = xx.substring(0, xx.length()-1);
            	else{
            		xx = "0.0"; 
            		zerar = 1;
            	}
            }
			
            else if(Evento.getSource() == Sair){
            	setVisible(false);
            }
			
			Visor.setText("" + xx);
			
		}
	}
	
	/*Funções da calculadora de medidas*/
	public class FuncoesCalculadoraMedidas implements ActionListener{
		public void actionPerformed(ActionEvent Evento) {
			
			if(Evento.getSource() == medidaN1){
            	if(zerarMedida == 1)
            		yy = "";
            	if(yy.equals("0"))
            		yy = "";
            	yy = yy + "1";
            	zerarMedida = 0;
            }
            
            else if(Evento.getSource() == medidaN2){
            	if(zerarMedida == 1)
            		yy = "";
            	
            	if(yy.equals("0"))
            		yy = "";
            	
            	yy = yy +"2";
            	zerarMedida = 0;
            }
            
            else if(Evento.getSource() == medidaN3){
            	if(zerarMedida == 1)
            		yy = "";
            	
            	if(yy.equals("0"))
            		yy = "";
            	yy = yy +"3";
            	zerarMedida = 0;
            }
            
            else if(Evento.getSource() == medidaN4){
            	if(zerarMedida == 1)
            		yy = "";
            	if(yy.equals("0"))
            		yy = "";
            	yy = yy +"4";
            	zerarMedida = 0;
            }
            
            else if(Evento.getSource() == medidaN5){
            	if(zerarMedida == 1)
            		yy = "";
            	if(yy.equals("0"))
            		yy = "";
            	yy = yy +"5";
            	zerarMedida = 0;
            }
            
            else if(Evento.getSource() == medidaN6){
            	if(zerarMedida == 1)
            		yy = "";
            	if(yy.equals("0"))
            		yy = "";
            	yy = yy +"6";
            	zerarMedida = 0;
            }
            
            else if(Evento.getSource() == medidaN7){
            	if(zerarMedida == 1)
            		yy = "";
            	if(yy.equals("0"))
            		yy = "";
            	yy = yy +"7";
            	zerarMedida = 0;
            }
            
            else if(Evento.getSource() == medidaN8){
            	if(zerarMedida == 1)
            		yy = "";
            	if(yy.equals("0"))
            		yy = "";
            	yy = yy +"8";
            	zerarMedida = 0;
            }
            
            else if(Evento.getSource() == medidaN9){
            	if(zerarMedida == 1)
            		yy = "";
            	if(yy.equals("0"))
            		yy = "";
            	yy = yy +"9";
            	zerarMedida = 0;
            }
            
            else if(Evento.getSource() == medidaN0){
            	if(zerarMedida == 1)
            		yy = "";
            	if(yy.equals("0"))
            		yy = "";
            	yy = yy +"0";
            	zerarMedida = 0;
            }
            
            else if(Evento.getSource() == medidaPonto){
            	AchouMedida = 0;
            	if(zerarMedida == 1)
            		yy = "";
            	for (int i=0; i<yy.length(); ++i)
            		if (yy.charAt(i) == '.') 
            			AchouMedida=1;
                    if (yy.equals("")) 
                    	yy = yy + "0.";
                else if (AchouMedida == 0) 
                	yy = yy + ".";
                zerarMedida = 0;
            }
			
            else if(Evento.getSource() == medidaCalcular){
            	yb = Double.parseDouble(valorEntrada.getText());
                unidadeEntrada = (String) comboBoxValorEntrada.getSelectedItem();
                unidadeResultado = (String) comboBoxValorResultado.getSelectedItem();
                
                if (buttonGroupMedidaTipo.getSelection() == null) {
                	String menssagemTitulo = "Nenhum tipo de medida selecionado";
 					String menssagemConteudo = "Selecione um tipo de medida";
 					Tela_que_Exibe_Menssagem menssagemSelecionarTipoMedida =  new Tela_que_Exibe_Menssagem(menssagemTitulo, menssagemConteudo);
 					menssagemSelecionarTipoMedida.setVisible(true);
				}
                else {
                	 if (radioTamanho.isSelected() == true) {
                     	if (unidadeEntrada.equals("Selecione") || unidadeResultado.equals("Selecione")) {
                     		String menssagemTitulo = "Unidade de medida não selecionada";
         					String menssagemConteudo = "Selecione uma unidade de medida";
         					Tela_que_Exibe_Menssagem menssagemSelecionarTipoMedida =  new Tela_que_Exibe_Menssagem(menssagemTitulo, menssagemConteudo);
         					menssagemSelecionarTipoMedida.setVisible(true);
     					}
                     	else {
                     		if (unidadeEntrada.equals("m")) {
                     			if (unidadeResultado.equals("polegada(s)")) {
                                  	yr = (yb/2.54) * 100;
                  				}
                     			else if (unidadeResultado.equals("mm")) {
                                  	yr = yb * 1000;
                  				}
                     			else if (unidadeResultado.equals("cm")) {
                                  	yr = yb * 100;
                  				}
                     			else if (unidadeResultado.equals("m")) {
                             		yr = yb;
             					}
                     			else if (unidadeResultado.equals("km")) {
                                  	yr = yb/1000;
                  				}
             				}
                            
                             
                            if (unidadeEntrada.equals("cm")) {
                            	if (unidadeResultado.equals("polegada(s)")) {
                                  	yr = yb / 2.54;
                  				}
                            	else if (unidadeResultado.equals("mm")) {
                                 	yr = yb * 10;
                 				}
                            	else if (unidadeResultado.equals("cm")) {
                                 	yr = yb;
                 				}
                                else if (unidadeResultado.equals("m")) {
                             		yr = yb/100;
             					}
                                else if (unidadeResultado.equals("km")) {
                                 	yr = yb/100000;
                 				}
             				}
                            
                            
                            if (unidadeEntrada.equals("mm")) {
                            	if (unidadeResultado.equals("polegada(s)")) {
                                  	yr = (yb / 2.54) * 10;
                  				}
                            	else if (unidadeResultado.equals("mm")) {
                                 	yr = yb;
                 				}
                             	else if (unidadeResultado.equals("cm")) {
                                 	yr = yb / 10;
                 				}
                                else if (unidadeResultado.equals("m")) {
                             		yr = yb / 1000;
             					}
                                else if (unidadeResultado.equals("km")) {
                                 	yr = yb / 1000000;
                 				}
             				}
                            
                            
                            if (unidadeEntrada.equals("polegada(s)")) {
                            	if (unidadeResultado.equals("polegada(s)")) {
                                 	yr = yb;
                 				}
                            	else if (unidadeResultado.equals("mm")) {
                                 	yr = yb * 25.4;
                 				}
                             	else if (unidadeResultado.equals("cm")) {
                                 	yr = yb * 2.54;
                 				}
                                else if (unidadeResultado.equals("m")) {
                              		yr = (yb * 2.54)/100;
              					}
                                else if (unidadeResultado.equals("km")) {
                                 	yr = (yb * 2.54)/100000;
                 				}
             				}
                             
                             
                            if (unidadeEntrada.equals("km")) {
                            	if (unidadeResultado.equals("polegada(s)")) {
                                 	yr = (yb/2.54) * 100000;
                 				}
                            	else if (unidadeResultado.equals("mm")) {
                                 	yr = yb * 1000000;
                 				}
                            	else if (unidadeResultado.equals("cm")) {
                                 	yr = yb * 100000;
                 				}
                                else if (unidadeResultado.equals("m")) {
                             		yr = yb * 1000;
             					}
                                else if (unidadeResultado.equals("km")) {
                                 	yr = yb;
                 				}
             				}
     					}
     				}
                	 
                	 
	                if (radioPeso.isSelected()== true) {
	 					if (unidadeEntrada.equals("Selecione") || unidadeResultado.equals("Selecione")) {
	 						String menssagemTitulo = "Unidade de medida não selecionada";
	     					String menssagemConteudo = "Selecione uma unidade de medida";
	     					Tela_que_Exibe_Menssagem menssagemSelecionarTipoMedida =  new Tela_que_Exibe_Menssagem(menssagemTitulo, menssagemConteudo);
	     					menssagemSelecionarTipoMedida.setVisible(true);
	 					}
	 					else {
	 						if (unidadeEntrada.equals("g")) {
	 							if (unidadeResultado.equals("mg")) {
	 		                    	yr = yb*1000;
	 		    				}
	 							else if (unidadeResultado.equals("g")) {
	 		                		yr = yb;
	 							}
	 		                	else if (unidadeResultado.equals("kg")) {
	 		                    	yr = yb/1000;
	 		    				}
	 		                    else if (unidadeResultado.equals("tonelada(s)")) {
	 		                    	yr = yb/1000000;
	 		    				}
	 						}
	 		                
	 		                
	 		                if (unidadeEntrada.equals("mg")) {
	 		                	if (unidadeResultado.equals("mg")) {
	 		                    	yr = yb;
	 		    				}
	 		                	else if (unidadeResultado.equals("g")) {
	 		                		yr = yb/1000;
	 							}
	 		                	else if (unidadeResultado.equals("kg")) {
	 		                    	yr = yb/1000000;
	 		    				}
	 		                    else if (unidadeResultado.equals("tonelada(s)")) {
	 		                    	yr = yb/1000000000;
	 		    				}
	 						}
	 		                
	 		                
	 		                if (unidadeEntrada.equals("kg")) {
	 		                	if (unidadeResultado.equals("mg")) {
	 		                    	yr = yb*1000000;
	 		    				}
	 		                	else if (unidadeResultado.equals("g")) {
	 		                		yr = yb*1000;
	 							}
	 		                	else if (unidadeResultado.equals("kg")) {
	 		                    	yr = yb;
	 		    				}
	 		                    else if (unidadeResultado.equals("tonelada(s)")) {
	 		                    	yr = yb/1000;
	 		    				}
	 						}
	 		                
	 		                
	 		                if (unidadeEntrada.equals("tonelada(s)")) {
	 		                	if (unidadeResultado.equals("mg")) {
	 		                    	yr = yb*1000000000;
	 		    				}
	 		                	else if (unidadeResultado.equals("g")) {
	 		                		yr = yb*1000000;
	 							}
	 		                	else if (unidadeResultado.equals("kg")) {
	 		                    	yr = yb*1000;
	 		    				}
	 		                    else if (unidadeResultado.equals("tonelada(s)")) {
	 		                    	yr = yb;
	 		    				}
	 						}
	 					}
	 				}
	                yk = String.valueOf(yr);
	                yt = new BigDecimal(yk);
	                yz = String.valueOf(yt);
                    zerarMedida = 1;
				} 
            }
			
            else if(Evento.getSource() == medidaCE){
            	yy = "0";
            	yz = "0";
            	zerarMedida = 1;
            	comboBoxValorEntrada.setSelectedItem("Selecione");
            	comboBoxValorResultado.setSelectedItem("Selecione");
            }
            
            else if(Evento.getSource() == medidaApagar){
            	if (yy.length()  > 1) 
            		yy = yy.substring(0, yy.length()-1);
            	else{
            		yy = "0"; 
            		zerarMedida = 1;
            	}
            }
			
            else if(Evento.getSource() == medidaSair){
            	setVisible(false);
            }
			
            else if(Evento.getSource() == ajudaSair){
            	setVisible(false);
            }
			
			valorEntrada.setText("" + yy);
			valorResultado.setText("" + yz);
			
		}
	}
	
	public class RadioButtonEstado implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent eventoItem) {
			if (eventoItem.getStateChange() == ItemEvent.SELECTED) {
				if (radioTamanho.isSelected() == true) {
					
					comboBoxValorEntrada.removeItem("mg");
					comboBoxValorEntrada.removeItem("g");
					comboBoxValorEntrada.removeItem("kg");
					comboBoxValorEntrada.removeItem("tonelada(s)");
					
					comboBoxValorResultado.removeItem("mg");
					comboBoxValorResultado.removeItem("g");
					comboBoxValorResultado.removeItem("kg");
					comboBoxValorResultado.removeItem("tonelada(s)");
					
					comboBoxValorEntrada.addItem("polegada(s)");
					comboBoxValorEntrada.addItem("mm");
					comboBoxValorEntrada.addItem("cm");
					comboBoxValorEntrada.addItem("m");
					comboBoxValorEntrada.addItem("km");
					
					comboBoxValorResultado.addItem("polegada(s)");
					comboBoxValorResultado.addItem("mm");
					comboBoxValorResultado.addItem("cm");
					comboBoxValorResultado.addItem("m");
					comboBoxValorResultado.addItem("km");
					
				}
				else if (radioPeso.isSelected() == true) {
					
					comboBoxValorEntrada.removeItem("polegada(s)");
					comboBoxValorEntrada.removeItem("mm");
					comboBoxValorEntrada.removeItem("cm");
					comboBoxValorEntrada.removeItem("m");
					comboBoxValorEntrada.removeItem("km");
					
					comboBoxValorResultado.removeItem("polegada(s)");
					comboBoxValorResultado.removeItem("mm");
					comboBoxValorResultado.removeItem("cm");
					comboBoxValorResultado.removeItem("m");
					comboBoxValorResultado.removeItem("km");
					
					comboBoxValorEntrada.addItem("mg");
					comboBoxValorEntrada.addItem("g");
					comboBoxValorEntrada.addItem("kg");
					comboBoxValorEntrada.addItem("tonelada(s)");
					
					comboBoxValorResultado.addItem("mg");
					comboBoxValorResultado.addItem("g");
					comboBoxValorResultado.addItem("kg");
					comboBoxValorResultado.addItem("tonelada(s)");
					
				}
			}
		}
	}
	
	/*Metodo que exibe o texto de ajuda da calculadora*/
	private String ajudaCalculadoraTexto;
	private JPanel panelTitulo;
	private JLabel icone;
	private JPanel panelTitulo2;
	private JSeparator separator;
	public String ExibeAjudaCalculadoraTexto() {
		ajudaCalculadoraTexto = "Ajuda \r\n"
								+ "\r\n"
								+ "Calculadora - Botões: \r\n"
								+ "Botões numericos: [1], [2], [3], [4], [5], [6], [7], [8], [9], [0] \r\n"
								+ "[+]: Adição \r\n"
								+ "[-]: Subtração \r\n"
								+ "[/]: Divisão \r\n"
								+ "[*]: Multiplicação \r\n"
								+ "[=]: Igual \r\n"
								+ "[,]: Ponto \r\n"
								+ "[%]: Porcentagem, Exibe a porcentagem do numero \r\n"
								+ "[N^2]: Potencia de 2 ou quadrado \r\n"
								+ "[N^3]: Potencia de 3 ou cubo \r\n"
								+ "[Raiz]: Raiz quadrada \r\n"
								+ "[CE]: Limpa a tela da calculadora \r\n"
								+ "[Sair]: Fecha a calculadora \r\n"
								+ "[Apagar]: Apaga um ou mais numeros da tela \r\n"
								+ "[+/-]: Troca o sinal do numero, para positivo ou negativo \r\n"
								+ "\r\n"
								+ "\r\n"
								+ "-------------------------------------------------------------------------- \r\n"
								+ "Calculadora - Funções:\r\n"
								+ "\r\n"
								+ "Soma de numeros: numero [+] numero [=] Resultado. Exemplo: [5] [+] [5] [=] 10 \r\n"
								+ "\r\n"
								+ "Subtração de numeros: numero [-] numero [=] Resultado. Exemplo: [6] [-] [5] [=]  1 \r\n"
								+ "\r\n"
								+ "Multiplicação de numeros: numero [*] numero [=] Resultado. Exemplo: [10] [*] [8] [=] 80 \r\n"
								+ "\r\n"
								+ "Divisão de numeros: numero [/] numero [=] Resultado. Exemplo: [50] [/] [2] [=] 25 \r\n"
								+ "\r\n"
								+ "Porcentagem de um numero: numero [%] Resultado. Exemplo: [8] [%] Resultado: 0.08 \r\n"
								+ "\r\n"
								+ "Potencia 2 ou quadrado de um numero: numero [N^2] Resultado. Exemplo: [30] [N^2] Resultado: 900 \r\n"
								+ "\r\n"
								+ "Potencia 3 ou cubo de um numero: numero [N^3] Resultado. Exemplo: [2] [N^3] Resultado: 8 \r\n"
								+ "\r\n"
								+ "Raiz de um numero: numero [Raiz] Resultado. Exemplo: [81] [Raiz] Resultado: 9 \r\n"
								+ "\r\n"
								+ "Colocar ponto nos numeros: numero [.] numero. Exemplo: [1] [.] [9] , Resultado: 1.9.\r\n"
								+ "\r\n"
								+ "Apagar um ou mais numeros da tela: numero(s) [Apagar] Resultado. Exemplo: numero 15 na tela, [Apagar] pressionado, o 5 é apagado e o 1 continua na tela.\r\n"
								+ "\r\n"
								+ "Limpar a tela: [CE] é pressionado. Exemplo: numero 55 na tela, [CE] pressionado, o 55 é apagado da tela.\r\n"
								+ "\r\n"
								+ "Sair da tela: aperte [Sair].\r\n"
								+ "\r\n"
								+ "\r\n"
								+ "-------------------------------------------------------------------------- \r\n"
								+ "Calculadora de medidas - Botões e telas: \r\n"
								+ "\r\n"
								+ "Botões numericos: [1], [2], [3], [4], [5], [6], [7], [8], [9], [0] \r\n"
								+ "Tela de valor de entrada: Onde os numeros que serão convertidos são digitados. \r\n"
								+ "Tela de resultado: Onde os numeros que foram convertidos são exibidos. \r\n"
								+ "[Calcular]\r\n"
								+ "[.]: Ponto\r\n"
								+ "[Selecione]: Onde a unidade do numero é selecionada,"
								+ "Tamanho: m - metro, mm - milimetro, cm - centimetro, km - quilimetro e polegada(s) ou"
								+ "Peso: g - grama, mg - miligrama, kq - quilograma e tonelada(s)\r\n"
								+ "Tipo de medida: Onde qual tipo de medida é selecionada, Tamanho ou Peso. \r\n"
								+ "[CE]: Limpa a tela da calculadora \r\n"
								+ "[Sair]: Fecha a calculadora \r\n"
								+ "[Apagar]: Apaga um ou mais numeros da tela \r\n"
								+ "\r\n"
								+ "\r\n"
								+ "-------------------------------------------------------------------------- \r\n"
								+ "Calculadora de medidas - Funções: \r\n"
								+ "\r\n"
								+ "Conveter valores de tamanho ou peso:"
								+ "- Passo 1: Selecione o tipo de medida (Tamanho ou peso). \r\n"
								+ "- Passo 2: Digite algum numero de entrada. \r\n"
								+ "- Passo 3: Selecione a unidade do numero  de entrada atraves das caixas [Selecione] ao lado do numero. \r\n"
								+ "- Passo 4: Pressione [Calcular] e veja o resultado\r\n"
								+ "Exemplo: \r\n"
								+ "- Tipo de medida: Tamanho \r\n"
								+ "- Valor de entrada: 1 \r\n"
								+ "- Unidade do valor de entrada: m \r\n"
								+ "- Unidade do resultado: mm \r\n"
								+ "- Pressionar [Calcular] \r\n"
								+ "- Resultado obtido: 1000 mm \r\n"
								+ "Colocar ponto nos numeros: numero [.] numero. Exemplo: [1] [.] [9] , Resultado: 1.9.\r\n"
								+ "\r\n"
								+ "Apagar um ou mais numeros da tela: numero(s) [Apagar] Resultado. Exemplo: numero 15 na tela, [Apagar] pressionado, o 5 é apagado e o 1 continua na tela.\r\n"
								+ "\r\n"
								+ "Limpar a tela: [CE] é pressionado. Exemplo: numero 55 na tela, [CE] pressionado, o 55 é apagado da tela.\r\n"
								+ "\r\n"
								+ "Sair da tela: aperte [Sair].\r\n"
								+ "--------------------------------------------------------------------------";
		return ajudaCalculadoraTexto;
	}
}