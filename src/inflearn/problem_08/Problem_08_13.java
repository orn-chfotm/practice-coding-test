package inflearn.problem_08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_08_13 {

    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    boolean[][] visited;
    int n;
    int[][] arr;

    public int solution(int n, int[][] arr) {
        this.n = n;
        this.arr = arr;
        visited = new boolean[n][n];

        int answer = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (arr[y][x] == 1 && !visited[y][x]) {
                    answer++;
                    bfs(x, y);
                }
            }
        }

        return answer;
    }

    private void bfs(int x, int y) {
        Queue<Path> queue = new LinkedList<>();
        queue.offer(new Path(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Path current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (arr[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new Path(nx, ny));
                    }
                }
            }
        }
    }

    public static class Path {
        int x;
        int y;

        public Path(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                arr[y][x] = sc.nextInt();
            }
        }

        Problem_08_13 main = new Problem_08_13();
        System.out.println(main.solution(n, arr));
    }
}
