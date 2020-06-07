import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;


public class JanelaExeTeste {

	public JanelaExeTeste(String arquivoTeste) {
		// TODO Auto-generated constructor stub
		JFrame gui = new JFrame("Racha Cuca ");
		
		gui.setBounds(0,0,1000,700);
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("nogrid") );
		panel.setForeground(java.awt.Color.white);
		
		//JTabbedPane tabbletPane = new JTabbedPane();
		
		
		//GuiCriaTeste guiCriaTeste = new GuiCriaTeste();
		
		//panel.add(guiCriaTeste.getPanel() );
		
		
		
		GuiExeTeste guiExeTeste = new GuiExeTeste(arquivoTeste);
		
		panel.add( new JScrollPane( guiExeTeste.getPanel() ) );
		

		//tabbletPane.add("Criar Teste",guiCriaTeste.getPanel() );
		//tabbletPane.add("Executar Teste",new JScrollPane( guiExeTeste.getPanel() ) );

		gui.add(panel);
		
		gui.setVisible(true);

	}

}
