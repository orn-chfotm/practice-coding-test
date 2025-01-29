package packjon;

import java.io.*;
import java.util.*;

public class Problem_1049 {

    static int setPcs = 6;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int minSet = Integer.MAX_VALUE;
            int minEach = Integer.MAX_VALUE;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                minSet = Math.min(minSet, Integer.parseInt(st.nextToken()));
                minEach = Math.min(minEach, Integer.parseInt(st.nextToken()));
            }

            // 세트와 낱개 중 한 종류만 구입했을 때, 혼합해서 구입했을 때 최솟값
            int pay = Math.min(
                    Math.min((N / setPcs + 1) * minSet, N * minEach),
                    ((N / setPcs) * minSet) + ((N % setPcs) * minEach)
            );

            bw.write(pay + "");
        }
    }

}
