import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        
        int N=Integer.parseInt(br.readLine());
        
        int[] size=new int[6];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0; i<6; i++){
            size[i]=Integer.parseInt(st.nextToken());
        }
        
        st=new StringTokenizer(br.readLine()," ");
        int T=Integer.parseInt(st.nextToken());
        int P=Integer.parseInt(st.nextToken());
        
        int cnt=0;
        for(int i=0; i<6; i++){
            if(size[i]%T!=0) cnt+=(size[i]/T)+1;
            else cnt+=size[i]/T;
        }
        System.out.println(cnt);
        
        int group=0;
        int one=0;
        group=N/P;
        one=N%P;
        System.out.println(group+" "+one);
    }
}