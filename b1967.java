import java.util.*;
import java.io.*;

public class b1967 {
    static class node{
        int child;
        int weight;
        node(int child, int weight){
            this.child = child;
            this.weight = weight;
        }
    }

    static int N;
    static int p, c, w;
    static int ans, sum, fn;
    static ArrayList<node>[] nodes;
    static boolean[] check;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N+1];
        check = new boolean[N+1];
        fn = 0; ans =0; sum = 0;

        for(int i=0;i<N+1;i++) {
            nodes[i] = new ArrayList<node>();
        }
        

        for(int i=0; i<N-1;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            nodes[p].add(new node(c, w));
            nodes[c].add(new node(p, w));
        }

        check[1] = true;
        DFS(1, 0);

        check = new boolean[N+1];
        ans = 0;
        check[fn] = true;
        DFS(fn, 0);

        System.out.println(ans);
    }

    private static void DFS(int start, int sum) {
        
        if(ans < sum) { // 가장 먼 노드까지의 거리 구함
            ans = sum;
            fn = start;
        }

        for(node nxt : nodes[start]) {
            if(!check[nxt.child]) {
                check[nxt.child] = true;
                DFS(nxt.child, sum+nxt.weight);
            }
        }
    }
}
