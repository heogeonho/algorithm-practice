import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, 1);
        }
        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // value가 2인 key만 리스트에 추가
        List<String> result = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key) == 2) {
                result.add(key);
            }
        }

        // 사전순 정렬
        Collections.sort(result);
        
        System.out.println(result.size());
        for(String s : result) {
            System.out.println(s);
        }
    }
}