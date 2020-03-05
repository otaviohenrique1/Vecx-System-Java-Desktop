package moduloFinanceiroCompraTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloHistoricoCompra extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<HistoricoCompraTabela> listaHistoricoCompra;
    private String[] colunas = {"Codigo da compra","Nome do funcionario", "Data e hora da venda","Preço total"};

    public TabelaModeloHistoricoCompra() {
        this.listaHistoricoCompra = new ArrayList<>();
    }
    
    public void addHistoricoCompra(HistoricoCompraTabela HistoricoCompraTabelaDados){
        this.listaHistoricoCompra.add(HistoricoCompraTabelaDados);
        fireTableDataChanged();
    }
    
    public HistoricoCompraTabela getCompra(int rowIndex){
        return this.listaHistoricoCompra.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaHistoricoCompra.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaHistoricoCompra.get(rowIndex).getCodigoCompra();
            case 1:
                return this.listaHistoricoCompra.get(rowIndex).getNomeFuncionario();
            case 2:
                return this.listaHistoricoCompra.get(rowIndex).getDataHoraCompra();
            case 3:
                return this.listaHistoricoCompra.get(rowIndex).getPrecoTotal();
            default:
                return this.listaHistoricoCompra.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}