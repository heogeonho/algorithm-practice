import java.util.*;
import java.io.*;

public class Main {
	static int[][] board=new int[5][5];
	static int bingo=0;

	static void find(int pickedNum) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(board[i][j]==pickedNum) {
					board[i][j]=0; 
					return;
				}
			}
		}
	}
	
	static void checkRow() {
		if(bingo==3) return;	
		for(int i=0; i<5; i++) {
			int isBingo=0;
			for(int j=0; j<5; j++) {
				if(board[i][j]==0) {
					isBingo++;
				}
			}
			if(isBingo==5) bingo+=1;
		}
	}
	
	static void checkColum() {
		if(bingo==3) return;	
		for(int j=0; j<5; j++) {
			int isBingo=0;
			for(int i=0; i<5; i++) {
				if(board[i][j]==0) {
					isBingo++;
				}
			}
			if(isBingo==5) bingo+=1;
		}
	}
	
	private static void checkDiagonal1() {  // 좌상 -> 우하 대각선 index 0,0 ~ 4,4
		if(bingo==3) return;	
		int isBingo=0;
		for(int i=0; i<5; i++) {
			if(board[i][i]==0) {
				isBingo++;
			}
		}
		if(isBingo==5) bingo+=1;
	}

	private static void checkDiagonal2() { // 우상 -> 좌하 대각선 index 0,4 ~ 4,0
		if(bingo==3) return;	
		int isBingo=0;
		for(int i=0; i<5; i++) {
			if(board[i][4-i]==0) {
				isBingo++;
			}
		}
		if(isBingo==5) bingo+=1;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		for(int i=0; i<5; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5; j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for(int i=0; i<5; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5; j++) {
				int pickedNum=Integer.parseInt(st.nextToken());
				cnt++;
				find(pickedNum);
				// [행_row][열_col]
				bingo=0;
				checkRow();
				checkColum();
				checkDiagonal1();
				checkDiagonal2();
				if(bingo>=3) break;				
			}
			if(bingo>=3) break;
		}
		
		System.out.println(cnt);
		br.close();
	}
}