import java.util.*;
import java.io.*;

public class Main {
	
	/*
	주어진 배열 정렬 (2차원 배열로 인덱스 값까지 저장)
	
	새로 만든 2차원 배열 정렬
	
	꺼낸 값을 저장하는 (값 꺼내면서 비교 같으면 압축결과 값 늘리지 않고 커지면 늘려서 할당)
	 */
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N][2];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<N; i++) {
			arr[i]=new int[] {Integer.parseInt(st.nextToken()),i};
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			return Integer.compare(o1[0],o2[0]);	
		});
		
//		for(int[] a: arr) System.out.println(Arrays.toString(a));
		
		int[] res=new int[N];
		int cnt=0;
		int temp=arr[0][0];
		res[arr[0][1]]=cnt;
		
		for(int i=1; i<N; i++) {
			if(temp!=arr[i][0]) cnt++;
			res[arr[i][1]]=cnt;
			temp=arr[i][0];
		}
		
		for(int k:res) sb.append(k).append(" ");
		
		System.out.print(sb.toString());
		br.close();
	}
}