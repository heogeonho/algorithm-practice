import java.util.*;
import java.io.*;

public class Main{
	static int N, M, size, max=Integer.MIN_VALUE;
	static int[][] road;
	static boolean[][] v;
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,1,0,-1};
	

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		road=new int[N][M];
		v=new boolean[N][M];
		
		for(int i=0; i<K; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			road[r-1][c-1]=1;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!v[i][j] && road[i][j]==1) {
					size=0;
					dfs(i,j);
				}
			}
		}
		
		System.out.println(max);
		br.close();
	}


	private static void dfs(int i, int j) {
		v[i][j]=true;
		size=size+1;
		if(size>max) max=size;
		for(int d=0; d<4; d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(ni>=0&&ni<N && nj>=0&&nj<M && !v[ni][nj] && road[ni][nj]==1) {
				dfs(ni, nj);
			}
		}
	}
}
