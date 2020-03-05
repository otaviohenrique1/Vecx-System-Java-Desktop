package moduloFinanceiroCompraTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaModeloCompraProdutosLista extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*Cria o arraylist da tabela*/
	private ArrayList<CompraListaTabela> listaCompraProdutos;
	
	/*Nome das colunas*/
    private String[] colunas = {"Codigo do produto", "Nome do produto","Quantidade","Preço unitario", "Preço x Quantidade", "Fornecedor"};
    
    
    public TabelaModeloCompraProdutosLista() {
        this.listaCompraProdutos = new ArrayList<>();
    }
    
    /*Adiciona os dados da compra na linha da tabela*/
    public void addCompraProdutosLista(CompraListaTabela ListaCompraTabelaDados){
        this.listaCompraProdutos.add(ListaCompraTabelaDados);
        fireTableDataChanged();
    }
    
    /*Remove uma linha da tabela*/
    public void removerCompra(int rowIndex){
    	this.listaCompraProdutos.remove(rowIndex);
        fireTableDataChanged();
    }
    
    /*Remove todas as linhas da tabela*/
    public void cancelarCompra(){
    	this.listaCompraProdutos.clear();
        fireTableDataChanged();
    }
    
    public CompraListaTabela getCompra(int rowIndex){
        return this.listaCompraProdutos.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaCompraProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listaCompraProdutos.get(rowIndex).getCodigo();
            case 1:
                return this.listaCompraProdutos.get(rowIndex).getNome();
            case 2:
                return this.listaCompraProdutos.get(rowIndex).getQuantidade();
            case 3:
                return this.listaCompraProdutos.get(rowIndex).getPreco();
            case 4:
                return this.listaCompraProdutos.get(rowIndex).getPrecoQuantidade();
            case 5:
                return this.listaCompraProdutos.get(rowIndex).getFornecedor();
            default:
                return this.listaCompraProdutos.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }	
}