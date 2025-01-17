package packjon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2178 {

    static int map[][];
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            /* init */
            map = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            bfs();
            bw.write(map[N - 1][M - 1] + "");
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] start = {0, 0};
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        int[] position = {nextX, nextY};
                        queue.offer(position);

                        map[nextX][nextY] = map[now[0]][now[1]]  + 1;
                    }
                }
            }
        }
    }
}
