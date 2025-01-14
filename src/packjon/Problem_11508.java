package packjon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Problem_11508 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        Integer[] prodcut = new Integer[N];

        for (int i = 0; i < N; i++) {
            int price = Integer.parseInt(br.readLine());
            prodcut[i] = price;
        }

        /**
         * 조건 - 유제품 3개를 한 번에 산다면 그중에서 가장 싼 것은 무료로 지불하고 나머지 두 개의 제품 가격만 지불하면 됩니다
         * 배열을 내림차순으로 정렬 후 3묶음 처리 시 큰 수 최소 비용으로 처리 가능하여
         * 내림차준 정렬 실행
         */
        Arrays.sort(prodcut, Collections.reverseOrder());

        /**
         * (index + 1)
         * (1 ~ 3) 순서에서 3번째 순서가 아닌 price 누적 
         */
        long sum = 0L;
        for (int i = 0; i < N; i++) {
            if ((i + 1)  % 3 != 0) {
                sum += prodcut[i];
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sum + "");
        bw.close();
        br.close();
    }
}
