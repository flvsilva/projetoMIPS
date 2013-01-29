import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Jmips
{
	private ArrayList<Integer> registradores;
	private byte[] memoria;
	
	private void inicializaRegistradores () 
	{
		registradores.add(0, 0); // $zero
	}
	
	private void inicializaMemoria()
	{
		memoria[0] = '0';
	}
	
	//recebe os dados de uma instrução e poe nos registradores
	private void preencheRegistradores ()
	{
		
	}
	
	public void main(String argv[]) throws FileNotFoundException 
	{
		inicializaRegistradores();
		inicializaMemoria();
		File arquivoFonteBruto = new File(argv[0]);  
		FileInputStream arquivoFonte = new FileInputStream(arquivoFonteBruto);  

		
		
	}
}