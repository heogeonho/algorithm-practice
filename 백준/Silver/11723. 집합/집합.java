import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 연산의 수 M가 3,000,000
        // 각 연산은  50 
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 결과 저장용 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());
        boolean[] S = new boolean[21]; // 1~20 사용

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            
            if (cmd.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                S[x] = true;
            } else if (cmd.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                S[x] = false;
            } else if (cmd.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(S[x] ? "1\n" : "0\n");
            } else if (cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                S[x] = !S[x];
            } else if (cmd.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    S[j] = true;
                }
            } else if (cmd.equals("empty")) {
                for (int j = 1; j <= 20; j++) {
                    S[j] = false;
                }
            }
        }
        
        // 결과 한 번에 출력
        System.out.print(sb.toString());
    }
}