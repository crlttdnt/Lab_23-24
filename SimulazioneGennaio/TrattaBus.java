public class TrattaBus extends Tratta {
//OVERVIEW: Tratta Bus per la quale la CO2 prodotta è calcolata come il prodotto delle ore di percorrenza e di un quantitativo fisso per ora, fornito alla creazione della tratta.
    //attributi
    String origine, destinazione; //nome del luogo di origine e destinazione
    double lunghezza, vel; //lunghezza del percorso in km e velocità media del mezzo in kmh
    double qHr; //quantitativo per ore

    //costruttore
    public TrattaTreno(String origine, String destinazione, double lunghezza, double vel, double qHr) {
        this.origine = origine;
        this.destinazione = destinazione;
        this.lunghezza = lunghezza;
        this.vel = vel;
        this.qHr = qHr;
    }


    //metodi
    public int quantaCO2() {
        //EFFECTS: calcola CO2 come il prodotto delle ore di percorrenza e di un quantitativo fisso per ora,.
        return this.calcoloDurata() * qHr;
    }

    
}
