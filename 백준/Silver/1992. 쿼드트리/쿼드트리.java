import java.util.*;
import java.io.*;

public class Main {
	static void partition(int x, int y, int size) {
		int value=video[y][x];
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				// 범위 돌다가 시작점과 다른 색이 존재하면 자르기위한 과정 넘기기 (findColor 변수에-1을 줘서 단계 넘기기)
				if(video[y+j][x+i]!=value) {
					value=-1;
					sb.append("(");
					break;
				}				
			}
			if(value==-1)  break;
		}
		if(value==1) sb.append("1");
		else if(value==0) sb.append("0");
		else {
			size=size/2;
			partition(x     ,y     ,size);
			partition(x+size,y     ,size);
			partition(x     ,y+size,size);
			partition(x+size,y+size,size);
			sb.append(")");
		}
	}
	
	static int[][] video;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		video=new int[N][N];
		for(int i=0; i<N; i++) {
			String temp=br.readLine();
			for(int j=0; j<N; j++) {
				video[i][j]=(temp.charAt(j)-'0');
			}
		}
		partition(0,0,N);
		System.out.println(sb);
		br.close();
	}
}
