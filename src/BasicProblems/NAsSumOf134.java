package BasicProblems;

import java.util.Scanner;

/**
 * Given N, count the number of ways to express N as sum of 1, 3 and 4.
 */

public class NAsSumOf134 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("Total number of ways: "+findWays(n));
    }

    public static int findWays(int n){
        int[] dp  = new int[n+1];

        dp[0] =1; dp[1] = 1; dp[2] = 1; dp[3] = 2;

        for(int i=4; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
        }

        return dp[n];
    }
}
