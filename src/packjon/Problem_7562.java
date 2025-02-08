package packjon;

import java.io.*;
import java.util.*;

public class Problem_7562 {

    static boolean[][] visited;
    static int[][] board;
    static int dx[] = {2, 1, -1, -2, -2, -1, 1, 2};
    static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static int I, targetX, targetY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());

            board = new int[I][I];
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            bfs(x, y);
            sb.append(board[targetX][targetY] + "\n");
        }
        System.out.println(sb.toString().trim());
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int currentX = point[0];
            int currentY = point[1];

            for(int i = 0; i < 8; i++) {
                int nextX = dx[i] + currentX;
                int nextY = dy[i] + currentY;

                if (nextX >= 0 && nextY >= 0 && nextX < I && nextY < I) {
                    if (!visited[nextX][nextY]) {
                        queue.offer(new int[]{nextX, nextY});
                        board[nextX][nextY] = board[point[0]][point[1]] + 1;
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
