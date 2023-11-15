public class Punto2d {
    //OVERVIEW: modella un punto in 2D - immutabile
    public final double x,y; //final --> immutabili

    //costruttore
    public Punto2d(double x, double y) {
        //MODIFIES: this
        //EFFECTS: inizializza this con x e y
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Punto2d: (x: " + this.x + ", y: " + this.y + ")";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(this.getClass().equals(obj.getClass())))
            return false;
        Punto2d tmp = (Punto2d) obj;
        if (this.x != tmp.x)
            return false;
        if (this.y != tmp.y)
            return false;
        return true;
    }

    
}
