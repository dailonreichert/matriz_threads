
package threads;

/**
 *
 * @author dailonreichert
 */
public class MyThread extends Thread {

    int[][] matrizA;
    int[][] matrizB;
    int[][] MatrizResultante;
    int linha;
    int coluna;
    int qntColunas;
    int intervaloInicial;
    int intervaloFinal;

    public void setIntervaloInicial(int intervaloInicial) {
        this.intervaloInicial = intervaloInicial;
    }

    public int getIntervaloInicial() {
        return intervaloInicial;
    }

    public void setIntervaloFinal(int intervaloFinal) {
        this.intervaloFinal = intervaloFinal;
    }

    public int getIntervaloFinal() {
        return intervaloFinal;
    }
    
    public MyThread(int[][] matrizA, int[][] matrizB, int[][] matrizResultante, /*int linha,*/ int coluna, int qntColunas) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.MatrizResultante = matrizResultante;
        //this.linha = linha;
        this.coluna = coluna;
        this.qntColunas = qntColunas;
    }

    // utilizado quando a quantidade de threads for uma quantidade fixa
    public void run() {
        for (int i = getIntervaloInicial(); i < getIntervaloFinal(); i++) {
            for (int j = 0; j < coluna; j++) {
                int valor = 0;

                for (int k = 0; k < qntColunas; k++){
                    valor += matrizA[i][k] * matrizB[k][j];

                }

                //System.out.print(valor + " ");

                MatrizResultante[i][j] = valor;
            }
        }
        //System.out.println();
    }
}
