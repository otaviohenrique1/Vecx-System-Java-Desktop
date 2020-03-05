package moduloFornecedorTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;

public class TabelaModeloFornecedoes extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<FornecedoresTabela> listaFornecedor;
    private String[] colunas = {"Codigo do fornecedor","Nome do Fornecedor","CNPJ",};

    public TabelaModeloFornecedoes() {
        this.listaFornecedor = new ArrayList<>();
    }
    
    public void addFornecedor(FornecedoresTabela FornecedoresTabelaDados){
        this.listaFornecedor.add(FornecedoresTabelaDados);
        fireTableDataChanged();
    }
    
    public void removerFornecedor(int rowIndex){
    	if(listaFornecedor.size() == 0){
    		String menssagemConteudo = "Nenhum item selecionado";
			Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
			mensagemConfirmacao.setVisible(true);
        }
    	else {
    		this.listaFornecedor.remove(rowIndex);
            fireTableDataChanged();
		}
    }
    
    public FornecedoresTabela getCompra(int rowIndex){
        return this.listaFornecedor.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaFornecedor.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
            	return this.listaFornecedor.get(rowIndex).getCodigoFornecedor();
            case 1:
            	return this.listaFornecedor.get(rowIndex).getNomeFornecedor();
            case 2:
                return this.listaFornecedor.get(rowIndex).getCNPJ();
            default:
                return this.listaFornecedor.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}