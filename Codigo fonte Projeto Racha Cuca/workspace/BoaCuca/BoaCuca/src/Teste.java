import java.io.Serializable;
import java.util.ArrayList;


public class Teste implements Serializable {

	private ArrayList<Questao> arrayQuestao;
	private ConfigTeste configTeste;
	
	public Teste() {
		// TODO Auto-generated constructor stub
		
		arrayQuestao = new ArrayList<Questao>();
		configTeste = new ConfigTeste();
		
	}

	public int adicionarQuestao(Questao quest ) {
	
		this.arrayQuestao.add(quest);
		return 0;
		
		
	}
	
	public ArrayList<Questao> retornarQuestoes() {
		return arrayQuestao;
		
	}
	public void setConfig(ConfigTeste conf) {
		this.configTeste = conf;
		
	}
}
