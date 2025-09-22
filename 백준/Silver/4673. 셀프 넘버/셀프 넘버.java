import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        boolean[] generated = new boolean[10000 + 1];

        for (int n = 1; n <= 10000; n++) {
            int s = selfNum(n);
            if (s <= 10000) generated[s] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (!generated[i]) sb.append(i).append('\n');
        }

        System.out.print(sb);
    }
    static int selfNum(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}