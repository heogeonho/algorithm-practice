import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.management.StringValueExp;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean inTag = false;

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);

            if (inTag) {
                res.append(tmp);
                if(tmp == '>') {
                    inTag = false;
                }
                continue;
            }

            if (tmp == '<') {
                res.append(word.reverse());
                word.setLength(0);

                inTag = true;
                res.append(tmp);
            } else if (tmp == ' ') {
                res.append(word.reverse());
                word.setLength(0);

                res.append(' ');
            } else {
                word.append(tmp);
            }
        }

        res.append(word.reverse());
        System.out.println(res);
    }
}