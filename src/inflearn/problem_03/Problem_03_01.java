package inflearn.problem_03;

import java.util.*;

public class Problem_03_01 {

    public static void main(String[] args) {
        Problem_03_01 problem = new Problem_03_01();
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

        for (int num : problem.solution2(arr1, arr2)) {
            System.out.print(num + " ");
        }
    }

    public List<Integer> solution(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            list.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            list.add(arr2[i]);
        }

        Collections.sort(list);
        return list;
    }

    public int[] solution2(int[] arr1, int[] arr2) {
        int[] resultArr = new int[arr1.length + arr2.length];

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < arr1.length + arr2.length; i++) {
            if (index1 == arr1.length) {
                for (int j = index2; j < arr2.length; j++) {
                    resultArr[i++] = arr2[j];
                }
                break;
            }
            if (index2 == arr2.length) {
                for (int j = index1; j < arr1.length; j++) {
                    resultArr[i++] = arr1[j];
                }
                break;
            }

            if (arr1[index1] > arr2[index2]) {
                resultArr[i] = arr2[index2++];
            } else if (arr2[index2] > arr1[index1]) {
                resultArr[i] = arr1[index1++];
            } else {
                resultArr[i++] = arr1[index1++];
                resultArr[i] = arr2[index2++];
            }
        }
        return resultArr;
    }
}
