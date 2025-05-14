import java.io.*;
import java.util.*;

// 안입는 경우 처리를 복잡하게 생각해서 초반에 방향을 잘 못잡은 문제
// 단순히 + 1을 해주어 해결할 수 있었음 null 선택지 (단 최종 결과 산출에 알몸인 경우 처리 -1)

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        // 테스트 반복
        while (T-- > 0) {
            // 각 옷 종류의 갯수를 세기 위한 map
            HashMap<String, Integer> map =  new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            while(n-- > 0) {
                String input = br.readLine();
                String[] temp = input.split(" ");
                map.put(temp[1],map.getOrDefault(temp[1],0)+1);
            }
            Collection<Integer> v = map.values();
            int res = 1;
            for(int num: v) {
                res = res * (num+1);
            }
            sb.append(res-1).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}