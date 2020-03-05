package moduloFinanceiroCompraTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloCompra extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*Cria o arraylist da tabela*/
	private ArrayList<CompraTabela> listaVendas;
	
	/*Nome das colunas*/
    private String[] colunas = {"Codigo do produto", "Nome do produto", "Quantidade", "Preço", "Preço x Quantidade ", "Fornecedor"};
    
    
    public TabelaModeloCompra() {
        this.listaVendas = new ArrayList<>();
    }
    
    /*Adiciona os dados da compra na linha da tabela*/
    public void addCompra(CompraTabela CompraTabelaDados){
        this.listaVendas.add(CompraTabelaDados);
        fireTableDataChanged();
    }
    
    /*Remove uma linha da tabela*/
    public void removerCompra(int rowIndex){
    	this.listaVendas.remove(rowIndex);
        fireTableDataChanged();
    }
    
    /*Remove todas as linhas da tabela*/
    public void cancelarCompra(){
    	this.listaVendas.clear();
        fireTableDataChanged();
    }
    
    public CompraTabela getCompra(int rowIndex){
        return this.listaVendas.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaVendas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
            	return this.listaVendas.get(rowIndex).getCodigoProduto();
            case 1:
            	return this.listaVendas.get(rowIndex).getNomeProduto();
            case 2:
            	return this.listaVendas.get(rowIndex).getQuantidade();
            case 3:
            	return this.listaVendas.get(rowIndex).getPrecoCompra();
            case 4:
            	return this.listaVendas.get(rowIndex).getPrecoQuantidade();
            case 5:
                return this.listaVendas.get(rowIndex).getFornecedor();
            default:
                return this.listaVendas.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}