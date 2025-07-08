package inflearn.problem_06;

import java.util.Scanner;

public class Problem_06_06 {

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[2];

        for (int i = 0; i < n; i++) {
            boolean check = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                    check = true;
                }
            }
            if (check) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem_06_06 main = new Problem_06_06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : main.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
