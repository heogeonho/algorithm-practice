import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        StringTokenizer st=new StringTokenizer(br.readLine(), " ");
        int N=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());

        while (N!=0) {
            if(N%B >= 10) {
                char temp= (char) ('A'+(N%B)-10);
                sb.append(temp+"");
            } else {
                sb.append(N%B);
            }
            N/=B;
        }

        System.out.println(sb.reverse().toString());
    }
}

