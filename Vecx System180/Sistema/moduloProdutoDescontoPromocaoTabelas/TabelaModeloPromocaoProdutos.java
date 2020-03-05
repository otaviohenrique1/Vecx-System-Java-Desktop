package moduloProdutoDescontoPromocaoTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloPromocaoProdutos extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<PromocaoProdutosTabela> listaPromocaoProdutos;
    private String[] colunas = {"Codigo do produto", "Nome do produto", "Preço normal", "Desconto", "Preço com desconto"};

    public TabelaModeloPromocaoProdutos() {
        this.listaPromocaoProdutos = new ArrayList<>();
    }
    
    public void addPromocaoProdutos(PromocaoProdutosTabela PromocaoProdutosTabelaDados){
        this.listaPromocaoProdutos.add(PromocaoProdutosTabelaDados);
        fireTableDataChanged();
    }
    
    public void removerPromocaoProdutos(int rowIndex){
        this.listaPromocaoProdutos.remove(rowIndex);
    	fireTableDataChanged();
    }
    
    public PromocaoProdutosTabela getPromocaoProdutos(int rowIndex){
        return this.listaPromocaoProdutos.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaPromocaoProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        	case 0:
        		return this.listaPromocaoProdutos.get(rowIndex).getCodigoProduto();
            case 1:
                return this.listaPromocaoProdutos.get(rowIndex).getNomeProduto();
            case 2:
                return this.listaPromocaoProdutos.get(rowIndex).getPrecoNormal();
            case 3:
                return this.listaPromocaoProdutos.get(rowIndex).getDescontoPorcentagem();
            case 4:
            	return this.listaPromocaoProdutos.get(rowIndex).getPrecoDesconto();
            default:
                return this.listaPromocaoProdutos.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	
    	return super.isCellEditable(rowIndex, columnIndex);
    }
}