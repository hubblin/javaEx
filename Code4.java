import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//자바에서 어떻게 파일로 관리를 할까

public class Code4 {
    public static void main(final String[] args) {

        // Scanner inFile = new Scanner(Code4.class.getResourceAsStream("input.txt"));
        Scanner inFile;
        try {
            inFile = new Scanner(new File("D:\\java remind\\code16\\javaEx\\input.txt"));
            String name = inFile.next();


            inFile.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("No File");
            return;
        }
    
    }

}
