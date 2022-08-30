import java.util.*;
import java.io.*;

public class b2606 {
    static int node, line, answer;
    static int[][] graph;
    static boolean[] check;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        graph = new int[node+1][node+1];
        check = new boolean[node+1];

        for(int i=1; i<=line; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        
        answer = 0;
        // System.out.println(BFS());
        System.out.println(DFS(1));


    }

    public static int BFS() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        check[1] = true;

        while(!queue.isEmpty()) {
            int idx = queue.poll();
            for(int i=1; i<=node; i++) {
                if(graph[idx][i] == 1 && !check[i]) {
                    answer++;
                    queue.add(i);
                    check[i] = true;
                }
            }
        }

        return answer;
    }

    public static int DFS(int idx) {
        check[idx] = true;
        for(int i=1; i<=node; i++) {
            if(graph[idx][i] == 1 && !check[i]){
                answer++;
                DFS(i);
            }
        }
        return answer;
    }
}
