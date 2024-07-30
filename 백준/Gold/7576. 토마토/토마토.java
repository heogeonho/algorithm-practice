import java.io.*;
import java.util.*;

/*
bfs 활용

bfs 깊이를 기억해뒀다가 최종 출력
	주의 사항으로는 토마토가 있지만 방문 x인 경우에는 -1 출력 (최종적으로 전체 순회 이때 최대값까지 판단)
+ 익은 토마토가 여러개이기 때문에 bfs를 진행할 때 
	해당 셀 값이 이미 방문처리 되어있더라도 들어가야 할 값이 기존값보다 작으면 값을 수정해준다.
    (이건 고민해봤을 때 먼저 익는 값(작은 값)이 무조건 먼저 처리되기 때문에 따로 처리해 줄 필요가 없을 것 같다)
 */

public class Main {
	static int n, m;			// 세로n, 가로m
	static int[][] map; 			// 지도
	static boolean[][] v;			// 방문처리
	
	static int[] di={-1, 0, 1, 0}; //상우하좌
	static int[] dj={0, 1, 0, -1}; //상우하좌

	static ArrayDeque<int[]> q=new ArrayDeque<>(); // 가로 세로 int[] 담는 큐
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		st=new StringTokenizer(br.readLine(), " ");
		m=Integer.parseInt(st.nextToken()); // 세로
		n=Integer.parseInt(st.nextToken()); // 가로
		map=new int[n][m];
		v=new boolean[n][m];

		// map 2차원 변수 생성
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				int input=Integer.parseInt(st.nextToken());
				map[i][j]=input;
				if(input==1) {
					q.offer(new int[] {i, j});
					v[i][j]=true;
					map[i][j]=0;
				}
			}
		}
		
		bfs();
		
		int answer=Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!v[i][j] && map[i][j]==0) { //안익은 토마토가 있는경우
					answer=-1;
					break;
				} else if(v[i][j]) { //방문처리가 된 토마토 중 가장 큰 수
					answer=Math.max(map[i][j], answer);
				}
			}
			if(answer==-1) break;
		}
		
		System.out.println(answer);
		br.close();
	}
	
	// 너비 우선 탐색
	static void bfs() {
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int ii=temp[0];
			int jj=temp[1];
			for(int d=0; d<4; d++) {
				int ni=ii+di[d];
				int nj=jj+dj[d];
				if(0<=ni&&ni<n && 0<=nj&&nj<m && !v[ni][nj] && map[ni][nj]!=-1) {
					v[ni][nj]=true;
					map[ni][nj]=map[ii][jj]+1;
					q.offer(new int[] {ni, nj});
				}
			}
		}
	}
	
	
}
