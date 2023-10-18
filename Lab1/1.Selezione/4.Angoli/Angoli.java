public class Angoli {
    

    public static void main(String[] args) {
        int angolo1 = Integer.parseInt(args[0]);
        int angolo2 = Integer.parseInt(args[1]);

        if (angolo1 + angolo2 > 180) 
            System.out.println("I due angoli non appartengono ad un triangolo");
    
        else System.out.println("Ampiezza terzo angolo = " + (180 - angolo1 - angolo2));
    
    }

}
