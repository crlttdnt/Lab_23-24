import java.util.ArrayList;
import java.util.Scanner;

public class Segmento2d {
    //OVERVIEW: modella un segmento di 2d - immutabile
    private final Punto2d a,b; //private perchè non sono tipi primitivi

    //costruttore
    public Segmento2d(Punto2d a , Punto2d b) throws IllegalArgumentException, NullPointerException {
        //MODIFIES: this
        //EFFECTS: inizializza this
        //      se a o b null lancia NullPointerException
        //      se a == b lancia IllegalArgumentException

        if (a == null) 
            throw new NullPointerException("a null");

        if (b == null) 
            throw new NullPointerException("b null");
        
        if (a.equals(b)) 
            throw new IllegalArgumentException("a equals b");

        this.a = a;
        //this.a = (A) a.clone() //fosserto stati immutabili.
        this.b = b;

    }

    public Punto2d getA() {
        return a;
    }

    public Punto2d getB() {
        return b;
    }

    public double length() {
        //EFFECTS: ritorna la lunghezza del segmento.
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    @Override
    public String toString() {
        return "Segmento2d: [" + a + " " + b + "]";
    }


    public static void main(String[] args) {
        double lenmin = Double.parseDouble(args[0]);

        Scanner s = new Scanner(System.in);

        ArrayList<Segmento2d> list = new ArrayList<>();

        System.out.println("Inserisci i segmenti nel formato ax ay bx by (temina con CTRL+D)");
        

        while(s.hasNextLine()) {
            
            String line = s.nextLine();

            String[] parts = line.split(" ");

            list.add (
                new Segmento2d(
                    new Punto2d(Double.parseDouble(parts[0]),Double.parseDouble(parts[1])),
                    new Punto2d(Double.parseDouble(parts[2]),Double.parseDouble(parts[3]))
                )
                
            );
             

            

        }
        System.out.println("Segmenti di lunghezza superiore a " + lenmin);
        for (Segmento2d seg : list) {
            if (seg.length() > lenmin) {
                System.out.println(seg);
            }
        }
       
        
    }
    


}
