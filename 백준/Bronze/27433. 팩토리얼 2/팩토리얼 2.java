import java.util.*;
import java.io.*;

class Main {
    public static long factorial(long n) {
        if(n==0||n==1){
            return 1;
        }
        else {
            return n*factorial(n-1);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        System.out.println(factorial(n));
    }
}