import java.io.*;
import java.util.*;

public class b1931 {
    static StringTokenizer st;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2];

        for(int i=0;i<N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if(o1[1] == o2[1]) { // 종료시간 같은 경우 시작시간 빠른 순 정렬
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1]; // 종료시간 빠른 순
            }

        });

        int cnt = 0;
        int prev = 0;

        for(int i=0;i<N;i++){
            if(prev <= meeting[i][0]) {
                prev = meeting[i][1];
                cnt++;
            }
        }
        
        System.out.println(cnt);

    }
}
