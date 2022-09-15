import java.util.*;
import java.io.*;

class Student {
    String name;
    int kor;
    int eng;
    int math;

    Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

}

public class b10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, kor, eng, math);
        }
        Comparator<Student> myComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.kor < o2.kor) {
                    return 1;
                }
                else if (o1.kor == o2.kor) {
                    if(o1.eng > o2.eng) {
                        return 1;
                    }
                    else if(o1.eng == o2.eng) {
                        if(o1.math < o2.math) {
                            return 1;
                        }
                        else if(o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                    }
                }
                return -1;
            }
        };

        Arrays.sort(students, myComparator);

        for(int i=0;i<N;i++){
            sb.append(students[i].name).append('\n');
        }
        
        System.out.println(sb);
    }
    
}

