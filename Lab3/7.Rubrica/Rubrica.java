import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Rubrica {
/*
Leggere da standard input una serie di contatti. Terminata la lettura con la combinazione dei tasti CTRL+D, verificare se vi sono contatti uguali nella rubrica e stamparli su standard output. Gestire i casi limite in maniera opportuna.
 */


    public static void stampaContattiUguali(ArrayList<Contatto> contatti) throws IllegalArgumentException {
        // EFFECTS: stampa i contatti ripetuti all'interno di contatti
        // lancia IllegalArgumentException se contatti = null
        if (contatti == null)
            throw new IllegalArgumentException("La lista non puo' essere nulla");

        Set<String> contattiUguali = new HashSet<>();
        // evita che contatti ripetuti più volte vengano ristampati

        for (int i = 0; i < contatti.size(); i++) {
            Contatto contatto1 = contatti.get(i);
            for (int j = i + 1; j < contatti.size(); j++) {
                Contatto contatto2 = contatti.get(j);
                if (contatto1.equals(contatto2))
                    contattiUguali.add(contatto1.toString());
            }
        }

        if (contattiUguali.size() == 0)
            System.out.println("\nNon ci sono contatti uguali");
        else {
            System.out.println("\nContatti uguali:");
            for (String contatto : contattiUguali) {
                System.out.println(contatto);
            }
        }

    }

    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        ArrayList<Contatto> contatti = new ArrayList<>();

        while (s.hasNextLine()) {
            String[] line = s.nextLine().split(" ");
            if (line.length != 4) {
                System.out.println("Inserimento non valido");
            } else { 
                try {
                contatti.add(new Contatto(line[0], line[1], line[2], line[3]));
                } catch (IllegalArgumentException e) {
                System.out.println("Inserimento non valido: " + e.getMessage());
                }
            }
        }
        stampaContattiUguali(contatti);
    }
}
