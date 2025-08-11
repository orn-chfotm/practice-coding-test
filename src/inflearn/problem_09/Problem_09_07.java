package inflearn.problem_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem_09_07 {

    public static class Load implements Comparable<Load> {
        int node_a;
        int node_b;
        int price;

        public Load(int node_a, int node_b, int price) {
            this.node_a = node_a;
            this.node_b = node_b;
            this.price = price;
        }

        @Override
        public int compareTo(Load o) {
            return this.price - o.price;
        }
    }

    static int[] unionResult;

    static int find (int node) {
        if (unionResult[node] == node) return node;
        return unionResult[node] = find(unionResult[node]);
    }

    static void union(int node_a, int node_b) {
        int fa = find(node_a);
        int fb = find(node_b);
        if (fa != fb) unionResult[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        unionResult = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            unionResult[i] = i;
        }

        List<Load> loads = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            loads.add(new Load(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(loads);

        int answer = 0;
        int loadConunt = 0;
        for (Load load : loads) {
            if (loadConunt == v - 1) break;

            int fa = find(load.node_a);
            int fb = find(load.node_b);
            if (fa != fb) {
                answer += load.price;
                loadConunt++;
                union(load.node_a, load.node_b);
            }
        }

        System.out.println(answer);
    }
}
