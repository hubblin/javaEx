import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//자바에서 어떻게 파일로 관리를 할까

public class Code5 {
    
    static String[] name = new String[1000];
    static String[] number = new String[1000];
    static int m = 0;
    public static void main(final String[] args) {



        // Scanner inFile = new Scanner(Code4.class.getResourceAsStream("input.txt"));
        try {
            final Scanner inFile = new Scanner(new File("D:\\java remind\\code16\\javaEx\\input.txt"));
            
            while(inFile.hasNext()){
                name[m] = inFile.next();
                number[m] = inFile.next();
                m++;
            }
            
            
            inFile.close();
        } catch (final FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("No File");
            return;
        }
        System.out.println("11");
        bubleSort();
        System.out.println("22");
        for(int i=0; i<m;i++){
            System.out.println(name[i] + ":" + number[i]);
        }
    
    }
    public static void bubleSort(){
        for(int i =m-1 ; i>0 ; i--){
            for(int j =0; j<i; j++){
                if(name[j].compareTo(name[j+1]) < 0){ // >라면  양수를 반환 < 라면 음수를 반환 =면 0을 반환
                    String tmp = name[j];
                    name[j] = name[j+1];
                    name[j+1] = tmp;

                    tmp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = number[j];
                }
            }
        }
    }
}
