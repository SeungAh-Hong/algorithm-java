import java.io.*;
import java.util.*;

public class b2108 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        double sum = 0;

        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
            sum+= num;
        }

        Arrays.sort(nums);

        // 최빈값 구하기
        int count = 0;
        int max = -1; // max count
        int mode = nums[0];
        boolean check = false;
        for(int i=0; i<N-1; i++) {
            if(nums[i] == nums[i+1]) {
                count++;
            } else {
                count = 0;
            }
            if(max < count) {
                max = count;
                mode = nums[i];
                check = true;
            }
            else if (max == count && check == true) { // 최빈값 여러 개면 두 번째로 작은 값 출력
                mode = nums[i];
                check = false;
            }

        }
        

        // 산술평균
        System.out.println(Math.round(sum/N));

        // 중앙값
        System.out.println(nums[(N-1)/2]);

        // 최빈값
        System.out.println(mode);

        // 범위
        System.out.println(nums[N-1] - nums[0]);
    }
    
}
