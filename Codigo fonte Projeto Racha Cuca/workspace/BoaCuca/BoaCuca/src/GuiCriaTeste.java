import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;


public class GuiCriaTeste {

	JPanel panel;
	
	public GuiCriaTeste() {
		// TODO Auto-generated constructor stub
		
		panel = new JPanel();
		panel.setLayout(new MigLayout("nogrid") );
		
		
		//JLabel lblArqFnt = new JLabel("Arquivo fonte (*.frc):");
		
		final JTextField txtArqTeste = new JTextField();
		final JButton btGeraArq = new JButton("Converter Arquivo Fonte Racha Cuca (*.frc) em Arquivo Racha Cuca (*.cuc)");
		final JButton btExeArq = new JButton("Iniciar teste (Arquivo Racha Cuca *.cuc)");
		
		
		//panel.add(lblArqFnt);
		// panel.add(txtArqTeste,"width 400:400:400,height 20:20:20");
		panel.add(btGeraArq,"wrap");
		panel.add(btExeArq,"wrap,height 100:100:100");
		
		
		btGeraArq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				   JFileChooser chooser = new JFileChooser();
				    // Note: source for ExampleFileFilter can be found in FileChooserDemo,
				    // under the demo/jfc directory in the Java 2 SDK, Standard Edition.
				   FiltroArquivo filtro = new FiltroArquivo(".frc","Arquivo Fonte Racha Cuca (.frc)");
				   
				   chooser.setFileFilter( filtro );
				   
				    int returnVal = chooser.showOpenDialog(panel);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				       //System.out.println("You chose to open this file: " +
				       //     chooser.getSelectedFile().getAbsolutePath());
				       		
				       ArquivoFonteTeste arqFntTeste = new ArquivoFonteTeste(chooser.getSelectedFile().getAbsolutePath());
				       txtArqTeste.setText(chooser.getSelectedFile().getAbsolutePath());
				       
				    }

			}
			
		});
		btExeArq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				   JFileChooser chooser = new JFileChooser();
				    // Note: source for ExampleFileFilter can be found in FileChooserDemo,
				    // under the demo/jfc directory in the Java 2 SDK, Standard Edition.
				   	FiltroArquivo filtro = new FiltroArquivo(".cuc","Arquivo Racha Cuca (.cuc)");
				   
				   chooser.setFileFilter( filtro );
				   
				   int returnVal = chooser.showOpenDialog(panel);
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				       		
				       JanelaExeTeste janelaExeTeste = new JanelaExeTeste(chooser.getSelectedFile().getAbsolutePath() );
				       //txtArqTeste.setText(chooser.getSelectedFile().getAbsolutePath());
				       
				    }

			}
			
		});
		
	}
	
	public JPanel getPanel() {
		return panel;
	}

	
}


