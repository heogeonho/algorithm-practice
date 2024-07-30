import java.io.*;
import java.util.*;

/*
bfs를 활용해야 한다고 생각

먼저 지도를 입력받고 숫자 2의 인덱스 값을 찾아야 함

bfs 동작을 실행하면서 한 회전당 숫자를 +1하여 삽입
전체 방문처리 후
최종적으로 방문 false인 곳과 지도의 값이 1인 경우를 -1로 수정해준다.
n과 m은 1000이하의 범위 (1,000,000 정도면?)
 */

public class Main {
	static int n, m;			// 세로n, 가로m
	static int[][] map; 			// 지도
	static boolean[][] v;			// 방문처리
	
	static int[] di={-1, 0, 1, 0}; //상우하좌
	static int[] dj={0, 1, 0, -1}; //상우하좌
	
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		st=new StringTokenizer(br.readLine(), " ");
		n=Integer.parseInt(st.nextToken()); // 세로
		m=Integer.parseInt(st.nextToken()); // 가로
		map=new int[n][m];
		v=new boolean[n][m];
		int startN=0;
		int startM=0;
		// map 2차원 변수 생성
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				int input=Integer.parseInt(st.nextToken());
				map[i][j]=input;
				if(input==2) {
					startN=i;	// 시작 점 index 저장
					startM=j;
				}
			}
		}
		
		// map test출력
//		for(int[] ai: map) System.out.println(Arrays.toString(ai));
		
		bfs(startN, startM);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(v[i][j] || map[i][j]==0) {
					sb.append(map[i][j]).append(" ");
				} else {
					sb.append(-1).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	// 너비 우선 탐색
	static void bfs(int startN, int startM) {
		ArrayDeque<int[]> q=new ArrayDeque<>(); // 가로 세로 int[] 담는 큐
		
		v[startN][startM]=true;	// 시작점 방문 처리 및 큐 삽입
		map[startN][startM]=0;
		q.offer(new int[] {startN, startM});
		
		while(!q.isEmpty()) {
			int[] temp=q.poll();
			int ii=temp[0];
			int jj=temp[1];
			for(int d=0; d<4; d++) {
				int ni=ii+di[d];
				int nj=jj+dj[d];
				if(0<=ni&&ni<n && 0<=nj&&nj<m && !v[ni][nj] && map[ni][nj]!=0) {
					v[ni][nj]=true;
					map[ni][nj]=map[ii][jj]+1;
					q.offer(new int[] {ni, nj});
				}
			}
		}
	}
}