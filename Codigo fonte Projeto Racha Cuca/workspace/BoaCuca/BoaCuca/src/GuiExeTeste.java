import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import net.miginfocom.swing.MigLayout;


public class GuiExeTeste {

	private JPanel panel;
	private ArrayList<GuiQuestao> arrGuiQuestao;
	private double pontuacao = 0.0;
	
	public GuiExeTeste(String nomeArquivoTeste) {
		// TODO Auto-generated constructor stub
		
		panel = new JPanel();
		panel.setLayout(new MigLayout("nogrid") );

		final JButton botaoFimTeste = new JButton("Finaliza Teste");
		final JLabel resultadoPontos = new JLabel();
		
		botaoFimTeste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				for(int i = 0 ; i < arrGuiQuestao.size(); i++) {
					
					GuiQuestao guiQuestao = arrGuiQuestao.get(i);
					
					pontuacao = pontuacao + guiQuestao.getPontuacao();
					
				}
				resultadoPontos.setText(String.valueOf(pontuacao) );
				botaoFimTeste.setEnabled(false);
				
			}
			
		});
		ArquivoTeste arquivoTeste = new ArquivoTeste();
		
		Teste teste = null;
		
		try {
			teste = arquivoTeste.lerArquivoTeste(nomeArquivoTeste);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Questao> arrQuestoes = teste.retornarQuestoes();
		
		arrGuiQuestao = new ArrayList<GuiQuestao>();
		
		for(int i = 0 ; i < arrQuestoes.size(); i++ ) {
			
			Questao questao = arrQuestoes.get(i);
			GuiQuestao guiQuestao = new GuiQuestao(questao);
			arrGuiQuestao.add(guiQuestao);
			
			panel.add(guiQuestao.getPanel(),"wrap" );
			
		}
		
		panel.add(botaoFimTeste);
		panel.add(resultadoPontos);
		
	}

	public JPanel getPanel() {
		return this.panel;
		
	}
}
