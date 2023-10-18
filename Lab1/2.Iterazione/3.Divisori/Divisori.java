public class Divisori {
    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]);

        System.out.print("Divisori di " + n + ": ");

        for (int i = 1; i < n; i++) {
            if (n % i == 0)
            System.out.print(i + " ");
        }
    }
}
