import java.util.ArrayList;
import java.util.Iterator;

public class Percorso implements Iterable<Tratta> {
    //OVERVIEW: Percorso costituito da una sequenza di Tratte, La prima tratta parte da un luogo d'origine e arriva al punto di partenza della tratta successiva e così via fino all'ultima tratta.

    //attributi
    private ArrayList<Tratta> tratte = new ArrayList<>();


    //costruttori
    public Percorso() {
        //EFFECTS: istanzia un percorso vuoto.

    }

    public Percorso(Percorso p) throws NullPointerException, TrattaNonValidaException {
        for (Tratta tratta : p) 
            this.add(tratta);
    }


    //metodi
    public void add(Tratta tratta) throws TrattaNonValidaException, NullPointerException {
        //modifies: this
        //effects: aggiunge una tratta al percorso, la tratta aggiunta deve continuare il percorso correttamente (avere il luogo d'origine = al luogo di destinazione dell'ultima tratta.) 
        //          lancia NullPointerException se tratta è nullo
        //          lancia TrattaNonValidaException (checked) se la tratta non continua il percorso correttamente.
        //          (lancia TrattaNonValidaException se t.origine != ultimaTrattaAggiunta.destinazione)

        if (tratta == null) 
            throw new NullPointerException("Tratta nulla");

        if (!tratte.isEmpty() && !tratte.get(tratte.size() - 1).getDestinazione().equals(tratta.getOrigine()))
            throw new TrattaNonValidaException("Tratta non continua il percorso correttamente");

        tratte.add(tratta);

        assert repOk();

    }

    public double sommaDurate() {
        //effects: returna la somma delle durate delle Tratte che compongono il Percorso
       double ret = 0;
        for (Tratta tratta : this) {
            ret += tratta.calcolaDurata();
        }
        return ret;
    }

    public double sommaCO2() {
        //effects:Calcola la CO2 prodotta come la somma delle quantità di CO2 prodotte per ciascuna Tratta del Percorso
        double ret = 0;
        for (Tratta tratta : this) {
            ret += tratta.quantaCO2();
        }
        return ret;

    }

    public ArrayList<Tratta> ordinaPerDurata() {
        //modifies: this
        //effects: definisce l'ordine naturale dei percorsi per durata
        ArrayList<Tratta> tratteSorted = new ArrayList<>(tratte);
        tratteSorted.sort(null);
        return tratteSorted;

    }

    //@Override
    public boolean repOk() {
       if (tratte == null) 
        return false;

        for (int i = 0; i < tratte.size(); i++) {
            if (tratte.get(i) == null)
                return false;
            if (i != 0 && !tratte.get(i - 1).getDestinazione().equals(tratte.get(i).getOrigine()))
                return false;
        }  

        return true;

    }

    @Override
    public String toString() {
        return "Percorso (durata: " + sommaDurate() + ", co2: " + sommaCO2() + ")";
    }
    //Percorso (durata: 1.7200000000000002, co2: 1410.675)

    

    @Override
    public Iterator<Tratta> iterator() {
    //EFFECTS: Restituire un Iteratore delle tratte del Percorso
        
        return new Iterator<Tratta>() {

            Iterator<Tratta> i = tratte.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Tratta next() {
                return i.next();
            }
        };
    
            
    }
    
}
    

   


