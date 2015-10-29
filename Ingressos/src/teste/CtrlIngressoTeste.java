package teste;

import org.junit.Test;

import control.CtrlIngresso;
import junit.framework.TestCase;

public class CtrlIngressoTeste extends TestCase {

	
	@Test
	public void testIngressoCalcula()
	{
		assertEquals(8.0, new CtrlIngresso().IngressoCalcula("01/11/2015", "Estudantes", false).getValor());
	}

	@Test
	public void testGetDiaSemana() {
		
		assertEquals(4, new CtrlIngresso().getDiaSemana("29/10/2015"));
	}
	@Test
	public void testCalculaDesconto() {
		assertEquals(5.0, new CtrlIngresso().CalculaDesconto(10, 50));
	}
	@Test
	public void testCalculaValorIngresso() {
		assertEquals( 6.0,new CtrlIngresso().CalculaValorIngresso(8.0, 2.0));
	}

}
