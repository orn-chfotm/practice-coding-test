package packjon;

import java.io.*;
import java.util.*;

public class Problem_1260 {

    static int[][] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            /* 정점의 갯수 -> Map size */
            int N = Integer.parseInt(st.nextToken());
            /* 간선의 갯수 -> 반복 횟수 */
            int M = Integer.parseInt(st.nextToken());
            /* 시작 정점 번호 */
            int V = Integer.parseInt(st.nextToken());

            map = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = map[y][x] = 1;
            }

            dfs(V);
            sb.append(System.lineSeparator());
            bw.write(sb.toString());
            sb.setLength(0);

            Arrays.fill(visited, false);

            bfs(V);
            bw.write(sb.toString());
            bw.flush();
        }
    }

    public static void dfs(int road) {
        write(road);

        int[] roads = map[road];
        for (int i = 1; i < roads.length; i++) {
            if (roads[i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int road) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(road);
        write(road);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int[] roads = map[now];

            for (int i = 1; i < roads.length; i++) {
                if (roads[i] == 1 && !visited[i]) {
                    queue.offer(i);
                    write(i);
                }
            }
        }
    }

    private static void write(int road) {
        visited[road] = true;
        sb.append(road).append(" ");
    }
}
