package moduloFinanceiroVendaTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloVendaProdutosLista extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<VendaListaTabela> listaVendasProdutos;
    private String[] colunas = {"Codigo do produto", "Nome do produto","Quantidade","Preço unitario", "Preço x Quantidade"};

    public TabelaModeloVendaProdutosLista() {
        this.listaVendasProdutos = new ArrayList<>();
    }
    
    public void addVendaProdutosLista(VendaListaTabela ListaVendaTabelaDados){
        this.listaVendasProdutos.add(ListaVendaTabelaDados);
        fireTableDataChanged();
    }
    
    public void removerVenda(int rowIndex){
        this.listaVendasProdutos.remove(rowIndex);
    	fireTableDataChanged();
    }
    
    public void cancelarVenda(){
    	this.listaVendasProdutos.clear();
        fireTableDataChanged();
    }
    
    public VendaListaTabela getVenda(int rowIndex){
        return this.listaVendasProdutos.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaVendasProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        	case 0:
        		return this.listaVendasProdutos.get(rowIndex).getCodigo();
        	case 1:
                return this.listaVendasProdutos.get(rowIndex).getNome();
            case 2:
                return this.listaVendasProdutos.get(rowIndex).getQuantidade();
            case 3:
                return this.listaVendasProdutos.get(rowIndex).getPreco();
            case 4:
                return this.listaVendasProdutos.get(rowIndex).getPrecoQuantidade();
            default:
                return this.listaVendasProdutos.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}