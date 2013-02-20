package base;

public class Instrucao {
	private boolean inicio = false;
	
	private String binario;
	private String comandoASM;
	private String estagio;
	
	
	private int funct;
	private int shamt;
	private int rs;
	private int rd;
	private int	rt;
	private int offset;
	private int address;
	
	
	
	public Instrucao(String binario, boolean inicio) {this.binario = binario; comandoASM="NOP"; estagio="NOP";}
	
	public Instrucao(String binario) {
		this.binario = binario;
		estagio = "ID";
	}

	public void MontaASM ()
	{	
		if (binario.equals(Jmips.NOP))
		{
			comandoASM = "NOP";
			return; //NOP
		}
		String opCode = binario.substring(0, 6);
		if (opCode.equals("000000")) 
		{
			String functInstrucao = binario.substring(26, 32);
			if (functInstrucao.equals("100000"))
			{
				preparaInstrucaoTipoR(functInstrucao);
				comandoASM = "ADD";
			}
			else if (functInstrucao.equals("100100"))
			{
				comandoASM = "AND";
			}
			else if (functInstrucao.equals("001000"))
			{
				comandoASM = "JR";
			}
			else if (functInstrucao.equals("100101"))
			{
				comandoASM = "OR";
			}
			else if (functInstrucao.equals("000000"))
			{
				comandoASM = "SLL";
			}
			else if (functInstrucao.equals("000010"))
			{
				comandoASM = "SRL";
			}
			else if (functInstrucao.equals("100010")) 
			{
				preparaInstrucaoTipoR(functInstrucao);
				comandoASM = "SUB";
			}
		} else {
			if (opCode.equals("001000")) { // ADDI
				rs = Integer.parseInt(binario.substring(6, 11), 2);
				rt = Integer.parseInt(binario.substring(11, 16), 2);
				offset = Integer.parseInt(binario.substring(16, 32), 2);
				comandoASM = "ADDI";
			
			} else {
				if (opCode.equals("000100")) {
					comandoASM = "BEQ";
				} else {
					if (opCode.equals("000101")) {
						comandoASM = "BNE";
					} else {
						if (opCode.equals("000010")) {
							address = Integer.parseInt(binario.substring(6, 32), 2);
							comandoASM = "J";
						} else {
							if (opCode.equals("000011")) 
							{
								comandoASM = "JA";
							} else {
								if (opCode.equals("100011"))
								{
									comandoASM = "LW";
								} else {
									if (opCode.equals("101011"))
									{
										comandoASM = "SW";
									}
								}
							}
						}
					}
				}
				
			}
		}
		System.out.println("ID: ->" + comandoASM);
		estagio = "EX";
	}

	private void preparaInstrucaoTipoR(String functInstrucao) {
		rs = Integer.parseInt(binario.substring(6, 11), 2);
		rt = Integer.parseInt(binario.substring(11, 16), 2);
		rd = Integer.parseInt(binario.substring(16, 21), 2);
		shamt = Integer.parseInt(binario.substring(21, 26), 2);
		funct = Integer.parseInt(functInstrucao);
	}
	
	public void execASM ()
	{
		
		estagio = "MEM";
	}
	
	public void memASM ()
	{
		estagio = "WB";
	}
	
	public void wbASM ()
	{
		if (comandoASM.equals("LW"))
		{
			
		}
		estagio = "FIM";
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

	public int getRs() {
		return rs;
	}

	public void setRs(int rs) {
		this.rs = rs;
	}

	public int getRd() {
		return rd;
	}

	public void setRd(int rd) {
		this.rd = rd;
	}

	public int getRt() {
		return rt;
	}

	public void setRt(int rt) {
		this.rt = rt;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public int getFunct() {
		return funct;
	}

	public void setFunct(int funct) {
		this.funct = funct;
	}

	public int getShamt() {
		return shamt;
	}

	public void setShamt(int shamt) {
		this.shamt = shamt;
	}
	public boolean isInicio() {
		return inicio;
	}
	public void setInicio(boolean inicio) {
		this.inicio = inicio;
	}
	
}
