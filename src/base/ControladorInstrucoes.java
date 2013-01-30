package base;

public class ControladorInstrucoes {

	public static Instrucao seletorInstrucao (String faseSelecionada) 
	{
		try 
		{
			if (Jmips.getIns1().getEstagio().equals(faseSelecionada))
			{
				return Jmips.getIns1();
			}
			if (Jmips.getIns2().getEstagio().equals(faseSelecionada))
			{
				return Jmips.getIns2();
			}
			if (Jmips.getIns3().getEstagio().equals(faseSelecionada))
			{
				return Jmips.getIns3();
			}
			if (Jmips.getIns4().getEstagio().equals(faseSelecionada))
			{
				return Jmips.getIns4();
			}
			if (Jmips.getIns5().getEstagio().equals(faseSelecionada))
			{
				return Jmips.getIns5();
			}
		} 
		catch (NullPointerException np) 
		{
			return Jmips.nop;
		}
		
		return Jmips.nop; 
	}
}
