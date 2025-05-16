import java.io.*;
import java.util.*;

// 2차원 배열을 활용해 인덱스 값을 포함해 정렬 진행
// 인덱스를 순회하며 앞 숫자와 같은지 판별 후 값 할당 
// 같은 경우 이전 수 활용, 다른 경우 인덱스 값 활용해 업데이트

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] valueIdxArr = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            valueIdxArr[i] = new int[] {Integer.parseInt(st.nextToken()), i};
        }

        Arrays.sort(valueIdxArr, (o1, o2) -> {
            return o1[0]-o2[0];
        });

        int[] res = new int[N];
        int preVal = Integer.MIN_VALUE;
        int preIdx = -1;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            int curVal = valueIdxArr[i][0];
            int curIdx = valueIdxArr[i][1];
            if (preVal != curVal) {
                res[curIdx] = idx;
                preVal = valueIdxArr[i][0];
                preIdx = idx;
                idx++;
            } else {
                res[curIdx] = preIdx;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}