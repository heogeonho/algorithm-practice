import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] members = new String[N][2]; // [][0]: 나이, [][1]: 이름

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members[i][0] = st.nextToken();
            members[i][1] = st.nextToken();
        }
        
        // 정렬하기
        Arrays.sort(members, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(members[i][0]).append(" ").append(members[i][1]).append("\n");
        }

        System.out.print(sb);
    }
}