public abstract class Tratta implements Comparable<Tratta>{
    //OVERVIEW: classe astratta immutabile: tratta di viaggio

    //attributi
    private final String origine, destinazione; //nome del luogo di origine e destinazione
    private final double lunghezza, vel; //lunghezza del percorso in km e velocità media del mezzo in kmh

    //non c'è bisogno della repOk() perchè attributi immutabili.

    //costruttore
    public Tratta(String origine, String destinazione, double lunghezza, double vel) {
        //modifies: this
        //effects: istanzia una nuova Tratta
        //  lancia NullPointerException se origine o destinazione sono nulli
        //  lancia IllegalArgumentException se origine o destinazione sono vuoti
        //  lancia IllegalArgumentException se lunghezza o velocita sono <= 0
        
        if (origine == null || destinazione == null)
            throw new NullPointerException("Origine o Destinazione nulla");
        if (origine.equals("") || destinazione.equals(""))
            throw new IllegalArgumentException("Origine o Destinazione vuota");
        if (lunghezza <= 0 || vel <= 0) 
            throw new IllegalArgumentException("Lunghezza o Velocita non valide");
        this.origine = origine;
        this.destinazione = destinazione;
        this.lunghezza = lunghezza;
        this.vel = vel;
    }

    //metodi
    public double calcolaDurata() {
        //EFFECTS: Calcola la durata della Tratta in ore
        //v = s/t --> t = s/v
        return lunghezza/vel;
    }


    public abstract double quantaCO2();
        //EFFECTS: Calcola la quantita di CO2 prodotta durante la Tratta

    
    

    public String getOrigine() {
        return origine;
    }

    @Override
    public String toString() {
        return "Tratta tra " + getOrigine() + " e " + getDestinazione() + "; lunghezza: " + getLunghezza() + ", velocità: " + getVel();
    }
    //Tratta tra Milano e Bergamo; lunghezza: 56.0, velocità: 80.0

    public String getDestinazione() {
        return destinazione;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public double getVel() {
        return vel;
    }


    @Override
    public int compareTo(Tratta o) {
        return Double.compare(this.calcolaDurata(), o.calcolaDurata());
    }

    
    
}
