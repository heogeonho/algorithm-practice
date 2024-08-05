import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//총 과일의 갯수 N
		int N=Integer.parseInt(br.readLine());
	
		//탕후루 과일들 표현하는 배열
		int[] arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		//포인터 2개 생성 (index 표현)
		int leftPointer=0, rightPointer=0;
		
		//투포인터 로직 구현
		int maxCnt=Integer.MIN_VALUE; // 최대 길이 저장을 위한 변수
		int[] fruits=new int[10]; //탕후루에 있는 과일을 나타내기 위한 배열 (인덱스->과일, 배열 값->과일 갯수)
		int kind=1;
		fruits[arr[0]]=1;
		while(true) {
			if(kind<=2) {
				maxCnt=Math.max(rightPointer-leftPointer+1, maxCnt) ;
				rightPointer++;
				if(rightPointer==N) break;
				if(fruits[arr[rightPointer]]==0) {
					kind++;
				}
				fruits[arr[rightPointer]]++;
			}
			else {
				fruits[arr[leftPointer]]--;
				if(fruits[arr[leftPointer]]==0) kind--;
				leftPointer++;
			}
		
			if(leftPointer==N-1) break;
		}
		
		System.out.println(maxCnt);
		br.close();
	}
}