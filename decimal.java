public class decimal {
    public static void main(String[] args){
        for(int n=2; n<=100000; n++){
            if(isPrime(n))
                System.out.println(n);
        }
    }
    static boolean isPrime(int k){
        for(int i=2; i*i<=k; i++){
            if (k % i == 0)
                return false;
        }
        return true;
    }
}