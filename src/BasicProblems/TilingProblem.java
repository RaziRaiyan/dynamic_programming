package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile
 * the given board using the 2 x 1 tiles. A tile can either be placed horizontally
 * i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile.
 *
 * Intuition:
 * Let “count(n)” be the count of ways to place tiles on a “2 x n” grid, we have following two ways to place first tile.
 * 1) If we place first tile vertically, the problem reduces to “count(n-1)”
 * 2) If we place first tile horizontally, we have to place second tile also horizontally. So the problem reduces to “count(n-2)”
 */

public class TilingProblem {

    static int[] counts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        counts = new int[n];

        System.out.println("Tiling problem by bottom up approach");
        long time = System.nanoTime();
        tilingBottomUp(n);
        time = System.nanoTime() - time;
        for(int count: counts){
            System.out.print(count+" ");
        }
        System.out.println("\nTime Taken: "+time+" nanosec");

        Arrays.fill(counts, -1);

        System.out.println("Tiling problem by top down approach");
        time = System.nanoTime();
        tilingTopDown(n-1);
        time = System.nanoTime() - time;
        for(int count: counts){
            System.out.print(count+" ");
        }
        System.out.println("\nTime Taken: "+time+" nanosec");

    }

    public static int tilingBottomUp(int n){
        // Base cases
        counts[0] = 1;
        counts[1] = 2;

        for(int i=2; i<n; i++){
            counts[i] = counts[i-1] + counts[i-2];
        }

        return counts[n-1];
    }

    public static int tilingTopDown(int n){
        // Base cases
        if(n == 0){
            counts[n] = 1;
            return 1;
        }

        if(n == 1){
            counts[1] = 2;
            return 2;
        }

        if(counts[n]  != -1){
            return counts[n];
        }

        counts[n] = tilingTopDown(n-1) + tilingTopDown(n-2);
        return counts[n];
    }
}
