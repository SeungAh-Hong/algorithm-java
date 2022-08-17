/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	static boolean[] isClock = new boolean[10000];
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer st;
		st = new StringTokenizer(str, " ");
		int[] n_arr = new int[4];
		for(int i=0; i<4; i++) {
			n_arr[i] = Integer.parseInt(st.nextToken());
		}
		int input = clock(n_arr);
		getAllClock();
		
		int answer = 0;
		for(int i=1111;i<=input;i++) {
			if(isClock[i] == true) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	public static int clock(int[] arr) {
		int min = Integer.MAX_VALUE;
		min = Math.min(min, arr[0]*1000 + arr[1]*100 + arr[2]*10 + arr[3]);
		min = Math.min(min, arr[1]*1000 + arr[2]*100 + arr[3]*10 + arr[0]);
		min = Math.min(min, arr[2]*1000 + arr[3]*100 + arr[0]*10 + arr[1]);
		min = Math.min(min, arr[3]*1000 + arr[0]*100 + arr[1]*10 + arr[2]);
		
		return min;
	}
	public static void getAllClock(){
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                for (int c = 1; c < 10; c++) {
                    for (int d = 1; d < 10; d++) {
                    	int[] arr = {a, b, c, d};
                        int n = clock(arr);

                        if (!isClock[n]) {
                            isClock[n] = true;
                        }
                    }
                }
            }
        }
	}
}