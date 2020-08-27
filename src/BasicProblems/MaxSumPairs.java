package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of integers and a number k. We can pair two number of array if difference between them is strictly less than k.
 * The task is to find maximum possible sum of disjoint pairs. Sum of P pairs is sum of all 2P numbers of pairs.
 *
 * Input  : arr[] = {3, 5, 10, 15, 17, 12, 9}, K = 4
 * Output : 62
 * Then disjoint pairs with difference less than K are,
 * (3, 5), (10, 12), (15, 17)
 * So maximum sum which we can get is 3 + 5 + 12 + 10 + 15 + 17 = 62
 * Note that an alternate way to form disjoint pairs is,
 * (3, 5), (9, 12), (15, 17), but this pairing produces lesser sum.
 *
 * Input  : arr[] = {5, 15, 10, 300}, k = 12
 * Output : 25
 *
 * Sort the array first
 * Pair up i with (i-1)th element, i.e.
 *       dp[i] = dp[i-2] + arr[i] + arr[i-1]
 *   Don't pair up, i.e.
 *       dp[i] = dp[i-1]
 */

public class MaxSumPairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        System.out.println("Max sum pairs: "+findMaxSumPairs(arr, k));

    }

    public static int findMaxSumPairs(int[] arr, int k){
        Arrays.sort(arr);

        Arrays.stream(arr).forEach(element -> System.out.print(element+" "));
        System.out.println();
        int[] dp = new int[arr.length+1];
        dp[1] = arr[0];

        for(int i=2; i<=arr.length; i++){
            if(arr[i-1] - arr[i-2] < k){
                dp[i] = Math.max(dp[i-2] + arr[i-1]+arr[i-2], dp[i-1]);
            }else {
                dp[i] = dp[i-1];
            }
        }

        Arrays.stream(dp).forEach(element -> System.out.print(element+" "));
        System.out.println();

        return dp[arr.length];
    }
}
