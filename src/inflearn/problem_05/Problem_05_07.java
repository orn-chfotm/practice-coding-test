package inflearn.problem_05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_05_07 {

    public String solution(String str1, String str2) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : str1.toCharArray()) {
            queue.add(c);
        }

        for (char c : str2.toCharArray()) {
            if (queue.isEmpty()) break;
            if (queue.peek() == c) {
                queue.poll();
            }
        }

        return queue.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Problem_05_07 problem = new Problem_05_07();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(problem.solution(str1, str2));
    }
}
