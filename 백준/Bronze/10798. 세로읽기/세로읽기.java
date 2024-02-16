import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] array = new String[5][15];
        for (int i = 0; i < 5; i++) {
            String word = br.readLine();
            int len = word.length();
            for (int j = 0; j < len; j++) {
                array[i][j] = Character.toString(word.charAt(j));
            }
        }
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if( array[j][i] != null ) {
                    System.out.print(array[j][i]);
                }
            }
        }
    }
}