package packjon;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2667 {

    static int M, N, K;
    static int[][] graph;
    static boolean[][] visited;
    static int[] positionX = {1, -1, 0, 0};
    static int[] positionY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                M = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());

                graph = new int[M][N];
                visited = new boolean[M][N];
                int count = 0;

                for (int j = 0; j < K; j++) {
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    graph[x][y] = 1;
                }

                for (int x = 0; x < M; x++) {
                    for (int y = 0; y < N; y++) {
                        if (graph[x][y] == 1 && !visited[x][y]) {
                            dfs(x, y);
                            count++;
                        }
                    }
                }
                bw.write(count + "\n");
            }
            bw.write(sb.toString());
        }
    }

    static void dfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            visited[point.x][point.y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = positionX[i] + point.x;
                int nextY = positionY[i] + point.y;

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
                if (graph[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }
    }
}
