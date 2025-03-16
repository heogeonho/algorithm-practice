import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = -1;
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                num = Integer.parseInt(str) + 1;
            } else if (num != -1) {
                num++;
            }
        }

        System.out.println(fizzBuzz(num));
    }

    static String fizzBuzz(int num) {
        if (num % 3 == 0 && num % 5 == 0) return "FizzBuzz";
        if (num % 3 == 0) return "Fizz";
        if (num % 5 == 0) return "Buzz";
        return String.valueOf(num);
    }
}