package inflearn.problem_02;

import java.util.Scanner;

public class Problem_02_07 {

    public int solution(int n, int[] arr) {
        int answer = 0;

        int score = 1;
        for (int i : arr) {
            if (i == 1) {
                answer += score;
                score += 1;
            } else {
                score = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem_02_07 problem = new Problem_02_07();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(problem.solution(n, arr));
    }
}
