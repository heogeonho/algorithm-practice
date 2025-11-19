import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] prices = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            long maxProfit = calMaxProfit(prices);
            sb.append(maxProfit).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static long calMaxProfit(int[] prices) {
        int len = prices.length;
        long profit = 0L;
        int maxPrice = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            } else {
                profit += (maxPrice - prices[i]);
            }
        }

        return profit;
    }
}