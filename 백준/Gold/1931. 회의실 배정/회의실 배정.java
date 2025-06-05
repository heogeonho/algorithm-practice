import java.io.*;
import java.util.*;

// 마지막 시간을 먼저 배열해서 처리
// 종료 시간이 빠른 회의부터 배정 -> 남은 시간 동안 회의를 최대한 많이 넣을 수 있음 그리디 조건

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int cnt = 0;
        int lastEnd = 0;

        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= lastEnd) {
                lastEnd = meetings[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}