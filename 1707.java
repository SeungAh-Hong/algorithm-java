import java.util.*;
import java.io.*;

class Main {
    static int node, line;
    static ArrayList<ArrayList<Integer>> graph; // 비연결 그래프 고려
    static final int RED = 1;
    static final int BLUE = -1;
    static int[] colors; // check 대신 colors에 색상 넣음
    static boolean check_bg; // 이분그래프 확인


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(TC --> 0) { // 테스트 케이스 개수만큼 반복
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            node = Integer.parseInt(st.nextToken());
            line = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            colors = new int[node+1];
            check_bg = true;

            for(int i=0;i<node+1; i++) { // graph, colors 초기화
                graph.add(new ArrayList<Integer>());
                colors[i] = 0;
            }
            while(line --> 0) { // 그래프 값 넣어줌
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for(int i=1; i<=node; i++) {
                if(check_bg == false) { // 이분그래프 아니면 탈출
                    break;
                }

                if(colors[i] == 0) { // 방문안한 노드 탐색
                    BFS(i, RED);
                }
            }

            System.out.println(check_bg ? "YES" : "NO");
        }



    }

    public static void BFS(int idx, int color) { // 큐
        Queue<Integer> queue = new LinkedList<>();
        colors[idx] = color;
        queue.add(idx);

        while (!queue.isEmpty() && check_bg == true) { // 반복
            idx = queue.poll();

            for(int other_node : graph.get(idx)) { // 모든 인접 정점 방문
                if(colors[other_node] == 0) {
                    queue.add(other_node);
                    colors[other_node] = colors[idx] * -1; // 모든 인접 정점에 현재 색깔이 아닌 다른 색깔 넣음
                }
                else if(colors[idx] + colors[other_node] != 0) { // 컬러가 정해졌는데 두 색 합쳐서 0이 아니면 -> 같은 색 (이분그래프 아님)
                    check_bg=false;
                    return;
                }
            }
        }
    }
}