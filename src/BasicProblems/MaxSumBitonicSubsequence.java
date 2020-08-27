package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of integers. A subsequence of arr[] is called Bitonic if it is first increasing, then decreasing.
 *
 * Input : arr[] = {1, 15, 51, 45, 33,
 *                    100, 12, 18, 9}
 * Output : 194
 * Explanation : Bi-tonic Sub-sequence are :
 *              {1, 51, 9} or {1, 50, 100, 18, 9} or
 *              {1, 15, 51, 100, 18, 9}  or
 *              {1, 15, 45, 100, 12, 9}  or
 *              {1, 15, 45, 100, 18, 9} .. so on
 * Maximum sum Bi-tonic sub-sequence is 1 + 15 +
 * 51 + 100 + 18 + 9 = 194
 *
 * Input : arr[] = {80, 60, 30, 40, 20, 10}
 * Output : 210
 */

public class MaxSumBitonicSubsequence {

    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(findMaxSumBitonicSubsequence());
    }

    public static int findMaxSumBitonicSubsequence(){
        int[] MSIBS = new int[arr.length];
        int[] MSDBS = new int[arr.length];
        int[] BS = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            int currMax = 0;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    currMax = Math.max(MSIBS[j], currMax);
                }
            }
            MSIBS[i] = currMax+arr[i];
        }

        for(int i=arr.length-1; i>=0; i--){
            int currMax = 0;
            for(int j=arr.length-1; j>i; j--){
                if(arr[i] > arr[j]){
                    currMax = Math.max(MSDBS[j], currMax);
                }
            }
            MSDBS[i] = currMax+arr[i];
            BS[i] = MSIBS[i] + MSDBS[i] - arr[i];
        }

        return Arrays.stream(BS).max().getAsInt();
    }
}
