package inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_02_01 {

    public static List<Integer> solution(int n, int[] arr) {
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                result.add(arr[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
