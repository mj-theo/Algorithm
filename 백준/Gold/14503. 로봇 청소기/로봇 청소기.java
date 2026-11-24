import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 로봇 청소기 https://acmicpc.net/problem/14503
    static int[] dx;
    static int[] dy;
    static int[][] rooms;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        // 방향 : 북,동,남,서 (0,1,2,3)
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        rooms = new int[n][m];

        st = new StringTokenizer(br.readLine());

        // 현재 위치와 시작 방향
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            if(rooms[x][y]==0){ // 1번 : 자신의 자리청소하기
                rooms[x][y]=2; // 청소 완료
                answer++;
            }

            if(isExist(x,y)){
                for(int i = 0;i<4;i++){
                    dir = (dir+3)%4;
                    if(rooms[x+dx[dir]][y+dy[dir]]==0){
                        x+=dx[dir];
                        y+=dy[dir];
                        break;
                    }
                }
            }else{
                if(rooms[x-dx[dir]][y-dy[dir]]==1){
                    break;
                }else{
                    x -= dx[dir];
                    y -= dy[dir];
                }
            }
        }
        System.out.print(answer);
    }

    static boolean isExist(int x, int y){ // 청소되지 않은 칸이 존재하는지 확인하는 메서드
        for(int i = 0;i<4;i++){
            if(rooms[x+dx[i]][y+dy[i]]==0){
                return true;
            }
        }
        return false;
    }
}
