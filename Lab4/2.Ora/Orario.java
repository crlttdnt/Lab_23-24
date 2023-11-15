import java.util.InputMismatchException;
import java.util.Scanner;

public class Orario {
    //OVERVIEW: rappresenta un'orario con un valore delle ore tra 0 e 23 e dei minuti tra 0 e 59

    //attributi
    int ore, minuti;

    //costruttori
    public Orario() {
    //modifies: this
    //EFFECTS: costruttore di default che inizializza un nuovo Orario con l'ora e i minuti a 0
        this.ore = 0;
        this.minuti = 0;

        assert repOk();
    }

    public Orario(int ore, int minuti) throws IllegalArgumentException { 
    //modifies: this
    //Effects: costruttore che inizializza un nuovo Orario con l'ora (nel range 0-23) e i minuti dati come parametri
    //      lancia IllegalArgumentException se ora non è 0-23 e minuti 0-59
       
        if (ore < 0 || ore > 23)
            throw new IllegalArgumentException("Valore ore non valido (0-23)");

        if (minuti < 0 || minuti > 59)
            throw new IllegalArgumentException("Valore minuti non valido (0-59)");
        
        
        this.ore = ore;
        this.minuti = minuti;

        assert repOk();
    }

    public Orario(int ore, int minuti, boolean PM) throws IllegalArgumentException {
    //modifies: this
    //effects: costruttore che inizializza un nuovo Orario con l'ora (nel range 1-12), i minuti, e un valore booleano che specifica se l'orario è di mattina (false) o pomeriggio (true)
    //      lancia IllegalArgumentException se se ora non è 1-12 e minuti 0-59

        if (ore < 1 || ore > 12)
            throw new IllegalArgumentException("Valore ore non valido (1-12)");

        if (minuti < 0 || minuti > 59)
            throw new IllegalArgumentException("Valore minuti non valido (0-59)");

        this.ore = convertiOra12to24(ore, PM);
        this.minuti = minuti;

        assert repOk();
    }

    //metodi
    public boolean repOk() {
        if (ore < 0 || ore > 23)
            return false;

        if (minuti < 0 || minuti > 59)
            return false;

        return true;
    }

    public int getOre() {
        return ore;
    }

    public int getMinuti() {
        return minuti;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Orario other = (Orario) obj;
        if (ore != other.ore)
            return false;
        if (minuti != other.minuti)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", ore, minuti);
    }

    public void avanza(int ore, int minuti) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: fa avanzare l'orario di ore e minuti specificati, gestendo opportunamente il cambio d'ora
        // lancia IllegalArgumentException se ore o minuti sono valori negativi
        if (ore < 0 || minuti < 0) {
            throw new IllegalArgumentException("Minuti o ore negativi");
        }

        this.ore = (this.ore + ore) % 24;

        this.minuti += minuti;
        if (this.minuti > 59) {
            this.ore += (this.minuti / 60);
            this.minuti = this.minuti % 60;
        }

        assert repOk();
    }
    
    public String getOra24() {
    //effects: restituisce una stringa che rappresenta l’orario nel formato a 24 ore (hh:mm)
        return this.toString();
    }
    
    public String getOra12() {
    //effects: restituisce le ore in una notazione a 12 ore (h:mm xx) dove xx è AM o PM.
        int ore = convertiOra24to12(this.ore, true);
        String AmPm = (this.ore >= 12) ? "PM" : "AM";

        return String.format("%02d:%02d %s", ore, minuti, AmPm);
    }

    private int convertiOra12to24(int ore, boolean PM) throws IllegalArgumentException {
    // EFFECTS: ritorna ore in formato 24H 
    // lancia IllegalArgumenteException se ore non è 1-12
        if (ore < 1 || ore > 12)
        throw new IllegalArgumentException("Valore ore non valido (1-12)");

        if (ore == 12 && !PM)
            return 0;

        if (ore == 12 && PM)
            return 12;

        if (ore < 12 && !PM)
            return ore;

        return ore + 12;

    }

    private int convertiOra24to12(int ore, boolean PM) throws IllegalArgumentException {
    // EFFECTS: ritorna ore in formato 12H 
    // lancia IllegalArgumenteException se ore non è 0-23

        if (ore < 0 || ore > 23)
        throw new IllegalArgumentException("Valore ore non valido (0-23)");

        if (ore == 0)
            return 12;

        if (ore <= 12)
            return ore;

        return ore - 12;

    }

    public static void main(String[] args) {
        Orario orario = null;

        try {
            String[] time = args[0].split(":");
            if (args.length == 1) {
                orario = new Orario(
                        Integer.parseInt(time[0]),
                        Integer.parseInt(time[1]));
            } else {
                orario = new Orario(
                        Integer.parseInt(time[0]),
                        Integer.parseInt(time[1]),
                        args[1].equals("PM"));
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            orario = new Orario();
        }

        System.out.println("Orario: " + orario.getOra24());
        System.out.println("Orario: " + orario.getOra12());

        Scanner s = new Scanner(System.in);
        try {
        s.next();
            orario.avanza(s.nextInt(), s.nextInt());
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Orario: " + orario.getOra24());
        System.out.println("Orario: " + orario.getOra12());

    }
    
}
