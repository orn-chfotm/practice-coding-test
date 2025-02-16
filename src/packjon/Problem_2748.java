package packjon;

import java.io.*;

public class Problem_2748 {

    static Long[] arr;
    public static void main (String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            int n = Integer.parseInt(br.readLine());

            arr = new Long[n + 1];
            arr[0] = 0L;
            arr[1] = 1L;

            System.out.println(fibona(n));
        }
    }
    public static long fibona(int n){
        if(arr[n] == null){
            arr[n] = fibona(n - 2) + fibona(n - 1);
        }
        return arr[n];
    }
}
