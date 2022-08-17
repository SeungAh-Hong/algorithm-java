import java.util.*;
import java.io.*;

class Main {
    static boolean[] check;
    static int[][] graph;
    static int node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<T;i++) {
            node = Integer.parseInt(br.readLine());
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            graph = new int[node+1][node+1];
            check = new boolean[node+1];
            for(int j=1; j<=node; j++) {
                int a = j;
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = graph[b][a] = 1;
            }
            int answer = 0;
            for(int idx=1; idx<=node; idx++) {
                if(check[idx] == false) {
                    DFS(idx);
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    public static void DFS(int idx) {
        if(check[idx]==true) {
            return;
        }
        else {
            check[idx]=true;
            for(int i=1;i<=node;i++) {
                if(graph[idx][i] == 1) {
                    DFS(i);
                }
            }
        }
    }
}
