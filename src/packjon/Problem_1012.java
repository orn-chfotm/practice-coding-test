package packjon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1012 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static int M, N;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int T = Integer.parseInt(br.readLine());

            StringTokenizer st;

            for (int t = 0; t < T; t++) {
                st = new StringTokenizer(br.readLine());
                M = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());
                map = new int[M][N];
                visited = new boolean[M][N];

                for (int i = 0; i < K; i++) {
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    map[x][y] = 1;
                }

                int warm = 0;
                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] == 1 && !visited[i][j]) {
                            bfs(i, j);
                            warm++;
                        }
                    }
                }

                bw.write(warm + "\n");
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
                    if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
