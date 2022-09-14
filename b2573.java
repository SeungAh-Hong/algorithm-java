import java.util.*;
import java.io.*;

public class b2573 {
    static int r, c;
    static int[][] map;
    static boolean[][] visited;
    static int[][] melt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // N
        c = Integer.parseInt(st.nextToken());// M
        map = new int[r][c];
        visited = new boolean[r][c];
        melt = new int[r][c];

        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
 
        while(true) {
            // dfs 로 빙산 덩어리 세기
            int count = 0;
            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    if(!visited[i][j] && map[i][j] != 0) {
                        DFS(i, j);
                        count++;
                    }
                }
            }
 
            if(count == 0) { // 덩어리 없음 (다 녹음)
                System.out.println(0);
                break;
            } else if(count >= 2) { // 덩어리 2개 넘었을 때 년수 출력
                System.out.println(year);
                break;
            }
            Melting();
            year++;
        }
    }
    
    static void DFS(int x, int y) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if(0 <= nx && nx < r && 0 <= ny && ny < c) {
                // 1년 후에 녹는 빙산의 양 구하기
                if(map[nx][ny] == 0) // 동서남북 네 방향 0 개수
                    melt[x][y]++;
 
                // dfs 재귀
                if(!visited[nx][ny] && map[nx][ny] != 0)
                    DFS(nx, ny);                    
            }
        }

    }
    static void Melting() {
        /**
        * 1. 빙산 녹이기
        * 2. 만약 녹인 높이가 음수가 되면 0으로 바꿔주기
        * 3. visited 초기화
        * 4. melt 초기화
        */               
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                map[i][j] -= melt[i][j];
 
                if(map[i][j] < 0)
                    map[i][j] = 0;
                                    
                visited[i][j]= true;
                melt[i][j] = 0;
            }
        }
    }
    }
}
