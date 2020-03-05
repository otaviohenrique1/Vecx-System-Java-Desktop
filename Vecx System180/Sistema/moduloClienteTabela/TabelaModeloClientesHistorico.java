package moduloClienteTabela;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloClientesHistorico extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ClientesTabelaHistorico> listaClientesHistorico;
    private String[] colunas = {"Codigo da compra","Data e hora da compra","Preço total"};

    public TabelaModeloClientesHistorico() {
        this.listaClientesHistorico = new ArrayList<>();
    }
    
    public void addCompraHistorico(ClientesTabelaHistorico ClientesTabelaHistoricoDados){
        this.listaClientesHistorico.add(ClientesTabelaHistoricoDados);
        fireTableDataChanged();
    }
    
    public ClientesTabelaHistorico getCompra(int rowIndex){
        return this.listaClientesHistorico.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaClientesHistorico.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaClientesHistorico.get(rowIndex).getCodigoCompra();
            case 1:
                return this.listaClientesHistorico.get(rowIndex).getDataHoraCompra();
            case 2:
                return this.listaClientesHistorico.get(rowIndex).getPrecoTotal();
            default:
                return this.listaClientesHistorico.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}