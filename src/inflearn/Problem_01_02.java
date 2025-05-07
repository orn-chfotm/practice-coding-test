package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_01_02 {
    public static String solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= "a".hashCode() && c <= "z".hashCode()) {
                str = str.substring(0, i) + String.valueOf(c).toUpperCase() + str.substring(i + 1);
            }
            if (c >= "A".hashCode() && c <= "Z".hashCode()) {
                str = str.substring(0, i) + String.valueOf(c).toLowerCase() + str.substring(i + 1);
            }
        }

        return str;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));
    }
}
