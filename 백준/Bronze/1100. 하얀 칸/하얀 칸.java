import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int row = 8;
        int col = 8;
        int sum = 0;

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                if(i%2==0&&j%2==0&&line.charAt(j)=='F') {
                    sum++;
                } else if (i%2==1&&j%2==1&&line.charAt(j)=='F') {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
