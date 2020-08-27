package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a number n, we can divide it in only three parts n/2, n/3 and n/4 (we will consider only integer part).
 * The task is to find the maximum sum we can make by dividing number in three parts recursively and summing up them together.
 *
 * Input : n = 12
 * Output : 13
 * // We break n = 12 in three parts {12/2, 12/3, 12/4}
 * // = {6, 4, 3},  now current sum is = (6 + 4 + 3) = 13
 * // again we break 6 = {6/2, 6/3, 6/4} = {3, 2, 1} = 3 +
 * // 2 + 1 = 6 and further breaking 3, 2 and 1 we get maximum
 * // summation as 1, so breaking 6 in three parts produces
 * // maximum sum 6 only similarly breaking 4 in three
 * // parts we can get maximum sum 4 and same for 3 also.
 * // Thus maximum sum by breaking number in parts  is=13
 *
 */

public class RecursiveNumberBreak {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println("Max break sum: "+ breakSumBottomUp(n));

    }

    public static int breakSumBottomUp(int n){
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = Math.max(dp[i/2]+dp[i/3]+dp[i/4], i);
        }

        Arrays.stream(dp).forEach(element -> System.out.print(element+" "));

        return dp[n];
    }
}
