package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 *
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 */

public class CuttingRodProblem {

    static int[] cutPrices;
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rodLength = scanner.nextInt();
        cutPrices = new int[rodLength];
        dp = new int[rodLength+1];

        for(int i=0; i<rodLength;i++){
            cutPrices[i] = scanner.nextInt();
        }

        maxPriceBottomUp();

        Arrays.stream(dp).forEach(val -> System.out.print(val+" "));
    }

    public static int maxPriceBottomUp(){

        // Base case: Make n cuts of length 1 for rod of length n
        for(int i=1; i<dp.length; i++){
            dp[i] = cutPrices[0]*i;
        }

        Arrays.stream(dp).forEach(val -> System.out.print(val+" "));

        System.out.println();

        for(int i=1; i<cutPrices.length; i++){
            for(int j=i; j<dp.length; j++){
                dp[j] = Math.max(dp[j], cutPrices[i-1]+dp[j-i]);
            }

            Arrays.stream(dp).forEach(val -> System.out.print(val+" "));
            System.out.println();
        }
        System.out.println();

        return dp[dp.length-1];

    }
}
