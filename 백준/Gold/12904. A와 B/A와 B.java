import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        /*
        S->T 연산 Case
        1. 문자열의 뒤에 A를 추가한다.
        2. 문자열을 뒤집고 뒤에 B를 추가한다.

        T->S 역방향 연산 Case (아이디어 이유: 뒷 글자에 따라 연산이 픽스됨)
        1-1. 문자열 뒤 A 제거
        2-1. 문자열 뒤 B 제거 후 뒤집기
        */

        while(t.length()!=s.length()) {
            if(t.charAt(t.length()-1) == 'A') t.deleteCharAt(t.length()-1);
            else {
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }

        System.out.println(t.toString().equals(s.toString()) ? 1 : 0);
    }

}