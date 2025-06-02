package inflearn.problem_01;

import java.util.Scanner;

public class Problem_01_05 {

    public static String solution(String str) {
        String answer = "";

        char[] charArray = str.toCharArray();
        int lt = 0, rt = charArray.length - 1;

        while (lt < rt) {
            if (!isAlphabet(charArray[lt])) {
                lt++;
            } else if (!isAlphabet(charArray[rt])) {
                rt--;
            } else {
                char temp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = temp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(charArray);
        return answer;
    }

    public static boolean isAlphabet(char c) {
        return ((c >= 65 && c <= 90) || (c >=97 && c <= 122));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
