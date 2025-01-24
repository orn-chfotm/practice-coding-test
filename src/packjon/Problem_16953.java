package packjon;

import java.util.*;
import java.io.*;
public class Problem_16953 {

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int result = 1;

            while (B != A) {
                if (B < A) {
                    result = -1;
                    break;
                }

                if (B % 2 != 0 && B % 10 != 1) {
                    result = -1;
                    break;
                }

                if (B % 2 == 0) {
                    B /= 2;
                } else if (B % 10 == 1) {
                    B /= 10;
                } else {
                    result = -1;
                    break;
                }

                result++;
            }
            bw.write(result + "");
        }
    }

}
