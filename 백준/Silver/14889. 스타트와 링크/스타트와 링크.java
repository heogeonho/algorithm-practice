import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[] v;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);
        System.out.println(min);
    }

    private static void comb(int cnt, int start) {
        if (cnt == N / 2) {
            culDiff();
            return;
        }
        for (int i = start; i < N; i++) {
            if (!v[i]) {
                v[i] = true;   
                comb(cnt + 1, i + 1);  
                v[i] = false;   
            }
        }
    }

    static void culDiff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {

                if (v[i] && v[j]) {
                    team_start += map[i][j];
                    team_start += map[j][i];
                } else if (!v[i] && !v[j]) {
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }
        int val = Math.abs(team_start - team_link);
        
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
        min = Math.min(val, min);

    }
}
