package appp;

public class GeradorDeNumerosPrimos
{
    private static boolean[] naoPrimos;
    private static int[] resultado;

    public static int[] gerarNumerosPrimeirosAte(int valorMaximo) {
        if (valorMaximo < 2) {
            return new int[0];
        } else {
            desmarcarNumerosAte(valorMaximo);
            desmarcarMultiplosDePrimos();
            inserirNumerosEncontradosNoResultado();
            return resultado;
        }
    }

    private static void inserirNumerosEncontradosNoResultado() {
        resultado = new int[quantidadeDeNumerosPrimosEncontrados()];
        for(int j = 0, i = 2; i < naoPrimos.length; i++) {
            if (marcadoComoPrimo(i)) {
                resultado[j++] = i;
            }
        }
    }

    private static int quantidadeDeNumerosPrimosEncontrados() {
        int quantidade = 0;
        for(int i = 2; i < naoPrimos.length; i++) {
            if (marcadoComoPrimo(i)) {
                quantidade++;
            }
        }
        return quantidade;
    }

    private static void desmarcarMultiplosDePrimos() {
        int limite = determinarLimiteDaIteracao();
        for(int i = 2; i <= limite; i++) {
            if (marcadoComoPrimo(i)) {
                desmarcarMultiplosDe(i);
            }
        }
    }

    private static void desmarcarMultiplosDe(int i) {
        for(int multiplo = 2 * i; multiplo < naoPrimos.length; multiplo += i) {
            naoPrimos[multiplo] = true;
        }
    }

    private static boolean marcadoComoPrimo(int i) {
        return naoPrimos[i] == false;
    }

    private static int determinarLimiteDaIteracao() {
        return (int) Math.sqrt(naoPrimos.length);
    }

    private static void desmarcarNumerosAte(int valorMaximo) {
        naoPrimos = new boolean[valorMaximo + 1];
        for(int i = 2; i < naoPrimos.length; i++) {
            naoPrimos[i] = false;
        }
    }
}
