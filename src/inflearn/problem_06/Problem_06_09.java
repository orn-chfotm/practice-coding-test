package inflearn.problem_06;

import java.util.Scanner;

public class Problem_06_09 {

    public int solution(int n, int m, int[] songs) {
        int lt = 0, rt = 0;
        for (int i = 0; i < n; i++) {
            lt = Math.max(lt, songs[i]);
            rt += songs[i];
        }

        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int record = 1, sum = 0;

            for (int song : songs) {
                if (sum + song > mid) {
                    record++;
                    sum = song;
                } else {
                    sum += song;
                }
            }

            if (record <= m) {
                answer = mid;
                rt = mid - 1;
            } else if (record > m) {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Problem_06_09 main = new Problem_06_09();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] songs = new int[n];

        for (int i = 0; i < n; i++) {
            songs[i] = sc.nextInt();
        }

        System.out.println(main.solution(n, m, songs));
    }
}
