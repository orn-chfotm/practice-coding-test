package packjon;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_14501 {

    public static void main(String[] args) throws IOException {

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());

            int[] T = new int[N+1];
            int[] P = new int[N+1];
            for(int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                T[i] = Integer.parseInt(st.nextToken());
                P[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N+2];

            for(int i = N; i >= 1; i--) {
                int nextDay = i + T[i];
                if(nextDay <= N + 1) {
                    dp[i] = Math.max(dp[i+1], P[i] + dp[nextDay]);
                } else {
                    dp[i] = dp[i+1];
                }
            }

            bw.write(dp[1] + "");
        }
    }
}
