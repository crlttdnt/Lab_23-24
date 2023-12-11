import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String nomeOperatore = args[0];

        Operatore operatore = new Operatore(nomeOperatore);
        
        System.out.println("Inserisci Utenza e comando (add/call/load/reset):");

        Scanner s = new Scanner(System.in);

        try {
            while (s.hasNextLine()) {
                String[] str = s.nextLine().split(" ");
                String NumeroUtenza = str[0];
                String parametro = str[1];
                String tipoUtenza = str[2];

                Utenza u = null;

        //1234567890 add Soglia 100 FumagalliBrambilla
        //0987654321 add Soglia 20 AjejeBrazorf
        //6789012345 add Prepagata JohnnyGlamour

                if (parametro.equals("add")) {
                    if (tipoUtenza.equals("Soglia")) {
                        double n = Double.parseDouble(str[4]);
                        u = new UtenzaSoglia(NumeroUtenza, str[3], n, 0);
                        operatore.aggiungiUtenza(u);
                    } else if (tipoUtenza.equals("Prepagata")) {
                        u = new UtenzaPrepagata(NumeroUtenza, str[3], 0, 0);
                        operatore.aggiungiUtenza(u);
                    }
                } else if (parametro.equals("call")) {
                    double temp = Double.parseDouble(str[2]);
                    u.durataChiamataEffettuata = temp;
                } else if (parametro.equals("load")) {
                    if (u.getClass() != UtenzaPrepagata.class) {
                        System.out.println("Tipo utenza sbagliato !");
                        System.exit(1);
                    }
                    double temp = Double.parseDouble(str[2]);
                    u.aumentaDurataChiamata(temp);
                } else if (parametro.equals("reset")) {
                    if (u.getClass() != UtenzaSoglia.class) {
                        System.out.println("Tipo utenza sbagliato !");
                        System.exit(1);
                    }
                    u.reset();
                }

            }

        } catch (TempoEsauritoException | IllegalArgumentException | NullPointerException | UtenzaNonValidaException e) {
           System.out.println(e.getMessage());
        }


        System.out.println(operatore);




    }
}
