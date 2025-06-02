package inflearn.problem_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_01_04_02 {

    public static List<String> solution(int n, String[] str) {
        List<String> answer = new ArrayList<>();

        for (String s : str) {
            char[] c = s.toCharArray();
            int lt = 0, rt = s.length() - 1;

            while (lt < rt) {
                char temp = c[lt];
                c[lt] = c[rt];
                c[rt] = temp;
                lt++;
                rt--;
            }

            String temp = String.valueOf(c);
            answer.add(temp);
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        for (String s : solution(n, str)) {
            System.out.println(s);
        }
    }
}
