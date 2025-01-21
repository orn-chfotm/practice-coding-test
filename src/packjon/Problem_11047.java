package packjon;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem_11047 {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Integer[] coins = new Integer[N];

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(coins, Collections.reverseOrder());

            int count = 0;
            for (int i = 0; i < N; i++) {
                count += K / coins[i];
                K = K % coins[i];
            }

            bw.write(String.valueOf(count));
        }
    }
}
