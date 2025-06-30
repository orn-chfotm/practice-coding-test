package inflearn.problem_04;

import java.util.*;

public class Problem_04_05 {

    private final int selection = 3;

    public int solution(int n, int k, int[] arr) {
        int result = 0;
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        result = set.stream()
                .skip(k - 1)
                .findFirst()
                .orElse(-1);

        return result;
    }

    public static void main(String[] args) {
        Problem_04_05 problem = new Problem_04_05();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(problem.solution(n, k, arr));
    }
}
