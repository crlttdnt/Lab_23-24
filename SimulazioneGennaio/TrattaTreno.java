public class TrattaTreno extends Tratta {
    //Tratta treno per la quale la CO2 prodotta è calcolata come il prodotto dei km percorsi e di un quantitativo fisso per km, fornito alla creazione della tratta.

    //attributi
    double qKm; //quantitativo per km

    //costruttore
    public TrattaTreno(String origine, String destinazione, double lunghezza, double vel, double qKm) {
        super(origine, destinazione, lunghezza, vel);
        this.qKm = qKm;
    }


    //metodi
    @Override
    public double quantaCO2() {
        //EFFECTS: calcola CO2 come il prodotto dei km percorsi e di un quantitativo fisso per km.
        return getLunghezza() * qKm;
    }


    public double getqKm() {
        return qKm;
    }


    @Override
    public String toString() {
        return "(Treno) " + super.toString() + ", qKm: " + qKm;
    }

    
    


}
