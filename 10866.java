import java.io.*;
import java.util.*;

class Main { // 덱(Dequeue)
    public static int[] deque;
    public static int first;
    public static int last;
    public static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        size = 0;
        first = 10000;
        last = 10000;
        
        int N = Integer.parseInt(br.readLine());
        deque = new int[20001];
        
        for(int i=0;i<N;i++){
            String cmd = br.readLine();
            if(cmd.contains("push_front")) {
                StringTokenizer st = new StringTokenizer(cmd, " ");
                st.nextToken();
                push_front(Integer.parseInt(st.nextToken()));
            }
            else if(cmd.contains("push_back")) {
                StringTokenizer st = new StringTokenizer(cmd, " ");
                st.nextToken();
                push_back(Integer.parseInt(st.nextToken()));
            }
            else if(cmd.contains("pop_front")) {
                sb.append(pop_front()).append('\n');
            }
            else if(cmd.contains("pop_back")) {
                sb.append(pop_back()).append('\n');
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

    static void push_front(int item) { // 정수 X를 덱의 앞에 넣는다.
        deque[first] = item;
        first--;
        size++;
    }
    static void push_back(int item) { // 정수 X를 덱의 뒤에 넣는다.
        last++;
        size++;
        deque[last] = item;
    }

    static int pop_front() { // 덱에서 가장 앞에 있는 정수를 빼고, 그 수를 출력
        if(size == 0){ // 들어있는 정수가 없는 경우에는 -1을 출력
            return -1;
        }
        else {
            int res = deque[first+1];
            first++;
            size--;
            return res;
        }
    }
    static int pop_back() { // 덱에서 가장 뒤에 있는 정수를 빼고, 그 수를 출력
        if(size == 0){ // 들어있는 정수가 없는 경우에는 -1을 출력
            return -1;
        }
        else {
            int res = deque[last];
            last--;
            size--;
            return res;
        }
    }

    static int size() { // 덱에 들어있는 정수의 개수를 출력
        return size;
    }
    static int empty() { // 덱가 비어있으면 1, 아니면 0을 출력
        if(size == 0){
            return 1;
        }else {
            return 0;
        }
    }
    static int front() { // 덱의 가장 앞에 있는 정수를 출력
        if (size == 0){ // 들어있는 정수가 없는 경우에는 -1을 출력
            return -1;
        }
        else {
            int res = deque[first+1];
            return res;
        }
    }
    static int back() { // 덱의 가장 뒤에 있는 정수를 출력
        if (size == 0){ // 들어있는 정수가 없는 경우에는 -1을 출력
            return -1;
        }
        else {
            int res = deque[last];
            return res;
        }
    }
}