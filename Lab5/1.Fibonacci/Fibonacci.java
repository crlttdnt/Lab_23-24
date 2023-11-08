import java.util.ArrayList;
import java.util.Iterator;

public class Fibonacci {
//OVERVIEW: implementa un Iteratore standalone Fibonacci che produce i primi n numeri della sequenza di Fibonacci.

    private int[] result = {0,1};
   
    
            public boolean hasNext() {
                return true;
            }

            public Integer next() {
                //EFFECTS: ...
                int tmp = this.result[1];
                this.result[1] = this.result[0] + this.result[1];
                this.result[0] = tmp;
                return tmp;

            }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        Fibonacci f = new Fibonacci();

        Iterator<Integer> it = f.iterator();


        for (int i = 0; i < n; i++) {
            System.out.println(it.next());
        }
    }
}
    

    
    
    

    

