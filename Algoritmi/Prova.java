public class Prova {

    public static void main(String[] args) {
        int c = 0;
        int a = 10000;
        while(a > 1) {
            int b = 1;
            while(b <= a*a) {
                c++;
                b = 2*b;
            }
            a = a/2;
        }
        System.out.println(c);
    }

}
