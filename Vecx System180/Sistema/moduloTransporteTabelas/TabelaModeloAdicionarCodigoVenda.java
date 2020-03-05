package moduloTransporteTabelas;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TabelaModeloAdicionarCodigoVenda extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<AdicionarCodigoVendaTabela> listaAdicionarCodigoVenda;
    private String[] colunas = {"Codigo da venda","Nome do cliente","Preço total","Data e hora da venda"};

    public TabelaModeloAdicionarCodigoVenda() {
        this.listaAdicionarCodigoVenda = new ArrayList<>();
    }
    
    public void addAdicionarCodigoVenda(AdicionarCodigoVendaTabela AdicionarCodigoVendaTabelaDados){
        this.listaAdicionarCodigoVenda.add(AdicionarCodigoVendaTabelaDados);
        fireTableDataChanged();
    }
    
    public AdicionarCodigoVendaTabela getCompra(int rowIndex){
        return this.listaAdicionarCodigoVenda.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaAdicionarCodigoVenda.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaAdicionarCodigoVenda.get(rowIndex).getCodigoVenda();
            case 1:
                return this.listaAdicionarCodigoVenda.get(rowIndex).getNomeCliente();
            case 2:
            	return this.listaAdicionarCodigoVenda.get(rowIndex).getPrecoTotal();
            case 3:
            	return this.listaAdicionarCodigoVenda.get(rowIndex).getDataHoraVenda();
            default:
                return this.listaAdicionarCodigoVenda.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}