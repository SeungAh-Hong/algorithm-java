import java.io.*;
import java.util.*;

class Main { // 이분탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] Ncard = new int[N];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i=0;i<N;i++){
            Ncard[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Ncard);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<M;i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(Ncard, key) - lowerBound(Ncard, key)).append(' ');
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key) {
        int lo = 0; 
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + ((hi-lo)/2);

            if(key <= arr[mid]) {
                hi = mid;
            }
            else { // key > arr[mid]
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + ((hi-lo)/2);

            if(key < arr[mid]) {
                hi = mid;
            }
            else { // key >= arr[mid]
                lo = mid + 1;
            }
        }
        return lo;
    }

}
