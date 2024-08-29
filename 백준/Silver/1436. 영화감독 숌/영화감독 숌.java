import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

         int temp = 666;
         int answer = 1;

         while (answer!=N) {
           temp++;

            if(Integer.toString(temp).contains("666")) answer+=1;
            if(answer==N) break;
         }
         System.out.println(temp);
    }
}