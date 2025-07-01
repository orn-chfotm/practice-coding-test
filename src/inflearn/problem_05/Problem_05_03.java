package inflearn.problem_05;

import java.util.Scanner;
import java.util.Stack;

public class Problem_05_03 {

    public int solution(int n, int[][] map, int m, int[] moves) {
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < m; i++) {
            int x = moves[i] - 1;
            for (int y = 0; y < n; y++) {
                if (map[y][x] > 0) {
                    if (!stack.isEmpty() && stack.peek() == map[y][x]) {
                        stack.pop();
                        count++;
                    } else {
                        stack.push(map[y][x]);
                    }
                    map[y][x] = 0;
                    break;
                }
            }
        }

        return count * 2;
    }

    public static void main(String[] args) {
        Problem_05_03 problem = new Problem_05_03();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(problem.solution(n, map, m, moves));
    }
}
