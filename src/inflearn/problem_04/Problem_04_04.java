package inflearn.problem_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem_04_04 {

    public int solution(String str1, String str2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int result = 0;

        for(char c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < str2.length(); i++) {
            char c = str1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        if (check(map1, map2)) result++;

        for (int i = str2.length(); i < str1.length(); i++) {
            char left = str1.charAt(i - str2.length());
            map1.put(left, map1.getOrDefault(left, 0) - 1);

            if (map1.get(left) == 0) {
                map1.remove(left);
            }

            char right = str1.charAt(i);
            map1.put(right, map1.getOrDefault(right, 0) + 1);

            if (check(map1, map2)) result++;
        }

        return result;
    }

    private boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int count = map2.get(entry.getKey());
                if (count != entry.getValue()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Problem_04_04 main = new Problem_04_04();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(main.solution(str1, str2));
    }
}
