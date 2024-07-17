import java.util.*;
import java.io.*;

public class Main{

	static long[] fibo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		fibo=new long[n+1];
		fibo[0]=0;
		fibo[1]=1;
		
		for(int i=2; i<=n; i++) {
			fibo[i]=fibo[i-1]+fibo[i-2];
		}	
		System.out.println(fibo[n]);
	}
}