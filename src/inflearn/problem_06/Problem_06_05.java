package inflearn.problem_06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem_06_05 {

    public String solution(int n, int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (Integer nun : arr) {
            set.add(nun);
        }

        Arrays.asList(set);

        return arr.length == set.size() ? "U" : "D";
    }

    public static void main(String[] args) {
        Problem_06_05 main = new Problem_06_05();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.solution(n, arr));
    }
}
