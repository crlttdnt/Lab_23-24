public class Carta implements Comparable<Carta> {
    //OVERVIEW: classe definita da: Un valore nel range [A=1,2,3,4,5,6,7,8,9,10,J=11,Q=12,K=13] 
    //e un seme nel range [cuori=C, quadri=Q, fiori=F, picche=P].
    
    //attributi
    private final int num;
    private final String seme;

    //costruttori
    public Carta(int num, String seme) throws IllegalArgumentException {
        //modifies: this
        //EFFECTS: istanzia una carta
        //          se seme == null o vuoti lancia IllegalArgumentException
        //          se num è fuori range (<1 o > 13) lancia IllegalArgumentException
        //          se seme è fuori range(non è C, Q, F, P) lancia IllegalArgumentException
        
        if (seme == null || seme == "") {
            throw new IllegalArgumentException("Num non può essere null");
        }

        if (num <1 || num > 13) {
            throw new IllegalArgumentException("Num fuori range");
        }

        if (seme != "P" || seme != "C" || seme != "Q" || seme != "F")
            throw new IllegalArgumentException("Seme deve essere: C, Q, F, P");

        this.num = num;
        this.seme = seme;

    }

     //metodi
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        carta other = (carta) obj;
        if (num != other.num)
            return false;
        if (seme == null) {
            if (other.seme != null)
                return false;
        } else if (!seme.equals(other.seme))
            return false;
        return true;
    }





   
    

}
