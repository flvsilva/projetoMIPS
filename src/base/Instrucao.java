package base;

public class Instrucao {

	private String binario;
	private String comandoASM;
	private String estagio;

	public Instrucao(String binario) {
		this.binario = binario;
		MontaASM();
	}

	public void MontaASM ()
	{	
		String opCode = binario.substring(0, 6);
		System.out.println("opCode: " + opCode);
	}
	public String getBinario() {
		return binario;
	}

	public void setBinario(String binario) {
		this.binario = binario;
	}

	public String getComandoASM() {
		return comandoASM;
	}

	public void setComandoASM(String comandoASM) {
		this.comandoASM = comandoASM;
	}
	
	public String getEstagio() {
		return estagio;
	}
	
	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}
	
}
