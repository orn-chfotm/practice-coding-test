package inflearn.problem_01;

import java.util.Scanner;

public class Problem_01_09 {

    public static int solution(String str) {
        String result = "";
        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            if (!Character.isAlphabetic(c)) {
                result += c;
            }
        }

        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
