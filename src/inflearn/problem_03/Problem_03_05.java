package inflearn.problem_03;

import java.util.Scanner;

public class Problem_03_05 {

    public int solution(int n) {
        int result = 0, left = 1, right = 1, max = n / 2 + 1, sum = 0;

        while (true) {
            if (sum >= n) {
                if (sum == n) result++;
                sum -= left++;
            } else {
                if (right > max) break;
                sum += right++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem_03_05 problem = new Problem_03_05();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(problem.solution(n));
    }
}
