package inflearn.problem_08;

import java.util.Scanner;

public class Problem_08_01 {

    int n, sum;
    boolean flag;

    public String solution(int n, int[] arr) {
        this.n = n;
        this.flag = false;

        for (int num : arr) {
            this.sum += num;
        }

        dfs(0, 0, arr);

        return flag ? "YES" : "NO";
    }

    public void dfs(int index, int current, int[] arr) {
        if (flag) return;

        if (index == n) {
            if ((sum - current) == current) {
                flag = true;
            }
            return;
        }

        dfs(index + 1, current + arr[index], arr);
        dfs(index + 1, current, arr);
    }

    public static void main(String[] args) {
        Problem_08_01 main = new Problem_08_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.solution(n, arr));
    }
}
