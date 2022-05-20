 
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

    static void printMatriz(int M[][], int rowSize, int colSize){
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++){
                System.out.print(M[i][j] + " ");
            } 
                
            System.out.println();
        }
    }

    static void multiplicaMatriz(int row1, int col1, int A[][],
                                 int row2, int col2, int B[][]) throws InterruptedException{
 
        if (row2 != col1) {
            System.out.println("\nMultiplication Not Possible");

            return;
        }

        int C[][] = new int[row1][col2];
        int threads = 8;
        int quantidadeCadaThread = row1 / threads;
        //int threads = 8;
  
        //Quando a quantidade de threads for a quantidade de linhas
        for (int i = 0; i < row1; i++) {
            MyThread2 minhaThread = new MyThread2(A, B, C, i, col2, row2);
            minhaThread.start();
            //minhaThread.join();
        }

        //Quando a quantidade de threads for igual a 2
        /*MyThread minhaThread = new MyThread(A, B, C, col2, row2);
        minhaThread.setIntervaloInicial(0);
        minhaThread.setIntervaloFinal(quantidadeCadaThread);
        minhaThread.start();

        MyThread minhaThread2 = new MyThread(A, B, C, col2, row2);
        minhaThread2.setIntervaloInicial(quantidadeCadaThread);
        minhaThread2.setIntervaloFinal(row1);
        minhaThread2.start();*/

        //Quando a quantidade de threads for maior que 2
        /*MyThread minhaThread = new MyThread(A, B, C, col2, row2);
        minhaThread.setIntervaloInicial(0);
        minhaThread.setIntervaloFinal(quantidadeCadaThread);
        minhaThread.start();

        for (int i = 2; i <= threads - 1; i++) {
            int inicioIntervalo = ((i - 1) * quantidadeCadaThread) + 1;
            int fimIntervalo = i * quantidadeCadaThread;

            MyThread minhaThread2 = new MyThread(A, B, C, col2, row2);
            minhaThread2.setIntervaloInicial(inicioIntervalo);
            minhaThread2.setIntervaloFinal(fimIntervalo);
            minhaThread2.start();
        }
        
        MyThread minhaThread3 = new MyThread(A, B, C, col2, row2);
        minhaThread3.setIntervaloInicial((quantidadeCadaThread * (threads - 1)) + 1);
        minhaThread3.setIntervaloFinal(row1);
        minhaThread3.start();*/

        //System.out.println("\nResultant Matrix:");
        //printMatriz(C, row1, col2);
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
