package base;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class Jmips
{
	public static final String NOP = "00000000000000000000000000000000";

	public static Instrucao nop = new Instrucao(NOP);
	
	private static Instrucao ins1 = null;
	private static Instrucao ins2 = null;
	private static Instrucao ins3 = null;
	private static Instrucao ins4 = null;
	private static Instrucao ins5 = null;
	
	
	public static void main(String argv[]) throws IOException  
	{

		
		ArrayList<Integer> registradores = new ArrayList<Integer>();
		byte[] memoria = new byte[1000];
		
		File arquivoFonteBruto = new File(argv[0]);  
		FileInputStream arquivoFonte = new FileInputStream(arquivoFonteBruto); 
		InputStreamReader isr = new InputStreamReader(arquivoFonte);
		BufferedReader br = new BufferedReader(isr);
		
		LineNumberReader linhaLeitura = new LineNumberReader(new FileReader(arquivoFonteBruto));  
		linhaLeitura.skip(arquivoFonteBruto.length());  
		int qtdLinha = linhaLeitura.getLineNumber();  
		linhaLeitura.close();
		
		System.out.println(qtdLinha);
		for (int l = 0; l <= qtdLinha; l++)
		{
			wbInstrucao(ControladorInstrucoes.seletorInstrucao("WB"));
			memInstrucao(ControladorInstrucoes.seletorInstrucao("EX"));
			exInstrucao(ControladorInstrucoes.seletorInstrucao("ID"));
			idInstrucao(ControladorInstrucoes.seletorInstrucao("IF"));
			ifInstrucao(br);
		}
		
	}
		

	
	private static void ifInstrucao(BufferedReader br) throws IOException 
	{
		String aux_instrucao;
		while ((aux_instrucao = br.readLine()) != null) 
		{
			if (ins1 == null) 
			{
				ins1 = new Instrucao(aux_instrucao); //busca
			} else {
				if (ins2 == null) 
				{
					ins2 = new Instrucao(aux_instrucao); //busca
				} else {
					if (ins3 == null) 
					{
						ins3 = new Instrucao(aux_instrucao); //busca
					} else {
						if (ins4 == null) 
						{
							ins4 = new Instrucao(aux_instrucao); //busca
						} else {
							if (ins5 == null) 
							{
								ins5 = new Instrucao(aux_instrucao); //busca
							}
						}
					}
				}
			}
			
			break;
		} //fim Busca		
	}
	private static void idInstrucao(Instrucao ins)
	{
			ins.MontaASM();
	}
	
	private static void exInstrucao(Instrucao ins) {
		
	}
	
	private static void memInstrucao(Instrucao ins) {
		
	}
			
	private static void wbInstrucao(Instrucao ins) {
		
	}



	public static Instrucao getIns1() {
		return ins1;
	}



	public static void setIns1(Instrucao ins1) {
		Jmips.ins1 = ins1;
	}



	public static Instrucao getIns2() {
		return ins2;
	}



	public static void setIns2(Instrucao ins2) {
		Jmips.ins2 = ins2;
	}



	public static Instrucao getIns3() {
		return ins3;
	}



	public static void setIns3(Instrucao ins3) {
		Jmips.ins3 = ins3;
	}



	public static Instrucao getIns4() {
		return ins4;
	}



	public static void setIns4(Instrucao ins4) {
		Jmips.ins4 = ins4;
	}



	public static Instrucao getIns5() {
		return ins5;
	}



	public static void setIns5(Instrucao ins5) {
		Jmips.ins5 = ins5;
	}
}