import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();  // 공백 제거
        long S = Long.parseLong(input);

        long n = 1;
        while ((n * (n + 1)) / 2 <= S) {
            n++;
        }
        n--;

        System.out.println(n);
    }
}