package moduloProdutoDescontoPromocaoTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloDesconto extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<DescontoTabela> listaDesconto;
    private String[] colunas = {"Codigo do desconto", "Nome do produto", "Desconto", "Inicio", "Termino", "Responsavel"};

    public TabelaModeloDesconto() {
        this.listaDesconto = new ArrayList<>();
    }
    
    public void addDesconto(DescontoTabela DescontoTabelaDados){
        this.listaDesconto.add(DescontoTabelaDados);
        fireTableDataChanged();
    }
    
    public DescontoTabela getDesconto(int rowIndex){
        return this.listaDesconto.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaDesconto.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        	case 0:
        		return this.listaDesconto.get(rowIndex).getCodigoDesconto();
            case 1:
                return this.listaDesconto.get(rowIndex).getNomeProduto();
            case 2:
                return this.listaDesconto.get(rowIndex).getDescontoPorcentagem();
            case 3:
                return this.listaDesconto.get(rowIndex).getDataHoraInicio();
            case 4:
            	return this.listaDesconto.get(rowIndex).getDataHoraTermino();
            case 5:
            	return this.listaDesconto.get(rowIndex).getNomeResponsavel();
            default:
                return this.listaDesconto.get(rowIndex);
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