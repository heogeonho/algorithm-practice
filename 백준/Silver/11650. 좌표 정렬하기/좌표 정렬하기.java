import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i][0] = x;
            points[i][1] = y;
        }

        // 메인 로직 (정렬)
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0]; // x좌표 오름차순
            return o1[1] - o2[1]; // y좌표 오름차순
        });
        
        StringBuilder sb = new StringBuilder();
        for (int[] p : points) {
            sb.append(p[0]).append(" ").append(p[1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}