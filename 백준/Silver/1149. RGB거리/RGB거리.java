import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
	
		int N=Integer.parseInt(br.readLine());
		int[][] dp =new int[N][3];
		
		st=new StringTokenizer(br.readLine(), " ");
		dp[0][0]=Integer.parseInt(st.nextToken());
		dp[0][1]=Integer.parseInt(st.nextToken());
		dp[0][2]=Integer.parseInt(st.nextToken());
		
		/*
		거리에 색을 칠하는 비용의 경우들을 저장하는 2차원 배열을 형성 후
		각 칸별로 값을 저장! (이전 값을 판단하여 최솟값을 갖도록)
		
		바텀업이라고 할 수 있을까
		
		최종 인덱스 값 3개를 비교해서 최소 값이 정답이 됩니다.
		 */
		
		for (int i=1; i<N; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				int temp=Integer.parseInt(st.nextToken());
				if(j==0) {
					dp[i][j]=Math.min(dp[i-1][1]+temp, dp[i-1][2]+temp);				
				} else if(j==1) {
					dp[i][j]=Math.min(dp[i-1][0]+temp, dp[i-1][2]+temp);									
				} else {
					dp[i][j]=Math.min(dp[i-1][0]+temp, dp[i-1][1]+temp);														
				}
			}
		}
		
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
		br.close();
	}
}