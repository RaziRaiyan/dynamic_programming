package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of
 * S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 *
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions:
 * {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */

public class CoinChangeProblem {

    static int[] coins;
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int amount = scanner.nextInt();

        coins = new int[n];
        dp = new int[amount+1];

        for(int i=0; i<n; i++){
            coins[i] = scanner.nextInt();
        }

        System.out.println("Coin Exchange by bottom up approach");
        long time = System.nanoTime();
        int total = coinExchangeBottomUp(amount);
        time = System.nanoTime() - time;
        Arrays.stream(dp).forEach(element -> System.out.print(element+" "));
        System.out.println("\nTime taken: "+time);


    }

    static int coinExchangeBottomUp(int amount){
        // Base case
        dp[0] = 1;

        for(int i=0; i<coins.length; i++){
            for(int j=coins[i]; j<=amount; j++){
                dp[j] += dp[j-coins[i]];
            }
        }

        return dp[amount];
    }


}
