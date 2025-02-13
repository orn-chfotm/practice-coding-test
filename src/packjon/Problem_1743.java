package packjon;

import java.io.*;
import java.util.*;

public class Problem_1743 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M, K, count;

    public static void main(String[] args) throws IOException {

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N + 1][M + 1];
            visited = new boolean[N + 1][M + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        max = Math.max(max, count);
                        count = 0;
                    }
                }
            }

            bw.write(max + "");
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;

            if (nextX < 1 || nextY < 1 || nextX > N || nextY > M) continue;
            if (map[nextX][nextY] == 0 || visited[nextX][nextY]) continue;

            dfs(nextX, nextY);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        count++;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + current[0];
                int nextY = dy[i] + current[1];

                if (nextX < 1 || nextY < 1 || nextX > N || nextY > M) continue;
                if (map[nextX][nextY] == 0 || visited[nextX][nextY]) continue;

                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                count++;
            }
        }
    }
}
