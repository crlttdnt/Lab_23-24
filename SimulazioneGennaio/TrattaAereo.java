public class TrattaAereo extends Tratta {
//OVERVIEW: per la quale la CO2 prodotta è la somma di un fisso per il decollo e di una quota calcolata in base ai km percorsi (come per la TrattaTreno), entrambi forniti alla creazione della tratta.
    
//attributi
    String origine, destinazione; //nome del luogo di origine e destinazione
    double lunghezza, vel; //lunghezza del percorso in km e velocità media del mezzo in kmh
    double qkm; //quantitativo per km
    double qFix; //quantitativo fisso per il decollo.

    //costruttore
    public TrattaTreno(String origine, String destinazione, double lunghezza, double vel, double qkm, double qFix) {
        this.origine = origine;
        this.destinazione = destinazione;
        this.lunghezza = lunghezza;
        this.vel = vel;
        this.qkm = qkm;
        this.qFix = qFix;
    }


    //metodi
    public int quantaCO2() {
        //EFFECTS: calcola CO2 come la somma di un fisso per il decollo e di una quota calcolata in base ai km percorsi
        return qFix + qkm;
    }

    

}
