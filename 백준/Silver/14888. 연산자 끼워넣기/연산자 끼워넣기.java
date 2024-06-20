import java.util.*;
import java.io.*;

public class Main {
	static int MIN=Integer.MAX_VALUE , MAX=Integer.MIN_VALUE;
	static int N;
	static int[] number;
	static ArrayList<String> operator ;
	static String[] O;
	static boolean[] v;
	
	//연산자의 순열 찾기
	private static void perm(int cnt) {
		if(cnt==N-1) {
			cal();
			return;
		}
		for(int i=0; i<N-1; i++) {
			if(v[i]) continue;
			v[i]=true;
			O[cnt]=operator.get(i);
			perm(cnt+1);
			v[i]=false;
		}
	}
	
	private static void cal() {
		int result=number[0];
		//연산자로 계산 진행 후 max, min 업데이트
		for (int i = 0; i < O.length; i++) {
			String op = O[i];
			int value = number[i+1];
			switch(op) {
				case "+":
					result += value;
					break;
				case "-":
					result -= value;
					break;
				case "*":
					result *= value;
					break;
				case "/":
					result /= value;
					break;
			}	
		}
		MAX=Math.max(result, MAX);
		MIN=Math.min(result, MIN);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		N=Integer.parseInt(br.readLine());
		number=new int[N];
		
		st=new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			number[i]=Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(number));
		
		//연산자가 저장되는 Array list
		st=new StringTokenizer(br.readLine()," ");
		operator =new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int k=Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				if(i==0) operator.add("+");
				else if(i==1) operator.add("-");
				else if(i==2) operator.add("*");
				else if(i==3) operator.add("/");
			}
		}
//		System.out.println(operator.toString());
//		System.out.println(operator.get(2));
		
		//연산자 순열 돌리기
		v=new boolean[N-1];
		O=new String[N-1];
		perm(0);
		
		//그때마다 계산 결과 돌리기 최소 최대 값 업데이트
		//끝나고 결과 출력하기
		System.out.println(MAX);
		System.out.println(MIN);
	}
}
