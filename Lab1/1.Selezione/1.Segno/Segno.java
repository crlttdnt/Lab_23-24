public class Segno {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n < 0) 
            System.out.println("-");
        else if (n > 0) 
            System.out.println("+");
        else 
            System.out.println("0");
        
    }
} 
