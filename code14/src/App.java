package code14.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    static MyRectangle2[] rects = new MyRectangle2[100];;
    static int n = 0;
    public static void main(String[] args) throws Exception {
        try {
            Scanner in = new Scanner(new File("D:\\java remind\\code16\\javaEx\\data1.txt"));
            while (in.hasNext()) {
                int x = in.nextInt();
                int y = in.nextInt();
                int width = in.nextInt();
                int height = in.nextInt();

                rects[n] = new MyRectangle2(x, y, width, height);

                n++; 
            }

            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("No data file");
            System.exit(1);
        }
        bubbleSort();

        for(int i =0; i < n; i++){
            System.out.println(rects[i].toString());
        }
        
    }

    private static void bubbleSort() {
        for(int i = n-1; i >0; i--){
            for(int j=0; j < i; j++){
                if(rects[j].calcArea() > rects[j+1].calcArea()){
                    MyRectangle2 tmp = rects[j];
                    rects[j] = rects[j+1];
                    rects[j+1] = tmp;
                }
            }
        }
    }

}

