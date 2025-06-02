package inflearn.problem_01;

import java.util.Scanner;

public class Problem_01_12 {

    public static String solution(int charCount, String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charCount; i++) {
            int lt = i * 7;
            int rt = lt + 7;
            String substring = str.substring(lt, rt);

            int decimal = 0;
            for (int j = substring.length(); j > 0 ; j--) {
                if (substring.charAt(j - 1) == '#') {
                    decimal += Math.pow(2, 7 - j);
                }
            }
            sb.append((char) decimal);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int charCount = Integer.parseInt(sc.next());
        String str = sc.next();
        System.out.println(solution(charCount, str));
    }
}
