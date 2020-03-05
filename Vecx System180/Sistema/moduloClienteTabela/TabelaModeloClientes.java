package moduloClienteTabela;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloClientes extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ClientesTabela> listaClientes;
    private String[] colunas = {"Codigo do cliente","Nome do cliente", "RG", "CPF"};

    public TabelaModeloClientes() {
        this.listaClientes = new ArrayList<>();
    }
    
    public void addClientes(ClientesTabela ClientesTabelaDados){
        this.listaClientes.add(ClientesTabelaDados);
        fireTableDataChanged();
    }
    
    public void removerCompra(int rowIndex){
    		this.listaClientes.remove(rowIndex);
            fireTableDataChanged();
    }
    
    public ClientesTabela getCompra(int rowIndex){
        return this.listaClientes.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaClientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
            	return this.listaClientes.get(rowIndex).getCodigoCliente();
            case 1:
            	return this.listaClientes.get(rowIndex).getNomeCliente();
            case 2:
                return this.listaClientes.get(rowIndex).getRG();
            case 3:
                return this.listaClientes.get(rowIndex).getCPF();
            default:
                return this.listaClientes.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}