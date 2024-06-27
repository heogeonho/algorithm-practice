import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;

		int N=Integer.parseInt(br.readLine());
		
		long[] road=new long[N-1];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N-1; i++) {
			road[i]=Integer.parseInt(st.nextToken());
		}
		
		long[] city=new long[N];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			city[i]=Integer.parseInt(st.nextToken());
		}
		
		long result=0;
		long startPrice=Integer.MAX_VALUE;
		long roadSum=0;
		for(int i=0; i<N; i++) {
			if(city[i]<startPrice) {
				result+=roadSum*startPrice;
				startPrice=city[i];
				roadSum=0;
			}
			if(i<N-1) {
				roadSum+=road[i];
			}
			if(i==N-1 && roadSum!=0) {
				result+=roadSum*startPrice;				
			}
		}
		System.out.println(result);
		br.close();
	}
}