import java.io.*;
import java.util.*;

class Main {

    static int s, N, K, R1, R2, C1, C2;
    static char[][] arr; // 실제로 출력할 부분만 담는 배열 (최대 50 x 50)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        int totalSize = (int) Math.pow(N, s);
        
        // 출력해야 하는 영역의 높이, 너비
        int h = R2 - R1 + 1;
        int w = C2 - C1 + 1;

        // 출력 영역 크기만큼만 배열 생성
        arr = new char[h][w];

        divide(0, 0, totalSize, false);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    static void divide(int x, int y, int size, boolean isBlack) {

        if (x > C2 || x + size <= C1 || y > R2 || y + size <= R1) {
            return;
        }

        if (size == 1) {
            int yy = y - R1;
            int xx = x - C1;

            arr[yy][xx] = isBlack ? '1' : '0';
            return;
        }

        int nSize = size / N; // 한 블록의 한 변 길이

        // [blackStart, blackEnd) 범위가 중앙
        int blackStart = (N - K) / 2;
        int blackEnd   = blackStart + K;

        for (int i = 0; i < N; i++) {
            int nY = y + nSize * i; // i번째 블록의 실제 y 좌표(왼쪽 위)

            for (int j = 0; j < N; j++) {
                int nX = x + nSize * j; // j번째 블록의 실제 x 좌표(왼쪽 위)

                boolean inCenter =
                        (i >= blackStart && i < blackEnd) &&
                        (j >= blackStart && j < blackEnd);

                boolean nextIsBlack = isBlack || inCenter;

                divide(nX, nY, nSize, nextIsBlack);
            }
        }
    }
}