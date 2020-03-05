package moduloProdutoTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;

public class TabelaModeloEstoque extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<EstoqueTabela> listaEstoque;
    private String[] colunas = {"Codigo do produto","Nome do produto","Quantidade","Preço","Lote"};

    public TabelaModeloEstoque() {
        this.listaEstoque = new ArrayList<>();
    }
    
    public void addProduto(EstoqueTabela EstoqueTabelaDados){
        this.listaEstoque.add(EstoqueTabelaDados);
        fireTableDataChanged();
    }
    
    public void removerCompra(int rowIndex){
    	if(listaEstoque.size() == 0){
    		String menssagemConteudo = "Nenhum item selecionado";
			Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
			mensagemConfirmacao.setVisible(true);
        }
    	else {
    		this.listaEstoque.remove(rowIndex);
            fireTableDataChanged();
		}
    }
    
    public EstoqueTabela getCompra(int rowIndex){
        return this.listaEstoque.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaEstoque.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        	case 0:
        		return this.listaEstoque.get(rowIndex).getCodigoProduto();
            case 1:
                return this.listaEstoque.get(rowIndex).getNome();
            case 2:
                return this.listaEstoque.get(rowIndex).getQuantidade();
            case 3:
                return this.listaEstoque.get(rowIndex).getPrecoaVista();
            case 4:
            	return this.listaEstoque.get(rowIndex).getLote();
            default:
                return this.listaEstoque.get(rowIndex);
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