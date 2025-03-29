import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int count = 0;

        while (X > 0) {
            count += X & 1;
            X >>= 1;
        }

        System.out.println(count);
    }
}