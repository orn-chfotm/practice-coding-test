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

        if (k > set.size()) return -1;
        Iterator<Integer> it = set.iterator();
        for (int i = 1; i < k; i++) it.next();

        result = it.next();
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
