import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Code8 {
    static String[] words = new String[100000];
    static int[] count = new int[100000];
    static int n = 0;
    /*
    문자열 동일성 검사 : boolean, equals(String) 
    문자열 사전식 순서 : int, compareTo(String) <-- 사전적 의미가 더 앞이면 양수 뒤면 음수 같으면 0
    문자열 길이 : int, length()
    특정 위치의 문자 : char, charAt(int)
    지정한 문자의 위치 검색 : int, indexOf(char)
    지정된 범위의 부분 문자열 : String, substring(int, int) 시작은 폐구간 끝은 개구간
    */
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

                String trimmed = trimming(word);
                if(trimmed != null){
                    String t = trimmed.toLowerCase();
                    addWord(t);
                }else{
                    addWord(word);
                }
                
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("no file");
            return;
        }
    }
    static String trimming(String str){
        int i =0, j = str.length() -1;
        while(i <str.length() && !Character.isLetter(str.charAt(i))) //while i-th character is not letter
            i++;
        
        while(j >= 0 && !Character.isLetter(str.charAt(j)) )
            j--;

        if(i >j)
            return null;
        String trimmed = str.substring(i, j+1);

        return trimmed;
    }


    static void addWord(String str){
        int index = findWord(str); // 못찾으면 return -1 
        if(index != -1){ 
            count[index]++;
        }else {
            int i = n-1;
            while (i >= 0 && words[i].compareTo(str)>0 ){
                words[i+1] = words[i];
                count[i+1] = count[i];
                i--;
            }
            
            words[i+1] = str;
            count[i+1] = 1;
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