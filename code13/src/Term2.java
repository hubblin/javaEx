package code13.src;

public class Term2 {
    public int coaf;
    public int expo;

    public Term2(int c, int e){
        coaf = c;
        expo = e;
    }

    public int calcterm(int x) {
        return (int) (coaf * Math.pow(x, expo));
    }
    public void printTerm() {
        System.out.print(coaf + "x^" + expo);
    }
}