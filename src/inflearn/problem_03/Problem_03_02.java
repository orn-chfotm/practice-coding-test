package inflearn.problem_03;

import java.util.*;

public class Problem_03_02 {

    public static void main(String[] args) {
        Problem_03_02 problem = new Problem_03_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int num : problem.solution(arr1, arr2)) {
            System.out.print(num + " ");
        }
    }

    public List<Integer> solution(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int index1 = 0, index2 = 0;

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                index1++;
            } else if (arr1[index1] > arr2[index2]) {
                index2++;
            } else {
                result.add(arr1[index1++]);
                index2++;
            }
        }

        return result;
    }
}
