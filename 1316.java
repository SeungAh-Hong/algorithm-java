import java.io.*;
import java.util.*;

class Main {
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[26];
        boolean[] answer = new boolean[N];
        Arrays.fill(answer, true);
    
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            Arrays.fill(check, false); // 문자열 하나 확인하고나면 다시 false로 초기화
            for (int j=0;j<str.length();j++) {
                char alph = str.charAt(j);
                int check_alph = alph - 'a';
                // 이전에 이미 나왔던 알파벳인지 확인 && 바로 전 알파벳이랑 다른 알파벳인지 확인
                if (j>=1 && check[check_alph] == true && str.charAt(j-1) != str.charAt(j)) {
                    answer[i] = false;
                    break;
                }
                check[check_alph] = true;
            }
        }
        int count = 0;
        for(int n=0;n<N;n++){
            if (answer[n] == true) {
                count++;
            }
        }
        System.out.println(count);
    }
}