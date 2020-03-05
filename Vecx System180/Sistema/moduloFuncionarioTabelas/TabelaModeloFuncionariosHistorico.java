package moduloFuncionarioTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloFuncionariosHistorico extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<FuncionariosTabelaFrequencia> listaFuncionariosFrequencia;
    private String[] colunas = {"Codigo","Nome do funcionario","Cargo","Maximo de faltas", "Presenças", "Faltas", "Turno", "Carga horaria"};

    public TabelaModeloFuncionariosHistorico() {
        this.listaFuncionariosFrequencia = new ArrayList<>();
    }
    
    public void addFuncionarioFrequencia(FuncionariosTabelaFrequencia FuncionariosTabelaFrequenciaDados){
        this.listaFuncionariosFrequencia.add(FuncionariosTabelaFrequenciaDados);
        fireTableDataChanged();
    }
    
    
    public FuncionariosTabelaFrequencia getCompra(int rowIndex){
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
                return this.listaFuncionariosFrequencia.get(rowIndex).getCodigoFuncionario();
            case 1:
                return this.listaFuncionariosFrequencia.get(rowIndex).getNomeFuncionario();
            case 2:
                return this.listaFuncionariosFrequencia.get(rowIndex).getCargoFuncionario();
            case 3:
                return this.listaFuncionariosFrequencia.get(rowIndex).getMaximoFaltas();
            case 4:
                return this.listaFuncionariosFrequencia.get(rowIndex).getPresencasValor();
            case 5:
                return this.listaFuncionariosFrequencia.get(rowIndex).getFaltasValor();
            case 6:
                return this.listaFuncionariosFrequencia.get(rowIndex).getTurnoHorario();
            case 7:
                return this.listaFuncionariosFrequencia.get(rowIndex).getCargaHoraria();
            default:
                return this.listaFuncionariosFrequencia.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}