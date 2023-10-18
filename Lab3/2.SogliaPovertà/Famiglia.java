import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Famiglia {
    //OVERVIEW: modella una famiglia con un certo numero di persone e un reddito complessivo
    
    int dimensione;
    double reddito;

    public Famiglia(double reddito, int dimensione) throws InputMismatchException {
    //inizializza un nuovo oggetto di tipo Famiglia e lancia una InputMismatchException se dimensione è non-positiva;
        if (dimensione <= 0) {
            throw new InputMismatchException("Impossibile creare una famiglia con meno di 1 componente");
        }

        this.reddito = reddito;
        this.dimensione = dimensione;

    }
    
    public boolean sottoSogliaPoverta(double costoCasa, double costoCibo) throws InputMismatchException {
    /*
     restituisce true se la somma tra costoCasa e costoCibo (moltiplicato per la dimensione della famiglia) è maggiore della metà del reddito della famiglia (costoCibo è il costo medio mensile del cibo per ogni individuo, mentre costoCasa è unico mensile per la famiglia); Il metodo lancia una InputMismatchException se costoCasa o costoCibo non sono positivi;
    */
        if (costoCasa <= 0 || costoCibo <= 0) {
            throw new InputMismatchException("Il costo non può essere negativo");
        }

        if(costoCasa + (costoCibo * this.dimensione) > (this.reddito / 2)) {
            return true;
        }

        return false;


    }
    
    @Override
    public String toString() {
    /* ridefinisce il metodo toString del supertipo Object e restituisce una stringa contenente le informazioni della famiglia; */
        return "Famiglia []";
    }
    

    public static void main(String[] args) {
    /*
    legge da riga di comando due numeri che definiscono rispettivamente il costo medio di vitto e di alloggio. Poi, da standard input dovrà leggere una serie di righe di testo costituite da reddito e dimensione di diverse famiglie, fermando la lettura quando l'utente preme la combinazione dei tasti CTRL+D. Dopo la lettura, visualizzare le famiglie che sono sotto la soglia di povertà. */ 

        
        ArrayList<Famiglia> famiglie = new ArrayList<>();

        double vitto = Double.parseDouble(args[0]);
        double alloggio = Double.parseDouble(args[1]);

        Scanner s = new Scanner(System.in);

        int contPoveri;

        while (s.hasNext()) {

            System.out.println("Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)");

            famiglie.add(new Famiglia(s.nextDouble(), s.nextDouble()));

            if (sottoSogliaPoverta(alloggio, vitto)) {
                contPoveri++;
                //
            }
            
        }



    }
}
