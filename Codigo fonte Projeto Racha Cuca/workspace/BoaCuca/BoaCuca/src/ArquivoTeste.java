import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ArquivoTeste {

	ObjectOutputStream out;
	ObjectInputStream in;
	
	public void geraArquivoTeste(String nomeDoArquivo,Teste teste) throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
		
		out = new ObjectOutputStream(new FileOutputStream( new File(nomeDoArquivo) ) );
		out.writeObject(teste);
		out.flush();
		out.close();
		
	}

	public Teste lerArquivoTeste(String nomeDoArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		in = new ObjectInputStream(new FileInputStream( new File(nomeDoArquivo) ) );
		Teste teste = (Teste) in.readObject();
		in.close();
		return teste;
				
	}
}
