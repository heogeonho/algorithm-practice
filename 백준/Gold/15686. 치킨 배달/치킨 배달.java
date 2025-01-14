import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int min = Integer.MAX_VALUE;
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static boolean[] mList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 도시 크기
        M = Integer.parseInt(st.nextToken()); // 폐업 x 치킨집 수


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    home.add(new int[]{i, j});
                } else if (temp == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        // 폐업 x 치킨집 고르고
        // 각 상황에서 치킨거리 구하고
        // 최소값 구하기 
        mList = new boolean[chicken.size()];
        comb(0, 0); // 조합을 통해 치킨집 선택
        System.out.println(min);
    }

    // 조합으로 치킨집 M개 선택
    static void comb(int cnt, int start) {
        if (cnt == M) {
            // 선택된 치킨집으로 최소 치킨 거리 계산
            calculateDistance();
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (mList[i]) continue;
            mList[i] = true;
            comb(cnt + 1, i + 1);
            mList[i] = false;
        }
    }

    // 선택된 치킨집으로 치킨 거리 계산
    static void calculateDistance() {
        int totalDistance = 0;

        for (int[] h : home) {
            int distance = Integer.MAX_VALUE;

            for (int i = 0; i < chicken.size(); i++) {
                if (mList[i]) { // 선택된 치킨집만 계산
                    int[] c = chicken.get(i);
                    distance = Math.min(distance, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                }
            }
            totalDistance += distance;
        }

        min = Math.min(min, totalDistance); // 최소 치킨 거리 업데이트
    }

}
