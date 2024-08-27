import java.util.*;

class Solution {
	static int[] di = new int[] {-1,0,1,0};
	static int[] dj = new int[] {0,1,0,-1};
	static boolean[][] v;
	static int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;

		v = new boolean[n][m];

		return bfs(0,0, maps, n, m);
	}

	private static int bfs(int i, int j, int[][] maps, int n, int m) {

		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {0, 0});
		v[0][0]=true;
		maps[0][0]=1;

		while (!dq.isEmpty()) {
			int[] ij = dq.poll();
			int ii = ij[0];
			int jj = ij[1];
			for (int d=0; d<4; d++) {
				int ni = ii + di[d];
				int nj = jj + dj[d];
				if(0<=ni&&ni<n && 0<=nj&&nj<m && !v[ni][nj] && maps[ni][nj]==1) {
					dq.offer(new int[] {ni, nj});
					maps[ni][nj]=maps[ii][jj]+1;
					v[ni][nj]=true;
				}
			}
		}

		if(v[n-1][m-1]) {
			return maps[n-1][m-1];
		}
		return -1;
	}
}