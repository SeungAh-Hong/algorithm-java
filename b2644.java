import java.util.*;
import java.io.*;

public class b2644 {
    static int node, line;
    static int[] input = new int[2];
    static int[][] graph;
    static int[] depth;
    static StringTokenizer st;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        input[0] = Integer.parseInt(st.nextToken());
        input[1] = Integer.parseInt(st.nextToken());

        line = Integer.parseInt(br.readLine());

        graph = new int[node+1][node+1];
        depth = new int[node+1];
        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        // BFS
        System.out.println(BFS(input[0], input[1]));
    }


    private static int BFS(int a, int b){
        queue = new LinkedList<Integer>();
        queue.offer(a);
        while(!queue.isEmpty()) {
            int idx = queue.poll();
            if(idx == b) {
                return depth[b];
            }
            for(int i=1; i<=node; i++) {
                if(depth[i] == 0 && graph[idx][i] == 1) {
                    depth[i] = depth[idx] + 1;
                    // System.out.println("idx: "+idx+", i: "+i+", depth:"+depth[i]);
                    queue.offer(i);
                }
            }
        }
        return -1;
    }
}