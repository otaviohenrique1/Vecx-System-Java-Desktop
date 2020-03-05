package moduloFornecedorTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloFornecedoesProdutos extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<FornecedoresTabelaProdutos> listaFornecedoresProdutos;
    private String[] colunas = {"Codigo do produto","Nome do produto", "Preço de compra", "Data da primeira compra"};

    public TabelaModeloFornecedoesProdutos() {
        this.listaFornecedoresProdutos = new ArrayList<>();
    }
    
    public void addFornecedorProdutos(FornecedoresTabelaProdutos FornecedoresTabelaProdutosDados){
        this.listaFornecedoresProdutos.add(FornecedoresTabelaProdutosDados);
        fireTableDataChanged();
    }
    
    public FornecedoresTabelaProdutos getCompra(int rowIndex){
        return this.listaFornecedoresProdutos.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaFornecedoresProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaFornecedoresProdutos.get(rowIndex).getCodigoProduto();
            case 1:
                return this.listaFornecedoresProdutos.get(rowIndex).getNomeProduto();
            case 2:
                return this.listaFornecedoresProdutos.get(rowIndex).getPrecoCompra();
            case 3:
            	return this.listaFornecedoresProdutos.get(rowIndex).getDataPrimeiraCompra();
            default:
                return this.listaFornecedoresProdutos.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }	
}