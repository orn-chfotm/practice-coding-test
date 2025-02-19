package packjon;

import java.io.*;

public class Problem_2775 {
    public static void main(String[] args) throws IOException {
        try(
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; t++) {
                int k = Integer.parseInt(br.readLine());
                int n = Integer.parseInt(br.readLine());
                int[][] apartment = new int[k + 1][n + 1];

                /* 0층 */
                for (int i = 1; i <= n; i++) {
                    apartment[0][i] = i;
                }

                /* 1층부터 k층까지 1호부터 n호 까지 계산 */
                for (int i = 1; i <= k; i++) {
                    for (int j = 1; j <= n; j++) {
                        apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
                    }
                }

                bw.write(apartment[k][n] + "");
                if (t < T - 1) {
                    bw.append("\n");
                }
            }
        }
    }
}
