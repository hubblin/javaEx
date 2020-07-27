package code12.src;
import java.util.Scanner;

public class App {
    static Polynomial2[] polys = new Polynomial2[100];
    static int n =0;

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in);
        while(true){
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("create")){
                char name = kb.next().charAt(0);
                
                polys[n] = new Polynomial2();
                polys[n].name = name;
                polys[n].terms = new Term2[100];
                polys[n].nterms = 0;
                n++;
            }else if(command.equals("add")){ //add f 2 3
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such polynoial exists.");
                }else{
                    int c = kb.nextInt();
                    int e = kb.nextInt();
                    polys[index].addTerm(c,e);
                }
            }else if(command.equals("calc")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such polynomial exists");
                }else{
                    int x = kb.nextInt();
                    int result = polys[index].calcPolynomial(x);
                    System.out.println(result);
                }
            }else if(command.equals("print")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such polynomial exists");
                }else{
                    polys[index].printPolynomial();
                }
            }else if(command.equals("exit")){
                break;
            }
        }
        
        kb.close();
    }




    //한 다항식 안에서 일어나는 일이 아니다. 
    //그러므로 클래스 안에 넣는것은 바람직하지 않다.
    private static int find(char name) {
        for(int i=0; i<n; i++){
            if(polys[i].name == name){
                return i;
            }
        }
        return -1;
    }
    
}
