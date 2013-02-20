package base;

public class ControladorInstrucoes {
	
	public static boolean instrucoesNoPipe = true;

	public static Instrucao seletorInstrucao (String faseSelecionada) 
	{
			if (Jmips.getIns1() != null && Jmips.getIns1().getEstagio().equals(faseSelecionada))
			{
				return Jmips.getIns1();
			}
			if (Jmips.getIns2() != null && Jmips.getIns2().getEstagio().equals(faseSelecionada))
			{
				return Jmips.getIns2();
			}
			if (Jmips.getIns3() != null && Jmips.getIns3().getEstagio().equals(faseSelecionada))
			{
				return Jmips.getIns3();
			}
			if (Jmips.getIns4() != null && Jmips.getIns4().getEstagio().equals(faseSelecionada))
			{
				return Jmips.getIns4();
			}
			if (Jmips.getIns5() != null && Jmips.getIns5().getEstagio().equals(faseSelecionada))
			{
				return Jmips.getIns5();
			}
			return Jmips.nop;
	}
}
