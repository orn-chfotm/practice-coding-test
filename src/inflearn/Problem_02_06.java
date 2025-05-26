package inflearn;

import java.util.Scanner;

public class Problem_02_06 {

    public static void solution(int[] arr) {
        for (int num : arr) {
            boolean check = false;

            if (num >= 2 && num <= 3) {
                System.out.print(num + " ");
                continue;
            } else if (num < 2) {
                continue;
            }

            for (int i = 2; i <= num - 1; i++) {
                if (num % i == 0) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                System.out.print(num + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            String str = sc.next();
            String reverse = "";
            for (int j = str.length() - 1; j >= 0; j--) {
                reverse += str.charAt(j);
            }

            arr[i] = Integer.parseInt(reverse);
        }

        solution(arr);
    }
}
