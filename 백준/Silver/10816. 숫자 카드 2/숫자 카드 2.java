import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		
		int[] card=new int[N];
		st=new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			card[i]=Integer.parseInt(st.nextToken());
		}
		
		int M=Integer.parseInt(br.readLine());
		
		int[] find=new int[M];
		st=new StringTokenizer(br.readLine(), " ");		
		for(int i=0; i<M; i++) {
			find[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		
		for(int i=0; i<M; i++) {
			int num=find[i];

			int cnt= (upper(card,num)-lowwer(card, num));
			
			sb.append(cnt+" ");
		}
		System.out.println(sb);
	}
	
	static int lowwer(int[] arr, int a) {
		int start = 0;
		int end = arr.length;
		int mid;
		
		while(start < end) {
			
			mid = (start+end)/2;
			
			if(a <= arr[mid]) {
				end = mid;
			}else {
				start = mid + 1;
			}
			
		}
		
		return start;
	}
	
	static int upper(int[] arr, int a) {
		
		int start = 0;
		int end = arr.length;
		int mid;
		
		while(start < end) {
			
			mid = (start+end)/2;
			
			if(a < arr[mid]) {
				end = mid;
			}else {
				start = mid + 1;
			}
			
		}
		
		return start;
	}


}
