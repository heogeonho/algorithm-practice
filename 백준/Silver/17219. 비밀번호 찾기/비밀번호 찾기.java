import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, String> pHash = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            pHash.put(site, password);
        }

        for (int i = 0; i < M; i++) {
            String site = br.readLine();
            sb.append(pHash.get(site)).append("\n");
        }
        System.out.print(sb);
    }
}