package packjon;

import java.io.*;
import java.util.StringTokenizer;

public class Problem_1010 {

    static int[][] map = new int[30][30];
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            Integer T = Integer.parseInt(br.readLine());
            StringTokenizer st;

            for (int i = 0; i < T; i++) {
                st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

            }
        }
    }
}
