import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" "); // 이런 방식으로 할 수 있더군요..!
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        System.out.println(factorial(n) / (factorial(k) * factorial(n - k)));
    }

    // 그냥 입력이 작아서 아래 함수로 처리했습니다.
    static int factorial(int num) {
        if (num == 0 || num == 1) return 1;
        return num * factorial(num - 1);
    }
}