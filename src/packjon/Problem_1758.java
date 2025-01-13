package packjon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Problem_1758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());

        Integer[] tips = new Integer[N];

        /* 입력 값 초기화 */
        for (int i = 0; i < N; i++) {
            int tip = Integer.parseInt(br.readLine());
            tips[i] = tip;
        }

        /* 팁의 최댓값을 구하기 위한 내림차순 정렬 */
        Arrays.sort(tips, Collections.reverseOrder());

        long sum = 0L;
        /**
         *  tip - (index - 1)
         *  index 는 0부터 사용
         *  실제 등수는 1부터 카운트 (등수 - 1) -> index 와 동일
         */
        for (int i = 0; i < tips.length; i++) {
            int pay = tips[i] - i;
            if (pay > 0) {
                sum += pay;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sum + "");
        bw.close();
        br.close();
    }
}
