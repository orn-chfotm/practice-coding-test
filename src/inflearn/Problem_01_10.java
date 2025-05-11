package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_01_10 {

    public static int[] solution(String str, char target) {
        int[] result = new int[str.length()];

        int max = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                max = 0;
            } else {
                max++;
            }
            result[i] = max;
        }

        max = str.length();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == target) {
                max = 0;
            } else {
                max++;
                result[i] = Math.min(result[i], max);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String target = sc.next();

        int[] result = solution(str, target.charAt(0));
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
