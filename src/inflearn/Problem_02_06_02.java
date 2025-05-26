package inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_02_06_02 {

    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            int res = 0;
            while (temp > 0) {
                int t = temp % 10;
                res = res * 10 + t;
                temp = temp / 10;
            }

            if (isPrime(res)) answer.add(res);
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem_02_06_02 problem = new Problem_02_06_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int num : problem.solution(n, arr)) {
            System.out.print(num + " ");
        }
    }
}
