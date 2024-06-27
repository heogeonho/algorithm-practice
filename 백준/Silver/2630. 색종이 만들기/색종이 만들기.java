import java.util.*;
import java.io.*;

public class Main {
	static void partition(int x, int y, int size) {
		int findColor=color[y][x];
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				// 범위 돌다가 시작점과 다른 색이 존재하면 자르기위한 과정 넘기기 (findColor 변수에-1을 줘서 단계 넘기기)
				if(color[y+j][x+i]!=findColor) {
					findColor=-1;
					break;
				}				
			}
			if(findColor==-1) break;
		}
		if(findColor==1) blueCnt+=1;
		else if(findColor==0) whiteCnt+=1;
		else {
			size=size/2;
			partition(x     ,y     ,size);
			partition(x+size,y     ,size);
			partition(x     ,y+size,size);
			partition(x+size,y+size,size);
		}
	}
	
	static int[][] color;
	static int whiteCnt=0;
	static int blueCnt=0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		int N=Integer.parseInt(br.readLine());
		color=new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				color[i][j]=Integer.parseInt(st.nextToken());
			}
		}	
		partition(0,0,N);
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
		br.close();
	}
}
