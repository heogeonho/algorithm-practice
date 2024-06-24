import java.io.*;
import java.util.*;

public class Main {
	static final int[] di= {-1,0,1,0};
	static final int[] dj= {0,1,0,-1};	
	static int N, max=Integer.MIN_VALUE;
	static int result=Integer.MIN_VALUE;
	static int[][] a;
	static boolean[][] v;
	
	static void dfs(int i, int j, int h) {
		v[i][j]=true;
		for(int d=0; d<4; d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj] && a[ni][nj]>h) {
				dfs(ni,nj,h);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		N=Integer.parseInt(br.readLine());
		a=new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				int temp=Integer.parseInt(st.nextToken());
				a[i][j]=temp;
				if(max<temp) {
					max=temp;
				}
			}
		}
//		for(int[] al:a) System.out.println(Arrays.toString(al));

		// 1부터 max까지 돌리기
		for(int h=0; h<max; h++) {
			int count=0;
			v=new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!v[i][j] && a[i][j]>h)	{
						count++;
						dfs(i,j,h);

					}
				}
			}
			if (count>result) {
				result=count;
			}
		}
		System.out.println(result);
		br.close();
	}
}