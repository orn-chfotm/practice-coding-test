package packjon;

import java.io.*;

public class Problem_2847 {

    public static void main(String[] args) throws IOException {
        try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {

            int N = Integer.parseInt(br.readLine());

            int[] scores = new int[N];

            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(br.readLine());
            }

            int sum = 0;
            for (int i = N - 2; i >= 0; i--) {
                int highSco = scores[i + 1];
                int lowSco = scores[i];

                if (lowSco >= highSco) {
                    int minus = lowSco - (highSco - 1);
                    scores[i] = highSco - 1;
                    sum += minus;
                }
            }

            bw.write(sum + "\n");
            bw.flush();
        }
    }
}
