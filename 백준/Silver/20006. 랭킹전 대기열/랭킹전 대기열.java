import java.io.*;
import java.util.*;

/*
 * 플레이어의 수 p
 * 방 한개의 정원 m -> 고정값으로 주어짐
 * 
 * 입장 신청
 * - 매칭 불가 (방의 기준값 -> 첫 유저의 레벨 +10 -10)
 *  - 새로운 방 생성 및 입장
 * - 매칭 가능
 *  - 입장 및 대기
 *  - 입장 가능 방 여러개일 경우 생성시간 빠른 순
 * - 정원 차면 게임 시작
 * 
 * 1차적으로 방을 생성
 * 2차로 유저 누적
 * 
 * 2차원 배열
 * {{ 유저 배열 닉네임 기준 정렬}, ...}
 * 방의 레벨 배열
 * 
 * 생성시간 빠른 순은 index 기준
 * 
 * 방 생성 수는 알 수 없으니 List 사용
 */



class Main {
    public static void main(String[] args) throws IOException {

        class User {
            int level;
            String name;

            public User(int level, String name) {
                this.level = level;
                this.name = name;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken()); // 플레이어의 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원

        // 게임 방 리스트 선언
        List<List<User>> roomList = new ArrayList<>();
        List<Integer> roomLevelList = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            User user = new User(l, n);
            boolean isIn = false;
            for(int j = 0; j < roomLevelList.size(); j++) {
                if(roomLevelList.get(j) <= l+10 && roomLevelList.get(j) >= l-10 && roomList.get(j).size() < m) {
                    roomList.get(j).add(user);
                    isIn = true;
                    break;
                }
            }
            if(!isIn) {
                roomLevelList.add(user.level);
                List<User> newRoom = new ArrayList<>();
                newRoom.add(user);
                roomList.add(newRoom);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(List<User> lu : roomList) {
            if(lu.size()==m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }
            lu.sort((u1, u2) -> u1.name.compareTo(u2.name));
            for(User u: lu) {
                sb.append(u.level).append(" ").append(u.name).append("\n");
            }
        }

        System.out.println(sb);

        
        
    }
}