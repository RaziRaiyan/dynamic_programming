package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

public class MinCostToMatrixChainMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] dimensions = new int[n];

        for(int i=0; i<n; i++){
            dimensions[i] = scanner.nextInt();
        }

        System.out.println("Minimum cost of matrix chain multiplication: "+findMinCost(dimensions));
    }

    public static int findMinCost(int[] dimensions){
        int n = dimensions.length-1;
        int[][] dp = new int[n][n];

        for(int l=1; l<n; l++){
            for(int i=0; i<n-l; i++){
                int j = i+l;
                int currMin = Integer.MAX_VALUE;
//                System.out.println("i:"+i+" j:"+j);
                for(int k=i; k<j; k++){
//                    System.out.println("k:"+k);
                    currMin = Math.min(currMin, dp[i][k]+dp[k+1][j]+dimensions[i]*dimensions[k+1]*dimensions[j+1]);
                }
                dp[i][j] = currMin;
            }
        }

        Arrays.stream(dp).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element+" "));
            System.out.println();
        });

        return dp[0][n-1];
    }
}
