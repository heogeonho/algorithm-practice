import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣지 못한 N명 set 처리
        Set<String> unheard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        // 듣보잡
        List<String> result = new ArrayList<>();

        // Set에 있는 경우만 리스트에 추가
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                result.add(name);
            }
        }
        // 사전 순
        Collections.sort(result);
        sb.append(result.size()).append('\n');
        for (String name : result) {
            sb.append(name).append('\n');
        }
        System.out.print(sb);

    }
}