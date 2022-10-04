import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class b9205 {
    static int tc, n, distance;
    static StringTokenizer st;
    static int[][] graph;
    static boolean[] checked;
    static Point[] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());
        

        while(tc --> 0) {
            n = Integer.parseInt(br.readLine());
            points = new Point[n+2];
            graph = new int[n+2][n+2];

            for(int i=0;i<n+2;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int px = Integer.parseInt(st.nextToken());
                int py = Integer.parseInt(st.nextToken());
                points[i] = new Point(px, py);
            }

            // 연결 가능한 점끼리 연결
            for(int i=0; i<n+1; i++) { // 반복문 i, j 범위 설정
                Point p1 = points[i];
                for(int j=i+1; j<n+2; j++) {    
                    Point p2 = points[j];              
                    distance = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
                    if(distance <= 1000) {
                        graph[i][j] = graph[j][i] = 1;
                    }
                }
            }
            
            
            sb.append(BFS(graph, n)).append('\n');
        }

        System.out.println(sb.toString());
    }

    static String BFS(int[][] graph, int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        checked = new boolean[n+2];
        String ans = "";
        checked[0] = true;
        queue.add(0);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int i=1; i<n+2; i++) {
                if(!checked[i] && graph[now][i] == 1) {
                    if(i == n+1) {
                        return "happy";
                    }
                    checked[i] = true;
                    queue.add(i);
                }
            }
        }

        return "sad";
    }
    
}
