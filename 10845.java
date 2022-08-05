import java.io.*;
import java.util.*;

class Main { // 큐 -> 선입선출
    public static int[] queue;
    public static int first;
    public static int last;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        first = 0;
        last = 0;
        
        int N = Integer.parseInt(br.readLine());
        queue = new int[N];
        
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
            else if(cmd.contains("front")) {
                sb.append(front()).append('\n');
            }
            else if(cmd.contains("back")) {
                sb.append(back()).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void push(int item) { // 정수 X를 큐에 넣는 연산
        queue[last] = item;
        last++;
    }

    static int pop() { // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력
        if(last-first == 0){ // 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
            return -1;
        }
        else {
            int res = queue[first];
            first++;
            return res;
        }
    }
    static int size() { // 큐에 들어있는 정수의 개수를 출력
        return last-first;
    }
    static int empty() { // 큐가 비어있으면 1, 아니면 0을 출력
        if(last-first == 0){
            return 1;
        }else {
            return 0;
        }
    }
    static int front() { // 큐의 가장 앞에 있는 정수를 출력
        if (last-first == 0){ // 들어있는 정수가 없는 경우에는 -1을 출력
            return -1;
        }
        else {
            int res = queue[first];
            return res;
        }
    }
    static int back() { // 큐의 가장 뒤에 있는 정수를 출력
        if (last-first == 0){ // 들어있는 정수가 없는 경우에는 -1을 출력
            return -1;
        }
        else {
            int res = queue[last-1];
            return res;
        }
    }
}