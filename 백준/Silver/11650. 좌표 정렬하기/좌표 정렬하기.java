import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		int[][] a=new int[N][2];
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			a[i][0]=Integer.parseInt(st.nextToken());
			a[i][1]=Integer.parseInt(st.nextToken());
		}
//		for(int[] al:a) System.out.print(Arrays.toString(al)+" ");
		
		Arrays.sort(a, (o1,o2)->{
			int compRes=Integer.compare(o1[0], o2[0]);
			if (compRes==0) {
				return Integer.compare(o1[1], o2[1]);
			}
			return compRes;
		});
		
		for(int[] al:a) sb.append(al[0]+" "+al[1]).append("\n");
		System.out.println(sb);
		br.close();
	}
}