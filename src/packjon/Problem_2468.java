package packjon;

import java.io.*;
import java.util.*;

public class Problem_2468 {

    static int[][] map;
    static boolean[][] visited;
    static int N;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            int maxHight = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHight = Math.max(maxHight, map[i][j]);
                }
            }

            int max = 0;
            for (int hight = 0; hight <= maxHight; hight++) {
                visited = new boolean[N][N];
                int count = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] > hight && !visited[i][j]) {
                            bfs(i, j, hight);
                            count++;
                        }
                    }
                }
                max = Math.max(max, count);
            }

            bw.write(max + "");
        }
    }

    static void bfs(int x, int y, int hight) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + currentPoint.x;
                int nextY = dy[i] + currentPoint.y;

                if(nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length) continue;
                if(visited[nextX][nextY]) continue;
                if(map[nextX][nextY] > hight) {
                    queue.offer(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
