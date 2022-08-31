import java.util.*;
import java.io.*;

public class b11725 {
    static int N;
    static ArrayList<ArrayList<Integer>> list;
    static int[] parents;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<ArrayList<Integer>>();
        parents = new int[N+1];
        check = new boolean[N+1];
        StringTokenizer st;

        for(int i=0;i<=N;i++){ // N+1개 만들어야 함
            list.add(new ArrayList<Integer>());
        }

        for(int i=1;i<N;i++){ // 간선 수만큼 (N-1)
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        findParents(1);

        for(int i=2; i<=N; i++) {
            System.out.println(parents[i]);
        }

    }

    // DFS
    private static void findParents(int idx) {
        if(check[idx]) {
            return;
        }
        check[idx] = true;
        for(int nxt : list.get(idx)) {
            if(!check[nxt]) {
                parents[nxt] = idx;
                findParents(nxt);
            }
        }
    }

    // BFS
    private static void bfs_findParents(int idx) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(idx);
        parents[idx] = 1;

        while(!queue.isEmpty()) {
            int parent = queue.poll();
            for(int nxt : list.get(parent)) {
                if(parents[nxt] == 0) {
                    parents[nxt] = idx;
                    queue.offer(nxt);
                }
            }
        }
    }
}
