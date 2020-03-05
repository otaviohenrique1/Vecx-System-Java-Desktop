package moduloProdutoTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloCadastroProdutoFornecedor extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<CadastroProdutoFornecedorTabela> listaCadastroProdutoFornecedor;
    private String[] colunas = {"Nome do fornecedor", "CNPJ do fornecedor"};

    public TabelaModeloCadastroProdutoFornecedor() {
        this.listaCadastroProdutoFornecedor = new ArrayList<>();
    }
    
    public void addCadastroProdutoFornecedor(CadastroProdutoFornecedorTabela CadastroProdutoFornecedorTabelaDados){
        this.listaCadastroProdutoFornecedor.add(CadastroProdutoFornecedorTabelaDados);
        fireTableDataChanged();
    }
    
    public CadastroProdutoFornecedorTabela getCadastroProdutoFornecedor(int rowIndex){
        return this.listaCadastroProdutoFornecedor.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaCadastroProdutoFornecedor.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaCadastroProdutoFornecedor.get(rowIndex).getFornecedorNome();
            case 1:
                return this.listaCadastroProdutoFornecedor.get(rowIndex).getFornecedorCNPJ();
            default:
                return this.listaCadastroProdutoFornecedor.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}