
import java.util.*;
import java.io.*;

public class Main {
	
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	
	static int N, cnt = 1;
	static int[][] map;
	static boolean[][] v;
	
	static ArrayList<Integer> eachCnt=new ArrayList<>();;

	static void bfs(int i, int j) {
		ArrayDeque<int[]> q=new ArrayDeque<>();
		cnt=1;
		v[i][j]=true;
		q.offer(new int[] {i,j});
		while (!q.isEmpty()) {
			int[] ij=q.poll();
			i=ij[0];
			j=ij[1];
			for(int d=0; d<4; d++) {
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj] && map[ni][nj]==1) {
					v[ni][nj]=true;
					cnt++;
					q.offer(new int[] {ni, nj});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		v=new boolean[N][N];

		for(int i=0; i<N; i++) {
			String input=br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(input.charAt(j)+"");
			}
		}
		
		int group=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && !v[i][j]) {
					bfs(i,j);
					group++;
					eachCnt.add(cnt);
				}
			}
		}
		Collections.sort(eachCnt);
		
		sb.append(group).append("\n");
		for(int k: eachCnt) {
			sb.append(k).append("\n");
		}
		System.out.println(sb.toString());
	}

}