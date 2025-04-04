import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        int cnt = 1;
        char temp = input.charAt(0);
        for (int i = 1; i < len; i++) {
            char cur = input.charAt(i);
            if (temp != cur) {
                cnt++;
                temp = cur;
            }
        }
        System.out.println(cnt/2);
    }
}