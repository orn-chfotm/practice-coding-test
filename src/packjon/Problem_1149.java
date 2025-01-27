package packjon;

import java.util.*;
import java.io.*;

public class Problem_1149 {

    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    static int[][] price;
    static int[][] fill;

    public static void main(String[] args) throws IOException{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            price = new int[N][3];
            fill = new int[N][3];
            StringTokenizer st;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<3; j++){
                    price[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            fill[0][RED] = price[0][RED];
            fill[0][GREEN] = price[0][GREEN];
            fill[0][BLUE] = price[0][BLUE];

            System.out.println(Math.min(paint(N-1, RED), Math.min(paint(N-1, GREEN), paint(N-1, BLUE))));
        }
    }

    static int paint(int N, int color){
        if(fill[N][color] == 0){
            if(color == RED){
                fill[N][RED] = Math.min(paint(N-1, GREEN), paint(N-1, BLUE)) + price[N][RED];
            } else if(color == GREEN){
                fill[N][GREEN] = Math.min(paint(N-1, RED), paint(N-1, BLUE)) + price[N][GREEN];
            } else {
                fill[N][BLUE] = Math.min(paint(N-1, RED), paint(N-1, GREEN)) + price[N][BLUE];
            }
        }
        return fill[N][color];
    }
}
