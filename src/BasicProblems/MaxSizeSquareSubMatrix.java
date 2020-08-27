package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 *
 */

public class MaxSizeSquareSubMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] mat = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                mat[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Maximum length of subsquare matrix: "+findMaxLenSquareSumMatrix(mat));
//        findMaxLenSquareSumMatrix(mat);
    }

    public static int findMaxLenSquareSumMatrix(int[][] mat){
        int n = mat.length;
        int m  = mat[0].length;

        int[][] dp = new int[n][m];

        int max = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
//                System.out.println(i+" "+j);
                if(i == 0 || j == 0){
                    dp[i][j] = mat[i][j];
                }else if(mat[i][j] == 1 && mat[i-1][j-1] == 1 && mat[i-1][j] == 1 && mat[i][j-1] ==1){
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }else {
                    dp[i][j] = mat[i][j];
                }

                max = Math.max(dp[i][j], max);
            }
        }

        Arrays.stream(dp).forEach(row -> {
            Arrays.stream(row).forEach(val -> System.out.print(val+" "));
            System.out.println();
        });

        return max;
    }
}
