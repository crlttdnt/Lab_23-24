import java.util.ArrayList;
import java.util.Scanner;

public class Stanza {
    int capienzaMax; 
    int persone;


// construttori
    public Stanza(int capienzaMax) throws IllegalArgumentException {
        // EFFECTS: istanzia una nuova Stanza
        // lancia IllegalArgumentException se capienza < 0
        if (capienzaMax < 0)
            throw new IllegalArgumentException("Non e' possibile avere una stanza con capienza negativa");

        this.capienzaMax = capienzaMax;
        this.persone = 0;
    }


//metodi
    public void menoPersona() throws StanzaGiaVuotaException {
    // MODIFIES: this
    // EFFECTS: toglie una persona dalla stanza;
    // lancia StanzaGiaVuotaException se persone = 0
        if (this.persone <= 0) {
            throw new StanzaGiaVuotaException("Nessuno nella stanza");
        }

        this.persone --;
    }

    public void piuPersona() throws StanzaGiaPienaException {
    // MODIFIES: this
    // EFFECTS: aggiunge una persona alla stanza;
    // lancia StanzaGiaPienaException se persone = capienzaMax
        if (this.persone >= this.capienzaMax) {
            throw new StanzaGiaPienaException("Capienza massima raggiunta nella stanza");
        }
        this.persone ++;
    }

    public static void aggiornaStanze(ArrayList<Stanza> stanze, int numStanza, char operazione)
        throws IllegalArgumentException, StanzaNonEsisteException, StanzaGiaPienaException, StanzaGiaVuotaException {
    //MODIFIES: stanze
    //EFFECTS: aggiorna il numero di persone in una stanza, operazione deve essere + o -.
    // lancia IllegalArgumentException se stanze = null o se operazione non e' un carattere valido
    // lancia StanzaNonEsisteException se idStanza > stanze.size()
    // lancia StanzaGiaPienaException se si vuole aggiungere una persona a una stanza già piena
    // lancia StanzaGiaVuotaException se si vuole togliere una persona da una stanza vuota
    
        if (stanze == null) {
            throw new IllegalArgumentException("Stanze non puo essere un valore nullo");
        }

        if (numStanza > stanze.size()) {
            throw new StanzaNonEsisteException("Stanza " + numStanza + " non esiste");
        }
            
        if (operazione == '+') {
            stanze.get(numStanza - 1).piuPersona();
        } else if (operazione == '-') {
            stanze.get(numStanza - 1).menoPersona();
        } else {
            throw new IllegalArgumentException("L'operazione non è valida");
        }
    }

    public static void main(String[] args) {
        ArrayList<Stanza>stanze = new ArrayList<>();

        for (String s : args) {
            try {
                int capienzaMax = Integer.parseInt(s);
                stanze.add(new Stanza(capienzaMax));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        System.out.println("Create " + stanze.size() + " stanze");

        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            String[] n = s.nextLine().split(" ");
            try {
                aggiornaStanze(stanze, Integer.parseInt(n[0]), n[1].charAt(0));
            } catch (IllegalArgumentException| StanzaNonEsisteException e) {
                System.out.println(e.getMessage());
            } catch (StanzaGiaPienaException | StanzaGiaVuotaException e) {
                System.out.println(e.getMessage() + " " + Integer.parseInt(n[0]));
            }
        }

        int totalePersone = 0;
        for (Stanza stanza : stanze) {
            totalePersone += stanza.persone;
        }
        System.out.println();
        System.out.println("Numero totale di persone presenti: " + totalePersone);
    }


}
