package packjon;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_19939 {

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 최소 공의 갯수
            int min = 0;
            for (int i = 1; i <= K; i++) {
                min += i;
            }

            int result = 0;
            if (min > N) {
                result = -1;
            } else {
                // 한개씩 차이일 경우 최소 최대 차이
                result = K - 1;
                // 남은 공
                N -= min;

                // 남은 공 % 바구니 == 0 -> 바구니간의 차이는 1
                // 남은 공 % 바구니 != 0 -> 바구니간의 차이가 증가
                if (N % K != 0) {
                    result++;
                }
            }
            bw.write(result + "");
        }
    }
}
