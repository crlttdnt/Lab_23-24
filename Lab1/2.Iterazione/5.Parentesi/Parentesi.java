public class Parentesi {
  //se scrivi main sto coso sotto va da solo
    public static void main(String[] args) {
       
        //String parentesi = args[0];
        int contAperte = 0;
        int contChiuse = 0;

        for (int i = 0; i < args[0].length(); i++) {
            if (args[0].charAt(i) == '[')  
                contAperte++;
            //charAt(i) sarebbe in posizione i
            
            if (args[0].charAt(i) == ']')
                contChiuse++;

            if (contChiuse < contAperte) {
                break;
            }
        }

            if (contAperte != contChiuse) {
                System.out.println("Non bilanciate");
            } else {
                System.out.println("Bilanciate");
            }


    } 
}
