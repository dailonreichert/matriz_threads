
package threads;

/**
 *
 * @author dailonreichert
 */
public class MyThread extends Thread {

    int[][] matrizA;
    int[][] matrizB;
    int linha;
    int coluna;
    int qntColunas;

    public MyThread(int[][] matrizA, int[][] matrizB, int linha, int coluna, int qntColunas) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.linha = linha;
        this.coluna = coluna;
        this.qntColunas = qntColunas;
    }
    
    @Override
    public void run() {
        for (int j = 0; j < coluna; j++) {
            int valor = 0;

            for (int k = 0; k < qntColunas; k++){
                valor += matrizA[linha][k] * matrizB[k][j];
            }

            System.out.print(valor + " ");
        }

        System.out.println();
    }
    
}
