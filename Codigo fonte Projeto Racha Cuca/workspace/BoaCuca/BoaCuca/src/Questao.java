import java.io.Serializable;
import java.util.ArrayList;


public class Questao implements Serializable {
	
	private String pergunta;
	private ArrayList<Alternativa> arrayAlternativas;
	private double valePonto = 0.0;
	
	public Questao(String perg,ArrayList<Alternativa> arrAlternativas,double pontos ) {
		
		this.pergunta = perg;
		this.arrayAlternativas = arrAlternativas;
		this.valePonto = pontos;
		
		
	}
	
	public String getPergunta() {
		
		return this.pergunta;
	}
	
	public ArrayList<Alternativa> getAlternativas() {
		
		return this.arrayAlternativas;
	}
	
	public double getPontos() {
		return this.valePonto;
		
	}
	
}
