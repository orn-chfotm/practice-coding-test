package inflearn;

import java.util.Scanner;

public class Problem_01_11 {

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        char temp = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (temp == str.charAt(i)) {
                count++;
            } else {
                sb.append(temp + "" + (count > 1 ? count : ""));
                temp = str.charAt(i);
                count = 1;
            }
        }

        sb.append(temp + "" + (count > 1 ? count : ""));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
