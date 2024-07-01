import java.util.*;
import java.io.*;

public class Main {
	static int R, C, K, cnt=0;
	static int[][] a;
	static boolean[][] v;
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,1,0,-1};
	
	static void dfs(int i, int j, int dist) {
		if(i==0 && j==C-1) { //도착하고 dist가 K면 cnt 증가
			if(dist==K) cnt++;
			return;
		}
		if(dist>K) {
			return;
		}
		v[i][j]=true;

		for(int k=0; k<4; k++) {
			int ni=i+di[k];
			int nj=j+dj[k];
			if(ni>=0&&ni<R && nj>=0&&nj<C && !v[ni][nj] && a[ni][nj]!=-1) {
				dfs(ni, nj, dist+1);
			}
		}
		v[i][j]=false; //탐색을 다 하고나서 다른 경우의 수를 보러갈 때 현재 칸 false로 수정				
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		st=new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		a=new int[R][C];
		v=new boolean[R][C];
		for(int i=0; i<R; i++) {
			String str=br.readLine();
			for(int j=0; j<C; j++) {
				char value=str.charAt(j);
				if(value=='.') a[i][j]=0;
				else a[i][j]=-1;
			}
		}
		
		cnt=0;
		dfs(R-1,0,1);
		System.out.println(cnt);
		br.close();
	}
}