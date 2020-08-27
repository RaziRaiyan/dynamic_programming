package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumOf2XNMatrixWithNoAdjacents {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] mat = new int[2][n];

        for(int i=0; i<2; i++){
            for(int j=0;j<n; j++){
                mat[i][j] = scanner.nextInt();
            }
        }

        findMaxSumNoAdjacent(mat);
    }

    public static int findMaxSumNoAdjacent(int[][] mat){
        int[][] dp = new int[2][mat[0].length];

        dp[0][0] = mat[0][0];
        dp[1][0] = mat[1][0];

        dp[0][1] = Math.max(mat[0][1], Math.max(mat[0][0], mat[1][0]));
        dp[1][1] = Math.max(mat[1][1], Math.max(mat[0][0], mat[1][0]));

        for(int j=2; j<mat[0].length; j++){
            for(int i=0; i<2; i++){
                dp[i][j] = Math.max(Math.max(dp[0][j-2],dp[1][j-2])+mat[i][j], Math.max(dp[0][j-1], dp[1][j-1]));
            }
        }

        Arrays.stream(dp).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element+" "));
            System.out.println();
        });

        return Math.max(dp[0][mat.length-1], dp[1][mat.length-1]);
    }
}
