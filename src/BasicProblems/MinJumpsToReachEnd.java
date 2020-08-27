package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element.
 * Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element).
 * If an element is 0, they cannot move through that element.
 */

public class MinJumpsToReachEnd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Minimum Jump required: "+countMinJump(arr));
    }

    public static int countMinJump(int[] arr){

        int[] dp = new int[arr.length];
        for(int i=1;i<arr.length; i++){
            int currMin = Integer.MAX_VALUE;
            for(int j=0; j<i; j++){
//                System.out.println("Here with: j="+j+" arr[j]="+arr[j]+" i="+i);
                if(j+arr[j] >= i){
                    currMin = Math.min(currMin, dp[j]);
                }
            }
            dp[i] = currMin+1;
        }

        Arrays.stream(dp).forEach(element -> System.out.print(element+" "));
        return dp[arr.length-1];
    }
}
