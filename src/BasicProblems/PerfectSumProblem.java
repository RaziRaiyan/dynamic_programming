package BasicProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array of integers and a sum, the task is to print all subsets of given array with sum equal to given sum.
 *
 * Examples:
 *
 * Input : arr[] = {2, 3, 5, 6, 8, 10}
 *         sum = 10
 * Output : 5 2 3
 *          2 8
 *          10
 *
 * Input : arr[] = {1, 2, 3, 4, 5}
 *         sum = 10
 * Output : 4 3 2 1
 *          5 3 2
 *          5 4 1
 */

public class PerfectSumProblem {

    static int[] arr;
    List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n];
        for(int i=0; i< n;i++){
            arr[i] = scanner.nextInt();
        }
    }

    public static void perfectSumBottomUp(){

    }
}
