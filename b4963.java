import java.io.*;
import java.util.*;

public class b4963 {
    static int W, H;
    static int map[][];
    static boolean[][] check;
    static int[] dr = {-1, 1, 0, 0, 1, -1, 1, -1};
    static int[] dc = {0, 0, -1, 1, 1, -1, -1, 1};
    static int count;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0) {
                break;
            }
            
            map = new int[H][W];
            check = new boolean[H][W];
            
            for(int i=0;i<H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0;
            
            for(int i=0;i<H; i++) {
                for(int j=0; j<W; j++) {
                    if(map[i][j] == 1 & check[i][j] == false) {
                        Search(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void Search(int x, int y) {
        check[x][y] = true;
        // 8방향 확인
        for(int i=0; i<8; i++) {
            int nx = x + dr[i];
            int ny = y + dc[i];

            if(nx>=0 && ny>=0 && nx<H && ny<W) {
                if(map[nx][ny]==1 && check[nx][ny]==false) {
                    Search(nx, ny);
                }
            }
        }
    }
}
