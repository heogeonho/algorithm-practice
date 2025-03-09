import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[1001]; //true 면 상근이가 이김
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        for (int i = 4; i <= n; i++) {
            dp[i] = !(dp[i-1] || dp[i-3]);
        }
        if (dp[n]) {
            System.out.print("SK");
        } else {
            System.out.print("CY");
        }
    }
}