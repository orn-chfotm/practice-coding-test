package inflearn.problem_01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem_01_03 {

    public static String solution(String str) {
        String[] splitStr = str.split(" ");
        List<String> splitList = Arrays.asList(splitStr);
        splitList.sort((x, y) -> y.length() - x.length());

        return splitStr[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(solution(str));
    }
}
