public class Sottostringa {
    //OVERVIEW: stabilisce se stringa1 è sottostringa di stringa2
    


    public static boolean sottoStringa (String testo, String parola) {
    // EFFECTS: restituisce `true` se `parola` è sottostringa di `testo` e `false` altrimenti.
        
            if (testo.contains(parola)) 
                return true;
            else 
                return false;
    }


    public static void main(String[] args) {
       String testo = args[0]; 
       String parola = args[1];
        
       if (sottoStringa(testo, parola)) {
            System.out.println(parola + " e' sottostringa di " + testo);
       } else {
            System.out.println(parola + " non e' sottostringa di " + testo);
       }

    }
}
