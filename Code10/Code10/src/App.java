package Code10.Code10.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {

    static Item[] items = new Item[10000];

    //static String[] words = new String[100000];
    //static int[] count = new int[100000];
    static int n = 0;

    public static void main(String[] args) throws Exception {
        final Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            final String command = kb.next();
            if (command.equals("read")) {
                final String fileName = kb.nextLine();
                makeIndex(fileName);
            } else if (command.equals("find")) {
                String str = kb.next();
                int index = findWord(str);
                if (index != -1) {
                    System.out.println("The word " + items[index].word + " appears " + items[index].count + " times.");
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
                out.println(items[i].word + " " + items[i].count);
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
            items[index].count++;
        }else {
            int i = n-1;
            while(i >= 0 && items[i].word.compareTo(str) >0){
                items[i+1] = items[i];
                i--;
            }
            items[i+1] = new Item();
            items[i+1].word = str;
            items[i+1].count = 1;
            n++;
        }
    }

    static int findWord(String str){
        for(int i=0; i<n; i++){
            if(items[i].word.equals(str)){
                return i;
            }
        }
        return -1;
    }
    
}
