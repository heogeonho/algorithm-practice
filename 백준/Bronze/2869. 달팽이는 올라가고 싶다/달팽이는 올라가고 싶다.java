import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int up = A - B;
        int res = (V - A) / up; // 마지막 날 A만큼 올라가고 미끄러지지 않음

        if ((V - A) % up != 0) {
            res++; // 나머지가 있다면 하루 더 필요함
        }

        System.out.println(res + 1); // 마지막 올라가는 날 (+1)
    }
}