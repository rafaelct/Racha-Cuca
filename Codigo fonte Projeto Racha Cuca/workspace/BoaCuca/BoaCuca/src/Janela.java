import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;


public class Janela {

	private String versao = "v1.0 - Beta 17082013";
	
	public Janela() {
		// TODO Auto-generated constructor stub
		
		JFrame gui = new JFrame("Racha Cuca "+ versao);
		
		gui.setBounds(0,0,1000,700);
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("nogrid") );
		
		GuiCriaTeste guiCriaTeste = new GuiCriaTeste();
		
		panel.add(guiCriaTeste.getPanel() );
		
		gui.add( panel );
		
		gui.setVisible(true);
		
	}

	
}
