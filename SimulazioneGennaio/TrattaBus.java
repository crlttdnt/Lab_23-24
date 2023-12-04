public class TrattaBus extends Tratta {
//OVERVIEW: Tratta Bus per la quale la CO2 prodotta è calcolata come il prodotto delle ore di percorrenza e di un quantitativo fisso per ora, fornito alla creazione della tratta.
    //attributi
    double qHr; //quantitativo per ore

    //costruttore
    public TrattaBus(String origine, String destinazione, double lunghezza, double vel, double qHr) {
        super(origine, destinazione, lunghezza, vel);
        this.qHr = qHr;
    }


    //metodi
    @Override
    public double quantaCO2() {
        //EFFECTS: calcola CO2 come il prodotto delle ore di percorrenza e di un quantitativo fisso per ora,.
        return this.calcolaDurata() * qHr;
    }


    public double getqHr() {
        return qHr;
    }


    @Override
    public String toString() {
        return "(Bus) " + super.toString() + ", qHr: " + qHr;
    }

    
    
}
