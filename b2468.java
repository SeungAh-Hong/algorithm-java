import java.util.*;
import java.io.*;

public class b2468 {
    static int N, cnt, max;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        int maxWater = 0;
        for(int i=1;i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > maxWater) {
                    maxWater = map[i][j];
                }
            }
        }

        max = 0;
        for(int water=0;water<=maxWater;water++) {
            check = new boolean[N+1][N+1];
            cnt = 0;
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    if(!check[i][j] && map[i][j] > water) {
                        DFS(i, j, water);
                        cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    static void DFS(int x, int y, int water) {
        check[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(check[nx][ny] || nx<0 || ny<0 || nx>N || ny>N) continue;
            if(map[nx][ny] > water) {
                DFS(nx, ny, water);
            }
        }
    }
}
