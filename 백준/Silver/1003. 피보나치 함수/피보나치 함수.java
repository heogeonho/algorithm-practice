import java.util.*;
import java.io.*;

public class Main {
	static int cntZero=0, cntOne=0;
	static int[][] fiboRes;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		
		fiboRes=new int[41][2]; //0이나 40보다 작거나 같은 자연수의 피보 결과 저장 리스트
		
		for(int[] fi:fiboRes) Arrays.fill(fi, -1);
		
		 fiboRes[0][0]=1;
		 fiboRes[0][1]=0;
		 fiboRes[1][0]=0;
		 fiboRes[1][1]=1;
		 
		for(int i=0; i<T; i++) {
			int N=Integer.parseInt(br.readLine());
			cntZero=0;
			cntOne=0;
			fibonacci(N);
			sb.append(fiboRes[N][0]).append(" ").append(fiboRes[N][1]).append("\n");
		}
		System.out.println(sb.toString());
	}
	 static int[] fibonacci(int n) {
		 if(fiboRes[n][0]==-1 || fiboRes[n][1]==-1) {
			 fiboRes[n][0]= fibonacci(n-1)[0]+fibonacci(n-2)[0];
			 fiboRes[n][1]= fibonacci(n-1)[1]+fibonacci(n-2)[1];
		 }
		 
		 return fiboRes[n];
	}
}