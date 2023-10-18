public class Terne {
    public static void main(String[] args) {
        int soglia = Integer.parseInt(args[0]);
        if (soglia <= 0) {
            System.exit(0);
        }
        ternePitagoriche(soglia);
    }

    public static boolean ternaPitagorica(int a, int b, int c) {
        return c * c == a * a + b * b;
    }

    public static void ternePitagoriche(int soglia) {
        for (int i = 1; i < soglia; i++) {
            for (int j = i+1; j < soglia; j++) {
                for (int k = j+1; k < soglia; k++) {
                    if (ternaPitagorica(i, j, k)) {
                        System.out.println("(" + i + ", " + j + ", " + k + ")");
                    }
                }
            }
        }
    }

}
