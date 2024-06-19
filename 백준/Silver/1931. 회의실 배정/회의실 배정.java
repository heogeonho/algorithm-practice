import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine()); //11
		int[][] timeList=new int[N][2]; //길이가 11인 리스트 생성
		 for (int i = 0; i < N; i++) { //11번 반복 & 리스트에 값 넣기
			st=new StringTokenizer(br.readLine());
			timeList[i][0]=Integer.parseInt(st.nextToken());
			timeList[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(timeList, (o1, o2)->{
			int compareResult=Integer.compare(o1[1],o2[1]); //회의 끝시간 비교 -> o2[1]이 크면 -1, 둘이 같으면 0, o1[1]이 크면 1;
			if(compareResult==0) {
				return Integer.compare(o1[0],o2[0]);
			}
			return compareResult;
		});
		
		int cnt=0;
		int prev_end=0;
		
		for(int i=0; i<N; i++) {	// 타임 리스트 쭉 돌면서
			if(prev_end <= timeList[i][0]) { //이전 종료 타임이 다음 시작보다 작으면
				prev_end= timeList[i][1]; //이전 종료 타임 업데이트 (회의실 사용인 회의 찾았음)
				cnt++;	//회의 진행한 것으로 카운트 체크
			}
		}
		
		System.out.println(cnt);
//		for(int[] i:a) System.out.print(Arrays.toString(i)+" ");
		br.close();
	}
}
