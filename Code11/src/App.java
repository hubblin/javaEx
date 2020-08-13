package Code11.src;

import java.util.Scanner;

/*
다항식을 만드는 프로그램
데이터 멤버와 함수 멤버가 모두 각 객체마다 다 따로 있을 수 있다.
객체란? 데이터+메서드 들의 집합이다. 
데이터는 객체의 정적인 속성을 표현하고, 메서드는 객체의 동적 속성을 표현한다.

*/
public class App {
    static Polynomial[] polys = new Polynomial[100];
    static int n =0;

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in);
        while(true){
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("create")){
                char name = kb.next().charAt(0);
                
                polys[n] = new Polynomial();
                polys[n].name = name;
                polys[n].terms = new term[100];
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
                    addTerm(polys[index], c,e);
                }
            }else if(command.equals("calc")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such polynomial exists");
                }else{
                    int x = kb.nextInt();
                    int result = calcPolynomial(polys[index], x);
                    System.out.println(result);
                }
            }else if(command.equals("print")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such polynomial exists");
                }else{
                    printPolynomial(polys[index]);
                }
            }else if(command.equals("exit")){
                break;
            }
        }
        
        kb.close();
    }



    private static int calcPolynomial(Polynomial p, int x) {
        int result =0;
        for(int i =0; i < p.nterms; i++){
            result += calcterm(p.terms[i],x);
        }
        return result;
    }

    private static int calcterm(term term, int x) {
        return (int) (term.coaf * Math.pow(x, term.expo));
    }

    private static void printPolynomial(Polynomial p) {
        for(int i=0; i < p.nterms; i++){
            printTerm(p.terms[i]);
            System.out.print("+");
        }
        System.out.println();
    }

    private static void printTerm(term term) {
        System.out.print(term.coaf + "x^" + term.expo);
    }

    private static void addTerm(Polynomial p, int c, int e) {
        int index = findterm(p,e);
        if(index != -1){
            p.terms[index].coaf += c;

        }else{
            int i = p.nterms -1;
            while(i >= 0 && p.terms[i].expo < e){
                p.terms[i+1] = p.terms[i];
                i--;
            }
            p.terms[i+1] = new term();
            p.terms[i+1].coaf = c;
            p.terms[i+1].expo = e;
            p.nterms++;
        }
    }

    private static int findterm(Polynomial p, int e) {
        for(int i =0; i < p.nterms && p.terms[i].expo >=e; i++){
            if(p.terms[i].expo == e){
                return i;
            } 
        }
        return -1;
    }

    private static int find(char name) {
        for(int i=0; i<n; i++){
            if(polys[i].name == name){
                return i;
            }
        }
        return -1;
    }
    
    
}
