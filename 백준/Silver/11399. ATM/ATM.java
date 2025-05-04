import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 작은 수 먼저 처리할 수 있도록 정렬
        Arrays.sort(arr);
        
        // 시간을 누적하여 소요시간 총 합 산출
        int res = 0;
        int temp = 0;
        for(int i = 0; i < N; i++) {
            temp += arr[i];            
            res += temp;
        }
        System.out.println(res);
    }
}