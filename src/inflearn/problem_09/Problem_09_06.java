package inflearn.problem_09;

import java.util.Scanner;

public class Problem_09_06 {

    static int[] unf;

    public static int find(int value) {
        if (unf[value] == value) return value;
        return unf[value] = find(unf[value]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (find(a) == find(b)) System.out.println("YES");
        else System.out.println("NO");
    }
}
