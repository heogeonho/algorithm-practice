import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        /*
        1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
        2. X가 2로 나누어 떨어지면, 2로 나눈다.
        3. 1을 뺀다.

        2   1
        3   1
        4   2
        5   3
        6   2
        7   3
        8   3
        9   2
        10  3
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        if(N==1) System.out.println(0);
        else if (N<4) {
            System.out.println(1);
        }
        else if (N>=4) {
            dp[2] = 1;
            dp[3] = 1;
            for(int i = 4; i <= N; i++) {
                if(i%3 == 0) dp[i] = dp[i/3]+1;
                if(i%2 == 0) {
                    if(dp[i]!=0) dp[i] = Math.min(dp[i/2]+1, dp[i]);
                    else dp[i] = dp[i/2]+1;
                }
                if(dp[i]!=0) dp[i] = Math.min(dp[i-1]+1,dp[i]);
                else dp[i] = dp[i-1]+1;
            }
            System.out.println(dp[N]);
        }
    }
}