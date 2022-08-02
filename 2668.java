import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    static boolean[] visited;
    static int[] box;
    static ArrayList<Integer> answer;
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        box = new int[N+1];
        answer = new ArrayList<>();

        visited = new boolean[N+1];
        for (int i=1;i<=N;i++){ // 배열에 값 채워넣음
            box[i] = Integer.parseInt(br.readLine());
        }
        // DFS 탐색
        for(int i=1; i<=N; i++){
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i=0; i<answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    public static void dfs(int start, int target) {
        if(visited[box[start]] == false) {
            visited[box[start]] = true;
            dfs(box[start], target);
            visited[box[start]] = false;
        }
        if(box[start] == target) {
            answer.add(target);
        }
    }
}