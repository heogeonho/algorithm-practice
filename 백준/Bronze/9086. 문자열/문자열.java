import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String str=br.readLine();
            int len=str.length();
            String temp=str.charAt(0)+""+str.charAt(len-1);
            sb.append(temp).append("\n");
        }
        System.out.print(sb);
    }    
}