//ha solo il main
/*
legga da riga di comando un valore decimale e inizializzi una nuova CalcolatriceConMemoria con quel valore. Se nessun valore è inserito inizializzare la calcolatrice col valore 0. Poi, mediante standard input, il metodo deve leggere una serie di righe di testo nel seguente formato: <operatore> <operando2>, applicando l'operazione sulla calcolatrice e scrivendo il nuovo risultato su standard output. La lettura termina quando viene inserito il carattere =.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class SvolgiCalcolo {

    public static void printHead() {
        System.out.println("Inserisci <operatore> <operando>. es: + 3");
        System.out.println("Per terminare inserire il carattere '='.");

    }

    public static void main(String[] args) {
        CalcolatriceConMemoria c = null;

        if (args.length == 0)
            c = new CalcolatriceConMemoria();
        else {
            try {
                c = new CalcolatriceConMemoria(Double.parseDouble(args[0]));
            } catch (NumberFormatException e) {
                c = new CalcolatriceConMemoria();
            }
        }

        System.out.println("Calcolatrice inizializzata con " + c.getMem());
        Scanner s = new Scanner(System.in);
        printHead();

        while (s.hasNext()) {
            String firstParam = s.next();

            if (firstParam.equals("=")) {
                break;
                // termina la lettura
            }

            double secondParam = s.nextDouble();

            try {
                System.out.println("Risultato: " + c.operate(firstParam.charAt(0), secondParam));
            } catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
                printHead();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                printHead();
            }

        }

    }
}
