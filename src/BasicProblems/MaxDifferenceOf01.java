package BasicProblems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxDifferenceOf01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String binaryString = scanner.nextLine();

        char[] val = new char[12];

        Integer[] arr = IntStream.range(0, binaryString.length()).mapToObj(i -> binaryString.charAt(i) == '1' ? -1: 1)
                .toArray(Integer[]::new);

        System.out.println("Max difference of os and 1s are:"+findMaxSubArraySum(arr));

    }

    public static int findMaxSubArraySum(Integer[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for(int i=1; i<dp.length; i++){
            dp[i] = Math.max(arr[i], arr[i]+dp[i-1]);
        }

        Arrays.stream(dp).forEach(element -> System.out.print(element+" "));
        System.out.println();

        return Arrays.stream(dp).max().getAsInt();
    }
}
