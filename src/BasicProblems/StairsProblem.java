package BasicProblems;

import java.util.Scanner;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 *
 * Therefore, dp[i] = dp[i-1]+dp[i-2]+dp[i-3]
 * with base cases: dp[0] = 1, dp[1] = 1, dp[2] = 2
 */

public class StairsProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("Total number of ways: "+findWays(n));
    }

    public static int findWays(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }


}
