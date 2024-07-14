import java.io.*;
import java.util.*;

public class Main {
    static int fibo(int n){
        if(n==0){
            return 0;
        } else if(n==1 || n==2){
            return 1;
        }
        return fibo(n-1)+fibo(n-2);
    }

    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fibo(n));
    }
}
