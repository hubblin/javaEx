import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Code7 {
    static String[] words = new String[100000];
    static int[] count = new int[100000];
    static int n = 0;

    public static void main(final String[] args) {

        final Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.println("$ ");
            final String command = kb.next();
            if (command.equals("read")) {
                final String fileName = kb.nextLine();
                makeIndex(fileName);
                for (int i = 0; i < n; i++) {
                    System.out.println(words[i] + " : " + count[i]);
                }
            } else if (command.equals("find")) {
                String str = kb.next();
                int index = findWord(str);
                if (index != -1) {
                    System.out.println("The word " + words[index] + " appears " + count[index] + " times.");
                } else {
                    System.out.println("The word " + str + "does not appear.");
                }
            } else if (command.equals("saves")) {
                String fileName = kb.next();
                saveAs(fileName);

            } else if (command.equals("exit"))
                break;
        }

        kb.close();
    }

    static void saveAs(String fileName) {
        PrintWriter out;
        try {
            String newfileName = fileName.replace(" ", "");
            String tempfileName = "D:\\java remind\\code16\\javaEx\\" + newfileName;
            out = new PrintWriter(new FileWriter(tempfileName));
        
            for(int i =0; i < n; i++){
                out.println(words[i] + " " + count[i]);
            }
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Save failed");
            return;
        }
        
    }

    static void makeIndex(final String fileName) {
        try {
            String newfileName = fileName.replace(" ", "");
            String tempfileName = "D:\\java remind\\code16\\javaEx\\" + newfileName;
            System.out.println(tempfileName);
            final Scanner inFile = new Scanner(new File(tempfileName));

            while(inFile.hasNext()){
                String word = inFile.next();

                addWord(word);
                
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("no file");
            return;
        }
    }
    static void addWord(String str){
        int index = findWord(str); // 못찾으면 return -1 
        if(index != -1){ 
            count[index]++;
        }else {
            words[n] = str;
            count[n] = 1;
            n++;
        }
    }

    static int findWord(String str){
        for(int i=0; i<n; i++){
            if(words[i].equals(str)){
                return i;
            }
        }
        return -1;
    }
}