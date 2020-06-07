import java.io.Serializable;


public class ConfigTeste implements Serializable {

	private String nomeTeste,nomeAutor,comentario,materialReferencia;
	
	public void setNomeTeste(String nTeste ) {
		this.nomeTeste = nTeste;
	}
	
	public void setNomeAutor(String nAutor ) {
		this.nomeAutor = nAutor;
	}
	
	public void setComentario(String coment ) {
		this.comentario = coment;
	}
	
	public void setMaterialReferencia(String mReferencia ) {
		this.materialReferencia = mReferencia;
	}
	
	public String getNomeTeste() {
		return this.nomeTeste;
	}
	
	public String getNomeAutor() {
		return this.nomeAutor;
	}
	
	public String getComentario() {
		return this.comentario;
	}
	
	public String getMaterialReferencia() {
		return this.materialReferencia;
	}
	                                                    
}
