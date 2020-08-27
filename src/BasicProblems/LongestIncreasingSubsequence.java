package BasicProblems;

import java.util.Scanner;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence
 * of a given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 *
 */

public class LongestIncreasingSubsequence {

    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        arr = new int[n];

        for(int i=0; i<n;i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(findLongestIncreasingSubsequence());
    }

    public static int findLongestIncreasingSubsequence(){
        int[] dp = new int[arr.length];

        for (int i=0; i<dp.length; i++){
            int currMax = 0;
            for(int j=0; j<i;j++){
                if(arr[i] > arr[j])
                    currMax = Math.max(currMax, dp[j]);
            }
            dp[i] = currMax+1;
        }

        return dp[arr.length-1];
    }
}
