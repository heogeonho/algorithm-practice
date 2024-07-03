import java.util.*;
import java.io.*;

public class Main {
	static int N, M, ans, C;
	static int[][] a;
	static boolean[][] v;
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,1,0,-1};

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		a=new int[N][M];
		v=new boolean[N][M];
		for(int i=0; i<N; i++) {
			String str=br.readLine();
			for(int j=0; j<M; j++) {
				char value=str.charAt(j);
				if(value=='1') {
					a[i][j]=1;
				}
				else {
					a[i][j]=0;
				}
			}
		}
		ans=0;
		C=1;
		bfs(0,0); //출발인덱스 0,0 도착인덱스 n-1, m-1
		br.close();
	}

	static void bfs(int i, int j) {
		ArrayDeque<int[]> q=new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] ij=q.poll();
			i=ij[0];
			j=ij[1];
			for(int d=0; d<4; d++) {
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<M && !v[ni][nj] && a[ni][nj]==1) {
					v[ni][nj]=true;
					q.offer(new int[] {ni,nj});
					a[ni][nj]=a[i][j]+1;
				}
			}
		}
		System.out.println(a[N-1][M-1]);
	}
}