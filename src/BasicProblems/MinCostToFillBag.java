package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

public class MinCostToFillBag {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Minimum costs to weight: "+findMinCostToWeight(arr, n));
    }

    public static int findMinCostToWeight(int[] costs, int weight){
        int[][] dp = new int[costs.length][weight+1];

        for(int j=1; j<dp[0].length; j++){
            dp[0][j] = costs[0]*j;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j >= i)
                    dp[i][j] = Math.min(dp[i][j-i]+costs[i-1], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        Arrays.stream(dp).forEach(row -> {
            Arrays.stream(row).forEach(element -> System.out.print(element+" "));
            System.out.println();
        });

        return dp[dp.length-1][dp[0].length-1];
    }
}
