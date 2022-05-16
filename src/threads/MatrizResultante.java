
package threads;

/**
 *
 * @author dailonreichert
 */
public class MatrizResultante {
    
    int matriz[][] = null;

    public MatrizResultante(int qntLinha, int qntColuna) {
        this.matriz = new int[qntLinha][qntColuna];
    }
    
    public void setValorLinhaColuna(int linha, int coluna, int valor){
        this.matriz[linha][coluna] = valor;
    }

    public int[][] getMatriz() {
        return matriz;
    }
}
