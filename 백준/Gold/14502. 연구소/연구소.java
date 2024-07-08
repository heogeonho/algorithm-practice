import java.util.*;
import java.io.*;

public class Main {
	static int N, M, totalWall, virusCnt ,max=-1;
	static int[][] map, copyMap;
	static int[] di={-1,0,1,0};
	static int[] dj={0,1,0,-1};

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				int input=Integer.parseInt(st.nextToken());
				map[i][j]=input;
				if(input==1) totalWall++;
			}
		}
		dfs(0);
		System.out.println(max);
		br.close();
	}
	
	static void dfs(int wallCnt) {
		if(wallCnt==3) {
			bfs();
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					virusCnt=0;
					dfs(wallCnt+1);
					map[i][j]=0;					
				}
			}
		}
	}
	
	static void bfs() {
		ArrayDeque<int[]> q=new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) {
					q.offer(new int[] {i,j});
					virusCnt++;
				}
			}
		}
		
		copyMap=new int[N][M];
		
		for(int i=0; i<N; i++) {
			copyMap[i]=map[i].clone();
		}
		
		while(!q.isEmpty()) {
			int[] ij=q.poll();
			int i=ij[0];
			int j=ij[1];
			for(int d=0; d<4; d++) {
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<M && copyMap[ni][nj]==0) {
					copyMap[ni][nj]=2;
					q.offer(new int[] {ni, nj});
					virusCnt++;
				}
			}
		}
		
		int safeZone = (N*M)-totalWall-virusCnt-3;
		max= Math.max(max, safeZone);
	}

}
