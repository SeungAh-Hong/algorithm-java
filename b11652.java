import java.util.*;
import java.io.*;

public class b11652 {
    static HashMap<Long, Integer> card;
    static long card_num;
    static long max_cnt = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        card = new HashMap<>();

        for(int i=0; i<N; i++) {
            long num = Long.parseLong(br.readLine());
            card.put(num, card.getOrDefault(num, 0)+1);
            if(card.get(num) > max_cnt) {
                max_cnt = card.get(num);
                card_num = num;
            }
            else if (card.get(num) == max_cnt) {
                card_num = Math.min(card_num, num); // 같은 개수 카드일 경우 카드 번호 작은걸 저장
            }
        }

        System.out.println(card_num);
    }
}
