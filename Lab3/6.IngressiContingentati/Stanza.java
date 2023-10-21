import java.util.ArrayList;
import java.util.Scanner;

public class Stanza {
    int capienzaMax; int persone;

    public void modificaStanza(String x) {
        //MODIFIES: this
        //EFFECTS: modifica la capienza della stanza
        if (x == "+") {
           this.persone ++;
        } else if (x == "-") {
            this.persone --;
        } 
    } 

    public static void main(String[] args) {
        ArrayList<Stanza> stanze = new ArrayList<>();

        int contStanze = 0;
        for (int i = 0; i < args.length; i++) {
            int n = Integer.parseInt(args[i]);
            if (n <= 0) {
                System.out.println("Non è possibile avere una stanza con capienza negativa");
                System.exit(1);
            }
            stanze.add(new Stanza(10, n));
            contStanze = i;
        }
        System.out.println("Create " + contStanze + " stanze");

        Scanner s = new Scanner(System.in);

        int numStanza = 0; 
        String x;
       
        while (s.hasNext()) {
            numStanza = s.nextInt();
            x = s.next();
             if (numStanza > contStanze || numStanza < contStanze) {
                System.out.println("Stanza " + numStanza + " non esiste");
            } else {
                stanze.get(numStanza).modificaStanza(x);
            }
            if (stanze.get(numStanza).persone <= 0) {
                System.out.println("Nessuno nella stanza " + numStanza);
            }
            if (stanze.get(numStanza).persone >= stanze.get(numStanza).capienzaMax) {
                System.out.println("Capienza massima raggiunta nella stanza " + numStanza);
            }
        }

        int totalePersone = 0;
        for (Stanza stanza : stanze) {
            totalePersone += stanza.persone;
        }
        System.out.println("Numero totale di persone presenti: " + totalePersone);
    }


}
