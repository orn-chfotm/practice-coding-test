package packjon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_11300 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] arrInt = new int[N];

            for(int i=0; i<N; i++){
                arrInt[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrInt);

            int sum = 0;
            int prev = 0;

            for(int i=0; i<N; i++){
                sum += prev + arrInt[i];
                prev += arrInt[i];
            }

            bw.write(sum + " ");
        }
    }
}
