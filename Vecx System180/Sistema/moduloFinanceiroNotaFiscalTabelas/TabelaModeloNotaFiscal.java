package moduloFinanceiroNotaFiscalTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloNotaFiscal extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<NotaFiscalTabela> listaNotaFiscal;
    private String[] colunas = {"Codigo nota fiscal","Codigo venda","Nome do cliente","Preço total","Data e hora da emissao"};

    public TabelaModeloNotaFiscal() {
        this.listaNotaFiscal = new ArrayList<>();
    }
    
    public void addNotaFiscal(NotaFiscalTabela NotaFiscalTabelaDados){
        this.listaNotaFiscal.add(NotaFiscalTabelaDados);
        fireTableDataChanged();
    }
    
    public void removerCompra(int rowIndex){
    		this.listaNotaFiscal.remove(rowIndex);
            fireTableDataChanged();
    }
    
    public NotaFiscalTabela getCompra(int rowIndex){
        return this.listaNotaFiscal.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaNotaFiscal.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
            	return this.listaNotaFiscal.get(rowIndex).getCodigoNotaFiscal();
            case 1:
            	return this.listaNotaFiscal.get(rowIndex).getCodigoCompra();
            case 2:
            	return this.listaNotaFiscal.get(rowIndex).getClienteNome();
            case 3:
                return this.listaNotaFiscal.get(rowIndex).getPrecoTotal();
            case 4:
                return this.listaNotaFiscal.get(rowIndex).getDataHoraEmissao();
            default:
                return this.listaNotaFiscal.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}