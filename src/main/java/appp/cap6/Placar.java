package appp.cap6;

public class Placar {
	private int bola;
	private int[] arremessos = new int[21];
	private int arremessoAtual;

	public void adicionarArremesso(int pinosDerrubados) {
		arremessos[arremessoAtual++] = pinosDerrubados;
	}

	public int pontuacaoNoQuadro(int quadro) {
		bola = 0;
		int pontuacao = 0;
		for(int quadroAtual = 0; quadroAtual < quadro; quadroAtual++) {
			if (foiStrike()) {
				pontuacao += 10 + proximasDuasBolasParaStrike();
				bola++;
			} else if (foiSpare()) {
				pontuacao += 10 + proximaBolaPeloSpare();
				bola += 2;
			} else {
				pontuacao += duasBolasNoQuadro();
				bola += 2;
			}
		}
		return pontuacao;
	}

	private boolean foiSpare() {
		return arremessos[bola] + arremessos[bola + 1] == 10;
	}

	private int duasBolasNoQuadro() {
		return arremessos[bola] + arremessos[bola + 1];
	}

	private boolean foiStrike() {
		return arremessos[bola] == 10;
	}

	private int proximaBolaPeloSpare() {
		return arremessos[bola + 2];
	}

	private int proximasDuasBolasParaStrike() {
		return arremessos[bola + 1] + arremessos[bola + 2];
	}
}
