package packjon;

import java.io.*;
import java.util.Arrays;

public class Problem_2012 {

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {

            int N = Integer.parseInt(br.readLine());
            int[] hopeRank = new int[N];
            for (int i=0; i<N; i++) {
                hopeRank[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(hopeRank);

            long discontent = 0;
            for (int i = 0; i < N; i++) {
                discontent += Math.abs(hopeRank[i] - (i + 1));
            }

            bw.write(discontent + "\n");
            bw.flush();
        }
    }
}
