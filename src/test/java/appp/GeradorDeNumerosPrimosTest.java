package appp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeradorDeNumerosPrimosTest {
	@Test
	public void testGerar() throws Exception {
		int[] nullArray = GeradorDeNumerosPrimos.gerar(0);
		assertEquals(nullArray.length, 0);

		int[] minArray = GeradorDeNumerosPrimos.gerar(2);
		assertEquals(minArray.length, 1);
		assertEquals(minArray[0], 2);

		int[] threeArray = GeradorDeNumerosPrimos.gerar(3);
		assertEquals(threeArray.length, 2);
		assertEquals(threeArray[0], 2);
		assertEquals(threeArray[1], 3);

		int[] centArray = GeradorDeNumerosPrimos.gerar(100);
		assertEquals(centArray.length, 25);
		assertEquals(centArray[24], 97);

	}
}