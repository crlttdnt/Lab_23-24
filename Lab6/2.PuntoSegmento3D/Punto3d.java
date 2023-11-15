public class Punto3d extends Punto2d {
   //
    final double z;

    public Punto3d(double x,y,z) {
    //MODIFIES: this
    //EFFECTS: inizializza this con super(x,y) + z;
        super(x,y);
        this.z = z;
    }


    @Override
    public String toString() {
        return super.toString() + ", z: " + z;
    }

    @Override
    public boolean equals(Object obj) {

    }

    public static void main(String[] args) {
        Punto2d p1 = new Punto3d(4,5,0);
        Punto2d p2 = new Punto2d(4,5);
    
        

    }
    
}
