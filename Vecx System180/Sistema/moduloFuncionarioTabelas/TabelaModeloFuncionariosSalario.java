package moduloFuncionarioTabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import mensagensSistema.Tela_que_Exibe_Menssagem_Texto_Uma_Linha;

public class TabelaModeloFuncionariosSalario extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<FuncionariosTabelaSalario> listaFuncionariosSalario;
    private String[] colunas = {"Estado", "Bonus", "Comissão","Data e hora do cadastro", "Responsavel"};

    public TabelaModeloFuncionariosSalario() {
        this.listaFuncionariosSalario = new ArrayList<>();
    }
    
    public void addFuncionarioSalario(FuncionariosTabelaSalario FuncionariosTabelaSalarioDados){
        this.listaFuncionariosSalario.add(FuncionariosTabelaSalarioDados);
        fireTableDataChanged();
    }
    
    public void removerCompra(int rowIndex){
    	if(listaFuncionariosSalario.size() == 0){
    		String menssagemConteudo = "Nenhum item selecionado";
			Tela_que_Exibe_Menssagem_Texto_Uma_Linha mensagemConfirmacao = new Tela_que_Exibe_Menssagem_Texto_Uma_Linha(menssagemConteudo);
			mensagemConfirmacao.setVisible(true);
        }
    	else {
    		this.listaFuncionariosSalario.remove(rowIndex);
            fireTableDataChanged();
		}
    }
    
    public FuncionariosTabelaSalario getCompra(int rowIndex){
        return this.listaFuncionariosSalario.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return  this.listaFuncionariosSalario.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
        	case 0:
            	return this.listaFuncionariosSalario.get(rowIndex).getEstadoComissaoBonus();
        	case 1:
                return this.listaFuncionariosSalario.get(rowIndex).getBonusSalario();
            case 2:
                return this.listaFuncionariosSalario.get(rowIndex).getComissaoSalario();
            case 3:
                return this.listaFuncionariosSalario.get(rowIndex).getDataHoraCadastro();
            case 4:
            	return this.listaFuncionariosSalario.get(rowIndex).getNomeResponsavel();
            default:
                return this.listaFuncionariosSalario.get(rowIndex);
        }
    }
    
    @Override
    public  String getColumnName(int columnIndex){
        return this.colunas[columnIndex];
    }
}