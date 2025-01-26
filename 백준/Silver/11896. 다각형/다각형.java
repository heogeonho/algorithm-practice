import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        long a = sc.nextLong();
        long b = sc.nextLong();

        long stA = (a % 2 == 0) ? a : a + 1; // a 이상의 첫 번째 짝수
        if (stA == 2) stA = 4;
        long edB = (b % 2 == 0) ? b : b - 1; // b 이하의 마지막 짝수

        if (stA > edB) {
            System.out.println(0); // 범위 내 짝수가 없을 경우
        } else {
            long count = ((edB - stA) / 2) + 1;
            long sum = count * (stA + edB) / 2;
            System.out.println(sum);
        }
        sc.close();
    }
}