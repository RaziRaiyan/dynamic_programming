package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in
 * the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should
 * return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
 *
 *
 */

public class MaxSumWithNoAdjacentElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Max sum with no adjacent elements: "+maxSumNoAdjacent(arr));
    }

    public static int maxSumNoAdjacent(int[] arr){
        int[] dp = new int[arr.length];

        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], arr[1]);

        for(int i=2; i<arr.length; i++){
            dp[i] = Math.max(dp[i-2]+arr[i], dp[i-1]);
        }

        Arrays.stream(dp).forEach(element -> System.out.print(element+" "));

        return dp[arr.length-1];
    }
}
