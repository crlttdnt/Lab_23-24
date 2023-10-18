public class Mesi {
    
    public static void main(String[] args) {
        
        String mese = args[0];

        if (mese.equals("aprile") || mese.equals("giugno") || mese.equals("settembre") || mese.equals("novembre"))
            System.out.printf("Il numero di giorni di %s e' 30", mese);

        else if (mese.equals("febbraio")) 
            System.out.println("Il numero di giorni di febbraio e' 28");

        else if (mese.equals("gennaio") || mese.equals("marzo") || mese.equals("maggio") ||mese.equals("luglio") || mese.equals("agosto") || mese.equals("ottobre") || mese.equals("dicembre"))
            System.out.printf("Il numero di giorni di %s e' 31", mese);

    
        else System.out.println("Il nome del mese non e' corretto.");
    }
}
