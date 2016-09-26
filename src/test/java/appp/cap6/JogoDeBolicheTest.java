package appp.cap6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JogoDeBolicheTest {

	private JogoDeBoliche jogoDeBoliche;

	@Before
	public void setUp() {
		jogoDeBoliche = new JogoDeBoliche();
	}

	@Test
	public void dois_arremessos_simples() {
		jogoDeBoliche.adicionarPontos(5);
		jogoDeBoliche.adicionarPontos(4);

		assertEquals(9, jogoDeBoliche.obterPlacar());
	}

	@Test
	public void quatro_arremessos_simples() {
		jogoDeBoliche.adicionarPontos(5);
		jogoDeBoliche.adicionarPontos(4);
		jogoDeBoliche.adicionarPontos(7);
		jogoDeBoliche.adicionarPontos(2);

		assertEquals(18, jogoDeBoliche.obterPlacar());
		assertEquals(9, jogoDeBoliche.obterPlacarNoQuadro(1));
		assertEquals(18, jogoDeBoliche.obterPlacarNoQuadro(2));
	}

	@Test
	public void spare_simples() {
		jogoDeBoliche.adicionarPontos(3);
		jogoDeBoliche.adicionarPontos(7);
		jogoDeBoliche.adicionarPontos(3);

		assertEquals(13, jogoDeBoliche.obterPlacarNoQuadro(1));
	}

	@Test
	public void proximo_quadro_simples_depois_de_spare() {
		jogoDeBoliche.adicionarPontos(3);
		jogoDeBoliche.adicionarPontos(7);
		jogoDeBoliche.adicionarPontos(3);
		jogoDeBoliche.adicionarPontos(2);

		assertEquals(13, jogoDeBoliche.obterPlacarNoQuadro(1));
		assertEquals(18, jogoDeBoliche.obterPlacarNoQuadro(2));
		assertEquals(18, jogoDeBoliche.obterPlacar());
	}

	@Test
	public void strike_simples() {
		jogoDeBoliche.adicionarPontos(10);
		jogoDeBoliche.adicionarPontos(3);
		jogoDeBoliche.adicionarPontos(6);

		assertEquals(19, jogoDeBoliche.obterPlacarNoQuadro(1));
		assertEquals(28, jogoDeBoliche.obterPlacarNoQuadro(2));
	}

	@Test
	public void jogo_perfeito() {
		for(int i = 0; i < 12; i++) {
			jogoDeBoliche.adicionarPontos(10);
		}

		assertEquals(300, jogoDeBoliche.obterPlacar());
	}

	@Test
	public void zerou_todos_arremessos_e_fez_spare_e_strike_no_ultimo_quadro() {
		for(int i = 0; i < 9; i++) {
			jogoDeBoliche.adicionarPontos(0);
			jogoDeBoliche.adicionarPontos(0);
		}
		jogoDeBoliche.adicionarPontos(2);
		jogoDeBoliche.adicionarPontos(8);
		jogoDeBoliche.adicionarPontos(10);

		assertEquals(20, jogoDeBoliche.obterPlacar());
	}

	@Test
	public void quadro_de_pontuacao() {
		jogoDeBoliche.adicionarPontos(1);
		jogoDeBoliche.adicionarPontos(4);
		jogoDeBoliche.adicionarPontos(4);
		jogoDeBoliche.adicionarPontos(5);
		jogoDeBoliche.adicionarPontos(6);
		jogoDeBoliche.adicionarPontos(4);
		jogoDeBoliche.adicionarPontos(5);
		jogoDeBoliche.adicionarPontos(5);
		jogoDeBoliche.adicionarPontos(10);
		jogoDeBoliche.adicionarPontos(0);
		jogoDeBoliche.adicionarPontos(1);
		jogoDeBoliche.adicionarPontos(7);
		jogoDeBoliche.adicionarPontos(3);
		jogoDeBoliche.adicionarPontos(6);
		jogoDeBoliche.adicionarPontos(4);
		jogoDeBoliche.adicionarPontos(10);
		jogoDeBoliche.adicionarPontos(2);
		jogoDeBoliche.adicionarPontos(8);
		jogoDeBoliche.adicionarPontos(6);

		assertEquals(133, jogoDeBoliche.obterPlacar());
	}

	public void quase_perfeito_errou_ultimo_arremesso() {
		for(int i = 0; i < 11; i++) {
			jogoDeBoliche.adicionarPontos(10);
		}
		jogoDeBoliche.adicionarPontos(9);

		assertEquals(299, jogoDeBoliche.obterPlacar());
	}

	@Test
	public void spare_no_decimo_quadro() {
		for(int i = 0; i < 9; i++) {
			jogoDeBoliche.adicionarPontos(10);
		}
		jogoDeBoliche.adicionarPontos(9);
		jogoDeBoliche.adicionarPontos(1);
		jogoDeBoliche.adicionarPontos(1);

		assertEquals(270, jogoDeBoliche.obterPlacar());
	}

	@Test
	public void spare_strike_jogada_simples() {
		jogoDeBoliche.adicionarPontos(9);
		jogoDeBoliche.adicionarPontos(1);
		jogoDeBoliche.adicionarPontos(10);
		jogoDeBoliche.adicionarPontos(3);
		jogoDeBoliche.adicionarPontos(3);

		assertEquals(42, jogoDeBoliche.obterPlacar());
	}
}
