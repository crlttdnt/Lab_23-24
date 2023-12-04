public class TrattaAereo extends Tratta {
//OVERVIEW: per la quale la CO2 prodotta è la somma di un fisso per il decollo e di una quota calcolata in base ai km percorsi (come per la TrattaTreno), entrambi forniti alla creazione della tratta.
    
//attributi
    double qKm; //quantitativo per km
    double qFix; //quantitativo fisso per il decollo.

    //costruttore
    public TrattaAereo(String origine, String destinazione, double lunghezza, double vel, double qKm, double qFix) {
        super(origine, destinazione, lunghezza, vel);
        this.qKm = qKm;
        this.qFix = qFix;
    }


    //metodi
    @Override
    public double quantaCO2() {
        //EFFECTS: calcola CO2 come la somma di un fisso per il decollo e di una quota calcolata in base ai km percorsi
        return qFix + qKm;
    }


    @Override
    public String toString() {
        return "(Aereo) " + super.toString() + ", qKm: " + qKm + ", qFix: " + qFix;
    }


    public double getqKm() {
        return qKm;
    }


    public double getqFix() {
        return qFix;
    }


    
    

    

}
