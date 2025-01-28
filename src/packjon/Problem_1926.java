package packjon;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Problem_1926 {

    static int n, m;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];

        int paint = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 1) paint++;
            }
        }

        if (paint == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && paper[i][j] == 1) {
                    pating(new Point(i, j));
                }
            }
        }

        System.out.println(result.size());
        int max = Integer.MIN_VALUE;
        for (int num : result) {
            max = Math.max(max, num);
        }
        System.out.println(max);
    }

    static void pating(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        visited[point.x][point.y] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + current.x;
                int nextY = dy[i] + current.y;

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (paper[nextX][nextY] == 0 || visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                queue.offer(new Point(nextX, nextY));
                count++;

            }
        }
        result.add(count);
    }
}
