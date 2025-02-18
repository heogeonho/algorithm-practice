import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        집 N개 수직선 위에 있다
        모두 다른 좌표
        집에 공유기 C개 설치

        C개 공유기 N개 집에 적절히 설치해서,
        가장 인접한 두 공유기 사이 거리 최대 구하기

        2 <= N <= 200,000
        2 <= C <= N
        0 <= 좌표 <= 1,000,000,000
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] positions = new int[N];
        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(positions);

        int minDist = 0;
        int low = 0;
        int high = positions[N - 1] - positions[0] + 1;

        while (low < high) {
            minDist = (high + low) / 2;
            int cnt = cntHouse(minDist, positions);

            if (cnt < C) {
                high = minDist;
            } else {
                low = minDist+1;
            }
        }
        System.out.println(low-1);

    }

    // 공유기 설치 집 수 계산 함수 -> return값 C개 나올때까지 탐색 진행
    static int cntHouse(int minDist, int[] positions) {
        int prePosition = positions[0];
        int cnt = 1;
        for (int position : positions) {
            if (position - prePosition >= minDist) {
                cnt++;
                prePosition = position;
            }
        }
        return cnt;
    }
}
/*
어떤 것을 기준으로 이분탐색을 진행해야 했을지 고민이 많았던 문제
결국 해설 확인.
같은 유형 여러번 풀고 다른 사람 풀이 비교하며 익숙해질 것
 */