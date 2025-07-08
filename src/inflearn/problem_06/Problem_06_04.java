package inflearn.problem_06;

import java.util.*;

public class Problem_06_04 {

    public Deque<Integer> solution(int s, int n, int[] arr) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int job = arr[i];
            if (deque.size() < s && !deque.contains(job)){
                deque.addFirst(job);
            } else {
                if (deque.contains(job)) {
                    deque.remove(job);
                } else {
                    deque.pollLast();
                }
                deque.addFirst(job);
            }
        }

        return deque;
    }

    public static void main(String[] args) {
        Problem_06_04 main = new Problem_06_04();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (Integer job : main.solution(s, n, arr)) {
            System.out.print(job + " ");
        }
    }
}
