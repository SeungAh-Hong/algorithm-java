import java.util.*;
import java.io.*;

public class b1697 {
    static int N, K;
    static int[] dist;
    static StringTokenizer st;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];

        System.out.println(BFS(N));


    }

    private static int BFS(int idx) {
        queue = new LinkedList<Integer>();
        queue.add(idx);
        dist[idx] = 1;
        int next = 0;
        while(!queue.isEmpty()) {
            next = queue.poll();
            if(next == K) {
                return dist[K];
            }
            if(next-1 >= 0 && dist[next-1] == 0) {
                dist[next-1] = dist[next]+1;
                queue.add(next-1);
            }
            if(next+1 <= 100000 && dist[next+1] == 0) {
                dist[next+1] = dist[next]+1;
                queue.add(next+1);
            }
            if(next*2 <= 100000 && dist[next*2] == 0) {
                dist[next*2] = dist[next]+1;
                queue.add(next*2);
            }
        }
        return -1;
    }
}
