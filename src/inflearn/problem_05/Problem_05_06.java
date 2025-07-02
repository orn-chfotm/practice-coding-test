package inflearn.problem_05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_05_06 {

    public int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int count = 1;
        int prince = queue.poll();
        while (!queue.isEmpty()) {
            if (count == k) {
                count = 1;
            } else {
                count++;
                queue.add(prince);
            }

            prince = queue.poll();
        }

        return prince;
    }

    public static void main(String[] args) {
        Problem_05_06 problem = new Problem_05_06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(problem.solution(n, k));
    }
}
