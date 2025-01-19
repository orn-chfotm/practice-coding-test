package packjon;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_2606 {

    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int computers = Integer.parseInt(br.readLine());
            int lines = Integer.parseInt(br.readLine());

            // init
            map = new int[computers + 1][computers + 1];
            visited = new boolean[computers + 1];
            StringTokenizer st;
            for (int i = 0; i < lines; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = map[y][x] = 1;
            }

            /* 첫번째 컴퓨터 카운팅 -> -1 */
            bw.write(dfs(1) - 1 + "");
            bw.flush();
        }
    }

    static int dfs(int start) {
        visited[start] = true;
        int count = 1;
        for (int i = 1; i < map[start].length; i++) {
            if (map[start][i] == 1 && !visited[i]) {
                count += dfs(i);
            }
        }
        return count;
    }

}
