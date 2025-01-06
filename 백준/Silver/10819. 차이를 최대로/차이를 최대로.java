import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int[] array;
    static int[] result;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        array = new int[N];
        result = new int[N];
        v = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        perm(N, 0);
        System.out.println(max);
    }

    static void perm(int N, int depth) {
        if (depth == N) {
            max = Math.max(max, calDiff());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                result[depth] = array[i];
                perm(N, depth + 1);
                v[i] = false;
            }
        }
    }

    static int calDiff() {
        int sum = 0;
        for (int i = 0; i < result.length - 1; i++) {
            sum += Math.abs(result[i] - result[i + 1]);
        }
        return sum;
    }
    
}
