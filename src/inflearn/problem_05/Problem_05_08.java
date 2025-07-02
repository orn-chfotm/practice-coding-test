package inflearn.problem_05;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Problem_05_08 {

    static class Patient {
        int index;
        int danger;

        public Patient(int order, int danger) {
            this.index = order;
            this.danger = danger;
        }
    }

    public int solution(int n , int m, int[] arr) {
        Queue<Patient> queue = new LinkedList();

        for (int i = 0; i < n; i++) {
            queue.add(new Patient(i, arr[i]));
        }

        int order = 0, result = 0;
        while (!queue.isEmpty()) {
            Patient current = queue.poll();

            boolean check = false;
            for (Patient patient : queue) {
                if (patient.danger > current.danger) {
                    check = true;
                    break;
                }
            }

            if (check) {
                queue.add(current);
            } else {
                order++;
                if (current.index == m) {
                    result = order;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem_05_08 problem = new Problem_05_08();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(problem.solution(n, m, arr));
    }
}
