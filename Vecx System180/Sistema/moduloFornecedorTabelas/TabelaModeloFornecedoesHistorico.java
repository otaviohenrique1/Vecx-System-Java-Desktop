package moduloFornecedorTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloFornecedoesHistorico extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<FornecedoresTabelaHistorico> listaFornecedoresHistorico;
    private String[] colunas = {"Codigo do produto", "Nome do produto", "Codigo da compra","Data e hora da compra","Preço unitario", "Quantidade", "Preço x Quantidade"};

    public TabelaModeloFornecedoesHistorico() {
        this.listaFornecedoresHistorico = new ArrayList<>();
    }
    
    public void addFornecedorHistorico(FornecedoresTabelaHistorico FornecedoresTabelaHistoricoDados){
        this.listaFornecedoresHistorico.add(FornecedoresTabelaHistoricoDados);
        fireTableDataChanged();
    }
    
    public FornecedoresTabelaHistorico getCompra(int rowIndex){
        return this.listaFornecedoresHistorico.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaFornecedoresHistorico.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        	case 0:
        		return this.listaFornecedoresHistorico.get(rowIndex).getCodigoProduto();
        	case 1:
                return this.listaFornecedoresHistorico.get(rowIndex).getNomeProduto();
        	case 2:
                return this.listaFornecedoresHistorico.get(rowIndex).getCodigoCompra();
            case 3:
                return this.listaFornecedoresHistorico.get(rowIndex).getDataHoraCompra();
            case 4:
                return this.listaFornecedoresHistorico.get(rowIndex).getPrecoUnitario();
            case 5:
                return this.listaFornecedoresHistorico.get(rowIndex).getQuantidadeProduto();
            case 6:
                return this.listaFornecedoresHistorico.get(rowIndex).getPrecoQuantidade();
            default:
                return this.listaFornecedoresHistorico.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}