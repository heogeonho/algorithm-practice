import java.util.*;
import java.io.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[] stu1=new int[] {1,2,3,4,5};           //5개 반복
        int[] stu2=new int[] {2,1,2,3,2,4,2,5};     //8개 반복
        int[] stu3=new int[] {3,3,1,1,2,2,4,4,5,5}; //10개 반복
        //answers 현재 인덱스를 활용 & stu.length로 나눈 나머지 인덱스 활용
        
        int[][] stuList=new int[][] {stu1, stu2, stu3};
        
        ArrayList<Integer> res=new ArrayList<>();
        int cnt, stu=1;
        int max=Integer.MIN_VALUE;
        for(int[] eachStu: stuList) {
            cnt=0;
            for(int i=0; i<answers.length; i++) {
                if(answers[i]==eachStu[i%eachStu.length]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
            if(cnt>max){
                max=cnt;
                res.clear();
                res.add(stu);
            } else if(cnt==max) res.add(stu);
            else {};
            stu++;
        }
        
        System.out.println(res.toString());
        // int[] answer = {};
        return res;
    }
}