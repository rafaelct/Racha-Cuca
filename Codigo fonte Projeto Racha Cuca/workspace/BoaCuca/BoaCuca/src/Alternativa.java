import java.io.Serializable;


public class Alternativa implements Serializable {

	private String respostaAlternativa;
	private boolean respostaCorreta = false;
	
	public Alternativa(String resposta,boolean correta) {
		// TODO Auto-generated constructor stub
		this.respostaAlternativa = resposta;
		this.respostaCorreta = correta;
		
	}

	public String getAlternativa() {
		// TODO Auto-generated method stub
		return this.respostaAlternativa;
	}

	public boolean getRespostaCorreta() {
		return this.respostaCorreta;
	}
	
}
