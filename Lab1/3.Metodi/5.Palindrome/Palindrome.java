public class Palindrome {
    public static void main(String[] args) {
        String s = args[0];

        System.out.print("[ ");

//fori e tab fa for ternario
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 2; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if(isPalindrome(temp)) {
                    System.out.print(temp + " ");
                }
            }
        }
        
         System.out.println("]");
    }

    
    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) 
                return false;
            
        }

        return true;
    }
}
