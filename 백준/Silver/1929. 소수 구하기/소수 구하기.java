import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine(), " ");
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());

        for(int i = M; i<=N; i++) {
            if(isPrime(i)){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static boolean isPrime(Integer a) {
        if (a < 2) {
            return false;
        }

        for (int i=2; i<=(int) Math.sqrt(a); i++) {
            if(a%i==0) {
                return false;
            }
        }
        return true;
    }
}