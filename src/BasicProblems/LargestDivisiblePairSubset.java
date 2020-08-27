package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of n distinct elements, find length of the largest subset such that every pair
 * in the subset is such that the larger element of the pair is divisible by smaller element.
 *
 * Input : arr[] = {10, 5, 3, 15, 20}
 * Output : 3
 * Explanation: The largest subset is 10, 5, 20.
 * 10 is divisible by 5, and 20 is divisible by 10.
 *
 * Input : arr[] = {18, 1, 3, 6, 13, 17}
 * Output : 4
 * Explanation: The largest subset is 18, 1, 3, 6,
 * In the subsequence, 3 is divisible by 1,
 * 6 by 3 and 18 by
 */

public class LargestDivisiblePairSubset {

    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        arr = new int[n];

        for(int i=0; i<n;i++){
            arr[i] = scanner.nextInt();
        }
    }

    public static int largestDivisiblePairSubsetBottomUp(){
        int[] dp = new int[arr.length];
        Arrays.sort(arr);
        dp[dp.length-1] = 1;

        for(int i=arr.length-2; i>=0; i--){
            int maxm = 0;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] % arr[i] == 0){
                    maxm = Math.max(maxm, dp[j]);
                }
            }
            dp[i] = maxm +1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
