/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] answer = new int[100][100];

        for(int i=0;i<4;i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // 해당하는 면적에 1 넣기 (자동 중복 제거)
            for(int j=x1; j<x2; j++) {
                for(int k=y1; k<y2; k++) {
                    answer[j][k] = 1;
                }
            }
        }
        // 면적 구하기
        int sum = 0;
        for(int i=0;i<100;i++) {
            for(int j=0;j<100;j++) {
                sum += answer[i][j];
            }
        }
        
        System.out.println(sum);

	}
}