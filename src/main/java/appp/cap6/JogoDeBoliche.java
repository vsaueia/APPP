package appp.cap6;

public class JogoDeBoliche {
	private int quadroCorrente = 0;
	private boolean ehPrimeiraJogada = true;
	private Placar placar = new Placar(); 
	
	public void adicionarPontos(int pinosDerrubados) {
		placar.adicionarArremesso(pinosDerrubados);
		ajustarQuadroCorrente(pinosDerrubados);
	}

	private void ajustarQuadroCorrente(int pinosDerrubados) {
		if (ultimaBolaNoQuadro(pinosDerrubados)) {
			avancarParaProximoQuadro();
		} else {
			ehPrimeiraJogada = false;
		}
	}

	private void avancarParaProximoQuadro() {
		quadroCorrente++;
		if (quadroCorrente > 10) {
			quadroCorrente = 10;
		}
	}

	private boolean ultimaBolaNoQuadro(int pinosDerrubados) {
		return foiStrike(pinosDerrubados) || (!ehPrimeiraJogada);
	}

	private boolean foiStrike(int pinosDerrubados) {
		return ehPrimeiraJogada && pinosDerrubados == 10;
	}

	public int obterPlacar() {
		return obterPlacarNoQuadro(quadroCorrente);
	}

	public int obterPlacarNoQuadro(int quadro) {
		return placar.pontuacaoNoQuadro(quadro);
	}
}
