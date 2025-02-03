package packjon;

import java.io.*;
import java.util.*;

public class Problem_2210 {

    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Set<String> result;
    static StringBuilder sb;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            map = new int[5][5];

            StringTokenizer st;
            for(int i = 0; i < 5; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 5; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb = new StringBuilder();
            result = new HashSet<>();
            temp = new int[6];
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    dfs(i, j, 0);
                }
            }
            bw.write(result.size() + "");
        }
    }

    static void dfs(int x, int y, int depth) {
        if (depth == 6) {
            Arrays.stream(temp)
                    .forEach(i -> sb.append(i));
            result.add(sb.toString());
            sb.delete(0, sb.length());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= 5 || nextY >= 5) continue;

            temp[depth] = map[nextX][nextY];
            dfs(nextX, nextY, depth + 1);
        }
    }
}
