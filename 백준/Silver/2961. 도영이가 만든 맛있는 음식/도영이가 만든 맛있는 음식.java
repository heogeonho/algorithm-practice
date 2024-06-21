import java.io.*;
import java.util.*;

public class Main {
	static int N, T=2; //재료 갯수N, 맛의 종류T
	static int[][] a;
	static int min=Integer.MAX_VALUE;

	static void subs(int cnt, int S, int B, int isEmpty) {

		//끝까지 돌면 리턴
		if(cnt==N) {
			
			if(isEmpty!=0) {
				//부분집합 내부 재료들의 맛별 계산 수치 산출하기
				//수치의 차이 구하기
				int result=Math.abs(S-B);
				//해당 차이 값으로 전역변수 min 업데이트하기;
				if(min>result) {
					min=result;
				}
				
			}
			return;
		}
		subs(cnt+1,S*a[cnt][0],B+a[cnt][1], isEmpty+1);
		subs(cnt+1,S,B, isEmpty);
	}

	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		N=Integer.parseInt(br.readLine());
		a=new int[N][T];
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			a[i][0]=Integer.parseInt(st.nextToken());
			a[i][1]=Integer.parseInt(st.nextToken());			
		}
//		for(int[] al:a) System.out.print(Arrays.toString(al)+" ");
		
		//재료의 부분집합 구하기 (parameter에 1차원배열이 들어가면 될까? -> 맛을 각각 넘겨주자!!!!)
		subs(0,1,0, 0);
		
		//결과 출력하기
		System.out.println(min);
		
		br.close();
	}
}
