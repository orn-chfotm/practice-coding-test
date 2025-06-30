package inflearn.problem_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem_04_02 {

    public String solution(String str1, String str2) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else if (str1.indexOf(c) == -1) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0 || entry.getValue() < 0) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        Problem_04_02 problem = new Problem_04_02();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(problem.solution(str1, str2));
    }
}
