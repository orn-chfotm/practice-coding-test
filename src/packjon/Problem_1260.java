package packjon;

import java.io.*;
import java.util.*;

public class Problem_1260 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] branch;

    static int node, line, start;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        branch = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            branch[a][b] = branch[b][a] = 1;
        }

        dfs(start);
        sb.append("\n");
        Arrays.fill(check, false);

        bfs(start);
        System.out.println(sb.toString());
    }

    public static void dfs(int start) {
        check[start] = true;
        sb.append(start + " ");

        for (int i = 0; i <= node; i++) {
            if(branch[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start + " ");

            for (int i = 0; i <= node; i++) {
                if(branch[start][i] == 1 && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
