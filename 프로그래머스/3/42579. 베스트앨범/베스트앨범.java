import java.util.*;
import java.io.*;

/*
현재 문제의 목표는 베스트 엘범에 들어갈 노래의 고유 번호를 리턴하는 것
- 베스트 엘범 선정 기준
- 장르 별 재생 총합이 큰 장르
- 장르 내 재생 수 큰 노래
- 재생 수 같으면 고유번호 오름차순

해시맵 하나로 키값으로 장르를 가지고 총합을 저장하게 하고
다른 해시맵 하나를 더 만들어 키: 장르/ 값: 인덱스와 재생 수 (재생 수 기준 오름차순 정렬) 를 저장

이후 조건을 걸어 2개 이하로만 걸러서 리턴하도록 추출

 */

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genresTotalCount=new HashMap<>();
        HashMap<String, ArrayList<int[]>> songsIdxPlays=new HashMap<>();

        for(int i=0; i<genres.length; i++){
            genresTotalCount.put(genres[i], genresTotalCount.getOrDefault(genres[i],0) + plays[i]);

            songsIdxPlays.putIfAbsent(genres[i], new ArrayList<>());
            songsIdxPlays.get(genres[i]).add(new int[]{i, plays[i]});
        }
//        System.out.println(genresTotalCount);

        ArrayList<String> genList=new ArrayList<>();
        for(String gen:genresTotalCount.keySet()){
            genList.add(gen);
        }
        genList.sort((o1,o2) -> Integer.compare(genresTotalCount.get(o2),genresTotalCount.get(o1)));
//        System.out.println(genList.toString());

        ArrayList<Integer> ans=new ArrayList<>();

        for(String genre : genList) {
            List<int[]> songs =songsIdxPlays.get(genre);
            songs.sort((o1, o2) -> Integer.compare(o2[1], o1[1]));
//            for(int[] i:songs) System.out.print(Arrays.toString(i)+" ");
//            System.out.println();
            ans.add(songs.get(0)[0]);
            if(songs.size() > 1) {
                ans.add(songs.get(1)[0]);
            }
        }

        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}