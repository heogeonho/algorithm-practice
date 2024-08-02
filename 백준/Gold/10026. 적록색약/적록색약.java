import java.util.*;
import java.io.*;

public class Main {
	static int N, a=0, b=0;
	static char[][] map;
	static boolean[][] vA, vB;
	
	static int[] di =new int[] {1,0,-1,0};
	static int[] dj =new int[] {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str=br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		vA=new boolean[N][N];
		vB=new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!vA[i][j]) {
					a++;
					dfsA(i, j);
				}
				if (!vB[i][j]) {
					b++;
					dfsB(i, j);
				}
			}
		}
		
		sb.append(a).append(" ").append(b);
		System.out.print(sb.toString());
		br.close();
	}

	private static void dfsA(int i, int j) {
		vA[i][j]=true;
		char value=map[i][j];
		for (int d=0; d<4; d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni&&ni<N && 0<=nj&&nj<N 
					&& !vA[ni][nj] && map[ni][nj]==value) {
				dfsA(ni,nj);
			}
		}
	}
	
	private static void dfsB(int i, int j) {
		vB[i][j]=true;
		char value=map[i][j];
		for (int d=0; d<4; d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(value=='R' || value=='G') {
				if(0<=ni&&ni<N && 0<=nj&&nj<N 
						&& !vB[ni][nj] && (map[ni][nj]=='R' || map[ni][nj]=='G')) {
					dfsB(ni,nj);
				}
			} else {
				if(0<=ni&&ni<N && 0<=nj&&nj<N 
						&& !vB[ni][nj] && map[ni][nj]==value) {
					dfsB(ni,nj);
				}
			}
		}	
	}
}