import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int sum = 0;
        boolean hasZero = false;
        List<Integer> digits = new ArrayList<>();

        for (char c : input.toCharArray()) {
            int digit = c - '0';
            if (digit == 0) hasZero = true;
            sum += digit;
            digits.add(digit);
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        digits.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int d : digits) {
            sb.append(d);
        }
        System.out.println(sb.toString());
    }
}
/*
 * 각 자리 수의 합이 3의 배수여야 함
 * 0이 포함 되어야 함
 */