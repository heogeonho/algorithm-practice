import java.util.*;
import java.io.*;

public class Main {
	static int min=Integer.MAX_VALUE;
	static int[] case1={1,0,1,0,1,0,1,0};
	static int[] case2={0,1,0,1,0,1,0,1};
	static int[][] board;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		int N=Integer.parseInt(st.nextToken()); //8<= __ <=50
		int M=Integer.parseInt(st.nextToken());
		
		board=new int[N][M];
	
		for(int i=0; i<N; i++) {
			String str=br.readLine();
			for(int j=0; j<M; j++) {
				char temp=str.charAt(j);
				if(temp=='W') board[i][j]=1; 	//1은 흰색
				else board[i][j]=0;				//0은 검정
			}
		}
//		for(int[] al:board) System.out.println(Arrays.toString(al));
	
		int yLoop=N-8+1;
		int xLoop=M-8+1;
		for(int i=0; i<yLoop; i++) {		//전체 순회
			for(int j=0; j<xLoop; j++) {
				check8By8(i,j);
			}
		}
		
		System.out.println(min);
	}

	//색칠 수 구하기 함수 (최솟값 업데이트까지)
	static void check8By8(int y,int x) {
		int cnt=0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(i%2==0) {
					if(board[y+i][x+j]!=case1[j]) {
						cnt++;
					}					
				} else {
					if(board[y+i][x+j]!=case2[j]) {
						cnt++;
					}	
				}
			}
		}
		if(cnt<min) min=cnt;
		
		cnt=0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(i%2==0) {
					if(board[y+i][x+j]!=case2[j]) {
						cnt++;
					}					
				} else {
					if(board[y+i][x+j]!=case1[j]) {
						cnt++;
					}	
				}
			}
		}
		if(cnt<min) min=cnt;
	}

}
