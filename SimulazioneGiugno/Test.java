import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //leggere da riga di comando il nome dell'azienda e poi, da standard input, una serie di righe

        String nomeAzienda = args[0];
        
        double tVisOld  = 0;

        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String[] str = s.nextLine().split(" ");
            //NomeCampagna TipoCampagna parametri + ...
            String NomeCampagna = str[0];
            String TipoCampagna = str[1]; //tipoCampagna può essere Social o WebRestyle
            if (str[2].equal("open")) {
                if (NomeCampagna.equals("WebRestyle")) {
                    tVisOld = Double.parseDouble(str[3]);
                    AdCampaignWebRestyling campagnaWeb = new AdCampaignWebRestyling(NomeCampagna, 0, true, 0, 0, tVisOld);
                }
                
            } else if (str[2].equal("close")) {
                
            }


        }

        CompanyAds azienda =  new CompanyAds(nomeAzienda);

    }
}
