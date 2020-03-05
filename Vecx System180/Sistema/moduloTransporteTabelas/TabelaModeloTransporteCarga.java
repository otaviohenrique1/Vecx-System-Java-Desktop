package moduloTransporteTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloTransporteCarga extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*Cria o arraylist da tabela*/
	private ArrayList<TransporteCargaTabela> listaTransporte;
	
	/*Nome das colunas*/
    private String[] colunas = {"Codigo de cadastro","Funcionario resposavel","Nome do cliente","Estado da entrega"};
    
    
    public TabelaModeloTransporteCarga() {
        this.listaTransporte = new ArrayList<>();
    }
    
    /*Adiciona os dados da compra na linha da tabela*/
    public void addTransporteCarga(TransporteCargaTabela TransporteCargaTabelaDados){
        this.listaTransporte.add(TransporteCargaTabelaDados);
        fireTableDataChanged();
    }
    
    /*Remove uma linha da tabela*/
    public void removerCompra(int rowIndex){
    	this.listaTransporte.remove(rowIndex);
        fireTableDataChanged();
    }
    
    /*Remove todas as linhas da tabela*/
    public void cancelarCompra(){
    	this.listaTransporte.clear();
        fireTableDataChanged();
    }
    
    public TransporteCargaTabela getCompra(int rowIndex){
        return this.listaTransporte.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaTransporte.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaTransporte.get(rowIndex).getCodigoTransporte();
            case 1:
                return this.listaTransporte.get(rowIndex).getFuncionarioNome();
            case 2:
                return this.listaTransporte.get(rowIndex).getClienteNome();
            case 3:
                return this.listaTransporte.get(rowIndex).getEstadoCarga();
            default:
                return this.listaTransporte.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}