package packjon;

import java.io.*;
import java.util.*;

public class Problem_11053 {
    static Integer[] dp;
    static int[] val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N];
        val = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int index = 0;
        while(st.hasMoreTokens()){
            val[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        for(int i=0; i<N; i++){
            check(i);
        }

        int max = dp[0];

        for(int value : dp){
            max = Math.max(max, value);
        }

        System.out.println(max);
    }

    static int check(int N){
        if(dp[N] == null){
            dp[N] = 1;

            for(int i=N-1; i>=0; i--){
                if(val[i] < val[N]){
                    dp[N] = Math.max(dp[N], check(i) + 1);
                }
            }
        }
        return dp[N];
    }
}
