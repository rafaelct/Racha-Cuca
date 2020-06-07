import javax.swing.JRadioButton;


public class XRadioButton extends JRadioButton {

	boolean corretaIncorreta = false;
	
	public XRadioButton(String texto,boolean corretaInc) {
		// TODO Auto-generated constructor stub
		super(texto);
		corretaIncorreta = corretaInc;
		
	}
	
	public boolean getCorretaIncorreta() {
		return this.corretaIncorreta;
	}

}
