package packjon;

import java.util.*;
import java.io.*;
public class Problem_2156 {

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {

            int n = Integer.parseInt(br.readLine());
            int[] wines = new int[n];
            int[] dp = new int[n];


            for (int i = 0; i < n; i++) {
                wines[i] = Integer.parseInt(br.readLine());
            }

            if (n >= 1) {
                dp[0] = wines[0];
            }

            if (n >= 2) {
                dp[1] = wines[0] + wines[1];
            }

            if (n >= 3) {
                dp[2] = Math.max(dp[1], Math.max(dp[0] + wines[2], wines[1] + wines[2]));
            }

            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + wines[i - 1]) + wines[i]);
            }

            bw.write(dp[n-1] + "");
        }
    }
}
