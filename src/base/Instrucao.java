package base;

public class Instrucao {

	private String binario;
	private String comandoASM;
	private String estagio;

	public Instrucao(String binario) {
		this.binario = binario;
		estagio = "IF";
	}

	public void MontaASM ()
	{	
		estagio = "ID";
		String opCode = binario.substring(0, 6);
		
		System.out.println("ID: -> opCode: " + opCode);
		
		if (opCode.equals("000000")) 
		{
			if (binario.substring(26, 32).equals("100000"))
			{
				System.out.println("eh um ADD");
			}
			else if (binario.substring(26, 32).equals("100100"))
			{
				System.out.println("eh um AND");
			}
			else if (binario.substring(26, 32).equals("001000"))
			{
				System.out.println("eh um JR");
			}
			else if (binario.substring(26, 32).equals("100101"))
			{
				System.out.println("eh um OR");
			}
			else if (binario.substring(26, 32).equals("000000"))
			{
				System.out.println("eh um SLL");
			}
			else if (binario.substring(26, 32).equals("000010"))
			{
				System.out.println("eh um SRL");
			}
			else if (binario.substring(26, 32).equals("100010")) 
			{
				System.out.println("eh um SUB");
			}
		} else {
			if (opCode.equals("001000")) {
				System.out.println("eh um ADDI");
				
			} else {
				if (opCode.equals("000100")) {
					System.out.println("eh um BEQ");
				} else {
					if (opCode.equals("BNE")) {
						System.out.println("eh um BNE");
					} else {
						if (opCode.equals("000010")) {
							System.out.println("eh um J");
						} else {
							if (opCode.equals("000011")) 
							{
								System.out.println("eh um JA");
							} else {
								if (opCode.equals("100011"))
								{
									System.out.println("eh um LW");
								} else {
									if (opCode.equals("101011"))
									{
										System.out.println("eh um SW");
									}
								}
							}
						}
					}
				}
				
			}
		}
	}
	
	public void execASM ()
	{
		
	}
	
	public void memASM ()
	{
		
	}
	
	public void wbASM ()
	{
		
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
