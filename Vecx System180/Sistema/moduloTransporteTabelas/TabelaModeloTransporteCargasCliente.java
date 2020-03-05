package moduloTransporteTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloTransporteCargasCliente extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<TransporteCargasClienteTabela> listaTransporteCargasCliente;
    private String[] colunas = {"Nome do cliente", "CPF do cliente","RG do cliente"};

    public TabelaModeloTransporteCargasCliente() {
        this.listaTransporteCargasCliente = new ArrayList<>();
    }
    
    public void addTransporteCargasCliente(TransporteCargasClienteTabela TransporteCargasClienteTabelaDados){
        this.listaTransporteCargasCliente.add(TransporteCargasClienteTabelaDados);
        fireTableDataChanged();
    }
    
    public TransporteCargasClienteTabela getTransporteCargasCliente(int rowIndex){
        return this.listaTransporteCargasCliente.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaTransporteCargasCliente.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaTransporteCargasCliente.get(rowIndex).getNomeCliente();
            case 1:
                return this.listaTransporteCargasCliente.get(rowIndex).getClienteCPF();
            case 2:
                return this.listaTransporteCargasCliente.get(rowIndex).getClienteRG();
            default:
                return this.listaTransporteCargasCliente.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}