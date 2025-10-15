import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer,Integer> eat = new HashMap<>();
        eat.put(c, 1);

        // 초기 윈도우
        for (int i = 0; i < k; i++) {
            int s = sushi[i];
            eat.put(s, eat.getOrDefault(s, 0) + 1);
        }

        int max = eat.size();

        // 슬라이딩
        int start = 0, end = k;
        for (int i = 0; i < N - 1; i++) { // N번 돌려도 됨
            int out = sushi[start++];
            int cnt = eat.get(out); // 한 번만 get
            if (out != c && cnt == 1) eat.remove(out);
            else eat.put(out, cnt - 1);

            int in = sushi[end % N];
            eat.put(in, eat.getOrDefault(in, 0) + 1);
            end++;

            int sz = eat.size();
            if (sz > max) max = sz;
        }
        System.out.println(max);
    }
}