import java.util.*;
import java.io.*;

public class b2146 {
    static int N, ret;
    static int num = 2;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] check;
    static Queue<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int a=0;a<N;a++){
            for(int b=0;b<N;b++) {
                if(map[a][b] == 1){
                    mapDivision(a, b); // 섬 구분
                }
            }
        }
        

        // for(int i=0;i<N;i++){
        //    for(int j=0;j<N;j++){
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        
        for(int a=0;a<N;a++){
            for(int b=0;b<N;b++) {
                if(map[a][b] > 0) {
                    check = new boolean[N][N]; // check 재초기화
                    ret = BFS(a, b);

                    if(ret == -1) continue;
                    if(min > ret) {
                        min = ret;
                    }
                }
            }
        }

        System.out.println(min);
    }

    private static void mapDivision(int a, int b) {
        queue = new LinkedList<int[]>();
        queue.offer(new int[] {a, b});
        check[a][b] = true;
        map[a][b] = num;

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            for(int p=0; p<4; p++) {
                int nx = x + dx[p];
                int ny = y + dy[p];
                if((nx>=0 && ny>=0 && nx<N && ny<N) && !check[nx][ny] && map[nx][ny] == 1) {
                    check[nx][ny] = true;
                    map[nx][ny] = num;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        num++;
    }

    private static int BFS(int a, int b) {
        queue = new LinkedList<int[]>();
        queue.offer(new int[] {a,b,0});
        int divNum = map[a][b]; // 현재 섬번호
        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            int cnt = xy[2];
            check[x][y] = true;

            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if((nx>=0 && ny>= 0 && nx<N && ny<N) && !check[nx][ny] && map[nx][ny] != divNum) {
                    check[nx][ny] = true;
                    if(map[nx][ny] == 0) // 바다
                    {
                        queue.offer(new int[] {nx, ny, cnt+1});
                    }
                    else {
                        return cnt;
                    }
                }
            }
        }
        return -1;
    }
}
