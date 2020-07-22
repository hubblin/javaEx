import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//자바에서 어떻게 파일로 관리를 할까

public class Code4 {
    public static void main(final String[] args) {

        String[] name = new String[1000];
        String[] number = new String[1000];
        int m = 0;

        // Scanner inFile = new Scanner(Code4.class.getResourceAsStream("input.txt"));
        try {
            Scanner inFile = new Scanner(new File("D:\\java remind\\code16\\javaEx\\input.txt"));
            
            while(inFile.hasNext()){
                name[m] = inFile.next();
                number[m] = inFile.next();
                m++;
            }
            
            
            inFile.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("No File");
            return;
        }
        for(int i=0; i<m;i++){
            System.out.println(name[i] + ":" + number[i]);
        }
    }

}
