package moduloFinanceiroVendaTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloVenda extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<VendaTabela> listaCompras;
    private String[] colunas = {"Codigo do produto", "Nome do produto", "Quantidade", "Preço unitario", "Preço x Quantidade"};

    public TabelaModeloVenda() {
        this.listaCompras = new ArrayList<>();
    }
    
    public void addVenda(VendaTabela VendaTabelaDados){
        this.listaCompras.add(VendaTabelaDados);
        fireTableDataChanged();
    }
    
    public void removerVenda(int rowIndex){
        this.listaCompras.remove(rowIndex);
    	fireTableDataChanged();
    }
    
    public void cancelarVenda(){
    	this.listaCompras.clear();
        fireTableDataChanged();
    }
    
    public VendaTabela getVenda(int rowIndex){
        return this.listaCompras.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaCompras.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
            	return this.listaCompras.get(rowIndex).getCodigoProduto();
            case 1:
            	return this.listaCompras.get(rowIndex).getNomeProduto();
            case 2:
            	return this.listaCompras.get(rowIndex).getQuantidade();
            case 3:
            	return this.listaCompras.get(rowIndex).getPreco();
            case 4:
            	return this.listaCompras.get(rowIndex).getPrecoQuantidade();
            default:
                return this.listaCompras.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}