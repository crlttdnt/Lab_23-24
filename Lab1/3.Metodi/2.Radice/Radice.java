
public class Radice {
    public static void main(String[] args) {
        int numero = Integer.parseInt(args[0]);
        if (radiceQuadrata(numero) != 0) {
            System.out.println(radiceQuadrata(numero));
        } else {
            System.out.println("Il valore inserito non appartiene al dominio della funzione");
        }
    }

    public static double radiceQuadrata(double numero) {
        if (numero > 0) {
            return Math.sqrt(numero);
        }
        return 0;
    }
}
