import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import net.miginfocom.swing.MigLayout;


public class GuiQuestao {

	JPanel panel;
	Questao questao;
	ArrayList<XRadioButton> arrXRadioButton;
	
	public GuiQuestao(Questao quest) {
		// TODO Auto-generated constructor stub
		
		questao = quest;
		
		panel = new JPanel(new MigLayout("nogrid"));
		
		JLabel lblPergunta = new JLabel( questao.getPergunta() );
		
		panel.add(lblPergunta,"wrap");
		
		ArrayList<Alternativa> arrAlternativas = questao.getAlternativas();
		
		arrXRadioButton = new ArrayList<XRadioButton>();
		
		ButtonGroup bg = new ButtonGroup();
		
		// ordem aleatoria
		Collections.shuffle(arrAlternativas);
		
		for(int j = 0 ; j < arrAlternativas.size() ; j++) {
			
			Alternativa alternativa = arrAlternativas.get(j);
			
			XRadioButton opAlternativa = new XRadioButton( alternativa.getAlternativa(), alternativa.getRespostaCorreta() );
			bg.add(opAlternativa);
			arrXRadioButton.add(opAlternativa);
			
			panel.add(opAlternativa,"wrap");
		}

	}

	public JPanel getPanel() {
		return panel;
	}

	public double getPontuacao() {
		// TODO Auto-generated method stub
		
		double pontos = 0.0;
		
		for(int i = 0 ; i < arrXRadioButton.size() ; i++ ) {
			
			XRadioButton xRadioButton = arrXRadioButton.get(i);
			
			//xRadioButton.setEnabled(false);
			
			if(xRadioButton.getCorretaIncorreta() ) {
				
				xRadioButton.setForeground(java.awt.Color.GREEN);
				
			}
			
			if(xRadioButton.isSelected() && ! xRadioButton.getCorretaIncorreta() ) {
				xRadioButton.setForeground(java.awt.Color.RED);
			}

			if( ! xRadioButton.isSelected() && ! xRadioButton.getCorretaIncorreta() ) {
				//xRadioButton.setForeground(java.awt.Color.RED);
				xRadioButton.setEnabled(false);
			}
			
			if(xRadioButton.isSelected() && xRadioButton.getCorretaIncorreta() ) {
				pontos = questao.getPontos();
			}
		}
		return pontos;
	}
}
