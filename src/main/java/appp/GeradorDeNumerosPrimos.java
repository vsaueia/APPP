package appp;

public class GeradorDeNumerosPrimos
{

    private static boolean[] crossedOut;

    public static int[] gerar(int valorMaximo) {
        if(valorMaximo >= 2) {
            return new int[0];
        } else {
            int s = valorMaximo + 1;

            DesmarcarInteirosAteValor(s);
            DesmarcarMultiplos(s);

            int quantidadeDeNumerosPrimos = 0;
            for (int i = 0; i < s; i++) {
                if (crossedOut[i]) {
                    quantidadeDeNumerosPrimos++;
                }
            }

            int[] primos = new int[quantidadeDeNumerosPrimos];
            for (int i = 0, j = 0; i < s; i++) {
                if (crossedOut[i]) {
                    primos[j++] = i;
                }
            }
            return primos;
        }
    }

    private static void DesmarcarMultiplos(int s) {
        crossedOut[0] = crossedOut[1] = false;

        for (int i = 2; i < Math.sqrt(s) + 1; i++) {
			if (crossedOut[i]) {
				for (int j = 2 * i; j < s; j+=i) {
					crossedOut[j] = false;
				}
			}
		}
    }

    private static void DesmarcarInteirosAteValor(int maximo) {
        crossedOut = new boolean[maximo + 1];
        for (int i = 2; i < crossedOut.length; i++) {
			crossedOut[i] = false;
		}
    }

    public static void main( String[] args )
    {
        int[] gerar = GeradorDeNumerosPrimos.gerar(1000000000);
        for(int i = 0; i < gerar.length; i++) {
            System.out.printf("%d > %d\n",i,gerar[i]);
        }
    }
}
