package inflearn;

import java.util.Scanner;

public class Problem_02_02 {

    public static int solution(int[] arr) {
        int result = 1;
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }
}
