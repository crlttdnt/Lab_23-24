import java.util.Scanner;

public class Garibaldi {
    public static void main(String[] args) {
        System.out.println("Inserisci un testo su più righe (termina con riga vuota):");
        String testo = "";
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            testo += s.nextLine() + "\n";
        }
        System.out.println("Risultato trasformazione:");
        System.out.println(trasforma(testo));
    }

    public static String trasforma(String testo) {
        char[] vocali = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        for (char vocale : vocali) {
            testo = testo.replace("" + vocale, "u");
            
        }
        return testo;
    }
}

