package inflearn.problem_01;

import java.util.Scanner;

public class Problem_01_07 {

    public static String solution(String str) {
        int lt = 0, rt = str.length() - 1;

        while (lt < rt) {
            if (!charEqual(str.charAt(lt), str.charAt(rt))) return "NO";
            lt++;
            rt--;
        }

        return "YES";
    }

    public static boolean charEqual(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(solution(str));
    }
}
