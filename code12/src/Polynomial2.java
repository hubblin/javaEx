package code12.src;

public class Polynomial2 {
    public int name;
    public Term2[] terms;
    public int nterms;

    public int calcPolynomial(int x) {
        int result =0;
        for(int i =0; i < nterms; i++){
            result += terms[i].calcterm(x);
        }
        return result;
    }

    public void printPolynomial() {
        for(int i=0; i < nterms; i++){
            terms[i].printTerm();
            System.out.print("+");
        }
        System.out.println();
    }

    public void addTerm(int c, int e) {
        int index = findterm(e);
        if(index != -1){
            terms[index].coaf += c;

        }else{
            int i = nterms -1;
            while(i >= 0 && terms[i].expo < e){
                terms[i+1] = terms[i];
                i--;
            }
            terms[i+1] = new Term2();
            terms[i+1].coaf = c;
            terms[i+1].expo = e;
            nterms++;
        }
    }

    public int findterm(int e) {
        for(int i =0; i < nterms && terms[i].expo >=e; i++){
            if(terms[i].expo == e){
                return i;
            } 
        }
        return -1;
    }
}