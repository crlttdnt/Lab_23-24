import java.util.ArrayList;
public class Medie {
    public static void main(String[] args) {
        ArrayList <Double> array = new ArrayList<Double>();
        for (int i = 0; i < args.length; i++) {
            array.add(Double.parseDouble(args[i]));
        }
       
        double totale = 0;
        for (double n : array) {
            totale += n;
        }    
        
        System.out.println("Media aritmetica: " + totale/array.size());


    }
}
