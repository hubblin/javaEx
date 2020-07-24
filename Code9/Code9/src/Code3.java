package Code9.Code9.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
c에서는 보통변수와 참조변수(포인터)가 있다
java에서는 보통변수만 있다.

c에서는 보통 변수로 struct person a;처럼 보통변수로 사용가능하다
참조변수로는 사용자 지정 타입을 *(포인터)를 사용하여 사용이 가능한데a= malloc(sizeof()); a->name, a->number 처럼 따라가서 쓰게된다.

미리 지정된 변수(프리미티브 타입 변수)는 무조건 보통변수
사용자 정의 타입은 무조건 참조변수 타입만을 지원한다.
*/

public class Code3 {
    static Persion1[] members;
    static int n = 0;

    public static void main(String[] args) {
        members = new Persion1 [100];
        try {
            Scanner in = new Scanner(new File("D:\\java remind\\code16\\javaEx\\input.txt"));
            while(in.hasNext()){
                String nm = in.next();
                String nb = in.next();
                
                members[n] = new Persion1();
                members[n].name = nm;
                members[n].number = nb;
                n++;
            }
            
            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("no data file");
            System.exit(1);
        }

        bubbleSort();

        for(int i =0; i < n ; i++){
            System.out.println(members[i].name + " " + members[i].number);
        }
        
    }

    private static void bubbleSort() {
        for(int i = n-1; i > 0 ; i--){
            for(int j =0; j <i; j++){
                if(members[j].name.compareTo(members[j+1].name)>0){ //compare names of j th and (j+1)th person
                    Persion1 tmp = members[j];
                    members[j] = members[j+1];
                    members[j+1] = tmp;
                }
            }
        }
    }
}  