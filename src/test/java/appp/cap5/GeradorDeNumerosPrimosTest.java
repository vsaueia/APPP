package appp.cap5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GeradorDeNumerosPrimosTest {
	@Test
	public void testGerar() throws Exception {
		int[] nullArray = GeradorDeNumerosPrimos.gerarNumerosPrimeirosAte(0);
		assertEquals(nullArray.length, 0);

		int[] minArray = GeradorDeNumerosPrimos.gerarNumerosPrimeirosAte(2);
		assertEquals(minArray.length, 1);
		assertEquals(minArray[0], 2);

		int[] threeArray = GeradorDeNumerosPrimos.gerarNumerosPrimeirosAte(3);
		assertEquals(threeArray.length, 2);
		assertEquals(threeArray[0], 2);
		assertEquals(threeArray[1], 3);

		int[] centArray = GeradorDeNumerosPrimos.gerarNumerosPrimeirosAte(100);
		assertEquals(centArray.length, 25);
		assertEquals(centArray[24], 97);
	}

	@Test
	public void testeDeExaustao() {
		for(int i = 2; i < 500; i++) {
			verificarListaDePrimos(GeradorDeNumerosPrimos.gerarNumerosPrimeirosAte(i));
		}
	}

	private void verificarListaDePrimos(int[] lista) {
		for(int i =0; i < lista.length; i++) {
			verificarPrimo(lista[i]);
		}
	}

	private void verificarPrimo(int n) {
		for(int fator = 2; fator < n; fator++) {
			assertTrue(n % fator != 0);
		}
	}
}