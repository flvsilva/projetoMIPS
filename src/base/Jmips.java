package base;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Jmips
{
	private static final String dumpBin = "/home/felipe/git/flvsilva/projetoMIPS/src/base/exb.txt";

	public static final String NOP = "00000000000000000000000000000000";

	public static Instrucao nop = new Instrucao(NOP, true);
	
	private static Instrucao ins1 = null;
	private static Instrucao ins2 = null;
	private static Instrucao ins3 = null;
	private static Instrucao ins4 = null;
	private static Instrucao ins5 = null;
	
	
	public static void main(String argv[]) throws IOException  
	{

		int qtdLinha =0;
		ArrayList<Integer> registradores = new ArrayList<Integer>();
		byte[] memoria = new byte[1000];
		
		File arquivoFonteBruto = new File(argv[0]);  
		
		geraBin(new PrintStream(dumpBin), arquivoFonteBruto);
		
		FileInputStream arquivoFonte = new FileInputStream(dumpBin); 
		InputStreamReader isr = new InputStreamReader(arquivoFonte);
		BufferedReader br = new BufferedReader(isr);
		
		FileReader fr = new FileReader(dumpBin);
		LineNumberReader linhaLeitura = new LineNumberReader(fr);  
		linhaLeitura.skip(Long.MAX_VALUE);
		qtdLinha = linhaLeitura.getLineNumber();  
		linhaLeitura.close();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>> " + qtdLinha);
		for (int l = 0; l <= qtdLinha; l++)
		{
			wbInstrucao(ControladorInstrucoes.seletorInstrucao("WB"));
			memInstrucao(ControladorInstrucoes.seletorInstrucao("MEM"));
			exInstrucao(ControladorInstrucoes.seletorInstrucao("EX"));
			idInstrucao(ControladorInstrucoes.seletorInstrucao("ID"));
			ifInstrucao(br);
			System.out.println("\n\n------> Fim do ciclo: "+l);
		}
		
	}
		

	
	private static void ifInstrucao(BufferedReader br) throws IOException 
	{
		String aux_instrucao;
		while ((aux_instrucao = br.readLine()) != null) 
		{
			System.out.println("IF: ->" + aux_instrucao);
			if (ins1 == null) 
			{
				ins1 = new Instrucao(aux_instrucao);
			} else {
				if (ins2 == null) 
				{
					ins2 = new Instrucao(aux_instrucao);
				} else {
					if (ins3 == null) 
					{
						ins3 = new Instrucao(aux_instrucao);
					} else {
						if (ins4 == null) 
						{
							ins4 = new Instrucao(aux_instrucao);
						} else {
							if (ins5 == null) 
							{
								ins5 = new Instrucao(aux_instrucao);
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
	
	private static void exInstrucao(Instrucao ins) 
	{
		System.out.println("EX: ->"+ins.getComandoASM());
		ins.execASM();
	}
	
	private static void memInstrucao(Instrucao ins) 
	{
		System.out.println("MEM: ->"+ins.getComandoASM());
		ins.memASM();
	}
			
	private static void wbInstrucao(Instrucao ins) 
	{
		System.out.println("WB: ->"+ins.getComandoASM());
		ins.wbASM();
	}

	public static void geraBin(PrintStream out, File file) throws IOException {
		
		InputStream is = new FileInputStream(file);
		
		while (is.available() > 0) {
			for (int j = 0; j < 16; j++) {
				if (is.available() > 0)
				{
					StringBuilder auxBuilder = new StringBuilder();
					for(int k=0; k<4 ; k++ )
					{
						int value = (int) is.read();
						auxBuilder.append(String.format("%02X", value));
					}
					String aux1 = auxBuilder.substring(2, 4);
					String aux2 = auxBuilder.substring(0, 2);
					String aux3 = auxBuilder.substring(6, 8);
					String aux4 = auxBuilder.substring(4, 6);
					
					StringBuilder sb1 = new StringBuilder();
					
					sb1.append(Integer.toBinaryString(Integer.parseInt(aux3.concat(aux4), 16)));
					while (sb1.length()<16)
					{
						sb1.insert(0, "0");
					}
					String auxBin = Integer.toBinaryString(Integer.parseInt(aux1.concat(aux2), 16));
					int b = (16 - auxBin.length());
					String auxPreenchimento = "";
					while (b > 0)
					{
						auxPreenchimento = auxPreenchimento.concat("0");
						b = (16 - (auxPreenchimento.length() + auxBin.length()));
					}
					sb1.append(auxPreenchimento.concat(auxBin));
					sb1.append(System.lineSeparator());
					out.print(sb1);
				}
			}
		}
		is.close();
		
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