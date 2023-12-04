import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String str = args[0];

        System.out.println("Mazzo:");

        MazzoRidotto mazzo = null;

        if (str.equals("Mazzo")) {
            mazzo = new Mazzo();
            mazzo.mischiaMazzo();
            System.out.println(mazzo);
        } else if (str.equals("MazzoRidotto")) {
            mazzo = new MazzoRidotto();
            mazzo.mischiaMazzo();
            System.out.println(mazzo);
        }

        Scanner s = new Scanner(System.in);

        while(s.hasNext()) {
            String in = s.nextLine();
            if (in.equals("estrai")) {
                System.out.print("Estratto: ");
                System.out.println(mazzo.next());

            } else {
                String[] stringa = in.split(" ");
                int seme = 0;
                switch (stringa[2]) {
                    case "C":
                        seme = 1;
                        break;
                    case "Q":
                        seme = 2;
                        break;
                    case "F":
                        seme = 3;
                        break;
                    case "P":
                        seme = 4;
                        break;
                }
                Carta carta = new Carta(Integer.parseInt(stringa[1]), seme);

                
                try {
                    mazzo.inserireCarta(carta); 
                    System.out.print("Inserito: ");
                    System.out.println(carta);
                } catch (CardExistsException | CardNotValidException e) {
                    System.out.println(e.getMessage());
                }
                
                
            }

       
        }
        System.out.println("Mazzo:");
        mazzo.ordinaMazzo();
        System.out.println(mazzo);

    }



}
