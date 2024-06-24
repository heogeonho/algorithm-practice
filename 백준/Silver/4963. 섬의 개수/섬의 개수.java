import java.util.*;
import java.io.*;

public class Main {
	 					//  상 상우 우 하우 하 하좌 좌 상좌
	static final int[] di= {-1,-1, 0, 1, 1, 1, 0,-1}; 
	static final int[] dj= {0 , 1, 1, 1, 0,-1,-1,-1};
	static int w, h, C=0;
	static int[][] a;
	static boolean[][] v;
	static StringBuilder sb=new StringBuilder(); 
	
	private static void dfs(int i, int j) {
		v[i][j]=true;
		for(int d=0; d<8; d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni&&ni<h && 0<=nj&&nj<w && !v[ni][nj] && a[ni][nj]==1) {
				dfs(ni,nj);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;

		while(true) {
			st=new StringTokenizer(br.readLine()," ");
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			a=new int[h][w];
			v=new boolean[h][w];
			
			if(w==0&&h==0) break;
			
			for(int i=0; i<h; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<w; j++) {
					a[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int count=0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!v[i][j] && a[i][j]==1) {
						count++;
						dfs(i,j);
					}
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}