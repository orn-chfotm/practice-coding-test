package inflearn.problem_05;

import java.util.Scanner;
import java.util.Stack;

public class Problem_05_05 {

    public int solution(String str) {
        Stack<Character> stack = new Stack<>();

        int sum = 0;
        char prev = ' ';
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (prev == '(') {
                    sum += stack.size();
                } else {
                    sum += 1;
                }
            }
            prev = c;
        }

        return sum;
    }

    public static void main(String[] args) {
        Problem_05_05 problem = new Problem_05_05();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(problem.solution(str));
    }
}
