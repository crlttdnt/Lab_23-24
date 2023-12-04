public class TrattaTreno extends Tratta {
    //Tratta treno per la quale la CO2 prodotta è calcolata come il prodotto dei km percorsi e di un quantitativo fisso per km, fornito alla creazione della tratta.

    //attributi
    String origine, destinazione; //nome del luogo di origine e destinazione
    double lunghezza, vel; //lunghezza del percorso in km e velocità media del mezzo in kmh
    double qKm; //quantitativo per km

    //costruttore
    public TrattaTreno(String origine, String destinazione, double lunghezza, double vel, double qKm) {
        this.origine = origine;
        this.destinazione = destinazione;
        this.lunghezza = lunghezza;
        this.vel = vel;
        this.qKm = qKm;
    }


    //metodi
    public int quantaCO2() {
        //EFFECTS: calcola CO2 come il prodotto dei km percorsi e di un quantitativo fisso per km.
        return lunghezza * qKm;
    }

    


}
