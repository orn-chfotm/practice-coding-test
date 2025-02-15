package packjon;

import java.io.*;

public class Problem_11727 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            dp = new int[n + 1];

            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
            }
            System.out.println(dp[n]);
        }
    }
}
