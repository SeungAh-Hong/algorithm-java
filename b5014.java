import java.io.*;
import java.util.*;

public class b5014 {
    static int F, S, G, U, D;
    static int[] move;
    static int[] ud = new int[2]; // up down 받음
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // 건물 층수
        S = Integer.parseInt(st.nextToken()); // 현재 층 (시작층)
        G = Integer.parseInt(st.nextToken()); // 스타트링크 층 (목표층)
        ud[0] = Integer.parseInt(st.nextToken()); // 위로 U층
        ud[1] = -Integer.parseInt(st.nextToken()); // 아래로 D층
        
        move = new int[F+1];
        BFS(S);
    }

    static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[F+1];

        q.add(start);
        check[start] = true;
        move[start] = 0;

        while(!q.isEmpty()) {
            int idx = q.poll();
            if(idx == G) {
                System.out.println(move[idx]);
                return;
            }

            for(int i=0;i<2;i++){
                int next = idx + ud[i]; // up down 해가면서 탐색
                if(next>F || next<1) continue;
                if(!check[next]) {
                    check[next] = true;
                    q.add(next);
                    move[next] = move[idx]+1; // 이동 횟수
                }
            }
        }

        // 목적지 도착 못하면 (엘베로)
        System.out.println("use the stairs");
    }
}
