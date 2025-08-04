package inflearn.problem_09;

import java.util.*;

public class Problem_09_04 {

    static class Lecture implements Comparable<Lecture> {
        public int price;
        public int day;

        public Lecture(int price, int day) {
            this.price = price;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.day - this.day;
        }
    }

    public int solution(int n, List<Lecture> list) {
        Collections.sort(list);

        int sum = 0;
        int day = list.get(0).day;
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = day; i >= 1; i--) {
            while (index < n && list.get(index).day >= i) {
                pq.offer(list.get(index).price);
                index++;
            }

            if (!pq.isEmpty()) sum += pq.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Lecture> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Lecture(sc.nextInt(), sc.nextInt()));
        }

        Problem_09_04 main = new Problem_09_04();
        System.out.println(main.solution(n, list));
    }
}
