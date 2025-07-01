package inflearn.problem_05;

import java.util.Scanner;
import java.util.Stack;

public class Problem_05_02 {

    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Problem_05_02 problem = new Problem_05_02();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(problem.solution(str));
    }
}
