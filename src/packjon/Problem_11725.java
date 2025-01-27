package packjon;

import java.io.*;
import java.util.*;

public class Problem_11725 {

    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(br.readLine());
        visited = new boolean[node + 1];
        parents = new int[node + 1];

        for (int i = 0 ; i <= node; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < node -1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeX = Integer.parseInt(st.nextToken());
            int nodeY = Integer.parseInt(st.nextToken());

            edges.get(nodeX).add(nodeY);
            edges.get(nodeY).add(nodeX);
        }

        dfs(1);
        Arrays.stream(parents)
                .skip(2)
                .forEach(System.out::println);

        br.close();
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int i : edges.get(start)) {
            if (visited[i]) continue;

            parents[i] = start;
            dfs(i);
        }
    }
}
