package inflearn.problem_09;

import java.util.*;

public class Problem_09_03 {

    public static class Time implements Comparable<Time> {
        public int time;
        public char state;

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) return this.state - o.state;
            return this.time - o.time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Time(sc.nextInt(), 's'));
            list.add(new Time(sc.nextInt(), 'e'));
        }

        Problem_09_03 main = new Problem_09_03();
        System.out.println(main.solution(n, list));
    }

    public int solution(int n, List<Time> list) {
        Collections.sort(list);

        int max = 0;
        int count = 0;
        for (Time time : list) {
            if (time.state == 's') count++;
            else count--;

            max = Math.max(max, count);
        }

        return max;
    }
}
