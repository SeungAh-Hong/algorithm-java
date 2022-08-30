import java.util.*;
import java.io.*;

class tomato {
    int x;
    int y;
    int h;

    tomato(int h, int x, int y) { // 높이 가로 세로
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

public class b7569 {
    static int M,N,H;
    static int[][][] box;
    static boolean[][][] check;
    static int time = Integer.MIN_VALUE;
    static Queue<tomato> queue = new LinkedList<tomato>();
    static StringTokenizer st;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        H = Integer.parseInt(st.nextToken()); // 높이

        box = new int[H][N][M];
        check = new boolean[H][N][M];

        for(int h=0;h<H;h++){ // 높이
            for(int n=0;n<N;n++) { // 가로
                st = new StringTokenizer(br.readLine(), " ");
                for(int m=0;m<M;m++) { // 세로
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.add(new tomato(h, n, m));
                    }
                }
            }
        }

        System.out.println(BFS());        
    }

    private static int BFS() {
        while(!queue.isEmpty()) {
            tomato nt = queue.poll();
            int x = nt.x;
            int y = nt.y;
            int h = nt.h;
            
            for(int i=0;i<6;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nh = h + dh[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && nh >= 0 && nh < H) {
                    if(box[nh][nx][ny] == 0) {
                        box[nh][nx][ny] = box[h][x][y] + 1;
                        queue.offer(new tomato(nh,nx,ny));
                    }
                }
            }
        }

        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++) {
                for(int m=0;m<M;m++) {
                    if (box[h][n][m] == 0) {
                        return -1;
                    } else {
                        time = Math.max(time, box[h][n][m]);
                    }
                    
                }
            }
        }
        if(time == 1) {
            return 0;
        } else {
            return (time-1);
        }
    }

}
