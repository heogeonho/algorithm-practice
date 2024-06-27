import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
	
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
	
		int[] coins=new int[N];
		
		for(int i=0; i<N; i++) {
			coins[i]=Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(coins));
		
		int cnt=0;
		while(true) {
			for(int i=N-1; i>=0; i--) {
				int div=K/coins[i];
				if(div!=0) {
					K=K-(coins[i]*(div));
					cnt+=div;
				}
			}
			if(K==0) break;
		}
		System.out.println(cnt);	
		br.close();
	}
}