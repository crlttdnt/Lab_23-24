public class Cerchio {
    
    public static void main(String[] args) {
        
        double raggio = Double.parseDouble(args[0]);

        System.out.println("Area del cerchio: " + CalcolaArea(raggio));
        System.out.println("Circonferenza del cerchio: " + CalcolaCirconferenza(raggio));

    }



    //restituisce il valore dell'area del cerchio associato;
    public static double CalcolaArea(double raggio) {
        return raggio*raggio*Math.PI;
    }


    //restituisce il valore della circonferenza del cerchio associato.
    public static double CalcolaCirconferenza(double raggio) {
        return 2*raggio*Math.PI;
    }
}
