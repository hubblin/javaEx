package Code9.Code9.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code2 {
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
        }
        for(int i =0; i < n ; i++){
            System.out.println(members[i].name + " " + members[i].number);
        }
    }
}  