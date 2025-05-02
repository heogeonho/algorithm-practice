import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] money = new int[N];
        
        // 입력을 높은가격순으로 배열에 저장
        while(N-- > 0) {
            money[N] = Integer.parseInt(br.readLine());
        }
        
        // 결과 찾기
        // 큰 금액부터 순회 -> 몫이 0이 아닌 경우 몫에 대한 처리 진행
        int result = 0;
        for(int i = 0; i < money.length; i++) {
            if(money[i] > K) continue;
            result += K/money[i];
            K -= money[i]*(K/money[i]);
            if(K==0) break;
        }
        System.out.println(result);
    }
}