package packjon;

import java.io.*;
import java.util.*;

public class Problem_24479 {

    static int N, M, R, sortedIndex;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        result = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        graph.forEach(Collections::sort);

        sortedIndex = 1;
        dfs(R);

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        result[start] = sortedIndex;

        for(int i : graph.get(start)) {
            if (visited[i]) continue;

            sortedIndex++;
            dfs(i);
        }
    }
}
