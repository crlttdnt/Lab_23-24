public class Carta implements Comparable<Carta> {
    //OVERVIEW: classe definita da: Un valore nel range [A=1,2,3,4,5,6,7,8,9,10,J=11,Q=12,K=13] 
    //e un seme nel range [cuori=C, quadri=Q, fiori=F, picche=P].
    
    //attributi
    private final int num;
    private final int seme; //C = 1, Q= 2, F= 3, P= 4;

    //costruttori
    public Carta(int num, int seme) throws IllegalArgumentException {
        //modifies: this
        //EFFECTS: istanzia una carta
        //          se seme == null o vuoti lancia IllegalArgumentException
        //          se num è fuori range (<1 o > 13) lancia IllegalArgumentException
        //          se seme è fuori range(non è 1,2,3,4) lancia IllegalArgumentException       

        if (num < 1 || num > 13) {
            throw new IllegalArgumentException("Num fuori range");
        }

        if (seme < 1 || seme > 4)
            throw new IllegalArgumentException("Seme deve essere: 1,2,3,4");

        this.num = num;
        this.seme = seme;

    }

     //metodi
    @Override
    public int compareTo(Carta o) {
       //1 se this > O, 0 se uguali e -1 se this<O
       //ordina le carte
       if (this.num < o.num) {
            return -1;
       }
        if (this.num > o.num) {
            return 1;
       }

       if (this.seme < o.seme) {
            return -1;
       }

       if (this.seme > o.seme) {
            return 1;
       }

       return 0; 
    }

    public int getNum() {
        return num;
    }

    public int getSeme() {
        return seme;
    }

    @Override
    public String toString() {
        String ret = "";
        switch (this.seme) {
            case 1:
                ret = "C";
                break;
        
            case 2:
                ret = "Q";
                break;

            case 3:
                ret = "F";
                break;
        
            case 4:
                ret = "P"; 
                break;   
        }
        return "Carta: " + num + " " + ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carta other = (Carta) obj;
        if (num != other.num)
            return false;
        if (seme != other.seme)
            return false;
        return true;
    }


    

    





   
    

}
