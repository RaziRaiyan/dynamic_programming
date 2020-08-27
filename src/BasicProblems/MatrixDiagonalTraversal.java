package BasicProblems;

import java.util.Scanner;

public class MatrixDiagonalTraversal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] mat = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n; j++){
                mat[i][j] = scanner.nextInt();
            }
        }

        printMatrixDiagonally(mat);
    }

    public static void printMatrixDiagonally(int[][] mat){
        int n = mat.length;

        for(int j=0; j<n; j++){
            for(int i=0; i< n-j; i++){
                System.out.print(mat[i][j+i]+" ");

            }
            System.out.println();
        }
    }
}
