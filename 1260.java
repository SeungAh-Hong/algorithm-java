import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] graph;
    static boolean[] check;

    static int node, line, start;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;
        st = new StringTokenizer(str, " ");

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new int[node+1][node+1];
        check = new boolean[node+1];
        
        for(int i=0; i<line; i++) { // 간선 연결상태 저장
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        // DFS
        DFS(start);
        sb.append('\n');
        check = new boolean[node+1];
        BFS(start);
        System.out.println(sb);
    }

    public static void DFS(int start) { // 재귀
        check[start] = true;
        sb.append(start + " ");

        for(int i=1; i<=node; i++) {
            if(graph[start][i] == 1 && !check[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start) { // 큐
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복함
            start = queue.poll();
            sb.append(start + " ");

            for(int i=1; i<=node; i++) {
                if(graph[start][i] == 1 && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}