import java.util.*;
import java.io.*;

public class b7576 {
    static int[][] map;
    static int N, M;
    static StringTokenizer st;
    static Queue<int[]> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        queue = new LinkedList<int[]>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) { // 익은 토마토면 queue에 넣음
                    queue.add(new int[] {i, j});
                }
            }
        }

        System.out.println(BFS());


    }

    public static int BFS() {
        int answer = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) { // 범위 내
                    if (map[nx][ny] == 0) {
                        queue.add(new int[] {nx, ny});
                        map[nx][ny] = map[x][y] + 1;
                    }
                }
            }
        }

        for(int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    return -1;
                }
                else {
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }

        if (answer == 1) {
            return 0;
        }
        else {
            return answer-1;
        }
    }
}
