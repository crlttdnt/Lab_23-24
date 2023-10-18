public class Palindroma {
    
    public static void main(String[] args) {
        
        String s = args[0];

        boolean palindroma = true;

        for (int i = 0; i <= s.length()/2; i++) {
           if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                 palindroma = false;
                 break;
           }
           
        }

        if (palindroma == true)
            System.out.println("Palindroma");
        else System.out.println("Non palindroma");
    }
}
