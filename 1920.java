/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] n_arr = new int[N];
		String nStr = br.readLine();
		StringTokenizer st;
		st = new StringTokenizer(nStr, " ");
		for(int i=0; i<N; i++) {
			n_arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(n_arr);
		
		int M = Integer.parseInt(br.readLine());
		String mStr = br.readLine();
		st = new StringTokenizer(mStr, " ");
		for(int i=0;i<M;i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(find(n_arr, key)).append('\n');
		}
		System.out.println(sb);
	}
	public static int find(int[] arr, int key) { // 이분 탐색
		int lo = 0;
		int hi = arr.length-1;
		int mid;
		
		while(lo <= hi) {
			mid = (lo+hi) / 2;
			
			if (key < arr[mid]) {
				hi = mid-1;
			}
			else if(key > arr[mid]) {
				lo = mid+1;
			}
			else {
				return 1;
			}
		}
		return 0;
	}
}