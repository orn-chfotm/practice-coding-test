package packjon;

import java.io.*;
import java.util.*;

public class Problem_21736 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int start_x, start_y;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count;

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            visited = new boolean[N][M];
            count = 0;

            for (int i = 0; i < N; i++) {
                String str = br.readLine();

                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == 'I') {
                        start_x = i;
                        start_y = j;
                    }
                }
            }

            bfs(start_x, start_y);
            bw.write(count == 0 ? "TT" : count + "");
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
            if (map[nextX][nextY] == 'X' || visited[nextX][nextY]) continue;
            if (map[nextX][nextY] == 'P') {
                count++;
            }
            dfs(nextX, nextY);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + currentPosition[0];
                int nextY = dy[i] + currentPosition[1];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (map[nextX][nextY] == 'X' || visited[nextX][nextY]) continue;
                if (map[nextX][nextY] == 'P') {
                    count++;
                }
                queue.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
    }
}
