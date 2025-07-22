package inflearn.problem_09;

import java.util.*;

public class Problem_09_01 {

    public int solution(List<int[]> list) {
        int answer = 0;

        int max = Integer.MIN_VALUE;
        for (int[] arr : list) {
            if (arr[1] > max) {
                answer++;
                max = arr[1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        Problem_09_01 main = new Problem_09_01();
        Collections.sort(list, Comparator.comparingInt((int[] a) -> a[0]).reversed());
        System.out.println(main.solution(list));
    }
}
