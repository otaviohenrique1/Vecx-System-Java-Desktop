package moduloProdutoDescontoPromocaoTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloDescontoResponsavel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<DescontoResonsavelTabela> listaDescontoResonsavel;
    private String[] colunas = {"Codigo do funcionario", "Nome do funcionario","Cargo"};

    public TabelaModeloDescontoResponsavel() {
        this.listaDescontoResonsavel = new ArrayList<>();
    }
    
    public void addDescontoResonsavel(DescontoResonsavelTabela DescontoResonsavelTabelaDados){
        this.listaDescontoResonsavel.add(DescontoResonsavelTabelaDados);
        fireTableDataChanged();
    }
    
    public DescontoResonsavelTabela getCompra(int rowIndex){
        return this.listaDescontoResonsavel.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaDescontoResonsavel.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaDescontoResonsavel.get(rowIndex).getCodigoFuncionario();
            case 1:
                return this.listaDescontoResonsavel.get(rowIndex).getNomeFuncionario();
            case 2:
                return this.listaDescontoResonsavel.get(rowIndex).getCargo();
            default:
                return this.listaDescontoResonsavel.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}