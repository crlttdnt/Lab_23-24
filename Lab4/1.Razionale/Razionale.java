public class Razionale {
//OVERVIEW:  rappresenta un numero razionale con il suo numeratore (intero) ed il suo denominatore (intero, diverso da 0)
    
    //attributi 
    int num, den;

    //costruttori
    public Razionale(int num, int den) throws ArithmeticException {
        //MODIFIES:this
        //EFFECTS:inizializza this con num e den
        //  se den == 0 lancia ArithmeticException
       
        if (den == 0)
            throw new ArithmeticException("Denominatore non puo essere = 0");

        this.num = num;
        this.den = den;

        assert repOk();

    }

    //metodi
    public boolean repOk() {
        return den != 0;
    }

    public double valore() {
        //EFFECTS:  restituisce il rapporto fra il numeratore ed il denominatore
        return (double) num / den;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        assert repOk();
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
         // EFFECTS: setter di den
        // lancia ArithmeticException se den = 0;
        if (den == 0)
            throw new ArithmeticException("Denominatore non puo' essere zero");

        this.den = den;

        assert repOk();
    }


    @Override
    public String toString() {
        return num + "/" + den;
    }



    public static void main(String[] args) {
        int num = 0;
        int den = 0;
    
        try {
            num = Integer.parseInt(args[0]);
            den = Integer.parseInt(args[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Parametri da riga di comando errati o mancanti: " + e.getMessage());
            System.exit(1);
        }
        
        try {
            Razionale razionale = new Razionale(num, den);
            System.out.println("Il razionale e' " + razionale + " o " + razionale.valore());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
       
    }
}
