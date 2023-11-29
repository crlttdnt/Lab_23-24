package Simulazione;
public abstract class Contenitore implements Comparable<Contenitore>{

    public Contenitore(double contrenuyto, String liquido) throws ExceedCapacityException, IllegalArgumentException {
        //MODIFIES:this
        //EFFECTS: inizializza this con contenuto di liquido
        //          se contenuto > capienza lancia ExceedCapacityException
        //          se String == null e contenuto != 0 lancia IllegalArgumentException
        //          se String != null e contenuto == 0 lancia IllegalArgumentException

    }

    public abstract double capienza() {
        //EFFECTS: restituisce la capienza di this.


    }

    public void versa(Contenitore c) throws NullPointerException, IncompatibleLiquidsException  {
        //MODIFIES: this,c
        //EFFECTS: travasa contenuto di this in c se capienza rimanente di c è sufficiente e hanno lo stesso liquido o c non 
        //         se la capienza di c non è sufdfifcientre si travasa fino alòla capacità massima
        //          se c null lancia NullPOinterException
        //      se tipo di c != liquidodi this lancia IncompatibleLiquidsException
        
    }

    @Override
    public int compareTo(Contenitore o)  {

    }

}