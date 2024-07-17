import java.util.*;
import java.io.*;

public class Main {
	
	static int Cnt = 0, N, M;
	static int[][] map;
	static boolean[][] v;
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	
	static void dfs(int i, int j) {
		for(int a=0; a<4; a++) {
			int ni=i+di[a];
			int nj=j+dj[a];
			if(0<=ni&&ni<N && 0<=nj&&nj<M && map[ni][nj]==1 && !v[ni][nj]) {
				v[ni][nj]=true;
				dfs(ni,nj);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		
		//테스트 반복
		for(int t=0; t<T; t++) {

			st=new StringTokenizer(br.readLine()," ");
			M=Integer.parseInt(st.nextToken()); //가로길이
			N=Integer.parseInt(st.nextToken()); //세로길이
			
			map=new int[N][M];
			v=new boolean[N][M];
			
			int k=Integer.parseInt(st.nextToken()); //배추 개수
			for (int j=0; j<k; j++) {
				st=new StringTokenizer(br.readLine()," ");
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				
				map[y][x]=1;
			}
			
			// map에 대해서 전체 순회
			for(int i=0; i<N; i++) { 
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && !v[i][j]) {
						dfs(i,j);
						Cnt++;
					}
				}
			}
			sb.append(Cnt).append("\n");
			Cnt=0;
		}
		
		System.out.println(sb.toString());
	}
}
