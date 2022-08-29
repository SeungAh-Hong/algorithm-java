import java.util.*;
import java.io.*;

public class b9466 {
    static int n;
    static int[] input;
    static int count = 0;
    static boolean[] visited;
    static boolean[] done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        while(TC --> 0) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            input = new int[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];
            count = 0;

            // input 값 넣음
            for(int i=1;i<=n;i++){
                input[i] = Integer.parseInt(st.nextToken());
            }

            for(int idx=1; idx<=n; idx++) {
                if(done[idx]==false) {
                    DFS(idx);
                }
            }
            sb.append(n-count).append('\n');
        }
        System.out.println(sb);
    }

    public static void DFS(int idx) {
        if(visited[idx]) {
            return; // 이미 방문했으면 종료
        }

        visited[idx] = true;
        int next = input[idx];

        if(!visited[next]) {
            DFS(next); // next 학생 탐색 안했으면 탐색 시작
        }
        else {
            if(done[next] == false) {
                // next 학생의 사이클이 끝나지 않았으면
                count++;
                for(int i=next; i!=idx; i=input[i]) {
                    count++; // 사이클 내부의 학생 수 count
                }
            }
        }
        
        // 모든 작업 종료시 해당 idx 사이클 종료된 것임
        done[idx] = true;
    }

}
