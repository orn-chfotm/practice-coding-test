package inflearn.problem_07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_07_08 {

    int[] move = {1, -1, 5};
    int[] visited = new int[10001];

    public int solution(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int j = 0; j < move.length; j++) {
                int next = current + move[j];
                if (next == e) {
                    return visited[current] + 1;
                } else if (next >= 1 && next <= 10000 && visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    queue.add(next);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem_07_08 main = new Problem_07_08();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(main.solution(s, e));
    }
}
