import java.util.Arrays;
import java.util.Scanner;

public class Tris {
//OVERVIEW: implementa il gioco del tris con due giocatori
    //attributi
    char[][] tabellone = new char[3][3];
    char turno;
    int numeroMosse;

    //costruttori
    public Tris() {
        //Effects: crea un nuovo gioco col tabellone vuoto e assegna il turno al giocatore O.
        this.tabellone = new char[3][3];
        this.turno = 'O';
    }

    //metodi
    public char turno() {
        //restituisce il carattere del giocatore di turno (X o O)
        return this.turno;
    }

    public void mossa(int x, int y) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS:  inserisce il carattere del giocatore di turno alle coordinate specificate, aumenta il numero di mosse e cambia il turno.
        //lancia l'eccezione IllegalArgumentException se la posizione è occupata o se x e y non rientrano nel range 1-3
        if (x < 1 || x > 3 || y < 1 || y > 3) {
            throw new IllegalArgumentException("Le coordinate sono fuori range");
        }
        
        if (tabellone[x-1][y-1] != 0) {
            throw new IllegalArgumentException("Posizione gia occupata");
        }

        this.tabellone[x-1][y-1] = this.turno;
        this.numeroMosse ++;
        cambiaTurno();
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "-----------------\n";
        ret += "|R\\C| 1 | 2 | 3 |\n";
         ret += "-----------------\n";
       
        for (int i = 0; i < tabellone.length; i++) {
            ret += "| " + (i + 1) + " |";
            for (int j = 0; j < tabellone.length; j++) {
                ret += " ";
                if (this.tabellone[i][j] == 0)
                    ret += " ";
                else 
                    ret += this.tabellone[i][j];
                ret += " |";
            }
            ret += "\n-----------------\n";
        }
        return ret;
        
    }

    public void cambiaTurno() {
    //MODIFIES: this
    //EFFECTS: cambia il turno.
        if(this.turno == 'O') {
            this.turno = 'X';
        } else {
             this.turno = 'O';
        }
    }


    public boolean terminato() {
    //EFFECTS: restituisce true se sono state giocate tutte e 9 le mosse
        if (this.numeroMosse == 9) {
            return true;
        }
        return false;
    }
    
    public boolean vittoria() {
    //EFFECTS:  restituisce true se il giocatore di turno ha vinto (tre dei suoi simboli in fila su riga, colonna o diagonale)
       if (this.tabellone[0][0] == this.tabellone[1][1] && this.tabellone[1][1] == this.tabellone[2][2]) {
        if (this.tabellone[0][0] == this.turno)
                        return true;
       }
        if (this.tabellone[0][2] == this.tabellone[2][2] && this.tabellone[2][2] == this.tabellone[2][0]) {
            if (this.tabellone[0][2] == this.turno)
                return true;
       }

       int i = 0;
       int j = 0;
                if (this.tabellone[i][j] == this.tabellone[i][j + 1] && this.tabellone[i][j] == this.tabellone[i][j + 2]) {
                    if (this.tabellone[i][j] == this.turno)
                        return true;
                }

                if (this.tabellone[j][i] == this.tabellone[j + 1][i] && this.tabellone[j][i] == this.tabellone[j + 2][i]) {
                     if (this.tabellone[j][i] == this.turno)
                        return true;
                }
            
       
       return false;
    }

    
    public static void main(String[] args) {
        Tris tris = new Tris();
        Scanner s = new Scanner(System.in);
        System.out.println("Mossa di " + tris.turno);
        System.out.println("Inserisci: x y");
        while (!tris.terminato()) {
            System.out.println("Mossa di " + tris.turno);
            System.out.println("Inserisci: x y");
            tris.mossa(s.nextInt(), s.nextInt());
            System.out.println(tris);
            if (tris.vittoria()) {
                System.out.println("Ha vinto" + tris.turno);
                System.exit(1);
            }
            if (tris.terminato()) {
                System.out.println("Partita terminata, nessuno ha vinto");
                System.exit(1);
            }
        }

        

    }

}

