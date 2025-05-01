import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> findPW = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        // 입력 값 Map 에 삽입
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String domain = st.nextToken();
            String pw = st.nextToken();
            findPW.put(domain, pw);
        }

        while (M-- > 0) {
            String input = br.readLine();
            sb.append(findPW.get(input)).append("\n");
        }
        System.out.println(sb);

    }
}