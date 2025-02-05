import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] memberList = new int[N][2];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                memberList[j][0] = Integer.parseInt(st.nextToken());
                memberList[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(memberList, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            int top = Integer.MAX_VALUE;
            int cnt = 0;
            for (int[] member : memberList) {
                if (member[1] < top) {
                    cnt++;
                    top = member[1];
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
