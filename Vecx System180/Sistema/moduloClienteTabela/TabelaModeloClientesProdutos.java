package moduloClienteTabela;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloClientesProdutos extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ClientesTabelaProdutos> listaClientesProdutos;
    private String[] colunas = {"Codigo do produto","Nome do produto","Quantidade comprada","Preço unitario"};

    public TabelaModeloClientesProdutos() {
        this.listaClientesProdutos = new ArrayList<>();
    }
    
    public void addCompra(ClientesTabelaProdutos ClientesTabelaProdutosDados){
        this.listaClientesProdutos.add(ClientesTabelaProdutosDados);
        fireTableDataChanged();
    }
    
    public ClientesTabelaProdutos getCompra(int rowIndex){
        return this.listaClientesProdutos.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaClientesProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaClientesProdutos.get(rowIndex).getCodigoProduto();
            case 1:
                return this.listaClientesProdutos.get(rowIndex).getNomeProduto();
            case 2:
                return this.listaClientesProdutos.get(rowIndex).getQuantidadeComprada();
            case 3:
                return this.listaClientesProdutos.get(rowIndex).getPrecoUnitario();
            default:
                return this.listaClientesProdutos.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}