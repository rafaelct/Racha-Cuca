import java.io.File;

import javax.swing.filechooser.FileFilter;


public class FiltroArquivo extends FileFilter {

	String strFiltro,strDescricao;
	
	public FiltroArquivo(String filtro,String descricao) {
		// TODO Auto-generated constructor stub
		strFiltro = filtro;
		strDescricao = descricao;
		
	}

	@Override
	public boolean accept(File arg0) {
		// TODO Auto-generated method stub
		
		if ( arg0.isDirectory() ) {
			return true;
		}
		
		String strArquivo = arg0.getName();
		
		if(strArquivo.substring(strArquivo.length()-4,strArquivo.length() ).equals(strFiltro) ) {
		return true;
		}
		
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return strDescricao;
	}

}
