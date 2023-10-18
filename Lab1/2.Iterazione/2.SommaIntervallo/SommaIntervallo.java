public class SommaIntervallo {

    public static void main(String[] args) {
        
        /*Scrivere un programma che legga da **riga di comando** due numeri interi `a` e `b` e 
        stampi a video la somma dei numeri pari compresi tra `a` e `b` (estremi esclusi) */

        int unit1 = Integer.parseInt(args[0]);
        int unit2 = Integer.parseInt(args[1]);


        int somma = 0; 

        for (int i = unit1 + 1; i < unit2; i++) {
            if (i % 2 == 0) 
            somma += i;
        }

        System.out.println("Somma = " + somma);
    }
}