import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int sum = 0;
        String[] inputSplitMinus = input.split("-");
        for (int i = 0; i < inputSplitMinus.length; i++) {

            String[] numbersToPlus = inputSplitMinus[i].split("\\+");
            int temp = 0;
            for (String strNum : numbersToPlus) {
                temp += Integer.parseInt(strNum);
            }

            if (i == 0) {
                sum += temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
