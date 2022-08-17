import java.util.*;
import java.io.*;

class Main {
    static int node, line;
    static boolean[] check = new boolean[1001];
    static int[][] graph = new int[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;
        st = new StringTokenizer(str, " ");
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        for (int i=0;i<line; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        int answer = 0;

        // DFS
        for(int i=1; i<=node; i++) {
            if(check[i] == false) {
                DFS(i);
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static void DFS(int idx) {
        if(check[idx] == true) return;
        else {
            check[idx] = true;
            for(int i=1; i<=node; i++) {
                if(graph[idx][i] == 1) {
                    DFS(i);
                }
            }
        }
    }
}