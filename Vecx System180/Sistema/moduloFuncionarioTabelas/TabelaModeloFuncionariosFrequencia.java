package moduloFuncionarioTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloFuncionariosFrequencia extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<FuncionariosTabelaFaltas> listaFuncionariosFrequencia;
    private String[] colunas = {"Data do dia", "Hora do cadastro", "Frequencia"};

    public TabelaModeloFuncionariosFrequencia() {
        this.listaFuncionariosFrequencia = new ArrayList<>();
    }
    
    public void addFuncionarioFrequencia(FuncionariosTabelaFaltas FuncionariosTabelaFaltasDados){
        this.listaFuncionariosFrequencia.add(FuncionariosTabelaFaltasDados);
        fireTableDataChanged();
    }
    
    
    public FuncionariosTabelaFaltas getCompra(int rowIndex){
        return this.listaFuncionariosFrequencia.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaFuncionariosFrequencia.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaFuncionariosFrequencia.get(rowIndex).getData();
            case 1:
                return this.listaFuncionariosFrequencia.get(rowIndex).getHoraCadastro();
            case 2:
                return this.listaFuncionariosFrequencia.get(rowIndex).getFrequencia();
            default:
                return this.listaFuncionariosFrequencia.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}