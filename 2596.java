import java.util.*;
import java.io.*;

class Main {
	public static final String A = "000000";
	public static final String B = "001111";
	public static final String C = "010011";
	public static final String D = "011100";
	public static final String E = "100110";
	public static final String F = "101001";
	public static final String G = "110101";
	public static final String H = "111010";

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];
        String str = br.readLine();
        int cnt = 0;
        for(int i=0;i<n; i++) {
            input[i] = str.substring(cnt, cnt+6);
            cnt+=6;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n; i++) {
            if(input[i].equals(A) || check(input[i], A)) {
                sb.append("A");
            }
            else if(input[i].equals(B) || check(input[i], B)) {
                sb.append("B");
            }
            else if(input[i].equals(C) || check(input[i], C)) {
                sb.append("C");
            }
            else if(input[i].equals(D) || check(input[i], D)) {
                sb.append("D");
            }
            else if(input[i].equals(E) || check(input[i], E)) {
                sb.append("E");
            }
            else if(input[i].equals(F) || check(input[i], F)) {
                sb.append("F");
            }
            else if(input[i].equals(G) || check(input[i], G)) {
                sb.append("G");
            }
            else if(input[i].equals(H) || check(input[i], H)) {
                sb.append("H");
            }
            else { // 문자 2개 이상 틀린 경우 해당 문자열 idx 반환
                sb = new StringBuffer();
                sb.append(i+1);
                break;
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean check(String input, String alph) {
        int cnt = 0;
        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) != alph.charAt(i)) {
                cnt++;
            }
        }
        if(cnt == 1) {
            return true;
        }
        return false;
    }
}