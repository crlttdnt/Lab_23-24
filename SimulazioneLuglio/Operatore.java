import java.util.ArrayList;
import java.util.Iterator;

public class Operatore implements Iterable<Utenza> {
   //OVERVIEW: operatore che contiene l'elenco delle proprie utenze e presenta un iteratore che attraversa le utenze in base al loro ordine naturale specificato sopra.

   //attributi
    ArrayList<Utenza> operatore = new ArrayList<>();
    final String nome;

   //costruttori
    public Operatore(String nome) throws NullPointerException {
       
        if (nome == null || nome.equals(""))
            throw new NullPointerException("Nome null o vuoto");
       
        ArrayList<Utenza> operatore = new ArrayList<>();
        this.nome = nome;
    }

   //metodi
    public void aggiungiUtenza(Utenza u) throws UtenzaNonValidaException {
        //effects: permette l'inserimento di nuove utenze
        // lancia UtenzaNonValidaException (checked) se questa è già presente
        if (operatore.contains(u)) 
            throw new UtenzaNonValidaException("Utenza gia presente");
        
        operatore.add(c);
    }


    public Utenza restituisciUtenza(String num) throws UtenzaNonValidaException {
        //effects: permette di restituire una Utenza dato il suo numero
        //lancian UtenzaNonValidaException (checked) se questa non è presente
        for (Utenza utenza : operatore) {
            if (utenza.numero = num) {
                return utenza;
                break;
            } 
        }
        throw new UtenzaNonValidaException("Utenza non presente");
    }

    public ArrayList<Utenza> ordina() {
        //modifies: this
        //effects: ordina per durata chiamata effettuata
        ArrayList<Utenza> operatoreSorted = new ArrayList<>(operatore);
        operatoreSorted.sort(null);
        return operatoreSorted;
    }

   
    @Override
    public Iterator<Utenza> iterator() {
        //iteratore che attraversa le utenze in base al loro ordine naturale 

        return new Iterator<Utenza>() {
            ArrayList<Utenza> operatoreSorted = new operatore.ordina();
            Iterator<Utenza> i = operatoreSorted.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Utenza next() {
                return i.next();
            }

            

        };
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Utenze di TIM: \n";
        for (Utenza utenza : operatore) {
            ret += utenza;
        }

        return ret;
    }


    

}
