import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class ArquivoFonteTeste {

	int numQuestao = 1;
	
	public ArquivoFonteTeste(String arquivoFonte) {
		// TODO Auto-generated constructor stub
		
		try {
			BufferedReader buf = new BufferedReader(new FileReader(arquivoFonte));
			
			String questao = "";
			String pontos = null;
			String versao = "";
			String arquivoFinal;
			
			ArrayList<Alternativa> arrAlternativa = new ArrayList<Alternativa>();
			Teste teste = new Teste();
			
			while(buf.ready() ) {
			
				String linha = buf.readLine();
				
				if(linha.length() > 1 && linha.substring(0,2).equals("//") ) {
					continue;
				}
				
				if(linha.indexOf(":") > 0 ) {
					
					String comando = linha.substring(0, linha.indexOf(":")+1 );
					String texto = linha.substring(linha.indexOf(":")+1,linha.length() );
					
					System.out.println("Comando: "+comando);
					System.out.println("Texto: "+texto);
					
					// Comandos
					
					if(comando.equals("V:")) {
						versao = texto;
						if(! versao.equals("1.0") ) {
							System.out.println("Versão " + versao + "incorreta ," + "Requer versão 1.0");
							return;
						}
						
					}
					if(comando.equals("Q:")) {
						
						if( ! questao.equals("") ) {
							
							numQuestao++;
							
							Questao questaoobj = new Questao(questao,arrAlternativa,Double.valueOf(pontos) );
							teste.adicionarQuestao(questaoobj);
							arrAlternativa = new ArrayList<Alternativa>();
							
						}
						
						questao = numQuestao + ") " + texto;
						
					}
					
					if(comando.equals("P:")) {
						pontos = texto;
					}
					
					if(comando.equals("AC:")) {
						Alternativa alternativa = new Alternativa(texto,true);
						arrAlternativa.add(alternativa);
					}
					
					if(comando.equals("AE:")) {
						Alternativa alternativa = new Alternativa(texto,false);
						arrAlternativa.add(alternativa);
					}
					
					// Fim dos comandos
					
				}
			}
			
			
			Questao questaoobj = new Questao(questao,arrAlternativa,Double.valueOf(pontos) );
			teste.adicionarQuestao(questaoobj);

			arquivoFonte = arquivoFonte.substring(0, arquivoFonte.length() -4 );
			arquivoFinal = arquivoFonte + ".cuc";
			
			ArquivoTeste arquivoTeste = new ArquivoTeste();
			arquivoTeste.geraArquivoTeste(arquivoFinal, teste);
			
			JOptionPane.showMessageDialog(null,"Arquivo "+arquivoFinal+" criado com sucesso !!!" , "Informação", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
