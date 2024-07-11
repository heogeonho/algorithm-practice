import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int[] dp=new int[N+1];
        dp[0]=dp[1]=0;

        for(int i=2; i<=N; i++){
            int result=dp[i-1]+1;
            if(i % 2==0) {
                result=Math.min(1+dp[i/2],result);
            }
            if(i % 3==0) {
                result=Math.min(1+dp[i/3],result);
            }
            dp[i]=result;
        }
        System.out.println(dp[N]);
    }
}