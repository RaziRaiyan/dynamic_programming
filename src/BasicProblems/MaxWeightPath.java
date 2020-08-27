package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a matrix of integers where every element represents weight of the cell.
 * Find the path having the maximum weight in matrix [N X N]. Path Traversal Rules are:
 *
 * It should begin from top left element.
 * The path can end at any element of last row.
 * We can move to following two cells from a cell (i, j).
 * Down Move : (i+1, j)
 * Diagonal Move : (i+1, j+1)
 */

public class MaxWeightPath {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] mat = new int[n][m];

        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Max weight: "+maxWeightPath(mat));
    }

    public static int maxWeightPath(int[][] mat){
        int[][] dp = new int[mat.length][mat[0].length];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<=Math.min(i, mat[0].length-1); j++){
                if(i == 0 && j==0){
                    dp[i][j] = mat[i][j];
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j] + mat[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+mat[i][j];
                }
            }
        }

        Arrays.stream(dp).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element+" "));
            System.out.println();
        });

        return Arrays.stream(dp[mat.length-1]).max().getAsInt();
    }
}
