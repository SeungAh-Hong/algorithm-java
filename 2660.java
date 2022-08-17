import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int N;
    static int a, b;
    static int[][] map;
    static int max, min = 100;
    static int[] score;
    static List<Integer> result;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    map[i][j] = 50;
                }
            }
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a == -1) {
                break;
            }

            map[a][b] = 1;
            map[b][a] = 1;
        }

// 최단 거리 값 갱신
        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if (map[s][m] + map[m][e] < map[s][e]) {
                        map[s][e] = map[s][m] + map[m][e];
                    }
                }
            }
        }

        score = new int[N+1];
        for (int i = 1; i <= N; i++) {
            max = 0;
            for (int j = 1; j <= N; j++) {
                max = Math.max(max, map[i][j]);
            }
            score[i] = max;
            min = Math.min(min, max);
        }

        result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (score[i] == min) {
                result.add(i);
            }
        }

        sb.append(min).append(" ").append(result.size()).append("\n");
        for (int score : result) {
            sb.append(score).append(" ");
        }

        System.out.println(sb);
    }
}