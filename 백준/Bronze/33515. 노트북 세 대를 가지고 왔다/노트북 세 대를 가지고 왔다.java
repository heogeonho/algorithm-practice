import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int teamMember1Time = Integer.parseInt(st.nextToken());
        int teamMember2Time = Integer.parseInt(st.nextToken());

        int minTeamMemberTime = Math.min(teamMember1Time, teamMember2Time);
        System.out.println(minTeamMemberTime);
    }
}