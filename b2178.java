import java.util.*;
import java.io.*;

public class b2178 {
    static int[][] map;
    static int N, M;
    static boolean[][] check;
    static StringTokenizer st;
    static Queue<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new boolean[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        
        BFS(0, 0);
        System.out.println(map[N-1][M-1]);
    }

    public static void BFS(int a, int b) {
        queue = new LinkedList<int[]>();
        int[] ab = {a, b};
        queue.offer(ab);
        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if(check[nx][ny] == true || map[nx][ny] == 0) {
                    continue;
                }
                int[] next = {nx, ny};
                queue.add(next);
                map[nx][ny] = map[x][y]+1;
                check[nx][ny] = true;
            }
        }
        check[a][b] = true;
     }
}
