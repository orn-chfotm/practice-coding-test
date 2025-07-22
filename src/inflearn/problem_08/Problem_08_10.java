package inflearn.problem_08;

import java.util.Scanner;

public class Problem_08_10 {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] visited;
    int count = 0;

    public int solution(int[][] map) {
        visited = new boolean[map.length][map[0].length];
        visited[0][0] = true;
        dfs(0, 0, map);

        return count;
    }

    public void dfs(int x, int y, int[][] map) {
        int mapSize = map.length;
        if (x == mapSize - 1 && y == mapSize - 1) {
            count++;
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx < mapSize && ny >= 0 && ny < mapSize) {
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, map);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int size = 7;
        int[][] map = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Problem_08_10 main = new Problem_08_10();
        System.out.println(main.solution(map));
    }
}
