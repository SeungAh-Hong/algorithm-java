import java.util.*;
import java.io.*;

public class b2331 {
    // static int last_num;
    // static int new_num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        ArrayList<Integer> D = new ArrayList<Integer>();
        D.add(A);

        int last_num = A;
        int new_num;
        while(true) {
            new_num = 0;
            while(last_num != 0) {
                new_num += Math.pow((last_num%10), P);
                last_num /= 10;
            }
            if(D.contains(new_num)){
                break;
            }
            else {
                D.add(new_num);
            }
            last_num = new_num;
        }

        int idx = D.indexOf(new_num);
        System.out.println(idx);
        // for(int i=idx; i<D.size(); i++){
        //     D.remove(i);
        // }
        // System.out.println(D.size());
    }
}
