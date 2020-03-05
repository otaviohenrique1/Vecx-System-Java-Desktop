package aInterfaceSistema;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ValidaNumeroInteiro extends PlainDocument {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Valida os campos, para receberem apenas numeros*/
	private int maxlength;
	public ValidaNumeroInteiro() {
		
	}
	
	public ValidaNumeroInteiro(int maxlength) {
		super();
		this.maxlength = maxlength;
	}
	
	public void insertString(int offs, String str, AttributeSet a){
		try{
			Integer.parseInt(str);
		}
		catch (NumberFormatException ex){
			str = "";
		}
		
		try{
			boolean fixedLengh = (!((getLength() + str.length()) > maxlength));
			if (maxlength == 0 || fixedLengh)
				super.insertString(offs, str, a);
		}
		catch (BadLocationException e){
			e.printStackTrace();
		}
	}
}