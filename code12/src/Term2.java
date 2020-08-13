package code12.src;

public class Term2 {
    public int coaf;
    public int expo;

    public int calcterm(int x) {
        return (int) (coaf * Math.pow(x, expo));
    }
    public void printTerm() {
        System.out.print(coaf + "x^" + expo);
    }
}