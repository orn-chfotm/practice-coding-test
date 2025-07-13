package pro;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }

        int index = 0;
        int weightSum = 0;
        while (index < truck_weights.length) {
            weightSum -= queue.poll();
            answer++;

            if (weightSum + truck_weights[index] <= weight && queue.size() < bridge_length) {
                int truck = truck_weights[index++];
                queue.offer(truck);
                weightSum += truck;
            } else {
                queue.offer(0);
            }
        }

        return answer + bridge_length;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
