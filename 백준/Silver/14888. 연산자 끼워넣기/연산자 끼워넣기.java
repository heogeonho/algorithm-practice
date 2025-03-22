import java.io.*;
import java.util.*;

class Main {
    static int len;
    static int[] nums;     
    static int[] op = new int[4]; // 매열의 인덱스: 연산 부호, 배열의 값: 연산자 개수
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    // 순조부 풀던게 생각 남. dfs 로 처리해봄
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        // 전체 돌면서 결과 찾기
        dfs(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int cnt, int result) {
        if (cnt == len) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        // 각 연산자에 맞게 값 업데이트
        // visit는 필요 x op의 값이 0이면 처리 x
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch (i) {
                    case 0: dfs(cnt + 1, result + nums[cnt]); break;
                    case 1: dfs(cnt + 1, result - nums[cnt]); break;
                    case 2: dfs(cnt + 1, result * nums[cnt]); break;
                    case 3: dfs(cnt + 1, result / nums[cnt]); break;
                }

                op[i]++;
            }
        }
    }
}