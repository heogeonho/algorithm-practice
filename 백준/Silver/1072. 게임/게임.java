import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long winRate = (Y * 100) / X;

        if (winRate >= 99) { // 99 보다 늘릴 수 없음 미리 처리
            System.out.println(-1);
            return;
        }

        long low = 0, high = X, answer = -1;

        while (low <= high) {
            long mid = (low + high) / 2;
            long newWinRate = ((Y + mid) * 100) / (X + mid);

            if (newWinRate > winRate) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }
}