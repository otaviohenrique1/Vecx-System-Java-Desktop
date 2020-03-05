package moduloFuncionarioTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;

public class TabelaModeloFuncionariosFerias extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<FuncionariosTabelaFeriasFolga> listaFuncionariosFerias;
    private String[] colunas = {"Tipo", "Data de inicio", "Data de final", "Duração","Data e hora de cadastro"};

    public TabelaModeloFuncionariosFerias() {
        this.listaFuncionariosFerias = new ArrayList<>();
    }
    
    public void addFuncionariosFerias(FuncionariosTabelaFeriasFolga FuncionariosTabelaFeriasDados){
        this.listaFuncionariosFerias.add(FuncionariosTabelaFeriasDados);
        fireTableDataChanged();
    }
    
    public void removerCompra(int rowIndex){
    	if(listaFuncionariosFerias.size() == 0){
    		String menssagemConteudo = "Nenhum item selecionado";
			Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
			mensagemConfirmacao.setVisible(true);
        }
    	else {
    		this.listaFuncionariosFerias.remove(rowIndex);
            fireTableDataChanged();
		}
    }
    
    public FuncionariosTabelaFeriasFolga getCompra(int rowIndex){
        return this.listaFuncionariosFerias.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaFuncionariosFerias.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        	case 0:
            	return this.listaFuncionariosFerias.get(rowIndex).getTipoFeriasFolga();
            case 1:
                return this.listaFuncionariosFerias.get(rowIndex).getDataInicio();
            case 2:
                return this.listaFuncionariosFerias.get(rowIndex).getDataFinal();
            case 3:
                return this.listaFuncionariosFerias.get(rowIndex).getDuracaoFerias();
            case 4:
            	return this.listaFuncionariosFerias.get(rowIndex).getDataHoraCadastro();
            default:
                return this.listaFuncionariosFerias.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}