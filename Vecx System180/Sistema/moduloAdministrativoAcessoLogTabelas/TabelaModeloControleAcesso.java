package moduloAdministrativoAcessoLogTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloControleAcesso extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ControleAcessoTabela> listaControleAcesso;
    private String[] colunas = {"Codigo de registro", "Nome do usuario", "Cargo", "Data e hora de acesso"};

    public TabelaModeloControleAcesso() {
        this.listaControleAcesso = new ArrayList<>();
    }
    
    public void addControleAcesso(ControleAcessoTabela ControleAcessoTabelaDados){
        this.listaControleAcesso.add(ControleAcessoTabelaDados);
        fireTableDataChanged();
    }
    
    public void removerCompra(int rowIndex){
    		this.listaControleAcesso.remove(rowIndex);
            fireTableDataChanged();
    }
    
    public ControleAcessoTabela getCompra(int rowIndex){
        return this.listaControleAcesso.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaControleAcesso.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        	case 0:
        		return this.listaControleAcesso.get(rowIndex).getCodigoRegistro();
        	case 1:
                return this.listaControleAcesso.get(rowIndex).getFuncionarioNome();
            case 2:
                return this.listaControleAcesso.get(rowIndex).getCargo();
            case 3:
                return this.listaControleAcesso.get(rowIndex).getDataHoraAcesso();
            default:
                return this.listaControleAcesso.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}