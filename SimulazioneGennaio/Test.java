import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Percorso> percorsi = new ArrayList<>();
        Percorso p = new Percorso();

        while(s.hasNextLine()) {
            
            String[] str = s.nextLine().split(" ");

            //Tratta tratta = null;

            try {
                switch (str[0]) {
                case "-":
                    percorsi.add(new Percorso(p));
                    p = new Percorso();
                    break;
                case "TrattaTreno":
                    p.add(new TrattaTreno(str[1], str[2], Double.parseDouble(str[3]), Double.parseDouble(str[4]), Double.parseDouble(str[5])));
                    break;
                case "TrattaAereo":
                    p.add(new TrattaAereo(str[1], str[2], Double.parseDouble(str[3]),Double.parseDouble(str[4]), Double.parseDouble(str[5]), Double.parseDouble(str[6])));
                    break;
                case "TrattaBus":
                    p.add (new TrattaBus(str[1], str[2], Double.parseDouble(str[3]),Double.parseDouble(str[4]), Double.parseDouble(str[5])));
                    break;
                default:
                    System.out.println("Tipo di Tratta sconosciuto");
                    break;
            }

            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Input non valido");
            } catch (TrattaNonValidaException | IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
            
        }
    
            try {
                percorsi.add(new Percorso(p));
            } catch (NullPointerException | TrattaNonValidaException e ) {
                System.out.println(e.getMessage());
            }


            for (Percorso percorso : percorsi) {
                System.out.println("\n");
                System.out.println(percorso);
                for (Tratta tratta : percorso) {
                    System.out.print("      ");
                    System.out.println(tratta);
                }
                
            }
            System.out.println();

    }

   
}
