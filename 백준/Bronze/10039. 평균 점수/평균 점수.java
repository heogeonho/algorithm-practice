import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        for (int i = 0; i < 5; i++) {
            int input = sc.nextInt();
            if(input < 40) {
                total += 40;
            } else {
                total += input;
            }
        }
        System.out.println(total/5);
    }
}