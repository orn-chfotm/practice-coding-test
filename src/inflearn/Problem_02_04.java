package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_02_04 {
    public static int[] solution1(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr;
    }

    public static void solution2(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /* solution1
        for (int num : solution1(n)) {
            System.out.print(num + " ");
        }*/

        solution2(n);
    }
}
