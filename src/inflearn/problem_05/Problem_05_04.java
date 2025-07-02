package inflearn.problem_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Problem_05_04 {

    public int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        List<Character> operatorList = new ArrayList<>();
        operatorList.add('+');
        operatorList.add('-');
        operatorList.add('*');
        operatorList.add('/');

        for (char c : str.toCharArray()) {
            if (operatorList.contains(c)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calculate(a, b, c));
            } else {
                stack.push(c - '0');
            }
        }

        return stack.pop();
    }

    private int calculate(int a, int b, Character operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Divide by zero");
                return a / b;
            case '%':
                return a % b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public static void main(String[] args) {
        Problem_05_04 problem = new Problem_05_04();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(problem.solution(str));
    }
}
