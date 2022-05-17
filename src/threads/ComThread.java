 
package threads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author dailonreichert
 */
public class ComThread {

    static void multiplicaMatriz(int row1, int col1, int A[][],
                                 int row2, int col2, int B[][]) throws InterruptedException{
 
        if (row2 != col1) {
            System.out.println("\nMultiplication Not Possible");

            return;
        }

        for (int i = 0; i < row1; i++) {
            MyThread minhaThread = new MyThread(A, B, i, col2, row2);
            minhaThread.start();
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException{
        /*macOS*/
        int linhaColuna1[] = getQuantidadeLinhaColuna(Const.CASO_2_A_MAC);
        int matriz1[][]    = getMatriz(Const.CASO_2_A_MAC, linhaColuna1[0], linhaColuna1[1]);
        int linhaColuna2[] = getQuantidadeLinhaColuna(Const.CASO_2_B_MAC);
        int matriz2[][]    = getMatriz(Const.CASO_2_B_MAC, linhaColuna2[0], linhaColuna2[1]);

        /*Windows*/
        /*int linhaColuna1[] = getQuantidadeLinhaColuna("C:/Users/dailo/Documents/caso1/A.txt");
        int matriz1[][]    = getMatriz("C:/Users/dailo/Documents/caso1/A.txt", linhaColuna1[0], linhaColuna1[1]);

        int linhaColuna2[] = getQuantidadeLinhaColuna("C:/Users/dailo/Documents/caso1/B.txt");
        int matriz2[][]    = getMatriz("C:/Users/dailo/Documents/caso1/B.txt", linhaColuna2[0], linhaColuna2[1]);*/

        multiplicaMatriz(linhaColuna1[0], linhaColuna1[1], matriz1,
                         linhaColuna2[0], linhaColuna2[1], matriz2);
    }

    public static int [][] getMatriz(String file, int qntLinha, int qntColuna) throws FileNotFoundException, IOException{
        int linha = 0;
        String line;
        int matrizCompleta[][] = new int[qntLinha][qntColuna];

        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            if(linha == 0 || linha == 1){
                linha++;
                continue;
            }

            int i = linha - 2;
            String[] colunaMatriz = line.split(" ");

            for (int j = 0; j < colunaMatriz.length; j++) {
                matrizCompleta[i][j] = Integer.parseInt(colunaMatriz[j]);
            }

            linha++;
        }

        return matrizCompleta;
    }

    public static int[] getQuantidadeLinhaColuna(String file) throws FileNotFoundException, IOException{
        int linhaColuna[] = {0 , 0};
        String line;
        int linha = 1;

        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            if(linha == 1){
                linhaColuna[0] = Integer.parseInt(line);
            }

            if(linha == 2){
                linhaColuna[1] = Integer.parseInt(line);
            }

            linha++;
        }

        return linhaColuna;
    }
    
}
