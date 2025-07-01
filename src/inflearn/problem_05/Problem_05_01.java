package inflearn.problem_05;

import java.util.Scanner;
import java.util.Stack;

public class Problem_05_01 {

    public String solution(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty()) {
                    return "NO";
                }
                stack.pop();
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        Problem_05_01 problem = new Problem_05_01();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(problem.solution(str));
    }
}
