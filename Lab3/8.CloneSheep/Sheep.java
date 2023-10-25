import java.util.ArrayList;
import java.util.Scanner;

public class Sheep implements Cloneable {
    String nome;
    ArrayList<String> cromosomi = new ArrayList<>();

    //costruttori
    public Sheep (String nome) throws IllegalArgumentException {
    // Effects: istanzia una nuova sheep e lancia illegalargumentexception se nome è vuoto o nullo
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Il nome non puo essere nullo o vuoto");
        }
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    //metodi

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //da finire;
        Sheep nuovaPecora = (Sheep) super.clone();
        //DEEP clone di cromosomi
        
        ArrayList<String> altriCromosomi = new ArrayList<>();

        for (String cromosoma : this.cromosomi) {
            altriCromosomi.add(cromosoma);            
        }

        nuovaPecora.cromosomi = altriCromosomi;

        return nuovaPecora;
        
    }

    @Override
    public boolean equals(Object obj) {
       if (this == obj) 
        return true;
        if (obj == null) 
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sheep other = (Sheep) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cromosomi == null) {
            if (other.cromosomi != null)
                return false;
        } else if (!cromosomi.equals(other.cromosomi))
            return false;
        return true;
    
    }

    public String getCromosoma(int i) {
    //Effects: legge una data stringa del dna in base al suo indice
        return this.cromosomi.get(i);
    }

    public void aggiungiCromosoma(String s) throws IllegalArgumentException {
        if (s == null || s.equals("")) {
            throw new IllegalArgumentException("La stringa di cromosomi non puo essere vuota o nulla");
        }
        this.cromosomi.add(s); 
    }

    public void sostituisciCromosoma(int i, String s) throws IllegalArgumentException {
        //sostituire una stringa del dna a un dato indice con un'altra data come parametro.
        if (s == null || s.equals("")) {
            throw new IllegalArgumentException("La stringa di cromosomi non puo essere vuota o nulla");
        }
        this.cromosomi.add(i, s);
    }

    public static void UguaglianzaConStampa(Sheep pecora1, Sheep pecora2) {
        if (pecora1.equals(pecora2)) {
            System.out.println("Le due pecore sono uguali.");

        } else {
            System.out.println("Le due pecore sono diverse.");

        }
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep pecora1 = null;

        if (args.length < 1) {
            System.out.println("Inserire il nome della pecora sulla riga di comando");
            System.exit(1);
        }
        try {
            pecora1 = new Sheep(args[0]);
        } catch (IllegalArgumentException e) {
            System.out.println("Pecora non valida");
            System.exit(1);
        }

        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci i cromosomi, uno per riga (terminare con CTRL+D):");
        while (s.hasNextLine()) {
            try {
                pecora1.aggiungiCromosoma(s.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        Sheep pecora2 = (Sheep) pecora1.clone();
   
        System.out.println();
        System.out.println("Ho creato un clone di " + pecora1.nome + ".");

        UguaglianzaConStampa(pecora1, pecora2);

        System.out.println("Inserisci il cromosoma da modificare ed il nuovo codice:");

        Scanner x = new Scanner(System.in);
        try {
            pecora2.sostituisciCromosoma(x.nextInt() - 1, x.next());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        
        UguaglianzaConStampa(pecora1, pecora2);
    }

    
}