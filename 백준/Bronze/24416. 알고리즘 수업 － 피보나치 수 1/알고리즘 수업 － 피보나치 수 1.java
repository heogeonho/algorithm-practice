import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cntFib = 0;
    static int cntFibonacci = 1;
    static int[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());

        fib(a);
        fibonacci(a);

        System.out.println(cntFib + " " + cntFibonacci);
    }


    public static int fib(int n) {
        if (n == 1 || n == 2) {
            cntFib++;
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    public static int fibonacci(int n) {
        f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i < n; i++) {
            cntFibonacci++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}