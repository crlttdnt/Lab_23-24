public abstract class Tratta {
    //OVERVIEW: classe astratta: tratta di viaggio

    //attributi
    String origine, destinazione; //nome del luogo di origine e destinazione
    double lunghezza, vel; //lunghezza del percorso in km e velocità media del mezzo in kmh

    //costruttore
    public Tratta(String origine, String destinazione, double lunghezza, double vel) {

        this.origine = origine;
        this.destinazione = destinazione;
        this.lunghezza = lunghezza;
        this.vel = vel;
    }

    //metodi
    public double calcoloDurata() {
        //EFFECTS: Calcola la durata della Tratta in ore
        //v = s/t --> t = s/v
        return lunghezza/vel;
    }


    public abstract double quantaCO2(Tratta tratta);
        //EFFECTS: Calcola la quantita di CO2 prodotta durante la Tratta


    

    
    
}
