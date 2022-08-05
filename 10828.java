import java.io.*;
import java.util.*;

class Main { // 스택 -> 선입후출
    public static int[] stack;
    public static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        stack = new int[N];
        
        for(int i=0;i<N;i++){
            String cmd = br.readLine();
            if(cmd.contains("push")) {
                StringTokenizer st = new StringTokenizer(cmd, " ");
                st.nextToken();
                push(Integer.parseInt(st.nextToken()));
            }
            else if(cmd.contains("pop")) {
                sb.append(pop()).append('\n');
            }
            else if(cmd.contains("size")) {
                sb.append(size()).append('\n');
            }
            else if(cmd.contains("empty")) {
                sb.append(empty()).append('\n');
            }
            else if(cmd.contains("top")) {
                sb.append(top()).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void push(int item) { //정수 X를 스택에 넣음
        stack[size] = item;
        size++;
    }

    static int pop() { //스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력
        if(size == 0){ // 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력
            return -1;
        }
        else {
            int res = stack[size-1];
            stack[size-1] = 0;
            size--;
            return res;
        }
    }
    static int size() { //스택에 들어있는 정수의 개수를 출력
        return size;
    }
    static int empty() { //스택이 비어있으면 1, 아니면 0을 출력
        if(size == 0){
            return 1;
        }else {
            return 0;
        }
    }
    static int top() { //스택의 가장 위에 있는 정수를 출력
        if (size == 0){ // 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력
            return -1;
        }
        else {
            int res = stack[size-1];
            return res;
        }

    }
}