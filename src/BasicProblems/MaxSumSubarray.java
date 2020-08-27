package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * An array is given, find length of the subarray having maximum sum.
 */

public class MaxSumSubarray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Length of subarray of max sum: "+findMaxSumLenSubarray(arr));

    }

    public static int findMaxSumLenSubarray(int[] arr){
        int[] sums = new int[arr.length+1];
        int[] lengths = new int[arr.length+1];

        for(int i=1;i<=arr.length; i++){
            if(arr[i-1] + sums[i-1] > arr[i-1]){
                sums[i] = sums[i-1]+arr[i-1];
                lengths[i] = lengths[i-1]+1;
            }else {
                sums[i] = arr[i-1];
                lengths[i] = 1;
            }
        }

        Arrays.stream(sums).forEach(element -> System.out.print(element+" "));
        System.out.println();
        Arrays.stream(lengths).forEach(element -> System.out.print(element+" "));
        System.out.println();
        int max = Arrays.stream(sums).max().getAsInt();
        int maxIndex = 0;
        for(int i=0;i<=arr.length;i++){
            if(max == sums[i]){
                maxIndex = i;
                break;
            }
        }

        return lengths[maxIndex];
    }
}
