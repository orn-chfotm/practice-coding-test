package inflearn.problem_01;

import java.util.Scanner;

public class Problem_01_08 {

    public static boolean solution(String str) {
        int lt = 0, rt = str.length() - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(str.charAt(lt))) {
                lt++;
            } else if (!Character.isAlphabetic(str.charAt(rt))) {
                rt--;
            } else {
                String strLeft = String.valueOf(str.charAt(lt));
                String strRight = String.valueOf(str.charAt(rt));
                if (!strLeft.equalsIgnoreCase(strRight)) {
                    return false;
                }
                lt++;
                rt--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str) ? "YES" : "NO");
    }
}
