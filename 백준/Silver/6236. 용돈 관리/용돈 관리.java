import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int[] amt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        amt = new int[N];
        int max = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            int d = Integer.parseInt(br.readLine());
            amt[i] = d;
            max = Math.max(max, d);
            sum += d;
        }

        int l = max;
        int r = sum;
        int mid = 0;
        int ans = 0;

        while (l <= r) {
            mid = l+((r-l)/2);
            
            if (getCnt(mid) <= M) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }
    static int getCnt(int withdraw) {
        int cnt = 1;
        int money = withdraw;

        for (int i : amt) {
            money -= i;
            if (money < 0) {
                cnt++;
                money = withdraw - i;
            }
        }
        return cnt;
    }
}