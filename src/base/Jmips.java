package base;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class Jmips
{
	public static void main(String argv[]) throws IOException  
	{
		ArrayList<Integer> registradores = new ArrayList<Integer>();
		byte[] memoria = new byte[1000];
		String aux_instrucao;
		
		File arquivoFonteBruto = new File(argv[0]);  
		
		aux_instrucao = ifInstrucao(arquivoFonteBruto);
		idInstrucao(aux_instrucao);
		exInstrucao();
		memInstrucao();
		wbInstrucao();
		
		
		
	}
	
	private static String ifInstrucao(File arquivoFonteBruto) throws IOException 
	{
		FileInputStream arquivoFonte = new FileInputStream(arquivoFonteBruto); 
		InputStreamReader isr = new InputStreamReader(arquivoFonte);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
		
	}
	private static void idInstrucao(String instrucao) {
		
	}
	
	private static void exInstrucao() {
		
	}
	
	private static void memInstrucao() {
		
	}
			
	private static void wbInstrucao() {
		
	}
}