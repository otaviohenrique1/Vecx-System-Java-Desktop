package moduloProdutoDescontoPromocaoTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloPromocao extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<PromocaoTabela> listaPromocao;
    private String[] colunas = {"Codigo da promoção", "Nome da promoção", "Inicio", "Termino", "Funcionario responsavel"};

    public TabelaModeloPromocao() {
        this.listaPromocao = new ArrayList<>();
    }
    
    public void addPromocao(PromocaoTabela PromocaoTabelaDados){
        this.listaPromocao.add(PromocaoTabelaDados);
        fireTableDataChanged();
    }
    
    public PromocaoTabela getPromocao(int rowIndex){
        return this.listaPromocao.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaPromocao.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        	case 0:
        		return this.listaPromocao.get(rowIndex).getCodigoPromocao();
            case 1:
                return this.listaPromocao.get(rowIndex).getNomePromocao();
            case 2:
                return this.listaPromocao.get(rowIndex).getDataHoraInicio();
            case 3:
                return this.listaPromocao.get(rowIndex).getDataHoraTermino();
            case 4:
            	return this.listaPromocao.get(rowIndex).getNomeResponsavel();
            default:
                return this.listaPromocao.get(rowIndex);
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