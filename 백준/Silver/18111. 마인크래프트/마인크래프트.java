import java.io.*;
import java.util.*;

class Main {

    static int N; // 세로
    static int M; // 가로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken()); // 블록 수

        int[][] map = new int[N][M];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                max = Math.max(max, temp);
                min = Math.min(min, temp);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = 0;

        for (int h = min; h <= max; h++) {
            int t = culTime(h, map, B);
            if (t != -1) {
                if (t < resultTime) {
                    resultTime = t;
                    resultHeight = h;
                } else if (t == resultTime && h > resultHeight) {
                    resultHeight = h;
                }
            }
        }
        System.out.println(resultTime + " " + resultHeight);
    }


    static int culTime(int h, int[][] m, int b) {
        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cur = m[i][j];
                if (cur > h) {
                    int diff = cur - h;
                    res += diff * 2;
                    b += diff;
                } else if (cur < h) {
                    int diff = h - cur;
                    res += diff * 1;
                    b -= diff;
                }
            }
        }
        return b >= 0 ? res : -1;
    }
}
