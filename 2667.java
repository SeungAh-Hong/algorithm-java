import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
static int N;
static int[][] rec; // N * N 정사각형
static int count;
static int[] dr = {-1, 1, 0, 0}; // 좌우 확인
static int[] dc = {0, 0, -1, 1}; // 상하 확인
static ArrayList<Integer> answer; // 답 담을 배열
static boolean[][] check; // 확인했는지 여부

    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec = new int[N][N]; 
        answer = new ArrayList<>(); 
        check = new boolean[N][N];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                rec[i][j] = str.charAt(j)-'0';
            }
        }
        // 1이 있을 때, 상하좌우 확인해서 1이 있으면 같은 단지로 취급 후 cnt 더해서 answer 배열에 넣음
        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(rec[i][j]==1 && check[i][j] == false) {
                    count=1;
                    Search(i, j);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int x : answer) {
            System.out.println(x);
        }
    }

    public static int Search(int x, int y) {
        check[x][y] = true;
        for(int i=0;i<4;i++) {
            // 상하좌우 1 있는지 확인
            int nx = x + dr[i]; // 좌우
            int ny = y + dc[i]; // 상하

            if(nx>=0 && ny>=0 && nx<N && ny<N) {
                if(rec[nx][ny]==1 && check[nx][ny]==false) {
                    Search(nx, ny);
                    count++;
                }
            }
        }
        return count;
    }
}