package moduloFuncionarioTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;

public class TabelaModeloFuncionarios extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<FuncionariosTabela> listaFuncionarios;
    private String[] colunas = {"Codigo do funcionario", "Nome do funcionario","Cargo", "RG", "CPF"};

    public TabelaModeloFuncionarios() {
        this.listaFuncionarios = new ArrayList<>();
    }
    
    public void addFuncionario(FuncionariosTabela FuncionariosTabelaDados){
        this.listaFuncionarios.add(FuncionariosTabelaDados);
        fireTableDataChanged();
    }
    
    public void removerCompra(int rowIndex){
    	if(listaFuncionarios.size() == 0){
    		String menssagemConteudo = "Nenhum item selecionado";
			Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
			mensagemConfirmacao.setVisible(true);
        }
    	else {
    		this.listaFuncionarios.remove(rowIndex);
            fireTableDataChanged();
		}
    }
    
    public FuncionariosTabela getCompra(int rowIndex){
        return this.listaFuncionarios.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaFuncionarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaFuncionarios.get(rowIndex).getCodigoFuncionario();
            case 1:
                return this.listaFuncionarios.get(rowIndex).getNomeFuncionario();
            case 2:
                return this.listaFuncionarios.get(rowIndex).getCargo();
            case 3:
                return this.listaFuncionarios.get(rowIndex).getRGFuncionario();
            case 4:
                return this.listaFuncionarios.get(rowIndex).getCPFFuncionario();
            default:
                return this.listaFuncionarios.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}