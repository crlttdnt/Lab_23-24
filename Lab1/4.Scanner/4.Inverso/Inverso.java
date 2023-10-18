import java.util.Scanner;

public class Inverso {
    public static void main(String[] args) {
        System.out.println("Inserisci un testo su più righe (termina con riga vuota):");
        String testo = "";
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            testo += s.nextLine() + "\n";
        }
        System.out.println("Testo invertito:");
        System.out.println(inverti(testo));
    }


    public static String inverti(String testo) {
       String testoInvertito = "";
        for (int i = testo.length() - 1; i >= 0; i--) {
            testoInvertito += testo.charAt(i) + "";
        }
        return testoInvertito;
    }
}
