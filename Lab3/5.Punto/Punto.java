import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

public class Punto {
//OVERVIEW: rappresenta un punto del piano cartesiano.
    double x;
    double y;

//costruttori
    public Punto(double x, double y) {
    // costruisce il punto di coordinate (x,y).
        this.x = x;
        this.y = y;

    }

    public Punto(double x) {
    //costruisce il punto di coordinate (x,x)
        this.x = x;
        this.y = x;
    }
   
    public Punto() {
    //costruisce il punto di coordinate (0,0).
        this.x = 0;
        this.y = 0;
    }   

//metodi
    public double getX() {
    //restituisce l'ascissa del punto.
        return this.x;
    }

    public double getY() {
    //restituisce l'ordinata del punto.
         return this.y;
    }

    public void setX(double x) {
    //modifica l'ascissa del punto (rendendola uguale a x)
        this.x = x;
    }

    public void setY(double y) {
    //modifica l'ordinata del punto (rendendola uguale a y).
        this.y = y;
    }
    
    public void setXY(double x, double y) {
    //modifica le coordinate del punto, rendendolo uguale a (x,y).
        setX(x);
        setY(y);
    }

    
    @Override
    public String toString() {
        return "{Punto: " + x + ", " + y + "}";
    }

    
    @Override
    public boolean equals(Object obj) {
    //restituisce true se il punto p coincide (cioè, se ha le stesse coordinate) con l'oggetto su cui il metodo viene invocato.
        return this.equals(obj);
        
    }

    public double distanza(Punto p) throws IllegalArgumentException {
        // EFFECTS: estituisce la distanza euclidea fra il punto p e il punto su cui il metodo viene invocato.
        // lancia IllegalArgumentException se il punto è == null
        if (p == null)
            throw new IllegalArgumentException("il punto non può essere nullo");

        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }

    public static void main(String[] args) {
        System.out.println("Inserire i punti (<x> <y>)");
        System.out.println("Terminare la lettura con CTRL+D");

        Scanner s = new Scanner(System.in);
        
        ArrayList<Punto> punti = new ArrayList<>();

        double maxDistanza = 0;
        Punto p1 = null, p2 = null;

        while (s.hasNext()) {
            try {
                punti.add(new Punto(s.nextDouble(), s.nextDouble()));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        for (int i = 0; i < punti.size() - 1; i++) {
            for (int j = i + 1; j < punti.size(); j++) {
                try {
                    double distanza = punti.get(i).distanza(punti.get(j));
                    if (distanza > maxDistanza) {
                        maxDistanza = distanza;
                        p1 = punti.get(i);
                        p2 = punti.get(j);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } 

        System.out.println();
        System.out.println("I punti piu distanti sono:");
        System.out.println(p1);
        System.out.println(p2);
    }
}
