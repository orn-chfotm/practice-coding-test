package inflearn.problem_08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_08_11 {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] visited;

    static class Path {
        int x;
        int y;
        int depth;

        public Path(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int solution(int[][] map) {
        int mapLength = map.length;
        visited = new boolean[mapLength][map[0].length];
        Queue<Path> queue = new LinkedList<>();
        queue.offer(new Path(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Path current = queue.poll();

            if (current.x == mapLength - 1 && current.y == mapLength - 1) {
                return current.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < mapLength && ny < mapLength) {
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Path(nx, ny, current.depth + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        final int mapSize = 7;
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Problem_08_11 main = new Problem_08_11();
        System.out.println(main.solution(map));
    }
}
