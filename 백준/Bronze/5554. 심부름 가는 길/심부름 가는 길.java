import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalTime = 0;

        for (int i = 0; i < 4; i++) {
            totalTime += Integer.parseInt(br.readLine());
        }

        System.out.println(totalTime / 60);
        System.out.println(totalTime % 60);
    }
}
