package moduloFinanceiroVendaTabelas;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TabelaModeloHistoricoVenda extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<HistoricoVendaTabela> listaHistoricoVenda;
    private String[] colunas = {"Codigo da venda","Nome do cliente","Nome do funcionario","Preço total","Data e hora da venda"};

    public TabelaModeloHistoricoVenda() {
        this.listaHistoricoVenda = new ArrayList<>();
    }
    
    public void addHistoricoVenda(HistoricoVendaTabela HistoricoVendaTabelaDados){
        this.listaHistoricoVenda.add(HistoricoVendaTabelaDados);
        fireTableDataChanged();
    }
    
    public HistoricoVendaTabela getCompra(int rowIndex){
        return this.listaHistoricoVenda.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaHistoricoVenda.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaHistoricoVenda.get(rowIndex).getCodigoVenda();
            case 1:
                return this.listaHistoricoVenda.get(rowIndex).getNomeCliente();
            case 2:
                return this.listaHistoricoVenda.get(rowIndex).getNomeFuncionario();
            case 3:
            	return this.listaHistoricoVenda.get(rowIndex).getPrecoTotal();
            case 4:
            	return this.listaHistoricoVenda.get(rowIndex).getDataHoraVenda();
            default:
                return this.listaHistoricoVenda.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}