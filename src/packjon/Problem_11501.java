package packjon;

import java.util.*;
import java.io.*;

public class Problem_11501 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());

            for (int i=0; i<T; i++){
                int N = Integer.parseInt(br.readLine());
                long sum = 0;
                int max = Integer.MIN_VALUE;
                int[] dayPrices = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int j=N-1; j>=0; j--) {
                    int dayPrice = dayPrices[j];
                    if (dayPrice > max) max = dayPrice;
                    else sum += max - dayPrice;
                }
                bw.write(sum + "\n");
            }
            bw.flush();
        }
    }
}
