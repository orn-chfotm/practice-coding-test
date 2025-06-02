package inflearn.problem_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem_01_04 {

    /* for 문 index 접근 방식*/
    /*public static void solution(List<String> words) {
        for (String word : words) {
            for (int i = word.length() - 1; i >= 0; i--) {
                System.out.print(word.charAt(i));
            }
            System.out.println();
        }
    }*/

    /* StringBuilder 방식 */
    public static void solution(List<String> words) {
        for (String word : words) {
            String temp = new StringBuilder(word).reverse().toString();
            System.out.println(temp);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            List<String> words = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                words.add(br.readLine());
            }

            solution(words);
        }
    }
}
