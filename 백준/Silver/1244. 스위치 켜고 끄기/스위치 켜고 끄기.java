import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_bj_1244.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		
		/*
		 1 이상 스위치 개수 이하 자연수 받고 받은 수 처리는
		 남학생 배수 스위치 반전
		 여학생 좌우 대칭 영역 최대 갯수 반전
		 */
		
		int N=Integer.parseInt(br.readLine()); //스위치의 개수
		int sList[]=new int[N];
		st=new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			sList[i]=Integer.parseInt(st.nextToken()); // 스위치 상태 배열화
		}
		
		int stuNum=Integer.parseInt(br.readLine()); //학생 수
		// 1 남학생, 2 여학생
		for (int i = 0; i < stuNum; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int stu = Integer.parseInt(st.nextToken());

			if(stu==1) { //남학생
				int num=Integer.parseInt(st.nextToken()); //받은 숫자
				int x = 1;
				while(x*num <= N) { //남학생은 배수 단위로 값을 변경한다 그 범위가 스위치 개수를 넘으면 안됨
					if(sList[x*num-1]==0) { // 값 비교후 반대 값 넣기
						sList[x*num-1]=1;
					} else {						
						sList[x*num-1]=0;
					}
					x++;
				}
			} else { //여학생
				int num=Integer.parseInt(st.nextToken()); //받은 숫자
				//여학생은 양 옆 대칭을 비교해야한다
				//0보다 작아지면 안됨
				//배열의 길이-1 인덱스를 넘어가면 안됨
				//다르면 중단하고 값 바꾸기
				int y = 0;
				while(num - y >= 1 && num + y <= N && sList[num - y - 1] == sList[num + y - 1]) {
					y++;
				}
				y--;
				for (int j = num - y; j <= num + y; j++) {
		            if (sList[j - 1] == 0) {
		                sList[j - 1] = 1;
		            } else {
		                sList[j - 1] = 0;
		            }
		        }
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(i%20==0) {
				sb.append(sList[i-1]).append("\n");
			}else {
				sb.append(sList[i-1]).append(" ");				
			}
		}
		
		
		
		System.out.println(sb);
	
		
		br.close();
	}
}
