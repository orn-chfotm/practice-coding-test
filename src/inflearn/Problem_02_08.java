package inflearn;

import java.util.Scanner;

public class Problem_02_08 {

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int score = arr[i];
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (score < arr[j]) {
                    rank = rank + 1;
                }
            }
            answer[i] = rank;
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem_02_08 problem = new Problem_02_08();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int rank : problem.solution(n, arr)) {
            System.out.print(rank + " ");
        }
    }
}
