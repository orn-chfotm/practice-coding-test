package inflearn.problem_04;

import java.util.*;

public class Problem_04_03 {

    public void solution(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        /* init */
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        sb.append(map.size()).append(" ");

        for (int i = k; i < n; i++) {
            int left = arr[i - k];
            map.put(left, map.get(left) - 1);

            if (map.get(left) == 0) {
                map.remove(left);
            }

            int right = arr[i];
            map.put(right, map.getOrDefault(right, 0) + 1);

            sb.append(map.size()).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        Problem_04_03 problem = new Problem_04_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        problem.solution(n, k, arr);
    }
}
