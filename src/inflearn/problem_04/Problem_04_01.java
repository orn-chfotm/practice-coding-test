package inflearn.problem_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem_04_01 {

    public char solution(int n, String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char result = 0;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                result = entry.getKey();
                max = entry.getValue();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem_04_01 problem = new Problem_04_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(problem.solution(n, str));
    }
}
